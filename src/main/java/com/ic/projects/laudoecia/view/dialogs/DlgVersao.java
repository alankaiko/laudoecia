/*
 * DlgVersao.java
 *
 * Created on 07/03/2012, 15:44:25
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.swing.plus.cps.MyJDialog;
import java.awt.Component;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgVersao extends MyJDialog
{
    public DlgVersao (Component cp)
    {
        super(cp, true, 378, 236);
        setTitle("Sobre o " + LaudoeCia.NOME_DO_SISTEMA);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlPrincipal = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblPrincipal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInfoTitulos = new javax.swing.JLabel();
        lblInfoValores = new javax.swing.JLabel();
        lblLinkPaginaOficial = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(378, 236));
        setResizable(false);

        lblLogo.setIcon(ImageResources.getIcon(ImagensLC.ICONE_LC));

        lblPrincipal.setText("<html>"
            + "<font size=\"5\"><b>"
            + LaudoeCia.NOME_DO_SISTEMA
            + "</b></font><BR><BR>Versão "
            + LaudoeCia.VERSAO_DO_SISTEMA
            + "<BR>"
            + LaudoeCia.COPYRIGHT_DO_SISTEMA
            + "</html>");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da Versão"));

        lblInfoTitulos.setText("<html>Data da versão: <br>Sistema operacional:<br>Resolução mínima:</html>");

        lblInfoValores.setText("<html>"
            + LaudoeCia.DATA_VERSAO_DO_SISTEMA
            + "<br>"
            + LaudoeCia.SIST_OPER_DO_SISTEMA
            + "<br>"
            + LaudoeCia.RESOLUCAO_RECOMENDADA
            + "<br></html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfoValores, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfoTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoValores))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLinkPaginaOficial.setText("<html><a href=\"#\">"
            + LaudoeCia.PAGINA_OFICIAL_DO_SISTEMA + "<br>"
            + LaudoeCia.TELEFONE + "<br>"
            + LaudoeCia.EMAIL
            + "</a></html>");
        lblLinkPaginaOficial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLinkPaginaOficial.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblLinkPaginaOficialMouseClicked(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(26, 26, 26)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(lblLinkPaginaOficial)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLinkPaginaOficial)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Informações da versão");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLinkPaginaOficialMouseClicked (java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblLinkPaginaOficialMouseClicked
    {//GEN-HEADEREND:event_lblLinkPaginaOficialMouseClicked
        Desktop desk = java.awt.Desktop.getDesktop();
        try
        {
            desk.browse(new java.net.URI(LaudoeCia.PAGINA_OFICIAL_DO_SISTEMA));
        }
        catch (URISyntaxException | IOException e)
        {
        }
    }//GEN-LAST:event_lblLinkPaginaOficialMouseClicked

    private void btnOKActionPerformed (java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOKActionPerformed
    {//GEN-HEADEREND:event_btnOKActionPerformed
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfoTitulos;
    private javax.swing.JLabel lblInfoValores;
    private javax.swing.JLabel lblLinkPaginaOficial;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPrincipal;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void fechar ()
    {
        btnOKActionPerformed(null);
    }

}
