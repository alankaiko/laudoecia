/*
 * IFrameProcMedico.java
 *
 * Created on 14/02/2012, 10:38:22
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaProcMedico;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroProcMedico;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProcMedico;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoProcMedico;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.utils.TableConfigurator;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameProcMedico extends SimpleIFrameCadastro
{

    public IFrameProcMedico ()
    {
        super("Exames e procedimentos médicos", 788, 344);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome", "Grupo"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            65, 120, 0
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
                            Integer.class, String.class, Object.class
                        };
            }

        });
        builder = builder.setTxtBusca(260);
        builder = builder.setCmbCampos(80, "nome", "grupo", "código");
        builder = builder.setCmbNumResultados(6);

        pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
        new MeuSw(pnlCadastro.getTbarCrud()).execute();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaProcMedico.class, C_EntidadeProcMedico.class,
              PnlProcMedico.class, false, C_CadastroProcMedico.class);
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
            return new C_ImpressaoProcMedico();
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
