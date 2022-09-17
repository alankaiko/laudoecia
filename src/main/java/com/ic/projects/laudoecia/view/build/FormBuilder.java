/*
 * FormBuilder.java
 *
 * Created on 11/01/2012, 16:52:36
 */

package com.ic.projects.laudoecia.view.build;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.control.ctrlacesso.UsuarioLogadoListener;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.lib.model.cnv.ConversorDateString;
import com.lib.model.cnv.ConversorDateTimeString;
import com.lib.swing.mdi.AbstractMdiBuilder;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.EdgedBalloonStyle;
import net.java.balloontip.utils.FadingUtils;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class FormBuilder extends AbstractMdiBuilder
{

    private static FormBuilder instance;

    protected FormBuilder ()
    {
    }

    public static FormBuilder getInstance()
    {
        if (instance == null)
        {
            switch (StaticInfo.getParametrosDoSistema().getVersaoDoSw())
            {
                case V1:
                    instance = new FormBuilderV1();
                    break;
                default:
                    instance = new FormBuilderV1();
            }
        }
        return instance;
    }

    void iniciarTarefa (String texto)
    {
        lblProgessBar.setText(" " + texto);
        progressBar.setIndeterminate(true);
        lblProgessBar.setVisible(true);
        sepProgressBar.setVisible(true);
        progressBar.setVisible(true);
    }

    void terminarTarefa (String texto)
    {
        lblProgessBar.setVisible(true);
        sepProgressBar.setVisible(true);
        progressBar.setVisible(true);
        lblProgessBar.setText("");
        progressBar.setIndeterminate(false);
        progressBar.setValue(progressBar.getMaximum());
        BalloonTip ballon = new BalloonTip(progressBar, texto,
                new EdgedBalloonStyle(Color.WHITE, Color.BLACK), true);
        MeuActionList ballonClosedAction = new MeuActionList();
        ballon.getCloseButton().addActionListener(ballonClosedAction);
        ballon.setVisible(true);
        FadingUtils.fadeOutBalloon(ballon, ballonClosedAction, 10000, 10);
    }

    @Override
    public JPanel getPnlStatus ()
    {

        // <editor-fold defaultstate="collapsed" desc="Lbl Usuario">

        final JLabel lblUsuario = new JLabel();
        lblUsuario.setForeground(Color.BLUE);
        ControladorDeAcesso.addUsuarioLogadoListener(new UsuarioLogadoListener() {
            @Override
            public void usuarioSelecionadoVaiMudar (Usuario antigo, Usuario novo)
            {
                lblUsuario.setText(" Usuário logado: " + novo.getNome());
            }
        });

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Lbl Suporte">

        JLabel lblSuporte = new JLabel("Suporte e vendas: " + LaudoeCia.TELEFONE);

        {
            Dimension lblDimension = new Dimension(370, 22);

            lblSuporte.setMaximumSize(lblDimension);
            lblSuporte.setPreferredSize(lblDimension);
            lblSuporte.setMinimumSize(lblDimension);

            lblSuporte.setForeground(Color.black);
            lblSuporte.setFont(lblSuporte.getFont().deriveFont(Font.BOLD));
            lblSuporte.setHorizontalAlignment(JLabel.CENTER);

        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Data e hora">

        final JLabel lblData = new JLabel();
        final JLabel lblHora = new JLabel();

        {
            Dimension lblDimension = new Dimension(85, 22);

            lblData.setMaximumSize(lblDimension);
            lblData.setPreferredSize(lblDimension);
            lblData.setMinimumSize(lblDimension);
            lblHora.setMaximumSize(lblDimension);
            lblHora.setPreferredSize(lblDimension);
            lblHora.setMinimumSize(lblDimension);
        }

        lblData.setForeground(Color.BLUE);
        lblHora.setForeground(Color.BLUE);
        lblData.setHorizontalAlignment(JLabel.CENTER);
        lblHora.setHorizontalAlignment(JLabel.CENTER);

        {
            ActionListener action = new ActionListener()
            {
                private final ConversorDateString cnvData = new ConversorDateString();

                private final ConversorDateTimeString cnvHora = new ConversorDateTimeString(true);

                @Override
                public void actionPerformed (java.awt.event.ActionEvent e)
                {
                    Calendar calendar = Calendar.getInstance();
                    lblData.setText(cnvData.convertForward(calendar.getTime()));
                    lblHora.setText(cnvHora.convertForward(calendar.getTime()));
                }

            };

            Timer time = new Timer(1000, action);
            action.actionPerformed(null);
            time.start();
        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Progress bar">

        progressBar.setSize(new Dimension(10, 32));
        progressBar.setIndeterminate(true);
        progressBar.setForeground(Color.BLUE);

        {
            Dimension barDimension = new Dimension(85, 22);
            progressBar.setPreferredSize(barDimension);
            progressBar.setMaximumSize(barDimension);
            progressBar.setMaximumSize(barDimension);
        }

        lblProgessBar.setForeground(Color.BLUE);
        lblProgessBar.setHorizontalAlignment(JLabel.CENTER);

        {
//            Dimension dLblProgressBar = new Dimension(135, 22);
//            lblProgessBar.setMaximumSize(dLblProgressBar);
//            lblProgessBar.setMinimumSize(dLblProgressBar);
//            lblProgessBar.setPreferredSize(dLblProgressBar);
        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Separators">

        JSeparator sepUsuario = new JSeparator(JSeparator.VERTICAL);
        JSeparator sepData = new JSeparator(JSeparator.VERTICAL);
        JSeparator sepSuporte = new JSeparator(JSeparator.VERTICAL);

        {
            Dimension dSep = new Dimension(3, 22);
            sepUsuario.setMaximumSize(dSep);
            sepUsuario.setPreferredSize(dSep);
            sepUsuario.setMinimumSize(dSep);
            sepProgressBar.setMaximumSize(dSep);
            sepProgressBar.setPreferredSize(dSep);
            sepProgressBar.setMinimumSize(dSep);
            sepData.setMaximumSize(dSep);
            sepData.setPreferredSize(dSep);
            sepData.setMinimumSize(dSep);
            sepSuporte.setMaximumSize(dSep);
            sepSuporte.setPreferredSize(dSep);
            sepSuporte.setMinimumSize(dSep);
        }

        // </editor-fold>

        JPanel pnlStatus = new JPanel();

        pnlStatus.setLayout(new BoxLayout(pnlStatus, BoxLayout.LINE_AXIS));
        pnlStatus.setMinimumSize(new Dimension(10, 22));
        pnlStatus.setPreferredSize(new Dimension(10, 22));
        pnlStatus.setBorder(new BlackAndWhiteEtchedBorder());

        pnlStatus.add(lblUsuario);
        pnlStatus.add(Box.createHorizontalGlue());
        pnlStatus.add(sepUsuario);
        pnlStatus.add(lblSuporte);
        pnlStatus.add(sepSuporte);
        pnlStatus.add(lblProgessBar);
        pnlStatus.add(progressBar);
        pnlStatus.add(sepProgressBar);
        pnlStatus.add(lblData);
        pnlStatus.add(sepData);
        pnlStatus.add(lblHora);

        return pnlStatus;

    }

    // <editor-fold defaultstate="collapsed" desc="Componentes">

    private final JProgressBar progressBar = new JProgressBar();
    private final JLabel lblProgessBar = new JLabel();
    private final JSeparator sepProgressBar = new JSeparator(JSeparator.VERTICAL);

    {
        progressBar.setVisible(false);
        lblProgessBar.setVisible(false);
        sepProgressBar.setVisible(false);

    }

    // </editor-fold>

    private class MeuActionList implements ActionListener
    {

        private boolean fuiChamado = false;

        @Override
        public void actionPerformed (ActionEvent e)
        {
            if (fuiChamado)
            {
            }
            else
            {
                lblProgessBar.setVisible(false);
                sepProgressBar.setVisible(false);
                progressBar.setVisible(false);
                fuiChamado = true;
            }
        }

    }

}
