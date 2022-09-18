/*
 * ViewFactory.java
 *
 * Created on 02/03/2012, 08:23:56
 */
package com.ic.projects.laudoecia.view.build;

import java.awt.Component;

import javax.swing.JInternalFrame;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.captura.C_Captura;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.basededados.IFrameCBHPM;
import com.ic.projects.laudoecia.view.basededados.IFrameCEP;
import com.ic.projects.laudoecia.view.basededados.IFrameCID10;
import com.ic.projects.laudoecia.view.basededados.IFrameCNES;
import com.ic.projects.laudoecia.view.basededados.IFrameCRM;
import com.ic.projects.laudoecia.view.basededados.IFrameEspecialidadeMedica;
import com.ic.projects.laudoecia.view.cadastro.IFrameAbreviaturas;
import com.ic.projects.laudoecia.view.cadastro.IFrameAtendimentos;
import com.ic.projects.laudoecia.view.cadastro.IFrameAuditoria;
import com.ic.projects.laudoecia.view.cadastro.IFrameBackup;
import com.ic.projects.laudoecia.view.cadastro.IFrameConsentimento;
import com.ic.projects.laudoecia.view.cadastro.IFrameConvenios;
import com.ic.projects.laudoecia.view.cadastro.IFrameEmailParametros;
import com.ic.projects.laudoecia.view.cadastro.IFrameEstacoesDeTrabalho;
import com.ic.projects.laudoecia.view.cadastro.IFrameGrupoDeProcedimentos;
import com.ic.projects.laudoecia.view.cadastro.IFrameGrupoDeUsuarios;
import com.ic.projects.laudoecia.view.cadastro.IFrameLicenciado;
import com.ic.projects.laudoecia.view.cadastro.IFramePacientes;
import com.ic.projects.laudoecia.view.cadastro.IFrameParametrosDaCaptura;
import com.ic.projects.laudoecia.view.cadastro.IFrameParametrosDoSistema;
import com.ic.projects.laudoecia.view.cadastro.IFramePoliticaPrivacidade;
import com.ic.projects.laudoecia.view.cadastro.IFrameProcMedico;
import com.ic.projects.laudoecia.view.cadastro.IFrameProfExecutante;
import com.ic.projects.laudoecia.view.cadastro.IFrameProfSolicitante;
import com.ic.projects.laudoecia.view.cadastro.IFrameRecortes;
import com.ic.projects.laudoecia.view.cadastro.IFrameTextosPadroes;
import com.ic.projects.laudoecia.view.cadastro.IFrameUsuarios;
import com.ic.projects.laudoecia.view.captura.C_CapturaJMF;
import com.ic.projects.laudoecia.view.dialogs.DlgAbreviaturas;
import com.ic.projects.laudoecia.view.dialogs.DlgCep;
import com.ic.projects.laudoecia.view.dialogs.DlgCid10;
import com.ic.projects.laudoecia.view.dialogs.DlgExecutantes;
import com.ic.projects.laudoecia.view.dialogs.DlgGrupoProc;
import com.ic.projects.laudoecia.view.dialogs.DlgProcMedico;
import com.ic.projects.laudoecia.view.dialogs.DlgRecorte;
import com.ic.projects.laudoecia.view.dialogs.DlgTextoPessoal;
import com.ic.projects.laudoecia.view.dialogs.DlgVersao;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.reports.DlgFiltroGrafDeAtendimentos;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelAtendCompleto;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelAtendPorConvenio;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelAtendPorProcMedico;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelAtendPorProfExecutante;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelAtendPorProfSolicitante;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelAtendResumos;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelConvenios;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelPacienteUnico;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelPacientes;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelProcMedico;
import com.ic.projects.laudoecia.view.reports.DlgFiltroRelProfExecutante;
import com.ic.projects.laudoecia.view.reports.IFrameTodosRelatorios;
import com.lib.swing.perfildeacesso.TabbedPanePerfilDeAcesso;
import com.lib.swing.plus.cps.MyJDialog;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class ViewFactory {

	private static ViewFactory singleton;
	private static C_Captura c_Captura;

	protected ViewFactory() {
	}

	public static ViewFactory getInstance() {
		if (singleton == null) {
			switch (StaticInfo.getParametrosDoSistema().getVersaoDoSw()) {
			case V1:
				singleton = new ViewFactoryV1();
				break;
			default:
				singleton = new ViewFactoryV1();
			}

		}
		return singleton;
	}

	Class<? extends JInternalFrame> getIFrameClass(int iframeId) {
		switch (iframeId) {
		case TelaPrincipal.CADASTRO_USUARIOS:
			return IFrameUsuarios.class;
		case TelaPrincipal.CADASTRO_GRUPOS_DE_USUARIOS:
			return IFrameGrupoDeUsuarios.class;
		case TelaPrincipal.CADASTRO_CONVENIOS:
			return IFrameConvenios.class;
		case TelaPrincipal.CADASTRO_PACIENTES:
			return IFramePacientes.class;
		case TelaPrincipal.CADASTRO_PROF_SOLICITANTE:
			return IFrameProfSolicitante.class;
		case TelaPrincipal.CADASTRO_PROF_EXECUTANTE:
			return IFrameProfExecutante.class;
		case TelaPrincipal.CONSENTIMENTO:
            return IFrameConsentimento.class;
		case TelaPrincipal.POLITICAS_PRIVACIDADE:
            return IFramePoliticaPrivacidade.class;
		case TelaPrincipal.CADASTRO_PROC_MEDICO:
			return IFrameProcMedico.class;
		case TelaPrincipal.CADASTRO_GRUPOS_PROCEDIMENTOS:
			return IFrameGrupoDeProcedimentos.class;
		case TelaPrincipal.CADASTRO_TEXTOS_PADROES:
			return IFrameTextosPadroes.class;
		case TelaPrincipal.CADASTRO_AUDITORIA_BD:
			return IFrameAuditoria.class;
		case TelaPrincipal.ATENDIMENTO:
			return IFrameAtendimentos.class;
		case TelaPrincipal.BASE_DE_DADOS_CBHPM:
			return IFrameCBHPM.class;
		case TelaPrincipal.BASE_DE_DADOS_CEP:
			return IFrameCEP.class;
		case TelaPrincipal.BASE_DE_DADOS_CID10:
			return IFrameCID10.class;
		case TelaPrincipal.BASE_DE_DADOS_CNES:
			return IFrameCNES.class;
		case TelaPrincipal.BASE_DE_DADOS_CRM:
			return IFrameCRM.class;
		case TelaPrincipal.BASE_DE_DADOS_ESPECIALIDADE_MEDICA:
			return IFrameEspecialidadeMedica.class;
		case TelaPrincipal.ESTACOES_DE_TRABALHO:
			return IFrameEstacoesDeTrabalho.class;
		case TelaPrincipal.PARAMETROS_DA_CAPTURA:
			return IFrameParametrosDaCaptura.class;
		case TelaPrincipal.PARAMETROS_DO_SISTEMA:
			return IFrameParametrosDoSistema.class;
		case TelaPrincipal.DADOS_DO_LICENCIADO:
			return IFrameLicenciado.class;
		case TelaPrincipal.PARAMETROS_EMAIL:
			return IFrameEmailParametros.class;
		case TelaPrincipal.RELATORIOS_TODOS:
			return IFrameTodosRelatorios.class;
		case TelaPrincipal.BACKUP_INSTANTANEO:
			return IFrameBackup.class;
		case TelaPrincipal.CADASTRO_ABREVIATURAS:
			return IFrameAbreviaturas.class;
		case TelaPrincipal.CADASTRO_RECORTES:
			return IFrameRecortes.class;
		default:
			return null;
		}
	}

	PnlFormPrincipal getJPanel(int tela) {
		switch (tela) {
		case TelaPrincipal.LAUDO_E_CAPTURA:
			return PnlLaudoeCia.getInstance();
		default:
			return null;
		}
	}

	MyJDialog getMyJDialog(int jDialogId, Component cp) {
		switch (jDialogId) {
		case TelaPrincipal.DLG_CID10:
			return new DlgCid10(cp);
		case TelaPrincipal.DLG_CEP:
			return new DlgCep(cp);
		case TelaPrincipal.DLG_GRUPO_PROC:
			return new DlgGrupoProc(cp);
		case TelaPrincipal.DLG_EXECUTANTES:
			return new DlgExecutantes(cp);
		case TelaPrincipal.DLG_PROC_MEDICO:
			return new DlgProcMedico(cp);
		case TelaPrincipal.REL_ATD_COMPLETO:
			return new DlgFiltroRelAtendCompleto(cp);
		case TelaPrincipal.REL_ATD_POR_CONVENIO:
			return new DlgFiltroRelAtendPorConvenio(cp);
		case TelaPrincipal.REL_ATD_POR_PROC_MED:
			return new DlgFiltroRelAtendPorProcMedico(cp);
		case TelaPrincipal.REL_ATD_POR_PROF_EXE:
			return new DlgFiltroRelAtendPorProfExecutante(cp);
		case TelaPrincipal.REL_ATD_POR_PROF_SOL:
			return new DlgFiltroRelAtendPorProfSolicitante(cp);
		case TelaPrincipal.REL_ATD_RESUMOS:
			return new DlgFiltroRelAtendResumos(cp);
		case TelaPrincipal.GRAF_ATDENDIMENTOS:
			return new DlgFiltroGrafDeAtendimentos(cp);
		case TelaPrincipal.REL_PROC_MEDICO:
			return new DlgFiltroRelProcMedico(cp);
		case TelaPrincipal.REL_PROF_EXEC:
			return new DlgFiltroRelProfExecutante(cp);
		case TelaPrincipal.REL_CONVENIOS:
			return new DlgFiltroRelConvenios(cp);
		case TelaPrincipal.REL_PACIENTES:
			return new DlgFiltroRelPacientes(cp);
		case TelaPrincipal.AJUDA_SOBRE:
			return new DlgVersao(cp);
		case TelaPrincipal.DLG_ABREVIATURAS:
			return new DlgAbreviaturas(cp);
		case TelaPrincipal.DLG_TEXTO_PESSOAL:
			return new DlgTextoPessoal(cp);
		case TelaPrincipal.DLG_RECORTES:
			return new DlgRecorte(cp);
		case TelaPrincipal.REL_PACIENTE_ANALITICO:
            return new DlgFiltroRelPacienteUnico(cp);
		default:
			return null;
		}
	}

	public C_Captura getC_Captura() {
		if (c_Captura == null) {
			c_Captura = new C_CapturaJMF();
		}
		return c_Captura;
	}

	public abstract TabbedPanePerfilDeAcesso<PerfilDeAcesso> criarTabsPerfilDeAcesso();

}
