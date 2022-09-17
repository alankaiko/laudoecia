/*
 * TelaPrincipalNull.java
 *
 * Created on 13/09/2012, 11:24:14
 */

package com.ic.projects.laudoecia.iview;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import java.util.List;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class TelaPrincipalNull implements TelaPrincipal
{

    @Override
    public void setCursorToDefaultCursor ()
    {
    }

    @Override
    public void setCursorToWaitCursor ()
    {
    }

    @Override
    public void iniciarTarefa (String descricao)
    {
    }

    @Override
    public void terminarTarefa (String mensagem)
    {
    }

    @Override
    public Usuario solicitarUsuario ()
    {
        return null;
    }

    @Override
    public void exigirLoginDoUsuario ()
    {
    }

    @Override
    public void suspenderSessao ()
    {
    }

    @Override
    public void mostrarMensagemDeErro (String mensagem, Tela t)
    {
    }

    @Override
    public void mostrarTela (int tela, TelaSolicitante telaSolicitante)
    {
    }

    @Override
    public void mostrarRelAuditoria (List<AcaoDoUsuario> lista)
    {
    }

    @Override
    public void mostrarComprovanteAtd (Atendimento atd)
    {
    }

    @Override
    public void start (boolean exigirLoginDoUsuario)
    {
    }

}
