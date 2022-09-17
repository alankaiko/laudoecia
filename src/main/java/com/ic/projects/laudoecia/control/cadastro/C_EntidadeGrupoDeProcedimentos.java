/*
 * C_EntidadeGrupoDeProcedimentos.java
 *
 * Created on 14/03/2012, 17:46:25
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoGrupoProcedimento;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeGrupoDeProcedimentos extends DefC_EntidadeComCrud<GrupoProcedimento, Integer>
{
    private DaoGrupoProcedimento dao;

    public C_EntidadeGrupoDeProcedimentos (ViewEntidadeComCrud<GrupoProcedimento> view)
    {
        super(new DaoGrupoProcedimento(), view);
        dao = (DaoGrupoProcedimento) getDao();
    }

    @Override
    public GrupoProcedimento criarEntidadeParaAdicionar ()
    {
        return new GrupoProcedimento(dao.sugerirNovoID());
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("nome", new ValidadorDeUnicidade(
                "O nome escolhido já foi cadastrado para outro grupo de exames!",
                new ValidadorAuxiliarDeUnicidade() {

                    @Override
                    public boolean validar (int codigo, String nome)
                    {
                        return dao.validarUnicidadeDeNome(codigo, nome);
                    }

                }));
    }

}
