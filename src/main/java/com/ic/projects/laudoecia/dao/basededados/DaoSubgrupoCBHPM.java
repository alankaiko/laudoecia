/*
 * DaoSubgrupoCBHPM.java
 *
 * Created on 17/02/2012, 10:18:18
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.SubgrupoCBHPM;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoSubgrupoCBHPM extends GenericDao<SubgrupoCBHPM, String>
{
    public DaoSubgrupoCBHPM ()
    {
        super(PUs.BASE_DE_DADOS_PU, SubgrupoCBHPM.class);
    }

    public SubgrupoCBHPM buscarSubgrupoPeloNome (String nomeDoSubgrupo)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("subgrupo"));
        qb.setParametro("subgrupo", nomeDoSubgrupo);
        return getSingleResult(qb);
    }

    public List<String> buscarSubGruposQuandoSubgrupoContiver (String textoDaBusca)
    {
        QueryBuilder qb = new QueryBuilder(new Select("subgrupo"),
                                           new Where(true, "subgrupo", LIKE),
                                           new OrderBy("subgrupo"));
        qb.setParametro("subgrupo", configurarParamBusca(textoDaBusca));
        return getResultList(qb, String.class);
    }

}
