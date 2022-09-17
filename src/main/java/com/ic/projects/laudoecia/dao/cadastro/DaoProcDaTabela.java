/*
 * DaoTabelaDeProcedimentos.java
 *
 * Created on 15/03/2012, 16:55:19
 */
package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.lib.dao.general.*;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoProcDaTabela extends GenericDaoWithIntegerId<ProcDaTabela>
{
    public DaoProcDaTabela ()
    {
        super(PUs.CADASTRO_PU, ProcDaTabela.class);
    }

    public List<ProcDaTabela> getToRelatorio (Convenio conv)
    {
        SqlClause where = conv == null ? null : new Where("tabelaDeProcedimentos.convenio");
        QueryBuilder qb = new QueryBuilder(new Select(), where,
                new OrderBy("procMedico.nome"));
        if (conv != null)
        {
            qb.setParametro("convenio", conv);
        }
        return getResultList(qb);
    }

}
