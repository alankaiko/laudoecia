/*
 * C_EntidadeProcMedico.java
 *
 * Created on 13/03/2012, 09:48:50
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoProcMedico;
import com.ic.projects.laudoecia.dao.cadastro.DaoTabelaDeProcedimentos;
import com.ic.projects.laudoecia.dao.laudo.DaoModeloDeLaudo;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.cadastro.TabelaDeProcedimentos;
import com.ic.projects.laudoecia.model.cadastro.ValorFixo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeProcMedico extends DefC_EntidadeComCrud<ProcMedico, Integer>
{

    private DaoProcMedico dao;
    private DaoTabelaDeProcedimentos daoTabelaDeProcedimentos;
    private C_CadastroProcMedico c_CadastroDeProcMedico;
    private DaoModeloDeLaudo daoMdl;

    public C_EntidadeProcMedico (ViewEntidadeComCrud<ProcMedico> view)
    {
        super(new DaoProcMedico(), view);
        dao = (DaoProcMedico) getDao();
    }

    @Override
    public ProcMedico criarEntidadeParaAdicionar ()
    {
        ProcMedico procMed = new ProcMedico(dao.sugerirNovoID());
        procMed.setProcDaTabela(getInitProcDaTabela());
        procMed.setDiasParaEntregaDoLaudo(0);
        ModeloDeLaudoDoProc m = new ModeloDeLaudoDoProc();
        m.setDescricao("EM BRANCO");
        m.setPrioridade(0);
        m.setCustomString("2;;setValor;;$$\n");
        ModeloDeLaudo mdl = new ModeloDeLaudo(27);
        mdl.setNome("TEXTO LIVRE");
        m.setModeloDeLaudo(mdl);
        procMed.addModelo(m);
        return procMed;
    }

    private List<ProcDaTabela> getInitProcDaTabela ()
    {
        List<TabelaDeProcedimentos> tabelas = getDaoTabelaDeProcedimentos().listar();
        if (tabelas == null || tabelas.isEmpty())
        {
            return null;
        }
        List<ProcDaTabela> result = new ArrayList<>();
        for (int i = 0; i < tabelas.size(); i++)
        {
            ProcDaTabela p = new ProcDaTabela();
            p.setTabelaDeProcedimentos(tabelas.get(i));
            p.setValorPaciente(0f);
            p.setValorNoConvenio(new ValorFixo(0f));
            result.add(p);
        }
        return result;
    }

    private DaoTabelaDeProcedimentos getDaoTabelaDeProcedimentos ()
    {
        if (daoTabelaDeProcedimentos == null)
        {
            daoTabelaDeProcedimentos = new DaoTabelaDeProcedimentos();
        }
        return daoTabelaDeProcedimentos;
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("nome", new ValidadorDeUnicidade(
                "O nome escolhido jรก foi cadastrado para outro procedimento!",
                new ValidadorAuxiliarDeUnicidade()
                {
                    @Override
                    public boolean validar (int codigo, String nome)
                    {
                        return dao.validarUnicidadeDeNome(codigo, nome);
                    }

                }));
    }

    public boolean alterar ()
    {
        return c_CadastroDeProcMedico.alterar();
    }

    public void setC_CadastroDeProcMedico (C_CadastroProcMedico c_CadastroDeProcMedico)
    {
        this.c_CadastroDeProcMedico = c_CadastroDeProcMedico;
    }

    public DaoModeloDeLaudo getDaoMdl ()
    {
        if (daoMdl == null)
        {
            daoMdl = new DaoModeloDeLaudo();
        }
        return daoMdl;
    }

    public List<ModeloDeLaudo> getModelosPlanilhados ()
    {
        return getDaoMdl().listarModelosPlanilhados();
    }

}
