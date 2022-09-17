/*
 * C_CadastroProcMedico.java
 *
 * Created on 13/03/2012, 09:52:57
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroProcMedico extends MyC_Cadastro<ProcMedico>
{
    
    public C_CadastroProcMedico (ViewCadastro view, DefC_BuscaComCrud<ProcMedico, Integer> c_Busca, C_EntidadeComCrud<ProcMedico, Integer> c_Entidade)
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
        ((C_EntidadeProcMedico) c_Entidade).setC_CadastroDeProcMedico(this);
    }

}
