/*
 * PaginaDeImagens.java
 *
 * Created on 02/10/2012, 10:19:35
 */

package com.ic.projects.laudoecia.model.cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
@Entity
@Table(name = "paginadeimagens")
public class PaginaDeImagens implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "layout", nullable = false)
	private LAYOUT_IMG layout;

	// Removido CascadeType.ALL a pedido do Janio para não ocorrer erros ao salvar
	// imagens impressas
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "pagina")
	private List<ImagemImpressa> imagens = new ArrayList<>();

	@JoinColumn(name = "procdoatd_codigo", referencedColumnName = "codigo")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProcDoAtd procDoAtd;

	public PaginaDeImagens(LAYOUT_IMG layout) {
		this.layout = layout;
	}

	public PaginaDeImagens() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<ImagemImpressa> getImagens() {
		return Collections.unmodifiableList(imagens);
	}

	public void setImagens(List<ImagemImpressa> imagens) {
		this.imagens.clear();
		if (imagens == null) {
		} else {
			this.imagens.addAll(imagens);
		}
	}

	public void addImagem(ImagemImpressa imagem) {
		imagens.add(imagem);
	}

	public void removeImagem(int index) {
		imagens.remove(index);
	}

	public LAYOUT_IMG getLayout() {
		return layout;
	}

	public void setLayout(LAYOUT_IMG layout) {
		this.layout = layout;
	}

	public ProcDoAtd getProcDoAtd() {
		return procDoAtd;
	}

	public void setProcDoAtd(ProcDoAtd procDoAtd) {
		this.procDoAtd = procDoAtd;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PaginaDeImagens other = (PaginaDeImagens) obj;
		if (this.codigo != other.getCodigo()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + this.codigo;
		return hash;
	}

}
