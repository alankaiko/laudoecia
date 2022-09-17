/*
 * BuscadorDeTextoPadrao.java
 *
 * Created on 11/07/2012, 11:53:13
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoTextoPadrao;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeTextoPadrao extends C_AutoCompletarLista<TextoPadrao>
{
    private DaoTextoPadrao dao;
    private ProcMedico procMedico;

    public void setProcMedico (ProcMedico procMedico)
    {
        this.procMedico = procMedico;
    }

    @Override
    protected TextoPadrao getModel (Object[] linha)
    {
        return getDao().buscarTextoPelaAbrev((String) linha[0]);
    }

    @Override
    protected Object[] getLinha (TextoPadrao model)
    {
        return new Object[]
                {
                    model.getAbreviatura()
                };
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (procMedico == null)
        {
            return AutoCompletarUtils.converterLista(
                getDao().buscarAbrevSemProcMedQueContenha(textoDaBusca));
        }
        return AutoCompletarUtils.converterLista(
                getDao().buscarAbrevQueContenhaTextoEProcMed(textoDaBusca, procMedico));

    }

    private DaoTextoPadrao getDao ()
    {
        if (dao == null)
        {
            dao = new DaoTextoPadrao();
        }
        return dao;
    }

    public boolean selecionar (String text)
    {
        TextoPadrao tp = getDao().buscarTextoPelaAbrev(text);
        if (tp == null)
        {
            return false;
        }
        setSelectedModel(tp);
        return true;
    }

}
