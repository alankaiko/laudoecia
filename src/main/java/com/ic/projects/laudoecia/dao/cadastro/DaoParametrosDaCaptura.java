/*
 * DaoParametrosDaCaptura.java
 *
 * Created on 20/06/2012, 10:37:24
 */
package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.lib.dao.general.DaoListener;
import com.lib.dao.general.EntityListener;
import com.lib.dao.general.GenericDaoWithIntegerId;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import com.lib.icontrol.crud.cadastro.CustomException;
import javax.persistence.EntityManager;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
public class DaoParametrosDaCaptura extends GenericDaoWithIntegerId<ParametrosDaCaptura> implements DaoListener<ParametrosDaCaptura>, EntityListener<ParametrosDaCaptura>
{

    private EntityManager em;

    public DaoParametrosDaCaptura ()
    {
        super(PUs.CADASTRO_PU, ParametrosDaCaptura.class);
        addDaoListener(this);
        addEntityListener(this);
    }

    public ParametrosDaCaptura procurar (EstacaoDeTrabalho estacao)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Where("estacao"));
        qb.setParametro("estacao", estacao);
        return getSingleResult(qb);
    }

    @Override
    public void aboutToPersist (ParametrosDaCaptura entity, EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void aboutToRemove (ParametrosDaCaptura entity, EntityManager em)
    {
    }

    @Override
    public void aboutToUpdate (ParametrosDaCaptura entity, ParametrosDaCaptura originalEntity, EntityManager em)
    {
    }

    @Override
    public void persisted (ParametrosDaCaptura entity) throws CustomException
    {
        em.flush();
    }

    @Override
    public void removed (ParametrosDaCaptura entity)
    {
    }

    @Override
    public void updated (ParametrosDaCaptura entity)
    {
    }

}
