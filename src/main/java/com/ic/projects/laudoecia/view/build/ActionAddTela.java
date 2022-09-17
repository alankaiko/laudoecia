/*
 * ActionAddTela.java
 *
 * Created on 02/03/2012, 09:07:07
 */

package com.ic.projects.laudoecia.view.build;

import com.ic.projects.laudoecia.control.build.C_Tela;
import com.ic.projects.laudoecia.control.ctrlacesso.PermissaoDeUsuario;
import com.ic.projects.laudoecia.iview.TelaSolicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ActionAddTela implements ActionListener
{
    private C_Tela c_Tela;

    public ActionAddTela (int tela)
    {
        c_Tela = new C_Tela(tela);
    }

    public ActionAddTela (int tela, PermissaoDeUsuario pdu)
    {
        c_Tela = new C_Tela(tela, pdu);
    }

    public ActionAddTela (int tela, TelaSolicitante telaSolicitante)
    {
        this(tela, telaSolicitante, null);
    }

    public ActionAddTela (int tela, TelaSolicitante telaSol, PermissaoDeUsuario pdu)
    {
        c_Tela = new C_Tela(tela, telaSol, pdu);
        if (telaSol instanceof TelaSolPadrao)
        {
            cadastrarAtalho((TelaSolPadrao) telaSol);
        }
    }

    private void cadastrarAtalho (final TelaSolPadrao telaSol)
    {
        telaSol.getTxt().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased (KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_F4:
                        if (telaSol.getReceptorDeBusca() == null ||
                            telaSol.getReceptorDeBusca().isHabilitadoParaReceber())
                        {
                            actionPerformed(null);
                        }
                        break;
                    default:
                }
            }
        });
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        c_Tela.mostrarTela();
    }

}
