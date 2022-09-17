/*
 * C_ListaDeVideos.java
 *
 * Created on 09/08/2012, 15:07:19
 */

package com.ic.projects.laudoecia.control.laudoecia;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.iview.ViewLaudoeCia;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class C_ListaDeVideos
{

    private ViewLaudoeCia view;
    private CompactadorDoVideo thread;
    private RunnQueRecarregaOsVideos notify;
    private List<String> videosSendoCompactados = new ArrayList<>();
    private boolean c_CapturaCompactaVideos;
    private LaudoeCiaMediator mediador;

    C_ListaDeVideos (ViewLaudoeCia view, LaudoeCiaMediator mediador)
    {
        this.view = view;
        this.mediador = mediador;
        c_CapturaCompactaVideos = LaudoeCia.getSoftwareView().
                    getC_Captura().compactaVideos();
    }

    void setarListaDeVideos (List<VideoGravado> videos)
    {
        if (c_CapturaCompactaVideos)
        {
            if (!(notify == null || notify.isDone()))
            {
                notify.listaMudou();
            }
            view.setarListaVideos(videos);
            thread = new CompactadorDoVideo(videos);
            notify = new RunnQueRecarregaOsVideos(videos, thread);
            LaudoeCia.getSoftwareView().runThread(thread, notify);
        }
        else
        {
            view.setarListaVideos(videos);
        }
    }

    boolean videoEstaSendoCompactado (String caminho)
    {
        return videosSendoCompactados.contains(caminho);
    }

    boolean videoEstaSendoCompactado ()
    {
        return !videosSendoCompactados.isEmpty();
    }

    private class RunnQueRecarregaOsVideos implements Runnable
    {

        private boolean listaMudou = false;
        private boolean done = false;
        private List<VideoGravado> videos;
        private CompactadorDoVideo compactador;

        private RunnQueRecarregaOsVideos (List<VideoGravado> videos, CompactadorDoVideo c)
        {
            this.videos = videos;
            this.compactador = c;
        }

        private void listaMudou ()
        {
            listaMudou = true;
        }

        private boolean isDone ()
        {
            return done;
        }

        @Override
        public void run ()
        {
            boolean atualizarView;
            if (compactador.foiPrecisoCompactar() && !listaMudou)
            {
                atualizarView = true;
            }
            else if (compactador.foiPrecisoCompactar() && listaMudou)
            {
                atualizarView = videos.isEmpty() ? false :
                                Objects.equals(videos.get(0).getProcedimento(),
                                       mediador.getProcSelecionado());
            }
            else
            {
                atualizarView = false;
            }
            done = true;
            videosSendoCompactados.remove(compactador.getCaminho());
            if (atualizarView)
            {
                view.setarListaVideos(mediador.getVideos());
            }
        }
    }

    private class CompactadorDoVideo implements Runnable
    {

        private File novoVideo = null;
        private String caminho = "";

        private CompactadorDoVideo (List<VideoGravado> videos)
        {
            for (int i = 0; i < videos.size(); i++)
            {
                VideoGravado vg = videos.get(i);
                if (StaticInfo.getEstTrabalho().equals(vg.getEstacaoDeTrabalho())
                    && !videosSendoCompactados.contains(vg.getCaminho()))
                {
                    File arqCompactado = new File(vg.getCaminho());
                    File arqGravado = new File(arqGravado(vg.getCaminho()));
                    if (arqGravado.exists() && vg.getCodigo() == 0)
                    {
                        novoVideo = arqCompactado;
                        videosSendoCompactados.add(vg.getCaminho());
                        caminho = vg.getCaminho();
                        break;
                    }
                    else
                    {
                    }
                }
            }
        }

        @Override
        public void run ()
        {
            if (novoVideo == null)
            {
            }
            else
            {
                File arqOrigem = new File(arqGravado(novoVideo.getAbsolutePath()));
                compactarVideo(arqOrigem, novoVideo);
            }
        }

        private void compactarVideo (File arqOrigem, File arqDestino)
        {
            LaudoeCia.getSoftwareView().getC_Captura().
                    compactarVideo(arqOrigem, arqDestino);
        }

        private boolean foiPrecisoCompactar ()
        {
            return novoVideo != null;
        }

        private String getCaminho ()
        {
            return caminho;
        }

    }

    String arqCompactado (String arqGravado)
    {
        return arqGravado.replace(recFileExtComPto(), compFileExtComPto());
    }

    String arqGravado (String arqCompactado)
    {
        return arqCompactado.replace(compFileExtComPto(), recFileExtComPto());
    }

    private String recFileExtComPto ()
    {
        return "." + LaudoeCia.getSoftwareView().getC_Captura().
                getRecordedVideoFileExtension();
    }

    private String compFileExtComPto ()
    {
        return "." + LaudoeCia.getSoftwareView().getC_Captura().
                getCompressedVideoFileExtension();
    }

}
