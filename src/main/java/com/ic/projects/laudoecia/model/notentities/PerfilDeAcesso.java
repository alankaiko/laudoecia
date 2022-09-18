/**
 * PerfilDeAcesso.java
 *
 * Created on 12/12/2011, 11:09:38
 */
package com.ic.projects.laudoecia.model.notentities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
@Embeddable
public class PerfilDeAcesso implements Serializable {

	// <editor-fold defaultstate="collapsed" desc="Menu Cadastros">
	// Convenio
	@Column(name = "acessaconvenio", nullable = false)
	private boolean acessaConvenio = false;

	@Column(name = "adicionaconvenio", nullable = false)
	private boolean adicionaConvenio = false;

	@Column(name = "alteraconvenio", nullable = false)
	private boolean alteraConvenio = false;

	@Column(name = "apagaconvenio", nullable = false)
	private boolean apagaConvenio = false;

	// ProcMedico
	@Column(name = "acessaprocmedico", nullable = false)
	private boolean acessaProcMedico = false;

	@Column(name = "adicionaprocmedico", nullable = false)
	private boolean adicionaProcMedico = false;

	@Column(name = "alteraprocmedico", nullable = false)
	private boolean alteraProcMedico = false;

	@Column(name = "apagaprocmedico", nullable = false)
	private boolean apagaProcMedico = false;

	// GrupoProcedimento
	@Column(name = "acessagrupoprocedimento", nullable = false)
	private boolean acessaGrupoProcedimento = false;

	@Column(name = "adicionagrupoprocedimento", nullable = false)
	private boolean adicionaGrupoProcedimento = false;

	@Column(name = "alteragrupoprocedimento", nullable = false)
	private boolean alteraGrupoProcedimento = false;

	@Column(name = "apagagrupoprocedimento", nullable = false)
	private boolean apagaGrupoProcedimento = false;

	// Paciente
	@Column(name = "acessapaciente", nullable = false)
	private boolean acessaPaciente = false;

	@Column(name = "adicionapaciente", nullable = false)
	private boolean adicionaPaciente = false;

	@Column(name = "alterapaciente", nullable = false)
	private boolean alteraPaciente = false;

	@Column(name = "apagapaciente", nullable = false)
	private boolean apagaPaciente = false;

	// ProfExecutante
	@Column(name = "acessaprofexecutante", nullable = false)
	private boolean acessaProfExecutante = false;

	@Column(name = "adicionaprofexecutante", nullable = false)
	private boolean adicionaProfExecutante = false;

	@Column(name = "alteraprofexecutante", nullable = false)
	private boolean alteraProfExecutante = false;

	@Column(name = "apagaprofexecutante", nullable = false)
	private boolean apagaProfExecutante = false;

	// ProfSolicitante
	@Column(name = "acessaprofsolicitante", nullable = false)
	private boolean acessaProfSolicitante = false;

	@Column(name = "adicionaprofsolicitante", nullable = false)
	private boolean adicionaProfSolicitante = false;

	@Column(name = "alteraprofsolicitante", nullable = false)
	private boolean alteraProfSolicitante = false;

	@Column(name = "apagaprofsolicitante", nullable = false)
	private boolean apagaProfSolicitante = false;

	// TextoPadrao
	@Column(name = "acessatextopadrao", nullable = false)
	private boolean acessaTextoPadrao = false;

	@Column(name = "adicionatextopadrao", nullable = false)
	private boolean adicionaTextoPadrao = false;

	@Column(name = "alteratextopadrao", nullable = false)
	private boolean alteraTextoPadrao = false;

	@Column(name = "apagatextopadrao", nullable = false)
	private boolean apagaTextoPadrao = false;

	// GrupoDeUsuarios
	@Column(name = "acessagrupodeusuarios", nullable = false)
	private boolean acessaGrupoDeUsuarios = false;

	@Column(name = "adicionagrupodeusuarios", nullable = false)
	private boolean adicionaGrupoDeUsuarios = false;

	@Column(name = "alteragrupodeusuarios", nullable = false)
	private boolean alteraGrupoDeUsuarios = false;

