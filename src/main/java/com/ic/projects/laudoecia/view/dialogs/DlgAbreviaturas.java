/*
 * DlgAbreviaturas.java
 *
 * Created on 02/05/2014, 15:27:05
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaAbreviatura;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroAbreviatura;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeAbreviatura;
import com.ic.projects.laudoecia.view.cadastro.PnlAbreviatura;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgAbreviaturas extends DlgCadastro
{

    public DlgAbreviaturas (Component cp)
    {
        super(cp, true, 719, 344);
        setTitle("Abreviaturas");

        pnlCadastro = new SimplePnlCadastro();

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Abreviatura"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            65, 0
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 0 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class
                        };
            }

        });
        builder = builder.setTxtBusca(220);
        builder = builder.setCmbCampos(100, "abreviatura", "código");
        builder = builder.setCmbNumResultados(6);

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaAbreviatura.class, C_EntidadeAbreviatura.class,
              PnlAbreviatura.class, false, C_CadastroAbreviatura.class);

        setContentPane(pnlCadastro);
    }

}
