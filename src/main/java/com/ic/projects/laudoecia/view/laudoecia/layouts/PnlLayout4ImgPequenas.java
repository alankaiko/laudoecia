/*
 * PnlLayout4ImgPequenas.java
 *
 * Created on 17/05/2012, 09:30:19
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
public class PnlLayout4ImgPequenas extends PnlLayoutImagens
{
    public PnlLayout4ImgPequenas (LaudoeCiaMediator mediador)
    {
        super(mediador);
    }

    @Override
    public MyJPanel definirLayout ()
    {
        MyJPanel pnl = new MyJPanel(new VerticalLayout());
        pnl.add(Box.createVerticalStrut(50));

        FlowLayout layoutLine = new FlowLayout(FlowLayout.CENTER, 10, 0);

        MyJPanel pnlLinha1 = new MyJPanel(layoutLine);
        pnlLinha1.setBackground(Color.WHITE);
        pnlLinha1.add(createItemLayout(189, 142, 0));
        pnlLinha1.add(createItemLayout(189, 142, 1));
        pnl.add(pnlLinha1);
        pnl.add(Box.createVerticalStrut(20));

        MyJPanel pnlLinha2 = new MyJPanel(layoutLine);
        pnlLinha2.setBackground(Color.WHITE);
        pnlLinha2.add(createItemLayout(189, 142, 2));
        pnlLinha2.add(createItemLayout(189, 142, 3));
        pnl.add(pnlLinha2);

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

        sb.append( "<tr><td align=\"right\">");
        sb.append(gerarImgHtmlTag(0,paginas,5));
        sb.append( "</td><td align=\"left\">");
        sb.append(gerarImgHtmlTag(1,paginas,5));
        sb.append("</td></tr>");

        sb.append( "<tr><td align=\"right\">");
        sb.append(gerarImgHtmlTag(2,paginas,5));
        sb.append( "</td><td align=\"left\">");
        sb.append(gerarImgHtmlTag(3,paginas,5));
        sb.append("</td></tr>");

        sb.append("</table>");
        return sb.toString();
    }

}
