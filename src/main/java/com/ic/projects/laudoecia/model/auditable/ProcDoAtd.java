/*
 * ProcDoAtd.java
 *
 * Created on 19/01/2012, 09:51:43
 */
package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.cadastro.ImagemImpressa;
import com.ic.projects.laudoecia.model.cadastro.PaginaDeImagens;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.lib.java.utils.Comparador;
import com.lib.java.utils.Money;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "procdoatd")
public class ProcDoAtd implements Serializable, Comparable<ProcDoAtd> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;

	@JoinColumn(name = "atendimento_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Atendimento atendimento;

	@JoinColumn(name = "profexecutante_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProfExecutante profExecutante;

	@JoinColumn(name = "procdatabela_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProcDaTabela procDaTabela;

	@JoinColumn(name = "laudo_codigo", referencedColumnName = "codigo", nullable = true, unique = true)
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	private Laudo laudo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinTable(name = "procdoatd_imagem", joinColumns = @JoinColumn(name = "procdoatd_codigo"), inverseJoinColumns = @JoinColumn(name = "imagem_codigo"))
	@OrderBy(value = "indice")
	// order column, which is easier, didnt fucking work after weaving)
	private List<Imagem> imagens = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "procedimento", orphanRemoval = true)
	private List<VideoGravado> videosGravados = new ArrayList<>();

	@Column(name = "valorpaciente")
	private double valorPaciente = 0d;

	@Column(name = "valorconvenio")
	private double valorConvenio = 0d;

	@Column(name = "preventregalaudo", nullable = true)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date prevEntregaLaudo = new Date();

	@Column(name = "datadaexecucao", nullable = true)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataDaExecucao = new Date();

	@JoinColumn(name = "cid_motivo_ex_codigo", referencedColumnName = "codigo", nullable = true)
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private SubcategoriaCID10 cidMotivoDoExame;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "procDoAtd", orphanRemoval = true)
	private List<PaginaDeImagens> impressoesDeImg = new ArrayList<>();

	@JoinColumn(name = "estacao_codigo", referencedColumnName = "codigo", nullable = true)
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private EstacaoDeTrabalho estacao;

	public EstacaoDeTrabalho getEstacao() {
		return estacao;
	}

	public void setEstacao(EstacaoDeTrabalho estacao) {
		this.estacao = estacao;
	}

	// <editor-fold defaultstate="collapsed" desc="Getters and setters">

	public SubcategoriaCID10 getCidMotivoDoExame() {
		return cidMotivoDoExame;
	}

	public void setCidMotivoDoExame(SubcategoriaCID10 cidMotivoDoExame) {
		this.cidMotivoDoExame = cidMotivoDoExame;
	}

	public List<Imagem> getImagens() {
		return Collections.unmodifiableList(imagens);
	}

	public List<VideoGravado> getVideosGravados() {
		return Collections.unmodifiableList(videosGravados);
	}

	public Laudo getLaudo() {
		return laudo;
	}

	public void setLaudo(Laudo laudo) {
		this.laudo = laudo;
		if (laudo != null) {
			laudo.setProcDoAtd(this);
		}
	}

	public ProcDaTabela getProcDaTabela() {
		return procDaTabela;
	}

	public void setProcDaTabela(ProcDaTabela procDaTabela) {
		this.procDaTabela = procDaTabela;
	}

	public ProfExecutante getProfExecutante() {
		return profExecutante;
	}

	public void setProfExecutante(ProfExecutante profExecutante) {
		this.profExecutante = profExecutante;
	}

	public Date getDataDaExecucao() {
		return dataDaExecucao;
	}

	public void setDataDaExecucao(Date dataDaExecucao) {
		this.dataDaExecucao = dataDaExecucao;
	}

	public Date getPrevEntregaLaudo() {
		return prevEntregaLaudo;
	}

	public void setPrevEntregaLaudo(Date prevEntregaLaudo) {
		this.prevEntregaLaudo = prevEntregaLaudo;
	}

	public Money getValorPaciente() {
		return new Money(valorPaciente);
	}

	public void setValorPaciente(double valorPaciente) {
		this.valorPaciente = new Money(valorPaciente).doubleValue();
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Money getValorConvenio() {
		return new Money(valorConvenio);
	}

	public void setValorConvenio(double valorConvenio) {
		this.valorConvenio = new Money(valorConvenio).doubleValue();
	}

	public ProcMedico getProcMedico() {
		return procDaTabela == null ? null : procDaTabela.getProcMedico();
	}

	public List<PaginaDeImagens> getImpressoesDeImg() {
		return Collections.unmodifiableList(impressoesDeImg);
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Overrides">

	@Override
	public String toString() {
		ProcMedico p = getProcMedico();
		return p == null ? "" : p.toString();
	}

	@Override
	public int compareTo(ProcDoAtd o) {
		return Comparador.compararRemovendoAcentos(this, o);
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Vídeos">

	public void addVideoGravado(VideoGravado video) {
		if (video == null) {
		} else {
			videosGravados.add(video);
			video.setProcedimento(this);
		}
	}

	public void removeVideoGravado(VideoGravado video) {
		if (video == null) {
		} else if (video.getCodigo() == 0) {
			for (int i = 0; i < videosGravados.size(); i++) {
				VideoGravado videoGravado = videosGravados.get(i);
				if (videoGravado.getCaminho().equals(video.getCaminho())
						&& videoGravado.getEstacaoDeTrabalho().equals(video.getEstacaoDeTrabalho())) {
					videosGravados.remove(i);
					break;
				}
			}
		} else {
			videosGravados.remove(video);
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Impressão">

	public void addImpImagem(PaginaDeImagens impImg) {
		impressoesDeImg.add(impImg);
	}

	public void removeImpImg(PaginaDeImagens impImg) {
		impressoesDeImg.remove(impImg);
	}

	public void removeImpImg(int index) {
		impressoesDeImg.remove(index);
	}

	public void setImpImg(int index, PaginaDeImagens impImg) {
		impressoesDeImg.set(index, impImg);
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Imagens">

	public void addImagem(Imagem img) {
		imagens.add(img);
	}

	public void removeImagem(Imagem img) {
		if (img.getCodigo() == 0) {
			int contadorDeImgComCodigo0 = 0;
			for (Imagem imagem : imagens) {
				if (imagem.getCodigo() == 0) {
					contadorDeImgComCodigo0++;
				}
			}
			switch (contadorDeImgComCodigo0) {
			case 0:
				break;
			case 1:
				if (imagens.remove(img)) {
					imagemFoiRemovida(img);
				}
				break;
			default:
				for (int i = 0; i < imagens.size(); i++) {
					Imagem imagem = imagens.get(i);
					if (Arrays.equals(imagem.getImagem(), img.getImagem())) {
						imagemFoiRemovida(imagens.remove(i));
						break;
					}
				}
			}
		} else {
			if (imagens.remove(img)) {
				imagemFoiRemovida(img);
			}
		}
	}

	public void removeImagem(int index) {
		imagemFoiRemovida(imagens.remove(index));
	}

	private void imagemFoiRemovida(Imagem img) {
		if (img != null) {
			for (int indexPag = 0; indexPag < impressoesDeImg.size(); indexPag++) {
				PaginaDeImagens pagina = impressoesDeImg.get(indexPag);
				List<ImagemImpressa> imagensImp = pagina.getImagens();
				for (int j = 0; j < imagensImp.size(); j++) {
					ImagemImpressa imgImp = imagensImp.get(j);
					if (imagensSaoIguais(imgImp.getImagem(), img)) {
						imgImp.setImagem(null);
					}
				}
			}
			for (int indexPagina = 0; indexPagina < impressoesDeImg.size(); indexPagina++) {
				PaginaDeImagens pagina = impressoesDeImg.get(indexPagina);
				List<ImagemImpressa> imagensImp = pagina.getImagens();
				boolean listaDeImagensMudou;
				do {
					listaDeImagensMudou = false;
					for (int i = 0; i < imagensImp.size(); i++) {
						if (imagensImp.get(i).getImagem() == null) {
							pagina.removeImagem(i);
							listaDeImagensMudou = true;
							break;
						}
					}
				} while (listaDeImagensMudou);
			}
		}
	}

	public void setImagem(int index, Imagem imagem) {
		imagens.set(index, imagem);
	}

	public boolean imagensSaoIguais(Imagem i1, Imagem i2) {
		if (Objects.equals(i1, i2)) {
			if (i1.getCodigo() == 0) {
				return Arrays.equals(i1.getImagem(), i2.getImagem());
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	// </editor-fold>


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProcDoAtd procDoAtd = (ProcDoAtd) o;

		return codigo == procDoAtd.codigo;
	}

	@Override
	public int hashCode() {
		return codigo;
	}
}
