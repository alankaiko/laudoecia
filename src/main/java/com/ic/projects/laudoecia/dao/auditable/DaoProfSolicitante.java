/*
 * DaoProfSolicitante.java
 *
 * Created on 13/02/2012, 15:13:09
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeProfSolicitante;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoProfSolicitante extends DaoAuditor<ProfSolicitante>
{

    public DaoProfSolicitante ()
    {
        super(ProfSolicitante.class, new AuditorDeProfSolicitante());
    }

    public List<Object[]> buscarPorNome (String nome, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo",
                "ufConselho", "conselho", "numNoConselho", "nome"),
                                           new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNome (String nome, UF uf, TISS_Conselho conselho)
    {
        QueryBuilder qb = new QueryBuilder(new Select("numNoConselho", "nome"),
                                           new Where(true, "nome", LIKE),
                                           new And("conselho"),
                                           new And("ufConselho"));
        qb.setParametro("nome", configurarParamBusca(nome));
        qb.setParametro("conselho", conselho);
        qb.setParametro("ufConselho", uf);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNroConselho (String numCons, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo",
                "ufConselho", "conselho", "numNoConselho", "nome"),
                                           new Where(true, "numNoConselho", LIKE));
        qb.setParametro("numNoConselho", configurarParamBusca(numCons, false));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNomeOuNumConselho (String busca)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("nome", "conselho", "ufConselho", "numNoConselho"),
                new Where(true, "nome", LIKE),
                new Or("numNoConselho", LIKE),
                new OrderBy("nome"));
        qb.setParametro("nome", configurarParamBusca(busca, false));
        qb.setParametro("numNoConselho", configurarParamBusca(busca, false));
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNumConselho (String busca, TISS_Conselho conselho, UF uf)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("conselho", "ufConselho", "numNoConselho", "nome"),
                new Where(true, "numNoConselho"),
                new And("conselho"), new And("ufConselho"),
                new OrderBy("numNoConselho"));
        qb.setParametro("numNoConselho", busca);
        qb.setParametro("conselho", conselho);
        qb.setParametro("ufConselho", uf);
        return getResultList(qb, Object[].class);
    }

    public ProfSolicitante procurarPorTissUfNum (TISS_Conselho conselho, UF uf, String numNoConselho)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("conselho"),
                new And("ufConselho"),
                new And("numNoConselho"));
        qb.setParametro("conselho", conselho);
        qb.setParametro("ufConselho", uf);
        qb.setParametro("numNoConselho", numNoConselho);
        return getSingleResult(qb);
    }

    public boolean validarUnicidadeDeNumNoConselho (Integer id, UF uf, TISS_Conselho conselho, String numNoConselho)
    {
        if (uf == null)
        {
            return true;
        }
        if (conselho == null)
        {
            return true;
        }
        QueryBuilder qb = new QueryBuilder(new Select(nomeDaColunaId),
                                           new Where("ufConselho"), new And("conselho"),
                                           new And("numNoConselho"));
        qb.setParametro("ufConselho", uf);
        qb.setParametro("conselho", conselho);
        qb.setParametro("numNoConselho", numNoConselho);
        qb.setMaxResults(1);
        List<Integer> lista = getResultList(qb, Integer.class);
        if (lista.isEmpty())
        {
            return true;
        }
        else if (lista.size() > 1)
        {
            return false;
        }
        else
        {
            return lista.get(0).equals(id);
        }
    }

}
