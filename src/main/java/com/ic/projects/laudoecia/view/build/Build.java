/**
 * Build.java
 * <p>
 * Created on 09/12/2011, 10:24:38
 */
package com.ic.projects.laudoecia.view.build;

import br.com.oslunaticos.InstallSpellcheck;
import com.ic.projects.laudoecia.control.backup.BackupListener;
import com.ic.projects.laudoecia.control.backup.BackupManager;
import com.ic.projects.laudoecia.control.backup.ImgFolderManager;
import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.control.laudoecia.ImgBackupManager;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.dao.cadastro.DaoRecorte;
import com.ic.projects.laudoecia.iview.SoftwareView;
import com.ic.projects.laudoecia.iview.captura.C_Captura;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.cadastro.ImagemRestore;
import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.ic.projects.laudoecia.view.backup.BM_PopupMenu;
import com.ic.projects.laudoecia.view.backup.BM_TrayIcon;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.print.LaudosHTMLUtils;
import com.ic.projects.laudoecia.view.print.PdfPrinter;
import com.lib.java.utils.StringConfigurator;
import com.lib.java.utils.SystemUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.plus.cps.MyHTMLEditorKit;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.utils.SwingUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
public class Build implements SoftwareView
{

    @SuppressWarnings("LeakingThisInConstructor")
    private Build (String[] args) throws Exception
    {
        configurarLookAndFeel();

        LaudoeCia.setSoftwareView(this);

        switch (descobrirTipoDeExcecucao(args))
        {
            case LaudoeCia.VERIFICAR_BACKUP_DE_IMAGENS:
                verificarBackupImagens();
                break;
            case LaudoeCia.CORRIGIR_BACKUP_DE_IMAGENS:
                corrigirBackupImagens();
                break;
            case LaudoeCia.EXPORTAR_IMAGEM:
                exportar();
                break;
            case LaudoeCia.IMPORTAR_IMAGEM:
                importar();
                break;
            case LaudoeCia.BACKUP_MANAGER:
                iniciarComoGerenciadorDeBackups();
                break;
            case LaudoeCia.HBA:
                LaudoeCia.configurarHbaPtoConf();
                break;
            case LaudoeCia.INSTALADOR:
                iniciarComoInstalador("T".equals(args[1]));
                System.exit(0);
                break;
            case LaudoeCia.LAUDO_E_CIA:
                iniciarLaudoeCia();
                break;
            case LaudoeCia.SALVAR_ESTACAO:
                StaticInfo.gerarArqPcId();
                break;
            case LaudoeCia.SALVAR_MDL:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarMdl();
                break;
            case LaudoeCia.ATUALIZAR_PROC_DA_TABELA:
                LaudoeCia.configurarGenericDao(false, true);
                LaudoeCia.atualizarProcDaTabela();
                break;
            case LaudoeCia.FECHAR_BKP_MANAGER:
                StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                        StaticInfo.FECHAR_BKP_MANAGER, "false");
                StaticInfo.escreverPropriedade(StaticInfo.BACKUP,
                        StaticInfo.FECHAR_BKP_MANAGER, "true");
                Thread.sleep(10000);
                break;
            case LaudoeCia.ATUALIZADOR:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarVersaoDoSw();
                break;
            case LaudoeCia.ATUALIZADOR_1_0_0:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_0_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_0_1:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdERestoreDaVersao1_0_1();
                break;
            case LaudoeCia.ATUALIZADOR_1_0_2:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_0_2();
                break;
            case LaudoeCia.ATUALIZADOR_1_2_0:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_2_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_3_0:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_3_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_3_1:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_3_1();
                break;
            case LaudoeCia.ATUALIZADOR_1_4_0:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_4_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_6_0:
                LaudoeCia.configurarGenericDao(true, false);
                LaudoeCia.atualizarBdDaVersao1_6_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_7_0:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_7_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_8_0:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBdDaVersao1_8_0();
                LaudoeCia.atualizarDadosLaudos1_8_0();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_1:
                LaudoeCia.configurarGenericDao(true, false);
                DaoRecorte d = new DaoRecorte();
                d.listar();
                Recorte r1 = new Recorte();
                r1.setDescricao("Olympus CV-100");
                r1.setPosicaoX(256);
                r1.setPosicaoY(57);
                r1.setLargura(405);
                r1.setAltura(380);
                Recorte r2 = new Recorte();
                r2.setDescricao("Olympus CV-180");
                r2.setPosicaoX(70);
                r2.setPosicaoY(12);
                r2.setLargura(585);
                r2.setAltura(460);
                Recorte r3 = new Recorte();
                r3.setDescricao("Olympus CV-150");
                r3.setPosicaoX(70);
                r3.setPosicaoY(12);
                r3.setLargura(588);
                r3.setAltura(460);
                Recorte r4 = new Recorte();
                r4.setDescricao("Olympus CV-145");
                r4.setPosicaoX(70);
                r4.setPosicaoY(12);
                r4.setLargura(586);
                r4.setAltura(460);
                Recorte r5 = new Recorte();
                r5.setDescricao("Olympus CV-160");
                r5.setPosicaoX(70);
                r5.setPosicaoY(12);
                r5.setLargura(585);
                r5.setAltura(460);
                d.adicionar(Arrays.asList(r1, r2, r3, r4, r5));
                try
                {
                    LaudoeCia.atualizarDadosParaLaudos1_9_2();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                LaudoeCia.atualizarBancoDeDados1_9_1();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_2:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBancoDeDados1_9_2();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_3:
                LaudoeCia.configurarGenericDao();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_4:
                LaudoeCia.configurarGenericDao();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_4_1:
                break;
            case LaudoeCia.ATUALIZADOR_1_9_4_2:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBancoDeDados1_9_3();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_4_3:
                break;
            case LaudoeCia.ATUALIZADOR_1_9_4_4:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBancoDeDados1_9_4_3();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_5:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBancoDeDados1_9_5();
                break;
            case LaudoeCia.ATUALIZADOR_1_9_6:
                LaudoeCia.configurarGenericDao();
                LaudoeCia.atualizarBancoDeDados1_9_6();
                break;
            default:
        }
    }

