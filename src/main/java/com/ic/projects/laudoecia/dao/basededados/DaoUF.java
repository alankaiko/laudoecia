/*
 * DaoUF.java
 *
 * Created on 08/02/2012, 15:10:43
 */

package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.dao.general.GenericDao;
import com.lib.dao.general.OrderBy;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DaoUF extends GenericDao<UF, String>
{

    public DaoUF ()
    {
        super(PUs.BASE_DE_DADOS_PU, UF.class, "sigla");
    }

    public List<UF> listarOrdenadoPorSigla ()
    {
        return getResultList(new QueryBuilder(new Select(), new OrderBy("sigla")));
    }

}
