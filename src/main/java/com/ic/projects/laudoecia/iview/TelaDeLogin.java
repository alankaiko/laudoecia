/*
 * TelaDeLogin.java
 *
 * Created on 16/12/2011, 18:24:33
 */
package com.ic.projects.laudoecia.iview;

import com.lib.icontrol.autocompletar.C_AutoCompletar;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com>
 */
public interface TelaDeLogin extends Tela
{
    void setarBuscador (C_AutoCompletar<?> buscador);
    void informarQueOLoginEhObrigatorio ();
}
