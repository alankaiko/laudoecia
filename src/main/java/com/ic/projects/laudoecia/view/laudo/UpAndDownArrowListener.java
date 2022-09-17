/*
 * UpAndDownArrowListener.java
 *
 * Created on 04/06/2012, 08:17:03
 */

package com.ic.projects.laudoecia.view.laudo;

import com.lib.swing.utils.RobotImpl;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class UpAndDownArrowListener extends KeyAdapter
{

    @Override
    public void keyReleased (KeyEvent evt)
    {
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
                RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
                evt.consume();
                break;
            case KeyEvent.VK_UP:
                RobotImpl.pressionarTecla(KeyEvent.VK_TAB, KeyEvent.VK_SHIFT);
                evt.consume();
                break;
            default:
        }
    }
    
}
