/*
 * C_CadastroParametrosDaCaptura.java
 *
 * Created on 25/07/2012, 14:56:58
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroParametrosDaCaptura extends MyC_Cadastro<ParametrosDaCaptura>
{
    public C_CadastroParametrosDaCaptura (ViewCadastro view, DefC_BuscaComCrud<ParametrosDaCaptura, Integer> c_Busca, C_EntidadeComCrud<ParametrosDaCaptura, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraParametrosDaCaptura();
            }

        });
    }

}
