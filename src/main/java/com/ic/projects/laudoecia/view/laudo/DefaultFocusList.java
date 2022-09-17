/*
 * DefaultFocusList.java
 *
 * Created on 22/08/2012, 15:35:47
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.lib.swing.utils.SwingUtils;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DefaultFocusList extends FocusAdapter
{
    
    private static DefaultFocusList instance;
    
    static DefaultFocusList getInstance ()
    {
        if (instance == null)
        {
            instance = new DefaultFocusList();
        }
        return instance;
    }
    
    @Override
    public void focusLost (FocusEvent e)
    {
        Component comp = e.getComponent();
        Component opComp = e.getOppositeComponent();
        PnlDoTopico compPnl;
        if (comp == null || opComp == null)
        {
            // assertion error
        }
        else if ((compPnl = SwingUtils.getParent(comp, PnlDoTopico.class)) == null)
        {
            // assertion error
        }
        else
        {
            PnlDoTopico opCompPnl = SwingUtils.getParent(opComp, PnlDoTopico.class);
            if (compPnl == opCompPnl)
            {
            }
            else
            {
                ViewCampoDoLaudo txtCdl;
                if (comp instanceof ViewCampoDoLaudo)
                {
                    txtCdl = (ViewCampoDoLaudo) comp;
                }
                else
                {
                    txtCdl = SwingUtils.getParent(comp, ViewCampoDoLaudo.class);
                }
                if (txtCdl == null)
                {
                }
                else
                {
                    switch (txtCdl.getFocusLostStatus())
                    {
                        case ViewCampoDoLaudo.NONE:
                            break;
                        case ViewCampoDoLaudo.TAB:
                            compPnl.proximo();
                            break;
                        case ViewCampoDoLaudo.SHIFT_TAB:
                            compPnl.anterior();
                            break;
                        default:
                    }
                }
            }
        }
    }

}
