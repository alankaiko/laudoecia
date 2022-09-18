package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

public class C_CadastroConsentimento extends MyC_Cadastro<Consentimento> {
	public C_CadastroConsentimento(ViewCadastro view, DefC_BuscaComCrud<Consentimento, Integer> c_Busca, C_EntidadeComCrud<Consentimento, Integer> c_Entidade) {
		super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAdicionar(PerfilDeAcesso p) {
				return p.isAdicionaConsentimento();
			}

			@Override
			public boolean podeAlterar(PerfilDeAcesso p) {
				return p.isAlteraConsentimento();
			}

			@Override
			public boolean podeApagar(PerfilDeAcesso p) {
				return p.isApagaConsentimento();
			}

		});
	}

}
