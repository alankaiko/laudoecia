package com.ic.projects.laudoecia.view.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

public class DecriptarArquivo {
	private String senhapadrao = "L@ud03cia";
	
	public byte[] DevolverArquivo(String nomecaminhoimagem){	
		try {
			byte[] encriptado = this.CarregandoImagens(nomecaminhoimagem);

			return this.Descriptar(encriptado);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public byte[] Descriptar(byte[] arquivo) throws Exception {
		DESKeySpec dks = new DESKeySpec(this.senhapadrao.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);

		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, desKey);

		return cipher.doFinal(arquivo);
	}

	public byte[] CarregandoImagens(String arquivoPasta) throws Exception {
		File arquivo = new File(arquivoPasta);
		Path pega = Paths.get(arquivo.getAbsolutePath());
		return Files.readAllBytes(pega);
	}
}
