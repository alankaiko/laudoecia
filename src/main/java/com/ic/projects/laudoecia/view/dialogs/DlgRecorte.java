/*
 * DlgProcMedico.java
 *
 * Created on 26/09/2012, 14:34:33
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaRecorte;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroRecorte;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeRecorte;
import com.ic.projects.laudoecia.view.cadastro.PnlRecorte;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgRecorte extends DlgCadastro
{

    public DlgRecorte (Component cp)
    {
        super(cp, true, 719, 346);
        setTitle("Recortes de imagem");

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
