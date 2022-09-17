/*
 * BM_TrayIcon.java
 *
 * Created on 10/04/2012, 17:03:09
 */
package com.ic.projects.laudoecia.view.backup;


import com.ic.projects.laudoecia.iview.Tela;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaSolicitante;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import java.awt.TrayIcon;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BM_TrayIcon extends TrayIcon implements TelaPrincipal
{

    private static BM_TrayIcon trayIcon;

    private BM_TrayIcon ()
    {
        super(ImageResources.getImage(ImagensLC.SYSTEM_TRAY_ICON),
              "Gerenciador de backups LaudoeCia");
    }

    public static BM_TrayIcon getInstance ()
    {
        if (trayIcon == null)
        {
            trayIcon = new BM_TrayIcon();
        }
        return trayIcon;
    }

    @Override
    public void iniciarTarefa (String descricao)
    {
//        displayMessage(null, descricao, MessageType.INFO);
    }

    @Override
    public void terminarTarefa (String mensagem)
    {
//        displayMessage(null, mensagem, MessageType.INFO);
    }

    // <editor-fold defaultstate="collapsed" desc="Tela principal">

    @Override
    public void start (boolean exigirLoginDoUsuario)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCursorToDefaultCursor ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCursorToWaitCursor ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario solicitarUsuario ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exigirLoginDoUsuario ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void suspenderSessao ()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarMensagemDeErro (String mensagem, Tela t)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarTela (int tela, TelaSolicitante telaSolicitante)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarRelAuditoria (List<AcaoDoUsuario> lista)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarComprovanteAtd (Atendimento atd)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // </editor-fold>

}
