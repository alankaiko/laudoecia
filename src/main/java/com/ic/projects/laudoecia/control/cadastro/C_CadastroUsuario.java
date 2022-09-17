/*
 * C_CadastroUsuario.java
 *
 * Created on 12/03/2012, 10:06:56
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_CadastroUsuario extends MyC_Cadastro<Usuario>
{

    private boolean desabilitarAltGrupo = false;

    public C_CadastroUsuario (ViewCadastro view, DefC_BuscaComCrud<Usuario, Integer> c_Busca, C_EntidadeComCrud<Usuario, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaUsuario();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraUsuario();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaUsuario();
            }

        });
        ((C_EntidadeUsuario) c_Entidade).setC_Cadastro(this);
    }

    @Override
    public boolean validarUpdate ()
    {
        desabilitarAltGrupo = false; // for safety
        if (ControladorDeAcesso.getInstance().podeAlterar(getPdu()))
        {
            Usuario u = ControladorDeAcesso.getInstance().getResponsavelPelaAcao();
            if (u.getGrupo().getPerfilDeAcesso().isAdicionaUsuario())
            {
                return true;
            }
            else if (u.equals(getEntidadeAtual()))
            {
                desabilitarAltGrupo = true;
                return true;
            }
            else
            {
                view.mostrarMsgErro(
                        "Só é possível alterar os dados do próprio usuário!");
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    void dadosForamPreenchidos ()
    {
        if (desabilitarAltGrupo)
        {
            getEntidadeAtual().setGrupo(ControladorDeAcesso.
                getInstance().getResponsavelPelaAcao().getGrupo());
            desabilitarAltGrupo = false;
        }
    }

}
