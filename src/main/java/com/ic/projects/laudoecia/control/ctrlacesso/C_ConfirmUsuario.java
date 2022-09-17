/*
 * C_ConfirmUsuario.java
 *
 * Created on 13/01/2012, 17:02:10
 */

package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeUsuarios;
import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.iview.TelaValidarUsuario;
import com.ic.projects.laudoecia.model.auditable.Usuario;

/**
 *
 * @author Danilo Brito
 */
public class C_ConfirmUsuario
{
    private TelaValidarUsuario telaValidarUsuario;
    private Usuario usuario;
    private static BuscadorDeUsuarios buscador = new BuscadorDeUsuarios();

    public C_ConfirmUsuario (TelaValidarUsuario telaValidarUsuario)
    {
        this.telaValidarUsuario = telaValidarUsuario;
        this.telaValidarUsuario.setarBuscador(buscador);
    }

    public Usuario getUsuario()
    {
        return this.usuario;
    }

    public boolean setarUsuarioEscolhidoOk (String textoDoTxtLogin, String senha)
    {
        usuario = buscador.getSelectedModel(textoDoTxtLogin);
        if (usuario == null)
        {
            LaudoeCia.getTelaPrincipal().mostrarMensagemDeErro(
                    "Usuário não existente!", telaValidarUsuario);
            return false;
        }
        else
        {
            if (usuario.getSenha().equals(senha))
            {
                return true;
            }
            else
            {
                usuario = null;
                LaudoeCia.getTelaPrincipal().mostrarMensagemDeErro(
                        "A senha está incorreta!", telaValidarUsuario);
                return false;
            }
        }

    }

}
