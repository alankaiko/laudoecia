/*
 * CriadorDePlanilha.java
 *
 * Created on 18/05/2012, 11:00:38
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeContexto;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.java.utils.StringUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CriadorDePlanilha
{

    private final Laudo laudo;
    private final Map<Integer, CampoDoLaudo> mapa = new HashMap<>();
    private Planilha planilha;

    private String ultimaLinhaDeMetodoLida;

    public CriadorDePlanilha (Laudo laudo) throws ErroNaCriacaoDoModelo
    {
        this.laudo = laudo;
        if (laudo == null)
        {
            throw new ErroNaCriacaoDoModelo("Laudo do criador de planilha null!");
        }
        if (laudo.getModeloDeLaudo() == null)
        {
            throw new ErroNaCriacaoDoModelo("Modelo de laudo do laudo do "
                    + "criador de planilha null!");
        }
        if (laudo.getModeloDeLaudo().getModeloDeLaudo() == null)
        {
            throw new ErroNaCriacaoDoModelo("Modelo de laudo do laudo do "
                    + "criador de planilha null!");
        }
    }

    public Planilha criarPlanilha () throws Exception
    {
        if (planilha == null)
        {
            criarPlanilhaDoLaudo();
            setarValoresNaPlanilha();
        }
        return planilha;
    }

    private Planilha criarPlanilhaDoLaudo () throws Exception
    {
        planilha = new Planilha(laudo);
        try
        {
            adicionarCamposNaPlanilha();
        }
        catch (Exception e)
        {
            throw new Exception("Erro na criação dos campos da planilha."
                                + " Campo onde houve erro: " + mapa.size(), e);
        }
        try
        {
            invocarMetodosDeConfiguracao();
        }
        catch (Exception e)
        {
            throw new Exception("Erro ao configurar os campos dos laudos."
                                + " Método onde houve erro: " +
                                String.valueOf(ultimaLinhaDeMetodoLida), e);
        }
        planilha.setMapa(mapa);
        return planilha;
    }

    private void adicionarCamposNaPlanilha () throws Exception
    {
        String campos[] = camposPeloContexto();
        Topico topicoAtual = null;
        Grupo grupoAtual = null;
        LinhaAbstrata linhaAtual = null;
        ImpressaoDiagnostica impDiag = null;
        for (int i = 0; i < campos.length; i++)
        {
            String[] paramsCriacao = campos[i].split(";;", -1);
            if (!Integer.valueOf(paramsCriacao[0]).equals(i))
            {
                throw new ErroNaCriacaoDoModelo("Index do campo do laudo inesperado.");
            }
            CampoDoLaudo cdl = criarCampoDoLaudo(paramsCriacao);
            mapa.put(i, cdl);
            if (topicoAtual == null && !(cdl instanceof Topico))
            {
                throw new ErroDeContexto("O primeiro campo deve ser um topico!");
            }
            else if (cdl instanceof Topico)
            {
                topicoAtual = (Topico) cdl;
                grupoAtual = null;
                linhaAtual = null;
                planilha.adicionarCampoFilho(topicoAtual);
            }
            else if (cdl instanceof Grupo)
            {
                grupoAtual = (Grupo) cdl;
                linhaAtual = null;
                topicoAtual.adicionarCampoFilho(grupoAtual);
            }
            // a partir daqui nem ultimo composite eh null, nem cdl eh topico
            else if (linhaAtual == null && !(cdl instanceof LinhaAbstrata))
            {
                throw new ErroDeContexto("Campo inesperado! Esperava uma linha.");
            }
            else if (cdl instanceof LinhaAbstrata)
            {
                linhaAtual = (LinhaAbstrata) cdl;
                if (grupoAtual == null)
                {
                    topicoAtual.adicionarCampoFilho(linhaAtual);
                }
                else
                {
                    grupoAtual.adicionarCampoFilho(linhaAtual);
                }
            }
            // a partir daqui nem ultima linha eh null, nem cdl eh linha
            else
            {
                linhaAtual.adicionarCampoFilho(cdl);
                if (cdl instanceof ImpressaoDiagnostica)
                {
                    if (impDiag == null)
                    {
                        impDiag = (ImpressaoDiagnostica) cdl;
                    }
                    else
                    {
                        throw new ErroNaCriacaoDoModelo("O laudo possui mais "
                                + "de uma impressão diagnóstica!!");
                    }
                }
            }
        }
        if (impDiag == null)
        {
            throw new ErroNaCriacaoDoModelo("O laudo deve possuir "
                                + "um campo do tipo impressão diagnóstica!!");
        }
    }

    private void invocarMetodosDeConfiguracao () throws Exception
    {
        String linhasDeMetodos[] = metodosPeloContexto();
        for (int i = 0; i < linhasDeMetodos.length; i++)
        {
            ultimaLinhaDeMetodoLida = linhasDeMetodos[i];
            String[] paramsDaLinha = ultimaLinhaDeMetodoLida.split(";;", -1);
            ParametrosDeMetodo pdm = new ParametrosDeMetodo(paramsDaLinha);

            CampoDoLaudo cdl = mapa.get(Integer.valueOf(paramsDaLinha[0]));
            Class<? extends CampoDoLaudo> classe = cdl.getClass();
            Method metodo = classe.getMethod(paramsDaLinha[1], pdm.getTipoParams());
            metodo.invoke(cdl, pdm.getParams());
        }
    }

    private void setarValoresNaPlanilha () throws ErrosDeValidacao
    {
        for (ParametroDoLaudo pdl : laudo.getParamsLaudo())
        {
            int index = pdl.getIndex();
            CampoDoLaudo campo;
            if (index == Planilha.INDEX_PLANILHA)
            {
                campo = planilha;
            }
            else
            {
                campo = planilha.getCampo(pdl.getIndex());
            }
            campo.setValor(pdl.getValor());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Utils">

    private String[] camposPeloContexto ()
    {
        return linhasPeloContexto(0, laudo.getModeloDeLaudo().getModeloDeLaudo().getContexto());
    }

    private String[] metodosPeloContexto ()
    {
        return linhasPeloContexto(1, laudo.getModeloDeLaudo()
                .getModeloDeLaudo().getContexto() + laudo.getModeloDeLaudo().getCustomString());
    }

    private String[] linhasPeloContexto (int index, String contexto)
    {
        String contextoSemEnterOuTab = contexto.replaceAll("[\n\t]", "");
        String[] split1 = contextoSemEnterOuTab.split("##");
        if (index >= split1.length)
        {
            return new String[0];
        }
        else
        {
            return split1[index].split("\\Q$$\\E");
        }
    }

    private CampoDoLaudo criarCampoDoLaudo (String... parametros) throws Exception
    {
        ParametrosDeMetodo paramsConst = new ParametrosDeMetodo(parametros);
        Class<? extends CampoDoLaudo> tipo = tipoPeloNome(parametros[1]);
        Constructor<? extends CampoDoLaudo> constr = tipo.
                getConstructor(paramsConst.getTipoParams());
        return constr.newInstance(paramsConst.getParams());
    }

    @SuppressWarnings("unchecked")
    public static Class<? extends CampoDoLaudo> tipoPeloNome (String nome) throws ClassNotFoundException
    {
        final String pacote = "com.ic.projects.laudoecia.model.laudo.";
        return (Class<? extends CampoDoLaudo>) Class.forName(pacote + nome);
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    private class ParametrosDeMetodo
    {

        private Class<?>[] tipoParams;
        private Object[] params;

        private ParametrosDeMetodo (String[] parametrosComoString) throws Exception
        {
            int numParams = parametrosComoString.length - 2;
            tipoParams = new Class<?> [numParams];
            params = new Object[numParams];
            for (int i = 0; i < numParams; i++)
            {
                configurarParams(i, parametrosComoString[i + 2]);
            }
        }

        private Object[] getParams ()
        {
            return params;
        }

        private Class<?>[] getTipoParams ()
        {
            return tipoParams;
        }

        private void configurarParams (int index, String param) throws Exception
        {
            if (param.matches("\\{[^\\}]+\\}"))
            {
                String[] paramsAr = param.replaceAll("[\\{\\}]", "").split("\\|", -1);
                Object objects = null;
                for (int i = 0; i < paramsAr.length; i++)
                {
                    String string = paramsAr[i];
                    Object[] classeEObjeto = getClassAndParamFromStr(string);
                    if (i == 0)
                    {
                        objects = Array.newInstance(
                                    (Class<?>) classeEObjeto[0], paramsAr.length);
                        tipoParams[index] = objects.getClass();
                    }
                    Array.set(objects, i, classeEObjeto[1]);
                }
                params[index] = objects;
            }
            else
            {
                Object[] classeEObjeto = getClassAndParamFromStr(param);
                tipoParams[index] = (Class<?>) classeEObjeto[0];
                params[index] = classeEObjeto[1];
            }
        }

        private Object[] getClassAndParamFromStr (String string) throws ClassNotFoundException
        {
            Object[] resposta = new Object[2];
            if (string.startsWith("(/s)"))
            {
                resposta[0] = String.class;
                resposta[1] = string.replace("(/s)", "");
            }
            else if (StringUtils.parseableToInt(string))
            {
                resposta[0] = int.class;
                resposta[1] = Integer.valueOf(string).intValue();
            }
            else if (StringUtils.parseableToDouble(string, false))
            {
                resposta[0] = double.class;
                resposta[1] = Double.valueOf(string).doubleValue();
            }
            else if (string.matches("\\$[0-9]+"))
            {
                int indexDoCampo = Integer.valueOf(string.replaceAll("\\$", ""));
                CampoDoLaudo cdl = mapa.get(indexDoCampo);
                resposta[0] = cdl.getClass();
                resposta[1] = cdl;
            }
            else if (string.matches("\\$[0-9]+[aA-zZ]+"))
            {
                int indexDoCampo = Integer.valueOf(string.replaceAll("[^(0-9)]", ""));
                CampoDoLaudo cdl = mapa.get(indexDoCampo);
                resposta[0] = tipoPeloNome(string.replaceAll("[$0-9]", ""));
                resposta[1] = cdl;
            }
            else if ("true".equalsIgnoreCase(string) || "false".equalsIgnoreCase(string))
            {
                resposta[0] = boolean.class;
                resposta[1] = Boolean.valueOf(string).booleanValue();
            }
            else
            {
                resposta[0] = String.class;
                resposta[1] = string;
            }
            return resposta;
        }

    }

    // </editor-fold>

}
