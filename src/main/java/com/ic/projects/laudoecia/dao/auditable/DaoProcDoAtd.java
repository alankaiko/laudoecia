/*
 * DaoProcDoAtd.java
 *
 * Created on 07/02/2012, 11:49:59
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeProcDoAtd;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.*;
import com.ic.projects.laudoecia.model.enums.STATUS_LAUDO;
import com.lib.dao.general.*;
import com.lib.java.utils.DateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoProcDoAtd extends DaoAuditor<ProcDoAtd>
{

    private EntityManager em = null;

    public DaoProcDoAtd ()
    {
        super(ProcDoAtd.class, new AuditorDeProcDoAtd());
    }

    public List<ProcDoAtd> buscarTodosPorData (Date dataIni, Date dataFin, String statusLaudo)
    {
        And wStatusLaudo = null;
        if (STATUS_LAUDO.PENDENTE.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NULL);
        }
        if (STATUS_LAUDO.PRONTO.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NOT_NULL);
        }

        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("procDaTabela.procMedico.codigo", DIFERENTE, "codigo"),
                new Between("atendimento.dataAtendimento", AND), wStatusLaudo);
        qb.setParametro(Between.LOWER_BOUND, dataIni);
        qb.setParametro("codigo", StaticInfo.receituario());
        qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        return getResultList(qb);
    }

    public List<ProcDoAtd> buscarPorProcedimentoEData (ProcMedico proMed, Date dataIni, Date dataFin)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("procDaTabela.procMedico"),
                new Between("atendimento.dataAtendimento", AND));
        qb.setParametro("procMedico", proMed);
        qb.setParametro(Between.LOWER_BOUND, dataIni);
        qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        return getResultList(qb);
    }

    public List<ProcDoAtd> buscarPorConvenioEData (Convenio convenio, Date dataIni, Date dataFin)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("atendimento.convenio"),
                new Between("atendimento.dataAtendimento", AND));
        qb.setParametro("convenio", convenio);
        qb.setParametro(Between.LOWER_BOUND, dataIni);
        qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        return getResultList(qb);
    }

    public List<ProcDoAtd> buscarPorProfExecutanteEData (ProfExecutante prof, Date dataIni, Date dataFin)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("profExecutante"),
                new Between("atendimento.dataAtendimento", AND));
        qb.setParametro("profExecutante", prof);
        qb.setParametro(Between.LOWER_BOUND, dataIni);
        qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        return getResultList(qb);
    }

    public List<ProcDoAtd> buscarPorProfSolicitanteEData (ProfSolicitante prof, Date dataIni, Date dataFin)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("atendimento.solicitante"),
                new Between("atendimento.dataAtendimento", AND));
        qb.setParametro("solicitante", prof);
        qb.setParametro(Between.LOWER_BOUND, dataIni);
        qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        return getResultList(qb);
    }

    public List<Object[]> buscarUltimos (Date dataIni, Date dataFin, String statusLaudo, int maxResults)
    {
        Between wDatas = dataIni == null || dataFin == null ? null : new Between("atendimento.dataAtendimento", AND);
        And wStatusLaudo = null;
        if (STATUS_LAUDO.PENDENTE.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NULL);
        }
        if (STATUS_LAUDO.PRONTO.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NOT_NULL);
        }

        QueryBuilder qb = new QueryBuilder(
                new Select(true, "atendimento.codigo", "atendimento.paciente",
                           "atendimento.convenio", "atendimento.dataAtendimento"),
                new Where("atendimento.codigo", DIFERENTE, "cod"),
                wDatas, wStatusLaudo,
                new OrderBy(true, "atendimento.dataAtendimento"));
        qb.setParametro("cod", 0);
        if (wDatas != null)
        {
            qb.setParametro(Between.LOWER_BOUND, dataIni);
            qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        }
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorPaciente (Paciente pac, Date dataIni, Date dataFin, String statusLaudo, int maxResults)
    {
        Between wDatas = dataIni == null || dataFin == null ? null : new Between("atendimento.dataAtendimento", AND);
        And wStatusLaudo = null;
        if (STATUS_LAUDO.PENDENTE.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NULL);
        }
        if (STATUS_LAUDO.PRONTO.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NOT_NULL);
        }

        QueryBuilder qb = new QueryBuilder(
                new Select(true, "atendimento.codigo", "atendimento.paciente",
                           "atendimento.convenio", "atendimento.dataAtendimento"),
                new Where("atendimento.paciente", "paciente"),
                wDatas, wStatusLaudo,
                new OrderBy(true, "atendimento.dataAtendimento"));
        qb.setParametro("paciente", pac);
        if (wDatas != null)
        {
            qb.setParametro(Between.LOWER_BOUND, dataIni);
            qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        }
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorProfExecutante (ProfExecutante prof, Date dataIni, Date dataFin, String statusLaudo, int maxResults)
    {
        Between wDatas = dataIni == null || dataFin == null ? null : new Between("atendimento.dataAtendimento", AND);
        And wStatusLaudo = null;
        if (STATUS_LAUDO.PENDENTE.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NULL);
        }
        if (STATUS_LAUDO.PRONTO.toString().equalsIgnoreCase(statusLaudo))
        {
            wStatusLaudo = new And("laudo", IS_NOT_NULL);
        }
        QueryBuilder qb = new QueryBuilder(
                new Select(true, "atendimento.codigo", "atendimento.paciente",
                           "atendimento.convenio", "atendimento.dataAtendimento"),
                new Where("profExecutante"),
                wDatas, wStatusLaudo,
                new OrderBy(true, "atendimento.dataAtendimento"));
        qb.setParametro("profExecutante", prof);
        if (wDatas != null)
        {
            qb.setParametro(Between.LOWER_BOUND, dataIni);
            qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataFin, 1));
        }
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<ProcDoAtd> buscarPorCodAtdEDataLimite (List<Integer> listCodAtd, Date dataLimite)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new In("atendimento.codigo"),
                new And("dataDaExecucao", MENOR));
        qb.setParametro(In.VALORES, listCodAtd);
        qb.setParametro("dataDaExecucao", dataLimite);
        return getResultList(qb);
    }

    public void limparPessimisticLock (int codigo) throws Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNativeQuery(
                    "update procdoatd set estacao_codigo = null where codigo = ?");
            q.setParameter(1, codigo);
            q.executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void limparPessimisticLock () throws Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNativeQuery(
                    "update procdoatd set estacao_codigo = null");
            q.executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void lock (int codigo, int estacao)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNativeQuery(
                    "update procdoatd set estacao_codigo = ? where codigo = ?");
            q.setParameter(1, estacao);
            q.setParameter(2, codigo);
            q.executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    @Override
    protected String getCodigoDoRegistro (ProcDoAtd entity, EntityManager em)
    {
        int codigo = entity.getAtendimento() == null ? entity.getCodigo() :
               entity.getAtendimento().getCodigo();
        return String.valueOf(codigo);
    }

    public void limparLockEstacao (int codigo)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNativeQuery(
                    "update procdoatd set estacao_codigo = null where estacao_codigo = ?");
            q.setParameter(1, codigo);
            q.executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public EstacaoDeTrabalho getEstacao (int codigo)
    {
        if (codigo == 0)
        {
            return null;
        }
        QueryBuilder qb = new QueryBuilder(
                new Select("estacao"),
                new Where("codigo"));
        qb.setParametro("codigo", codigo);
        return getSingleResult(qb, EstacaoDeTrabalho.class);
    }

    public List<Object[]> listarExames (Paciente paciente)
    {
        if (paciente == null)
        {
            return new ArrayList<>();
        }
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "atendimento.codigo", "dataDaExecucao",
                        "procDaTabela.procMedico.nome"),
                new Where("atendimento.paciente"));
        qb.setParametro("paciente", paciente);
        return getResultList(qb, Object[].class);
    }

}
