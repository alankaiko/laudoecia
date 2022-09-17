/*
 * IFrameAtendimentos.java
 *
 * Created on 23/04/2012, 09:03:25
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaAtendimento;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroAtendimento;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeAtendimento;
import com.ic.projects.laudoecia.control.cadastro.C_ImpressaoAtendimento;
import com.ic.projects.laudoecia.view.pnl.PnlBuscaAtendimento;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.iview.crud.ViewResultadosDaBusca;
import com.lib.swing.crud.busca.PnlParamsBusca;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameAtendimentos extends SimpleIFrameCadastro
{

    public IFrameAtendimentos ()
    {
        super("Atendimentos", 725, 492);
        setPnlCadastro(new SimplePnlCadastro());

        PnlBuscaAtendimento builder = new PnlBuscaAtendimento(new TableConfigurator()
        {
            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Paciente", "Convênio", "Data do cadastro"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, Object.class, Object.class, Date.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            75, 100, 0, 150
                        };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true, true, false
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[]
                        {
                            0, 0
                        };
            }

        }, this);
        builder = builder.setTxtBusca(215);
        builder.getTxtBusca().setStrCnfEnabled(false);
        builder = builder.setCmbCampos(120, "código", "paciente", "prof. executante");
        builder = builder.setCmbStatusLaudo(95);
        MyJButton btnAtualizar = new MyJButton("Atualizar");
        btnAtualizar.setFocusable(false);
        btnAtualizar.setBackground(Color.yellow);
        btnAtualizar.setToolTipText("Atualizar tabela (F5)");
        final PnlParamsBusca pnlParamsBusca = builder.getPnlParamsBusca();
        btnAtualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                pnlParamsBusca.parametroDeBuscaChanged();
            }
        });
        builder.getPnlParamsBusca().add(btnAtualizar, null, null);
        builder = builder.addDefaultPanel();
        builder = builder.setCmbData(160).setTxtDataIni(85).
                        setTxtDataFin(85).setCmbNumResultados(5);
        builder.getScroll().setHeaderAlignment(3, SwingConstants.CENTER);
        builder.getScroll().setCellRenderer(3, new MyDateRenderer(
                Constantes.TIMESTAMP, SwingConstants.CENTER));

        pnlCadastro.getTbarCrud().habilitarBtnImprimir(true);
        new MeuSw(builder.getScroll(), pnlCadastro.getTbarCrud()).execute();

        pnlCadastro.setPnlBusca(builder);
        pnlCadastro.start(C_BuscaAtendimento.class, C_EntidadeAtendimento.class,
              PnlAtendimento.class, C_CadastroAtendimento.class);
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
            return new C_ImpressaoAtendimento(view);
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
