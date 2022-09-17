/*
 * PermissaoDeUsuario.java
 *
 * Created on 12/12/2011, 07:56:11
 */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com>
 */
public interface PermissaoDeUsuario
{
    public boolean podeAcessar (PerfilDeAcesso p);
    public boolean podeAdicionar (PerfilDeAcesso p);
    public boolean podeAlterar (PerfilDeAcesso p);
    public boolean podeApagar (PerfilDeAcesso p);

}