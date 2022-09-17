/*
 * DaoAbreviatura.java
 *
 * Created on 30/04/2014, 09:17:59
 */

package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
import com.lib.dao.general.GenericDaoWithIntegerId;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DaoAbreviatura extends GenericDaoWithIntegerId<Abreviatura>
{

    public DaoAbreviatura ()
    {
        super(PUs.CADASTRO_PU, Abreviatura.class);
    }

    public List<Object[]> buscarPorAbrev (String busca, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "abreviatura"),
                                           new Where(true, "abreviatura", LIKE));
        qb.setParametro("abreviatura", configurarParamBusca(busca));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (Integer codigo, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "abreviatura"),
                                           new Where("codigo"));
        qb.setParametro("codigo", codigo);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeAbrev (int codigo, String abrev)
    {
        return validarUnicidade(codigo, "abreviatura", abrev);
    }

    public List<Object[]> buscarPorAbrev (String busca)
    {
        QueryBuilder qb = new QueryBuilder(new Select("abreviatura", "texto"),
                                           new Where("abreviatura", LIKE));
        qb.setParametro("abreviatura", busca + "%");
        return getResultList(qb, Object[].class);
    }

}
