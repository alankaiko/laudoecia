/*
 * RelAtendCreator.java
 *
 * Created on 06/03/2012, 11:06:14
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.reports.C_RelatoriosDeAtendimentos;
import com.ic.projects.laudoecia.model.auditable.*;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.validacao.ValidadorFiltroIntervaloDeDatas;
import com.lib.swing.utils.SwingUtils;
import net.sf.jasperreports.swing.JRViewer;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class RelAtendCreator
{
    private static C_RelatoriosDeAtendimentos controlador = new C_RelatoriosDeAtendimentos(
            RelatorioResources.class.getResource("/jasper/").toExternalForm(),
            ImageResources.getUrlImagem(ImagensLC.ICONE_LC).toExternalForm());
    private static boolean soResumosEnabled = false;

    //<editor-fold defaultstate="collapsed" desc="Funções GetRelatorio">
    public static JRViewer getRelatorioCompleto (Date dataIni, Date dataFin, Boolean show_resumos, String statusLaudo)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        controlador.configurarRelatorioCompleto(dataIni, dataFin, show_resumos, statusLaudo);
        return criarRelatorio(RelatoriosLC.REL_ATEND_COMPLETO,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioSoResumos (Date dataIni, Date dataFin, Boolean showProc, Boolean showConv, Boolean showProfExe, Boolean showProfSol)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (!showConv && !showProc && !showProfExe && !showProfSol)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar mostrar pelo menos um resumo");
            return null;
        }
        controlador.configurarRelatorioSoResumos(dataIni, dataFin, showProc, showConv, showProfExe, showProfSol);
        soResumosEnabled = true;
        return criarRelatorio(RelatoriosLC.REL_ATEND_RESUMOS,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioPorProcMedico (ProcMedico procMed, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (procMed == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um procedimento médico.");
            return null;
        }
        controlador.configurarRelatorioPorProcMedico(procMed, dataIni, dataFin, show_resumos);
        return criarRelatorio(RelatoriosLC.REL_ATEND_POR_PROC_MED,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioSoResumosPorProcMedico (ProcMedico procMed, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (procMed == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um procedimento médico.");
            return null;
        }
        controlador.configurarRelatorioSoResumosPorProcMedico(procMed, dataIni, dataFin);
        soResumosEnabled = true;
        return criarRelatorio(RelatoriosLC.REL_ATEND_RESUMOS,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioPorConvenio (Convenio convenio, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (convenio == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um convênio.");
            return null;
        }
        controlador.configurarRelatorioPorConvenio(convenio, dataIni, dataFin, show_resumos);
        return criarRelatorio(RelatoriosLC.REL_ATEND_POR_CONVENIO,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioSoResumosPorConvenio (Convenio convenio, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (convenio == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um convênio.");
            return null;
        }
        controlador.configurarRelatorioSoResumosPorConvenio(convenio, dataIni, dataFin);
        soResumosEnabled = true;
        return criarRelatorio(RelatoriosLC.REL_ATEND_RESUMOS,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioPorProfExecutante (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (profExe == null && laudo.trim().isEmpty())
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional executante ou um texto do laudo.");
            return null;
        }
        controlador.configurarRelatorioPorProfExecutanteLaudo(laudo, profExe, dataIni, dataFin, show_resumos);
        return criarRelatorio(RelatoriosLC.REL_ATEND_POR_PROF_EXE,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioSoResumosPorProfExecutante (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (profExe == null && laudo.trim().isEmpty())
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional executante ou um texto do laudo.");
            return null;
        }
        controlador.configurarRelatorioSoResumosPorProfExecutanteLaudo(laudo, profExe, dataIni, dataFin);
        soResumosEnabled = true;
        return criarRelatorio(RelatoriosLC.REL_ATEND_RESUMOS,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioPorProfSolicitante (ProfSolicitante profSol, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (profSol == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional solicitante.");
            return null;
        }
        controlador.configurarRelatorioPorProfSolicitante(profSol, dataIni, dataFin, show_resumos);
        return criarRelatorio(RelatoriosLC.REL_ATEND_POR_PROF_SOL,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getRelatorioSoResumosPorProfSolicitante (ProfSolicitante profSol, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        if (profSol == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional solicitante.");
            return null;
        }
        controlador.configurarRelatorioSoResumosPorProfSolicitante(profSol, dataIni, dataFin);
        soResumosEnabled = true;
        return criarRelatorio(RelatoriosLC.REL_ATEND_RESUMOS,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getGraficoPorConvenio (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        controlador.configurarGraficoPorConvenio(dataIni, dataFin);
        return criarRelatorio(RelatoriosLC.GRAF_ATEND_POR_CONVENIO,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getGraficoPorProfExecutante (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        controlador.configurarGraficoPorProfExecutante(dataIni, dataFin);
        return criarRelatorio(RelatoriosLC.GRAF_ATEND_POR_PROF_EXE,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getGraficoPorProfSolicitante (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        controlador.configurarGraficoPorProfSolicitante(dataIni, dataFin);
        return criarRelatorio(RelatoriosLC.GRAF_ATEND_POR_PROF_SOL,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getGraficoPorProcMedico (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return null;
        }
        controlador.configurarGraficoPorProcMedico(dataIni, dataFin);
        return criarRelatorio(RelatoriosLC.GRAF_ATEND_POR_PROC_MED,
                              controlador.getParametros(), controlador.getLista());
    }

    public static JRViewer getComprovante (Atendimento atendimento)
    {
        if (atendimento == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um atendimento.");
            return null;
        }
        controlador.configurarComprovanteAtend(atendimento);
        return criarRelatorio(RelatoriosLC.COMPROVANTE_ATENDIMENTO,
                              controlador.getParametros(), controlador.getLista());
    }

    private static JRViewer criarRelatorio (String relatorio, Map<String, Object> parametros, List<ProcDoAtd> lista)
    {
        if (lista == null || lista.isEmpty())
        {
            SwingUtils.mostrarAviso(null, "Não há movimentações no período!");
            return null;
        }
        if (soResumosEnabled)
        {
            lista = null;
            soResumosEnabled = false;
        }
        return RelatorioResources.criarRelatorio(relatorio, parametros, lista);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funções Exportar PDF">
    public static void exportPdfRelatorioCompleto (Date dataIni, Date dataFin, Boolean show_resumos, String statusLaudo)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        controlador.configurarRelatorioCompleto(dataIni, dataFin, show_resumos, statusLaudo);
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_COMPLETO, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos");
    }

    public static void exportPdfRelatorioSoResumos (Date dataIni, Date dataFin, Boolean showProc, Boolean showConv, Boolean showProfExe, Boolean showProfSol)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (!showConv && !showProc && !showProfExe && !showProfSol)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar mostrar pelo menos um resumo");
            return;
        }
        controlador.configurarRelatorioSoResumos(dataIni, dataFin, showProc, showConv, showProfExe, showProfSol);
        soResumosEnabled = true;
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_RESUMOS, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos Resumos");
    }

    public static void exportPdfRelatorioPorProcMedico (ProcMedico procMed, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (procMed == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um procedimento médico.");
            return;
        }
        controlador.configurarRelatorioPorProcMedico(procMed, dataIni, dataFin, show_resumos);
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_POR_PROC_MED, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos Por Procedimento");
    }

    public static void exportPdfRelatorioSoResumosPorProcMedico (ProcMedico procMed, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (procMed == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um procedimento médico.");
            return;
        }
        controlador.configurarRelatorioSoResumosPorProcMedico(procMed, dataIni, dataFin);
        soResumosEnabled = true;
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_RESUMOS, controlador.getParametros(),
                controlador.getLista(),"Relatório de Atendimentos Resumos Por Procedimento");
    }

    public static void exportPdfRelatorioPorConvenio (Convenio convenio, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (convenio == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um convênio.");
            return;
        }
        controlador.configurarRelatorioPorConvenio(convenio, dataIni, dataFin, show_resumos);
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_POR_CONVENIO, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos Por Convênio");
    }

    public static void exportPdfRelatorioSoResumosPorConvenio (Convenio convenio, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (convenio == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um convênio.");
            return;
        }
        controlador.configurarRelatorioSoResumosPorConvenio(convenio, dataIni, dataFin);
        soResumosEnabled = true;
        exportarRelatorioToPDF(RelatoriosLC.REL_ATEND_RESUMOS,
                controlador.getParametros(), controlador.getLista(),
                "Relatório de Atendimentos Resumos Por Convênio");
    }

    public static void exportPdfRelatorioPorProfExecutanteLaudo (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (profExe == null && laudo.trim().isEmpty())
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional executante ou um texto do laudo.");
            return;
        }
        controlador.configurarRelatorioPorProfExecutanteLaudo(laudo, profExe, dataIni, dataFin, show_resumos);
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_POR_PROF_EXE, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos Por Profissional Executante / Diagnóstico");
    }

    public static void exportPdfRelatorioSoResumosPorProfExecutanteLaudo (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (profExe == null && laudo.trim().isEmpty())
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional executante ou um diagnóstico.");
            return;
        }
        controlador.configurarRelatorioSoResumosPorProfExecutanteLaudo(laudo, profExe, dataIni, dataFin);
        soResumosEnabled = true;
        exportarRelatorioToPDF(RelatoriosLC.REL_ATEND_RESUMOS,
                               controlador.getParametros(), controlador.getLista(),
                               "Relatório de Atendimentos Resumos Por Profissional Executante / Diagnóstico");
    }

    public static void exportPdfRelatorioPorProfSolicitante (ProfSolicitante profSol, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (profSol == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional solicitante.");
            return;
        }
        controlador.configurarRelatorioPorProfSolicitante(profSol, dataIni, dataFin, show_resumos);
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_POR_PROF_SOL, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos por Profissional Solicitante");
    }

    public static void exportPdfRelatorioSoResumosPorProfSolicitante (ProfSolicitante profSol, Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        if (profSol == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um profissional solicitante.");
            return;
        }
        controlador.configurarRelatorioSoResumosPorProfSolicitante(profSol, dataIni, dataFin);
        soResumosEnabled = true;
        exportarRelatorioToPDF(
                RelatoriosLC.REL_ATEND_RESUMOS, controlador.getParametros(),
                controlador.getLista(), "Relatório de Atendimentos Resumospor Profissional Solicitante");
    }

    public static void exportPdfGraficoPorConvenio (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        controlador.configurarGraficoPorConvenio(dataIni, dataFin);
        exportarRelatorioToPDF(
                RelatoriosLC.GRAF_ATEND_POR_CONVENIO, controlador.getParametros(),
                controlador.getLista(), "Gráfico de Atendimentos por Convênio");
    }

    public static void exportPdfGraficoPorProfExecutante (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        controlador.configurarGraficoPorProfExecutante(dataIni, dataFin);
        exportarRelatorioToPDF(
                RelatoriosLC.GRAF_ATEND_POR_PROF_EXE, controlador.getParametros(),
                controlador.getLista(), "Gráfico de Atendimentos por Profissional Executante");
    }

    public static void exportPdfGraficoPorProfSolicitante (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        controlador.configurarGraficoPorProfSolicitante(dataIni, dataFin);
        exportarRelatorioToPDF(
                RelatoriosLC.GRAF_ATEND_POR_PROF_SOL, controlador.getParametros(),
                controlador.getLista(), "Gráfico de Atendimentos por Profissional Solicitante");
    }

    public static void exportPdfGraficoPorProcMedico (Date dataIni, Date dataFin)
    {
        if (!ValidadorFiltroIntervaloDeDatas.validarDatas(dataIni, dataFin))
        {
            return;
        }
        controlador.configurarGraficoPorProcMedico(dataIni, dataFin);
        exportarRelatorioToPDF(
                RelatoriosLC.GRAF_ATEND_POR_PROC_MED, controlador.getParametros(),
                controlador.getLista(), "Gráfico de Atendimentos por Procedimento");
    }

    public static void exportPdfComprovante (Atendimento atendimento)
    {
        if (atendimento == null && atendimento.getProcedimentos() == null)
        {
            SwingUtils.mostrarAviso(null, "Você deve selecionar um atendimento.");
            return;
        }
        controlador.configurarComprovanteAtend(atendimento);
        exportarRelatorioToPDF(
                RelatoriosLC.COMPROVANTE_ATENDIMENTO, controlador.getParametros(),
                controlador.getLista(), "Atendimento " + atendimento.getCodigo());
    }

    private static void exportarRelatorioToPDF (String relatorio, Map<String, Object> parametros, List<ProcDoAtd> lista, String defaultFileName)
    {
        if (lista == null || lista.isEmpty())
        {
            SwingUtils.mostrarAviso(null, "Não há movimentações no período.");
            return;
        }
        if (soResumosEnabled)
        {
            lista = null;
            soResumosEnabled = false;
        }
        RelatorioResources.exportarRelatorioToPDF(relatorio, parametros, lista, defaultFileName);
    }
    //</editor-fold>

}
