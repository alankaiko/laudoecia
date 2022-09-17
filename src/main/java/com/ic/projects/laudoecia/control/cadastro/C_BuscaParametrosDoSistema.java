/*
 * C_BuscaParametrosDoSistema.java
 *
 * Created on 02/04/2012, 11:03:55
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaParametrosDoSistema extends AbsDefC_BuscaComCrud <ParametrosDoSistema, Integer>
{

    private DaoParametrosDoSistema dao;

    public C_BuscaParametrosDoSistema (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoParametrosDoSistema(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoParametrosDoSistema) getDao();
    }

    @Override
    public List<Object[]> listarResultados (Object[] paramsBusca)
    {
        return nullSafeListarResultados(paramsBusca);
    }

    @Override
    public Object[] criarLinhaSelecionada (ParametrosDoSistema entidade)
    {
        return new Object[] { entidade.getCodigo() };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        List<Object[]> resposta = new ArrayList<>();
        resposta.add(new Object[] { dao.procurarPorId(1).getCodigo() });
        return resposta;
    }

}
