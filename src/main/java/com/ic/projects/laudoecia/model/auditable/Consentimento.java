package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "consentimento")
public class Consentimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo")
	private int codigo;	
	
	@Column(name = "descricao", length = 100)
	private String descricao;

	@Column(name = "aceito")
	private boolean aceito;
	
	@Column(name = "revogado")
	private boolean revogado;

	@Column(name = "dataaceitacao", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dataaceitacao;

	@Column(name = "datarevogacao", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date datarevogacao;

	@JoinColumn(name = "tbl_paciente_id", referencedColumnName = "codigo", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Paciente paciente;
	
	@JoinColumn(name = "tbl_politicaprivacidade_id", referencedColumnName = "codigo", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PoliticaPrivacidade politicaprivacidade;

	@Column(nullable = true)
	private byte[] scannerdocumento;
	
	public Consentimento(int codigo) {
		this.codigo = codigo;
	}
	
	public Consentimento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isAceito() {
		return aceito;
	}

	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	
	public boolean isRevogado() {
		return revogado;
	}
	
	public void setRevogado(boolean revogado) {
		this.revogado = revogado;
	}

	public Date getDataaceitacao() {
		return dataaceitacao;
	}

	public void setDataaceitacao(Date dataaceitacao) {
		this.dataaceitacao = dataaceitacao;
	}

	public Date getDatarevogacao() {
		return datarevogacao;
	}
	
	public void setDatarevogacao(Date datarevogacao) {
		this.datarevogacao = datarevogacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public PoliticaPrivacidade getPoliticaprivacidade() {
		return politicaprivacidade;
	}
	
	public void setPoliticaprivacidade(PoliticaPrivacidade politicaprivacidade) {
		this.politicaprivacidade = politicaprivacidade;
	}

	public byte[] getScannerdocumento() {
		return scannerdocumento;
	}

	public void setScannerdocumento(byte[] scannerdocumento) {
		this.scannerdocumento = scannerdocumento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Paciente:" + paciente.getNome() + " - Termo: " + politicaprivacidade.getTitulo() + "]";
	}

	
}
