/*
 * MyC_Cadastro.java
 *
 * Created on 27/02/2012, 15:36:02
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.control.ctrlacesso.PermissaoDeUsuario;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.cadastro.DefSimpleC_Cadastro;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;
import java.io.Serializable;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class MyC_Cadastro<T extends Serializable> extends DefSimpleC_Cadastro<T, Integer>
{

    private PermissaoDeUsuario pdu;

    MyC_Cadastro (ViewCadastro view, DefC_BuscaComCrud<T, Integer> c_Busca,
                   C_EntidadeComCrud<T, Integer> c_Entidade, PermissaoDeUsuario pdu)
    {
        super(view, c_Busca, c_Entidade);
        if (pdu == null)
        {
            this.pdu = new AdapterPermissaoDeUsuario();
        }
        else
        {
            this.pdu = pdu;
        }
    }

    @Override
    public boolean validarPersist ()
    {
        return ControladorDeAcesso.getInstance().podeAdicionar(pdu);
    }

    @Override
    public boolean validarUpdate ()
    {
        return ControladorDeAcesso.getInstance().podeAlterar(pdu);
    }

    @Override
    public boolean validarApagar ()
    {
        return ControladorDeAcesso.getInstance().podeApagar(pdu);
    }

    public PermissaoDeUsuario getPdu ()
    {
        return pdu;
    }

}
