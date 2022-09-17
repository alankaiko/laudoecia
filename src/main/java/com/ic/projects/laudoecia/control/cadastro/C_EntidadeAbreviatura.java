/*
 * C_EntidadeAbreviatura.java
 *
 * Created on 20/06/2012, 16:29:47
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.cadastro.DaoAbreviatura;
import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeAbreviatura extends DefC_EntidadeComCrud<Abreviatura, Integer>
{
    private DaoAbreviatura dao;

    public C_EntidadeAbreviatura (ViewEntidadeComCrud<Abreviatura> view)
    {
        super(new DaoAbreviatura(), view);
        dao = (DaoAbreviatura) getDao();
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("abreviatura", new ValidadorDeUnicidade(
                "A abreviatura escolhida ja foi utilizada em outro texto padrão!",
                new ValidadorAuxiliarDeUnicidade()
                {
                    @Override
                    public boolean validar (int codigo, String abrev)
                    {
                        return dao.validarUnicidadeDeAbrev(codigo, abrev);
                    }

                }));
    }

    @Override
    public Abreviatura criarEntidadeParaAdicionar ()
    {
        Abreviatura texto = new Abreviatura();
        texto.setCodigo(dao.sugerirNovoID());
        return texto;
    }

}
