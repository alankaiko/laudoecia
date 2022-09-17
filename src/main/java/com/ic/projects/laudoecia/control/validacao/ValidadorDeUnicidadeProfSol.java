/*
 * ValidadorDeUnicidadeProfSol.java
 *
 * Created on 13/04/2012, 10:55:23
 */
package com.ic.projects.laudoecia.control.validacao;

import com.ic.projects.laudoecia.dao.auditable.DaoProfSolicitante;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.FieldReader;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class ValidadorDeUnicidadeProfSol implements C_Validacao
{
    private DaoProfSolicitante dao;
    private FieldReader readerCodigo;
    private FieldReader readerUF;
    private FieldReader readerConselho;
    private FieldReader readerNumNoConselho;

    public ValidadorDeUnicidadeProfSol (DaoProfSolicitante dao)
    {
        this.dao = dao;
    }

    @Override
    public C_Validacao set (FieldReader reader)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public C_Validacao set (String chave, FieldReader reader)
    {
        switch (chave)
        {
            case "codigo":
                readerCodigo = reader;
                return this;
            case "uf":
                readerUF = reader;
                return this;
            case "conselho":
                readerConselho = reader;
                return this;
            case "numNoConselho":
                readerNumNoConselho = reader;
                return this;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public boolean validationOk (int tipo)
    {
        return dao.validarUnicidadeDeNumNoConselho(
                (int) readerCodigo.readField(),
                (UF) readerUF.readField(),
                (TISS_Conselho) readerConselho.readField(),
                (String) readerNumNoConselho.readField());
    }

    @Override
    public String getErrorMessage ()
    {
        return "Número no conselho já cadastrado!";
    }

}
