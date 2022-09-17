/*
 * CampoInteiro.java
 *
 * Created on 07/05/2012, 09:08:06
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeConversao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoInteiro extends CampoNumero
{

    private int numeroMaxDeDigitos;

    public CampoInteiro (String valorConstante, int numeroMaxDeDigitos) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        setZeroDeveSerImpresso(false);
        this.numeroMaxDeDigitos = numeroMaxDeDigitos;
        if (numeroMaxDeDigitos < 1 || numeroMaxDeDigitos > 9)
        {
            throw new ErroNaCriacaoDoModelo("Numero maximo de digitos inconsistente!");
        }
    }

    public int getNumeroMaxDeDigitos ()
    {
        return numeroMaxDeDigitos;
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
        if (valor.matches("[\\Q-+\\E]?[0-9]{0," + String.valueOf(numeroMaxDeDigitos) + "}"))
        {
        }
        else if (valor.matches("[\\Q-+\\E]?[0-9]+"))
        {
            throw new ErroDeConversao(this, "O valor é maior do que o permitido!");
        }
        else
        {
            throw new ErroDeConversao(this, "O valor não pôde ser convertido em inteiro!");
        }
    }

    @Override
    String zero ()
    {
        return "0";
    }

    @Override
    String tratarValorNaoVazioParaImpressao (String valor)
    {
        return valor;
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

}
