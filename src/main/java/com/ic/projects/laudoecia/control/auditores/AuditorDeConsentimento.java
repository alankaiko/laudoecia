package com.ic.projects.laudoecia.control.auditores;

import java.util.Objects;

import com.ic.projects.laudoecia.model.auditable.Consentimento;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;

public class AuditorDeConsentimento extends Auditor<Consentimento> {
	@Override
	void preencherAlteracoes(Consentimento novo, Consentimento antigo) {
	
		if (!Objects.equals(novo.getPaciente(), antigo.getPaciente())) {
			AltDeRegistro ar = criarAltDeReg();
			ar.setCampo("Paciente");
			ar.setValorOriginal(antigo.getPaciente().toString());
			ar.setValorAposAlteracao(novo.getPaciente().toString());
		}
		if (!Objects.equals(novo.getDataaceitacao(), antigo.getDataaceitacao())) {
			AltDeRegistro ar = criarAltDeReg();
			ar.setCampo("Data Aceito");
			ar.setValorOriginal(antigo.getDataaceitacao().toString());
			ar.setValorAposAlteracao(novo.getDataaceitacao().toString());
		}
		if (!Objects.equals(novo.getDatarevogacao(), antigo.getDatarevogacao())) {
			AltDeRegistro ar = criarAltDeReg();
			ar.setCampo("Data Revoga");
			ar.setValorOriginal(antigo.getDatarevogacao().toString());
			ar.setValorAposAlteracao(novo.getDatarevogacao().toString());
		}
	}
}
