/*
 * TIPO_PAPEL.java
 *
 * Created on 28/06/2012, 08:20:51
 */
package com.ic.projects.laudoecia.model.enums;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public enum TIPO_PAPEL
{
    A4("A4", 21.0, 29.7),
    OFICIO("Ofício", 21.6, 35.6),
    CARTA("Carta", 21.6, 27.9),
    CUSTOM("Personalizado", 0, 0);
    
    private final String descricao;
    private final double width;
    private final double height;

    private TIPO_PAPEL (String descricao, double width, double height)
    {
        this.descricao = descricao;
        this.width = width;
        this.height = height;
    }

    public String getDescricao ()
    {
        return descricao;
    }

    public double getHeight ()
    {
        return height;
    }

    public double getWidth ()
    {
        return width;
    }

    @Override
    public String toString ()
    {
        return descricao;
    }

}
