/*
 * BlueScrollBarUI.java
 *
 * Created on 10/05/2012, 14:58:15
 */
package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BlueScrollBarUI extends BasicScrollBarUI
{
    
    @Override
    protected JButton createDecreaseButton (int orientation)
    {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton (int orientation)
    {
        return createZeroButton();
    }

    @Override
    protected void configureScrollBarColors ()
    {
        LookAndFeel.installColors(scrollbar, "ScrollBar.background",
                                  "ScrollBar.foreground");
        Color blue = new Color(0, 102, 204);
        thumbHighlightColor = blue;
        thumbLightShadowColor = blue;
        thumbDarkShadowColor = blue;
        thumbColor = blue;
        trackColor = Color.GRAY;
        trackHighlightColor = Color.DARK_GRAY;
    }

    @Override
    public Dimension getPreferredSize (JComponent c)
    {
        return new Dimension(7, 7);
    }

    private JButton createZeroButton ()
    {
        JButton jbutton = new JButton();
        jbutton.setPreferredSize(new Dimension(0, 0));
        return jbutton;
    }

}
