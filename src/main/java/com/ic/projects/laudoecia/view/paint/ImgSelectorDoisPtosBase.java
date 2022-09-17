/*
 * ImgSelectorDoisPtosBase.java
 *
 * Created on 13/05/2011, 10:29:19
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class ImgSelectorDoisPtosBase extends DesenhistaDoisPtosBase implements ImgSelector
{
    
    private Command undoableAction;
    private Shape shape;

    ImgSelectorDoisPtosBase (Painter decorator)
    {
        super(decorator, ELIPSE);
        stroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                                 BasicStroke.JOIN_MITER, 10f, new float[]
                {
                    10f
                }, 0);
    }

    @Override
    void setFillShapes (boolean fillShapes)
    {
        // fillshapes deve ser sempre false
    }

    @Override
    void setAction (int action)
    {
        switch (action)
        {
            case RECTANGLE:
            case ROUND_RECTANGLE:
            case ELIPSE:
            case CIRCLE:
            case SQUARE:
            case ROUND_SQUARE:
                super.setAction(action);
                break;
            default:
                super.setAction(RECTANGLE);
                break;
        }
    }

    @Override
    void setStroke (float width)
    {
        stroke = new BasicStroke(width);
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {

        Point2D posAtualDoMouse = e.getPoint();

        if (posIniDoMouse == null || posIniDoMouse.equals(posAtualDoMouse))
        {
            posIniDoMouse = null;
            return;
        }

        if (undoableAction != null)
        {
            undoableAction.undo(painter.getImage());
            painter.removeUndoableAction(undoableAction);
        }

        shape = shapeCreator.createShape(posIniDoMouse, posAtualDoMouse);
        BufferedImage b = painter.getImage();
        BasicStroke bs = new BasicStroke(stroke.getLineWidth() + 5f);
        Shape shapeToMap = bs.createStrokedShape(shape);
        Graphics2D g = b.createGraphics();
        g.setColor(color);

        undoableAction = doFinalAction(g, shape, Utils.createMap(shapeToMap, b));
        painter.addCommand(undoableAction);

        g.dispose();

        painter.painting();
        posIniDoMouse = null;

    }

    /**
     * Desenha o shape desejado, criando um undoableAction no processo
     *
     * @param g o objeto para criacao do desenho
     * @param shape o objeto a ser desenhado
     * @param mapa o mapa com os pixels de cada ponto que sera sofrera
     * alteracoes (utilizado para a criacao do undoableAction
     * @return o undoableAction criado
     */
    private InheritedUndoableAction doFinalAction (Graphics2D g, Shape shape, HashMap<Point2D, Integer> mapa)
    {
        InheritedUndoableAction iua = new InheritedUndoableAction(color, stroke, xorColor, shape, mapa);
        g.setStroke(stroke);
        g.draw(shape);
        return iua;
    }

    @Override
    public boolean hasSelection ()
    {
        return shape != null;
    }

    @Override
    public Shape getSelectedShapeFromImage ()
    {
        return shape;
    }

    private class InheritedUndoableAction extends MyCommand
    {
        private Shape savedShape;

        InheritedUndoableAction (Color color, Stroke stroke, Color xorColor, Shape shape, HashMap<Point2D, Integer> mapa)
        {
            super(color, stroke, xorColor, shape, mapa);
            savedShape = shape;
        }

        @Override
        public void undo (BufferedImage b)
        {
            super.undo(b);
            shape = null;
        }

        @Override
        public void redo (BufferedImage b)
        {
            super.redo(b);
            shape = savedShape;
        }

    }

}