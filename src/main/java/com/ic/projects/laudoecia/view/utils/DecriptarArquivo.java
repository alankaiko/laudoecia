package com.ic.projects.laudoecia.view.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class DecriptarArquivo {
private String senhapadrao = "L@ud03cia";
	
	public byte[] DevolverArquivo(String nomecaminhoimagem){	
		try {		
			FileInputStream arqentrada = new FileInputStream(nomecaminhoimagem);
			return this.Descriptar(arqentrada);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	private byte[] Descriptar(FileInputStream arqentrada)throws Exception {
		PBEKeySpec chave = new PBEKeySpec(this.senhapadrao.toCharArray());
		SecretKeyFactory instancia = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
		SecretKey chavesecreta = instancia.generateSecret(chave);

		byte[] salt = new byte[8];
		arqentrada.read(salt);

		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);

		Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
		cipher.init(Cipher.DECRYPT_MODE, chavesecreta, pbeParameterSpec);
		ByteArrayOutputStream  fos = new ByteArrayOutputStream();
		byte[] in = new byte[64];
		int read;
	
		while ((read = arqentrada.read(in)) != -1) {
			byte[] output = cipher.update(in, 0, read);
			if (output != null)
				fos.write(output);
		}

		arqentrada.close();
		fos.flush();
		fos.close();
		return fos.toByteArray();
	}
}
