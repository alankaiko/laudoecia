/*
 * FocusLostStatusCleaner.java
 *
 * Created on 12/07/2012, 10:15:16
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class FocusLostStatusCleaner extends FocusAdapter
{

    private ViewCampoDoLaudo viewCdl;

    FocusLostStatusCleaner (ViewCampoDoLaudo viewCdl)
    {
        this.viewCdl = viewCdl;
    }

    @Override
    public void focusGained (FocusEvent e)
    {
        viewCdl.setFocusLostStatus(ViewCampoDoLaudo.NONE);
    }

}
