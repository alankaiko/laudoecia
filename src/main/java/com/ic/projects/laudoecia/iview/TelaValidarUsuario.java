/*
 * TelaValidarUsuario.java
 *
 * Created on 19/01/2012, 15:41:11
 */

package com.ic.projects.laudoecia.iview;

import com.lib.icontrol.autocompletar.C_AutoCompletar;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface TelaValidarUsuario extends Tela
{
    void setarBuscador (C_AutoCompletar<?> buscador);
}
