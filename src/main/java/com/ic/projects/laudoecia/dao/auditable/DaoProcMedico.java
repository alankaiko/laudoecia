/*
 * DaoProcMedico.java
 *
 * Created on 14/02/2012, 11:14:06
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeProcMedico;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.lib.dao.general.OrderBy;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoProcMedico extends DaoAuditor<ProcMedico>
{

    private boolean auditar;

    public DaoProcMedico ()
    {
        this(true);
    }

    public DaoProcMedico (boolean auditar)
    {
        super(ProcMedico.class, new AuditorDeProcMedico());
        this.auditar = auditar;
    }

    public List<Object[]> buscarPorNome (String nome, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome", "grupo"),
                                           new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorGrupo (GrupoProcedimento grupo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome", "grupo"),
                                           new Where("grupo"));
        qb.setParametro("grupo", grupo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (Integer codigo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome", "grupo"),
                                           new Where("codigo"));
        qb.setParametro("codigo", codigo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public ProcMedico procurarPorNome (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nome.toUpperCase());
        return getSingleResult(qb);
    }

    public List<Object[]> buscarCandidatosPorNome (String busca)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("nome", "codigo"),
                new Where(true, "nome", LIKE),
                new OrderBy("nome"));
        qb.setParametro("nome", configurarParamBusca(busca));
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeNome (int codigo, String nome)
    {
        return validarUnicidade(codigo, "nome", nome);
    }

    @Override
    protected boolean auditar ()
    {
        return auditar;
    }

}
