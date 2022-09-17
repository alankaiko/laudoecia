/*
 * BuscadorDeModeloDeLaudo.java
 *
 * Created on 16/03/2012, 15:38:32
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.laudo.DaoModeloDeLaudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudo;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeModeloDeLaudo extends C_AutoCompletarLista<ModeloDeLaudo>
{
    private DaoModeloDeLaudo dao;

    @Override   
    protected ModeloDeLaudo getModel (Object[] linha)
    {
        return getDao().buscarModeloPeloNome((String) linha[0]);
    }

    @Override
    protected Object[] getLinha (ModeloDeLaudo modelo)
    {
        return new Object[]
                {
                    modelo.getNome()
                };
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarNomesQuandoNomeComecaCom(textoDaBusca));
    }

    private DaoModeloDeLaudo getDao ()
    {
        if (dao == null)
        {
            dao = new DaoModeloDeLaudo();
        }
        return dao;
    }

}
