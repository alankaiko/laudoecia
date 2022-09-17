/*
 * C_CadastroBackup.java
 *
 * Created on 09/04/2012, 16:37:51
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.lib.icontrol.crud.busca.DefC_BuscaComCrud;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.iview.crud.ViewCadastro;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_CadastroBackup extends MyC_Cadastro<Backup>
{
    
    public C_CadastroBackup (ViewCadastro view, DefC_BuscaComCrud<Backup, Integer> c_Busca, C_EntidadeComCrud<Backup, Integer> c_Entidade)
    {
        super(view, c_Busca, c_Entidade, new AdapterPermissaoDeUsuario()
        {
            @Override
            public boolean podeAdicionar (PerfilDeAcesso p)
            {
                return p.isAdicionaBackup();
            }

            @Override
            public boolean podeAlterar (PerfilDeAcesso p)
            {
                return p.isAlteraBackup();
            }

            @Override
            public boolean podeApagar (PerfilDeAcesso p)
            {
                return p.isApagaBackup();
            }

        });
    }

    @Override
    public boolean validarAlterar ()
    {
        Backup backup = c_BuscaComCrud.getEntity(c_Busca.getSelectedResult());
        if (backup.getStatus() != STATUS_BACKUP.AGENDADO)
        {
            view.mostrarMsgErro("Só é possível alterar backups que possuam status Agendado!");
            return false;
        }
        else if (backup.isBackupAutomatico())
        {
            view.mostrarMsgErro("Para alterar o backup automático, vá em Parâmetros do sistema!");
            return false;
        }
        else
        {
            return true;
        }
    }

}
