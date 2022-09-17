/*
 * HelpDoSistema.java
 *
 * Created on 17/09/2012, 11:39:05
 */
package com.ic.projects.laudoecia.view.utils;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.enums.TOPICOS_HELP;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.swing.utils.SwingUtils;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tekna <informatica@instrumental.net.br>
 */
public class HelpDoSistema
{

    private static Desktop desk = java.awt.Desktop.getDesktop();

    public static void abreManual (TOPICOS_HELP idMenu)
    {
        LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
        try
        {
            File indexFile = new File(StaticInfo.getPastaHelp() + "index.html");
            if (idMenu == null)
            {
                desk.browse(indexFile.toURI());
            }
            else
            {
                String param = "?id=" + idMenu.toString();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(indexFile)))
                {
                    bw.write("<html>\n");
                    bw.write("<head>\n");
                    bw.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
                    bw.write("<link rel=\"shortcut icon\" href=\"structure/img/help.ico\" type=\"image/x-icon\" />\n");
                    bw.write("<title>Ajuda do Sistema</title>\n");
                    bw.write("</head>\n");
                    bw.write("<FRAMESET ROWS=\"15%, 85%\">\n");
                    bw.write("<FRAME SRC=\"structure/header.html\" name=\"header\" noresize=\"noresize\">\n");
                    bw.write("<FRAMESET COLS=\"25%, 75%\">\n");
                    bw.write("<FRAME SRC=\"structure/menu.html" + param + "\" name=\"menu\">\n");
                    bw.write("<FRAME SRC=\"content/home.html\" name=\"content\">\n");
                    bw.write("</FRAMESET>\n");
                    bw.write("</FRAMESET>\n");
                    bw.write("<noframes>\n");
                    bw.write("<body>\n");
                    bw.write("Navegador não tem suporte a visualização deste help.\n");
                    bw.write("</body>\n");
                    bw.write("</noframes>\n");
                    bw.write("</html>");
                }
                desk.browse(indexFile.toURI());
            }
        }
        catch (IOException e)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(FormPrincipal.getInstance(),
                      "Não foi possível abrir o manual.\nVocê o pode abrir manualmente pela pasta de instalação do sistema.");
        }
        finally
        {
            LaudoeCia.getTelaPrincipal().setCursorToDefaultCursor();
        }
    }

}
