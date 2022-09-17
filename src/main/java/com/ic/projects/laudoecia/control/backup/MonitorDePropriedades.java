/*
 * MonitorDePropriedades.java
 *
 * Created on 24/04/2012, 10:49:48
 */

package com.ic.projects.laudoecia.control.backup;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class MonitorDePropriedades
{
    private WatchKey watchKey;
    private String valorAnterior;

    private String arqDePropriedades;
    private String chave;
    private Runnable runnable;

    public static final int defaultSleepTime = 2000;

    MonitorDePropriedades (String arqDePropriedades, String chave, Runnable runnable) throws IOException, InterruptedException
    {
        setWatchKey();
        this.arqDePropriedades = arqDePropriedades;
        this.chave = chave;
        this.runnable = runnable;
        valorAnterior = StaticInfo.lerPropriedade(arqDePropriedades, chave);
    }

    void start ()
    {
        LaudoeCia.getSoftwareView().runThread(new MyTask(), null);
    }

    private void setWatchKey () throws IOException, InterruptedException
    {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        File watchDirFile = new File(StaticInfo.getPastaProperties());
        Path watchDirPath = watchDirFile.toPath();
        watchKey = watchDirPath.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
    }

    private class MyTask implements Runnable
    {

        private String lerValorAtual ()
        {
            try
            {
                return StaticInfo.lerPropriedade(arqDePropriedades, chave);
            }
            catch (IOException ex)
            {
                return "";
            }
        }

        @Override
        @SuppressWarnings("SleepWhileInLoop")
        public void run ()
        {
            do
            {
                try
                {
                    Thread.sleep(defaultSleepTime);
                }
                catch (InterruptedException ex)
                {
                }
                for (WatchEvent<?> event : watchKey.pollEvents())
                {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY)
                    {
                        String valorAtual = lerValorAtual();
                        if (!Objects.equals(valorAtual, valorAnterior))
                        {
                            valorAnterior = valorAtual;
                            runnable.run();
                        }
                    }
                }
            } while (true);
        }

    }

}
