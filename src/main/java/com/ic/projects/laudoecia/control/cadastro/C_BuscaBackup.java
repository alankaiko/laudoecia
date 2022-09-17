/*
 * C_BuscaBackup.java
 *
 * Created on 09/04/2012, 16:27:47
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeStatusBackup;
import com.ic.projects.laudoecia.control.backup.BackupListener;
import com.ic.projects.laudoecia.control.backup.BackupStatusListener;
import com.ic.projects.laudoecia.dao.cadastro.DaoBackup;
import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.iview.crud.ViewParamsBusca;
import com.lib.java.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaBackup extends AbsDefC_BuscaComCrud<Backup, Integer> implements BackupStatusListener
{

    private DaoBackup dao;
    private BuscadorDeStatusBackup buscador = new BuscadorDeStatusBackup();

    @SuppressWarnings("LeakingThisInConstructor")
    public C_BuscaBackup (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoBackup(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoBackup) getDao();
        BackupListener.addListener(this);
    }

    @Override
    public Object[] criarLinhaSelecionada (Backup entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(), entidade.getDataMarcada(),
                    entidade.getTipo(), entidade.getDiretorioDoArquivo(),
                    entidade.getStatus()
                };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "data marcada":
                Date dataMarcada = StringUtils.getRecentDateFromString(busca);
                if (dataMarcada == null)
                {
                    if (busca == null || busca.isEmpty())
                    {
                        return dao.buscarTodosNaoCancelados(maxResults);
                    }
                    else
                    {
                        return new ArrayList<>();
                    }
                }
                else
                {
                    return dao.buscarBackupsPorMarcada(dataMarcada, maxResults);
                }
            case "status":
                STATUS_BACKUP status = buscador.getSelectedModel();
                if (status == null)
                {
                    return new ArrayList<>();
                }
                else
                {
                    return dao.buscarBackupsPorStatus(status, maxResults);
                }
            default:
                return new ArrayList<>();
        }
    }

    @Override
    protected void parametrosBuscaMudaram (Object[] newParamsBusca, Object[] oldParamsBusca)
    {
        String newCampo = (String) newParamsBusca[1];
        String oldCampo = (String) oldParamsBusca[1];
        if (!newCampo.equals(oldCampo))
        {
            switch (newCampo)
            {
                case "status":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscador);
                    break;
                default:
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, null);
            }
        }
    }

    @Override
    public void backupIniciou (Backup backup)
    {
        atualizarDadosDaTabela(backup);
    }

    @Override
    public void backupTerminou (Backup backup)
    {
        atualizarDadosDaTabela(backup);
    }

    private void atualizarDadosDaTabela (Backup backup)
    {
        List<Object[]> results = c_ResultadosDaBusca.getResults();
        for (int i = 0; i < results.size(); i++)
        {
            Object[] result = results.get(i);
            if (result[0].equals(backup.getCodigo()))
            {
                result[4] = backup.getStatus();
                c_ResultadosDaBusca.atualizarResultado(result, i);
            }
        }
        Object[] selResult = c_ResultadosDaBusca.getSelectedResult();
        if (selResult != null && selResult[0].equals(backup.getCodigo()))
        {
            c_ResultadosDaBusca.selectedResultChanged();
        }
    }

    @Override
    public void viewClosed ()
    {
        BackupListener.removeListener(this);
    }

}
