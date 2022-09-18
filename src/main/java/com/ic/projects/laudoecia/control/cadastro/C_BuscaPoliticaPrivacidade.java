package com.ic.projects.laudoecia.control.cadastro;

import java.util.ArrayList;
import java.util.List;

import com.ic.projects.laudoecia.dao.auditable.DaoPoliticaPrivacidade;
import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;

public class C_BuscaPoliticaPrivacidade extends AbsDefC_BuscaComCrud<PoliticaPrivacidade, Integer> {
	private DaoPoliticaPrivacidade dao;

	public C_BuscaPoliticaPrivacidade(C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca) {
		super(new DaoPoliticaPrivacidade(), c_ParamsBusca, c_ResultadosDaBusca);
		dao = (DaoPoliticaPrivacidade) getDao();
	}

	@Override
	public Object[] criarLinhaSelecionada(PoliticaPrivacidade entidade) {
		return new Object[] { entidade.getCodigo(), entidade.getTitulo(), entidade.getVersao(), entidade.isAtivo(), entidade.getDatacadastro(), entidade.getDatadesativacao() };
	}

	@Override
	protected List<Object[]> nullSafeListarResultados(Object[] paramsBusca) {
		Object busca = paramsBusca[0];
		String campo = (String) paramsBusca[1];
		int maxResults = (int) paramsBusca[2];
		switch (campo) {
		case "descricao":
			return dao.buscarPorNome((String) busca, maxResults);
		default:
			return new ArrayList<>();
		}
	}

}
