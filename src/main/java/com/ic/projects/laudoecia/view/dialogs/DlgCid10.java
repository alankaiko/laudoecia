/*
 * DlgCid10.java
 *
 * Created on 26/09/2012, 08:59:49
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.basededados.C_BuscaCID10;
import com.ic.projects.laudoecia.view.basededados.PnlCID10;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgCid10 extends DlgCadastro
{

    public DlgCid10 (Component cp)
    {
        super(cp, true, 700, 367);
        setTitle("CID10");

        pnlCadastro = new SimplePnlCadastro(false);

        DefBuilder builder = new DefBuilder(new TableConfigurator() {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[] { "Código", "Nome" };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 75, 0 };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 1 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { String.class, String.class } ;
            }

        });
        builder = builder.setTxtBusca(240);
        builder = builder.setCmbCampos(130, "nome", "código", "categoria",
                          "grupo", "assunto / capitulo").setCmbNumResultados();
        pnlCadastro.setPnlBusca(builder);
        builder.getTxtBusca().setLargura(2.2d);

        pnlCadastro.start(C_BuscaCID10.class, PnlCID10.class);

        setContentPane(pnlCadastro);

    }

}
