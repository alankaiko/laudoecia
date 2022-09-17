/*
 * TxtInteiro.java
 *
 * Created on 11/06/2012, 08:06:08
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoInteiro;
import com.lib.java.utils.StringUtils;
import com.lib.swing.utils.EnterEnviaTab;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class TxtInteiro extends com.lib.swing.plus.utils.TxtInteiro implements ViewCampoDoLaudo
{
    
    private CampoInteiro campoInteiro;
    private int focusLostStatus = ViewCampoDoLaudo.NONE;

    TxtInteiro (CampoInteiro campoInteiro, boolean vincularVisible)
    {
        super(campoInteiro.getNumeroMaxDeDigitos(), true);
        this.campoInteiro = campoInteiro;
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
        if (text == null || text.isEmpty() || !StringUtils.parseableToInt(text))
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
        return campoInteiro;
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
