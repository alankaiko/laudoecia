/*
 * PnlLaudo.java
 *
 * Created on 09/05/2012, 15:49:53
 */
package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableCellRenderer;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeMdlDoProc;
import com.ic.projects.laudoecia.control.laudoecia.C_TxtPreview;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.iview.PreviewCampoDoLaudo;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.model.laudo.Planilha;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.view.dialogs.DlgWhats;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudo.SwViewLaudo;
import com.ic.projects.laudoecia.view.laudo.TxtHtmlLaudo;
import com.ic.projects.laudoecia.view.laudo.TxtTopico;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJScrollPane;
import com.lib.swing.plus.cps.MyJTable;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.BtnTextoEmBaixo;
import com.lib.swing.plus.utils.CardAdapter;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlLaudo extends MyJPanel {

	private LaudoeCiaMediator mediador;
	private Map<Laudo, SwViewLaudo> laudos = new IdentityHashMap<>();
	private SwViewLaudo activeSw;
	private boolean abrirLaudo = false;

	public PnlLaudo(LaudoeCiaMediator mediador) {
		this.mediador = mediador;

		setBorder(new BlackAndWhiteEtchedBorder());

		initPnlSuperior();
		initPnlCentral();
		initPnlPreview();

		setLayout(new BorderLayout());
		add(pnlMenuSup, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlPreview, BorderLayout.SOUTH);

	}

	// <editor-fold defaultstate="collapsed" desc="Componentes do Painel">
	private MyJPanel pnlMenuSup = new MyJPanel();
	private MyJPanel pnlCenter = new MyJPanel(new BorderLayout());
	private MyJPanel pnlPreview = new MyJPanel(new BorderLayout());

	{
		pnlMenuSup.setBorder(
				new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK), new MatteBorder(0, 0, 1, 0, Color.WHITE)));
	}

	// <editor-fold defaultstate="collapsed" desc="PnlMenuSuperior">
	private JToolBar tBar = new JToolBar(JToolBar.HORIZONTAL);
	private BtnTextoEmBaixo btnSalvar = new BtnTextoEmBaixo("Salvar");
	private BtnTextoEmBaixo btnCancelar = new BtnTextoEmBaixo("Cancelar");
	private BtnTextoEmBaixo btnImprimir = new BtnTextoEmBaixo("Imprimir");
	private BtnTextoEmBaixo btnPDF = new BtnTextoEmBaixo("Gerar PDF");
	private BtnTextoEmBaixo btnEscImg = new BtnTextoEmBaixo("Escolher imagens");
	private BtnTextoEmBaixo btnModelo = new BtnTextoEmBaixo("Modelo");
	private BtnTextoEmBaixo btnReceituario = new BtnTextoEmBaixo("Receita");
	private BtnTextoEmBaixo btnVisualizar = new BtnTextoEmBaixo("Visualizar laudo");
	private BtnTextoEmBaixo btnEnviarWhats = new BtnTextoEmBaixo("Env. WathsApp");

	{
		tBar.setFloatable(false);
		tBar.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

		Font fontBtnsVert = new java.awt.Font("Tahoma", 1, 11);

		btnSalvar.setIcon(SwingLibResources.getIcon(Imagens.SALVAR));
		btnSalvar.setFont(fontBtnsVert);
		btnSalvar.setToolTipText("Salvar laudo, vídeos e imagens (Ctrl + S)");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
				mediador.salvar();
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		btnSalvar.setPreferredWidth(65);

		btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
		btnCancelar.setFont(fontBtnsVert);
		btnCancelar.setToolTipText("Cancelar edição do laudo.");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
				mediador.cancelar();
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		btnCancelar.setPreferredWidth(65);

		btnImprimir.setIcon(SwingLibResources.getIcon(Imagens.IMPRESSORA));
		btnImprimir.setFont(fontBtnsVert);
		btnImprimir.setToolTipText("Mostrar opções de impressão");
		btnImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int y = btnImprimir.getSize().height;
				popupImprimir.show(btnImprimir, 0, y);
			}

		});
		btnImprimir.setPreferredWidth(70);

		btnPDF.setIcon(SwingLibResources.getIcon(Imagens.PDF_FILE));
		btnPDF.setFont(fontBtnsVert);
		btnPDF.setToolTipText("Mostrar opções de geração de PDF");
		btnPDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int y = btnPDF.getSize().height;
				popupPDF.show(btnPDF, 0, y);
			}

		});
		btnPDF.setPreferredWidth(75);

		btnVisualizar.setIcon(SwingLibResources.getIcon(Imagens.PRINT_VIEW));
		btnVisualizar.setFont(fontBtnsVert);
		btnVisualizar.setToolTipText("Visualizar laudo completo");
		btnVisualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.visualizarLaudo();
			}

		});
		btnVisualizar.setPreferredWidth(115);

		btnEnviarWhats.setIcon(ImageResources.getIcon(ImagensLC.ENVIOWHATS));
		btnEnviarWhats.setFont(fontBtnsVert);
		btnEnviarWhats.setToolTipText("Enviar pelo WhatsApp");
		btnEnviarWhats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int y = btnEnviarWhats.getSize().height;
				popupPDFzap.show(btnEnviarWhats, 0, y);
			}
		});
		btnEnviarWhats.setPreferredWidth(115);

		btnEscImg.setIcon(ImageResources.getIcon(ImagensLC.ESCOLHER_IMAGENS));
		btnEscImg.setFont(fontBtnsVert);
		btnEscImg.setToolTipText("Escolher imagens para impressão");
		btnEscImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.escolherImgParaImp();
			}

		});
		btnEscImg.setPreferredWidth(115);
		btnEscImg.setForeground(Color.red);

		btnModelo.setIcon(ImageResources.getIcon(ImagensLC.MODELO_LAUDO));
		btnModelo.setFont(fontBtnsVert);
		btnModelo.setToolTipText("Alterar modelo de laudo");
		btnModelo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirPopupModelo();

			}

		});
		btnModelo.setPreferredWidth(75);

		btnReceituario.setIcon(ImageResources.getIcon(ImagensLC.OPTIONS));
		btnReceituario.setFont(fontBtnsVert);
		btnReceituario.setToolTipText("Receita");
		btnReceituario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.receita();
			}

		});
		btnReceituario.setPreferredWidth(70);
	}

	private void initPnlSuperior() {
		tBar.add(btnSalvar);
		tBar.add(btnCancelar);
		tBar.add(btnImprimir);
		tBar.add(btnPDF);
		tBar.add(btnVisualizar);
		tBar.add(btnEscImg);
		tBar.add(btnModelo);
		tBar.add(btnReceituario);
		tBar.add(btnEnviarWhats);

		pnlMenuSup.setLayout(new BorderLayout());
		pnlMenuSup.add(tBar, BorderLayout.CENTER);
	}

	// <editor-fold defaultstate="collapsed" desc="Popup Imprimir">
	private JPopupMenu popupImprimir = new JPopupMenu();

	{
		JMenuItem btnImpImgLaudo = popupImprimir.add("Laudo com imagens (Ctrl + Shift + P)");
		JMenuItem btnImpSoLaudo = popupImprimir.add("Apenas laudo (Ctrl + P)");
		JMenuItem btnImpSoImg = popupImprimir.add("Apenas imagens (Ctrl + Alt + P)");
		popupImprimir.addSeparator();
		JMenuItem btnPrevImgLaudo = popupImprimir.add("Pré-Visualizar laudo com imagens");
		JMenuItem btnPrevSoLaudo = popupImprimir.add("Pré-Visualizar apenas laudo");
		JMenuItem btnPrevSoImg = popupImprimir.add("Pré-Visualizar apenas imagens");

		btnImpImgLaudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.imprimirLaudoEImagens();
			}

		});
		btnImpSoLaudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.imprimirApenasLaudo();
			}

		});
		btnImpSoImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.imprimirApenasImagens();
			}

		});

		btnPrevImgLaudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.previewLaudoEImagens();
			}

		});
		btnPrevSoLaudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.previewApenasLaudo();
			}

		});
		btnPrevSoImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.previewApenasImagens();
			}

		});
	}

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="Popup PDF">
	private JPopupMenu popupPDF = new JPopupMenu();
	private JMenuItem btnPDFImgLaudo = popupPDF.add("Laudo com imagens");
	private JMenuItem btnPDFSoLaudo = popupPDF.add("Apenas laudo");
	private JMenuItem btnPDFSoImg = popupPDF.add("Apenas imagens");

	{
		btnPDFImgLaudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.gerarPDFLaudoEImagens();
			}

		});
		btnPDFSoLaudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.gerarPDFApenasLaudo();
			}

		});
		btnPDFSoImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.gerarPDFApenasImagens();
			}

		});
	}
	
	private JPopupMenu popupPDFzap = new JPopupMenu();
	private JMenuItem btnPDFImgLaudozap = popupPDFzap.add("Laudo com imagens");
	private JMenuItem btnPDFSoLaudozap = popupPDFzap.add("Apenas laudo");
	private JMenuItem btnPDFSoImgzap = popupPDFzap.add("Apenas imagens");
	
	{
		btnPDFImgLaudozap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File valor = mediador.GerarLaudoEImagemsPDFEmail();
					if (valor != null)
						DlgWhats.getInstance(mediador.getAtdSelecionado(), valor.getAbsolutePath());
					else
						JOptionPane.showMessageDialog(null, "Laudo Com Imagens não foi criado");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}

		});
		btnPDFSoLaudozap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File valor = mediador.gerarPDFApenasLaudoEmail();
				if (valor != null)
					DlgWhats.getInstance(mediador.getAtdSelecionado(), valor.getAbsolutePath());
				else
					JOptionPane.showMessageDialog(null, "Laudo não foi criado");
			}

		});
		btnPDFSoImgzap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File valor = mediador.gerarPDFApenasImagensEmail();
				if (valor != null)
					DlgWhats.getInstance(mediador.getAtdSelecionado(), valor.getAbsolutePath());
				else
					JOptionPane.showMessageDialog(null, "Laudo De Imagens não foi criado");
			}

		});
	}

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="Popup Modelo">
	private JPopupMenu popupModelo = new JPopupMenu() {

		@Override
		public void setVisible(boolean visible) {
			if (visible) {
				super.setVisible(true);
				txtModelos.requestFocusInWindow();
				txtModelos.autoCompletar();
			} else if (!txtModelos.isFocusOwner()) {
				super.setVisible(false);
			}
		}

	};
	private BuscadorDeMdlDoProc buscador = new BuscadorDeMdlDoProc();
	private MTable tabelaDeModelos = new MTable();
	private TxtComAutoCompletar txtModelos = new TxtComAutoCompletar(buscador) {

		@Override
		protected MyJTable criarTabela() {
			return tabelaDeModelos;
		}

	};
	private boolean naoNotificarMediadorMdlMudou = false;
	private ModeloDeLaudoDoProc mdl;

	{
		popupModelo.setLayout(new GridBagLayout());
		popupModelo.setBorder(new CompoundBorder(popupModelo.getBorder(), new EmptyBorder(0, 5, 0, 5)));
		txtModelos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				popupModelo.setVisible(false);
				if (mdl != null && buscador.getSelectedModel() == null) {
					naoNotificarMediadorMdlMudou = true;
					buscador.setSelectedModel(mdl);
					naoNotificarMediadorMdlMudou = false;
				}
			}

		});
		txtModelos.addAutoCompletarListener(new AutoCompletarListener() {
			@Override
			public void linhaSelecionadaMudou(Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada) {
				if (popupModelo.isVisible() && newLinhaSelecionada == null) {
				} else if (naoNotificarMediadorMdlMudou) {
				} else {
					mediador.modeloDeLaudoMudou(buscador.getSelectedModel());
				}
			}

		});
		txtModelos.setSelecionarPrimeiroAposBusca(false);
		txtModelos.setMaxVisibleRows(14);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.insets.bottom = 3;
		popupModelo.add(new LblNegrito(" Modelos (o modelo atual está em vermelho)"), c);
		c.gridy = 1;
		c.insets.bottom = 0;
		popupModelo.add(txtModelos, c);
		c.gridy = 2;
		popupModelo.add(Box.createHorizontalStrut(400), c);
	}

	private class MTable extends MyJTable {

		private Border defBorder;
		private String modeloSelecionado;

		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
			Component lbl = super.prepareRenderer(renderer, rowIndex, vColIndex);
			if (lbl instanceof JLabel) {
				JLabel lblRend = (JLabel) lbl;
				if (defBorder == null) {
					defBorder = lblRend.getBorder();
				}
				if (modeloSelecionado == null && buscador.getSelectedModel() != null) {
					modeloSelecionado = buscador.getSelectedModel().getDescricao();
				}
				if (modeloSelecionado == null) {
				} else if (lblRend.getText().equals(modeloSelecionado)) {
					lblRend.setBorder(new LineBorder(Color.red, 1));
				} else {
					lblRend.setBorder(defBorder);
				}
			}
			return lbl;
		}

		private void limparModeloSelecionado() {
			modeloSelecionado = null;
		}

	}

	// </editor-fold>
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="PnlCenter">
	private MyJButton btnPrimeiro = new MyJButton();
	private MyJButton btnAnterior = new MyJButton();
	private MyJButton btnProximo = new MyJButton();
	private MyJButton btnUltimo = new MyJButton();
	private PnlCartao pnlTopicos = new PnlCartao();
	private MyJScrollPane scrpTopicos = new MyJScrollPane(pnlTopicos);
	private TxtTopico txtTopico = new TxtTopico(pnlTopicos);

	{
		txtTopico.setFont(txtTopico.getFont().deriveFont(Font.BOLD));
		txtTopico.setFont(txtTopico.getFont().deriveFont(16f));
		txtTopico.setMaxVisibleRows(25);

		EmptyBorder btnsBorder = new EmptyBorder(4, 12, 4, 12);

		btnPrimeiro.setIcon(SwingLibResources.getIcon(Imagens.PRIMEIRO));
		btnPrimeiro.setToolTipText("Ir para primeiro tópico");
		btnPrimeiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnPrimeiroAction();
			}

		});
		btnPrimeiro.setBorder(btnsBorder);

		btnAnterior.setIcon(ImageResources.getIcon(ImagensLC.ANTERIOR_GRANDE));
		btnAnterior.setToolTipText("Ir para tópico anterior");
		btnAnterior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAnteriorAction();
			}

		});
		btnAnterior.setBorder(btnsBorder);

		btnProximo.setIcon(ImageResources.getIcon(ImagensLC.PROXIMO_GRANDE));
		btnProximo.setToolTipText("Ir para próximo tópico");
		btnProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnProximoAction();
			}

		});
		btnProximo.setBorder(btnsBorder);

		btnUltimo.setIcon(SwingLibResources.getIcon(Imagens.ULTIMO));
		btnUltimo.setToolTipText("Ir para último tópico");
		btnUltimo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnUltimoAction();
			}

		});
		btnUltimo.setBorder(btnsBorder);

		scrpTopicos.setPreferredSize(new Dimension(10, 10));
		scrpTopicos.setBorder(new EmptyBorder(0, 0, 0, 0));

		pnlTopicos.setPreferredSize(new Dimension(10, 10));
		pnlTopicos.addCardListener(new CardAdapter() {

			@Override
			public void cardAdded(String cardId) {
				PnlLaudo.this.cardAdded(cardId);
			}

			@Override
			public void cardSelected(String cardId) {
				PnlLaudo.this.cardSelected(cardId);
			}

		});

	}

	private void initPnlCentral() {

		MyJPanel pnlTxtTop = new MyJPanel(new GridBagLayout());
		pnlTxtTop.setBorder(new LineBorder(Color.DARK_GRAY));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1d;
		c.gridx = 0;
		c.gridy = 0;
		c.insets.top = 5;
		c.insets.left = 5;
		c.insets.bottom = 5;
		pnlTxtTop.add(new PnlComp(false, false, false).setComponent(txtTopico.pintarDeAmarelo()), c);
		c.weightx = 0d;
		c.gridx = 1;
		pnlTxtTop.add(btnPrimeiro, c);
		c.gridx = 2;
		pnlTxtTop.add(btnAnterior, c);
		c.gridx = 3;
		pnlTxtTop.add(btnProximo, c);
		c.gridx = 4;
		c.insets.right = 5;
		pnlTxtTop.add(btnUltimo, c);

		pnlCenter.add(new PnlComEspaco(pnlTxtTop), BorderLayout.NORTH);
		pnlCenter.add(new PnlComEspaco(scrpTopicos, 3, 0), BorderLayout.CENTER);

	}

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="PnlPreview">
	private TxtPreview txtHtmlPreview = new TxtPreview();
	private C_TxtPreview buscadorTxtPreview;
	private TxtComAutoCompletar txtTopicoPreview;
	private LblActionPreview lblEditar = new LblActionPreview("EDITAR");
	private LblActionPreview lblValorPadrao = new LblActionPreview("LAUDO PADRÃO");
	private MyJButton btnVoltarParaTopicos = new MyJButton("Voltar");

	{

		lblEditar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				actionLblEditar();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				actionLblEditar();
			}

		});

		lblValorPadrao.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				actionLblValorPadrao();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				actionLblValorPadrao();
			}

		});
		lblValorPadrao.setEnabled(false);

		btnVoltarParaTopicos.setIcon(SwingLibResources.getIcon(Imagens.VOLTAR));
		btnVoltarParaTopicos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnVoltarParaTopicos();
			}

		});
		btnVoltarParaTopicos.setVisible(false);

	}

	private void initPnlPreview() {

		buscadorTxtPreview = new C_TxtPreview(txtHtmlPreview, mediador);
		txtTopicoPreview = new TxtComAutoCompletar(buscadorTxtPreview);
		txtTopicoPreview.setHorizontalAlignment(TxtComAutoCompletar.CENTER);
		txtTopicoPreview.setMaxVisibleRows(7);

		pnlPreview.setPreferredHeight(0);

		MyJPanel pnl = new MyJPanel(new GridBagLayout());
		pnl.setBorder(new LineBorder(Color.gray));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.insets = new Insets(5, 5, 0, 0);
		pnl.add(new LblNegrito(" Pré visualização:"), c);

		c.gridx = 1;
		txtTopicoPreview.setPreferredWidth(370);
		c.weightx = 1;
		pnl.add(txtTopicoPreview, c);

		c.ipadx = 10;
		c.gridx = 2;
		c.weightx = 0;
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		pnl.add(lblEditar, c);

		c.gridx = 3;
		c.insets.right = 5;
		lblValorPadrao.setHorizontalAlignment(SwingConstants.CENTER);
		pnl.add(lblValorPadrao, c);

		c.gridx = 4;
		c.insets.left = 0;
		pnl.add(btnVoltarParaTopicos, c);

		c.weighty = 1;
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 5;
		c.insets.bottom = 5;
		c.insets.left = 5;
		txtHtmlPreview.setPreferredSize(new Dimension(10, 10));
		pnl.add(txtHtmlPreview, c);

		pnlPreview.add(new PnlComEspaco(pnl), BorderLayout.CENTER);

	}

	private class LblActionPreview extends MyJLabel {

		private LblActionPreview(String labelText) {
			super(labelText);

			Map<TextAttribute, Object> atributos = new HashMap<>();
			atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

			setFont(getFont().deriveFont(Font.BOLD, 14).deriveFont(atributos));
			setForeground(Color.BLUE);
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

	}

	private class TxtPreview extends TxtHtmlLaudo implements PreviewCampoDoLaudo {

		private boolean houveErroDeValidacao = false;

		private TxtPreview() {
			setEditable(false);
			setToolBarsVisible(false);
		}

		private void setCampoDoLaudo(CampoDoLaudo cdl) {
			if (cdl == null) {
				setHtml("");
			} else {
				String valor = cdl.getValor();
				if (valor == null || valor.isEmpty()) {
					lblValorPadrao.setEnabled(false);
					try {
						if (cdl instanceof Planilha) {
							setHtml(((Planilha) cdl).preview());
							houveErroDeValidacao = false;
						} else {
							setHtml(cdl.gerarHtml(false));
							houveErroDeValidacao = false;
						}
					} catch (ErrosDeValidacao ex) {
						setHtml("<font color=\"#FF0000\">" + ex.getMessage() + "</font>");
						houveErroDeValidacao = true;
					}
				} else {
					lblValorPadrao.setEnabled(true);
					setHtml(valor);
					houveErroDeValidacao = false;
				}
			}
		}

		@Override
		public void atualizarDadosDoPreview(int indexCdl) {
			PnlLaudo.this.atualizarDadosDoPreview(indexCdl);
		}

		@Override
		public void limparPreview() {
			PnlLaudo.this.limparPreview();
		}

		@Override
		public void atualizarAlturaDoPreview(int pixels) {
			PnlLaudo.this.atualizarAlturaDoPreview(pixels);
		}

		private boolean isHouveErroDeValidacao() {
			return houveErroDeValidacao;
		}

		@Override
		public void setHtml(String html) {
			super.setHtml(addTagDiv(html));
		}

		private String addTagDiv(String html) {
			if (html == null || html.contains("<div class=\"topico\">")) {
				return html;
			} else {
				return "<div class=\"topico\">" + html + "</div>";
			}
		}

	}

	// </editor-fold>
	// </editor-fold>
	private void cardAdded(String cardId) {
		buscadorTxtPreview.topicoFoiAdicionado(cardId);
	}

	private void cardSelected(String cardId) {
		buscadorTxtPreview.topicoFoiSelecionado(cardId);
	}

	private void atualizarDadosDoPreview(int indexCdl) {
		if (activeSw == null) {
			return;
		}
		try {
			if (indexCdl == -1) {
				txtHtmlPreview.setCampoDoLaudo(activeSw.getLaudo().getPlanilha());
			} else {
				txtHtmlPreview.setCampoDoLaudo(activeSw.getLaudo().getPlanilha().getCampo(indexCdl));
			}
		} catch (Exception ex) {
			txtHtmlPreview.setCampoDoLaudo(null);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				txtHtmlPreview.getScrollPane().getVerticalScrollBar().setValue(0);
			}

		});
	}

	private void atualizarAlturaDoPreview(int pixels) {
		pnlPreview.setPreferredHeight(pixels);
		revalidate();
	}

	private void limparPreview() {
		btnVoltarParaTopicos.setVisible(false);
		pnlCenter.setVisible(true);
		pnlPreview.setPreferredHeight(0);
		txtHtmlPreview.setCampoDoLaudo(null);
		revalidate();
	}

	private void actionLblEditar() {
		if (buscadorTxtPreview.planilhaFoiEditada() && !buscadorTxtPreview.isImpLaudoSelected()) {
			SwingUtils.mostrarAviso(this, "O laudo está em modo de edição total.");
		} else if (buscador.getSelectedModel().getModeloDeLaudo().getCodigo() == 27) {
			actionBtnVoltarParaTopicos();
		} else {
			DlgPersonalizarCdl dlg = criarDlgPersCdl();
			dlg.setVisible(true);
			if (dlg.isCancelado()) {
			} else {
				buscadorTxtPreview.setarValor(dlg.getHtmlEditado());
			}
		}
	}

	private DlgPersonalizarCdl criarDlgPersCdl() {
		DlgPersonalizarCdl dlg;
		if (buscadorTxtPreview.isImpLaudoSelected()) {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(screenSize);
			dlg = new DlgPersonalizarCdl(rect);
		} else {
			int maxWidht = 800;
			int maxHeight = 600;
			int minWidht = txtHtmlPreview.getPreferredSize().width;
			int minHeight = 400;

			int width = Math.min(maxWidht, txtHtmlPreview.getSize().width);
			int height = Math.min(maxHeight, txtHtmlPreview.getSize().height);

			width = Math.max(minWidht, width);
			height = Math.max(minHeight, height);

			dlg = new DlgPersonalizarCdl(width, height);
		}
		return dlg;
	}

	private void actionLblValorPadrao() {
		if (lblValorPadrao.isEnabled() && SwingUtils.obterConfirmacaoDoUsuario(
				"Esta ação apaga este laudo digitado.\n" + "Tem certeza que deseja continuar?",
				this) == JOptionPane.YES_OPTION) {
			buscadorTxtPreview.setarValorPadrao();
		} else {
//            PnlLaudoeCia.getInstance().mostrarMsgErro("O tópico já está"
//                    + "  com valor padrão!");
		}
	}

	private void actionBtnVoltarParaTopicos() {
		alterarVisualizacaoLaudo(false);
	}

	private void btnPrimeiroAction() {
		if (txtTopico.getControlador() == null) {
		} else {
			txtTopico.getControlador().primeiro();
			pnlTopicos.requestFocusInWindow();
		}
	}

	private void btnAnteriorAction() {
		if (txtTopico.getControlador() == null) {
		} else {
			txtTopico.getControlador().anterior();
			pnlTopicos.requestFocusInWindow();
		}
	}

	private void btnProximoAction() {
		if (txtTopico.getControlador() == null) {
		} else {
			txtTopico.getControlador().proximo();
			pnlTopicos.requestFocusInWindow();
		}
	}

	private void btnUltimoAction() {
		if (txtTopico.getControlador() == null) {
		} else {
			txtTopico.getControlador().ultimo();
			pnlTopicos.requestFocusInWindow();
		}
	}

	private void cancelActiveSw(boolean mayInterruptIfRunning) {
		if (activeSw == null) {
		} else if (activeSw.isDone()) {
			activeSw.cancelarShowView();
		} else {
			activeSw.cancelar(mayInterruptIfRunning);
		}
	}

	private void alterarVisualizacaoLaudo(boolean visualizar) {
		if (btnVoltarParaTopicos.isVisible() == visualizar) {
		} else {
			int pnlPreviewHeight = pnlPreview.getPreferredSize().height;
			if (visualizar) {
				buscadorTxtPreview.selecionarImpLaudo();
				pnlPreviewHeight += pnlCenter.getHeight();
			} else {
				pnlPreviewHeight -= pnlCenter.getHeight();
			}
			pnlCenter.setVisible(!visualizar);
			btnVoltarParaTopicos.setVisible(visualizar);
			pnlPreview.setPreferredHeight(pnlPreviewHeight);
			revalidate();
		}
	}

	PnlCartao getPnlTopicos() {
		return pnlTopicos;
	}

	void irParaTopico(CampoDoLaudo cdl) {
		alterarVisualizacaoLaudo(false);
		activeSw.irParaTopico(cdl);
	}

	void irParaExec() {
		if (activeSw == null) {
		} else {
			alterarVisualizacaoLaudo(false);
			activeSw.irParaExec();
		}
	}

	void configurarLaudo(ProcMedico proc, ModeloDeLaudoDoProc mdlSel) {
		buscador.setModel(proc, mdlSel);
//        if (proc != null && proc.getLaudoModelo())
//        {
//            abrirPopupModelo();
//        }
	}

	void setLaudo(Laudo laudo) {

		cancelActiveSw(false);

		pnlTopicos.removeAllCards();
		txtTopico.setControlador(null);
		if (laudo == null) {
			activeSw = null;
		} else if (laudos.containsKey(laudo)) {
			activeSw = laudos.get(laudo);
			activeSw.showView();
		} else {
			SwViewLaudo newSw = new SwViewLaudo(laudo, txtTopico, pnlTopicos, mediador);
			newSw.execute();
			activeSw = newSw;
			laudos.put(laudo, newSw);
		}
	}

	void limparLaudos() {
		laudos.clear();
		cancelActiveSw(true);
		alterarVisualizacaoLaudo(false);
		activeSw = null;
	}

	void visualizarLaudo() {
		alterarVisualizacaoLaudo(!btnVoltarParaTopicos.isVisible());
	}

	@Override
	public boolean requestFocusInWindow() {
		return pnlTopicos.requestFocusInWindow();
	}

	private class DlgPersonalizarCdl extends MyJDialog {

		private String htmlOriginal;
		private boolean cancelado = true;

		private DlgPersonalizarCdl(Rectangle bounds) {
			super(PnlLaudoeCia.getInstance(), true, bounds);
			setLocationRelativeTo(PnlLaudo.this);
			init();
		}

		private DlgPersonalizarCdl(int width, int height) {
			super(PnlLaudoeCia.getInstance(), true, width, height);
			init();
		}

		private void init() {
			setUndecorated(true);
			editor.setHtml(getHtmlOriginal());
			htmlOriginal = editor.getHTML();
			initView();
			addWindowListener(new WindowAdapter() {

				@Override
				public void windowOpened(WindowEvent e) {
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							editor.getScrollPane().getVerticalScrollBar().setValue(0);
						}

					});
				}

			});
			editor.getEditor().setCaretPosition(0);
		}

		private String getHtmlOriginal() {
			if (txtHtmlPreview.isHouveErroDeValidacao()) {
				return "";
			}
			return txtHtmlPreview.getHTML();
		}

		// <editor-fold defaultstate="collapsed" desc="View">
		private TxtHtmlLaudo editor = new TxtHtmlLaudo();
		private MyJButton btnConfirmar = new MyJButton("Confirmar");
		private MyJButton btnCancelar = new MyJButton("Cancelar");

		{
			editor = editor.withSpellChecker();
			editor = editor.withAddTextosPadrao(activeSw.getLaudo().getProcDoAtd().getProcMedico());

			btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
			btnConfirmar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					confirmar();
				}

			});

			btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
			btnCancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cancelar();
				}

			});

		}

		private void initView() {

			MyJPanel contentPane = new MyJPanel(new GridBagLayout());
			contentPane.setBorder(new BlackAndWhiteEtchedBorder());

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;

			c.weighty = 1;
			c.gridwidth = 3;
			c.insets.top = 10;
			c.insets.left = 10;
			c.insets.right = 10;
			contentPane.add(editor, c);

			c.gridwidth = 1;
			c.weightx = 1;
			c.gridy = 1;
			c.weighty = 0;
			c.insets.right = 0;
			c.insets.bottom = 10;
			contentPane.add(new LblNegrito(
					"<html><font color=\"ff0000\">" + "Atenção: Quando é usada a opção \"EDITAR\" novas "
							+ "mudanças no laudo<br> só podem ser feitas " + "diretamente nessa janela.</font></html>",
					SwingConstants.CENTER), c);

			c.gridx = 1;
			c.weightx = 0;
			c.ipady = 20;
			c.ipadx = 5;
			contentPane.add(btnConfirmar, c);

			c.gridx = 2;
			c.insets.right = 10;
			contentPane.add(btnCancelar, c);

			setLayout(new BorderLayout());
			add(contentPane, BorderLayout.CENTER);

		}

		// </editor-fold>
		private void confirmar() {
			if (htmlOriginal.equals(editor.getHTML())) {
				cancelar();
			} else {
				cancelado = false;
				fechar();
			}
		}

		private String getHtmlEditado() {
			return editor.getHTML();
		}

		private boolean isCancelado() {
			return cancelado;
		}

		private void cancelar() {
			fechar();
		}

		@Override
		public void fechar() {
			dispose();
		}

	}

	public void abrirPopupModelo() {

		mdl = buscador.getSelectedModel();
		int y = btnModelo.getSize().height;
		popupModelo.show(btnModelo, 0, y);
		tabelaDeModelos.limparModeloSelecionado();
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				txtModelos.autoCompletar();
			}

		});

	}

}
