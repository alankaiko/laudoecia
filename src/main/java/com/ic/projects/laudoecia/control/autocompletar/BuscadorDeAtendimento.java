/*
 * BuscadorDeAtendimento.java
 *
 * Created on 21/05/2012, 08:56:24
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.lib.icontrol.autocompletar.AbsC_AutoCompletar;
import com.lib.iview.autocompletar.AcTableConfigurator;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.utils.Constantes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeAtendimento extends AbsC_AutoCompletar<Atendimento>
{
    private DaoAtendimento dao;

    @Override
    protected Atendimento getModel (Object[] linha)
    {
        return getDao().procurarPorId((int) linha[0]);
    }

    @Override
    protected Object[] getLinha (Atendimento model)
    {
        return new Object[]
                {
                    model.getCodigo(), model.getPaciente().getNome()
                };
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (textoDaBusca != null && textoDaBusca.matches("[0-9]+"))
        {
            Atendimento atd = getDao().procurarPorId(Integer.valueOf(textoDaBusca));
            List<Object[]> result = new ArrayList<>();
            if (atd != null)
            {
                result.add(new Object[]
                        {
                            atd.getCodigo(), atd.getPaciente(), atd.getDataAtendimento()
                        });
            }
            return result;
        }
        else
        {
            return getDao().buscarPorPaciente(textoDaBusca);
        }
    }

    @Override
    public AcTableConfigurator getPropriedadesDaTabela ()
    {
        return new AcTableConfigurator()
        {

            @Override
            public Map<Integer, TableCellRenderer> getOverridingRenderers ()
            {
                Map<Integer, TableCellRenderer> mapa = super.getOverridingRenderers();
                mapa.put(2, new MyDateRenderer(Constantes.TIMESTAMP_AMPM_OFF));
                return mapa;
            }

            @Override
            public int indexToUseAsTextFieldText ()
            {
                return 1;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Atd", "Paciente", "Data de cadastro"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class, Date.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            55, 0, 140
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
                        };
            }

        };
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
