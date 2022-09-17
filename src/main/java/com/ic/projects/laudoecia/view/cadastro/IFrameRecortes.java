/*
 * IFrameRecortes.java
 *
 * Created on 13/01/2012, 15:41:22
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaRecorte;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroRecorte;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeRecorte;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class IFrameRecortes extends SimpleIFrameCadastro
{

    public IFrameRecortes ()
    {
        super("Recortes de imagem", 662, 334);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator() {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[] { "Código", "Descrição" };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 65, 0} ;
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
        builder = builder.setTxtBusca(360);
        builder = builder.setCmbCampos(130, "descrição");

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaRecorte.class, C_EntidadeRecorte.class,
                                    PnlRecorte.class, C_CadastroRecorte.class);

    }

}
