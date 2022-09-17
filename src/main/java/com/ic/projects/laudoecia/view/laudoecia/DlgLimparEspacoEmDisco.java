/*
 * DlgLimparEspacoEmDisco.java
 *
 * Created on 13/08/2012, 17:03:56
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgLimparEspacoEmDisco extends MyJDialog
{
    private boolean cancelado = true;

    public DlgLimparEspacoEmDisco (Component cp)
    {
        super(cp, true, 380, 200);
        setTitle("Deletando vídeos antigos...");
        setIconImage(FormPrincipal.getInstance().getIconImage());
        initializeComponents ();
    }

    private TxtData txtData = new TxtData();
    private MyJLabel lblInfo = new MyJLabel("<html>Por favor, escolha uma data limite para a exclusão dos vídeos.<BR>Serão excluídos os vídeos anteriores a esta data, portanto muita atenção ao fazer esta operação.</html>");
    private MyJButton btnConfirmar = new MyJButton("Confirmar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");

    {
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
        txtData.setPreferredSize(new Dimension(150, txtData.getPreferredSize().height));
    }

    private void initializeComponents ()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.weightx = 1;
        c.gridwidth = 2;
        c.weighty = 0.7;
        pnl.add(lblInfo, c);

        MyJPanel pnlData = new MyJPanel(new FlowLayout(FlowLayout.CENTER));
        pnlData.add(new LblNegrito("Data Limite"));
        pnlData.add(txtData);
        c.weighty = 0;
        c.gridy = 1;
        pnl.add(pnlData, c);

        c.gridwidth = 1;
        c.gridy = 2;
        c.gridx = 0;
        c.weighty = 0.3;
        pnl.add(new PnlComp(true, false).setComponent(btnConfirmar), c);
        c.gridx = 1;
        pnl.add(new PnlComp(true, false).setComponent(btnCancelar), c);

        add(new PnlComEspaco(pnl));
    }

    private void btnConfirmarAction ()
    {
        if (txtData.getDate() != null)
        {
            cancelado = false;
            dispose();
        }
        else
        {
            SwingUtils.mostrarAviso(this, "Você deve escolher uma data.");
        }
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    public Date getData()
    {
        return txtData.getDate();
    }

    @Override
    public void fechar ()
    {
        dispose();
    }

}
