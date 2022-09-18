package com.ic.projects.laudoecia.dao.auditable;

import java.util.List;

import javax.persistence.EntityManager;

import com.ic.projects.laudoecia.control.auditores.AuditorDeConsentimento;
import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.lib.dao.general.And;
import com.lib.dao.general.OrderBy;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;

public class DaoConsentimento extends DaoAuditor<Consentimento> {

	public DaoConsentimento() {
		super(Consentimento.class, new AuditorDeConsentimento());
	}

	public Consentimento procurarPorNome(String descricao) {
		QueryBuilder qb = new QueryBuilder(new Select(), new Where("descricao"));
		qb.setParametro("descricao", descricao);
		return getSingleResult(qb);
	}
	
	public List<String> buscarPorNome(String busca, int maxResults) {
		QueryBuilder qb = new QueryBuilder(new Select("descricao"), new Where(true, "descricao", LIKE), new OrderBy("descricao"));
		qb.setParametro("nome", configurarParamBusca(busca, false));
		qb.setMaxResults(maxResults);
		return getResultList(qb, String.class);
	}

	public List<Object[]> buscarConsentimentoPorNome(String descricao, int maxResults) {
		QueryBuilder qb = new QueryBuilder(new Select("codigo", "descricao", "dataaceitacao", "aceito", "datarevogacao"),
				new Where(true, "descricao", LIKE));
		qb.setParametro("descricao", configurarParamBusca(descricao, false));
		qb.setMaxResults(maxResults);
		return getResultList(qb, Object[].class);
	}

	public List<Object[]> buscarConsentimentoPorCodigo(int codigo) {
		QueryBuilder qb = new QueryBuilder(new Select("codigo", "descricao", "dataaceitacao", "aceito", "datarevogacao"), new Where("codigo"));
		qb.setParametro("codigo", codigo);
		return getResultList(qb, Object[].class);
	}

	public boolean validarUnicidadeDeNome(int codigo, String descricao) {
		return validarUnicidade(codigo, "descricao", descricao);
	}

	@Override
	public void aboutToPersist(Consentimento entity, EntityManager em) {
		super.aboutToPersist(entity, em);
	}

	@Override
	public void aboutToRemove(Consentimento entity, EntityManager em) {
		super.aboutToRemove(entity, em);
	}

	public List<Consentimento> getToRelatorio() {
		QueryBuilder qb = new QueryBuilder(new Select());
		return getResultList(qb);
	}

	public boolean validarUnicidadeDeNumNoConselho(Integer id, Paciente paciente, String descricao) {
		QueryBuilder qb = new QueryBuilder(new Select(nomeDaColunaId), new And("paciente"), new And("descricao"));
		qb.setParametro("paciente", paciente);
		qb.setParametro("descricao", descricao);
		qb.setMaxResults(1);
		List<Integer> lista = getResultList(qb, Integer.class);
		if (lista.isEmpty()) {
			return true;
		} else if (lista.size() > 1) {
			return false;
		} else {
			return lista.get(0).equals(id);
		}
	}

}
