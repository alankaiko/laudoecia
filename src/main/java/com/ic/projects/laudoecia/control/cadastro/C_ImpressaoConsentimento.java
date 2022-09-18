package com.ic.projects.laudoecia.control.cadastro;

import java.util.List;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.auditable.DaoConsentimento;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.lib.icontrol.crud.cadastro.C_Impressao;

public class C_ImpressaoConsentimento implements C_Impressao {
	private DaoConsentimento dao;

	@Override
	public void imprimir() {
		LaudoeCia.getTelaPrincipal().mostrarTela(TelaPrincipal.CONSENTIMENTO, null);
	}

	public List<Consentimento> getLista() {
		return getDao().getToRelatorio();
	}

	public DaoConsentimento getDao() {
		if (dao == null) 
			dao = new DaoConsentimento();

		return dao;
	}
}
