/*
 * AuditorDeUsuarios.java
 *
 * Created on 05/03/2012, 10:14:37
 */

package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class AuditorDeUsuarios extends Auditor<Usuario>
{

    @Override
    void preencherAlteracoes (Usuario novo, Usuario antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
        //ao invés de remover, estou mascarando a senha
        if (!Objects.equals(novo.getSenha(), antigo.getSenha()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Senha");
            ar.setValorOriginal("*****");
            ar.setValorAposAlteracao("*****");
        }
        if (!Objects.equals(novo.getLogin(), antigo.getLogin()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Login");
            ar.setValorOriginal(antigo.getLogin());
            ar.setValorAposAlteracao(novo.getLogin());
        }
        if (!Objects.equals(novo.getGrupo(), antigo.getGrupo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Grupo");
            if (antigo.getGrupo() == null)
            {
                ar.setValorOriginal("");
            }
            else
            {
                ar.setValorOriginal(antigo.getGrupo().toString());
            }
            if (novo.getGrupo() == null)
            {
                ar.setValorAposAlteracao("");
            }
            else
            {
                ar.setValorAposAlteracao(novo.getGrupo().toString());
            }
        }
    }

}
