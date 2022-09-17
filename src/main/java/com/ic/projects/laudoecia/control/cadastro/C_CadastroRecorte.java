/*
 * C_CadastroRecorte.java
 *
 * Created on 20/06/2012, 16:37:14
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroRecorte extends MyC_Cadastro<Recorte>
{
    public C_CadastroRecorte (ViewCadastro view, DefC_BuscaComCrud<Recorte, Integer> c_Busca, C_EntidadeComCrud<Recorte, Integer> c_Entidade)
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
