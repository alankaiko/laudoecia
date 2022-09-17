/*
 * UsuarioLogadoListener.java
 *
 * Created on 12/12/2011, 15:04:52
 */
package com.ic.projects.laudoecia.control.ctrlacesso;

import com.ic.projects.laudoecia.model.auditable.Usuario;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com>
 */
public interface UsuarioLogadoListener
{
    
    public void usuarioSelecionadoVaiMudar (Usuario antigo, Usuario atual);

}