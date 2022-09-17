/*
 * ErroDeConversao.java
 *
 * Created on 10/05/2012, 09:57:54
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;

/**
 * Erro lançado quando o valor que se tentou setar não pôde ser convertido 
 * no valor desejado.
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ErroDeConversao extends ErroAoSetarPropriedade
{

    public ErroDeConversao (CampoDoLaudo cdl, String message)
    {
        super(message, ErroAoSetarPropriedade.VALOR, cdl);
    }

}
