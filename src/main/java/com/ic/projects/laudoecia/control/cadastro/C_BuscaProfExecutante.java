/*
 * C_BuscaProfExecutante.java
 *
 * Created on 15/03/2012, 11:12:08
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoProfExecutante;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaProfExecutante extends AbsDefC_BuscaComCrud<ProfExecutante, Integer>
{
    private DaoProfExecutante dao;

    public C_BuscaProfExecutante (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoProfExecutante(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoProfExecutante) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (ProfExecutante entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(), entidade.getNome(),
                    entidade.getNumNoConselho(), entidade.getConselho(),
                    entidade.getUfConselho()
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
