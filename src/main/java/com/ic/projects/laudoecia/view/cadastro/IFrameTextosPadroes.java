/*
 * IFrameTextosPadroes.java
 *
 * Created on 20/06/2012, 16:11:24
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaTextoPadrao;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroTextoPadrao;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeTextoPadrao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameTextosPadroes extends SimpleIFrameCadastro
{
    public IFrameTextosPadroes ()
    {
        super("Textos pessoais", 662, 344);
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

        pnlCadastro.start(C_BuscaTextoPadrao.class, C_EntidadeTextoPadrao.class,
              PnlTextoPadrao.class, false, C_CadastroTextoPadrao.class);
    }

}
