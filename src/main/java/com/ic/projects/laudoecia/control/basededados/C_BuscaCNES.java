/*
 * C_BuscaCNES.java
 *
 * Created on 12/03/2012, 08:44:00
 */

package com.ic.projects.laudoecia.control.basededados;

import com.ic.projects.laudoecia.dao.basededados.DaoCNES;
import com.ic.projects.laudoecia.model.basededados.CNES;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.icontrol.crud.busca.AbsDefC_Busca;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaCNES extends AbsDefC_Busca<CNES, String>
{
    private DaoCNES dao;

    public C_BuscaCNES (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoCNES(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoCNES) getDao();
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
            case "nome fantasia":
                return dao.buscarPorNomeFantasia(busca, uf, maxResults);
            case "razão social":
                return dao.buscarPorRazaoSocial(busca, uf, maxResults);
            case "cnes":
                return dao.buscarPorCNES(busca, uf, maxResults);
            case "cnpj":
                return dao.buscarPorCNPJ(busca, uf, maxResults);
            case "cpf":
                return dao.buscarPorCPF(busca, uf, maxResults);
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (CNES entidade)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
