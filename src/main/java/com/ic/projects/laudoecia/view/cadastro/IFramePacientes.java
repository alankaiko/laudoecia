/*
 * IFramePacientes.java
 *
 * Created on 08/03/2012, 11:02:32
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaPaciente;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroPaciente;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadePaciente;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoPacientes;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.TableConfigurator;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFramePacientes extends SimpleIFrameCadastro
{

    public IFramePacientes ()
    {
        super("Pacientes", 788, 344);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {
            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true, false, false
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Prontuário", "Nome", "Nascimento", "Data de cadastro"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            85, 0, 90, 150
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
                            Integer.class, String.class, Date.class, Date.class
                        };
            }

        });

        builder = builder.setTxtBusca(212);
        builder = builder.setCmbCampos(125, "nome", "prontuário", "data nascimento", "data cadastro");
        builder = builder.setCmbNumResultados();
        builder.getScroll().setHeaderAlignment(2, SwingConstants.CENTER);
        builder.getScroll().setHeaderAlignment(3, SwingConstants.CENTER);
        builder.getScroll().setCellRenderer(2, new MyDateRenderer(
                Constantes.DATE_ONLY, SwingConstants.CENTER));
        builder.getScroll().setCellRenderer(3, new MyDateRenderer(
                Constantes.TIMESTAMP, SwingConstants.CENTER));

        pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
        new MeuSw(pnlCadastro.getTbarCrud()).execute();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaPaciente.class, C_EntidadePaciente.class,
              PnlPaciente.class, false, C_CadastroPaciente.class);

    }

    private class MeuSw extends SwingWorker<C_Impressao, Void>
    {
        private TBarCRUD tbarCrud;

        private MeuSw (TBarCRUD tbarCrud)
        {
            this.tbarCrud = tbarCrud;
        }

        @Override
        protected C_Impressao doInBackground () throws Exception
        {
            return new C_ImpressaoPacientes();
        }

        @Override
        protected void done ()
        {
            try
            {
                tbarCrud.setC_Impressao(get());
            }
            catch (InterruptedException | ExecutionException ex)
            {
            }
        }

    }

}
