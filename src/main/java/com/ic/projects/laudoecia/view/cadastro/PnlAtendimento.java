/*
 * PnlAtendimento.java
 *
 * Created on 23/04/2012, 09:48:19
 */
package com.ic.projects.laudoecia.view.cadastro;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import br.com.oslunaticos.InstallSpellcheck;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeConvenio;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePacientes;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfSolECrm;
import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeAtendimento;
import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaSolicitanteNull;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.ic.projects.laudoecia.view.dialogs.DlgAtestado;
import com.ic.projects.laudoecia.view.dialogs.DlgEmail;
import com.ic.projects.laudoecia.view.dialogs.DlgProcDoAtd;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.pnl.JanelaComTitulo;
import com.ic.projects.laudoecia.view.validacao.ValidadorDeTabelaRequired;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.FieldReader;
import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.java.utils.Money;
import com.lib.model.abstracao.RESTRICAO_SEXO;
import com.lib.model.abstracao.SEXO;
import com.lib.model.cnv.ConversorDateTimeStampString;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.crud.entidade.validation.TxtDataDeNascValidator;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.maskedfields.TxtTelefone;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJRadioButton;
import com.lib.swing.plus.cps.MyJTextArea;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.CmbEnum;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.plus.utils.TxtReadOnly;
import com.lib.swing.utils.EnterEnviaTab;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlAtendimento extends PnlDaEntidadeComCrud<Atendimento> {

	private BuscadorDeConvenio buscConv = new BuscadorDeConvenio();
	private BuscadorDePacientes buscPac = new BuscadorDePacientes();
	private BuscadorDeProfSolECrm buscProfSol = new BuscadorDeProfSolECrm();
	private TxtConvenioListener txtConvenioListener = new TxtConvenioListener();
	private Atendimento ultimoAtdMostrado;
	private C_EntidadeAtendimento controlador;
	private JanelaComTitulo janela;
	private boolean mostrandoDadosDoPaciente = false;

	public PnlAtendimento() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		MyJPanel pnlUsuarioConvenio = new MyJPanel(new GridBagLayout());
		c.weightx = 1;
		pnlUsuarioConvenio.add(campoDaEntUsuario, c);
		c.gridx = 1;
		pnlUsuarioConvenio.add(new CampoDaEnt("Convênio", true, false).setComponent(txtConvenio.pintarDeAmarelo()), c);
		c.weightx = 0;

		c.gridy = 0;
		c.gridx = 0;
		txtCodigo.setEditable(false);
		add(new CampoDaEnt("Atendimento", false, false).setComponent(txtCodigo.pintarDeAmarelo(), true, false, false, true), c);
		c.gridx = 1;
		add(new CampoDaEnt("Data do cadastro", true, false).setComponent(txtDataHora), c);
		c.gridx = 2;
		c.gridwidth = 6;
		add(pnlUsuarioConvenio, c);
		c.gridx = 8;
		c.gridwidth = 1;
		add(new CampoDaEnt(true, false).setComponent(btnBuscaConv, false, true, false, false), c);

		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 3;
		add(new CampoDaEnt("Paciente", false, true).setComponent(txtPaciente.pintarDeAmarelo()), c);
		c.gridx = 3;
		c.gridwidth = 1;
		add(new CampoDaEnt(true, true).setComponent(btnBuscaPac, false, true, false, false), c);
		c.gridx = 4;
		c.gridwidth = 2;
		add(new CampoDaEnt("Dt. nascimento", true, true).setComponent(txtDataNasc.pintarDeAmarelo()), c);
		c.gridx = 6;
		c.gridwidth = 1;
		add(new CampoDaEnt("Sexo", true, true).setComponent(cmbSexo.pintarDeAmarelo()), c);
		c.gridx = 7;
		c.gridwidth = 2;
		add(new CampoDaEnt("Telefone", true, true).setComponent(txtTelefone), c);

		MyJPanel pnlProfSol = new MyJPanel(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;
		pnlProfSol.add(new CampoDaEnt("Conselho", false, true).setComponent(cmbConselho), c2);
		c2.gridx = 1;
		pnlProfSol.add(new CampoDaEnt("UF", true, true).setComponent(cmbUF), c2);
		c2.gridx = 2;
		txtNumConselho.addKeyListener(new EnterEnviaTab(true));
		pnlProfSol.add(new CampoDaEnt("Nº no conselho   ", true, true).setComponent(txtNumConselho, false, true, true, true), c2);
		c2.gridx = 3;
		pnlProfSol.add(new CampoDaEnt(true, true).setComponent(btnBuscaProfSol, false, true, true, false), c2);
		c2.gridx = 4;
		c2.weightx = 1;
		pnlProfSol.add(new CampoDaEnt("Nome do prof. solicitante", true, true).setComponent(txtProfSol, false, true, true, true), c2);
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 9;
		add(pnlProfSol, c);

		c.gridy = 3;
		c.gridx = 0;
		scrpTabela.setMinimumSize(new Dimension(50, 93));
		add(new CampoDaEnt(false, false, true).setComponent(scrpTabela), c);

		MyJPanel pnlBtns = new MyJPanel(new GridBagLayout());
		GridBagConstraints c3 = new GridBagConstraints();
		pnlBtns.add(new CampoDaEnt(false, false, true).setComponent(btnAddProc, false, false, true, true), c3);
		c3.gridx = 1;
		pnlBtns.add(new CampoDaEnt(false, true, true).setComponent(btnEditProc, false, false, true, true), c3);
		c3.gridx = 2;
		pnlBtns.add(new CampoDaEnt(false, true, true).setComponent(btnDelProc, false, false, true, true), c3);
		c3.weightx = 1;
		c3.gridx = 3;
//		pnlBtns.add(new CampoDaEnt(false, true, true).setComponent(btnEmailProc, true, true, false, true), c3);
//		c3.gridx = 3;
		pnlBtns.add(Box.createHorizontalStrut(0), c3);
		c3.weightx = 0;
		c3.gridx = 4;
		pnlBtns.add(new CampoDaEnt(false, true, true).setComponent(btnAtestado, true, true, false, true), c3);
		c3.gridx = 5;
		pnlBtns.add(new CampoDaEnt(false, true, true).setComponent(btnLaudo, true, true, false, true), c3);
		c3.gridx = 6;
		pnlBtns.add(new CampoDaEnt(false, true, true).setComponent(btnCaptura, true, true, false, true), c3);

		c.gridy = 4;
		add(pnlBtns, c);

		c.gridy = 5;
		c.weighty = 1d;
		add(new CampoDaEnt("Observações / Informações úteis", false, true).setComponent(new JScrollPane(txtObservacoes,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), false, true, true, true), c);

		MyJPanel pnlTotalPac = new MyJPanel(new GridBagLayout());
		GridBagConstraints c4 = new GridBagConstraints();
		pnlTotalPac.add(new PnlComp(false, true, true).setComponent(Box.createHorizontalStrut(0)), c4);
		c4.gridx = 1;
		pnlTotalPac.add(new CampoDaEnt(false, true, true).setComponent(Box.createHorizontalStrut(0)), c4);
		c4.gridx = 2;
		pnlTotalPac.add(new CampoDaEnt(false, true, true).setComponent(Box.createHorizontalStrut(0)), c4);
		c4.gridx = 3;
		c4.weightx = 1;
		pnlTotalPac.add(Box.createHorizontalStrut(0), c4);
		c4.gridx = 4;
		c4.weightx = 0;
		pnlTotalPac.add(new PnlComp(false, false, true).setComponent(lblTotal), c4);
		c4.gridx = 5;
		pnlTotalPac.add(new CampoDaEnt(false, true, true).setComponent(txtTotalPac, false, true, false, true), c4);
		txtTotalPac.setColumns(7);

		c.weighty = 0;
		c.gridy = 6;
		add(pnlTotalPac, c);

		// codigo
		c.gridy = 7;
		c.gridx = 0;
		c.gridwidth = 1;
		add(Box.createHorizontalStrut(100), c);

		// data do atd
		c.gridx = 1;
		add(Box.createHorizontalStrut(160), c);

		// txt paciente e solicitante
		c.gridx = 2;
		c.weightx = 1;
		add(Box.createHorizontalStrut(0), c);

		// sexo
		c.gridx = 6;
		c.weightx = 0;
		add(Box.createHorizontalStrut(75), c);

		// telefone
		c.gridx = 7;
		add(Box.createHorizontalStrut(75), c);

	}

	@Override
	protected <ID> void controladorWasSet(C_EntidadeComCrud<Atendimento, ID> controlador) {
		this.controlador = (C_EntidadeAtendimento) controlador;
	}

	@Override
	protected void configurarValidacao(Map<String, C_Validacao> validadores) {
		formValidator.add(txtConvenio, new RequiredFieldValidator(buscConv));
		formValidator.add(txtPaciente, new RequiredFieldValidator(txtPaciente), new IValidaCampo() {

			private String erro = "";

			@Override
			public boolean validationOk(int tipo) {
				if (buscPac.getLinhaSelecionada() != null) {
					return true;
				}
				if (txtPaciente.getText().matches(".*  .*")) {
					erro = "O nome do paciente possui espaços duplicados!";
					return false;
				}
				if (txtPaciente.getText().startsWith(" ")) {
					erro = "O nome do paciente não pode começar com espaço!";
					return false;
				}
				if (txtPaciente.getText().endsWith(" ")) {
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
		}, validadores.get("paciente").set(new FieldReader() {
			@Override
			public Object readField() {
				return buscPac;
			}

		}), new IValidaCampo() {

			@Override
			public boolean validationOk(int tipo) {
				if (buscPac.getLinhaSelecionada() == null) {
					return !controlador.pacienteExiste(txtPaciente.getText(), txtDataNasc.getDate());
				}
				return true;
			}

			@Override
			public String getErrorMessage() {
				return "Já existe um paciente com esse nome e essa data de nascimento!";
			}
		});
		formValidator.add(txtDataNasc, new RequiredFieldValidator(txtDataNasc), new TxtDataDeNascValidator(txtDataNasc));
		formValidator.add(cmbSexo, new RequiredFieldValidator(cmbSexo));
		formValidator.add(txtNumConselho, new RequiredFieldValidator(txtNumConselho) {

			@Override
			public String getErrorMessage() {
				return "O número no conselho é obrigatório se o nome for informado!";
			}

			@Override
			public boolean validationOk(int tipo) {
				return txtProfSol.getText().trim().isEmpty() || super.validationOk(tipo);
			}
		});
		formValidator.add(txtProfSol, new RequiredFieldValidator(txtProfSol) {

			@Override
			public String getErrorMessage() {
				return "O nome é obrigatório se o número no conselho for informado!";
			}

			@Override
			public boolean validationOk(int tipo) {
				return txtNumConselho.getText().trim().isEmpty() || super.validationOk(tipo);
			}
		});
		formValidator.add(scrpTabela, new ValidadorDeTabelaRequired(scrpTabela), new ValidadorDeRestricaoDeSexo());
	}

	@Override
	protected void prepararParaAdicionar(Object dadosIniciais) {
		cmbConselho.setSelectedItem(new TISS_Conselho("CRM"));
		cmbUF.setSelectedItem(StaticInfo.getDefaultUF());
		txtConvenio.requestFocusInWindow();
		rdbGravarNao.setSelected(true);
	}

	@Override
	protected void prepararParaAlterar(boolean pnlEntidadeWasSelected) {
		txtObservacoes.requestFocusInWindow();
	}

	@Override
	protected boolean mostrarDadosDaEntidadeOk(Atendimento entidade, int contador) {
		//ultimoAtdMostrado = entidade;
		switch (contador) {
		case 0:
			txtCodigo.setText(entidade.getCodigo());
			txtDataHora.setText(entidade.getDataAtendimento());
			preencherUsuario(entidade.getCodigo());
			txtObservacoes.setText(entidade.getObservacoes());
			rdbGravarSim.setSelected(entidade.isGravarExame());
			rdbGravarNao.setSelected(!entidade.isGravarExame());
			buscPac.setSelectedModel(null);
			mostrandoDadosDoPaciente = true;
			buscPac.setSelectedModel(entidade.getPaciente());
			mostrandoDadosDoPaciente = false;
			return false;
		case 1:
			buscConv.setSelectedModel(entidade.getConvenio());
			return false;
		case 2:
			buscProfSol.setSelectedModel(entidade.getSolicitante());
			return false;
		case 3:
			if (entidade.getProcedimentos().isEmpty()) {
				scrpTabela.limparTabela();
				return true;
			}
			return false;
		case 4:
			final List<Object[]> linhasDaTabela = new ArrayList<>();
			List<ProcDoAtd> procedimentos = entidade.getProcedimentos();
			for (int i = 0; i < procedimentos.size(); i++) {
				ProcDoAtd p = procedimentos.get(i);
				linhasDaTabela
						.add(new Object[] { p, p.getProfExecutante() == null ? 0 : p.getProfExecutante().getCodigo(),
								p.getPrevEntregaLaudo(), p.getValorPaciente() });
			}
			scrpTabela.updateResultList(new ResultsGenerator() {
				@Override
				public List<Object[]> generateResults() {
					return linhasDaTabela;
				}

			});
			return true;
		default:
			throw new AssertionError();
		}
	}

	@Override
	public void preencherDadosDaEntidade(Atendimento atendimento) {
		if (txtCodigo.isEditable()) {
			atendimento.setCodigo(txtCodigo.getInt());
		}
		atendimento.setConvenio(buscConv.getSelectedModel());
		Paciente pac = buscPac.getSelectedModel();
		if (pac == null) {
			pac = new Paciente();
		}
		pac.setNome(txtPaciente.getText());
		pac.setDataNascimento(txtDataNasc.getDate());
		pac.setSexo(cmbSexo.getSelectedItem());
		if (txtTelefone.getText().length() < 11) {
			pac.setTelefone1("");
		} else {
			pac.setTelefone1(txtTelefone.getText());
		}
		atendimento.setPaciente(pac);
		if (txtNumConselho.getText().trim().isEmpty()) {
			atendimento.setSolicitante(null);
		} else {
			ProfSolicitante prof = buscProfSol.getSelectedModel();
			if (prof == null) {
				prof = new ProfSolicitante();
			}
			prof.setNome(txtProfSol.getText());
			prof.setUfConselho(cmbUF.getSelectedItem());
			prof.setConselho(cmbConselho.getSelectedItem());
			prof.setNumNoConselho(txtNumConselho.getText());
			atendimento.setSolicitante(prof);
		}

		List<ProcDoAtd> listaProc = gerarListaProcs(scrpTabela.getResults(), atendimento);
		atendimento.setProcedimentos(listaProc);
		atendimento.setObservacoes(txtObservacoes.getText());
		atendimento.setGravarExame(rdbGravarSim.isSelected());
	}

	@Override
	public void usarResultadoDaBusca(Object o) {
		if (o instanceof Convenio) {
			Convenio c = (Convenio) o;
			if (c.isAtivo()) {
				txtConvenio.requestFocusInWindow();
				buscConv.setSelectedModel(c);
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						txtPaciente.requestFocusInWindow();
					}

				});
			} else {
				SwingUtils.mostrarMensagemDeErroConhecido(this, "O convênio " + "está inativo");
			}
		} else if (o instanceof Paciente) {
			Paciente p = (Paciente) o;
			buscPac.setSelectedModel(p);
			ultimoAtdMostrado.setPaciente(p);
			txtNumConselho.requestFocusInWindow();
		} else if (o instanceof ProfSolicitante) {
			ProfSolicitante ps = (ProfSolicitante) o;
			buscProfSol.setSelectedModel(ps);
		} else {
			// assertion error
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Componentes do Pnl">

	private TxtReadOnly txtDataHora = new TxtReadOnly();
	private TxtReadOnly txtUsuario = new TxtReadOnly();
	private CampoDaEnt campoDaEntUsuario = new CampoDaEnt("Usuário", true, false).setComponent(txtUsuario);
	private TxtComAutoCompletar txtConvenio = new TxtComAutoCompletar(buscConv);
	private BtnFKey btnBuscaConv = new BtnFKey();
	private TxtComAutoCompletar txtPaciente = new TxtComAutoCompletar(buscPac);
	private BtnFKey btnBuscaPac = new BtnFKey();
	private TxtData txtDataNasc = new TxtData();
	private CmbEnum<SEXO> cmbSexo = new CmbEnum<>(SEXO.FEMININO, SEXO.MASCULINO);
	private TxtTelefone txtTelefone = new TxtTelefone(StaticInfo.getDefaultDDD());
	private MyJTextField txtProfSol = new MyJTextField();
	private BtnFKey btnBuscaProfSol = new BtnFKey();
	private MyJComboBox<UF> cmbUF = new MyJComboBox<>(StaticInfo.getUfs());
	private MyJComboBox<TISS_Conselho> cmbConselho = new MyJComboBox<>(StaticInfo.getTiss_Conselhos());
	private TxtComAutoCompletar txtNumConselho = new TxtComAutoCompletar(buscProfSol);
	private ScrollResultsDaBusca scrpTabela = new ScrollResultsDaBusca(new TableConfigurator() {
		@Override
		public String[] columnsTitles() {
			return new String[] { "Procedimento médico", "Prof. ex.", "Prev. entrega", "Valor paciente" };
		}

		@Override
		public Class<?>[] columnsClasses() {
			return new Class<?>[] { Object.class, Object.class, Date.class, Object.class };
		}

		@Override
		public int[] columnsWidths() {
			return new int[] { 0, 75, 100, 100 };
		}

		@Override
		public boolean[] shouldResizeColumns() {
			return new boolean[] { true, false, false, false };
		}

		@Override
		public int[] sortedColumns() {
			return new int[] { 0 };
		}

	});
	private MyJButton btnAddProc = new MyJButton("Adicionar");
	private MyJButton btnEditProc = new MyJButton("Alterar");
	private MyJButton btnDelProc = new MyJButton("Remover");
	//private MyJButton btnEmailProc = new MyJButton("E-mail");
	private MyJButton btnAtestado = new MyJButton("Atestado");
	private MyJButton btnLaudo = new MyJButton("Laudo/Foto");
	private MyJButton btnCaptura = new MyJButton("Captura");
	private MyJTextArea txtObservacoes = new MyJTextArea();
	private LblNegrito lblGravar = new LblNegrito("Gravar procedimento em vídeo?");
	private ButtonGroup btgGravar = new ButtonGroup();
	private MyJRadioButton rdbGravarSim = new MyJRadioButton("Sim");
	private MyJRadioButton rdbGravarNao = new MyJRadioButton("Não");
	private LblNegrito lblTotal = new LblNegrito("Valor total paciente");
	private MyJTextField txtTotalPac = new MyJTextField();
	private boolean adicionandoProc = false;
	private boolean listenerProfSolEnabled = true;

	{

		InstallSpellcheck.install(txtPaciente, StaticInfo.mainDictPath(), StaticInfo.userDictPath());

		txtDataHora.setConversorDeData(new ConversorDateTimeStampString(true));

		txtUsuario.addDocumentListener(new TxtChangedListener() {

			@Override
			public void textChanged(DocumentEvent de) {
				final String login = txtUsuario.getText();
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						campoDaEntUsuario.setVisible(!(login == null || login.isEmpty()));
					}

				});
			}
		});
		campoDaEntUsuario.setVisible(false);

		txtConvenio.setStrictMatching(true);
		txtConvenio.setMensagemDeErro("Convênio não encontrado");
		txtConvenio.addAutoCompletarListener(txtConvenioListener);
		txtConvenio.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtConvenio.isEditable()) {
					txtConvenio.selectAll();
				}
			}
		});

		btnBuscaConv.addActionListener(new ActionAddTela(TelaPrincipal.CADASTRO_CONVENIOS,
				new TelaSolPadrao(TelaPrincipal.ATENDIMENTO, txtConvenio), new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaConvenio();
					}

				}));

		txtPaciente.addAutoCompletarListener(new AutoCompletarListener() {
			@Override
			public void linhaSelecionadaMudou(final Object[] oldLinhaSelecionada, final Object[] newLinhaSelecionada) {
				final Paciente paciente = buscPac.getSelectedModel();
				if (paciente == null) {
					txtDataNasc.setText("");
					cmbSexo.setSelectedItem(null);
					txtTelefone.setText("");
				} else {
					txtDataNasc.setText(paciente.getDataNascimento());
					cmbSexo.setSelectedItem(paciente.getSexo());
					txtTelefone.setText(paciente.getTelefone1());

				}
				mostrarIdadeOssea(paciente);
				if (txtObservacoes.isEditable() && !mostrandoDadosDoPaciente) {
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							formValidator.revalidate(txtDataNasc);
							formValidator.revalidate(cmbSexo);
							if (pacienteMudou() && controlador.jaExisteAtdHoje(paciente)) {
								mostrarAviso("Alerta: já existe um atendimento " + "cadastrado para esse paciente "
										+ "com a data de hoje!");
							}
						}

						private boolean pacienteMudou() {
							if (Objects.equals(newLinhaSelecionada, oldLinhaSelecionada)) {
								return false;
							}
							if (newLinhaSelecionada != null && oldLinhaSelecionada != null
									&& Objects.equals(newLinhaSelecionada[2], oldLinhaSelecionada[2])) {
								return false;
							}
							return true;
						}

					});
				}
			}

		}, true);
		txtPaciente.setLargura(1.5d);
		txtPaciente.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtPaciente.isEditable()) {
					txtPaciente.selectAll();
				}
			}
		});

		btnBuscaPac.addActionListener(new ActionAddTela(TelaPrincipal.CADASTRO_PACIENTES,
				new TelaSolPadrao(TelaPrincipal.ATENDIMENTO, txtPaciente), new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaPaciente();
					}

				}));

		cmbConselho.setFocusable(false);
		cmbConselho.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					buscProfSol.setConselho(cmbConselho.getSelectedItem());
				}
			}
		});

		cmbUF.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					buscProfSol.setUf(cmbUF.getSelectedItem());
				}
			}
		});
		cmbUF.setFocusable(false);

		txtNumConselho.addAutoCompletarListener(new AutoCompletarListener() {
			@Override
			public void linhaSelecionadaMudou(Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada) {
				ProfSolicitante ps = buscProfSol.getSelectedModel();
				if (ps == null) {
					if (txtObservacoes.isEditable()) {
						txtProfSol.setEditable(true);
					}
					txtProfSol.setText("");
				} else {
					cmbUF.setSelectedItem(ps.getUfConselho());
					cmbConselho.setSelectedItem(ps.getConselho());
					txtProfSol.setText(ps.getNome());
					txtProfSol.setEditable(false);
					if (txtObservacoes.isEditable()) {
						if (ultimoAtdMostrado.getProcedimentos().isEmpty() && listenerProfSolEnabled) {
							btnAddProc.requestFocusInWindow();
							java.awt.EventQueue.invokeLater(new Runnable() {
								@Override
								public void run() {
									btnAddProcAction();
								}

							});
						}
					}
				}
			}

		});
		txtNumConselho.setBtnAutoCompletarPodeSerVisivel(false);
		txtNumConselho.setLargura(5d);
		txtNumConselho.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (txtNumConselho.isEditable()) {
					txtNumConselho.selectAll();
				}
			}
		});

		txtProfSol.setFocusTraversalKeysEnabled(false);
		txtProfSol.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_TAB:
				case KeyEvent.VK_ENTER:
					if (txtObservacoes.isEditable() && scrpTabela.getResults().isEmpty()) {
						btnAddProc.requestFocusInWindow();
						java.awt.EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								btnAddProcAction();
							}

						});
					}
					break;
				default:
				}
			}
		});

		btnBuscaProfSol.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buscarSolAction();
			}
		});
		btnBuscaProfSol.setToolTipText("Procurar solicitante");
		btnBuscaProfSol.setIcon(SwingLibResources.getIcon(Imagens.BUSCA));

		btnAddProc.setIcon(SwingLibResources.getIcon(Imagens.ADICIONAR));
		btnAddProc.setToolTipText("Adicionar um novo procedimento");
		btnAddProc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddProcAction();
			}

		});

		btnEditProc.setIcon(SwingLibResources.getIcon(Imagens.ALTERAR));
		btnEditProc.setToolTipText("Alterar procedimento selecionado");
		btnEditProc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEditProcAction();
			}

		});

		btnDelProc.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
		btnDelProc.setToolTipText("Remover procedimento selecionado");
		btnDelProc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDelProcAction();
			}

		});

