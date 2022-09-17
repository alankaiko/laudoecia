/*
 * DaoLicenciado.java
 *
 * Created on 04/04/2012, 11:35:06
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeLicenciado;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.lib.dao.general.EntityListener;
import com.lib.icontrol.crud.cadastro.CustomException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoLicenciado extends DaoAuditor<Licenciado>
        implements EntityListener<Licenciado>
{
    private static List<EntityListener<Licenciado>> entityListeners = new ArrayList<>();

    public DaoLicenciado ()
    {
        super(Licenciado.class, new AuditorDeLicenciado());
        addEntityListener(this);
    }

    public static void addStaticEntityListener (EntityListener<Licenciado> el)
    {
        entityListeners.add(el);
    }

    public static void removeStaticEntityListener (EntityListener<Licenciado> el)
    {
        entityListeners.remove(el);
    }

    @Override
    public void persisted (Licenciado entity) throws CustomException
    {
        for (EntityListener<Licenciado> entityListener : entityListeners)
        {
            entityListener.persisted(entity);
        }
    }

    @Override
    public void removed (Licenciado entity)
    {
        for (EntityListener<Licenciado> entityListener : entityListeners)
        {
            entityListener.removed(entity);
        }
    }

    @Override
    public void updated (Licenciado entity)
    {
        for (EntityListener<Licenciado> entityListener : entityListeners)
        {
            entityListener.updated(entity);
        }
    }

}
