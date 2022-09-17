/*
 * DaoCRM.java
 *
 * Created on 10/02/2012, 16:02:56
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.Crm;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoCRM extends GenericDaoWithIntegerId<Crm>
{
    public DaoCRM ()
    {
        super(PUs.BASE_DE_DADOS_PU, Crm.class);
    }

    public Crm procurarPorCrmEUF (String crm, UF uf)
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("crm"), new And("uf"));
        qb.setParametro("crm", crm);
        qb.setParametro("uf", uf);
        return getSingleResult(qb);
    }

    public List<Object[]> buscarPorNome (String nome, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "crm", "nome"),
                                           new Where(true, "nome", LIKE),
                                           new And("uf"));
        qb.setParametro("nome", configurarParamBusca(nome, false));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNome (String nome, UF uf)
    {
        QueryBuilder qb = new QueryBuilder(new Select("crm", "nome"),
                                           new Where(true, "nome", LIKE),
                                           new And("uf"));
        qb.setParametro("nome", configurarParamBusca(nome));
        qb.setParametro("uf", uf);
        qb.setMaxResults(100);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCrm (String crm, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "crm", "nome"),
                                           new Where(true, "crm", LIKE),
                                           new And("uf"));
        qb.setParametro("crm", configurarParamBusca(crm, false));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNumConselho (String numConselho, UF uf)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("uf", "crm", "nome"),
                new Where(true, "crm"),
                new And("uf"));
        qb.setParametro("crm", numConselho);
        qb.setParametro("uf", uf);
        return getResultList(qb, Object[].class);
    }

}
