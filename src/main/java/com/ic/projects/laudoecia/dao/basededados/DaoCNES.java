/*
 * DaoCNES.java
 *
 * Created on 23/02/2012, 09:07:25
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.CNES;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoCNES extends GenericDao<CNES, String>
{
    public DaoCNES ()
    {
        super(PUs.BASE_DE_DADOS_PU, CNES.class);
    }

    public List<Object[]> buscarPorNomeFantasia (String nomeFantasia, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "razaoSocial"),
                                           new Where(true, "nomeFantasia", LIKE),
                                           new And("uf"));
        qb.setParametro("nomeFantasia", configurarParamBusca(nomeFantasia));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorRazaoSocial (String razaoSocial, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "razaoSocial"),
                                           new Where(true, "razaoSocial", LIKE),
                                           new And("uf"));
        qb.setParametro("razaoSocial", configurarParamBusca(razaoSocial));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCNES (String cnes, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "razaoSocial"),
                                           new Where(true, "codigo", LIKE),
                                           new And("uf"));
        qb.setParametro("codigo", configurarParamBusca(cnes));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCNPJ (String cnpj, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "razaoSocial"),
                                           new Where(true, "cnpj", LIKE),
                                           new And("uf"));
        qb.setParametro("cnpj", configurarParamBusca(cnpj));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCPF (String cpf, UF uf, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "uf", "razaoSocial"),
                                           new Where(true, "cpf", LIKE),
                                           new And("uf"));
        qb.setParametro("cpf", configurarParamBusca(cpf));
        qb.setParametro("uf", uf);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

}
