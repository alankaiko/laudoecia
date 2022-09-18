package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.validacao.ValidadorDeUnicidadeConsentimento;
import com.ic.projects.laudoecia.dao.auditable.DaoConsentimento;
import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;

public class C_EntidadeConsentimento extends DefC_EntidadeComCrud<Consentimento, Integer> {
	private DaoConsentimento dao;

	public C_EntidadeConsentimento(ViewEntidadeComCrud<Consentimento> view) {
		super(new DaoConsentimento(), view);
		dao = (DaoConsentimento) getDao();
	}

	@Override
	public Consentimento criarEntidadeParaAdicionar() {
		Consentimento resp = new Consentimento(dao.sugerirNovoID());
		return resp;
	}

	@Override
	protected void adicionarValidadores() {
		validadores.put("numNoConselho", new ValidadorDeUnicidadeConsentimento((DaoConsentimento) getDao()));
	}

}
