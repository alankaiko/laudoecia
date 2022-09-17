/*
 * AuditorDeLicenciado.java
 *
 * Created on 04/04/2012, 11:36:43
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeLicenciado extends Auditor<Licenciado>
{
    @Override
    void preencherAlteracoes (final Licenciado novo, Licenciado antigo)
    {
        if (!Objects.equals(novo.getCnes(), antigo.getCnes()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("CNES");
            ar.setValorOriginal(antigo.getCnes());
            ar.setValorAposAlteracao(novo.getCnes());
        }
        if (!Objects.equals(novo.getCnpj(), antigo.getCnpj()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("CNPJ");
            ar.setValorOriginal(antigo.getCnpj());
            ar.setValorAposAlteracao(novo.getCnpj());
        }
        if (!Objects.equals(novo.getCpf(), antigo.getCpf()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("CPF");
            ar.setValorOriginal(antigo.getCpf());
            ar.setValorAposAlteracao(novo.getCpf());
        }
        if (!Objects.equals(novo.getRazaoSocial(), antigo.getRazaoSocial()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Razão Social");
            ar.setValorOriginal(antigo.getRazaoSocial());
            ar.setValorAposAlteracao(novo.getRazaoSocial());
        }
        if (!Objects.equals(novo.getEmail(), antigo.getEmail()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("E-mail");
            ar.setValorOriginal(antigo.getEmail());
            ar.setValorAposAlteracao(novo.getEmail());
        }
        if (!Objects.equals(novo.getSite(), antigo.getSite()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Website");
            ar.setValorOriginal(antigo.getSite());
            ar.setValorAposAlteracao(novo.getSite());
        }
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
        boolean licencaMudou = false;
        if (!Objects.equals(novo.getSerial(), antigo.getSerial()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Serial");
            ar.setValorOriginal(antigo.getSerial());
            ar.setValorAposAlteracao(novo.getSerial());
            licencaMudou = true;
        }
        if (!Objects.equals(novo.getLicenciadoPara(), antigo.getLicenciadoPara()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Licenciado para");
            ar.setValorOriginal(antigo.getLicenciadoPara());
            ar.setValorAposAlteracao(novo.getLicenciadoPara());
            licencaMudou = true;
        }
        if (!Objects.equals(novo.getQtdeAcessos(), antigo.getQtdeAcessos()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Qtde de acessos");
            ar.setValorOriginal(String.valueOf(antigo.getQtdeAcessos()));
            ar.setValorAposAlteracao(String.valueOf(novo.getQtdeAcessos()));
            licencaMudou = true;
        }
        if (!Objects.equals(novo.getTipodelicenca(), antigo.getTipodelicenca()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Tipo de licenca");
            ar.setValorOriginal(String.valueOf(antigo.getTipodelicenca()));
            ar.setValorAposAlteracao(String.valueOf(novo.getTipodelicenca()));
            licencaMudou = true;
        }
        final boolean licencaMudouFinal = licencaMudou;
        java.awt.EventQueue.invokeLater(new Runnable()
        {

            @Override
            public void run ()
            {
                if (licencaMudouFinal)
                {
                    StaticInfo.licencaMudou(novo);
                }
            }
        });
        compararEnderecos(novo.getEndereco(), antigo.getEndereco());

    }

}
