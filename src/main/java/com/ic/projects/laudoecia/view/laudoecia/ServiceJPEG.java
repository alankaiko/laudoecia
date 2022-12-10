package com.ic.projects.laudoecia.view.laudoecia;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.ImagemJPEG;
import com.ic.projects.laudoecia.view.utils.DiretorioDoSistemaUtil;

//Jonathan Alves - classe inteira
public class ServiceJPEG {
	//private LaudoeCiaMediator mediator;
	private Atendimento atendimento;
	private ProcDoAtd procedimento;
	private int cont = 1;


	
	public ServiceJPEG(Atendimento atendimento, ProcDoAtd procedimento) {
		this.atendimento = atendimento;
		this.procedimento = procedimento;
		VerificaOuCria();
	}
	
	
	public List<ImagemJPEG> ListaImagensCapturadas(Integer codigoProcedimento, Integer idAtendimento) {
			ConverterParaJPEG converte = new ConverterParaJPEG();
			return converte.listaDeImagensCapturadas(codigoProcedimento, idAtendimento);
	}
	
	public void CriaImagemNaPasta(byte[] imagem) {
		try {
			ConverterParaJPEG conv = new ConverterParaJPEG();
			conv.Converter(Arquivo(), imagem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void EditarImageNaPasta(String nomeImagem, byte[] imagem) {
		try {
			ConverterParaJPEG converte = new ConverterParaJPEG();
			converte.Converter(CriaPastaAtendimento() + nomeImagem, imagem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean ExcluirImagem(ImagemJPEG imagemjpeg) {
		try {
			ConverterParaJPEG converte = new ConverterParaJPEG();
			converte.ExcluirImagens(CriaPastaAtendimento() + imagemjpeg.getNomeDaImagem());
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	

	// ------------------------METODOS PRIVADOS PARA CONSTRUIR O NOME DAS
	// IMAGENS---------------------//
	// verifica se a pasta de atendimento ja existe dentro da pasta
	// imagenscapturadas, caso nao exista, o metodo manda criar
	private void VerificaOuCria() {
		DiretorioDoSistemaUtil.VerificaPastaDeAtendimentos(this.atendimento.getCodigo());
	}

	// chama o metodo "Verifica" para pegar o nome da imagem completa
	// e verifica se o nome da imagem ja existe. Tambem retorna o nome final que
	// sera usado na imagem
	private String Arquivo() throws IOException {
		while (new File(Verifica()).exists())
			this.cont++;

		return Verifica();
	}

	// monta o nome da imagem e retorna pra quem chamar
	private String Verifica() throws IOException {
		return CriaPastaAtendimento() + ConstroiNomeImagem();
	}

	private String CriaPastaAtendimento() throws IOException {
		return DiretorioDoSistemaUtil.PegaDiretorioDeImagens() + this.atendimento.getCodigo() + "\\";
	}

	// constroi o nome da imagem usando o numero do procedimento e o contador
	private String ConstroiNomeImagem() {
		String nome = this.procedimento.getProcMedico().getCodigo() + "";
		nome = nome + Teste() + ".jpg";

		return nome;
	}

	private String Teste() {
		return String.format("%02d", this.cont);
	}

}
