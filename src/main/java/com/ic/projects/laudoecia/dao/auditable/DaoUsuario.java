/*
 * DaoUsuario.java
 *
 * Created on 04/01/2012, 10:13:43
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito
 */
public class DaoUsuario extends DaoAuditor<Usuario>
{

    public DaoUsuario ()
    {
        super(Usuario.class, new AuditorDeUsuarios());
    }

    public List<String> buscarPorLogin (String login)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("login"),
                new Where(true, "login", LIKE),
                new And("ativo", "ativo"),
                new And("codigo", DIFERENTE, "codigoUsSuporte"),
                new And("codigo", DIFERENTE, "codigoUsNull"),
                new OrderBy("login"));
        qb.setParametro("login", configurarParamBusca(login, false));
        qb.setParametro("ativo", true);
        qb.setParametro("codigoUsSuporte", Usuario.CODIGO_SUPORTE);
        qb.setParametro("codigoUsNull", Usuario.CODIGO_NULL);
        return getResultList(qb, String.class);
    }

    public List<Object[]> buscarPorNomeOuLogin (String busca)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome",
                "dataDeCadastro", "ativo"),
                new Where(true, "nome", LIKE).setOrs(
                new Or(true, "login", LIKE)),
                new And("codigo", DIFERENTE, "codigoUsSuporte"),
                new And("codigo", DIFERENTE, "codigoUsNull"));
        qb.setParametro("nome", configurarParamBusca(busca));
        qb.setParametro("login", configurarParamBusca(busca));
        qb.setParametro("codigoUsSuporte", Usuario.CODIGO_SUPORTE);
        qb.setParametro("codigoUsNull", Usuario.CODIGO_NULL);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorGrupo (GrupoDeUsuarios grupo)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome",
                "dataDeCadastro", "ativo"), new Where("grupo"));
        qb.setParametro("grupo", grupo);
        return getResultList(qb, Object[].class);
    }

    public Usuario buscarDonoDoLogin (String login)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("login"));
        qb.setParametro("login", login.toUpperCase());
        return getSingleResult(qb);
    }

    public boolean validarUnicidadeDeLogin (int codigo, String login)
    {
        return validarUnicidade(codigo, "login", login);
    }

}
