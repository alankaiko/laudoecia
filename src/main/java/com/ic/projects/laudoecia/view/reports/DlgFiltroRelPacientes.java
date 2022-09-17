/*
 * DlgFiltroRelAtendPorConvenio.java
 *
 * Created on 02/03/2012, 09:45:13
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeCidade;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoPacientes;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import net.sf.jasperreports.swing.JRViewer;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgFiltroRelPacientes extends MyJDialog
{
    private BuscadorDeCidade buscadorCidade = new BuscadorDeCidade();
    private C_ImpressaoPacientes c_Imp = new C_ImpressaoPacientes();

    public DlgFiltroRelPacientes (Component cp)
    {
        super(cp, false, 440, 300);
        setTitle("Relatório de Pacientes");
        initComponents();
    }

    private void initComponents ()
    {
        pnlPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0;
        c.gridwidth = 3;
        pnlPrincipal.add(lblExplicacao1, c);
        c.gridy = 1;
        pnlPrincipal.add(lblExplicacao2, c);
        c.gridy = 2;
        pnlPrincipal.add(Box.createVerticalStrut(20), c);
        c.gridy = 3;
        c.gridwidth = 2;
        pnlPrincipal.add(new PnlComp("Data Nascimento de", false, true).setComponent(txtDtNascDe), c);
        c.gridx = 2;
        c.gridwidth = 1;
        pnlPrincipal.add(new PnlComp("Data Nascimento até", true, true).setComponent(txtDtNascAte), c);
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 2;
        pnlPrincipal.add(new PnlComp("Data Cadastro de", false, true).setComponent(txtDtCadDe), c);
        c.gridx = 2;
        c.gridwidth = 1;
        pnlPrincipal.add(new PnlComp("Data Cadastro até", true, true).setComponent(txtDtCadAte), c);
        c.gridy = 5;
        c.gridx = 0;
        pnlPrincipal.add(new PnlComp("UF", false, true).setComponent(cmbUf), c);
        c.gridx = 1;
        c.gridwidth = 2;
        pnlPrincipal.add(new PnlComp("Cidade", true, true).setComponent(txtCidade), c);
        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlButtons.add(btnGerarPdf);
        pnlButtons.add(btnGerarRel);
        pnlButtons.add(btnCancelar);
        pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 1;
        c.weightx = 1;
        pnlPrincipal.add(Box.createHorizontalStrut(60), c);
        c.gridx = 1;
        pnlPrincipal.add(Box.createHorizontalStrut(110), c);
        c.gridx = 2;
        pnlPrincipal.add(Box.createHorizontalStrut(180), c);

    }

    private void btnGerarPdfAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Date dtNascDe = txtDtNascDe.getDate();
        Date dtNascAte = txtDtNascAte.getDate();
        Date dtCadDe = txtDtCadDe.getDate();
        Date dtCadAte = txtDtCadAte.getDate();
        UF uf = cmbUf.getSelectedItem();
        String cidade = buscadorCidade.getSelectedModel();

        if (!RelCadastrosCreator.exportToPDF(TelaPrincipal.REL_PACIENTES,
                       c_Imp.getLista(dtNascDe, dtNascAte, uf, cidade, dtCadDe, dtCadAte)))
        {
            SwingUtils.mostrarMsgDeInformacao(this, "Não há dados a serem mostrados!");
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnGerarRelAction ()
    {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Date dtNascDe = txtDtNascDe.getDate();
        Date dtNascAte = txtDtNascAte.getDate();
        Date dtCadDe = txtDtCadDe.getDate();
        Date dtCadAte = txtDtCadAte.getDate();
        UF uf = cmbUf.getSelectedItem();
        String cidade = buscadorCidade.getSelectedModel();
        JRViewer jrv = RelCadastrosCreator.getRelatorio(TelaPrincipal.REL_PACIENTES,
                       c_Imp.getLista(dtNascDe, dtNascAte, uf, cidade, dtCadDe, dtCadAte));
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
    private TxtData txtDtNascDe = new TxtData();
    private TxtData txtDtNascAte = new TxtData();
    private TxtData txtDtCadDe = new TxtData();
    private TxtData txtDtCadAte = new TxtData();
    private MyJComboBox<UF> cmbUf = new MyJComboBox<>(StaticInfo.getUfs());
    private TxtComAutoCompletar txtCidade = new TxtComAutoCompletar(buscadorCidade);
    private MyJPanel pnlButtons = new MyJPanel();
    private MyJButton btnGerarPdf = new MyJButton();
    private MyJButton btnGerarRel = new MyJButton();
    private MyJButton btnCancelar = new MyJButton();
    //</editor-fold>

    //Configuração dos Components
    {
        pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
        add(pnlPrincipal);

        lblExplicacao1.setText(" Para gerar o relatório, utilize os campos abaixo para filtrar ou ");
        lblExplicacao2.setText(" deixe todos os campos em branco para todos.");

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
        txtCidade.setControlador(buscadorCidade);
        cmbUf.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    buscadorCidade.setFiltroUF(cmbUf.getSelectedItem());
                }
            }

        });

    }

}
