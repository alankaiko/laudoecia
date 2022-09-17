/*
 * TxtDouble.java
 *
 * Created on 11/06/2012, 08:26:29
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDouble;
import com.lib.java.utils.StringUtils;
import com.lib.swing.utils.EnterEnviaTab;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class TxtDouble extends com.lib.swing.plus.utils.TxtDouble implements ViewCampoDoLaudo
{
    
    private CampoDouble campoDouble;
    private int focusLostStatus = ViewCampoDoLaudo.NONE;

    TxtDouble (CampoDouble campoDouble, boolean vincularVisible)
    {
        this.campoDouble = campoDouble;
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
        String text = getText();
        if (text == null || text.isEmpty() || !StringUtils.parseableToDouble(text, true))
        {
            return null;
        }
        else
        {
            return text;
        }
    }

    @Override
    public CampoDoLaudo getCampoDoLaudo ()
    {
        return campoDouble;
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
