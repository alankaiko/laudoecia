/*
 * CDRecorder.java
 *
 * Created on 06/07/2012, 11:51:56
 */
package com.ic.projects.laudoecia.view.utils;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.notentities.SCSIDevice;
import com.lib.java.utils.StringUtils;
import com.lib.swing.utils.SwingUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class CDRecorder
{

    /**
     * Busca os dispositivos SCSI presentes no computador.
     * Faz o comando -scanbus
     *
     * @return uma lista de SCSIDevice
     */
    public static List<SCSIDevice> getDevices ()
    {
//        if (System.getProperty("os.name").contains("10"))
//        {
            return new ArrayList<>();
//        }
//        else
//        {
//            List<SCSIDevice> devices = new ArrayList<>();
//            try
//            {
//                List<String> comando = new ArrayList<>();
//                comando.add(StaticInfo.getCdRecordPath());
//                comando.add("-scanbus");
//                InputStream is = executeProcess(comando);
//                try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
//                {
//                    devices = SCSIDevice.devicesScannedFrom(br);
//                }
//            }
//            catch (IOException | InterruptedException ex)
//            {
//            }
//            return devices;
//        }
    }

    /**
     * Grava os arquivos passados pela lista no device escolhido.
     *
     * @param arquivos Lista de arquivos a gravar
     * @param device identificação do dispositivo de gravação ("0,0,0")
     * @return true se ocorreu tudo certo ou false caso dê alguma falha.
     */
    public static boolean burnCD (List<File> arquivos, String device)
    {
        if (device == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, "Dispositivo de gravação não encontrado");
            return false;
        }
        if (arquivos == null || arquivos.isEmpty())
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, "Não há arquivos a serem gravados");
            return false;
        }

        File fileISO;
        try
        {
            fileISO = createISO(arquivos, device);
        }
        catch (IOException ex)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, "Falha ao criar imagem do disco.");
            return false;
        }

        return burnISO2CD(fileISO, device);
    }

    private static InputStream executeProcess (List<String> comando) throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        String ex = "";
        InputStream is = process.getInputStream();
        CopyInputStream cis = new CopyInputStream(is);
        is = cis.getCopy();
        InputStream input1 = cis.getCopy();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                ex += line;
                System.out.println(line);
            }
            System.out.println("Done!\n\n");
        }

        if (process.waitFor() == 0)
        {
            try
            {
                process.destroy();
            }
            catch (Exception e)
            {
            }
            return input1;
        }
        else
        {
            try
            {
                process.destroy();
            }
            catch (Exception e)
            {
            }
            throw new IOException(ex);
        }
    }

    private static File createISO (List<File> arquivos, String device) throws IOException
    {
        List<String> comando = new ArrayList<>();
        comando.add(StaticInfo.getMkiSofsPath());
        comando.add("-graft-points");
        comando.add("-R");
        comando.add("-J");
        comando.add("-f");
        comando.add("-l");
        comando.add("-D");
        comando.add("-no-bak");
        comando.add("-o");

        File fileISO = File.createTempFile("JCDW", ".iso");
        String isoPath = fileISO.getAbsolutePath();
        comando.add(isoPath);

        String multiSessionPositions = getMultiSessionPositions(device);
        if (multiSessionPositions != null)
        {
            comando.add("-M");
            comando.add(device);
            comando.add("-C");
            comando.add(multiSessionPositions);
        }

        for (File file : arquivos)
        {
            StringBuilder fileStrIso = new StringBuilder("");
            fileStrIso.append("/\"").append(file.getName()).append("\"=");
            fileStrIso.append(file.getAbsolutePath().replace("\\", "/"));
            comando.add(fileStrIso.toString());
        }

        try
        {
            executeProcess(comando);
        }
        catch (InterruptedException ex)
        {
            fileISO = null;
        }

        return fileISO;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    private static boolean burnISO2CD (File fileISO, String device)
    {
        if (fileISO == null)
        {
            return false;
        }

        boolean result;
        try
        {
            List<String> comando = new ArrayList<>();
            comando.add(StaticInfo.getCdRecordPath());
            comando.add("-v");
            comando.add("-eject");
            comando.add("-multi");
            comando.add("dev=" + device);
            comando.add("speed=4");
            comando.add(fileISO.getAbsolutePath());
            executeProcess(comando);
            result = true;
        }
        catch (InterruptedException | IOException ex)
        {
            ex.printStackTrace();
            SwingUtils.mostrarMensagemDeErroConhecido(null, "Houve falha no "
                    + "processo de gravação!\nVerifique se há disco no "
                    + "dispositivo de gravação ou se o disco está vazio.\n"
                    + "Verifique ainda se o dispositivo de gravação está "
                    + "funcionando corretamente!");
            result = false;
        }
        finally
        {
            try
            {
                fileISO.delete();
            }
            catch (Exception e)
            {
            }
        }
        return result;
    }

    private static String getMultiSessionPositions (String device)
    {
        try
        {
            List<String> comando = new ArrayList<>();
            comando.add(StaticInfo.getCdRecordPath());
            comando.add("-msinfo");
            comando.add("dev=" + device);
            InputStream is = executeProcess(comando);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is)))
            {
                String line = br.readLine();
                if (StringUtils.parseableToDouble(line, true))
                {
                    return line;
                }
                return null;
            }
        }
        catch (IOException | InterruptedException ex)
        {
            return null;
        }
    }

    private static class CopyInputStream
    {
        private InputStream _is;
        private ByteArrayOutputStream _copy = new ByteArrayOutputStream();

        private CopyInputStream (InputStream is)
        {
            _is = is;

            try
            {
                copy();
            }
            catch (IOException ignored)
            {
            }
        }

        private int copy () throws IOException
        {
            int read = 0;
            int chunk = 0;
            byte[] data = new byte[256];

            while (-1 != (chunk = _is.read(data)))
            {
                read += data.length;
                _copy.write(data, 0, chunk);
            }

            return read;
        }

        private InputStream getCopy ()
        {
            return new ByteArrayInputStream(_copy.toByteArray());
        }

    }

}
