/*
 * CampoNumero.java
 *
 * Created on 09/05/2012, 14:08:08
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class CampoNumero extends CampoSimples
{

    private boolean tratarValorVazioComoZero = true;

    public CampoNumero (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        setMsgErroValidCampoObrig("Campo obrigatório!\nDigite 0 para não imprimir.");
    }

    public void setTratarValorVazioComoZero (boolean tratarValorVazioComoZero)
    {
        this.tratarValorVazioComoZero = tratarValorVazioComoZero;
    }

    public void adicionarExcecao (String valorImpresso)
    {
        adicionarExcecao(zero(), valorImpresso);
    }

    public void adicionarExcecao ()
    {
        adicionarExcecao("");
    }

    public void setZeroDeveSerImpresso (boolean zeroDeveSerImpresso)
    {
        if (zeroDeveSerImpresso)
        {
            removerExcecao(zero());
        }
        else
        {
            adicionarExcecao(zero(), "");
        }
    }

    public void adicionarExcecao (double valorEscolhido, String valorImpresso)
    {
        if (valorEscolhido == 0.0d)
        {
            adicionarExcecao(zero(), valorImpresso);
        }
    }

    double getDouble ()
    {
        String valor = getValor();
        if (valor == null || valor.isEmpty())
        {
            return 0;
        }
        else
        {
            return Double.valueOf(valor.replaceAll(",", "."));
        }
    }

    int getInt ()
    {
        String valor = getValor();
        if (valor == null || valor.isEmpty())
        {
            return 0;
        }
        return (int) getDouble();
    }

    @Override
    String tratarValorQueSeraSetado (String valor)
    {
        if (valor == null)
        {
            return null;
        }
        else if (valor.replaceAll("[,\\.]", "").matches("0+"))
        {
            return zero();
        }
        else
        {
            return valor;
        }
    }

    @Override
    String tratarValorParaImpressao (String valor)
    {
        if (valor == null || valor.isEmpty())
        {
            return tratarValorVazioComoZero ? zero() : "";
        }
        else
        {
            return tratarValorNaoVazioParaImpressao(valor);
        }
    }

    abstract String tratarValorNaoVazioParaImpressao (String valor);
    abstract String zero();

}
