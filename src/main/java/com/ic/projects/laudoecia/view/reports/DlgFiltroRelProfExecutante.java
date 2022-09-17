/*
 * DlgFiltroRelAtendPorConvenio.java
 *
 * Created on 02/03/2012, 09:45:13
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoProfExecutante;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import net.sf.jasperreports.swing.JRViewer;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgFiltroRelProfExecutante extends MyJDialog
{
    private C_ImpressaoProfExecutante c_Imp = new C_ImpressaoProfExecutante();

    public DlgFiltroRelProfExecutante (Component cp)
    {
        super(cp, false, 440, 230);
        setTitle("Relatório de Profissionais Executantes");
        initComponents();
    }

    private void initComponents ()
    {

        pnlPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0;
        c.gridwidth = 2;
        pnlPrincipal.add(lblExplicacao1, c);
        c.gridy = 1;
        pnlPrincipal.add(lblExplicacao2, c);
        c.gridy = 2;
        pnlPrincipal.add(Box.createVerticalStrut(20), c);
        c.gridy = 3;
        c.gridwidth = 1;
        c.weightx = 0.3;
        pnlPrincipal.add(new PnlComp("UF conselho", false, true).setComponent(cmbUfConselho), c);
        c.gridx = 1;
        c.weightx = 0.7;
        pnlPrincipal.add(new PnlComp("Conselho", false, true).setComponent(cmbConselho), c);
        c.weightx = 0;
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 2;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarRel);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);
    }

    private void btnGerarPdfAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        UF uf = cmbUfConselho.getSelectedItem();
        TISS_Conselho conselho =  cmbConselho.getSelectedItem();

        if (!RelCadastrosCreator.exportToPDF(TelaPrincipal.REL_PROF_EXEC, c_Imp.getLista(uf, conselho)))
        {
            SwingUtils.mostrarMsgDeInformacao(this, "Não há dados a serem mostrados!");
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarRelAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        UF uf = cmbUfConselho.getSelectedItem();
        TISS_Conselho conselho =  cmbConselho.getSelectedItem();
        JRViewer jrv = RelCadastrosCreator.getRelatorio(TelaPrincipal.REL_PROF_EXEC, c_Imp.getLista(uf, conselho));
        if (jrv != null)
        {
            JFrameRelatorios frame = new JFrameRelatorios(this.getTitle());
            frame.add(jrv);
            frame.setVisible(true);
        }
        else
        {
            SwingUtils.mostrarMsgDeInformacao(this, "Não há dados a serem mostrados!");
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
    private MyJComboBox<TISS_Conselho> cmbConselho = new MyJComboBox<>(StaticInfo.getTiss_Conselhos());
    private MyJComboBox<UF> cmbUfConselho = new MyJComboBox<>(StaticInfo.getUfs());
    private MyJPanel pnlButtons = new MyJPanel();
    private MyJButton btnGerarPdf = new MyJButton();
    private MyJButton btnGerarRel = new MyJButton();
    private MyJButton btnCancelar = new MyJButton();
    //</editor-fold>

    //Configuração dos Components
    {
        pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
        add(pnlPrincipal);

        lblExplicacao1.setText(" Para gerar o relatório, selecione o estado e/ou o conselho");
        lblExplicacao2.setText(" desejado ou deixe-os em branco para todos.");

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

    }

}
