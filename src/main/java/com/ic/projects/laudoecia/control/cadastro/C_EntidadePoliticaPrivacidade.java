package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoPoliticaPrivacidade;
import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;

public class C_EntidadePoliticaPrivacidade extends DefC_EntidadeComCrud<PoliticaPrivacidade, Integer> {
	private DaoPoliticaPrivacidade dao;

	public C_EntidadePoliticaPrivacidade(ViewEntidadeComCrud<PoliticaPrivacidade> view) {
		super(new DaoPoliticaPrivacidade(), view);
		dao = (DaoPoliticaPrivacidade) getDao();
	}

	@Override
	public PoliticaPrivacidade criarEntidadeParaAdicionar() {
		PoliticaPrivacidade resp = new PoliticaPrivacidade(dao.sugerirNovoID());
		return resp;
	}

	@Override
	protected void adicionarValidadores() {
		
	}

}
