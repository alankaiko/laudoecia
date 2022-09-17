/*
 * IFrameUsuarios.java
 *
 * Created on 13/01/2012, 15:41:22
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaUsuario;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroUsuario;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeUsuario;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.plus.renderers.MyBooleanRenderer;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.TableConfigurator;
import java.util.Date;
import javax.swing.SwingConstants;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class IFrameUsuarios extends SimpleIFrameCadastro
{

    public IFrameUsuarios ()
    {
        super("Usuários do sistema", 662, 278);
        setPnlCadastro(new SimplePnlCadastro());

        DefBuilder builder = new DefBuilder(new TableConfigurator() {

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, true, false, false } ;
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[] { "Código", "Nome", "Data de cadastro", "Ativo" };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 65, 0, 120, 60 } ;
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 1 };
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { Integer.class, String.class, Date.class, Boolean.class } ;
            }

        });
        builder = builder.setTxtBusca(360);
        builder = builder.setCmbCampos(130, "nome ou login", "grupo");
        builder.getScroll().setHeaderAlignment(2, SwingConstants.CENTER);
        builder.getScroll().setHeaderAlignment(3, SwingConstants.CENTER);
        builder.getScroll().setCellRenderer(2, new MyDateRenderer(Constantes.DATE_ONLY, SwingConstants.CENTER));
        builder.getScroll().setCellRenderer(3, new MyBooleanRenderer());

        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaUsuario.class, C_EntidadeUsuario.class,
                                    PnlUsuario.class, C_CadastroUsuario.class);

    }

}
