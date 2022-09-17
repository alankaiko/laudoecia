/*
 * TelaSolicitante.java
 *
 * Created on 25/09/2012, 08:25:34
 */

package com.ic.projects.laudoecia.iview;

import com.lib.swing.crud.cadastro.ReceptorDeBusca;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public interface TelaSolicitante
{

    Object getParametroDeBusca ();
    int getCodigo ();
    ReceptorDeBusca getReceptorDeBusca ();

}