	@Column(name = "apagagrupodeusuarios", nullable = false)
	private boolean apagaGrupoDeUsuarios = false;

	// Usuario
	@Column(name = "acessausuario", nullable = false)
	private boolean acessaUsuario = false;

	@Column(name = "adicionausuario", nullable = false)
	private boolean adicionaUsuario = false;

	@Column(name = "alterausuario", nullable = false)
	private boolean alteraUsuario = false;

	@Column(name = "apagausuario", nullable = false)
	private boolean apagaUsuario = false;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Menu Operações">
	// Atendimento
	@Column(name = "acessaatendimento", nullable = false)
	private boolean acessaAtendimento = false;

	@Column(name = "adicionaatendimento", nullable = false)
	private boolean adicionaAtendimento = false;

	@Column(name = "alteraatendimento", nullable = false)
	private boolean alteraAtendimento = false;

	@Column(name = "apagaatendimento", nullable = false)
	private boolean apagaAtendimento = false;

	// Captura
	@Column(name = "acessacaptura", nullable = false)
	private boolean acessaCaptura = false;

	// Laudo
	@Column(name = "acessalaudo", nullable = false)
	private boolean acessaLaudo = false;

	@Column(name = "alteralaudo", nullable = false)
	private boolean alteraLaudo = false;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Menu Relatórios">
	@Column(name = "acessarelatendcompleto", nullable = false)
	private boolean acessaRelAtendCompleto = false;

	@Column(name = "acessarelatendporconvenio", nullable = false)
	private boolean acessaRelAtendPorConvenio = false;

	@Column(name = "acessarelatendporprocmedico", nullable = false)
	private boolean acessaRelAtendPorProcMedico = false;

	@Column(name = "acessarelatendporprofexe", nullable = false)
	private boolean acessaRelAtendPorProfExe = false;

	@Column(name = "acessarelatendporprofsol", nullable = false)
	private boolean acessaRelAtendPorProfSol = false;

	@Column(name = "acessarelatendresumos", nullable = false)
	private boolean acessaRelAtendResumos = false;

	@Column(name = "acessagrafatendimentos", nullable = false)
	private boolean acessaGrafAtendimentos = false;

	@Column(name = "acessaauditoria", nullable = false)
	private boolean acessaAuditoria = false;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Menu Ferramentas">

	// Backup
	@Column(name = "acessabackup", nullable = false)
	private boolean acessaBackup = false;

	@Column(name = "adicionabackup", nullable = false)
	private boolean adicionaBackup = false;

	@Column(name = "alterabackup", nullable = false)
	private boolean alteraBackup = false;

	@Column(name = "apagabackup", nullable = false)
	private boolean apagaBackup = false;

	// EstacaoDeTrabalho
	@Column(name = "acessaestacaodetrabalho", nullable = false)
	private boolean acessaEstacaoDeTrabalho = false;

	@Column(name = "alteraestacaodetrabalho", nullable = false)
	private boolean alteraEstacaoDeTrabalho = false;

	@Column(name = "apagaestacaodetrabalho", nullable = false)
	private boolean apagaEstacaoDeTrabalho = false;

	// ParametrosDaCaptura
	@Column(name = "acessaparametrosdacaptura", nullable = false)
	private boolean acessaParametrosDaCaptura = false;

	@Column(name = "alteraparametrosdacaptura", nullable = false)
	private boolean alteraParametrosDaCaptura = false;

	// ParametrosDoSistema
	@Column(name = "acessaparametrosdosistema", nullable = false)
	private boolean acessaParametrosDoSistema = false;

	@Column(name = "alteraparametrosdosistema", nullable = false)
	private boolean alteraParametrosDoSistema = false;

	// Licenciado
	@Column(name = "acessalicenciado", nullable = false)
	private boolean acessaLicenciado = false;

	@Column(name = "alteralicenciado", nullable = false)
	private boolean alteraLicenciado = false;

	// Altera Email
	@Column(name = "acessaparametrosemail", nullable = false)
	private boolean acessaParametrosEmail = false;

