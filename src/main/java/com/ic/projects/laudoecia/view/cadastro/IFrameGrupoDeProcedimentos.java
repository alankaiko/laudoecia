/*
 * IFrameGrupoDeProcedimentos.java
 *
 * Created on 14/03/2012, 17:20:32
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaGrupoDeProcedimentos;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroGrupoDeProcedimentos;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeGrupoDeProcedimentos;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameGrupoDeProcedimentos extends SimpleIFrameCadastro
{

    public IFrameGrupoDeProcedimentos ()
    {
        super("Grupos de exames e procedimentos médicos", 725, 300);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Código", "Nome"
                        };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Integer.class, String.class
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            65, 0
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
        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaGrupoDeProcedimentos.class, C_EntidadeGrupoDeProcedimentos.class,
              PnlGrupoDeProcedimentos.class, C_CadastroGrupoDeProcedimentos.class);
    }

}
