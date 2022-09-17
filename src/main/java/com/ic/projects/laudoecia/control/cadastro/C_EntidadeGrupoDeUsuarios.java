/*
 * C_EntidadeGrupoDeUsuarios.java
 *
 * Created on 12/03/2012, 09:37:18
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.dao.auditable.DaoGrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_EntidadeGrupoDeUsuarios extends DefC_EntidadeComCrud<GrupoDeUsuarios, Integer>
{

    private DaoGrupoDeUsuarios dao;

    public C_EntidadeGrupoDeUsuarios (ViewEntidadeComCrud<GrupoDeUsuarios> view)
    {
        super(new DaoGrupoDeUsuarios(), view);
        dao = (DaoGrupoDeUsuarios) getDao();
    }

    @Override
    public GrupoDeUsuarios criarEntidadeParaAdicionar ()
    {
        return new GrupoDeUsuarios(dao.sugerirNovoID());
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("nome", new ValidadorDeUnicidade(
                "O nome escolhido já foi cadastrado para outro grupo de usuários!",
                new ValidadorAuxiliarDeUnicidade() {

                    @Override
                    public boolean validar (int codigo, String nome)
                    {
                        return dao.validarUnicidadeDeNome(codigo, nome);
                    }

                }));
    }

    @Override
    public void alterar (GrupoDeUsuarios entidadeBase) throws OptimisticLockException, EntityNotFoundException, Exception
    {
        super.alterar(entidadeBase);
        if (ControladorDeAcesso.getUsuarioLogado().getGrupo().equals(entidadeBase))
        {
            ControladorDeAcesso.getUsuarioLogado().setGrupo(entidadeBase);
        }
    }
    
}
