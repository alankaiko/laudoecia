/*
 * DlgFiltroRelAtendPorProfSolicitante.java
 *
 * Created on 05/03/2012, 08:24:10
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfSolicitante;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.lib.java.utils.DateUtils;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
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
public class DlgFiltroRelAtendPorProfSolicitante extends MyJDialog
{
    private BuscadorDeProfSolicitante buscProfSol = new BuscadorDeProfSolicitante();

    public DlgFiltroRelAtendPorProfSolicitante (Component cp)
    {
        super(cp, false, 450, 260);
        setTitle("Relatório de Atendimentos Por Profissional Solicitante");
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
        pnlPrincipal.add(new PnlComp("Profissional Solicitante", false, true).setComponent(txtProfSol), c);
        c.gridy = 5;
        c.gridx = 0;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarRel);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);

        c.gridy = 6; //tamanhos
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
        ProfSolicitante profSol = buscProfSol.getSelectedModel();
        if (ckbSoResumos.isSelected())
        {
            RelAtendCreator.exportPdfRelatorioSoResumosPorProfSolicitante(profSol, txtDataInicial.getDate(), txtDataFinal.getDate());
        }
        else
        {
            RelAtendCreator.exportPdfRelatorioPorProfSolicitante(profSol, txtDataInicial.getDate(), txtDataFinal.getDate(), ckbComResumos.isSelected());
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarRelAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        ProfSolicitante profSol = buscProfSol.getSelectedModel();
        JRViewer jrv;
        if (ckbSoResumos.isSelected())
        {
            jrv = RelAtendCreator.getRelatorioSoResumosPorProfSolicitante(profSol, txtDataInicial.getDate(), txtDataFinal.getDate());
        }
        else
        {
            jrv = RelAtendCreator.getRelatorioPorProfSolicitante(profSol, txtDataInicial.getDate(), txtDataFinal.getDate(), ckbComResumos.isSelected());
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
    private LblNegrito lblExplicacao1 = new LblNegrito();
    private LblNegrito lblExplicacao2 = new LblNegrito();
    private TxtData txtDataInicial = new TxtData();
    private TxtData txtDataFinal = new TxtData();
    private MyJCheckBox ckbComResumos = new MyJCheckBox();
    private MyJCheckBox ckbSoResumos = new MyJCheckBox();
    private TxtComAutoCompletar txtProfSol = new TxtComAutoCompletar();
    private MyJPanel pnlButtons = new MyJPanel();
    private MyJButton btnGerarPdf = new MyJButton();
    private MyJButton btnGerarRel = new MyJButton();
    private MyJButton btnCancelar = new MyJButton();
    //</editor-fold>

    {
        pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
        add(pnlPrincipal);

        lblExplicacao1.setText(" Escolha o período de datas de atendimento e selecione um proffisional");
        lblExplicacao2.setText(" solicitante para gerar seu relatório.");
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
        txtProfSol.setControlador(buscProfSol);
        txtProfSol.setLargura(1.3);
    }

}
