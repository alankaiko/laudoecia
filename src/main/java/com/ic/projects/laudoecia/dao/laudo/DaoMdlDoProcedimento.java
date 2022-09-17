/*
 * DaoMdlDoProcedimento.java
 *
 * Created on 28/06/2012, 10:35:45
 */

package com.ic.projects.laudoecia.dao.laudo;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.lib.dao.general.*;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DaoMdlDoProcedimento extends GenericDaoWithIntegerId<ModeloDeLaudoDoProc>
{

    public DaoMdlDoProcedimento ()
    {
        super(PUs.CADASTRO_PU, ModeloDeLaudoDoProc.class);
    }

    public ModeloDeLaudoDoProc buscarModelo (ProcMedico procMedico, String descricao)
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("procMedico"), new And("descricao"));
        qb.setParametro("procMedico", procMedico);
        qb.setParametro("descricao", descricao);
        return getSingleResult(qb);
    }

    public List<ModeloDeLaudoDoProc> buscarModelos (ProcMedico procMedico, String descricao)
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("procMedico"), new And("descricao", LIKE)
                , new OrderBy("prioridade"));
        qb.setParametro("procMedico", procMedico);
        qb.setParametro("descricao", configurarParamBusca(descricao));
        return getResultList(qb, ModeloDeLaudoDoProc.class);
    }

    public List<ModeloDeLaudoDoProc> buscarModelos (ProcMedico procMedico)
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("procMedico"), new OrderBy("prioridade"));
        qb.setParametro("procMedico", procMedico);
        return getResultList(qb, ModeloDeLaudoDoProc.class);
    }

}
