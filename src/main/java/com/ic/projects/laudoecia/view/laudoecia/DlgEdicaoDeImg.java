/*
 * DlgEdicaoDeImg.java
 *
 * Created on 15/05/2012, 11:36:37
 */
package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.PropriedadeDaCaptura;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.paint.FontSource;
import com.ic.projects.laudoecia.view.paint.Painter;
import com.ic.projects.laudoecia.view.paint.PnlPaint;
import com.lib.java.utils.ImageUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJToggleButton;
import com.lib.swing.plus.renderers.FontComboCellRenderer;
import com.lib.swing.plus.renderers.SizeComboCellRenderer;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.ColorChooser;
import com.lib.swing.plus.utils.HTMLFontUtils;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtReadOnly;
import com.lib.swing.utils.SwingUtils;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgEdicaoDeImg extends MyJDialog {

	private LaudoeCiaMediator mediador;
	private ConversorByteArrayImage cnv = new ConversorByteArrayImage();

	public DlgEdicaoDeImg(LaudoeCiaMediator mediador) {
		super(FormPrincipal.getInstance(), true,
				new Rectangle(new Point(), Toolkit.getDefaultToolkit().getScreenSize()));
		this.mediador = mediador;
		setTitle("LaudoeCia - Edição de imagem");
		setIconImage(FormPrincipal.getInstance().getIconImage());
		initComponents();
		final byte[] img = DlgEdicaoDeImg.this.mediador.getImagemAtual();
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Rectangle rect = getRect(cnv.convertForward(img));
				PnlPaint pnlPaint = pnlEdicaoImagem.getPnlPaint();
				pnlPaint.setBounds(rect);
				pnlPaint.getLblImagem().revalidate();
			}

			private Rectangle getRect(BufferedImage im) {
				Dimension dTotal = pnlEdicaoImagem.getPnlBorderImagem().getSize();
				dTotal.width -= 8;
				dTotal.height -= 8;
				Dimension d = ImageUtils.getFitSize(dTotal, (float) im.getWidth() / (float) im.getHeight());
				Point p = new Point(((dTotal.width - d.width) / 2) + 4, ((dTotal.height - d.height) / 2) + 4);
				return new Rectangle(p, d);
			}

		});
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				pnlEdicaoImagem.setImagem(img);
			}

		});
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		add(menu, BorderLayout.NORTH);
		add(pnlEdicaoImagem, BorderLayout.CENTER);
	}

	// <editor-fold defaultstate="collapsed" desc="Componentes">
	private JMenuBar menu = new JMenuBar();
	private MyJButton btnSalvar = new MyJButton("Salvar e voltar");
	private MyJButton btnAplicar = new MyJButton("Sempre ajustar brilho e contraste");
	private MyJButton btnCancelar = new MyJButton("Cancelar");
	private MyJButton btnResetar = new MyJButton("Restaurar padrão");
	private PnlEdicaoImagem pnlEdicaoImagem = new PnlEdicaoImagem();

	{
		btnSalvar.setIcon(ImageResources.getIcon(ImagensLC.SALVAR_VOLTAR));
		btnSalvar.setToolTipText("Salvar imagem e retornar.");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSalvarAction();
			}

		});
		btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
		btnCancelar.setToolTipText("Sair sem salvar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fechar(false);
			}

		});
		btnAplicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String brilho = String.valueOf(pnlEdicaoImagem.sliderBrilho.getValue() / 100f).replace(",", ".");
					String contraste = String.valueOf(pnlEdicaoImagem.sliderContraste.getValue() / 100f).replace(",",
							".");
					// String cor =
					// String.valueOf((float)pnlEdicaoImagem.sliderIntensidadeCor.getValue()/100f).replace(",",
					// ".");
					// String saturacao =
					// String.valueOf((float)pnlEdicaoImagem.sliderIntensidadeSat.getValue()/100f).replace(",",
					// ".");

					StaticInfo.salvarPropriedadeDaCaptura("ajustes", brilho + ";" + contraste + "; ");// " + cor + ";" +
																										// saturacao);
					btnSalvarAction();
					SwingUtils.mostrarMsgDeSucesso(null, "Ajuste de brilho e contraste gravado com sucesso!");
					Runtime.getRuntime().exec("C:\\LaudoeCia\\bin\\Laudoecia.bat");
					System.exit(0);

					// String dir = StaticInfo.getPastaDeInstalacaoDoSistema() + "LaudoeCia.jar";
					// SwingUtils.mostrarAviso(null, dir);
					// Runtime.getRuntime().exec(dir);
				} catch (Exception ex) {
					SwingUtils.mostrarAviso(null,
							"O programa será fechado para aplicar as alterações.\nExecute o LaudoeCia novamente!");
					System.exit(0);
				}
			}

		});
		btnResetar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String brilho = String.valueOf(1.0);
					String contraste = String.valueOf(1.0);
					StaticInfo.salvarPropriedadeDaCaptura("ajustes", brilho + ";" + contraste + "; ");
					btnSalvarAction();
					Runtime.getRuntime().exec("C:\\LaudoeCia\\bin\\Laudoecia.bat");
					System.exit(0);
				} catch (Exception ex) {
					SwingUtils.mostrarAviso(null, "O programa será fechado.\nExecute o LaudoeCia novamente!");
					System.exit(0);
				}
			}

		});
		menu.setBorder(new CompoundBorder(new BlackAndWhiteEtchedBorder(), new EmptyBorder(3, 3, 3, 3)));
		menu.add(btnSalvar);
		menu.add(btnCancelar);
		menu.add(btnAplicar);
		menu.add(btnResetar);
	}

	// </editor-fold>
	private void btnSalvarAction() {

		fechar(false);
		mediador.imagemFoiEditada(pnlEdicaoImagem.getImagem());
		try {
			pnlEdicaoImagem.salvarPrefs();
		} catch (Exception e) {
		}
	}

	@Override
	public void fechar() {
		fechar(true);
	}

	private void fechar(boolean solicitarQueSalve) {
		if (solicitarQueSalve) {
			if (SwingUtils.obterConfirmacaoDoUsuario("Sair sem salvar?", this) == JOptionPane.YES_OPTION) {
			} else {
				return;
			}
		}
		dispose();
	}

	private class PnlEdicaoImagem extends MyJPanel implements FontSource {

		private PnlEdicaoImagem() {
			setLayout(new GridBagLayout());
			setBorder(new CompoundBorder(new BlackAndWhiteEtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridy = 0;
			c.gridx = 0;
			c.gridheight = 3;
			c.weightx = 1;
			add(pnlBorderImagem, c);
			c.gridx = 1;
			c.gridheight = 1;
			c.weightx = 0;
			add(new PnlComp("Ferramentas", true, false).setComponent(pnlFerramentas), c);
			c.gridy = 1;
			c.weighty = 0.35;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.LINE_START;
			add(new PnlComp("Controles", true, true).setComponent(pnlUndoRedo), c);
			c.gridy = 2;
			c.weighty = 0.65;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			add(new PnlComp("Configurações", true, true).setComponent(pnlConfiguracoes), c);
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 2;
			c.weighty = 0;
			JPanel pnl = new JPanel(new GridLayout(0, 2, 0, 0));
			pnl.add(new PnlComp("Ajustes de Imagem", false, true).setComponent(pnlAjustes));
			pnl.add(new PnlComp("Configurações de Fonte", true, true).setComponent(pnlFonte));
			add(pnl, c);

			java.awt.EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					try {
						carregarPrefs();
					} catch (Exception e) {
					}
				}

			});

		}

		private void carregarPrefs() {
			ParametrosDaCaptura params = StaticInfo.getParamsCaptura();
			for (PropriedadeDaCaptura pc : params.getPropriedades()) {
				String desc = pc.getDescricao();
				switch (desc) {
				case FONTE:
					cmbFonte.setSelectedItem(pc.getValor());
					break;
				case TAMANHO:
					cmbTamanhoFonte.setSelectedItem(Integer.valueOf(pc.getValor()));
					break;
				case COR:
					colorChooser.setCor(new Color(Integer.valueOf(pc.getValor())));
					break;
				case STROKE:
					cmbTamanho.setSelectedIndex(Integer.valueOf(pc.getValor()));
					break;
				case NEGRITO:
					btnNegrito.setSelected(Boolean.valueOf(pc.getValor()));
					break;
				case ITALICO:
					btnItalico.setSelected(Boolean.valueOf(pc.getValor()));
					break;
				case TOOL:
					switch (pc.getValor()) {
					case SETA:
						btnSeta.setSelected(true);
						break;
					case LINHA:
						btnLinha.setSelected(true);
						break;
					case CANETA:
						btnPincel.setSelected(true);
						break;
					case TEXTO:
						btnTexto.setSelected(true);
						break;
					case CIRCULO:
						btnCirculo.setSelected(true);
						break;
					case QUADRADO:
						btnQuadrado.setSelected(true);
						break;
					}
					break;
				}
			}
		}

		private void salvarPrefs() throws Exception {
			Map<String, String> mapa = new HashMap<>();
			mapa.put(FONTE, cmbFonte.getSelectedItem());
			mapa.put(TAMANHO, String.valueOf(cmbTamanhoFonte.getSelectedItem()));
			mapa.put(COR, String.valueOf(colorChooser.getCor().getRGB()));
			mapa.put(STROKE, String.valueOf(cmbTamanho.getSelectedIndex()));
			mapa.put(NEGRITO, Boolean.toString(btnNegrito.isSelected()));
			mapa.put(ITALICO, Boolean.toString(btnItalico.isSelected()));
			String tool = SETA;
			if (btnLinha.isSelected()) {
				tool = LINHA;
			} else if (btnCirculo.isSelected()) {
				tool = CIRCULO;
			} else if (btnPincel.isSelected()) {
				tool = CANETA;
			} else if (btnQuadrado.isSelected()) {
				tool = QUADRADO;
			} else if (btnTexto.isSelected()) {
				tool = TEXTO;
			}
			mapa.put(TOOL, tool);
			StaticInfo.salvarPropriedadeDaCaptura(mapa);
		}

		private byte[] getImagem() {
			return cnv.convertReverse(pnlPaint.getImgParaVerEmResOr());
		}

		private void setImagem(byte[] imagem) {
			pnlPaint.setImagem(imagem);
		}

		private PnlPaint getPnlPaint() {
			return pnlPaint;
		}

		private MyJPanel getPnlBorderImagem() {
			return pnlBorderImagem;
		}

		// <editor-fold defaultstate="collapsed" desc="Paineis">
		private MyJPanel pnlBorderImagem = new MyJPanel();
		private PnlPaint pnlPaint = new PnlPaint(new MouseAdapter() {
		}, null);
		private MyJPanel pnlFerramentas = new MyJPanel();
		private MyJPanel pnlUndoRedo = new MyJPanel();
		private MyJPanel pnlConfiguracoes = new MyJPanel();
		private MyJPanel pnlAjustes = new MyJPanel();
		private MyJPanel pnlFonte = new MyJPanel();
		private Painter painter = new Painter(pnlPaint);

		{

			painter.setFontSource(this);

			CompoundBorder border = new CompoundBorder(new EtchedBorder(), new EmptyBorder(5, 5, 5, 5));
			pnlFerramentas.setBorder(border);
			pnlUndoRedo.setBorder(border);
			pnlConfiguracoes.setBorder(border);
			pnlAjustes.setBorder(border);
			pnlFonte.setBorder(border);
			pnlBorderImagem.setBorder(new CompoundBorder(new LineBorder(Color.GRAY), new LineBorder(Color.WHITE, 3)));
			pnlBorderImagem.setLayout(null);
			pnlBorderImagem.setBackground(Color.black);
			pnlBorderImagem.add(pnlPaint);
			// pnlBorderImagem.setLayout(new BorderLayout());
			// pnlBorderImagem.add(pnlPaint, BorderLayout.CENTER);
		}

		// </editor-fold>
		// <editor-fold defaultstate="collapsed" desc="Painel de Ferramentas">
		private MyJToggleButton btnToolSelected;
		private MyJToggleButton btnSeta = new MyJToggleButton();
		private MyJToggleButton btnQuadrado = new MyJToggleButton();
		private MyJToggleButton btnCirculo = new MyJToggleButton();
		private MyJToggleButton btnLinha = new MyJToggleButton();
		private MyJToggleButton btnPincel = new MyJToggleButton();
		private MyJToggleButton btnTexto = new MyJToggleButton();

		{
			btnSeta.setIcon(ImageResources.getIcon(ImagensLC.ARROW_TOOL));
			btnSeta.setToolTipText("Ferramenta de seta");
			btnSeta.addItemListener(new ToolItemListener(Painter.DRAW_ARROW));

			btnQuadrado.setIcon(ImageResources.getIcon(ImagensLC.RECTANGLE_TOOL));
			btnQuadrado.setToolTipText("Ferramenta de retângulo");
			btnQuadrado.addItemListener(new ToolItemListener(Painter.DRAW_RECTANGLE));

			btnCirculo.setIcon(ImageResources.getIcon(ImagensLC.CIRCLE_TOOL));
			btnCirculo.setToolTipText("Ferramenta de círculo");
			btnCirculo.addItemListener(new ToolItemListener(Painter.DRAW_ELIPSE));

			btnLinha.setIcon(ImageResources.getIcon(ImagensLC.LINE_TOOL));
			btnLinha.setToolTipText("Ferramenta de linha");
			btnLinha.addItemListener(new ToolItemListener(Painter.DRAW_LINE));

			btnPincel.setIcon(ImageResources.getIcon(ImagensLC.PENCIL_TOOL));
			btnPincel.setToolTipText("Ferramenta de desenho a mão livre");
			btnPincel.addItemListener(new ToolItemListener(Painter.FREE_DRAWING_PEN));

			btnTexto.setIcon(ImageResources.getIcon(ImagensLC.FONT_TOOL));
			btnTexto.setToolTipText("Ferramenta de texto");
			btnTexto.addItemListener(new ToolItemListener(Painter.ADD_TEXT));
			btnTexto.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					setPnlFontEnabled(btnTexto.isSelected());
				}

			});

			pnlFerramentas.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridy = 0;
			c.gridx = 0;
			pnlFerramentas.add(btnSeta, c);
			c.gridy = 1;
			pnlFerramentas.add(new PnlComp(false, false, true).setComponent(btnCirculo), c);
			c.gridy = 2;
			pnlFerramentas.add(new PnlComp(false, false, true).setComponent(btnPincel), c);
			c.gridy = 0;
			c.gridx = 1;
			pnlFerramentas.add(new PnlComp(false, true, false).setComponent(btnQuadrado), c);
			c.gridy = 1;
			pnlFerramentas.add(new PnlComp(false, true, true).setComponent(btnLinha), c);
			c.gridy = 2;
			pnlFerramentas.add(new PnlComp(false, true, true).setComponent(btnTexto), c);
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 2;
			c.weightx = 1d;
			c.weighty = 1d;
			pnlFerramentas.add(Box.createHorizontalStrut(10), c);

			btnSeta.setSelected(true);

		}

		private class ToolItemListener implements ItemListener {

			private int action;

			private ToolItemListener(int action) {
				this.action = action;
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (!(btnToolSelected == null || btnToolSelected == e.getSource())) {
						btnToolSelected.setSelected(false);
					}
					btnToolSelected = (MyJToggleButton) e.getSource();
					painter.setAction(action);
				}
			}

		}

		// </editor-fold>
		// <editor-fold defaultstate="collapsed" desc="Painel de Controles">
		private MyJButton btnDesfazer = new MyJButton();
		private MyJButton btnRefazer = new MyJButton();

		{
			btnDesfazer.setIcon(SwingLibResources.getIcon(Imagens.UNDO));
			btnDesfazer.setToolTipText("Desfazer ação");
			btnDesfazer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnDesfazerAction();
				}

			});
			btnRefazer.setIcon(SwingLibResources.getIcon(Imagens.REDO));
			btnRefazer.setToolTipText("Refazer ação");
			btnRefazer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnRefazerAction();
				}

			});

			pnlUndoRedo.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridy = 0;
			c.gridx = 0;
			pnlUndoRedo.add(btnDesfazer, c);
			c.gridx = 1;
			pnlUndoRedo.add(new PnlComp(false, true, false).setComponent(btnRefazer), c);
		}

		private void btnDesfazerAction() {
			painter.undo();
		}

		private void btnRefazerAction() {
			painter.redo();
		}

		// </editor-fold>
		// <editor-fold defaultstate="collapsed" desc="Painel Configurações">
		private MyJComboBox<Integer> cmbTamanho = new MyJComboBox<>(new Integer[] { 1, 2, 3, 4, 5, 6 });
		private ColorChooser colorChooser = new ColorChooser(this, Color.WHITE);

		{
			cmbTamanho.setRenderer(new SizeComboCellRenderer());
			cmbTamanho.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						painter.setStroke(cmbTamanho.getSelectedIndex());
					}
				}

			});

			colorChooser.adicionarListener(new Runnable() {

				@Override
				public void run() {
					painter.setColor(colorChooser.getCor());
				}

			});

			pnlConfiguracoes.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1d;
			c.gridy = 0;
			c.gridx = 0;
			pnlConfiguracoes.add(new PnlComp("Tamanho", false, false).setComponent(cmbTamanho), c);
			c.gridy = 1;
			pnlConfiguracoes.add(new PnlComp("Cor", false, true).setComponent(colorChooser), c);

			cmbTamanho.setSelectedIndex(4);
			colorChooser.setCor(Color.white);

		}

		// </editor-fold>
		// <editor-fold defaultstate="collapsed" desc="Painel Ajustes">
		private LblNegrito lblBrilho = new LblNegrito("Brilho");
		private LblNegrito lblContraste = new LblNegrito("Contraste");
		// private LblNegrito lblCor = new LblNegrito("Cor");
		// private LblNegrito lblSat = new LblNegrito("Saturação");
		private JSlider sliderBrilho = new JSlider(0, 200, 100);
		private JSlider sliderContraste = new JSlider(0, 200, 100);
		private JSlider sliderIntensidadeCor = new JSlider(0, 200, 100);
		private JSlider sliderIntensidadeSat = new JSlider(0, 200, 100);
		private TxtReadOnly txtBrilhoValue = new TxtReadOnly();
		private TxtReadOnly txtContrasteValue = new TxtReadOnly();
		private TxtReadOnly txtCorValue = new TxtReadOnly();
		private TxtReadOnly txtSatValue = new TxtReadOnly();

		{
			txtBrilhoValue.setText(0);
			txtContrasteValue.setText(0);
			txtCorValue.setText(0);
			txtSatValue.setText(0);
			txtBrilhoValue.setHorizontalAlignment(JTextField.CENTER);
			txtContrasteValue.setHorizontalAlignment(JTextField.CENTER);
			txtCorValue.setHorizontalAlignment(JTextField.CENTER);
			txtSatValue.setHorizontalAlignment(JTextField.CENTER);
			sliderBrilho.addChangeListener(new SliderChangeListener(txtBrilhoValue, Painter.BRIGHTNESS));
			sliderContraste.addChangeListener(new SliderChangeListener(txtContrasteValue, Painter.CONTRAST));
			sliderIntensidadeCor.addChangeListener(new SliderChangeListener(txtCorValue, Painter.COLOR));
			sliderIntensidadeSat.addChangeListener(new SliderChangeListener(txtSatValue, Painter.SATURATION));

			pnlAjustes.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridy = 0;
			c.gridx = 0;
			pnlAjustes.add(lblBrilho, c);
			c.gridx = 1;
			pnlAjustes.add(sliderBrilho, c);
			c.gridx = 2;
			pnlAjustes.add(txtBrilhoValue, c);
			c.gridy = 1;
			c.gridx = 0;
			pnlAjustes.add(lblContraste, c);
			c.gridx = 1;
			pnlAjustes.add(sliderContraste, c);
			c.gridx = 2;
			pnlAjustes.add(txtContrasteValue, c);
			// c.gridy = 2;
			// c.gridx = 0;
			// pnlAjustes.add(lblCor, c);
			c.gridx = 1;
			pnlAjustes.add(sliderIntensidadeCor, c);
			c.gridx = 2;
			pnlAjustes.add(txtCorValue, c);
			// c.gridy = 3;
			// c.gridx = 0;
			// pnlAjustes.add(lblSat, c);
			c.gridx = 1;
			pnlAjustes.add(sliderIntensidadeSat, c);
			c.gridx = 2;
			pnlAjustes.add(txtSatValue, c);
			c.gridy = 4;
			c.gridx = 0;
			pnlAjustes.add(Box.createHorizontalStrut(80), c);
			c.gridx = 1;
			c.weightx = 1;
			pnlAjustes.add(Box.createHorizontalStrut(0), c);
			c.gridx = 2;
			c.weightx = 0;
			pnlAjustes.add(Box.createHorizontalStrut(50), c);
		}

		private class SliderChangeListener implements ChangeListener {

			private JTextField txt;
			private int filtro;
			private DecimalFormat format = new DecimalFormat();

			{
				format.setMaximumFractionDigits(2);
				format.setMinimumFractionDigits(2);
			}

			private SliderChangeListener(JTextField txt, int filtro) {
				this.txt = txt;
				this.filtro = filtro;
			}

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sld = (JSlider) e.getSource();
				float valorSld = sld.getValue();
				float valorCorrigido = valorSld / 100;
				txt.setText(format.format((valorCorrigido - 1)));
				painter.aplicarFiltro(filtro, valorCorrigido);
			}

		}

		// </editor-fold>
		// <editor-fold defaultstate="collapsed" desc="Painel Fontes">
		private LblNegrito lblFonte = new LblNegrito("Fonte");
		private LblNegrito lblTamanhoFonte = new LblNegrito("Tamanho");
		private MyJComboBox<String> cmbFonte = new MyJComboBox<>(HTMLFontUtils.getFonts());
		private MyJComboBox<Integer> cmbTamanhoFonte = new MyJComboBox<>(HTMLFontUtils.getSizes());
		private MyJToggleButton btnNegrito = new MyJToggleButton();
		private MyJToggleButton btnItalico = new MyJToggleButton();

		{

			cmbFonte.setRenderer(new FontComboCellRenderer(cmbFonte));

			btnNegrito.setIcon(SwingLibResources.getIcon(Imagens.FONT_BOLD));
			btnNegrito.setToolTipText("Negrito");
			btnNegrito.setSelected(true);

			btnItalico.setIcon(SwingLibResources.getIcon(Imagens.FONT_ITALIC));
			btnItalico.setToolTipText("Itálico");

			cmbTamanhoFonte.setSelectedIndex(6);

			pnlFonte.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridy = 0;
			c.gridx = 0;
			pnlFonte.add(lblFonte, c);
			c.gridwidth = 4;
			c.gridx = 1;
			pnlFonte.add(cmbFonte, c);
			c.gridwidth = 1;
			c.gridy = 1;
			c.gridx = 0;
			pnlFonte.add(new PnlComp(false, false, true).setComponent(lblTamanhoFonte), c);
			c.gridx = 1;
			pnlFonte.add(new PnlComp(false, false, true).setComponent(cmbTamanhoFonte), c);
			c.gridx = 2;
			pnlFonte.add(new PnlComp(false, true, true).setComponent(btnNegrito), c);
			c.gridx = 3;
			pnlFonte.add(new PnlComp(false, true, true).setComponent(btnItalico), c);
			c.weighty = 1d;
			c.gridy = 2;
			c.gridx = 0;
			pnlFonte.add(Box.createHorizontalStrut(80), c);
			c.gridx = 1;
			pnlFonte.add(Box.createHorizontalStrut(60), c);
			c.gridx = 2;
			pnlFonte.add(Box.createHorizontalStrut(30), c);
			c.gridx = 3;
			pnlFonte.add(Box.createHorizontalStrut(30), c);
			c.weightx = 1d;
			c.gridx = 4;
			pnlFonte.add(Box.createHorizontalStrut(10), c);

			setPnlFontEnabled(false);
		}

		@Override
		public Font getFonte() {
			int style = Font.PLAIN;
			if (btnNegrito.isSelected()) {
				style += Font.BOLD;
			}
			if (btnItalico.isSelected()) {
				style += Font.ITALIC;
			}
			return new Font(cmbFonte.getSelectedItem(), style, cmbTamanhoFonte.getSelectedItem());
		}

		private void setPnlFontEnabled(boolean enabled) {
			lblFonte.setEnabled(enabled);
			lblTamanhoFonte.setEnabled(enabled);
			cmbFonte.setEnabled(enabled);
			cmbTamanhoFonte.setEnabled(enabled);
			btnNegrito.setEnabled(enabled);
			btnItalico.setEnabled(enabled);
		}

		// </editor-fold>
		private static final String FONTE = "FONTE";
		private static final String TAMANHO = "TAMANHO";
		private static final String COR = "COR";
		private static final String STROKE = "STROKE";
		private static final String NEGRITO = "NEGRITO";
		private static final String ITALICO = "ITALICO";
		private static final String TOOL = "TOOL";
		private static final String SETA = "SETA";
		private static final String LINHA = "LINHA";
		private static final String CANETA = "CANETA";
		private static final String TEXTO = "TEXTO";
		private static final String CIRCULO = "CIRCULO";
		private static final String QUADRADO = "QUADRADO";

	}

}
