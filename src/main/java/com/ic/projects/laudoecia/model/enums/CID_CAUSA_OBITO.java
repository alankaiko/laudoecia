/*
 * CID_CAUSA_OBITO.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.enums;

/**
 * Enumeração do campo causa óbito de um registro do CID
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum CID_CAUSA_OBITO
{
    EM_BRANCO("NÃO HÁ RESTRIÇÃO"), // Não há restrição
    N("POUCA PROBABILIDADE");      // Pouca probabilidade de causar óbito

    private final String causaObito;

    private CID_CAUSA_OBITO (String causaObito)
    {
        this.causaObito = causaObito;
    }

    public String getCausaObito ()
    {
        return causaObito;
    }

    @Override
    public String toString ()
    {
        return causaObito;
    }
    
}
