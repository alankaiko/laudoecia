/*
 * Paciente.java
 *
 * Created on 05/11/2010, 09:30:40
 */
package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;

import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.java.utils.Comparador;
import com.lib.model.abstracao.SEXO;
import com.lib.model.cnv.ConversorDateIdadeOssea;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable, Comparable<Paciente> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nome", nullable = false)
	private String nome = "";

	@Column(name = "email", nullable = true)
	private String email = "";

	@Column(name = "telefone1", nullable = true)
	private String telefone1 = "";

	@Column(name = "telefone2", nullable = true)
	private String telefone2 = "";

	@Embedded
	private Endereco endereco = new Endereco();

	@Column(name = "datanascimento", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "datadecadastro", nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dataDeCadastro;

	@Column(name = "sexo", nullable = false)
	@Enumerated(EnumType.STRING)
	private SEXO sexo;

	@Column(name = "observacoes", nullable = true, length = 500)
	private String observacoes = "";

	@JoinTable(name = "paciente_imagem", joinColumns = @JoinColumn(name = "paciente_codigo"), inverseJoinColumns = @JoinColumn(name = "imagem_codigo"))
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Imagem> foto = new ArrayList<>();

	// <editor-fold defaultstate="collapsed" desc="Versioned">

	@Version
	private long version = 0;

	private boolean anonimo;

	@Column(name = "dataanonimo", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataanonimo;

	public long getVersion() {
		return version;
	}

	// </editor-fold>

	public Paciente(int codigo) {
		this.codigo = codigo;
	}

	public Paciente() {
	}

	public int getCodigo() {
		return codigo;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public String getEmail() {
		return email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public SEXO getSexo() {
		return sexo;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setSexo(SEXO sexo) {
		this.sexo = sexo;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Imagem getFoto() {
		return foto.isEmpty() ? null : foto.get(0);
	}

	public void setFoto(Imagem foto) {
		if (foto == null) {
			this.foto.clear();
		} else if (this.foto.isEmpty()) {
			this.foto.add(foto);
		} else {
			this.foto.set(0, foto);
		}
	}
	
	public boolean isAnonimo() {
		return anonimo;
	}
	
	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}
	
	public Date getDataanonimo() {
		return dataanonimo;
	}
	
	public void setDataanonimo(Date dataanonimo) {
		this.dataanonimo = dataanonimo;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int compareTo(Paciente other) {
		if (other == null) {
			return +1;
		} else if (this.nome == null) {
			return other.getNome() == null ? 0 : -1;
		} else {
			return Comparador.compararRemovendoAcentos(this.nome, other.getNome());
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Paciente other = (Paciente) obj;
		if (this.codigo != other.getCodigo()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + this.codigo;
		return hash;
	}

	public String getIdadeOssea() {
		return new ConversorDateIdadeOssea().convertForward(dataNascimento);
	}

}
