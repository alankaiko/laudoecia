/*
 * DlgValidarUsuario.java
 *
 * Created on 13/01/2012, 16:05:48
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.ctrlacesso.C_ConfirmUsuario;
import com.ic.projects.laudoecia.iview.TelaValidarUsuario;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.lib.icontrol.autocompletar.C_AutoCompletar;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.utils.EnterEnviaTab;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgValidarUsuario extends MyJDialog implements TelaValidarUsuario
{

    private C_ConfirmUsuario c_ConfirmUsuario;

    public DlgValidarUsuario (java.awt.Frame parent, boolean modal)
    {
        super(parent, modal, 370, 61);
        initComponents();
        c_ConfirmUsuario = new C_ConfirmUsuario(this);

        txtLogin.addKeyListener(new EnterEnviaTab(false));
        pswSenha.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.getKeyChar() == '\n')
                {
                    btnConfirmar.doClick();
                }
            }

        });
        btnConfirmar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                if (c_ConfirmUsuario.setarUsuarioEscolhidoOk(
                        txtLogin.getText(), new String(pswSenha.getPassword())))
                {
                    dispose();
                }
            }
        });

    }

    public Usuario getUsuario ()
    {
        return c_ConfirmUsuario.getUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlImagem = new javax.swing.JPanel();
        lblCadeado = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtLogin = new TxtComAutoCompletar();
        pswSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Permissão de Acesso");
        setMinimumSize(new java.awt.Dimension(370, 61));
        setResizable(false);

        lblCadeado.setIcon(ImageResources.getIcon(com.ic.projects.laudoecia.view.imagens.ImagensLC.CADEADO_SMALL));

        javax.swing.GroupLayout pnlImagemLayout = new javax.swing.GroupLayout(pnlImagem);
        pnlImagem.setLayout(pnlImagemLayout);
        pnlImagemLayout.setHorizontalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCadeado))
        );
        pnlImagemLayout.setVerticalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCadeado, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsuario.setText(" Usuário");

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSenha.setText(" Senha");

        btnConfirmar.setText("OK");
        btnConfirmar.setFocusable(false);

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnlImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel lblCadeado;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlImagem;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void fechar ()
    {
        dispose();
    }

    @Override
    public void setarBuscador (C_AutoCompletar<?> b)
    {
        ((TxtComAutoCompletar) txtLogin).setControlador(b);
    }

}
