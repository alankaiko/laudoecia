/*
 * C_CadastroProfExecutante.java
 *
 * Created on 15/03/2012, 11:25:48
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroProfExecutante extends MyC_Cadastro<ProfExecutante>
{
    public C_CadastroProfExecutante (ViewCadastro view, DefC_BuscaComCrud<ProfExecutante, Integer> c_Busca, C_EntidadeComCrud<ProfExecutante, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaProfExecutante();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraProfExecutante();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaProfExecutante();
            }

        });
    }

}
