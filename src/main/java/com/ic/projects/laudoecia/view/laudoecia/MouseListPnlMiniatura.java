/*
 * MouseListPnlMiniatura.java
 *
 * Created on 13/07/2012, 15:22:31
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.lib.swing.utils.SwingUtils;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class MouseListPnlMiniatura extends MouseAdapter
{

    private List<PnlImgMiniatura> listaMiniaturas;
    private LaudoeCiaMediator mediador;
    private boolean selectForEveryButton;

    MouseListPnlMiniatura (List<PnlImgMiniatura> listaMiniaturas,
                 LaudoeCiaMediator mediador, boolean selectForEveryButton)
    {
        this.listaMiniaturas = listaMiniaturas;
        this.mediador = mediador;
        this.selectForEveryButton = selectForEveryButton;
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        if ((selectForEveryButton || e.getButton() == MouseEvent.BUTTON1)
                && e.getSource() instanceof Container)
        {
            PnlImgMiniatura pnl = SwingUtils.getParent(
                    (Container) e.getSource(), PnlImgMiniatura.class);
            if (pnl != null)
            {
                int index = listaMiniaturas.indexOf(pnl);
                mediador.irParaImg(index);
            }
        }
    }

    @Override
    public void mouseReleased (final MouseEvent e)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                if (e.isConsumed())
                {
                }
                else if (e.getButton() == MouseEvent.BUTTON3)
                {
//                    mediador.iniciarEdicaoDeImg();
                }
                else
                {
                }
            }

        });
    }

}
