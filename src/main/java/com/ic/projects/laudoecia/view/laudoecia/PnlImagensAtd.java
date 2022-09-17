/*
 * PnlImagensAtd.java
 *
 * Created on 09/05/2012, 15:41:47
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.iview.ViewLaudoeCia;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.java.utils.DateUtils;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.BtnTextoEmBaixo;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlImagem;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlImagensAtd extends MyJPanel implements ViewImagens
{

    private List<PnlImgMiniatura> listaMiniaturas = new ArrayList<>();
    private LaudoeCiaMediator mediador;
    private MeuSw meuSw;

    public PnlImagensAtd (LaudoeCiaMediator mediador)
    {
        this.mediador = mediador;
        initializeComponents();
        updateIndexes();
        setPreferredSize(new Dimension(350, 445));
        setSize(new Dimension(350, 445));
        setMinimumSize(new Dimension(350, 445));
        setMaximumSize(new Dimension(350, 445));
    }

    private void initializeComponents ()
    {
        setBorder(new BlackAndWhiteEtchedBorder());
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridwidth = 4;
        c.weighty = 1;
        c.insets.top = 5;
        c.insets.left = 5;
        c.insets.right = 5;
        pnlImageViewWithBorder.setPreferredSize(new Dimension(5, 5));
        add(pnlImageViewWithBorder, c);

        c.gridy = 1;
        c.weighty = 0;
        c.insets.right = 0;
        c.insets.bottom = 5;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.weightx = 0.5;
        MyJPanel pnl = new MyJPanel(new GridLayout(1, 2, 5, 0));
        pnl.add(btnEditar);
        pnl.add(btnMover);
        add(pnl, c);
        c.insets.bottom = 0;
        c.gridheight = 1;
        c.gridx = 1;
        c.weightx = 0.25;
        add(btnAnterior, c);
        c.gridx = 2;
        add(btnProxima, c);
        c.insets.right = 5;
        c.gridx = 3;
        c.weightx = 0;
        c.gridheight = 2;
        c.insets.bottom = 5;
        add(lblIndice, c);
        add(Box.createHorizontalStrut(90), c);

        c.gridy = 2;
        c.gridx = 1;
        c.weightx = 0;
        c.insets.right = 0;
        c.gridheight = 1;
        add(btnFullScreen, c);
        c.gridx = 2;
        c.gridwidth = 1;
        add(btnExcluir, c);

        c.gridwidth = 4;
        c.gridy = 3;
        c.gridx = 0;
        c.insets.bottom = 0;
        c.insets.top = 0;
        c.insets.left = 0;
        c.insets.right = 0;
        scrpMiniaturas.setPreferredSize(new Dimension(5, 127));
        add(scrpMiniaturas, c);

    }

    //<editor-fold defaultstate="collapsed" desc="Componentes do Painel">

    private MyJPanel pnlImageViewWithBorder = new MyJPanel();
    private PnlImagemPrincipal pnlImageView = new PnlImagemPrincipal();
    private MyJPanel pnlMiniaturas = new MyJPanel();
    private ScrpMiniaturas scrpMiniaturas = new ScrpMiniaturas(true,
            pnlMiniaturas, listaMiniaturas);

    private BtnTextoEmBaixo btnEditar     = new BtnTextoEmBaixo("Editar");
    private BtnTextoEmBaixo btnMover      = new BtnTextoEmBaixo("<html>" +
            "<p align=\"center\">Importar<br>Ou<br>Mover</p></html>");
    private LblNegrito      lblIndice     = new LblNegrito();
    private MyJButton       btnExcluir    = new MyJButton();
//    private MyJButton       btnExcluir    = new MyJButton("<html><font color=\"0000ff\"><u>E</u></font></html>");
    private MyJButton       btnFullScreen = new MyJButton("");
    private MyJButton       btnAnterior   = new MyJButton();
    private MyJButton       btnProxima    = new MyJButton();

    {

        pnlImageView.setAcaoNoDuploClique(PnlImagem.VISUALIZAR_FULL_SCREEN);

        pnlImageViewWithBorder.setBorder(new CompoundBorder(
                new LineBorder(Color.GRAY),
                new LineBorder(Color.WHITE, 3)));
        pnlImageViewWithBorder.setLayout(new BorderLayout());
        pnlImageViewWithBorder.add(pnlImageView, BorderLayout.CENTER);
        btnEditar.setBorder(new EmptyBorder(6, 10, 6, 10));
        btnEditar.setIcon(ImageResources.getIcon(ImagensLC.IMG_EDIT));
        btnEditar.setToolTipText("Editar imagem selecionada");
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnEditarAction();
            }
        });

        btnMover.setBorder(new EmptyBorder(6, 10, 6, 10));
//        btnMover.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnMover.setToolTipText("Importar / mover imagens");
        btnMover.setBackground(Color.yellow);
        btnMover.setHorizontalAlignment(SwingConstants.CENTER);
        btnMover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnMoverAction();
            }
        });

        lblIndice.setForeground(new Color(0, 102, 255));
        lblIndice.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblIndice.setBorder(new BlackAndWhiteEtchedBorder());
        lblIndice.setHorizontalAlignment(SwingConstants.CENTER);

        btnExcluir.setHorizontalAlignment(SwingConstants.CENTER);
        btnExcluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnExcluirAction();
            }
        });
        btnExcluir.setForeground(Color.red);
        btnExcluir.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnExcluir.setToolTipText("Excluir imagem selecionada");

        btnFullScreen.setIcon(SwingLibResources.getIcon(Imagens.FULLSCREEN));
        btnFullScreen.setToolTipText("Ver imagens ampliadas em tela cheia");
        btnFullScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnFullScreenAction();
            }
        });
        btnAnterior.setIcon(SwingLibResources.getIcon(Imagens.ANTERIOR));
        btnAnterior.setToolTipText("Imagem anterior");
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAnteriorAction();
            }
        });
        btnProxima.setIcon(SwingLibResources.getIcon(Imagens.PROXIMO));
        btnProxima.setToolTipText("Próxima imagem");
        btnProxima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnProximaAction();
            }
        });

        pnlMiniaturas.setLayout(new FlowLayout(FlowLayout.LEADING));

        scrpMiniaturas.getHorizontalScrollBar().setUI(new BlueScrollBarUI());
        scrpMiniaturas.setBorder(new MatteBorder(1, 0, 0, 0, Color.GRAY));
        scrpMiniaturas.getHorizontalScrollBar().setUnitIncrement(10);
        scrpMiniaturas.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrpMiniaturas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    }

    //</editor-fold>

    @Override
    public void addImg (byte[] img)
    {
        PnlImgMiniatura itemMiniatura = criarPnlMiniatura(img);
        pnlMiniaturas.add(itemMiniatura);
        listaMiniaturas.add(itemMiniatura);
    }

    @Override
    public void removerImgSel ()
    {
        int index = mediador.getIndexAtual();
        listaMiniaturas.get(index).setVisible(false);
        listaMiniaturas.remove(index);
    }

    @Override
    public void atualizarSelecao ()
    {
        if (meuSw == null)
        {
            // assertion error
        }
        else
        {
            meuSw.atualizarSelecao();
        }
    }

    @Override
    public void carregarImagens (final List<byte[]> imagens)
    {
        if (!(meuSw == null || meuSw.isDone()))
        {
            meuSw.cancel(true);
        }
        meuSw = new MeuSw(imagens);
        meuSw.execute();
    }

    @Override
    public void imgSelMudou ()
    {
        int index = mediador.getIndexAtual();
        PnlImgMiniatura miniatura = listaMiniaturas.get(index);
        miniatura.setImagem(mediador.getImagemAtual());
        pnlImageView.setImagem(mediador.getImagemAtual());
    }

    // <editor-fold defaultstate="collapsed" desc="Eventos">

    private void btnMoverAction ()
    {
        if (mediador.validarMoverImg())
        {
            DlgMoverImportarImg dlg = new DlgMoverImportarImg(mediador);
            dlg.setVisible(true);
        }
    }

    private void btnEditarAction ()
    {
        mediador.iniciarEdicaoDeImg();
    }

    private void btnExcluirAction ()
    {
        mediador.removerImgSelecionada();
    }

    private void btnFullScreenAction ()
    {
        mediador.mostrarImagensEmFullScreen();
    }

    private void btnAnteriorAction ()
    {
        mediador.irParaImgAnterior();
    }

    private void btnProximaAction ()
    {
        mediador.irParaProximaImg();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Utils">

    private void resetPainel()
    {
        try
        {
            listaMiniaturas.clear();
            pnlImageView.setImagem(null);
            pnlMiniaturas.removeAll();
            pnlMiniaturas.repaint();
            updateIndexes();
        }
        catch (ClassCastException e)
        {
            resetPainel();
        }
    }

    private void updateIndexes ()
    {
        lblIndice.setText(mediador.getIndexes());
    }

    private PnlImgMiniatura criarPnlMiniatura (byte[] img)
    {
        PnlImgMiniatura itemMiniatura = new PnlImgMiniatura(img, scrpMiniaturas,
                new Dimension(135, 100),
                new MouseListPnlMiniatura(listaMiniaturas, mediador, false));
        itemMiniatura.configurar(new EmptyBorder(5, 0, 5, 0),
                                 new EmptyBorder(0, 1, 0, 1));
        return itemMiniatura;
    }

    // </editor-fold>

    private class MeuSw extends SwingWorker<Void, PnlImgMiniatura>
    {

        private List<byte[]> imagens;
        private boolean resetPanel = true;

        private MeuSw (List<byte[]> imagens)
        {
            this.imagens = imagens;
        }

        private void atualizarSelecao ()
        {
            if (isDone())
            {
                int index = mediador.getIndexAtual();
                for (int i = 0; i < listaMiniaturas.size(); i++)
                {
                    listaMiniaturas.get(i).setSelected(false);
                }
                byte[] img = mediador.getImagemAtual();
                pnlImageView.setImagem(img);
                if (img == null)
                {
                }
                else
                {
                    try
                    {
                        PnlImgMiniatura miniatura = listaMiniaturas.get(index);
                        miniatura.setSelected(true);
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                    }
                }
                updateIndexes();
            }
            else
            {
            }
        }

        @Override
        protected void process (List<PnlImgMiniatura> chunks)
        {
            if (isCancelled())
            {
            }
            else
            {
                if (resetPanel)
                {
                    do
                    {
                        try
                        {
                            resetPainel();
                            resetPanel = false;
                        }
                        catch (ClassCastException cce)
                        {
                        }
                    } while (resetPanel);
                }
                for (int i = 0; i < chunks.size(); i++)
                {
                    PnlImgMiniatura itemMiniatura = chunks.get(i);
                    pnlMiniaturas.add(itemMiniatura);
                    listaMiniaturas.add(itemMiniatura);
                }
            }
        }

        @Override
        @SuppressWarnings("AssignmentToForLoopParameter")
        protected Void doInBackground () throws Exception
        {
            for (int i = 0; i < imagens.size(); i++)
            {
                try
                {
                    publish(criarPnlMiniatura(imagens.get(i)));
                }
                catch (ClassCastException cce)
                {
                    i--;
                }
            }
            return null;
        }

        @Override
        protected void done ()
        {
            if (!isCancelled())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run ()
                    {
                        if (resetPanel)
                        {
                            resetPainel();
                        }
                        else
                        {
                            atualizarSelecao();
                        }
                    }
                });
            }
        }

    }

    private class PnlImagemPrincipal extends PnlImagem
    {

        private Timer timer = new Timer(true);
        private TimerTask tt;

        private PnlImagemPrincipal ()
        {
            super(null, null);
            getLblImagem().addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered (MouseEvent e)
                {
                    PnlImagemPrincipal.this.mouseEntered(e);
                }

                @Override
                public void mouseExited (MouseEvent e)
                {
                    PnlImagemPrincipal.this.mouseExited(e);
                }

            });
        }

        private void mouseEntered (MouseEvent e)
        {
            if (pnlImageView.getImagem() == null ||
                !mediador.getViewState().equals(ViewLaudoeCia.LAUDO))
            {
            }
            else
            {
                if (tt != null)
                {
                    tt.cancel();
                }
                tt = createTimerTask();
                timer.schedule(tt, DateUtils.addMiliSegNaData(new Date(), 50));
            }
        }

        private void mouseExited (MouseEvent e)
        {
            if (tt == null || pnlImageView.getImagem() == null)
            {
            }
            else
            {
                tt.cancel();
            }
        }

        private TimerTask createTimerTask ()
        {
            return new TimerTask() {

                @Override
                public void run ()
                {
                    new DlgPreviewImg().setVisible(true);
                }
            };
        }

    }

    private class DlgPreviewImg extends MyJDialog
    {

        private DlgPreviewImg ()
        {
            // só funciona se não for modal, porque eu não sei...
            super(pnlImageView, false);
            setBounds(calculateBounds());
            setUndecorated(true);
            MouseAdapter ml = new MouseAdapter() {

                @Override
                public void mouseExited (MouseEvent e)
                {
                    fechar();
                }

                @Override
                public void mouseClicked (MouseEvent e)
                {
                    fechar();
                }

                @Override
                public void mouseDragged (MouseEvent e)
                {
                    fechar();
                }

            };
            addMouseListener(ml);
            final PnlImagem pnlImg = new PnlImagem(new MouseAdapter() {}, null);
            pnlImg.getLblImagem().addMouseListener(ml);
            pnlImg.setFocusable(true);
            setContentPane(pnlImg);
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    byte[] imagem = pnlImageView.getImagem();
                    if (imagem == null)
                    {
                        fechar();
                    }
                    else
                    {
                        pnlImg.setImagem(imagem);
                    }
                }
            });
        }

        private Rectangle calculateBounds ()
        {
            Rectangle r = new Rectangle();

            Point losPnlWBorder = pnlImageViewWithBorder.getLocationOnScreen();
            int pnlImgWithBorderWidth = pnlImageViewWithBorder.getSize().width;

            r.y = losPnlWBorder.y;

            BufferedImage imgResOrig = pnlImageView.getImgParaVerEmResOr();
            r.width = Math.min(imgResOrig.getWidth(), 720);
            r.height = Math.min(imgResOrig.getHeight(), 480);

            r.x = losPnlWBorder.x + pnlImgWithBorderWidth - r.width;

            return r;
        }

        @Override
        public void fechar ()
        {
            dispose();
        }

    }
}
