/*
 * AuditorDeEstacaoDeTrabalho.java
 *
 * Created on 17/07/2012, 10:46:18
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeEstacaoDeTrabalho extends Auditor<EstacaoDeTrabalho>
{
    @Override
    void preencherAlteracoes (EstacaoDeTrabalho novo, EstacaoDeTrabalho antigo)
    {
        if (!Objects.equals(novo.getNomeEstacaoDeTrabalho(), antigo.getNomeEstacaoDeTrabalho()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Nome");
            ar.setValorOriginal(antigo.getNomeEstacaoDeTrabalho());
            ar.setValorAposAlteracao(novo.getNomeEstacaoDeTrabalho());
        }
        if (!Objects.equals(novo.getDispositivoGrav(), antigo.getDispositivoGrav()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Dispositivo Gravação");
            ar.setValorOriginal(antigo.getDispositivoGrav());
            ar.setValorAposAlteracao(novo.getDispositivoGrav());
        }
    }

}
