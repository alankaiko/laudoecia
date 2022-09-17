/*
 * DlgFiltroRelAtendResumos.java
 *
 * Created on 05/03/2012, 10:11:57
 */
package com.ic.projects.laudoecia.view.reports;

import com.lib.java.utils.DateUtils;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
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
public class DlgFiltroRelAtendResumos extends MyJDialog
{
    public DlgFiltroRelAtendResumos (Component cp)
    {
        super(cp, false, 450, 280);
        setTitle("Relatório de Atendimentos - Resumos");
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
        c.gridwidth = 3;
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
        c.gridwidth = 3;
        c.gridy = 3;
        c.gridx = 0;
        pnlPrincipal.add(new PnlComp(false, false).setComponent(ckbResumosConv), c);
        c.gridy = 4;
        c.gridx = 0;
        pnlPrincipal.add(ckbResumosProcMed, c);
        c.gridy = 5;
        c.gridx = 0;
        pnlPrincipal.add(ckbResumosProfExe, c);
        c.gridy = 6;
        c.gridx = 0;
        pnlPrincipal.add(ckbResumosProfSol, c);
        c.gridy = 7;
        c.gridx = 0;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarRel);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);

        c.gridy = 8; //tamanhos
        c.gridx = 0;
        c.gridwidth = 1;
        c.weighty = 0;
        pnlPrincipal.add(Box.createHorizontalStrut(145), c);
        c.gridx = 1;
        pnlPrincipal.add(Box.createHorizontalStrut(145), c);
        c.gridx = 2;
        pnlPrincipal.add(Box.createHorizontalStrut(140), c);
    }

    private void btnGerarPdfAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        RelAtendCreator.exportPdfRelatorioSoResumos(
                        txtDataInicial.getDate(), txtDataFinal.getDate(),
                        ckbResumosProcMed.isSelected(),
                        ckbResumosConv.isSelected(),
                        ckbResumosProfExe.isSelected(),
                        ckbResumosProfSol.isSelected());
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarRelAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        JRViewer jrv = RelAtendCreator.getRelatorioSoResumos(
                        txtDataInicial.getDate(), txtDataFinal.getDate(),
                        ckbResumosProcMed.isSelected(),
                        ckbResumosConv.isSelected(),
                        ckbResumosProfExe.isSelected(),
                        ckbResumosProfSol.isSelected());
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
    private MyJCheckBox ckbResumosConv = new MyJCheckBox();
    private MyJCheckBox ckbResumosProcMed = new MyJCheckBox();
    private MyJCheckBox ckbResumosProfExe = new MyJCheckBox();
    private MyJCheckBox ckbResumosProfSol = new MyJCheckBox();
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
        ckbResumosConv.setText("Mostrar resumos por convênio?");
        ckbResumosConv.setSelected(true);
        ckbResumosProcMed.setText("Mostrar resumos por procedimento médico?");
        ckbResumosProcMed.setSelected(true);
        ckbResumosProfExe.setText("Mostrar resumos por profissional executante?");
        ckbResumosProfExe.setSelected(true);
        ckbResumosProfSol.setText("Mostrar resumos por profissional solicitante?");
        ckbResumosProfSol.setSelected(true);
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
    }

}
