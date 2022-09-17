/*
 * DlgLogin.java
 *
 * Created on 14/03/2012, 14:31:45
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.ctrlacesso.C_Login;
import com.ic.projects.laudoecia.iview.TelaDeLogin;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.icontrol.autocompletar.C_AutoCompletar;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.RobotImpl;
import com.lib.swing.utils.SwingUtils;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgLogin extends MyJDialog implements TelaDeLogin
{

    private static final long serialVersionUID = 1L;
    private C_Login c_Login;

    public DlgLogin (Frame parent, boolean modal)
    {
        super(parent, modal, 402, 226);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        initComponents();
        c_Login = new C_Login(this);
    }

    @Override
    public void fechar ()
    {
        btnCancelarActionPerformed();
    }

    @Override
    public void setarBuscador (C_AutoCompletar<?> buscador)
    {
        txtLogin.setControlador(buscador);
    }

    @Override
    public void informarQueOLoginEhObrigatorio ()
    {
        int resultado = SwingUtils.obterConfirmacaoDoUsuario(
                "É necessário fazer o login para entrar no sistema!\n"
                + "Deseja sair do programa?", this);
        if (resultado == JOptionPane.YES_OPTION)
        {
            Runtime.getRuntime().exit(0);
        }
    }

    private void initComponents ()
    {
        pnlLogin.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        pnlLogin.add(lblImgTopo, c);
        c.weighty = 1;
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridheight = 5;
        pnlLogin.add(lblImgCadeado, c);
        c.weighty = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridy = 1;
        c.gridx = 1;
        pnlLogin.add(new PnlComp("Login de Acesso", false, false).setComponent(txtLogin), c);
        c.gridy = 2;
        c.gridx = 1;
        pnlLogin.add(new PnlComp("Senha", false, true).setComponent(txtSenha), c);
        c.gridy = 3;
        c.gridx = 1;
        pnlLogin.add(Box.createVerticalStrut(5), c);
        c.gridy = 4;
        c.gridx = 1;
        c.gridwidth = 1;
        c.weighty = 1;
        pnlLogin.add(btnCancelar, c);
        c.gridy = 4;
        c.gridx = 2;
        pnlLogin.add(btnConfirmar, c);

        c.weighty = 0;
        c.gridy = 5;
        c.gridwidth = 4;
        c.gridx = 1;
        pnlLogin.add(Box.createVerticalStrut(15), c);

        c.gridy = 6;
        c.gridwidth = 1;
        c.gridx = 0;
        pnlLogin.add(Box.createHorizontalStrut(120), c);
        c.gridx = 1;
        pnlLogin.add(Box.createHorizontalStrut(130), c);
        c.gridx = 2;
        pnlLogin.add(Box.createHorizontalStrut(130), c);
        c.gridx = 3;
        pnlLogin.add(Box.createHorizontalStrut(20), c);

        add(pnlLogin);
    }

    //<editor-fold defaultstate="collapsed" desc="Components do Dialog">

    private MyJPanel pnlLogin = new MyJPanel();
    private MyJLabel lblImgTopo = new MyJLabel();
    private MyJLabel lblImgCadeado = new MyJLabel();
    private TxtComAutoCompletar txtLogin = new TxtComAutoCompletar();
    private MyJPasswordField txtSenha = new MyJPasswordField();
    private MyJButton btnConfirmar = new MyJButton("Confirmar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");

    {
        pnlLogin.setBorder(new LineBorder(new Color(0, 51, 102)));
        lblImgTopo.setIcon(ImageResources.getIcon(ImagensLC.LOGIN_TOPO));
        lblImgCadeado.setIcon(ImageResources.getIcon(ImagensLC.LOGIN_CADEADO));
        lblImgCadeado.setVerticalAlignment(MyJLabel.CENTER);
        lblImgCadeado.setHorizontalAlignment(MyJLabel.CENTER);
        txtLogin.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
                if (e.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
                }
            }

        });
        txtLogin.setKeyEventDelay(100);
        txtSenha.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
                if (e.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    btnConfirmarActionPerformed();
                }
            }

        });
        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnCancelarActionPerformed();
            }

        });
        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarActionPerformed();
            }

        });
    }

    //</editor-fold>

    private void btnCancelarActionPerformed ()
    {
        if (c_Login.cancelarOk())
        {
            dispose();
        }
    }

    private void btnConfirmarActionPerformed ()
    {
        if (c_Login.loginOk(txtLogin.getText(), new String(txtSenha.getPassword())))
        {
            dispose();
        }
    }

}
