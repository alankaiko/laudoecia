/*
 * PnlCaptura.java
 *
 * Created on 09/05/2012, 16:25:56
 */

package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeAtendimento;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.iview.captura.C_Captura;
import com.ic.projects.laudoecia.iview.captura.exceptions.CapturaException;
import com.ic.projects.laudoecia.iview.captura.exceptions.NoAudioException;
import com.ic.projects.laudoecia.iview.captura.exceptions.SemDispDeCapturaException;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import com.ic.projects.laudoecia.view.audio.AudioResources;
import com.ic.projects.laudoecia.view.audio.AudiosLC;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.build.ViewFactory;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.java.utils.DateUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJToggleButton;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;

import net.java.balloontip.BalloonTip;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlCaptura extends MyJPanel {

	private LaudoeCiaMediator mediador;
	private MyJPanel pnlVideo;
	private Date tempoDeGravacao;
	private Timer timerGravacao;
	private final SimpleDateFormat formatTempoGravacao = new SimpleDateFormat("HH:mm:ss");
	private C_Captura c_Captura = ViewFactory.getInstance().getC_Captura();
	private ConversorByteArrayImage cnv = new ConversorByteArrayImage();

	private FrameFS fr = new FrameFS();

	public PnlCaptura(LaudoeCiaMediator mediador, MyJPanel pnlVideo) {
		this.mediador = mediador;
		this.pnlVideo = pnlVideo;
		new MeuSw().execute();
		initializeComponents();
		c_Captura.setMouseListener(new MeuMouseListener(mediador));
		c_Captura.setKeyListener(new MeuKeyListener());
	}

	private void initializeComponents() {
		setBorder(new CompoundBorder(new BlackAndWhiteEtchedBorder(), new EmptyBorder(2, 2, 2, 2)));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		add(pnlPlayerCaptura);
		add(new PnlComp(false, false, true).setComponent(pnlCapturarEMostrarLaudo));
		add(new PnlComp(false, false, true).setComponent(pnlListaVideos));
		add(new PnlComp(false, false, true).setComponent(pnlOutrasOpcoes));
		add(new PnlComp(false, false, true).setComponent(pnlGravandoCD));

		setGravacaoDiscoVisible(false);
		btnPlayPauseCaptura.setEnabled(false);
	}

	// <editor-fold defaultstate="collapsed" desc="Componentes do Painel">

	// PnlPlayerCaptura
	private MyJPanel pnlPlayerCaptura = new MyJPanel();
	private MyJToggleButton btnGravar = new MyJToggleButton();
	private MyJButton btnPlayPauseCaptura = new MyJButton();
	private MyJToggleButton btnAudio = new MyJToggleButton();
	private MyJButton btnMostrarCaptura = new MyJButton();
	private LblNegrito lblTempoValue = new LblNegrito("00:00:00");
	private MyJButton btnFullScreen = new MyJButton();

	// pnlCapturarEMostrarLaudo
	private MyJPanel pnlCapturarEMostrarLaudo = new MyJPanel(new GridLayout(1, 2));
	private MyJButton btnCapturar = new MyJButton("Capturar imagem");
	private MyJButton btnLaudoVideo = new MyJButton();

	// pnlListaVideos
	private MyJPanel pnlListaVideos = new MyJPanel();
	private MyJButton btnPlayVideo = new MyJButton();
	private MyJButton btnDeleteVideo = new MyJButton();
	private MyJButton btnMoverVideo = new MyJButton();
	private ScrollResultsDaBusca scrpTabelaVideos = new ScrollResultsDaBusca(new TableConfigurator() {

		@Override
		public String[] columnsTitles() {
			return new String[] { "VideoGravado", "Vídeo", "Duração", "Tamanho" };
		}

		@Override
		public Class<?>[] columnsClasses() {
			return new Class<?>[] { Object.class, Object.class, String.class, String.class };
		}

		@Override
		public int[] columnsWidths() {
			return new int[] { 0, 100, 70, 70 };
		}

		@Override
		public boolean[] shouldResizeColumns() {
			return new boolean[] { false, true, false, false };
		}

		@Override
		public int[] sortedColumns() {
			return new int[] { 1 };
		}
	});

	// pnlOutrasOpções
	private MyJPanel pnlOutrasOpcoes = new MyJPanel();
	private MyJButton btnExportar = new MyJButton("Exportar imagens e vídeos");
	private JPopupMenu popupMenuOO = new JPopupMenu();
	private MyJButton btnOpcoes = new MyJButton("Opções");
	private JMenuItem btnEscolherDispDeCaptura = popupMenuOO.add("Detectar dispositivo de captura");
	private JMenuItem btnConfigDispDeCaptura = popupMenuOO.add("Alterar canal/brilho/contraste");
	private JMenuItem btnEscolherFormatoVideo = popupMenuOO.add("Escolher formato do vídeo");
	private JMenuItem btnEscolherRecorte = popupMenuOO.add("Escolher recorte da imagem");

	// pnlGravandoCD
	private MyJPanel pnlGravandoCD = new MyJPanel(new BorderLayout());
	private LblNegrito lblGravandoCD = new LblNegrito("Gravando arquivos em disco. Por favor aguarde...");
	private JProgressBar progressBar = new JProgressBar();

	// <editor-fold defaultstate="collapsed" desc="Icons">

	private final Icon ICON_REC_RED = ImageResources.getIcon(ImagensLC.RECORD_RED);
	private final Icon ICON_REC_GREEN = ImageResources.getIcon(ImagensLC.RECORD_GREEN);
	private final Icon ICON_PLAY = ImageResources.getIcon(ImagensLC.PLAY);
	private final Icon ICON_PAUSE = ImageResources.getIcon(ImagensLC.PAUSE);
	private final Icon ICON_SOUND_ON = ImageResources.getIcon(ImagensLC.SOUND_ON);
	private final Icon ICON_SOUND_OFF = ImageResources.getIcon(ImagensLC.SOUND_OFF);
	private final Icon ICON_LAUDO = ImageResources.getIcon(ImagensLC.LAUDO_ICON);
	private final Icon ICON_CAPTURA = ImageResources.getIcon(ImagensLC.CAPTURA_ICON);

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Tooltip texts">

	private final String TOOLTIP_REC_START = "Iniciar gravação de vídeo";
	private final String TOOLTIP_REC_END = "Finalizar gravação do vídeo";
	private final String TOOLTIP_PLAY = "Continuar gravação do vídeo";
	private final String TOOLTIP_PAUSE = "Pausar gravação do vídeo";
	private final String TOOLTIP_SOUND_ON = "Desativar áudio";
	private final String TOOLTIP_SOUND_OFF = "Ativar áudio";
	private final String TEXTO_MOSTRAR_LAUDO = "Mostrar laudo";
	private final String TEXTO_MOSTRAR_CAPTURA = "Mostrar captura";

	// </editor-fold>

	{

		CompoundBorder borderInfo = new CompoundBorder(new EtchedBorder(), new EmptyBorder(3, 3, 3, 3));

		// <editor-fold defaultstate="collapsed" desc="PnlPlayerCaptura Layout">

		MyJPanel pnlBtns1 = new MyJPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		pnlBtns1.setBorder(borderInfo);
		pnlBtns1.add(btnGravar);
		pnlBtns1.add(btnPlayPauseCaptura);
		pnlBtns1.add(btnAudio);
		pnlBtns1.add(btnMostrarCaptura);

		lblTempoValue.setFont(new Font("Arial", 1, 16));
		lblTempoValue.setHorizontalAlignment(SwingConstants.CENTER);
		PnlComp pnlTempoVal = new PnlComp(false, false, true).setComponent(lblTempoValue);
		pnlTempoVal.setBorder(borderInfo);

		MyJPanel pnlBtns2 = new MyJPanel(new FlowLayout(FlowLayout.CENTER, 0, 4));
		pnlBtns2.setBorder(borderInfo);
		pnlBtns2.add(btnFullScreen);

		pnlPlayerCaptura.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		pnlPlayerCaptura.add(pnlBtns1, c);
		c.gridx = 1;
		c.weightx = 1;
		pnlPlayerCaptura.add(pnlTempoVal, c);
		c.gridx = 2;
		c.weightx = 0;
		pnlPlayerCaptura.add(pnlBtns2, c);

		// </editor-fold>

		// <editor-fold defaultstate="collapsed" desc="pnlCaturarEMostrarLaudo Layout">

		pnlCapturarEMostrarLaudo.setBorder(borderInfo);
		pnlCapturarEMostrarLaudo.add(btnCapturar);
		pnlCapturarEMostrarLaudo.add(btnLaudoVideo);

		// </editor-fold>

		// <editor-fold defaultstate="collapsed" desc="pnlListaVideos Layout">

		pnlListaVideos.setLayout(new GridBagLayout());
		pnlListaVideos.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(3, 3, 3, 3)));
		scrpTabelaVideos.removeColumn(0);
		scrpTabelaVideos.getTabela().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					btnPlayVideoAction();
				}
			}

		});
		EmptyBorder btnsBorder = new EmptyBorder(6, 8, 6, 8);
		btnPlayVideo.setIcon(ImageResources.getIcon(ImagensLC.PLAY));
		btnPlayVideo.setToolTipText("Reproduzir vídeo selecionado");
		btnPlayVideo.setBorder(btnsBorder);
		btnPlayVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnPlayVideoAction();
			}
		});
		btnDeleteVideo.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
		btnDeleteVideo.setToolTipText("Apagar vídeo selecionado");
		btnDeleteVideo.setBorder(btnsBorder);
		btnDeleteVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeleteVideoAction();
			}
		});
		btnMoverVideo.setText("<html><font color=\"0000ff\"><u>M</u></font></html>");
		btnMoverVideo.setToolTipText("Mover o vídeo selecionado");
		btnMoverVideo.setBorder(btnsBorder);
		btnMoverVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMoverVideoAction();
			}
		});

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 4;
		pnlListaVideos.add(scrpTabelaVideos, c);
		c.gridx = 1;
		c.weightx = 0;
		pnlListaVideos.add(Box.createHorizontalStrut(3), c);
		c.gridheight = 1;
		c.gridx = 2;
		pnlListaVideos.add(btnPlayVideo, c);
		c.gridy = 1;
		pnlListaVideos.add(btnDeleteVideo, c);
		c.gridy = 2;
		pnlListaVideos.add(btnMoverVideo, c);
		c.gridy = 3;
		c.weighty = 1d;
		pnlListaVideos.add(Box.createVerticalStrut(0), c);

		// </editor-fold>

		// <editor-fold defaultstate="collapsed" desc="pnlOutrasOpções Layout">

		pnlOutrasOpcoes.setBorder(borderInfo);
		pnlOutrasOpcoes.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		pnlOutrasOpcoes.add(btnExportar, c);
		c.gridx = 1;
		pnlOutrasOpcoes.add(btnOpcoes, c);

		// </editor-fold>

		// <editor-fold defaultstate="collapsed" desc="pnlGravandoCD Layout">

		progressBar.setIndeterminate(true);
		progressBar.setPreferredSize(new Dimension(10, 10));
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setForeground(new Color(0, 102, 204));
		pnlGravandoCD.setBorder(borderInfo);
		pnlGravandoCD.add(lblGravandoCD, BorderLayout.NORTH);
		pnlGravandoCD.add(Box.createVerticalStrut(10), BorderLayout.CENTER);
		pnlGravandoCD.add(progressBar, BorderLayout.SOUTH);

		// </editor-fold>

		btnCapturar.setIcon(ImageResources.getIcon(ImagensLC.CAMERA_FOTO));
		btnCapturar.setToolTipText("Capturar nova imagem");
		btnCapturar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCapturarAction();
			}

		});
		btnCapturar.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnLaudoVideo.setIcon(ICON_LAUDO);
		btnLaudoVideo.setText(TEXTO_MOSTRAR_LAUDO);
		btnLaudoVideo.setFocusable(false);
		btnLaudoVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLaudoVideoAction();
			}
		});
		btnLaudoVideo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLaudoVideo.setBackground(Color.yellow);

		btnExportar.setIcon(SwingLibResources.getIcon(Imagens.DOWNLOAD));
		btnExportar.setToolTipText("Exportar imagens e vídeos deste procedimento");
		btnExportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnExportarAction();
			}

		});

		btnFullScreen.setIcon(SwingLibResources.getIcon(Imagens.FULLSCREEN));
		btnFullScreen.setToolTipText("Ver vídeo em tela cheia");
		btnFullScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnFullScreenAction();
			}
		});

		btnGravar.setIcon(ICON_REC_RED);
		btnGravar.setToolTipText(TOOLTIP_REC_START);
		btnGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// SwingUtils.mostrarMsgDeInformacao(null, "Recurso desabilitado entre em
				// contato com o suporte.");
				btnIniciarOuPararGravacaoDeVideoAction();
			}

		});
		btnGravar.setRolloverIcon(ICON_REC_RED);
		// btnGravar.setSelectedIcon(ICON_REC_GREEN);

		btnMostrarCaptura.setToolTipText("Voltar para captura do dispositivo");
		btnMostrarCaptura.setIcon(ImageResources.getIcon(ImagensLC.TV_CAPTURA));
		btnMostrarCaptura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMostrarCapturaAction();
			}
		});

		btnPlayPauseCaptura.setToolTipText(TOOLTIP_PAUSE);
		btnPlayPauseCaptura.setIcon(ICON_PAUSE);
		btnPlayPauseCaptura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnPlayPauseCapturaAction();
			}
		});

		btnAudio.setIcon(ICON_SOUND_ON);
		btnAudio.setRolloverIcon(ICON_SOUND_ON);
		btnAudio.setSelectedIcon(ICON_SOUND_OFF);
		btnAudio.setToolTipText(TOOLTIP_SOUND_ON);
		btnAudio.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				btnAudioAction();
			}
		});
		btnAudio.setRolloverEnabled(false);
		btnAudio.doClick(); // para começar desabilitado

		btnEscolherDispDeCaptura.setIcon(ImageResources.getIcon(ImagensLC.CAPTURA_SMALL));
		btnEscolherDispDeCaptura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEscolherDispDeCapturaAction();
			}

		});

		btnConfigDispDeCaptura.setIcon(ImageResources.getIcon(ImagensLC.SLIDER));
		btnConfigDispDeCaptura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnConfDispDeCapturaAction();
			}
		});

		btnEscolherFormatoVideo.setIcon(ImageResources.getIcon(ImagensLC.OPTIONS));
		btnEscolherFormatoVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEscolherFormatoVideoAction();
			}
		});

		btnEscolherRecorte.setIcon(ImageResources.getIcon(ImagensLC.OPTIONS));
		btnEscolherRecorte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEscolherRecorteAction();
			}
		});

		btnOpcoes.setIcon(ImageResources.getIcon(ImagensLC.CAPTURA_CONFIG));
		// btnOpcoes.setToolTipText("Abrir opções de configuração da captura");
		btnOpcoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnOpcoesBalloon != null && btnOpcoesBalloon.isVisible()) {
					btnOpcoesBalloon.setVisible(false);
					btnOpcoesBalloon = null;
					try {
						StaticInfo.salvarPropriedadeDaCaptura(C_Captura.PRIMEIRA_EXECUCAO_DA_CAPTURA, "false");
					} catch (Exception ex) {
					}
				}
				Dimension d = popupMenuOO.getPreferredSize();
				int x = btnOpcoes.getX() + btnOpcoes.getSize().width - d.width;
				int y = btnOpcoes.getY() - d.height;
				popupMenuOO.show(pnlOutrasOpcoes, x, y);
			}
		});

	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Ações dos botões">

	private void btnIniciarOuPararGravacaoDeVideoAction() {
		if (c_Captura.estadoAtual() == C_Captura.NENHUM_DISPOSITIVO) {
			PnlLaudoeCia.getInstance().mostrarMsgErro("Nenhum dispositivo " + "de captura encontrado.\n Acione o botão "
					+ "Opções e escolha Detectar dispositivo de captura.");
			return;
		}
		if (btnGravar.isSelected()) {
			if (mediador.iniciarGravacaoDeVideo()) {
				btnPlayPauseCaptura.setEnabled(true);
				AudioResources.executaArquivoDeAudio(AudiosLC.INICIAGRAVACAO);
			} else {
				btnPlayPauseCaptura.setEnabled(false);
				btnGravar.setSelected(false);
			}
		} else {
			AudioResources.executaArquivoDeAudio(AudiosLC.TERMINAGRAVACAO);
			c_Captura.terminarGravacaoDeVideo();

			btnPlayPauseCaptura.setEnabled(false);
			btnGravar.setToolTipText(TOOLTIP_REC_START);

			mediador.videoFoiGravado(formatTempoGravacao.format(tempoDeGravacao));

			resetaCronometro();

		}
	}

	private void btnCapturarAction() {
		mediador.capturarImagem();
	}

	private void btnLaudoVideoAction() {
		if (btnLaudoVideo.getText().equals(TEXTO_MOSTRAR_LAUDO)) {
			mediador.mostrarLaudo();
		} else {
			mediador.mostrarCaptura();
		}
	}

	private void btnExportarAction() {
		mediador.iniciarExportacaoDeArquivos();
	}

	private void btnFullScreenAction() {
		if (c_Captura.estadoAtual() == C_Captura.NENHUM_DISPOSITIVO) {
			PnlLaudoeCia.getInstance().mostrarMsgErro("Nenhum dispositivo " + "de captura encontrado.\n Acione o botão "
					+ "Opções e escolha Detectar dispositivo de captura.");
			return;
		}
		if (!fr.isVisible()) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					final MyJPanel pnl = new MyJPanel(new GridBagLayout());
					pnl.setBackground(Color.black);
					GridBagConstraints c = new GridBagConstraints();
					c.fill = GridBagConstraints.BOTH;
					c.weightx = 1;
					c.weighty = 1;
					pnl.add(c_Captura.getPnlCaptura(), c);
					fr.setContentPane(pnl);
					fr.revalidate();
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							pnl.revalidate();
							pnl.repaint();
							pnlVideo.repaint();
							c_Captura.getPnlCaptura().requestFocusInWindow();
						}

					});
				}

			});
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				c_Captura.foiParaFullScreen();
			}

		});
		fr.setBounds(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		fr.setVisible(true);
	}

	private void btnPlayPauseCapturaAction() {
		int estado = c_Captura.alternarEstado();
		switch (estado) {
		case C_Captura.GRAVACAO_PAUSADA:
			btnPlayPauseCaptura.setToolTipText(TOOLTIP_PLAY);
			btnPlayPauseCaptura.setIcon(ICON_PLAY);
			new SwingWorker<Void, Void>() {
				@Override
				@SuppressWarnings("SleepWhileInLoop")
				protected Void doInBackground() throws Exception {
					String timer = lblTempoValue.getText();
					int alternateColor = 1;
					lblTempoValue.setForeground(Color.BLUE);
					while (c_Captura.estadoAtual() == C_Captura.GRAVACAO_PAUSADA) {
						Thread.sleep(500);
						if (alternateColor > 0) {
							lblTempoValue.setText(" ");
						} else {
							lblTempoValue.setText(timer);
						}
						alternateColor *= -1;
					}
					lblTempoValue.setForeground(Color.black);
					lblTempoValue.setText(timer);
					return null;
				}

			}.execute();
			break;
		case C_Captura.GRAVANDO_VIDEO:
			btnPlayPauseCaptura.setToolTipText(TOOLTIP_PAUSE);
			btnPlayPauseCaptura.setIcon(ICON_PAUSE);
			break;
		default:
		}
	}

	private void btnMostrarCapturaAction() {
		if (fr.isVisible()) {
			fr.fechar();
		}
		mediador.mostrarCaptura();
		if (!btnPlayPauseCaptura.isEnabled()) {
			c_Captura.alternarEstado();
			lblTempoValue.setText("00:00:00");
		}
	}

	private void btnAudioAction() {
		if (btnAudio.isSelected()) {
			btnAudio.setToolTipText(TOOLTIP_SOUND_OFF);
		} else if (c_Captura.audioEstaDisponivel()) {
			btnAudio.setToolTipText(TOOLTIP_SOUND_ON);
		} else {
			PnlLaudoeCia.getInstance().mostrarAviso("Nenhum dispositivo de áudio!");
			btnAudio.setSelected(false);
		}
		switch (c_Captura.estadoAtual()) {
		case C_Captura.GRAVACAO_PAUSADA:
		case C_Captura.GRAVANDO_VIDEO:
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					PnlLaudoeCia.getInstance().mostrarAviso("" + "A configuração será aplicada no próximo vídeo!");
				}

			});
			break;
		default:
		}
	}

	private void btnEscolherDispDeCapturaAction() {
		try {
			if (PnlLaudoeCia.getInstance()
					.obterConfirmacaoDoUsuario("Deseja" + " detectar os dispositivos de captura?")) {
				c_Captura.escolherDispsDeCaptura();
			}
		} catch (Exception ex) {
			PnlLaudoeCia.getInstance().mostrarAviso("Houve um erro na" + " detecção do dispositivo.\n"
					+ " Reinicie o sistema e teste novamente.\n" + ex.getMessage());
		}
	}

	private void btnConfDispDeCapturaAction() {
		try {
			FormPrincipal.getInstance().setCursorToWaitCursor();
			mediador.mostrarCaptura();
			c_Captura.configDispsDeCaptura();
		} catch (SemDispDeCapturaException ex) {
			PnlLaudoeCia.getInstance().mostrarMsgErro("Nenhum dispositivo " + "de captura encontrado.\n"
					+ "Clique na opção detectar dispositivo de captura!");
		} catch (CapturaException ex) {
			PnlLaudoeCia.getInstance().mostrarMsgErro(ex.getMessage());
		} finally {
			FormPrincipal.getInstance().setCursorToDefaultCursor();
		}
	}

	private void btnEscolherFormatoVideoAction() {
		try {
			c_Captura.escolherFormato();
		} catch (SemDispDeCapturaException ex) {
			PnlLaudoeCia.getInstance().mostrarMsgErro("Nenhum dispositivo "
					+ "de captura encontrado.\n Clique na opção detectar " + "dispositivo de captura!");
		} catch (CapturaException ex) {
			PnlLaudoeCia.getInstance().mostrarMsgErro(ex.getMessage());
		}
	}

	private void btnEscolherRecorteAction() {
		byte[] img = null;
		try {
			img = mediador.getImagemAtual();
		} catch (Exception e) {
		}
		if (img == null || img.length == 0) {
			PnlLaudoeCia.getInstance()
					.mostrarAviso("Escolha um exame " + "e capture uma foto para configurar os recortes de imagem!");
		} else {
			c_Captura.escolherRecorte(img);
		}
	}

	private void btnPlayVideoAction() {
		int estadoAtual = c_Captura.estadoAtual();
		if (estadoAtual == C_Captura.GRAVACAO_PAUSADA || estadoAtual == C_Captura.GRAVANDO_VIDEO) {
			PnlLaudoeCia.getInstance().mostrarAviso("Termine a gravação do vídeo" + " em andamento!");
			return;
		}

		// selectedResult é composto de {VideoGravado, File, Tempo, Tamanho}
		Object[] selectedResult = scrpTabelaVideos.getSelectedResult();
		if (selectedResult == null) {
			PnlLaudoeCia.getInstance().mostrarAviso("Selecione um vídeo!");
			return;
		}

		VideoGravado video = (VideoGravado) selectedResult[0];
		File arquivo = (File) selectedResult[1];
		if (mediador.reproduzirArquivoDeVideo(video, arquivo)) {
			mediador.mostrarCaptura();
			try {
				c_Captura.reproduzirArquivoDeVideo(arquivo);
				lblTempoValue.setText((String) selectedResult[2]);
			} catch (CapturaException ex) {
				PnlLaudoeCia.getInstance().mostrarMsgErro(ex.getMessage());
			}
		}
	}

	private void btnDeleteVideoAction() {
		Object[] selectedResult = scrpTabelaVideos.getSelectedResult();
		if (selectedResult == null) {
			PnlLaudoeCia.getInstance().mostrarAviso("Selecione um vídeo!");
		} else if (mediador.deletarVideoGravado((VideoGravado) selectedResult[0])) {
			scrpTabelaVideos.removerResultadoSelecionado();
		} else {
		}
	}

	private void btnMoverVideoAction() {
		if (mediador.validarMoverVideo()) {
			Object[] selectedResult = scrpTabelaVideos.getSelectedResult();
			VideoGravado v = selectedResult == null ? null : (VideoGravado) selectedResult[0];
			if (v == null) {
				PnlLaudoeCia.getInstance().mostrarMsgErro("Escolha um vídeo na lista.");
			} else {
				DlgEscolherProcDoAtd d = new DlgEscolherProcDoAtd();
				d.setVisible(true);
				ProcDoAtd p = d.getProcEscolhido();
				if (mediador.moverVideoGravado(v, p)) {
					scrpTabelaVideos.removerResultadoSelecionado();
				}
			}
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Package private">

	private BalloonTip btnOpcoesBalloon;

	void chamarAtencaoParaBtnOpcoesDaCaptura() {
		if (btnOpcoesBalloon == null && !c_Captura.necessitaReiniciar()) {
			btnOpcoesBalloon = new BalloonTip(btnOpcoes, "");
			MyJPanel pnl = new MyJPanel();
			pnl.setLayout(new BoxLayout(pnl, BoxLayout.PAGE_AXIS));
			pnl.setBackground(new Color(255, 253, 245));
			pnl.add(new JLabel("<html>Este é o botão de opções da captura.<br>"
					+ "Utilize-o para alterar o canal, brilho e " + "contraste, ou o formato do vídeo.</html>"));
			MyJCheckBox chk = new MyJCheckBox("Fechar e não mostrar novamente.");
			pnl.add(chk);
			chk.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						try {
							StaticInfo.salvarPropriedadeDaCaptura(C_Captura.PRIMEIRA_EXECUCAO_DA_CAPTURA, "false");
						} catch (Exception ex) {
						}
					}
					btnOpcoesBalloon.setVisible(false);
				}

			});
			btnOpcoesBalloon.setContents(pnl);
		}
	}

	void desconectar() {
		c_Captura.desconectar();
		if (fr == null) {
		} else {
			fr.dispose();
		}
	}

	void pararAtividades() {
		c_Captura.pausarAtividades();
	}

	void continuarAtividades() {
		c_Captura.continuarAtividades();
	}

	void setListaVideos(final List<VideoGravado> listaVideos) {
		scrpTabelaVideos.updateResultList(new ResultsGenerator() {

			@Override
			public List<Object[]> generateResults() {
				List<Object[]> results = new ArrayList<>();
				for (int i = 0; i < listaVideos.size(); i++) {
					VideoGravado video = listaVideos.get(i);
					File arquivo = new File(video.getCaminho()) {
						@Override
						public String toString() {
							return getName();
						}
					};
					String time = video.getDuracao();
					String size = calcularTamanho(arquivo);
					results.add(new Object[] { video, arquivo, time, size });
				}
				return results;
			}

			private String calcularTamanho(File arquivo) {
				if (arquivo.exists() && !mediador.videoEstaSendoCompactado(arquivo.getAbsolutePath())) {
					return (arquivo.length() / 1048576) + " Mb";
				} else {
					return "...";
				}
			}

		});
		if (c_Captura.estadoAtual() == C_Captura.REPRODUZINDO_VIDEO) {
			c_Captura.alternarEstado();
			lblTempoValue.setText("00:00:00");
		}
	}

	void capturarImg() {
		try {
			Image snapshot = c_Captura.capturarImagem();
			if (snapshot == null) {
			} else {
				mediador.imagemFoiCriada(cnv.convertReverse(snapshot), true);
				mediador.AtualizarLista();
			}
			mediador.salvar();
		} catch (CapturaException ex) {
			// como nao foi executado o som garantindo que a imagem foi
			// capturada, o usuario deve tirar outra foto
			// jah aconteceu de a imagem capturada vir null, esse catch
			// protege desse caso
		} catch (SemDispDeCapturaException ex) {
			SwingUtils.mostrarMensagemDeErroConhecido(FormPrincipal.getInstance(), "Nenhum dispositivo de captura!");
		}
	
	
	}

	void btnGravarVideoDoClick(boolean tratarSelected) {
		if (!tratarSelected || !btnGravar.isSelected()) {
			btnGravar.doClick();
		}
	}

	void iniciaCronometro() {
		Calendar cal = Calendar.getInstance();
		cal.set(0, 0, 0, 0, 0, 0);
		tempoDeGravacao = cal.getTime();
		timerGravacao = new Timer();
		TimerTask tarefa = new TimerTask() {
			@Override
			public void run() {
				if (c_Captura.estadoAtual() == C_Captura.GRAVANDO_VIDEO) {
					tempoDeGravacao = DateUtils.adicionarSegundosNaData(tempoDeGravacao, 1);
					lblTempoValue.setText(formatTempoGravacao.format(tempoDeGravacao));
				}
			}
		};
		timerGravacao.scheduleAtFixedRate(tarefa, 0, 1000);
	}

	private void resetaCronometro() {
		timerGravacao.cancel();
		timerGravacao.purge();
		tempoDeGravacao = null;
		lblTempoValue.setText("00:00:00");
	}

	boolean iniciarGravacaoDeVideo(final File arquivoDeVideo) {
		try {
			c_Captura.iniciarGravacaoDeVideo(arquivoDeVideo, !btnAudio.isSelected());
			btnGravar.setToolTipText(TOOLTIP_REC_END);
			btnPlayPauseCaptura.setIcon(ICON_PAUSE);
			btnPlayPauseCaptura.setToolTipText(TOOLTIP_PAUSE);
			new SwingWorker<Void, Void>() {

				private boolean up = false;

				@Override
				@SuppressWarnings("SleepWhileInLoop")
				protected Void doInBackground() throws Exception {
					while (btnGravar.isSelected()) {
						Thread.sleep(500);
						if (up) {
							btnGravar.setSelectedIcon(ICON_REC_GREEN);
							up = false;
						} else {
							btnGravar.setSelectedIcon(ICON_REC_RED);
							up = true;
						}
					}
					return null;
				}

			}.execute();
			iniciaCronometro();
			return true;
		} catch (NoAudioException nae) {
			PnlLaudoeCia.getInstance()
					.mostrarAviso("Não foi possível " + "gravar com áudio. Tentando gravar sem áudio!");
			btnAudio.setSelected(true);
			return iniciarGravacaoDeVideo(arquivoDeVideo);
		} catch (Exception e) {
			PnlLaudoeCia.getInstance().mostrarAviso(
					"Não foi possível iniciar a gravação!\n" + "Verifique se há espaço suficiente em disco,\n"
							+ "ou se seu dispositivo de captura está funcionando " + "corretamente.");
			btnGravar.setSelected(false);
			return false;
		}
	}

	/**
	 * Mostra ou esconde visão da thread de gravação de CD/DVD.
	 *
	 * @param visible
	 *            boolean
	 */
	void setGravacaoDiscoVisible(boolean visible) {
		pnlGravandoCD.setVisible(visible);
	}

	void configurarBtnLaudoCapt(boolean irParaLaudo) {
		if (irParaLaudo) {
			btnLaudoVideo.setIcon(ICON_LAUDO);
			btnLaudoVideo.setText(TEXTO_MOSTRAR_LAUDO);
		} else {
			btnLaudoVideo.setIcon(ICON_CAPTURA);
			btnLaudoVideo.setText(TEXTO_MOSTRAR_CAPTURA);
		}
	}

	void alternarGravacaoNoDisco() {
		btnGravar.doClick();
	}

	// </editor-fold>

	private class MeuSw extends SwingWorker<Void, Component> {

		@Override
		protected void process(List<Component> chunks) {
			final Component pnl = chunks.get(0);
			if (pnl == null) {
			} else {
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						pnl.setPreferredSize(new Dimension(10, 10));
						pnlVideo.add(pnl, BorderLayout.CENTER);
						pnlVideo.revalidate();
					}

				});
			}
		}

		@Override
		protected Void doInBackground() throws Exception {
			if (c_Captura == null) {
			} else {
				publish(c_Captura.getPnlCaptura());
			}
			return null;
		}

	}

	private class DlgEscolherProcDoAtd extends MyJDialog {

		private MyJComboBox<ProcDoAtd> cmbProcs = new CmbProcDoAtd();

		private DlgEscolherProcDoAtd() {
			super(PnlLaudoeCia.getInstance(), true, 550, 200);
			setTitle("Mover vídeos");
			initComponents();
		}

		@Override
		public void fechar() {
			dispose();
		}

		private ProcDoAtd getProcEscolhido() {
			return cmbProcs.getSelectedItem();
		}

		private void initComponents() {
			final BuscadorDeAtendimento buscAtd = new BuscadorDeAtendimento();
			TxtComAutoCompletar txtAtd = new TxtComAutoCompletar(buscAtd);
			txtAtd.setLargura(1.5);
			txtAtd.addAutoCompletarListener(new AutoCompletarListener() {

				@Override
				public void linhaSelecionadaMudou(Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada) {
					if (newLinhaSelecionada == null) {
						cmbProcs.setModel(new ArrayList<ProcDoAtd>());
					} else {
						List<ProcDoAtd> procs = new ArrayList<>(buscAtd.getSelectedModel().getProcedimentos());
						procs.remove(mediador.getProcSelecionado());
						cmbProcs.setModel(procs);
						if (!procs.isEmpty()) {
							cmbProcs.setSelectedIndex(0);
						}
					}
				}
			});
			buscAtd.setSelectedModel(mediador.getAtdSelecionado());

			MyJButton btnOk = new MyJButton("Confirmar");
			btnOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (cmbProcs.getSelectedItem() == null) {
						SwingUtils.mostrarAviso(DlgEscolherProcDoAtd.this, "" + "Escolha um procedimento na lista!");
					} else {
						fechar();
					}
				}
			});

			MyJButton btnCancelar = new MyJButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cmbProcs.setSelectedItem(null);
					fechar();
				}
			});

			MyJPanel pnl = new MyJPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;

			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 4;
			pnl.add(new PnlComp("Atendimento", false, false).setComponent(txtAtd), c);

			c.gridy = 1;
			pnl.add(new PnlComp("Procedimento", false, true).setComponent(cmbProcs), c);

			c.gridy = 2;
			c.weighty = 0.5;
			pnl.add(Box.createVerticalStrut(0), c);

			c.gridy = 3;
			c.gridwidth = 1;
			c.weightx = 0.35;
			c.weighty = 0;
			pnl.add(Box.createHorizontalStrut(0), c);
			c.gridx = 1;
			c.weightx = 0.15;
			c.insets.right = 3;
			pnl.add(btnOk, c);
			c.insets.left = 3;
			c.insets.right = 0;
			c.gridx = 2;
			pnl.add(btnCancelar, c);
			c.gridx = 3;
			c.weightx = 0.35;
			c.insets.left = 0;
			pnl.add(Box.createHorizontalStrut(0), c);

			c.gridy = 4;
			c.weightx = 0;
			c.gridwidth = 4;
			c.weighty = 0.5;
			pnl.add(Box.createVerticalStrut(0), c);

			setContentPane(new PnlComEspaco(pnl));
		}

		private class CmbProcDoAtd extends MyJComboBox<ProcDoAtd> {
			private boolean layingOut = false;

			@Override
			public void doLayout() {
				try {
					layingOut = true;
					super.doLayout();
				} finally {
					layingOut = false;
				}
			}

			@Override
			public Dimension getSize() {
				Dimension dim = super.getSize();
				if (!layingOut) {
					dim.width += dim.width * 0.5;
				}
				return dim;
			}

		}

	}

	private class FrameFS extends MyJDialog {

		private FrameFS() {
			super(null, false, new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			// comentado porque undecorated teve que ser true para
			// receber eventos do mouse quando o ponteiro esta sobre a barra de titulo
			// setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			// setIconImage(ImageResources.getImage(ImagensLC.ICONE_LC));
			// setResizable(true);
			setUndecorated(true);
			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					fechar();
				}
			});
		}

		@Override
		public void fechar() {
			final Component pnlCaptura = c_Captura.getPnlCaptura();
			setVisible(false);
			pnlVideo.add(pnlCaptura, BorderLayout.CENTER);
			pnlVideo.revalidate();
			pnlVideo.repaint();
			java.awt.EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					c_Captura.voltouDoFullScreen();
				}

			});
			dispose();
		}

	}

	private class MeuMouseListener implements MouseListener {

		private MouseListDaCaptura ml;

		private MeuMouseListener(LaudoeCiaMediator mediador) {
			ml = new MouseListDaCaptura(mediador);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				if (fr.isVisible()
						&& fr.getBounds().equals(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()))) {
					// some widescreen size ( nao usado pois nao foi possivel
					// tornar o dialog undecorated false )
					// fr.setSize(16 * 30, 9 * 30);
					// fr.setLocationRelativeTo(null);
					fr.fechar();
				} else {
					btnFullScreenAction();
				}
				e.consume();
			}
			ml.mouseClicked(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			ml.mouseReleased(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			ml.mousePressed(e);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			ml.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			ml.mouseExited(e);
		}

	}

	private class MeuKeyListener extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				if (fr == null) {
				} else if (fr.isVisible()) {
					fr.fechar();
				} else {
				}
				break;
			default:
			}
		}

	}

}
