package com.ic.projects.laudoecia.model.enums;

public enum PARAMETRO_BUSCA_SIGLA {
	BUSCA_SIGLA_TEXTO("1 - Busca Sigla ap. Texto", Descricao.BUSCA_SIGLA_TEXTO),
	BUSCA_TEXTO_TEXTO("2 - Busca Texto ap. Texto", Descricao.BUSCA_TEXTO_TEXTO),
	BUSCA_SIGLA_SIGLA("3 - Busca Sigla ap. Sigla", Descricao.BUSCA_SIGLA_SIGLA),
	BUSCA_MEIO_TEXTO_TEXTO("4 - Buca Texto meio Texto", Descricao.BUSCA_MEIO_TEXTO_TEXTO),
	BUSCA_SIGLA_MOSTRA_TEXTO("5 - Busca Sigla e Mostra Texto", Descricao.BUSCA_SIGLA_MOSTRA_TEXTO),
	BUSCA_SIGLA_MOSTRA_SIGLA_E_TEXTO("6 - Busca Sigla e mostra Sigla Com Texto", Descricao.BUSCA_SIGLA_MOSTRA_SIGLA_E_TEXTO);

	private final String controle;
	private final String descricao;

	private PARAMETRO_BUSCA_SIGLA(String controle, String descricao) {
		this.controle = controle;
		this.descricao = descricao;
	}

	public String getControle() {
		return controle;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return controle;
	}

	private class Descricao {
		private static final String BUSCA_SIGLA_TEXTO = "1 - Busca Sigla e mostra Texto na tela";
		private static final String BUSCA_TEXTO_TEXTO = "2 - Busca Texto e mostra Texto na tela";
		private static final String BUSCA_SIGLA_SIGLA = "3 - Busca Sigla e mostra Sigla na tela";
		private static final String BUSCA_MEIO_TEXTO_TEXTO = "4 - Busca Texto e mostra meio do Texto";
		private static final String BUSCA_SIGLA_MOSTRA_TEXTO = "5 - Busca Sigla e Mostra Texto na tela";
		private static final String BUSCA_SIGLA_MOSTRA_SIGLA_E_TEXTO = "6 - Busca Sigla e mostra Sigla Com Texto";
	}
	
}
