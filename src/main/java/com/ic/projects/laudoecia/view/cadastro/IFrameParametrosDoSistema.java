/*
 * IFrameParametrosDoSistema.java
 *
 * Created on 02/04/2012, 10:51:23
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaParametrosDoSistema;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroParametrosDoSistema;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeParametrosDoSistema;
import com.lib.icontrol.crud.busca.DefC_ParamsBusca;
import com.lib.icontrol.crud.busca.DefC_ResultadosDaBusca;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.CrudConfigurator;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class IFrameParametrosDoSistema extends SimpleIFrameCadastro
{

    public IFrameParametrosDoSistema ()
    {
        super("Parâmetros do sistema", 630, 490);

        setPnlCadastro(new SimplePnlCadastro(
                new CrudConfigurator()
                {
                    @Override
                    public boolean permiteAdicionar ()
                    {
                        return false;
                    }

                    @Override
                    public boolean permiteAlterar ()
                    {
                        return true;
                    }

                    @Override
                    public boolean permiteApagar ()
                    {
                        return false;
                    }

                    @Override
                    public int selBtn ()
                    {
                        return TBarCRUD.BTN_ALTERAR;
                    }

        }, false, false, null));

        PnlParametrosDoSistema ppsd = new PnlParametrosDoSistema();
        pnlCadastro.setContainerEntidade(ppsd, false);

        DefBuilder builder = new DefBuilder(new TableConfigurator() {

            @Override
            public String[] columnsTitles ()
            {
                return new String[] { "Código" } ;
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { Integer.class } ;
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 0 } ;
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[] { true } ;
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 0 } ;
            }

        });
        C_BuscaParametrosDoSistema c = new C_BuscaParametrosDoSistema(
                new DefC_ParamsBusca(builder.getPnlBusca()) ,
                new DefC_ResultadosDaBusca(builder.getPnlBusca()));
        pnlCadastro.setPnlBusca(builder);

        builder.getPnlBusca().setC_Busca(c);
        pnlCadastro.setControlador(new C_CadastroParametrosDoSistema(pnlCadastro,
                c, new C_EntidadeParametrosDoSistema(ppsd)));
        builder.getPnlBusca().parametroDeBuscaChanged();

    }

}
