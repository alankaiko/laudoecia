/*
 * PnlImgMiniatura.java
 *
 * Created on 13/07/2012, 15:04:20
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.PnlImagem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.border.Border;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class PnlImgMiniatura extends MyJPanel
{
    
    private PnlImagem pnlImgMin;
    private MyJPanel pnlSelect = new MyJPanel(new BorderLayout());
    private byte[] imagem;
    private Color normalBg = this.getBackground();
    private Color selectedBg = new Color(0, 102, 204);
    private boolean selected = false;
    private ScrpMiniaturas scrp;

    PnlImgMiniatura (byte[] img, ScrpMiniaturas scrp, Dimension tamImg)
    {
        this(img, scrp, tamImg, null);
    }
    
    PnlImgMiniatura (byte[] img, ScrpMiniaturas scrp, Dimension tamImg, MouseListener mouseList)
    {
        super(new BorderLayout());
        this.scrp = scrp;
        imagem = img;
        if (mouseList == null)
        {
            pnlImgMin = new PnlImagem();
        }
        else
        {
            pnlImgMin = new PnlImagem(mouseList, "Selecionar Imagem");
        }
        pnlImgMin.setMinimumSize(tamImg);
        pnlImgMin.setPreferredSize(tamImg);
        pnlImgMin.setMaximumSize(tamImg);
        pnlImgMin.setSize(tamImg);
        pnlImgMin.setImagem(imagem);
        pnlSelect.add(pnlImgMin, BorderLayout.CENTER);
        add(pnlSelect, BorderLayout.CENTER);
    }

    void setSelected (boolean select)
    {
        if (selected != select)
        {
            if (select)
            {
                pnlSelect.setBackground(selectedBg);
                scrp.atualizarScroll(this);
            }
            else
            {
                pnlSelect.setBackground(normalBg);
            }
            selected = select;
        }
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    void setImagem (byte[] imagem)
    {
        this.imagem = imagem;
        pnlImgMin.setImagem(imagem);
    }
    
    void configurar (Border pnlSelectBorder, Border border)
    {
        pnlSelect.setBorder(pnlSelectBorder);
        setBorder(border);
    }

}
