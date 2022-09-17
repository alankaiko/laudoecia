/*
 * DlgCadastro.java
 *
 * Created on 26/09/2012, 11:26:49
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.plus.cps.MyJDialog;
import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public abstract class DlgCadastro extends MyJDialog implements ReceptorDeBusca
{

    protected SimplePnlCadastro pnlCadastro;

    public DlgCadastro (Component cp, boolean modal)
    {
        super(cp, modal);
    }

    public DlgCadastro (Component cp, boolean modal, Rectangle bounds)
    {
        super(cp, modal, bounds);
    }

    public DlgCadastro (Component cp, boolean modal, int width, int heigth)
    {
        super(cp, modal, width, heigth);
    }

    public void iniciarBusca (ReceptorDeBusca receptor, Object param)
    {
        pnlCadastro.iniciarBusca(receptor, param);
    }

    @Override
    public void fechar ()
    {
        pnlCadastro.viewClosing();
    }

    @Override
    public boolean isHabilitadoParaReceber ()
    {
        return true;
    }

    @Override
    public void receberBusca (Object param)
    {
        Container c = pnlCadastro.getContainerEntidade();
        if (param != null && c instanceof PnlDaEntidade)
        {
            ((PnlDaEntidade) c).usarResultadoDaBusca(param);
        }
    }

}
