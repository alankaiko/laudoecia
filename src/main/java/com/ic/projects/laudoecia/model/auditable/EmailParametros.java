package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ic.projects.laudoecia.model.enums.EnumEmail;

@Entity()
@Table(name = "emailparametros")
public class EmailParametros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo")
	private int codigo = 1;
	
	@Enumerated(EnumType.STRING)
	private EnumEmail tipo;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha = "";

	@Column(name = "smtp", nullable = false)
	private String smtp = "smtp.gmail.com";

	@Column(name = "portsocket", nullable = false)
	private String portsocket = "465";

	@Column(name = "socket", nullable = false)
	private String socket = "javax.net.ssl.SSLSocketFactory";
	
	private boolean ssl;

	@Column(name = "port", nullable = false)
	private String port = "465";

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public EnumEmail getTipo() {
		return tipo;
	}
	
	public void setTipo(EnumEmail tipo) {
		this.tipo = tipo;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getPortsocket() {
		return portsocket;
	}

	public void setPortsocket(String portsocket) {
		this.portsocket = portsocket;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public boolean isSsl() {
		return ssl;
	}
	
	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	

}
