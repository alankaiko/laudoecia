/*
 * C_EntidadeBackup.java
 *
 * Created on 09/04/2012, 16:35:17
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.cadastro.DaoBackup;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;
import java.util.Date;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeBackup extends DefC_EntidadeComCrud<Backup, Integer>
{
    private DaoBackup dao;

    public C_EntidadeBackup (ViewEntidadeComCrud<Backup> view)
    {
        super(new DaoBackup(), view);
        dao = (DaoBackup) getDao();
    }

    @Override
    public Backup criarEntidadeParaAdicionar ()
    {
        Backup backup = new Backup();
        backup.setTipo(TIPO_BACKUP.DADOS);
        backup.setStatus(STATUS_BACKUP.AGENDADO);
        backup.setDataMarcada(new Date());
        backup.setEstacao(StaticInfo.getEstTrabalho());
        return backup;
    }

    @Override
    protected void adicionarValidadores ()
    {
    }

    @Override
    public void apagar (Integer chavePrimaria) throws EntityNotFoundException, Exception
    {
        Backup backup = dao.procurarPorId(chavePrimaria);
        backup.setStatus(STATUS_BACKUP.CANCELADO);
        dao.alterar(backup);
    }

    @Override
    public void alterar (Backup entidadeBase) throws OptimisticLockException, EntityNotFoundException, Exception
    {
        super.alterar(entidadeBase);
        if (entidadeBase.isBackupAutomatico())
        {
            // assertion error
        }
        else
        {
            StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.BACKUP_LOCAL_MUDOU, "true");
        }
    }

    @Override
    public void adicionar (Backup entidadeBase) throws EntityExistsException, Exception
    {
        super.adicionar(entidadeBase);
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.BACKUP_LOCAL_MUDOU, "true");
    }

}
