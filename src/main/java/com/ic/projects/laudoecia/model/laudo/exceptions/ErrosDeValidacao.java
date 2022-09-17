/*
 * ErrosDeValidacao.java
 *
 * Created on 10/05/2012, 11:14:03
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;

/**
 * Representa um erro de validação quando um campo do laudo é solicitado 
 * a gerar seu html, ou quando tenta-se setar o seu valor. Representa um erro
 * de validação das regras de negócio existentes no modelo do laudo.
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class ErrosDeValidacao extends ErrosDoCampoDoLaudo
{
    
    private CampoDoLaudo source;

    public ErrosDeValidacao (CampoDoLaudo source, String message)
    {
        super(message);
        this.source = source;
    }

    public CampoDoLaudo getSource ()
    {
        return source;
    }

}
