/*
 * AuditorDeProfExecutante.java
 *
 * Created on 16/03/2012, 10:17:26
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeProfExecutante extends Auditor<ProfExecutante>
{
    @Override
    void preencherAlteracoes (ProfExecutante novo, ProfExecutante antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
        if (!Objects.equals(novo.getUfConselho(), antigo.getUfConselho()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("UF Conselho");
            ar.setValorOriginal(antigo.getUfConselho().toString());
            ar.setValorAposAlteracao(novo.getUfConselho().toString());
        }
        if (!Objects.equals(novo.getConselho(), antigo.getConselho()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Conselho");
            ar.setValorOriginal(antigo.getConselho().toString());
            ar.setValorAposAlteracao(novo.getConselho().toString());
        }
        if (!Objects.equals(novo.getNumNoConselho(), antigo.getNumNoConselho()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Num. no Conselho");
            ar.setValorOriginal(antigo.getNumNoConselho());
            ar.setValorAposAlteracao(novo.getNumNoConselho());
        }
        if (!Objects.equals(novo.getFrasePessoal(), antigo.getFrasePessoal()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Frase Pessoal");
            ar.setValorOriginal(antigo.getFrasePessoal());
            ar.setValorAposAlteracao(novo.getFrasePessoal());
        }

        compararEnderecos(novo.getEndereco(), antigo.getEndereco());

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
        if (!Objects.equals(novo.getEmail(), antigo.getEmail()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Email");
            ar.setValorOriginal(antigo.getEmail());
            ar.setValorAposAlteracao(novo.getEmail());
        }
    }

}
