/*
 * DaoCBHPM.java
 *
 * Created on 17/02/2012, 10:00:09
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.CBHPM;
import com.ic.projects.laudoecia.model.basededados.GrupoCBHPM;
import com.ic.projects.laudoecia.model.basededados.SubgrupoCBHPM;
import com.lib.dao.general.GenericDao;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoCBHPM extends GenericDao<CBHPM, String>
{
    public DaoCBHPM ()
    {
        super(PUs.BASE_DE_DADOS_PU, CBHPM.class);
    }

    public List<Object[]> buscarPorProcedimento (String procedimento, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "procedimento"),
                                           new Where(true, "procedimento", LIKE));
        qb.setParametro("procedimento", configurarParamBusca(procedimento));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (String codigo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "procedimento"),
                                           new Where(true, "codigo", LIKE));
        qb.setParametro("codigo", configurarParamBusca(codigo, false));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorGrupo (GrupoCBHPM grupoCBHPM, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "procedimento"),
                                           new Where("subgrupo.grupo"));
        qb.setParametro("grupo", grupoCBHPM);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorSubgrupo (SubgrupoCBHPM subgrupoCBHPM, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "procedimento"),
                                           new Where("subgrupo"));
        qb.setParametro("subgrupo", subgrupoCBHPM);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

}
