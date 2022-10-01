package com.ic.projects.laudoecia.view.utils;

import com.ic.projects.laudoecia.view.laudoecia.ConverterParaJPEG;
import com.ic.projects.laudoecia.view.laudoecia.ServiceJPEG;
import org.bouncycastle.crypto.CryptoException;

import java.io.*;
import java.security.Key;
import java.util.Random;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncriptarArquivo {
	private String senhapadrao = "L@ud03cia";
	private static final String TRANSFORMATION = "AES";

	public void ReceberArquivo(byte[] imagem, String nomecaminhoimagem){
		try {
			FileOutputStream arquivofinal = new FileOutputStream(nomecaminhoimagem);
			this.encryptOrDecrypt(arquivofinal, imagem);
			//FileOutputStream arquivofinal = new FileOutputStream(nomecaminhoimagem);
			//this.Encriptar(imagem, arquivofinal);
			//arquivofinal.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Encriptar(byte[] imagem, FileOutputStream arqsaida)throws Exception {
		ConverterParaJPEG jpeg = new ConverterParaJPEG();
		File file = jpeg.Converter(imagem);

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


	public void encryptOrDecrypt(OutputStream os, byte[] imagem) throws Exception {
		ConverterParaJPEG jpeg = new ConverterParaJPEG();
		File file = jpeg.Converter(imagem);

		InputStream is = new FileInputStream(file);

		DESKeySpec dks = new DESKeySpec(this.senhapadrao.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

		cipher.init(Cipher.ENCRYPT_MODE, desKey);
		CipherInputStream cis = new CipherInputStream(is, cipher);
		doCopy(cis, os);
	}

	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;

		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}

		os.flush();
		os.close();
		is.close();
	}
}



























































