/*
 * TIPO_ACAO_DO_USUARIO.java
 *
 * Created on 01/03/2012, 10:03:15
 */

package com.ic.projects.laudoecia.model.enums;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum TIPO_ACAO_DO_USUARIO
{

    ADICIONAR("ADICIONAR"),
    ALTERAR("ALTERAR"),
    APAGAR("APAGAR");

    private final String acao;

    private TIPO_ACAO_DO_USUARIO (String acao)
    {
        this.acao = acao;
    }

    public String getAcao ()
    {
        return acao;
    }

    @Override
    public String toString ()
    {
        return acao;
    }

    /**
     * Método criado para gerar os combobox com uma opção adicional
     * @param opcaoAdicional Ex: "TODAS"
     * @return array de string com opção adicional no indice 0
     */
    public static String[] getAcoesComOpcaoAdicional(String opcaoAdicional)
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
