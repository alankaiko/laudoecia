/*
 * C_BuscaRecorte.java
 *
 * Created on 20/06/2012, 16:18:36
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.cadastro.DaoRecorte;
import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaRecorte extends AbsDefC_BuscaComCrud<Recorte, Integer>
{
    private DaoRecorte dao;

    public C_BuscaRecorte (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoRecorte(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoRecorte) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (Recorte entidade)
    {
        return new Object[] { entidade.getCodigo(), entidade.getDescricao()};
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        switch (campo)
        {
            case "descrição":
                return dao.buscarPorDesc(busca);
            default:
                return new ArrayList<>();
        }
    }

}
