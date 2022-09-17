/*
 * DlgFiltroRelAtendCompleto.java
 *
 * Created on 01/03/2012, 14:12:11
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.model.enums.STATUS_LAUDO;
import com.lib.java.utils.DateUtils;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import net.sf.jasperreports.swing.JRViewer;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgFiltroRelAtendCompleto extends MyJDialog
{
    public DlgFiltroRelAtendCompleto (Component cp)
    {
        super(cp, false, 430, 230);
        setTitle("Relatório de Atendimentos - Completo");
        initComponents();
    }

    private void initComponents ()
    {
        pnlPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        pnlPrincipal.add(lblExplicacao, c);
        c.gridy = 1;
        c.gridx = 0;
        pnlPrincipal.add(Box.createVerticalStrut(20), c);
        c.gridwidth = 1;
        c.gridy = 2;
        c.gridx = 0;
        pnlPrincipal.add(new PnlComp("Data Inicial", false, true).setComponent(txtDataInicial), c);
        c.gridy = 2;
        c.gridx = 1;
        pnlPrincipal.add(new PnlComp("Data Final", true, true).setComponent(txtDataFinal), c);
        MyJPanel p = new MyJPanel();
        p.setLayout(new BorderLayout());
        p.add(ckbComResumos, BorderLayout.NORTH);
        p.add(ckbSoResumos, BorderLayout.SOUTH);
        c.gridy = 2;
        c.gridx = 3;
        pnlPrincipal.add(p, c);//cmbStatusLaudo
        c.gridy = 3;
        c.gridx = 0;
        pnlPrincipal.add(new PnlComp("Situação do laudo", false, true).setComponent(cmbStatusLaudo), c);
        c.gridwidth = 4;
        c.gridy = 4;
        c.gridx = 0;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarRel);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp(false, false).setComponent(pnlButtons), c);

        c.gridy = 5; //tamanhos
        c.gridx = 0;
        c.gridwidth = 1;
        c.weighty = 0;
        pnlPrincipal.add(Box.createHorizontalStrut(135), c);
        c.gridx = 1;
        pnlPrincipal.add(Box.createHorizontalStrut(135), c);
        c.gridx = 2;
        pnlPrincipal.add(Box.createHorizontalStrut(5), c);
        c.gridx = 3;
        pnlPrincipal.add(Box.createHorizontalStrut(140), c);
    }

    private void btnGerarPdfAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (ckbSoResumos.isSelected())
        {
            RelAtendCreator.exportPdfRelatorioSoResumos(txtDataInicial.getDate(), txtDataFinal.getDate(), true, true, true, true);
        }
        else
        {
            RelAtendCreator.exportPdfRelatorioCompleto(txtDataInicial.getDate(), txtDataFinal.getDate(), ckbComResumos.isSelected(), cmbStatusLaudo.getSelectedItem());
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarRelAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        JRViewer jrv;
        if (ckbSoResumos.isSelected())
        {
            jrv = RelAtendCreator.getRelatorioSoResumos(txtDataInicial.getDate(), txtDataFinal.getDate(), true, true, true, true);
        }
        else
        {
            jrv = RelAtendCreator.getRelatorioCompleto(txtDataInicial.getDate(), txtDataFinal.getDate(), ckbComResumos.isSelected(), cmbStatusLaudo.getSelectedItem());
        }
        if (jrv != null)
        {
            JFrameRelatorios frame = new JFrameRelatorios(this.getTitle());
            frame.add(jrv);
            frame.setVisible(true);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnCancelarAction ()
    {
        fechar();
    }

    @Override
    public void fechar ()
    {
        this.setVisible(false);
    }

    //<editor-fold defaultstate="collapsed" desc="Components Filtro">
    private MyJPanel pnlPrincipal = new MyJPanel();
    private LblNegrito lblExplicacao = new LblNegrito();
    private TxtData txtDataInicial = new TxtData();
    private TxtData txtDataFinal = new TxtData();
    private MyJCheckBox ckbComResumos = new MyJCheckBox();
    private MyJCheckBox ckbSoResumos = new MyJCheckBox();
    private MyJComboBox<String> cmbStatusLaudo = new MyJComboBox<>(STATUS_LAUDO.getStatusComOpcaoAdicional("indiferente"));;
    private MyJPanel pnlButtons = new MyJPanel();
    private MyJButton btnGerarPdf = new MyJButton();
    private MyJButton btnGerarRel = new MyJButton();
    private MyJButton btnCancelar = new MyJButton();
    //</editor-fold>

    //Configurações dos Components
    {
        pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
        add(pnlPrincipal);

        lblExplicacao.setText(" Escolha o período de datas de atendimento para gerar seu relatório.");
        ckbComResumos.setText("Com resumos?");
        ckbComResumos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                if (ckbComResumos.isSelected())
                {
                    ckbSoResumos.setSelected(false);
                }
            }
        });
        ckbSoResumos.setText("Apenas Resumos");
        ckbSoResumos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                if (ckbSoResumos.isSelected())
                {
                    ckbComResumos.setSelected(false);
                }
            }
        });
        btnGerarPdf.setText("Gerar PDF");
        btnGerarPdf.setIcon(SwingLibResources.getIcon(Imagens.PDF_FILE));
        btnGerarPdf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnGerarPdfAction();
            }

        });
        btnGerarRel.setText("Gerar Relatório");
        btnGerarRel.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnGerarRel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnGerarRelAction();
            }

        });
        btnCancelar.setText("Cancelar");
        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnCancelarAction();
            }

        });
        txtDataInicial.setText(DateUtils.subtrairDiasNaData(new Date(), 30));
        txtDataFinal.setText(new Date());

        ckbSoResumos.setSelected(true);

    }

}
