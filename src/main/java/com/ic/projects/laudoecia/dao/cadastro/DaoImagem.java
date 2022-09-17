/*
 * DaoImagem.java
 *
 * Created on 23/04/2012, 15:29:28
 */

package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.cadastro.ImagemRestore;
import com.lib.dao.general.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Marcelo <marcelo@instrumental.net.br>
 */
public class DaoImagem extends GenericDaoWithIntegerId<Imagem>
{

    private final String DELETE_ORPHANS_QUERY;

    {
        // nao deleto a ultima imagem para manter a integridade do banco.
        // se o usuario fizer um restore de um arquivo mais antigo, ficarao
        // imagens sobrando na pasta de imagens. No proximo backup as novas
        // imagens nao serao exportadas por ja existirem, mas nao serao as
        // mesmas que estao no banco
        DELETE_ORPHANS_QUERY = "DELETE FROM " + nomeDaEntidade + " img" +
                " WHERE NOT EXISTS (" +
                "SELECT proc.codigo FROM ProcDoAtd proc" +
                " WHERE img MEMBER OF proc.imagens)" +
                " AND NOT EXISTS (" +
                " SELECT pac.codigo FROM Paciente pac" +
                " WHERE pac.foto = img)" +
                " AND NOT EXISTS (" +
                " SELECT imp.codigo FROM ImagemImpressa imp" +
                " WHERE imp.imagem = img)" +
                " AND img.codigo <> (" +
                "SELECT MAX(i1.codigo) FROM " +
                nomeDaEntidade + " i1)";
    }

    public DaoImagem ()
    {
        super(PUs.CADASTRO_PU, Imagem.class);
    }

    public List<Imagem> buscar100Imagens (int codInicial, List<Integer> excecoes)
    {
        if (excecoes.isEmpty())
        {
            return buscar100Imagens(codInicial);
        }
        QueryBuilder qb = new QueryBuilder(new Select(), new Between(
                nomeDaColunaId, WHERE), new In(nomeDaColunaId,
                AND, true));
        qb.setParametro(Between.LOWER_BOUND, codInicial);
        qb.setParametro(Between.UPPER_BOUND, codInicial + 99);
        qb.setParametro(In.VALORES, excecoes);
        return getResultList(qb);

    }

    public List<Imagem> buscar100Imagens (int codInicial)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new Between(
                nomeDaColunaId, WHERE));
        qb.setParametro(Between.LOWER_BOUND, codInicial);
        qb.setParametro(Between.UPPER_BOUND, codInicial + 99);
        return getResultList(qb);

    }

    public int getIndice (int codInicial)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            Query q = em.createNativeQuery("SELECT indice FROM imagem WHERE codigo = ?1");
            q.setParameter(1, codInicial);
            return (int) q.getSingleResult();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void persistirImagem (ImagemRestore imagem) throws Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(imagem);
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

    public void persistir100Imagens (List<ImagemRestore> imagens) throws Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            for (int i = 0; i < imagens.size(); i++)
            {
                em.persist(imagens.get(i));
            }
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

    public int deletarImagensOrfas ()
    {
        return executeUpdate(new QueryBuilder(new Sql(DELETE_ORPHANS_QUERY)));
    }

    public void cadastrarImagem (Imagem img, ProcDoAtd proc) throws Exception
    {
        img.setCodigo(sugerirNovoID());
        adicionar(img);
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNativeQuery("INSERT INTO procdoatd_imagem("
                    + "procdoatd_codigo, imagem_codigo) VALUES (?, ?)");
            q.setParameter(1, proc.getCodigo());
            q.setParameter(2, img.getCodigo());
            q.executeUpdate();
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
