/*
 * DaoCID10.java
 *
 * Created on 16/01/2012, 14:20:13
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.CapituloCID10;
import com.ic.projects.laudoecia.model.basededados.CategoriaCID10;
import com.ic.projects.laudoecia.model.basededados.GrupoCID10;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.lib.dao.general.*;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DaoCID10 extends GenericDao<SubcategoriaCID10, String>
{
    public DaoCID10 ()
    {
        super(PUs.BASE_DE_DADOS_PU, SubcategoriaCID10.class);
    }

    public List<Object[]> buscarPorNome (String nome, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome"),
                                           new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (String codigo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome"),
                                           new Where(true, "codigo", LIKE));
        qb.setParametro("codigo", configurarParamBusca(codigo));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCategoria (CategoriaCID10 categoria, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome"),
                new Where("categoriaCID10"));
        qb.setParametro("categoriaCID10", categoria);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorGrupo (GrupoCID10 grupo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome"),
                new Where("categoriaCID10.grupoCID10"));
        qb.setParametro("grupoCID10", grupo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCapitulo (CapituloCID10 capitulo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nome"),
                new Where("categoriaCID10.grupoCID10.capituloCID10"));
        qb.setParametro("capituloCID10", capitulo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorNomeOuCodigo (String texto)
    {
        Select sel = new Select("codigo", "nome", "nome50");
        QueryBuilder qb;
        if (texto == null || texto.isEmpty())
        {
            qb = new QueryBuilder(sel);
        }
        else
        {
            qb = new QueryBuilder(sel, new Where(true, "nome", LIKE),
                        new Or("codigo", LIKE), new Or("nome50", LIKE));
            qb.setParametro("nome", configurarParamBusca(texto));
            qb.setParametro("codigo", configurarParamBusca(texto, false));
            qb.setParametro("nome50", configurarParamBusca(texto, false));
        }
        qb.setMaxResults(100);
        return getResultList(qb, Object[].class);
    }

}