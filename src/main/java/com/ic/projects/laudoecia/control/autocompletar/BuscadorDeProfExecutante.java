/*
 * BuscadorDeProfExecutante.java
 *
 * Created on 02/03/2012, 16:46:50
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoProfExecutante;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.lib.icontrol.autocompletar.AbsC_AutoCompletar;
import com.lib.iview.autocompletar.AcTableConfigurator;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeProfExecutante extends AbsC_AutoCompletar<ProfExecutante>
{

    private static DaoProfExecutante dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return getDao().buscarPorNomeCodigoOuNumConselho(textoDaBusca);
    }

    @Override
    protected ProfExecutante getModel (Object[] linha)
    {
        return getDao().procurarPorId((int)linha[1]);
    }

    @Override
    protected Object[] getLinha (ProfExecutante model)
    {
        return new Object[] { model.getNome(), model.getCodigo() };
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

    private static DaoProfExecutante getDao()
    {
        if (dao == null)
        {
            dao = new DaoProfExecutante();
        }
        return dao;
    }

}
