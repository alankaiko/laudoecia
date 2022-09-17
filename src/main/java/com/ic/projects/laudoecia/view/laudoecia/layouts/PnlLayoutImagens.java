/*
 * PnlLayoutImagens.java
 *
 * Created on 14/05/2012, 16:34:17
 */
package com.ic.projects.laudoecia.view.laudoecia.layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.cadastro.ImagemImpressa;
import com.ic.projects.laudoecia.view.laudoecia.ConverterParaJPEG;
import com.ic.projects.laudoecia.view.laudoecia.MyItemLayout;
import com.lib.icontrol.crud.utils.C_ImpImagens;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public abstract class PnlLayoutImagens extends MyJPanel {
	public static final String TEXTO_LAUDO = "@TEXTO_LAUDO";

	private List<MyItemLayout> itens = new ArrayList<>();
	private MyJLabel lblPagina = new MyJLabel("Página 1");
	private int indexPagina = 0;
	private MyJPanel pnlLayout;
	private LaudoeCiaMediator mediador;

	public static int labelImagem = 0;

	public PnlLayoutImagens(LaudoeCiaMediator mediador) {
		super(new BorderLayout(10, 10));
		this.mediador = mediador;
		pnlLayout = definirLayout();
		setBackground(Color.WHITE);
		setBorder(new CompoundBorder(new LineBorder(Color.BLACK),
				new EmptyBorder(10, 10, 10, 10)));
		Dimension d = new Dimension(595, 842);
		setPreferredSize(d);
		add(lblPagina, BorderLayout.NORTH);
		add(pnlLayout, BorderLayout.CENTER);
		lblPagina.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPagina.setForeground(Color.GRAY);
		lblPagina.setHorizontalAlignment(SwingConstants.CENTER);
		if (pnlLayout != null) {
			pnlLayout.setBackground(Color.WHITE);
		}
	}

	public void setPagina(int pagina) {
		lblPagina.setText("Página " + pagina);
		indexPagina = pagina - 1;
	}

	protected MyItemLayout createItemLayout(int width, int heigth, int indexItem) {
		MyItemLayout item = new MyItemLayout(mediador, width, heigth, this,
				indexItem);
		itens.add(item);
		return item;
	}

	protected String gerarImgHtmlTag(int indexImg, int paginas, int qtdFotos) {
		MyItemLayout item = itens.get(indexImg);
		if (item == null) {
			return "";
		}
		if (item.getImagem() == null) {
			return "";
		}
		int img = C_ImpImagens.cadastrarImgParaImp(item.getImagem());
		return "<img src=\"" + String.valueOf(img) + "\" width=\""
				+ String.valueOf(item.getLargura()) + "\" height=\""
				+ String.valueOf(item.getAltura())
				+ "\"><font size=\"1\"><p align='center'>" + "Imagem "
				+ ++labelImagem + " </p></font> </img>";
	}

	public void preencherAutomaticamente(List<byte[]> imagens) {
		if (imagens == null || imagens.isEmpty()) {
			return;
		}
		int loopEnd = imagens.size() < itens.size() ? imagens.size() : itens
				.size();
		for (int i = 0; i < loopEnd; i++) {
			itens.get(i).setImagem(imagens.get(i));
		}
	}

	public void preencherLayout(List<ImagemImpressa> imagens) {
		ConverterParaJPEG conv = new ConverterParaJPEG();
		
		if (imagens == null || imagens.isEmpty()) {
			return;
		}
		

		for (int i = 0; i < imagens.size(); i++) {
			ImagemImpressa imagemImp = imagens.get(i);
			if(!(imagemImp.getImagem() == null))
				itens.get(imagemImp.getIndice()).setImagem(imagemImp.getImagem().getImagem());
		}
		for(int i =0; i < imagens.size(); i++){
			ImagemImpressa imagemImp = imagens.get(i);
			
			if(imagemImp.getCaminhoimagemjpeg() !=null)
				itens.get(imagemImp.getIndice()).setImagem(conv.CarregandoImagens(imagemImp.getCaminhoimagemjpeg()));;
		}
	}

	public void atualizarImagemNaPosição(int indiceDaImg, byte[] novaImg) {
		itens.get(indiceDaImg).setImagem(novaImg);
	}

	public void limparPreenchimento() {
		for (int i = 0; i < itens.size(); i++) {
			itens.get(i).setImagem(null);
		}
	}

	public boolean isEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getImagem() != null) {
				isEmpty = false;
			}
		}
		return isEmpty;
	}

	public int getIndexPagina() {
		return indexPagina;
	}

	public abstract MyJPanel definirLayout();

	public abstract String getHTML(int paginas);

}
