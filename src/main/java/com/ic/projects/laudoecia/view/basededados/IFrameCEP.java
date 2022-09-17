/*
 * IFrameCEP.java
 *
 * Created on 24/02/2012, 10:19:33
 */
package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.basededados.C_BuscaCEP;
import com.ic.projects.laudoecia.view.pnl.PnlBuscaCep;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.plus.renderers.MyCEPRenderer;
import com.lib.swing.utils.TableConfigurator;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameCEP extends SimpleIFrameCadastro
{

    public IFrameCEP ()
    {

        super("Base de Dados de CEP", 700, 381);
        setPnlCadastro(new SimplePnlCadastro(false));

        PnlBuscaCep builder = new PnlBuscaCep(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, false, true, true, true, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[] {
                    "", "CEP", "Tipo de Log.", "Logradouro", "Bairro", "Cidade" };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 80, 100, 200, 150, 150
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 3, 4 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { Integer.class,
                     String.class, String.class, String.class, String.class, String.class };
            }

        });
        builder.getScroll().removeColumn(0);
        builder.getScroll().setCellRenderer(0, new MyCEPRenderer());

        pnlCadastro.setPnlBusca(builder);
        pnlCadastro.start(C_BuscaCEP.class, PnlCEP.class);

    }

}
