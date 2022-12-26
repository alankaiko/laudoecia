/*
 * PnlLayout8Img.java
 *
 * Created on 17/05/2012, 09:37:21
 */
package com.ic.projects.laudoecia.view.laudoecia.layouts;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;

import org.jfree.ui.tabbedui.VerticalLayout;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.lib.swing.plus.cps.MyJPanel;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlLayout8ImgGrandes extends PnlLayoutImagens {
	public PnlLayout8ImgGrandes(LaudoeCiaMediator mediador) {
		super(mediador);
	}

	@Override
	public MyJPanel definirLayout() {
		MyJPanel pnl = new MyJPanel(new VerticalLayout());
		pnl.add(Box.createVerticalStrut(0));

		FlowLayout layoutLine = new FlowLayout(FlowLayout.CENTER, 0, 0);

		MyJPanel pnlLinha1 = new MyJPanel(layoutLine);
		pnlLinha1.setBackground(Color.WHITE);
		pnlLinha1.add(createItemLayout(268, 179, 0));
		pnlLinha1.add(createItemLayout(268, 179, 1));
		pnl.add(pnlLinha1);
		pnl.add(Box.createVerticalStrut(5));

		MyJPanel pnlLinha2 = new MyJPanel(layoutLine);
		pnlLinha2.setBackground(Color.WHITE);
		pnlLinha2.add(createItemLayout(268, 179, 2));
		pnlLinha2.add(createItemLayout(268, 179, 3));
		pnl.add(pnlLinha2);
		pnl.add(Box.createVerticalStrut(5));

		MyJPanel pnlLinha3 = new MyJPanel(layoutLine);
		pnlLinha3.setBackground(Color.WHITE);
		pnlLinha3.add(createItemLayout(268, 179, 4));
		pnlLinha3.add(createItemLayout(268, 179, 5));
		pnl.add(pnlLinha3);
		pnl.add(Box.createVerticalStrut(5));

		MyJPanel pnlLinha4 = new MyJPanel(layoutLine);
		pnlLinha4.setBackground(Color.WHITE);
		pnlLinha4.add(createItemLayout(268, 179, 6));
		pnlLinha4.add(createItemLayout(268, 179, 7));
		pnl.add(pnlLinha4);

		return pnl;
	}

	@Override
	public String getHTML(int paginas) {
		if (isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder("");
		sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">");

		sb.append("<tr><td align=\"right\">");
		sb.append(gerarImgHtmlTag(0, paginas, 9));
		sb.append("</td><td align=\"left\">");
		sb.append(gerarImgHtmlTag(1, paginas, 9));
		sb.append("</td></tr>");

		sb.append("<tr><td align=\"right\">");
		sb.append(gerarImgHtmlTag(2, paginas, 9));
		sb.append("</td><td align=\"left\">");
		sb.append(gerarImgHtmlTag(3, paginas, 9));
		sb.append("</td></tr>");

		sb.append("<tr><td align=\"right\">");
		sb.append(gerarImgHtmlTag(4, paginas, 9));
		sb.append("</td><td align=\"left\">");
		sb.append(gerarImgHtmlTag(5, paginas, 9));
		sb.append("</td></tr>");

		sb.append("<tr><td align=\"right\">");
		sb.append(gerarImgHtmlTag(6, paginas, 9));
		sb.append("</td><td align=\"left\">");
		sb.append(gerarImgHtmlTag(7, paginas, 9));
		sb.append("</td></tr>");

		sb.append("</table>");
		return sb.toString();
	}

}
