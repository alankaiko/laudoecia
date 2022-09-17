/*
 * C_BuscaCrm.java
 *
 * Created on 09/03/2012, 17:05:52
 */

package com.ic.projects.laudoecia.control.basededados;

import com.ic.projects.laudoecia.dao.basededados.DaoCRM;
import com.ic.projects.laudoecia.model.basededados.Crm;
import com.ic.projects.laudoecia.model.basededados.UF;
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
public class C_BuscaCrm extends AbsDefC_Busca<Crm, Integer>
{
    private DaoCRM dao;

    public C_BuscaCrm (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoCRM(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoCRM) getDao();
    }

    @Override
    public List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        UF uf = (UF) paramsBusca[2];
        int maxResults = (int) paramsBusca[3];
        if (busca.isEmpty())
        {
            return new ArrayList<>();
        }
        switch (campo)
        {
            case "nome":
                return dao.buscarPorNome(busca, uf, maxResults);
            case "crm":
                return dao.buscarPorCrm(busca, uf, maxResults);
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
                case "crm":
                    putProperty(ViewParamsBusca.KEY_LABEL_DA_BUSCA, "Buscar por");
                    break;
                case "nome":
                    putProperty(ViewParamsBusca.KEY_LABEL_DA_BUSCA, "Buscar por Dr(a)");
                    break;
            }
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (Crm entidade)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