	@Column(name = "adicionaparametrosemail", nullable = false)
	private boolean adicionaParametrosEmail = false;

	@Column(name = "alteraparametrosemail", nullable = false)
	private boolean alteraParametrosEmail = false;

	@Column(name = "apagaparametrosemail", nullable = false)
	private boolean apagaParametrosEmail = false;
	
	// Altera Termo Consentimento
	@Column(name = "acessaconsentimento", nullable = false)
	private boolean acessaConsentimento = false;

	@Column(name = "adicionaconsentimento", nullable = false)
	private boolean adicionaConsentimento = false;

	@Column(name = "alteraconsentimento", nullable = false)
	private boolean alteraConsentimento = false;

	@Column(name = "apagaconsentimento", nullable = false)
	private boolean apagaConsentimento = false;
	
	// Altera Politica de Privacidade
	@Column(name = "acessapoliticaprivacidade", nullable = false)
	private boolean acessaPoliticaPrivacidade = false;

	@Column(name = "adicionapoliticaprivacidade", nullable = false)
	private boolean adicionaPoliticaPrivacidade = false;
	
	@Column(name = "alterapoliticaprivacidade", nullable = false)
	private boolean alteraPoliticaPrivacidade = false;

	@Column(name = "apagapoliticaprivacidade", nullable = false)
	private boolean apagaPoliticaPrivacidade = false;

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Getters and Setters">

	public boolean isAcessaAtendimento() {
		return acessaAtendimento;
	}

	public void setAcessaAtendimento(boolean acessaAtendimento) {
		this.acessaAtendimento = acessaAtendimento;
	}

	public boolean isAcessaAuditoria() {
		return acessaAuditoria;
	}

	public void setAcessaAuditoria(boolean acessaAuditoria) {
		this.acessaAuditoria = acessaAuditoria;
	}

	public boolean isAcessaBackup() {
		return acessaBackup;
	}

	public void setAcessaBackup(boolean acessaBackup) {
		this.acessaBackup = acessaBackup;
	}

	public boolean isAcessaCaptura() {
		return acessaCaptura;
	}

	public void setAcessaCaptura(boolean acessaCaptura) {
		this.acessaCaptura = acessaCaptura;
	}

	public boolean isAcessaConvenio() {
		return acessaConvenio;
	}

	public void setAcessaConvenio(boolean acessaConvenio) {
		this.acessaConvenio = acessaConvenio;
	}

	public boolean isAcessaEstacaoDeTrabalho() {
		return acessaEstacaoDeTrabalho;
	}

	public void setAcessaEstacaoDeTrabalho(boolean acessaEstacaoDeTrabalho) {
		this.acessaEstacaoDeTrabalho = acessaEstacaoDeTrabalho;
	}

	public boolean isAcessaGrafAtendimentos() {
		return acessaGrafAtendimentos;
	}

	public void setAcessaGrafAtendimentos(boolean acessaGrafAtendimentos) {
		this.acessaGrafAtendimentos = acessaGrafAtendimentos;
	}

	public boolean isAcessaGrupoDeUsuarios() {
		return acessaGrupoDeUsuarios;
	}

	public void setAcessaGrupoDeUsuarios(boolean acessaGrupoDeUsuarios) {
		this.acessaGrupoDeUsuarios = acessaGrupoDeUsuarios;
	}

	public boolean isAcessaGrupoProcedimento() {
		return acessaGrupoProcedimento;
	}

	public void setAcessaGrupoProcedimento(boolean acessaGrupoProcedimento) {
		this.acessaGrupoProcedimento = acessaGrupoProcedimento;
	}

	public boolean isAcessaLaudo() {
		return acessaLaudo;
	}

	public void setAcessaLaudo(boolean acessaLaudo) {
		this.acessaLaudo = acessaLaudo;
	}

	public boolean isAcessaLicenciado() {
		return acessaLicenciado;
	}

	public void setAcessaLicenciado(boolean acessaLicenciado) {
		this.acessaLicenciado = acessaLicenciado;
	}

