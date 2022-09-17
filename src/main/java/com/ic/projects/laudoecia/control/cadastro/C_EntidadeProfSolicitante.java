/*
 * C_EntidadeProfSolicitante.java
 *
 * Created on 12/03/2012, 17:21:51
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.validacao.ValidadorDeUnicidadeProfSol;
import com.ic.projects.laudoecia.dao.auditable.DaoProfSolicitante;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeProfSolicitante extends DefC_EntidadeComCrud<ProfSolicitante, Integer>
{
    private DaoProfSolicitante dao;

    public C_EntidadeProfSolicitante (ViewEntidadeComCrud<ProfSolicitante> view)
    {
        super(new DaoProfSolicitante(), view);
        dao = (DaoProfSolicitante) getDao();
    }

    @Override
    public ProfSolicitante criarEntidadeParaAdicionar ()
    {
        return new ProfSolicitante(dao.sugerirNovoID());
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("numNoConselho", new ValidadorDeUnicidadeProfSol((DaoProfSolicitante) getDao()));
    }

}
