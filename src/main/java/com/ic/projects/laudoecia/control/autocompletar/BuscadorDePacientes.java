/*
 * BuscadorDePacientes.java
 *
 * Created on 04/04/2012, 08:56:37
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoPaciente;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.lib.icontrol.autocompletar.AbsC_AutoCompletar;
import com.lib.iview.autocompletar.AcTableConfigurator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class BuscadorDePacientes extends AbsC_AutoCompletar<Paciente>
{
    private DaoPaciente dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        List<Object[]> resposta = new ArrayList<>();
        if (textoDaBusca == null)
        {
        }
        else if (textoDaBusca.matches("[0-9]+"))
        {
            Paciente model = getDao().procurarPorId(Integer.valueOf(textoDaBusca));
            if (model != null)
            {
                resposta.add(new Object[]
                        {
                            model.getNome(), model.getDataNascimento(), model.getCodigo()
                        });
            }
        }
        else
        {
            resposta.addAll(getDao().buscarPorNome(textoDaBusca));
        }
        return resposta;
    }

    @Override
    protected Object[] getLinha (Paciente model)
    {
        return new Object[]
                {
                    model.getNome(), model.getDataNascimento(), model.getCodigo()
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
                return 0;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Nome", "Data Nasc.", "Prontuário"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            String.class, Date.class, Integer.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 90, 80
                        };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            true, false, false
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[]
                        {
                            0
                        };
            }

        };
    }

    @Override
    protected Paciente getModel (Object[] linha)
    {
        return getDao().procurarPorId((int) linha[2]);
    }

    private DaoPaciente getDao ()
    {
        if (dao == null)
        {
            dao = new DaoPaciente();
        }
        return dao;
    }

}
