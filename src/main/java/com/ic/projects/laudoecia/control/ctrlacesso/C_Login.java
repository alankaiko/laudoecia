/**
  * C_Login.java
  *
  * Created on 16/12/2011, 18:42:21
  */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeUsuarios;
import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.iview.TelaDeLogin;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
public class C_Login
{    
    private TelaDeLogin telaDeLogin;
    private BuscadorDeUsuarios buscador = new BuscadorDeUsuarios();

    public C_Login (TelaDeLogin telaDeLogin)
    {
        this.telaDeLogin = telaDeLogin;
        this.telaDeLogin.setarBuscador(buscador);
        buscador.buscarCandidatos("");
    }
    
    public boolean loginOk (String textoDoTxtLogin, String senha)    
    {
        Usuario u = buscador.getSelectedModel(textoDoTxtLogin);
        if (u == null)
        {
            LaudoeCia.getTelaPrincipal().mostrarMensagemDeErro(
                    "Usuário não existente!", telaDeLogin);            
            return false;
        }
        else
        {
            if (Objects.equals(u.getSenha(), senha))
            {
                ControladorDeAcesso.setUsuarioLogado(u);
                return true;
            }
            else
            {
                LaudoeCia.getTelaPrincipal().mostrarMensagemDeErro(
                        "A senha está incorreta!", telaDeLogin);            
                return false;
            }
        }
    }

    public boolean cancelarOk ()
    {
        if (ControladorDeAcesso.existeUsuarioLogado())
        {
            return true;
        }
        else
        {
            telaDeLogin.informarQueOLoginEhObrigatorio();
            return false;
        }
    }

}
