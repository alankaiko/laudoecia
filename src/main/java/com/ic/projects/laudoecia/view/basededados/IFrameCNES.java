/*
 * IFrameCNES.java
 *
 * Created on 23/02/2012, 08:51:45
 */
package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.basededados.C_BuscaCNES;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.view.pnl.DefBuilderComUF;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameCNES extends SimpleIFrameCadastro
{

    public IFrameCNES ()
    {
        super("Cadastro Nacional de Estabelecimentos de Saúde - CNES", 700, 322);
        setPnlCadastro(new SimplePnlCadastro(false));

        DefBuilderComUF builder = new DefBuilderComUF(new TableConfigurator() {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, false, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[] {"CNES", "UF", "Razão social"};
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 75, 50, 0 } ;
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 2 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { String.class, UF.class, String.class } ;
            }

        });
        builder = builder.setTxtBusca(185);
        builder = builder.setCmbCampos(115, "nome fantasia", "razão social",
                     "cnes", "cnpj", "cpf").withUF().setCmbNumResultados();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaCNES.class, PnlCNES.class);

    }

}
