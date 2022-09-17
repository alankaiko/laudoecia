/*
 * BackupTask.java
 *
 * Created on 24/04/2012, 16:15:18
 */

package com.ic.projects.laudoecia.control.backup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.cadastro.DaoBackup;
import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.ic.projects.laudoecia.view.utils.DiretorioDoSistemaUtil;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class BackupTask extends TimerTask {

	private Backup backup;
	private BackupManager backupManager;

	private static Backup backupEmAndamento = null;
	private static DaoBackup daoBackup = new DaoBackup();
	private static DaoImagem daoImagem = new DaoImagem();

	private BackupTask(Backup backup, BackupManager backupManager) {
		this.backup = backup;
		this.backupManager = backupManager;
	}

	static BackupTask createInstance(Backup backup, BackupManager backupManager) {
		BackupTask bt = new BackupTask(backup, backupManager);
		new Timer().schedule(bt, backup.getDataMarcada());
		return bt;
	}

	Backup getBackup() {
		return backup;
	}

	// <editor-fold defaultstate="collapsed" desc="Equals and hashCode">

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BackupTask other = (BackupTask) obj;
		if (!Objects.equals(this.backup, other.getBackup())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + Objects.hashCode(this.backup);
		return hash;
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Utils">

	private boolean bkpDirWasCreated = false;

	private Path backupDirectory() {
		String backupDir;
		if (backup.isBackupAutomatico() || backup.getEstacao().equals(StaticInfo.getEstTrabalho())) {
			backupDir = backup.getDiretorioDoArquivo();
		} else {
			try {
				backupDir = StaticInfo.getPastaTemp();
			} catch (IOException ex) {
				backupDir = backup.getDiretorioDoArquivo();
			}
		}
		if (!bkpDirWasCreated) {
			new File(backupDir).mkdirs();
			bkpDirWasCreated = true;
		}
		return Paths.get(backupDir);
	}

	private List<String> criarComandoBackup(Path dir, List<String> tabelas) throws IOException {
		List<String> resposta = new ArrayList<>();

		resposta.add(StaticInfo.pgDumpPath()); // arquivo a ser executado

		resposta.add("-h"); // host
		resposta.add("localhost");

		resposta.add("-p"); // port
		resposta.add(StaticInfo.getPortaBd());

		resposta.add("-U"); // usuario
		resposta.add(StaticInfo.getUsuarioBd());

		resposta.add("-F"); // formato custom
		resposta.add("c");

		resposta.add("-b"); // blob

		resposta.add("-f"); // arquivo a ser criado
		resposta.add(dir.resolve(backup.fileName()).toString());

		for (int i = 0; i < tabelas.size(); i++) {
			resposta.add(tabelas.get(i));
		}

		resposta.add(StaticInfo.getBancoDeDados());

		return resposta;
	}

	private boolean validarConcorrencia() {
		if (backupEmAndamento == null) {
			return true;
		} else {
			backup.setStatus(STATUS_BACKUP.CONCURRENCY_EXCEPTION);
			try {
				daoBackup.alterar(backup);
			} catch (Exception ex) {
			}
			return false;
		}
	}

	private boolean validarStatusDoBackup() {
		Backup b = daoBackup.procurarPorId(backup.getCodigo());
		return !(b == null || b.getStatus().isStatusDeErro());
	}

	private void executarBackup(Path dir, List<String> tabelas) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder(criarComandoBackup(dir, tabelas));
		pb.environment().put("PGPASSWORD", StaticInfo.getSenhaUsuarioBd());
		pb.redirectErrorStream(true);
		if (pb.start().waitFor() == 0) {
		} else {
			throw new IOException("Erro ao realizar o backup!");
		}
	}

	// </editor-fold>

	@Override
	public void run() {
		try {
			if (validarConcorrencia() && validarStatusDoBackup()) {
				backupEmAndamento = backup;
				notificarInicioDoBackup();
				executarBackupDeDados();
				if (backup.getTipo() == TIPO_BACKUP.DADOS_E_IMAGENS) {
					executarBackupDeImagens();
					//Jonathan Alves
					this.executarBackupDaPastaDeImagens();
				}
				notificarFimDoBackup();
				backupEmAndamento = null;
			} else {
			}
		} catch (IOException ex) {
			manageBkpError(STATUS_BACKUP.IO_EXCEPTION);
		} catch (Exception ex) {
			manageBkpError(STATUS_BACKUP.ERRO_DESCONHECIDO);
		}
		backupManager.backupTerminou(this);
	}

	private void manageBkpError(STATUS_BACKUP status) {
		backupEmAndamento = null;
		backup.setStatus(status);
		try {
			daoBackup.alterar(backup);
		} catch (Exception ex) {
		}
		if (backup.isBackupAutomatico()) {
		} else {
			try {
				StaticInfo.escreverPropriedade(StaticInfo.BACKUP, StaticInfo.BACKUP_TERMINOU, "null");
				StaticInfo.escreverPropriedade(StaticInfo.BACKUP, StaticInfo.BACKUP_TERMINOU, String.valueOf(backup.getCodigo()));
			} catch (IOException ex) {
			}
		}
	}

	private void notificarInicioDoBackup() throws Exception {
		backup.setStatus(STATUS_BACKUP.EM_ANDAMENTO);
		backup.setDataDeInicio(new Date());
		daoBackup.alterar(backup);
		if (!backup.isBackupAutomatico()) {
			StaticInfo.escreverPropriedade(StaticInfo.BACKUP, StaticInfo.BACKUP_INICIOU, String.valueOf(backup.getCodigo()));
			Thread.sleep(MonitorDePropriedades.defaultSleepTime);
		}
	}

	private void notificarFimDoBackup() throws Exception {
		if (backup.isBackupAutomatico()) {
			backup.setStatus(STATUS_BACKUP.REALIZADO_COM_SUCESSO);
			backup.setDataDeTermino(new Date());
			daoBackup.alterar(backup);
		} else {
			StaticInfo.escreverPropriedade(StaticInfo.BACKUP, StaticInfo.BACKUP_TERMINOU, String.valueOf(backup.getCodigo()));
		}
	}

	private void executarBackupDeDados() throws IOException, InterruptedException {
		List<String> tabelas = new ArrayList<>();
		for (String tabela : StaticInfo.getTabelasDeImagens(true)) {
			tabelas.add("-T");
			tabelas.add(tabela);
		}
		for (String tabela : StaticInfo.getTabelasDeBaseDeDados()) {
			tabelas.add("-T");
			tabelas.add(tabela);
		}
		for (String tabela : StaticInfo.getTabelasEspecificasDaInstalacao()) {
			tabelas.add("-T");
			tabelas.add(tabela);
		}
		executarBackup(backupDirectory(), tabelas);
	}

	private void executarBackupDeImagens() throws IOException, InterruptedException, NumberFormatException {
		ImgFolderManager imgManager = new ImgFolderManager(backupDirectory());

		List<String> tabelas = new ArrayList<>();
		for (String tabela : StaticInfo.getTabelasDeImagens(false)) {
			tabelas.add("-t");
			tabelas.add(tabela);
		}
		Files.createDirectories(imgManager.pastaDeImagens());
		executarBackup(imgManager.pastaDeImagens(), tabelas);

		int imagemQueVaiSerExportada = daoImagem.getMaxID();

		while (imagemQueVaiSerExportada > 0) {
			Imagem imagem = daoImagem.procurarPorId(imagemQueVaiSerExportada);
			imagemQueVaiSerExportada--;
			if (imagem == null) {
				continue;
			}
			if (!imgManager.exportarImagem(imagem)) {
				break;
			}
		}
	}
	
	//Jonathan Alves
	private void executarBackupDaPastaDeImagens() throws IOException {
		try {
			File source = new File(DiretorioDoSistemaUtil.PegaDiretorioDeImagens());
			File dest = new File(this.backup.getDiretorioDoArquivo() + "\\ImagensCapturadas");
		    FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

}
