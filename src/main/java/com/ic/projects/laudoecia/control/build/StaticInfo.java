/*
 * StaticInfo.java
 *
 * Created on 15/02/2012, 16:11:44
 */

package com.ic.projects.laudoecia.control.build;

import com.ic.projects.laudoecia.dao.auditable.DaoEstacaoDeTrabalho;
import com.ic.projects.laudoecia.dao.auditable.DaoLicenciado;
import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.dao.basededados.DaoEnderecoPorCep;
import com.ic.projects.laudoecia.dao.basededados.DaoUF;
import com.ic.projects.laudoecia.dao.cadastro.DaoParametrosDaCaptura;
import com.ic.projects.laudoecia.dao.tiss.DaoTISS_Conselho;
import com.ic.projects.laudoecia.iview.captura.C_Captura;
import com.ic.projects.laudoecia.model.auditable.*;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.PropriedadeDaCaptura;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.dao.general.EntityListener;
import com.lib.java.utils.Comparador;
import com.lib.java.utils.SystemUtils;
import com.lib.swing.utils.SwingUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.security.Key;
import java.security.MessageDigest;
import java.security.Security;
import java.util.*;
import java.util.List;

/**
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class StaticInfo
{

    // <editor-fold defaultstate="collapsed" desc="Ambiente">

    private static String pastaDeInstalacaoDoSistema;
    private static String pastaDeInstalacaoDoBancoDeDados;
    private static String pastaProperties;
    private static String nomeDoSistemaOperacional;
    private static String linguagemDoSistemaOperacional;
    private static final String nomeDoJarComSplash = "LaudoeCia.jar";
    private static final String nomeDoJarSemSplash = "LaudoeCia-sem splash.jar";

    public static String getPastaTemp () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\temp\\";
    }

    public static String getPastaTempImagens () throws IOException
    {
        return getPastaTemp() + "imagens\\";
    }

    public static String getPastaDeRecursos () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\recursos\\";
    }

    public static String getPastaHelp () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\help\\";
    }

    public static String getPastaJmf () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\jmf\\";
    }

    public static String getPastaDeInstalacaoDoSistema () throws IOException
    {
        if (pastaDeInstalacaoDoSistema == null)
        {
            try
            {
                pastaDeInstalacaoDoSistema = SystemUtils.getPastaDeInstalacao(
                        StaticInfo.class);
            }
            catch (Exception ex)
            {
                throw new IOException("Erro ao descobrir a pasta de instalação do sistema!");
            }
        }
        return pastaDeInstalacaoDoSistema.trim();
    }

    private static String getPastaExt () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\ext\\";
    }

    public static String getPastaDeInstalacaoDoBancoDeDados () throws IOException
    {
        if (pastaDeInstalacaoDoBancoDeDados == null)
        {
            pastaDeInstalacaoDoBancoDeDados = StaticInfo.lerPropriedade(
                    StaticInfo.BANCO_DE_DADOS, StaticInfo.PASTA_INST_BD);
        }
        return pastaDeInstalacaoDoBancoDeDados.trim();
    }

    public static String getPastaProperties () throws IOException
    {
        if (pastaProperties == null)
        {
            pastaProperties = StaticInfo.getPastaDeInstalacaoDoSistema() + "\\properties\\";
        }
        return pastaProperties;
    }

    public static String arquivoBackupDaInstalacao () throws IOException
    {
        return StaticInfo.getPastaDeRecursos() + "bkpInstall.backup";
    }

    public static String arquivoBackupParaRestore () throws IOException
    {
        return StaticInfo.getPastaDeRecursos() + "bkpRestore.backup";
    }

    public static String pgDumpPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\pg_dump.exe");
        return sb.toString();
    }

    public static String pgRestorePath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\pg_restore.exe");
        return sb.toString();
    }

    public static String pgPsqlPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\psql.exe");
        return sb.toString();
    }

    public static String pgCtlPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\pg_ctl.exe");
        return sb.toString();
    }

    public static String pgDataDirPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(lerPropriedade(BANCO_DE_DADOS, DATA_DIR));
        return sb.toString();
    }

    public static String createDbPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\createdb.exe");
        return sb.toString();
    }

    public static String vacuumPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\vacuumdb.exe");
        return sb.toString();
    }

    public static String dropDbPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(StaticInfo.getPastaDeInstalacaoDoBancoDeDados());
        sb.append("bin\\dropdb.exe");
        return sb.toString();
    }

    public static String pgHbaPath () throws IOException
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(pgDataDirPath());
        sb.append("\\pg_hba.conf");
        return sb.toString();
    }

    public static String getJarComSplash () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\" + nomeDoJarComSplash;
    }

    public static String getJarSemSplash () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\" + nomeDoJarSemSplash;
    }

    /**
     * @return Vazio se houve erro, ou o nome do sistema operacional
     */
    public static String getNomeDoSistemaOperacional ()
    {
        if (nomeDoSistemaOperacional == null)
        {
            nomeDoSistemaOperacional = System.getProperty("os.name");
            if (nomeDoSistemaOperacional == null)
            {
                nomeDoSistemaOperacional = "";
            }
        }
        return nomeDoSistemaOperacional;
    }

    /**
     * @return Vazio se houve erro, ou o nome do sistema operacional
     */
    public static String getLinguagemDoSistemaOperacional ()
    {
        if (linguagemDoSistemaOperacional == null)
        {
            linguagemDoSistemaOperacional = System.getProperty("user.language");
            if (linguagemDoSistemaOperacional == null)
            {
                linguagemDoSistemaOperacional = "";
            }
        }
        return linguagemDoSistemaOperacional;
    }

    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Auditoria">

    private final static Map<String, String> mapaDeEntdeAudit           = new HashMap<>();
    private final static List<String>        listaDeEntidadesAuditaveis = new ArrayList<>();

    private static void preencherMapaDeEntidadesParaAuditoria ()
    {
        mapaDeEntdeAudit.put(Atendimento.class.getSimpleName(), "Atendimentos");
        mapaDeEntdeAudit.put(Convenio.class.getSimpleName(), "Convênios");
        mapaDeEntdeAudit.put(EstacaoDeTrabalho.class.getSimpleName(), "Estação de Trabalho");
        mapaDeEntdeAudit.put(GrupoDeUsuarios.class.getSimpleName(), "Grupos de Usuários");
        mapaDeEntdeAudit.put(GrupoProcedimento.class.getSimpleName(), "Grupos de Procedimentos");
        mapaDeEntdeAudit.put(Licenciado.class.getSimpleName(), "Dados do Licenciado");
        mapaDeEntdeAudit.put(Paciente.class.getSimpleName(), "Pacientes");
        mapaDeEntdeAudit.put(ParametrosDoSistema.class.getSimpleName(), "Parametros do Sistema");
        mapaDeEntdeAudit.put(ProcDoAtd.class.getSimpleName(), "Laudo e imagem");
        mapaDeEntdeAudit.put(ProcMedico.class.getSimpleName(), "Procedimentos Médicos");
        mapaDeEntdeAudit.put(ProfExecutante.class.getSimpleName(), "Profissionais Executantes");
        mapaDeEntdeAudit.put(ProfSolicitante.class.getSimpleName(), "Profissionais Solicitantes");
        mapaDeEntdeAudit.put(TextoPadrao.class.getSimpleName(), "Texto Padrão");
        mapaDeEntdeAudit.put(Usuario.class.getSimpleName(), "Usuários");
        listaDeEntidadesAuditaveis.addAll(mapaDeEntdeAudit.values());
        Collections.sort(listaDeEntidadesAuditaveis);
    }

    public static List<String> getEntidadesAuditaveis ()
    {
        return Collections.unmodifiableList(listaDeEntidadesAuditaveis);
    }

    public static List<String> getEntidadesAuditaveis (String opcaoAdicional)
    {
        List<String> newModel = new ArrayList<>();
        newModel.add(opcaoAdicional);
        for (int i = 0; i < listaDeEntidadesAuditaveis.size(); i++)
        {
            newModel.add(listaDeEntidadesAuditaveis.get(i));
        }
        return newModel;
    }

    public static String getNomeDaEntidadeAuditavel (String entidadeKey)
    {
        return mapaDeEntdeAudit.get(entidadeKey);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Dados do Licenciado">

    private static DaoLicenciado daoLicenciado;
    private static Licenciado    licenciado;
    private static String        defaultDDD;
    private static String        defaultCidade;
    private static UF            defaultUF;
    private static boolean licenciadoMudou    = false;
    private static boolean defaultDddMudou    = false;
    private static boolean defaultUfMudou     = false;
    private static boolean defaultCidadeMudou = false;

    private static DaoLicenciado getDaoLicenciado ()
    {
        if (daoLicenciado == null)
        {
            daoLicenciado = new DaoLicenciado();
            DaoLicenciado.addStaticEntityListener(new EntityListener<Licenciado>()
            {
                @Override
                public void persisted (Licenciado entity)
                {
                }

                @Override
                public void removed (Licenciado entity)
                {
                }

                @Override
                public void updated (Licenciado entity)
                {
                    licenciadoMudou = true;
                    defaultDddMudou = true;
                    defaultUfMudou = true;
                }

            });
        }
        return daoLicenciado;
    }

    public static Licenciado getLicenciado ()
    {
        if (licenciado == null || licenciadoMudou)
        {
            licenciado = getDaoLicenciado().procurarPorId(1);
            if (licenciado == null)
            {
                licenciado = new Licenciado();
            }
            else
            {
                licenciadoMudou = false;
            }
        }
        return licenciado;
    }

    public static String getDefaultDDD ()
    {
        if (defaultDDD == null || defaultDddMudou)
        {
            String telefone = getLicenciado().getTelefone1();
            if (telefone == null || telefone.isEmpty())
            {
                //quando for primeiro acesso ao sistema abre 62
                defaultDDD = "62";
            }
            else
            {
                if (telefone.contains("("))
                {
                    defaultDDD = telefone.substring(1, 3);
                }
                else
                {
                    defaultDDD = telefone.substring(0, 2);
                }
            }
            defaultDddMudou = false;
        }
        return defaultDDD;
    }

    public static UF getDefaultUF ()
    {
        if (defaultUF == null || defaultUfMudou)
        {
            Endereco end = getLicenciado().getEndereco();
            if (end == null)
            {
                end = new Endereco();
            }
            if (end.getUf() != null)
            {
                defaultUF = end.getUf();
            }
            else
            {
                //quando for primeiro acesso ao sistema abre GO
                defaultUF = new UF();
                defaultUF.setSigla("GO");
            }
            defaultUfMudou = false;
        }
        return defaultUF;
    }

    public static String getDefaultCidade ()
    {
        if (defaultCidade == null || defaultCidadeMudou)
        {
            Endereco end = getLicenciado().getEndereco();
            if (end == null)
            {
                end = new Endereco();
            }
            defaultCidade = end.getCidade();
            defaultCidadeMudou = false;
        }
        return defaultCidade;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Parametros do Sistema">

    private static DaoParametrosDoSistema daoParamSistema;
    private static ParametrosDoSistema    paramSistema;
    private static boolean paramSistemaMudou = false;

    private static DaoParametrosDoSistema getDaoParametrosDoSistema ()
    {
        if (daoParamSistema == null)
        {
            daoParamSistema = new DaoParametrosDoSistema();
            DaoParametrosDoSistema.addStaticEntityListener(new EntityListener<ParametrosDoSistema>()
            {
                @Override
                public void persisted (ParametrosDoSistema entity)
                {
                }

                @Override
                public void removed (ParametrosDoSistema entity)
                {
                }

                @Override
                public void updated (ParametrosDoSistema entity)
                {
                    paramSistemaMudou = true;
                    LaudoeCia.getSoftwareView().paramsSistemaMudou();
                }

            });
        }
        return daoParamSistema;
    }

    public static ParametrosDoSistema getParametrosDoSistema ()
    {
        return getParametrosDoSistema(false);
    }

    public static ParametrosDoSistema getParametrosDoSistema (boolean buscarNoBanco)
    {
        if (paramSistema == null || paramSistemaMudou || buscarNoBanco)
        {
            paramSistema = getDaoParametrosDoSistema().procurarPorId(1);
            if (paramSistema == null)
            {
                paramSistema = new ParametrosDoSistema();
            }
            else
            {
                paramSistemaMudou = false;
            }
        }
        return paramSistema;
    }

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Endereco">

    private static List<UF> ufs;
    private static final Map<UF, List<String>>       mapaDeCidades = new HashMap<>();
    private static final Map<UfCidade, List<String>> mapaDeBairros = new HashMap<>();
    private static DaoEnderecoPorCep daoEndPorCep;

    public static List<UF> getUfs ()
    {
        if (ufs == null)
        {
            ufs = new DaoUF().listarOrdenadoPorSigla();
        }
        return Collections.unmodifiableList(ufs);
    }

    public static List<String> getCidades (UF uf)
    {
        if (!mapaDeCidades.containsKey(uf))
        {
            mapaDeCidades.put(uf, Comparador.ordenarLista(
                    getDaoEndPorCep().listarCidades(uf), false));
        }
        return mapaDeCidades.get(uf);
    }

    public static List<String> getBairros (UF uf, String cidade)
    {
        UfCidade ufCidade = new UfCidade(uf, cidade);
        if (!mapaDeBairros.containsKey(ufCidade))
        {
            mapaDeBairros.put(ufCidade, Comparador.ordenarLista(
                    getDaoEndPorCep().listarBairros(uf, cidade), false));
        }
        return mapaDeBairros.get(ufCidade);
    }

    private static DaoEnderecoPorCep getDaoEndPorCep ()
    {
        if (daoEndPorCep == null)
        {
            daoEndPorCep = new DaoEnderecoPorCep();
        }
        return daoEndPorCep;
    }

    public static String getPastaDeVideos ()
    {
        return getParametrosDoSistema().getDiretorioDeVideos();
    }

    public static void desconectarEstacao () throws Exception
    {
        EstacaoDeTrabalho et = getEstTrabalho();
        et.setLogado(false);
        getDaoEstDeTrabalho().alterar(et);
    }

    public static Key getkey () throws Exception
    {
        byte[] keyBytes = ("erika").getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keyBytes = sha.digest(keyBytes);
        keyBytes = Arrays.copyOf(keyBytes, 16);

        return new SecretKeySpec(keyBytes, "AES");
    }

    private static class UfCidade
    {
        private final UF     uf;
        private final String cidade;

        private UfCidade (UF uf, String cidade)
        {
            this.uf = uf;
            this.cidade = cidade == null ? "" : cidade;
        }

        @Override
        public boolean equals (Object obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            final UfCidade other = (UfCidade) obj;
            if (!Objects.equals(this.uf, other.getUf()))
            {
                return false;
            }
            return Objects.equals(this.cidade, other.getCidade());
        }

        @Override
        public int hashCode ()
        {
            int hash = 3;
            hash = 19 * hash + Objects.hashCode(this.uf);
            hash = 19 * hash + Objects.hashCode(this.cidade);
            return hash;
        }

        private String getCidade ()
        {
            return cidade;
        }

        private UF getUf ()
        {
            return uf;
        }

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TISS">

    private static List<TISS_Conselho> tiss_Conselhos;

    public static List<TISS_Conselho> getTiss_Conselhos ()
    {
        if (tiss_Conselhos == null)
        {
            tiss_Conselhos = new DaoTISS_Conselho().listarOrdenadoPorSigla();
        }
        return Collections.unmodifiableList(tiss_Conselhos);
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estacao de Trabalho">

    private static EstacaoDeTrabalho    estacaoDeTrabalho;
    private static DaoEstacaoDeTrabalho daoEstDeTrabalho;
    private static final String nomeArqPcId   = "pc_id.lc";
    private static final String pathArqPcId86 = "c:\\windows\\system32\\" + nomeArqPcId;
    private static final String pathArqPcId64 = "c:\\windows\\syswow64\\" + nomeArqPcId;

    public static EstacaoDeTrabalho getEstTrabalho ()
    {
        if (estacaoDeTrabalho == null)
        {
            try
            {
                DaoEstacaoDeTrabalho dao = getDaoEstDeTrabalho();
                if (System.getProperty("os.name").toLowerCase().contains("windows"))
                {
                    estacaoDeTrabalho = dao.buscarEstacaoPorSerial(lerCodigoDaMaquina());
                }
                else
                {
                    estacaoDeTrabalho = dao.listar().get(0);
                }
                if (estacaoDeTrabalho != null)
                {
                    estacaoDeTrabalho.setLogado(true);
                    dao.alterar(estacaoDeTrabalho);
                }
            }
            catch (Exception ex)
            {
            }
        }
        return estacaoDeTrabalho;
    }

    public static void validarQtdEst () throws Exception
    {
        int count = getDaoEstDeTrabalho().getEstLogadasCount();
        int q = configurarProtecaoDoSistemaRetornarQtdeEstLogadaPermitida();
        if (count > q)
        {
            estacaoDeTrabalho.setLogado(false);
            getDaoEstDeTrabalho().alterar(estacaoDeTrabalho);
            throw new Exception("As " + String.valueOf(q) + " licenças adquiridas para"
                    + " uso simultâneo do LaudoeCia foram atingidas.\n"
                    + "Basta fechar o programa em computadores que"
                    + " não estiverem sendo usados ou adquirir novas licenças "
                    + "pelo telefone (62)3643-6264, informando o código "
                    + getLicenciado().getSerial());
        }
    }

    public static String getStringParaCypher (Licenciado lic)
    {
        if (lic.getLicenciadoPara().trim().isEmpty() || lic.getQtdeAcessos() < 1
                || lic.getTipodelicenca() == null)
        {
            return null;
        }
        return lic.getLicenciadoPara() +
                Integer.toString(lic.getQtdeAcessos() * 967, 36) +
                Integer.toString(LaudoeCia.VERSAO_DO_SISTEMA_ENUM.getVersaoInt() * 337, 36) +
                Integer.toString(lic.getTipodelicenca().getVersaoInt() * 1637, 36);
    }

    private static int configurarProtecaoDoSistemaRetornarQtdeEstLogadaPermitida () throws Exception
    {
        Licenciado lic = getLicenciado();
        String serial = lic.getSerial();
        String cypherStr = getStringParaCypher(lic);
        if (cypherStr == null || serial == null || serial.trim().isEmpty() || seriaisProibidos.contains(serial))
        {
            LICENCIADO_LAUDO = LICENCIADO_LAUDO_VERSAO_TESTES;
            return lic.getQtdeAcessos();
        }
        String serialEncriptografado = encriptografar(cypherStr);
        if (Objects.equals(serial.toUpperCase(), serialEncriptografado.toUpperCase()))
        {
            LICENCIADO_LAUDO = "<font size=\"2\">Software LaudoeCia - "
                    + "Licenciado para " + lic.getLicenciadoPara() + "</font>";
            return lic.getQtdeAcessos();
        }
        LICENCIADO_LAUDO = LICENCIADO_LAUDO_VERSAO_TESTES;
        return lic.getQtdeAcessos();
    }

    public static void cadastrarEstDeTrabalho () throws Exception
    {
        EstacaoDeTrabalho edt = new EstacaoDeTrabalho();
        edt.setNomeEstacaoDeTrabalho(SystemUtils.getLocalHostName().toUpperCase());
        edt.setSerialHD(lerCodigoDaMaquina());
        getDaoEstDeTrabalho().adicionar(edt);
    }

    public static void gerarArqPcId () throws FileNotFoundException, IOException, Exception
    {
        String caminho = getPastaDeRecursos() + "\\" + nomeArqPcId;
        try (Writer out = new OutputStreamWriter(new FileOutputStream(caminho)))
        {
            out.write(gerarCodigoDaMaquina());
        }
    }

    public static String getPastaPgHba () throws IOException
    {
        if (pgHba == null)
        {
            try
            {
                Properties prop = new Properties();
                FileInputStream arqProperties = new FileInputStream(StaticInfo.getCaminhoArqProp("bd"));
                prop.load(arqProperties);
                pgHba = prop.getProperty("dataDir");
            }
            catch (Exception ex)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(null, "Erro ao descobrir a pasta do arquivo pg_hba.conf dos" +
                        " postgres!");
            }
        }
        return pgHba.trim();
    }

    private static String gerarCodigoDaMaquina ()
    {
        Random random = new Random();
        return String.valueOf(random.nextInt(10000));
    }

    private static String lerCodigoDaMaquina () throws IOException, FileNotFoundException
    {
        File arquivoPcId = new File(pathArqPcId86);
        if (!arquivoPcId.exists())
        {
            arquivoPcId = new File(pathArqPcId64);
        }
        try (BufferedReader in = new BufferedReader(new FileReader(arquivoPcId)))
        {
            return in.readLine();
        }
    }

    private static DaoEstacaoDeTrabalho getDaoEstDeTrabalho ()
    {
        if (daoEstDeTrabalho == null)
        {
            daoEstDeTrabalho = new DaoEstacaoDeTrabalho();
        }
        return daoEstDeTrabalho;
    }

    public static void licencaMudou (Licenciado novoLic)
    {
        licenciado = novoLic;
        try
        {
            configurarProtecaoDoSistemaRetornarQtdeEstLogadaPermitida();
        }
        catch (Exception ex)
        {
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Arquivos de propriedades">

    public static final  String BACKUP         = "backup";
    public static final  String BANCO_DE_DADOS = "bd";
    public static final  String CAPTURA        = "captura";
    private static final String LAUDOS         = "laudos";
    private static String pgHba;

    private static Integer receituario  = null;
    private static Boolean imprimirAss  = null;
    private static Boolean limitarFotos = null;

    // <editor-fold defaultstate="collapsed" desc="Laudos properties">

    public static final String FATOR_VOL_DIVERSOS = "fator_para_calculo_de_volume_diversos";
    public static final String FATOR_PESO_PROST   = "fator_para_calculo_do_peso_da_prostata";

    private static final Map<String, String> parametrosDoLaudo = new HashMap<>();

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Backup properties">

    public static final String BACKUP_LOCAL_MUDOU      = "backupLocalMudou";
    public static final String BACKUP_AUT_MUDOU        = "backupAutMudou";
    public static final String PARAMS_BACKUP_AUT_MUDOU = "paramsBackupAutMudou";
    public static final String BACKUP_INICIOU          = "backupIniciou";
    public static final String BACKUP_TERMINOU         = "backupTerminou";
    public static final String FECHAR_BKP_MANAGER      = "fechar_bkp_manager";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Database properties">

    public static final String IP_SERVIDOR   = "ipDoServidor";
    public static final String PASTA_INST_BD = "pastaInstBd";
    public static final String DATA_DIR      = "dataDir";
    public static final String HOST_NAME     = "hostName";

    public static final String DIR_IMP_IMG = "dirImpImg";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Captura properties">

    public static final String CMD_COMPACTACAO = "cmd_compactacao";

    // </editor-fold>

    public static String getPenDrive ()
    {
        try
        {
            return lerPropriedade(BANCO_DE_DADOS, "pen_drive");
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static void setPenDrive (String pendrive) throws IOException
    {
        escreverPropriedade(BANCO_DE_DADOS, "pen_drive", pendrive);
    }

    private static String getCaminhoArqProp (String arqDeProp) throws IOException
    {
        StringBuilder sb = new StringBuilder(getPastaProperties());
        sb.append(arqDeProp).append(".properties");
        return sb.toString();
    }

    public static String lerPropriedade (String arqDeProp, String chave) throws IOException
    {
        String resposta;
        Properties p = new Properties();
        try (FileInputStream fis = new FileInputStream(getCaminhoArqProp(arqDeProp)))
        {
            p.load(fis);
            resposta = p.getProperty(chave);
        }
        return resposta;
    }

    public static int receituario ()
    {
        if (receituario == null)
        {
            try
            {
                String valor = lerPropriedade(StaticInfo.BANCO_DE_DADOS, "receituario");
                receituario = Integer.valueOf(valor);
            }
            catch (IOException e)
            {
                receituario = 0;
            }
        }
        return receituario;
    }

    public static boolean imprimirAss ()
    {
        if (imprimirAss == null)
        {
            try
            {
                String valor = lerPropriedade(StaticInfo.BANCO_DE_DADOS, "imprimirAss");
                imprimirAss = !"false".equals(valor);
            }
            catch (IOException e)
            {
                imprimirAss = true;
            }
        }
        return imprimirAss;
    }

    public static boolean limitarFotos ()
    {
        if (limitarFotos == null)
        {
            try
            {
                String valor = lerPropriedade(StaticInfo.BANCO_DE_DADOS, "limitarFotos");
                limitarFotos = Boolean.valueOf(valor);
            }
            catch (IOException e)
            {
                limitarFotos = true;
            }
        }
        return limitarFotos;
    }

    public static void escreverPropriedade (String arqDeProp, String chave, String valor) throws IOException
    {
        Properties p = new Properties();
        String caminhoArqProp = getCaminhoArqProp(arqDeProp);
        try (FileInputStream fis = new FileInputStream(caminhoArqProp))
        {
            p.load(fis);
        }
        p.setProperty(chave, valor);
        try (FileWriter fw = new FileWriter(caminhoArqProp))
        {
            p.store(fw, "");
        }
    }

    public static String ipDoServidor () throws IOException
    {
        return lerPropriedade(BANCO_DE_DADOS, IP_SERVIDOR);
    }

    public static String getParametroDoLaudo (String param) throws IOException
    {
        if (!parametrosDoLaudo.containsKey(param))
        {
            parametrosDoLaudo.put(param, lerPropriedade(LAUDOS, param));
        }
        return parametrosDoLaudo.get(param);
    }

    public static String getDirImportacaoImagens ()
    {

        try
        {
            return lerPropriedade(BANCO_DE_DADOS, DIR_IMP_IMG);
        }
        catch (IOException e)
        {
            return "";
        }
    }

    public static void setDirImportacaoImagens (String value)
    {
        try
        {
            escreverPropriedade(BANCO_DE_DADOS, DIR_IMP_IMG, value);
        }
        catch (IOException e)
        {
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Banco de dados">

    private static String urlBd;

    public static String getSenhaUsuarioBd ()
    {
        return "Joao1030";
    }

    public static String getSenhaUsuarioSistema ()
    {
        return "1Joao418";
    }

    public static String getBancoDeDados ()
    {
        return "laudoecia";
    }

    public static String getUsuarioBd ()
    {
        return "teknamed";
    }

    public static String getPortaBd ()
    {
        if (System.getProperty("os.name").toLowerCase().contains("windows"))
        {
            return "5434";
        }
        return "5432";
    }

    public static String getUrlBd (boolean bkpinstall)
    {
        if (urlBd == null)
        {
            StringBuilder sb = new StringBuilder("jdbc:postgresql://");
            try
            {
                sb.append(ipDoServidor());
            }
            catch (IOException ex)
            {
                sb.append("127.0.0.1");
            }
            sb.append(":").append(getPortaBd()).append("/").append(bkpinstall ? "bkpinstall" : getBancoDeDados());
            urlBd = sb.toString();
        }
        return urlBd;
    }

    public static String getUsuarioSistema ()
    {
        return "teknamedpg";
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Backup">

    public static final String FORMATO_IMAGEM_EXPORTADA = "png";
    public static final String EXT_IMAGEM_EXPORTADA     = '.' + FORMATO_IMAGEM_EXPORTADA;

    private static final List<String> tabelasDeBaseDeDados = new ArrayList<>();

    public static List<String> getTabelasDeBaseDeDados ()
    {
        if (tabelasDeBaseDeDados.isEmpty())
        {
            tabelasDeBaseDeDados.add("public.capitulocid10");
            tabelasDeBaseDeDados.add("public.categoriacid10");
            tabelasDeBaseDeDados.add("public.cbhpm");
            tabelasDeBaseDeDados.add("public.cnes");
            tabelasDeBaseDeDados.add("public.crm");
            tabelasDeBaseDeDados.add("public.crm_especialidade");
            tabelasDeBaseDeDados.add("public.enderecoporcep");
            tabelasDeBaseDeDados.add("public.especialidademedica");
            tabelasDeBaseDeDados.add("public.grupocbhpm");
            tabelasDeBaseDeDados.add("public.grupocid10");
            tabelasDeBaseDeDados.add("public.subcategoriacid10");
            tabelasDeBaseDeDados.add("public.subgrupocbhpm");
            tabelasDeBaseDeDados.add("public.uf");
            tabelasDeBaseDeDados.add("public.tiss_conselho");
        }
        return Collections.unmodifiableList(tabelasDeBaseDeDados);
    }

    public static List<String> getTabelasDeImagens (boolean incluirTabelaImagem)
    {
        List<String> resposta = new ArrayList<>();
        if (incluirTabelaImagem)
        {
            resposta.add("public.imagem");
        }
        resposta.add("public.paciente_imagem");
        resposta.add("public.procdoatd_imagem");
        resposta.add("public.impressaodeimg");
        resposta.add("public.imagemimpressa");
        resposta.add("public.paginadeimagens");
        return resposta;
    }

    public static List<String> getTabelasEspecificasDaInstalacao ()
    {
        List<String> resposta = new ArrayList<>();
        resposta.add("public.backup");
        return resposta;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Corretor ortografico">

    public static String mainDictPath ()
    {
        try
        {
            return getPastaDeInstalacaoDoSistema() + "\\userdict\\pt_BR";
        }
        catch (IOException ex)
        {
            return "c:\\Ant\\userdict\\pt_BR";
        }
    }

    public static String userDictPath ()
    {
        try
        {
            return getPastaDeInstalacaoDoSistema() + "\\userdict\\user";
        }
        catch (IOException ex)
        {
            return "c:\\Ant\\userdict\\user";
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ext">

    public static String getMkiSofsPath () throws IOException
    {
        return getPastaExt() + "mkisofs2.exe";
    }

    public static String getCdRecordPath () throws IOException
    {
        return getPastaExt() + "cdrecord2.exe";
    }

    public static String getFFMPGEPath () throws IOException
    {
        return getPastaExt() + "ffmpeg.exe";
    }

    public static String getMiniRunAsPath () throws IOException
    {
        return getPastaExt() + "miniRunAs.exe";
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Captura">

    private static DaoParametrosDaCaptura daoParamsCaptura;
    private static ParametrosDaCaptura    pc;

    private static DaoParametrosDaCaptura getDaoParamsCaptura ()
    {
        if (daoParamsCaptura == null)
        {
            daoParamsCaptura = new DaoParametrosDaCaptura();
        }
        return daoParamsCaptura;
    }

    public static ParametrosDaCaptura getParamsCaptura ()
    {
        if (pc == null)
        {
            pc = getDaoParamsCaptura().procurar(getEstTrabalho());
        }
        return pc;
    }

    public static String getSnapshotName ()
    {
        return getEstTrabalho().getCodigo() + EXT_IMAGEM_EXPORTADA;
    }

    public static File getSnapshotFile () throws IOException
    {
        return new File(getPastaDeInstalacaoDoSistema() + "\\" + getSnapshotName());
    }

    public static boolean estacaoPossuiCaptura ()
    {
        pc = getParamsCaptura();
        if (pc == null)
        {
        }
        else
        {
            List<PropriedadeDaCaptura> propriedades = pc.getPropriedades();
            for (int i = 0; i < propriedades.size(); i++)
            {
                PropriedadeDaCaptura prop = propriedades.get(i);
                if (C_Captura.POSSUI_DISPOSITIVO_DE_CAPTURA.equals(prop.getDescricao()))
                {
                    return "true".equals(prop.getValor());
                }
            }
        }
        return false;
    }

    public static boolean primeiraExecucaoDaCaptura ()
    {
        pc = getParamsCaptura();
        if (pc == null)
        {
        }
        else
        {
            List<PropriedadeDaCaptura> propriedades = pc.getPropriedades();
            for (int i = 0; i < propriedades.size(); i++)
            {
                PropriedadeDaCaptura prop = propriedades.get(i);
                if (C_Captura.PRIMEIRA_EXECUCAO_DA_CAPTURA.equals(prop.getDescricao()))
                {
                    return "true".equals(prop.getValor());
                }
            }
        }
        return false;
    }

    public static void salvarPropriedadeDaCaptura (String descricao, String valor) throws Exception
    {
        if (descricao == null)
        {
            throw new IllegalArgumentException("Descricao null!");
        }
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put(descricao, valor);
        salvarPropriedadeDaCaptura(mapa);
    }

    public static void salvarPropriedadeDaCaptura (Map<String, String> mapa) throws Exception
    {
        ParametrosDaCaptura paramsDaCap = getParamsCaptura();
        if (paramsDaCap == null)
        {
            paramsDaCap = new ParametrosDaCaptura();
            paramsDaCap.setEstacao(getEstTrabalho());
            getDaoParamsCaptura().adicionar(paramsDaCap);
        }
        for (Map.Entry<String, String> entry : mapa.entrySet())
        {
            String descricao = entry.getKey();
            String valor = entry.getValue();
            PropriedadeDaCaptura pdc = new PropriedadeDaCaptura();
            pdc.setDescricao(descricao);
            pdc.setValor(valor);
            boolean pdcJaExistia = false;
            List<PropriedadeDaCaptura> propriedades = paramsDaCap.getPropriedades();
            for (int i = 0; i < propriedades.size(); i++)
            {
                PropriedadeDaCaptura pdcLoop = propriedades.get(i);
                if (descricao.equals(pdcLoop.getDescricao()))
                {
                    pdcLoop.setValor(valor);
                    pdcJaExistia = true;
                }
            }
            if (!pdcJaExistia)
            {
                paramsDaCap.addPropriedade(pdc);
            }
            pdc.setParametrosDaCaptura(paramsDaCap);
        }
        getDaoParamsCaptura().alterar(paramsDaCap);
        pc = paramsDaCap;
    }

    public static void reiniciarPropriedadesDaCaptura () throws Exception
    {
        ParametrosDaCaptura paramsCaptura = getParamsCaptura();
        if (paramsCaptura != null)
        {
            paramsCaptura.setPropriedades(null);
            getDaoParamsCaptura().alterar(paramsCaptura);
            pc = null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="JMF">

    public static String arquivoJmfPropertiesDaEstacao () throws IOException
    {
        return getPastaJmf() + "jmf" + getEstTrabalho().getCodigo() + ".properties";
    }

    public static String arquivoJmfSoundBankDaEstacao () throws IOException
    {
        return getPastaJmf() + "soundbank" + getEstTrabalho().getCodigo() + ".gm";
    }

    public static String arquivoJmfPropertiesDoJar () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\jmf.properties";
    }

    public static String arquivoJmfSoundBankDoJar () throws IOException
    {
        return getPastaDeInstalacaoDoSistema() + "\\soundbank.gm";
    }

    public static String arquivoJmfPropertiesPadrao () throws IOException
    {
        return getPastaJmf() + "jmf.properties";
    }

    public static String arquivoJmfSoundBankPadrao () throws IOException
    {
        return getPastaJmf() + "soundbank.gm";
    }

    // </editor-fold>

    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Background System">

    private static Image backgroundImage;
    private static final String BG_IMAGE = "IMAGEM_DE_FUNDO.jpg";

    public static Image getBackgroundImage () throws IOException
    {
        if (backgroundImage == null)
        {
            String caminhoImg = getPastaDeRecursos() + BG_IMAGE;
            File imgFile = new File(caminhoImg);
            if (imgFile.exists())
            {
                backgroundImage = ImageIO.read(imgFile);
            }
            else
            {
                throw new IOException("Arquivo não existe!");
            }
        }
        return backgroundImage;
    }

    //</editor-fold>

    public static float convertToJpeg ()
    {
        if (convertToJpeg == null)
        {
            try
            {
                String prop = lerPropriedade(BANCO_DE_DADOS, "jpeg");
                convertToJpeg = Float.valueOf(prop);
            }
            catch (Exception ex)
            {
            }
            if (convertToJpeg == null)
            {
                convertToJpeg = 0f;
            }
        }
        return convertToJpeg;
    }

    private static Float convertToJpeg = null;

    private StaticInfo ()
    {
    }

    static
    {
        preencherMapaDeEntidadesParaAuditoria();
    }

    public static final String LICENCIADO_LAUDO_VERSAO_TESTES =
            "<font size=\"4\">Software LaudoeCia - ESTE LAUDO NÃO É REAL, VERSÃO GRATUITA PARA TESTES</font>";

    public static String LICENCIADO_LAUDO = LICENCIADO_LAUDO_VERSAO_TESTES;

    public static final java.util.List<String> seriaisProibidos = Arrays.asList("42A9BA9FB5", "1E74A10642",
            "44DF5661B1",
            "D8E556F620", "5DB697B262", "5DB697B479", "DE0723119D", "1E74A10566");

    // <editor-fold defaultstate="collapsed" desc="Cypher">

    public static String encriptografar (String inputStr) throws Exception
    {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        byte[] input = inputStr.getBytes("UTF-8");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, StaticInfo.getkey());

        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);

        String hex = javax.xml.bind.DatatypeConverter.printHexBinary(cipherText);

        return hex.substring(0, 7) + hex.substring(hex.length() - 3, hex.length());
    }

    // </editor-fold>

}
