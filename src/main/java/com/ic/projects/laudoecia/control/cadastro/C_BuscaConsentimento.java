package com.ic.projects.laudoecia.control.cadastro;

import java.util.ArrayList;
import java.util.List;

import com.ic.projects.laudoecia.dao.auditable.DaoConsentimento;
import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;

public class C_BuscaConsentimento extends AbsDefC_BuscaComCrud<Consentimento, Integer> {
	private DaoConsentimento dao;

	public C_BuscaConsentimento(C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca) {
		super(new DaoConsentimento(), c_ParamsBusca, c_ResultadosDaBusca);
		dao = (DaoConsentimento) getDao();
	}

	@Override
	public Object[] criarLinhaSelecionada(Consentimento entidade) {
		return new Object[] { entidade.getCodigo(), entidade.getDescricao(), entidade.getDataaceitacao(), entidade.isAceito(), entidade.getDatarevogacao() };
	}

	@Override
	protected List<Object[]> nullSafeListarResultados(Object[] paramsBusca) {
		Object busca = paramsBusca[0];
		String campo = (String) paramsBusca[1];
		int maxResults = (int) paramsBusca[2];
		switch (campo) {
		case "descricao":
			return dao.buscarConsentimentoPorNome((String) busca, maxResults);
		default:
			return new ArrayList<>();
		}
	}

}
