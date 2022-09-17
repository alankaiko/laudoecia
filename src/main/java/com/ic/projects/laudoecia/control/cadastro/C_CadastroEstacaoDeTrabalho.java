/*
 * C_CadastroEstacaoDeTrabalho.java
 *
 * Created on 09/04/2012, 11:17:40
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroEstacaoDeTrabalho extends MyC_Cadastro<EstacaoDeTrabalho>
{
    public C_CadastroEstacaoDeTrabalho (ViewCadastro view, DefC_BuscaComCrud<EstacaoDeTrabalho, Integer> c_Busca, C_EntidadeComCrud<EstacaoDeTrabalho, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraEstacaoDeTrabalho();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaEstacaoDeTrabalho();
            }

        });
    }

}
