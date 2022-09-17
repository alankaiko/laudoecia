/*
 * DesenhistaCaneta.java
 *
 * Created on 09/05/2011, 15:33:13
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DesenhistaCaneta extends Desenhista
{

    private Point2D posAnteriorDoMouse;
    private GeneralPath gp = new GeneralPath();

    DesenhistaCaneta (Painter decorator)
    {
        super(decorator);
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {

        painter.setLabelCursor(new Cursor(Cursor.WAIT_CURSOR));
        BufferedImage b = painter.getImage();
        Graphics2D g = b.createGraphics();
        g.setColor(color);
        g.setStroke(stroke);
        BasicStroke bs = new BasicStroke(stroke.getLineWidth() + 5f);
        painter.addCommand(new MyCommand(color, stroke, xorColor,
                                           Utils.createMap(bs.createStrokedShape(gp), b), gp));

        g.draw(gp);
        g.dispose();
        painter.painting();
        posAnteriorDoMouse = null;
        painter.setLabelCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        painter.donePainting();

    }

    @Override
    public void mouseDragged (MouseEvent e)
    {

        Point posAtualDoMouse = e.getPoint();

        if (posAnteriorDoMouse == null)
        {
            posAnteriorDoMouse = posAtualDoMouse;
            gp = new GeneralPath();
            gp.moveTo(posAtualDoMouse.getX(), posAtualDoMouse.getY());
        }
        else if (!posAnteriorDoMouse.equals(posAtualDoMouse))
        {

            Graphics2D g = painter.getGraphics();
            g.setColor(color);
            g.setXORMode(xorColor);
            g.setStroke(stroke);
            g.draw(gp);
            gp.lineTo(posAtualDoMouse.getX(), posAtualDoMouse.getY());
            g.draw(gp);
            g.dispose();

            posAnteriorDoMouse = posAtualDoMouse;
            painter.painting();

        }
        else
        {
        }

    }

    private class MyCommand implements Command
    {

        private HashMap<Point2D, Integer> myMap = new HashMap<>();
        private Color myColor;
        private Stroke myStroke;
        private Color myXorColor;
        private Shape myShape;

        MyCommand (Color myColor, Stroke myStroke, Color myXorColor,
                   HashMap<Point2D, Integer> mapa, Shape shape)
        {
            this.myColor = myColor;
            this.myStroke = myStroke;
            this.myXorColor = myXorColor;
            this.myMap.putAll(mapa);
            this.myShape = shape;
        }

        @Override
        public void undo (BufferedImage b)
        {
            for (Map.Entry<Point2D, Integer> en : myMap.entrySet())
            {
                Point2D p = en.getKey();
                Integer rgb = en.getValue();
                b.setRGB((int) p.getX(), (int) p.getY(), rgb);
            }
            Graphics2D g = b.createGraphics();
            g.setColor(myColor);
            g.setStroke(myStroke);
            g.setXORMode(myXorColor);
            g.draw(myShape);
            g.dispose();
        }

        @Override
        public void redo (BufferedImage b)
        {
            Graphics2D g = b.createGraphics();
            g.setColor(color);
            g.setStroke(stroke);
            g.draw(myShape);
            g.dispose();
        }

    }

}
