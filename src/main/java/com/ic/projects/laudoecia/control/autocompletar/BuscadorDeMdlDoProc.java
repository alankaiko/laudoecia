/*
 * BuscadorDeMdlDoProc.java
 *
 * Created on 28/06/2012, 10:31:12
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.laudo.DaoMdlDoProcedimento;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class BuscadorDeMdlDoProc extends C_AutoCompletarLista<ModeloDeLaudoDoProc>
{

    private ProcMedico procMedico;
    private DaoMdlDoProcedimento dao;

    public void setModel (ProcMedico procMedico, ModeloDeLaudoDoProc selModel)
    {
        if (Objects.equals(this.procMedico, procMedico))
        {
        }
        else
        {
            this.procMedico = procMedico;
        }
        setSelectedModel(selModel);
    }

    @Override
    protected ModeloDeLaudoDoProc getModel (Object[] linha)
    {
        return (ModeloDeLaudoDoProc) linha[0];
    }

    @Override
    protected Object[] getLinha (ModeloDeLaudoDoProc model)
    {
        return new Object[] { model };
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        List<ModeloDeLaudoDoProc> modelosFiltrados;
        if (textoDaBusca == null || textoDaBusca.isEmpty() ||
                (modelosFiltrados =
                 getDao().buscarModelos(procMedico, textoDaBusca)).isEmpty())
        {
            return AutoCompletarUtils.converterLista(
                    getDao().buscarModelos(procMedico));
        }
        else
        {
            return AutoCompletarUtils.converterLista(modelosFiltrados);
        }
    }

    private DaoMdlDoProcedimento getDao ()
    {
        if (dao == null)
        {
            dao = new DaoMdlDoProcedimento();
        }
        return dao;
    }

}
