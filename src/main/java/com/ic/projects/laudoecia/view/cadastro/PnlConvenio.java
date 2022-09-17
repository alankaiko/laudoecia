/*
 * PnlConvenio.java
 *
 * Created on 15/03/2012, 09:40:37
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.view.pnl.PnlEndereco;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.crud.entidade.validation.TxtEmailValidator;
import com.lib.swing.maskedfields.TxtTelefone;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJTabbedPane;
import com.lib.swing.plus.cps.MyJTextArea;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.docfilters.NomeDePessoa;
import com.lib.swing.plus.utils.SpinnerInt;
import com.lib.swing.plus.utils.TxtInteiro;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JScrollPane;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlConvenio extends PnlDaEntidadeComCrud<Convenio>
{
    public PnlConvenio ()
    {
        PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        pnlTab1.add(Box.createHorizontalStrut(100), c);
        c.gridx = 1;
        pnlTab1.add(new CampoDaEnt("Nº cópias do laudo", true, false).setComponent(txtNumCopiasLaudo), c);
        pnlTab1.add(Box.createHorizontalStrut(135), c);
        c.gridx = 2;
        c.weightx = 1;
        pnlTab1.add(Box.createHorizontalStrut(0), c);
        c.gridx = 3;
        c.weightx = 0;
        pnlTab1.add(new CampoDaEnt(false, false).setComponent(chkAtivo), c);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 4;
        pnlTab1.add(new CampoDaEnt("Nome", false, true).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridy = 2;
        c.weighty = 1;
        pnlTab1.add(new CampoDaEnt("Observações", false, true).setComponent(
                new JScrollPane(txtObservacoes,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
                false, true, true, true), c);

        PnlDoTabbedPane pnlTab2 = new PnlDoTabbedPane(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 3;
        c.weightx = 1;
        pnlTab2.add(pnlEndereco, c);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        pnlTab2.add(new CampoDaEnt("Telefone", false, true).setComponent(txtTelefone), c);
        c.gridx = 1;
        pnlTab2.add(new CampoDaEnt("Fax", true, true).setComponent(txtFax), c);
        c.gridx = 2;
        pnlTab2.add(new CampoDaEnt("E-mail", true, true).setComponent(txtEmail), c);
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlTab2.add(new CampoDaEnt("Nome do contato", false, true).setComponent(txtNomeContato), c);
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 1;
        c.weighty = 1;
        pnlTab2.add(Box.createHorizontalStrut(152), c);
        c.gridx = 1;
        pnlTab2.add(Box.createHorizontalStrut(152), c);
        c.gridx = 2;
        pnlTab2.add(Box.createHorizontalStrut(370), c);

        tabPane.addTab("Dados principais", pnlTab1);
        tabPane.addTab("Dados para contato", pnlTab2);
        setLayout(new CardLayout());
        add(tabPane);
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNumCopiasLaudo, new IValidaCampo()
        {

            @Override
            public boolean validationOk (int tipo)
            {
                return txtNumCopiasLaudo.getInt() > 0;
            }

            @Override
            public String getErrorMessage ()
            {
                return "Escolha um valor > 0";
            }
        });
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome),
                          validadores.get("nome").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtNome)));
        formValidator.add(txtEmail, new TxtEmailValidator(txtEmail));
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (Convenio entidade, int contador)
    {
        txtCodigo.setText(entidade.getCodigo());
        chkAtivo.setSelected(entidade.isAtivo());
        txtNome.setText(entidade.getNome());
        txtObservacoes.setText(entidade.getObservacoes());
        pnlEndereco.setEndereco(entidade.getEndereco());
        txtTelefone.setText(entidade.getTelefone());
        txtFax.setText(entidade.getFax());
        txtEmail.setText(entidade.getEmail());
        txtNomeContato.setText(entidade.getNomeDoContato());
        txtNumCopiasLaudo.setText(entidade.getNumcopiasdolaudo());
        return true;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        tabPane.setSelectedIndex(0);
        txtNome.requestFocusInWindow();
        if (dadosIniciais != null)
        {
            txtNome.setText(dadosIniciais.toString());
        }
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        if (!pnlEntidadeWasSelected)
        {
            tabPane.setSelectedIndex(0);
        }
        switch (tabPane.getSelectedIndex())
        {
            case 0:
                txtObservacoes.requestFocusInWindow();
                break;
            case 1:
                txtTelefone.requestFocusInWindow();
                break;
            default:
        }
    }

    @Override
    public void preencherDadosDaEntidade (Convenio entidadeBase)
    {
        entidadeBase.setCodigo(txtCodigo.getInt());
        entidadeBase.setAtivo(chkAtivo.isSelected());
        entidadeBase.setNome(txtNome.getText());
        entidadeBase.setObservacoes(txtObservacoes.getText());
        entidadeBase.setEndereco(pnlEndereco.getEndereco());
        entidadeBase.setTelefone(txtTelefone.getText());
        entidadeBase.setFax(txtFax.getText());
        entidadeBase.setEmail(txtEmail.getText());
        entidadeBase.setNomeDoContato(txtNomeContato.getText());
        entidadeBase.getTabelaDeProcedimentos().setConvenio(entidadeBase);
        entidadeBase.getTabelaDeProcedimentos().setCodigo(txtCodigo.getInt());
        entidadeBase.setNumcopiasdolaudo(txtNumCopiasLaudo.getInt());
    }

    @Override
    public void usarResultadoDaBusca (Object o)
    {
        if (o instanceof EnderecoPorCep)
        {
            pnlEndereco.alimentarCamposPorCep(((EnderecoPorCep) o).getEndereco());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Campos do cadastro">

    private MyJTabbedPane tabPane = new MyJTabbedPane();
    private MyJCheckBox chkAtivo = new MyJCheckBox("Convênio ativo   ");
    private TxtInteiro txtNumCopiasLaudo = new TxtInteiro(2);
    private MyJTextField txtNome = new MyJTextField();
    private MyJTextArea txtObservacoes = new MyJTextArea();
    private PnlEndereco pnlEndereco = new PnlEndereco(TelaPrincipal.CADASTRO_CONVENIOS);
    private TxtTelefone txtTelefone = new TxtTelefone(StaticInfo.getDefaultDDD());
    private TxtTelefone txtFax = new TxtTelefone(StaticInfo.getDefaultDDD());
    private MyJTextField txtEmail = new MyJTextField();
    private MyJTextField txtNomeContato = new MyJTextField();

    {
        txtNome.setDocumentFilter(new LimitedLengthDocFilter());
        txtNomeContato.setDocumentFilter(new NomeDePessoa(new LimitedLengthDocFilter()));
        txtEmail.setStrCnfEnabled(false);
    }

    //</editor-fold>

}
