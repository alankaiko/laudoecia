/*
 * Painter.java
 *
 * Created on 06/05/2011, 10:50:13
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class Painter implements MouseListener, MouseMotionListener
{

    private PnlPaint pnlPaint;
    private JLabel label;
    private Desenhista desenhista;
    private ImgSelector imgSelector;
    private ArrayDeque<Command> undoStack = new ArrayDeque<>();
    private ArrayDeque<Command> redoStack = new ArrayDeque<>();

    // <editor-fold defaultstate="collapsed" desc="Desenhistas">

    private DesenhistaCaneta desenhistaCaneta = new DesenhistaCaneta(this);

    private DesenhistaDoisPtosBase desenhistaDoisPtosBase =
                                   new DesenhistaDoisPtosBase(this, DesenhistaDoisPtosBase.LINE);

    private DesenhistaDeTexto desenhistaDeTexto = new DesenhistaDeTexto(this);

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Img selectors">

    private ImgSelectorDoisPtosBase selecionaImgDoisPtosBase = new ImgSelectorDoisPtosBase(this);

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ACTIONS">

    public static final int DRAW_LINE = 0;
    public static final int DRAW_RECTANGLE = 1;
    public static final int DRAW_ROUND_RECTANGLE = 2;
    public static final int DRAW_ELIPSE = 3;
    public static final int DRAW_CIRCLE = 4;
    public static final int DRAW_SQUARE = 5;
    public static final int DRAW_ROUND_SQUARE = 6;
    public static final int DRAW_ARROW = 7;
    public static final int FREE_DRAWING_PEN = 8;
    public static final int ADD_TEXT = 9;
    public static final int SELECT_IMAGE = 10;

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FILTROS">

    public static final int BRIGHTNESS = 11;
    public static final int CONTRAST = 12;
    public static final int COLOR = 13;
    public static final int SATURATION = 14;

    // </editor-fold>

    public Painter (PnlPaint pnlPaint)
    {
        if (pnlPaint == null)
        {
            throw new NullPointerException("PnlImagem não deve ser null");
        }
        this.pnlPaint = pnlPaint;
        this.label = pnlPaint.getLblImagem();
        label.addMouseListener(this);
        label.addMouseMotionListener(this);
        desenhista = desenhistaDoisPtosBase;
        imgSelector = selecionaImgDoisPtosBase;
        pnlPaint.addListener(new Runnable() {
            @Override
            public void run ()
            {
                undoStack.clear();
                redoStack.clear();
            }

        });
    }

    // <editor-fold defaultstate="collapsed" desc="Public">

    public void aplicarFiltro (int filtro, float valor)
    {
        if (imgSelector.hasSelection())
        {
            pnlPaint.setSelection(imgSelector.getSelectedShapeFromImage());
            pnlPaint.setFilterSelection(true);
        }
        else
        {
            pnlPaint.setSelection(null);
            pnlPaint.setFilterSelection(false);
        }
        switch (filtro)
        {
            case BRIGHTNESS:
                pnlPaint.setarBrilho(valor);
                pnlPaint.repaint();
                break;
            case CONTRAST:
                pnlPaint.setarContraste(valor);
                pnlPaint.repaint();
                break;
            case COLOR:
                pnlPaint.setarCor(valor);
                pnlPaint.repaint();
                break;
            case SATURATION:
                pnlPaint.setarSaturacao(valor);
                pnlPaint.repaint();
                break;
        }
    }

    public void setAction (int action)
    {
        switch (action)
        {
            case DRAW_LINE:
                desenhistaDoisPtosBase.setAction(DRAW_LINE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_RECTANGLE:
                desenhistaDoisPtosBase.setAction(DRAW_RECTANGLE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_ROUND_RECTANGLE:
                desenhistaDoisPtosBase.setAction(DRAW_ROUND_RECTANGLE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_ELIPSE:
                desenhistaDoisPtosBase.setAction(DRAW_ELIPSE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_CIRCLE:
                desenhistaDoisPtosBase.setAction(DRAW_CIRCLE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_SQUARE:
                desenhistaDoisPtosBase.setAction(DRAW_SQUARE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_ROUND_SQUARE:
                desenhistaDoisPtosBase.setAction(DRAW_ROUND_SQUARE);
                desenhista = desenhistaDoisPtosBase;
                break;
            case DRAW_ARROW:
                desenhistaDoisPtosBase.setAction(DRAW_ARROW);
                desenhista = desenhistaDoisPtosBase;
                break;
            case FREE_DRAWING_PEN:
                desenhista = desenhistaCaneta;
                break;
            case ADD_TEXT:
                desenhista = desenhistaDeTexto;
                break;
            case SELECT_IMAGE:
                selecionaImgDoisPtosBase.setAction(desenhistaDoisPtosBase.getAction());
                desenhista = selecionaImgDoisPtosBase;
                break;
            default:
        }
    }

    public void setFillOption (boolean fillOption)
    {
        desenhistaDoisPtosBase.setFillShapes(fillOption);
    }

    public void setStroke (float stroke)
    {
        desenhistaDoisPtosBase.setStroke(stroke);
        desenhistaCaneta.setStroke(stroke);
    }

    public void setColor (Color color)
    {
        desenhistaDoisPtosBase.setDrawingColor(color);
        desenhistaCaneta.setDrawingColor(color);
        desenhistaDeTexto.setDrawingColor(color);
    }

    public void setFontSource (FontSource fontSource)
    {
        desenhistaDeTexto.setFontSource(fontSource);
    }

    public void undo ()
    {
        if (!undoStack.isEmpty())
        {
            Command undo = undoStack.pop();
            redoStack.push(undo);
            undo.undo(getImage());
            donePainting();
        }
    }

    public void redo ()
    {
        if (!redoStack.isEmpty())
        {
            Command redo = redoStack.pop();
            undoStack.push(redo);
            redo.redo(getImage());
            donePainting();
        }
    }

    // </editor-fold>

    private boolean labelPossuiImagem ()
    {
        if (label == null)
        {
            return false;
        }
        else if (label.getIcon() == null)
        {
            return false;
        }
        else if (!(label.getIcon() instanceof ImageIcon))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    Graphics2D getGraphics ()
    {
        return getImage().createGraphics();
    }

    BufferedImage getImage ()
    {
        return pnlPaint.getBufferedImg();
    }

    JLabel getLabel ()
    {
        return label;
    }

    void setLabelCursor (Cursor cursor)
    {
        label.setCursor(cursor);
    }

    void painting ()
    {
        pnlPaint.painting();
    }

    void donePainting ()
    {
        pnlPaint.donePainting();
    }

    void addCommand (Command action)
    {
        undoStack.push(action);
    }

    void removeUndoableAction (Command action)
    {
        undoStack.remove(action);
        redoStack.remove(action);
    }

    // <editor-fold defaultstate="collapsed" desc="Listeners">

    @Override
    public void mouseClicked (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mouseExited(e);
        }
    }

    @Override
    public void mouseDragged (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved (MouseEvent e)
    {
        if (labelPossuiImagem())
        {
            desenhista.mouseMoved(e);
        }
    }

    // </editor-fold>

}