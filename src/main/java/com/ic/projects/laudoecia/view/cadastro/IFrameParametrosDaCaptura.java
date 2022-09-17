/*
 * IFrameParametrosDaCaptura.java
 *
 * Created on 25/07/2012, 14:42:34
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaParametrosDaCaptura;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroParametrosDaCaptura;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeParametrosDaCaptura;
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
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameParametrosDaCaptura extends SimpleIFrameCadastro
{
    public IFrameParametrosDaCaptura ()
    {
        super("Parâmetros da Captura", 400, 250);

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

        PnlParametrosDaCaptura pnlPdc = new PnlParametrosDaCaptura();
        pnlCadastro.setContainerEntidade(pnlPdc);

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

        C_BuscaParametrosDaCaptura c = new C_BuscaParametrosDaCaptura(
                new DefC_ParamsBusca(builder.getPnlBusca()) ,
                new DefC_ResultadosDaBusca(builder.getPnlBusca()));
        pnlCadastro.setPnlBusca(builder);

        builder.getPnlBusca().setC_Busca(c);
        pnlCadastro.setControlador(new C_CadastroParametrosDaCaptura(pnlCadastro,
                c, new C_EntidadeParametrosDaCaptura(pnlPdc)));
        builder.getPnlBusca().parametroDeBuscaChanged();

    }

}
