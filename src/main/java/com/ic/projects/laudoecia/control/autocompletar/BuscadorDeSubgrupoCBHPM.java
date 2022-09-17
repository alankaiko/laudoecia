/*
 * BuscadorDeSubgrupoCBHPM.java
 *
 * Created on 17/02/2012, 10:12:45
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.basededados.DaoSubgrupoCBHPM;
import com.ic.projects.laudoecia.model.basededados.SubgrupoCBHPM;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeSubgrupoCBHPM extends C_AutoCompletarLista<SubgrupoCBHPM>
{
    private DaoSubgrupoCBHPM dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                    getDao().buscarSubGruposQuandoSubgrupoContiver(textoDaBusca));
    }

    @Override
    protected SubgrupoCBHPM getModel (Object[] linha)
    {
        return getDao().buscarSubgrupoPeloNome( (String) linha[0]);
    }

    @Override
    protected Object[] getLinha (SubgrupoCBHPM model)
    {
        return new Object[] { model.getSubgrupo() };
    }

    private DaoSubgrupoCBHPM getDao()
    {
        if (dao == null)
        {
            dao = new DaoSubgrupoCBHPM();
        }
        return dao;
    }

}
