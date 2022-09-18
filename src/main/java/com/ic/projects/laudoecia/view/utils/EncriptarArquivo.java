package com.ic.projects.laudoecia.view.utils;

import java.io.FileOutputStream;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class EncriptarArquivo {
	private String senhapadrao = "L@ud03cia";
	
	public void ReceberArquivo(byte[] imagem, String nomecaminhoimagem){	
		try {		
			FileOutputStream arquivofinal = new FileOutputStream(nomecaminhoimagem);
			this.Encriptar(imagem, arquivofinal);
			arquivofinal.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void Encriptar(byte[] imagem, FileOutputStream arqsaida)throws Exception {
		PBEKeySpec chave = new PBEKeySpec(this.senhapadrao.toCharArray());
		SecretKeyFactory instancia = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
		SecretKey chavesecreta = instancia.generateSecret(chave);

		byte[] arquivo = new byte[8];
		Random randomico = new Random();
		randomico.nextBytes(arquivo);

		PBEParameterSpec parametro = new PBEParameterSpec(arquivo, 100);
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
		cipher.init(Cipher.ENCRYPT_MODE, chavesecreta, parametro);

		byte[] a = cipher.update(imagem);

		arqsaida.write(a);
		arqsaida.flush();
		arqsaida.close();
	}
	
}



























































