/*
 * C_CapturaJMF.java
 *
 * Created on 03/08/2012, 11:34:14
 */
package com.ic.projects.laudoecia.view.captura;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.cadastro.DaoRecorte;
import com.ic.projects.laudoecia.iview.captura.C_Captura;
import com.ic.projects.laudoecia.iview.captura.exceptions.CapturaException;
import com.ic.projects.laudoecia.iview.captura.exceptions.ErroNaGravacaoException;
import com.ic.projects.laudoecia.iview.captura.exceptions.NoAudioException;
import com.ic.projects.laudoecia.iview.captura.exceptions.SemDispDeCapturaException;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.PropriedadeDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.jhlabs.image.ContrastFilter;
import com.jhlabs.image.HSBAdjustFilter;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.java.utils.DateUtils;
import com.lib.java.utils.ImageUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.busca.TxtBuscaDocList;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.PnlImagem;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.plus.utils.TxtInteiro;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;
import com.sun.media.format.AviVideoFormat;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.*;
import javax.media.control.FrameGrabbingControl;
import javax.media.datasink.DataSinkEvent;
import javax.media.datasink.DataSinkListener;
import javax.media.format.*;
import javax.media.protocol.CaptureDevice;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;
import javax.media.protocol.SourceCloneable;
import javax.media.util.BufferToImage;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.LayerUI;
import javax.swing.table.DefaultTableCellRenderer;
import net.java.balloontip.BalloonTip;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_CapturaJMF implements C_Captura, JMF
{

    private int estadoAtual = NENHUM_DISPOSITIVO;
    private boolean primeiraExecucao = true;
    private boolean necessitaReiniciar = false;
    private File arqSendoRep = null;
    private ConversorByteArrayImage cnv = new ConversorByteArrayImage();

    // <editor-fold defaultstate="collapsed" desc="View">
    private PnlTotal pnlTotal = new PnlTotal();
    private PnlCaptura pnlImagem = new PnlCaptura();
    private MouseListener ml = new MouseAdapter()
    {
    };
    private KeyListener kl = new KeyAdapter()
    {
    };
    private LayerUI<JPanel> layerUi = new MyLayerUI();
    private JLayer<JPanel> layer = new JLayer<>(pnlTotal, layerUi);
    private MyJLabel lblVertGravacao = new LblVerticalGravacao();
    private MyJLabel lblHorGravacao = new MyJLabel("");
    private MyJLabel lblGravacao = lblHorGravacao;
    private SwLblStatusDaGravacao meuSw;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Parametros">
    private int frameRate = 30;
    private String extDoArqGravado = "avi";
    private String extDoArqCompactado = "mpg";
    private String videoEncoding = ENCODING_VIDEO.MJPG.getDesc();
//    private String audioEncoding = ENCODING_AUDIO.LINEAR.getDesc();
    private String containerArquivo = ENCODING_OUTPUT.VIDEO_X_MSVIDEO.getDesc();
    private int maxVideoWidth = 720;
    private int maxVideoHeight = 480;
    private int larguraInicialDoVideo = 640;
    private int alturaInicialDoVideo = 480;
    private int larguraVideoGravado = 576;
    private int alturaVideoGravado = 480;
    private String formatoDesejado = "";
    private final String formatoPreferencial = "YUV";
    private int larguraMinimaParaEstender = 900;
    private boolean sugerirDetectarCaptura = true;
    private RecortadorDeImg recortadorNull = new RecortadorDeImg()
    {

        @Override
        public Image recortarImagem (Image image)
        {
            return image;
        }

    };
    private RecortadorDeImg recortador = recortadorNull;
    private Recorte recorte = null;
    private AjustadorDeImg ajus = new AjustadorDeImg()
    {

        @Override
        public Image ajustarImagem (Image image)
        {
            return image;
        }

    };

    // </editor-fold>

    {

        layer.setFocusable(false);
        layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.KEY_EVENT_MASK);

        pnlTotal.add(pnlImagem);
        pnlTotal.add(lblVertGravacao);
        pnlTotal.add(lblHorGravacao);

        lblVertGravacao.setFont(lblVertGravacao.getFont().deriveFont(14));

        lblHorGravacao.setFont(lblHorGravacao.getFont().deriveFont(14));
        lblHorGravacao.setVerticalAlignment(SwingConstants.TOP);

    }

    // <editor-fold defaultstate="collapsed" desc="Flags">
    private final String AUDIO_PREFERENCIAL
                         = "LINEAR, 44100.0 Hz, 16-bit, Stereo, LittleEndian, Signed";

    // <editor-fold defaultstate="collapsed" desc="Parametros da captura">
    private final String AJUSTES = "ajustes";
    private final String FRAME_RATE = "frame rate";
    private final String EXT_DO_ARQ_GRAVADO = "extensao do arquivo gravado";
    private final String EXT_DO_ARQ_COMPACTADO = "extensao do arquivo compactado";
    private final String VIDEO_ENCODING = "video encoding";
    private final String AUDIO_ENCODING = "audio encoding";
    private final String CONTAINER_DO_ARQUIVO = "container do arquivo";
    private final String ALTURA_MAX_VIDEO = "altura maxima do video";
    private final String LARGURA_MAXIMA_DO_VIDEO = "largura maxima do video";
    private final String ALTURA_INICIAL_VIDEO = "altura inicial do video";
    private final String LARGURA_INICIAL_DO_VIDEO = "largura inicial do video";
    private final String FORMATO_DESEJADO = "formato desejado";
    private final String LARGURA_MIN_PARA_ESTENDER = "largura minima para estender";
    private final String SUGERIR_DETECTAR_DISPOSITIVO = "sugerir detectar dispositivo";
    private final String ALTURA_VIDEO_GRAVADO = "altura do video gravado";
    private final String LARGURA_VIDEO_GRAVADO = "largura do video gravado";
    private final String RECORTE = "recorte";

    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="JMF objects">
    private List<VideoFormat> formatosDisponiveis = new ArrayList<>();
    private VideoFormat videoFormat;
    private AudioFormat audioFormat;
    private Player capturePlayer;
    private Player filePlayer;
    private DataSource videoDevice;
    private DataSource audioDevice;
    private Processor fileRecorder;
    private DataSink dataSinkRecord;
    private MyDataSinkListener dataSinkListener = new MyDataSinkListener();

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Private stuff">
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private void carregarParametros ()
    {
        ParametrosDaCaptura pc = StaticInfo.getParamsCaptura();
        outer:
        for (PropriedadeDaCaptura pdc : pc.getPropriedades())
        {
            String descricao = pdc.getDescricao();
            String valor = pdc.getValor();
            if (descricao == null || valor == null || "-".equals(valor))
            {
            }
            else
            {
                switch (descricao)
                {
                    case POSSUI_DISPOSITIVO_DE_CAPTURA:
                    case PRIMEIRA_EXECUCAO_DA_CAPTURA:
                        break;
                    case SUGERIR_DETECTAR_DISPOSITIVO:
                        switch (valor)
                        {
                            case "true":
                                sugerirDetectarCaptura = true;
                                break;
                            case "false":
                                sugerirDetectarCaptura = false;
                                break;
                            default:
                                System.out.println("sugerir detectar captura invalido!");
                                break;
                        }
                        break;
                    case FORMATO_DESEJADO:
                        this.formatoDesejado = valor;
                        break;
                    case AJUSTES:
                        if (valor.matches(".+;.+"))
                        {
                            String[] split = valor.split(";");
                            try
                            {
                                float brilho = Float.valueOf(split[0]);
                                float contraste = Float.valueOf(split[1]);
//                                float cor = Float.valueOf(split[2]);
//                                float saturacao = Float.valueOf(split[3]);

                                if (brilho != 0 && contraste != 0)
                                {
                                    ajus = new Ajust(brilho, contraste);
                                }
                            }
                            catch (Exception e)
                            {
                            }
                        }
                        break;
                    case RECORTE:
                        if (valor.matches("[0-9]+"))
                        {
                            Integer valorInt = Integer.valueOf(valor);
                            try
                            {
                                configurarRecorte(new DaoRecorte().procurarPorId(valorInt));
                            }
                            catch (Exception e)
                            {
                            }
                        }
                        break;
                    case FRAME_RATE:
                        if (valor.matches("[0-9]+"))
                        {
                            Integer valorInt = Integer.valueOf(valor);
                            if (valorInt > 0)
                            {
                                frameRate = valorInt;
                            }
                            else
                            {
                                System.out.println("frame rate invalido!");
                            }
                        }
                        else
                        {
                            System.out.println("frame rate invalido!");
                        }
                        break;
                    case LARGURA_VIDEO_GRAVADO:
                        if (valor.matches("[0-9]+"))
                        {
                            Integer valorInt = Integer.valueOf(valor);
                            if (valorInt > 0)
                            {
                                larguraVideoGravado = valorInt;
                            }
                            else
                            {
                                System.out.println("frame rate invalido!");
                            }
                        }
                        else
                        {
                            System.out.println("frame rate invalido!");
                        }
                        break;
                    case ALTURA_VIDEO_GRAVADO:
                        if (valor.matches("[0-9]+"))
                        {
                            Integer valorInt = Integer.valueOf(valor);
                            if (valorInt > 0)
                            {
                                alturaVideoGravado = valorInt;
                            }
                            else
                            {
                                System.out.println("frame rate invalido!");
                            }
                        }
                        else
                        {
                            System.out.println("frame rate invalido!");
                        }
                        break;
                    case EXT_DO_ARQ_GRAVADO:
                        switch (valor)
                        {
                            case "avi":
                            case "mpg":
                            case "mov":
                                extDoArqGravado = valor;
                                break;
                            default:
                                System.out.println("extensao do arquivo invalida");
                        }
                        break;
                    case EXT_DO_ARQ_COMPACTADO:
                        switch (valor)
                        {
                            case "avi":
                            case "mpg":
                            case "mov":
                            case "mp4":
                                extDoArqCompactado = valor;
                                break;
                            default:
                                System.out.println("extensao do arquivo invalida");
                        }
                        break;
                    case VIDEO_ENCODING:
                        if (ENCODING_VIDEO.validarDesc(valor))
                        {
                            videoEncoding = valor;
                        }
                        else
                        {
                            System.out.println("video encoding não encontrado!");
                        }
                        break;
                    case AUDIO_ENCODING:
                        System.out.println("não é possível "
                                           + "alterar audio encoding nessa versão!");
                        break;
                    case CONTAINER_DO_ARQUIVO:
                        if (ENCODING_OUTPUT.validarDesc(valor))
                        {
                            containerArquivo = valor;
                        }
                        else
                        {
                            System.out.println("video encoding não encontrado!");
                        }
                        break;
                    case ALTURA_MAX_VIDEO:
                        if (valor.matches("[0-9]+"))
                        {
                            maxVideoHeight = Integer.valueOf(valor);
                        }
                        else
                        {
                            System.out.println("altura maxima do video invalida!");
                        }
                        break;
                    case LARGURA_MAXIMA_DO_VIDEO:
                        if (valor.matches("[0-9]+"))
                        {
                            maxVideoWidth = Integer.valueOf(valor);
                        }
                        else
                        {
                            System.out.println("largura maxima do video invalida!");
                        }
                        break;
                    case ALTURA_INICIAL_VIDEO:
                        if (valor.matches("[0-9]+"))
                        {
                            alturaInicialDoVideo = Integer.valueOf(valor);
                        }
                        else
                        {
                            System.out.println("altura maxima do video invalida!");
                        }
                        break;
                    case LARGURA_INICIAL_DO_VIDEO:
                        if (valor.matches("[0-9]+"))
                        {
                            larguraInicialDoVideo = Integer.valueOf(valor);
                        }
                        else
                        {
                            System.out.println("largura maxima do video invalida!");
                        }
                        break;
                    case LARGURA_MIN_PARA_ESTENDER:
                        if (valor.matches("[0-9]+"))
                        {
                            larguraMinimaParaEstender = Integer.valueOf(valor);
                        }
                        else
                        {
                            System.out.println("tamanho minimo para estender invalido!");
                        }
                        break;
                    default:
                        System.out.println(descricao + " : parametro desconhecido!");
                }
            }
        }
    }

    @SuppressWarnings(
            {
                "unchecked", "UseOfSystemOutOrSystemErr", "AssignmentToMethodParameter"
            })
    private void carregarDispositivosDaCaptura (boolean procurarAudio) throws Exception
    {
        formatosDisponiveis.clear();
        AudioFormat audioEscolhido = null;
        CaptureDeviceInfo cdiVideo = null;
        CaptureDeviceInfo cdiAudio = null;
        List<CaptureDeviceInfo> deviceList = CaptureDeviceManager.getDeviceList(null);
        for (int deviceIndex = 0; deviceIndex < deviceList.size(); deviceIndex++)
        {
            CaptureDeviceInfo cdi = deviceList.get(deviceIndex);
            Format[] formats = cdi.getFormats();
            String cdiToString = cdi.toString();
            System.out.println(cdiToString);
            for (int formatIndex = 0; formatIndex < formats.length; formatIndex++)
            {
                Format format = formats[formatIndex];
                if (format instanceof VideoFormat)
                {
                    formatosDisponiveis.add((VideoFormat) format);
                    cdiVideo = cdi;
                }
                if (format instanceof AudioFormat && procurarAudio)
                {
                    AudioFormat af = (AudioFormat) format;
                    if (cdiToString.contains(DIRECT_SOUND_STRING)
                        || cdiToString.contains(JAVA_SOUND_STRING))
                    {
                        if (audioEscolhido == null)
                        {
                            cdiAudio = cdi;
                            audioEscolhido = af;
                        }
                        if (format.toString().equals(AUDIO_PREFERENCIAL))
                        {
                            audioEscolhido = af;
                            cdiAudio = cdi;
                            if (cdiToString.contains(DIRECT_SOUND_STRING))
                            {
                                procurarAudio = false;
                            }
                            System.out.println("Audio preferencial encontrado!");
                        }
                    }
                }
            }
        }
        VideoFormat vf = escolherVideoFormat();
        if (!(vf == null || cdiVideo == null))
        {
            configurarVideo(cdiVideo, vf);
            try
            {
                Collections.sort(formatosDisponiveis,
                                 new Comparator<VideoFormat>()
                {

                    @Override
                    public int compare (VideoFormat o1, VideoFormat o2)
                    {
                        int compEnc = o1.getEncoding().toString().
                                compareTo(o2.getEncoding().toString());
                        if (compEnc == 0)
                        {
                            Integer size1 = o1.getSize().width * o1.getSize().height;
                            Integer size2 = o2.getSize().width * o2.getSize().height;
                            return -1 * size1.compareTo(size2);
                        }
                        else
                        {
                            return -1 * compEnc;
                        }
                    }

                                 });
            }
            catch (Exception e)
            {
            }
            setEstadoAtual(CAPTURANDO_IMAGEM);
        }
        if (audioEscolhido != null)
        {
            configurarAudio(cdiAudio, audioEscolhido);
        }
    }

    private VideoFormat escolherVideoFormat ()
    {
        if (formatoDesejado == null || formatoDesejado.isEmpty())
        {
            VideoFormat resposta = null;
            for (int i = 0; i < formatosDisponiveis.size(); i++)
            {
                VideoFormat vf = formatosDisponiveis.get(i);
                Dimension vfSize = vf.getSize();
                if (vfSize.width > maxVideoWidth || vfSize.height > maxVideoHeight)
                {
                }
                else if (resposta == null)
                {
                    resposta = vf;
                }
                else if (vf.toString().contains(formatoPreferencial)
                         && !resposta.toString().contains(formatoPreferencial))
                {
                    resposta = vf;
                }
                else if (resposta.toString().contains(formatoPreferencial)
                         && !vf.toString().contains(formatoPreferencial))
                {
                }
                else if (dim2MelhorQueDim1(resposta.getSize(), vfSize))
                {
                    resposta = vf;
                }
            }
            return resposta;
        }
        else
        {
            for (int i = 0; i < formatosDisponiveis.size(); i++)
            {
                VideoFormat vf = formatosDisponiveis.get(i);
                if (vf.toString().equals(formatoDesejado))
                {
                    return vf;
                }
            }
            return null;
        }
    }

    private class PlayerEventHandler extends ControllerAdapter
    {

        private Player player;

        private PlayerEventHandler (Player pl)
        {
            this.player = pl;
        }

        @Override
        public void endOfMedia (EndOfMediaEvent mediaEndEvent)
        {
            player.stop();
            player.setMediaTime(new Time(0));
        }

    }

    private class MyDataSinkListener implements DataSinkListener
    {

        private boolean endOfStream = false;

        @Override
        public void dataSinkUpdate (DataSinkEvent event)
        {
            if (event instanceof javax.media.datasink.EndOfStreamEvent)
            {
                endOfStream = true;
            }
        }

        @SuppressWarnings("SleepWhileInLoop")
        private void waitEndOfStream ()
        {
            int count = 0;
            while (!endOfStream)
            {
                try
                {
                    Thread.sleep(10);
                    if (count > 3000)
                    {
                        return;
                    }
                    count++;
                }
                catch (InterruptedException ie)
                {
                }
            }
        }

    }

    private Player getPlayingPlayer ()
    {
        switch (estadoAtual)
        {
            case NENHUM_DISPOSITIVO:
                return null;
            case CAPTURANDO_IMAGEM:
            case GRAVACAO_PAUSADA:
            case GRAVANDO_VIDEO:
                return capturePlayer;
            case REPRODUZINDO_VIDEO:
                return filePlayer;
            default:
                throw new AssertionError();
        }
    }

    private boolean criarAudioDataSourceOk ()
    {
        try
        {
            audioDevice.disconnect();
            audioDevice = Manager.createDataSource(audioDevice.getLocator());
            JmfUtils.tryToSetFormat((CaptureDevice) audioDevice, audioFormat);
            return true;
        }
        catch (IOException | NoDataSourceException ex)
        {
        }
        return false;
    }

    private void configurarAudio (CaptureDeviceInfo cdi, AudioFormat af) throws Exception
    {
        audioDevice = Manager.createDataSource(cdi.getLocator());
        audioFormat = af;
        JmfUtils.tryToSetFormat((CaptureDevice) audioDevice, af);
    }

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private void configurarVideo (CaptureDeviceInfo cdi, VideoFormat vf) throws Exception
    {
        DataSource ds = Manager.createDataSource(cdi.getLocator());
        videoDevice = Manager.createCloneableDataSource(ds);
        videoFormat = getCustomFormat(vf, frameRate);
        if (JmfUtils.tryToSetFormat((CaptureDevice) videoDevice, videoFormat))
        {
        }
        else
        {
            System.out.println("Não foi possível setar o formato customizado do vídeo");
        }
        capturePlayer = Manager.createRealizedPlayer(videoDevice);
        capturePlayer.getVisualComponent().setFocusable(false);
        pnlImagem.add(capturePlayer.getVisualComponent(), BorderLayout.CENTER);
//        pnlImagem.add(capturePlayer.getControlPanelComponent(), BorderLayout.NORTH);
        capturePlayer.start();
    }

    private ProcessorModel createProcessorModel (boolean gravarAudio) throws NoAudioException
    {
        Format outputFormat[];
        DataSource ds;
        DataSource cloneVideo = ((SourceCloneable) videoDevice).createClone();
        if (gravarAudio)
        {
            if (!(audioEstaDisponivel() && criarAudioDataSourceOk()))
            {
                throw new NoAudioException();
            }
            DataSource mixed[] = new DataSource[]
            {
                cloneVideo, audioDevice
            };
            try
            {
                ds = Manager.createMergingDataSource(mixed);
            }
            catch (IncompatibleSourceException ex)
            {
                throw new NoAudioException();
            }
            outputFormat = new Format[2];
            outputFormat[1] = audioFormat;
        }
        else
        {
            ds = cloneVideo;
            outputFormat = new Format[1];
        }
        outputFormat[0] = new VideoFormat(videoEncoding, new Dimension(
                larguraVideoGravado, alturaVideoGravado),
                                          videoFormat.getMaxDataLength(), videoFormat.getDataType(), frameRate);
        FileTypeDescriptor outputType = new FileTypeDescriptor(containerArquivo);
        return new ProcessorModel(ds, outputFormat, outputType);
    }

    private String getStringTempo (double segundos)
    {
        int segundosInt = (int) segundos;
        Date d = new Date();
        Date newDate = DateUtils.adicionarSegundosNaData(d, segundosInt);
        String h = String.valueOf(DateUtils.diferencaDeHoras(d, newDate));
        String m = String.valueOf(DateUtils.diferencaDeMinutos(d, newDate));
        String s = String.valueOf(DateUtils.diferencaDeSegundos(d, newDate));
        if (h.length() == 1)
        {
            h = "0" + h;
        }
        if (m.length() == 1)
        {
            m = "0" + m;
        }
        if (s.length() == 1)
        {
            s = "0" + s;
        }
        double seg = segundos - segundosInt;
        String segStr = String.valueOf(seg);
        if (segStr.length() == 3)
        {
            segStr = "0" + segStr.substring(2, 3);
        }
        else if (segStr.length() > 3)
        {
            segStr = segStr.substring(2, 4);
        }
        return h + ":" + m + ":" + s + "." + segStr;
    }

    private Image capturarFrameDoArquivo (double segundos)
    {
        if (arqSendoRep == null)
        {
            return null;
        }
        Process p = null;
        try
        {
            List<String> comando = new ArrayList<>();
            comando.add(StaticInfo.getFFMPGEPath());
            comando.add("-i");
            comando.add(arqSendoRep.getAbsolutePath());
            comando.add("-vframes");
            comando.add("1");
            comando.add("-ss");
            comando.add(getStringTempo(segundos));
            comando.add("-f");
            comando.add("image2");
            comando.add(StaticInfo.getSnapshotName());
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.redirectErrorStream(true);
            p = pb.start();
            InputStream is = p.getInputStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
            {
                String line = br.readLine();
                while (line != null)
                {
                    line = br.readLine();
                }
            }
            if (p.waitFor() == 0)
            {
                File arqGeradoPeloFFMpeg = StaticInfo.getSnapshotFile();
                BufferedImage imagemLidaDoArq = ImageIO.read(arqGeradoPeloFFMpeg);
                arqGeradoPeloFFMpeg.delete();
                return imagemLidaDoArq;
            }
            else
            {
            }
        }
        catch (IOException | InterruptedException ex)
        {
            return null;
        }
        finally
        {
            if (p != null)
            {
                p.destroy();
            }
        }
        return null;
    }

    private String formatoAtualSemFrameRate ()
    {
        if (videoFormat == null)
        {
            return "";
        }
        return videoFormat.toString().replaceAll("FrameRate=[^\\,]+\\, ", "");
    }

    private String lerCmdCompactacao (int index) throws IOException
    {
        return StaticInfo.lerPropriedade(StaticInfo.CAPTURA,
                                         StaticInfo.CMD_COMPACTACAO + String.valueOf(index));
    }

    // <editor-fold defaultstate="collapsed" desc="Format Utils">
    private VideoFormat criarYuvFormat (YUVFormat ft, float fr)
    {
        return new YUVFormat(ft.getSize(), ft.getMaxDataLength(),
                             ft.getDataType(), fr, ft.getYuvType(),
                             ft.getStrideY(), ft.getStrideUV(),
                             ft.getOffsetY(), ft.getOffsetU(), ft.getOffsetV());
    }

    private VideoFormat criarRgbFormat (RGBFormat ft, float fr)
    {
        return new RGBFormat(ft.getSize(), ft.getMaxDataLength(),
                             ft.getDataType(), fr, ft.getBitsPerPixel(), ft.getRedMask(),
                             ft.getGreenMask(),
                             ft.getBlueMask(), ft.getPixelStride(), ft.getLineStride(),
                             ft.getFlipped(), ft.getEndian());
    }

    private VideoFormat criarAviFormat (AviVideoFormat ft, float fr)
    {
        return new AviVideoFormat(ft.getEncoding(), ft.getSize(),
                                  ft.getMaxDataLength(), ft.getDataType(), fr,
                                  ft.getPlanes(), ft.getBitsPerPixel(),
                                  ft.getImageSize(), ft.getXPelsPerMeter(),
                                  ft.getYPelsPerMeter(), ft.getClrUsed(),
                                  ft.getClrImportant(), ft.getCodecSpecificHeader());
    }

    private VideoFormat criarH261Format (H261Format ft, float fr)
    {
        return new H261Format(ft.getSize(), ft.getMaxDataLength(),
                              ft.getDataType(), fr, ft.getStillImageTransmission());
    }

    private VideoFormat criarH263Format (H263Format ft, float fr)
    {
        return new H263Format(ft.getSize(), ft.getMaxDataLength(),
                              ft.getDataType(), fr, ft.getAdvancedPrediction(),
                              ft.getArithmeticCoding(), ft.getErrorCompensation(), ft.getHrDB(),
                              ft.getPBFrames(), ft.getUnrestrictedVector());
    }

    private VideoFormat criarIndexFormat (IndexedColorFormat ft, float fr)
    {
        return new IndexedColorFormat(ft.getSize(), ft.getMaxDataLength(),
                                      ft.getDataType(), fr, ft.getLineStride(),
                                      ft.getMapSize(), ft.getRedValues(), ft.getGreenValues(),
                                      ft.getBlueValues());
    }

    private VideoFormat criarJPEGFormat (JPEGFormat ft, float fr)
    {
        return new JPEGFormat(ft.getSize(), ft.getMaxDataLength(),
                              ft.getDataType(), fr, ft.getQFactor(), ft.getDecimation());
    }

    private VideoFormat criarVideoFormat (VideoFormat ft, float fr)
    {
        return new VideoFormat(ft.getEncoding(), ft.getSize(),
                               ft.getMaxDataLength(), ft.getDataType(), fr);
    }

    // esse metodo serve apenas para limitar a dimensao do video, pois pode
    // acontecer de aparecer um formato que esteja entre os disponiveis, mas
    // que a placa de captura nao aceite.
    private VideoFormat getCustomFormat (VideoFormat vf, float fr)
    {
        if (vf instanceof YUVFormat)
        {
            return criarYuvFormat((YUVFormat) vf, fr);
        }
        else if (vf instanceof RGBFormat)
        {
            return criarRgbFormat((RGBFormat) vf, fr);
        }
        else if (vf instanceof AviVideoFormat)
        {
            return criarAviFormat((AviVideoFormat) vf, fr);
        }
        else if (vf instanceof H261Format)
        {
            return criarH261Format((H261Format) vf, fr);
        }
        else if (vf instanceof H263Format)
        {
            return criarH263Format((H263Format) vf, fr);
        }
        else if (vf instanceof IndexedColorFormat)
        {
            return criarIndexFormat((IndexedColorFormat) vf, fr);
        }
        else if (vf instanceof JPEGFormat)
        {
            return criarJPEGFormat((JPEGFormat) vf, fr);
        }
        else
        {
            return criarVideoFormat(vf, fr);
        }
    }

    private boolean dim2MelhorQueDim1 (Dimension dim1, Dimension dim2)
    {
        return (dim1.width * dim1.height) < (dim2.width * dim2.height);
    }

    // </editor-fold>
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos nao usados">
    private void alternarCapturePlayer ()
    {
        // Nao deu certo, provavelmente porque no jmf, de acordo com a pagina
        // known issues,
        // VFW capture can only be used once per instance of VM
//        Player playingPlayer = fullScreen ? capturePlayerFS : capturePlayer;
//        Player newPlayer = fullScreen ? capturePlayer : capturePlayerFS;
//        JmfUtils.deallocatePlayer(playingPlayer);
//        if (capturePlayerFS == null)
//        {
//            try
//            {
//                capturePlayerFS = Manager.createRealizedPlayer(
//                    ((SourceCloneable)captureDevice).createClone());
//            }
//            catch (IOException | NoPlayerException | CannotRealizeException ex)
//            {
//                System.out.println("erro ao criar player fs");
//            }
//        }
//        pnlImagem.removeAll();
//        pnlImagem.add(newPlayer.getVisualComponent(), BorderLayout.CENTER);
//        newPlayer.start();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="C_Captura">
    @Override
    public void capturaFoiAcionada ()
    {
        if (!(primeiraExecucao || StaticInfo.estacaoPossuiCaptura()))
        {
            if (sugerirDetectarCaptura)
            {
                DlgDetectarDisp dlg = new DlgDetectarDisp();
                dlg.setVisible(true);
                if (dlg.detectar())
                {
                    escolherDispsDeCaptura();
                }
                if (dlg.naoPerguntarNovamente())
                {
                    sugerirDetectarCaptura = false;
                    try
                    {
                        StaticInfo.salvarPropriedadeDaCaptura(
                                SUGERIR_DETECTAR_DISPOSITIVO, "false");
                    }
                    catch (Exception ex)
                    {
                    }
                }
            }
        }
    }

    @Override
    public boolean compactaVideos ()
    {
        return ENCODING_VIDEO.MJPG.toString().equals(videoEncoding);
    }

    @Override
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public void compactarVideo (File arqOrigem, File arqDestino)
    {
        Process p = null;
        try
        {
            List<String> comando = new ArrayList<>();
            comando.add(StaticInfo.getFFMPGEPath());
            comando.add("-i");
            comando.add(arqOrigem.getPath());
            int index = 0;
            String cmdCompactacao = lerCmdCompactacao(index);
            while (!(cmdCompactacao == null || cmdCompactacao.trim().isEmpty()))
            {
                switch (cmdCompactacao)
                {
                    case "videosize":
                        comando.add("-s");
                        Dimension videoSize = getVideoSize();
                        comando.add(videoSize.width + "x" + videoSize.height);
                        break;
                    default:
                        comando.add(cmdCompactacao);
                }
                index++;
                cmdCompactacao = lerCmdCompactacao(index);
            }
            comando.add(arqDestino.getPath());
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.redirectErrorStream(true);
            p = pb.start();
            InputStream is = p.getInputStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
            {
                String linha = br.readLine();
                while (linha != null)
                {
                    System.out.println(linha);
                    linha = br.readLine();
                }
            }
            if (p.waitFor() == 0)
            {
                arqOrigem.delete();
            }
            else
            {
            }
        }
        catch (IOException | InterruptedException ex)
        {
        }
        finally
        {
            if (p != null)
            {
                p.destroy();
            }
        }
    }

    @Override
    public String getCompressedVideoFileExtension ()
    {
        return extDoArqCompactado;
    }

    @Override
    public String getRecordedVideoFileExtension ()
    {
        return extDoArqGravado;
    }

    @Override
    public Dimension getVideoSize ()
    {
        return videoFormat == null ? new Dimension(10, 10) : videoFormat.getSize();
    }

    @Override
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public void escolherDispsDeCaptura ()
    {
        try
        {
            switch (JmfUtils.detectarDispositivos())
            {
                case JmfUtils.VIDEO_ENCONTRADO:
                case JmfUtils.AUDIO_E_VIDEO_ENCONTRADOS:
                    new SwingWorker<Void, Void>()
                    {
                        @Override
                        protected Void doInBackground () throws Exception
                        {
                            StaticInfo.reiniciarPropriedadesDaCaptura();
                            StaticInfo.salvarPropriedadeDaCaptura(
                                    POSSUI_DISPOSITIVO_DE_CAPTURA, "true");
                            StaticInfo.salvarPropriedadeDaCaptura(
                                    PRIMEIRA_EXECUCAO_DA_CAPTURA, "true");
                            return null;
                        }

                    }.execute();
                    JmfUtils.jogarArqPropAlteradoNaMaqLocal();
                    PnlLaudoeCia.getInstance().mostrarMsgSucesso(
                            "Dispositivo encontrado."
                            + "\nReinicie o computador para usar a captura.");
                    necessitaReiniciar = true;
                    break;
                default:
                    PnlLaudoeCia.getInstance().mostrarMsgErro(
                            "Nenhum dispositivo encontrado!");
            }
        }
        catch (Exception ex)
        {
            PnlLaudoeCia.getInstance().mostrarMsgErro(ex.getMessage());
        }
    }

    @Override
    public void foiParaFullScreen ()
    {
        pnlTotal.setFocusable(true);
        pnlTotal.requestFocusInWindow();
    }

    @Override
    public void voltouDoFullScreen ()
    {
        pnlTotal.setFocusable(false);
    }

    @Override
    public void setMouseListener (MouseListener ml)
    {
        if (ml == null)
        {
            throw new IllegalArgumentException("Ml null!");
        }
        else
        {
            this.ml = ml;
        }
    }

    @Override
    public void setKeyListener (KeyListener kl)
    {
        if (kl == null)
        {
            throw new IllegalArgumentException("Kl null!");
        }
        else
        {
            this.kl = kl;
        }
    }

    @Override
    public int estadoAtual ()
    {
        return estadoAtual;
    }

    @Override
    public Component getPnlCaptura ()
    {
        if (primeiraExecucao)
        {
            primeiraExecucao = false;
            carregarParametros();
            if (StaticInfo.estacaoPossuiCaptura())
            {
                try
                {
                    JmfUtils.carregarArquivoProperties();
                    carregarDispositivosDaCaptura(true);
                }
                catch (Exception ex)
                {
                }
            }
        }
        return layer;
    }

    @Override
    public void terminarGravacaoDeVideo ()
    {
        switch (estadoAtual)
        {
            case GRAVANDO_VIDEO:
            case GRAVACAO_PAUSADA:
                JmfUtils.cleanupPlayer(fileRecorder);
                dataSinkListener.waitEndOfStream();
                dataSinkRecord.close();
                setEstadoAtual(CAPTURANDO_IMAGEM);
                break;
            default:
            // a visao valida os outros casos
        }
    }

    @Override
    public boolean audioEstaDisponivel ()
    {
        return audioDevice != null;
    }

    @Override
    public void iniciarGravacaoDeVideo (File arquivoDeVideo, boolean gravarAudio)
            throws NoAudioException, SemDispDeCapturaException, ErroNaGravacaoException
    {
        switch (estadoAtual)
        {
            case NENHUM_DISPOSITIVO:
                throw new SemDispDeCapturaException();
            case REPRODUZINDO_VIDEO:
                alternarEstado();
                break;
            case GRAVACAO_PAUSADA:
            case GRAVANDO_VIDEO:
                // a visao valida esse caso
                break;
            default:
        }
        try
        {
            MediaLocator mediaDest = new MediaLocator(arquivoDeVideo.toURI().toURL());
            fileRecorder = Manager.createRealizedProcessor(createProcessorModel(gravarAudio));
            if (ENCODING_VIDEO.MJPG.getDesc().equals(videoEncoding))
            {
                JmfUtils.setJPEGQuality(fileRecorder, 1.0f);
            }
            dataSinkRecord = Manager.createDataSink(fileRecorder.getDataOutput(), mediaDest);
            dataSinkRecord.addDataSinkListener(dataSinkListener);
            dataSinkRecord.open();
            dataSinkRecord.start();
            fileRecorder.start();
            // <editor-fold defaultstate="collapsed" desc="File recorder pnl">

//            JFrame frame = new JFrame();
//            frame.setLayout(new BorderLayout());
//            frame.add(fileRecorder.getControlPanelComponent(), BorderLayout.CENTER);
//            frame.setSize(new Dimension(720, 480));
//            frame.setVisible(true);
            // </editor-fold>
            setEstadoAtual(GRAVANDO_VIDEO);
        }
        catch (CannotRealizeException ex)
        {
            if (gravarAudio)
            {
                throw new NoAudioException();
            }
            throw new ErroNaGravacaoException();
        }
        catch (NoDataSinkException | NoProcessorException |
               SecurityException | IOException ex)
        {
            throw new ErroNaGravacaoException();
        }
    }

    @Override
    public int alternarEstado ()
    {
        switch (estadoAtual)
        {
            case NENHUM_DISPOSITIVO:
            case CAPTURANDO_IMAGEM:
                return estadoAtual;
            case REPRODUZINDO_VIDEO:
                pnlImagem.removeAll();
                JmfUtils.cleanupPlayer(filePlayer);
                if (capturePlayer == null)
                {
                    setEstadoAtual(NENHUM_DISPOSITIVO);
                }
                else
                {
                    setEstadoAtual(CAPTURANDO_IMAGEM);
                    pnlImagem.add(capturePlayer.getVisualComponent(), BorderLayout.CENTER);
//                    pnlImagem.add(capturePlayer.getControlPanelComponent(), BorderLayout.SOUTH);
                    capturePlayer.start();
                }
                return estadoAtual;
            case GRAVACAO_PAUSADA:
                fileRecorder.start();
                setEstadoAtual(GRAVANDO_VIDEO);
                return estadoAtual;
            case GRAVANDO_VIDEO:
                fileRecorder.stop();
                setEstadoAtual(GRAVACAO_PAUSADA);
                return estadoAtual;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void desconectar ()
    {
        pnlImagem.removeAll();
        pnlImagem.repaint();
        JmfUtils.cleanupPlayer(filePlayer);
        JmfUtils.cleanupPlayer(capturePlayer);
        JmfUtils.cleanupPlayer(fileRecorder);
        if (videoDevice != null)
        {
            videoDevice.disconnect();
        }
        if (audioDevice != null)
        {
            audioDevice.disconnect();
        }
    }

    @Override
    public void pausarAtividades ()
    {
        switch (estadoAtual)
        {
            case CAPTURANDO_IMAGEM:
                capturePlayer.stop();
                break;
            default:
        }
    }

    @Override
    public void continuarAtividades ()
    {
        switch (estadoAtual)
        {
            case CAPTURANDO_IMAGEM:
                capturePlayer.start();
                break;
            default:
        }
    }

    @Override
    public Image capturarImagem () throws SemDispDeCapturaException, CapturaException
    {
        switch (estadoAtual)
        {
            case NENHUM_DISPOSITIVO:
                throw new SemDispDeCapturaException();
            default:
        }
        Player pp = getPlayingPlayer();
        if (pp == filePlayer)
        {
            double seconds = filePlayer.getMediaTime().getSeconds();
            return capturarFrameDoArquivo(seconds);
        }
        else
        {
            FrameGrabbingControl fgc = (FrameGrabbingControl) pp.getControl(FRAME_GRABBER);
            Buffer buffer = fgc.grabFrame();
            BufferToImage bti = new BufferToImage((VideoFormat) buffer.getFormat());
            Image createImage = bti.createImage(buffer);
            return ajus.ajustarImagem(recortador.recortarImagem(createImage));
        }
    }

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void reproduzirArquivoDeVideo (File arquivo) throws CapturaException
    {
        pnlImagem.removeAll();
        if (filePlayer != null)
        {
            JmfUtils.cleanupPlayer(filePlayer);
        }
        try
        {
            filePlayer = Manager.createRealizedPlayer(arquivo.toURI().toURL());
            filePlayer.addControllerListener(new PlayerEventHandler(filePlayer));
            pnlImagem.add(filePlayer.getVisualComponent(), BorderLayout.CENTER);
            pnlImagem.add(filePlayer.getControlPanelComponent(), BorderLayout.SOUTH);
            if (capturePlayer != null)
            {
                capturePlayer.stop();
            }
            setEstadoAtual(REPRODUZINDO_VIDEO);
            filePlayer.start();
            arqSendoRep = arquivo;
        }
        catch (IOException | NoPlayerException | CannotRealizeException ex)
        {
            ex.printStackTrace();
            throw new CapturaException("Erro ao reproduzir o arquivo");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new CapturaException("Erro ao reproduzir o arquivo");
        }
    }

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void configDispsDeCaptura () throws SemDispDeCapturaException, CapturaException
    {
        if (capturePlayer == null)
        {
            throw new SemDispDeCapturaException();
        }
        else
        {
            final Dimension size = videoFormat.getSize();
            desconectar();
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {

                    try
                    {
                        JmfUtils.mostrarPropDoDispDeCaptura(new Rectangle(
                                pnlTotal.getLocationOnScreen(), size));
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        try
                        {
                            throw new CapturaException("Erro ao abrir propriedades do"
                                                       + " dispositivo de captura!");
                        }
                        catch (CapturaException ex)
                        {
                        }
                    }
                    new SwingWorker<Void, Void>()
                    {
                        @Override
                        protected Void doInBackground () throws Exception
                        {
                            primeiraExecucao = true;
                            getPnlCaptura();
                            PnlLaudoeCia.getInstance().ocultarDlgAguarde();
                            return null;
                        }

                    }.execute();
                    PnlLaudoeCia.getInstance().mostrarDlgAguarde("Preparando as novas propriedades");
                }

            });

        }
    }

    @Override
    public void escolherFormato () throws SemDispDeCapturaException, CapturaException
    {
        switch (estadoAtual)
        {
            case NENHUM_DISPOSITIVO:
                throw new SemDispDeCapturaException();
            default:
                new DlgEscolherFormato().setVisible(true);
        }
    }

    @Override
    public boolean necessitaReiniciar ()
    {
        return necessitaReiniciar;
    }

    // </editor-fold>
    private void setEstadoAtual (int novoEstado)
    {
        if (estadoAtual == novoEstado)
        {
        }
        else
        {
            estadoAtual = novoEstado;
            switch (estadoAtual)
            {
                case CAPTURANDO_IMAGEM:
                case NENHUM_DISPOSITIVO:
                case REPRODUZINDO_VIDEO:
                    if (meuSw == null)
                    {
                    }
                    else
                    {
                        meuSw.cancel(true);
                    }
                    break;
                case GRAVANDO_VIDEO:
                case GRAVACAO_PAUSADA:
                    if (meuSw == null)
                    {
                    }
                    else
                    {
                        meuSw.cancel(true);
                    }
                    meuSw = new SwLblStatusDaGravacao();
                    meuSw.execute();
                    break;
                default:
            }
        }
    }

    private Dimension getPnlCapturaPreferredSize ()
    {
        if (videoFormat == null)
        {
            return new Dimension(640, 480);
        }
        else
        {
            return videoFormat.getSize();
        }
    }

    private class PnlCaptura extends MyJPanel
    {

        private PnlCaptura ()
        {
            super(new BorderLayout());
            setBackground(Color.black);
        }

    }

    private class PnlTotal extends MyJPanel
    {

        private PnlTotal ()
        {
            super(null);
            addComponentListener(new ComponentAdapter()
            {

                @Override
                public void componentResized (ComponentEvent e)
                {
                    Dimension newSize = getSize();
                    if (newSize.width > 0 && newSize.height > 0)
                    {
                        resized(newSize);
                    }
                }

            });
            setBackground(Color.black);
        }

        private void resized (Dimension newSize)
        {
            Dimension capturaPrefSize = getPnlCapturaPreferredSize();
            float aspectRatio = ((float) capturaPrefSize.width)
                                / ((float) capturaPrefSize.height);

            Dimension resize = pnlImagemSize(newSize, aspectRatio);
            int altura = resize.height;
            int largura = resize.width;

            int pnlImgX = (newSize.width - largura) / 2;
            int pnlImgY = (newSize.height - altura) / 2;

            pnlImagem.setBounds(pnlImgX, pnlImgY, largura, altura);

            if (pnlImgX <= pnlImgY)
            {
                lblHorGravacao.setBounds(0, 0, 200, 25);
                lblGravacao = lblHorGravacao;
                lblVertGravacao.setText("");
            }
            else
            {
                lblVertGravacao.setBounds(0, 0, 15, 200);
                lblGravacao = lblVertGravacao;
                lblHorGravacao.setText("");
            }
        }

        private Dimension pnlImagemSize (Dimension newSize, float aspectRatio)
        {
            if (newSize.width > larguraMinimaParaEstender)
            {
                return ImageUtils.getFitSize(newSize, aspectRatio);
            }
            else
            {
                return new Dimension(larguraInicialDoVideo, alturaInicialDoVideo);
            }
        }

    }

    private class SwLblStatusDaGravacao extends SwingWorker<Void, Integer>
    {

        private final int LBL_SEM_TEXTO = 0;
        private final int LBL_GRAVACAO_PAUSADA = 1;
        private final int LBL_GRAVANDO_VIDEO = 2;

        private boolean mostrarTexto = true;

        @Override
        protected void process (List<Integer> chunks)
        {
            if (isCancelled() || isDone())
            {
                return;
            }
            switch (chunks.get(0))
            {
                case LBL_SEM_TEXTO:
                    lblGravacao.setText("");
                    break;
                case LBL_GRAVACAO_PAUSADA:
                    lblGravacao.setText("GRAVAÇÃO PAUSADA");
                    lblGravacao.setForeground(Color.green);
                    break;
                case LBL_GRAVANDO_VIDEO:
                    lblGravacao.setText("GRAVANDO VÍDEO");
                    lblGravacao.setForeground(Color.RED);
                    break;
                default:
            }
        }

        @Override
        @SuppressWarnings("SleepWhileInLoop")
        protected Void doInBackground () throws Exception
        {
            while (!isCancelled())
            {
                switch (estadoAtual)
                {
                    case CAPTURANDO_IMAGEM:
                    case NENHUM_DISPOSITIVO:
                    case REPRODUZINDO_VIDEO:
                        break;
                    case GRAVANDO_VIDEO:
                        publish(mostrarTexto ? LBL_GRAVANDO_VIDEO : LBL_SEM_TEXTO);
                        break;
                    case GRAVACAO_PAUSADA:
                        publish(mostrarTexto ? LBL_GRAVACAO_PAUSADA : LBL_SEM_TEXTO);
                        break;
                    default:
                }
                Thread.sleep(500);
                mostrarTexto = !mostrarTexto;
            }
            return null;
        }

        @Override
        protected void done ()
        {
            lblHorGravacao.setText("");
            lblVertGravacao.setText("");
        }

    }

    private class MyLayerUI extends LayerUI<JPanel>
    {

        @Override
        protected void processMouseEvent (MouseEvent e, JLayer<? extends JPanel> l)
        {
            switch (e.getID())
            {
                case MouseEvent.MOUSE_CLICKED:
                    ml.mouseClicked(e);
                    break;
                case MouseEvent.MOUSE_PRESSED:
                    ml.mousePressed(e);
                    break;
                case MouseEvent.MOUSE_RELEASED:
                    ml.mouseReleased(e);
                    break;
                default:
            }
        }

        @Override
        protected void processKeyEvent (KeyEvent e, JLayer<? extends JPanel> l)
        {
            switch (e.getID())
            {
                case KeyEvent.KEY_RELEASED:
                    kl.keyReleased(e);
                    break;
                default:
            }
        }

    }

    private class LblVerticalGravacao extends MyJLabel
    {

        private LblVerticalGravacao ()
        {
            super("", true);

        }

    }

    private class DlgEscolherFormato extends MyJDialog
    {

        private MyJList<VideoFormat> jlist = new MyJList<>(formatosDisponiveis);
        private TxtInteiro txtFr = new TxtInteiro(2);
        private BalloonTip ajudaFr;

        private DlgEscolherFormato ()
        {
            super(PnlLaudoeCia.getInstance(), true, 600, 300);

            setTitle("Destaque em vermelho = formato atual");

            jlist.setCellRenderer(new MyListRenderer());

            MyJButton btnConfirmar = new MyJButton("Aplicar e sair");
            btnConfirmar.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    confirmar();
                }

            });
            MyJButton btnAplicar = new MyJButton("Aplicar");
            btnAplicar.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    aplicar();
                }

            });
            MyJButton btnSair = new MyJButton("Sair");
            btnSair.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    sair();
                }

            });

            MyJPanel pnlBotoes = new MyJPanel(new FlowLayout(FlowLayout.TRAILING));
            pnlBotoes.add(btnConfirmar);
            pnlBotoes.add(btnAplicar);
            pnlBotoes.add(btnSair);

            MyJPanel pnlFrameRate = new MyJPanel(new FlowLayout(FlowLayout.LEADING));
            pnlFrameRate.add(new MyJLabel("Quadros por segundo"));
            txtFr.setColumns(3);
            txtFr.setText(frameRate);
            pnlFrameRate.add(txtFr);
            MyJLabel lblAjuda = new MyJLabel("<html><u>?</u></html>");
            lblAjuda.setForeground(Color.blue);
            lblAjuda.setToolTipText("Clique para ver a ajuda do campo"
                                    + " quadros por segundo.");
            lblAjuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblAjuda.addMouseListener(new MouseAdapter()
            {

                @Override
                public void mouseClicked (MouseEvent e)
                {
                    ajudaFr = new BalloonTip(txtFr, msgAjudaSobreFr());
                    ajudaFr.setVisible(true);
                }

            });
            pnlFrameRate.add(lblAjuda);

            MyJPanel pnlSouth = new MyJPanel();
            pnlSouth.setLayout(new BoxLayout(pnlSouth, BoxLayout.PAGE_AXIS));
            pnlSouth.add(pnlFrameRate);
            pnlSouth.add(pnlBotoes);

            MyJPanel contentPane = new MyJPanel(new BorderLayout());
            contentPane.add(new MyJScrollPane(jlist), BorderLayout.CENTER);
            contentPane.add(pnlSouth, BorderLayout.SOUTH);
            setContentPane(new PnlComEspaco(contentPane));

            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    txtFr.requestFocusInWindow();
                }

            });

        }

        private String msgAjudaSobreFr ()
        {
            return "<html><font size=\"4\">É a quantidade de quadros processados"
                   + " em um segundo.<br>Quando maior, maior a sensação de "
                   + "continuidade da imagem,<br>"
                   + " mas os valores permitidos dependem da placa.<br>"
                   + "Recomenda-se deixar o valor padrão.</html>";
        }

        @Override
        public void fechar ()
        {
            if (ajudaFr != null && ajudaFr.isVisible())
            {
                ajudaFr.closeBalloon();
            }
            dispose();
        }

        private void confirmar ()
        {
            if (aplicar())
            {
                fechar();
            }
        }

        private boolean aplicar ()
        {
            try
            {
                if (ajudaFr != null && ajudaFr.isVisible())
                {
                    ajudaFr.closeBalloon();
                }
                if (txtFr.getInt() == 0)
                {
                    SwingUtils.mostrarAviso(this, "O campo quadros por segundo"
                                                  + " deve ser maior que zero.");
                    return false;
                }
                else
                {

                    VideoFormat vf = jlist.getSelectedValue();
                    boolean vfMudou = !(vf == null || formatoAtualSemFrameRate()
                                        .toString().equals(vf.toString()));
                    boolean frMudou = !Integer.valueOf(frameRate).equals(txtFr.getInt());
                    if (!(vfMudou || frMudou))
                    {
                        SwingUtils.mostrarAviso(this, vf == null
                                                      ? "Nenhum formato escolhido" : "Escolha um formato"
                                                                                     + " diferente do atual!");
                        return false;
                    }
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    SwDesconectar sw = new SwDesconectar();
                    sw.execute();
                    try
                    {
                        if (vfMudou)
                        {
                            formatoDesejado = vf.toString();
                            StaticInfo.salvarPropriedadeDaCaptura(
                                    FORMATO_DESEJADO, formatoDesejado);
                        }
                        if (frMudou)
                        {
                            frameRate = txtFr.getInt();
                            StaticInfo.salvarPropriedadeDaCaptura(
                                    FRAME_RATE, txtFr.getText());
                        }
                    }
                    catch (Exception ex)
                    {
                        SwingUtils.mostrarAviso(PnlLaudoeCia.getInstance(), "Não foi "
                                                                            + "possível salvar o novo formato no banco de dados!");
                    }
                    while (!sw.isDone())
                    {
                    }
                    try
                    {
                        if (!sw.isCancelled())
                        {
                            carregarDispositivosDaCaptura(false);
                        }
                    }
                    catch (Exception ex)
                    {
                        SwingUtils.mostrarAviso(PnlLaudoeCia.getInstance(),
                                                "Erro ao carregar novo formato!");
                    }
                    if (frMudou)
                    {
                        jlist.validate();
                        jlist.repaint();
                    }
                    return true;
                }
            }
            finally
            {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }

        private void sair ()
        {
            fechar();
        }

        private class MyListRenderer extends DefaultListCellRenderer
        {

            @Override
            public Component getListCellRendererComponent (JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
            {
                Component resp = super.getListCellRendererComponent(list,
                                                                    value, index, isSelected, cellHasFocus);
                if (value.toString().equals(formatoAtualSemFrameRate()))
                {
                    if (resp instanceof JComponent)
                    {
                        JComponent jc = (JComponent) resp;
                        jc.setBorder(new LineBorder(Color.red));
                    }
                }
                return resp;
            }

        }

    }

    private class SwDesconectar extends SwingWorker<Void, Void>
    {

        @Override
        protected Void doInBackground () throws Exception
        {
            desconectar();
            return null;
        }

    }

    private class DlgDetectarDisp extends MyJDialog
    {

        private boolean detectar = false;
        private MyJCheckBox chkNaoPerguntar = new MyJCheckBox("Não perguntar novamente");

        private DlgDetectarDisp ()
        {
            super(PnlLaudoeCia.getInstance(), true, 400, 120);
            setUndecorated(true);
            MyJPanel pnlBtns = new MyJPanel(new FlowLayout());
            final MyJButton btnSim = new MyJButton("Sim");
            btnSim.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    detectar = true;
                    dispose();
                }

            });
            MyJButton btnNao = new MyJButton("Não");
            btnNao.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    dispose();
                }

            });
            pnlBtns.add(btnSim);
            pnlBtns.add(btnNao);

            MyJPanel pnl = new MyJPanel();
            pnl.setLayout(new BoxLayout(pnl, BoxLayout.PAGE_AXIS));
            JLabel lbl = new LblNegrito("Deseja detectar o dispositivo de captura?");
            lbl.setFont(lbl.getFont().deriveFont(14f));
            pnl.add(Box.createVerticalStrut(10));
            pnl.add(lbl);
            pnl.add(Box.createVerticalStrut(10));
            pnl.add(chkNaoPerguntar);
            pnl.add(Box.createVerticalStrut(10));
            pnl.add(pnlBtns);
            pnl.add(Box.createVerticalStrut(10));
            pnl.setBorder(new BlackAndWhiteEtchedBorder());
            setContentPane(pnl);

            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    btnSim.requestFocusInWindow();
                }

            });

        }

        @Override
        public void fechar ()
        {
        }

        private boolean naoPerguntarNovamente ()
        {
            return chkNaoPerguntar.isSelected();
        }

        private boolean detectar ()
        {
            return detectar;
        }

    }

    private interface RecortadorDeImg
    {
        Image recortarImagem (Image image);

    }

    private interface AjustadorDeImg
    {
        Image ajustarImagem (Image image);
    }

    private class Ajust implements AjustadorDeImg
    {

        private ContrastFilter cf = new ContrastFilter();
        private HSBAdjustFilter hsbaf = new HSBAdjustFilter();

        private Ajust (float brilho, float contraste)
        {
            cf.setBrightness(brilho);
            cf.setContrast(contraste);

//            hsbaf.setSFactor(saturacao);
//            hsbaf.setHFactor(cor);

        }

        @Override
        public BufferedImage ajustarImagem (Image image)
        {
            BufferedImage b = ImageUtils.convertToBufferedImage(image);
            return cf.filter(b, b);
        }

    }

    private void configurarRecorte (final Recorte recorte)
    {
        this.recorte = recorte;
        recortador = new RecortadorDeImg()
        {

            @Override
            public Image recortarImagem (Image image)
            {
                return recortar(recorte, image);
            }

            private Image recortar (Recorte r, Image image)
            {
                try
                {
                    BufferedImage bi = ImageUtils.convertToBufferedImage(image);
                    return bi.getSubimage(r.getPosicaoX(), r.getPosicaoY(),
                                          r.getLargura(), r.getAltura());
                }
                catch (Exception e)
                {
                    return image;
                }
            }

        };
    }

    @Override
    public void escolherRecorte (byte[] img)
    {
        new DlgEscolherRecorte(img).setVisible(true);
    }

    private class DlgEscolherRecorte extends MyJDialog
    {

        private final BufferedImage imgOriginal;
        private final byte[] imgOriginalBytes;
        private DaoRecorte daoRecorte;
        private boolean recorteSelecionadoMudando = false;

        private DlgEscolherRecorte (final byte[] img)
        {
            super(PnlLaudoeCia.getInstance(), true, 800, 350);
            imgOriginal = new ConversorByteArrayImage().convertForward(img);
            imgOriginalBytes = img;
            setTitle("Escolha um recorte para a imagem");
            setResizable(true);

            MyJButton btnAdd = new MyJButton("Novo");
            btnAdd.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    novo();
                }

            });
            MyJButton btnExcluir = new MyJButton("Excluir");
            btnExcluir.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    excluir();
                }

            });
            MyJButton btnSalvar = new MyJButton("Salvar");
            btnSalvar.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    salvar();
                }

            });
            MyJButton btnUsar = new MyJButton("Usar");
            btnUsar.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed (ActionEvent e)
                {
                    usar();
                }

            });

            MyJPanel cp = new MyJPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.fill = GridBagConstraints.BOTH;
            c.gridheight = 2;
            c.gridwidth = 4;
            cp.add(new MyJScrollPane(lsRecortes), c);
            c.gridy = 2;
            c.gridheight = 1;
            c.gridwidth = 4;
            cp.add(new PnlComp(false, false, true).setComponent(new LblNegrito(""
                                                                               + " Em vermelho: recorte usado nesta estação")), c);
            c.gridwidth = 1;
            c.gridy = 3;
            c.ipadx = 20;
            cp.add(new PnlComp(false, false, true).setComponent(btnAdd), c);
            c.gridx = 1;
            cp.add(new PnlComp(false, true, true).setComponent(btnExcluir), c);
            c.gridx = 2;
            cp.add(new PnlComp(false, true, true).setComponent(btnSalvar), c);
            c.gridx = 3;
            cp.add(new PnlComp(false, true, true).setComponent(btnUsar), c);
            c.gridx = 4;
            c.gridwidth = 4;
            c.gridy = 0;
            c.ipadx = 0;
            cp.add(new PnlComp("Descrição", true, false).setComponent(txtDesc), c);
            c.gridy = 1;
            c.weighty = 1;
            c.gridwidth = 4;
            MyJPanel pnlImagens = new MyJPanel(new GridLayout(1, 2));
            pnlImagens.add(new PnlComp("Foto original", true, true).setComponent(pnlImgOriginal));
            pnlImagens.add(new PnlComp("Foto recortada", true, true).setComponent(pnlImgRecortada));
            cp.add(pnlImagens, c);
            c.weighty = 0;
            c.gridy = 2;
            c.weightx = 0.25;
            c.gridx = 4;
            c.gridwidth = 1;
            c.gridheight = 2;
            cp.add(new PnlComp("Posição X", true, true).setComponent(txtX), c);
            c.gridx = 5;
            cp.add(new PnlComp("Posição Y", true, true).setComponent(txtY), c);
            c.gridx = 6;
            cp.add(new PnlComp("Largura", true, true).setComponent(txtLargura), c);
            c.gridx = 7;
            cp.add(new PnlComp("Altura", true, true).setComponent(txtAltura), c);

            setContentPane(new PnlComEspaco(cp));

            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    pnlImgOriginal.setImagem(img);
                }

            });

            new SwingWorker<List<Recorte>, Void>()
            {

                @Override
                protected List<Recorte> doInBackground () throws Exception
                {
                    daoRecorte = new DaoRecorte();
                    return daoRecorte.listar();
                }

                @Override
                protected void done ()
                {
                    try
                    {
                        final List<Recorte> recortes = get();
                        Recorte r = new Recorte();
                        r.setDescricao(nenhum());
                        recortes.add(r);
                        lsRecortes.setItens(recortes);
                        if (recorte == null)
                        {
                            lsRecortes.setSelectedValue(r, true);
                        }
                        else
                        {
                            lsRecortes.setSelectedValue(recorte, true);
                        }
                    }
                    catch (Exception ex)
                    {
                    }
                }

            }.execute();
        }

        @Override
        public void fechar ()
        {
            dispose();
        }

        private void salvar ()
        {
            if (validar())
            {
                final Recorte r = lsRecortes.getSelectedValue();
                preencherRecorte(r);
                try
                {
                    daoRecorte.alterar(r);
                    if (r.equals(recorte))
                    {
                        recorte = r;
                    }
                    lsRecortes.setItens(new ArrayList<>(lsRecortes.getItens()));
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {

                        @Override
                        public void run ()
                        {
                            lsRecortes.setSelectedValue(r, true);
                        }

                    });
                }
                catch (Exception ex)
                {
                    PnlLaudoeCia.getInstance().mostrarMsgErro("Erro ao salvar o recorte!");
                }
            }
        }

        private void usar ()
        {
            Recorte r = lsRecortes.getSelectedValue();
            if (r != null)
            {
                String prop;
                if (r.getDescricao().equals(nenhum()))
                {
                    prop = "-";
                    recorte = null;
                    recortador = recortadorNull;
                }
                else
                {
                    prop = String.valueOf(r.getCodigo());
                    configurarRecorte(r);
                }
                try
                {
                    StaticInfo.salvarPropriedadeDaCaptura(RECORTE, prop);
                }
                catch (Exception e)
                {
                    PnlLaudoeCia.getInstance().mostrarAviso("Erro "
                                                            + "ao salvar propriedade!");
                }
                recorteDaEstacaoMudou();
            }
            else
            {
                PnlLaudoeCia.getInstance().mostrarAviso("Escolha um recorte!");
            }
        }

        private void novo ()
        {
            String desc = JOptionPane.showInputDialog("Digite uma descrição");
            if (desc != null && !desc.isEmpty())
            {
                desc = desc.toUpperCase();
                Recorte r = new Recorte();
                r.setDescricao(desc);
                r.setLargura(200);
                r.setAltura(200);
                try
                {
                    if (!nenhum().equals(desc) && daoRecorte.validarUnicidadeDeDesc(0, desc))
                    {
                        daoRecorte.adicionarComFlush(r);
                        List<Recorte> itens = new ArrayList<>(lsRecortes.getItens());
                        itens.add(r);
                        lsRecortes.setItens(itens);
                        lsRecortes.setSelectedValue(r, true);
                        recorteSelecionadoMudou();
                        usar();
                    }
                    else
                    {
                        PnlLaudoeCia.getInstance().mostrarMsgErro("A descrição"
                                                                  + " digitada ja foi usada!");
                    }
                }
                catch (Exception e)
                {
                    PnlLaudoeCia.getInstance().mostrarMsgErro("Erro ao criar novo registro!");
                }
            }
        }

        private void excluir ()
        {
            Recorte r = lsRecortes.getSelectedValue();
            if (r.getDescricao().equals(nenhum()))
            {
                PnlLaudoeCia.getInstance().mostrarAviso("O recorte "
                                                        + "selecionado não pode ser excluído");
            }
            else
            {
                try
                {
                    daoRecorte.apagar(r.getCodigo());
                    List<Recorte> rs = new ArrayList<>(lsRecortes.getItens());
                    rs.remove(r);
                    lsRecortes.setItens(rs);
                    lsRecortes.setSelectedIndex(-1);
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {

                        @Override
                        public void run ()
                        {
                            lsRecortes.setSelectedIndex(0);
                            recorteSelecionadoMudou();
                        }

                    });
                    if (r.equals(recorte))
                    {
                        recorte = null;
                        recortador = recortadorNull;
                    }
                }
                catch (Exception e)
                {
                    PnlLaudoeCia.getInstance().mostrarAviso("Erro ao excluir o recorte!");
                }
            }
        }

        // <editor-fold defaultstate="collapsed" desc="View">
        private final PnlImagem pnlImgOriginal = new PnlImagem();
        private final PnlImagem pnlImgRecortada = new PnlImagem();
        private final MyJList<Recorte> lsRecortes = new MyJList<Recorte>()
        {

            @Override
            public void setItens (List<Recorte> items)
            {
                Collections.sort(items, new Comparator<Recorte>()
                {

                    @Override
                    public int compare (Recorte o1, Recorte o2)
                    {
                        return o1.getDescricao().compareTo(o2.getDescricao());
                    }

                });
                super.setItens(items);
            }

        };
        private final MyJTextField txtDesc = new MyJTextField();
        private final TxtInteiro txtX = new TxtInteiro(3);
        private final TxtInteiro txtY = new TxtInteiro(3);
        private final TxtInteiro txtLargura = new TxtInteiro(4);
        private final TxtInteiro txtAltura = new TxtInteiro(4);


        {
            txtDesc.setDocumentFilter(new LimitedLengthDocFilter());
            lsRecortes.setCellRenderer(new DefaultListCellRenderer()
            {

                @Override
                public Component getListCellRendererComponent (JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
                {
                    Component resp = super.getListCellRendererComponent(list,
                                                                        value, index, isSelected, cellHasFocus);
                    if (value.equals(recorte) || (recorte == null && value.toString().equals(nenhum())))
                    {
                        if (resp instanceof JComponent)
                        {
                            JComponent jc = (JComponent) resp;
                            jc.setBorder(new LineBorder(Color.red));
                        }
                    }
                    return resp;
                }

            });
            lsRecortes.getSelectionModel().addListSelectionListener(new ListSelectionListener()
            {

                @Override
                public void valueChanged (ListSelectionEvent e)
                {
                    recorteSelecionadoMudou();
                }

            });

            TxtChangedListener lst = new TxtChangedListener()
            {

                @Override
                public void textChanged (DocumentEvent de)
                {
                    Recorte r = lsRecortes.getSelectedValue();
                    if (r != null && !recorteSelecionadoMudando)
                    {
                        if (r.getCodigo() == 0)
                        {
                        }
                        else
                        {
                            Recorte r2 = new Recorte();
                            preencherRecorte(r2);
                            atualizarImgRecortada(r2);
                        }
                    }
                }

            };
            txtX.addDocumentListener(lst);
            txtY.addDocumentListener(lst);
            txtLargura.addDocumentListener(lst);
            txtAltura.addDocumentListener(lst);

            pnlImgOriginal.setBorder(null);
            pnlImgRecortada.setBorder(null);

        }

        // </editor-fold>
        private String nenhum ()
        {
            return "Sem recorte";
        }

        private boolean validar ()
        {
            Recorte r = lsRecortes.getSelectedValue();
            if (r == null)
            {
                PnlLaudoeCia.getInstance().mostrarMsgErro("Escolha um recorte!");
                return false;
            }
            else
            {
                String desc = txtDesc.getText();
                if (r.getCodigo() == 0)
                {
                    PnlLaudoeCia.getInstance().mostrarMsgErro("A configuração "
                                                              + "'" + nenhum() + "' não pode ser alterada!");
                    return false;
                }
                if (desc.isEmpty())
                {
                    PnlLaudoeCia.getInstance().mostrarMsgErro("Escolha uma "
                                                              + "descrição!");
                    return false;
                }
                if (!daoRecorte.validarUnicidadeDeDesc(r.getCodigo(), desc))
                {
                    PnlLaudoeCia.getInstance().mostrarMsgErro("A descrição já "
                                                              + "foi utilizada para outro recorte!");
                    return false;
                }
                if (txtLargura.getInt() == 0 || txtAltura.getInt() == 0)
                {
                    PnlLaudoeCia.getInstance().mostrarMsgErro("Nem a largura nem "
                                                              + "a altura podem ser zero!");
                    return false;
                }
                return true;
            }
        }

        private void preencherRecorte (Recorte r)
        {
            r.setDescricao(txtDesc.getText());
            r.setPosicaoX(txtX.getInt());
            r.setPosicaoY(txtY.getInt());
            r.setLargura(txtLargura.getInt());
            r.setAltura(txtAltura.getInt());
        }

        private void recorteSelecionadoMudou ()
        {
            recorteSelecionadoMudando = true;
            Recorte r = lsRecortes.getSelectedValue();
            if (r == null || r.getCodigo() == 0)
            {
                txtDesc.setText("");
                txtX.setText("");
                txtY.setText("");
                txtLargura.setText("");
                txtAltura.setText("");
                txtDesc.setEditable(false);
                txtX.setEditable(false);
                txtY.setEditable(false);
                txtLargura.setEditable(false);
                txtAltura.setEditable(false);
                pnlImgRecortada.setImagem(imgOriginalBytes);
            }
            else
            {
                txtDesc.setText(r.getDescricao());
                txtX.setText(r.getPosicaoX());
                txtY.setText(r.getPosicaoY());
                txtLargura.setText(r.getLargura());
                txtAltura.setText(r.getAltura());
                txtDesc.setEditable(true);
                txtX.setEditable(true);
                txtY.setEditable(true);
                txtLargura.setEditable(true);
                txtAltura.setEditable(true);
                atualizarImgRecortada(r);
            }
            recorteSelecionadoMudando = false;
        }

        private void atualizarImgRecortada (Recorte r)
        {
            try
            {
                pnlImgRecortada.setImagem(cnv.convertReverse(
                        imgOriginal.getSubimage(r.getPosicaoX(), r.getPosicaoY(),
                                                r.getLargura(), r.getAltura())));
            }
            catch (Exception e)
            {
            }
        }

        private void recorteDaEstacaoMudou ()
        {
            lsRecortes.validate();
            lsRecortes.repaint();
        }

    }

}
