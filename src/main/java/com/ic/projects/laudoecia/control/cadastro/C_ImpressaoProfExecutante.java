/*
 * C_ImpressaoAtendimento.java
 *
 * Created on 22/05/2012, 14:26:13
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.auditable.DaoProfExecutante;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_ImpressaoProfExecutante implements C_Impressao
{
    private DaoProfExecutante dao;

    @Override
    public void imprimir ()
    {
        LaudoeCia.getTelaPrincipal().mostrarTela(TelaPrincipal.REL_PROF_EXEC, null);
    }

    public List<ProfExecutante> getLista (UF uf, TISS_Conselho conselho)
    {
        return getDao().getToRelatorio(uf, conselho);
    }

    public DaoProfExecutante getDao ()
    {
        if (dao == null)
        {
            dao = new DaoProfExecutante();
        }
        return dao;
    }
}
