/*
 * C_CadastroParametrosDoSistema.java
 *
 * Created on 02/04/2012, 11:09:11
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_CadastroParametrosDoSistema extends MyC_Cadastro<ParametrosDoSistema>
{
    public C_CadastroParametrosDoSistema (ViewCadastro view, DefC_BuscaComCrud<ParametrosDoSistema, Integer> c_Busca, C_EntidadeComCrud<ParametrosDoSistema, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraParametrosDoSistema();
            }

        });
    }

}
