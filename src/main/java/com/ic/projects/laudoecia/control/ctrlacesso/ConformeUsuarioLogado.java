/**
  * ConformeUsuarioLogado.java
  *
  * Created on 12/12/2011, 18:44:47
  */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.model.auditable.Usuario;

/**
 * Nessa estratégia de controle de acesso todas as ações possiveis - acessar, 
 * adicionar, alterar e apagar - são validadas conforme o usuário que está
 * logado. Se o usuário logado não tiver permissão para alguma ação, algum 
 * usuário que tenha poderá digitar sua senha, o que não altera o usuário 
 * logado, apenas concede permissão temporária para a ação desejada.
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
class ConformeUsuarioLogado extends ControladorDeAcesso
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
        if (validar(VALIDAR_ADICIONAR, p, true))
        {
            return true;
        }
        return validar(VALIDAR_ADICIONAR, p, false);
    }

    @Override
    public boolean podeAlterar (PermissaoDeUsuario p)
    {
        if (validar(VALIDAR_ALTERAR, p, true))
        {
            return true;
        }
        return validar(VALIDAR_ALTERAR, p, false);
    }

    @Override
    public boolean podeApagar (PermissaoDeUsuario p)
    {
        if (validar(VALIDAR_APAGAR, p, true))
        {
            return true;
        }
        return validar(VALIDAR_APAGAR, p, false);
    }

    @Override
    public Usuario getResponsavelPelaAcao ()
    {
        return ultimoUsuarioValidado == null ? getUsuarioLogado() : ultimoUsuarioValidado;
    }

}
