/*
 * BuscadorCID10.java
 *
 * Created on 10/07/2012, 10:14:13
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.basededados.DaoCID10;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.lib.icontrol.autocompletar.AbsC_AutoCompletar;
import com.lib.iview.autocompletar.AcTableConfigurator;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class BuscadorCID10 extends AbsC_AutoCompletar<SubcategoriaCID10>
{

    private static DaoCID10 dao;

    @Override
    public List<Object[]> buscarCandidatos (String busca)
    {
        return getDao().buscarPorNomeOuCodigo(busca);
    }

    @Override
    protected Object[] getLinha (SubcategoriaCID10 model)
    {
        return new Object[]
                {
                    model.getCodigo(), model.getNome(),
                    model.getNome50()
                };
    }

    @Override
    public AcTableConfigurator getPropriedadesDaTabela ()
    {
        return new AcTableConfigurator()
        {
            @Override
            public int indexToUseAsTextFieldText ()
            {
                return 2;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "CID10", "Descrição", null
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            String.class, String.class, String.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            60, 0, 0
                        };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true, false
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[]
                        {
                            1
                        };
            }

        };
    }

    @Override
    protected SubcategoriaCID10 getModel (Object[] linha)
    {
        return getDao().procurarPorId((String) linha[0]);
    }

    private static DaoCID10 getDao ()
    {
        if (dao == null)
        {
            dao = new DaoCID10();
        }
        return dao;
    }

}
