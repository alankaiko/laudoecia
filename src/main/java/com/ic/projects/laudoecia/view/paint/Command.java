/*
 * Command.java
 *
 * Created on 11/05/2011, 09:02:38
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.image.BufferedImage;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
interface Command
{
    
    void undo (BufferedImage b);
    void redo (BufferedImage b);

}