/*
 * DaoProfExecutante.java
 *
 * Created on 02/03/2012, 16:52:28
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeProfExecutante;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoProfExecutante extends DaoAuditor<ProfExecutante>
{
    public DaoProfExecutante ()
    {
        super(ProfExecutante.class, new AuditorDeProfExecutante());
    }

    public List<Object[]> buscarPorNomeCodigoOuNumConselho (String busca)
    {
        QueryBuilder qb;
        if (busca.matches("[0-9]+"))
        {
            qb = new QueryBuilder(
                    new Select("nome", "codigo"),
                    new Where("codigo"),
                    new Or("numNoConselho"));
            qb.setParametro("codigo", Integer.valueOf(busca));
            qb.setParametro("numNoConselho", busca);
        }
        else
        {
            qb = new QueryBuilder(
                    new Select("nome", "codigo"),
                    new Where(true, "nome", LIKE));
            qb.setParametro("nome", configurarParamBusca(busca));
        }
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNome (String nome, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome",
                "numNoConselho", "conselho", "ufConselho"),
                                           new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNroConselho (String numCons, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome",
                "numNoConselho", "conselho", "ufConselho"),
                                           new Where("numNoConselho"));
        qb.setParametro("numNoConselho", numCons);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
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

    public List<ProfExecutante> getToRelatorio (UF uf, TISS_Conselho conselho)
    {
        And andUF = uf == null ? null : new And("ufConselho");
        And andConselho = conselho == null ? null : new And("conselho");

        QueryBuilder qb = new QueryBuilder(
                new Select(), new Where("nome", DIFERENTE),
                andUF, andConselho, new OrderBy("nome"));
        qb.setParametro("nome", "");
        if (uf != null)
        {
            qb.setParametro("ufConselho", uf);
        }
        if (conselho != null)
        {
            qb.setParametro("conselho", conselho);
        }
        return getResultList(qb);
    }

}
