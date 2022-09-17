/*
 * Desenhista.java
 *
 * Created on 06/05/2011, 16:44:12
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@SuppressWarnings({"NoopMethodInAbstractClass", "PackageVisibleField"})
abstract class Desenhista implements MouseListener, MouseMotionListener
{
    
    Painter painter;
    Color color = Color.BLACK;
    Color xorColor = Color.GRAY;
    BasicStroke stroke = new BasicStroke(1);

    Desenhista (Painter decorator)
    {
        this.painter = decorator;
    }

    void setDrawingColor (Color drawingColor)
    {
        this.color = drawingColor;
        if (xorColor.equals(color))
        {
            if (color.equals(Color.GRAY))
            {
                xorColor = Color.WHITE;
            }
            else
            {
                xorColor = Color.GRAY;
            }
        }
    }

    void setStroke (float width)
    {
        stroke = new BasicStroke(width);
    }

    @Override
    public void mouseClicked (MouseEvent e)
    {
    }

    @Override
    public void mouseEntered (MouseEvent e)
    {
    }

    @Override
    public void mouseExited (MouseEvent e)
    {
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {
    }

    @Override
    public void mouseDragged (MouseEvent e)
    {
    }

    @Override
    public void mouseMoved (MouseEvent e)
    {
    }

}
