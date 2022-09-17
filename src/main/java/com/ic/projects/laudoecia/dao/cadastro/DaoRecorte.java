/*
 * DaoAbreviatura.java
 *
 * Created on 30/04/2014, 09:17:59
 */

package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.lib.dao.general.DaoListener;
import com.lib.dao.general.EntityListener;
import com.lib.dao.general.GenericDaoWithIntegerId;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DaoRecorte extends GenericDaoWithIntegerId<Recorte>
{

    public DaoRecorte ()
    {
        super(PUs.CADASTRO_PU, Recorte.class);
    }

    public boolean validarUnicidadeDeDesc (int codigo, String desc)
    {
        return validarUnicidade(codigo, "descricao", desc);
    }

    public List<Object[]> buscarPorDesc (String busca)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo", "descricao"),
                                           new Where("descricao", LIKE));
        qb.setParametro("descricao", busca + "%");
        return getResultList(qb, Object[].class);
    }

    public void adicionarComFlush (Recorte r)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(r);
            em.flush();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

}
