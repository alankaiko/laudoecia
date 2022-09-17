/*
 * ImgAdapterExtending.java
 *
 * Created on 03/05/2011, 09:58:27
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class ImgAdapterExtending implements ImgAdapter
{
    
    private JLabel imageLabel;

    ImgAdapterExtending (JLabel imageLabel)
    {
        this.imageLabel = imageLabel;
    }

    @Override
    public BufferedImage adaptImage (BufferedImage image)
    {

        if (image == null || image.getType() == BufferedImage.TYPE_CUSTOM)
        {
            return null;
        }

        int desirableWidth = imageLabel.getWidth();
        int desirableHeight = imageLabel.getHeight();

        BufferedImage resposta = new BufferedImage(
                desirableWidth, desirableHeight, image.getType());
        Graphics2D g = resposta.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                           RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, desirableWidth, desirableHeight, null);
        g.dispose();

        return resposta;

    }

}