    private void corrigirBackupImagens ()
    {
        try
        {
            LaudoeCia.configurarGenericDao();
            String[] split = SystemUtils.getClipboardText().split(";");
            String pasta = split[0];
            DaoImagem daoImagem = new DaoImagem();
            int codigoMenor = Integer.valueOf(split[1]);
            int codigoMaior = Integer.valueOf(split[2]);
            int codigoAtual = codigoMaior;
            List<Integer> codigosDasImagensNaoRenomeadas = new ArrayList<>();
            while (codigoAtual > codigoMenor)
            {
                try
                {
                    int indice = daoImagem.getIndice(codigoAtual);
                    Path imagem = Paths.get(pasta, getSubPasta(codigoAtual), codigoAtual + ".png");
                    Path pastaDaImagem = imagem.getParent();
                    Files.move(imagem, pastaDaImagem.resolve(codigoAtual + "-" + indice + ".png"));
                }
                catch (Exception e)
                {
                    codigosDasImagensNaoRenomeadas.add(codigoAtual);
                }
                codigoAtual--;
            }
            if (!codigosDasImagensNaoRenomeadas.isEmpty())
            {
                StringBuilder stringBuilder = new StringBuilder("select codigo, indice from imagem where codigo in (");
                for (Integer codigo : codigosDasImagensNaoRenomeadas)
                {
                    stringBuilder.append(codigo).append(", ");
                }
                String out = stringBuilder.toString();
                out = out.substring(0, out.length() - 2) + ") order by codigo";
                SystemUtils.setClipboardContents(out);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void verificarBackupImagens ()
    {
        try
        {
            LaudoeCia.configurarGenericDao();
            String pasta = SystemUtils.getClipboardText();
            DaoImagem daoImagem = new DaoImagem();
            int codigoAtual = daoImagem.getMaxID();
            while (codigoAtual > 0)
            {
                try
                {
                    int indice = daoImagem.getIndice(codigoAtual);
                    Path imagem = Paths.get(pasta, getSubPasta(codigoAtual), codigoAtual + "-" + indice + ".png");
                    if (Files.notExists(imagem))
                    {
                        System.out.println(codigoAtual);
                    }
                }
                catch (Exception e)
                {
                    // uma imagem nao existe para o codigo atual. Sem problema...
                }
                codigoAtual--;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void exportar ()
    {
        try
        {
            LaudoeCia.configurarGenericDao();
            String[] split = SystemUtils.getClipboardText().split(";");
            String pasta = split[0];
            DaoImagem daoImagem = new DaoImagem();
            int codigoMenor = Integer.valueOf(split[1]);
            int codigoMaior = Integer.valueOf(split[2]);
            int codigoAtual = codigoMaior;
            while (codigoAtual > codigoMenor)
            {
                Imagem imagem = daoImagem.procurarPorId(codigoAtual);
                if (imagem != null)
                {
                    exportarImagem(imagem, pasta);
                }
                codigoAtual--;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void exportarImagem (Imagem imagem, String pasta) throws Exception
    {
        int codigo = imagem.getCodigo();
        int indice = imagem.getIndice();
        String subPasta = getSubPasta(codigo);
        new File(pasta + "\\" + subPasta).mkdirs();
        try (FileOutputStream fos = new FileOutputStream(new File(pasta + "\\" + subPasta + "\\" + codigo + "-" +
                indice + ".png")))
        {
            fos.write(imagem.getImagem());
        }
    }

    private String getSubPasta (int codigo)
    {
        String codigoString = String.valueOf(codigo);
        if (codigoString.length() < 3)
        {
            return "1-100";
        }
        else if (codigoString.endsWith("00"))
        {
            return String.valueOf(codigo - 99) + "-" + codigoString;
        }
        else
        {
            codigoString = codigoString.substring(0, codigoString.length() - 2);
            int codigoInicial = Integer.valueOf(codigoString + "00") + 1;
            return String.valueOf(codigoInicial) + "-" + String.valueOf(codigoInicial + 99);
        }
    }

    private void importar ()
    {
        try
        {
            LaudoeCia.configurarGenericDao();
            ConversorByteArrayImage c = new ConversorByteArrayImage();
            String[] split = SystemUtils.getClipboardText().split(";");
            String pasta = split[0];
            int codigoMenor = Integer.valueOf(split[1]);
            int codigoMaior = Integer.valueOf(split[2]);
            int codigoAtual = codigoMaior;
            DaoImagem daoImagem = new DaoImagem();
            while (codigoAtual > codigoMenor)
            {
                String subPasta = getSubPasta(codigoAtual);
                File[] files = new File(pasta + "\\" + subPasta).listFiles(new FileNameFilterRestore(
                        String.valueOf(codigoAtual)));
                if (files.length > 0)
                {
                    ImagemRestore i = new ImagemRestore();
                    i.setCodigo(codigoAtual);
                    i.setIndice(getIndice(files[0].getName()));
                    i.setImagem(c.convertReverse(files[0]));
                    daoImagem.persistirImagem(i);
                }
                codigoAtual--;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private int getIndice (String arquivo)
    {
        String id = arquivo.substring(arquivo.indexOf("-") + 1);
        return Integer.valueOf(id.replaceAll("[^0-9]", ""));
    }

    private void configurarLookAndFeel () throws UnsupportedLookAndFeelException
    {
        LookAndFeel laf = new NimbusLookAndFeel();
        laf.getDefaults().put("ProgressBarUI", "javax.swing.plaf.basic.BasicProgressBarUI");
        laf.getDefaults().put("ProgressBar.cycleTime", 2500);
        laf.getDefaults().put("PopupMenu.consumeEventOnClose", Boolean.FALSE);
        laf.getDefaults().put("ToolTip.font", new FontUIResource(
                new FontUIResource("SansSerif", Font.PLAIN, 14)));
        UIManager.setLookAndFeel(laf);
    }

    private static void iniciarLaudoeCia () throws Exception
    {
        SplashScreenLC.splashInit();

        SplashScreenLC.splashUpdate("Conectando ao banco de dados... ", 30);
        try
        {
            LaudoeCia.configurarGenericDao();
            LaudoeCia.configurarPadroesDoSistema();
        }
        catch (Exception ex)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, ex.getMessage());
            throw ex;
        }
        final boolean exigirLogin = ControladorDeAcesso.getInstance().
                exigirLoginAoIniciarOSistema();

        SplashScreenLC.splashUpdate("Criando formulários... ", 50);
        final FormPrincipal fp = FormPrincipal.getInstance();
        PnlLaudoeCia.getInstance();
        LaudoeCia.setTelaPrincipal(fp);

        SplashScreenLC.splashUpdate("Configurando o sistema... ", 70);
        new SwingWorker<Void, Void>()
        {
            @Override
            protected Void doInBackground () throws Exception
            {
                InstallSpellcheck.preloadDictionaries(
                        StaticInfo.mainDictPath(),
                        StaticInfo.userDictPath());
                PdfPrinter pdfPrinter = new PdfPrinter();
                new DaoProcDoAtd().limparLockEstacao(StaticInfo.getEstTrabalho().getCodigo());
                ImgBackupManager.restore();
                return null;
            }

        }.execute();
        MyJTextField.setStringConfigurator(new StringConfigurator()
        {
            @Override
            public String configurarString (String string)
            {
                return string.toUpperCase();
            }

        });
        StyleSheet sheet = new MyHTMLEditorKit().getStyleSheet();
        sheet.addRule("div.topico, td { font-family: Arial, Helvetica, sans"
                + "-serif; font-size: 12pt; } div.topico, table.topico { margin-bottom: 5px; }");
        SplashScreenLC.splashUpdate("Inicializando o sistema... ", 90);
        try
        {
            BackupListener.main(null);
        }
        catch (Exception ex)
        {
            SplashScreenLC.splashUpdate("Erro ao iniciar função backup", 95);
        }
        SplashScreenLC.splashUpdate("Inicializando o sistema... ", 100);
        SplashScreenLC.splashClose();
        java.awt.EventQueue.invokeLater(new Runnable()
        {

            @Override
            public void run ()
            {
                fp.start(exigirLogin);
            }

        });

    }

    private static void iniciarComoGerenciadorDeBackups () throws Exception
    {
        SplashScreenLC.splashInit();
        SplashScreenLC.splashClose();
        MyJTextField.setStringConfigurator(new StringConfigurator()
        {
            @Override
            public String configurarString (String string)
            {
                return string.toUpperCase();
            }

        });
        BM_TrayIcon trayIcon = BM_TrayIcon.getInstance();
        trayIcon.setPopupMenu(BM_PopupMenu.getInstance());
        LaudoeCia.setTelaPrincipal(trayIcon);
        if (!SystemTray.isSupported())
        {
            throw new Exception("System tray não é suportado!");
        }
        SystemTray.getSystemTray().add(trayIcon);
//        try
//        {
//            StaticInfo.escreverPropriedade(StaticInfo.BANCO_DE_DADOS,
//                                       StaticInfo.IP_SERVIDOR,
//                                       SystemUtils.getLocalHostIpAddress());
//        }
//        catch (Exception e)
//        {
//            // péssima prática de programação, eu sei
//        }
        try
        {
            LaudoeCia.execComoConfHba();
        }
        catch (Exception e)
        {
            // péssima prática de programação, eu sei
        }
        LaudoeCia.configurarGenericDao();
        new SwingWorker<Void, Void>()
        {

            @Override
            protected Void doInBackground () throws Exception
            {
                Thread.sleep(7500);
                BackupListener.main(null);
                BackupManager.main(null);
                return null;
            }
        }.execute();
    }

    private static void iniciarComoInstalador (boolean bdPrecisouSerInstalado) throws Exception
    {

        SplashScreenLC.splashInit();

        SplashScreenLC.splashUpdate("Configurando o banco de dados... ", 20);
        StaticInfo.gerarArqPcId();
        LaudoeCia.configurarArqBdProperties();
        LaudoeCia.configurarHbaPtoConf();
        LaudoeCia.configurarGenericDao();

        if (bdPrecisouSerInstalado)
        {
            SplashScreenLC.splashUpdate("Criando o banco de dados... ", 40);
            LaudoeCia.criarBancoDeDados();
            LaudoeCia.deletarPlpgsql();

            SplashScreenLC.splashUpdate("Restaurando o banco de dados inicial... ", 50);
            LaudoeCia.restaurarBancoDeDadosComSchema(StaticInfo.arquivoBackupDaInstalacao());

            SplashScreenLC.splashUpdate("Otimizando o banco de dados... ", 75);
            LaudoeCia.vaccumDatabase();

            SplashScreenLC.splashUpdate("Configurando dados iniciais... ", 85);
            LaudoeCia.configurarDadosIniciais();
        }

        SplashScreenLC.splashUpdate("Configurando permissões de pasta... ", 90);
        LaudoeCia.configPermissoesDePasta();
        SplashScreenLC.splashUpdate("Instalação concluída ", 100);
        Thread.sleep(2000);

        SplashScreenLC.splashClose();

    }

    private static void gerarImagens (String path, int maiorCodigo) throws Exception
    {
        ImgFolderManager manager = new ImgFolderManager(Paths.get(path));
        byte[] bytes = criarImagem();
        for (int codigo = 1; codigo <= maiorCodigo; codigo++)
        {
            Imagem imagem = new Imagem();
            imagem.setCodigo(codigo);
            imagem.setIndice(codigo);
            imagem.setImagem(bytes);
            manager.exportarImagem(imagem);
        }
    }

    private static byte[] criarImagem () throws Exception
    {
        BufferedImage img = new BufferedImage(2560, 1080, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, 200, 200);
        g.setColor(Color.red);
        g.fillOval(500, 500, 100, 100);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    // <editor-fold defaultstate="collapsed" desc="Utilities">
    private static String descobrirTipoDeExcecucao (String[] args) throws IOException
    {
        if (args == null || args.length == 0)
        {
        }
        else
        {
            String tipoDeExecucao = args[0];
            if (LaudoeCia.BACKUP_MANAGER.equals(tipoDeExecucao))
            {
                return LaudoeCia.BACKUP_MANAGER;
            }
            if (LaudoeCia.CORRIGIR_BACKUP_DE_IMAGENS.equals(tipoDeExecucao))
            {
                return LaudoeCia.CORRIGIR_BACKUP_DE_IMAGENS;
            }
            if (LaudoeCia.VERIFICAR_BACKUP_DE_IMAGENS.equals(tipoDeExecucao))
            {
                return LaudoeCia.VERIFICAR_BACKUP_DE_IMAGENS;
            }
            if (LaudoeCia.EXPORTAR_IMAGEM.equals(tipoDeExecucao))
            {
                return LaudoeCia.EXPORTAR_IMAGEM;
            }
            if (LaudoeCia.IMPORTAR_IMAGEM.equals(tipoDeExecucao))
            {
                return LaudoeCia.IMPORTAR_IMAGEM;
            }
            if (LaudoeCia.HBA.equals(tipoDeExecucao))
            {
                return LaudoeCia.HBA;
            }
            if (LaudoeCia.INSTALADOR.equals(tipoDeExecucao))
            {
                if (args.length != 3)
                {
                    throw new IllegalArgumentException("Argumentos incorretos!");
                }
                if (!("T".equals(args[1]) || "F".equals(args[1])))
                {
                    throw new IllegalArgumentException(""
                            + "Informe se o banco de dados já existe!");
                }
                StaticInfo.escreverPropriedade(StaticInfo.BANCO_DE_DADOS,
                        StaticInfo.DATA_DIR,
                        args[2].replace("\"", "\""));
                return LaudoeCia.INSTALADOR;
            }
            if (LaudoeCia.SALVAR_MDL.equals(tipoDeExecucao))
            {
                return LaudoeCia.SALVAR_MDL;
            }
            if (LaudoeCia.SALVAR_ESTACAO.equals(tipoDeExecucao))
            {
                return LaudoeCia.SALVAR_ESTACAO;
            }
            if (LaudoeCia.FECHAR_BKP_MANAGER.equals(tipoDeExecucao))
            {
                return LaudoeCia.FECHAR_BKP_MANAGER;
            }
            if (LaudoeCia.ATUALIZADOR.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR;
            }
            if (LaudoeCia.ATUALIZADOR_1_0_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_0_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_0_1.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_0_1;
            }
            if (LaudoeCia.ATUALIZADOR_1_0_2.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_0_2;
            }
            if (LaudoeCia.ATUALIZADOR_1_2_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_2_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_3_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_3_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_3_1.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_3_1;
            }
            if (LaudoeCia.ATUALIZADOR_1_4_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_4_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_6_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_6_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_7_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_7_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_8_0.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_8_0;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_1.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_1;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_2.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_2;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_3.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_3;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_4.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_4;
            }

            if (LaudoeCia.ATUALIZADOR_1_9_4_1.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_4_1;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_4_2.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_4_2;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_4_3.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_4_3;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_4_4.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_4_4;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_5.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_5;
            }
            if (LaudoeCia.ATUALIZADOR_1_9_6.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZADOR_1_9_6;
            }
            if (LaudoeCia.ATUALIZAR_PROC_DA_TABELA.equals(tipoDeExecucao))
            {
                return LaudoeCia.ATUALIZAR_PROC_DA_TABELA;
            }
            throw new IllegalArgumentException("Parâmetro de inicialização desconhecido!");
        }
        return LaudoeCia.LAUDO_E_CIA;
    }

    private class MeuSw extends SwingWorker<Void, Void>
    {

        private Runnable thread;
        private Runnable notify;

        private MeuSw (Runnable thread, Runnable notify)
        {
            this.thread = thread;
            this.notify = notify;
        }

        @Override
        protected Void doInBackground () throws Exception
        {
            thread.run();
            return null;
        }

        @Override
        protected void done ()
        {
            if (notify != null)
            {
                notify.run();
            }
        }

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="View LaudoeCia">
    @Override
    public void runThread (Runnable thread, Runnable notify)
    {
        new MeuSw(thread, notify).execute();
    }

    @Override
    public C_Captura getC_Captura ()
    {
        return ViewFactory.getInstance().getC_Captura();
    }

    @Override
    public void paramsSistemaMudou ()
    {
        LaudosHTMLUtils.headerFooterMudou();
        FormPrincipal.getInstance().atualizarBackground();
    }

    // </editor-fold>
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main (String[] args) throws Exception
    {
//        gerarImagens("/Users/amsterdam/Desktop/organizar/iad", 890000);
        new Build(args);
    }

    private class FileNameFilterRestore implements FilenameFilter
    {
        private String codigo;

        private FileNameFilterRestore (String codigo)
        {
            this.codigo = codigo;
        }

        @Override
        public boolean accept (File dir, String name)
        {
            return name.matches(codigo + "-.+");
        }

    }
}
