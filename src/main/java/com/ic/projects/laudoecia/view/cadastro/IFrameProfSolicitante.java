/*
 * IFrameProfSolicitante.java
 *
 * Created on 13/02/2012, 15:07:04
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaProfSolicitante;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroProfSolicitante;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProfSolicitante;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameProfSolicitante extends SimpleIFrameCadastro
{

    public IFrameProfSolicitante ()
    {
        super("Profissionais solicitantes", 725, 300);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator()  {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, false, false, false, true
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "", "UF", "Conselho", "Nº No Conselho", "Nome do profissional"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 45, 75, 110, 0
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 4 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, Object.class, Object.class, String.class, String.class
                        };
            }

        });
        builder = builder.setTxtBusca(220);
        builder = builder.setCmbCampos(120, "nome", "núm. conselho");
        builder = builder.setCmbNumResultados();
        builder.getScroll().removeColumn(0);
        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaProfSolicitante.class, C_EntidadeProfSolicitante.class,
              PnlProfSolicitante.class, C_CadastroProfSolicitante.class);
    }

}
