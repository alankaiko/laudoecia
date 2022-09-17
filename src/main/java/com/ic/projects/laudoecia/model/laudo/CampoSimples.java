/*
 * CampoSimples.java
 *
 * Created on 07/05/2012, 16:53:45
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Campo cujo html eh calculado simplesmente por um valor constante concantenado
 * (na verdade substituido conforme posicao do identificador)
 * pelo valor do campo. Esse campo também aceita o cadastro de parametros,
 * conforme propriedade params.
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class CampoSimples extends CampoDoLaudo
{

    // <editor-fold defaultstate="collapsed" desc="Flags">

    /**
     * Flag utilizada como valorConstante para informar que esse campo
     * nao gera html
     */
    public static final String NAO_IMPRIMIVEL = "null";
    /**
     * Flag que representa o valor do campo, que sera substituido no valor
     * constante durante a geracao do html
     */
    public static final String identificador = "@valor@";

    // </editor-fold>

    /**
     * Mapa de campos cujos valores sao usados para a geracao do html.
     * O parametro booleano representa se o valor do campo eh obrigatorio
     * Se ele for obrigatorio, o html gerado sera null quando o valor do campo
     * for null
     * Os parametros sao substituidos conforme ordem de cadastramento, assim,
     * @C1@ sera substituido pelo valor do campo que foi cadastrado primeiro,
     * e assim sucessivamente
     */
    private Map<CampoDoLaudo, Boolean> params = new LinkedHashMap<>();
    /**
     * Mapa contendo valores que fogem às regras habituais de geracao do html
     * Se o valor do campo for uma chave desse mapa, sera impresso apenas o
     * valor correspondente a chave
     */
    private Map<String, String> excecoes = new HashMap<>();
    /**
     * Valor que determina a geracao do html, contendo o identificador e
     * parametros
     */
    private String valorConstante;

    public CampoSimples (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        if (NAO_IMPRIMIVEL.equalsIgnoreCase(valorConstante))
        {
            this.valorConstante = valorConstante;
            setTipoValidObrig(CampoDoLaudo.POR_VALOR);
        }
        else if (valorConstante == null || !valorConstante.contains(identificador))
        {
            throw new ErroNaCriacaoDoModelo("Valor constante inconsistente!");
        }
        else
        {
            this.valorConstante = valorConstante;
        }
    }

    public void adicionarExcecao (String valorEscolhido, String valorImpresso)
    {
        excecoes.put(valorEscolhido, valorImpresso);
    }

    public void removerExcecao (String valorEscolhido)
    {
        excecoes.remove(valorEscolhido);
    }

    public void cadastrarParametro (CampoDoLaudo campo)
    {
        cadastrarParametro(campo, true);
    }

    public void cadastrarParametro (CampoDoLaudo campo, boolean obrigatorio)
    {
        params.put(campo, obrigatorio);
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        return previewGerarHtmlImpl(getValor(), validar);
    }

    public String previewGerarHtmlImpl (String valor, boolean validar) throws ErrosDeValidacao
    {
        if (NAO_IMPRIMIVEL.equals(valorConstante) || valor == null)
        {
            return "";
        }
        if (excecoes.containsKey(valor))
        {
            return excecoes.get(valor);
        }
        else
        {
            String valorTratado = tratarValorParaImpressao(valor);
            String resposta = valorConstante.replaceAll(identificador, valorTratado);
            int contador = 0;
            for (Map.Entry<CampoDoLaudo, Boolean> entry : params.entrySet())
            {
                CampoDoLaudo campoDoLaudo = entry.getKey();
                Boolean obrigatorio = entry.getValue();
                String valorCampo = campoDoLaudo.getValor();
                if (valorCampo == null) { valorCampo = ""; }
                if (obrigatorio && valorCampo.isEmpty())
                {
                    return "";
                }
                else
                {
                    contador++;
                    resposta = resposta.replaceAll("@C" +
                           String.valueOf(contador), valorCampo);
                }
            }
            return resposta;
        }
    }

    String tratarValorParaImpressao (String valor) throws ErrosDeValidacao
    {
        return valor;
    }

}
