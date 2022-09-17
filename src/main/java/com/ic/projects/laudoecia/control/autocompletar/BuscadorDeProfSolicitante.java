/*
 * BuscadorDeProfSolicitante.java
 *
 * Created on 05/03/2012, 08:36:21
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoProfSolicitante;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import com.lib.iview.autocompletar.AcTableConfigurator;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeProfSolicitante extends C_AutoCompletarLista<ProfSolicitante>
{

    private DaoProfSolicitante dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return getDao().buscarPorNomeOuNumConselho(textoDaBusca);
    }

    @Override
    protected ProfSolicitante getModel (Object[] linha)
    {
        return getDao().procurarPorTissUfNum(
                (TISS_Conselho) linha[1],
                (UF) linha[2],
                (String) linha[3]);
    }

    @Override
    protected Object[] getLinha (ProfSolicitante model)
    {
        return new Object[] {model.getNome(), model.getConselho(), model.getUfConselho(), model.getNumNoConselho()};
    }

    @Override
    public AcTableConfigurator getPropriedadesDaTabela ()
    {
        return new AcTableConfigurator()
        {
            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            String.class, Object.class, Object.class, String.class
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int [] { 0 };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            true, false, false, false
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Nome", "Conselho", "UF", "Num. Cons."
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 75, 40, 90
                        };
            }

            @Override
            public int indexToUseAsTextFieldText ()
            {
                return 0;
            }

        };
    }

    private DaoProfSolicitante getDao()
    {
        if (dao == null)
        {
            dao = new DaoProfSolicitante();
        }
        return dao;
    }

}
