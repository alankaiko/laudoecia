/**
  * SemControle.java
  *
  * Created on 12/12/2011, 18:44:17
  */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.model.auditable.Usuario;

/**
 * Nesse caso não há controle algum de permissão de usuário. Não é necessário
 * fazer login no sistema (o sistema faz o login automaticamente utilizando um
 * usuário null - design patter null object);
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
class SemControle extends ControladorDeAcesso
{

    @Override
    public boolean criarMenusDeControleDeSessão ()
    {
        return false;
    }

    @Override
    public boolean exigirLoginAoIniciarOSistema ()
    {
        return false;
    }

    @Override
    public boolean mostrarCadastrosDoControleDeAcesso ()
    {
        return false;
    }

    @Override
    public boolean podeAcessar (PermissaoDeUsuario p)
    {
        return true;
    }

    @Override
    public boolean podeAdicionar (PermissaoDeUsuario p)
    {
        return true;
    }

    @Override
    public boolean podeAlterar (PermissaoDeUsuario p)
    {
        return true;
    }

    @Override
    public boolean podeApagar (PermissaoDeUsuario p)
    {
        return true;
    }

    @Override
    public Usuario getResponsavelPelaAcao ()
    {
        return getUsuarioLogado();
    }

}