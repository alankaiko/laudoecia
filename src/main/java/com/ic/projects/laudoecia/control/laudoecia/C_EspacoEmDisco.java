/*
 * C_EspacoEmDisco.java
 *
 * Created on 13/08/2012, 10:23:24
 */
package com.ic.projects.laudoecia.control.laudoecia;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.iview.ViewLaudoeCia;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingWorker;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class C_EspacoEmDisco
{
    private static DaoProcDoAtd dao;
    private ViewLaudoeCia view;

    C_EspacoEmDisco (ViewLaudoeCia view)
    {
        this.view = view;
    }

    void verificarEspacoEmDisco ()
    {
        final File pastaVideos = new File(StaticInfo.getPastaDeVideos());
        long freeSpace = pastaVideos.getFreeSpace();
        long totalSpace = pastaVideos.getTotalSpace();
        if (((double) freeSpace / (double) totalSpace) < 0.1)
        {
            if (view.obterConfirmacaoDoUsuario("Há pouco espaço em disco! "
                                               + "\nTalvez não seja possível concluir uma nova gravação de vídeo."
                                               + "\nDeseja excluir alguns vídeos antigos para liberar espaço em disco?"))
            {
                final Date dataLimite = view.liberarEspacoEmDisco();
                if (dataLimite != null)
                {
                    new SwingWorker<Void, Void>()
                    {
                        @Override
                        protected Void doInBackground () throws Exception
                        {
                            doDeleteFiles(dataLimite, pastaVideos);
                            return null;
                        }
                    }.execute();
                }
            }
        }
    }

    private void doDeleteFiles (Date dataLimite, File pastaVideos)
    {
        List<Integer> listAtd = new ArrayList<>();
        String[] list = pastaVideos.list();
        for (int i = 0; i < list.length; i++)
        {
            String cod_atd = list[i].substring(0, list[i].indexOf('-'));
            if (cod_atd.matches("[0-9]+"))
            {
                int cod = Integer.valueOf(cod_atd);
                if (!listAtd.contains(cod))
                {
                    listAtd.add(cod);
                }
            }
        }
        List<ProcDoAtd> procs = getDao().buscarPorCodAtdEDataLimite (listAtd, dataLimite);
        for (int i = 0; i < procs.size(); i++)
        {
            List<VideoGravado> videos = procs.get(i).getVideosGravados();
            for (int j = 0; j < videos.size(); j++)
            {
                File video = new File(videos.get(j).getCaminho());
                if (video.exists())
                {
                    video.delete();
                }
            }
        }
    }

    public static DaoProcDoAtd getDao ()
    {
        if (dao == null)
        {
            dao = new DaoProcDoAtd();
        }
        return dao;
    }

}
