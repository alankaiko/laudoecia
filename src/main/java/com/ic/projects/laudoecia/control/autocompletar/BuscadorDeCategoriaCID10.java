/*
 * BuscadorDeCategoriaCID10.java
 *
 * Created on 09/02/2012, 15:50:54
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.basededados.DaoCategoriaCID10;
import com.ic.projects.laudoecia.model.basededados.CategoriaCID10;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeCategoriaCID10 extends C_AutoCompletarLista<CategoriaCID10>
{
    private DaoCategoriaCID10 dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarNomesQuandoNomeContiver(textoDaBusca));
    }

    @Override
    protected CategoriaCID10 getModel (Object[] linha)
    {
        return getDao().buscarCategoriaPeloNome((String) linha[0]);
    }

    @Override
    protected Object[] getLinha (CategoriaCID10 model)
    {
        return new Object[] { model.getNome() };
    }

    private DaoCategoriaCID10 getDao()
    {
        if (dao == null)
        {
            dao = new DaoCategoriaCID10();
        }
        return dao;
    }

}
