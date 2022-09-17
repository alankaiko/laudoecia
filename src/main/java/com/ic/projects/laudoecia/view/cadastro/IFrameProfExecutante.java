/*
 * IFrameProfExecutante.java
 *
 * Created on 15/03/2012, 10:58:34
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaProfExecutante;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroProfExecutante;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProfExecutante;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoProfExecutante;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.utils.TableConfigurator;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameProfExecutante extends SimpleIFrameCadastro
{
    public IFrameProfExecutante ()
    {
        super("Profissionais executantes", 725, 344);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {
            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true, false, false, false
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome", "Nº no conselho", "Conselho", "UF"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            65, 0, 110, 80, 45
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[]
                        {
                            0
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class, String.class, Object.class, Object.class
                        };
            }

        });
        builder = builder.setTxtBusca(220);
        builder = builder.setCmbCampos(120, "nome", "núm. conselho");
        builder = builder.setCmbNumResultados();

        pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
        new MeuSw(pnlCadastro.getTbarCrud()).execute();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaProfExecutante.class, C_EntidadeProfExecutante.class,
                          PnlProfExecutante.class, false, C_CadastroProfExecutante.class);
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
            return new C_ImpressaoProfExecutante();
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
