/*
 * DlgCep.java
 *
 * Created on 26/09/2012, 15:28:25
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.basededados.C_BuscaCEP;
import com.ic.projects.laudoecia.view.basededados.PnlCEP;
import com.ic.projects.laudoecia.view.pnl.PnlBuscaCep;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.plus.renderers.MyCEPRenderer;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgCep extends DlgCadastro
{

    public DlgCep (Component cp)
    {
        super(cp, true, 719, 381);
        setTitle("Base de dados de CEP");

        pnlCadastro = new SimplePnlCadastro(false);

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

        setContentPane(pnlCadastro);

    }

}
