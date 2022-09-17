/*
 * C_Captura.java
 *
 * Created on 02/08/2012, 14:31:11
 */

package com.ic.projects.laudoecia.iview.captura;

import com.ic.projects.laudoecia.iview.captura.exceptions.CapturaException;
import com.ic.projects.laudoecia.iview.captura.exceptions.ErroNaGravacaoException;
import com.ic.projects.laudoecia.iview.captura.exceptions.NoAudioException;
import com.ic.projects.laudoecia.iview.captura.exceptions.SemDispDeCapturaException;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.File;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface C_Captura
{

    // <editor-fold defaultstate="collapsed" desc="Propriedades da captura">

    String POSSUI_DISPOSITIVO_DE_CAPTURA = "POSSUI_DISPOSITIVO_DE_CAPTURA";
    String PRIMEIRA_EXECUCAO_DA_CAPTURA = "primeira execucao da captura";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estado atual">

    int NENHUM_DISPOSITIVO = 0;
    int CAPTURANDO_IMAGEM = 1;
    int GRAVANDO_VIDEO = 2;
    int GRAVACAO_PAUSADA = 3;
    int REPRODUZINDO_VIDEO = 4;

    // </editor-fold>

    /**
     *
     * @param arqOrigem
     * @param arqDestino
     */
    void compactarVideo (File arqOrigem, File arqDestino);

    /**
     *
     * @return
     */
    String getRecordedVideoFileExtension ();

    /**
     *
     * @return
     */
    String getCompressedVideoFileExtension ();

    /**
     *
     * @return
     */
    Component getPnlCaptura ();

    /**
     *
     * @param ml
     */
    void setMouseListener (MouseListener ml);

    /**
     *
     * @param kl
     */
    void setKeyListener (KeyListener kl);

    /**
     * Termina a gravacao video, se algum video estiver sendo gravado.
     */
    void terminarGravacaoDeVideo ();

    /**
     * Alterna o estado atual do controlador. Se estiver capturando imagem,
     * não faz nada. Se esta gravando o video, pausa a gravacao.
     * Se esta com a gravacao do video pausada, continua a gravacao.
     * Se estiver reproduzindo um
     * arquivo de video, para a reprodução e mostra a captura.
     * @return o estado em que se encontra o player apos a solicitacao
     */
    int alternarEstado ();

    /**
     * Retorna o estado atual do controlador.
     * @return
     */
    int estadoAtual ();

    /**
     *
     * @return
     */
    boolean audioEstaDisponivel ();

    /**
     *
     * @return
     */
    Dimension getVideoSize ();

    /**
     *
     * @throws SemDispDeCapturaException
     * @throws CapturaException
     */
    void configDispsDeCaptura () throws SemDispDeCapturaException, CapturaException;

    /**
     *
     */
    void escolherDispsDeCaptura ();

    /**
     *
     */
    void desconectar ();

    /**
     *
     */
    void pausarAtividades ();

    /**
     *
     */
    void continuarAtividades ();

    /**
     *
     * @return
     * @throws SemDispDeCapturaException
     * @throws CapturaException
     */
    Image capturarImagem () throws SemDispDeCapturaException, CapturaException;

    /**
     *
     * @param arquivoDeVideo
     * @param gravarComAudio
     * @throws NoAudioException
     * @throws SemDispDeCapturaException
     * @throws ErroNaGravacaoException
     */
    void iniciarGravacaoDeVideo (File arquivoDeVideo, boolean gravarComAudio)
            throws NoAudioException, SemDispDeCapturaException, ErroNaGravacaoException;

    /**
     *
     */
    void foiParaFullScreen ();

    /**
     *
     */
    void voltouDoFullScreen ();

    /**
     *
     * @param file
     */
    void reproduzirArquivoDeVideo (File file) throws CapturaException;

    /**
     *
     * @return
     */
    boolean compactaVideos ();

    void escolherFormato () throws SemDispDeCapturaException, CapturaException;

    void capturaFoiAcionada ();

    boolean necessitaReiniciar ();

    void escolherRecorte (byte[] image);

    

}
