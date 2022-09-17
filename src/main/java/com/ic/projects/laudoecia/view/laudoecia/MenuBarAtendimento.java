/*
 * MenuBarAtendimento.java
 *
 * Created on 09/05/2012, 14:26:43
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeAtendimento;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.icontrol.autocompletar.C_AutoCompletar;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.LblNegrito;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class MenuBarAtendimento extends JMenuBar
{

    private BuscadorDeAtendimento buscadorAtd = new BuscadorDeAtendimento();
    private LaudoeCiaMediator mediador;
    private MouseListener mlDaCaptura;

    MenuBarAtendimento (LaudoeCiaMediator mediador)
    {
        this.mediador = mediador;
        mlDaCaptura = new MouseListDaCaptura(mediador);
        new MeuSw().execute();
        setLayout(new CardLayout());
        setBorder(new BlackAndWhiteEtchedBorder());

        JPanel pnl = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        pnl.add(lblAtd, c);
        c.gridx = 1;
        // <editor-fold defaultstate="collapsed" desc="Consideracoes sobre a largura 330">

        // 330 consegue mostrar nomes de até 35 caracteres, em atendimentos
        // que pode ter codigo ate 9999. Nomes com até 35 caracteres
        // representam 95% dos nomes contidos na base de dados crm
        // Na resolucao de 1024 pixels horizontal, com esse tamanho de txt
        // cabem no combobox proc um proc com nome de até 50 caracteres, sempre
        // visivel, ou até 80 caracteres (visivel quando o popup do combobox
        // esta aberto. De qualquer forma, no dialog de informacoes do atd
        // o campo procedimentos possui um combobox horizontal que permite
        // que o nome do procedimento seja visualizado qualquer que seja seu
        // numero de caracteres

        // </editor-fold>
        txtAtd.setPreferredWidth(350);
        pnl.add(txtAtd, c);
        c.gridx = 2;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets.right = 1;
        pnl.add(sep1, c);
        pnl.add(Box.createHorizontalStrut(5), c);
        c.fill = GridBagConstraints.BOTH;
        c.insets.right = 0;
        c.gridx = 3;
        c.weightx = 1;
        ProcMedico pm = new ProcMedico();
        pm.setNome("");
        ProcDaTabela pt = new ProcDaTabela();
        pt.setProcMedico(pm);
        ProcDoAtd pDoAtd = new ProcDoAtd();
        pDoAtd.setProcDaTabela(pt);
        cmbProc.setPrototypeDisplayValue(pDoAtd);
        pnl.add(cmbProc, c);
        c.weightx = 0;
//        c.gridx = 4;
//        pnl.add(btnAnterior, c);
//        c.gridx = 5;
//        pnl.add(btnProximo, c);
        c.gridx = 4;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets.right = 1;
        pnl.add(sep2, c);
        pnl.add(Box.createHorizontalStrut(5), c);
        c.fill = GridBagConstraints.BOTH;
        c.insets.right = 0;
        c.gridx = 5;
        pnl.add(btnVoltar, c);

        LayerUI<JPanel> layerUi = new LayerUI<JPanel>()
        {
            @Override
            protected void processMouseEvent (final MouseEvent e, JLayer<? extends JPanel> l)
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run ()
                    {
                        switch (e.getID())
                        {
                            case MouseEvent.MOUSE_RELEASED:
                                mlDaCaptura.mouseReleased(e);
                                break;
                            case MouseEvent.MOUSE_PRESSED:
                                mlDaCaptura.mousePressed(e);
                                break;
                            default:
                        }
                    }

                });
            }

        };
        JLayer<JPanel> layer = new JLayer<>(pnl, layerUi);
        layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
        add(layer);

        addMouseListener(mlDaCaptura);

    }

    //<editor-fold defaultstate="collapsed" desc="Componentes do menu">

    private LblNegrito lblAtd = new LblNegrito(" Atendimento ");
    private TxtAtd txtAtd = new TxtAtd(buscadorAtd);
    private JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
    private CmbProcDoAtd cmbProc = new CmbProcDoAtd();
    private MyJButton btnAnterior = new MyJButton();
    private MyJButton btnProximo = new MyJButton();
    private JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
    private MyJButton btnVoltar = new MyJButton();

    {
        btnVoltar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                voltar();
            }
        });

        btnAnterior.setToolTipText("Procedimento Anterior");
        btnAnterior.setIcon(SwingLibResources.getIcon(Imagens.ANTERIOR));
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnProcAnterior();
            }
        });

        btnProximo.setToolTipText("Próximo Procedimento");
        btnProximo.setIcon(SwingLibResources.getIcon(Imagens.PROXIMO));
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnProcProximo();
            }
        });

        txtAtd.addAutoCompletarListener(new AutoCompletarListener() {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                atendimentoMudou();
            }
        });
        txtAtd.setLargura(1.7d);
        txtAtd.addFocusListener(new FocusListener() {

            @Override
            public void focusGained (FocusEvent e)
            {
                txtAtd.selectAll();
            }

            @Override
            public void focusLost (FocusEvent e)
            {
                txtAtd.setCaretPosition(0);
            }
        });

        cmbProc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    procedimentoMudou();
                }
            }
        });

    }

    //</editor-fold>

    void setAtendimento (Atendimento entidade)
    {
        buscadorAtd.setSelectedModel(entidade);
    }

    void setProcedimentoSelecionado (ProcDoAtd procDoAtd)
    {
        cmbProc.setSelectedItem(procDoAtd);
    }

    void setProcedimentos (java.util.List<ProcDoAtd> procedimentos)
    {
        cmbProc.setModel(procedimentos);
    }

    void configurarBtnVoltar (boolean sair)
    {
        if (sair)
        {
            btnVoltar.setText(" Sair ");
            btnVoltar.setToolTipText("Sair do módulo de laudo e captura");
            btnVoltar.setIcon(SwingLibResources.getIcon(Imagens.SAIR));
        }
        else
        {
            btnVoltar.setText("Voltar");
            btnVoltar.setToolTipText("Voltar para tela anterior");
            btnVoltar.setIcon(SwingLibResources.getIcon(Imagens.VOLTAR));
        }
    }

    private void atendimentoMudou ()
    {
        try
        {
            FormPrincipal.getInstance().setCursorToWaitCursor();
            mediador.atendimentoMudou(buscadorAtd.getSelectedModel());
        }
        finally
        {
            FormPrincipal.getInstance().setCursorToDefaultCursor();
        }
    }

    private void procedimentoMudou()
    {
//        java.awt.EventQueue.invokeLater(new Runnable()
//        {
//            @Override
//            public void run ()
//            {
                mediador.procMudou(cmbProc.getSelectedItem());
//            }
//
//        });
    }

    private void btnProcAnterior()
    {
        int index = cmbProc.getSelectedIndex();
        if (index > 0)
        {
            cmbProc.setSelectedIndex(index - 1);
        }
    }

    private void btnProcProximo()
    {
        int index = cmbProc.getSelectedIndex();
        if ((index + 1) < cmbProc.getItemCount())
        {
            cmbProc.setSelectedIndex(index + 1);
        }
    }

    @Override
    public boolean requestFocusInWindow ()
    {
        return txtAtd.requestFocusInWindow();
    }

    void voltar ()
    {
        mediador.voltar();
    }

    private class TxtAtd extends TxtComAutoCompletar
    {

        private TxtAtd (C_AutoCompletar<?> buscador)
        {
            super(buscador);
            MeuBtn btn = new MeuBtn("");
            add(btn);
            TxtAtdBorder border = new TxtAtdBorder(btn);
            addPropertyChangeListener("validado", border);
            addAutoCompletarListener(border);
            setBorder(new CompoundBorder(getBorder(), border));
            setStrictMatching(true);
        }

        @Override
        protected void focusLost ()
        {
        }

    }

    private class TxtAtdBorder implements Border, PropertyChangeListener, AutoCompletarListener
    {

        private Insets borderInsets = new Insets(0, 0, 0, 0);
        private final int leftGap = 1;
        private final int rightGap = 2;

        private MyJButton btn;

        TxtAtdBorder (MyJButton btn)
        {
            this.btn = btn;
            btn.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            btn.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        }

        @Override
        public void paintBorder (Component c, Graphics g, int x, int y, int width, int height)
        {
            if (btn.isVisible())
            {
                float xCoord = leftGap;
                float yCoord = (height - btn.getHeight()) / 2;
                btn.setLocation((int) xCoord + x, (int) yCoord + y);
            }
        }

        @Override
        public Insets getBorderInsets (Component c)
        {
            return borderInsets;
        }

        @Override
        public boolean isBorderOpaque ()
        {
            return false;
        }

        @Override
        public void propertyChange (PropertyChangeEvent evt)
        {
            if ((boolean) evt.getNewValue())
            {
                borderInsets.left = this.btn.getWidth() + leftGap;
            }
            else
            {
                borderInsets.left = 0;
            }
        }

        @Override
        public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
        {
            if (newLinhaSelecionada == null)
            {
                borderInsets.left = 0;
                btn.setVisible(false);
            }
            else
            {
                btn.setVisible(true);
                btn.setText(String.valueOf(newLinhaSelecionada[0]));
                btn.setSize(btn.getPreferredSize().width, 20);
                borderInsets.left = this.btn.getWidth() + leftGap + rightGap;
            }
        }

    }

    private class MeuBtn extends MyJButton
    {

        private MeuBtn (String text)
        {
            super(text);
            setOpacity(0.5f);
            setFocusable(false);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            setBorder(new CompoundBorder(getBorder(), new Border() {

                private Insets insets = new Insets(0, -8, 0, -8);

                @Override
                public void paintBorder (Component c, Graphics g, int x, int y, int width, int height)
                {
                }

                @Override
                public Insets getBorderInsets (Component c)
                {
                    return insets;
                }

                @Override
                public boolean isBorderOpaque ()
                {
                    return false;
                }
            }));
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                    try
                    {
                        Atendimento atd = buscadorAtd.getSelectedModel();
                        PnlLaudoeCia.getInstance().mostrarDadosDoAtendimento(atd);
                    }
                    catch (Exception ex)
                    {
                        PnlLaudoeCia.getInstance().mostrarMsgErro(""
                                + "Verifique conexão com o banco de dados!");
                    }
                }
            });
            setToolTipText("Clique para ver os dados do atendimento.");
        }

    }

    private class CmbProcDoAtd extends MyJComboBox<ProcDoAtd>
    {

        private boolean layingOut = false;

        @Override
        public void doLayout ()
        {
            try
            {
                layingOut = true;
                super.doLayout();
            }
            finally
            {
                layingOut = false;
            }
        }

        @Override
        public Dimension getSize ()
        {
            Dimension dim = super.getSize();
            if (!layingOut)
            {
                dim.width += btnVoltar.getWidth() + 9;
                    //btnProximo.getWidth() * 2 + btnVoltar.getWidth() + 5;
            }
            return dim;
        }

    }

    private class MeuSw extends SwingWorker<Void, Void>
    {

        @Override
        protected Void doInBackground () throws Exception
        {
            buscadorAtd.buscarCandidatos("");
            return null;
        }

    }

}
