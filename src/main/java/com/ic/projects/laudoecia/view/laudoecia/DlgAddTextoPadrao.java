/*
 * DlgAddTextoPadrao.java
 *
 * Created on 11/07/2012, 11:50:42
 */
package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeTextoPadrao;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.HTMLEditor;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.JScrollPane;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgAddTextoPadrao extends MyJDialog
{
    private static final BuscadorDeTextoPadrao buscador = new BuscadorDeTextoPadrao();
    private boolean cancelado = true;

    public DlgAddTextoPadrao (ProcMedico procMedico)
    {
        super(FormPrincipal.getInstance(), true, 600, 400);
        buscador.setProcMedico(procMedico);
        setTitle("Inserir texto pessoal...");
        setIconImage(FormPrincipal.getInstance().getIconImage());
        setLocationRelativeTo(null);
        initializeComponents();
        txtAbrev.autoCompletar();
    }

    private void initializeComponents ()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        pnl.add(new PnlComp("Busque pela abreviatura", false, false).setComponent(txtAbrev), c);
        c.gridx = 1;
        c.weightx = 0;
        pnl.add(new PnlComp("", true, false).setComponent(btnBusca), c);
        c.gridy = 1;
        c.gridx = 0;
        c.weighty = .95;
        c.gridwidth = 2;
        pnl.add(new PnlComp("Visualização do texto a ser inserido", false, true).setComponent(scroll), c);
        c.gridwidth = 2;
        c.weighty = 0.05;
        c.gridy = 2;
        MyJPanel pnlBtns = new MyJPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlBtns.add(btnConfirmar);
        pnlBtns.add(btnCancelar);
        pnl.add(new PnlComp(false, true).setComponent(pnlBtns), c);
        add(new PnlComEspaco(pnl));
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">
    private final TxtComAutoCompletar txtAbrev = new TxtComAutoCompletar(buscador);
    private final BtnFKey btnBusca = new BtnFKey();
    private final HTMLEditor txtPreview = new HTMLEditor();
    private final JScrollPane scroll = new JScrollPane(txtPreview);
    private final MyJButton btnConfirmar = new MyJButton("Confirmar");
    private final MyJButton btnCancelar = new MyJButton("Cancelar");

    {
        txtAbrev.setMaxVisibleRows(10);
        txtAbrev.setStrictMatching(true);
        txtAbrev.setMensagemDeErro("Abreviatura não encontrada");
        txtAbrev.addAutoCompletarListener(new AutoCompletarListener() {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                abreviaturaMudou();
            }
        });
        txtPreview.setEditable(false);
        txtPreview.setFocusable(false);
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

        btnBusca.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_TEXTO_PESSOAL, new TelaSolPadrao(
                TelaPrincipal.TELA_NULL, new MyJTextField(),
                new ReceptorDeBusca()
                {
                    @Override
                    public boolean isHabilitadoParaReceber ()
                    {
                        return true;
                    }

                    @Override
                    public void receberBusca (Object o)
                    {
                        if (o != null && o instanceof TextoPadrao)
                        {
                            buscador.setSelectedModel((TextoPadrao)o);
                            btnConfirmarAction();
                        }
                    }

                })));

        txtAbrev.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyReleased (KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_ENTER:
                        btnConfirmarAction();
                        break;
                    default:

                }
            }

        });

    }
    //</editor-fold>

    private void abreviaturaMudou ()
    {
        TextoPadrao textoSel = buscador.getSelectedModel();
        if (textoSel == null)
        {
            txtPreview.setText(null);
        }
        else
        {
            txtPreview.setText(textoSel.getTexto());
            btnConfirmar.requestFocusInWindow();
        }
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
        if (buscador.getSelectedModel() == null)
        {
            if (txtAbrev.getText().isEmpty())
            {
                SwingUtils.mostrarMensagemDeErroConhecido(
                        this, "Você deve selecionar um texto padrão!");
                return false;
            }
            if (!buscador.selecionar(txtAbrev.getText()))
            {
                SwingUtils.mostrarMensagemDeErroConhecido(
                        this, "Texto não encontrado!");
                return false;
            }
        }
        return true;
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    public String getTexto ()
    {
        if (buscador.getSelectedModel() != null)
        {
            return buscador.getSelectedModel().getTexto();
        }
        return "";
    }

    @Override
    public void fechar ()
    {
        cancelado = true;
        dispose();
    }

}
