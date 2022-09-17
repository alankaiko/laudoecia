/*
 * C_BuscaCBHPM.java
 *
 * Created on 09/03/2012, 10:05:10
 */

package com.ic.projects.laudoecia.control.basededados;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeGrupoCBHPM;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeSubgrupoCBHPM;
import com.ic.projects.laudoecia.dao.basededados.DaoCBHPM;
import com.ic.projects.laudoecia.model.basededados.CBHPM;
import com.ic.projects.laudoecia.model.basededados.GrupoCBHPM;
import com.ic.projects.laudoecia.model.basededados.SubgrupoCBHPM;
import com.lib.icontrol.crud.busca.AbsDefC_Busca;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.iview.crud.ViewParamsBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaCBHPM extends AbsDefC_Busca<CBHPM, String>
{

    private DaoCBHPM dao;
    private BuscadorDeGrupoCBHPM buscadorGrupo = new BuscadorDeGrupoCBHPM();
    private BuscadorDeSubgrupoCBHPM buscadorSubgrupo = new BuscadorDeSubgrupoCBHPM();

    public C_BuscaCBHPM (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoCBHPM(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoCBHPM) getDao();
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "procedimento":
                if (busca == null || busca.isEmpty())
                {
                    return new ArrayList<>();
                }
                return dao.buscarPorProcedimento(busca, maxResults);
            case "código":
                if (busca == null || busca.isEmpty())
                {
                    return new ArrayList<>();
                }
                String codigo = busca;
                codigo = codigo.replace(".", "").replace("-", "");
                return dao.buscarPorCodigo(codigo, maxResults);
            case "grupo":
                GrupoCBHPM grupoCBHPM = buscadorGrupo.getSelectedModel();
                if (grupoCBHPM != null)
                {
                    return dao.buscarPorGrupo(grupoCBHPM, maxResults);
                }
                return new ArrayList<>();
            case "subgrupo":
                SubgrupoCBHPM subgrupoCBHPM = buscadorSubgrupo.getSelectedModel();
                if (subgrupoCBHPM != null)
                {
                    return dao.buscarPorSubgrupo(subgrupoCBHPM, maxResults);
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
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorGrupo);
                    break;
                case "subgrupo":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorSubgrupo);
                    break;
                default:
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, null);
            }
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (CBHPM entidade)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
