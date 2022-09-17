/*
 * ErroAoGerarHtml.java
 *
 * Created on 02/10/2012, 08:22:01
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class ErroAoGerarHtml extends ErrosDeValidacao
{

    public ErroAoGerarHtml (CampoDoLaudo source, String message)
    {
        super(source, message);
    }

}
