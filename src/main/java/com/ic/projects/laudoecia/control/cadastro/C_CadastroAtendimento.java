/*
 * C_CadastroAtendimento.java
 *
 * Created on 23/04/2012, 09:45:20
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.cadastro.CustomException;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;
import javax.persistence.EntityExistsException;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroAtendimento extends MyC_Cadastro<Atendimento>
{

    public C_CadastroAtendimento (ViewCadastro view, DefC_BuscaComCrud<Atendimento, Integer> c_Busca, C_EntidadeComCrud<Atendimento, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaAtendimento();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraAtendimento();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaAtendimento();
            }
        });
        ((C_EntidadeAtendimento) c_Entidade).setC_Cadastro(this);
    }

    @Override
    protected String getMsgConfirmacaoDeExclusaoDeReg ()
    {
        return "<html>Tem certeza que deseja excluir o <b><font color="
                + "\"ff0000\">ATENDIMENTO</b></font> selecionado?</html>";
    }

    @Override
    protected boolean tryToPersist ()
    {
        try
        {
            c_EntidadeComCrud.adicionar(entidadeAtual);
            return true;
        }
        catch (EntityExistsException eee)
        {
            view.mostrarMsgErro("A entidade já existe no banco de dados");
        }
        catch (CustomException ce)
        {
            view.mostrarMsgErro(ce.getMessage());
            view.minimize();
        }
        catch (Exception e)
        {
            view.mostrarMsgDeErroDesconhecido();
        }
        return false;
    }

}
