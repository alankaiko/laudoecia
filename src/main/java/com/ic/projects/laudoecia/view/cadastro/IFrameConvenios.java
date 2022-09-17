/*
 * IFrameConvenios.java
 *
 * Created on 15/03/2012, 09:08:35
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaConvenio;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroConvenio;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeConvenio;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoConvenios;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.plus.renderers.MyBooleanRenderer;
import com.lib.swing.plus.renderers.MyTelefoneRenderer;
import com.lib.swing.utils.TableConfigurator;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameConvenios extends SimpleIFrameCadastro
{

    public IFrameConvenios ()
    {
        super("Convênios", 788, 344);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true, false, false } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome", "Telefone", "Ativo"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class, String.class, Boolean.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            75, 0, 100, 60
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 0 };
            }

        });
        builder = builder.setTxtBusca(380);
        builder = builder.setCmbCampos(110, "nome", "código");

        builder.getScroll().setHeaderAlignment(3, SwingConstants.CENTER);
        builder.getScroll().setCellRenderer(2, new MyTelefoneRenderer());
        builder.getScroll().setCellRenderer(3, new MyBooleanRenderer());

        pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
        new MeuSw(pnlCadastro.getTbarCrud()).execute();

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaConvenio.class, C_EntidadeConvenio.class,
              PnlConvenio.class, false, C_CadastroConvenio.class);
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
            return new C_ImpressaoConvenios();
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
