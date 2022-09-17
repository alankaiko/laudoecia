/*
 * DaoBackup.java
 *
 * Created on 09/04/2012, 10:27:09
 */
package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.lib.dao.general.*;
import com.lib.java.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcelol-IC
 */
public class DaoBackup extends GenericDaoWithIntegerId<Backup>
{
    public DaoBackup ()
    {
        super(PUs.CADASTRO_PU, Backup.class);
    }

    public List<Object[]> buscarTodosNaoCancelados (int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "dataMarcada", "tipo", "diretorioDoArquivo", "status"),
                new Where("status", DIFERENTE),
                new OrderBy(true, "dataMarcada"));
        qb.setParametro("status", STATUS_BACKUP.CANCELADO);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarBackupsPorMarcada (Date data, int maxResults)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date dataInicial = c.getTime();
        Date dataFinal = DateUtils.adicionarDiasNaData(dataInicial, 1);
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "dataMarcada", "tipo", "diretorioDoArquivo", "status"),
                new Between("dataMarcada"),
                new And("status", DIFERENTE),
                new OrderBy(true, "dataMarcada"));
        qb.setParametro(Between.LOWER_BOUND, dataInicial);
        qb.setParametro(Between.UPPER_BOUND, dataFinal);
        qb.setParametro("status", STATUS_BACKUP.CANCELADO);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarBackupsPorStatus (STATUS_BACKUP status, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "dataMarcada", "tipo", "diretorioDoArquivo", "status"),
                new Where("status"),
                new OrderBy(true, "dataMarcada"));
        qb.setParametro("status", status);
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Backup> buscarBackupsAtrasados ()
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("status", "agendado").setOrs(
                new Or("status", "andamento")), new And(
                "dataMarcada", MENOR));
        qb.setParametro("agendado", STATUS_BACKUP.AGENDADO);
        qb.setParametro("andamento", STATUS_BACKUP.EM_ANDAMENTO);
        qb.setParametro("dataMarcada", new Date());
        return getResultList(qb);
    }

    public Backup buscarBackupPelaDataMarcada (Date data)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select(),
                new Where("dataMarcada"));
        qb.setParametro("dataMarcada", data);
        return getSingleResult(qb);
    }

    public List<Backup> buscarBackupsLocaisAgendados ()
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("status"), new And("estacao", IS_NOT_NULL));
        qb.setParametro("status", STATUS_BACKUP.AGENDADO);
        return getResultList(qb);
    }

    public void apagarBackupsAutomaticosAgendados () throws Exception
    {
        QueryBuilder qb = new QueryBuilder(new Select(),
                new Where("estacao", IS_NULL), new And("status"));
        qb.setParametro("status", STATUS_BACKUP.AGENDADO);
        for (Backup backup : getResultList(qb))
        {
            apagar(backup.getCodigo());
        }
    }

}
