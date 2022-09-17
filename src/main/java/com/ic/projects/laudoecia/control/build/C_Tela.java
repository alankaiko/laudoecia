/*
 * C_Tela.java
 *
 * Created on 04/01/2012, 15:25:32
 */

package com.ic.projects.laudoecia.control.build;

import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.control.ctrlacesso.PermissaoDeUsuario;
import com.ic.projects.laudoecia.iview.TelaSolicitante;
import com.ic.projects.laudoecia.iview.TelaSolicitanteNull;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_Tela
{
    private int telaASerMostrada;
    private TelaSolicitante telaSolicitante;
    private PermissaoDeUsuario pdu;

    public C_Tela (int telaASerMostrada)
    {
        this(telaASerMostrada, new TelaSolicitanteNull());
    }

    public C_Tela (int telaASerMostrada, TelaSolicitante telaSol)
    {
        this(telaASerMostrada, telaSol, null);
    }

    public C_Tela (int telaASerMostrada, PermissaoDeUsuario pdu)
    {
        this(telaASerMostrada, new TelaSolicitanteNull(), pdu);
    }

    public C_Tela (int telaASerMostrada, TelaSolicitante telaSol, PermissaoDeUsuario pdu)
    {
        this.telaASerMostrada = telaASerMostrada;
        this.telaSolicitante = telaSol;
        this.pdu = pdu;
    }

    public void mostrarTela ()
    {
        LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
        if (usuarioOk())
        {
            LaudoeCia.getTelaPrincipal().mostrarTela(telaASerMostrada, telaSolicitante);
        }
        LaudoeCia.getTelaPrincipal().setCursorToDefaultCursor();
    }

    private boolean usuarioOk ()
    {
        return pdu == null ? true :
               ControladorDeAcesso.getInstance().podeAcessar(pdu);
    }

}
