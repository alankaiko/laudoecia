/*
 * AuditorDeGrupoDeUsuarios.java
 *
 * Created on 05/03/2012, 11:07:18
 */

package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class AuditorDeGrupoDeUsuarios extends Auditor<GrupoDeUsuarios>
{

    @Override
    void preencherAlteracoes (GrupoDeUsuarios novo, GrupoDeUsuarios antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
        compararPerfisDeAcesso(novo.getPerfilDeAcesso(), antigo.getPerfilDeAcesso());
    }

}
