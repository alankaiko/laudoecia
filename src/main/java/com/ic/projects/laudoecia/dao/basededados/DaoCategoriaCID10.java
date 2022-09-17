/*
 * DaoCategoriaCID10.java
 *
 * Created on 09/02/2012, 15:57:59
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.CategoriaCID10;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoCategoriaCID10 extends GenericDao<CategoriaCID10, String>
{
    public DaoCategoriaCID10 ()
    {
        super(PUs.BASE_DE_DADOS_PU, CategoriaCID10.class);
    }

    public CategoriaCID10 buscarCategoriaPeloNome (String nomeCategoria)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nomeCategoria);
        return getSingleResult(qb);
    }

    public List<String> buscarNomesQuandoNomeContiver (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("nome"),
                new Where(true, "nome", LIKE), new OrderBy("nome"));
        qb.setParametro("nome", configurarParamBusca(nome));
        return getResultList(qb, String.class);
    }

}
