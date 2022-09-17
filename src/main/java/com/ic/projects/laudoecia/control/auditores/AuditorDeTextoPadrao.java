/*
 * AuditorDeTextoPadrao.java
 *
 * Created on 20/06/2012, 16:20:57
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeTextoPadrao extends Auditor<TextoPadrao>
{
    @Override
    void preencherAlteracoes (TextoPadrao novo, TextoPadrao antigo)
    {
        if (!Objects.equals(novo.getAbreviatura(), antigo.getAbreviatura()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Abreviatura");
            ar.setValorOriginal(antigo.getAbreviatura());
            ar.setValorAposAlteracao(novo.getAbreviatura());
        }
        if (!Objects.equals(novo.getTexto(), antigo.getTexto()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Texto");
            ar.setValorOriginal(antigo.getTexto());
            ar.setValorAposAlteracao(novo.getTexto());
        }

        compararListaModelos(novo.getProcedimentos(), antigo.getProcedimentos());
    }

    private void compararListaModelos (List<ProcMedico> novo, List<ProcMedico> antigo)
    {
        //laço para testar se excluiu
        for (int i = 0; i < antigo.size(); i++)
        {
            ProcMedico pAntigo = antigo.get(i);
            if (!novo.contains(pAntigo))
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.APAGAR);
                ar.setCampo("Procedimentos Relacionados");
                ar.setValorOriginal(pAntigo.toString());
                ar.setValorAposAlteracao("");
            }
        }
        //testa se inseriu algum procedimento
        for (int i = 0; i < novo.size(); i++)
        {
            if (!antigo.contains(novo.get(i)))
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.ADICIONAR);
                ar.setCampo("Procedimentos Relacionados");
                ar.setValorOriginal("");
                ar.setValorAposAlteracao(novo.get(i).toString());
            }
        }
    }

}
