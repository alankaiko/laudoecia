/*
 * PnlEndereco.java
 *
 * Created on 10/02/2012, 09:58:45
 */
package com.ic.projects.laudoecia.view.pnl;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeBairro;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeCidade;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeTipoDeLogradouro;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.cadastro.C_Endereco;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.ViewEndereco;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.ic.projects.laudoecia.view.dialogs.DlgCadastro;
import com.ic.projects.laudoecia.view.dialogs.DlgCepRepetido;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.maskedfields.TxtCep;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.utils.SwingUtils;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.*;
import java.util.List;
import javax.swing.Box;
import javax.swing.JInternalFrame;

/**
 *
 * @author Danilo Brito <danilobrito@instrumental.net.br>
 */
public class PnlEndereco extends MyJPanel implements ViewEndereco
{
    private C_Endereco controlador;

    private BuscadorDeTipoDeLogradouro buscadorTipoLog = new BuscadorDeTipoDeLogradouro();
    private BuscadorDeCidade buscadorCidade = new BuscadorDeCidade();
    private BuscadorDeBairro buscadorBairro = new BuscadorDeBairro();
    private ActionAddTela actionAddTela;

    public PnlEndereco (final int tela)
    {

        btnBuscaCep.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                if (actionAddTela == null)
                {
                    criarActionAddTela();
                }
                actionAddTela.actionPerformed(e);
            }

