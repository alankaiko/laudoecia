/*
 * ErrosDoCampoDoLaudo.java
 *
 * Created on 10/05/2012, 10:29:19
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

/**
 * Representa um erro que aconteceu em um modelo de laudo, que pode ser 
 * lançado por qualquer classe que seja uma especialização de CampoDoLaudo
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ErrosDoCampoDoLaudo extends Exception
{

    public ErrosDoCampoDoLaudo (String message)
    {
        super(message);
    }

}
