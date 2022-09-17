/*
 * DlgGrupoProc.java
 *
 * Created on 26/09/2012, 15:28:16
 */

package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaGrupoDeProcedimentos;
import com.ic.projects.laudoecia.control.cadastro.C_CadastroGrupoDeProcedimentos;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeGrupoDeProcedimentos;
import com.ic.projects.laudoecia.view.cadastro.PnlGrupoDeProcedimentos;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgGrupoProc extends DlgCadastro
{

    public DlgGrupoProc (Component cp)
    {
        super(cp, true, 719, 302);
        setTitle("Grupos de exames e procedimentos médicos");

        pnlCadastro = new SimplePnlCadastro();

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
                return new int[] { 1 };
            }

        });
        builder = builder.setTxtBusca(380);
        builder = builder.setCmbCampos(110, "nome", "código");
        pnlCadastro.setPnlBusca(builder);

        pnlCadastro.start(C_BuscaGrupoDeProcedimentos.class, C_EntidadeGrupoDeProcedimentos.class,
              PnlGrupoDeProcedimentos.class, C_CadastroGrupoDeProcedimentos.class);

        setContentPane(pnlCadastro);

    }

}
