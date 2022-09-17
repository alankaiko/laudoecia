/*
 * C_EntidadeRecorte.java
 *
 * Created on 20/06/2012, 16:29:47
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.cadastro.DaoRecorte;
import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeRecorte extends DefC_EntidadeComCrud<Recorte, Integer>
{
    private DaoRecorte dao;

    public C_EntidadeRecorte (ViewEntidadeComCrud<Recorte> view)
    {
        super(new DaoRecorte(), view);
        dao = (DaoRecorte) getDao();
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("descrição", new ValidadorDeUnicidade(
                "A descrição escolhida ja foi utilizada em outro recorte!",
                new ValidadorAuxiliarDeUnicidade()
                {
                    @Override
                    public boolean validar (int codigo, String abrev)
                    {
                        return dao.validarUnicidadeDeDesc(codigo, abrev);
                    }

                }));
    }

    @Override
    public Recorte criarEntidadeParaAdicionar ()
    {
        Recorte texto = new Recorte();
        return texto;
    }

}
