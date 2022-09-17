/*
 * AuditorDeProcMedico.java
 *
 * Created on 16/03/2012, 14:13:50
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeProcMedico extends Auditor<ProcMedico>
{
    @Override
    void preencherAlteracoes (ProcMedico novo, ProcMedico antigo)
    {
        if (!Objects.equals(novo.getNome(), antigo.getNome()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNome());
            ar.setValorAposAlteracao(novo.getNome());
        }
        if (!Objects.equals(novo.getDiasParaEntregaDoLaudo(), antigo.getDiasParaEntregaDoLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Dias para Entrega do laudo");
            ar.setValorOriginal(String.valueOf(antigo.getDiasParaEntregaDoLaudo()));
            ar.setValorAposAlteracao(String.valueOf(novo.getDiasParaEntregaDoLaudo()));
        }
        if (!Objects.equals(novo.getRestricaoSexo(), antigo.getRestricaoSexo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Restrição de Sexo");
            ar.setValorOriginal(antigo.getRestricaoSexo().toString());
            ar.setValorAposAlteracao(novo.getRestricaoSexo().toString());
        }
        if (!Objects.equals(novo.getGrupo(), antigo.getGrupo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Grupo");
            ar.setValorOriginal(antigo.getGrupo().toString());
            ar.setValorAposAlteracao(novo.getGrupo().toString());
        }

        compararListaModelos(novo.getModelos(), antigo.getModelos());

        compararListaProcedimentos(novo.getProcDaTabela(), antigo.getProcDaTabela());
    }

    private void compararListaProcedimentos (List<ProcDaTabela> novo, List<ProcDaTabela> antigo)
    {
        //laço para testar se excluiu ou alterou algum procedimento
        for (int i = 0; i < antigo.size(); i++)
        {
            ProcDaTabela pAntigo = antigo.get(i);
            if (!novo.contains(pAntigo)) //se excluiu
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.APAGAR);
                ar.setCampo("Tabela de Preços");
                ar.setValorOriginal(pAntigo.toString());
                ar.setValorAposAlteracao("");
            }
            else // verifica alterações
            {
                ProcDaTabela pNovo = novo.get(novo.lastIndexOf(pAntigo));
                if (!Objects.equals(pNovo.getValorPaciente(), pAntigo.getValorPaciente()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo(pAntigo.getTabelaDeProcedimentos().toString() + " -> Valor Paciente");
                    ar.setValorOriginal(String.valueOf(pAntigo.getValorPaciente()));
                    ar.setValorAposAlteracao(String.valueOf(pNovo.getValorPaciente()));
                }
                if (!Objects.equals(pNovo.getValorNoConvenio().getValorNoConvenio(), pAntigo.getValorNoConvenio().getValorNoConvenio()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo(pAntigo.getTabelaDeProcedimentos().toString() + " -> Valor Convênio");
                    ar.setValorOriginal(String.valueOf(pAntigo.getValorNoConvenio().getValorNoConvenio()));
                    ar.setValorAposAlteracao(String.valueOf(pNovo.getValorNoConvenio().getValorNoConvenio()));
                }
            }
        }
        //testa se inseriu algum procedimento
        for (int i = 0; i < novo.size(); i++)
        {
            if (!antigo.contains(novo.get(i)))
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.ADICIONAR);
                ar.setCampo("Tabela de Preços");
                ar.setValorOriginal("");
                ar.setValorAposAlteracao(novo.get(i).toString());
            }
        }

    }

    private void compararListaModelos (List<ModeloDeLaudoDoProc> novo, List<ModeloDeLaudoDoProc> antigo)
    {
        //laço para testar se excluiu ou alterou algum procedimento
        for (int i = 0; i < antigo.size(); i++)
        {
            ModeloDeLaudoDoProc mAntigo = antigo.get(i);
            if (!novo.contains(mAntigo)) //se excluiu
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.APAGAR);
                ar.setCampo("Modelos de Laudo");
                ar.setValorOriginal(mAntigo.toString());
                ar.setValorAposAlteracao("");
            }
            else // verifica alterações
            {
                ModeloDeLaudoDoProc mNovo = novo.get(novo.lastIndexOf(mAntigo));
                if (!Objects.equals(mNovo.getDescricao(), mAntigo.getDescricao()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo("Descrição");
                    ar.setValorOriginal(mAntigo.getDescricao());
                    ar.setValorAposAlteracao(mNovo.getDescricao());
                }
                if (!Objects.equals(mNovo.getModeloDeLaudo(), mAntigo.getModeloDeLaudo()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo("Modelo de Laudo");
                    ar.setValorOriginal(mAntigo.getModeloDeLaudo().toString());
                    ar.setValorAposAlteracao(mNovo.getModeloDeLaudo().toString());
                }
            }
        }
        //testa se inseriu algum procedimento
        for (int i = 0; i < novo.size(); i++)
        {
            if (!antigo.contains(novo.get(i)))
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.ADICIONAR);
                ar.setCampo("Modelos de Laudo");
                ar.setValorOriginal("");
                ar.setValorAposAlteracao(novo.get(i).toString());
            }
        }
    }

}