	public boolean isAcessaPaciente() {
		return acessaPaciente;
	}

	public void setAcessaPaciente(boolean acessaPaciente) {
		this.acessaPaciente = acessaPaciente;
	}

	public boolean isAcessaParametrosDaCaptura() {
		return acessaParametrosDaCaptura;
	}

	public void setAcessaParametrosDaCaptura(boolean acessaParametrosDaCaptura) {
		this.acessaParametrosDaCaptura = acessaParametrosDaCaptura;
	}

	public boolean isAcessaParametrosDoSistema() {
		return acessaParametrosDoSistema;
	}

	public void setAcessaParametrosDoSistema(boolean acessaParametrosDoSistema) {
		this.acessaParametrosDoSistema = acessaParametrosDoSistema;
	}

	public boolean isAcessaProcMedico() {
		return acessaProcMedico;
	}

	public void setAcessaProcMedico(boolean acessaProcMedico) {
		this.acessaProcMedico = acessaProcMedico;
	}

	public boolean isAcessaProfExecutante() {
		return acessaProfExecutante;
	}

	public void setAcessaProfExecutante(boolean acessaProfExecutante) {
		this.acessaProfExecutante = acessaProfExecutante;
	}

	public boolean isAcessaProfSolicitante() {
		return acessaProfSolicitante;
	}

	public void setAcessaProfSolicitante(boolean acessaProfSolicitante) {
		this.acessaProfSolicitante = acessaProfSolicitante;
	}

	public boolean isAcessaTextoPadrao() {
		return acessaTextoPadrao;
	}

	public void setAcessaTextoPadrao(boolean acessaTextoPadrao) {
		this.acessaTextoPadrao = acessaTextoPadrao;
	}

	public boolean isAdicionaTextoPadrao() {
		return adicionaTextoPadrao;
	}

	public void setAdicionaTextoPadrao(boolean adicionaTextoPadrao) {
		this.adicionaTextoPadrao = adicionaTextoPadrao;
	}

	public boolean isAlteraTextoPadrao() {
		return alteraTextoPadrao;
	}

	public void setAlteraTextoPadrao(boolean alteraTextoPadrao) {
		this.alteraTextoPadrao = alteraTextoPadrao;
	}

	public boolean isApagaTextoPadrao() {
		return apagaTextoPadrao;
	}

	public void setApagaTextoPadrao(boolean apagaTextoPadrao) {
		this.apagaTextoPadrao = apagaTextoPadrao;
	}

	public boolean isAcessaRelAtendCompleto() {
		return acessaRelAtendCompleto;
	}

	public void setAcessaRelAtendCompleto(boolean acessaRelAtendCompleto) {
		this.acessaRelAtendCompleto = acessaRelAtendCompleto;
	}

	public boolean isAcessaRelAtendPorConvenio() {
		return acessaRelAtendPorConvenio;
	}

	public void setAcessaRelAtendPorConvenio(boolean acessaRelAtendPorConvenio) {
		this.acessaRelAtendPorConvenio = acessaRelAtendPorConvenio;
	}

	public boolean isAcessaRelAtendPorProcMedico() {
		return acessaRelAtendPorProcMedico;
	}

	public void setAcessaRelAtendPorProcMedico(boolean acessaRelAtendPorProcMedico) {
		this.acessaRelAtendPorProcMedico = acessaRelAtendPorProcMedico;
	}

	public boolean isAcessaRelAtendPorProfExe() {
		return acessaRelAtendPorProfExe;
	}

	public void setAcessaRelAtendPorProfExe(boolean acessaRelAtendPorProfExe) {
		this.acessaRelAtendPorProfExe = acessaRelAtendPorProfExe;
	}

	public boolean isAcessaRelAtendPorProfSol() {
		return acessaRelAtendPorProfSol;
	}

	public void setAcessaRelAtendPorProfSol(boolean acessaRelAtendPorProfSol) {
		this.acessaRelAtendPorProfSol = acessaRelAtendPorProfSol;
	}

	public boolean isAcessaRelAtendResumos() {
		return acessaRelAtendResumos;
	}

