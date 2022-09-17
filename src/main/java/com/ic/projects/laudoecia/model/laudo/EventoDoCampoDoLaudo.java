/*
 * EventoDoCampoDoLaudo.java
 *
 * Created on 07/05/2012, 09:23:31
 */

package com.ic.projects.laudoecia.model.laudo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class EventoDoCampoDoLaudo
{

    public static final int HABILITADO_MUDOU = 0;
    public static final int VALOR_MUDOU = 1;
    public static final int OBRIGATORIO_MUDOU = 2;
    
    private int tipo;
    private CampoDoLaudo origem;
    private Object valorAnterior;
    private Object valorAtual;

    public EventoDoCampoDoLaudo (int tipo, CampoDoLaudo origem, Object valorAnterior, Object valorAtual)
    {
        this.tipo = tipo;
        this.origem = origem;
        this.valorAnterior = valorAnterior;
        this.valorAtual = valorAtual;
    }

    public CampoDoLaudo getOrigem ()
    {
        return origem;
    }

    public int getTipo ()
    {
        return tipo;
    }

    public Object getValorAnterior ()
    {
        return valorAnterior;
    }

    public Object getValorAtual ()
    {
        return valorAtual;
    }

}
