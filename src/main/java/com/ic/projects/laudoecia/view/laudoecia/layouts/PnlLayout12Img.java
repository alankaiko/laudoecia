/*
 * PnlLayout9Img.java
 *
 * Created on 17/05/2012, 09:40:00
 */
package com.ic.projects.laudoecia.view.laudoecia.layouts;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.lib.swing.plus.cps.MyJPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Box;
import org.jfree.ui.tabbedui.VerticalLayout;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlLayout12Img extends PnlLayoutImagens
{
    public PnlLayout12Img (LaudoeCiaMediator mediador)
    {
        super(mediador);
    }

    @Override
    public MyJPanel definirLayout ()
    {
        MyJPanel pnl = new MyJPanel(new VerticalLayout());
        pnl.add(Box.createVerticalStrut(50));

        FlowLayout layoutLine = new FlowLayout(FlowLayout.CENTER, 5, 0);

        MyJPanel pnlLinha1 = new MyJPanel(layoutLine);
        pnlLinha1.setBackground(Color.WHITE);
        pnlLinha1.add(createItemLayout(151, 113, 0));
        pnlLinha1.add(createItemLayout(151, 113, 1));
        pnlLinha1.add(createItemLayout(151, 113, 2));
        pnl.add(pnlLinha1);
        pnl.add(Box.createVerticalStrut(20));

        MyJPanel pnlLinha2 = new MyJPanel(layoutLine);
        pnlLinha2.setBackground(Color.WHITE);
        pnlLinha2.add(createItemLayout(151, 113, 3));
        pnlLinha2.add(createItemLayout(151, 113, 4));
        pnlLinha2.add(createItemLayout(151, 113, 5));
        pnl.add(pnlLinha2);
        pnl.add(Box.createVerticalStrut(20));

        MyJPanel pnlLinha3 = new MyJPanel(layoutLine);
        pnlLinha3.setBackground(Color.WHITE);
        pnlLinha3.add(createItemLayout(151, 113, 6));
        pnlLinha3.add(createItemLayout(151, 113, 7));
        pnlLinha3.add(createItemLayout(151, 113, 8));
        pnl.add(pnlLinha3);
        pnl.add(Box.createVerticalStrut(20));

        MyJPanel pnlLinha4 = new MyJPanel(layoutLine);
        pnlLinha4.setBackground(Color.WHITE);
        pnlLinha4.add(createItemLayout(151, 113, 9));
        pnlLinha4.add(createItemLayout(151, 113, 10));
        pnlLinha4.add(createItemLayout(151, 113, 11));
        pnl.add(pnlLinha4);

        return pnl;
    }

    @Override
    public String getHTML (int paginas)
    {
        if (isEmpty())
        {
            return "";
        }
        StringBuilder sb = new StringBuilder("");

        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">");

        sb.append("<tr><td align=\"right\">");
        sb.append(gerarImgHtmlTag(0,paginas,13));
        sb.append("</td><td align=\"center\" width=\"153\">");
        sb.append(gerarImgHtmlTag(1,paginas,13));
        sb.append("</td><td align=\"left\">");
        sb.append(gerarImgHtmlTag(2,paginas,13));
        sb.append("</td></tr>");

        sb.append("<tr><td align=\"right\">");
        sb.append(gerarImgHtmlTag(3,paginas,13));
        sb.append("</td><td align=\"center\">");
        sb.append(gerarImgHtmlTag(4,paginas,13));
        sb.append("</td><td align=\"left\">");
        sb.append(gerarImgHtmlTag(5,paginas,13));
        sb.append("</td></tr>");

        sb.append("<tr><td align=\"right\">");
        sb.append(gerarImgHtmlTag(6,paginas,13));
        sb.append("</td><td align=\"center\">");
        sb.append(gerarImgHtmlTag(7,paginas,13));
        sb.append("</td><td align=\"left\">");
        sb.append(gerarImgHtmlTag(8,paginas,13));
        sb.append("</td></tr>");

        sb.append("<tr><td align=\"right\">");
        sb.append(gerarImgHtmlTag(9,paginas,13));
        sb.append("</td><td align=\"center\">");
        sb.append(gerarImgHtmlTag(10,paginas,13));
        sb.append("</td><td align=\"left\">");
        sb.append(gerarImgHtmlTag(11,paginas,13));
        sb.append("</td></tr>");

        sb.append("</table>");
        return sb.toString();
    }

}
