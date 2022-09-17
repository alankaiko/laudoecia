/*
 * AuditorDeConvenios.java
 *
 * Created on 16/03/2012, 08:48:57
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeConvenios extends Auditor<Convenio>
{
    @Override
    void preencherAlteracoes (Convenio novo, Convenio antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
        if (!Objects.equals(novo.getObservacoes(), antigo.getObservacoes()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Observações");
            ar.setValorOriginal(antigo.getObservacoes());
            ar.setValorAposAlteracao(novo.getObservacoes());
        }
        if (!Objects.equals(novo.getTelefone(), antigo.getTelefone()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Telefone");
            ar.setValorOriginal(antigo.getTelefone());
            ar.setValorAposAlteracao(novo.getTelefone());
        }
        if (!Objects.equals(novo.getFax(), antigo.getFax()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Fax");
            ar.setValorOriginal(antigo.getFax());
            ar.setValorAposAlteracao(novo.getFax());
        }
        if (!Objects.equals(novo.getEmail(), antigo.getEmail()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Email");
            ar.setValorOriginal(antigo.getEmail());
            ar.setValorAposAlteracao(novo.getEmail());
        }
        if (!Objects.equals(novo.getNomeDoContato(), antigo.getNomeDoContato()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome do contato");
            ar.setValorOriginal(antigo.getNomeDoContato());
            ar.setValorAposAlteracao(novo.getNomeDoContato());
        }

        compararEnderecos(novo.getEndereco(), antigo.getEndereco());

    }

}
