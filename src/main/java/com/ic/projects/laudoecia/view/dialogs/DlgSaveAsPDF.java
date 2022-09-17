/*
 * DlgSaveAsPDF.java
 *
 * Created on 07/03/2012, 08:18:15
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.lib.swing.utils.SwingUtils;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgSaveAsPDF extends JFileChooser
{
    private static File lastDir;
    private File inicialFile;

    public DlgSaveAsPDF (String inicialFileName)
    {
        setDialogTitle("Salvar como PDF");
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setFileFilter(new FileNameExtensionFilter("PDF (*.pdf)", "pdf"));
        this.inicialFile = new File(inicialFileName+".pdf");
    }

    public String getUserOutputFilePath ()
    {
        setSelectedFile(inicialFile);
        if (lastDir == null)
        {
            // fileChooser should start at default location
        }
        else
        {
            setCurrentDirectory(lastDir);
        }
        int retorno = showSaveDialog(null);
        lastDir = getCurrentDirectory();
        if (retorno == JFileChooser.APPROVE_OPTION)
        {
            if (getSelectedFile().getName().toLowerCase().startsWith(".pdf"))
            {
                SwingUtils.mostrarAviso(this, "Digite um nome de arquivo!");
                return getUserOutputFilePath();
            }
            String filePath = getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf"))
            {
                filePath += ".pdf";
            }
            if (new File(filePath).exists())
            {
                retorno = SwingUtils.obterConfirmacaoDoUsuario(
                        "O arquivo já existe!\nDeseja substituí-lo?", this);
                if (retorno != JOptionPane.YES_OPTION)
                {
                    return getUserOutputFilePath();
                }
            }
            return filePath;
        }
        return null;
    }

    public void setInicialFileName (String inicialFileName)
    {
        this.inicialFile = new File(inicialFileName+".pdf");
    }

}
