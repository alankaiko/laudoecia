/*
 * PnlLayout3Img.java
 *
 * Created on 17/05/2012, 09:16:05
 */
package com.ic.projects.laudoecia.view.laudoecia.layouts;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.lib.swing.plus.cps.MyJPanel;
import javax.swing.Box;
import org.jfree.ui.tabbedui.VerticalLayout;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlLayout3Img extends PnlLayoutImagens
{
    public PnlLayout3Img (LaudoeCiaMediator mediador)
    {
        super(mediador);
    }

    @Override
    public MyJPanel definirLayout ()
    {
        MyJPanel pnl = new MyJPanel(new VerticalLayout());
        pnl.add(Box.createVerticalStrut(50));
        pnl.add(createItemLayout(227, 170, 0));
        pnl.add(Box.createVerticalStrut(20));
        pnl.add(createItemLayout(227, 170, 1));
        pnl.add(Box.createVerticalStrut(20));
        pnl.add(createItemLayout(227, 170, 2));
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

        sb.append( "<tr><td align=\"center\">");
        sb.append(gerarImgHtmlTag(0,paginas,4));
        sb.append("</td></tr>");

        sb.append( "<tr><td align=\"center\">");
        sb.append(gerarImgHtmlTag(1,paginas,4));
        sb.append("</td></tr>");

        sb.append( "<tr><td align=\"center\">");
        sb.append(gerarImgHtmlTag(2,paginas,4));
        sb.append("</td></tr>");

        sb.append("</table>");
        return sb.toString();
    }

}
