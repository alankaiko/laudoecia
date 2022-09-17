package com.ic.projects.laudoecia.view.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//https://www.guj.com.br/t/resolvido-metodo-post/369059
//de onde tirei a solucao
public class VerificaVersaoCrhome {
	private HttpURLConnection con;

	public String UltimaVerChromeDriver(){
		StringBuilder versao = null;
		
		try {
			URL url = new URL("https://chromedriver.storage.googleapis.com/LATEST_RELEASE");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String line;
				versao = new StringBuilder();

				while ((line = in.readLine()) != null) 
					versao.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
		}
		
		return versao.toString();
	}
}