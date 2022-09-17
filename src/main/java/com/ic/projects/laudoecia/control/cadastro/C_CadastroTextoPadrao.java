/*
 * C_CadastroTextoPadrao.java
 *
 * Created on 20/06/2012, 16:37:14
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroTextoPadrao extends MyC_Cadastro<TextoPadrao>
{
    public C_CadastroTextoPadrao (ViewCadastro view, DefC_BuscaComCrud<TextoPadrao, Integer> c_Busca, C_EntidadeComCrud<TextoPadrao, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaTextoPadrao();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraTextoPadrao();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaTextoPadrao();
            }

        });
    }

}
