package com.ic.projects.laudoecia.control.autocompletar;

import java.util.ArrayList;
import java.util.List;

import com.ic.projects.laudoecia.dao.auditable.DaoPoliticaPrivacidade;
import com.ic.projects.laudoecia.model.auditable.PoliticaPrivacidade;
import com.lib.icontrol.autocompletar.AbsC_AutoCompletar;
import com.lib.iview.autocompletar.AcTableConfigurator;

public class BuscadorDePoliticaPrivacidade extends AbsC_AutoCompletar<PoliticaPrivacidade> {
	private DaoPoliticaPrivacidade dao;

	@Override
	public List<Object[]> buscarCandidatos(String textoDaBusca) {
		List<Object[]> resposta = new ArrayList<>();
		if (textoDaBusca == null) {
		} else if (textoDaBusca.matches("[0-9]+")) {
			PoliticaPrivacidade model = getDao().procurarPorId(Integer.valueOf(textoDaBusca));
			if (model != null) {
				resposta.add(new Object[] { model.getTitulo(), model.getVersao(), model.getCodigo() });
			}
		} else {
			resposta.addAll(getDao().buscarPorDescricaoCodigo(textoDaBusca));
		}
		return resposta;
	}

	@Override
	protected Object[] getLinha(PoliticaPrivacidade model) {
		return new Object[] { model.getTitulo(), model.getVersao(), model.getCodigo() };
	}

	@Override
	public AcTableConfigurator getPropriedadesDaTabela() {
		return new AcTableConfigurator() {
			@Override
			public int indexToUseAsTextFieldText() {
				return 0;
			}

			@Override
			public String[] columnsTitles() {
				return new String[] { "Título", "Versão", "Código" };
			}

			@Override
			public Class<?>[] columnsClasses() {
				return new Class<?>[] { String.class, String.class, Integer.class };
			}

			@Override
			public int[] columnsWidths() {
				return new int[] { 0, 90, 80 };
			}

			@Override
			public boolean[] shouldResizeColumns() {
				return new boolean[] { true, false, false };
			}

			@Override
			public int[] sortedColumns() {
				return new int[] { 0 };
			}

		};
	}

	@Override
	protected PoliticaPrivacidade getModel(Object[] linha) {
		return getDao().procurarPorId((int) linha[2]);
	}

	private DaoPoliticaPrivacidade getDao() {
		if (dao == null) {
			dao = new DaoPoliticaPrivacidade();
		}
		return dao;
	}

}
