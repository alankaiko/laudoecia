/*
 * PnlPaciente.java
 *
 * Created on 13/03/2012, 08:57:35
 */
package com.ic.projects.laudoecia.view.cadastro;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePacientes;
import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadePaciente;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaSolicitanteNull;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.pnl.JanelaComTitulo;
import com.ic.projects.laudoecia.view.pnl.PnlEndereco;
import com.ic.projects.laudoecia.view.utils.FormatarTelefone;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.model.abstracao.SEXO;
import com.lib.model.cnv.ConversorDateTimeStampString;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.crud.entidade.validation.TxtDataDeNascValidator;
import com.lib.swing.crud.entidade.validation.TxtEmailValidator;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.maskedfields.TxtTelefone;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTabbedPane;
import com.lib.swing.plus.cps.MyJTextArea;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.utils.CmbEnum;
import com.lib.swing.plus.utils.PnlImagemComBotoes;
import com.lib.swing.plus.utils.TxtReadOnly;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;

import br.com.oslunaticos.InstallSpellcheck;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlPaciente extends PnlDaEntidadeComCrud<Paciente> {

	private BuscadorDePacientes buscador = new BuscadorDePacientes();
	private JanelaComTitulo janela;
	private C_EntidadePaciente c_Paciente;

	public PnlPaciente() {

		txtCodigo.setFocusable(false);

		PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridy = 0;
		c.gridx = 0;
		pnlTab1.add(new CampoDaEnt("Prontuário", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
		c.gridx = 1;
		c.gridwidth = 2;
		pnlTab1.add(new CampoDaEnt("Data de cadastro", true, false).setComponent(txtDataDeCadastro), c);
		c.gridy = 0;
		c.gridx = 3;
        pnlTab1.add(new CampoDaEnt(false, false).setComponent(chkAnonimo), c);
		c.gridx = 5;
		c.gridwidth = 1;
		c.gridheight = 4;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		pnlTab1.add(new CampoDaEnt("Foto", SwingConstants.CENTER, true, false).setComponent(pnlFoto), c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridheight = 1;
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 5;
		pnlTab1.add(new CampoDaEnt("Nome", false, true).setComponent(txtNome.pintarDeAmarelo()), c);
		c.gridwidth = 1;
		c.gridy = 2;
		c.gridx = 0;
		c.fill = GridBagConstraints.BOTH;
		pnlTab1.add(new CampoDaEnt("Sexo", false, true).setComponent(cmbSexo.pintarDeAmarelo()), c);
		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		pnlTab1.add(new CampoDaEnt("Dt. nascimento", true, true).setComponent(txtDataNascimento.pintarDeAmarelo()), c);
		c.gridx = 2;
		c.gridwidth = 2;
		pnlTab1.add(new CampoDaEnt("Telefone 1", true, true).setComponent(txtTelefone1), c);
		c.gridwidth = 1;
		c.gridx = 4;
		pnlTab1.add(new CampoDaEnt("Telefone 2/ Whatsapp", true, true).setComponent(txtTelefone2), c);
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 5;
		pnlTab1.add(new CampoDaEnt("E-mail", false, true).setComponent(txtEmail), c);
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridx = 0;
		pnlTab1.add(Box.createHorizontalStrut(110), c);
		c.gridx = 1;
		pnlTab1.add(Box.createHorizontalStrut(130), c);
		c.gridx = 2;
		pnlTab1.add(Box.createHorizontalStrut(30), c);
		c.gridx = 3;
		pnlTab1.add(Box.createHorizontalStrut(100), c);
		c.gridx = 4;
		pnlTab1.add(Box.createHorizontalStrut(130), c);
		c.gridx = 5;
		pnlTab1.add(Box.createHorizontalStrut(120), c);

		PnlDoTabbedPane pnlTab2 = new PnlDoTabbedPane(new BorderLayout());
		pnlTab2.add(pnlEndereco, BorderLayout.PAGE_START);
		pnlTab2.add(new CampoDaEnt("Observações", false, true).setComponent(new JScrollPane(txtObservacoes,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), false, true, true,
				true), BorderLayout.CENTER);

		PnlDoTabbedPane pnlTab3 = new PnlDoTabbedPane(new BorderLayout());
		pnlTab3.add(scrExames, BorderLayout.CENTER);
		MyJButton b = new MyJButton("Laudo / Foto") {

			@Override
			public void setEnabled(boolean b) {
				super.setEnabled(!b); // To change body of generated methods, choose Tools | Templates.
			}
		};
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] sr = scrExames.getSelectedResult();
				if (sr == null) {
					SwingUtils.mostrarAviso(PnlPaciente.this, "Escolha um exame!");
					return;
				}
				ProcDoAtd p = c_Paciente.getProc((int) sr[0]);
				LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
				FormPrincipal.getInstance().mostrarTela(TelaPrincipal.LAUDO_E_CAPTURA, new TelaSolicitanteNull());
				PnlLaudoeCia.getInstance().abrirModuloDeLaudo(p.getAtendimento(), p);
				LaudoeCia.getTelaPrincipal().setCursorToDefaultCursor();
			}
		});
		MyJPanel pnl = new MyJPanel(new FlowLayout());
		pnl.add(new CampoDaEnt(false, false, true).setComponent(b));
		pnlTab3.add(pnl, BorderLayout.PAGE_END);

		tabPane.addTab("Dados principais", pnlTab1);
		tabPane.addTab("Endereço e observações", pnlTab2);
		tabPane.addTab("Histórico", pnlTab3);
		setLayout(new CardLayout());
		add(tabPane);

	}

	@Override
	protected <ID> void controladorWasSet(C_EntidadeComCrud<Paciente, ID> controlador) {
		c_Paciente = (C_EntidadePaciente) controlador;
		txtNome.addAutoCompletarListener(new AutoCompletarListener() {

			@Override
			public void linhaSelecionadaMudou(Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada) {
				final Paciente p = buscador.getSelectedModel();
				if (p != null) {
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							c_Paciente.verPaciente(p);
						}

					});
				}
			}

		});
	}

	@Override
	public boolean mostrarDadosDaEntidadeOk(final Paciente entidade, int contador) {
		switch (contador) {
		case 0:
			txtCodigo.setText(entidade.getCodigo());
			txtDataDeCadastro.setText(entidade.getDataDeCadastro());
			txtDataNascimento.setText(entidade.getDataNascimento());
			txtEmail.setText(entidade.getEmail());
			txtNome.setText(entidade.getNome());
			if (entidade.getTelefone1().length() == 10) {
				txtTelefone1.setText(FormatarTelefone.getInstance().format("(##)####-#####", entidade.getTelefone1()));
			} else if (entidade.getTelefone2().length() == 10) {
				txtTelefone2.setText(FormatarTelefone.getInstance().format("(##)####-#####", entidade.getTelefone2()));
			} else {
				txtTelefone1.setText(entidade.getTelefone1());
				txtTelefone2.setText(entidade.getTelefone2());
			}
			cmbSexo.setSelectedItem(entidade.getSexo());
			chkAnonimo.setSelected(entidade.isAnonimo());
			alterarTitulo(entidade);
			return false;
		case 1:
			entidade.getFoto();
			return false;
		case 2:
			Imagem foto = entidade.getFoto();
			if (foto == null) {
				pnlFoto.setImagem(null);
			} else {
				pnlFoto.setImagem(foto.getImagem());
			}
			return false;
		case 3:
			txtObservacoes.setText(entidade.getObservacoes());
			pnlEndereco.setEndereco(entidade.getEndereco());
			return false;
		case 4:
			scrExames.updateResultList(new ResultsGenerator() {

				@Override
				public List<Object[]> generateResults() {
					return c_Paciente.listarExames(entidade);
				}
			});
			return true;
		default:
			throw new AssertionError();
		}
	}

	@Override
	public void prepararParaAdicionar(Object dadosIniciais) {
		tabPane.setSelectedIndex(0);
		txtNome.requestFocusInWindow();
		txtNome.setHabilitado(true);
		if (dadosIniciais != null && dadosIniciais instanceof String) {
			txtNome.setText((String) dadosIniciais);
		}
	}

	@Override
	public void prepararParaAlterar(boolean pnlEntidadeWasSelected) {
		txtNome.setHabilitado(false);
		if (pnlEntidadeWasSelected) {
			switch (tabPane.getSelectedIndex()) {
			case 0:
				txtTelefone2.requestFocusInWindow();
				break;
			case 1:
				txtObservacoes.requestFocusInWindow();
				break;
			default:
			}
		} else {
			tabPane.setSelectedIndex(0);
			txtTelefone2.requestFocusInWindow();
		}
	}

	@Override
	public void preencherDadosDaEntidade(Paciente entidadeBase) {
		entidadeBase.setCodigo(txtCodigo.getInt());
		entidadeBase.setDataNascimento(txtDataNascimento.getDate());
		entidadeBase.setEmail(txtEmail.getText());
		entidadeBase.setEndereco(pnlEndereco.getEndereco());
		byte[] novaFoto = pnlFoto.getImagem();
		if (novaFoto == null) {
			entidadeBase.setFoto(null);
		} else {
			Imagem fotoOri = entidadeBase.getFoto();
			if (fotoOri == null || !Arrays.equals(novaFoto, fotoOri.getImagem())) {
				entidadeBase.setFoto(new Imagem(novaFoto));
			}
		}
		entidadeBase.setNome(txtNome.getText());
		entidadeBase.setAnonimo(chkAnonimo.isSelected());
		entidadeBase.setObservacoes(txtObservacoes.getText());
		entidadeBase.setSexo(cmbSexo.getSelectedItem());
		entidadeBase.setTelefone1(txtTelefone1.getText());
		entidadeBase.setTelefone2(txtTelefone2.getText());
	}

	@Override
	public void usarResultadoDaBusca(Object o) {
		if (o instanceof EnderecoPorCep) {
			pnlEndereco.alimentarCamposPorCep(((EnderecoPorCep) o).getEndereco());
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Campos do cadastro">
	private MyJTabbedPane tabPane = new MyJTabbedPane();
	private PnlEndereco pnlEndereco = new PnlEndereco(TelaPrincipal.CADASTRO_PACIENTES);
	private MyJCheckBox chkAnonimo = new MyJCheckBox("Dados Anonimos?");
	private TxtComAutoCompletar txtNome = new TxtComAutoCompletar();
	private TxtReadOnly txtDataDeCadastro = new TxtReadOnly();
	private TxtData txtDataNascimento = new TxtData();
	private CmbEnum<SEXO> cmbSexo = new CmbEnum<>(SEXO.FEMININO, SEXO.MASCULINO);
	private TxtTelefone txtTelefone1 = new TxtTelefone(StaticInfo.getDefaultDDD());
	private TxtTelefone txtTelefone2 = new TxtTelefone(StaticInfo.getDefaultDDD());
	private MyJTextField txtEmail = new MyJTextField();
	private MyJTextArea txtObservacoes = new MyJTextArea();
	private PnlImagemComBotoes pnlFoto = new PnlImagemComBotoes();

	private ScrollResultsDaBusca scrExames = new ScrollResultsDaBusca(new TableConfigurator() {

		@Override
		public String[] columnsTitles() {
			return new String[] { "Codigo", "Atd", "Data", "Procedimento" };
		}

		@Override
		public Class<?>[] columnsClasses() {
			return new Class<?>[] { Integer.class, Integer.class, Date.class, String.class };
		}

		@Override
		public int[] columnsWidths() {
			return new int[] { 0, 70, 100, 0 };
		}

		@Override
		public boolean[] shouldResizeColumns() {
			return new boolean[] { false, false, false, true };
		}

		@Override
		public int[] sortedColumns() {
			return new int[] { 1 };
		}
	});

	{
		InstallSpellcheck.install(txtNome, StaticInfo.mainDictPath(), StaticInfo.userDictPath());
		txtNome.setDocumentFilter(new LimitedLengthDocFilter());
		txtNome.setControlador(buscador);
		txtNome.setSelecionarPrimeiroAposBusca(false);
		txtDataDeCadastro.setConversorDeData(new ConversorDateTimeStampString(true));
		txtEmail.setStrCnfEnabled(false);
	}

	// </editor-fold>
	@Override
	protected void configurarValidacao(Map<String, C_Validacao> validadores) {
		formValidator.add(txtNome, new RequiredFieldValidator(txtNome), new IValidaCampo() {

			private String erro = "";

			@Override
			public boolean validationOk(int tipo) {
				if (txtNome.getText().matches(".*  .*")) {
					erro = "O nome do paciente possui espaços duplicados!";
					return false;
				}
				if (txtNome.getText().startsWith(" ")) {
					erro = "O nome do paciente não pode começar com espaço!";
					return false;
				}
				if (txtNome.getText().endsWith(" ")) {
					erro = "O nome do paciente não pode terminar com espaço!";
					return false;
				}
				erro = "";
				return true;
			}

			@Override
			public String getErrorMessage() {
				return erro;
			}
		}, new IValidaCampo() {

			@Override
			public boolean validationOk(int tipo) {
				int codigo = c_Paciente.getCodigo(txtNome.getText(), txtDataNascimento.getDate());
				return codigo == 0 || codigo == txtCodigo.getInt();
			}

			@Override
			public String getErrorMessage() {
				return "Já existe um paciente com esse nome e essa data de nascimento!";
			}
		});
		formValidator.add(cmbSexo, new RequiredFieldValidator(cmbSexo));
		formValidator.add(txtDataNascimento, new RequiredFieldValidator(txtDataNascimento),
				new TxtDataDeNascValidator(txtDataNascimento));
		formValidator.add(txtEmail, new TxtEmailValidator(txtEmail));
	}

	private void alterarTitulo(Paciente p) {
		if (janela == null) {
			janela = JanelaComTitulo.obterJanela(this);
		}
		if (janela == null) {
		} else if (p == null) {
			janela.setTitulo("Pacientes");
		} else {
			String nome = p.getNome();
			if (nome == null || nome.trim().isEmpty()) {
				janela.setTitulo("Pacientes");
			} else {
				janela.setTitulo(nome + ", " + p.getIdadeOssea());
			}
		}
	}

	@Override
	public void cardSelected(String cardId) {
		if (SimpleC_Cadastro.VIEW_ENTIDADE.equals(cardId)) {
			alterarTitulo(buscador.getSelectedModel());
		} else {
			alterarTitulo(null);
		}
	}

}
