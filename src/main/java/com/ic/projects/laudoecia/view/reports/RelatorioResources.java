/*
 * RelatorioResources.java
 *
 * Created on 17/01/2012, 16:28:58
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.view.dialogs.DlgSaveAsPDF;
import com.lib.swing.utils.SwingUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Danilo Brito
 */
public class RelatorioResources
{
    private static DlgSaveAsPDF savePdfFile;

    private RelatorioResources ()
    {
    }

    @SuppressWarnings("unchecked")
    public static JRViewer criarRelatorio (String relatorio, Map<String, Object> parametros, List<?> lista)
    {
        InputStream is = RelatorioResources.class.getResourceAsStream("/jasper/" + relatorio);
        JasperPrint print;
        JRDataSource dataSource;
        if (lista != null)
        {
            dataSource = new JRBeanCollectionDataSource(lista);
        }
        else
        {
            dataSource = new JREmptyDataSource(1);
        }
        try
        {
            print = JasperFillManager.fillReport(is, parametros, dataSource);
            JRViewer viewer = new JRViewer(print);
            return viewer;
        }
        catch (JRException ex)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, ex.getMessage());
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public static JRViewer criarRelatorio (JasperDesign jd, Map<String, Object> parametros, List<?> lista)
    {
        JasperReport jr;
        JasperPrint print;
        JRDataSource dataSource;
        if (jd == null)
        {
            return null;
        }
        if (lista != null)
        {
            dataSource = new JRBeanCollectionDataSource(lista);
        }
        else
        {
            dataSource = new JREmptyDataSource(1);
        }
        try
        {
            jr = JasperCompileManager.compileReport(jd);
            print = JasperFillManager.fillReport(jr, parametros, dataSource);
            return new JRViewer(print);
        }
        catch (JRException ex)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, ex.getMessage());
            return null;
        }
    }

    public static void exportarRelatorioToPDF (String relatorio, Map<String, Object> parametros, List<?> lista, String defaultFileName)
    {
        InputStream is = RelatorioResources.class.getResourceAsStream("/jasper/" + relatorio);
        JasperPrint print;
        JRDataSource dataSource;

        if (lista != null)
        {
            dataSource = new JRBeanCollectionDataSource(lista);
        }
        else
        {
            dataSource = new JREmptyDataSource(1);
        }
        try
        {
            print = JasperFillManager.fillReport(is, parametros, dataSource);

            if (savePdfFile == null)
            {
                savePdfFile = new DlgSaveAsPDF(defaultFileName);
            }
            else
            {
                savePdfFile.setInicialFileName(defaultFileName);
            }

            String nomeArquivo = savePdfFile.getUserOutputFilePath();
            if (nomeArquivo != null)
            {
                JasperExportManager.exportReportToPdfFile(print, nomeArquivo);
                int resp = SwingUtils.obterConfirmacaoDoUsuario("Arquivo gravado com sucesso!\n"
                                                                              + "Deseja abrir o arquivo gerado?", null);
                if (resp == JOptionPane.YES_OPTION)
                {
                    File pdf = new File(nomeArquivo);
                    try
                    {
                        Desktop.getDesktop().open(pdf);
                    }
                    catch (Exception ex)
                    {
                        SwingUtils.mostrarAviso(null, "Houve uma falha ao tentar abrir o arquivo:\n" + ex.getMessage());
                    }
                }

            }
        }
        catch (JRException ex)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(null, ex.getMessage());
        }
    }

}
