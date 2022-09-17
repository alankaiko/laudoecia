/*
 * DlgProcDoAtd.java
 *
 * Created on 21/05/2012, 11:47:00
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorCID10;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfExecutante;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.ic.projects.laudoecia.view.print.LaudosHTMLUtils;
import com.ic.projects.laudoecia.view.print.PrintLaudo;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.maskedfields.TxtHora;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.EnterEnviaTab;
import com.lib.swing.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgAtestado extends MyJDialog
{
    private BuscadorDeProfExecutante buscadorProfExe = new BuscadorDeProfExecutante();
    private BuscadorCID10 buscadorCID10 = new BuscadorCID10();
    private Paciente paciente = null;
    private Date dataRef = null;
    private PrintLaudo printer = new PrintLaudo();

    public DlgAtestado (Component cp, Paciente pac, Date data)
    {
        super(cp, true, 420, 320);
        setTitle(" Imprimir atestado...");
        if (pac == null || data == null)
        {
            SwingUtils.mostrarAviso(cp, "Paciente e data devem ser preenchidos.");
        }
        else
        {
            paciente = pac;
            dataRef = data;
            initializeComponents();
        }
    }

    private void initializeComponents()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        pnl.add(new PnlComp(false, false, false).setComponent(chkPaciente), c);

        c.gridy = 1;
        c.gridwidth = 5;
        pnl.add(new PnlComp(false, false, true).setComponent(txtPaciente), c);

        c.gridy = 2;
        c.gridwidth = 1;
        pnl.add(new PnlComp(false, false, true).setComponent(chkAcompanhante), c);

        c.gridy = 3;
        c.gridwidth = 5;
        pnl.add(new PnlComp(false, false, true).setComponent(txtAcompanhante), c);

        c.gridy = 4;
        c.gridwidth = 1;
        pnl.add(new PnlComp("Data", false, true).setComponent(txtDataRef), c);

        c.gridx = 1;
        c.weightx = 0.5;
        pnl.add(Box.createHorizontalStrut(0), c);

        MyJPanel pnlHora = new MyJPanel(new GridLayout(1, 5));
        pnlHora.add(txtHoraDe);
        pnlHora.add(new LblNegrito("às", SwingConstants.CENTER));
        pnlHora.add(txtHoraAte);
        pnlHora.add(new LblNegrito("  horas  ", SwingConstants.CENTER));

        c.gridx = 2;
        c.weightx = 0;
        pnl.add(new PnlComp("Intervalo", false, true).setComponent(pnlHora), c);

        c.gridx = 3;
        c.weightx = 0.5;
        pnl.add(Box.createHorizontalStrut(0), c);

        c.gridy = 5;
        c.gridx = 0;
        c.weightx = 0;
        c.gridwidth = 4;
        pnl.add(new PnlComp("Prof. executante", false, true).setComponent(txtProfExe), c);

        c.gridx = 4;
        c.gridwidth = 1;
        pnl.add(new PnlComp("", true, true).setComponent(btnExec), c);

        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 4;
        pnl.add(new PnlComp("CID 10", false, true).setComponent(txtCid), c);

        c.gridx = 4;
        c.gridwidth = 1;
        pnl.add(new PnlComp("", true, true).setComponent(btnCid), c);

        c.gridy = 7;
        c.gridwidth = 5;
        c.gridx = 0;
        MyJPanel pnlBotoes = new MyJPanel(new FlowLayout(FlowLayout.TRAILING));
        pnlBotoes.add(btnConfirmar);
        pnlBotoes.add(btnGerarPDF);
        pnlBotoes.add(btnCancelar);
        pnl.add(pnlBotoes, c);

        setContentPane(new PnlComEspaco(pnl));

        txtPaciente.setText(paciente.getNome());
        txtDataRef.setText(dataRef);
        txtHoraDe.setText("0800");
        txtHoraAte.setText("1800");

    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private MyJCheckBox chkPaciente = new MyJCheckBox("Paciente");
    private MyJCheckBox chkAcompanhante = new MyJCheckBox("Acompanhante");
    private MyJTextField txtPaciente = new MyJTextField();
    private MyJTextField txtAcompanhante = new MyJTextField();
    private TxtData txtDataRef = new TxtData();
    private TxtHora txtHoraDe = new TxtHora();
    private TxtHora txtHoraAte = new TxtHora();
    private TxtComAutoCompletar txtProfExe = new TxtComAutoCompletar(buscadorProfExe);
    private TxtComAutoCompletar txtCid = new TxtComAutoCompletar(buscadorCID10);
    private BtnFKey btnExec = new BtnFKey();
    private BtnFKey btnCid = new BtnFKey();
    private MyJButton btnConfirmar = new MyJButton("Imprimir");
    private MyJButton btnGerarPDF = new MyJButton("Gerar PDF");
    private MyJButton btnCancelar = new MyJButton("Cancelar");

    {
        KeyListener kl = new EnterEnviaTab(false);

        chkPaciente.setSelected(true);
        chkPaciente.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                txtPaciente.setEnabled(chkPaciente.isSelected());
                txtPaciente.requestFocusInWindow();
            }
        });

        chkAcompanhante.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                txtAcompanhante.setEnabled(chkAcompanhante.isSelected());
                txtAcompanhante.requestFocusInWindow();
            }
        });

        txtPaciente.setEditable(false);
        txtAcompanhante.setEnabled(false);
        txtAcompanhante.addKeyListener(kl);
        txtDataRef.addKeyListener(kl);

        txtHoraDe.addKeyListener(kl);
        txtHoraAte.addKeyListener(kl);

        txtProfExe.addKeyListener(kl);
        txtProfExe.setStrictMatching(true);
        txtProfExe.setMensagemDeErro("Profissional não encontrado");

        txtCid.addKeyListener(kl);
        txtCid.setStrictMatching(true);
        txtCid.setMensagemDeErro("CID não encontrado");

        btnExec.setFocusable(false);
        btnExec.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_EXECUTANTES, new TelaSolPadrao(
                TelaPrincipal.TELA_NULL, txtProfExe,
                new ReceptorDeBusca() {
                    @Override
                    public boolean isHabilitadoParaReceber ()
                    {
                        return true;
                    }

                    @Override
                    public void receberBusca (Object o)
                    {
                        if (o != null && o instanceof ProfExecutante)
                        {
                            buscadorProfExe.setSelectedModel((ProfExecutante)o);
                            java.awt.EventQueue.invokeLater(new Runnable()
                            {
                                @Override
                                public void run ()
                                {
                                    txtProfExe.requestFocusInWindow();
                                }

                            });
                        }
                    }

                })));

        btnCid.setFocusable(false);
        btnCid.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_CID10, new TelaSolPadrao(
                TelaPrincipal.TELA_NULL, txtCid,
                new ReceptorDeBusca() {
                    @Override
                    public boolean isHabilitadoParaReceber ()
                    {
                        return true;
                    }

                    @Override
                    public void receberBusca (Object o)
                    {
                        if (o != null && o instanceof SubcategoriaCID10)
                        {
                            buscadorCID10.setSelectedModel((SubcategoriaCID10)o);
                            java.awt.EventQueue.invokeLater(new Runnable()
                            {
                                @Override
                                public void run ()
                                {
                                    txtCid.requestFocusInWindow();
                                }

                            });
                        }
                    }

                })));

        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.IMPRESSORA));
        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction(false);
            }

        });

        btnGerarPDF.setIcon(SwingLibResources.getIcon(Imagens.PDF_FILE));
        btnGerarPDF.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction(true);
            }

        });

        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                fechar();
            }

        });

    }

    //</editor-fold>

    private void btnConfirmarAction (boolean pdf)
    {
        if (validarCampos())
        {
            LaudosHTMLUtils.setPagination(false);
            String html = "";
            LaudosHTMLUtils.setProcDoAtd(null);
            if (chkPaciente.isSelected())
            {
                html += LaudosHTMLUtils.createTabelaPagina(
                        LaudosHTMLUtils.createHtmlAtestadoPac(txtPaciente.getText(),
                          txtDataRef.getText(), txtHoraDe.getText(),
                          txtHoraAte.getText(), buscadorProfExe.getSelectedModel(),
                        buscadorCID10.getSelectedModel()), 1, true, 5, false);
            }
            if (chkAcompanhante.isSelected())
            {
                html += LaudosHTMLUtils.createTabelaPagina(
                LaudosHTMLUtils.createHtmlAtestadoAcomp(txtPaciente.getText(),
                       txtAcompanhante.getText(), txtDataRef.getText(),
                       txtHoraDe.getText(), txtHoraAte.getText(),
                       buscadorProfExe.getSelectedModel(),
                        buscadorCID10.getSelectedModel()), 1, true, 5, false);
            }
            if (pdf)
            {
                printer.gerarPDFAtestado(html);
            }
            else
            {
                printer.printAtestado(html);
            }
            LaudosHTMLUtils.setPagination(true);
            dispose();
        }
    }

    @Override
    public void fechar ()
    {
        dispose();
    }

    private boolean validarCampos ()
    {
        if (!(chkPaciente.isSelected() || chkAcompanhante.isSelected()))
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "O atestado deve ser para o paciente, o acompanhante"
                    + " ou ambos!!");
            return false;
        }
        if (chkAcompanhante.isSelected() && txtAcompanhante.getText().isEmpty())
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve preencher o nome do acompanhante.");
            return false;
        }
        if (txtDataRef.getDate() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve preencher uma data de referência.");
            return false;
        }
        if (txtHoraDe.getDate() == null || txtHoraAte.getDate() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve preencher o período corretamente.");
            return false;
        }
        if (buscadorProfExe.getSelectedModel() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve selecionar um profissional.");
            return false;
        }
        return true;
    }

}
