/*
 * DaoAtendimento.java
 *
 * Created on 08/02/2012, 08:15:53
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeAtendimentos;
import com.ic.projects.laudoecia.dao.cadastro.DaoAcaoDoUsuario;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.lib.dao.general.Between;
import com.lib.dao.general.OrderBy;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.SqlClause;
import com.lib.dao.general.Where;
import com.lib.java.utils.DateUtils;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoAtendimento extends DaoAuditor<Atendimento>
{

    private DaoPaciente daoPac;
    private DaoProfSolicitante daoProfSol;
    private DaoAcaoDoUsuario daoAcaoDoUsuario;
    private boolean auditarAlt = true;

    public DaoAtendimento ()
    {
        super(Atendimento.class, new AuditorDeAtendimentos());
    }

    public List<Object[]> buscarPorCodigo (int codigo)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "paciente", "convenio", "dataAtendimento"),
                new Where("codigo"));
        qb.setParametro("codigo", codigo);
        return getResultList(qb, Object[].class);
    }

    @Override
    public void adicionar (Atendimento registro) throws Exception
    {
        verificarPaciente(registro.getPaciente());
        verificarProfSolicitante(registro.getSolicitante());
        super.adicionar(registro);
    }

    @Override
    public void alterar (Atendimento registro) throws Exception, EntityNotFoundException
    {
        alterar(registro, true);
    }

    @Override
    protected boolean auditar ()
    {
        return auditarAlt;
    }

    public Object[] getAtdMaisRecente ()
    {
        QueryBuilder qb = new QueryBuilder(new Select("dataAtendimento",
                "codigo"), new OrderBy(true, "dataAtendimento"));
        qb.setMaxResults(1);
        try
        {
            List<Object[]> results = getResultList(qb, Object[].class);
            if (results.isEmpty())
            {
                return null;
            }
            else
            {
                return results.get(0);
            }
        }
        catch (Exception e)
        {
            return new Object[] {new Date(0), 0};
        }
    }

    public void alterar (Atendimento registro, boolean auditar) throws Exception, EntityNotFoundException
    {
        auditarAlt = auditar;
        verificarPaciente(registro.getPaciente());
        verificarProfSolicitante(registro.getSolicitante());
        super.alterar(registro);
        auditarAlt = true;
    }

    private void verificarPaciente(Paciente pac) throws Exception
    {
        if (pac.getCodigo() == 0)
        {
            pac.setCodigo(getDaoPac().sugerirNovoID());
            pac.setDataDeCadastro(new Date());
            getDaoPac().adicionar(pac);
        }
        else
        {
            getDaoPac().alterar(pac);
        }
    }

    private void verificarProfSolicitante (ProfSolicitante prof) throws Exception
    {
        if (prof == null)
        {
        }
        else if (prof.getCodigo() == 0)
        {
            getDaoProfSol().adicionar(prof);
        }
    }

    public List<Object[]> buscarPorPaciente (String textoDaBusca)
    {
        SqlClause constraint;
        OrderBy orderBy;
        if (textoDaBusca == null || textoDaBusca.isEmpty())
        {
            constraint = new Between("dataAtendimento");
            orderBy = new OrderBy(true, "dataAtendimento");
        }
        else
        {
            constraint = new Where(true, "paciente.nome", LIKE);
            orderBy = new OrderBy("paciente.nome");
        }
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "paciente.nome", "dataAtendimento"), constraint, orderBy);
        if (textoDaBusca == null || textoDaBusca.isEmpty())
        {
            Date[] intervalo = criarIntervaloDeData(new Date());
            qb.setParametro(Between.LOWER_BOUND, intervalo[0]);
            qb.setParametro(Between.UPPER_BOUND, intervalo[1]);
        }
        else
        {
            qb.setParametro("nome", configurarParamBusca(textoDaBusca, false));
        }
        qb.setMaxResults(25);
        List<Object[]> resposta = getResultList(qb, Object[].class);
        if (resposta.isEmpty() && constraint instanceof Between)
        {
            QueryBuilder qb2 = new QueryBuilder(
                    new Select("codigo", "paciente.nome", "dataAtendimento")
                    , new OrderBy("paciente.nome"));
            return getResultList(qb2, Object[].class);
        }
        else
        {
            return resposta;
        }
    }

    @Override
    public void aboutToPersist (Atendimento atendimento, EntityManager em)
    {
        int atdComMaiorCodigo = getMaxID(em);
        int codMaxDoAtdExcluido = getDaoAcaoDoUsuario().codMaxDoAtdExcluido(em);
        atendimento.setCodigo(
                Math.max(atdComMaiorCodigo, codMaxDoAtdExcluido) + 1);
        super.aboutToPersist(atendimento, em);
    }

    public DaoPaciente getDaoPac ()
    {
        if (daoPac == null)
        {
            daoPac = new DaoPaciente();
        }
        return daoPac;
    }

    private DaoProfSolicitante getDaoProfSol ()
    {
        if (daoProfSol == null)
        {
            daoProfSol = new DaoProfSolicitante();
        }
        return daoProfSol;
    }

    private DaoAcaoDoUsuario getDaoAcaoDoUsuario ()
    {
        if (daoAcaoDoUsuario == null)
        {
            daoAcaoDoUsuario = new DaoAcaoDoUsuario();
        }
        return daoAcaoDoUsuario;
    }

    public boolean jaExisteAtdHoje (Paciente p)
    {
        QueryBuilder qb = new QueryBuilder(new Select("dataAtendimento"),
            new Where("paciente"));
        qb.setParametro("paciente", p);
        List<Date> rl = getResultList(qb, Date.class);
        Date hoje = new Date();
        int dia = DateUtils.getDayOfMonth(hoje);
        int mes = DateUtils.getMonth(hoje);
        int ano = DateUtils.getYear(hoje);
        for (Date dataAtd : rl)
        {
            int diaAtd = DateUtils.getDayOfMonth(dataAtd);
            int mesAtd = DateUtils.getMonth(dataAtd);
            int anoAtd = DateUtils.getYear(dataAtd);
            if (dia == diaAtd && mes == mesAtd && anoAtd == ano)
            {
                return true;
            }
        }
        return false;
    }

    public boolean existemMaisDe50Atd ()
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo"),
                new Where("codigo", MAIOR_IGUAL));
        qb.setMaxResults(1);
        qb.setParametro("codigo", 50);
        return !getResultList(qb, Integer.class).isEmpty();
    }

}
