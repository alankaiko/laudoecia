/*
 * ErroAoSetarPropriedade.java
 *
 * Created on 10/05/2012, 16:13:22
 */

package com.ic.projects.laudoecia.model.laudo.exceptions;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ErroAoSetarPropriedade extends ErrosDeValidacao
{
    
    public static final String VALOR = "valor";
    public static final String HABILITADO = "habilitado";
    public static final String OBRIGATORIO = "obrigatorio";

    public ErroAoSetarPropriedade (String message, String tipo, CampoDoLaudo cdl)
    {
        super(cdl, message);
    }
    
}
