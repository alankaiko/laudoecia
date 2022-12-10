/*
 * DaoPaciente.java
 *
 * Created on 08/03/2012, 11:23:44
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDePaciente;
import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.dao.general.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoPaciente extends DaoAuditor<Paciente>
{

    private DaoImagem daoImagem;

    public DaoPaciente ()
    {
        super(Paciente.class, new AuditorDePaciente());
    }

    public List<Object[]> buscarPorNome (String busca, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome", "dataNascimento", "dataDeCadastro"),
                new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(busca, false));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNome (String busca)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("nome", "dataNascimento", "codigo"),
                new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(busca, false));
        qb.setMaxResults(25);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorDataNascimento (Date dataNasc, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome", "dataNascimento", "dataDeCadastro"),
                new Where("dataNascimento"));
        qb.setParametro("dataNascimento", dataNasc);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorDiaDeCadastro (Date dataDeCadastro, int maxResults)
    {
        if (dataDeCadastro == null)
        {
            return new ArrayList<>();
        }
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome", "dataNascimento", "dataDeCadastro"),
                new Between("dataDeCadastro"));
        Date[] intervalo = criarIntervaloDeData(dataDeCadastro);
        qb.setParametro(Between.LOWER_BOUND, intervalo[0]);
        qb.setParametro(Between.UPPER_BOUND, intervalo[1]);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (Integer codigo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome", "dataNascimento", "dataDeCadastro"),
                new Where("codigo"));
        qb.setParametro("codigo", codigo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    @Override
    public void aboutToUpdate (Paciente entity, Paciente originalEntity, EntityManager em)
    {
        super.aboutToUpdate(entity, originalEntity, em);
    }

    private DaoImagem getDaoImagem ()
    {
        if (daoImagem == null)
        {
            daoImagem = new DaoImagem();
        }
        return daoImagem;
    }

    public List<Paciente> getToRelatorio (Date dtNascDe, Date dtNascAte, UF uf, String cidade, Date dtCadDe, Date dtCadAte)
    {
        Between andDtNasc = dtNascDe == null || dtNascAte == null ? null : new Between("dataNascimento", AND, false, "dtNascDe", "dtNascAte");
        And andUF = uf == null ? null : new And("endereco.uf");
        And andCidade = cidade == null || cidade.isEmpty() ? null : new And("endereco.cidade");
        Between andDtCad = dtCadDe == null || dtCadAte == null ? null : new Between("dataDeCadastro", AND, false, "dtCadDe", "dtCadAte");

        QueryBuilder qb = new QueryBuilder(
                new Select(), new Where("nome", DIFERENTE),
                andDtNasc, andUF, andCidade, andDtCad, new OrderBy("nome"));
        qb.setParametro("nome", "");
        if (dtNascDe != null && dtNascAte != null)
        {
            qb.setParametro("dtNascDe", dtNascDe);
            qb.setParametro("dtNascAte", dtNascAte);
        }
        if (uf != null)
        {
            qb.setParametro("uf", uf);
        }
        if (cidade != null && !cidade.isEmpty())
        {
            qb.setParametro("cidade", cidade);
        }
        if (dtCadDe != null && dtCadAte != null)
        {
            qb.setParametro("dtCadDe", dtCadDe);
            qb.setParametro("dtCadAte", dtCadAte);
        }
        return getResultList(qb);
    }

    public int getCodigo (String nome, Date nasc)
    {
        if (nome == null || nome.trim().isEmpty() || nasc == null)
        {
            return 0;
        }
        QueryBuilder qb = new QueryBuilder(new Select("codigo"),
                new Where("nome"), new And("dataNascimento"));
        qb.setParametro("nome", nome);
        qb.setParametro("dataNascimento", nasc);
        List<Integer> resultList = getResultList(qb, Integer.class);
        if (resultList.isEmpty())
        {
            return 0;
        }
        return resultList.get(0);
    }

}
