/*
 * DesabilitadorDeCampo.java
 *
 * Created on 16/05/2012, 16:30:17
 */

package com.ic.projects.laudoecia.model.laudo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
abstract class DesabilitadorDeCampo implements CampoDoLaudoListener
{
    
    abstract boolean desabilitarCampo ();

}
