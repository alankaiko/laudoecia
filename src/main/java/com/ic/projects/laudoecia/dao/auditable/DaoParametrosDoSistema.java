/*
 * DaoParametrosDoSistema.java
 *
 * Created on 02/04/2012, 11:05:37
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeParametroDeSistemas;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.lib.dao.general.EntityListener;
import com.lib.icontrol.crud.cadastro.CustomException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DaoParametrosDoSistema extends DaoAuditor<ParametrosDoSistema>
                                    implements EntityListener<ParametrosDoSistema>
{

    private static List<EntityListener<ParametrosDoSistema>> entityListeners = new ArrayList<>();

    public DaoParametrosDoSistema ()
    {
        super(ParametrosDoSistema.class, new AuditorDeParametroDeSistemas());
        addEntityListener(this);
    }

    public static void addStaticEntityListener (EntityListener<ParametrosDoSistema> el)
    {
        entityListeners.add(el);
    }

    public static void removeStaticEntityListener (EntityListener<ParametrosDoSistema> el)
    {
        entityListeners.remove(el);
    }

    @Override
    public void persisted (ParametrosDoSistema entity) throws CustomException
    {
        for (EntityListener<ParametrosDoSistema> entityListener : entityListeners)
        {
            entityListener.persisted(entity);
        }
    }

    @Override
    public void removed (ParametrosDoSistema entity)
    {
        for (EntityListener<ParametrosDoSistema> entityListener : entityListeners)
        {
            entityListener.removed(entity);
        }
    }

    @Override
    public void updated (ParametrosDoSistema entity)
    {
        for (EntityListener<ParametrosDoSistema> entityListener : entityListeners)
        {
            entityListener.updated(entity);
        }
    }

}
