package com.ic.projects.laudoecia.view.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;


public class DownloadChromeDriver {
	private URL url;
	private String versao;
	
	public void BuscaVersao(){
		VerificaVersaoCrhome ave = new VerificaVersaoCrhome();
		this.versao = ave.UltimaVerChromeDriver();
	}
	
	public boolean CriarTxtVersao(String caminho, String versao) throws IOException {
		File arquivo = new File(caminho + "\\" + versao + ".txt");

		if (!arquivo.exists()){
			this.ApagarArquivos(caminho);
	
			FileWriter arq = new FileWriter(arquivo);
	        PrintWriter gravarArq = new PrintWriter(arq);
	        gravarArq.printf(versao);
	        arq.close();
	        return true;
		} else {
			return false;
		}        
    }
	
	public void MontarUrl() {
		try {
			this.url = new URL("https://chromedriver.storage.googleapis.com/" + this.versao + "/chromedriver_win32.zip");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void Baixar() {
        try {    
        	String caminho = DiretorioDoSistemaUtil.PegaDiretorioChrome() + "\\chromedriver.zip";
        	File arquivo = new File(caminho);
        	 
        	if (!arquivo.exists()) 
        		this.SalvarArquivo(arquivo);
        } catch (Exception t) {
            t.printStackTrace();
        }
    }

    private void SalvarArquivo(File file) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        this.SalvarArquivo(out);
        out.close();
    }

    private void SalvarArquivo(OutputStream out) throws IOException {
        InputStream in = url.openStream();
        byte[] buffer = new byte[8192];
        for (int read = -1; (read = in.read(buffer)) != -1; out.write(buffer, 0, read)) {}
        out.flush();
    }
    
    public void DescompactarZip(String caminho) {
    	try {
    	    ZipFile zipFile = new ZipFile(caminho + "/chromedriver.zip");
    	    zipFile.extractAll(caminho);
    	} catch (ZipException e) {
    	    e.printStackTrace();
    	}
	}
    
    public void ApagarArquivos(String caminho) {
    	File folder = new File(caminho);
    	
    	if (folder.exists()) {
    		File[] sun = folder.listFiles();
    		for (File toDelete : sun) {
    			if(toDelete.getName() != this.versao + ".txt")
    				toDelete.delete();
    		}
    	}
    }
    
    public String getVersao() {
		return versao;
	}
}