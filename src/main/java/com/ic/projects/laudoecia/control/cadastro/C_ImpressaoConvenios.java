/*
 * C_ImpressaoAtendimento.java
 *
 * Created on 22/05/2012, 14:26:13
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.auditable.DaoConvenio;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_ImpressaoConvenios implements C_Impressao
{
    private DaoConvenio dao;

    @Override
    public void imprimir ()
    {
        LaudoeCia.getTelaPrincipal().mostrarTela(TelaPrincipal.REL_CONVENIOS, null);
    }

    public List<Convenio> getLista (Boolean ativo)
    {
        return getDao().getToRelatorio(ativo);
    }

    public DaoConvenio getDao ()
    {
        if (dao == null)
        {
            dao = new DaoConvenio();
        }
        return dao;
    }
}
