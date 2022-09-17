package com.ic.projects.laudoecia.view.utils;

import java.io.File;

public class VersaoChromeInicia {

	public void VerificarChrome() {
		this.VerificaSeEstaLigado();
		
		DownloadChromeDriver downloade = new DownloadChromeDriver();
		downloade.BuscaVersao();
		
		try {
			String caminho = DiretorioDoSistemaUtil.PegaDiretorioChrome();
			File arq = new File(caminho);
			
			if(!arq.exists())
				arq.mkdir();
			
			if (downloade.CriarTxtVersao(caminho, downloade.getVersao())){				
				downloade.MontarUrl();
				downloade.Baixar();
				downloade.DescompactarZip(caminho);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void VerificaSeEstaLigado() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		} catch (Exception e) {
			System.out.println("ERRO NO METODO VerificaSeEstaLigado NA LINHA 30 CLASSE VersaoChromeInicia");
		}
	}

}
