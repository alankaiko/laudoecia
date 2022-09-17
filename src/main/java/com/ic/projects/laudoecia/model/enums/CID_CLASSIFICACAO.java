/*
 * CID_CLASSIFICACAO.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.enums;

/**
 * Enumeração das classificações de uma doença
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum CID_CLASSIFICACAO
{
    EM_BRANCO(""), // pode ser utilizado em qualquer situação
    POSITIVO("+"), // classificação por etiologia
    ASTERISCO("*"); // classificação por manifestação

    private final String classificacao;

    private CID_CLASSIFICACAO (String classificação)
    {
        this.classificacao = classificação;
    }

    public String getClassificação ()
    {
        return classificacao;
    }

}
