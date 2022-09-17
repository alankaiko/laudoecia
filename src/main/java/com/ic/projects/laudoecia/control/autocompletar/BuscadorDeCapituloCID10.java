/*
 * BuscadorDeCapituloCID10.java
 *
 * Created on 10/02/2012, 10:09:27
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.basededados.DaoCapituloCID10;
import com.ic.projects.laudoecia.model.basededados.CapituloCID10;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeCapituloCID10 extends C_AutoCompletarLista<CapituloCID10>
{
    private DaoCapituloCID10 dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarNomesQuandoNomeContiver(textoDaBusca));
    }

    @Override
    protected CapituloCID10 getModel (Object[] linha)
    {
        return getDao().buscarCapituloPeloNome((String) linha[0]);
    }

    @Override
    protected Object[] getLinha (CapituloCID10 model)
    {
        return new Object[] { model.getNome() };
    }

    private DaoCapituloCID10 getDao()
    {
        if (dao == null)
        {
            dao = new DaoCapituloCID10();
        }
        return dao;
    }

}
