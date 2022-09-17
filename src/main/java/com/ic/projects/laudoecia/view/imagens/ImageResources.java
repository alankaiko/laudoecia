/*
 * ImageResources.java
 *
 * Created on 13/01/2012, 10:05:01
 */
package com.ic.projects.laudoecia.view.imagens;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Danilo Brito
 */
public class ImageResources
{

    private ImageResources ()
    {
        super();
    }

    public static URL getUrlImagem (String imagem)
    {
        return ImageResources.class.getResource("/images/" + imagem);
    }

    public static Image getImage (String imagem)
    {
        return Toolkit.getDefaultToolkit().getImage(getUrlImagem(imagem));
    }

    public static Icon getIcon (String imagem)
    {
        try
        {
            return new ImageIcon(getUrlImagem(imagem));
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
