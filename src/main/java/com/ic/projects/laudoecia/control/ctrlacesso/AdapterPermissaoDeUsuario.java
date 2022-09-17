/**
  * AdapterPermissaoDeUsuario.java
  *
  * Created on 12/12/2011, 15:33:46
  */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
public class AdapterPermissaoDeUsuario implements PermissaoDeUsuario
{

    @Override
    public boolean podeAcessar (PerfilDeAcesso p)
    {
        return false;
    }

    @Override
    public boolean podeAdicionar (PerfilDeAcesso p)
    {
        return false;
    }

    @Override
    public boolean podeAlterar (PerfilDeAcesso p)
    {
        return false;
    }

    @Override
    public boolean podeApagar (PerfilDeAcesso p)
    {
        return false;
    }

}