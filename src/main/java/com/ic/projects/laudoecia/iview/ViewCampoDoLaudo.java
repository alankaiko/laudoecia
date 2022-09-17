/*
 * ViewCampoDoLaudo.java
 *
 * Created on 11/06/2012, 08:16:26
 */

package com.ic.projects.laudoecia.iview;

import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface ViewCampoDoLaudo
{
    
    int NONE = 0;
    int TAB = 1;
    int SHIFT_TAB = 2;
    
    void setEnabled (boolean enabled);
    void setVisible (boolean visible);
    void setText (String string);

    String getValor ();
    CampoDoLaudo getCampoDoLaudo ();
    
    int getFocusLostStatus ();
    void setFocusLostStatus (int status);
    
    boolean requestFocusInWindow ();

}
