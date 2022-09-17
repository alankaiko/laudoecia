/*
 * MouseListDaCaptura.java
 *
 * Created on 11/08/2012, 10:12:36
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.lib.java.utils.DateUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class MouseListDaCaptura extends MouseAdapter
{

    private LaudoeCiaMediator mediador;
    private long mousePressedWhen = 0;
    private static final int MIN_PRESSED_TIME = 10000;
    private static final int MAX_PRESSED_TIME = 10750;

    public MouseListDaCaptura (LaudoeCiaMediator mediador)
    {
        this.mediador = mediador;
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        switch (e.getButton())
        {
            case MouseEvent.BUTTON3:
            case MouseEvent.BUTTON2:
                mousePressedWhen = e.getWhen();
                break;
            default:
        }
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {
        if ((e.getButton() == MouseEvent.BUTTON3 ||
            e.getButton() == MouseEvent.BUTTON2) && !e.isConsumed())
        {
            if (pressedMilliSeconds(e.getWhen()) > MIN_PRESSED_TIME &&
                     pressedMilliSeconds(e.getWhen()) < MAX_PRESSED_TIME)
            {
//                PnlLaudoeCia.getInstance().alternarGravacaoNoDisco();
//                e.consume();
            }
            else if (pressedMilliSeconds(e.getWhen()) > MAX_PRESSED_TIME)
            {
            }
            else if (mediador.capturarImagem())
            {
                e.consume();
            }
            else
            {
            }
        }
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                mousePressedWhen = 0;
            }

        });
    }

    private long pressedMilliSeconds (long mouseReleasedWhen)
    {
        return mouseReleasedWhen - mousePressedWhen;
    }

}
