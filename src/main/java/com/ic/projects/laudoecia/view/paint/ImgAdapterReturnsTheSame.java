/*
 * ImgAdapterReturnsTheSame.java
 *
 * Created on 16/05/2011, 08:36:38
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.image.BufferedImage;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class ImgAdapterReturnsTheSame implements ImgAdapter
{
    
    @Override
    public BufferedImage adaptImage (BufferedImage image)
    {
        return image;
    }

}
