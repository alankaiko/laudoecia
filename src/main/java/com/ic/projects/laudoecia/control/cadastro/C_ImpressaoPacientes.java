/*
 * C_ImpressaoAtendimento.java
 *
 * Created on 22/05/2012, 14:26:13
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.auditable.DaoPaciente;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_ImpressaoPacientes implements C_Impressao
{
    private DaoPaciente dao;

    @Override
    public void imprimir ()
    {
        LaudoeCia.getTelaPrincipal().mostrarTela(TelaPrincipal.REL_PACIENTES, null);
    }

    public List<Paciente> getLista (Date dtNascDe, Date dtNascAte, UF uf, String cidade, Date dtCadDe, Date dtCadAte)
    {
        return getDao().getToRelatorio(dtNascDe, dtNascAte, uf, cidade, dtCadDe, dtCadAte);
    }

    public DaoPaciente getDao ()
    {
        if (dao == null)
        {
            dao = new DaoPaciente();
        }
        return dao;
    }
}
