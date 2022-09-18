package com.ic.projects.laudoecia.view.cadastro;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJTabbedPane;
import com.lib.swing.plus.cps.MyJTextField;

public class PnlPoliticaPrivacidade extends PnlDaEntidadeComCrud<PoliticaPrivacidade> {
	private MyJTabbedPane tabPane = new MyJTabbedPane();
    private JTextArea txtTermo = new JTextArea();
    private MyJTextField txtTitulo = new MyJTextField();
    private MyJTextField txtVersao = new MyJTextField();
    private MyJCheckBox chkAtivo = new MyJCheckBox("Aceitação");
    private TxtData txtDataCadastro = new TxtData();
    private TxtData txtDataDesativacao = new TxtData();
    private JScrollPane scrolpainel = new JScrollPane(txtTermo);

    public PnlPoliticaPrivacidade() {
        PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        c.gridy = 0;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Titulo", false, true).setComponent(txtTitulo), c);
        
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridx = 3;
        pnlTab1.add(new CampoDaEnt("Versão", false, true).setComponent(txtVersao), c);
        
        c.gridy = 4;
        c.gridwidth = 4;
        c.weightx = 0.333;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Termo", false, false).setComponent(scrolpainel), c);

        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Data Aceitação", true, true).setComponent(txtDataCadastro), c);
                 
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 1;
        pnlTab1.add(new CampoDaEnt(true, true).setComponent(chkAtivo), c);
        
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 2;
        pnlTab1.add(new CampoDaEnt("Data Revogação", true, true).setComponent(txtDataDesativacao), c);     
        
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
      
        tabPane.addTab("Dados principais", pnlTab1);
        setLayout(new CardLayout());
        add(tabPane);
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk(PoliticaPrivacidade entidade, int contador) {
		txtCodigo.setText(entidade.getCodigo());
		txtTitulo.setText(entidade.getTitulo());
		txtTermo.setText(entidade.getTermo());
		System.out.println(entidade.getTermo());
		txtVersao.setText(entidade.getVersao());
		chkAtivo.setSelected(entidade.isAtivo());
		txtDataCadastro.setText(entidade.getDatacadastro());
		txtDataDesativacao.setText(entidade.getDatadesativacao());
      	 
        return true;
    }

    @Override
    public void prepararParaAdicionar(Object dadosIniciais) {
    	
    }

    @Override
    public void prepararParaAlterar(boolean pnlEntidadeWasSelected) {
    
    }

    @Override
    public void preencherDadosDaEntidade(PoliticaPrivacidade entidadeBase) {
		entidadeBase.setCodigo(txtCodigo.getInt());
		entidadeBase.setTitulo(txtTitulo.getText());
		entidadeBase.setTermo(txtTermo.getText());
		entidadeBase.setVersao(txtVersao.getText());
    	entidadeBase.setAtivo(chkAtivo.isSelected());
    	entidadeBase.setDatacadastro(txtDataCadastro.getDate());
    	entidadeBase.setDatadesativacao(txtDataDesativacao.getDate());
    }

    @Override
    public void usarResultadoDaBusca(Object o) {
    	
    }

    @Override
    protected void configurarValidacao(Map<String, C_Validacao> validadores) {
       
    }

}
