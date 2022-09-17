/*
 * C_EntidadeEstacaoDeTrabalho.java
 *
 * Created on 09/04/2012, 11:16:10
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoEstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeEstacaoDeTrabalho extends DefC_EntidadeComCrud<EstacaoDeTrabalho, Integer>
{
    private DaoEstacaoDeTrabalho dao;

    public C_EntidadeEstacaoDeTrabalho (ViewEntidadeComCrud<EstacaoDeTrabalho> view)
    {
        super(new DaoEstacaoDeTrabalho(), view);
        dao = (DaoEstacaoDeTrabalho) getDao();
    }

    @Override
    public EstacaoDeTrabalho criarEntidadeParaAdicionar ()
    {
        EstacaoDeTrabalho e = new EstacaoDeTrabalho();
        e.setCodigo(0);
        return e;
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("nomeEstacaoDeTrabalho", new ValidadorDeUnicidade(
                "O nome escolhido já foi cadastrado para outra estação de trabalho!",
                new ValidadorAuxiliarDeUnicidade() {

                    @Override
                    public boolean validar (int codigo, String nome)
                    {
                        return dao.validarUnicidadeDeNome(codigo, nome);
                    }

                }));
    }

}
