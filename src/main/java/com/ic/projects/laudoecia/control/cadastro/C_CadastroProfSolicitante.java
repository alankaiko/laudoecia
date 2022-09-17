/*
 * C_CadastroProfSolicitante.java
 *
 * Created on 12/03/2012, 17:33:58
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroProfSolicitante extends MyC_Cadastro<ProfSolicitante>
{
    public C_CadastroProfSolicitante (ViewCadastro view, DefC_BuscaComCrud<ProfSolicitante, Integer> c_Busca, C_EntidadeComCrud<ProfSolicitante, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaProfSolicitante();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraProfSolicitante();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaProfSolicitante();
            }

        });
    }

}
