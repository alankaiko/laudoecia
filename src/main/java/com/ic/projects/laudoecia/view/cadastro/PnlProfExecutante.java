/*
 * PnlProfExecutante.java
 *
 * Created on 15/03/2012, 11:27:25
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfSolECrm;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.ic.projects.laudoecia.view.pnl.PnlEndereco;
import com.ic.projects.laudoecia.view.utils.FormatarTelefone;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.crud.entidade.validation.TxtEmailValidator;
import com.lib.swing.maskedfields.TxtTelefone;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJTabbedPane;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.docfilters.NomeDePessoa;
import com.lib.swing.plus.utils.PnlImagemComBotoes;
import com.lib.swing.plus.utils.TxtDouble;
import com.lib.swing.plus.utils.TxtInteiro;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlProfExecutante extends PnlDaEntidadeComCrud<ProfExecutante> {

    private BuscadorDeProfSolECrm buscProfSol = new BuscadorDeProfSolECrm();

    public PnlProfExecutante() {
        btnGroup.add(jRadioM);
        btnGroup.add(jRadioF);
        btnGroup.add(jRadioN);

        PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
//        c.gridwidth = 1;
        pnlTab1.add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);

        c.gridy = 0;
        c.gridx = 1;
//        c.gridwidth = 1;
        pnlTab1.add(new CampoDaEnt("Conselho", true, true).setComponent(cmbConselho.pintarDeAmarelo()), c);

        c.gridy = 0;
        c.gridx = 2;
        pnlTab1.add(new CampoDaEnt("UF conselho", false, true).setComponent(cmbUfConselho.pintarDeAmarelo()), c);

        c.gridy = 0;
        c.gridx = 3;
//        c.gridwidth =1;
        pnlTab1.add(new CampoDaEnt("Número no conselho", false, false).setComponent(txtNumNoConselho.pintarDeAmarelo()), c);

        PnlDoTabbedPane pnlTab2 = new PnlDoTabbedPane(new GridBagLayout());
        c.gridy = 1;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Dr", true, true).setComponent(jRadioM), c);

        c.gridy = 1;
        c.gridx = 1;
        pnlTab1.add(new CampoDaEnt("Dra", true, true).setComponent(jRadioF), c);

        c.gridy = 1;
        c.gridx = 2;
        pnlTab1.add(new CampoDaEnt("Nenhum", true, true).setComponent(jRadioN), c);

        //TESTE
        c.gridy = 1;
        pnlTab1.add(Box.createHorizontalStrut(50), c);

        c.gridy = 2;
        c.gridwidth = 4;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Nome do profissional", false, true).setComponent(txtNome.pintarDeAmarelo()), c);

        c.gridy = 3;
        c.gridwidth = 4;
        pnlTab1.add(new CampoDaEnt("Frase pessoal", false, true).setComponent(txtFrasePessoal), c);
        c.gridx = 4;
        c.weightx = 0.333;
        c.gridwidth = 1;
        pnlTab1.add(new CampoDaEnt("Largura", true, true).setComponent(txtWidth), c);
        c.gridx = 5;
        pnlTab1.add(new CampoDaEnt("Altura", true, true).setComponent(txtHeight), c);
        c.gridx = 6;
        pnlTab1.add(new CampoDaEnt("Margem sup.", true, true).setComponent(txtMargem), c);

        c.gridy = 4;
        c.gridx = 0;
        c.weightx = 0;
        pnlTab1.add(Box.createHorizontalStrut(75), c);
        c.gridx = 1;
        c.weighty = 1;
        pnlTab1.add(Box.createHorizontalStrut(25), c);
        c.weighty = 0;
        c.gridx = 2;
        pnlTab1.add(Box.createHorizontalStrut(120), c);
        c.gridx = 3;
        pnlTab1.add(Box.createHorizontalStrut(160), c);
        c.gridy = 0;
        c.gridx = 4;
        c.gridheight = 3;
        c.gridwidth = 3;
        pnlTab1.add(new CampoDaEnt("Assinatura digitalizada", SwingConstants.CENTER, true, false).
                setComponent(pnlAss), c);

        PnlDoTabbedPane pnlTab3 = new PnlDoTabbedPane(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 3;
        c.weighty = 0;
        c.gridheight = 1;
        pnlTab3.add(pnlEndereco, c);

        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        pnlTab3.add(new CampoDaEnt("Telefone 1", false, true).setComponent(txtTelefone1), c);
        c.gridx = 1;
        pnlTab3.add(new CampoDaEnt("Telefone 2", true, true).setComponent(txtTelefone2), c);

        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 2;
        pnlTab3.add(new CampoDaEnt("E-mail", false, true).setComponent(txtEmail), c);

        c.gridy = 3;
        c.gridx = 0;
        c.weighty = 1;
        c.gridwidth = 1;
        pnlTab3.add(Box.createHorizontalStrut(110), c);
        c.gridx = 1;
        pnlTab3.add(Box.createHorizontalStrut(110), c);
        c.gridx = 2;
        c.weightx = 1;
        pnlTab3.add(Box.createHorizontalStrut(0), c);

        tabPane.addTab("Dados principais", pnlTab1);
        tabPane.addTab("Endereço e contatos", pnlTab3);
        setLayout(new CardLayout());
        add(tabPane);

        jRadioN.setSelected(true);
        jRadioF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtNome.getText().substring(0, 4).trim().equals("DRA.")) {
                    txtNome.setText("DRA." + txtNome.getText().substring(4));
                } else if (txtNome.getText().substring(0, 3).trim().equals("DR.")) {
                    txtNome.setText("DRA." + txtNome.getText().substring(3));
                } else {
                    txtNome.setText("DRA. " + txtNome.getText());
                }
            }
        });

        jRadioM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtNome.getText().substring(0, 3).trim().equals("DR.")) {
                    txtNome.setText("DR." + txtNome.getText().substring(3));
                } else if (txtNome.getText().substring(0, 4).trim().equals("DRA.")) {
                    txtNome.setText("DR" + txtNome.getText().substring(3));
                } else {
                    txtNome.setText("DR. " + txtNome.getText());
                }
            }
        });

        jRadioN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtNome.getText().substring(0, 3).trim().equals("DR.")) {
                    txtNome.setText("" + txtNome.getText().substring(4));
                } else if (txtNome.getText().substring(0, 4).trim().equals("DRA.")) {
                    txtNome.setText("" + txtNome.getText().substring(5));
                }
            }
        });
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk(ProfExecutante entidade, int contador) {
        txtCodigo.setText(entidade.getCodigo());
        cmbConselho.setSelectedItem(entidade.getConselho());
        cmbUfConselho.setSelectedItem(entidade.getUfConselho());
        txtNumNoConselho.setText(entidade.getNumNoConselho());
        txtNome.setText(entidade.getNome());
        txtFrasePessoal.setText(entidade.getFrasePessoal());
        pnlEndereco.setEndereco(entidade.getEndereco());
        if (entidade.getTelefone1().length() == 10) {
            txtTelefone1.setText(FormatarTelefone.getInstance().format("(##)####-#####", entidade.getTelefone1()));
            txtTelefone2.setText(FormatarTelefone.getInstance().format("(##)####-#####", entidade.getTelefone2()));
        } else if(entidade.getTelefone2().length() == 10){
            txtTelefone2.setText(FormatarTelefone.getInstance().format("(##)####-#####", entidade.getTelefone2()));
        }else {
            txtTelefone1.setText(entidade.getTelefone1());
            txtTelefone2.setText(entidade.getTelefone2());
        }
        txtEmail.setText(entidade.getEmail());
        pnlAss.setImagem(entidade.getAssinatura());
        txtWidth.setText(entidade.getAssWidth());
        txtHeight.setText(entidade.getAssHeight());
        txtMargem.setText(entidade.getEspacoAss());
        jRadioN.setSelected(true);
        return true;
    }

    @Override
    public void prepararParaAdicionar(Object dadosIniciais) {
        txtNumNoConselho.requestFocusInWindow();
        if (dadosIniciais != null && dadosIniciais instanceof String) {
            txtNome.setText((String) dadosIniciais);
        }
    }

    @Override
    public void prepararParaAlterar(boolean pnlEntidadeWasSelected) {
        txtNome.requestFocusInWindow();
    }

    @Override
    public void preencherDadosDaEntidade(ProfExecutante entidadeBase) {
        entidadeBase.setEspacoAss(txtMargem.getInt());
        entidadeBase.setCodigo(txtCodigo.getInt());
        entidadeBase.setUfConselho(cmbUfConselho.getSelectedItem());
        entidadeBase.setConselho(cmbConselho.getSelectedItem());
        entidadeBase.setNumNoConselho(txtNumNoConselho.getText());
        entidadeBase.setNome(txtNome.getText());
        entidadeBase.setFrasePessoal(txtFrasePessoal.getText());
        entidadeBase.setEndereco(pnlEndereco.getEndereco());
        if(txtTelefone1.getText().length() < 11){
            entidadeBase.setTelefone1("");
        }else{
            entidadeBase.setTelefone1(txtTelefone1.getText());
        }

        if(txtTelefone2.getText().length() < 11){
            entidadeBase.setTelefone2("");
        }else{
            entidadeBase.setTelefone2(txtTelefone2.getText());
        }
        entidadeBase.setEmail(txtEmail.getText());
        entidadeBase.setAssinatura(pnlAss.getImagem());
        entidadeBase.setNome(txtNome.getText());

        if (txtWidth.getDouble() <= 0 && entidadeBase.getAssinatura() != null) {
            entidadeBase.setAssWidth(1);
        } else {
            entidadeBase.setAssWidth(txtWidth.getDouble());
        }
        if (txtHeight.getDouble() <= 0 && entidadeBase.getAssinatura() != null) {
            entidadeBase.setAssHeight(1);
        } else {
            entidadeBase.setAssHeight(txtHeight.getDouble());
        }
    }

    @Override
    public void usarResultadoDaBusca(Object o) {
        if (o instanceof EnderecoPorCep) {
            pnlEndereco.alimentarCamposPorCep(((EnderecoPorCep) o).getEndereco());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Campos do cadastro">
    private MyJTabbedPane tabPane = new MyJTabbedPane();
    private MyJTextField txtNome = new MyJTextField();
    private MyJComboBox<TISS_Conselho> cmbConselho = new MyJComboBox<>(StaticInfo.getTiss_Conselhos());
    private MyJComboBox<UF> cmbUfConselho = new MyJComboBox<>(StaticInfo.getUfs());
    private TxtComAutoCompletar txtNumNoConselho = new TxtComAutoCompletar();
    private MyJTextField txtFrasePessoal = new MyJTextField();
    private PnlEndereco pnlEndereco = new PnlEndereco(TelaPrincipal.CADASTRO_PROF_EXECUTANTE);
    private TxtTelefone txtTelefone1 = new TxtTelefone(StaticInfo.getDefaultDDD());
    private TxtTelefone txtTelefone2 = new TxtTelefone(StaticInfo.getDefaultDDD());
    private MyJTextField txtEmail = new MyJTextField();
    private PnlImagemComBotoes pnlAss = new PnlImagemComBotoes();
    private final TxtDouble txtWidth = new TxtDouble(2);
    private final TxtDouble txtHeight = new TxtDouble(2);
    private final TxtInteiro txtMargem = new TxtInteiro(3);
    private JRadioButton jRadioM = new JRadioButton();
    private JRadioButton jRadioF = new JRadioButton();
    private JRadioButton jRadioN = new JRadioButton();
    private ButtonGroup btnGroup = new ButtonGroup();

    {
        buscProfSol.setBuscarSoEmCrm(true);
        txtNome.setDocumentFilter(new NomeDePessoa(new LimitedLengthDocFilter()));
        txtEmail.setStrCnfEnabled(false);
        txtNumNoConselho.setControlador(buscProfSol);
        txtNumNoConselho.setBtnAutoCompletarPodeSerVisivel(false);
        txtNumNoConselho.addAutoCompletarListener(new AutoCompletarListener() {
            @Override
            public void linhaSelecionadaMudou(Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada) {
                ProfSolicitante ps = buscProfSol.getSelectedModel();
                if (ps != null) {
                    txtNome.setText(ps.getNome());
                }
            }
        });
        txtNumNoConselho.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e){
                txtNome.requestFocus();
            }
        });
        txtNumNoConselho.setLargura(2.5d);
        cmbUfConselho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                buscProfSol.setUf(cmbUfConselho.getSelectedItem());
            }
        });
        cmbConselho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                buscProfSol.setConselho(cmbConselho.getSelectedItem());
            }
        });
    }

    //</editor-fold>
    @Override
    protected void configurarValidacao(Map<String, C_Validacao> validadores) {
        formValidator.add(cmbUfConselho, new RequiredFieldValidator(cmbUfConselho));
        formValidator.add(cmbConselho, new RequiredFieldValidator(cmbConselho));
        formValidator.add(txtNumNoConselho, new RequiredFieldValidator(txtNumNoConselho),
                validadores.get("numNoConselho").
                set("codigo", readerInt(txtCodigo)).
                set("uf", readerComboBox(cmbUfConselho)).
                set("conselho", readerComboBox(cmbConselho)).
                set("numNoConselho", readerStr(txtNumNoConselho)));
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome));
        formValidator.add(txtEmail, new TxtEmailValidator(txtEmail));
    }

}
