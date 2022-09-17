/*
 * DlgFiltroGrafDeAtendimentos.java
 *
 * Created on 05/03/2012, 11:02:55
 */
package com.ic.projects.laudoecia.view.reports;

import com.lib.java.utils.DateUtils;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJComboBox;
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
public class DlgFiltroGrafDeAtendimentos extends MyJDialog
{
    public DlgFiltroGrafDeAtendimentos (Component cp)
    {
        super(cp, false, 450, 220);
        setTitle("Gráficos de Atendimentos");
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
        c.gridy = 3;
        c.gridx = 2;
        pnlPrincipal.add(new PnlComp("Tipo de Gráfico",true, true).setComponent(cboGrafico), c);
        c.gridwidth = 3;
        c.gridy = 4;
        c.gridx = 0;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarGraf);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);

        c.gridy = 5; //tamanhos
        c.gridx = 0;
        c.gridwidth = 1;
        c.weighty = 0;
        pnlPrincipal.add(Box.createHorizontalStrut(100), c);
        c.gridx = 1;
        pnlPrincipal.add(Box.createHorizontalStrut(100), c);
        c.gridx = 2;
        pnlPrincipal.add(Box.createHorizontalStrut(160), c);
    }

    private void btnGerarPdfAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        switch (cboGrafico.getSelectedItem()){
            case "por Convênio":
                RelAtendCreator.exportPdfGraficoPorConvenio(txtDataInicial.getDate(), txtDataFinal.getDate());
                break;
            case "por Procedimento Médico":
                RelAtendCreator.exportPdfGraficoPorProcMedico(txtDataInicial.getDate(), txtDataFinal.getDate());
                break;
            case "por Profissional Executante":
                RelAtendCreator.exportPdfGraficoPorProfExecutante(txtDataInicial.getDate(), txtDataFinal.getDate());
                break;
            case "por Profissional Solicitante":
                RelAtendCreator.exportPdfGraficoPorProfSolicitante(txtDataInicial.getDate(), txtDataFinal.getDate());
                break;
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarGrafAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        switch (cboGrafico.getSelectedItem()){
            case "por Convênio":
                gerarGraficoConvenio();
                break;
            case "por Procedimento Médico":
                gerarGraficoProcMedico();
                break;
            case "por Profissional Executante":
                gerarGraficoProfExecutante();
                break;
            case "por Profissional Solicitante":
                gerarGraficoProfSolicitante();
                break;
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void gerarGraficoConvenio ()
    {
        JRViewer jrv = RelAtendCreator.getGraficoPorConvenio(txtDataInicial.getDate(), txtDataFinal.getDate());
        if (jrv != null)
        {
            JFrameRelatorios frame = new JFrameRelatorios(this.getTitle() + " por Convênios");
            frame.add(jrv);
            frame.setVisible(true);
        }
    }

    private void gerarGraficoProcMedico ()
    {
        JRViewer jrv = RelAtendCreator.getGraficoPorProcMedico(txtDataInicial.getDate(), txtDataFinal.getDate());
        if (jrv != null)
        {
            JFrameRelatorios frame = new JFrameRelatorios(this.getTitle() + " por Procedimentos Médicos");
            frame.add(jrv);
            frame.setVisible(true);
        }
    }

    private void gerarGraficoProfExecutante ()
    {
        JRViewer jrv = RelAtendCreator.getGraficoPorProfExecutante(txtDataInicial.getDate(), txtDataFinal.getDate());
        if (jrv != null)
        {
            JFrameRelatorios frame = new JFrameRelatorios(this.getTitle() + " por Profissionais Executantes");
            frame.add(jrv);
            frame.setVisible(true);
        }
    }

    private void gerarGraficoProfSolicitante ()
    {
        JRViewer jrv = RelAtendCreator.getGraficoPorProfSolicitante(txtDataInicial.getDate(), txtDataFinal.getDate());
        if (jrv != null)
        {
            JFrameRelatorios frame = new JFrameRelatorios(this.getTitle() + " por Profissionais Solicitantes");
            frame.add(jrv);
            frame.setVisible(true);
        }
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
    private LblNegrito lblExplicacao1 = new LblNegrito();
    private LblNegrito lblExplicacao2 = new LblNegrito();
    private TxtData txtDataInicial = new TxtData();
    private TxtData txtDataFinal = new TxtData();
    private MyJComboBox<String> cboGrafico;
    private MyJPanel pnlButtons = new MyJPanel();
    private MyJButton btnGerarPdf = new MyJButton();
    private MyJButton btnGerarGraf = new MyJButton();
    private MyJButton btnCancelar = new MyJButton();
    //</editor-fold>

    //Configurações dos Components
    {
        pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
        add(pnlPrincipal);

        lblExplicacao1.setText(" Escolha o período de datas de atendimento e o tipo de gráfico");
        lblExplicacao2.setText(" para gerar seu gráfico.");
        cboGrafico = new MyJComboBox<>(new String[]
                {
                    "por Convênio",
                    "por Procedimento Médico",
                    "por Profissional Executante",
                    "por Profissional Solicitante"
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
        btnGerarGraf.setText("Gerar Gráfico");
        btnGerarGraf.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnGerarGraf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnGerarGrafAction();
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
