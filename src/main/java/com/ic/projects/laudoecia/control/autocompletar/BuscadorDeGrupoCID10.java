/*
 * BuscadorDeGrupoCID10.java
 *
 * Created on 10/02/2012, 09:51:08
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.basededados.DaoGrupoCID10;
import com.ic.projects.laudoecia.model.basededados.GrupoCID10;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeGrupoCID10 extends C_AutoCompletarLista<GrupoCID10>
{
    private DaoGrupoCID10 dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarNomesQuandoNomeConter(textoDaBusca));
    }

    @Override
    protected GrupoCID10 getModel (Object[] linha)
    {
        return getDao().buscarGrupoPeloNome((String) linha[0]);
    }

    @Override
    protected Object[] getLinha (GrupoCID10 model)
    {
        return new Object[] { model.getNome() };
    }

    private DaoGrupoCID10 getDao()
    {
        if (dao == null)
        {
            dao = new DaoGrupoCID10();
        }
        return dao;
    }

}
