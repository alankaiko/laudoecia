/*
 * DaoGrupoDeUsuarios.java
 *
 * Created on 06/01/2012, 11:36:07
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeGrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.lib.dao.general.And;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 *
 * @author Danilo Brito
 */
public class DaoGrupoDeUsuarios extends DaoAuditor<GrupoDeUsuarios>
{

    public DaoGrupoDeUsuarios ()
    {
        super(GrupoDeUsuarios.class, new AuditorDeGrupoDeUsuarios());
    }

    public GrupoDeUsuarios buscarGrupoPeloNome (String nomeDoGrupo)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nomeDoGrupo);
        return getSingleResult(qb);
    }

    public List<String> buscarNomesQuandoNomeComecaCom (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("nome"), new
                Where(true, "nome", LIKE), new And("codigo", DIFERENTE));
        qb.setParametro("nome", configurarParamBusca(nome, false));
        qb.setParametro("codigo", GrupoDeUsuarios.CODIGO_SUPORTE);
        return getResultList(qb, String.class);
    }

    public List<Object[]> buscarCodigoseNomesQuandoNomeComecaCom (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome"), new
                Where(true, "nome", LIKE), new And("codigo", DIFERENTE));
        qb.setParametro("nome", configurarParamBusca(nome, false));
        qb.setParametro("codigo", GrupoDeUsuarios.CODIGO_SUPORTE);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarCodigoseNomesPorCodigo (int codigo)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome"), new
                Where("codigo", "cod1"), new And("codigo", DIFERENTE, "cod2"));
        qb.setParametro("cod1", codigo);
        qb.setParametro("cod2", GrupoDeUsuarios.CODIGO_SUPORTE);
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeNome (int codigo, String nome)
    {
        return validarUnicidade(codigo, "nome", nome);
    }

}
