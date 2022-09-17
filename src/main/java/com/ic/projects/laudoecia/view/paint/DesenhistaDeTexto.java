/*
 * DesenhistaDeTexto.java
 *
 * Created on 12/05/2011, 10:40:58
 */
package com.ic.projects.laudoecia.view.paint;

import com.lib.swing.plus.cps.MyJTextArea;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.GlyphVector;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DesenhistaDeTexto extends Desenhista
{
    
    private FontSource nullFontSource = new FontSource() {
        
        @Override
        public Font getFonte ()
        {
            return null;
        }
    };
    private FontSource fontSource = nullFontSource;
    private TxtArea txtArea = new TxtArea();
    private int x;
    private int y;

    DesenhistaDeTexto (Painter decorator)
    {
        super(decorator);
    }

    void setFontSource (FontSource fontSource)
    {
        if (fontSource == null)
        {
            this.fontSource = nullFontSource;
        }
        else
        {
            this.fontSource = fontSource;
        }
    }

    @Override
    public void mouseClicked (MouseEvent e)
    {
        if (txtArea.isFocusOwner())
        {
            doneEditing();
        }
        else
        {
            x = e.getX();
            y = e.getY();
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    JLabel label = painter.getLabel();
                    label.setLayout(null);
                    label.remove(txtArea);
                    label.add(txtArea);
                    Font font = getFont();
                    FontMetrics fontMetrics = txtArea.getFontMetrics(font);
                    txtArea.setLocation(x - 6, y - fontMetrics.getHeight() - 3);
                    txtArea.setFont(getFont());
                    txtArea.setForeground(color);
                    txtArea.setText("");
                    txtArea.requestFocusInWindow();
                    label.revalidate();
                }

            });
        }
    }
    
    private void doneEditing ()    
    {
        painter.getLabel().remove(txtArea);
        paint(txtArea.getText());
        txtArea.setText("");
    }
    
    private void paint (String texto)    
    {
        
        if (texto == null || texto.isEmpty()) { return; }
        
        Font font = getFont();
        
        BufferedImage bi = painter.getImage();
        Graphics2D g2d = bi.createGraphics();

        GlyphVector gv = font.createGlyphVector(g2d.getFontRenderContext(), texto);
        Shape shape = gv.getOutline(x, y);
        BasicStroke bs = new BasicStroke(5F);
        painter.addCommand(new MyCommand(x, y, font,
                                           color, texto, Utils.createMap(bs.createStrokedShape(shape), bi)));

        g2d.setColor(color);
        g2d.setFont(font);
        g2d.drawString(texto, x, y);
        g2d.dispose();
        painter.donePainting();
    }
    
    private Font getFont ()
    {
        Font font = fontSource.getFonte();
        return font == null ? txtArea.getFont() : font;
    }

    private class MyCommand implements Command
    {
        
        private Color myColor;
        private String myText;
        private Font myFont;
        private int myX;
        private int myY;

        private HashMap<Point2D, Integer> myMap = new HashMap<>();

        private MyCommand (int x, int y, Font font, Color myColor, String myText, HashMap<Point2D, Integer> mapa)
        {
            this.myX = x;
            this.myY = y;
            this.myFont = font;
            this.myColor = myColor;
            this.myText = myText;
            this.myMap = mapa;
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
        }

        @Override
        public void redo (BufferedImage b)
        {
            Graphics2D g2d = b.createGraphics();
            g2d.setColor(myColor);
            g2d.setFont(myFont);
            g2d.drawString(myText, myX, myY);
            g2d.dispose();
        }

    }
    
    private class TxtArea extends MyJTextArea implements FocusListener
    {

        private TxtArea ()
        {
            addFocusListener(this);
            addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed (KeyEvent e)
                {
                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_ENTER:
                            doneEditing();
                            e.consume();
                            break;
                        default:
                    }
                }

                @Override
                public void keyReleased (KeyEvent e)
                {
                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_ESCAPE:
                            doneEditing();
                            e.consume();
                            break;
                        default:
                    }
                }
            });
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked (MouseEvent e)
                {
                    doneEditing();
                }
            });
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
            setSize(500, 100);
        }
        
        @Override
        public void focusGained (FocusEvent e)
        {
        }

        @Override
        public void focusLost (FocusEvent e)
        {
            doneEditing();
        }

        @Override
        protected void paintBorder (Graphics g)
        {
        }
        
    }
    
}