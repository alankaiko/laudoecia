/*
 * PnlPaint.java
 *
 * Created on 29/05/2012, 10:15:48
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.jhlabs.image.ContrastFilter;
import com.jhlabs.image.HSBAdjustFilter;
import com.lib.java.utils.ImageUtils;
import com.lib.swing.plus.utils.PnlImagem;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlPaint extends PnlImagem {

	// <editor-fold defaultstate="collapsed" desc="Commented out for now">

	private Shape selection;
	private boolean filterSelection = false;

	// <editor-fold defaultstate="collapsed" desc="Setters">

	void setSelection(Shape selection) {
		this.selection = selection;
	}

	void setFilterSelection(boolean filterSelection) {
		this.filterSelection = filterSelection;
	}

	// </editor-fold>

//    // <editor-fold defaultstate="collapsed" desc="Flip">
//
//    public static final int FLIP_H = 1;
//    public static final int FLIP_V = 2;
//    public static final int FLIP_HV = 3;
//    public static final int FLIP_90CW = 4;
//    public static final int FLIP_90CCW = 5;
//    public static final int FLIP_180 = 6;
//
//    // </editor-fold>

//     <editor-fold defaultstate="collapsed" desc="Filters">

//    /**
//     * Faz um flip na imagem mostrada
//     *
//     * @param tipo um dos seguintes:
//     * <code>FLIP_H</code>
//     * <code>FLIP_V</code>
//     * <code>FLIP_HV</code>
//     * <code>FLIP_90CW</code>
//     * <code>FLIP_90CCW</code>
//     * <code>FLIP_180</code>
//     */
//    void flipImage (int tipo)
//    {
//
//        FlipFilter filtro = new FlipFilter();
//        switch (tipo)
//        {
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//                filtro.setOperation(tipo);
//                break;
//            default:
//                return;
//        }
//        aplicarFiltro(filtro);
//
//    }
//
//    /**
//     * Crops an image
//     *
//     * @param x the left edge of the crop rectangle
//     * @param y the top edge of the crop rectangle
//     * @param width the width of the crop rectangle
//     * @param height the height of the crop rectangle
//     */
//    void cropImage (int x, int y, int width, int height)
//    {
//
//        CropFilter filtro = new CropFilter(x, y, width, height);
//        aplicarFiltro(filtro);
//
//    }
//
//    void aplicarGlow ()
//    {
//
//        GlowFilter filtro = new GlowFilter();
//        aplicarFiltro(filtro);
//
//    }
//
//    void alterarHSB (float hue, float saturation, float brightness)
//    {
//
//        HSBAdjustFilter filtro = new HSBAdjustFilter();
//        filtro.setHFactor(hue);
//        filtro.setSFactor(saturation);
//        filtro.setBFactor(brightness);
//        aplicarFiltro(filtro);
//
//    }

	// </editor-fold>

//     <editor-fold defaultstate="collapsed" desc="Aplicar filtro">

	// private void aplicarFiltro (AbstractBufferedImageOp filtro)
//    {
//
//        // eh importante que no metodo filtro.filter o parametro
//        // dest seja null, e a imagem filtrada eh retornada pelo metodo
//
//        try
//        {
//            BufferedImage source = imgParaDesenho;
//            if (source == null)
//            {
//            }
//            else if (filterSelection)
//            {
//                BufferedImage copia = new BufferedImage(source.getWidth(),
//                                                        source.getHeight(), source.getType());
//                Graphics2D g = (Graphics2D) copia.getGraphics();
//                g.clip(selection);
//                g.drawImage(source, 0, 0, null);
//                g.dispose();
//                BufferedImage imgFiltrada = filtro.filter(copia, null);
//                Graphics2D g2 = (Graphics2D) source.getGraphics();
//                g2.setClip(selection);
//                g2.drawImage(imgFiltrada, 0, 0, null);
//                g2.dispose();
//                desenharImagemNoJLabel(source);
//            }
//            else
//            {
//                desenharImagemNoJLabel(filtro.filter(source, null));
//            }
//        }
//        catch (Exception e)
//        {
//        }
//
//    }

	// </editor-fold>

	// </editor-fold>

	private ContrastFilter filtroContraste = new ContrastFilter();
	private HSBAdjustFilter filtroHueSat = new HSBAdjustFilter();
	private BufferedImage imgSemFiltro;
	private boolean filtroMudou = false;

	public PnlPaint(MouseListener acaoLabel, String toolTip) {
		super(acaoLabel, toolTip);
		addListener(new Runnable() {

			@Override
			public void run() {
				imgSemFiltro = getLblImage();
			}
		});
	}

	private BufferedImage getLblImage() {
		Icon icon = getLblImagem().getIcon();
		if (icon == null || !(icon instanceof ImageIcon)) {
			return null;
		} else {
			ImageIcon imgIcon = (ImageIcon) icon;
			Image img = imgIcon.getImage();
			if (img == null) {
				return null;
			} else {
				return com.lib.java.utils.ImageUtils.convertToBufferedImage(img);
			}
		}
	}

	private void desenharImagemNoJLabel() {
		if (filtroMudou) {
			getLblImagem().setIcon(new ImageIcon(filtroContraste.filter(imgSemFiltro, null)));
		} else {
			getLblImagem().setIcon(new ImageIcon(imgSemFiltro));
		}
	}

	/**
	 * Altera o brilho da imagem mostrada no panel
	 *
	 * @param brilho o valor de brilho desejado (de 0 a 2.0f)
	 */
	void setarBrilho(float brilho) {
		if (imgSemFiltro == null) {
		} else {
			filtroContraste.setBrightness(brilho);
			filtroMudou = true;
			desenharImagemNoJLabel();
			filtroMudou = false;
		}
	}

	/**
	 * Altera o contraste da imagem mostrada no panel
	 *
	 * @param contraste o valor de contraste desejado (de 0 a 2.0f)
	 */
	void setarContraste(float contraste) {
		if (imgSemFiltro == null) {
		} else {
			filtroContraste.setContrast(contraste);
			filtroMudou = true;
			desenharImagemNoJLabel();
			filtroMudou = false;
		}
	}

	void setarCor(float cor) {
		if (imgSemFiltro == null) {
		} else {
			filtroHueSat.setHFactor(cor);
			filtroMudou = true;
			desenharImagemNoJLabel();
			filtroMudou = false;
		}
	}

	void setarSaturacao(float saturacao) {
		if (imgSemFiltro == null) {
		} else {
			filtroHueSat.setSFactor(saturacao);
			filtroMudou = true;
			desenharImagemNoJLabel();
			filtroMudou = false;
		}
	}

	public BufferedImage getImgEditada() {
		return getLblImage();
	}

	BufferedImage getBufferedImg() {
		return imgSemFiltro;
	}

	void painting() {
		desenharImagemNoJLabel();
	}

	void donePainting() {
		filtroMudou = true;
		desenharImagemNoJLabel();
		filtroMudou = false;
	}

	@Override
	public BufferedImage getImgParaVerEmResOr() {
		BufferedImage img = super.getImgParaVerEmResOr();
		if (img == null) {
			return null;
		}
		BufferedImage bi = getLblImage();
		if (bi == null) {
			return null;
		}
		//BufferedImage imgResPadrao = ImageUtils.createResizedCopy(bi, img.getWidth(), img.getHeight(), true);
		return filtroContraste.filter(imgSemFiltro, null);
	}

}
