/*
 * BuscadorDeGrupoCBHPM.java
 *
 * Created on 17/02/2012, 10:12:29
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.basededados.DaoGrupoCBHPM;
import com.ic.projects.laudoecia.model.basededados.GrupoCBHPM;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeGrupoCBHPM extends C_AutoCompletarLista<GrupoCBHPM>
{
    private DaoGrupoCBHPM dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarGruposQuandoGrupoContiver(textoDaBusca));
    }

    @Override
    protected GrupoCBHPM getModel (Object[] linha)
    {
        return getDao().buscarGrupoPeloNome( (String) linha[0]);
    }

    @Override
    protected Object[] getLinha (GrupoCBHPM model)
    {
        return new Object[] { model.getGrupo() };
    }

    private DaoGrupoCBHPM getDao()
    {
        if (dao == null)
        {
            dao = new DaoGrupoCBHPM();
        }
        return dao;
    }

}
