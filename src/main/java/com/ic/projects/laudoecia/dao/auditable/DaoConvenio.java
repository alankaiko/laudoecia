/*
 * DaoConvenio.java
 *
 * Created on 02/03/2012, 10:39:58
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeConvenios;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.cadastro.ValorFixo;
import com.lib.dao.general.*;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoConvenio extends DaoAuditor<Convenio>
{

    public DaoConvenio ()
    {
        super(Convenio.class, new AuditorDeConvenios());
    }

    public Convenio procurarPorNome (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nome);
        return getSingleResult(qb);
    }

    public List<String> buscarPorNome (String busca)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("nome"),
                new Where(true, "nome", LIKE),
                new And("ativo"),
                new OrderBy("nome"));
        qb.setParametro("nome", configurarParamBusca(busca, false));
        qb.setParametro("ativo", true);
        return getResultList(qb, String.class);
    }

    public List<Object[]> buscarConveniosPorNome (String nome)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome", "telefone", "ativo"),
                new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome, false));
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarConveniosPorCodigo (int codigo)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome", "telefone", "ativo"),
                new Where("codigo"));
        qb.setParametro("codigo", codigo);
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeNome (int codigo, String nome)
    {
        return validarUnicidade(codigo, "nome", nome);
    }

    @Override
    public void aboutToPersist (Convenio entity, EntityManager em)
    {
        super.aboutToPersist(entity, em);
        List<ProcMedico> rl = getProcsMedicos(em);
        for (Iterator<ProcMedico> it = rl.iterator(); it.hasNext();)
        {
            ProcDaTabela pdt = new ProcDaTabela();
            pdt.setProcMedico(it.next());
            pdt.setTabelaDeProcedimentos(entity.getTabelaDeProcedimentos());
            pdt.setValorNoConvenio(new ValorFixo(0));
            em.persist(pdt);
        }
    }

    @Override
    public void aboutToRemove (Convenio entity, EntityManager em)
    {
        super.aboutToRemove(entity, em);
        List<ProcMedico> rl = getProcsMedicos(em);
        for (Iterator<ProcMedico> it = rl.iterator(); it.hasNext();)
        {
            ProcDaTabela pdt = it.next().getProcDaTabela(entity);
            if (pdt == null)
            {
                // assertion error
            }
            else
            {
                em.remove(pdt);
            }
        }
    }

    private List<ProcMedico> getProcsMedicos (EntityManager em)
    {
        TypedQuery<ProcMedico> tq = em.createQuery("select object(o) from " +
                                     "ProcMedico as o", ProcMedico.class);
        return tq.getResultList();
    }

    public List<Convenio> getToRelatorio (Boolean ativo)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(), new Where("ativo"), new OrderBy("nome"));
        qb.setParametro("ativo", ativo.booleanValue());
        return getResultList(qb);
    }

}
