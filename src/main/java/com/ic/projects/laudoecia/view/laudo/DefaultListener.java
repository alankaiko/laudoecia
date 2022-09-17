/*
 * DefaultListener.java
 *
 * Created on 05/06/2012, 08:43:05
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudoListener;
import com.ic.projects.laudoecia.model.laudo.EventoDoCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.utils.SwingUtils;
import java.awt.Component;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DefaultListener extends TxtChangedListener implements CampoDoLaudoListener
{

    private ViewCampoDoLaudo view;
    private boolean docListEnabled = true;
    private boolean valorDoCdlListEnabled = true;
    private boolean vincularVisible;

    DefaultListener (ViewCampoDoLaudo view, boolean vincularVisible)
    {
        this.view = view;
        view.getCampoDoLaudo().setView(view);
        view.getCampoDoLaudo().adicionarListener(this);
        view.setText(view.getCampoDoLaudo().getValor());
        this.vincularVisible = vincularVisible;
        if (vincularVisible)
        {
            setVisible(view.getCampoDoLaudo().isHabilitado());
        }
        else
        {
            view.setEnabled(view.getCampoDoLaudo().isHabilitado());
        }
    }

    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
        switch (evento.getTipo())
        {
            case EventoDoCampoDoLaudo.HABILITADO_MUDOU:
                if (vincularVisible)
                {
                    setVisible((boolean) evento.getValorAtual());
                }
                else
                {
                    view.setEnabled((boolean)evento.getValorAtual());
                }
                break;
            case EventoDoCampoDoLaudo.VALOR_MUDOU:
                if (valorDoCdlListEnabled)
                {
                    docListEnabled = false;
                    view.setText((String)evento.getValorAtual());
                    docListEnabled = true;
                }
                break;
            default:
        }
    }

    @Override
    public void textChanged (DocumentEvent de)
    {
        if (docListEnabled)
        {
            valorDoCdlListEnabled = false;
            try
            {
                view.getCampoDoLaudo().setValor(view.getValor());
            }
            catch (ErrosDeValidacao ex)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(null, ex.getMessage());
            }
            finally
            {
                valorDoCdlListEnabled = true;
            }
        }
    }

    private void setVisible (boolean visible)
    {
        Component cp = ((Component) view);
        PnlComp pc = SwingUtils.getParent(cp, PnlComp.class, 3);
        if (pc == null)
        {
            view.setVisible(visible);
        }
        else
        {
            view.setVisible(true);
            pc.setVisible(visible);
        }
    }

}
