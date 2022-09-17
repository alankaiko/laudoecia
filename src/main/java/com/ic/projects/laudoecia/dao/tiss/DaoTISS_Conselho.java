/*
 * DaoTISS_Conselho.java
 *
 * Created on 13/02/2012, 16:32:22
 */
package com.ic.projects.laudoecia.dao.tiss;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.dao.general.GenericDao;
import com.lib.dao.general.OrderBy;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoTISS_Conselho extends GenericDao<TISS_Conselho, String>
{
    public DaoTISS_Conselho ()
    {
        super(PUs.BASE_DE_DADOS_PU, TISS_Conselho.class);
    }

    public List<TISS_Conselho> listarOrdenadoPorSigla ()
    {
        return getResultList(new QueryBuilder(new Select(), new OrderBy("sigla")));
    }

}
