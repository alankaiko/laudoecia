/*
 * RestoreManager.java
 *
 * Created on 16/04/2012, 14:21:06
 */
package com.ic.projects.laudoecia.control.backup;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.dao.utils.DaoLaudoeCia;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;

/**
 * @author Marcelo <marcelo@instrumentalcientifico.com.br>
 */
public class RestoreManager {

	private static FileFilterRestore fileFilterRestore = new FileFilterRestore();
	private static SimpleDateFormat meuSdf;
	private static String regexArqBkp;
	private TIPO_BACKUP tipo;
	private File backupFile;

	static {
		meuSdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss", new Locale("pt", "BR"));
		regexArqBkp = "[0-9]{2}\\-[0-9]{2}\\-[0-9]{4} " + "[0-9]{2}\\-[0-9]{2}\\-[0-9]{2}\\.backup";
	}

	public RestoreManager(TIPO_BACKUP tipo, File backupFile) throws IllegalArgumentException {
		if (tipo == null) {
			throw new IllegalArgumentException("Escolha o tipo de backup!");
		}
		if (backupFile == null) {
			throw new IllegalArgumentException("Escolha um arquivo de backup!");
		}
		if (!validarArquivoBackup(backupFile, tipo)) {
			throw new IllegalArgumentException("Arquivo backup inválido!");
		}
		this.tipo = tipo;
		this.backupFile = backupFile;
	}

