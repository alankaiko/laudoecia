/*
 * DlgBackup.java
 *
 * Created on 13/09/2012, 09:01:36
 */

package com.ic.projects.laudoecia.view.backup;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaBackup;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroBackup;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeBackup;
import com.ic.projects.laudoecia.view.cadastro.PnlBackup;
import com.lib.icontrol.crud.busca.DefC_ParamsBusca;
import com.lib.icontrol.crud.busca.DefC_ResultadosDaBusca;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.CrudConfigurator;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.TableConfigurator;
import java.util.Date;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
class DlgBackup extends MyJDialog
{

    private static DlgBackup instance;

    private DlgBackup ()
    {
        super(null, true, 656, 323);
        setTitle("Backup do sistema");
        SimplePnlCadastro pc = new SimplePnlCadastro(new CrudConfigurator() {

            @Override
            public boolean permiteAdicionar ()
            {
                return true;
            }

            @Override
            public boolean permiteAlterar ()
            {
                return true;
            }

            @Override
            public boolean permiteApagar ()
            {
                return true;
            }

            @Override
            public int selBtn ()
            {
                return TBarCRUD.BTN_ADICIONAR;
            }

        }
                , true, true, SimpleC_Cadastro.VIEW_BUSCA);

        PnlBackup pnlBackup = new PnlBackup();
        pc.setContainerEntidade(pnlBackup);

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {
            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, false, false, true, true
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Data Marcada", "Tipo do Backup", "Diretório do Arquivo", "Status"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, Date.class, Object.class, String.class, Object.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            0, 150, 130, 150, 150
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[]
                        {
                            1, 1, 4
                        };
            }

        });
        builder = builder.setTxtBusca(220);
        builder = builder.setCmbCampos(110, "data marcada", "status");
        builder = builder.setCmbNumResultados(0);

        builder.getTxtBusca().setLargura(1.5d);
        builder.getScroll().setCellRenderer(1, new MyDateRenderer(Constantes.TIMESTAMP));
        builder.getScroll().removeColumn(0);
        builder.getScroll().setSelecionarPrimeiroPorPadrao(false);

        C_BuscaBackup c = new C_BuscaBackup(
                new DefC_ParamsBusca(builder.getPnlBusca()),
                new DefC_ResultadosDaBusca(builder.getPnlBusca()));

        pc.setPnlBusca(builder);

        builder.getPnlBusca().setC_Busca(c);
        pc.setControlador(new C_CadastroBackup(
                pc, c, new C_EntidadeBackup(pnlBackup)));
        builder.getPnlBusca().parametroDeBuscaChanged();

        pc.getTbarCrud().requestFocusInWindow(TBarCRUD.BTN_ADICIONAR);

        setContentPane(pc);

    }

    private static DlgBackup getInstance ()
    {
        if (instance == null)
        {
            instance = new DlgBackup();
        }
        return instance;
    }

    static void setState (boolean on)
    {
        if (instance == null && !on)
        {
        }
        else
        {
            getInstance().setVisible(on);
        }
    }

    @Override
    public void fechar ()
    {
        setVisible(false);
    }

}
