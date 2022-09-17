/*
 * TxtTopico.java
 *
 * Created on 06/07/2012, 15:09:50
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.control.laudoecia.C_TxtTopico;
import com.ic.projects.laudoecia.iview.ViewTopico;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.plus.utils.CardAdapter;
import com.lib.swing.plus.utils.PnlCartao;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class TxtTopico extends TxtComAutoCompletar implements ViewTopico
{
    
    private PnlCartao pnlTopicos;

    public TxtTopico (PnlCartao pnlTopicos)
    {
        this.pnlTopicos = pnlTopicos;
        addAutoCompletarListener(new AutoCompletarListener()
        {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                C_TxtTopico controlador = getControlador();
                if (controlador == null)
                {
                }
                else
                {
                    controlador.modelSelMudou(oldLinhaSelecionada);
                }
            }

        });
        pnlTopicos.addCardListener(new CardAdapter()
        {
            @Override
            public void cardAdded (String cardId)
            {
                C_TxtTopico controlador = getControlador();
                if (controlador == null)
                {
                }
                else
                {
                    controlador.topicoFoiAdicionado(cardId);
                }

            }

        });
    }

    @Override
    public C_TxtTopico getControlador ()
    {
        return (C_TxtTopico) super.getControlador();
    }

    @Override
    public void setTopicoSel (String cardId)
    {
        pnlTopicos.setSelectedCard(cardId);
    }

}
