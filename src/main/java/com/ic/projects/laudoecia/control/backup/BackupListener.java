/*
 * BackupListener.java
 *
 * Created on 25/04/2012, 08:51:53
 */

package com.ic.projects.laudoecia.control.backup;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.cadastro.DaoBackup;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class BackupListener
{

    private DaoBackup daoBackup = new DaoBackup();
    private static List<BackupStatusListener> listeners = new ArrayList<>();

    private BackupListener () throws IOException, InterruptedException
    {
        new MonitorDePropriedades(StaticInfo.BACKUP, StaticInfo.BACKUP_INICIOU,
                new Runnable() {

            @Override
            public void run ()
            {
                try
                {
                    backupIniciou();
                }
                catch (IOException ex)
                {
                }
            }
        }).start();
        new MonitorDePropriedades(StaticInfo.BACKUP, StaticInfo.BACKUP_TERMINOU,
                new Runnable() {

            @Override
            public void run ()
            {
                try
                {
                    backupTerminou();
                }
                catch (IOException ex)
                {
                }
            }
        }).start();
    }

    private void backupIniciou () throws IOException
    {
        Backup backup = getBackup(StaticInfo.BACKUP_INICIOU);
        if (backup == null)
        {
        }
        else if (StaticInfo.getEstTrabalho().equals(backup.getEstacao()))
        {
            if (STATUS_BACKUP.EM_ANDAMENTO.equals(backup.getStatus()))
            {
                LaudoeCia.getTelaPrincipal().iniciarTarefa("Realizando backup...");
                for (int i = 0; i < listeners.size(); i++)
                {
                    listeners.get(i).backupIniciou(backup);
                }
            }
//            StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
//                       StaticInfo.BACKUP_INICIOU, "null");
        }
        else
        {
        }
    }

    private void backupTerminou () throws IOException
    {
        Backup backup = getBackup(StaticInfo.BACKUP_TERMINOU);
        if (backup == null)
        {
        }
        else if (StaticInfo.getEstTrabalho().equals(backup.getEstacao()))
        {
//            StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
//                       StaticInfo.BACKUP_TERMINOU, "null");
            STATUS_BACKUP status = backup.getStatus();
            if (status == STATUS_BACKUP.EM_ANDAMENTO ||
                status == STATUS_BACKUP.REALIZADO_COM_SUCESSO)
            {
                if (copiarBackupDoServidorOk(backup))
                {
                    backup.setDataDeTermino(new Date());
                    alterarStatusDoBackup(backup, STATUS_BACKUP.REALIZADO_COM_SUCESSO);
                    LaudoeCia.getTelaPrincipal().terminarTarefa("Backup realizado com sucesso!");
                }
                else
                {
                    alterarStatusDoBackup(backup, STATUS_BACKUP.ERRO_AO_MOVER_BACKUP_LOCAL);
                    LaudoeCia.getTelaPrincipal().terminarTarefa("Erro ao mover o backup."
                            + " O backup encontra-se na pasta de instalação "
                            + "do sistema.");
                }
            }
            else if (status.isStatusDeErro())
            {
                LaudoeCia.getTelaPrincipal().terminarTarefa("Erro ao realizar backup! "
                        + status.getMensagem());
            }
            else
            {
                LaudoeCia.getTelaPrincipal().terminarTarefa("Erro do sistema!");
            }
            for (int i = 0; i < listeners.size(); i++)
            {
                listeners.get(i).backupTerminou(backup);
            }
        }
        else
        {
        }
    }

    private boolean copiarBackupDoServidorOk (Backup backup)
    {
        File arquivoBackup;
        File pastaDeImagens;
        try
        {
            arquivoBackup = new File(StaticInfo.getPastaTemp() + backup.fileName());
            pastaDeImagens = new File(StaticInfo.getPastaTempImagens());
            if (arquivoBackup.exists())
            {
                Files.copy(arquivoBackup.toPath(),
                           Paths.get(backup.getDiretorioDoArquivo(), backup.fileName())
                           , StandardCopyOption.REPLACE_EXISTING);
                if (backup.getTipo() == TIPO_BACKUP.DADOS_E_IMAGENS)
                {
                    if (pastaDeImagens.exists())
                    {
                        Path sourceImg = pastaDeImagens.toPath();
                        Path destImg = Paths.get(backup.pastaDeImagens());
                        Files.walkFileTree(sourceImg,
                                           new CopyDirVisitor(sourceImg, destImg));
                    }
                }
            }
            else
            {
                // retorna true se essa estacao de trabalho eh o proprio servidor,
                // portanto o bkp foi feito diretamente na pasta de destino
                return new File(backup.getDiretorioDoArquivo() + backup.fileName()).exists();
            }
        }
        catch (IOException ex)
        {
            return false;
        }
        return true;
    }

    private void alterarStatusDoBackup (Backup backup, STATUS_BACKUP status)
    {
        backup.setStatus(status);
        try
        {
            daoBackup.alterar(backup);
        }
        catch (Exception ex)
        {
        }
    }

    private Backup getBackup (String chave)
    {
        String codigoStr;
        try
        {
            codigoStr = StaticInfo.lerPropriedade(
                            StaticInfo.BACKUP, chave);
            if (codigoStr == null || !codigoStr.matches("[0-9]+"))
            {
                return null;
            }
        }
        catch (IOException | IllegalArgumentException ex)
        {
            return null;
        }
        return daoBackup.procurarPorId(Integer.valueOf(codigoStr));
    }

    public static void main (String[] args) throws Exception
    {
        BackupListener backupListener = new BackupListener();
    }

    public static void addListener (BackupStatusListener listener)
    {
        listeners.add(listener);
    }

    public static void removeListener (BackupStatusListener listener)
    {
        listeners.remove(listener);
    }

    private class CopyDirVisitor extends SimpleFileVisitor<Path>
    {

        private Path fromPath;
        private Path toPath;
        private StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;

        private CopyDirVisitor (Path fromPath, Path toPath)
        {
            this.fromPath = fromPath;
            this.toPath = toPath;
        }

        @Override
        public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException
        {
            Path targetPath = toPath.resolve(fromPath.relativize(dir));
            if (Files.exists(targetPath))
            {
                if (targetPath.equals(toPath))
                {
                    return FileVisitResult.CONTINUE;
                }
                else
                {
                    return FileVisitResult.SKIP_SUBTREE;
                }
            }
            else
            {
                Files.createDirectory(targetPath);
                return FileVisitResult.CONTINUE;
            }
        }

        @Override
        public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException
        {
            Path p = toPath.resolve(fromPath.relativize(file));
            if (Files.exists(p))
            {
            }
            else
            {
                Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
            }
            return FileVisitResult.CONTINUE;
        }

    }

}
