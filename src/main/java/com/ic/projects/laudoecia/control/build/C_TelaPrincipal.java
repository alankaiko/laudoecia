/*
 * C_TelaPrincipal.java
 *
 * Created on 19/01/2012, 15:15:07
 */

package com.ic.projects.laudoecia.control.build;

import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.iview.TelaPrincipal;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_TelaPrincipal
{
    private TelaPrincipal telaPrincipal;

    public C_TelaPrincipal (TelaPrincipal telaPrincipal)
    {
        this.telaPrincipal = telaPrincipal;
    }

    public void suspenderSessao ()
    {
        ControladorDeAcesso.setUsuarioLogado(null);
        telaPrincipal.exigirLoginDoUsuario();
    }
    
}
