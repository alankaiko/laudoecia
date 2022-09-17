/*
 * BuscadorDeGrupoDeUsuarios.java
 *
 * Created on 26/01/2012, 17:17:47
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoGrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class BuscadorDeGrupoDeUsuarios extends C_AutoCompletarLista<GrupoDeUsuarios>
{
    private DaoGrupoDeUsuarios dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                getDao().buscarNomesQuandoNomeComecaCom(textoDaBusca));
    }

    @Override
    protected GrupoDeUsuarios getModel (Object[] linha)
    {
        return getDao().buscarGrupoPeloNome( (String) linha[0]);
    }

    @Override
    protected Object[] getLinha (GrupoDeUsuarios grupo)
    {
        return new Object[] { grupo.getNome() };
    }

    private DaoGrupoDeUsuarios getDao()
    {
        if (dao == null)
        {
            dao = new DaoGrupoDeUsuarios();
        }
        return dao;
    }

}
