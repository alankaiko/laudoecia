/*
 * C_EntidadePaciente.java
 *
 * Created on 13/03/2012, 08:55:14
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoPaciente;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;
import java.util.Date;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadePaciente extends DefC_EntidadeComCrud<Paciente, Integer>
{
    private DaoProcDoAtd daoProc;
    private DaoPaciente dao;
    private C_CadastroPaciente c_CadastroDePaciente;

    public C_EntidadePaciente (ViewEntidadeComCrud<Paciente> view)
    {
        super(new DaoPaciente(), view);
        dao = (DaoPaciente) getDao();
    }

    @Override
    public boolean validarCodigo ()
    {
        return false;
    }

    @Override
    public Paciente criarEntidadeParaAdicionar ()
    {
        Paciente p = new Paciente();
        p.setDataDeCadastro(new Date());
        return p;
    }

    @Override
    protected void preencherDadosParaAdicao (Paciente p) throws Exception
    {
        p.setCodigo(dao.sugerirNovoID());
    }

    public void verPaciente (Paciente p)
    {
        if (c_CadastroDePaciente != null)
        {
            c_CadastroDePaciente.verPaciente(p);
        }
    }

    void setC_CadastroDePaciente (C_CadastroPaciente c_CadastroDePaciente)
    {
        this.c_CadastroDePaciente = c_CadastroDePaciente;
    }

    @Override
    protected void adicionarValidadores ()
    {
    }

    public int getCodigo (String text, Date date)
    {
        return dao.getCodigo(text, date);
    }

    public List<Object[]> listarExames (Paciente entidade)
    {
        return getDaoProc().listarExames(entidade);
    }

    private DaoProcDoAtd getDaoProc()
    {
        if (daoProc == null)
        {
            daoProc = new DaoProcDoAtd();
        }
        return daoProc;
    }

    public ProcDoAtd getProc (int i)
    {
        return getDaoProc().procurarPorId(i);
    }

}
