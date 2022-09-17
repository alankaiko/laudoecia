/*
 * STATUS_LAUDO.java
 *
 * Created on 23/04/2012, 08:14:51
 */
package com.ic.projects.laudoecia.model.enums;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum STATUS_LAUDO
{
    PENDENTE("pendente"),
    PRONTO("pronto");
    private final String status;

    private STATUS_LAUDO (String status)
    {
        this.status = status;
    }

    public String getAcao ()
    {
        return status;
    }

    @Override
    public String toString ()
    {
        return status;
    }

    /**
     * Método criado para gerar os combobox com uma opção adicional
     *
     * @param opcaoAdicional Ex: "TODAS"
     * @return array de string com opção adicional no indice 0
     */
    public static String[] getStatusComOpcaoAdicional (String opcaoAdicional)
    {
        String[] model = new String[values().length + 1];
        model[0] = opcaoAdicional;
        for (int i = 0; i < values().length; i++)
        {
            model[i + 1] = values()[i].toString();
        }
        return model;
    }

}
