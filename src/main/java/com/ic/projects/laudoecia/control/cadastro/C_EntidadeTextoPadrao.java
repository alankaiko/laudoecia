/*
 * C_EntidadeTextoPadrao.java
 *
 * Created on 20/06/2012, 16:29:47
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoTextoPadrao;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeTextoPadrao extends DefC_EntidadeComCrud<TextoPadrao, Integer>
{
    private DaoTextoPadrao dao;

    public C_EntidadeTextoPadrao (ViewEntidadeComCrud<TextoPadrao> view)
    {
        super(new DaoTextoPadrao(), view);
        dao = (DaoTextoPadrao) getDao();
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
    public TextoPadrao criarEntidadeParaAdicionar ()
    {
        TextoPadrao texto = new TextoPadrao();
        texto.setCodigo(dao.sugerirNovoID());
        return texto;
    }

}
