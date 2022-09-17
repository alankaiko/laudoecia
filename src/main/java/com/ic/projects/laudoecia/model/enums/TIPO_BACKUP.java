/*
 * TIPO_BACKUP.java
 *
 * Created on 11/04/2012, 09:10:34
 */

package com.ic.projects.laudoecia.model.enums;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum TIPO_BACKUP
{

    DADOS("Apenas dados"),
    DADOS_E_IMAGENS("Dados e imagens");

    private final String tipo;

    private TIPO_BACKUP (String tipo)
    {
        this.tipo = tipo;
    }

    public String getTipo ()
    {
        return tipo;
    }

    @Override
    public String toString ()
    {
        return tipo;
    }

}
