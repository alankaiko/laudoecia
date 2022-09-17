/*
 * IFrameGrupoDeUsuarios.java
 *
 * Created on 05/01/2012, 08:37:40
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaGrupoDeUsuarios;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroGrupoDeUsuarios;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeGrupoDeUsuarios;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class IFrameGrupoDeUsuarios extends SimpleIFrameCadastro
{

    public IFrameGrupoDeUsuarios ()
    {
        super("Grupos de usuários", 725, 432);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator() {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[] { "Código", "Nome" };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 75, 0 } ;
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 0 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { Integer.class, String.class } ;
            }

        });
        builder = builder.setTxtBusca(380);
        builder = builder.setCmbCampos(110, "nome", "código");

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaGrupoDeUsuarios.class, C_EntidadeGrupoDeUsuarios.class,
                     PnlGrupoDeUsuarios.class, C_CadastroGrupoDeUsuarios.class);

    }

}
