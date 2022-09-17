/*
 * DlgExecutantes.java
 *
 * Created on 26/09/2012, 08:59:56
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaProfExecutante;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroProfExecutante;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProfExecutante;
import com.ic.projects.laudoecia.view.cadastro.PnlProfExecutante;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgExecutantes extends DlgCadastro
{

    public DlgExecutantes (Component cp)
    {
        super(cp, true, 719, 346);
        setTitle("Profissionais executantes");

        pnlCadastro = new SimplePnlCadastro();

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true, false, false, false
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome", "Nº No Conselho", "Conselho", "UF"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            65, 0, 110, 80, 45
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 1 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class, String.class, Object.class, Object.class
                        };
            }

        });
        builder = builder.setTxtBusca(220);
        builder = builder.setCmbCampos(120, "nome", "núm. conselho");
        builder = builder.setCmbNumResultados();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaProfExecutante.class, C_EntidadeProfExecutante.class,
              PnlProfExecutante.class, false, C_CadastroProfExecutante.class);

        setContentPane(pnlCadastro);

    }

}
