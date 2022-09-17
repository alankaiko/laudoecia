/*
 * C_BuscaAtendimento.java
 *
 * Created on 23/04/2012, 09:20:38
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePacientes;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfExecutante;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.dao.cadastro.DaoParametroDoLaudo;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.iview.crud.ViewParamsBusca;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaAtendimento extends AbsDefC_BuscaComCrud<Atendimento, Integer>
{
    private DaoAtendimento daoAtd;
    private DaoProcDoAtd daoProc;
    private BuscadorDePacientes buscadorPac = new BuscadorDePacientes();
    private BuscadorDeProfExecutante buscadorProf = new BuscadorDeProfExecutante();
    private DaoParametroDoLaudo daoLaudo;
    public static final String LICENCA_EXPIROU = "LICENCA_EXPIROU";

    public C_BuscaAtendimento (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoAtendimento(), c_ParamsBusca, c_ResultadosDaBusca);
        daoAtd = (DaoAtendimento) getDao();
        daoProc = new DaoProcDoAtd();
    }

    @Override
    public Object[] criarLinhaSelecionada (Atendimento entidade)
    {
        return new Object[] { entidade.getCodigo(), entidade.getPaciente(),
                            entidade.getConvenio(), entidade.getDataAtendimento() };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        String statusLaudo = (String) paramsBusca[2];
        Date dataIni = (Date) paramsBusca[3];
        Date dataFin = (Date) paramsBusca[4];
        int maxResults = (int) paramsBusca[5];
        if ("indiferente".equalsIgnoreCase(statusLaudo))
        {
            statusLaudo = null;
        }
        switch (campo)
        {
            case "código":
                if (busca.matches("[0-9]+"))
                {
                    return daoAtd.buscarPorCodigo(Integer.valueOf(busca));
                }
                else
                {
                    return daoProc.buscarUltimos(dataIni, dataFin, statusLaudo, maxResults);
                }
            case "paciente":
                Paciente pac = buscadorPac.getSelectedModel();
                if (pac != null)
                {
                    return daoProc.buscarPorPaciente(pac, dataIni, dataFin, statusLaudo, maxResults);
                }
                return new ArrayList<>();
            case "prof. executante":
                ProfExecutante prof = buscadorProf.getSelectedModel();
                if (prof != null)
                {
                    return daoProc.buscarPorProfExecutante(prof, dataIni, dataFin, statusLaudo, maxResults);
                }
                return new ArrayList<>();
            case "laudo":
                if (busca == null || busca.length() < 3)
                {
                    return new ArrayList<>();
                }
                return getDaoLaudo().buscarPorFrag(busca, dataIni, dataFin, maxResults);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    protected void parametrosBuscaMudaram (Object[] newParamsBusca)
    {
        if (StaticInfo.LICENCIADO_LAUDO_VERSAO_TESTES.
                equals(StaticInfo.LICENCIADO_LAUDO))
        {
            if (daoAtd.existemMaisDe50Atd())
            {
                putProperty(LICENCA_EXPIROU, true);
            }
        }
    }

    @Override
    protected void parametrosBuscaMudaram (Object[] newParamsBusca, Object[] oldParamsBusca)
    {
        String newCampo = (String) newParamsBusca[1];
        String oldCampo = (String) oldParamsBusca[1];
        if (!newCampo.equals(oldCampo))
        {
            switch (newCampo)
            {
                case "paciente":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorPac);
                    break;
                case "prof. executante":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorProf);
                    break;
                default:
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, null);
            }
        }
    }

    private DaoParametroDoLaudo getDaoLaudo ()
    {
        if (daoLaudo == null)
        {
            daoLaudo = new DaoParametroDoLaudo();
        }
        return daoLaudo;
    }

}
