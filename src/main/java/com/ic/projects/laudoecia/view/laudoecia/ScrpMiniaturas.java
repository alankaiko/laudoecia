/*
 * ScrpMiniaturas.java
 *
 * Created on 13/07/2012, 15:38:03
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.lib.swing.plus.cps.MyJPanel;
import java.util.List;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class ScrpMiniaturas extends JScrollPane
{
    
    private boolean horizontal;
    private MyJPanel pnlMiniaturas;
    private List<PnlImgMiniatura> lista;

    ScrpMiniaturas (boolean horizontal, MyJPanel pnlMiniaturas, List<PnlImgMiniatura> lista)
    {
        super(pnlMiniaturas);
        this.horizontal = horizontal;
        this.pnlMiniaturas = pnlMiniaturas;
        this.lista = lista;
    }

    void atualizarScroll (final PnlImgMiniatura pnl)    
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                if (horizontal)
                {
                    atualizarScrollHoriz(pnl.getWidth() + 5, lista.indexOf(pnl));
                }
                else
                {
                    atualizarScrollVert(pnl.getHeight(), lista.indexOf(pnl));
                }
            }
            
        });
    }

    private void atualizarScrollVert (int alturaPnlMin, int index)
    {
        JScrollBar scrllBar = getVerticalScrollBar();
        if (index == -1)
        {
            scrllBar.setValue(0);
            return;
        }
        int valorScrlBar = scrllBar.getValue();
        double valorVisivel = pnlMiniaturas.getVisibleRect().getHeight();
        int valorLinhaSelc = index * alturaPnlMin;
        // atualiza a propriedade valor maximo antes usar o metodo setValue
        validate();

        if (valorLinhaSelc + alturaPnlMin >= valorScrlBar + valorVisivel)
        {
            scrllBar.setValue((int) (valorLinhaSelc - valorVisivel + alturaPnlMin));
        }
        else if (valorLinhaSelc < valorScrlBar)
        {
            scrllBar.setValue(valorLinhaSelc);
        }
        else
        {
            // a linha ja esta visivel
        }
    }
    
    private void atualizarScrollHoriz (int larguraPnlMin, int index)
    {
        JScrollBar scrllBar = getHorizontalScrollBar();
        if (index == -1)
        {
            scrllBar.setValue(0);
            return;
        }
        int valorScrlBar = scrllBar.getValue();
        double valorVisivel = pnlMiniaturas.getVisibleRect().getWidth();
        int valorLinhaSelc = index * larguraPnlMin;
        // atualiza a propriedade valor maximo antes usar o metodo setValue
        validate();

        if (valorLinhaSelc + larguraPnlMin >= valorScrlBar + valorVisivel)
        {
            scrllBar.setValue((int) (valorLinhaSelc - valorVisivel + larguraPnlMin));
        }
        else if (valorLinhaSelc < valorScrlBar)
        {
            scrllBar.setValue(valorLinhaSelc);
        }
        else
        {
            // a linha ja esta visivel
        }
    }
    
}
