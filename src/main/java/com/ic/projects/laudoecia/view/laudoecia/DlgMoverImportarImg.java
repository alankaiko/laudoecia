package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;

import com.ic.projects.laudoecia.view.utils.DecriptarArquivo;
import org.apache.commons.io.FileUtils;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeAtendimento;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.ImagemJPEG;
import com.ic.projects.laudoecia.view.utils.DiretorioDoSistemaUtil;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.java.utils.ImageUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJRadioButton;
import com.lib.swing.plus.cps.MyJScrollPane;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.utils.SwingUtils;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class DlgMoverImportarImg extends MyJDialog {
	private Map<ChkImagem, MinhaImagem> mapaDeImg = new HashMap<>();
	private MyJComboBox<ProcDoAtd> cmbProc = new CmbProcDoAtd();
	private MyJLabel lblImagemPreview = new MyJLabel();
	private MyJLabel lblTotal = new MyJLabel();
	private ConversorByteArrayImage conversor = new ConversorByteArrayImage();

	private BuscadorDeAtendimento buscAtd = new BuscadorDeAtendimento();
	private MyJScrollPane scrollPane = new MyJScrollPane();
	private MyJTextField txtDirImagens = new MyJTextField();

	private MyJRadioButton rb1 = new MyJRadioButton("Mover imagens do arquivo para este procedimento");
	private MyJRadioButton rb2 = new MyJRadioButton("Mover imagens deste para outro procedimento");

	private LaudoeCiaMediator mediador;
	private ServiceJPEG captur;
	private List<ImagemJPEG> listaimagemjpeg;

	private final String CARD_IMPORTAR = "xxx";
	private final String CARD_MOVER = "yyy";

	DlgMoverImportarImg(LaudoeCiaMediator mediador) {
		super(PnlLaudoeCia.getInstance(), true, new Rectangle(new Point(),
				Toolkit.getDefaultToolkit().getScreenSize()));
		setTitle("Importar / mover imagens");
		this.mediador = mediador;
		initComponents();
	}

	private void initComponents() {
		MyJPanel pnl = new MyJPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.gridy = 0;
		c.gridx = 0;
		pnl.add(rb1, c);

		c.gridy = 1;
		pnl.add(new PnlComp("", false, true).setComponent(rb2), c);

		final PnlCartao pnlCartao = getPnl();
		rb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnlCartao.setSelectedCard(CARD_IMPORTAR);
					carregarImagens();
				}
			}
		});
		rb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pnlCartao.setSelectedCard(CARD_MOVER);
					carregarImagens();
				}
			}
		});
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rb1);
		buttonGroup.add(rb2);

		c.gridy = 2;
		pnl.add(pnlCartao, c);

		c.gridy = 3;
		c.weighty = 1;
		scrollPane
				.setVerticalScrollBarPolicy(MyJScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnl.add(new PnlComp(
				"Escolha as imagens que serão importadas / movidas", false,
				true).setComponent(scrollPane), c);

		MyJButton btnMarcarTodas = new MyJButton("Marcar todas");
		btnMarcarTodas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (MyJCheckBox myJCheckBox : mapaDeImg.keySet()) {
					myJCheckBox.setSelected(true);
				}
			}
		});
		MyJButton btnDesmarcarTodas = new MyJButton("Desmarcar todas");
		btnDesmarcarTodas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (MyJCheckBox myJCheckBox : mapaDeImg.keySet()) {
					myJCheckBox.setSelected(false);
				}
			}
		});
		MyJButton btnConfirmar = new MyJButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//List<Imagem> imagens = obterImagensSelecionadas();
				List<ImagemJPEG> imagens = obterImagensSelecionadass();
				
				if (rb1.isSelected()) {
					if (mediador.importarImagens(imagens)) {
						StaticInfo.setDirImportacaoImagens(txtDirImagens.getText());
						deletarImagensSelecionadas();
						fechar();
					}
				} else {
					if (buscAtd.getLinhaSelecionada() == null) {
						SwingUtils.mostrarMensagemDeErroConhecido(DlgMoverImportarImg.this,"Escolha um atendimento!");
					} else if (mediador.moverImagens(imagens, getProc())) {
						fechar();
					} else {
					}
				}
			}
			
		});
		
		
		MyJButton btnEncaminhar = new MyJButton("Encaminhar");
		btnEncaminhar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//List<Imagem> imagens = obterImagensSelecionadas();
				List<ImagemJPEG> imagens = obterImagensSelecionadass();
				
				if(rb2.isSelected())
					ExportarImagensParaDiretorio(imagens);				
			}
			
		});
		
		MyJButton btnCancelar = new MyJButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fechar();
			}
		});
		MyJPanel pnlBotoes = new MyJPanel(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH;
		c1.gridx = 0;
		c1.gridy = 0;
		pnlBotoes.add(btnMarcarTodas, c1);
		c1.gridx = 1;
		c1.insets.left = 3;
		pnlBotoes.add(btnDesmarcarTodas, c1);
		c1.gridx = 2;
		c1.weightx = 1;
		lblTotal.setForeground(Color.blue);
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		atualizarLblTotal();
		pnlBotoes.add(lblTotal, c1);
		c1.weightx = 0;
		c1.gridx = 3;
		pnlBotoes.add(btnEncaminhar, c1);
		c1.weightx = 0;
		c1.gridx = 4;
		pnlBotoes.add(btnConfirmar, c1);
		c1.gridx = 5;
		pnlBotoes.add(btnCancelar, c1);
		

		c.gridy = 4;
		c.weighty = 0;
		c.insets.top = 5;
		c.insets.bottom = 5;
		pnl.add(pnlBotoes, c);
		c.gridy = 5;
		c.insets.top = 0;
		c.insets.bottom = 0;
		pnl.add(Box.createHorizontalStrut(600), c);

		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 5;
		c.insets.left = 5;
		MyJPanel pnlPreview = new MyJPanel(new BorderLayout());
		pnlPreview.add(lblImagemPreview, BorderLayout.CENTER);
		pnlPreview.setBackground(Color.black);
		pnl.add(pnlPreview, c);

		setContentPane(new PnlComEspaco(pnl));

		rb1.setSelected(true);
	}
	

	private PnlCartao getPnl() {
		MyJPanel pnlImportar = new MyJPanel(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH;
		c1.gridx = 0;
		c1.gridy = 0;
		c1.weightx = 1;
		pnlImportar.add(new PnlComp("Pasta de imagens", false, false)
				.setComponent(txtDirImagens), c1);
		c1.weightx = 0;
		c1.gridx = 1;
		MyBtnFileChooser comp = new MyBtnFileChooser();
		pnlImportar.add(comp, c1);

		txtDirImagens.setText(StaticInfo.getDirImportacaoImagens());
		txtDirImagens.getDocument().addDocumentListener(
				new TxtChangedListener() {
					@Override
					public void textChanged(DocumentEvent de) {
						carregarImagens();
					}
				});

		MyJPanel pnlMover = new MyJPanel(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;
		c2.gridy = 0;
		c2.gridx = 0;
		c2.weightx = 1;
		final TxtComAutoCompletar txtAtd = new TxtComAutoCompletar(buscAtd);
		txtAtd.addAutoCompletarListener(new AutoCompletarListener() {

			@Override
			public void linhaSelecionadaMudou(Object[] oldLinhaSelecionada,
					Object[] newLinhaSelecionada) {
				if (newLinhaSelecionada == null) {
					cmbProc.setModel(new ArrayList<ProcDoAtd>());
				} else {
					List<ProcDoAtd> procs = new ArrayList<>(buscAtd
							.getSelectedModel().getProcedimentos());
					procs.remove(mediador.getProcSelecionado());
					cmbProc.setModel(procs);
					if (!procs.isEmpty()) {
						cmbProc.setSelectedIndex(0);
					}
				}
			}
		});
		txtAtd.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				txtAtd.selectAll();
			}
		});
		buscAtd.setSelectedModel(mediador.getAtdSelecionado());
		pnlMover.add(new PnlComp("Atendimento de destino", false, true)
				.setComponent(txtAtd), c2);

		c2.gridy = 1;
		pnlMover.add(new PnlComp("Procedimento de destino", false, true)
				.setComponent(cmbProc), c2);

		PnlCartao resposta = new PnlCartao();
		resposta.addCard(pnlImportar, CARD_IMPORTAR);
		resposta.addCard(pnlMover, CARD_MOVER);
		return resposta;
	}
	
	public void ExportarImagensParaDiretorio(List<ImagemJPEG> imagens){
		String caminho = "";
		
		try {
			caminho = DiretorioDoSistemaUtil.PegaDiretorioDeImagens()  + mediador.getProcSelecionado().getAtendimento().getCodigo()+"\\";
		} catch (Exception a) {
			a.printStackTrace();
		}

		JFileChooser jfc = new JFileChooser();
		jfc.setMultiSelectionEnabled(true);
		jfc.setSelectedFile(new File(imagens.get(0).getNomeDaImagem()));
		int resultado = jfc.showSaveDialog(null);
		
		try {
			if (resultado == JFileChooser.APPROVE_OPTION) {
				for(ImagemJPEG imagem : imagens) {
					String caminhofinal = jfc.getSelectedFile().getAbsolutePath();
					String[] nomeImagem = imagem.getNomeDaImagem().split("\\.");
					String crianomeimagem =  "atd_" + mediador.getProcSelecionado().getAtendimento().getCodigo() + nomeImagem[0] + ".jpg";
					caminhofinal = caminhofinal.replace(imagens.get(0).getNomeDaImagem(), crianomeimagem);
					DecriptarArquivo decriptarArquivo = new DecriptarArquivo();
					byte[] arquivoFinal = decriptarArquivo.DevolverArquivo(caminho + imagem.getNomeDaImagem());

					this.Converter(caminhofinal, arquivoFinal);
				}					
			}
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	public void Converter(String caminho, byte[] imager) {
		Iterator<ImageWriter> iterador = ImageIO.getImageWritersByFormatName("jpeg");
		ImageWriter subescreve = iterador.next();
		ImageWriteParam parametroimagem = subescreve.getDefaultWriteParam();
		parametroimagem.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		parametroimagem.setCompressionQuality(1);

		try {
			BufferedImage imagem = ImageIO.read(new ByteArrayInputStream(imager));
			IIOImage imagestream = new IIOImage(imagem, null, null);

			File file = new File(caminho);
			FileImageOutputStream output = new FileImageOutputStream(file);
			subescreve.setOutput(output);

			subescreve.write(null, imagestream, parametroimagem);
			subescreve.dispose();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}

	private void carregarImagens() {
		mapaDeImg.clear();
		atualizarPreview(null);
		scrollPane.setViewportView(new JPanel());
		final List<MinhaImagem> imagens = obterImagens();
		if (imagens.size() > 0) {
			MinhaImagem img = imagens.get(0);
			Dimension chkPrefSize = descobrirPrefSize(conversor.convertForward(img.getImagem().getImagem()));
			criarChkBox(img, chkPrefSize);
			if (imagens.size() > 1) {
				for (int i = 1; i < imagens.size(); i++) {
					criarChkBox(imagens.get(i), chkPrefSize);
				}
			}
			scrollPane.setViewportView(criarPnlDeChk());
		}
	}

	private List<MinhaImagem> obterImagens() {
		if (rb1.isSelected()) {
			try {
				String text = txtDirImagens.getText();
				Path path = Paths.get(text);
				final List<MinhaImagem> resposta = new ArrayList<>();
				if (!text.trim().isEmpty() && Files.isDirectory(path)) {
					Files.walkFileTree(path, new FileVisitor<Path>() {
						@Override
						public FileVisitResult preVisitDirectory(Path dir,
								BasicFileAttributes attrs) throws IOException {
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFile(final Path file,
								BasicFileAttributes attrs) throws IOException {
							if (file.getFileName().toString().matches(".+\\.(jpg|jpeg|bmp|png|" + "JPG|JPEG|PNG|BMP)")) {
								resposta.add(new MinhaImagem() {
									@Override
									public ImagemJPEG getImagem() {
										ImagemJPEG jpeg = new ImagemJPEG();
										jpeg.setImagem(conversor.convertReverse(file.toFile()));
										return jpeg;
									}

									@Override
									public File getArquivoImagem() {
										return file.toFile();
									}
								});
								if (resposta.size() > 100) {
									return FileVisitResult.TERMINATE;
								}
							}
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult visitFileFailed(Path file,
								IOException exc) throws IOException {
							return FileVisitResult.CONTINUE;
						}

						@Override
						public FileVisitResult postVisitDirectory(Path dir,
								IOException exc) throws IOException {
							return FileVisitResult.CONTINUE;
						}
					});
					return resposta;
				}
			} catch (Exception e) {
			}
			return new ArrayList<>();
		} else {
			//List<Imagem> imagens = mediador.getProcSelecionado().getImagens();
			captur = new ServiceJPEG(mediador.getAtdSelecionado(), mediador.getProcSelecionado());
			this.listaimagemjpeg = this.captur.ListaImagensCapturadas(this.mediador.getProcSelecionado().getProcMedico().getCodigo(), this.mediador.getProcSelecionado().getAtendimento().getCodigo());
			List<MinhaImagem> resposta = new ArrayList<>();
			for (final ImagemJPEG imagen : this.listaimagemjpeg) {
				resposta.add(new MinhaImagem() {
					@Override
					public ImagemJPEG getImagem() {
						return imagen;
					}

					@Override
					public File getArquivoImagem() {
						return null;
					}
				});
			}
			return resposta;
		}
	}

	@Override
	public void fechar() {
		dispose();
	}

	private List<ImagemJPEG> obterImagensSelecionadass() {
		List<ImagemJPEG> imagens = new ArrayList<ImagemJPEG>();
		//this.listaimagemjpeg = this.captur.ListaImagensCapturadas(this.mediador.getProcSelecionado().getProcMedico().getCodigo(), this.mediador.getProcSelecionado().getAtendimento().getCodigo());
		for (Map.Entry<ChkImagem, MinhaImagem> entry : mapaDeImg.entrySet()) {
			if (entry.getKey().isSelected()) {
				imagens.add(entry.getValue().getImagem());
			}
		}
		return imagens;
	}
	
//	private List<Imagem> obterImagensSelecionadas (){
//        List<Imagem> imagens = new ArrayList<>();
//        for (Map.Entry<ChkImagem, MinhaImagem> entry : mapaDeImg.entrySet()) {
//            if (entry.getKey().isSelected()) {
//                imagens.add(entry.getValue().getImagem());
//            }
//        }
//        return imagens;
//    }

	private void deletarImagensSelecionadas() {
		//List<MinhaImagem> imagens = new ArrayList<>();
		this.captur = new ServiceJPEG(mediador.getAtdSelecionado(), mediador.getProcSelecionado());
		
		this.listaimagemjpeg = this.captur.ListaImagensCapturadas(this.mediador.getProcSelecionado().getProcMedico().getCodigo(), this.mediador.getProcSelecionado().getAtendimento().getCodigo());
		for (Map.Entry<ChkImagem, MinhaImagem> entry : mapaDeImg.entrySet()) {
			if (entry.getKey().isSelected()) {
				entry.getValue().getArquivoImagem().delete();
			}
		}
	}

	private ProcDoAtd getProc() {
		return cmbProc.getSelectedItem();
	}

	private void atualizarLblTotal() {
		int contador = 0;
		for (MyJCheckBox myJCheckBox : mapaDeImg.keySet()) {
			if (myJCheckBox.isSelected()) {
				contador++;
			}
		}
		switch (contador) {
		case 0:
			lblTotal.setText("Nenhuma imagem selecionada");
			break;
		case 1:
			lblTotal.setText("1 imagem selecionada");
			break;
		default:
			lblTotal.setText(String.valueOf(contador) + " imagens selecionadas");
		}
	}

	private void atualizarPreview(byte[] imagem) {
		if (imagem == null) {
			lblImagemPreview.setIcon(null);
		} else {
			BufferedImage imgOriginal = conversor.convertForward(imagem);
			float aspectRatio = ((float) imgOriginal.getWidth())
					/ ((float) imgOriginal.getHeight());
			Dimension fitSize = ImageUtils.getFitSize(
					lblImagemPreview.getSize(), aspectRatio);
			lblImagemPreview.setIcon(new ImageIcon(ImageUtils
					.createResizedCopy(imgOriginal, fitSize.width,
							fitSize.height, true)));
		}
	}

	private void limparSelecao() {
		for (ChkImagem chk : mapaDeImg.keySet()) {
			chk.getParent().setBackground(null);
		}
	}

	private void marcarChkBox(ChkImagem chk) {
		chk.getParent().setBackground(Color.blue);
	}

	private Dimension descobrirPrefSize(BufferedImage bi) {
		float proporcao = ((float) bi.getWidth()) / ((float) bi.getHeight());
		return new Dimension(185, (int) (185 / proporcao));
	}

	private void criarChkBox(final MinhaImagem imagem, Dimension chkPreSize) {
		BufferedImage bi = conversor.convertForward(imagem.getImagem().getImagem());
		final ChkImagem chk = new ChkImagem(bi);
		mapaDeImg.put(chk, imagem);
		chk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				atualizarPreview(imagem.getImagem().getImagem());
				limparSelecao();
				marcarChkBox(chk);
			}

		});
		chk.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				atualizarLblTotal();
			}

		});
		chk.setVerticalAlignment(SwingConstants.TOP);
		chk.setPreferredSize(chkPreSize);
	}

	private Component criarPnlDeChk() {
		MyJPanel pnl = new MyJPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		Set<ChkImagem> chks = mapaDeImg.keySet();
		final List<ChkImagem> chksList = new ArrayList<>(chks);
		int numLinhas = (chks.size() / 3) + 1;
		int indexImg = 0;
		c.insets.left = 6;
		c.insets.top = 2;
		for (int linha = 0; linha < numLinhas; linha++) {
			c.gridy = linha;
			for (int coluna = 0; coluna < 3; coluna++) {
				if (indexImg <= chks.size() - 1) {
					c.gridx = coluna;
					pnl.add(new PnlComEspaco(chksList.get(indexImg), 4, 4, 0, 0),
							c);
					indexImg++;
				}
			}
		}
		c.weightx = 1;
		c.weighty = 1;
		c.gridy = numLinhas;
		c.gridx = 3;
		pnl.add(Box.createHorizontalStrut(0), c);
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (chksList.size() > 0) {
					marcarChkBox(chksList.get(0));
					atualizarPreview(mapaDeImg.get(chksList.get(0)).getImagem()
							.getImagem());
				}
			}

		});
		return pnl;
	}

	private class ChkImagem extends MyJCheckBox {

		private BufferedImage img;

		private ChkImagem(BufferedImage img) {
			this.img = img;
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g.create();
			int width = getWidth();
			int height = getHeight();
			g2d.drawImage(img, 0, 0, width, height, this);
			g2d.dispose();
			super.paintComponent(g);
		}

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

	private interface MinhaImagem {
		ImagemJPEG getImagem();

		File getArquivoImagem();
	}

	private class MyBtnFileChooser extends JButton {
		private File lastDir;

		private MyBtnFileChooser() {
			setIcon(SwingLibResources.getIcon(Imagens.PASTA));
			addActionListener(new MyActionListener());
		}

		private class MyActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				if (lastDir == null && !txtDirImagens.getText().isEmpty()) {
					File file = new File(txtDirImagens.getText());
					if (file.exists() && file.isDirectory()) {
						fileChooser.setCurrentDirectory(file);
					}
				}
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					lastDir = fileChooser.getCurrentDirectory();
					File file = fileChooser.getSelectedFile();
					if (file == null) {
						txtDirImagens.setText("");
					} else {
						txtDirImagens.setText(file.getPath());
					}
				}
			}
		}
	}
}
