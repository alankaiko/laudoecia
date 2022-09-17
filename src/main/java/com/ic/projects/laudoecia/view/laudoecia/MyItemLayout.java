/*
 * MyItemLayout.java
 *
 * Created on 15/05/2012, 09:57:59
 */
package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutImagens;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BtnSoImagem;
import com.lib.swing.plus.utils.PnlImagem;
import com.lib.swing.utils.SwingUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class MyItemLayout extends MyJPanel
{
    private PnlImagem pnlImg;
    private PnlLayoutImagens pnlLayout;
    private int indexNoLayout;
    private BtnSoImagem btnRemover;
    private byte[] imagem;
    private boolean escondeRemover = true;
    private int largura;
    private int altura;
    private LaudoeCiaMediator mediador;
    private ConversorByteArrayImage cnv = new ConversorByteArrayImage();

    public MyItemLayout (LaudoeCiaMediator mediador, int largura, int altura, PnlLayoutImagens pnlLayout, int indexNoLayout)
    {
        this.mediador = mediador;
        this.pnlLayout = pnlLayout;
        this.indexNoLayout = indexNoLayout;
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        pnlImg = new PnlImagem(acaoPnlImagem, "Colocar imagem selecionada");
        this.largura = largura;
        this.altura = altura;
        Dimension d = new Dimension(largura, altura);
        pnlImg.setSize(d);
        pnlImg.setUsarPreferedSize(true);
        pnlImg.setPreferredSize(d);
        pnlImg.setMaximumSize(d);
        pnlImg.setMinimumSize(d);
        pnlImg.setBorder(new LineBorder(new Color(0, 102, 204)));
        pnlImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRemover = new BtnSoImagem(ImageResources.getIcon(ImagensLC.FECHAR));
        btnRemover.setToolTipText("Remover imagem");
        btnRemover.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnRemoverAction();
            }

        });
        btnRemover.addMouseListener(acaoMouseBtnRemover);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridx = 0;
        c.gridheight = 2;
        add(pnlImg, c);
        c.gridheight = 1;
        c.gridx = 1;
        add(btnRemover, c);
        c.gridy = 1;
        c.weighty = 1.0;
        add(Box.createHorizontalStrut(12), c);
        btnRemover.setVisible(false);
    }

    private MouseListener acaoPnlImagem = new MouseAdapter()
    {
        @Override
        public void mouseEntered (MouseEvent e)
        {
            escondeRemover = false;
            btnRemover.setVisible(true);
        }

        @Override
        public void mouseExited (MouseEvent e)
        {
            btnRemoverHideAction();
        }

        @Override
        public void mouseReleased (MouseEvent e)
        {
            switch (e.getButton())
            {
                case MouseEvent.BUTTON1:
                    pnlImgClickAction();
                    break;
                case MouseEvent.BUTTON3:
                    try
                    {
                        importarImagem();
                    }
                    catch (Exception ex)
                    {
                        PnlLaudoeCia.getInstance().mostrarMsgErro(ex.getMessage());
                    }
                    break;
            }
        }

    };

    private MouseListener acaoMouseBtnRemover = new MouseAdapter()
    {
        @Override
        public void mouseEntered (MouseEvent e)
        {
            escondeRemover = false;
        }

        @Override
        public void mouseExited (MouseEvent e)
        {
            btnRemoverHideAction();
        }

    };

    private void btnRemoverHideAction ()
    {
        escondeRemover = true;
        new SwingWorker<Void, Void>()
        {
            @Override
            protected Void doInBackground () throws Exception
            {
                try
                {
                    Thread.sleep(1000);
                    if (escondeRemover)
                    {
                        btnRemover.setVisible(false);
                    }
                }
                catch (InterruptedException ex)
                {
                }
                return null;
            }

        }.execute();
    }

    private void btnRemoverAction ()
    {
        setImagem(null);
    }

    private void pnlImgClickAction ()
    {
        byte[] selectedImagem = mediador.getImagemAtual();
        setImagem(selectedImagem);
    }

    private void importarImagem () throws Exception
    {
        ProcDoAtd p = mediador.getProcSelecionado();
        if (p != null)
        {
            byte[] imagem = getImg(p.getProcMedico());
            if (imagem == null)
            {
                return;
            }
            BufferedImage bi = cnv.convertForward(imagem);
            File file = File.createTempFile("laudoecia", "img");
            file.deleteOnExit();
            ImageIO.write(bi, "png", file);
            ProcessBuilder pb = new ProcessBuilder(Arrays.asList(
                    "mspaint", file.getCanonicalPath()));
            pb.redirectErrorStream(true);
            if (pb.start().waitFor() == 0)
            {
            }
            else
            {
                throw new IOException("Erro ao iniciar o paint!");
            }
            imgFoiEditadaNoPaint(cnv.convertReverse(file));
        }
    }

    private byte[] getImg (ProcMedico p)
    {
        byte[] img = pnlImg.getImagem();
        if (img != null)
        {
            return img;
        }
        byte[] imagem1 = p.getImagem1();
        byte[] imagem2 = p.getImagem2();
        if (imagem1 == null && imagem2 == null)
        {
            return null;
        }
        if (imagem1 == null && imagem2 != null)
        {
            return imagem2;
        }
        if (imagem1 != null && imagem2 == null)
        {
            return imagem1;
        }
        Dlg d = new Dlg(imagem1, imagem2);
        d.setVisible(true);
        return d.getSel();
    }

    private byte[] getImgAreaTrans ()
    {
        // get the system clipboard
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // get the contents on the clipboard in a transferable object
        Transferable clipboardContents = systemClipboard.getContents(null);
        // check if clipboard is empty
        if (clipboardContents == null)
        {
        }
        else
        {
            try
            {
                if (clipboardContents.isDataFlavorSupported(
                        DataFlavor.imageFlavor))
                {
                    BufferedImage resposta = (BufferedImage) clipboardContents.getTransferData(DataFlavor.imageFlavor);
                    return cnv.convertReverse(resposta);
                }
            }
            catch (Exception ufe)
            {
            }
        }
        SwingUtils.mostrarAviso(PnlLaudoeCia.getInstance(), ""
                 + "Copie uma imagem para a área de transferência do Windows!");
        return null;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public byte[] getImagem ()
    {
        return imagem;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setImagem (byte[] imagem)
    {
        if (imagem == null)
        {
            mediador.removerImgDoQuadro(pnlLayout.getIndexPagina(), indexNoLayout);
            this.imagem = imagem;
            pnlImg.setImagem(imagem);
        }
        else if (mediador.colocarImgSelNoQuadro(pnlLayout.getIndexPagina(), indexNoLayout))
        {
            this.imagem = imagem;
            pnlImg.setImagem(imagem);
        }
    }

    public int getAltura ()
    {
        return altura;
    }

    public int getLargura ()
    {
        return largura;
    }

    private void imgFoiEditadaNoPaint (byte[] img)
    {
        mediador.imagemFoiCriada(img, false);
        setImagem(img);
    }

    private class Dlg extends MyJDialog
    {

        private PnlImagem p1 = new PnlImagem(new MouseAdapter()
        {

            @Override
            public void mouseReleased (MouseEvent e)
            {
                sel = p1.getImagem();
                fechar();
            }

        }, "Clique para escolher");
        private PnlImagem p2 = new PnlImagem(new MouseAdapter()
        {

            @Override
            public void mouseReleased (MouseEvent e)
            {
                sel = p2.getImagem();
                fechar();
            }

        }, "Clique para escolher");
        private byte[] sel = null;

        private Dlg (final byte[] img1, final byte[] img2)
        {
            super(PnlLaudoeCia.getInstance(), true, 400, 400);
            setTitle("Clique na imagem desejada para escolher");
            java.awt.EventQueue.invokeLater(new Runnable()
            {

                @Override
                public void run ()
                {
                    p1.setImagem(img1);
                    p2.setImagem(img2);
                }
            });
            MyJPanel cp = new MyJPanel(new GridLayout(1, 2));
            cp.add(p1);
            cp.add(p2);
            setContentPane(cp);
        }

        private byte[] getSel()
        {
            return sel;
        }

        @Override
        public void fechar ()
        {
            dispose();
        }

    }

}
