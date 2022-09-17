/*
 * C_ImpressaoAtendimento.java
 *
 * Created on 22/05/2012, 14:26:13
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.iview.crud.ViewResultadosDaBusca;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_ImpressaoAtendimento implements C_Impressao
{
    private DaoAtendimento dao;
    private ViewResultadosDaBusca view;

    public C_ImpressaoAtendimento (ViewResultadosDaBusca view)
    {
        this.view = view;
    }

    @Override
    public void imprimir ()
    {
        Object[] selectedResult = view.getSelectedResult();
        if (selectedResult != null)
        {
            Atendimento atd = getDao().procurarPorId((Integer) selectedResult[0]);
            LaudoeCia.getTelaPrincipal().mostrarComprovanteAtd(atd);
        }
    }

    private DaoAtendimento getDao ()
    {
        if (dao == null)
        {
            dao = new DaoAtendimento();
        }
        return dao;
    }

}
