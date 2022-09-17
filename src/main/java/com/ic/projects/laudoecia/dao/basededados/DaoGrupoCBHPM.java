/*
 * DaoGrupoCBHPM.java
 *
 * Created on 17/02/2012, 10:18:06
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.GrupoCBHPM;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoGrupoCBHPM extends GenericDao<GrupoCBHPM, String>
{
    public DaoGrupoCBHPM ()
    {
        super(PUs.BASE_DE_DADOS_PU, GrupoCBHPM.class);
    }

    public GrupoCBHPM buscarGrupoPeloNome (String nomeDoGrupo)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("grupo"));
        qb.setParametro("grupo", nomeDoGrupo);
        return getSingleResult(qb);
    }

    public List<String> buscarGruposQuandoGrupoContiver (String textoDaBusca)
    {
        QueryBuilder qb = new QueryBuilder(new Select("grupo"),
                                           new Where(true, "grupo", LIKE),
                                           new OrderBy("grupo"));
        qb.setParametro("grupo", configurarParamBusca(textoDaBusca));
        return getResultList(qb, String.class);
    }

}
