/*
 * DlgFiltroRelAtendPorProfExecutante.java
 *
 * Created on 02/03/2012, 14:48:04
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfExecutante;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.lib.java.utils.DateUtils;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgFiltroRelAtendPorProfExecutante extends MyJDialog
{

    private final BuscadorDeProfExecutante buscProfExe = new BuscadorDeProfExecutante();

    public DlgFiltroRelAtendPorProfExecutante (Component cp)
    {
        super(cp, false, 450, 300);
        setTitle("Relatório de Atendimentos Por Profissional Executante / Diagnóstico");
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
        pnlPrincipal.add(lblExplicacao1, c);
        c.gridy = 1;
        c.gridx = 0;
        pnlPrincipal.add(lblExplicacao2, c);
        c.gridy = 2;
        c.gridx = 0;
        pnlPrincipal.add(Box.createVerticalStrut(20), c);
        c.gridwidth = 1;
        c.gridy = 3;
        c.gridx = 0;
        pnlPrincipal.add(new PnlComp("Data Inicial", false, true).setComponent(txtDataInicial), c);
        c.gridy = 3;
        c.gridx = 1;
        pnlPrincipal.add(new PnlComp("Data Final", true, true).setComponent(txtDataFinal), c);
        MyJPanel p = new MyJPanel();
        p.setLayout(new BorderLayout());
        p.add(ckbComResumos, BorderLayout.NORTH);
        p.add(ckbSoResumos, BorderLayout.SOUTH);
        c.gridy = 3;
        c.gridx = 3;
        pnlPrincipal.add(p, c);
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 4;
        pnlPrincipal.add(new PnlComp("Profissional Executante", false, true).setComponent(txtProfExe), c);
        c.gridy = 5;
        pnlPrincipal.add(new PnlComp("Parte do laudo", false, true).setComponent(txtLaudo), c);
        pnlPrincipal.add(Box.createHorizontalBox(), c);
        c.gridy = 6;
        c.gridx = 0;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarRel);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);

        c.gridy = 7; //tamanhos
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
        ProfExecutante profExe = buscProfExe.getSelectedModel();
        if (ckbSoResumos.isSelected())
        {
            RelAtendCreator.exportPdfRelatorioSoResumosPorProfExecutanteLaudo(txtLaudo.getText(), profExe, txtDataInicial.getDate(), txtDataFinal.getDate());
        }
        else
        {
            RelAtendCreator.exportPdfRelatorioPorProfExecutanteLaudo(txtLaudo.getText(), profExe, txtDataInicial.getDate(), txtDataFinal.getDate(), ckbComResumos.isSelected());
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarRelAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        ProfExecutante profExe = buscProfExe.getSelectedModel();
        JRViewer jrv;
        if (ckbSoResumos.isSelected())
        {
            jrv = RelAtendCreator.getRelatorioSoResumosPorProfExecutante(txtLaudo.getText(), profExe, txtDataInicial.getDate(), txtDataFinal.getDate());
        }
        else
        {
            jrv = RelAtendCreator.getRelatorioPorProfExecutante(txtLaudo.getText(), profExe, txtDataInicial.getDate(), txtDataFinal.getDate(), ckbComResumos.isSelected());
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

    private final MyJPanel pnlPrincipal = new MyJPanel();
    private final LblNegrito lblExplicacao1 = new LblNegrito();
    private final LblNegrito lblExplicacao2 = new LblNegrito();
    private final TxtData txtDataInicial = new TxtData();
    private final TxtData txtDataFinal = new TxtData();
    private final MyJCheckBox ckbComResumos = new MyJCheckBox();
    private final MyJCheckBox ckbSoResumos = new MyJCheckBox();
    private final TxtComAutoCompletar txtProfExe = new TxtComAutoCompletar();
    private final MyJTextField txtLaudo = new MyJTextField();
    private final MyJPanel pnlButtons = new MyJPanel();
    private final MyJButton btnGerarPdf = new MyJButton();
    private final MyJButton btnGerarRel = new MyJButton();
    private final MyJButton btnCancelar = new MyJButton();

    //</editor-fold>

    {
        pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
        add(pnlPrincipal);

        lblExplicacao1.setText(" Escolha o período de datas de atendimento e selecione um profissional");
        lblExplicacao2.setText(" executante / diagnóstico para gerar seu relatório.");
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
        txtProfExe.setControlador(buscProfExe);
    }

}
