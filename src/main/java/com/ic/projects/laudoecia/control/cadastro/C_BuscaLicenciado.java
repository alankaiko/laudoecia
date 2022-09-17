/*
 * C_BuscaLicenciado.java
 *
 * Created on 04/04/2012, 11:27:44
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoLicenciado;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaLicenciado extends AbsDefC_BuscaComCrud<Licenciado, Integer>
{
    private DaoLicenciado dao;

    public C_BuscaLicenciado (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoLicenciado(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoLicenciado) getDao();
    }

    @Override
    public List<Object[]> listarResultados (Object[] paramsBusca)
    {
        return nullSafeListarResultados(paramsBusca);
    }

    @Override
    public Object[] criarLinhaSelecionada (Licenciado entidade)
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
