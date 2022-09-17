/*
 * C_CadastroGrupoDeProcedimentos.java
 *
 * Created on 14/03/2012, 17:49:14
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroGrupoDeProcedimentos extends MyC_Cadastro<GrupoProcedimento>
{
    public C_CadastroGrupoDeProcedimentos (ViewCadastro view, DefC_BuscaComCrud<GrupoProcedimento, Integer> c_Busca, C_EntidadeComCrud<GrupoProcedimento, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaProcMedico();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraProcMedico();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaProcMedico();
            }

        });
    }

}
