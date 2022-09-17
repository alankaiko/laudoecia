/*
 * IFrameCRM.java
 *
 * Created on 10/02/2012, 15:42:44
 */

package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.basededados.C_BuscaCrm;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.view.pnl.DefBuilderComUF;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameCRM extends SimpleIFrameCadastro
{

    public IFrameCRM ()
    {
        super("Base de dados de médicos - CRM", 750, 300);
        setPnlCadastro(new SimplePnlCadastro(false));

        DefBuilderComUF builder = new DefBuilderComUF(new TableConfigurator()
        {
            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, false, false, true
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "", "UF", "Crm", "Nome"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 60, 80, 0
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 3 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, UF.class, String.class, String.class
                        };
            }

        });
        builder.getScroll().removeColumn(0);
        builder = builder.setTxtBusca(240).setCmbCampos(75, "nome", "crm");
        builder = builder.withUF().setCmbNumResultados();
        builder.getLblBuscarPor().setText("Buscar por Dr(a)");

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaCrm.class, PnlCrm.class);

    }

}
