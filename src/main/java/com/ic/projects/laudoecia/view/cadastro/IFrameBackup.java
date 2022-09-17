/*
 * IFrameBackup.java
 *
 * Created on 09/04/2012, 16:06:40
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaBackup;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroBackup;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeBackup;
import com.lib.icontrol.crud.busca.DefC_ParamsBusca;
import com.lib.icontrol.crud.busca.DefC_ResultadosDaBusca;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.CrudConfigurator;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.TableConfigurator;
import java.util.Date;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameBackup extends SimpleIFrameCadastro
{
    public IFrameBackup ()
    {
        super("Backup do sistema", 662, 322);
        setPnlCadastro(new SimplePnlCadastro(new CrudConfigurator() {

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
                , true, true, SimpleC_Cadastro.VIEW_BUSCA));

        PnlBackup pnlBackup = new PnlBackup();
        pnlCadastro.setContainerEntidade(pnlBackup);

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
                            "Código", "Data marcada", "Tipo do backup", "Diretório do arquivo", "Status"
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

        pnlCadastro.setPnlBusca(builder);

        builder.getPnlBusca().setC_Busca(c);
        pnlCadastro.setControlador(new C_CadastroBackup(
                pnlCadastro, c, new C_EntidadeBackup(pnlBackup)));
        builder.getPnlBusca().parametroDeBuscaChanged();

    }

}
