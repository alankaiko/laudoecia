/*
 * DlgProcDoAtd.java
 *
 * Created on 21/05/2012, 11:47:00
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProcMedico;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfExecutante;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.java.utils.DateUtils;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtDinheiro;
import com.lib.swing.utils.EnterEnviaTab;
import com.lib.swing.utils.SwingUtils;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.Date;
import java.util.List;
import javax.swing.Box;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgProcDoAtd extends MyJDialog
{
    private static DlgProcDoAtd instance;
    private BuscadorDeProcMedico buscadorProcedimento = new BuscadorDeProcMedico();
    private BuscadorDeProfExecutante buscadorProfExe = new BuscadorDeProfExecutante();
    private Convenio convenio;
    private ProcDaTabela procDaTabela = null;
    private double valorConvenio = 0.0;
    private boolean cancelado = true;

    public static DlgProcDoAtd getInstance (Convenio conv)
    {
        if (instance == null)
        {
            instance = new DlgProcDoAtd(FormPrincipal.getInstance());
        }
        instance.prepararParaNovaInstancia(conv);
        return instance;
    }

    private DlgProcDoAtd (Component cp)
    {
        super(cp, true, 420, 240);
        initializeComponents();
    }

    private void prepararParaNovaInstancia (Convenio conv)
    {
        convenio = conv;
        buscadorProcedimento.setSelectedModel(null);
        buscadorProfExe.setSelectedModel(null);
        txtProcedimento.setEditable(true);
        btnProc.setEnabled(true);
        txtPrevEntrega.setText("");
        txtDataExecucao.setText("");
        txtVlrPaciente.setText(0d);
    }

    private void initializeComponents()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridwidth = 3;
        pnl.add(new PnlComp("Procedimento médico", false, false).setComponent(txtProcedimento), c);

        c.gridx = 3;
        c.gridwidth = 1;
        pnl.add(new PnlComp("", true, false).setComponent(btnProc), c);

        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        pnl.add(new PnlComp("Profissional executante", false, true).setComponent(txtProfExe), c);

        c.gridx = 3;
        c.gridwidth = 1;
        pnl.add(new PnlComp("", true, true).setComponent(btnExec), c);

        c.gridy = 2;
        c.gridx = 0;
        pnl.add(new PnlComp("Data execução", false, true).setComponent(txtDataExecucao), c);
        c.gridx = 1;
        pnl.add(new PnlComp("Prev. entrega laudo", true, true).setComponent(txtPrevEntrega), c);
        c.gridx = 2;
        c.gridwidth = 2;
        pnl.add(new PnlComp("Valor paciente", true, true).setComponent(txtVlrPaciente), c);

        MyJPanel pnlBotoes = new MyJPanel(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;

        c2.weighty = 0.25d;
        c2.gridwidth = 4;
        pnlBotoes.add(Box.createVerticalStrut(0), c2);
        c2.weightx = 0.25d;
        c2.gridy = 1;
        c2.weighty = 0.5d;
        c2.gridwidth = 1;
        pnlBotoes.add(Box.createHorizontalStrut(0), c2);
        c2.gridx = 1;
        pnlBotoes.add(btnConfirmar, c2);
        c2.gridx = 2;
        c2.insets.left = 5;
        pnlBotoes.add(btnCancelar, c2);
        c2.insets.left = 0;
        c2.gridx = 3;
        pnlBotoes.add(Box.createHorizontalStrut(0), c2);
        c2.gridx = 0;
        c2.gridy = 2;
        c2.weightx = 0;
        c2.gridwidth = 4;
        c2.weighty = 0.25d;
        pnlBotoes.add(Box.createVerticalStrut(0), c2);

        c.gridy = 3;
        c.weighty = 1;
        c.gridwidth = 4;
        c.gridx = 0;
        pnl.add(pnlBotoes, c);

        c.weighty = 0;
        c.gridy = 4;
        c.gridx = 0;
        c.gridwidth = 1;
        c.weightx = 0.333333333333333f;
        pnl.add(Box.createHorizontalStrut(0), c);
        c.gridx = 1;
        pnl.add(Box.createHorizontalStrut(0), c);
        c.gridx = 2;
        pnl.add(Box.createHorizontalStrut(0), c);

        add(new PnlComEspaco(pnl));

    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private final TxtComAutoCompletar txtProcedimento = new TxtComAutoCompletar(buscadorProcedimento);
    private BtnFKey btnProc = new BtnFKey();
    private TxtComAutoCompletar txtProfExe = new TxtComAutoCompletar(buscadorProfExe);
    private BtnFKey btnExec = new BtnFKey();
    private TxtData txtPrevEntrega = new TxtData();
    private TxtData txtDataExecucao = new TxtData();
    private TxtDinheiro txtVlrPaciente = new TxtDinheiro();
    private MyJButton btnConfirmar = new MyJButton("Confirmar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");

    {
        KeyListener kl = new EnterEnviaTab(false);

        txtPrevEntrega.addKeyListener(kl);

        txtDataExecucao.addKeyListener(kl);
        txtDataExecucao.addFocusListener(new FocusAdapter() {
            private Date oldValue;

            @Override
            public void focusGained (FocusEvent e)
            {
                oldValue = txtDataExecucao.getDate();
            }

            @Override
            public void focusLost (FocusEvent e)
            {
                if (txtDataExecucao.getDate() != oldValue)
                {
                    sugerirPrevisaoEntrega(txtDataExecucao.getDate());
                }
            }
        });

        txtVlrPaciente.addKeyListener(kl);
        txtVlrPaciente.setText(0.0);

        txtProcedimento.addKeyListener(kl);
        txtProcedimento.setStrictMatching(true);
        txtProcedimento.setMensagemDeErro("Procedimento não encontrado");
        txtProcedimento.addAutoCompletarListener(new AutoCompletarListener() {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                procedimentoMudouAction();
            }
        });
        txtProcedimento.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained (FocusEvent e)
            {
                txtProcedimento.selectAll();
            }
        });
        txtProcedimento.setLargura(1.5d);

        btnProc.setFocusable(false);
        btnProc.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_PROC_MEDICO, new TelaSolPadrao(
                TelaPrincipal.TELA_NULL, txtProcedimento,
                new ReceptorDeBusca()
                {
                    @Override
                    public boolean isHabilitadoParaReceber ()
                    {
                        return txtProcedimento.isEditable();
                    }

                    @Override
                    public void receberBusca (Object o)
                    {
                        if (o != null && o instanceof ProcMedico)
                        {
                            txtProfExe.requestFocusInWindow();
                            buscadorProcedimento.setSelectedModel((ProcMedico)o);
                            java.awt.EventQueue.invokeLater(new Runnable()
                            {
                                @Override
                                public void run ()
                                {
                                    txtProcedimento.requestFocusInWindow();
                                }

                            });
                        }
                    }

                })));

        txtProfExe.addKeyListener(kl);
        txtProfExe.setStrictMatching(true);
        txtProfExe.setMensagemDeErro("Profissional não encontrado");
        txtProfExe.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained (FocusEvent e)
            {
                txtProfExe.selectAll();
            }
        });

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
                            txtProcedimento.requestFocusInWindow();
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

        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction();
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

    private void btnConfirmarAction ()
    {
        if (validarCampos())
        {
            cancelado = false;
            dispose();
        }
    }

    @Override
    public void fechar ()
    {
        cancelado = true;
        dispose();
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and setters">

    public ProcDaTabela getProcDaTabela ()
    {
        return procDaTabela;
    }

    public ProfExecutante getProfExecutante ()
    {
        return buscadorProfExe.getSelectedModel();
    }

    public Date getDataExecucao ()
    {
        return txtDataExecucao.getDate();
    }

    public Date getPrevEntregaLaudo ()
    {
        return txtPrevEntrega.getDate();
    }

    public double getValorPaciente ()
    {
        return txtVlrPaciente.getDouble();
    }

    public double getValorConvenio ()
    {
        return valorConvenio;
    }

    public void setProcDaTabela (ProcDaTabela procDaTabela)
    {
        ProcMedico procMedico = procDaTabela ==
                                null ? null : procDaTabela.getProcMedico();
        buscadorProcedimento.setSelectedModel(procMedico);
    }

    public void setProfExecutante (ProfExecutante profExecutante)
    {
        buscadorProfExe.setSelectedModel(profExecutante);
    }

    public void setDataExecucao (Date dataDaExecucao)
    {
        txtDataExecucao.setText(dataDaExecucao);
    }

    public void setPrevEntregaLaudo (Date prevEntregaLaudo)
    {
        txtPrevEntrega.setText(prevEntregaLaudo);
    }

    public void setValorPaciente (double valor)
    {
        txtVlrPaciente.setText(valor);
    }

    //</editor-fold>

    private boolean validarCampos ()
    {
        if (getProcDaTabela() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve selecionar um procedimento.");
            return false;
        }
        if (getDataExecucao() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve preencher a data de execução.");
            return false;
        }
        if (getPrevEntregaLaudo() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve preencher a data de previsão de entrega do laudo.");
            return false;
        }
        return true;
    }

    private void procedimentoMudouAction()
    {
        procDaTabela = null;
        valorConvenio = 0.0;
        txtVlrPaciente.setText(0.0);
        ProcMedico procMedico = buscadorProcedimento.getSelectedModel();
        if (procMedico != null)
        {
            List<ProcDaTabela> listaProc = procMedico.getProcDaTabela();
            for (int i = 0; i < listaProc.size(); i++)
            {
                ProcDaTabela p = listaProc.get(i);
                if (p.getTabelaDeProcedimentos().getConvenio().equals(convenio))
                {
                    procDaTabela = p;
                    break;
                }
            }
            if (procDaTabela == null)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Procedimento não realizado pelo convênio " + convenio.getNome());
                buscadorProcedimento.setSelectedModel(null);
            }
            else
            {
                txtVlrPaciente.setText(procDaTabela.getValorPaciente().doubleValue());
                valorConvenio = procDaTabela.getValorPagoPeloConvenio().doubleValue();
                if (txtDataExecucao.getDate() == null)
                {
                    txtDataExecucao.setText(new Date());
                }
                sugerirPrevisaoEntrega(txtDataExecucao.getDate());
            }
        }
    }

    private void sugerirPrevisaoEntrega(Date dtExec)
    {
        ProcMedico proc = buscadorProcedimento.getSelectedModel();
        if (dtExec != null && proc != null)
        {
            int dias = proc.getDiasParaEntregaDoLaudo();
            Date previsao = DateUtils.adicionarDiasNaData(dtExec, dias);
            txtPrevEntrega.setText(previsao);
        }
    }

}
