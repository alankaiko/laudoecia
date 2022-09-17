/*
 * IFrameCBHPM.java
 *
 * Created on 17/02/2012, 09:27:35
 */
package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.basededados.C_BuscaCBHPM;
import com.ic.projects.laudoecia.view.renderers.CodigoCBHPMTblRnd;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameCBHPM extends SimpleIFrameCadastro
{

    public IFrameCBHPM ()
    {
        super("CBHPM 5ª edição", 700, 322);
        setPnlCadastro(new SimplePnlCadastro(false));

        DefBuilder builder = new DefBuilder(new TableConfigurator() {

            @Override
            public String[] columnsTitles ()
            {
                return new String[] { "Código", "Procedimento" };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true } ;
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 90, 0 };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 1 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { Integer.class, String.class } ;
            }

        });
        builder = builder.setTxtBusca(255);
        builder = builder.setCmbCampos(115, "procedimento", "código", "subgrupo", "grupo");
        builder = builder.setCmbNumResultados();
        builder.getScroll().setCellRenderer(0, new CodigoCBHPMTblRnd());
        builder.getTxtBusca().setLargura(2.2d);
        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaCBHPM.class, PnlCBHPM.class);

    }

}
