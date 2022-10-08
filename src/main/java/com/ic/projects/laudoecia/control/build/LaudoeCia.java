/*
 * LaudoeCia.java
 *
 * Created on 17/02/2012, 17:28:49
 */
package com.ic.projects.laudoecia.control.build;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.dao.auditable.DaoConvenio;
import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.dao.auditable.DaoProcMedico;
import com.ic.projects.laudoecia.dao.laudo.DaoModeloDeLaudo;
import com.ic.projects.laudoecia.dao.utils.DaoLaudoeCia;
import com.ic.projects.laudoecia.iview.SoftwareView;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaPrincipalNull;
import com.ic.projects.laudoecia.mdl.*;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.cadastro.ValorFixo;
import com.ic.projects.laudoecia.model.enums.VERSAO_DO_SW;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudo;
import com.lib.dao.general.GenericDao;
import com.lib.java.utils.StringConfigurator;
import com.lib.java.utils.StringUtils;
import com.lib.java.utils.SystemUtils;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class LaudoeCia {

	public static final String NOME_DO_SISTEMA = "LaudoeCia";
	public static final VERSAO_DO_SW VERSAO_DO_SISTEMA_ENUM = VERSAO_DO_SW.V1_9_9_5;
	public static final String VERSAO_DO_SISTEMA = VERSAO_DO_SISTEMA_ENUM.getTipo();
	public static final String TELEFONE = "(62) 3643-6264";
	public static final String EMAIL = "contato@semprimed.com.br";
	public static final String SIST_OPER_DO_SISTEMA = "Windows XP ou Superior";
	public static final String COPYRIGHT_DO_SISTEMA = "Copyright © 2021";
	public static final String PAGINA_OFICIAL_DO_SISTEMA = "semprimed.com.br";
	public static final String RESOLUCAO_RECOMENDADA = "1024 x 768";
	public static final String DATA_VERSAO_DO_SISTEMA = "25/08/2021";
	private static String serial = "";
	private static TelaPrincipal telaPrincipal = new TelaPrincipalNull();
	private static SoftwareView softwareView;
	private static DaoLaudoeCia daoLc;

	// <editor-fold defaultstate="collapsed" desc="Tipos de execução">
	public static final String ATUALIZADOR = "atualizador";
	public static final String ATUALIZADOR_1_0_0 = "atualizadorV1.0.0";
	public static final String ATUALIZADOR_1_0_1 = "atualizadorV1.0.1";
	public static final String ATUALIZADOR_1_0_2 = "atualizadorV1.0.2";
	public static final String ATUALIZADOR_1_2_0 = "atualizadorV1.2.0";
	public static final String ATUALIZADOR_1_3_0 = "atualizadorV1.3.0";
	public static final String ATUALIZADOR_1_3_1 = "atualizadorV1.3.1";
	public static final String ATUALIZADOR_1_4_0 = "atualizadorV1.4.0";
	public static final String ATUALIZADOR_1_6_0 = "atualizadorV1.6.0";
	public static final String ATUALIZADOR_1_7_0 = "atualizadorV1.7.0";
	public static final String ATUALIZADOR_1_8_0 = "atualizadorV1.8.0";
	public static final String ATUALIZADOR_1_9_1 = "atualizadorV1.9.1";
	public static final String ATUALIZADOR_1_9_2 = "atualizadorV1.9.2";
	public static final String ATUALIZADOR_1_9_3 = "atualizadorV1.9.3";
	public static final String ATUALIZADOR_1_9_4 = "atualizadorV1.9.4";
	public static final String ATUALIZADOR_1_9_4_1 = "atualizadorV1.9.4.1";
	public static final String ATUALIZADOR_1_9_4_2 = "atualizadorV1.9.4.2";
	public static final String ATUALIZADOR_1_9_4_3 = "atualizadorV1.9.4.3";
	public static final String ATUALIZADOR_1_9_4_4 = "atualizadorV1.9.4.4";
	public static final String ATUALIZADOR_1_9_5 = "atualizadorV1.9.5";
	public static final String ATUALIZADOR_1_9_6 = "atualizadorV1.9.6";

	public static final String BACKUP_MANAGER = "backup";
	public static final String HBA = "hba";
	public static final String INSTALADOR = "instalador";
	public static final String LAUDO_E_CIA = "laudoecia";
	public static final String SALVAR_MDL = "laudos";
	public static final String SALVAR_ESTACAO = "salvarEstacao";
	public static final String FECHAR_BKP_MANAGER = "fecharbkpmanager";
	public static final String ATUALIZAR_PROC_DA_TABELA = "atualizarProcDaTabela";

	public static final String EXPORTAR_IMAGEM = "exportar";
	public static final String IMPORTAR_IMAGEM = "importar";
	public static final String CORRIGIR_BACKUP_DE_IMAGENS = "corrigirBackupDeImagens";
	public static final String VERIFICAR_BACKUP_DE_IMAGENS = "verificarBackupDeImagens";

	// </editor-fold>
	public LaudoeCia(String serial) {
		this.serial = serial;
	}

	// <editor-fold defaultstate="collapsed" desc="Getters and setters">
	public static TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

	public static SoftwareView getSoftwareView() {
		return softwareView;
	}

	public static void setTelaPrincipal(TelaPrincipal telaPrincipal) {
		if (telaPrincipal == null) {
			setTelaPrincipal(new TelaPrincipalNull());
		} else {
			LaudoeCia.telaPrincipal = telaPrincipal;
		}
	}

	public static void setSoftwareView(SoftwareView softwareView) {
		LaudoeCia.softwareView = softwareView;
	}

	private static DaoLaudoeCia getDaoLc() {
		if (daoLc == null) {
			daoLc = new DaoLaudoeCia();
		}
		return daoLc;
	}

	public static String getSerial() {
		return serial;
	}

	public static void setSerial(String serial) {
		LaudoeCia.serial = serial;
	}

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="Instalador">
	public static void configPermissoesDePasta() throws Exception {
		String property = StaticInfo.getNomeDoSistemaOperacional();
		String language = StaticInfo.getLinguagemDoSistemaOperacional();
		if (property.contains("XP")) {
			List<String> comandosDeCriacao = new ArrayList<>();
			comandosDeCriacao.add("cmd");
			comandosDeCriacao.add("/c");
			comandosDeCriacao.add("echo");
			comandosDeCriacao.add("pt".equals(language) ? "s|" : "y|");
			comandosDeCriacao.add("cacls");
			comandosDeCriacao.add(StaticInfo.getPastaDeInstalacaoDoSistema());
			comandosDeCriacao.add("/t");
			comandosDeCriacao.add("/e");
			comandosDeCriacao.add("/g");
			comandosDeCriacao.add("pt".equals(language) ? "todos:F" : "everyone:F");
			execProcPerm(comandosDeCriacao);
		} else {
			List<String> comandosDeCriacao = new ArrayList<>();
			comandosDeCriacao.add("icacls");
			comandosDeCriacao.add(StaticInfo.getPastaDeInstalacaoDoSistema());
			comandosDeCriacao.add("/t");
			comandosDeCriacao.add("/grant:r");
			comandosDeCriacao.add("pt".equals(language) ? "todos:F" : "everyone:F");
			execProcPerm(comandosDeCriacao);
		}
	}

	private static void execProcPerm(List<String> comandos) throws Exception {
		ProcessBuilder pb = new ProcessBuilder(comandos);
		Process process = pb.start();
		CopyInputStream cis = new CopyInputStream(process.getInputStream());
		InputStream is = cis.getCopy();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			while (br.readLine() != null) {
			}
		}
		if (process.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao configurar permissões de pasta!");
		}
	}

	public static void configurarDadosIniciais() throws Exception {

		DaoAtendimento daoAtendimento = new DaoAtendimento();
		Atendimento atd = daoAtendimento.procurarPorId(1);
		if (atd == null) {
		} else {
			atd.setDataAtendimento(new Date());
			daoAtendimento.alterar(atd, false);
		}
		DaoParametrosDoSistema daoParamDoSist = new DaoParametrosDoSistema();
		ParametrosDoSistema pds = StaticInfo.getParametrosDoSistema();
		if (pds == null) {
			throw new Exception("Parâmetros do sistema não encontrado!");
		} else {
			pds.setVersaoDoSw(LaudoeCia.VERSAO_DO_SISTEMA_ENUM);
			daoParamDoSist.alterar(pds);
			StaticInfo.gerarArqPcId();
		}
	}

	public static void configurarIPArqBd() throws Exception {
		// StaticInfo.escreverPropriedade(
		// StaticInfo.BANCO_DE_DADOS, StaticInfo.IP_SERVIDOR,
		// SystemUtils.getLocalHostIpAddress());
	}

	public static void configurarArqBdProperties() throws Exception {
		// StaticInfo.escreverPropriedade(
		// StaticInfo.BANCO_DE_DADOS, StaticInfo.IP_SERVIDOR,
		// SystemUtils.getLocalHostIpAddress());

		StaticInfo.escreverPropriedade(StaticInfo.BANCO_DE_DADOS, StaticInfo.PASTA_INST_BD,
				descobrirLocalDeInstDoPostgres83("Base Directory"));

		StaticInfo.escreverPropriedade(StaticInfo.BANCO_DE_DADOS, StaticInfo.DATA_DIR,
				descobrirLocalDeInstDoPostgres83("Data Directory"));

		StaticInfo.escreverPropriedade(StaticInfo.BANCO_DE_DADOS, StaticInfo.HOST_NAME, SystemUtils.getLocalHostName());

	}

	private static String descobrirLocalDeInstDoPostgres83(String setting) throws Exception {
		String pg83Dir = SystemUtils.lerRegWindows(
				"HKEY_LOCAL_MACHINE\\SOFTWARE\\PostgreSQL\\Installations\\" + "{B823632F-3B72-4514-8861-B961CE263224}",
				setting);
		if (pg83Dir == null || pg83Dir.isEmpty()) {
			throw new Exception("Erro ao descobrir pasta do banco de dados!");
		} else {
			String[] testeCaminho = pg83Dir.trim().split("REG_SZ    ");
			if (testeCaminho.length > 1) {
				return testeCaminho[1].trim();
			} else {
				return pg83Dir.trim();
			}
		}
	}

	private static class CopyInputStream {
		private final InputStream _is;
		private final ByteArrayOutputStream _copy = new ByteArrayOutputStream();

		private CopyInputStream(InputStream is) {
			_is = is;

			try {
				copy();
			} catch (IOException ex) {
			}
		}

		private int copy() throws IOException {
			int read = 0;
			int chunk = 0;
			byte[] data = new byte[256];

			while (-1 != (chunk = _is.read(data))) {
				read += data.length;
				_copy.write(data, 0, chunk);
			}

			return read;
		}

		public InputStream getCopy() {
			return new ByteArrayInputStream(_copy.toByteArray());
		}

	}

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="Atualizador">
	public static void atualizarVersaoDoSw() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.atualizarVersao();
	}

	public static void atualizarBdDaVersao1_0_0() {
		DaoLaudoeCia dao = getDaoLc();
		dao.criarColunaTamanhoSepRodape();
		dao.alterarTabelaParamDoLaudo1_0_0();
	}

	public static void atualizarRestoreDaVersao1_0_0() {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarTabelaParamDoLaudo1_0_0();
	}

	public static void atualizarBdERestoreDaVersao1_0_1() {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarTabelaParamDoLaudo1_0_1();
	}

	public static void atualizarBdDaVersao1_0_2() {
		DaoLaudoeCia dao = getDaoLc();
		dao.limparCadastroDeLicencas();
	}

	public static void atualizarBdDaVersao1_2_0() throws Exception {
		DaoModeloDeLaudo daoModeloDeLaudo = new DaoModeloDeLaudo();
		ModeloDeLaudo modeloDeLaudo = new ModeloDeLaudo();
		modeloDeLaudo.setNome("VIDEOCOLPOSCOPIA (PADRÃO)");
		modeloDeLaudo.setContexto("");
		modeloDeLaudo.setVisao("");
		daoModeloDeLaudo.adicionar(modeloDeLaudo);
	}

	public static void atualizarBdDaVersao1_3_0() throws Exception {
		DaoModeloDeLaudo daoModeloDeLaudo = new DaoModeloDeLaudo();
		ModeloDeLaudo modeloDeLaudo = new ModeloDeLaudo();
		modeloDeLaudo.setNome("TEXTO LIVRE");
		modeloDeLaudo.setContexto("");
		modeloDeLaudo.setVisao("");
		daoModeloDeLaudo.adicionar(modeloDeLaudo);
	}

	public static void atualizarBdDaVersao1_3_1() throws Exception {
		DaoModeloDeLaudo daoModeloDeLaudo = new DaoModeloDeLaudo();
		ModeloDeLaudo modeloDeLaudo = new ModeloDeLaudo();
		modeloDeLaudo.setNome("HISTEROSCOPIA DIAGNÓSTICA");
		modeloDeLaudo.setContexto("");
		modeloDeLaudo.setVisao("");
		daoModeloDeLaudo.adicionar(modeloDeLaudo);
	}

	public static void atualizarBdDaVersao1_4_0() throws Exception {
		DaoModeloDeLaudo daoModeloDeLaudo = new DaoModeloDeLaudo();
		ModeloDeLaudo modeloDeLaudo = new ModeloDeLaudo();
		modeloDeLaudo.setNome("ENDOSCOPIA DIGESTIVA BAIXA (COLONOSCOPIA)");
		modeloDeLaudo.setContexto("");
		modeloDeLaudo.setVisao("");
		daoModeloDeLaudo.adicionar(modeloDeLaudo);
	}

	public static void atualizarBdDaVersao1_6_0() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarTabelas1_6();
		dao.listar();
	}

	public static void atualizarBdDaVersao1_7_0() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarTabelas1_7();
	}

	public static void atualizarBdDaVersao1_8_0() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarTabelas1_8();
	}

	public static void atualizarDadosLaudos1_8_0() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarDadosLaudos1_8();
		DaoModeloDeLaudo daoModeloDeLaudo = new DaoModeloDeLaudo();
		ModeloDeLaudo modeloDeLaudo = new ModeloDeLaudo();
		modeloDeLaudo.setNome("VIDEOCOLPOSCOPIA (IFCPC 2011 REVISADO)");
		modeloDeLaudo.setContexto("");
		modeloDeLaudo.setVisao("");
		daoModeloDeLaudo.adicionar(modeloDeLaudo);
	}

	public static void atualizarDadosParaLaudos1_9_2() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarDadosLaudos1_9_2();
	}

	public static void atualizarBancoDeDados1_9_1() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarBd191();
	}

	public static void atualizarBancoDeDados1_9_2() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarBd192();
	}

	public static void atualizarBancoDeDados1_9_3() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarBd193();
	}

	public static void atualizarBancoDeDados1_9_4() throws Exception {

	}

	public static void atualizarBancoDeDados1_9_4_3() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarBd1943();
	}

	public static void atualizarBancoDeDados1_9_5() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarBd195();
	}

	public static void atualizarBancoDeDados1_9_6() throws Exception {
		DaoLaudoeCia dao = getDaoLc();
		dao.alterarBd196();
	}

	public static void atualizarProcDaTabela() throws Exception {
		DaoConvenio daoConvenio = new DaoConvenio();
		List<Convenio> convenios = daoConvenio.listar();
		DaoProcMedico daoProcMedico = new DaoProcMedico(false);
		List<ProcMedico> procs = daoProcMedico.listar();
		Set<ProcMedico> procsAlterados = new HashSet<>();
		for (ProcMedico procMedico : procs) {
			for (Convenio convenio : convenios) {
				if (procMedico.getProcDaTabela(convenio) == null) {
					ProcDaTabela procDaTabela = new ProcDaTabela();
					procDaTabela.setProcMedico(procMedico);
					procDaTabela.setTabelaDeProcedimentos(convenio.getTabelaDeProcedimentos());
					procDaTabela.setValorNoConvenio(new ValorFixo());
					procMedico.addProcDaTabela(procDaTabela);
					procsAlterados.add(procMedico);
				}
			}
		}
		daoProcMedico.alterar(new ArrayList<>(procsAlterados));
	}

	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="Funções do banco de dados">
	public static void vaccumDatabase() throws Exception {
		List<String> comandosDeCriacao = new ArrayList<>();

		comandosDeCriacao.add(StaticInfo.vacuumPath());

		comandosDeCriacao.add("--host");
		comandosDeCriacao.add(StaticInfo.ipDoServidor());

		comandosDeCriacao.add("--port");
		comandosDeCriacao.add(StaticInfo.getPortaBd());

		comandosDeCriacao.add("--username");
		comandosDeCriacao.add(StaticInfo.getUsuarioBd());

		comandosDeCriacao.add("--dbname");
		comandosDeCriacao.add(StaticInfo.getBancoDeDados());

		comandosDeCriacao.add("--analyze");

		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);

		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao analisar banco de dados!");
		}
	}

	public static void deletarBancoDeDados() throws Exception {
		reiniciarServicoPostgres();
		Thread.sleep(15000);
		dropDatabase();
	}

	public static void criarBancoDeDados() throws Exception {

		List<String> comandosDeCriacao = new ArrayList<>();

		comandosDeCriacao.add(StaticInfo.createDbPath());

		comandosDeCriacao.add("--host");
		comandosDeCriacao.add(StaticInfo.ipDoServidor());

		comandosDeCriacao.add("--port");
		comandosDeCriacao.add(StaticInfo.getPortaBd());

		comandosDeCriacao.add("--username");
		comandosDeCriacao.add(StaticInfo.getUsuarioBd());

		comandosDeCriacao.add(StaticInfo.getBancoDeDados());
		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);

		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao criar o banco de dados!");
		}
	}

	public static void deletarPlpgsql() throws Exception {

		List<String> comandosDeCriacao = new ArrayList<>();

		comandosDeCriacao.add(StaticInfo.pgPsqlPath());

		comandosDeCriacao.add("--host");
		comandosDeCriacao.add("localhost");

		comandosDeCriacao.add("--port");
		comandosDeCriacao.add(StaticInfo.getPortaBd());

		comandosDeCriacao.add("--username");
		comandosDeCriacao.add(StaticInfo.getUsuarioBd());

		comandosDeCriacao.add("--dbname");
		comandosDeCriacao.add(StaticInfo.getBancoDeDados());

		comandosDeCriacao.add("--command");
		comandosDeCriacao.add("\"DROP LANGUAGE IF EXISTS plpgsql\"");
		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);
		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao deletar linguagem Plpgsql!");
		}
	}

	public static void restaurarBancoDeDadosComSchema(String arqBkp) throws Exception {

		List<String> comandosDeCriacao = new ArrayList<>();

		comandosDeCriacao.add(StaticInfo.pgRestorePath());

		comandosDeCriacao.add("--host");
		comandosDeCriacao.add(StaticInfo.ipDoServidor());

		comandosDeCriacao.add("--port");
		comandosDeCriacao.add(StaticInfo.getPortaBd());

		comandosDeCriacao.add("--username");
		comandosDeCriacao.add(StaticInfo.getUsuarioBd());

		comandosDeCriacao.add("--dbname");
		comandosDeCriacao.add(StaticInfo.getBancoDeDados());

		comandosDeCriacao.add(arqBkp);

		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);
		Process p = pb.start();

		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao restaurar o banco de dados inicial!");
		}
	}

	public static void configurarHbaPtoConf() throws Exception {
		// File arquivo = new File(StaticInfo.pgHbaPath());
		// try (PrintWriter p = new PrintWriter(new FileWriter(arquivo)))
		// {
		// p.println(textoHba());
		// p.flush();
		// }
	}

	public static void configurarPadroesDoSistema() throws Exception {
		StaticInfo.getUfs();
		StaticInfo.getDefaultDDD();
		StaticInfo.getDefaultUF();
		StaticInfo.getTiss_Conselhos();
		ParametrosDaCaptura pc = StaticInfo.getParamsCaptura();
		if (pc != null) {
			pc.getPropriedades();
		}
		if (StaticInfo.getEstTrabalho() == null) {
			try {
				StaticInfo.cadastrarEstDeTrabalho();
			} catch (IOException ioe) {
				throw new Exception("Execute o setup do sistema!\nEle encontra"
						+ "-se na pasta de instalação do software no servidor.");
			} catch (Exception ex) {
				throw ex;
			}
		}
		StaticInfo.validarQtdEst();
		StaticInfo.getPastaDeInstalacaoDoSistema();
	}

	public static void configurarGenericDao() {
		configurarGenericDao(false, false);
	}

	public static void configurarGenericDao(boolean criarTabelas, boolean bkpinstall) {
		GenericDao.putProperty("javax.persistence.jdbc.url", StaticInfo.getUrlBd(bkpinstall));
		GenericDao.putProperty("javax.persistence.jdbc.password", StaticInfo.getSenhaUsuarioBd());
		GenericDao.putProperty("javax.persistence.jdbc.user", StaticInfo.getUsuarioBd());
		if (criarTabelas) {
			GenericDao.putProperty("eclipselink.ddl-generation", "create-tables");
		}
		GenericDao.setStringConfigurator(new StringConfigurator() {
			@Override
			public String configurarString(String buscaNoBancoDeDados) {
				return StringUtils.removerAcentos(buscaNoBancoDeDados).toUpperCase();
			}

		});
	}

	public static void execComoConfHba() throws Exception {
		List<String> comandosDeCriacao = new ArrayList<>();
		comandosDeCriacao.add(StaticInfo.getMiniRunAsPath());
		comandosDeCriacao.add(StaticInfo.getUsuarioSistema());
		comandosDeCriacao.add(StaticInfo.getSenhaUsuarioSistema());
		comandosDeCriacao.add("javaw");
		comandosDeCriacao.add("-jar");
		comandosDeCriacao.add(StaticInfo.getJarSemSplash());
		comandosDeCriacao.add(LaudoeCia.HBA);
		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao configurar hba.conf!");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Utils">
	private static void dropDatabase() throws Exception {
		List<String> comandosDeCriacao = new ArrayList<>();

		comandosDeCriacao.add(StaticInfo.dropDbPath());

		comandosDeCriacao.add("--host");
		comandosDeCriacao.add(StaticInfo.ipDoServidor());

		comandosDeCriacao.add("--port");
		comandosDeCriacao.add(StaticInfo.getPortaBd());

		comandosDeCriacao.add("--username");
		comandosDeCriacao.add(StaticInfo.getUsuarioBd());

		comandosDeCriacao.add(StaticInfo.getBancoDeDados());

		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);
		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao remover o banco de dados!");
		}
	}

	private static void reiniciarServicoPostgres() throws Exception {

		List<String> comandosDeCriacao = new ArrayList<>();

		comandosDeCriacao.add(StaticInfo.getMiniRunAsPath());

		comandosDeCriacao.add(StaticInfo.getUsuarioSistema());

		comandosDeCriacao.add(StaticInfo.getSenhaUsuarioSistema());

		comandosDeCriacao.add(StaticInfo.pgCtlPath());

		comandosDeCriacao.add("-w");
		comandosDeCriacao.add("-s");

		comandosDeCriacao.add("-m");
		comandosDeCriacao.add("immediate");

		comandosDeCriacao.add("-D");
		comandosDeCriacao.add(StaticInfo.pgDataDirPath());

		comandosDeCriacao.add("-o");
		comandosDeCriacao.add("\"-p " + StaticInfo.getPortaBd() + "\"");

		comandosDeCriacao.add("restart");

		ProcessBuilder pb = new ProcessBuilder(comandosDeCriacao);
		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao reiniciar o servico do banco de dados!");
		}
	}

	public static String textoHba() throws UnknownHostException {
		String hostAddress = SystemUtils.getLocalHostIpAddress();
		StringBuilder sb = new StringBuilder("");
		if (hostAddress == null || hostAddress.isEmpty() || !hostAddress.contains(".")) {
		} else {
			sb.append("host    all         all         ");
			sb.append(hostAddress.substring(0, hostAddress.lastIndexOf('.')));
			sb.append(".0/24").append("          trust \r\n");
		}
		sb.append("host    all         all         0.0.0.0/0      trust\r\n");
		sb.append("host    all         all         ");
		sb.append("127.0.0.1/32          md5 \r\n");
		sb.append("host    all         all         ::1/128               md5 ");
		return sb.toString();
	}

	// </editor-fold>
	// </editor-fold>
	public static void atualizarMdl() throws Exception {

		M_Doppler_Diversos.main(null);
		V_Doppler_Diversos.main(null);

		M_Endoscopia_Laparoscopia_Abdomen.main(null);
		V_Endoscopia_Laparoscopia_Abdomen.main(null);

		M_Obstetricos.main(null);
		V_Obstetricos.main(null);

		M_Outros.main(null);
		V_Outros.main(null);

		M_Morfologico.main(null);
		V_Morfologico.main(null);
	}

}
