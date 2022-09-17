/*
 * IFrameEstacoesDeTrabalho.java
 *
 * Created on 09/04/2012, 10:51:06
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaEstacaoDeTrabalho;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroEstacaoDeTrabalho;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeEstacaoDeTrabalho;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.CrudConfigurator;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class IFrameEstacoesDeTrabalho extends SimpleIFrameCadastro
{
    public IFrameEstacoesDeTrabalho ()
    {
        super("Estações de trabalho", 599, 278);

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
                        return true;
                    }

                    @Override
                    public int selBtn ()
                    {
                        return -1;
                    }

                }, true, true, SimpleC_Cadastro.VIEW_ENTIDADE));

        DefBuilder builder = new DefBuilder(new TableConfigurator()
        {
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
                            70, 350
                        };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, true
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[]
                        {
                            1
                        };
            }

        });
        builder = builder.setTxtBusca(320);
        builder = builder.setCmbCampos(110, "nome", "código");

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaEstacaoDeTrabalho.class, C_EntidadeEstacaoDeTrabalho.class,
              PnlEstacaoDeTrabalho.class, C_CadastroEstacaoDeTrabalho.class);
    }

}
