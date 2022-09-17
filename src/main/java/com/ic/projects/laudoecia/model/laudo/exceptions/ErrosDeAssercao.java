/*
 * ErrosDeAssercao.java
 *
 * Created on 10/05/2012, 16:12:17
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

/**
 * Representa uma classe de erros que só acontecem por falhas na lógica 
 * de programação do sistema.
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class ErrosDeAssercao extends ErrosDoCampoDoLaudo
{

    public ErrosDeAssercao (String message)
    {
        super(message);
    }

}
