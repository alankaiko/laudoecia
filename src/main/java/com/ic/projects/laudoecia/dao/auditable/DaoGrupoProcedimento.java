/*
 * DaoGrupoProcedimento.java
 *
 * Created on 14/02/2012, 14:05:46
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeGrupoDeProcedimentos;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoGrupoProcedimento extends DaoAuditor<GrupoProcedimento>
{
    public DaoGrupoProcedimento ()
    {
        super(GrupoProcedimento.class, new AuditorDeGrupoDeProcedimentos());
    }

    public GrupoProcedimento buscarGrupoPeloNome (String nomeDoGrupo)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nomeDoGrupo);
        return getSingleResult(qb);
    }

    public List<String> buscarNomesQuandoNomeComecaCom (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("nome"), new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome, false));
        return getResultList(qb, String.class);
    }

    public List<Object[]> buscarCodigoseNomesQuandoNomeComecaCom (String nome)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome"),
                new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome, false));
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarCodigoseNomesPorCodigo (Integer codigo)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome"),
                new Where("codigo"));
        qb.setParametro("codigo", codigo);
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeNome (int codigo, String nome)
    {
        return validarUnicidade(codigo, "nome", nome);
    }

}
