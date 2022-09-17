/*
 * PnlDoTopico.java
 *
 * Created on 09/07/2012, 10:19:20
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.control.laudoecia.C_TxtTopico;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.lib.swing.plus.cps.MyJPanel;
import java.awt.Component;
import java.awt.GridBagLayout;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class PnlDoTopico extends MyJPanel
{
    
    private C_TxtTopico buscador;
    private SwViewLaudo sw;
    private Component focusCp;

    PnlDoTopico (C_TxtTopico buscador, SwViewLaudo sw)
    {
        super(new GridBagLayout());
        this.buscador = buscador;
        this.sw = sw;
        setFocusable(true);
    }
    
    void proximo ()
    {
        buscador.proximo();
    }
    
    void anterior ()
    {
        buscador.anterior();
    }

    void setFocusCp (Component focusCp)
    {
        this.focusCp = focusCp;
    }
    
    void irParaExec ()
    {
        buscador.irParaExec();
    }
    
    void irPara (CampoDoLaudo cdl)
    {
        sw.irParaTopico(cdl);
    }
    
    @Override
    public boolean requestFocusInWindow ()
    {
        if (focusCp == null)
        {
            return super.requestFocusInWindow();
        }
        else
        {
            return focusCp.requestFocusInWindow();
        }
    }

}
