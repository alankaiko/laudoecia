/*
 * DlgBackupAutomatico.java
 *
 * Created on 11/04/2012, 16:14:27
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.lib.model.abstracao.DIA_DA_SEMANA;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtHora;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgBackupAutomatico extends MyJDialog
{
    private boolean cancelado = true;

    public DlgBackupAutomatico (Component cp)
    {
        super(cp, true, 510, 420);
        setTitle("Adicionar Configurações de Backups Automáticos");
        initComponents();
    }

    private void initComponents ()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridy = 0;
        c.gridx = 0;
        pnl.add(rdbDiariamente, c);
        c.gridx = 1;
        pnl.add(lblHorario, c);
        c.gridx = 2;
        pnl.add(lblTipo, c);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        pnl.add(pnlDiariamente, c);

        c.gridy = 2;
        c.gridwidth = 1;
        pnl.add(rdbPersonalizado, c);
        c.gridy = 3;
        c.gridwidth = 3;
        pnl.add(pnlDomingo, c);
        c.gridy = 4;
        pnl.add(pnlSegunda, c);
        c.gridy = 5;
        pnl.add(pnlTerca, c);
        c.gridy = 6;
        pnl.add(pnlQuarta, c);
        c.gridy = 7;
        pnl.add(pnlQuinta, c);
        c.gridy = 8;
        pnl.add(pnlSexta, c);
        c.gridy = 9;
        pnl.add(pnlSabado, c);

        c.gridy = 10;
        c.gridwidth = 1;
        c.gridx = 0;
        pnl.add(Box.createHorizontalStrut(150), c);
        c.gridx = 1;
        pnl.add(Box.createHorizontalStrut(90), c);
        c.gridx = 2;
        pnl.add(Box.createHorizontalStrut(230), c);

        c.gridy = 11;
        c.gridx = 0;
        c.gridwidth = 3;
        pnl.add(new PnlComp(false, false).setComponent(pnlAviso), c);

        MyJPanel pnlBotoes = new MyJPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlBotoes.add(btnConfirmar);
        pnlBotoes.add(btnCancelar);
        c.gridy = 12;
        pnl.add(pnlBotoes, c);
        c.gridy = 13;
        pnl.add(Box.createVerticalStrut(5), c);

        setLayout(new BorderLayout());
        add(pnl, BorderLayout.CENTER);
    }

    public List<Object[]> getLinhas ()
    {
        List<Object[]> linhas = new ArrayList<>();
        if (rdbDiariamente.isSelected())
        {
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.DOMINGO));
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.SEGUNDA));
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.TERCA));
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.QUARTA));
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.QUINTA));
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.SEXTA));
            linhas.add(pnlDiariamente.montaLinha(DIA_DA_SEMANA.SABADO));
        }
        else
        {
            if (pnlDomingo.isEnabled())
            {
                linhas.add(pnlDomingo.montaLinha(DIA_DA_SEMANA.DOMINGO));
            }
            if (pnlSegunda.isEnabled())
            {
                linhas.add(pnlSegunda.montaLinha(DIA_DA_SEMANA.SEGUNDA));
            }
            if (pnlTerca.isEnabled())
            {
                linhas.add(pnlTerca.montaLinha(DIA_DA_SEMANA.TERCA));
            }
            if (pnlQuarta.isEnabled())
            {
                linhas.add(pnlQuarta.montaLinha(DIA_DA_SEMANA.QUARTA));
            }
            if (pnlQuinta.isEnabled())
            {
                linhas.add(pnlQuinta.montaLinha(DIA_DA_SEMANA.QUINTA));
            }
            if (pnlSexta.isEnabled())
            {
                linhas.add(pnlSexta.montaLinha(DIA_DA_SEMANA.SEXTA));
            }
            if (pnlSabado.isEnabled())
            {
                linhas.add(pnlSabado.montaLinha(DIA_DA_SEMANA.SABADO));
            }
        }

        return linhas;
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    private void btnConfirmarAction ()
    {
        if (validarCampos())
        {
            cancelado = false;
            dispose();
        }
    }

    private boolean validarCampos ()
    {
        if (rdbDiariamente.isSelected())
        {
            return pnlDiariamente.validarCampos();
        }
        else
        {
            boolean valid = true;
            boolean temSelecionado = false;
            if (pnlDomingo.isEnabled() && valid)
            {
                valid = pnlDomingo.validarCampos();
                temSelecionado = true;
            }
            if (pnlSegunda.isEnabled() && valid)
            {
                valid = pnlSegunda.validarCampos();
                temSelecionado = true;
            }
            if (pnlTerca.isEnabled() && valid)
            {
                valid = pnlTerca.validarCampos();
                temSelecionado = true;
            }
            if (pnlQuarta.isEnabled() && valid)
            {
                valid = pnlQuarta.validarCampos();
                temSelecionado = true;
            }
            if (pnlQuinta.isEnabled() && valid)
            {
                valid = pnlQuinta.validarCampos();
                temSelecionado = true;
            }
            if (pnlSexta.isEnabled() && valid)
            {
                valid = pnlSexta.validarCampos();
                temSelecionado = true;
            }
            if (pnlSabado.isEnabled() && valid)
            {
                valid = pnlSabado.validarCampos();
                temSelecionado = true;
            }
            if (!temSelecionado)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this, "Você deve selecionar pelo menos um dia.");
                return false;
            }
            return valid;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes do Form">

    private ButtonGroup btgAdicionar = new ButtonGroup();
    private MyJRadioButton rdbDiariamente = new MyJRadioButton("Diariamente");
    private MyJRadioButton rdbPersonalizado = new MyJRadioButton("Personalizado");
    private LblNegrito lblHorario = new LblNegrito("Horário");
    private LblNegrito lblTipo = new LblNegrito("Tipo de Backup");
    private MyJPanel pnlAviso = new MyJPanel();
    private MyJLabel lblAviso = new MyJLabel();

    private PnlDiaSemana pnlDiariamente = new PnlDiaSemana();
    private PnlDiaSemana pnlDomingo = new PnlDiaSemana("Domingo");
    private PnlDiaSemana pnlSegunda = new PnlDiaSemana("Segunda-Feira");
    private PnlDiaSemana pnlTerca = new PnlDiaSemana("Terça-Feira");
    private PnlDiaSemana pnlQuarta = new PnlDiaSemana("Quarta-Feira");
    private PnlDiaSemana pnlQuinta = new PnlDiaSemana("Quinta-Feira");
    private PnlDiaSemana pnlSexta = new PnlDiaSemana("Sexta-Feira");
    private PnlDiaSemana pnlSabado = new PnlDiaSemana("Sábado");

    private MyJButton btnConfirmar = new MyJButton("Confirmar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");

    private void setDiariamenteEnabled (boolean enabled)
    {
        pnlDiariamente.setEnabled(enabled);

        pnlDomingo.setEnabled(!enabled);
        pnlSegunda.setEnabled(!enabled);
        pnlTerca.setEnabled(!enabled);
        pnlQuarta.setEnabled(!enabled);
        pnlQuinta.setEnabled(!enabled);
        pnlSexta.setEnabled(!enabled);
        pnlSabado.setEnabled(!enabled);
    }

    {
        btgAdicionar.add(rdbDiariamente);
        btgAdicionar.add(rdbPersonalizado);
        rdbDiariamente.setSelected(true);
        rdbDiariamente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                setDiariamenteEnabled(rdbDiariamente.isSelected());
            }
        });
        rdbPersonalizado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                setDiariamenteEnabled(!rdbPersonalizado.isSelected());
            }
        });
        setDiariamenteEnabled(true);

        pnlAviso.setBackground(new Color(255, 255, 204));
        pnlAviso.setBorder(new LineBorder(new Color(255, 204, 102)));
        pnlAviso.setLayout(new CardLayout(5, 5));
        pnlAviso.add(lblAviso);
        lblAviso.setText("<html><font size=\"2\"><b>Atenção!</b> <BR>- O backup \"Apenas Dados\" é um processo mais rápido, porém não contem as imagens do sistema.<BR>- Fazer backup de \"Dados e Imagens\" pode ser um processo mais demorado, porém é mais seguro.</font></html>");

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
    }

    //</editor-fold>

    @Override
    public void fechar ()
    {
        cancelado = true;
        dispose();
    }

    private class PnlDiaSemana extends MyJPanel
    {
        private String strTipoDados = "Apenas Dados";
        private String strTipoDadosImg = "Dados e Imagens";
        private MyJCheckBox ckbDia;
        private TxtHora txtHoraDia = new TxtHora();
        private ButtonGroup btgTipoDia = new ButtonGroup();
        private MyJRadioButton rdbTipoDiaDados = new MyJRadioButton(strTipoDados);
        private MyJRadioButton rdbTipoDiaDadosImagens = new MyJRadioButton(strTipoDadosImg);
        private boolean showCheckBox = true;

        private PnlDiaSemana ()
        {
            this(null);
        }

        private PnlDiaSemana (String diaSemana)
        {
            if (diaSemana == null)
            {
                showCheckBox = false;
            }
            else
            {
                ckbDia = new MyJCheckBox(diaSemana);
                ckbDia.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed (ActionEvent e)
                    {
                        enableConfig(ckbDia.isSelected());
                        txtHoraDia.requestFocusInWindow();
                    }

                });
            }
            btgTipoDia.add(rdbTipoDiaDados);
            btgTipoDia.add(rdbTipoDiaDadosImagens);
            rdbTipoDiaDadosImagens.setSelected(true);
            montarPainel();
        }

        private void montarPainel ()
        {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.weightx = 1;

            c.gridy = 0;
            c.gridx = 0;
            add(new CampoDaEnt(false, true, false).setComponent(showCheckBox ? ckbDia : Box.createHorizontalStrut(5)), c);
            c.gridx = 1;
            add(new CampoDaEnt(false, true, false).setComponent(txtHoraDia), c);
            c.gridx = 3;
            add(new CampoDaEnt(false, true, false).setComponent(rdbTipoDiaDados), c);
            c.gridx = 4;
            add(new CampoDaEnt(false, true, false).setComponent(rdbTipoDiaDadosImagens), c);

            c.gridy = 0;
            c.gridx = 0;
            add(Box.createHorizontalStrut(140), c);
            c.gridx = 1;
            add(Box.createHorizontalStrut(70), c);
            c.gridx = 2;
            add(Box.createHorizontalStrut(20), c);
            c.gridx = 3;
            add(Box.createHorizontalStrut(80), c);
            c.gridx = 3;
            add(Box.createHorizontalStrut(110), c);
        }

        private void enableConfig (boolean enable)
        {
            if (enable)
            {
                txtHoraDia.setEnabled(true);
                rdbTipoDiaDados.setEnabled(true);
                rdbTipoDiaDadosImagens.setEnabled(true);
            }
            else
            {
                txtHoraDia.setEnabled(false);
                rdbTipoDiaDados.setEnabled(false);
                rdbTipoDiaDadosImagens.setEnabled(false);
            }
        }

        @Override
        public void setEnabled (boolean enabled)
        {
            super.setEnabled(enabled);
            if (showCheckBox)
            {
                if (enabled)
                {
                    ckbDia.setEnabled(true);
                }
                else
                {
                    ckbDia.setSelected(false);
                    ckbDia.setEnabled(false);
                    enableConfig(false);
                }
            }
            else
            {
                enableConfig(enabled);
            }

        }

        @Override
        public boolean isEnabled ()
        {
            if (super.isEnabled())
            {
                if (showCheckBox)
                {
                    return ckbDia.isSelected();
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }

        }

        public Object[] montaLinha(DIA_DA_SEMANA dia)
        {
            Object[] linha = new Object[5];
            linha[0] = 0;
            linha[1] = dia.getPorNumero();
            linha[2] = dia;
            linha[3] = txtHoraDia.getDate();
            linha[4] = rdbTipoDiaDados.isSelected() ? TIPO_BACKUP.DADOS : TIPO_BACKUP.DADOS_E_IMAGENS;
            return linha;
        }

        private boolean validarCampos ()
        {
            if (txtHoraDia.getDate() == null)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(null, "Você deve escolher o horário");
                return false;
            }
            return true;
        }

    }

}