	public void setAcessaRelAtendResumos(boolean acessaRelAtendResumos) {
		this.acessaRelAtendResumos = acessaRelAtendResumos;
	}

	public boolean isAcessaUsuario() {
		return acessaUsuario;
	}

	public void setAcessaUsuario(boolean acessaUsuario) {
		this.acessaUsuario = acessaUsuario;
	}

	public boolean isAdicionaAtendimento() {
		return adicionaAtendimento;
	}

	public void setAdicionaAtendimento(boolean adicionaAtendimento) {
		this.adicionaAtendimento = adicionaAtendimento;
	}

	public boolean isAdicionaBackup() {
		return adicionaBackup;
	}

	public void setAdicionaBackup(boolean adicionaBackup) {
		this.adicionaBackup = adicionaBackup;
	}

	public boolean isAdicionaConvenio() {
		return adicionaConvenio;
	}

	public void setAdicionaConvenio(boolean adicionaConvenio) {
		this.adicionaConvenio = adicionaConvenio;
	}

	public boolean isAdicionaGrupoDeUsuarios() {
		return adicionaGrupoDeUsuarios;
	}

	public void setAdicionaGrupoDeUsuarios(boolean adicionaGrupoDeUsuarios) {
		this.adicionaGrupoDeUsuarios = adicionaGrupoDeUsuarios;
	}

	public boolean isAdicionaGrupoProcedimento() {
		return adicionaGrupoProcedimento;
	}

	public void setAdicionaGrupoProcedimento(boolean adicionaGrupoProcedimento) {
		this.adicionaGrupoProcedimento = adicionaGrupoProcedimento;
	}

	public boolean isAlteraLaudo() {
		return alteraLaudo;
	}

	public void setAlteraLaudo(boolean alteraLaudo) {
		this.alteraLaudo = alteraLaudo;
	}

	public boolean isAdicionaPaciente() {
		return adicionaPaciente;
	}

	public void setAdicionaPaciente(boolean adicionaPaciente) {
		this.adicionaPaciente = adicionaPaciente;
	}

	public boolean isAdicionaProcMedico() {
		return adicionaProcMedico;
	}

	public void setAdicionaProcMedico(boolean adicionaProcMedico) {
		this.adicionaProcMedico = adicionaProcMedico;
	}

	public boolean isAdicionaProfExecutante() {
		return adicionaProfExecutante;
	}

	public void setAdicionaProfExecutante(boolean adicionaProfExecutante) {
		this.adicionaProfExecutante = adicionaProfExecutante;
	}

	public boolean isAdicionaProfSolicitante() {
		return adicionaProfSolicitante;
	}

	public void setAdicionaProfSolicitante(boolean adicionaProfSolicitante) {
		this.adicionaProfSolicitante = adicionaProfSolicitante;
	}

	public boolean isAdicionaUsuario() {
		return adicionaUsuario;
	}

	public void setAdicionaUsuario(boolean adicionaUsuario) {
		this.adicionaUsuario = adicionaUsuario;
	}

	public boolean isAlteraAtendimento() {
		return alteraAtendimento;
	}

	public void setAlteraAtendimento(boolean alteraAtendimento) {
		this.alteraAtendimento = alteraAtendimento;
	}

	public boolean isAlteraBackup() {
		return alteraBackup;
	}

	public void setAlteraBackup(boolean alteraBackup) {
		this.alteraBackup = alteraBackup;
	}

	public boolean isAlteraConvenio() {
		return alteraConvenio;
	}

	public void setAlteraConvenio(boolean alteraConvenio) {
		this.alteraConvenio = alteraConvenio;
	}

	public boolean isAlteraEstacaoDeTrabalho() {
		return alteraEstacaoDeTrabalho;
	}

	public void setAlteraEstacaoDeTrabalho(boolean alteraEstacaoDeTrabalho) {
		this.alteraEstacaoDeTrabalho = alteraEstacaoDeTrabalho;
	}

	public boolean isAlteraGrupoDeUsuarios() {
		return alteraGrupoDeUsuarios;
	}

