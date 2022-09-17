/*
 * C_BuscaProcMedico.java
 *
 * Created on 13/03/2012, 09:41:53
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeGrupoProcedimento;
import com.ic.projects.laudoecia.dao.auditable.DaoProcMedico;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.iview.crud.ViewParamsBusca;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaProcMedico extends AbsDefC_BuscaComCrud<ProcMedico, Integer>
{

    private DaoProcMedico dao;
    private BuscadorDeGrupoProcedimento buscador = new BuscadorDeGrupoProcedimento();

    public C_BuscaProcMedico (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoProcMedico(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoProcMedico) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (ProcMedico entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(), entidade.getNome(),
                    entidade.getGrupo()
                };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "nome":
                return dao.buscarPorNome( busca, maxResults);
            case "grupo":
                GrupoProcedimento grupo = buscador.getSelectedModel();
                if (grupo != null)
                {
                    return dao.buscarPorGrupo(grupo, maxResults);
                }
                return new ArrayList<>();
            case "código":
                if (busca.matches("[0-9]+"))
                {
                    return dao.buscarPorCodigo(Integer.valueOf(busca), maxResults);
                }
                return new ArrayList<>();
            default:
                return new ArrayList<>();
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
                case "grupo":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscador);
                    break;
                default:
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, null);
            }
        }
    }

}