//		btnEmailProc.setIcon(ImageResources.getIcon(ImagensLC.ENVIOEMAIL));
//		btnEmailProc.setToolTipText("Enviar para E-mail");
//		btnEmailProc.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					if(procSel().getLaudo() != null){
//					DlgEmail dialogo = DlgEmail.getInstance(ultimoAtdMostrado, procSel());
//					}else{
//						JOptionPane.showMessageDialog(null, "Laudo não foi criado");
//					}
//				} catch (Exception aff) {
//					aff.printStackTrace();
//				}
//
//			}
//
//		});

		btnAtestado.setIcon(ImageResources.getIcon(ImagensLC.ATESTADO));
		btnAtestado.setToolTipText("Imprimir atestado.");
		btnAtestado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarBtnLaudoECaptura()) {
					LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
					DlgAtestado dlgAtestado = new DlgAtestado(PnlAtendimento.this, buscPac.getSelectedModel(),ultimoAtdMostrado.getDataAtendimento());
					dlgAtestado.setVisible(true);
					LaudoeCia.getTelaPrincipal().setCursorToDefaultCursor();
				}
			}

		});

		btnLaudo.setIcon(ImageResources.getIcon(ImagensLC.LAUDO_SMALL));
		btnLaudo.setToolTipText("Abrir módulo de laudos.");
		btnLaudo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarBtnLaudoECaptura()) {
					LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
					FormPrincipal.getInstance().mostrarTela(TelaPrincipal.LAUDO_E_CAPTURA, new TelaSolicitanteNull());
					PnlLaudoeCia.getInstance().abrirModuloDeLaudo(ultimoAtdMostrado, procSel());
					LaudoeCia.getTelaPrincipal().setCursorToDefaultCursor();					
				}
			}

		});

		btnCaptura.setIcon(ImageResources.getIcon(ImagensLC.CAPTURA_SMALL));
		btnCaptura.setToolTipText("Abrir módulo de captura.");
		btnCaptura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarBtnLaudoECaptura()) {
					LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
					FormPrincipal.getInstance().mostrarTela(TelaPrincipal.LAUDO_E_CAPTURA, new TelaSolicitanteNull());
					PnlLaudoeCia.getInstance().abrirModuloDeCaptura(ultimoAtdMostrado, procSel());
					LaudoeCia.getTelaPrincipal().setCursorToDefaultCursor();
				}
			}

		});

		btgGravar.add(rdbGravarSim);
		btgGravar.add(rdbGravarNao);

		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

		txtTotalPac.setEditable(false);

		scrpTabela.setFocusable(true);
		scrpTabela.setPermiteValorIgual(true);
		scrpTabela.getTabela().setFocusable(true);
		scrpTabela.getTabela().getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				Money valorTotal = new Money(0);
				List<Object[]> results = scrpTabela.getResults();
				for (int i = 0; i < results.size(); i++) {
					Object[] objects = results.get(i);
					valorTotal.addSet((Money) objects[3]);
				}
				txtTotalPac.setText(valorTotal.doubleValue() == 0 ? "" : valorTotal.toString());
			}

		});
		scrpTabela.getTabela().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && txtConvenio.isEditable()) {
					btnEditProcAction();
				}
			}
		});
		scrpTabela.getTabela().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DELETE:
					btnDelProcAction();
					break;
				case KeyEvent.VK_INSERT:
				case KeyEvent.VK_PLUS:
				case KeyEvent.VK_ADD:
					btnAddProcAction();
					break;
				default:
				}
			}
		});
	}

	// </editor-fold>

	private boolean validarBtnLaudoECaptura() {
		if (txtObservacoes.isEditable()) {
			boolean salvarOk = controlador.salvar();
			if (salvarOk) {
				try {
					// para dar tempo de carregar os dados do atd
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
				}
			}
			return salvarOk;
		}
		return !txtCodigo.getText().isEmpty();
	}

	private void btnAddProcAction() {
		if (adicionandoProc) {
		} else {
			adicionandoProc = true;
			try {
				Convenio conv = buscConv.getSelectedModel();
				if (conv == null) {
					SwingUtils.mostrarAviso(null, "É preciso selecionar" + " um convênio primeiro.");
				} else {
					DlgProcDoAtd d = DlgProcDoAtd.getInstance(conv);
					d.setTitle("Adicionar procedimento...");
					d.setVisible(true);
					if (!d.isCancelado()) {
						ProcDoAtd proc = new ProcDoAtd();
						proc.setCodigo(0);
						proc.setProcDaTabela(d.getProcDaTabela());
						proc.setProfExecutante(d.getProfExecutante());
						proc.setDataDaExecucao(d.getDataExecucao());
						proc.setPrevEntregaLaudo(d.getPrevEntregaLaudo());
						proc.setValorPaciente(d.getValorPaciente());
						proc.setValorConvenio(d.getValorConvenio());
						if (validaUnicidadeProcedimento(d.getProcDaTabela())) {
							Object[] dados = new Object[4];
							dados[0] = proc;
							dados[1] = proc.getProfExecutante() == null ? 0 : proc.getProfExecutante().getCodigo();
							dados[2] = proc.getPrevEntregaLaudo();
							dados[3] = proc.getValorPaciente();
							scrpTabela.adicionarESelecionarResultado(dados);
						}
						formValidator.revalidate(scrpTabela);
					}
				}
			} finally {
				adicionandoProc = false;
			}
		}
	}

	private void btnEditProcAction() {
		Object[] selectedResult = scrpTabela.getSelectedResult();
		if (selectedResult == null) {
			SwingUtils.mostrarAviso(null, "Selecione um procedimento para alterar!");
			return;
		}
		ProcDoAtd proc = (ProcDoAtd) selectedResult[0];
		if (procIsLocked(proc.getCodigo())) {
			return;
		}
		DlgProcDoAtd d = DlgProcDoAtd.getInstance(buscConv.getSelectedModel());
		d.setTitle("Alterar procedimento...");
		d.setProcDaTabela(proc.getProcDaTabela());
		d.setProfExecutante(proc.getProfExecutante());
		d.setDataExecucao(proc.getDataDaExecucao());
		d.setPrevEntregaLaudo(proc.getPrevEntregaLaudo());
		d.setValorPaciente(proc.getValorPaciente().doubleValue());
		d.setVisible(true);
		if (!d.isCancelado() && validarAlteracaoDeProc(d, proc)) {
			proc.setProcDaTabela(d.getProcDaTabela());
			proc.setProfExecutante(d.getProfExecutante());
			proc.setDataDaExecucao(d.getDataExecucao());
			proc.setPrevEntregaLaudo(d.getPrevEntregaLaudo());
			proc.setValorPaciente(d.getValorPaciente());
			proc.setValorConvenio(d.getValorConvenio());
			Object[] dados = new Object[4];
			dados[0] = proc;
			dados[1] = proc.getProfExecutante() == null ? 0 : proc.getProfExecutante().getCodigo();
			dados[2] = proc.getPrevEntregaLaudo();
			dados[3] = proc.getValorPaciente();
			scrpTabela.atualizarResultadoSelecionado(dados);
			formValidator.revalidate(scrpTabela);
		}
	}

	private void buscarSolAction() {
		DlgSolicitante dlgSol = new DlgSolicitante();
		dlgSol.setVisible(true);
		if (!dlgSol.isCancelado()) {
			ProfSolicitante solicitante = dlgSol.getSolicitante();
			if (solicitante == null) {
				buscProfSol.setSelectedModel(null);
				txtNumConselho.requestFocusInWindow();
			} else if (solicitante.getNumNoConselho() == null || solicitante.getNumNoConselho().trim().isEmpty()) {
				listenerProfSolEnabled = false;
				buscProfSol.setSelectedModel(null);
				cmbUF.setSelectedItem(solicitante.getUfConselho());
				cmbConselho.setSelectedItem(solicitante.getConselho());
				txtProfSol.setText(solicitante.getNome());
				txtNumConselho.requestFocusInWindow();
				listenerProfSolEnabled = true;
			} else if (buscConv.getLinhaSelecionada() == null) {
				listenerProfSolEnabled = false;
				buscProfSol.setSelectedModel(solicitante);
				listenerProfSolEnabled = true;
			} else {
				buscProfSol.setSelectedModel(solicitante);
			}
		}
	}

	private boolean validarAlteracaoDeProc(DlgProcDoAtd d, ProcDoAtd proc) {
		if (d.getProcDaTabela().equals(proc.getProcDaTabela())) {
			return true;
		} else if (validaUnicidadeProcedimento(d.getProcDaTabela())) {
			if (proc.getLaudo() == null) {
				return true;
			} else if (SwingUtils.obterConfirmacaoDoUsuario("Atenção!\nO laudo do"
					+ " exame será original será perdido, mas não as imagens." + " Deseja continuar?",
					this) == JOptionPane.YES_OPTION) {
				proc.setLaudo(null);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private void btnDelProcAction() {
		Object[] selectedResult = scrpTabela.getSelectedResult();
		if (selectedResult != null && SwingUtils.obterConfirmacaoDoUsuario(
				"Atenção!\nO laudo e/ou imagens desse procedimento "
						+ "serão perdidos.\nEssa ação não pode ser desfeita!\n" + "Continuar?",
				this) == JOptionPane.YES_OPTION) {
			if (procIsLocked(((ProcDoAtd) selectedResult[0]).getCodigo())) {
				return;
			}
			scrpTabela.removerResultadoSelecionado();
			formValidator.revalidate(scrpTabela);
		}
	}

	private ProcDoAtd procSel() {
		Object[] selResult = scrpTabela.getSelectedResult();
		if (selResult == null) {
			return null;
		} else {
			return (ProcDoAtd) selResult[0];
		}
	}

	private boolean validaUnicidadeProcedimento(ProcDaTabela proc) {
		List<Object[]> linhasDaTabela = scrpTabela.getResults();
		for (int i = 0; i < linhasDaTabela.size(); i++) {
			ProcDoAtd p = (ProcDoAtd) linhasDaTabela.get(i)[0];
			if (p.getProcDaTabela().equals(proc)) {
				SwingUtils.mostrarMensagemDeErroConhecido(this, "Este procedimento já foi adicionado!");
				return false;
			}
		}
		return true;
	}

	private List<ProcDoAtd> gerarListaProcs(List<Object[]> listaTbl, Atendimento entidadeBase) {
		List<ProcDoAtd> listaProc = new ArrayList<>();
		for (int i = 0; i < listaTbl.size(); i++) {
			Object[] dados = listaTbl.get(i);
			ProcDoAtd proc = (ProcDoAtd) dados[0];
			proc.setAtendimento(entidadeBase);
			listaProc.add(proc);
		}
		return listaProc;
	}

	private void mostrarIdadeOssea(Paciente p) {
		if (janela == null) {
			janela = JanelaComTitulo.obterJanela(this);
		}
		if (janela == null) {
		} else if (p == null) {
			janela.setTitulo("Atendimentos");
		} else {
			janela.setTitulo("Atendimento " + txtCodigo.getText() + ": " + p.getNome() + ", " + p.getIdadeOssea());
		}
	}

	@Override
	public void cardSelected(String cardId) {
		if (SimpleC_Cadastro.VIEW_ENTIDADE.equals(cardId)) {
			mostrarIdadeOssea(buscPac.getSelectedModel());
		} else {
			mostrarIdadeOssea(null);
		}
	}

	private void preencherUsuario(int codigoAtd) {
		Usuario user = controlador.getUsuarioRespPelaAcao(codigoAtd);
		if (user == null) {
			txtUsuario.setText("");
		} else {
			txtUsuario.setText(user.getLogin());
		}
	}

	private boolean procIsLocked(int codigo) {
		EstacaoDeTrabalho est = controlador.procIsLocked(codigo);
		if (est == null) {
			return false;
		}
		mostrarAviso("O procedimento não pode ser alterado porque ele está " + "aberto na estação "
				+ est.getNomeEstacaoDeTrabalho());
		return true;
	}

	private class TxtConvenioListener implements AutoCompletarListener {

		@Override
		public void linhaSelecionadaMudou(final Object[] convenioAntigo, Object[] newLinhaSelecionada) {
			if (newLinhaSelecionada == null) {
			} else {
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						atualizarConvenio();
					}

				});
			}
		}

		private void atualizarConvenio() {
			Convenio conv = buscConv.getSelectedModel();
			if (ultimoAtdMostrado == null || !txtConvenio.isEditable()) {
			} else if (conv == null) {
			} else {
				List<ProcDoAtd> procs = gerarListaProcs(scrpTabela.getResults(), null);
				if (procs.isEmpty()) {
				} else {
					final List<Object[]> linhasDaTabela = new ArrayList<>();
					for (int i = 0; i < procs.size(); i++) {
						ProcDoAtd p = procs.get(i);
						ProcDaTabela pdt = p.getProcMedico().getProcDaTabela(conv);
						if (pdt == null) {
							return;
						}
						p.setProcDaTabela(pdt);
						p.setValorConvenio(pdt.getValorNoConvenio().getValorNoConvenio().doubleValue());
						p.setValorPaciente(pdt.getValorPaciente().doubleValue());
						linhasDaTabela.add(
								new Object[] { p, p.getProfExecutante() == null ? 0 : p.getProfExecutante().getCodigo(),
										p.getPrevEntregaLaudo(), p.getValorPaciente() });
					}
					scrpTabela.updateResultList(new ResultsGenerator() {
						@Override
						public List<Object[]> generateResults() {
							return linhasDaTabela;
						}

					});
				}
			}
		}

	}

	private class ValidadorDeRestricaoDeSexo implements IValidaCampo {
		private ProcDoAtd procAtual;
		private SEXO sexo;

		@Override
		public boolean validationOk(int tipo) {
			sexo = cmbSexo.getSelectedItem();
			if (sexo == null) {
				return true;
			}
			boolean valid = true;
			List<ProcDoAtd> listaProc = gerarListaProcs(scrpTabela.getResults(), null);
			FOR: for (int i = 0; i < listaProc.size(); i++) {
				procAtual = listaProc.get(i);
				RESTRICAO_SEXO restricaoSexo = procAtual.getProcMedico().getRestricaoSexo();
				SWITCH: switch (restricaoSexo) {
				case NENHUMA_RESTRICAO:
					break SWITCH;
				case APENAS_FEMININO:
					if (sexo == SEXO.MASCULINO) {
						valid = false;
						break FOR;
					}
					break SWITCH;
				case APENAS_MASCULINO:
					if (sexo == SEXO.FEMININO) {
						valid = false;
						break FOR;
					}
					break SWITCH;
				default:
				}
			}
			return valid;
		}

		@Override
		public String getErrorMessage() {
			return "O procedimento " + procAtual + " não pode ser feito para pacientes do sexo " + sexo + ".";
		}
	}

	private class DlgSolicitante extends MyJDialog {

		private boolean cancelado = true;
		private ProfSolicitante solicitante;
		private MyJComboBox<UF> cmbUF = new MyJComboBox<>(StaticInfo.getUfs());
		private MyJComboBox<TISS_Conselho> cmbConselho = new MyJComboBox<>(StaticInfo.getTiss_Conselhos());
		private MyJTextField txtBusca = new MyJTextField();
		private ScrollResultsDaBusca scroll = new ScrollResultsDaBusca(new TableConfigurator() {

			@Override
			public String[] columnsTitles() {
				return new String[] { "Núm. no conselho", "Nome" };
			}

			@Override
			public Class<?>[] columnsClasses() {
				return new Class<?>[] { String.class, String.class };
			}

			@Override
			public int[] columnsWidths() {
				return new int[] { 130, 0 };
			}

			@Override
			public boolean[] shouldResizeColumns() {
				return new boolean[] { false, true };
			}

			@Override
			public int[] sortedColumns() {
				return new int[] { 1 };
			}

		});
		private MeuSw meuSw;

		{
			cmbConselho.setFocusable(false);
			cmbConselho.setSelectedItem(new TISS_Conselho("CRM"));
			cmbUF.setSelectedItem(StaticInfo.getDefaultUF());
			cmbUF.setFocusable(false);
			txtBusca.addDocumentListener(new TxtChangedListener() {

				@Override
				public void textChanged(DocumentEvent de) {
					if (txtBusca.isEditable() && txtBusca.isFocusOwner()) {
						if (!(meuSw == null || meuSw.isDone())) {
							meuSw.cancel(false);
						}
						meuSw = new MeuSw();
						meuSw.execute();
					}
				}
			});
		}

		private DlgSolicitante() {
			super(PnlAtendimento.this, true, 500, 300);
			setTitle("Busca de profissionais solicitantes");
			setContentPane(new PnlComEspaco(criarContentPane()));
		}

		private Container criarContentPane() {
			MyJPanel pnl = new MyJPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;

			c.gridx = 0;
			c.gridy = 0;
			pnl.add(new PnlComp("UF", false, true).setComponent(cmbUF), c);
			c.gridx = 1;
			pnl.add(new PnlComp("Conselho", true, true).setComponent(cmbConselho), c);
			c.gridx = 2;
			c.weightx = 1;
			pnl.add(new PnlComp("Núm. no conselho ou nome do solicitante", true, true).setComponent(txtBusca), c);

			c.weightx = 0;
			c.weighty = 1;
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 3;
			pnl.add(new PnlComp("Resultados da busca", false, true).setComponent(scroll), c);

			MyJButton btnOk = new MyJButton("Confirmar");
			btnOk.setIcon(SwingLibResources.getIcon(Imagens.OK));
			btnOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (scroll.getSelectedResult() == null) {
						if (txtBusca.getText().trim().isEmpty()) {
							SwingUtils.mostrarAviso(DlgSolicitante.this, "" + "Nenhum resultado selecionado!");
						} else {
							solicitante = new ProfSolicitante();
							solicitante.setConselho(cmbConselho.getSelectedItem());
							solicitante.setUfConselho(cmbUF.getSelectedItem());
							if (txtBusca.getText().matches("[0-9]+")) {
								solicitante.setNumNoConselho(txtBusca.getText().trim());
							} else {
								solicitante.setNome(txtBusca.getText());
							}
							cancelado = false;
							fechar();
						}
					} else {
						solicitante = buscProfSol
								.getModel(new Object[] { cmbConselho.getSelectedItem(), cmbUF.getSelectedItem(),
										scroll.getSelectedResult()[0], scroll.getSelectedResult()[1] });
						cancelado = false;
						fechar();
					}
				}
			});
			MyJButton btnCancelar = new MyJButton("Cancelar");
			btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
			btnCancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			MyJPanel pnlBotoes = new MyJPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
			pnlBotoes.add(btnOk);
			pnlBotoes.add(btnCancelar);
			c.gridy = 2;
			c.weighty = 0;
			c.insets.top = 5;
			pnl.add(new PnlComp(false, false, false).setComponent(pnlBotoes), c);

			return pnl;
		}

		private boolean isCancelado() {
			return cancelado;
		}

		private ProfSolicitante getSolicitante() {
			return solicitante;
		}

		@Override
		public void fechar() {
			dispose();
		}

		private class MeuSw extends SwingWorker<List<Object[]>, Void> {

			@Override
			protected List<Object[]> doInBackground() throws Exception {
				String textoBusca = txtBusca.getText().trim();
				if (textoBusca.isEmpty() || textoBusca.matches("[0-9]+")) {
				} else {
					Thread.sleep(400);
				}
				List<Object[]> r = new ArrayList<>();
				if (!isCancelled()) {
					r.addAll(buscProfSol.buscarNumENome(cmbConselho.getSelectedItem(), cmbUF.getSelectedItem(),
							textoBusca));
				}
				return r;
			}

			@Override
			protected void done() {
				if (isCancelled()) {
					return;
				}
				try {
					final List<Object[]> results = get();
					if (results != null) {
						scroll.updateResultList(new ResultsGenerator() {
							@Override
							public List<Object[]> generateResults() {
								return results;
							}

						});
					}
				} catch (CancellationException | InterruptedException | ExecutionException e) {
				}
			}

		}

	}

}
