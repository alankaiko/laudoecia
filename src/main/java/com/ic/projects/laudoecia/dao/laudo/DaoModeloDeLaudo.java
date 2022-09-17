/*
 * DaoModeloDeLaudo.java
 *
 * Created on 16/03/2012, 15:45:19
 */
package com.ic.projects.laudoecia.dao.laudo;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudo;
import com.lib.dao.general.And;
import com.lib.dao.general.GenericDaoWithIntegerId;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoModeloDeLaudo extends GenericDaoWithIntegerId<ModeloDeLaudo>
{
    public DaoModeloDeLaudo ()
    {
        super(PUs.CADASTRO_PU, ModeloDeLaudo.class);
    }

    public ModeloDeLaudo buscarModeloPeloNome (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("nome"));
        qb.setParametro("nome", nome);
        return getSingleResult(qb);
    }

    public List<String> buscarNomesQuandoNomeComecaCom (String busca)
    {
        QueryBuilder qb = new QueryBuilder(new Select("nome"), new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(busca, false));
        return getResultList(qb, String.class);
    }

    public List<ModeloDeLaudo> listarModelosPlanilhados ()
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("codigo", DIFERENTE), new And("codigo", DIFERENTE, "codigo2"));
        qb.setParametro("codigo", ModeloDeLaudo.DIVERSOS);
        qb.setParametro("codigo2", ModeloDeLaudo.TEXTO_LIVRE);
        return getResultList(qb);
    }

}
