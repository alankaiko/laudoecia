/*
 * DesabilitadorPorValor.java
 *
 * Created on 16/05/2012, 16:51:47
 */

package com.ic.projects.laudoecia.model.laudo;

import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DesabilitadorPorValor extends DesabilitadorDeCampo
{
    
    private boolean desabilitarCampo;
    private String[] valoresAhComparar;
    private boolean desQuandoForIgual;
    
    /**
     * 
     * @param valoresAhComparar
     * @param valorAtual
     * @param desQuandoForIgual valor a ser setado quando o valor atual for igual
     *                      a algum dos valores que alteram a habilitacao
     */
    DesabilitadorPorValor (String[] valoresAhComparar, String valorAtual, boolean desQuandoForIgual)
    {
        this.valoresAhComparar = valoresAhComparar;
        this.desQuandoForIgual = desQuandoForIgual;
        setDesabilitarCampo(valorAtual);
    }

    private void setDesabilitarCampo (String valorAtual)
    {
        desabilitarCampo = false;
        boolean foiIgualUmaVez = false;
        for (int i = 0; i < valoresAhComparar.length; i++)
        {
            if (Objects.equals(valoresAhComparar[i], valorAtual))
            {
                foiIgualUmaVez = true;
                break;
            }
        }
        if (desQuandoForIgual && foiIgualUmaVez)
        {
            desabilitarCampo = true;
        }
        boolean desQuandoForDiferente = !desQuandoForIgual;
        boolean valorAtualEhDiferenteDosValoresAhComparar = !foiIgualUmaVez;
        if (desQuandoForDiferente && valorAtualEhDiferenteDosValoresAhComparar)
        {
            desabilitarCampo = true;
        }
    }

    @Override
    boolean desabilitarCampo ()
    {
        return desabilitarCampo;
    }

    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
        switch (evento.getTipo())
        {
            case EventoDoCampoDoLaudo.VALOR_MUDOU:
                Object valorAtual = evento.getValorAtual();
                if (valorAtual == null)
                {
                    setDesabilitarCampo("");
                }
                else
                {
                    setDesabilitarCampo((String)valorAtual);
                }
                break;
            default:
        }
    }
    
}
