/*
 * DlgProcMedico.java
 *
 * Created on 26/09/2012, 14:34:33
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaProcMedico;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroProcMedico;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProcMedico;
import com.ic.projects.laudoecia.view.cadastro.PnlProcMedico;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgProcMedico extends DlgCadastro
{

    public DlgProcMedico (Component cp)
    {
        super(cp, true, 719, 346);
        setTitle("Exames e Procedimentos Médicos");

        pnlCadastro = new SimplePnlCadastro();

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome Procedimento", "Grupo"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            65, 120, 0
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 1, 2 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class, Object.class
                        };
            }

        });
        builder = builder.setTxtBusca(260);
        builder = builder.setCmbCampos(80, "nome", "grupo", "código");
        builder = builder.setCmbNumResultados();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaProcMedico.class, C_EntidadeProcMedico.class,
              PnlProcMedico.class, false, C_CadastroProcMedico.class);

        setContentPane(pnlCadastro);

    }

}
