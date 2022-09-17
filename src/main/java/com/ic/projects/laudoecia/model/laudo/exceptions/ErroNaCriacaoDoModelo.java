/*
 * ErroNaCriacaoDoModelo.java
 *
 * Created on 10/05/2012, 10:10:31
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

/**
 * Erro inesperado que acontece quando um modelo de laudo está sendo criado
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ErroNaCriacaoDoModelo extends ErrosDeAssercao
{

    public ErroNaCriacaoDoModelo (String message)
    {
        super(message);
    }

}
