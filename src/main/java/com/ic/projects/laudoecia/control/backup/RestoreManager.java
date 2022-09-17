/*
 * RestoreManager.java
 *
 * Created on 16/04/2012, 14:21:06
 */
package com.ic.projects.laudoecia.control.backup;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.dao.utils.DaoLaudoeCia;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Marcelo <marcelo@instrumentalcientifico.com.br>
 */
public class RestoreManager
{

    private static FileFilterRestore fileFilterRestore = new FileFilterRestore();
    private static SimpleDateFormat meuSdf;
    private static String           regexArqBkp;
    private        TIPO_BACKUP      tipo;
    private        File             backupFile;

    static
    {
        meuSdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss",
                new Locale("pt", "BR"));
        regexArqBkp = "[0-9]{2}\\-[0-9]{2}\\-[0-9]{4} "
                + "[0-9]{2}\\-[0-9]{2}\\-[0-9]{2}\\.backup";
    }

    public RestoreManager (TIPO_BACKUP tipo, File backupFile) throws IllegalArgumentException
    {
        if (tipo == null)
        {
            throw new IllegalArgumentException("Escolha o tipo de backup!");
        }
        if (backupFile == null)
        {
            throw new IllegalArgumentException("Escolha um arquivo de backup!");
        }
        if (!validarArquivoBackup(backupFile, tipo))
        {
            throw new IllegalArgumentException("Arquivo backup inválido!");
        }
        this.tipo = tipo;
        this.backupFile = backupFile;
    }

    @SuppressWarnings("fallthrough")
    public void executar () throws IOException, InterruptedException, Exception
    {
        recriarBancoDeDados();
        executarRestoreDados();
        DaoImagem daoImagem = new DaoImagem();
        // metodos chamados para reiniciar a conexao.
        // se houver erro na consulta, o que vai ocorrer, a conexao sera
        // feita novamente e as proximas chamadas terao sucesso
        daoImagem.listar();
        daoImagem.listar();
        if (tipo == TIPO_BACKUP.DADOS_E_IMAGENS)
        {
            new ImgFolderManager(backupFile.toPath().getParent()).restaurarImagens(daoImagem);
            new DaoLaudoeCia().atualizarIndiceImg();
            executarRestoreImagens();
            daoImagem.deletarImagensOrfas();
        }
        ParametrosDoSistema pds = StaticInfo.getParametrosDoSistema(true);
        switch (pds.getVersaoDoSw())
        {
            case V1:
                LaudoeCia.atualizarRestoreDaVersao1_0_0();
            case V1_0_1:
                LaudoeCia.atualizarBdERestoreDaVersao1_0_1();
            case V1_0_2:
            case V1_1_0:
            case V1_1_1:
                break;
            case V1_2_0:
                LaudoeCia.atualizarBdDaVersao1_2_0();
            case V1_3_0:
                LaudoeCia.atualizarBdDaVersao1_3_0();
            case V1_3_1:
                LaudoeCia.atualizarBdDaVersao1_3_1();
            case V1_4_0:
                LaudoeCia.atualizarBdDaVersao1_4_0();
            case V1_5_0:
            case V1_6_0:
            case V1_7_0:
            case V1_8_0:
                LaudoeCia.atualizarDadosLaudos1_8_0();
                LaudoeCia.atualizarMdl();
            case V1_9_1:
                LaudoeCia.atualizarDadosParaLaudos1_9_2();
            default:
        }
        pds.setVersaoDoSw(LaudoeCia.VERSAO_DO_SISTEMA_ENUM);
        new DaoParametrosDoSistema().alterar(pds);
        LaudoeCia.vaccumDatabase();
    }

    private void recriarBancoDeDados () throws Exception
    {
        LaudoeCia.deletarBancoDeDados();
        LaudoeCia.criarBancoDeDados();
        LaudoeCia.deletarPlpgsql();
        LaudoeCia.restaurarBancoDeDadosComSchema(StaticInfo.arquivoBackupParaRestore());
    }

    private void executarRestoreDados () throws IOException, Exception
    {
        ProcessBuilder pb = new ProcessBuilder(criarComandoRestore(backupFile.getPath()));
        pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
        pb.redirectErrorStream(true);
        Process p = pb.start();
        if (p.waitFor() == 0)
        {
        }
        else
        {
            throw new Exception("Erro ao restaurar os dados do backup!");
        }
    }

    private void executarRestoreImagens () throws IOException, InterruptedException, Exception
    {
        ProcessBuilder pb = new ProcessBuilder(criarComandoRestore(getImgBkpFile()));
        pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
        pb.redirectErrorStream(true);
        if (pb.start().waitFor() == 0)
        {
        }
        else
        {
            throw new Exception("Erro ao restaurar o cadastro de imagens!");
        }
    }

    private String getImgBkpFile ()
    {
        return Paths.get(backupFile.getParent(), "imagens",
                backupFile.getName()).toString();
    }

    private boolean validarArquivoBackup (File backupFile, TIPO_BACKUP tipo)
    {
        if (!(backupFile.isFile() || backupFile.exists() || backupFile.getParentFile().isDirectory()))
        {
            return false;
        }
        if (backupFile.getName().matches(regexArqBkp))
        {
            switch (tipo)
            {
                case DADOS:
                    return true;
                case DADOS_E_IMAGENS:
                    File bkpFolder = backupFile.getParentFile();
                    File[] bkpFolderFiles = bkpFolder.listFiles();
                    for (int i = 0; i < bkpFolderFiles.length; i++)
                    {
                        File bkpFolderFile = bkpFolderFiles[i];
                        if (bkpFolderFile.isDirectory() && "imagens".equals(bkpFolderFile.getName()))
                        {
                            File pastaImagens = bkpFolderFile;
                            File[] pastaImagensFiles = pastaImagens.listFiles();
                            for (int j = 0; j < pastaImagensFiles.length; j++)
                            {
                                File pastaImagensFile = pastaImagensFiles[j];
                                if (pastaImagensFile.getName().equals(backupFile.getName()))
                                {
                                    return true;
                                }
                            }
                            throw new IllegalArgumentException("Arquivo de imagens não encontrado.");
                        }
                    }
                    throw new IllegalArgumentException("Arquivo de imagens não encontrado.");
                default:
                    return false;
            }
        }
        else
        {
            return false;
        }
    }

    private List<String> criarComandoRestore (String caminhoArquivoBackup) throws IOException
    {
        List<String> resposta = new ArrayList<>();

        resposta.add(StaticInfo.pgRestorePath()); // arquivo a ser executado

        resposta.add("--host");
        resposta.add("localhost");

        resposta.add("--port");
        resposta.add(StaticInfo.getPortaBd());

        resposta.add("--username");
        resposta.add(StaticInfo.getUsuarioBd());

        resposta.add("--dbname");
        resposta.add(StaticInfo.getBancoDeDados());

        resposta.add("--data-only");

        resposta.add("--disable-triggers");

//        resposta.add("--verbose");

//        resposta.add("\"" + caminhoArquivoBackup + "\""); nao ha necessidade
        resposta.add(caminhoArquivoBackup);

        return resposta;
    }

    public static Map<Date, File> buscarArquivosDeBackup (File pastaDeBackups)
    {
        Map<Date, File> resp = new HashMap<>();
        List<File> arquivosDeBackup = new ArrayList<>();
        if (pastaDeBackups != null && pastaDeBackups.exists())
        {
            File[] filesArray = pastaDeBackups.listFiles(fileFilterRestore);
            arquivosDeBackup.addAll(Arrays.asList(filesArray));
        }
        for (int i = 0; i < arquivosDeBackup.size(); i++)
        {
            File file = arquivosDeBackup.get(i);
            String fileName = file.getName();
            String nameWithoutExt = fileName.substring(0, fileName.indexOf('.'));
            try
            {
                Date bkpDate = meuSdf.parse(nameWithoutExt);
                resp.put(bkpDate, file);
            }
            catch (ParseException ex)
            {
            }
        }
        return resp;
    }

    private static class FileFilterRestore implements FileFilter
    {
        @Override
        public boolean accept (File pathname)
        {
            return pathname.isFile() && pathname.getName().matches(regexArqBkp);
        }

    }

}