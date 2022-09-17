/*
 * C_BuscaTextoPadrao.java
 *
 * Created on 20/06/2012, 16:18:36
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoTextoPadrao;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaTextoPadrao extends AbsDefC_BuscaComCrud<TextoPadrao, Integer>
{
    private DaoTextoPadrao dao;

    public C_BuscaTextoPadrao (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoTextoPadrao(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoTextoPadrao) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (TextoPadrao entidade)
    {
        return new Object[] { entidade.getCodigo(), entidade.getAbreviatura() };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "abreviatura":
                return dao.buscarPorAbrev( busca, maxResults);
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

}
