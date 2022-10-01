package com.ic.projects.laudoecia.view.utils;

import java.io.File;
import java.io.IOException;

import com.ic.projects.laudoecia.control.build.StaticInfo;

public class DiretorioDoSistemaUtil {
	
	//retorna o diretorio das imagens
	public static String PegaDiretorioDeImagens() throws IOException {
		return UrlInstalacaoDoSistema() + "\\ImagensCapturadas\\";
	}
	
	public static String PegaDiretorioChrome() throws IOException {
		return UrlInstalacaoDoSistema() + "\\chrome";
	}
	
	public static String PegaDiretorioImgBackup() throws IOException {
		return UrlInstalacaoDoSistema() + "\\imgBkp\\";
	}
	
	//verifica se a pasta de cada imgBKP ja foi criada ou cria a medida que precisar
	public static void VerificaPastaDeImgBkp() {
		try {
			String caminho = PegaDiretorioImgBackup();
			File file = new File(caminho);
			Criar(file,caminho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//verifica se a pasta de cada atendimento ja foi criada ou cria a medida que precisar
	public static void VerificaPastaDeAtendimentos(int atendimento) {
		try {
			String caminho = PegaDiretorioDeImagens()+ atendimento;
			File file = new File(caminho);
			Criar(file,caminho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//metodo chama outro metodo e verifica node esta instalado o jar do sistema para entao criar a pasta de imagens
	public static String UrlInstalacaoDoSistema() throws IOException {
		return StaticInfo.getPastaDeInstalacaoDoSistema().substring(0, IdentificaPosicao()).replace("/", "\\");
	}
	
	
	//metodo verifica se o programa esta instalado no workspace do eclipse ou na pasta C:
	private static int IdentificaPosicao() throws IOException {
		boolean confere = StaticInfo.getPastaDeInstalacaoDoSistema().contains("/bin");
		return confere ? 
				StaticInfo.getPastaDeInstalacaoDoSistema().lastIndexOf("/bin") 
				: StaticInfo.getPastaDeInstalacaoDoSistema().lastIndexOf("/target");
	}
	
	//verifica se arquivos existem, e criam quando necessario e atribui permissao somente para leitura
	private static void Criar(File file, String caminho) throws IOException {
		if(!file.exists()) {
			file.mkdirs();
			file.setReadable(Boolean.TRUE, Boolean.TRUE);
			file.setWritable(Boolean.FALSE, Boolean.TRUE);
			file.setExecutable(Boolean.FALSE, Boolean.TRUE);
		}
	}

	
	public static void DeletaArquivo(String arquivo) {
		File file = new File(arquivo);
		file.delete();
	}
}