	public void setAlteraGrupoDeUsuarios(boolean alteraGrupoDeUsuarios) {
		this.alteraGrupoDeUsuarios = alteraGrupoDeUsuarios;
	}

	public boolean isAlteraGrupoProcedimento() {
		return alteraGrupoProcedimento;
	}

	public void setAlteraGrupoProcedimento(boolean alteraGrupoProcedimento) {
		this.alteraGrupoProcedimento = alteraGrupoProcedimento;
	}

	public boolean isAlteraLicenciado() {
		return alteraLicenciado;
	}

	public void setAlteraLicenciado(boolean alteraLicenciado) {
		this.alteraLicenciado = alteraLicenciado;
	}

	public boolean isAlteraPaciente() {
		return alteraPaciente;
	}

	public void setAlteraPaciente(boolean alteraPaciente) {
		this.alteraPaciente = alteraPaciente;
	}

	public boolean isAlteraParametrosDaCaptura() {
		return alteraParametrosDaCaptura;
	}

	public void setAlteraParametrosDaCaptura(boolean alteraParametrosDaCaptura) {
		this.alteraParametrosDaCaptura = alteraParametrosDaCaptura;
	}

	public boolean isAlteraParametrosDoSistema() {
		return alteraParametrosDoSistema;
	}

	public void setAlteraParametrosDoSistema(boolean alteraParametrosDoSistema) {
		this.alteraParametrosDoSistema = alteraParametrosDoSistema;
	}

	public boolean isAlteraProcMedico() {
		return alteraProcMedico;
	}

	public void setAlteraProcMedico(boolean alteraProcMedico) {
		this.alteraProcMedico = alteraProcMedico;
	}

	public boolean isAlteraProfExecutante() {
		return alteraProfExecutante;
	}

	public void setAlteraProfExecutante(boolean alteraProfExecutante) {
		this.alteraProfExecutante = alteraProfExecutante;
	}

	public boolean isAlteraProfSolicitante() {
		return alteraProfSolicitante;
	}

	public void setAlteraProfSolicitante(boolean alteraProfSolicitante) {
		this.alteraProfSolicitante = alteraProfSolicitante;
	}

	public boolean isAlteraUsuario() {
		return alteraUsuario;
	}

	public void setAlteraUsuario(boolean alteraUsuario) {
		this.alteraUsuario = alteraUsuario;
	}

	public boolean isApagaAtendimento() {
		return apagaAtendimento;
	}

	public void setApagaAtendimento(boolean apagaAtendimento) {
		this.apagaAtendimento = apagaAtendimento;
	}

	public boolean isApagaBackup() {
		return apagaBackup;
	}

	public void setApagaBackup(boolean apagaBackup) {
		this.apagaBackup = apagaBackup;
	}

	public boolean isApagaConvenio() {
		return apagaConvenio;
	}

	public void setApagaConvenio(boolean apagaConvenio) {
		this.apagaConvenio = apagaConvenio;
	}

	public boolean isApagaEstacaoDeTrabalho() {
		return apagaEstacaoDeTrabalho;
	}

	public void setApagaEstacaoDeTrabalho(boolean apagaEstacaoDeTrabalho) {
		this.apagaEstacaoDeTrabalho = apagaEstacaoDeTrabalho;
	}

	public boolean isApagaGrupoDeUsuarios() {
		return apagaGrupoDeUsuarios;
	}

	public void setApagaGrupoDeUsuarios(boolean apagaGrupoDeUsuarios) {
		this.apagaGrupoDeUsuarios = apagaGrupoDeUsuarios;
	}

	public boolean isApagaGrupoProcedimento() {
		return apagaGrupoProcedimento;
	}

	public void setApagaGrupoProcedimento(boolean apagaGrupoProcedimento) {
		this.apagaGrupoProcedimento = apagaGrupoProcedimento;
	}

	public boolean isApagaPaciente() {
		return apagaPaciente;
	}

	public void setApagaPaciente(boolean apagaPaciente) {
		this.apagaPaciente = apagaPaciente;
	}

