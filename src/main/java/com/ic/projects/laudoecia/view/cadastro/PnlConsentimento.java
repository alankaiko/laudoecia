package com.ic.projects.laudoecia.view.cadastro;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePacientes;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePoliticaPrivacidade;
import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJTabbedPane;
import com.lib.swing.plus.utils.PnlImagemComBotoes;
import com.lib.swing.plus.utils.TxtReadOnly;

public class PnlConsentimento extends PnlDaEntidadeComCrud<Consentimento> {
	private BuscadorDePacientes buscPaciente = new BuscadorDePacientes();
	private BuscadorDePoliticaPrivacidade buscPolitica = new BuscadorDePoliticaPrivacidade();
	private MyJTabbedPane tabPane = new MyJTabbedPane();
    private TxtComAutoCompletar txtPaciente = new TxtComAutoCompletar(buscPaciente);
    private TxtComAutoCompletar txtPolitica = new TxtComAutoCompletar(buscPolitica);
    private TxtReadOnly txtDescricao = new TxtReadOnly();
    private MyJCheckBox chkAceito = new MyJCheckBox("Aceitação");
    private MyJCheckBox chkRevogado = new MyJCheckBox("Revogação");
    private TxtData txtDataAceitacao = new TxtData();
    private TxtData txtDataRevogacao = new TxtData();
    private PnlImagemComBotoes pnlScanner = new PnlImagemComBotoes();

    public PnlConsentimento() {
        PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridx = 1;
        pnlTab1.add(new CampoDaEnt("Descrição Paciente", false, false).setComponent(txtDescricao), c);
        
        c.gridy = 2;
        c.gridwidth = 4;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Paciente", true, true).setComponent(txtPaciente), c);
        
        c.gridy = 3;
        c.gridwidth = 4;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Politica de Privacidade", true, true).setComponent(txtPolitica), c);

        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Data Aceitação", true, true).setComponent(txtDataAceitacao), c);
                 
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 1;
        pnlTab1.add(new CampoDaEnt(true, true).setComponent(chkAceito), c);
        
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 2;
        pnlTab1.add(new CampoDaEnt("Data Revogação", true, true).setComponent(txtDataRevogacao), c);     
        
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridx = 3;
        pnlTab1.add(new CampoDaEnt(true, true).setComponent(chkRevogado), c);
        
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
        c.gridheight = 4;
        c.gridwidth = 4;
        pnlTab1.add(new CampoDaEnt("Termo digitalizado", SwingConstants.CENTER, true, false).setComponent(pnlScanner), c);

        tabPane.addTab("Dados principais", pnlTab1);
        setLayout(new CardLayout());
        add(tabPane);
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk(Consentimento entidade, int contador) {
    	txtCodigo.setText(entidade.getCodigo());
    	chkAceito.setSelected(entidade.isAceito());
    	chkRevogado.setSelected(entidade.isRevogado());
    	txtDataAceitacao.setText(entidade.getDataaceitacao());
    	txtDataRevogacao.setText(entidade.getDatarevogacao());
    	buscPaciente.setSelectedModel(entidade.getPaciente());
      	buscPolitica.setSelectedModel(entidade.getPoliticaprivacidade());
      	txtDescricao.setText(entidade.getDescricao());
        return true;
    }

    @Override
    public void prepararParaAdicionar(Object dadosIniciais) {
    
    }

    @Override
    public void prepararParaAlterar(boolean pnlEntidadeWasSelected) {
    
    }

    @Override
    public void preencherDadosDaEntidade(Consentimento entidadeBase) {
    	 entidadeBase.setCodigo(txtCodigo.getInt());
    	 entidadeBase.setAceito(chkAceito.isSelected());
    	 entidadeBase.setRevogado(chkRevogado.isSelected());
    	 entidadeBase.setDataaceitacao(txtDataAceitacao.getDate());
    	 entidadeBase.setDatarevogacao(txtDataRevogacao.getDate());
    	 entidadeBase.setPaciente(buscPaciente.getSelectedModel());
    	 entidadeBase.setPoliticaprivacidade(buscPolitica.getSelectedModel());
    	 entidadeBase.setDescricao(txtDescricao.getText());
    	 entidadeBase.setScannerdocumento(pnlScanner.getImagem());
    }

    @Override
    public void usarResultadoDaBusca(Object o) {

    	if (o instanceof Paciente) {
    		Paciente pac = (Paciente) o;
			txtPaciente.requestFocusInWindow();
			buscPaciente.setSelectedModel(pac);
			java.awt.EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					txtPaciente.requestFocusInWindow();
				}
			});			
		}
    	
    	if (o instanceof PoliticaPrivacidade) {
    		PoliticaPrivacidade polit = (PoliticaPrivacidade) o;
	
			txtPolitica.requestFocusInWindow();
			buscPolitica.setSelectedModel(polit);
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					txtPolitica.requestFocusInWindow();
				}
			});			
		}
    }
    
    {
    	this.txtPaciente.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				txtDescricao.setText(txtPaciente.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
    }

    @Override
    protected void configurarValidacao(Map<String, C_Validacao> validadores) {
       
    }

}
