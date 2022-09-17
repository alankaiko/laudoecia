/*
 * LinhaDaTbl.java
 *
 * Created on 04/06/2012, 10:22:47
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class LinhaDaTbl extends LinhaAbstrata
{

    /**
     * mapa informando o que deve ser impresso quando o campo estiver desabilitado
     */
    private Map<CampoDoLaudo, String> htmlCamposDesabilitados = new HashMap<>();

    private Map<String, String> mapaDescrPrimParag = new HashMap<>();

    private String textoDaLinha;
    private boolean naoImprimirTdVazio;

    private boolean naoImprimirSeAlgumCampoEstaVazio = false;

    public static final String HTML_FILHO_1 = "@html do campo filho 1@";
    public static final String HTML_FILHO_2 = "@html do campo filho 2@";
    public static final String HTML_FILHO_3 = "@html do campo filho 3@";
    public static final String HTML_FILHO_4 = "@html do campo filho 4@";

    public LinhaDaTbl (boolean b, String textoDaLinha) throws ErroNaCriacaoDoModelo
    {
        this(textoDaLinha, true);
        naoImprimirSeAlgumCampoEstaVazio = b;
    }

    public LinhaDaTbl (String textoDaLinha) throws ErroNaCriacaoDoModelo
    {
        this(textoDaLinha, true);
    }

    public LinhaDaTbl (String textoDaLinha, boolean naoImprimirTdVazio) throws ErroNaCriacaoDoModelo
    {
        if (textoDaLinha == null)
        {
            throw new ErroNaCriacaoDoModelo("Texto da linha da tabela nao deve ser null!");
        }
        this.textoDaLinha = textoDaLinha;
        this.naoImprimirTdVazio = naoImprimirTdVazio;
    }

    @Override
    void adicionarCampoFilho (CampoDoLaudo campo)
    {
        super.adicionarCampoFilho(campo);
        htmlCamposDesabilitados.put(campo, "-");
    }

    public void setarHtmlCampoDes (CampoDoLaudo campo, String valor)
    {
        if (htmlCamposDesabilitados.containsKey(campo))
        {
            htmlCamposDesabilitados.put(campo, valor);
        }
    }

    public void setDescrPrimParag (String campoFilho, String descrPrimParag)
    {
        mapaDescrPrimParag.put(campoFilho, descrPrimParag);
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        String valor = getValor();
        if (!(valor == null || valor.isEmpty()))
        {
            return valor;
        }
        String resposta = textoDaLinha;
        List<CampoDoLaudo> campos = getProle();
        boolean peloMenos1CampoFilhoTemHtml = false;
        for (int i = 0; i < campos.size(); i++)
        {
            CampoDoLaudo campo = campos.get(i);
            String htmlDoCampo = campo.gerarHtml(validar);
            if (naoImprimirSeAlgumCampoEstaVazio && htmlDoCampo.isEmpty())
            {
                return "";
            }
            if (campo.isHabilitado())
            {
                if (htmlDoCampo == null)
                {
                    htmlDoCampo = "";
                }
                if (!htmlDoCampo.isEmpty())
                {
                    peloMenos1CampoFilhoTemHtml = true;
                }
            }
            else
            {
                htmlDoCampo = htmlCamposDesabilitados.get(campo);
            }
            resposta = resposta.replaceAll(getIdentificador(i + 1),
                                    tratarHtmlCampoFilho(i + 1, htmlDoCampo));
        }
        if (naoImprimirTdVazio && !peloMenos1CampoFilhoTemHtml)
        {
            return "";
        }
        else
        {
            return resposta;
        }
    }

    private String getIdentificador (int index)
    {
        return "@html do campo filho " + String.valueOf(index) + "@";
    }

    private String tratarHtmlCampoFilho (int index, String htmlCampo)
    {
        String htmlCampoTrim = htmlCampo.trim();
        if (htmlCampoTrim.isEmpty())
        {
            return "";
        }
        else if (htmlCampoTrim.startsWith("<p s") && htmlCampoTrim.endsWith("</p>"))
        {
        }
        else if (htmlCampoTrim.endsWith("</p>"))
        {
            htmlCampoTrim = "<p style=\"margin-top: 0\">" + htmlCampoTrim;
        }
        else if (htmlCampoTrim.startsWith("<p s"))
        {
            htmlCampoTrim += "</p>";
        }
        else
        {
            htmlCampoTrim = "<p style=\"margin-top: 0\">" + htmlCampoTrim + "</p>";
        }
        if (mapaDescrPrimParag.containsKey(getIdentificador(index)))
        {
            return htmlCampoTrim.replaceFirst(">", ">" +
                            mapaDescrPrimParag.get(getIdentificador(index)));
        }
        else
        {
            return htmlCampoTrim;
        }
    }

}
