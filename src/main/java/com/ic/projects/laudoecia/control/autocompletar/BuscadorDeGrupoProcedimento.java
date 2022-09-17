/*
 * BuscadorDeGrupoProcedimento.java
 *
 * Created on 14/02/2012, 11:20:51
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoGrupoProcedimento;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeGrupoProcedimento extends C_AutoCompletarLista<GrupoProcedimento>
{
    private DaoGrupoProcedimento dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarNomesQuandoNomeComecaCom(textoDaBusca));
    }

    @Override
    protected GrupoProcedimento getModel (Object[] linha)
    {
        return getDao().buscarGrupoPeloNome ( (String) linha[0] );
    }

    @Override
    protected Object[] getLinha (GrupoProcedimento grupo)
    {
        return new Object[] { grupo.getNome() };
    }

    private DaoGrupoProcedimento getDao()
    {
        if (dao == null)
        {
            dao = new DaoGrupoProcedimento();
        }
        return dao;
    }

}
