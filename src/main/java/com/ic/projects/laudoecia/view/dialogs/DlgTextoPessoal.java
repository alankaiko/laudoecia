/*
 * DlgTextoPessoal.java
 *
 * Created on 05/05/2014, 10:39:56
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaTextoPadrao;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroTextoPadrao;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeTextoPadrao;
import com.ic.projects.laudoecia.view.cadastro.PnlTextoPadrao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgTextoPessoal extends DlgCadastro
{

    public DlgTextoPessoal (Component cp)
    {
        super(cp, true, 719, 344);
        setTitle("Textos pessoais");

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
        builder = builder.setCmbNumResultados();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaTextoPadrao.class, C_EntidadeTextoPadrao.class,
              PnlTextoPadrao.class, false, C_CadastroTextoPadrao.class);

        setContentPane(pnlCadastro);

    }

}
