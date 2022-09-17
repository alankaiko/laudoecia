/*
 * PnlLayoutLaudoE4Img.java
 *
 * Created on 17/05/2012, 09:44:21
 */
package com.ic.projects.laudoecia.view.laudoecia.layouts;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import java.awt.*;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import org.jfree.ui.tabbedui.VerticalLayout;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlLayoutLaudoE4Img extends PnlLayoutImagens
{
    public PnlLayoutLaudoE4Img (LaudoeCiaMediator mediador)
    {
        super(mediador);
    }

    @Override
    public MyJPanel definirLayout ()
    {
        MyJPanel p = new MyJPanel(new VerticalLayout());
        p.add(Box.createVerticalStrut(50));

        MyJPanel pnl = new MyJPanel(new FlowLayout());
        pnl.setBackground(Color.WHITE);
        pnl.add(Box.createVerticalStrut(50));

        MyJPanel pnlLaudo = new MyJPanel(new BorderLayout());
        pnlLaudo.setBackground(Color.WHITE);
        pnlLaudo.setPreferredSize(new Dimension(350, 600));
        pnlLaudo.setBorder(new LineBorder(Color.LIGHT_GRAY));
        MyJLabel lblLaudo = new MyJLabel("Informações do Laudo");
        lblLaudo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLaudo.setForeground(Color.LIGHT_GRAY);
        lblLaudo.setHorizontalAlignment(SwingConstants.CENTER);
        pnlLaudo.add(lblLaudo, BorderLayout.CENTER);
        pnl.add(pnlLaudo);

        pnl.add(Box.createHorizontalStrut(10));

        MyJPanel pnlImagens = new MyJPanel(new VerticalLayout());
        pnlImagens.setBackground(Color.WHITE);
        pnlImagens.add(createItemLayout(151, 113, 0));
        pnlImagens.add(Box.createVerticalStrut(20));
        pnlImagens.add(createItemLayout(151, 113, 1));
        pnlImagens.add(Box.createVerticalStrut(20));
        pnlImagens.add(createItemLayout(151, 113, 2));
        pnlImagens.add(Box.createVerticalStrut(20));
        pnlImagens.add(createItemLayout(151, 113, 3));
        pnlImagens.add(Box.createVerticalStrut(80));
        pnl.add(pnlImagens);

        p.add(pnl);

        return p;
    }

    /**
     * Gera HTML do layout laudo e 4 imagens.
     * Substituir o html do laudo pelo parametro PnlLayoutImagens.TEXTO_LAUDO
     * @param paginas
     * @return
     */
    @Override
    public String getHTML (int paginas)
    {
        if (isEmpty())
        {
            return "";
        }

        StringBuilder sbTabelaImgs = new StringBuilder(200);
        sbTabelaImgs.append("<table width=\"100%\" border=\"0\" "
                + "cellspacing=\"0\" cellpadding=\"5\">");

        sbTabelaImgs.append( "<tr><td align=\"center\">");
        sbTabelaImgs.append(gerarImgHtmlTag(0,paginas,5));
        sbTabelaImgs.append("</td></tr>");

        sbTabelaImgs.append( "<tr><td align=\"center\">");
        sbTabelaImgs.append(gerarImgHtmlTag(1,paginas,5));
        sbTabelaImgs.append("</td></tr>");

        sbTabelaImgs.append( "<tr><td align=\"center\">");
        sbTabelaImgs.append(gerarImgHtmlTag(2,paginas,5));
        sbTabelaImgs.append("</td></tr>");

        sbTabelaImgs.append( "<tr><td align=\"center\">");
        sbTabelaImgs.append(gerarImgHtmlTag(3,paginas,5));
        sbTabelaImgs.append("</td></tr>");

        sbTabelaImgs.append("</table>");

        return getTabelaDivisao(sbTabelaImgs.toString());
    }

    public static String getTabelaDivisao (String tblImagens)
    {
        String html = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
                      + "<tr><td>" + TEXTO_LAUDO + "</td>"
                      + "<td width=\"5\">&nbsp;</td>"
                      + "<td width=\"163\" valign=\"top\">" + tblImagens + "</td>"
                      + "</tr></table>";
        return html;
    }

}
