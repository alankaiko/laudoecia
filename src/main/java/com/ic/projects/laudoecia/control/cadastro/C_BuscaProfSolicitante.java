/*
 * C_BuscaProfSolicitante.java
 *
 * Created on 12/03/2012, 17:14:23
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoProfSolicitante;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaProfSolicitante extends AbsDefC_BuscaComCrud<ProfSolicitante, Integer>
{
    private DaoProfSolicitante dao;

    public C_BuscaProfSolicitante (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoProfSolicitante(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoProfSolicitante) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (ProfSolicitante entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(),
                    entidade.getUfConselho(), entidade.getConselho(),
                    entidade.getNumNoConselho(), entidade.getNome()
                };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        Object busca = paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "nome":
                return dao.buscarPorNome((String) busca, maxResults);
            case "núm. conselho":
                return dao.buscarPorNroConselho((String) busca, maxResults);
            default:
                return new ArrayList<>();
        }
    }

}
