package com.ic.projects.laudoecia.dao.auditable;

import java.util.List;

import com.ic.projects.laudoecia.control.auditores.AuditorDePoliticaPrivacidade;
import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;

public class DaoPoliticaPrivacidade extends DaoAuditor<PoliticaPrivacidade> {
	
	public DaoPoliticaPrivacidade() {
		super(PoliticaPrivacidade.class, new AuditorDePoliticaPrivacidade());
	}

	public List<Object[]> buscarPorNome(String titulo, int maxResults) {
		QueryBuilder qb = new QueryBuilder(new Select("codigo", "titulo", "versao", "ativo", "datacadastro", "datadesativacao"),
				new Where(true, "titulo", LIKE));
		qb.setParametro("titulo", configurarParamBusca(titulo));
		qb.setMaxResults(maxResults);
		return getResultList(qb, Object[].class);
	}
	
	public List<Object[]> buscarPorVersao(String titulo) {
		QueryBuilder qb = new QueryBuilder(new Select("codigo", "titulo", "versao", "ativo", "datacadastro", "datadesativacao"),
				new Where(true, "titulo", LIKE));
		qb.setParametro("titulo", configurarParamBusca(titulo));
		return getResultList(qb, Object[].class);
	}

	public List<Object[]> buscarPorDescricaoCodigo(String titulo) {
		QueryBuilder qb;
		if (titulo.matches("[0-9]+")) {
			qb = new QueryBuilder(new Select("titulo", "versao", "codigo"), new Where("codigo"));
			qb.setParametro("codigo", Integer.valueOf(titulo));
		} else {
			qb = new QueryBuilder(new Select("titulo", "versao", "codigo"), new Where(true, "titulo", LIKE));
			qb.setParametro("titulo", configurarParamBusca(titulo));
		}
		return getResultList(qb, Object[].class);
	}

	public PoliticaPrivacidade procurarPorTitulo(String titulo) {
		QueryBuilder qb = new QueryBuilder(new Select(), new Where("titulo"));
		qb.setParametro("titulo", titulo);
		return getSingleResult(qb);
	}

	public List<Object[]> buscarPorPolitica(PoliticaPrivacidade privacidade, int maxResults) {
		
		QueryBuilder qb = new QueryBuilder(
				new Select(true, "codigo", "titulo", "versao", "ativo", "datacadastro", "datadesativacao"),
				new Where("privacidade", "privacidade"));
		qb.setParametro("privacidade", privacidade);

		qb.setMaxResults(maxResults);
		return getResultList(qb, Object[].class);
	}

}
