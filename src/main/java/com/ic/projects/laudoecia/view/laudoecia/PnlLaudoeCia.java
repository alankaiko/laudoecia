/*
 * PnlLaudoeCia.java
 *
 * Created on 18/04/2012, 17:04:25
 */

package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LayerUI;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.iview.ViewLaudoeCia;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.PaginaDeImagens;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.view.build.PnlFormPrincipal;
import com.ic.projects.laudoecia.view.build.ViewFactory;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutImagens;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutLaudoE4Img;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutLaudoE5Img;
import com.ic.projects.laudoecia.view.print.LaudosHTMLUtils;
import com.ic.projects.laudoecia.view.print.PrintLaudo;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.utils.SwingUtils;

/**
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlLaudoeCia extends MyJPanel implements ViewLaudoeCia, PnlFormPrincipal {

	private final String PNL_LAUDO_TVCAP = "PNL_LAUDO_TVCAP";
	private static PnlLaudoeCia instance;
	private ViewImagens viewImagens = null;
	private JLayer<JPanel> layerPnlCartao;
	private LaudoeCiaMediator mediador = new LaudoeCiaMediator(this);
	private PrintLaudo printer = new PrintLaudo();
	private SwingWorker<Void, Void> swGravadora;
	private ActionListener actionImprimirLaudoEImg = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			mediador.imprimirLaudoEImagens();
		}
	};
	private ActionListener actionImprimirSoLaudo = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			mediador.imprimirApenasLaudo();
		}
	};
	private ActionListener actionImprimirSoImg = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			mediador.imprimirApenasImagens();
		}
	};
	private MouseListDaCaptura mlDaCaptura = new MouseListDaCaptura(mediador);
	private DlgAguarde dlgAguarde;

	// <editor-fold defaultstate="collapsed" desc="Singleton, PnlFormPrincipal,
	// Component">

	private PnlLaudoeCia() {
		setLayout(new BorderLayout());
		add(pnlCartao, BorderLayout.CENTER);
		configurarControlesPeloTeclado();
	}

	public synchronized static PnlLaudoeCia getInstance() {
		if (instance == null) {
			instance = new PnlLaudoeCia();
		}
		return instance;
	}

	@Override
	public JMenuBar getMenu() {
		return menuBar;
	}

	@Override
	public boolean fullScreen() {
		return true;
	}

	@Override
	public Container getContainer() {
		if (layerPnlCartao == null) {
			LayerUI<JPanel> layerUi = new LayerUI<JPanel>() {
				@Override
				protected void processMouseEvent(final MouseEvent e, JLayer<? extends JPanel> l) {
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							switch (e.getID()) {
							case MouseEvent.MOUSE_RELEASED:
								mlDaCaptura.mouseReleased(e);
								break;
							case MouseEvent.MOUSE_PRESSED:
								mlDaCaptura.mousePressed(e);
								break;
							default:
							}
						}

					});
				}

			};
			layerPnlCartao = new JLayer<>(instance, layerUi);
			layerPnlCartao.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
			layerPnlCartao.addComponentListener(new ComponentAdapter() {

				@Override
				public void componentShown(ComponentEvent e) {
					PnlLaudoeCia.this.requestFocusInWindow();
				}
			});
		}
		return layerPnlCartao;
	}

	@Override
	public void selected() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				requestFocusInWindow();
				pnlLaudo.getPnlTopicos().removeAllCards();
			}

		});
	}

	@Override
	public boolean requestFocusInWindow() {
		if (menuBar == null) {
			return super.requestFocusInWindow();
		} else {
			return menuBar.requestFocusInWindow();
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Componentes de Visão">

	private MenuBarAtendimento menuBar = new MenuBarAtendimento(mediador);
	private PnlCartao pnlCartao = new PnlCartao();
	private MyJPanel pnlLaudoECia = new MyJPanel(new GridBagLayout());
	private PnlImagensAtdFullScreen pnlImgsFullScreen = new PnlImagensAtdFullScreen(mediador);
	private PnlEscolherImagens pnlEscolherImagens = new PnlEscolherImagens(mediador);

	// pnlLaudoECia components
	private PnlCartao pnlCartaoLaudoTVCap = new PnlCartao();
	private MyJPanel pnlTVCaptura = new MyJPanel(new BorderLayout());
	private PnlLaudo pnlLaudo = new PnlLaudo(mediador);
	private MyJButton btnShowHideImgCap = new MyJButton();
	private PnlImagensAtd pnlImagens = new PnlImagensAtd(mediador);
	private PnlCaptura pnlActionsCaptura = new PnlCaptura(mediador, pnlTVCaptura);

	{
		pnlTVCaptura.setBorder(new BlackAndWhiteEtchedBorder());

		btnShowHideImgCap.setIcon(ImageResources.getIcon(ImagensLC.SETA_TO_RIGHT));
		btnShowHideImgCap.setBorder(new EmptyBorder(4, 4, 4, 4));
		btnShowHideImgCap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alternarVisibDoPnlImagens();
			}
		});

		// <editor-fold defaultstate="collapsed" desc="pnlLaudoECia Layout">
		pnlCartaoLaudoTVCap.addCard(pnlLaudo, LAUDO);
		pnlCartaoLaudoTVCap.addCard(pnlTVCaptura, CAPTURA);
		pnlCartaoLaudoTVCap.setSelectedCard(LAUDO);

		MyJPanel pnlImgECapt = new MyJPanel(new BorderLayout());
		pnlImgECapt.add(pnlImagens, BorderLayout.PAGE_START);
		pnlImgECapt.add(pnlActionsCaptura, BorderLayout.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1d;
		c.weighty = 1d;
		pnlCartaoLaudoTVCap.setPreferredSize(new Dimension(10, 10));
		pnlLaudoECia.add(pnlCartaoLaudoTVCap, c);
		c.gridx = 1;
		c.weightx = 0d;
		c.weighty = 0d;
		pnlLaudoECia.add(btnShowHideImgCap, c);
		c.gridx = 2;
		pnlLaudoECia.add(pnlImgECapt, c);

		// </editor-fold>

		pnlCartao.addCard(pnlLaudoECia, PNL_LAUDO_TVCAP);
		pnlCartao.addCard(pnlEscolherImagens, ESCOLHER_IMAGENS);
		pnlCartao.addCard(pnlImgsFullScreen, IMAGENS_FULL_SCREEN);
		pnlCartao.setSelectedCard(PNL_LAUDO_TVCAP);
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Private and package private
	// stuff">

	void alternarGravacaoNoDisco() {
		pnlActionsCaptura.alternarGravacaoNoDisco();
	}

	private void configurarControlesPeloTeclado() {
		InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);

		KeyStroke ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK, true);
		inputMap.put(ctrlS, "salvar");

		KeyStroke ctrlP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK, true);
		inputMap.put(ctrlP, "printSoLaudo");

		KeyStroke ctrlAltP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK + InputEvent.ALT_MASK, true);
		inputMap.put(ctrlAltP, "printSoImg");

		KeyStroke ctrlShiftP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK,
				true);
		inputMap.put(ctrlShiftP, "printLaudoImg");

		ActionMap actionMap = getActionMap();
		actionMap.put("salvar", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.salvar();
			}
		});
		actionMap.put("printLaudoImg", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.imprimirLaudoEImagens();
			}
		});
		actionMap.put("printSoLaudo", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.imprimirApenasLaudo();
			}
		});
		actionMap.put("printSoImg", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediador.imprimirApenasImagens();
			}
		});

	}

	private void alternarVisibDoPnlImagens() {
		boolean visible = !pnlImagens.isVisible();
		if (visible) {
			pnlImagens.setVisible(true);
			pnlActionsCaptura.setVisible(true);
			btnShowHideImgCap.setIcon(ImageResources.getIcon(ImagensLC.SETA_TO_RIGHT));
			btnShowHideImgCap.setToolTipText("Esconder imagens e captura");
		} else {
			pnlImagens.setVisible(false);
			pnlActionsCaptura.setVisible(false);
			btnShowHideImgCap.setIcon(ImageResources.getIcon(ImagensLC.SETA_TO_LEFT));
			btnShowHideImgCap.setToolTipText("Mostrar imagens e captura");
		}
	}

	private boolean escolheuImagensParaImpressao() {
		if (pnlEscolherImagens.isPaginasVazias()) {
			if (obterConfirmacaoDoUsuario("Não foram definidas imagens para impressão!\n"
					+ "Deseja que o sistema preencha automaticamente e faça a impressão?\n"
					+ "Caso escolha [não] você será direcionado para tela de escolher imagens.")) {
			} else {
				mediador.escolherImgParaImp();
				return false;
			}
			mediador.escolherImagensAutomaticamente(false);
		}
		return true;
	}

	private List<File> imagens;

	private List<File> getArquivosParaExportar(int tipoExportacao) {
		List<File> videos = new ArrayList<>();
		imagens = new ArrayList<>();
		if (tipoExportacao == LaudoeCiaMediator.EXP_APENAS_VIDEOS
				|| tipoExportacao == LaudoeCiaMediator.EXP_IMAGENS_VIDEOS) {
			videos = mediador.getFilesVideosGravados(false);
			if (videos == null) {
				return null;
			}
		}
		if (tipoExportacao == LaudoeCiaMediator.EXP_APENAS_IMAGENS
				|| tipoExportacao == LaudoeCiaMediator.EXP_IMAGENS_VIDEOS) {
			imagens = mediador.exportarImagensProcedimento(getTempPath());
			if (imagens == null) {
				return null;
			}
		}
		List<File> arquivos = new ArrayList<>();
		arquivos.addAll(videos);
		arquivos.addAll(imagens);
		return arquivos;
	}

	private String getTempPath() {
		String path;
		File tempFile;
		try {
			tempFile = File.createTempFile("path", ".0");
			path = tempFile.getParent();
			tempFile.delete();
		} catch (IOException ex) {
			return null;
		}
		return path;
	}

	private void deletarTempFiles(List<File> imagens) {
		if (imagens == null) {
			return;
		}
		for (int i = 0; i < imagens.size(); i++) {
			imagens.get(i).delete();
		}
	}

	private String addAtdInfoEAssProf(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		LaudosHTMLUtils.setProcDoAtd(procDoAtd);
		String htmlComAdicionais = htmlDoLaudo;
		htmlComAdicionais += LaudosHTMLUtils.createAssProf(procDoAtd.getProfExecutante());
		return htmlComAdicionais;
	}

	private String gerarHtmlImpressaoLaudoEImg(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		String htmlComAdicionais;
		String htmlPagesLaudo;
		int numPages;
		final int MARGEM_SEGURANCA = 8;

		LaudosHTMLUtils.setProcDoAtd(procDoAtd);

		String html;
		LAYOUT_IMG layout_img = pnlEscolherImagens.temLayoutLaudoEImagens();
		if (layout_img != null) {
			htmlComAdicionais = htmlDoLaudo;
			htmlComAdicionais += LaudosHTMLUtils.createAssProf(procDoAtd.getProfExecutante());
			switch (layout_img) {
			case LAYOUT_LAUDO_E_4_IMG:
				numPages = printer.getNumPages(PnlLayoutLaudoE4Img.getTabelaDivisao("&nbsp;")
						.replace(PnlLayoutImagens.TEXTO_LAUDO, htmlComAdicionais));
				break;
			case LAYOUT_LAUDO_E_5_IMG:
				numPages = printer.getNumPages(PnlLayoutLaudoE5Img.getTabelaDivisao("&nbsp;")
						.replace(PnlLayoutImagens.TEXTO_LAUDO, htmlComAdicionais));
				break;
			default:
				throw new NullPointerException();
			}
			htmlPagesLaudo = LaudosHTMLUtils.createTabelaPagina(htmlComAdicionais, numPages, false,
					(numPages * MARGEM_SEGURANCA), true);

			html = pnlEscolherImagens.gerarHtmlParaImpressao(true, procDoAtd);
			html = html.replace(PnlLayoutImagens.TEXTO_LAUDO, htmlPagesLaudo);
		} else {
			htmlComAdicionais = addAtdInfoEAssProf(htmlDoLaudo, procDoAtd);
			numPages = printer.getNumPages(htmlComAdicionais);
			htmlPagesLaudo = LaudosHTMLUtils.createTabelaPagina(htmlComAdicionais, numPages, false,
					(numPages * MARGEM_SEGURANCA), true);
			html = htmlPagesLaudo + pnlEscolherImagens.gerarHtmlParaImpressao(false, procDoAtd);
		}
		return html;
	}

	String getSelectedCard() {
		return pnlCartao.getSelectedCard();
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="View LaudoeCia">

	@Override
	public void atualizarImgImpressa(int indexPag, int indiceDaImg, byte[] novaImg) {
		pnlEscolherImagens.atualizarImgImpressa(indexPag, indiceDaImg, novaImg);
	}

	@Override
	public void carregarImpressoes(List<PaginaDeImagens> paginas) {
		pnlEscolherImagens.carregarImpressoes(paginas);
	}

	@Override
	public void mostrarErroDeValidacaoDoLaudo(ErrosDeValidacao ex) {
		mostrarMsgErro(ex.getMessage());
		pnlLaudo.irParaTopico(ex.getSource());
	}

	@Override
	public void mostrarDadosDoAtendimento(Atendimento atd) {
		// maybe invoke and wait would be better
		try {
			pnlActionsCaptura.pararAtividades();
			final DlgInfoAtd dlg = DlgInfoAtd.getInstance();
			dlg.setAtendimento(atd);
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					dlg.setVisible(true);
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							pnlLaudo.requestFocusInWindow();
						}

					});
				}

			});
			pnlActionsCaptura.continuarAtividades();
		} catch (ClassCastException e) {
			mostrarDadosDoAtendimento(atd);
		}
	}

	@Override
	public void setLaudo(Laudo laudo) {
		pnlLaudo.setLaudo(laudo);
	}

	@Override
	public void visualizarLaudo() {
		pnlLaudo.visualizarLaudo();
	}

	@Override
	public void limparLaudos() {
		pnlLaudo.limparLaudos();
	}

	@Override
	public void setAtendimento(Atendimento atendimento) {
		menuBar.setAtendimento(atendimento);
	}

	@Override
	public void configurarLaudo(ProcMedico proc, ModeloDeLaudoDoProc mdlSel) {
		pnlLaudo.configurarLaudo(proc, mdlSel);
	}

	@Override
	public void setProcSel(ProcDoAtd procSel) {
		menuBar.setProcedimentoSelecionado(procSel);
	}

	@Override
	public void setProcedimentos(java.util.List<ProcDoAtd> procedimentos) {
		menuBar.setProcedimentos(procedimentos);
	}

	@Override
	public void setState(String state) {
		switch (state) {
		case CAPTURA:
			viewImagens = pnlImagens;
			pnlCartaoLaudoTVCap.setSelectedCard(CAPTURA, false);
			pnlActionsCaptura.continuarAtividades();
			pnlActionsCaptura.configurarBtnLaudoCapt(true);
			menuBar.configurarBtnVoltar(true);
			pnlCartao.setSelectedCard(PNL_LAUDO_TVCAP);
			ViewFactory.getInstance().getC_Captura().capturaFoiAcionada();
			if (StaticInfo.primeiraExecucaoDaCaptura()) {
				pnlActionsCaptura.chamarAtencaoParaBtnOpcoesDaCaptura();
			}
			break;
		case LAUDO:
			viewImagens = pnlImagens;
			pnlCartaoLaudoTVCap.setSelectedCard(LAUDO);
			pnlActionsCaptura.continuarAtividades();
			pnlActionsCaptura.configurarBtnLaudoCapt(false);
			menuBar.configurarBtnVoltar(true);
			pnlCartao.setSelectedCard(PNL_LAUDO_TVCAP);
			break;
		case IMAGENS_FULL_SCREEN:
			viewImagens = pnlImgsFullScreen;
			pnlActionsCaptura.pararAtividades();
			menuBar.configurarBtnVoltar(false);
			pnlCartao.setSelectedCard(IMAGENS_FULL_SCREEN);
			break;
		case ESCOLHER_IMAGENS:
			viewImagens = pnlEscolherImagens;
			pnlActionsCaptura.pararAtividades();
			menuBar.configurarBtnVoltar(false);
			pnlCartao.setSelectedCard(ESCOLHER_IMAGENS);
			break;
		default:
		}
	}

	@Override
	public void pararCaptura() {
		pnlActionsCaptura.pararAtividades();
	}

	@Override
	public void mostrarMsgErro(String msgErro) {
		SwingUtils.mostrarMensagemDeErroConhecido(this, msgErro);
	}

	@Override
	public void mostrarMsgSucesso(String msgSucesso) {
		SwingUtils.mostrarMsgDeSucesso(this, msgSucesso);
	}

	@Override
	public void mostrarAviso(String aviso) {
		SwingUtils.mostrarAviso(this, aviso);
	}

	@Override
	public boolean obterConfirmacaoDoUsuario(String msg) {
		return SwingUtils.obterConfirmacaoDoUsuario(msg, this) == JOptionPane.YES_OPTION;
	}

	@Override
	public void editarImagemAtual() {

		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		DlgEdicaoDeImg dlgEdicaoDeImg = new DlgEdicaoDeImg(mediador);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		dlgEdicaoDeImg.setVisible(true);
	}

	@Override
	public void imgSelMudou() {
		viewImagens.imgSelMudou();
		if (viewImagens != pnlImagens) {
			pnlImagens.imgSelMudou();
		}
		if (viewImagens != pnlEscolherImagens) {
			pnlEscolherImagens.imgSelMudou();
		}
		if (viewImagens != pnlImgsFullScreen) {
			pnlImgsFullScreen.imgSelMudou();
		}
	}

	@Override
	public void atualizarSelecao() {
		viewImagens.atualizarSelecao();
	}

	@Override
	public void removerImgSelecionada() {
		viewImagens.removerImgSel();
		if (viewImagens != pnlImagens) {
			pnlImagens.removerImgSel();
		}
		if (viewImagens != pnlEscolherImagens) {
			pnlEscolherImagens.removerImgSel();
		}
		if (viewImagens != pnlImgsFullScreen) {
			pnlImgsFullScreen.removerImgSel();
		}
	}

	@Override
	public void addImagem(byte[] img) {
		viewImagens.addImg(img);
		if (viewImagens != pnlImagens) {
			pnlImagens.addImg(img);
		}
		if (viewImagens != pnlEscolherImagens) {
			pnlEscolherImagens.addImg(img);
		}
		if (viewImagens != pnlImgsFullScreen) {
			pnlImgsFullScreen.addImg(img);
		}
	}

	@Override
	public void carregarImagens(java.util.List<byte[]> imagens) {
		viewImagens.carregarImagens(imagens);
		if (viewImagens != pnlImagens) {
			pnlImagens.carregarImagens(imagens);
		}
		if (viewImagens != pnlEscolherImagens) {
			pnlEscolherImagens.carregarImagens(imagens);
		}
		if (viewImagens != pnlImgsFullScreen) {
			pnlImgsFullScreen.carregarImagens(imagens);
		}
	}

	@Override
	public void escolherImagensAutomaticamente(java.util.List<byte[]> imagens) {
		pnlEscolherImagens.doEscolherImagensAutomaticamente(imagens);
	}

	@Override
	public void exportarArquivosDoProc() {
		DlgExportarImgVideos dlg = new DlgExportarImgVideos(mediador);
		dlg.setVisible(true);
	}

	@Override
	public boolean iniciarGravacaoNoDisco(int tipoExportacao, final String dispositivo) {
		// final List<File> arquivos = getArquivosParaExportar(tipoExportacao);
		// if (arquivos == null) //aborta processo
		// {
		// return false;
		// }
		// swGravadora = new SwingWorker<Void, Void>()
		// {
		// @Override
		// @SuppressWarnings("SleepWhileInLoop")
		// protected Void doInBackground () throws Exception
		// {
		// pnlActionsCaptura.setGravacaoDiscoVisible(true);
		// //manda comando para gravação em disco
		// for (File arquivo : arquivos)
		// {
		// while (mediador.videoEstaSendoCompactado(arquivo.getAbsolutePath()))
		// {
		// Thread.sleep(1000);
		// }
		// }
		// CDRecorder.burnCD(arquivos, dispositivo);
		// pnlActionsCaptura.setGravacaoDiscoVisible(false);
		// deletarTempFiles(imagens);
		// mediador.gravacaoNoDiscoFinalizou();
		// return null;
		// }
		// };
		// swGravadora.execute();
		mostrarAviso("A gravação em CD/DVD está desabilitada nesta versão!");
		return false;
	}

	@Override
	public void abortarGravacaoNoDisco() {
		if (swGravadora != null) {
			mediador.gravacaoNoDiscoFinalizou();
			swGravadora.cancel(true);
		}
	}

	@Override
	public void imprimirApenasLaudo(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		printer.setProcDoAtd(procDoAtd);
		printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
		String htmlComAdicionais = addAtdInfoEAssProf(htmlDoLaudo, procDoAtd);
		int numPages = printer.getNumPages(htmlComAdicionais);
		if (numPages == 1) {
			htmlComAdicionais = LaudosHTMLUtils.createTabelaPagina(htmlComAdicionais, numPages, false, 0, true);
		}
		printer.print(htmlComAdicionais, StaticInfo.getParametrosDoSistema().getDefprinterlaudo(),
				procDoAtd.getAtendimento().getConvenio().getNumcopiasdolaudo());
	}

	@Override
	public void imprimirLaudoEImg(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			printer.print(gerarHtmlImpressaoLaudoEImg(htmlDoLaudo, procDoAtd),
					StaticInfo.getParametrosDoSistema().getDefprinterimagens(), 1);
		}
	}

	@Override
	public void imprimirApenasImagens(ProcDoAtd procDoAtd) {
		if (pnlEscolherImagens.temLayoutLaudoEImagens() != null) {
			mediador.imprimirLaudoEImagens();
		} else if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			printer.print(pnlEscolherImagens.gerarHtmlParaImpressao(true, procDoAtd),
					StaticInfo.getParametrosDoSistema().getDefprinterimagens(), 1);
		}
	}

	@Override
	public void previewApenasImagens(ProcDoAtd procDoAtd) {
		if (pnlEscolherImagens.temLayoutLaudoEImagens() != null) {
			mostrarMsgErro("Não é possível imprimir apenas imagens com o layout \n["+ LAYOUT_IMG.LAYOUT_LAUDO_E_4_IMG.getLayout() + "].\n" + "Escolha outro layout para impressão.");
			mediador.escolherImgParaImp();
		} else if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			printer.preview(pnlEscolherImagens.gerarHtmlParaImpressao(true, procDoAtd), actionImprimirSoImg);
		}
	}

	@Override
	public void previewApenasLaudo(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		printer.setProcDoAtd(procDoAtd);
		printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
		String htmlComAdicionais = addAtdInfoEAssProf(htmlDoLaudo, procDoAtd);
		int numPages = printer.getNumPages(htmlComAdicionais);
		if (numPages == 1) {
			htmlComAdicionais = LaudosHTMLUtils.createTabelaPagina(htmlComAdicionais, numPages, false, 0, true);
		}
		printer.preview(htmlComAdicionais, actionImprimirSoLaudo);
	}

	@Override
	public void previewLaudoEImg(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			printer.preview(gerarHtmlImpressaoLaudoEImg(htmlDoLaudo, procDoAtd), actionImprimirLaudoEImg);
		}
	}

	@Override
	public void capturarImagem() {
		pnlActionsCaptura.capturarImg();
	}

	@Override
	public void irParaExec() {
		pnlLaudo.irParaExec();
	}

	@Override
	public void gerarPDFApenasImagens(final ProcDoAtd procDoAtd) {
		if (pnlEscolherImagens.temLayoutLaudoEImagens() != null) {
			mediador.gerarPDFLaudoEImagens();
		} else if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			printer.gerarPDF(pnlEscolherImagens.gerarHtmlParaImpressao(true, procDoAtd));
		}
	}

	@Override
	public void gerarPDFApenasLaudo(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		printer.setProcDoAtd(procDoAtd);
		printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
		String htmlComAdicionais = addAtdInfoEAssProf(htmlDoLaudo, procDoAtd);
		int numPages = printer.getNumPages(htmlComAdicionais);
		if (numPages == 1) {
			htmlComAdicionais = LaudosHTMLUtils.createTabelaPagina(htmlComAdicionais, numPages, false, 0, true);
		}
		printer.gerarPDF(htmlComAdicionais);
	}

	@Override
	public void gerarPDFLaudoEImg(final String htmlDoLaudo, final ProcDoAtd procDoAtd) {
		if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			printer.gerarPDF(gerarHtmlImpressaoLaudoEImg(htmlDoLaudo, procDoAtd));
		}
	}

	@Override
	public File GerarEnvioPdfEmailLaudoEImg(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
		}
		return printer.GerarEnvioPDFEmail(gerarHtmlImpressaoLaudoEImg(htmlDoLaudo, procDoAtd));
	}
	
	@Override
	public File GerarEnvioPdfEmailLaudo(String htmlDoLaudo, ProcDoAtd procDoAtd) {
		printer.setProcDoAtd(procDoAtd);
		printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
		String htmlComAdicionais = addAtdInfoEAssProf(htmlDoLaudo, procDoAtd);
		int numPages = printer.getNumPages(htmlComAdicionais);
		if (numPages == 1) {
			htmlComAdicionais = LaudosHTMLUtils.createTabelaPagina(htmlComAdicionais, numPages, false, 0, true);
		}
		return printer.GerarEnvioPDFEmail(htmlComAdicionais);
	}
	
	@Override
	public File GerarEnvioPdfEmailImagens(ProcDoAtd procDoAtd) {
		if (pnlEscolherImagens.temLayoutLaudoEImagens() != null) {
			mediador.gerarPDFLaudoEImagens();
		} else if (escolheuImagensParaImpressao()) {
			printer.setProcDoAtd(procDoAtd);
			printer.pagina = pnlEscolherImagens.getPaginaAtual().getNumPagina();
			return printer.GerarEnvioPDFEmail(pnlEscolherImagens.gerarHtmlParaImpressao(true, procDoAtd));
		}
		
		return null;
	}
	
	@Override
	public boolean iniciarGravacaoDeVideo(File arquivo) {
		return pnlActionsCaptura.iniciarGravacaoDeVideo(arquivo);
	}

	@Override
	public void btnGravarVideoDoClick(boolean tratarSelected) {
		pnlActionsCaptura.btnGravarVideoDoClick(tratarSelected);
	}

	@Override
	public void setarListaVideos(List<VideoGravado> videos) {
		pnlActionsCaptura.setListaVideos(videos);
	}

	@Override
	public Date liberarEspacoEmDisco() {
		DlgLimparEspacoEmDisco dlg = new DlgLimparEspacoEmDisco(this);
		dlg.setVisible(true);
		if (!dlg.isCancelado()) {
			return dlg.getData();
		}
		return null;
	}

	@Override
	public void mostrarDlgAguarde(String texto) {
		if (dlgAguarde == null) {
			dlgAguarde = new DlgAguarde(this);
		}
		dlgAguarde.setText(texto);
		if (!dlgAguarde.isVisible()) {
			dlgAguarde.setVisible(true);
		}
	}

	@Override
	public void ocultarDlgAguarde() {
		dlgAguarde.fechar();
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Public">

	public static boolean foiInstanciado() {
		return instance != null;
	}

	public void disconnect() {
		pnlActionsCaptura.desconectar();
	}

	public void abrirModuloDeLaudo(Atendimento atdASerMostrado, ProcDoAtd procSel) {
		mediador.abrirModuloDeLaudo(atdASerMostrado, procSel);
		if (atdASerMostrado == null) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					menuBar.requestFocusInWindow();
				}

			});
		}
	}

	public void abrirModuloDeCaptura(Atendimento atdASerMostrado, ProcDoAtd procSel) {
		mediador.abrirModuloDeCaptura(atdASerMostrado, procSel);
	}

	public void voltar() {
		menuBar.voltar();
	}

	public Rectangle getPnlCapturaBounds() {
		return pnlCartaoLaudoTVCap.getBounds();
	}

	public boolean estaCompactandoVideo() {
		return mediador.estaCompactandoVideo();
	}

	public boolean estaGravandoCd() {
		return mediador.estaGravandoCd();
	}

	// </editor-fold>

	private class DlgAguarde extends MyJDialog {

		private DlgAguarde(Component cp) {
			super(cp, true, 300, 100);
			setUndecorated(true);

			progressBar.setIndeterminate(true);
			progressBar.setPreferredSize(new Dimension(10, 10));
			progressBar.setBackground(Color.DARK_GRAY);
			progressBar.setForeground(new Color(0, 102, 204));
			lblDescricao.setVerticalAlignment(SwingConstants.CENTER);
			pnlAguarde.add(new MyJLabel("<html><b><font size=\"4\">AGUARDE...</font></b></html>"), BorderLayout.NORTH);
			pnlAguarde.add(lblDescricao, BorderLayout.CENTER);
			pnlAguarde.add(progressBar, BorderLayout.SOUTH);

			PnlComEspaco pnlComEspaco = new PnlComEspaco(pnlAguarde);
			pnlComEspaco.setBorder(new BlackAndWhiteEtchedBorder());

			add(pnlComEspaco);
		}

		private void setText(String text) {
			lblDescricao.setText(text);
		}

		@Override
		public void fechar() {
			setVisible(false);
		}

		private MyJPanel pnlAguarde = new MyJPanel(new BorderLayout());
		private LblNegrito lblDescricao = new LblNegrito();
		private JProgressBar progressBar = new JProgressBar();

	}

	@Override
	public void abrirPopupModelo() {
		pnlLaudo.abrirPopupModelo();
	}

}
