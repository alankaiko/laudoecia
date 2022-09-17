/*
 * AuditorDeProfSolicitante.java
 *
 * Created on 20/04/2012, 11:10:48
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeProfSolicitante extends Auditor<ProfSolicitante>
{
    @Override
    void preencherAlteracoes (ProfSolicitante novo, ProfSolicitante antigo)
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
    }

}
