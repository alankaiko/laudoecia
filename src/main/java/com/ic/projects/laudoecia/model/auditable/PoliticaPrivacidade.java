package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "politicaprivacidade")
public class PoliticaPrivacidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo")
	private int codigo;
	
	@Column(length = 100)
	private String titulo;

	@Column(length = 15000)
	private String termo;

	@Column(name = "versao", length = 10)
	private String versao;

	@Column(name = "ativo")
	private boolean ativo;

	@Column(name = "datacadastro", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date datacadastro;

	@Column(name = "datadesativacao", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date datadesativacao;

	public PoliticaPrivacidade(int codigo) {
		this.codigo = codigo;
	}

	public PoliticaPrivacidade() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Date getDatadesativacao() {
		return datadesativacao;
	}

	public void setDatadesativacao(Date datadesativacao) {
		this.datadesativacao = datadesativacao;
	}

	@Override
	public String toString() {
		return this.titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoliticaPrivacidade other = (PoliticaPrivacidade) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}	
	
}
