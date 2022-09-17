/*
 * Enumeracao.java
 *
 * Created on 07/05/2012, 09:09:07
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeConversao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class Enumeracao extends CampoSimples
{

    // <editor-fold defaultstate="collapsed" desc="Teste">

    public static final int COMECAR_DO_ZERO_SE_POSSUI_NAO_IMPRIMIR = 0;
    public static final int COMECAR_DO_ZERO_SIM = 1;
    public static final int COMECAR_DO_ZERO_NAO = 2;

    // </editor-fold>

    private Map<String, String> opcoes = new LinkedHashMap<>();
    public static final String NAO_IMPRIMIR = "Não imprimir";
    public static final String TEXTO_NORMAL = "Texto normal sugestivo";
    private int comecarDoZero = COMECAR_DO_ZERO_SE_POSSUI_NAO_IMPRIMIR;
    private CampoTexto campoTextoNormal;

    public Enumeracao (CampoTexto campoTextoNormal) throws ErroNaCriacaoDoModelo
    {
        this(identificador, true);
        this.campoTextoNormal = campoTextoNormal;
        if (campoTextoNormal == null)
        {
            throw new IllegalArgumentException("Campo texto null!");
        }
        if (campoTextoNormal.possuiTextoPadrao())
        {
            opcoes.put(TEXTO_NORMAL, "");
        }
        opcoes.put(DIGITAR, "");
        campoTextoNormal.vincularHabAoValorDoCampo(this, false, DIGITAR);
    }

    public Enumeracao () throws ErroNaCriacaoDoModelo
    {
        this(identificador);
    }

    public Enumeracao (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        this(valorConstante, false);
    }

    public Enumeracao (String valorConstante, boolean opcaoNaoImprimir) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        if (opcaoNaoImprimir)
        {
            adicionarOpcao(NAO_IMPRIMIR);
            adicionarExcecao(NAO_IMPRIMIR, "");
        }
    }

    public void adicionarOpcao (String descricao)
    {
        adicionarOpcao(descricao, descricao);
    }

    public void adicionarOpcao (String descricao, String impressao)
    {
        opcoes.put(descricao == null ? "" : descricao,
                   impressao == null ? "" : impressao);
    }

    public boolean possuiTextoNormal ()
    {
        for (String opcao : opcoes.keySet())
        {
            if (TEXTO_NORMAL.equals(opcao))
            {
                return true;
            }
        }
        return false;
    }

    public String getTextoNormal () throws ErrosDeValidacao
    {
        if (possuiTextoNormal())
        {
            return campoTextoNormal.getTextoPadrao();
        }
        else
        {
            return null;
        }
    }

    public String[] getOpcoes ()
    {
        String[] resposta = new String[opcoes.size()];
        Set<String> keys = opcoes.keySet();
        int contador = 0;
        for (Iterator<String> it = keys.iterator(); it.hasNext();)
        {
            resposta[contador] = it.next();
            contador++;
        }
        return resposta;
    }

    public void setComecarDoZero (int comecarDoZero) throws ErroNaCriacaoDoModelo
    {
        switch (comecarDoZero)
        {
            case COMECAR_DO_ZERO_SE_POSSUI_NAO_IMPRIMIR:
            case COMECAR_DO_ZERO_NAO:
            case COMECAR_DO_ZERO_SIM:
                this.comecarDoZero = comecarDoZero;
                break;
            default:
                throw new ErroNaCriacaoDoModelo("Opção inválida!");
        }
    }

    public boolean comecarDoZero ()
    {
        switch (comecarDoZero)
        {
            case COMECAR_DO_ZERO_SIM:
                return true;
            case COMECAR_DO_ZERO_NAO:
                return false;
            case COMECAR_DO_ZERO_SE_POSSUI_NAO_IMPRIMIR:
                String[] itensDaLista = getOpcoes();
                for (int i = 0; i < itensDaLista.length; i++)
                {
                    String opcao = itensDaLista[i];
                    if (Enumeracao.NAO_IMPRIMIR.equalsIgnoreCase(opcao))
                    {
                        return true;
                    }
                }
                return false;
            default:
                throw new AssertionError();
        }
    }

    String valorDaChaveSelecionada ()
    {
        String valor = getValor();
        if (valor == null)
        {
            return "";
        }
        else
        {
            return opcoes.get(valor);
        }
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
        if (opcoes.containsKey(valor))
        {
        }
        else
        {
            throw new ErroDeConversao(this, "Opção inválida");
        }
    }

    @Override
    public String tratarValorParaImpressao (String valor) throws ErrosDeValidacao
    {
        String valorTratado = tratarValorParaBuscaNoMapa(valor);
        if (opcoes.containsKey(valorTratado))
        {
            if (TEXTO_NORMAL.equals(valor) && possuiTextoNormal())
            {
                return campoTextoNormal.getTextoPadrao();
            }
            return opcoes.get(valorTratado);
        }
        return valor;
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

    private String tratarValorParaBuscaNoMapa (String valor)
    {
        if (valor == null || TEXTO_NORMAL.equals(valor))
        {
            return valor;
        }
        for (String opcao : opcoes.keySet())
        {
            if (valor.equalsIgnoreCase(opcao))
            {
                return opcao;
            }
        }
        return valor;
    }

}
