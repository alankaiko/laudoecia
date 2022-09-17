/*
 * PnlBuscaCep.java
 *
 * Created on 24/02/2012, 09:18:29
 */
package com.ic.projects.laudoecia.view.pnl;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeBairro;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeCidade;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeTipoDeLogradouro;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.AbstractPnlBuscaBuilder;
import com.lib.swing.crud.busca.TxtBuscaKeyListener;
import com.lib.swing.crud.entidade.ComponentReader;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.utils.RobotImpl;
import com.lib.swing.utils.TableConfigurator;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jfree.ui.tabbedui.VerticalLayout;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public final class PnlBuscaCep extends AbstractPnlBuscaBuilder
{
    
    //<editor-fold defaultstate="collapsed" desc="Components do Builder">

    private MyJComboBox<String> cmbCampos;
    private MyJComboBox<Integer> cmbNumResultados;
    private MyJPanel subPnlParamsBuscaPorEndereco;
    private MyJPanel subPnlParamsBuscaPorCep;
    private BuscadorDeCidade buscadorCidade = new BuscadorDeCidade();
    private BuscadorDeBairro buscadorBairro = new BuscadorDeBairro();

    private MyJTextField txtCep = new MyJTextField();
    private MyJButton btnOkCep = new MyJButton("OK");

    private MyJComboBox<UF> cmbUF = new MyJComboBox<>(StaticInfo.getUfs());
    private TxtComAutoCompletar txtCidade = criarTxtAC(230, 1.7d);
    private TxtComAutoCompletar txtBairro = criarTxtAC(230, 1.7d);
    private TxtComAutoCompletar txtTipoLog = criarTxtAC(120, 2.0d);
    private MyJTextField txtLogradouro = new MyJTextField();
    private MyJButton btnOkEndereco = new MyJButton("OK");

    //</editor-fold>

    {
        
        cmbUF.setFocusable(false);
        cmbUF.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    txtCidade.setText("");
                    txtBairro.setText("");
                    buscadorCidade.setFiltroUF(cmbUF.getSelectedItem());
                    buscadorBairro.setFiltroUF(cmbUF.getSelectedItem());
                    buscadorBairro.setFiltroCidade(null);

                    txtCidade.requestFocusInWindow();
                    limparResultados ();

                }
            }
        });
        cmbUF.setSelectedItem(StaticInfo.getDefaultUF());
        txtCidade.addAutoCompletarListener(new AutoCompletarListener() {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                txtBairro.setText("");
                buscadorBairro.setFiltroCidade(buscadorCidade.getSelectedModel());
            }

        });
        
        txtCidade.setControlador(buscadorCidade);
        txtBairro.setControlador(buscadorBairro);
        pnlParamsBusca.setFocusedComponent(txtBairro);
        buscadorCidade.setSelectedModel(StaticInfo.getDefaultCidade());
        
        ActionListener actionBtn = new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                pnlBusca.parametroDeBuscaChanged();
            }
        };
        btnOkCep.addActionListener(actionBtn);
        btnOkEndereco.addActionListener(actionBtn);

        DocumentListener textChangeListener = new TxtChangedListener() {

            @Override
            public void textChanged (DocumentEvent de)
            {
                limparResultados();
            }
        };
        txtCidade.addDocumentListener(textChangeListener);
        txtBairro.addDocumentListener(textChangeListener);
        txtTipoLog.addDocumentListener(textChangeListener);
        txtLogradouro.addDocumentListener(textChangeListener);

        KeyListener buscarAoDigitarEnter = new KeyAdapter() {
            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.isConsumed() || e.getKeyCode() != KeyEvent.VK_ENTER)
                {
                }
                else
                {
                    if (scroll.getResults().isEmpty())
                    {
                        pnlBusca.parametroDeBuscaChanged();
                    }
                    else
                    {
                        pnlParamsBusca.actionPerformed();
                    }
                }
            }

        };
        txtCep.addKeyListener(buscarAoDigitarEnter);
        txtCep.addDocumentListener(textChangeListener);
        txtLogradouro.addKeyListener(buscarAoDigitarEnter);

        KeyListener navegador = new TxtBuscaKeyListener(scroll);
        txtLogradouro.addKeyListener(navegador);
        txtCep.addKeyListener(navegador);

        txtTipoLog.setControlador(new BuscadorDeTipoDeLogradouro());
        txtLogradouro.setPreferredSize(new Dimension(260, txtLogradouro.getPreferredSize().height));

        btnOkEndereco.setFocusable(false);
        btnOkCep.setFocusable(false);
        
    }

    public PnlBuscaCep (TableConfigurator tc)
    {
        super(tc, new JPanel(new FlowLayout(FlowLayout.CENTER)));
        addCmbCampos(130, 0);
        addCmbNumResultados(2);
        addSubPnls();
    }
    
    private TxtComAutoCompletar criarTxtAC (int width, double largura)
    {
        final TxtComAutoCompletar txtBusca = new TxtComAutoCompletar();
        txtBusca.setPreferredSize(new Dimension(width, txtBusca.getPreferredSize().height));
        txtBusca.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !e.isConsumed())
                {
                    RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
                    e.consume();
                }
            }

        });
        txtBusca.setLargura(largura);
        return txtBusca;
    }

    private void addCmbCampos (int width, int selIndex)
    {
        cmbCampos = new MyJComboBox<> (new String[]{"endereço", "cep"});
        cmbCampos.setFocusable(false);
        cmbCampos.setPreferredSize(new Dimension(width, cmbCampos.getPreferredSize().height));
        cmbCampos.setSelectedIndex(selIndex);
        pnlParamsBusca.add(cmbCampos, cmbReader, new LblNegrito("Buscar por"), null);
        cmbCampos.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    alternarSubPaineis(cmbCampos.getSelectedItem());
                    limparResultados ();
                }
            }

        });
    }

    private void addCmbNumResultados (int selIndex)
    {
        cmbNumResultados = criarCmbNumResultados(selIndex);
        pnlParamsBusca.add(cmbNumResultados, cmbReader, new LblNegrito(" ver apenas"),
                           new LblNegrito("resultados"));
    }

    private void addSubPnls ()
    {
        createSubPnlDeBuscaPorEndereco();
        createSubPnlDeBuscaPorCep();
        pnlParamsBusca.addPanel(new JPanel(new VerticalLayout()));
        pnlParamsBusca.add(subPnlParamsBuscaPorEndereco, new ComponentReader() {
            @Override
            public Object getParamFromComp (Component component)
            {
                Endereco endereco = new Endereco();
                endereco.setUf(cmbUF.getSelectedItem());
                endereco.setCidade(txtCidade.getText());
                endereco.setBairro(txtBairro.getText());
                endereco.setTipoDeLogradouro(txtTipoLog.getText());
                endereco.setLogradouro(txtLogradouro.getText());
                return endereco;
            }
        }, null, null);
        pnlParamsBusca.add(subPnlParamsBuscaPorCep, new ComponentReader() {
            @Override
            public Object getParamFromComp (Component component)
            {
                return txtCep.getText();
            }
        }, null, null);
    }

    private void alternarSubPaineis (String novoCampoSelecionado)
    {
        switch (novoCampoSelecionado)
        {
            case "endereço":
                subPnlParamsBuscaPorCep.setVisible(false);
                subPnlParamsBuscaPorEndereco.setVisible(true);
                if (!subPnlParamsBuscaPorEndereco.isFocusOwner())
                {
                    txtCidade.requestFocusInWindow();
                }
                pnlParamsBusca.setFocusedComponent(txtLogradouro);
                break;
            case "cep":
                subPnlParamsBuscaPorEndereco.setVisible(false);
                subPnlParamsBuscaPorCep.setVisible(true);
                pnlParamsBusca.setFocusedComponent(txtCep);
                txtCep.requestFocusInWindow();
                break;
            default:
                break;
        }
    }

    private void createSubPnlDeBuscaPorEndereco ()
    {
        subPnlParamsBuscaPorEndereco = new MyJPanel();
        subPnlParamsBuscaPorEndereco.setLayout(new BorderLayout());
        subPnlParamsBuscaPorEndereco.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 5, 5), new LineBorder(new Color(175, 175, 175))));

        JPanel pnlAux1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlAux1.add(new LblNegrito("UF"));
        pnlAux1.add(cmbUF);
        pnlAux1.add(new LblNegrito("Cidade"));
        pnlAux1.add(txtCidade);
        pnlAux1.add(new LblNegrito("Bairro"));
        pnlAux1.add(txtBairro);
        subPnlParamsBuscaPorEndereco.add(pnlAux1, BorderLayout.NORTH);

        JPanel pnlAux2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlAux2.add(new LblNegrito("Tipo de logradouro"));
        pnlAux2.add(txtTipoLog);
        pnlAux2.add(new LblNegrito("Logradouro"));
        pnlAux2.add(txtLogradouro);
        pnlAux2.add(btnOkEndereco);
        subPnlParamsBuscaPorEndereco.add(pnlAux2, BorderLayout.SOUTH);

    }

    private void createSubPnlDeBuscaPorCep ()
    {
        subPnlParamsBuscaPorCep = new MyJPanel();
        subPnlParamsBuscaPorCep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        subPnlParamsBuscaPorCep.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 5, 5), new LineBorder(new Color(175, 175, 175))));

        subPnlParamsBuscaPorCep.add(new LblNegrito("Digite o CEP"));
        txtCep.setPreferredSize(new Dimension(110, txtCep.getPreferredSize().height));
        subPnlParamsBuscaPorCep.add(txtCep);
        btnOkCep.setFocusable(false);
        subPnlParamsBuscaPorCep.add(btnOkCep);

        subPnlParamsBuscaPorCep.setVisible(false);
    }

    private void limparResultados ()
    {
        pnlBusca.updateResultList(new ResultsGenerator() {
            @Override
            public java.util.List<Object[]> generateResults ()
            {
                return new ArrayList<>();
            }

        });
    }

}
