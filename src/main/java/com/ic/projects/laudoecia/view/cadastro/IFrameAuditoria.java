/*
 * IFrameAuditoria.java
 *
 * Created on 05/03/2012, 10:55:07
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaAuditoria;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoAuditoria;
import com.ic.projects.laudoecia.view.pnl.PnlBuscaAuditoria;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.iview.crud.ViewResultadosDaBusca;
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
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class IFrameAuditoria extends SimpleIFrameCadastro
{

    public IFrameAuditoria ()
    {
        super("Auditoria do banco de dados", 755, 442);
        setPnlCadastro(new SimplePnlCadastro(false));

        PnlBuscaAuditoria builder = new PnlBuscaAuditoria(new TableConfigurator() {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, false, false, true, false
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Ação", "Rotina", "Registro", "Data"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, Object.class, String.class, String.class, Date.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 75, 175, 0, 150
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 4 };
            }

        });
        builder.getScroll().removeColumn (0);
        builder.getScroll().setHeaderAlignment(3, SwingConstants.CENTER);
        builder.getScroll().setCellRenderer(3, new MyDateRenderer(
                Constantes.TIMESTAMP, SwingConstants.CENTER));

        pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
        new MeuSw(builder.getScroll(), pnlCadastro.getTbarCrud()).execute();

        pnlCadastro.setPnlBusca(builder);
        pnlCadastro.start(C_BuscaAuditoria.class, PnlAuditoria.class);

    }

    private class MeuSw extends SwingWorker<C_Impressao, Void>
    {

        private ViewResultadosDaBusca view;
        private TBarCRUD tbarCrud;

        private MeuSw (ViewResultadosDaBusca view, TBarCRUD tbarCrud)
        {
            this.view = view;
            this.tbarCrud = tbarCrud;
        }

        @Override
        protected C_Impressao doInBackground () throws Exception
        {
            return new C_ImpressaoAuditoria(view);
        }

        @Override
        protected void done ()
        {
            try
            {
                tbarCrud.setC_Impressao(get());
            }
            catch (InterruptedException | ExecutionException e)
            {
            }
        }

    }

}
