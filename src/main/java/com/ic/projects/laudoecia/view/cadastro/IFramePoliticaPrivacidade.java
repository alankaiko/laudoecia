package com.ic.projects.laudoecia.view.cadastro;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaPoliticaPrivacidade;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroPoliticaPrivacidade;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadePoliticaPrivacidade;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoConsentimento;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.utils.TableConfigurator;

public class IFramePoliticaPrivacidade extends SimpleIFrameCadastro {
	public IFramePoliticaPrivacidade() {
		super("Politica de Privacidade", 725, 500);
		setPnlCadastro(new SimplePnlCadastro());

		DefBuilder builder = new DefBuilder(new TableConfigurator() {
			@Override
			public boolean[] shouldResizeColumns() {
				return new boolean[] { false, true, false, false, false };
			}

			@Override
			public String[] columnsTitles() {
				return new String[] { "Código", "Titulo", "Versão", "Ativo?", "Data Cadastro", "Data Desativação" };
			}

			@Override
			public int[] columnsWidths() {
				return new int[] { 65, 150, 70, 100, 100 };
			}

			@Override
			public int[] sortedColumns() {
				return new int[] { 0 };
			}

			@Override
			public Class<?>[] columnsClasses() {
				return new Class<?>[] { Integer.class, String.class, String.class, Boolean.class, Date.class, Date.class };
			}

		});
		builder = builder.setTxtBusca(220);
		builder = builder.setCmbCampos(120, "descricao");
		builder = builder.setCmbNumResultados();

		pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
		new MeuSw(pnlCadastro.getTbarCrud()).execute();

		pnlCadastro.setPnlBusca(builder);

		pnlCadastro.start(C_BuscaPoliticaPrivacidade.class, C_EntidadePoliticaPrivacidade.class, PnlPoliticaPrivacidade.class, false, C_CadastroPoliticaPrivacidade.class);
	}

	private class MeuSw extends SwingWorker<C_Impressao, Void> {
		private TBarCRUD tbarCrud;

		private MeuSw(TBarCRUD tbarCrud) {
			this.tbarCrud = tbarCrud;
		}

		@Override
		protected C_Impressao doInBackground() throws Exception {
			return new C_ImpressaoConsentimento();
		}

		@Override
		protected void done() {
			try {
				tbarCrud.setC_Impressao(get());
			} catch (InterruptedException | ExecutionException ex) {
			}
		}

	}

}
