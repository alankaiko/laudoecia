/*
 * TxtCampoAlfaNumerico.java
 *
 * Created on 30/05/2014, 10:53:52
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoAlfaNumerico;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.utils.EnterEnviaTab;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class TxtCampoAlfaNumerico extends MyJTextField implements ViewCampoDoLaudo
{

    private final CampoAlfaNumerico campoAlfa;
    private int focusLostStatus = ViewCampoDoLaudo.NONE;

    public TxtCampoAlfaNumerico (CampoAlfaNumerico campoTexto, boolean vincularVisible)
    {
        this.campoAlfa = campoTexto;
        setStrCnfEnabled(false);
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
        if (text == null || text.isEmpty())
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
        return campoAlfa;
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
