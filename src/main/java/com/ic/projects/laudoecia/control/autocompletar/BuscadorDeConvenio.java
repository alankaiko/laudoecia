/*
 * BuscadorDeConvenio.java
 *
 * Created on 02/03/2012, 10:27:14
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoConvenio;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeConvenio extends C_AutoCompletarLista<Convenio>
{
    private DaoConvenio dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (textoDaBusca != null && textoDaBusca.matches("[0-9]+"))
        {
            Convenio c = getDao().procurarPorId(Integer.valueOf(textoDaBusca));
            List<Object[]> result = new ArrayList<>();
            if (c != null && c.isAtivo()) //se nao for ativo nao mostra
            {
                result.add (new Object[] { c.getNome() });
            }
            return result;
        }
        else
        {
            return AutoCompletarUtils.converterLista(
                    getDao().buscarPorNome(textoDaBusca));
        }
    }

    @Override
    protected Convenio getModel (Object[] linha)
    {
        return getDao().procurarPorNome( (String) linha[0]);
    }

    @Override
    protected Object[] getLinha (Convenio model)
    {
        return new Object[] { model.getNome() };
    }

    private DaoConvenio getDao()
    {
        if (dao == null)
        {
            dao = new DaoConvenio();
        }
        return dao;
    }

}
