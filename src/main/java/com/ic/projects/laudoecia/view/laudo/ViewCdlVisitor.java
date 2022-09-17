/*
 * ViewCdlVisitor.java
 *
 * Created on 21/06/2012, 15:32:51
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudoVisitor;
import java.awt.Component;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
abstract class ViewCdlVisitor implements CampoDoLaudoVisitor
{
    
    abstract Component getComponentCriado ();
    
}
