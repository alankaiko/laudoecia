/*
 * C_CadastroConvenio.java
 *
 * Created on 15/03/2012, 09:38:36
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroConvenio extends MyC_Cadastro<Convenio>
{
    public C_CadastroConvenio (ViewCadastro view, DefC_BuscaComCrud<Convenio, Integer> c_Busca, C_EntidadeComCrud<Convenio, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaConvenio();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraConvenio();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaConvenio();
            }

        });
    }

}
