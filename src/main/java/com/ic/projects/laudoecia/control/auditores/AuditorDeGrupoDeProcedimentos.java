/*
 * AuditorDeGrupoDeProcedimentos.java
 *
 * Created on 15/03/2012, 08:22:08
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeGrupoDeProcedimentos extends Auditor<GrupoProcedimento>
{
    @Override
    void preencherAlteracoes (GrupoProcedimento novo, GrupoProcedimento antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
    }

}
