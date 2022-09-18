package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

public class C_CadastroPoliticaPrivacidade extends MyC_Cadastro<PoliticaPrivacidade> {
	public C_CadastroPoliticaPrivacidade(ViewCadastro view, DefC_BuscaComCrud<PoliticaPrivacidade, Integer> c_Busca, C_EntidadeComCrud<PoliticaPrivacidade, Integer> c_Entidade) {
		super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAdicionar(PerfilDeAcesso p) {
				return p.isAdicionaPoliticaPrivacidade();
			}
		});
	}

}
