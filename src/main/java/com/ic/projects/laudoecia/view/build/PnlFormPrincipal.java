/*
 * PnlFormPrincipal.java
 *
 * Created on 23/04/2012, 09:19:10
 */

package com.ic.projects.laudoecia.view.build;

import java.awt.Container;
import javax.swing.JMenuBar;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface PnlFormPrincipal
{
    
    JMenuBar getMenu ();
    boolean fullScreen ();
    Container getContainer ();
    void selected ();

}