	@SuppressWarnings("fallthrough")
	public void executar() throws IOException, InterruptedException, Exception {
		recriarBancoDeDados();
		
		this.ConfigurandoTabelaAdicional();
		
		executarRestoreDados();
		DaoImagem daoImagem = new DaoImagem();
		// metodos chamados para reiniciar a conexao.
		// se houver erro na consulta, o que vai ocorrer, a conexao sera
		// feita novamente e as proximas chamadas terao sucesso
		daoImagem.listar();
		daoImagem.listar();
		if (tipo == TIPO_BACKUP.DADOS_E_IMAGENS) {
			new ImgFolderManager(backupFile.toPath().getParent()).restaurarImagens(daoImagem);
			new DaoLaudoeCia().atualizarIndiceImg();
			executarRestoreImagens();
			daoImagem.deletarImagensOrfas();
		}
		ParametrosDoSistema pds = StaticInfo.getParametrosDoSistema(true);
		switch (pds.getVersaoDoSw()) {
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
	
	private void ConfigurandoTabelaAdicional() {
		this.CriarTabela();
		this.AlterarTabelaParamSistema();
		this.AlteraGrupoDeUsuariosAcessa();
		this.AlteraGrupoDeUsuariosAdd();
		this.AlteraGrupoDeUsuariosAlt();
		this.AlteraGrupoDeUsuariosApaga();
		this.AlteraImagemImpressa();	
		this.AlteraGrupoDeUsuariosAcessaCons();
		this.AlteraGrupoDeUsuariosAddCons();
		this.AlteraGrupoDeUsuariosAltCons();
		this.AlteraGrupoDeUsuariosApagaCons();
		this.AdicionaAnonimizadoPaciente();
		this.AdicionaAnonimizadoPacienteData();
		this.AlteraGrupoDeUsuariosAcessaPolitica();
		this.AlteraGrupoDeUsuariosAddPolitica();
		this.AlteraGrupoDeUsuariosAltPolitica();
		this.AlteraGrupoDeUsuariosApagaPolitica();
		this.CriarTabelaPoliticaPrivacidade();
		this.CriarTabelaConsentimento();
	}
	
	private void AlteraImagemImpressa(){
		String sql= "ALTER TABLE imagemimpressa ADD COLUMN caminhoimagemjpeg character varying(255)";
				
		try{
			System.out.println("1 - INICIO COMANDO classe ComandosSimplesDAO Método AlteraImagemImpressa");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraImagemImpressa");
		} catch(Exception e){
			System.out.println("1 - Erro == Classe ComandosSimplesDAO Método AlteraImagemImpressa");
		}
		System.out.println("============================================================================");
	}
	
	private void CriarTabela(){
		String sql= "CREATE TABLE emailparametros (codigo serial NOT NULL, tipo character varying(50) NOT NULL,"
				+ " login character varying(50) NOT NULL, senha character varying(50) NOT NULL,"
				+ "smtp character varying(150) NOT NULL, portsocket character varying(150),"
				+ "socket character varying(150), port character varying(150) NOT NULL, ssl boolean,"
				+ "CONSTRAINT emailparametros_pkey PRIMARY KEY (codigo))";
				
		try{
			System.out.println("4 - INICIO COMANDO classe ComandosSimplesDAO Método CriarTabela");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método CriarTabela");
		} catch(Exception e){
			System.out.println("4 - Erro == classe ComandosSimplesDAO Método CriarTabela");
		}
		System.out.println("============================================================================");
	}
	
	private void AlterarTabelaParamSistema(){
		String sql= "ALTER TABLE parametrosdosistema ADD COLUMN parametrobuscasigla character varying(255)";
				
		try{
			System.out.println("6 - INICIO COMANDO classe ComandosSimplesDAO Método AlterarTabelaParamSistema");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlterarTabelaParamSistema");
		} catch(Exception e){
			System.out.println("6 - Erro == classe ComandosSimplesDAO Método AlterarTabelaParamSistema");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAcessa(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN acessaparametrosemail boolean";
				
		try{
			System.out.println("7 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuarios");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuarios");
		} catch(Exception e){
			System.out.println("7 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuarios");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAdd(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN adicionaparametrosemail boolean";
				
		try{
			System.out.println("8 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAdd");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAdd");
		} catch(Exception e){
			System.out.println("8 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAdd");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAlt(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN alteraparametrosemail boolean";
				
		try{
			System.out.println("9 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAlt");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAlt");
		} catch(Exception e){
			System.out.println("9 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAlt");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosApaga(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN apagaparametrosemail boolean";
				
		try{
			System.out.println("10 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApaga");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApaga");
		} catch(Exception e){
			System.out.println("10 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApaga");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAcessaCons(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN acessaconsentimento boolean";
				
		try{
			System.out.println("11 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAcessaCons");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAcessaCons");
		} catch(Exception e){
			System.out.println("11 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAcessaCons");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAddCons(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN adicionaconsentimento boolean";
				
		try{
			System.out.println("12 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAddCons");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAddCons");
		} catch(Exception e){
			System.out.println("12 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAddCons");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAltCons(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN alteraconsentimento boolean";
				
		try{
			System.out.println("13 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAltCons");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAltCons");
		} catch(Exception e){
			System.out.println("13 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAltCons");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosApagaCons(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN apagaconsentimento boolean";
				
		try{
			System.out.println("14 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApagaCons");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApagaCons");
		} catch(Exception e){
			System.out.println("14 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApagaCons");
		}
		System.out.println("============================================================================");
	}
	
	
	
	private void AdicionaAnonimizadoPaciente(){
		String sql= "ALTER TABLE paciente ADD COLUMN anonimo boolean";
				
		try{
			System.out.println("15 - INICIO COMANDO classe ComandosSimplesDAO Método AdicionaAnonimizadoPaciente");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AdicionaAnonimizadoPaciente");
		} catch(Exception e){
			System.out.println("15 - Erro == Classe ComandosSimplesDAO Método AdicionaAnonimizadoPaciente");
		}
		System.out.println("============================================================================");
	}
	
	private void AdicionaAnonimizadoPacienteData(){
		String sql= "ALTER TABLE paciente ADD COLUMN dataanonimo date";
				
		try{
			System.out.println("16 - INICIO COMANDO classe ComandosSimplesDAO Método AdicionaAnonimizadoPacienteData");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AdicionaAnonimizadoPacienteData");
		} catch(Exception e){
			System.out.println("16 - Erro == Classe ComandosSimplesDAO Método AdicionaAnonimizadoPacienteData");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAcessaPolitica(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN acessapoliticaprivacidade boolean";
				
		try{
			System.out.println("17 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAcessaPolitica");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAcessaPolitica");
		} catch(Exception e){
			System.out.println("17 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAcessaPolitica");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAddPolitica(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN adicionapoliticaprivacidade boolean";
				
		try{
			System.out.println("18 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAddPolitica");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAddPolitica");
		} catch(Exception e){
			System.out.println("18 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAddPolitica");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosAltPolitica(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN alterapoliticaprivacidade boolean";
				
		try{
			System.out.println("19 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAltPolitica");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAltPolitica");
		} catch(Exception e){
			System.out.println("19 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosAltPolitica");
		}
		System.out.println("============================================================================");
	}
	
	private void AlteraGrupoDeUsuariosApagaPolitica(){
		String sql= "ALTER TABLE grupodeusuarios ADD COLUMN apagapoliticaprivacidade boolean";
				
		try{
			System.out.println("20 -INICIO COMANDO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApagaPolitica");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApagaPolitica");
		} catch(Exception e){
			System.out.println("20 - Erro == Classe ComandosSimplesDAO Método AlteraGrupoDeUsuariosApagaPolitica");
		}
		System.out.println("============================================================================");
	}
	
	private void CriarTabelaPoliticaPrivacidade(){
		String sql= "CREATE TABLE politicaprivacidade ("
				+ "codigo serial NOT NULL,"
				+ "titulo character varying(100),"
				+ " termo character varying(15000) NOT NULL,"
				+ "versao character varying(50),"
				+ "ativo boolean,"
				+ "datacadastro date,"
				+ "datadesativacao date,"
				+ "CONSTRAINT politicaprivacidade_pkey PRIMARY KEY (codigo))";
		
	
				
		try{
			System.out.println("21 - INICIO COMANDO classe ComandosSimplesDAO Método CriarTabelaConsentimento");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método CriarTabelaConsentimento");
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("21 - Erro == classe ComandosSimplesDAO Método CriarTabelaConsentimento");
		}
		System.out.println("============================================================================");
	}
	
	private void CriarTabelaConsentimento(){
		String sql= "CREATE TABLE Consentimento ("
				+ "codigo serial NOT NULL,"
				+ "descricao character varying(100),"
				+ "aceito boolean,"
				+ "revogado boolean,"
				+ "scannerdocumento bytea,"
				+ "dataaceitacao date,"
				+ "datarevogacao date,"
				+ "tbl_paciente_id integer,"
				+ "tbl_politicaprivacidade_id integer,"
				+ "CONSTRAINT consentimento_pkey PRIMARY KEY (codigo),"
				+ "CONSTRAINT fk_consentimento_paciente_codigo FOREIGN KEY (tbl_paciente_id) REFERENCES paciente (codigo), "
				+ "CONSTRAINT fk_consentimento_politica_codigo FOREIGN KEY (tbl_politicaprivacidade_id) REFERENCES politicaprivacidade (codigo) "
				+ "MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION)";
		
	
				
		try{
			System.out.println("22 - INICIO COMANDO classe ComandosSimplesDAO Método CriarTabelaConsentimento");
			Connection con = this.Conectando();
			PreparedStatement injetar=con.prepareStatement(sql);
			injetar.execute();
			injetar.close();
			con.close();
			System.out.println("SUCESSO classe ComandosSimplesDAO Método CriarTabelaConsentimento");
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("22 - Erro == classe ComandosSimplesDAO Método CriarTabelaConsentimento");
		}
		System.out.println("============================================================================");
	}
	
	
	
	
	private Connection Conectando(){
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5434/laudoecia","teknamed","Joao1030");
		}
		catch(Exception e){
			System.out.println("Erro ao conectar no banco");
			e.printStackTrace();
			return null;
		}
	}
	
	private void recriarBancoDeDados() throws Exception {
		LaudoeCia.deletarBancoDeDados();
		LaudoeCia.criarBancoDeDados();
		LaudoeCia.deletarPlpgsql();
		LaudoeCia.restaurarBancoDeDadosComSchema(StaticInfo.arquivoBackupParaRestore());
	}

	private void executarRestoreDados() throws IOException, Exception {
		ProcessBuilder pb = new ProcessBuilder(criarComandoRestore(backupFile.getPath()));
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);
		Process p = pb.start();
		if (p.waitFor() == 0) {
		} else {
			throw new Exception("Erro ao restaurar os dados do backup!");
		}
	}

	private void executarRestoreImagens() throws IOException, InterruptedException, Exception {
		ProcessBuilder pb = new ProcessBuilder(criarComandoRestore(getImgBkpFile()));
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);
		if (pb.start().waitFor() == 0) {
		} else {
			throw new Exception("Erro ao restaurar o cadastro de imagens!");
		}
	}

	private String getImgBkpFile() {
		return Paths.get(backupFile.getParent(), "imagens", backupFile.getName()).toString();
	}

	private boolean validarArquivoBackup(File backupFile, TIPO_BACKUP tipo) {
		if (!(backupFile.isFile() || backupFile.exists() || backupFile.getParentFile().isDirectory())) {
			return false;
		}
		if (backupFile.getName().matches(regexArqBkp)) {
			switch (tipo) {
			case DADOS:
				return true;
			case DADOS_E_IMAGENS:
				File bkpFolder = backupFile.getParentFile();
				File[] bkpFolderFiles = bkpFolder.listFiles();
				for (int i = 0; i < bkpFolderFiles.length; i++) {
					File bkpFolderFile = bkpFolderFiles[i];
					if (bkpFolderFile.isDirectory() && "imagens".equals(bkpFolderFile.getName())) {
						File pastaImagens = bkpFolderFile;
						File[] pastaImagensFiles = pastaImagens.listFiles();
						for (int j = 0; j < pastaImagensFiles.length; j++) {
							File pastaImagensFile = pastaImagensFiles[j];
							if (pastaImagensFile.getName().equals(backupFile.getName())) {
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
		} else {
			return false;
		}
	}

	private List<String> criarComandoRestore(String caminhoArquivoBackup) throws IOException {
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

	public static Map<Date, File> buscarArquivosDeBackup(File pastaDeBackups) {
		Map<Date, File> resp = new HashMap<>();
		List<File> arquivosDeBackup = new ArrayList<>();
		if (pastaDeBackups != null && pastaDeBackups.exists()) {
			File[] filesArray = pastaDeBackups.listFiles(fileFilterRestore);
			arquivosDeBackup.addAll(Arrays.asList(filesArray));
		}
		for (int i = 0; i < arquivosDeBackup.size(); i++) {
			File file = arquivosDeBackup.get(i);
			String fileName = file.getName();
			String nameWithoutExt = fileName.substring(0, fileName.indexOf('.'));
			try {
				Date bkpDate = meuSdf.parse(nameWithoutExt);
				resp.put(bkpDate, file);
			} catch (ParseException ex) {
			}
		}
		return resp;
	}

	private static class FileFilterRestore implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			return pathname.isFile() && pathname.getName().matches(regexArqBkp);
		}

	}

}