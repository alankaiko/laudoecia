/*
 * TabKeyListener.java
 *
 * Created on 12/07/2012, 10:21:08
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class TabKeyListener extends KeyAdapter
{

    private ViewCampoDoLaudo viewCdl;

    TabKeyListener (ViewCampoDoLaudo viewCdl)
    {
        this.viewCdl = viewCdl;
    }

    @Override
    public void keyReleased (KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_TAB:
                boolean trocarFoco = true;
                CampoDoLaudo cdl = viewCdl.getCampoDoLaudo();
                if (!(cdl == null || e.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK))
                {
                    String valor = cdl.getValor();
                    if ((valor == null || valor.isEmpty()) && cdl.isObrigatorio())
                    {
                        PnlLaudoeCia.getInstance().mostrarMsgErro(
                                cdl.getMsgErroValidCampoObrig());
                        trocarFoco = false;
                    }
                }
                if (trocarFoco)
                {
                    trocarFoco(e);
                }
                break;
            default:
        }
    }

    private void trocarFoco (KeyEvent e)
    {
        KeyboardFocusManager manager = KeyboardFocusManager.
                getCurrentKeyboardFocusManager();
        if (e.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK)
        {
            viewCdl.setFocusLostStatus(ViewCampoDoLaudo.SHIFT_TAB);
            manager.focusPreviousComponent();
        }
        else
        {
            viewCdl.setFocusLostStatus(ViewCampoDoLaudo.TAB);
            manager.focusNextComponent();
        }
        e.consume();
    }

}
