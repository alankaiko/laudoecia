/*
 * TelaSolicitanteNull.java
 *
 * Created on 25/09/2012, 08:28:13
 */

package com.ic.projects.laudoecia.iview;

import com.lib.swing.crud.cadastro.ReceptorDeBusca;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class TelaSolicitanteNull implements TelaSolicitante
{

    @Override
    public Object getParametroDeBusca ()
    {
        return null;
    }

    @Override
    public int getCodigo ()
    {
        return TelaPrincipal.TELA_NULL;
    }

    @Override
    public ReceptorDeBusca getReceptorDeBusca ()
    {
        return null;
    }

}
