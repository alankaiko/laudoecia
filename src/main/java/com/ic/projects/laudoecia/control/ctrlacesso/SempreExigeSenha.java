/**
  * SempreExigeSenha.java
  *
  * Created on 12/12/2011, 18:45:24
  */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.model.auditable.Usuario;

/**
 * Nesse caso, em toda ação de adicionar, alterar e apagar, deve ser exigido
 * o usuário e senha. O usuário logado é aquele que fez o login ou o último
 * que digitou sua senha. As permissões para acessar os menus são checadas
 * conforme o usuário logado.
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
class SempreExigeSenha extends ControladorDeAcesso
{

    @Override
    public boolean criarMenusDeControleDeSessão ()
    {
        return true;
    }

    @Override
    public boolean exigirLoginAoIniciarOSistema ()
    {
        return true;
    }

    @Override
    public boolean mostrarCadastrosDoControleDeAcesso ()
    {
        return true;
    }

    @Override
    public boolean podeAcessar (PermissaoDeUsuario p)
    {
        if (validar(VALIDAR_ACESSAR, p, true))
        {
            return true;
        }
        return validar(VALIDAR_ACESSAR, p, false);
    }

    @Override
    public boolean podeAdicionar (PermissaoDeUsuario p)
    {
        return validar(VALIDAR_ADICIONAR, p, false);
    }

    @Override
    public boolean podeAlterar (PermissaoDeUsuario p)
    {
        return validar(VALIDAR_ALTERAR, p, false);
    }

    @Override
    public boolean podeApagar (PermissaoDeUsuario p)
    {
        return validar(VALIDAR_APAGAR, p, false);
    }

    @Override
    public Usuario getResponsavelPelaAcao ()
    {
        return ultimoUsuarioValidado == null ? getUsuarioLogado() : ultimoUsuarioValidado;
    }

}