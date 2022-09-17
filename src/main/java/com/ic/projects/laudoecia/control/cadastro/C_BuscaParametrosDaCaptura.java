/*
 * C_BuscaParametrosDaCaptura.java
 *
 * Created on 25/07/2012, 14:49:20
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.cadastro.DaoParametrosDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaParametrosDaCaptura extends AbsDefC_BuscaComCrud<ParametrosDaCaptura, Integer>
{
    private DaoParametrosDaCaptura dao;

    public C_BuscaParametrosDaCaptura (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoParametrosDaCaptura(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoParametrosDaCaptura) getDao();
    }

    @Override
    public List<Object[]> listarResultados (Object[] paramsBusca)
    {
        return nullSafeListarResultados(paramsBusca);
    }

    @Override
    public Object[] criarLinhaSelecionada (ParametrosDaCaptura entidade)
    {
        return new Object[] { entidade.getCodigo() };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        List<Object[]> resposta = new ArrayList<>();
        resposta.add(new Object[] { dao.procurarPorId(StaticInfo.getParamsCaptura().getCodigo()).getCodigo() });
        return resposta;
    }

}
