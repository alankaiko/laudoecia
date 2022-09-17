/*
 * DaoTextoPadrao.java
 *
 * Created on 20/06/2012, 16:20:09
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeTextoPadrao;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Sql;
import com.lib.dao.general.Where;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoTextoPadrao extends DaoAuditor<TextoPadrao>
{
    public DaoTextoPadrao ()
    {
        super(TextoPadrao.class, new AuditorDeTextoPadrao());
    }

    public List<Object[]> buscarPorAbrev (String busca, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "abreviatura"),
                                           new Where(true, "abreviatura", LIKE));
        qb.setParametro("abreviatura", configurarParamBusca(busca));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (Integer codigo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "abreviatura"),
                                           new Where("codigo"));
        qb.setParametro("codigo", codigo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeAbrev (int codigo, String abrev)
    {
        return validarUnicidade(codigo, "abreviatura", abrev);
    }

    public TextoPadrao buscarTextoPelaAbrev (String abreviatura)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("abreviatura"));
        qb.setParametro("abreviatura", abreviatura);
        return getSingleResult(qb);
    }

    public List<String> buscarAbrevQueContenhaTextoEProcMed (String busca, ProcMedico proc)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("abreviatura"),
                new Where(true, "abreviatura", LIKE),
                new Sql(" AND :proc MEMBER OF entidade1.procedimentos"));
        qb.setParametro("abreviatura", configurarParamBusca(busca));
        qb.setParametro("proc", proc);

        List<String> listProc = getResultList(qb, String.class);
        List<String> listSemProc = buscarAbrevSemProcMedQueContenha(busca);
        List<String> resultList = new ArrayList<>();
        resultList.addAll(listProc);
        resultList.addAll(listSemProc);
        Collections.sort(resultList);
        return resultList;
    }

    public List<String> buscarAbrevSemProcMedQueContenha (String busca)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("abreviatura"),
                new Where(true, "abreviatura", LIKE),
                new Sql(" AND entidade1.procedimentos IS EMPTY"));
        qb.setParametro("abreviatura", configurarParamBusca(busca));
        return getResultList(qb, String.class);
    }
    
}