            private void criarActionAddTela ()
            {
                JInternalFrame iframe = SwingUtils.getParent(
                        PnlEndereco.this, JInternalFrame.class);
                if (iframe == null)
                {
                    DlgCadastro dlg = SwingUtils.getParent(
                        PnlEndereco.this, DlgCadastro.class);
                    if (dlg != null)
                    {
                        actionAddTela = new ActionAddTela(TelaPrincipal.
                            DLG_CEP, new TelaSolPadrao(
                            TelaPrincipal.TELA_NULL, txtCep, dlg));
                    }
                }
                else
                {
                    actionAddTela = new ActionAddTela(TelaPrincipal.
                        BASE_DE_DADOS_CEP, new TelaSolPadrao(tela, txtCep));
                }
            }

        });

        controlador = new C_Endereco(this);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0; //linha 1
        c.gridx = 0;
        add(new CampoDaEnt("CEP", false, false).setComponent(txtCep), c);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt("", true, false).setComponent(btnBuscaCep
                , false, true, false, false), c);
        c.gridx = 2;
        add(new CampoDaEnt("UF", true, false).setComponent(cmbUf), c);
        c.gridx = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new CampoDaEnt("Cidade", true, false).setComponent(txtCidade), c);
        c.gridx = 4;
        add(new CampoDaEnt("Bairro", true, false).setComponent(txtBairro), c);

        c.gridy = 1; //linha 2
        c.gridx = 0;
        c.gridwidth = 2;
        add(new CampoDaEnt("Tipo Log.", false, true).setComponent(txtTipoDeLogradouro), c);
        c.gridx = 2;
        c.weightx = 0.5;
        add(new CampoDaEnt("Endereço (Logradouro)", true, true).setComponent(txtLogradouro), c);
        c.gridx = 4;
        c.gridwidth = 1;
        c.weightx = 0.5;
        add(new CampoDaEnt("Complemento", true, true).setComponent(txtComplemento), c);

        c.gridwidth = 1; //linha 3 (tamanhos)
        c.gridy = 2;
        c.weightx = 0;
        c.gridx = 0;
        add(Box.createHorizontalStrut(100), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(150), c);
        c.gridx = 4;
        add(Box.createHorizontalStrut(200), c);

    }

    public Endereco getEndereco ()
    {
        Endereco e = new Endereco();
        e.setCep(txtCep.getText());
        e.setUf(cmbUf.getSelectedItem());
        e.setCidade(txtCidade.getText());
        e.setBairro(txtBairro.getText());
        e.setTipoDeLogradouro(txtTipoDeLogradouro.getText());
        e.setLogradouro(txtLogradouro.getText());
        e.setComplemento(txtComplemento.getText());
        return e;
    }

    public void setEndereco (Endereco endereco)
    {
        Endereco endUtilizado = endereco == null ? new Endereco() : endereco;
        txtCep.setText(endUtilizado.getCep());
        cmbUf.setSelectedItem(endUtilizado.getUf());
        buscadorCidade.setSelectedModel(endUtilizado.getCidade());
        buscadorBairro.setSelectedModel(endUtilizado.getBairro());
        buscadorTipoLog.setSelectedModel(endUtilizado.getTipoDeLogradouro());
        txtLogradouro.setText(endUtilizado.getLogradouro());
        txtComplemento.setText(endUtilizado.getComplemento());
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes do Painel">

    private TxtCep txtCep = new TxtCep();
    private BtnFKey btnBuscaCep = new BtnFKey();
    private MyJComboBox<UF> cmbUf = new MyJComboBox<>(StaticInfo.getUfs());
    private TxtComAutoCompletar txtCidade = new TxtComAutoCompletar(buscadorCidade);
    private TxtComAutoCompletar txtBairro = new TxtComAutoCompletar(buscadorBairro);
    private TxtComAutoCompletar txtTipoDeLogradouro = new TxtComAutoCompletar(buscadorTipoLog);
    private MyJTextField txtLogradouro = new MyJTextField();
    private MyJTextField txtComplemento = new MyJTextField();

    public MyJComboBox<UF> getCmbUf ()
    {
        return cmbUf;
    }

    public TxtComAutoCompletar getTxtBairro ()
    {
        return txtBairro;
    }

    public TxtCep getTxtCep ()
    {
        return txtCep;
    }

    public TxtComAutoCompletar getTxtCidade ()
    {
        return txtCidade;
    }

    public MyJTextField getTxtComplemento ()
    {
        return txtComplemento;
    }

    public MyJTextField getTxtLogradouro ()
    {
        return txtLogradouro;
    }

    public TxtComAutoCompletar getTxtTipoDeLogradouro ()
    {
        return txtTipoDeLogradouro;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Ações dos componentes">

    {
        txtCep.addFocusListener(new FocusAdapter()
        {
            private String oldText = "";

            @Override
            public void focusLost (FocusEvent e)
            {
                if (!txtCep.getText().isEmpty() && txtCep.isEditable() && !txtCep.getText().equals(oldText))
                {
                    controlador.cepSelecionadoMudou(txtCep.getText());
                }
            }

            @Override
            public void focusGained (FocusEvent e)
            {
                oldText = txtCep.getText();
            }

        });
        cmbUf.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    buscadorCidade.setFiltroUF(cmbUf.getSelectedItem());
                    buscadorBairro.setFiltroUF(cmbUf.getSelectedItem());
                }
            }

        });
        txtCidade.addAutoCompletarListener(new AutoCompletarListener()
        {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                buscadorBairro.setFiltroCidade(buscadorCidade.getSelectedModel());
            }

        });

        btnBuscaCep.setToolTipText("Buscar CEP");
        txtTipoDeLogradouro.setLargura(2.0d);
        txtCidade.setLargura(1.7d);
        txtBairro.setLargura(1.7d);

    }

    //</editor-fold>

    @Override
    public void alimentarCamposPorCep (Endereco endereco)
    {
        buscadorCidade.setFiltroUF(endereco.getUf());
        buscadorBairro.setFiltroUF(endereco.getUf());
        buscadorBairro.setFiltroCidade(endereco.getCidade());
        setEndereco(endereco);
        if (cmbUf.getSelectedIndex() < 0)
        {
            cmbUf.requestFocusInWindow();
        }
        else if (txtCidade.getText().isEmpty())
        {
            txtCidade.requestFocusInWindow();
        }
        else if (txtBairro.getText().isEmpty())
        {
            txtBairro.requestFocusInWindow();
        }
        else if (txtTipoDeLogradouro.getText().isEmpty())
        {
            txtTipoDeLogradouro.requestFocusInWindow();
        }
        else if (txtLogradouro.getText().isEmpty())
        {
            txtLogradouro.requestFocusInWindow();
        }
        else
        {
            txtComplemento.requestFocusInWindow();
        }
    }

    @Override
    public Endereco escolherEnderecoRepetido (List<Endereco> listEndereco)
    {
        Window w = SwingUtils.getParent(this, Window.class);
        return new DlgCepRepetido(w == null ? this : w, listEndereco).escolherEndereco();
    }

}
