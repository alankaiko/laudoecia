/*
 * ViewFactoryV1.java
 *
 * Created on 02/03/2012, 08:30:42
 */

package com.ic.projects.laudoecia.view.build;

import java.util.ArrayList;
import java.util.List;

import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.swing.perfildeacesso.LinhaDePermissao;
import com.lib.swing.perfildeacesso.TabbedPanePerfilDeAcesso;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ViewFactoryV1 extends ViewFactory {
	private List<LinhaDePermissao> ldps = new ArrayList<>();

	protected ViewFactoryV1() {
		popularLinhasDePermissoes();
	}

	private void popularLinhasDePermissoes() {
		// menu cadastros
		ldps.add(new LinhaDePermissao("Convenio", "Cadastros", "Convênios"));
		ldps.add(new LinhaDePermissao("ProcMedico", "Cadastros", "Exames e procedimentos médicos"));
		ldps.add(new LinhaDePermissao("GrupoProcedimento", "Cadastros", "Grupo de exames e procedimentos"));
		ldps.add(new LinhaDePermissao("Paciente", "Cadastros", "Pacientes"));
		ldps.add(new LinhaDePermissao("ProfExecutante", "Cadastros", "Profissionais executantes"));
		ldps.add(new LinhaDePermissao("ProfSolicitante", "Cadastros", "Profissionais solicitantes"));
		ldps.add(new LinhaDePermissao("TextoPadrao", "Cadastros", "Textos padrões"));
		ldps.add(new LinhaDePermissao("GrupoDeUsuarios", "Cadastros", "Grupos de usuários"));
		ldps.add(new LinhaDePermissao("Usuario", "Cadastros", "Usuários"));

		// menu operações
		ldps.add(new LinhaDePermissao("Atendimento", "Operações", "Atendimentos"));
		ldps.add(new LinhaDePermissao("Laudo", "Operações", "Laudo e imagem"));
		
		// menu relatórios
		ldps.add(new LinhaDePermissao("RelAtendCompleto", "Relatórios", "Atendimento completo"));
		ldps.add(new LinhaDePermissao("RelAtendPorConvenio", "Relatórios", "Atendimento por convênio"));
		ldps.add(new LinhaDePermissao("RelAtendPorProcMedico", "Relatórios", "Atendimento por proc. médico"));
		ldps.add(new LinhaDePermissao("RelAtendPorProfExe", "Relatórios", "Atendimento por Prof. executante"));
		ldps.add(new LinhaDePermissao("RelAtendPorProfSol", "Relatórios", "Atendimento por Prof. solicitante"));
		ldps.add(new LinhaDePermissao("RelAtendResumos", "Relatórios", "Atendimento resumido"));
		ldps.add(new LinhaDePermissao("GrafAtendimentos", "Relatórios", "Gráficos de atendimentos"));
		ldps.add(new LinhaDePermissao("Auditoria", "Relatórios", "Auditoria do banco de dados"));

		// menu ferramentas
		ldps.add(new LinhaDePermissao("Backup", "Ferramentas", "Backup"));
		ldps.add(new LinhaDePermissao("EstacaoDeTrabalho", "Ferramentas", "Estações de trabalho"));
		// ldps.add(new LinhaDePermissao("ParametrosDaCaptura", "Ferramentas", "Parametros da Captura"));
		ldps.add(new LinhaDePermissao("ParametrosDoSistema", "Ferramentas", "Parametros do sistema"));
		ldps.add(new LinhaDePermissao("Licenciado", "Ferramentas", "Dados do licenciado"));
		//ldps.add(new LinhaDePermissao("ParametrosEmail", "Ferramentas", "Parametros de E-mail"));
		ldps.add(new LinhaDePermissao("Consentimento", "Ferramentas", "Consentimento"));
		ldps.add(new LinhaDePermissao("PoliticaPrivacidade", "Ferramentas", "Políticas de Privacidade"));
	}

	@Override
	public TabbedPanePerfilDeAcesso<PerfilDeAcesso> criarTabsPerfilDeAcesso() {
		return new TabbedPanePerfilDeAcesso<>(PerfilDeAcesso.class, ldps);
	}

}
