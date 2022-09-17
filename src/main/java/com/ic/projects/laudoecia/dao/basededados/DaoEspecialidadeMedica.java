/*
 * DaoEspecialidadeMedica.java
 *
 * Created on 10/02/2012, 11:36:07
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.EspecialidadeMedica;
import com.lib.dao.general.GenericDaoWithIntegerId;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoEspecialidadeMedica extends GenericDaoWithIntegerId<EspecialidadeMedica>
{
    public DaoEspecialidadeMedica ()
    {
        super(PUs.BASE_DE_DADOS_PU, EspecialidadeMedica.class);
    }

    public List<Object[]> buscarPorNome (String nome)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome"),
                                           new Where(true, "nome", LIKE));
        qb.setParametro("nome", configurarParamBusca(nome));
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorCodigo (Integer codigo)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "nome"),
                                           new Where("codigo"));
        qb.setParametro("codigo", codigo);
        return getResultList(qb, Object[].class);
    }

}
