/*
 * DaoGrupoCID10.java
 *
 * Created on 10/02/2012, 09:44:45
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.GrupoCID10;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoGrupoCID10 extends GenericDao<GrupoCID10, String>
{
    public DaoGrupoCID10 ()
    {
        super(PUs.BASE_DE_DADOS_PU, GrupoCID10.class);
    }

    public GrupoCID10 buscarGrupoPeloNome (String nomeGrupo)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nomeGrupo);
        return getSingleResult(qb);
    }

    public List<String> buscarNomesQuandoNomeConter (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("nome"),
                new Where(true, "nome", LIKE), new OrderBy("nome"));
        qb.setParametro("nome", configurarParamBusca(nome));
        return getResultList(qb, String.class);
    }

}
