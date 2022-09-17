/*
 * BackupManager.java
 *
 * Created on 16/04/2012, 14:21:06
 */
package com.ic.projects.laudoecia.control.backup;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoEstacaoDeTrabalho;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.dao.cadastro.DaoBackup;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.cadastro.BackupAutomatico;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.lib.java.utils.DateUtils;
import com.lib.model.abstracao.DIA_DA_SEMANA;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Marcelo <marcelo@instrumentalcientifico.com.br>
 */
public class BackupManager
{

    private static DaoBackup daoBackup;

    private List<BackupTask> backupTasks = new ArrayList<>();

    private static final int REMOVER_BKP_LOCAIS = 0;
    private static final int REMOVER_BKP_AUT = 1;

    private static boolean iniciado = false;

    private BackupManager () throws IOException, InterruptedException, Exception
    {
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.BACKUP_INICIOU, "null");
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.BACKUP_TERMINOU, "null");
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.FECHAR_BKP_MANAGER, "false");
        manageStatus();
        manageAutomaticTasks();
        manageLocalTasks();
        new MonitorDePropriedades(StaticInfo.BACKUP,
                StaticInfo.BACKUP_LOCAL_MUDOU, new Runnable() {

            @Override
            public void run ()
            {
                try
                {
                    if ("true".equals(StaticInfo.lerPropriedade(
                            StaticInfo.BACKUP, StaticInfo.BACKUP_LOCAL_MUDOU)))
                    {
                        manageLocalTasks();
                    }
                }
                catch (Exception ex)
                {
                }
            }
        }).start();
        new MonitorDePropriedades(StaticInfo.BACKUP,
                StaticInfo.PARAMS_BACKUP_AUT_MUDOU, new Runnable() {

            @Override
            public void run ()
            {
                try
                {
                    if ("true".equals(StaticInfo.lerPropriedade(
                            StaticInfo.BACKUP, StaticInfo.PARAMS_BACKUP_AUT_MUDOU)))
                    {
                        manageAutomaticTasks();
                    }
                }
                catch (Exception ex)
                {
                }
            }
        }).start();
        new MonitorDePropriedades(StaticInfo.BACKUP,
                StaticInfo.FECHAR_BKP_MANAGER, new Runnable() {

            @Override
            public void run ()
            {
                try
                {
                    if ("true".equals(StaticInfo.lerPropriedade(
                            StaticInfo.BACKUP, StaticInfo.FECHAR_BKP_MANAGER)))
                    {
                        System.exit(0);
                    }
                }
                catch (Exception ex)
                {
                }
            }
        }).start();
        try
        {
//            LaudoeCia.vaccumDatabase();
        }
        catch (Exception e)
        {
            // péssima prática de programação
        }
        try
        {
            new DaoProcDoAtd().limparPessimisticLock();
            DaoEstacaoDeTrabalho d = new DaoEstacaoDeTrabalho();
            List<EstacaoDeTrabalho> ests = d.listar();
            for (EstacaoDeTrabalho et : ests)
            {
                et.setLogado(false);
            }
            d.alterar(ests);
        }
        catch (Exception e)
        {
            // péssima prática de programação
        }
    }

    private void manageStatus () throws Exception
    {
        List<Backup> backups = getDaoBackup().buscarBackupsAtrasados();
        if (backups.isEmpty())
        {
        }
        else if (backups.size() == 1)
        {
            BackupTask.createInstance(backups.get(0), this);
        }
        else
        {
            Backup backupMaisRecente = backups.get(0);
            for (int i = 1; i < backups.size(); i++)
            {
                Backup backup = backups.get(i);
                if (backup.getDataMarcada().after(backupMaisRecente.getDataMarcada()))
                {
                    backupMaisRecente = backup;
                }
            }
            for (Backup backup : backups)
            {
                if (backup != backupMaisRecente)
                {
                    backup.setStatus(STATUS_BACKUP.ERRO_DESCONHECIDO);
                    getDaoBackup().alterar(backup);
                }
            }
            BackupTask.createInstance(backupMaisRecente, this);
        }
    }

    private void manageLocalTasks () throws Exception
    {
        removeAndCancelTasks(REMOVER_BKP_LOCAIS);
        for (Backup backup : getDaoBackup().buscarBackupsLocaisAgendados())
        {
            criarTarefaDeBackup(backup);
        }
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.BACKUP_LOCAL_MUDOU, "false");
    }

    private void manageAutomaticTasks () throws Exception
    {
        getDaoBackup().apagarBackupsAutomaticosAgendados();
        removeAndCancelTasks(REMOVER_BKP_AUT);
        ParametrosDoSistema pds = StaticInfo.getParametrosDoSistema(true);
        if (pds != null && pds.isBackupAutomaticoEnabled())
        {
            BackupAutomatico backupAut = backupAutomaticoMaisProximo(pds.getBackups());
            if (backupAut != null)
            {
                Date dataMarcada = backupAut.getDiaDaSemana().proximaOcorrencia();
                dataMarcada = DateUtils.setTime(dataMarcada, backupAut.getHorario());
                Backup backup = new Backup();
                backup.setEstacao(null);
                backup.setDataMarcada(dataMarcada);
                backup.setDiretorioDoArquivo(backupAut.getDiretorioDoArquivo());
                backup.setStatus(STATUS_BACKUP.AGENDADO);
                backup.setTipo(backupAut.getTipo());
                daoBackup.adicionar(backup);
                backup.setCodigo(daoBackup.getMaxID());
                criarTarefaDeBackup(backup);
            }
        }
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                                       StaticInfo.PARAMS_BACKUP_AUT_MUDOU, "false");
    }

    private void criarTarefaDeBackup (Backup backup) throws Exception
    {
        backupTasks.add(BackupTask.createInstance(backup, this));
    }

    private void removeAndCancelTasks (int tipo)
    {
        List<BackupTask> toBeRemoved = new ArrayList<>();
        for (BackupTask backupTask : backupTasks)
        {
            boolean bkpTaskDeveSerExcluido;
            switch (tipo)
            {
                case REMOVER_BKP_LOCAIS:
                    bkpTaskDeveSerExcluido = !backupTask.getBackup().isBackupAutomatico();
                    break;
                case REMOVER_BKP_AUT:
                    bkpTaskDeveSerExcluido = backupTask.getBackup().isBackupAutomatico();
                    break;
                default:
                    throw new AssertionError();
            }
            if (bkpTaskDeveSerExcluido)
            {
                backupTask.cancel();
                toBeRemoved.add(backupTask);
            }
        }
        for (BackupTask backupTask : toBeRemoved)
        {
            backupTasks.remove(backupTask);
        }
    }

    private DaoBackup getDaoBackup ()
    {
        if (daoBackup == null)
        {
            daoBackup = new DaoBackup();
        }
        return daoBackup;
    }

    void backupTerminou (BackupTask backupTask)
    {
        backupTasks.remove(backupTask);
        if (backupTask.getBackup().isBackupAutomatico())
        {
            try
            {
                manageAutomaticTasks();
            }
            catch (Exception ex)
            {
            }
        }
    }

    public static void main (String[] args) throws IOException, InterruptedException, Exception
    {
        if (iniciado)
        {
            throw new Exception("Backup manager já foi iniciado!");
        }
        else
        {
            BackupManager backupManager = new BackupManager();
            iniciado = true;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Utils">

    private boolean validarHorario (BackupAutomatico backup)
    {
        if (backup.getDiaDaSemana() == DIA_DA_SEMANA.hoje())
        {
            return DateUtils.beforeConsiderandoSohHorario(new Date(), backup.getHorario());
        }
        else
        {
            return true;
        }
    }

    private List<BackupAutomatico> sortedBackups (List<BackupAutomatico> backups)
    {
        List<BackupAutomatico> sorted = new ArrayList<>();
        sorted.addAll(backups);
        Collections.sort(sorted, new Comparator<BackupAutomatico>(){
                @Override
                public int compare (BackupAutomatico o1, BackupAutomatico o2)
                {
                    return DateUtils.compararHorarios(o1.getHorario(), o2.getHorario());
                }

            });
        return sorted;
    }

    private BackupAutomatico backupAutomaticoMaisProximo (List<BackupAutomatico> backups)
    {
        if (backups == null || backups.isEmpty())
        {
            return null;
        }
        else if (backups.size() == 1)
        {
            return backups.get(0);
        }
        else
        {
            DIA_DA_SEMANA dds = DIA_DA_SEMANA.hoje();
            List<BackupAutomatico> sortedBackups = sortedBackups(backups);
            BackupAutomatico bkpDeHojeCujoHorarioJaPassou = null;
            do
            {
                for (int i = 0; i < sortedBackups.size(); i++)
                {
                    BackupAutomatico backup = sortedBackups.get(i);
                    if (backup.getDiaDaSemana() == dds)
                    {
                        if (validarHorario(backup))
                        {
                            return backup;
                        }
                        else if (bkpDeHojeCujoHorarioJaPassou == null)
                        {
                            bkpDeHojeCujoHorarioJaPassou = backup;
                        }
                        else
                        {
                        }
                    }
                }
            } while ((dds = dds.proximoDiaDaSemana()) != DIA_DA_SEMANA.hoje());
            return bkpDeHojeCujoHorarioJaPassou;
        }
    }

    // </editor-fold>

}