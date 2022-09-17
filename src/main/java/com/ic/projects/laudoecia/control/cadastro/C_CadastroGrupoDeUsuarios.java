/*
 * C_CadastroGrupoDeUsuarios.java
 *
 * Created on 12/03/2012, 09:26:38
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_CadastroGrupoDeUsuarios extends MyC_Cadastro<GrupoDeUsuarios>
{
    public C_CadastroGrupoDeUsuarios (ViewCadastro view, DefC_BuscaComCrud<GrupoDeUsuarios, Integer> c_Busca, C_EntidadeComCrud<GrupoDeUsuarios, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaGrupoDeUsuarios();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraGrupoDeUsuarios();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaGrupoDeUsuarios();
            }

        });
    }

}
