/*
 * ErroDeCampoObrigatorio.java
 *
 * Created on 16/05/2012, 14:50:00
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;

/**
 * Erro lancado quando um campo obrigatório é solicitado a gerar seu html.
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ErroDeCampoObrigatorio extends ErrosDeValidacao
{

    public ErroDeCampoObrigatorio (CampoDoLaudo source, String message)
    {
        super(source, message);
    }

}
