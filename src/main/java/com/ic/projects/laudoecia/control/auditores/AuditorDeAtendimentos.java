/*
 * AuditorDeAtendimentos.java
 *
 * Created on 27/03/2012, 08:43:24
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.lib.java.utils.DateUtils;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeAtendimentos extends Auditor<Atendimento>
{

    @Override
    void preencherAlteracoes (Atendimento novo, Atendimento antigo)
    {
        if (!Objects.equals(novo.getPaciente(), antigo.getPaciente()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Paciente");
            ar.setValorOriginal(antigo.getPaciente().toString());
            ar.setValorAposAlteracao(novo.getPaciente().toString());
        }
        if (!Objects.equals(novo.getConvenio(), antigo.getConvenio()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Convênio");
            ar.setValorOriginal(antigo.getConvenio().toString());
            ar.setValorAposAlteracao(novo.getConvenio().toString());
        }
        if (!Objects.equals(novo.getSolicitante(), antigo.getSolicitante()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Profissional Solicitante");
            ar.setValorOriginal(antigo.getSolicitante() == null ? "" :
                                antigo.getSolicitante().toString());
            ar.setValorAposAlteracao(novo.getSolicitante() == null ? "" :
                                novo.getSolicitante().toString());
        }
        if (!Objects.equals(novo.getObservacoes(), antigo.getObservacoes()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Observações");
            ar.setValorOriginal(antigo.getObservacoes());
            ar.setValorAposAlteracao(novo.getObservacoes());
        }
        if (!Objects.equals(novo.isGravarExame(), antigo.isGravarExame()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Gravar Exame");
            ar.setValorOriginal(antigo.isGravarExame() ? "SIM" : "NÃO");
            ar.setValorAposAlteracao(novo.isGravarExame() ? "SIM" : "NÃO");
        }

        compararListaProcedimentos(novo.getProcedimentos(), antigo.getProcedimentos());

    }

    private void compararListaProcedimentos (List<ProcDoAtd> novo, List<ProcDoAtd> antigo)
    {
        //laço para testar se excluiu ou alterou algum procedimento
        for (int i = 0; i < antigo.size(); i++)
        {
            ProcDoAtd pAntigo = antigo.get(i);
            if (!novo.contains(pAntigo)) //se excluiu
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.APAGAR);
                ar.setCampo("Procedimentos");
                ar.setValorOriginal(pAntigo.toString());
                ar.setValorAposAlteracao("");
            }
            else // verifica alterações
            {
                ProcDoAtd pNovo = novo.get(novo.lastIndexOf(pAntigo));
                if (!Objects.equals(pNovo.getProfExecutante(), pAntigo.getProfExecutante()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo(pAntigo.toString() + " -> Prof. Executante");
                    ar.setValorOriginal(pAntigo.getProfExecutante() == null ?
                                        "" : pAntigo.getProfExecutante().getNome());
                    ar.setValorAposAlteracao(pNovo.getProfExecutante() == null ?
                                        "" : pNovo.getProfExecutante().getNome());
                }
                if (!Objects.equals(pNovo.getValorPaciente(), pAntigo.getValorPaciente()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo(pAntigo.toString() + " -> Valor Paciente");
                    ar.setValorOriginal(pAntigo.getValorPaciente().toString());
                    ar.setValorAposAlteracao(pNovo.getValorPaciente().toString());
                }
                if (!Objects.equals(pNovo.getDataDaExecucao(), pAntigo.getDataDaExecucao()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo(pAntigo.toString() + " -> Data Execucao");
                    ar.setValorOriginal(DateUtils.dateToString(pAntigo.getDataDaExecucao(), "dd/MM/yyyy"));
                    ar.setValorAposAlteracao(DateUtils.dateToString(pNovo.getDataDaExecucao(), "dd/MM/yyyy"));
                }
                if (!Objects.equals(pNovo.getPrevEntregaLaudo(), pAntigo.getPrevEntregaLaudo()))
                {
                    AltDeRegistro ar = criarAltDeReg();
                    ar.setCampo(pAntigo.toString() + " -> Prev. de Entrega Laudo");
                    ar.setValorOriginal(DateUtils.dateToString(pAntigo.getPrevEntregaLaudo(), "dd/MM/yyyy"));
                    ar.setValorAposAlteracao(DateUtils.dateToString(pNovo.getPrevEntregaLaudo(), "dd/MM/yyyy"));
                }
            }
        }
        //testa se inseriu algum procedimento
        for (int i = 0; i < novo.size(); i++)
        {
            if (!antigo.contains(novo.get(i)))
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.ADICIONAR);
                ar.setCampo("Procedimentos");
                ar.setValorOriginal("");
                ar.setValorAposAlteracao(novo.get(i).toString());
            }
        }

    }

}
