/*
 * C_CadastroPaciente.java
 *
 * Created on 13/03/2012, 09:01:48
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroPaciente extends MyC_Cadastro<Paciente>
{
    public C_CadastroPaciente (ViewCadastro view,
                               DefC_BuscaComCrud<Paciente, Integer> c_Busca,
                               C_EntidadeComCrud<Paciente, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaPaciente();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraPaciente();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaPaciente();
            }

        });
        ((C_EntidadePaciente) c_Entidade).setC_CadastroDePaciente(this);
    }

    public void verPaciente (Paciente p)
    {
        cancelar(false);
        c_BuscaComCrud.adicionarESelecionarResultado(p);
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                view.selecionarBtn(ViewCadastro.BTN_ALTERAR);
            }
            
        });
    }

}
