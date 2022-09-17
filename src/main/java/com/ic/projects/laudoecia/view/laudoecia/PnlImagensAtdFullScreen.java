/*
 * PnlImagensAtdFullScreen.java
 *
 * Created on 24/04/2012, 08:39:23
 */
package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.iview.ViewLaudoeCia;
import com.lib.java.utils.ImageUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.BtnSoImagem;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComEspaco;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlImagensAtdFullScreen extends MyJPanel implements ViewImagens
{

    private ConversorByteArrayImage conversor = new ConversorByteArrayImage();
    private LaudoeCiaMediator mediador;
    private int indexAtual = -1;

    public PnlImagensAtdFullScreen (LaudoeCiaMediator mediador)
    {
        super(new BorderLayout());
        this.mediador = mediador;
        setBorder(new BlackAndWhiteEtchedBorder());
        initializeComponents();
        configurarNavPeloTeclado();
        setBackground(Color.black);
    }

    private void configurarNavPeloTeclado ()
    {
        InputMap inputMap = getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        KeyStroke right = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true);
        inputMap.put(right, "proximo");

        KeyStroke left = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true);
        inputMap.put(left, "anterior");

        KeyStroke primeiro = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true);
        inputMap.put(primeiro, "primeiro");

        KeyStroke ultimo = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true);
        inputMap.put(ultimo, "ultimo");

        KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true);
        inputMap.put(esc, "esc");

        ActionMap actionMap = getActionMap();
        actionMap.put("proximo", new AbstractAction() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnProximaAction();
            }
        });
        actionMap.put("anterior", new AbstractAction() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAnteriorAction();
            }
        });
        actionMap.put("primeiro", new AbstractAction() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnPrimeiraAction();
            }
        });
        actionMap.put("ultimo", new AbstractAction() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnUltimaAction();
            }
        });
        actionMap.put("esc", new AbstractAction() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                mediador.voltar();
            }
        });

    }

    private void initializeComponents ()
    {
        lblImagemFS.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 4;
        lblImagemFS.add(btnEditar, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;
        c.gridx = 0;
        c.weighty = 1;
        c.weightx = 1;
        lblImagemFS.add(Box.createVerticalStrut(10), c);
        c.weighty = 0;
        c.weightx = 0;
        c.fill = GridBagConstraints.NONE;

        c.gridy = 2;
        c.gridx = 0;
        c.anchor = GridBagConstraints.WEST;
        lblImagemFS.add(new PnlComEspaco(lblIndicador, 15, 5), c);
        c.gridx = 1;
        lblImagemFS.add(btnPrimeira, c);
        c.gridx = 2;
        lblImagemFS.add(btnAnterior, c);
        c.gridx = 3;
        lblImagemFS.add(btnProxima, c);
        c.gridx = 4;
        lblImagemFS.add(btnUltima, c);

        add(lblImagemFS, BorderLayout.CENTER);
    }

    @Override
    public boolean requestFocusInWindow ()
    {
        return btnProxima.requestFocusInWindow();
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private MyJLabel lblImagemFS = new MyJLabel();
    private LblNegrito lblIndicador = new LblNegrito();
    private BtnSoImagem btnPrimeira = new BtnSoImagem(
            SwingLibResources.getIcon(Imagens.BTN_PRIMEIRO),
            SwingLibResources.getIcon(Imagens.BTN_PRIMEIRO_UP));
    private BtnSoImagem btnAnterior = new BtnSoImagem(
            SwingLibResources.getIcon(Imagens.BTN_ANTERIOR),
            SwingLibResources.getIcon(Imagens.BTN_ANTERIOR_UP));
    private BtnSoImagem btnProxima = new BtnSoImagem(
            SwingLibResources.getIcon(Imagens.BTN_PROXIMO),
            SwingLibResources.getIcon(Imagens.BTN_PROXIMO_UP));
    private BtnSoImagem btnUltima = new BtnSoImagem(
            SwingLibResources.getIcon(Imagens.BTN_ULTIMO),
            SwingLibResources.getIcon(Imagens.BTN_ULTIMO_UP));
    private BtnSoImagem btnEditar = new BtnSoImagem(
            SwingLibResources.getIcon(Imagens.BTN_EDITAR),
            SwingLibResources.getIcon(Imagens.BTN_EDITAR_UP));

    {
        Cursor hand = new Cursor(Cursor.HAND_CURSOR);

        lblImagemFS.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagemFS.setVerticalAlignment(SwingConstants.CENTER);

        btnPrimeira.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnPrimeiraAction();
            }

        });
        btnPrimeira.setToolTipText("Primeira Imagem");
        btnPrimeira.setCursor(hand);

        btnAnterior.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAnteriorAction();
            }

        });
        btnAnterior.setToolTipText("Imagem Anterior");
        btnAnterior.setCursor(hand);

        btnProxima.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnProximaAction();
            }

        });
        btnProxima.setToolTipText("Próxima Imagem");
        btnProxima.setCursor(hand);

        btnUltima.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnUltimaAction();
            }

        });
        btnUltima.setToolTipText("Última Imagem");
        btnUltima.setCursor(hand);

        btnEditar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnEditarAction();
            }

        });
        btnEditar.setToolTipText("Editar Imagem");
        btnEditar.setCursor(hand);

        lblIndicador.setForeground(new Color(10, 80, 130));

    }

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Eventos">

    private void btnPrimeiraAction ()
    {
        mediador.irParaPrimeiraImg();
    }

    private void btnAnteriorAction ()
    {
        mediador.irParaImgAnterior();
    }

    private void btnProximaAction ()
    {
        mediador.irParaProximaImg();
    }

    private void btnUltimaAction ()
    {
        mediador.irParaUltimaImg();
    }

    private void btnEditarAction()
    {
        mediador.iniciarEdicaoDeImg();
    }

    // </editor-fold>

    @Override
    public void addImg (byte[] img)
    {
    }

    @Override
    public void carregarImagens (java.util.List<byte[]> imagens)
    {
        switch (PnlLaudoeCia.getInstance().getSelectedCard())
        {
            case ViewLaudoeCia.IMAGENS_FULL_SCREEN:
                atualizarSelecao();
                if (!imagens.isEmpty())
                {
                    requestFocusInWindow();
                }
                break;
            default:
        }
    }

    @Override
    public void removerImgSel ()
    {
    }

    @Override
    public void atualizarSelecao ()
    {
        if (indexAtual == mediador.getIndexAtual())
        {
        }
        else
        {
            indexAtual = mediador.getIndexAtual();
            byte[] imagem = mediador.getImagemAtual();
            if (imagem == null)
            {
                lblImagemFS.setIcon(null);
            }
            else
            {
                atualizarLblImagem(imagem);
            }
            lblIndicador.setText(mediador.getIndexes());
        }
    }

    @Override
    public void imgSelMudou ()
    {
        atualizarLblImagem(mediador.getImagemAtual());
    }

    private void atualizarLblImagem (byte[] imagem)
    {
        BufferedImage imgOriginal = conversor.convertForward(imagem);
        float aspectRatio = ((float) imgOriginal.getWidth()) / ((float)imgOriginal.getHeight());
        Dimension fitSize = ImageUtils.getFitSize(lblImagemFS.getSize(), aspectRatio);
        lblImagemFS.setIcon(new ImageIcon(ImageUtils.createResizedCopy(
                imgOriginal, fitSize.width, fitSize.height, true)));
    }

}
