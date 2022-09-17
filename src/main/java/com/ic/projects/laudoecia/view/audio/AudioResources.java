/*
 * AudioResources.java
 *
 * Created on 13/01/2012, 10:05:01
 */
package com.ic.projects.laudoecia.view.audio;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 *
 * @author Marcelo
 */
public class AudioResources
{

    private static File getUrlAudio (String audio) throws IOException
    {
        return new File(StaticInfo.getPastaDeRecursos() + audio);
    }

    @SuppressWarnings({"NestedAssignment", "UseSpecificCatch"})
    public static void executaArquivoDeAudio (String som)
    {
        AudioInputStream in = null;
        AudioInputStream din = null;
        try
        {
            in = AudioSystem.getAudioInputStream(getUrlAudio(som));
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
                    baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
                    false);
            din = AudioSystem.getAudioInputStream(decodedFormat, in);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            if (line != null)
            {
                line.open(decodedFormat);
                byte[] data = new byte[4096];
                // Start
                line.start();

                int nBytesRead;
                while ((nBytesRead = din.read(data, 0, data.length)) != -1)
                {
                    line.write(data, 0, nBytesRead);
                }
                // Stop
                line.drain();
                line.stop();
                line.close();
                din.close();
            }

        }
        catch (Exception e)
        {
        }
        finally
        {
            if (din != null)
            {
                try
                {
                    din.close();
                }
                catch (IOException e)
                {
                }
            }
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
    }

}
