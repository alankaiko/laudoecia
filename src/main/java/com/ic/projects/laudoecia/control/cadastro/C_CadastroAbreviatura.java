/*
 * C_CadastroAbreviatura.java
 *
 * Created on 20/06/2012, 16:37:14
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroAbreviatura extends MyC_Cadastro<Abreviatura>
{
    public C_CadastroAbreviatura (ViewCadastro view, DefC_BuscaComCrud<Abreviatura, Integer> c_Busca, C_EntidadeComCrud<Abreviatura, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return true;
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return true;
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return true;
            }

        });
    }

}
