/*
 * C_CadastroLicenciado.java
 *
 * Created on 04/04/2012, 11:29:24
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroLicenciado extends MyC_Cadastro<Licenciado>
{
    public C_CadastroLicenciado (ViewCadastro view, DefC_BuscaComCrud<Licenciado, Integer> c_Busca, C_EntidadeComCrud<Licenciado, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraLicenciado();
            }

        });
    }

}
