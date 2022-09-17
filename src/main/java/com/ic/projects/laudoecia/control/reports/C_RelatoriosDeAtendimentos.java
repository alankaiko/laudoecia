/*
 * C_RelatoriosDeAtendimentos.java
 *
 * Created on 26/01/2012, 15:54:18
 */
package com.ic.projects.laudoecia.control.reports;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.dao.cadastro.DaoParametroDoLaudo;
import com.ic.projects.laudoecia.model.auditable.*;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.lib.java.utils.Comparador;
import com.lib.java.utils.DateUtils;
import com.lib.model.cnv.ConversorByteArrayImage;
import java.awt.Image;
import static java.util.Collections.sort;
import java.util.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_RelatoriosDeAtendimentos
{
    private DaoProcDoAtd daoProc = new DaoProcDoAtd();
    private DaoParametroDoLaudo daoLaudo = new DaoParametroDoLaudo();
    private String filtros;
    private Boolean show_resumos;
    private String subReportDir;
    private String iconDir;
    private Map<String, Object> parametros;
    private List<ProcDoAtd> lista = new ArrayList<>();
    private List<ProcDoAtd> listaResumoProc = new ArrayList<>();
    private List<ProcDoAtd> listaResumoConv = new ArrayList<>();
    private List<ProcDoAtd> listaResumoProfExe = new ArrayList<>();
    private List<ProcDoAtd> listaResumoProfSol = new ArrayList<>();

    public C_RelatoriosDeAtendimentos (String subReportDir, String iconDir)
    {
        this.subReportDir = subReportDir;
        this.iconDir = iconDir;
    }

    private void initializeComponents (List<ProcDoAtd> listaDeProcedimentos, String filtros, boolean showResConv, boolean showResProc, boolean showResProfExe, boolean showResProfSol)
    {
        if (listaDeProcedimentos == null)
        {
            return;
        }
        setListas(listaDeProcedimentos, showResConv, showResProc, showResProfExe, showResProfSol);
        sortListByAtendimento(lista);
        sortListByDataAtendimento(lista);
        setFiltros(filtros);
        setShow_resumos(showResConv || showResProc || showResProfExe || showResProfSol);
    }

    public void configurarRelatorioCompleto (Date dataIni, Date dataFin, Boolean show_resumos, String statusLaudo)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarTodosPorData(dataIni, dataFin, statusLaudo.equals("indiferente") ? null : statusLaudo);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy")
                        + ("indiferente".equalsIgnoreCase(statusLaudo) ? "" :
                        " com situação do laudo " + statusLaudo);
        initializeComponents(listaDeProcedimentos, filtro, show_resumos, show_resumos, show_resumos, show_resumos);
        setParametrosDefault();
    }

    public void configurarRelatorioSoResumos (Date dataIni, Date dataFin, Boolean showProc, Boolean showConv, Boolean showProfExe, Boolean showProfSol)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarTodosPorData(dataIni, dataFin, null);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");
        initializeComponents(listaDeProcedimentos, filtro, showConv, showProc, showProfExe, showProfSol);
        setParametrosDefault();
    }

    public void configurarRelatorioPorProcMedico (ProcMedico procMed, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarPorProcedimentoEData(procMed, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");
        initializeComponents(listaDeProcedimentos, filtro, show_resumos, false, show_resumos, show_resumos);
        setParametrosDefault();
    }

    public void configurarRelatorioSoResumosPorProcMedico (ProcMedico procMed, Date dataIni, Date dataFin)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarPorProcedimentoEData(procMed, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy")
                        + "\nProcedimento: "+ procMed.getNome();
        initializeComponents(listaDeProcedimentos, filtro, true, false, true, true);
        setParametrosDefault();
    }

    public void configurarRelatorioPorConvenio (Convenio convenio, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarPorConvenioEData(convenio, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");
        initializeComponents(listaDeProcedimentos, filtro, false, show_resumos, show_resumos, show_resumos);
        setParametrosDefault();
    }

    public void configurarRelatorioSoResumosPorConvenio (Convenio convenio, Date dataIni, Date dataFin)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarPorConvenioEData(convenio, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy")
                        + "\nConvênio: "+ convenio.getNome();
        initializeComponents(listaDeProcedimentos, filtro, false, true, true, true);
        setParametrosDefault();
    }

    public void configurarRelatorioPorProfExecutanteLaudo (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        List<ProcDoAtd> listaDeProcedimentos = laudo.trim().isEmpty() ?
            daoProc.buscarPorProfExecutanteEData(profExe, dataIni, dataFin) :
            daoLaudo.buscarParaRel(laudo, profExe, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");
        initializeComponents(listaDeProcedimentos, filtro, show_resumos, show_resumos, false, show_resumos);
        listaResumoProfExe.clear();
        setParametrosDefault();
        parametros.put("EXEC", profExe == null ? "" : profExe.getCodigo() + " - " + profExe.getNome());
        parametros.put("LAUDO", laudo);
    }

    public void configurarRelatorioSoResumosPorProfExecutanteLaudo (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin)
    {
        List<ProcDoAtd> listaDeProcedimentos = laudo.trim().isEmpty() ?
            daoProc.buscarPorProfExecutanteEData(profExe, dataIni, dataFin) :
            daoLaudo.buscarParaRel(laudo, profExe, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");
        initializeComponents(listaDeProcedimentos, filtro, true, true, false, true);
        setParametrosDefault();
        parametros.put("EXEC", profExe == null ? "" :  profExe.getCodigo() + " - " + profExe.getNome());
        parametros.put("LAUDO", laudo);
    }

    public void configurarRelatorioPorProfSolicitante (ProfSolicitante profSol, Date dataIni, Date dataFin, Boolean show_resumos)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarPorProfSolicitanteEData(profSol, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");
        initializeComponents(listaDeProcedimentos, filtro, show_resumos, show_resumos, show_resumos, false);
        listaResumoProfSol.clear();
        setParametrosDefault();
    }

    public void configurarRelatorioSoResumosPorProfSolicitante (ProfSolicitante profSol, Date dataIni, Date dataFin)
    {
        List<ProcDoAtd> listaDeProcedimentos = daoProc.buscarPorProfSolicitanteEData(profSol, dataIni, dataFin);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy")
                        + "\nProf. Solicitante: "+ profSol.getNome();
        initializeComponents(listaDeProcedimentos, filtro, true, true, true, false);
        setParametrosDefault();
    }

    public void configurarGraficoPorConvenio (Date dataIni, Date dataFin)
    {
        this.lista = daoProc.buscarTodosPorData(dataIni, dataFin, null);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");

        sortListByAtendimento(this.lista);
        sortListByConvenio(this.lista);
        setFiltros(filtro);
        setParametrosDefault();
    }

    public void configurarGraficoPorProfExecutante (Date dataIni, Date dataFin)
    {
        this.lista = daoProc.buscarTodosPorData(dataIni, dataFin, null);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");

        sortListByProfExecutante(this.lista);
        setFiltros(filtro);
        setParametrosDefault();
    }

    public void configurarGraficoPorProfSolicitante (Date dataIni, Date dataFin)
    {
        this.lista = daoProc.buscarTodosPorData(dataIni, dataFin, null);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");

        sortListByAtendimento(this.lista);
        sortListByProfSoli(this.lista);
        setFiltros(filtro);
        setParametrosDefault();
    }

    public void configurarGraficoPorProcMedico (Date dataIni, Date dataFin)
    {
        this.lista = daoProc.buscarTodosPorData(dataIni, dataFin, null);
        String filtro = "De " + DateUtils.dateToString(dataIni, "dd/MM/yyyy")
                        + " até " + DateUtils.dateToString(dataFin, "dd/MM/yyyy");

        sortListByProcedimento(this.lista);
        setFiltros(filtro);
        setParametrosDefault();
    }

    public void configurarComprovanteAtend (Atendimento atendimento)
    {
        this.lista = atendimento.getProcedimentos();
        setParametrosComprovante();
    }

    //<editor-fold defaultstate="collapsed" desc="Gets">
    @SuppressWarnings("unchecked")
    public Map<String, Object> getParametros ()
    {
        //não colocado como unmodifiableMap pois o JasperReport irá adicionar novos parametros
        return parametros;
    }

    public List<ProcDoAtd> getLista ()
    {
        try
        {
            return Collections.unmodifiableList(lista);
        }
        catch (Exception e)
        {
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Private Methods">
    private void setParametrosDefault ()
    {
        Licenciado dadosLicenciado = StaticInfo.getLicenciado();
        parametros = new HashMap<>();
        parametros.put("NOME_EMPRESA", dadosLicenciado.getLicenciadoPara());
        parametros.put("LICENCIADO", dadosLicenciado.getLicenciadoPara());

        //parametros da classe para o relatório
        parametros.put("FILTROS", filtros);
        parametros.put("SHOW_RESUMOS", show_resumos);
        sortListByProcedimento(listaResumoProc);
        parametros.put("DATA_SOURCE_PROC", new JRBeanCollectionDataSource(listaResumoProc));
        sortListByAtendimento(listaResumoConv);
        sortListByConvenio(listaResumoConv);
        parametros.put("DATA_SOURCE_CONV", new JRBeanCollectionDataSource(listaResumoConv));
        sortListByProfExecutante(listaResumoProfExe);
        parametros.put("DATA_SOURCE_PROF_EXE", new JRBeanCollectionDataSource(listaResumoProfExe));
        sortListByAtendimento(listaResumoProfSol);
        sortListByProfSoli(listaResumoProfSol);
        parametros.put("DATA_SOURCE_PROF_SOL", new JRBeanCollectionDataSource(listaResumoProfSol));

        //parametro com caminho da pasta onde estao os sub relatorios e imagens
        parametros.put("SUBREPORT_DIR", subReportDir);
        parametros.put("ICON_URL", iconDir);
    }

    private void setParametrosComprovante ()
    {
        ParametrosDoSistema parametrosDoSistema = StaticInfo.getParametrosDoSistema();
        Licenciado dadosLicenciado = StaticInfo.getLicenciado();
        String telefone = dadosLicenciado.getTelefone1();
        StringBuilder sbTelefone = new StringBuilder(telefone);
        if (sbTelefone.length() != 0)
        {
            sbTelefone.insert(0, "(").insert(3, ") ").insert(9, "-");
        }
        byte[] logomarca = parametrosDoSistema.getLogomarcaLaudo();
        Image imagemTopo = null;
        if (logomarca != null)
        {
            imagemTopo = new ConversorByteArrayImage().convertForward(logomarca);
        }

        parametros = new HashMap<>();
        parametros.put("IMAGEM_TOPO", imagemTopo);
        if (parametrosDoSistema.getTextoCabecalhoLaudo() == null)
        {
            parametros.put("NOME_EMPRESA", dadosLicenciado.getLicenciadoPara());
            parametros.put("TELEFONE_EMPRESA", sbTelefone.toString());
        }
        else
        {
            parametros.put("NOME_EMPRESA", parametrosDoSistema.getTextoCabecalhoLaudo());
        }

        //rodape
        parametros.put("LICENCIADO_PARA", dadosLicenciado.getRazaoSocial());

        String endereco = dadosLicenciado.getEndereco() == null ?
                          "" : dadosLicenciado.getEndereco().toString();
        endereco += "\nFone:"+sbTelefone.toString();
        endereco += dadosLicenciado.getEmail().isEmpty() ? "" : " e-mail: " + dadosLicenciado.getEmail();
        endereco += dadosLicenciado.getSite().isEmpty() ? "" : " - " + dadosLicenciado.getSite();

        parametros.put("ENDERECO_EMPRESA", endereco);
    }

    private void setFiltros (String filtros)
    {
        this.filtros = filtros;
    }

    private void setShow_resumos (Boolean show_resumos)
    {
        this.show_resumos = show_resumos;
    }

    private void setListas (List<ProcDoAtd> list, boolean copyToConv, boolean copyToProc, boolean copyToProfExe, boolean copyToProfSol)
    {
        this.lista = list;

        /*
         * limpo a lista para quando o usuario fechar o relatorio e abrir
         * novamente nao liste valores repetidos no relatório e faz as cópias da
         * lista principal para os subreports
         */
        listaResumoConv.clear();
        listaResumoProc.clear();
        listaResumoProfExe.clear();
        listaResumoProfSol.clear();
        if (copyToConv)
        {
            listaResumoConv.addAll(list);
        }
        if (copyToProc)
        {
            listaResumoProc.addAll(list);
        }
        if (copyToProfExe)
        {
            listaResumoProfExe.addAll(list);
        }
        if (copyToProfSol)
        {
            listaResumoProfSol.addAll(list);
        }
    }

    private void sortListByAtendimento (List<ProcDoAtd> lista)
    {
        sort(lista, new Comparator<ProcDoAtd>()
        {
            @Override
            public int compare (ProcDoAtd o1, ProcDoAtd o2)
            {
                return Comparador.comparar(o1.getAtendimento().getCodigo(), o2.getAtendimento().getCodigo());
            }

        });
    }

    private void sortListByProcedimento (List<ProcDoAtd> lista)
    {
        sort(lista, new Comparator<ProcDoAtd>()
        {
            @Override
            public int compare (ProcDoAtd o1, ProcDoAtd o2)
            {
                ProcMedico proc1 = o1.getProcDaTabela().getProcMedico();
                ProcMedico proc2 = o2.getProcDaTabela().getProcMedico();
                return Comparador.comparar(proc1 == null ? 0 : proc1.getCodigo(), proc2 == null ? 0 : proc2.getCodigo());
            }

        });
    }

    private void sortListByConvenio (List<ProcDoAtd> lista)
    {
        sort(lista, new Comparator<ProcDoAtd>()
        {
            @Override
            public int compare (ProcDoAtd o1, ProcDoAtd o2)
            {
                return Comparador.comparar(o1.getAtendimento().getConvenio().getCodigo(), o2.getAtendimento().getConvenio().getCodigo());
            }

        });
    }

    private void sortListByProfExecutante (List<ProcDoAtd> lista)
    {
        sort(lista, new Comparator<ProcDoAtd>()
        {
            @Override
            public int compare (ProcDoAtd o1, ProcDoAtd o2)
            {
                ProfExecutante profExe1 = o1.getProfExecutante();
                ProfExecutante profExe2 = o2.getProfExecutante();
                return Comparador.comparar(profExe1 == null ? 0 : profExe1.getCodigo(), profExe2 == null ? 0 : profExe2.getCodigo());
            }

        });
    }

    private void sortListByProfSoli (List<ProcDoAtd> lista)
    {
        sort(lista, new Comparator<ProcDoAtd>()
        {
            @Override
            public int compare (ProcDoAtd o1, ProcDoAtd o2)
            {
                ProfSolicitante sol1 = o1.getAtendimento().getSolicitante();
                ProfSolicitante sol2 = o2.getAtendimento().getSolicitante();
                return Comparador.comparar(sol1 == null ? 0 : sol1.getCodigo(), sol2 == null ? 0 : sol2.getCodigo());
            }
        });
    }

    private void sortListByDataAtendimento (List<ProcDoAtd> lista)
    {
        sort(lista, new Comparator<ProcDoAtd>()
        {
            @Override
            public int compare (ProcDoAtd o1, ProcDoAtd o2)
            {
                return o1.getAtendimento().getDataAtendimento().compareTo(o2.getAtendimento().getDataAtendimento());
            }

        });
    }
    //</editor-fold>

}
