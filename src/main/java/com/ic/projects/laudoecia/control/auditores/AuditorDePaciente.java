/*
 * AuditorDePaciente.java
 *
 * Created on 08/03/2012, 11:40:15
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.lib.java.utils.DateUtils;
import java.util.Objects;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDePaciente extends Auditor<Paciente>
{
    @Override
    void preencherAlteracoes (Paciente novo, Paciente antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
        if (!Objects.equals(novo.getEmail(), antigo.getEmail()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Email");
            ar.setValorOriginal(antigo.getEmail());
            ar.setValorAposAlteracao(novo.getEmail());
        }
        if (!Objects.equals(novo.getTelefone1(), antigo.getTelefone1()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Telefone 1");
            ar.setValorOriginal(antigo.getTelefone1());
            ar.setValorAposAlteracao(novo.getTelefone1());
        }
        if (!Objects.equals(novo.getTelefone2(), antigo.getTelefone2()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Telefone 2");
            ar.setValorOriginal(antigo.getTelefone2());
            ar.setValorAposAlteracao(novo.getTelefone2());
        }
        if (!Objects.equals(novo.getDataNascimento(), antigo.getDataNascimento()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Data Nascimento");
            ar.setValorOriginal(DateUtils.dateToString(antigo.getDataNascimento(), "dd/MM/yyyy"));
            ar.setValorAposAlteracao(DateUtils.dateToString(antigo.getDataNascimento(), "dd/MM/yyyy"));
        }
        if (!Objects.equals(novo.getSexo(), antigo.getSexo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Sexo");
            ar.setValorOriginal(antigo.getSexo().toString());
            ar.setValorAposAlteracao(novo.getSexo().toString());
        }
        if (!Objects.equals(novo.getObservacoes(), antigo.getObservacoes()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Observações");
            ar.setValorOriginal(antigo.getObservacoes());
            ar.setValorAposAlteracao(novo.getObservacoes());
        }

        compararEnderecos(novo.getEndereco(), antigo.getEndereco());

    }

}
