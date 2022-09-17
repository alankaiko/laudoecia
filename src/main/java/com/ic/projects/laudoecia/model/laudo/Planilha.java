/*
 * Planilha.java
 *
 * Created on 07/05/2012, 15:39:05
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroAoSetarPropriedade;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class Planilha extends Composite
{

    private final Laudo laudo;
    private final Map<Integer, CampoDoLaudo> mapaDeCampos = new HashMap<>();
    public static final int INDEX_PLANILHA = 10000;

    Planilha (Laudo laudo)
    {
        this.laudo = laudo;
    }

    public void totalmenteNormal () throws ErrosDeValidacao
    {
        ValidadorDoTN validador = new ValidadorDoTN();
        visitarProle(validador, this);
        if (validador.validacaoOk())
        {
            visitarProle(new CampoDoLaudoTreeWalker() {

            @Override
            public int visit (CampoDoLaudo cdl)
            {
                if (cdl instanceof Enumeracao)
                {
                    Enumeracao e = (Enumeracao) cdl;
                    if (e.possuiTextoNormal())
                    {
                        try
                        {
                            e.setValor(Enumeracao.TEXTO_NORMAL);
                        }
                        catch (ErrosDeValidacao ex)
                        {
                        }
                    }
                }
                return CampoDoLaudoTreeWalker.CONTINUAR;
            }
        }, this);
        }
        else
        {
            throw new ErroAoSetarPropriedade("O campo já foi preenchido!",
                    ErroAoSetarPropriedade.VALOR, validador.getCdl());
        }
    }

    public CampoDoLaudo getCampo (int index)
    {
        return mapaDeCampos.get(index);
    }

    void setMapa (Map<Integer, CampoDoLaudo> mapa)
    {
        this.mapaDeCampos.putAll(mapa);
    }

    public Map<Integer, CampoDoLaudo> getMapaDeCampos ()
    {
        return Collections.unmodifiableMap(mapaDeCampos);
    }

    Map<Integer, String> criarParamsLaudo ()
    {
        LeitorDeValoresDosCampos visitor = new LeitorDeValoresDosCampos();
        visitarProle(visitor, this);
        Map<Integer, String> resposta = new HashMap<>(visitor.getResposta());
        String valor = getValor();
        if (!(valor == null || valor.trim().isEmpty()))
        {
            resposta.put(INDEX_PLANILHA, valor);
        }
        return resposta;
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        StringBuilder html = new StringBuilder(16);
        String valor = getValor();
        if (valor == null)
        {
            List<CampoDoLaudo> topicos = getProle();
            int numTopicos = topicos.size();
            for (int i = 0; i < numTopicos; i++)
            {
                String htmlDoTopico = topicos.get(i).gerarHtml(validar);
                if (htmlDoTopico == null || htmlDoTopico.isEmpty())
                {
                }
                else
                {
                    if (!(htmlDoTopico.contains("<table") || htmlDoTopico.contains("<div")))
                    {
                        htmlDoTopico = "<div class=\"topico\">" + htmlDoTopico + "</div>";
                    }
                    // horible hack
                    else if (htmlDoTopico.contains("</div><table"))
                    {
                        htmlDoTopico = "<div class=\"topico\">" + htmlDoTopico + "</div>";
                    }
                    html.append(htmlDoTopico);
                }
            }
            return html.toString();
        }
        else
        {
            return valor;
        }
    }

    @Override
    public Laudo getLaudo ()
    {
        return laudo;
    }

    public String preview ()
    {
        try
        {
            return gerarHtmlImpl(false);
        }
        catch (ErrosDeValidacao ex)
        {
            return "";
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Private stuff">

    private class LeitorDeValoresDosCampos implements CampoDoLaudoTreeWalker
    {

        private Map<Integer, String> resposta = new HashMap<>();
        private int contador = 0;

        private Map<Integer, String> getResposta ()
        {
            return Collections.unmodifiableMap(resposta);
        }

        @Override
        public int visit (CampoDoLaudo cdl)
        {
            String valor = cdl.getValor();
            if (!(valor == null || valor.trim().isEmpty()) && cdl.isPersistivel())
            {
                resposta.put(contador, valor);
            }
            contador++;
            return CampoDoLaudoTreeWalker.CONTINUAR;
        }

    }

    private class ValidadorDoTN implements CampoDoLaudoTreeWalker
    {

        private CampoDoLaudo cdl;

        @Override
        public int visit (CampoDoLaudo cdl)
        {
            if (cdl instanceof Enumeracao)
            {
                Enumeracao e = (Enumeracao) cdl;
                String valor = e.getValor();
                if (e.possuiTextoNormal() && !(valor == null || valor.isEmpty()))
                {
                    this.cdl = cdl;
                    return CampoDoLaudoTreeWalker.PARAR;
                }
            }
            return CampoDoLaudoTreeWalker.CONTINUAR;
        }

        private boolean validacaoOk ()
        {
            return cdl == null;
        }

        private CampoDoLaudo getCdl ()
        {
            return cdl;
        }

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Deprecated">

//    so unfortunate i didn't get to use this code...

//    public CampoDoLaudo getCampo (int index)
//    {
//        IndexVisitor visitor = new IndexVisitor(index);
//        visitarProle(visitor, this);
//        return visitor.getResposta();
//    }

//    private class IndexVisitor implements CampoDoLaudoVisitor
//    {
//
//        private int contador = 0;
//        private int index;
//        private CampoDoLaudo resposta;
//
//        private IndexVisitor (int index)
//        {
//            this.index = index;
//        }
//
//        private CampoDoLaudo getResposta ()
//        {
//            return resposta;
//        }
//
//        @Override
//        public int visit (CampoDoLaudo cdl)
//        {
//            if (index == contador)
//            {
//                resposta = cdl;
//                return CampoDoLaudoVisitor.PARAR;
//            }
//            contador++;
//            return CampoDoLaudoVisitor.CONTINUAR;
//        }
//    }

    // </editor-fold>

    public static boolean comparar (Planilha p1, Planilha p2)
    {
        if (p1 == null)
        {
            return p2 == null;
        }
        else if (p2 == null)
        {
            return false;
        }
        else
        {
            Laudo l1 = p1.getLaudo();
            Laudo l2 = p2.getLaudo();
            if (l1 == null)
            {
                return p2.getLaudo() == null;
            }
            else if (l2 == null)
            {
                return false;
            }
            else if (!Objects.equals(l1.getModeloDeLaudo(), l2.getModeloDeLaudo()))
            {
                return false;
            }
            else
            {
                for (Map.Entry<Integer, CampoDoLaudo> entry : p1.getMapaDeCampos().entrySet())
                {
                    Integer index = entry.getKey();
                    CampoDoLaudo cdl = entry.getValue();
                    if (Objects.equals(cdl.getValor(), p2.getCampo(index).getValor()))
                    {
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean comparar (Map<Integer, String> valoresOriginais)
    {
        if (!Objects.equals(getValor(), valoresOriginais.get(INDEX_PLANILHA)))
        {
            return false;
        }
        for (Map.Entry<Integer, CampoDoLaudo> entry : mapaDeCampos.entrySet())
        {
            Integer index = entry.getKey();
            CampoDoLaudo cdl = entry.getValue();
            if (valorMudou(cdl.getValor(), valoresOriginais.get(index)))
            {
                return false;
            }
        }
        return true;
    }

}
