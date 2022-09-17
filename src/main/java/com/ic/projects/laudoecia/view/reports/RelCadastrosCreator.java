/*
 * RelAuditoriaCreator.java
 *
 * Created on 23/03/2012, 08:58:04
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.reports.C_RelCadastros;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import net.sf.jasperreports.swing.JRViewer;

import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class RelCadastrosCreator
{
    private static C_RelCadastros controlador = new C_RelCadastros(
            RelatorioResources.class.getResource("/jasper/").toExternalForm(),
            ImageResources.getUrlImagem(ImagensLC.ICONE_LC).toExternalForm()
            );

    public static JRViewer getRelatorio (int tela, List<?> list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        switch (tela)
        {
            case TelaPrincipal.REL_PROC_MEDICO:
                return RelatorioResources.criarRelatorio(RelatoriosLC.REL_PROC_MEDICO,
                    controlador.getParametros(), list);
            case TelaPrincipal.REL_PROF_EXEC:
                return RelatorioResources.criarRelatorio(RelatoriosLC.REL_PROF_EXEC,
                    controlador.getParametros(), list);
            case TelaPrincipal.REL_CONVENIOS:
                return RelatorioResources.criarRelatorio(RelatoriosLC.REL_CONVENIOS,
                    controlador.getParametros(), list);
            case TelaPrincipal.REL_PACIENTES:
                return RelatorioResources.criarRelatorio(RelatoriosLC.REL_PACIENTES,
                    controlador.getParametros(), list);
            default:
                return null;
        }

    }

    public static boolean exportToPDF (int tela, List<?> list)
    {
        if (list == null || list.isEmpty())
        {
            return false;
        }
        switch (tela)
        {
            case TelaPrincipal.REL_PROC_MEDICO:
                RelatorioResources.exportarRelatorioToPDF(RelatoriosLC.REL_PROC_MEDICO,
                    controlador.getParametros(), list, "Relatório Procedimentos Médicos");
                break;
            case TelaPrincipal.REL_PROF_EXEC:
                RelatorioResources.exportarRelatorioToPDF(RelatoriosLC.REL_PROF_EXEC,
                    controlador.getParametros(), list, "Relatório Profissionais Executantes");
                break;
            case TelaPrincipal.REL_CONVENIOS:
                RelatorioResources.exportarRelatorioToPDF(RelatoriosLC.REL_CONVENIOS,
                    controlador.getParametros(), list, "Relatório Convênios");
                break;
            case TelaPrincipal.REL_PACIENTES:
                RelatorioResources.exportarRelatorioToPDF(RelatoriosLC.REL_PACIENTES,
                    controlador.getParametros(), list, "Relatório Pacientes");
                break;
            default:
                return false;
        }
        return true;

    }

}
