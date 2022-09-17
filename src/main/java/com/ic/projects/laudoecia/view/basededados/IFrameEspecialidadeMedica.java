/*
 * IFrameEspecialidadeMedica.java
 *
 * Created on 10/02/2012, 11:15:41
 */
package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.basededados.C_BuscaEspecialidadeMedica;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameEspecialidadeMedica extends SimpleIFrameCadastro
{

    public IFrameEspecialidadeMedica ()
    {
        super("Especialidades médicas", 600, 366);
        setPnlCadastro(new SimplePnlCadastro(false, false, null));

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {
            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            75, 0
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
                            Integer.class, String.class
                        };
            }

        });
        builder = builder.setTxtBusca(300).setCmbCampos(130, "nome", "código");

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaEspecialidadeMedica.class);

    }

}
