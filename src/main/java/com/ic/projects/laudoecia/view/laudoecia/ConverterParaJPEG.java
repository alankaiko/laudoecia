package com.ic.projects.laudoecia.view.laudoecia;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import com.ic.projects.laudoecia.model.cadastro.ImagemJPEG;
import com.ic.projects.laudoecia.view.utils.DiretorioDoSistemaUtil;

//Jonathan Alves
public class ConverterParaJPEG {

	public List<ImagemJPEG> listaDeImagensCapturadas(Integer codigoProcedimento, Integer idAtendimento){
		List<ImagemJPEG> lista = new ArrayList<ImagemJPEG>();
		String caminho = null;
		final String nome = codigoProcedimento+"";
		
		try {
			caminho = DiretorioDoSistemaUtil.PegaDiretorioDeImagens()  + idAtendimento+"\\";
		} catch (IOException e) {}
		
		File dir = new File(caminho);
		FileFilter filtro = new FileFilter(){
		   public boolean accept(File arq) {
		      return arq.getName().startsWith(nome);
		   }
		};
		
		File[] arquivos = dir.listFiles(filtro);
		if(!arquivos.equals(null)) {
			for(File file : arquivos) {
				ImagemJPEG imagem = new ImagemJPEG();
				imagem.setNomeDaImagem(file.getName());
				imagem.setImagem(CarregandoImagens(caminho + file.getName()));
				lista.add(imagem);
			}
		}
		
		return lista;		
	}
	
	
	public byte[] CarregandoImagens(String arquivoPasta) {
		byte[] foto = null;
		
		try {
			File arquivo = new File(arquivoPasta);
			Path pega = Paths.get(arquivo.getAbsolutePath());
			foto = Files.readAllBytes(pega);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return foto;
	}
	
	public void Converter(String caminho, byte[] imager) {
		Iterator<ImageWriter> iterador = ImageIO.getImageWritersByFormatName("jpeg");
		ImageWriter subescreve = iterador.next();
		ImageWriteParam parametroimagem = subescreve.getDefaultWriteParam();
		parametroimagem.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		parametroimagem.setCompressionQuality(1);

		try {
			BufferedImage imagem = ImageIO.read(new ByteArrayInputStream(imager));
			IIOImage imagestream = new IIOImage(imagem, null, null);

			File file = new File(caminho);
			FileImageOutputStream output = new FileImageOutputStream(file);
			subescreve.setOutput(output);

			subescreve.write(null, imagestream, parametroimagem);
			subescreve.dispose();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
	}
	
	public void ExcluirImagens(String nome) {
		DiretorioDoSistemaUtil.DeletaArquivo(nome);
	}
	

}
