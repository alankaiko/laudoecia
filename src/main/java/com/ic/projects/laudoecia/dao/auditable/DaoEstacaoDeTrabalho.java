/*
 * DaoEstacaoDeTrabalho.java
 *
 * Created on 09/04/2012, 10:27:09
 */
package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.AuditorDeEstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoEstacaoDeTrabalho extends DaoAuditor<EstacaoDeTrabalho>
{
    public DaoEstacaoDeTrabalho ()
    {
        super(EstacaoDeTrabalho.class, new AuditorDeEstacaoDeTrabalho());
    }

    public List<Object[]> buscarEstacoesPorNome (String nome)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nomeEstacaoDeTrabalho", "serialHD"),
                new Where(true, "nomeEstacaoDeTrabalho", LIKE));
        qb.setParametro("nomeEstacaoDeTrabalho", configurarParamBusca(nome, false));
        return getResultList(qb, Object[].class);
    }

    public EstacaoDeTrabalho buscarEstacaoPorSerial (String serial)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("serialHD"));
        qb.setParametro("serialHD", serial);
        return getSingleResult(qb);
    }

    public List<Object[]> buscarEstacoesPorCodigo (int codigo)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "nomeEstacaoDeTrabalho", "serialHD"),
                new Where("codigo"));
        qb.setParametro("codigo", codigo);
        return getResultList(qb, Object[].class);
    }

    public boolean validarUnicidadeDeNome (int codigo, String nome)
    {
        return validarUnicidade(codigo, "nomeEstacaoDeTrabalho", nome);
    }

    @Override
    public void aboutToPersist (EstacaoDeTrabalho entity, EntityManager em)
    {
    }

    public int getEstLogadasCount ()
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo"),
                new Where("logado"));
        qb.setParametro("logado", true);
        return getResultList(qb, Integer.class).size();
    }

}
