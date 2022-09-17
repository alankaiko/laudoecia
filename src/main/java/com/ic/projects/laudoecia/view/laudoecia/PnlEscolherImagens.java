/*
 * PnlEscolherImagens.java
 *
 * Created on 09/05/2012, 16:51:09
 */

package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.ImagemImpressa;
import com.ic.projects.laudoecia.model.cadastro.PaginaDeImagens;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout12Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout15Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout1Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout1ImgPrinter;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout2Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout2ImgGrande;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout3Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout4ImgGrandes;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout4ImgMedias;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout4ImgPequenas;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout6Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout6ImgGrandes;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout8Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout8ImgGrandes;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayout9Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutImagens;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutLaudoE4Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutLaudoE5Img;
import com.ic.projects.laudoecia.view.print.LaudosHTMLUtils;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.BtnSoImagem;
import com.lib.swing.plus.utils.BtnTextoEmBaixo;
import com.lib.swing.plus.utils.CmbEnum;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.SpinnerInt;
import com.lib.swing.utils.SwingUtils;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlEscolherImagens extends MyJPanel implements ViewImagens {

	private LaudoeCiaMediator mediador;
	private List<PnlImgMiniatura> listaMiniaturas = new ArrayList<>();
	private List<MyPnlPagina> listaDePaginas = new ArrayList<>();
	private MyPnlPagina paginaAtual;
	private MeuSw meuSw;

	public PnlEscolherImagens(LaudoeCiaMediator mediador) {
		super(new BorderLayout());
		this.mediador = mediador;
		initializeComponents();

		updateIndexes();
	}

	private void initializeComponents() {
		initializeMenuLayout();
		initializeMenuSuperior();
		initializeLayoutView();
		initializeMenuMiniaturas();
		initializePainelMiniaturas();

		setBorder(new BlackAndWhiteEtchedBorder());
		add(pnlMenuSup, BorderLayout.NORTH);
		add(scrpLayout, BorderLayout.CENTER);
		add(pnlInferior, BorderLayout.SOUTH);
	}

	// <editor-fold defaultstate="collapsed" desc="Menu Layout">

	private boolean estaSelecionandoPagina = false;

	// <editor-fold defaultstate="collapsed" desc="Componentes">

	private MyJPanel pnlMenuLayout = new MyJPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
	private LblNegrito lblPagina = new LblNegrito("Página");
	private SpinnerInt spnPagina = new SpinnerInt(0, 0, 1);
	private LblNegrito lblTotalPagina = new LblNegrito("de 1");
	private MyJButton btnAddPagina = new MyJButton();
	private MyJButton btnRemovePagina = new MyJButton();
	private LblNegrito lblLayout = new LblNegrito("Layout de Imagens");
	private CmbEnum<LAYOUT_IMG> cmbLayout = new CmbEnum<>(
			LAYOUT_IMG.LAYOUT_1_IMG, LAYOUT_IMG.LAYOUT_1_IMG);

	{
		pnlMenuLayout.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

		spnPagina.setPreferredSize(new Dimension(50, spnPagina
				.getPreferredSize().height));
		spnPagina.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				selectPagina(spnPagina.getValue());
			}
		});

		btnAddPagina.setIcon(SwingLibResources.getIcon(Imagens.ADICIONAR));
		btnAddPagina.setToolTipText("Adicionar página");
		btnAddPagina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addPagina(StaticInfo.getParametrosDoSistema().getLayoutImagem());
			}
		});

		btnRemovePagina.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
		btnRemovePagina.setToolTipText("Remover página atual");
		btnRemovePagina.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removePaginaAtual();
			}
		});

		cmbLayout.setMaximumRowCount(200);
		cmbLayout.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch (e.getStateChange()) {
				case ItemEvent.SELECTED:
					cmbLayoutAction();
					break;
				default:
				}
			}
		});
	}

	private void initializeMenuLayout() {
		pnlMenuLayout.add(lblPagina);
		pnlMenuLayout.add(spnPagina);
		pnlMenuLayout.add(lblTotalPagina);
		pnlMenuLayout.add(btnAddPagina);
		pnlMenuLayout.add(btnRemovePagina);
		pnlMenuLayout.add(Box.createHorizontalStrut(5));
		pnlMenuLayout.add(lblLayout);
		pnlMenuLayout.add(cmbLayout);
	}

	// </editor-fold>

	private void selectPagina(int pagina) {
		if (pagina > 0) {
			paginaAtual = listaDePaginas.get(pagina - 1);
			pnlPageAlternate.setSelectedCard(paginaAtual.getIdentificador());
			paginaAtual.setNumeroDaPagina(pagina);
			estaSelecionandoPagina = true;
			spnPagina.setValue(pagina);
			cmbLayout.setSelectedItem(paginaAtual.getLayoutActive());
			estaSelecionandoPagina = false;
		} else {
			paginaAtual = null;
			cmbLayout.setSelectedIndex(0);
			spnPagina.setValue(0);
		}
	}

	private void addPagina(LAYOUT_IMG layout) {
		MyPnlPagina pnlPg = new MyPnlPagina();
		pnlPageAlternate.addCard(pnlPg, pnlPg.getIdentificador());
		listaDePaginas.add(pnlPg);
		if (layout != null) {
			pnlPg.setLayoutActive(layout);
			mediador.pagFoiAdicionada(layout);
		}
		selectPagina(listaDePaginas.size());
		atualizaSpnPagina();
	}
	
	private void atualizandoPaginaEspecifica(){
		mediador.pagFoiAtualizada(spnPagina.getValue()-1, cmbLayout.getSelectedItem());
	}

	private void removePaginaAtual() {
		int pgId = spnPagina.getValue();
		if (pgId > 0) {
			pnlPageAlternate.removeCard(paginaAtual.getIdentificador());
			listaDePaginas.remove(pgId - 1);
			mediador.pagFoiRemovida(pgId - 1);
			if (listaDePaginas.isEmpty()) {
				selectPagina(0);
			} else if ((pgId - 1) == listaDePaginas.size()) {
				selectPagina(pgId - 1);
			} else {
				selectPagina(pgId);
			}
		} else {
			// ??
		}
		atualizaSpnPagina();
	}

	private void atualizaSpnPagina() {
		int maximo = listaDePaginas.size();
		int minimo = maximo == 0 ? 0 : 1;
		spnPagina.setMinimum(minimo);
		spnPagina.setMaximum(maximo);
		lblTotalPagina.setText("de " + maximo);
	}

	private void cmbLayoutAction() {
		if (paginaAtual != null) {
			if (cmbLayout.getSelectedItem().isPossuiLaudo()
					&& possuiMaisDeUmLayoutComLaudo()) {
				SwingUtils.mostrarAviso(this,
						"Este layout não pode ser adicionado mais de uma vez.\nSerá selecionado"
								+ " automaticamente o layout padrão.");
				cmbLayout.setSelectedItem(StaticInfo.getParametrosDoSistema()
						.getLayoutImagem());
			} else {
				paginaAtual.setLayoutActive(cmbLayout.getSelectedItem());
			}
			if (!estaSelecionandoPagina) {
				int pgId = spnPagina.getValue() - 1;
				mediador.layoutDaPagMudou(pgId, cmbLayout.getSelectedItem());
				atualizandoPaginaEspecifica();
			}
		}
	}

	private boolean possuiMaisDeUmLayoutComLaudo() {
		int count = 0;
		for (int i = 0; i < listaDePaginas.size(); i++) {
			if (listaDePaginas.get(i).getLayoutActive().isPossuiLaudo()) {
				count++;
			}
		}
		return count > 1;
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Menu Superior">

	// <editor-fold defaultstate="collapsed" desc="Componentes">

	private MyJPanel pnlMenuSup = new MyJPanel(new GridBagLayout());
	private JToolBar tBar = new JToolBar(JToolBar.HORIZONTAL);
	private BtnTextoEmBaixo btnImprimir = new BtnTextoEmBaixo("Imprimir");
	private BtnTextoEmBaixo btnPDF = new BtnTextoEmBaixo("Gerar PDF");
	private BtnTextoEmBaixo btnEscolherAutom = new BtnTextoEmBaixo(
			"Escolher Autom.");
	private BtnTextoEmBaixo btnLimpar = new BtnTextoEmBaixo("Limpar Página");

	{
		pnlMenuSup.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0,
				Color.BLACK), new MatteBorder(0, 0, 1, 0, Color.WHITE)));
		Font fontBtnsVert = new java.awt.Font("Tahoma", 1, 11);

		tBar.setFloatable(false);
		tBar.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

		btnImprimir.setIcon(SwingLibResources.getIcon(Imagens.IMPRESSORA));
		btnImprimir.setFont(fontBtnsVert);
		btnImprimir.setToolTipText("Imprimir páginas de imagens");
		btnImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnImprimirAction();
			}
		});
		btnImprimir.setPreferredSize(new Dimension(70, 48));

		btnPDF.setIcon(SwingLibResources.getIcon(Imagens.PDF_FILE));
		btnPDF.setFont(fontBtnsVert);
		btnPDF.setToolTipText("Gerar PDF das páginas de imagens");
		btnPDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnPDFAction();
			}
		});
		btnPDF.setPreferredSize(new Dimension(75, 48));

		btnEscolherAutom.setIcon(ImageResources
				.getIcon(ImagensLC.ESCOLHER_IMAGENS));
		btnEscolherAutom.setFont(fontBtnsVert);
		btnEscolherAutom
				.setToolTipText("Escolher e preencher imagens no layout automaticamente.");
		btnEscolherAutom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEscolherAutomAction();
			}
		});
		btnEscolherAutom.setPreferredSize(new Dimension(110, 48));

		btnLimpar.setIcon(ImageResources.getIcon(ImagensLC.LIMPAR));
		btnLimpar.setFont(fontBtnsVert);
		btnLimpar.setToolTipText("Limpar preenchimento da página atual");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLimparAction();
			}
		});
		btnLimpar.setPreferredSize(new Dimension(105, 48));
	}

	private void initializeMenuSuperior() {
		tBar.add(btnImprimir);
		tBar.add(btnPDF);
		tBar.add(btnEscolherAutom);
		tBar.add(btnLimpar);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		c.gridx = 0;
		pnlMenuSup.add(tBar, c);
		c.weightx = 1d;
		c.gridx = 1;
		pnlMenuSup.add(pnlMenuLayout, c);
	}

	// </editor-fold>

	private void btnImprimirAction() {
		mediador.imprimirApenasImagens();
	}

	private void btnPDFAction() {
		mediador.gerarPDFApenasImagens();
	}

	private void btnEscolherAutomAction() {
		mediador.escolherImagensAutomaticamente(true);
	}

	private void btnLimparAction() {
		if (paginaAtual != null) {
			paginaAtual.limparPreenchimento();
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Page Layout View">

	// <editor-fold defaultstate="collapsed" desc="Componentes">

	private JScrollPane scrpLayout = new JScrollPane();
	private MyJPanel pnlLayout = new MyJPanel(new GridBagLayout());
	private PnlCartao pnlPageAlternate = new PnlCartao();
	private final JLabel lbl = new JLabel();
	private final String lblText = "<html>Este laudo possui \"Imagens dos esquemas\".<br>- Escolha um "
			+ "layout e use o botão direito do mouse para escolher e editar.<br>- Clique novamente se for precisar "
			+ "adicionar mais imagens.</html>";

	{
		scrpLayout.setViewportView(pnlLayout);
		scrpLayout.getVerticalScrollBar().setUnitIncrement(50);
		scrpLayout.getVerticalScrollBar().setBlockIncrement(50);

		lbl.setForeground(Color.red);
		lbl.setVerticalAlignment(SwingConstants.TOP);
		lbl.setFont(lbl.getFont().deriveFont(11f));

	}

	private void initializeLayoutView() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		pnlLayout.add(Box.createHorizontalStrut(0), c);
		c.gridx = 1;
		c.weightx = 0;
		pnlLayout.add(pnlPageAlternate, c);
		c.gridx = 2;
		c.insets.left = 5;
		c.weightx = 0.5;
		pnlLayout.add(lbl, c);
	}

	// </editor-fold>

	/**
	 * Verifica nas páginas se contem imagens no layout ou não.
	 *
	 * @return true se as páginas nao tiver imagens colocadas ou false caso
	 *         contrário
	 */
	public boolean isPaginasVazias() {
		boolean paginasVazias = true;
		for (int i = 0; i < listaDePaginas.size(); i++) {
			if (!listaDePaginas.get(i).getHTML(0).isEmpty()) {
				paginasVazias = false;
			}
		}
		PnlLayoutImagens.labelImagem = 0;
		return paginasVazias;
	}

	/**
	 * Concatena o html de todas as páginas de imagens geradas pelo usuário.
	 *
	 * @param addAtdInfoFirstPage
	 *            se true adiciona informações do atendimento na primeira
	 *            pagina.
	 * @param proc
	 *            Procedimento para gerar informações do atendimento
	 * @return String html pronto para impressao das páginas de imagens
	 */
	public String gerarHtmlParaImpressao(boolean addAtdInfoFirstPage,ProcDoAtd proc) {
		LaudosHTMLUtils.setProcDoAtd(proc);
		String html = "";
		int listaDePaginasSize = listaDePaginas.size();
		for (int i = 0; i < listaDePaginas.size(); i++) {
			if (addAtdInfoFirstPage && i == 0 && proc != null) {
				html += LaudosHTMLUtils.createTabelaPagina(listaDePaginas.get(i).getHTML(i), listaDePaginasSize * 8, true);
			} else {
				html += LaudosHTMLUtils.createTabelaPagina(listaDePaginas.get(i).getHTML(i), listaDePaginasSize * 8, false);
			}
		}
		return html;
	}

	private LAYOUT_IMG inferirLayout(int qtdeFotos) {
		// NAO PODE SER UTILIZADO O LAYOUT DE LAUDO COM FOTO
		switch (qtdeFotos) {
		case 1:
			return LAYOUT_IMG.LAYOUT_1_IMG;
		case 2:
			return LAYOUT_IMG.LAYOUT_2_IMG;
		case 3:
			return LAYOUT_IMG.LAYOUT_3_IMG;
		case 4:
			return LAYOUT_IMG.LAYOUT_4_IMG_MEDIAS;
		case 5:
		case 6:
			return LAYOUT_IMG.LAYOUT_6_IMG;
		case 7:
		case 8:
			return LAYOUT_IMG.LAYOUT_8_IMG;
		case 9:
			return LAYOUT_IMG.LAYOUT_9_IMG;
		case 10:
		case 11:
		case 12:
			return LAYOUT_IMG.LAYOUT_12_IMG;
		default:
			return LAYOUT_IMG.LAYOUT_15_IMG;
		}
	}

	/**
	 * Faz a escolha das imagens automaticamente no layout atual selecionado.
	 */
	public void doEscolherImagensAutomaticamente(List<byte[]> listaImagem) {
		if (mediador.getNumeroDeImagens() < 1) {
			SwingUtils.mostrarMsgDeInformacao(null,
					"Não há imagens para preenchimento.");
			return;
		}

		FormPrincipal.getInstance().setCursorToWaitCursor();
		LAYOUT_IMG layout = inferirLayout(listaImagem.size());

		if (listaDePaginas.isEmpty()) {
			addPagina(layout);
		}
		selectPagina(1);

		int qtdePaginasAPreencher = mediador.getNumeroDeImagens()
				/ layout.getQtdeImagens();
		;
		int resto = mediador.getNumeroDeImagens() % layout.getQtdeImagens();
		if (resto != 0) {
			qtdePaginasAPreencher++;
		}

		int qtdePaginasACriar = qtdePaginasAPreencher - listaDePaginas.size();
		if (qtdePaginasACriar < 0) {
			// remover paginas que estão a mais
			for (int i = 0; i > qtdePaginasACriar; i--) {
				// remove a ultima
				selectPagina(listaDePaginas.size());
				removePaginaAtual();
			}
		}

		// cria páginas a mais
		for (int i = 0; i < qtdePaginasACriar; i++) {
			addPagina(layout);
		}

		// preenchendo imagens
		List<byte[]> newList = new ArrayList<>(listaImagem);
		for (int pag = 0; pag < listaDePaginas.size(); pag++) {
			selectPagina(pag + 1);
			paginaAtual.limparPreenchimento();
			int qtdeImagensLayout;
			cmbLayout.setSelectedItem(layout);
			qtdeImagensLayout = layout.getQtdeImagens();
			paginaAtual.preencherAutomaticamente(newList);
			if (newList.size() > qtdeImagensLayout) {
				newList = newList.subList(layout.getQtdeImagens(),
						newList.size());
			}
		}

		selectPagina(1);
		FormPrincipal.getInstance().setCursorToDefaultCursor();
	}

	/**
	 * Verifica se tem algum layout que tem laudo e imagem.
	 *
	 * @return true se tem.
	 */
	public LAYOUT_IMG temLayoutLaudoEImagens() {
		boolean resp = false;
		for (int i = 0; i < listaDePaginas.size(); i++) {
			if (listaDePaginas.get(i).getLayoutActive().isPossuiLaudo()) {
				return listaDePaginas.get(i).getLayoutActive();
			}
		}
		return null;
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Menu Miniaturas">

	// <editor-fold defaultstate="collapsed" desc="Componentes">

	private MyJPanel pnlBtnsInf = new MyJPanel(new GridBagLayout());
	private MyJButton btnIndice = new MyJButton();
	private BtnTextoEmBaixo btnEditar = new BtnTextoEmBaixo(
			"Editar Imagem Selecionada");
	private MyJButton btnFullScreen = new MyJButton("Ver Imagens Ampliadas");

	{
		btnIndice.setForeground(new Color(0, 102, 255));
		btnIndice.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIndice.setEnabled(false);

		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setIcon(ImageResources.getIcon(ImagensLC.IMG_EDIT));
		btnEditar.setToolTipText("Editar Imagem Selecionada");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEditarAction();
			}
		});

		btnFullScreen.setHorizontalAlignment(SwingConstants.LEFT);
		btnFullScreen.setIcon(SwingLibResources.getIcon(Imagens.FULLSCREEN));
		btnFullScreen.setToolTipText("Ver imagens em tela cheia");
		btnFullScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnFullScreenAction();
			}
		});
	}

	private void initializeMenuMiniaturas() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		pnlBtnsInf.add(Box.createVerticalStrut(10), c);
		c.gridy = 1;
		pnlBtnsInf.add(btnIndice, c);
		c.gridy = 2;
		pnlBtnsInf.add(btnEditar, c);
		c.gridy = 3;
		pnlBtnsInf.add(btnFullScreen, c);
		c.gridy = 4;
		c.gridx = 1;
		pnlBtnsInf.add(Box.createRigidArea(new Dimension(5, 9)), c);
	}

	// </editor-fold>

	private void btnEditarAction() {
		mediador.iniciarEdicaoDeImg();
	}

	private void btnFullScreenAction() {
		mediador.mostrarImagensEmFullScreen();
	}

	private void updateIndexes() {
		btnIndice.setText("Imagem " + mediador.getIndexes());
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Painel Miniaturas">

	private MyJPanel pnlInferior = new MyJPanel(new GridBagLayout());
	private BtnSoImagem btnEsquerda = new BtnSoImagem(
			SwingLibResources.getIcon(Imagens.BTN_ANTERIOR),
			SwingLibResources.getIcon(Imagens.BTN_ANTERIOR_UP));
	private BtnSoImagem btnDireita = new BtnSoImagem(
			SwingLibResources.getIcon(Imagens.BTN_PROXIMO),
			SwingLibResources.getIcon(Imagens.BTN_PROXIMO_UP));
	private MyJPanel pnlMiniaturas = new MyJPanel(new FlowLayout(
			FlowLayout.LEADING));
	private ScrpMiniaturas scrpMiniaturas = new ScrpMiniaturas(true,
			pnlMiniaturas, listaMiniaturas);

	{
		pnlInferior.setBorder(new MatteBorder(1, 0, 0, 0, Color.GRAY));
		scrpMiniaturas.setBorder(null);
		scrpMiniaturas
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrpMiniaturas
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrpMiniaturas.getHorizontalScrollBar().setUnitIncrement(10);
		scrpMiniaturas.getHorizontalScrollBar().setUI(new BlueScrollBarUI());

		btnEsquerda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.irParaImgAnterior();
			}
		});
		btnDireita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.irParaProximaImg();
			}
		});
	}

	private void initializePainelMiniaturas() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0d;
		c.gridy = 0;
		c.gridx = 0;
		pnlInferior.add(btnEsquerda, c);
		c.gridx = 1;
		c.weightx = 1d;
		c.weighty = 1d;
		pnlInferior.add(scrpMiniaturas, c);
		c.weightx = 0d;
		c.weighty = 0d;
		c.gridx = 2;
		pnlInferior.add(btnDireita, c);
		c.gridx = 3;
		pnlInferior.add(Box.createHorizontalStrut(8), c);
		c.gridx = 4;
		pnlInferior.add(pnlBtnsInf, c);
	}

	// </editor-fold>

	/**
	 * Limpa o painel, removendo todas as miniaturas e páginas de layout.
	 */
	public void resetPainel() {
		try {
			listaMiniaturas.clear();
			pnlMiniaturas.removeAll();
			pnlMiniaturas.repaint();
			ProcDoAtd pdt = mediador.getProcSelecionado();
			ProcMedico p = pdt == null ? null : pdt.getProcMedico();
			if (p != null && (p.getImagem1() != null || p.getImagem2() != null)) {
				lbl.setText(lblText);
			} else {
				lbl.setText("");
			}
			updateIndexes();
		} catch (ClassCastException e) {
			resetPainel();
		}
	}

	/**
	 * Altera a imagem referenciada pelo indice da imagem na página escolhida.
	 *
	 * @param indexPag
	 *            indice da página
	 * @param indiceDaImg
	 *            indice da posição da imagem
	 * @param novaImg
	 *            imagem para ser colocada
	 */
	public void atualizarImgImpressa(int indexPag, int indiceDaImg,
			byte[] novaImg) {
		MyPnlPagina pagina = listaDePaginas.get(indexPag);
		if (pagina != null) {
			pagina.atualizarImagemNaPosição(indiceDaImg, novaImg);
		}
	}

	/**
	 * Carrega as páginas de impressão de imagens.
	 *
	 * @param paginas
	 *            lista de paginas.
	 */
	public void carregarImpressoes(List<PaginaDeImagens> paginas) {
		// remove todas as páginas
		int size = listaDePaginas.size();
		for (int i = 1; i <= size; i++) {
			selectPagina(1);
			removePaginaAtual();
		}
		// adiciona as páginas de acordo com a lista passada
		for (int i = 0; i < paginas.size(); i++) {
			PaginaDeImagens pagina = paginas.get(i);
			addPagina(pagina.getLayout());
			paginaAtual.preencherLayout(pagina.getImagens());
		}
	}

	class MyPnlPagina extends MyJPanel {
		private PnlLayoutImagens pnlLayoutActive;
		private String identificador;
		private int numPagina = 1;
		private LAYOUT_IMG layoutActive;

		private MyPnlPagina() {
			setLayout(new BorderLayout());
			identificador = String.valueOf(new Date().getTime());
		}

		private LAYOUT_IMG getLayoutActive() {
			return layoutActive;
		}

		private void setLayoutActive(LAYOUT_IMG layout) {
			if (layoutActive != layout) {
				layoutActive = layout;
				removeAll();
				pnlLayoutActive = getPnlLayout();
				if (pnlLayoutActive != null) {
					pnlLayoutActive.setPagina(numPagina);
					add(pnlLayoutActive, BorderLayout.CENTER);
				}
			}
		}

		private PnlLayoutImagens getPnlLayout() {
			switch (layoutActive) {
			case LAYOUT_1_IMG:
				return new PnlLayout1Img(mediador);
			case LAYOUT_2_IMG_GRANDES:
				return new PnlLayout2ImgGrande(mediador);
			case LAYOUT_1_IMG_PRINTER:
				return new PnlLayout1ImgPrinter(mediador);
			case LAYOUT_2_IMG:
				return new PnlLayout2Img(mediador);
			case LAYOUT_3_IMG:
				return new PnlLayout3Img(mediador);
			case LAYOUT_4_IMG_GRANDES:
				return new PnlLayout4ImgGrandes(mediador);
			case LAYOUT_4_IMG_MEDIAS:
				return new PnlLayout4ImgMedias(mediador);
			case LAYOUT_4_IMG_PEQUENAS:
				return new PnlLayout4ImgPequenas(mediador);
			case LAYOUT_6_IMG:
				return new PnlLayout6Img(mediador);
			case LAYOUT_6_IMG_GRANDES:
				return new PnlLayout6ImgGrandes(mediador);
			case LAYOUT_8_IMG:
				return new PnlLayout8Img(mediador);
			case LAYOUT_8_IMG_GRANDES:
				return new PnlLayout8ImgGrandes(mediador);
			case LAYOUT_9_IMG:
				return new PnlLayout9Img(mediador);
			case LAYOUT_12_IMG:
				return new PnlLayout12Img(mediador);
			case LAYOUT_15_IMG:
				return new PnlLayout15Img(mediador);
			case LAYOUT_LAUDO_E_4_IMG:
				return new PnlLayoutLaudoE4Img(mediador);
			case LAYOUT_LAUDO_E_5_IMG:
				return new PnlLayoutLaudoE5Img(mediador);
			default:
				return null;
			}
		}

		private void preencherAutomaticamente(List<byte[]> list) {
			pnlLayoutActive.preencherAutomaticamente(list);
		}

		private void preencherLayout(List<ImagemImpressa> imagens) {
			pnlLayoutActive.preencherLayout(imagens);
		}

		private void atualizarImagemNaPosição(int indiceDaImg, byte[] novaImg) {
			pnlLayoutActive.atualizarImagemNaPosição(indiceDaImg, novaImg);
		}

		private void limparPreenchimento() {
			pnlLayoutActive.limparPreenchimento();
		}

		private String getIdentificador() {
			return identificador;
		}

		private void setNumeroDaPagina(int numPagina) {
			if (pnlLayoutActive != null) {
				this.numPagina = numPagina;
				pnlLayoutActive.setPagina(numPagina);
			}
		}
	
		public int getNumPagina() {
			return numPagina;
		}
	
		private String getHTML(int paginas) {
			return pnlLayoutActive.getHTML(paginas);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final MyPnlPagina other = (MyPnlPagina) obj;
			if (!Objects.equals(this.identificador, other.getIdentificador())) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			int hash = 3;
			hash = 89 * hash + Objects.hashCode(this.identificador);
			return hash;
		}

	}

	// <editor-fold defaultstate="collapsed" desc="View imagens">

	@Override
	public void addImg(byte[] imagem) {
		PnlImgMiniatura itemMiniatura = criarPnlMiniatura(imagem);
		pnlMiniaturas.add(itemMiniatura);
		listaMiniaturas.add(itemMiniatura);
	}

	@Override
	public void atualizarSelecao() {
		if (meuSw == null) {
			// assertion error
		} else {
			meuSw.atualizarSelecao();
		}
	}

	@Override
	public void carregarImagens(List<byte[]> imagens) {
		if (!(meuSw == null || meuSw.isDone())) {
			meuSw.cancel(true);
		}
		meuSw = new MeuSw(imagens);
		meuSw.execute();
	}

	@Override
	public void imgSelMudou() {
		int index = mediador.getIndexAtual();
		PnlImgMiniatura miniatura = listaMiniaturas.get(index);
		miniatura.setImagem(mediador.getImagemAtual());
	}

	@Override
	public void removerImgSel() {
		int index = mediador.getIndexAtual();
		listaMiniaturas.get(index).setVisible(false);
		listaMiniaturas.remove(index);
	}

	// </editor-fold>

	private class MeuSw extends SwingWorker<Void, PnlImgMiniatura> {

		private List<byte[]> imagens;
		private boolean resetPanel = true;

		private MeuSw(List<byte[]> imagens) {
			this.imagens = imagens;
		}

		private void atualizarSelecao() {
			if (isDone()) {
				int index = mediador.getIndexAtual();
				for (int i = 0; i < listaMiniaturas.size(); i++) {
					listaMiniaturas.get(i).setSelected(false);
				}
				byte[] img = mediador.getImagemAtual();
				if (img == null) {
				} else {
					try {
						// pode acontecer devido a um erro de concorrencia
						PnlImgMiniatura miniatura = listaMiniaturas.get(index);
						miniatura.setSelected(true);
					} catch (IndexOutOfBoundsException e) {
					}
				}
				updateIndexes();
			} else {
			}
		}

		@Override
		protected void process(List<PnlImgMiniatura> chunks) {
			if (isCancelled()) {
			} else {
				if (resetPanel) {
					do {
						try {
							resetPainel();
							resetPanel = false;
						} catch (ClassCastException cce) {
						}
					} while (resetPanel);
				}
				for (int i = 0; i < chunks.size(); i++) {
					PnlImgMiniatura itemMiniatura = chunks.get(i);
					pnlMiniaturas.add(itemMiniatura);
					listaMiniaturas.add(itemMiniatura);
				}
			}
		}

		@Override
		@SuppressWarnings("AssignmentToForLoopParameter")
		protected Void doInBackground() throws Exception {
			for (int i = 0; i < imagens.size(); i++) {
				try {
					publish(criarPnlMiniatura(imagens.get(i)));
				} catch (ClassCastException cce) {
					i--;
				}
			}
			return null;
		}

		@Override
		protected void done() {
			if (!isCancelled()) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						if (resetPanel) {
							resetPainel();
						} else {
							atualizarSelecao();
						}
					}
				});
			}
		}

	}

	private PnlImgMiniatura criarPnlMiniatura(byte[] img) {
		PnlImgMiniatura itemMiniatura = new PnlImgMiniatura(img,
				scrpMiniaturas, new Dimension(128, 96),
				new MouseListPnlMiniatura(listaMiniaturas, mediador, true));
		itemMiniatura.configurar(new EmptyBorder(5, 0, 5, 0), new EmptyBorder(
				0, 1, 0, 1));
		return itemMiniatura;
	}

	public MyPnlPagina getPaginaAtual() {
		return paginaAtual;
	}
}
