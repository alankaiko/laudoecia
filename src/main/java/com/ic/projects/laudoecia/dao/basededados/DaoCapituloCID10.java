/*
 * DaoCapituloCID10.java
 *
 * Created on 10/02/2012, 10:06:34
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.CapituloCID10;
import com.lib.dao.general.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoCapituloCID10 extends GenericDao<CapituloCID10, String>
{
    public DaoCapituloCID10 ()
    {
        super(PUs.BASE_DE_DADOS_PU, CapituloCID10.class);
    }

    public CapituloCID10 buscarCapituloPeloNome (String nomeCapitulo)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nomeCapitulo);
        return getSingleResult(qb);
    }

    public List<String> buscarNomesQuandoNomeContiver (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("nome"), new Where(true, "nome", LIKE), new OrderBy("nome"));
        qb.setParametro("nome", configurarParamBusca(nome));
        return getResultList(qb, String.class);
    }

}
