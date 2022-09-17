/*
 * DesenhistaDoisPtosBase.java
 *
 * Created on 09/05/2011, 08:56:03
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@SuppressWarnings({"PackageVisibleField", "PackageVisibleInnerClass", "OverridableMethodCallInConstructor" })
class DesenhistaDoisPtosBase extends Desenhista
{

    Point2D posIniDoMouse;
    Point2D posAnteriorDoMouse;
    TwoPointBasedShapeCreator shapeCreator;

    private int action = LINE;
    private boolean fillShapes = false;

    // <editor-fold defaultstate="collapsed" desc="SHAPES">

    static final int LINE = 0;
    static final int RECTANGLE = 1;
    static final int ROUND_RECTANGLE = 2;
    static final int ELIPSE = 3;
    static final int CIRCLE = 4;
    static final int SQUARE = 5;
    static final int ROUND_SQUARE = 6;
    static final int ARROW = 7;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ShapeCreators">

    private TwoPointBasedShapeCreator lineCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            return new Line2D.Double(p1, p2);
        }

        @Override
        public boolean isFillable ()
        {
            return false;
        }

    };

    private TwoPointBasedShapeCreator rectCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            Rectangle2D r = new Rectangle2D.Double();
            r.setFrameFromDiagonal(p1, p2);
            return r;
        }

        @Override
        public boolean isFillable ()
        {
            return true;
        }

    };

    private TwoPointBasedShapeCreator roundRectCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            RoundRectangle2D r = new RoundRectangle2D.Double(0, 0, 0, 0, 20, 20);
            r.setFrameFromDiagonal(p1, p2);
            return r;
        }

        @Override
        public boolean isFillable ()
        {
            return true;
        }

    };

    private TwoPointBasedShapeCreator elipseCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            Ellipse2D elipse = new Ellipse2D.Double();
            elipse.setFrameFromDiagonal(p1, p2);
            return elipse;
        }

        @Override
        public boolean isFillable ()
        {
            return true;
        }

    };

    private TwoPointBasedShapeCreator circleCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            Ellipse2D elipse = new Ellipse2D.Double();
            elipse.setFrameFromDiagonal(p1, Utils.makeSquare(p1, p2));
            return elipse;
        }

        @Override
        public boolean isFillable ()
        {
            return true;
        }

    };

    private TwoPointBasedShapeCreator squareCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            Rectangle2D r = new Rectangle2D.Double();
            r.setFrameFromDiagonal(p1, Utils.makeSquare(p1, p2));
            return r;
        }

        @Override
        public boolean isFillable ()
        {
            return true;
        }

    };

    private TwoPointBasedShapeCreator roundSquareCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            RoundRectangle2D r = new RoundRectangle2D.Double(0, 0, 0, 0, 20, 20);
            r.setFrameFromDiagonal(p1, Utils.makeSquare(p1, p2));
            return r;
        }

        @Override
        public boolean isFillable ()
        {
            return true;
        }

    };

    private TwoPointBasedShapeCreator arrowCreator = new TwoPointBasedShapeCreator()
    {
        @Override
        public Shape createShape (Point2D p1, Point2D p2)
        {
            GeneralPath arrow = new GeneralPath();
            arrow.moveTo(p1.getX(), p1.getY());
            Point2D ptoAux1 = getP1(p1, p2);
            Point2D ptoAux2 = getP2(p1, p2, ptoAux1);
            Point2D ptoAux3 = getP3(p1, p2, ptoAux1);
            arrow.lineTo(ptoAux1.getX(), ptoAux1.getY());
            arrow.lineTo(ptoAux2.getX(), ptoAux2.getY());
            arrow.lineTo(p2.getX(), p2.getY());
            arrow.lineTo(ptoAux3.getX(), ptoAux3.getY());
            arrow.lineTo(ptoAux1.getX(), ptoAux1.getY());
            return arrow;
        }

        @Override
        public boolean isFillable ()
        {
            return false;
        }

        private Point2D getP1 (Point2D p1, Point2D p2)
        {
            // essas variaveis controlam o sinal da soma dos valores de x e de y
            int sinalX = Math.max(p1.getX(), p2.getX()) == p2.getX() ? -1 : +1;
            int sinalY = Math.max(p1.getY(), p2.getY()) == p2.getY() ? -1 : +1;

            return new Point2D.Double(
                    p2.getX() + Math.abs(p2.getX() - p1.getX()) / 4 * sinalX,
                    p2.getY() + Math.abs(p2.getY() - p1.getY()) / 4 * sinalY);
        }

        private Point2D getP2 (Point2D p1, Point2D p2, Point2D p3)
        {

            // essas variaveis controlam o sinal da soma dos valores de x e de y
            int sinalX = (p2.getY() - p1.getY()) > 0 ? +1 : -1;
            int sinalY = (p2.getX() - p1.getX()) > 0 ? -1 : +1;

            double ladoTrianguloSobre2 = 5;//p3.distance(p2);
            double distTotal = p1.distance(p2);
            double cosTeta = Math.abs(p2.getY() - p1.getY()) / distTotal;
            double senTeta = Math.abs(p2.getX() - p1.getX()) / distTotal;

            Point2D resposta = new Point2D.Double(
                    p3.getX() + ladoTrianguloSobre2 * cosTeta * sinalX,
                    p3.getY() + ladoTrianguloSobre2 * senTeta * sinalY);

            return resposta;
        }

        private Point2D getP3 (Point2D p1, Point2D p2, Point2D p3)
        {

            // essas variaveis controlam o sinal da soma dos valores de x e de y
            int sinalX = (p2.getY() - p1.getY()) > 0 ? -1 : +1;
            int sinalY = (p2.getX() - p1.getX()) > 0 ? +1 : -1;

            double ladoTrianguloSobre2 = 5;//p3.distance(p2);
            double distTotal = p1.distance(p2);
            double cosTeta = Math.abs(p2.getY() - p1.getY()) / distTotal;
            double senTeta = Math.abs(p2.getX() - p1.getX()) / distTotal;

            Point2D resposta = new Point2D.Double(
                    p3.getX() + ladoTrianguloSobre2 * cosTeta * sinalX,
                    p3.getY() + ladoTrianguloSobre2 * senTeta * sinalY);

            return resposta;
        }

    };

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Private work">

    /**
     * Desenha o shape desejado, criando um undoableAction no processo
     *
     * @param g o objeto para criacao do desenho
     * @param shape o objeto a ser desenhado
     * @param mapa o mapa com os pixels de cada ponto que sera sofrera
     * alteracoes (utilizado para a criacao do undoableAction
     * @return o undoableAction criado
     */
    private MyCommand doFinalAction (Graphics2D g, Shape shape, HashMap<Point2D, Integer> mapa)
    {
        MyCommand mua = new MyCommand(color, stroke, xorColor, shape, mapa);
        if (fillShapes && shapeCreator.isFillable())
        {
            g.fill(shape);
            mua.setFill(true);
        }
        else
        {
            g.setStroke(stroke);
            g.draw(shape);
        }
        return mua;
    }

    /**
     * Desenha o shape temporario, que sera apagado no evento mouseRelease
     *
     * @param g o objeto para criacao do desenho
     * @param p1 o ponto inicial a ser passado para o shapeCreator
     * @param p2 o ponto final a ser passado para o shapeCreator
     */
    private void doTempAction (Graphics2D g, Point2D p1, Point2D p2)
    {
        Shape shape = shapeCreator.createShape(p1, p2);
        if (fillShapes && shapeCreator.isFillable())
        {
            g.fill(shape);
        }
        else
        {
            g.setStroke(stroke);
            g.draw(shape);
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Private abstraction">

    interface TwoPointBasedShapeCreator
    {
        Shape createShape (Point2D p1, Point2D p2);

        boolean isFillable ();

    }

    class MyCommand implements Command
    {

        private Color myColor;
        private Stroke myStroke;
        private Color myXorColor;
        private Shape myShape;
        private boolean fill = false;
        private HashMap<Point2D, Integer> mapa = new HashMap<>();

        MyCommand (Color color, Stroke stroke, Color xorColor, Shape shape, HashMap<Point2D, Integer> mapa)
        {
            this.myColor = color;
            this.myStroke = stroke;
            this.myXorColor = xorColor;
            this.myShape = shape;
            this.mapa = mapa;
        }

        void setFill (boolean fill)
        {
            this.fill = fill;
        }

        @Override
        public void undo (BufferedImage b)
        {
            for (Map.Entry<Point2D, Integer> en : mapa.entrySet())
            {
                Point2D p = en.getKey();
                Integer rgb = en.getValue();
                b.setRGB((int) p.getX(), (int) p.getY(), rgb);
            }
            Graphics2D g = b.createGraphics();
            g.setXORMode(myXorColor);
            g.setColor(myColor);
            if (fill)
            {
                g.fill(myShape);
            }
            else
            {
                g.setStroke(myStroke);
                g.draw(myShape);
            }
            g.dispose();
        }

        @Override
        public void redo (BufferedImage b)
        {

            Graphics2D g = b.createGraphics();
            g.setColor(myColor);
            g.setStroke(myStroke);
            if (fill)
            {
                g.fill(myShape);
            }
            else
            {
                g.draw(myShape);
            }
            g.dispose();

        }

    }

    // </editor-fold>

    DesenhistaDoisPtosBase (Painter decorator, int action)
    {
        super(decorator);
        setAction(action);
    }

    int getAction ()
    {
        return action;
    }

    void setAction (int action)
    {
        switch (action)
        {
            case LINE:
                shapeCreator = lineCreator;
                break;
            case RECTANGLE:
                shapeCreator = rectCreator;
                break;
            case ROUND_RECTANGLE:
                shapeCreator = roundRectCreator;
                break;
            case ELIPSE:
                shapeCreator = elipseCreator;
                break;
            case CIRCLE:
                shapeCreator = circleCreator;
                break;
            case SQUARE:
                shapeCreator = squareCreator;
                break;
            case ROUND_SQUARE:
                shapeCreator = roundSquareCreator;
                break;
            case ARROW:
                shapeCreator = arrowCreator;
                break;
            default:
                // parametro passado nao foi aceito, mantem o action atual
                return;
        }
        this.action = action;
    }

    void setFillShapes (boolean fillShapes)
    {
        this.fillShapes = fillShapes;
    }

    @Override
    public void mouseDragged (MouseEvent e)
    {

        Point posAtualDoMouse = e.getPoint();

        if (posIniDoMouse == null)
        {
            posIniDoMouse = posAtualDoMouse;
            posAnteriorDoMouse = posAtualDoMouse;
        }
        else if (!posIniDoMouse.equals(posAtualDoMouse))
        {

            Graphics2D g = painter.getGraphics();
            g.setColor(color);
            g.setXORMode(xorColor);
            if (!posIniDoMouse.equals(posAnteriorDoMouse))
            {
                // apaga o desenho anterior
                doTempAction(g, posIniDoMouse, posAnteriorDoMouse);
            }
            // desenha
            doTempAction(g, posIniDoMouse, posAtualDoMouse);
            g.dispose();
            posAnteriorDoMouse = posAtualDoMouse;
            painter.painting();

        }
        else
        {
        }

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

        Shape shape = shapeCreator.createShape(posIniDoMouse, posAtualDoMouse);
        Shape shapeToMap = shape;
        BufferedImage b = painter.getImage();
        if (!(shapeCreator.isFillable() && fillShapes))
        {
            BasicStroke bs = new BasicStroke(stroke.getLineWidth() + 5f);
            shapeToMap = bs.createStrokedShape(shape);
        }
        HashMap<Point2D, Integer> mapa = Utils.createMap(shapeToMap, b);
        Graphics2D g = b.createGraphics();
        g.setColor(color);
        painter.addCommand(doFinalAction(g, shape, mapa));

        g.dispose();

        painter.donePainting();
        posIniDoMouse = null;

    }

}