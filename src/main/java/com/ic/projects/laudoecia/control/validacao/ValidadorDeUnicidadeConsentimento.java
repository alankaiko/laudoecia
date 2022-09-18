package com.ic.projects.laudoecia.control.validacao;

import com.ic.projects.laudoecia.dao.auditable.DaoConsentimento;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.FieldReader;

public class ValidadorDeUnicidadeConsentimento implements C_Validacao {
	private DaoConsentimento dao;
	private FieldReader readerCodigo;
	private FieldReader readerPaciente;
	private FieldReader readerTitulo;

	public ValidadorDeUnicidadeConsentimento(DaoConsentimento dao) {
		this.dao = dao;
	}

	@Override
	public C_Validacao set(FieldReader reader) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public C_Validacao set(String chave, FieldReader reader) {
		switch (chave) {
		case "codigo":
			readerCodigo = reader;
			return this;
		case "paciente":
			readerPaciente = reader;
			return this;
		case "titulo":
			readerTitulo = reader;
			return this;
		default:
			throw new AssertionError();
		}
	}

	@Override
	public boolean validationOk(int tipo) {
		return dao.validarUnicidadeDeNumNoConselho((int) readerCodigo.readField(),
				(Paciente) readerPaciente.readField(), (String) readerTitulo.readField());
	}

	@Override
	public String getErrorMessage() {
		return "O número no conselho escolhido já foi cadastrado para este estado e conselho!";
	}

}