	public boolean isApagaProcMedico() {
		return apagaProcMedico;
	}

	public void setApagaProcMedico(boolean apagaProcMedico) {
		this.apagaProcMedico = apagaProcMedico;
	}

	public boolean isApagaProfExecutante() {
		return apagaProfExecutante;
	}

	public void setApagaProfExecutante(boolean apagaProfExecutante) {
		this.apagaProfExecutante = apagaProfExecutante;
	}

	public boolean isApagaProfSolicitante() {
		return apagaProfSolicitante;
	}

	public void setApagaProfSolicitante(boolean apagaProfSolicitante) {
		this.apagaProfSolicitante = apagaProfSolicitante;
	}

	public boolean isApagaUsuario() {
		return apagaUsuario;
	}

	public void setApagaUsuario(boolean apagaUsuario) {
		this.apagaUsuario = apagaUsuario;
	}

	public boolean isAcessaParametrosEmail() {
		return acessaParametrosEmail;
	}

	public void setAcessaParametrosEmail(boolean acessaParametrosEmail) {
		this.acessaParametrosEmail = acessaParametrosEmail;
	}

	public boolean isAdicionaParametrosEmail() {
		return adicionaParametrosEmail;
	}

	public void setAdicionaParametrosEmail(boolean adicionaParametrosEmail) {
		this.adicionaParametrosEmail = adicionaParametrosEmail;
	}

	public boolean isAlteraParametrosEmail() {
		return alteraParametrosEmail;
	}

	public void setAlteraParametrosEmail(boolean alteraParametrosEmail) {
		this.alteraParametrosEmail = alteraParametrosEmail;
	}

	public boolean isApagaParametrosEmail() {
		return apagaParametrosEmail;
	}

	public void setApagaParametrosEmail(boolean apagaParametrosEmail) {
		this.apagaParametrosEmail = apagaParametrosEmail;
	}

	public boolean isAcessaConsentimento() {
		return acessaConsentimento;
	}

	public void setAcessaConsentimento(boolean acessaConsentimento) {
		this.acessaConsentimento = acessaConsentimento;
	}

	public boolean isAdicionaConsentimento() {
		return adicionaConsentimento;
	}

	public void setAdicionaConsentimento(boolean adicionaConsentimento) {
		this.adicionaConsentimento = adicionaConsentimento;
	}

	public boolean isAlteraConsentimento() {
		return alteraConsentimento;
	}

	public void setAlteraConsentimento(boolean alteraConsentimento) {
		this.alteraConsentimento = alteraConsentimento;
	}

	public boolean isApagaConsentimento() {
		return apagaConsentimento;
	}

	public void setApagaConsentimento(boolean apagaConsentimento) {
		this.apagaConsentimento = apagaConsentimento;
	}

	public boolean isAcessaPoliticaPrivacidade() {
		return acessaPoliticaPrivacidade;
	}

	public void setAcessaPoliticaPrivacidade(boolean acessaPoliticaPrivacidade) {
		this.acessaPoliticaPrivacidade = acessaPoliticaPrivacidade;
	}

	public boolean isAdicionaPoliticaPrivacidade() {
		return adicionaPoliticaPrivacidade;
	}

	public void setAdicionaPoliticaPrivacidade(boolean adicionaPoliticaPrivacidade) {
		this.adicionaPoliticaPrivacidade = adicionaPoliticaPrivacidade;
	}

	public boolean isAlteraPoliticaPrivacidade() {
		return alteraPoliticaPrivacidade;
	}

	public void setAlteraPoliticaPrivacidade(boolean alteraPoliticaPrivacidade) {
		this.alteraPoliticaPrivacidade = alteraPoliticaPrivacidade;
	}

	public boolean isApagaPoliticaPrivacidade() {
		return apagaPoliticaPrivacidade;
	}

	public void setApagaPoliticaPrivacidade(boolean apagaPoliticaPrivacidade) {
		this.apagaPoliticaPrivacidade = apagaPoliticaPrivacidade;
	}	

	// </editor-fold>

}
