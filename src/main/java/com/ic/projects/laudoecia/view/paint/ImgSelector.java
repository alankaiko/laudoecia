/*
 * ImgSelector.java
 *
 * Created on 16/05/2011, 08:38:17
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.Shape;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
interface ImgSelector
{
    
    boolean hasSelection ();
    Shape getSelectedShapeFromImage ();

}
