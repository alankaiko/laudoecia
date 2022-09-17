/*
 * TxtData.java
 *
 * Created on 11/06/2012, 09:38:21
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDate;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.lib.swing.utils.EnterEnviaTab;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class TxtData extends com.lib.swing.maskedfields.TxtData implements ViewCampoDoLaudo
{
    
    private CampoDate campoDate;
    private int focusLostStatus = ViewCampoDoLaudo.NONE;

    TxtData (CampoDate campoDate, boolean vincularVisible)
    {
        this.campoDate = campoDate;
        addKeyListener(new UpAndDownArrowListener());
        addKeyListener(new EnterEnviaTab());
        addDocumentListener(new DefaultListener(this, vincularVisible));
        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained (FocusEvent e)
            {
                selectAll();
            }
        });
        addFocusListener(new FocusLostStatusCleaner(this));
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new TabKeyListener(this));
    }
    
    @Override
    public String getValor ()
    {
        return getDate() == null ? null : getText();
    }

    @Override
    public CampoDoLaudo getCampoDoLaudo ()
    {
        return campoDate;
    }

    @Override
    public int getFocusLostStatus ()
    {
        return focusLostStatus;
    }
    
    @Override
    public void setFocusLostStatus (int status)
    {
        focusLostStatus = status;
    }

}
