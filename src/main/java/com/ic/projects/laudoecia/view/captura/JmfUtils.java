/*
 * JmfUtils.java
 *
 * Created on 30/08/2011, 16:29:46
 */
package com.ic.projects.laudoecia.view.captura;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.utils.SwingUtils;
import com.sun.jna.Native;
import com.sun.media.ExclusiveUse;
import com.sun.media.util.Registry;

import javax.media.*;
import javax.media.Renderer;
import javax.media.control.FormatControl;
import javax.media.control.QualityControl;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;
import javax.media.protocol.CaptureDevice;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.List;

import static javax.media.PlugInManager.setPlugInList;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class JmfUtils
{

    private static MeuSw meuSw;

    // <editor-fold defaultstate="collapsed" desc="Flags">

    static final int NENHUM_DISPOSITIVO = 0;
    static final int AUDIO_ENCONTRADO = 1;
    static final int VIDEO_ENCONTRADO = 2;
    static final int AUDIO_E_VIDEO_ENCONTRADOS = 3;

    // </editor-fold>

    static int detectarDispositivos () throws Exception
    {
        try
        {
            reiniciarArqProperties();
        }
        catch (IOException ex)
        {
            throw new Exception("Erro ao mover o arquivo de propriedades.\n"
                    + "Execute o sistema como administrador!");
        }
        if (carregarArquivoProperties())
        {
            return new DlgDetectDevices().getStatus();
        }
        throw new Exception("Erro ao carregar arquivo properties!");
    }

    static void jogarArqPropAlteradoNaMaqLocal () throws IOException
    {
        File jmfPropDoJar = new File(StaticInfo.arquivoJmfPropertiesDoJar());
        File jmfSoundbankDoJar = new File(StaticInfo.arquivoJmfSoundBankDoJar());

        File jmfPropDaEstacao = new File(StaticInfo.arquivoJmfPropertiesDaEstacao());
        File jmfSoundbankDaEstacao = new File(StaticInfo.arquivoJmfSoundBankDaEstacao());

        Files.copy(jmfPropDoJar.toPath(), jmfPropDaEstacao.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(jmfSoundbankDoJar.toPath(), jmfSoundbankDaEstacao.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    static void mostrarPropDoDispDeCaptura (Rectangle rect) throws Exception
    {
        int id = (int) Native.getWindowID(FormPrincipal.getInstance());
        int deviceId = 0;
        Avicap32 lib = (Avicap32) Native.loadLibrary("AviCap32", Avicap32.class);
        User32 libU = (User32) Native.loadLibrary("User32", User32.class);

        int hWnd = lib.capCreateCaptureWindowA(String.valueOf(deviceId),
                                           Avicap32.WS_VISIBLE | Avicap32.WS_CHILD,
                                           rect.x, rect.y, rect.width, rect.height, id, 0);
        if (libU.SendMessageA(hWnd, Avicap32.WM_CAP_DRIVER_CONNECT, deviceId, 0) == 0)
        {
        }
        else
        {
            meuSw = new MeuSw(libU, hWnd, id);
            meuSw.execute();
            libU.SendMessageA(hWnd, Avicap32.WM_CAP_DLG_VIDEOSOURCE, -1, 0);
        }
        if (!(meuSw == null || meuSw.isDone()))
        {
            meuSw.cancel(true);
        }
        libU.SendMessageA(hWnd, Avicap32.WM_CAP_DRIVER_DISCONNECT, deviceId, 0);
        libU.DestroyWindow(hWnd);
    }

    static boolean carregarArquivoProperties ()
    {
        boolean success = false;
        InputStream in = null;
        try
        {
            try
            {
                File arqJmfPropDaEst = new File(StaticInfo.arquivoJmfPropertiesDaEstacao());
                if (arqJmfPropDaEst.exists())
                {
                    in = new FileInputStream(arqJmfPropDaEst);
                    success = readJMFRegistry(in);
                }
            }
            catch (FileNotFoundException ex)
            {
                SwingUtils.mostrarAviso(null, "Arquivo de propriedades"
                        + "da captura não está no local indicado!");
            }
            catch (IOException ex)
            {
                SwingUtils.mostrarAviso(null, "Arquivo com as propriedades"
                        + " da captura não pôde ser lido!");
            }
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                }
            }
        }
        return success;
    }

    static boolean tryToSetFormat (CaptureDevice capDev, Format format)
    {
        FormatControl formatControls[] = capDev.getFormatControls();
        for (int x = 0; x < formatControls.length; x++)
        {
            if (formatControls[x] == null)
            {
                continue;
            }

            Format supportedFormats[] = formatControls[x].getSupportedFormats();
            if (supportedFormats == null)
            {
                continue;
            }

            if (formatMatches(format, supportedFormats) != null)
            {
                formatControls[0].setFormat(format);
                return true;
            }
        }
        return false;
    }

    static void cleanupPlayer (Player player)
    {
        if (player != null)
        {
            deallocateToRealizedPlayer(player);
            player.close();
        }
    }

    static void waitForState (Player player, int state)
    {
        // Fast abort
        if (player.getState() == state)
        {
            return;
        }

        long startTime = new Date().getTime();

        long timeout = 5 * 1000;

        final Object waitListener = new Object();

        ControllerListener cl = new ControllerListener()
        {
            @Override
            public void controllerUpdate (ControllerEvent ce)
            {
                synchronized (waitListener)
                {
                    waitListener.notifyAll();
                }
            }

        };
        try
        {
            player.addControllerListener(cl);

            // Make sure we wake up every 500ms to check for timeouts and in case we miss a signal
            synchronized (waitListener)
            {
                while (player.getState() != state && new Date().getTime() - startTime < timeout)
                {
                    try
                    {
                        waitListener.wait(500);
                    }
                    catch (InterruptedException ex)
                    {
                    }
                }
            }
            if (new Date().getTime() - startTime > timeout)
            {
            }
        }
        finally
        {
            // No matter what else happens, we want to remove this
            player.removeControllerListener(cl);
        }
    }

    static float setJPEGQuality (Player p, float val)
    {
        Control cs[] = p.getControls();
        VideoFormat jpegFmt = new VideoFormat(VideoFormat.JPEG);
        // Loop through to find the Quality control for the JPEG encoder.
        for (int i = 0; i < cs.length; i++)
        {
            if (cs[i] instanceof QualityControl && cs[i] instanceof Owned)
            {
                Object owner = ((Owned) cs[i]).getOwner();
                // Check to see if the owner is a Codec.
                // Then check for the output format.
                if (owner instanceof Codec)
                {
                    Format fmts[] = ((Codec) owner).getSupportedOutputFormats(null);
                    for (int j = 0; j < fmts.length; j++)
                    {
                        if (fmts[j].matches(jpegFmt))
                        {
                            return ((QualityControl) cs[i]).setQuality(val);
                        }
                    }
                }
            }
        }
        return -1;
    }

    static void deallocateToRealizedPlayer (Player player)
    {
        if (player != null)
        {
            if (player.getState() == Player.Started)
            {
                player.stop();
                waitForState(player, Player.Prefetched);
            }

            if (player.getState() == Player.Prefetched)
            {
                player.deallocate();
                waitForState(player, Player.Realized);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Private stuff">

    private JmfUtils ()
    {
    }

    private static void reiniciarArqProperties () throws IOException
    {
        File jmfPropPadrao = new File(StaticInfo.arquivoJmfPropertiesPadrao());
        File jmfSoundbankPadrao = new File(StaticInfo.arquivoJmfSoundBankPadrao());

        File jmfPropDaEstacao = new File(StaticInfo.arquivoJmfPropertiesDaEstacao());
        File jmfSoundbankDaEstacao = new File(StaticInfo.arquivoJmfSoundBankDaEstacao());

        Files.copy(jmfPropPadrao.toPath(), jmfPropDaEstacao.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(jmfSoundbankPadrao.toPath(), jmfSoundbankDaEstacao.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static class MeuSw extends SwingWorker<Void, Void>
    {

        private User32 libU;
        private int hWnd;
        private int id;

        private MeuSw (User32 libU, int hWnd, int id)
        {
            this.libU = libU;
            this.hWnd = hWnd;
            this.id = id;
        }

        @Override
        @SuppressWarnings("SleepWhileInLoop")
        protected Void doInBackground () throws Exception
        {
            while (true)
            {
                Thread.sleep(50);
                libU.SendMessageA(hWnd, Avicap32.WM_CAP_GRAB_FRAME, -1, id);
            }
        }

    }

    private static Format formatMatches (Format format, Format supported[])
    {
        if (supported == null)
        {
            return null;
        }
        for (int i = 0; i < supported.length; i++)
        {
            if (supported[i].matches(format))
            {
                return supported[i];
            }
        }
        return null;
    }

    private static boolean readJMFRegistry (InputStream ris)
    {
        if (ris == null)
        {
            return false;
        }

        try
        {
            HashMap<String, Object> hash = new HashMap<>();
            try (ObjectInputStream ois = new ObjectInputStream(ris))
            {
                int tableSize = ois.readInt();
                int version = ois.readInt();
                if (version > 200)
                {
                    // Version number mismatch
                    // There could be errors in reading the registry
                }
                for (int i = 0; i < tableSize; i++)
                {
                    String key = ois.readUTF();
                    try
                    {
                        Object value = ois.readObject();
                        hash.put(key, value);
                    }
                    catch (ClassNotFoundException | OptionalDataException cnfe)
                    {
                    }
                }
            }
            ris.close();
            for (Map.Entry<String, Object> entry : hash.entrySet())
            {
                Registry.set(entry.getKey(), entry.getValue());
            }

        }
        catch (Throwable t)
        {
            return false;
        }
        return true;
    }

    @SuppressWarnings({"CallToThreadStartDuringObjectConstruction", "SleepWhileInLoop", "UseOfObsoleteCollectionType"})
    private static class DlgDetectDevices extends MyJDialog implements Runnable
    {

        private TextArea textBox = new TextArea(15, 50);
        private boolean done = false;
        private int status = NENHUM_DISPOSITIVO;
        private Thread detectThread = new Thread(this);

        private DlgDetectDevices ()
        {
            super(PnlLaudoeCia.getInstance(), true, 300, 300);
            setTitle("Detectando dispositivos de captura.");

            message("Essa operação pode demorar até 3 minutos. Aguarde");

            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    detectThread.setDaemon(true);
                    detectThread.start();

                    new MeuSw1().execute();
                }

            });

            setVisible();

        }

        @Override
        public void run ()
        {
            detectDirectAudio();
            detectS8DirectAudio();
            detectCaptureDevices();
            done = true;
        }

        private void detectCaptureDevices ()
        {
            // check if JavaSound capture is available
            message("Detectando dispositivos de áudio");
            Class<?> dsauto;
            try
            {
                dsauto = Class.forName("DirectSoundAuto");
                dsauto.newInstance();
                message("Dispositivo de áudio DirectSound detectado");
                status = AUDIO_ENCONTRADO;
            }
            catch (ThreadDeath td)
            {
                throw td;
            }
            catch (Throwable t)
            {
            }

            Class<?> jsauto;
            try
            {
                jsauto = Class.forName("JavaSoundAuto");
                jsauto.newInstance();
                message("Dispositivo de áudio JavaSound detectado");
                status = AUDIO_ENCONTRADO;
            }
            catch (ThreadDeath td)
            {
                throw td;
            }
            catch (Throwable t)
            {
                message("Erro detecção de dispositivo de áudio JavaSound!");
            }

            // Check if VFWAuto or SunVideoAuto is available
            message("Detectando dispositivos de vídeo");
            Class<?> auto = null;
            Class<?> autoPlus = null;
            try
            {
                auto = Class.forName("VFWAuto");
            }
            catch (Exception e)
            {
            }
            if (auto == null)
            {
                try
                {
                    auto = Class.forName("SunVideoAuto");
                }
                catch (Exception ee)
                {
                }
                try
                {
                    autoPlus = Class.forName("SunVideoPlusAuto");
                }
                catch (Exception ee)
                {
                }
            }
            try
            {
                Object instance = auto.newInstance();
                if (autoPlus != null)
                {
                    Object instancePlus = autoPlus.newInstance();
                }
                message("Dispositivo de vídeo WFW detectado");
                switch (status)
                {
                    case AUDIO_ENCONTRADO:
                        status = AUDIO_E_VIDEO_ENCONTRADOS;
                        break;
                    default:
                        status = VIDEO_ENCONTRADO;
                }
            }
            catch (ThreadDeath td)
            {
                throw td;
            }
            catch (Throwable t)
            {
                message("Erro detecção de dispositivo de vídeo!");
            }
        }

        private void detectDirectAudio ()
        {
            Class<?> cls;
            int plType = PlugInManager.RENDERER;
            String dar = "com.sun.media.renderer.audio.DirectAudioRenderer";
            try
            {
                // Check if this is the Windows Performance Pack - hack
                Class.forName("VFWAuto");
                // Check if DS capture is supported, otherwise fail DS renderer
                // since NT doesn't have capture
                Class.forName("com.sun.media.protocol.dsound.DSound");
                // Find the renderer class and instantiate it.
                cls = Class.forName(dar);

                Renderer rend = (Renderer) cls.newInstance();
                try
                {
                    // Set the format and open the device
                    AudioFormat af = new AudioFormat(AudioFormat.LINEAR,
                                                     44100, 16, 2);
                    rend.setInputFormat(af);
                    rend.open();
                    Format[] inputFormats = rend.getSupportedInputFormats();
                    // Register the device
                    PlugInManager.addPlugIn(dar, inputFormats, new Format[0],
                                            plType);
                    // Move it to the top of the list
                    @SuppressWarnings("unchecked")
                    List<Object> rendList = (List<Object>) PlugInManager.getPlugInList(null, null, plType);
                    int listSize = rendList.size();
                    if (rendList.get(listSize - 1).equals(dar))
                    {
                        rendList.remove(listSize - 1);
                        rendList.add(0, dar);
                        setPlugInList((Vector) rendList, plType);
                        PlugInManager.commit();
                        //System.err.println("registered");
                    }
                    rend.close();
                }
                catch (ResourceUnavailableException | IOException t)
                {
                    //System.err.println("Error " + t);
                }
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException tt)
            {
            }
        }

        private void detectS8DirectAudio ()
        {
            Class<?> cls;
            int plType = PlugInManager.RENDERER;
            String dar = "com.sun.media.renderer.audio.DirectAudioRenderer";
            try
            {
                // Check if this is the solaris Performance Pack - hack
                Class.forName("SunVideoAuto");

                // Find the renderer class and instantiate it.
                cls = Class.forName(dar);

                Renderer rend = (Renderer) cls.newInstance();

                if (rend instanceof ExclusiveUse
                    && !((ExclusiveUse) rend).isExclusive())
                {
                    // sol8+, DAR supports mixing
                    @SuppressWarnings("unchecked")
                    List<Object> rendList = (List<Object>) PlugInManager.getPlugInList(null, null, plType);
                    int listSize = rendList.size();
                    boolean found = false;
                    String rname;

                    for (int i = 0; i < listSize; i++)
                    {
                        rname = (String) (rendList.get(i));
                        if (rname.equals(dar))
                        { // DAR is in the registry
                            found = true;
                            rendList.remove(i);
                            break;
                        }
                    }
                    if (found)
                    {
                        rendList.add(0, dar);
                        PlugInManager.setPlugInList((Vector) rendList, plType);
                        PlugInManager.commit();
                    }
                }
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException tt)
            {
            }
        }

        private void message (String mesg)
        {
            textBox.append(mesg + "...\n\n");
        }

        private void setVisible ()
        {
            add(textBox, BorderLayout.CENTER);
            textBox.setEditable(false);
            setLocationRelativeTo(null);
            pack();
            setVisible(true);
        }

        private int getStatus ()
        {
            return status;
        }

        private void interromperThread ()
        {
            try
            {
                Thread.sleep(2000);
                detectThread.interrupt();
            }
            catch (Exception e)
            {
            }
        }

        @Override
        public void fechar ()
        {
            if (SwingUtils.obterConfirmacaoDoUsuario(""
                    + "Deseja cancelar a detecção?", this) == JOptionPane.YES_OPTION)
            {
                fecharDialog();
            }
        }

        private void fecharDialog ()
        {
            interromperThread();
            getContentPane().removeAll();
            dispose();
        }

        private class MeuSw1 extends SwingWorker<Void, Void>
        {

            @Override
            @SuppressWarnings("SleepWhileInLoop")
            protected Void doInBackground () throws Exception
            {
                int slept = 0;
                while (!done && slept < 60 * 1000 * 3)
                {
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException ie)
                    {
                    }
                    slept += 500;
                }

                if (!done)
                {
                    message("detecção abortada!");
                }

                return null;
            }

            @Override
            protected void done ()
            {
                fecharDialog();
            }

        }

    }

    // </editor-fold>

}
