/*
 * DlgProcDaTabela.java
 *
 * Created on 19/03/2012, 11:18:23
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeConvenio;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.lib.java.utils.Money;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtDinheiro;
import com.lib.swing.utils.EnterEnviaTab;
import com.lib.swing.utils.SwingUtils;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Box;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgProcDaTabela extends MyJDialog
{
    private static final long serialVersionUID = 1L;

    private BuscadorDeConvenio buscadorDeConvenios = new BuscadorDeConvenio();
    private boolean cancelado = true;

    public DlgProcDaTabela (Component cp)
    {
        super(cp, true, 500, 140);
        initComponents();
    }

    public Convenio getConvenio ()
    {
        return buscadorDeConvenios.getSelectedModel();
    }

    public Money getValorConvenio ()
    {
        return new Money(txtValorConv.getDouble());
    }

    public Money getValorPaciente ()
    {
        return new Money(txtValorPac.getDouble());
    }

    public void setConvenio (Convenio convenio)
    {
        buscadorDeConvenios.setSelectedModel(convenio);
    }

    public void setTxtConvenioEnabled(boolean enabled)
    {
        txtConvenio.setEditable(enabled);
        txtConvenio.setFocusable(enabled);
    }

    public void setValorConvenio (double valorConvenio)
    {
        txtValorConv.setText(valorConvenio);
    }

    public void setValorPaciente (double valorPaciente)
    {
        txtValorPac.setText(valorPaciente);
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    @Override
    public void fechar ()
    {
        cancelado = true;
        dispose();
    }

    private void btnConfirmarAction ()
    {
        if (validarCampos())
        {
            cancelado = false;
            dispose();
        }
    }

    private void initComponents ()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        pnl.add(new PnlComp("Convênio", false, false).setComponent(txtConvenio), c);
        c.gridx = 1;
        pnl.add(new PnlComp("Valor Paciente", true, false).setComponent(txtValorPac), c);
        c.gridx = 2;
        pnl.add(new PnlComp("Valor Convênio", true, false).setComponent(txtValorConv), c);

        c.gridy = 1;
        c.gridx = 1;
        c.weighty = 1;
        pnl.add(new PnlComp(true, false).setComponent(btnConfirmar), c);
        c.gridx = 2;
        pnl.add(new PnlComp(true, false).setComponent(btnCancelar), c);

        c.weighty = 0;
        c.gridy = 2;
        c.gridx = 0;
        pnl.add(Box.createHorizontalStrut(250), c);
        c.gridx = 1;
        pnl.add(Box.createHorizontalStrut(120), c);
        c.gridx = 2;
        pnl.add(Box.createHorizontalStrut(120), c);

        add(new PnlComEspaco(pnl));
    }

    //<editor-fold defaultstate="collapsed" desc="Components do Form">

    private TxtComAutoCompletar txtConvenio = new TxtComAutoCompletar(buscadorDeConvenios);
    private TxtDinheiro txtValorPac = new TxtDinheiro();
    private TxtDinheiro txtValorConv = new TxtDinheiro();
    private MyJButton btnConfirmar = new MyJButton("Confirmar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");

    {
        KeyListener kl = new EnterEnviaTab(false);
        txtValorConv.addKeyListener(kl);
        txtValorPac.addKeyListener(kl);
        txtConvenio.addKeyListener(kl);
        txtConvenio.setStrictMatching(true);
        txtConvenio.setMensagemDeErro("Convênio não encontrado");
        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                fechar();
            }

        });
        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction();
            }

        });
    }

    //</editor-fold>

    private boolean validarCampos ()
    {
        if (buscadorDeConvenios.getSelectedModel() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "Você deve selecionar um convênio.");
            return false;
        }
        return true;
    }

}
