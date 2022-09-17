/*
 * C_ImpressaoAtendimento.java
 *
 * Created on 22/05/2012, 14:26:13
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.cadastro.DaoProcDaTabela;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_ImpressaoProcMedico implements C_Impressao
{
    private DaoProcDaTabela dao;

    @Override
    public void imprimir ()
    {
        LaudoeCia.getTelaPrincipal().mostrarTela(TelaPrincipal.REL_PROC_MEDICO, null);
    }

    public List<ProcDaTabela> getLista (Convenio conv)
    {
        return getDao().getToRelatorio(conv);
    }

    public DaoProcDaTabela getDao ()
    {
        if (dao == null)
        {
            dao = new DaoProcDaTabela();
        }
        return dao;
    }
}
