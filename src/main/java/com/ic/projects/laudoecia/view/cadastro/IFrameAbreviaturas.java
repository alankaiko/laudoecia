/*
 * IFrameAbreviaturas.java
 *
 * Created on 20/06/2012, 16:11:24
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaAbreviatura;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroAbreviatura;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeAbreviatura;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameAbreviaturas extends SimpleIFrameCadastro
{
    public IFrameAbreviaturas ()
    {
        super("Abreviaturas", 662, 344);
        setPnlCadastro(new SimplePnlCadastro());

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
    }

}
