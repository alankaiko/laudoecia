/*
 * BuscadorDeProcMedico.java
 *
 * Created on 05/03/2012, 09:42:13
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoProcMedico;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import com.lib.iview.autocompletar.AcTableConfigurator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeProcMedico extends C_AutoCompletarLista<ProcMedico>
{
    private DaoProcMedico dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (textoDaBusca != null && textoDaBusca.matches("[0-9]+"))
        {
            ProcMedico pM = getDao().procurarPorId(Integer.valueOf(textoDaBusca));
            List<Object[]> result = new ArrayList<>();
            if (pM != null)
            {
                result.add(new Object[] { pM.getNome(), pM.getCodigo() });
            }
            return result;
        }
        else
        {
            return getDao().buscarCandidatosPorNome(textoDaBusca);
        }
    }

    @Override
    protected ProcMedico getModel (Object[] linha)
    {
        return getDao().procurarPorId((int)linha[1]);
    }

    @Override
    protected Object[] getLinha (ProcMedico procMedico)
    {
        return new Object[] { procMedico.getNome(), procMedico.getCodigo() };
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
                            String.class, Integer.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 75
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 0 };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            true, false
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Nome", "Código"
                        };
            }

            @Override
            public int indexToUseAsTextFieldText ()
            {
                return 0;
            }

        };
    }

    private DaoProcMedico getDao()
    {
        if (dao == null)
        {
            dao = new DaoProcMedico();
        }
        return dao;
    }

}
