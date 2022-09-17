/*
 * C_BuscaEstacaoDeTrabalho.java
 *
 * Created on 09/04/2012, 11:14:19
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoEstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaEstacaoDeTrabalho extends AbsDefC_BuscaComCrud<EstacaoDeTrabalho, Integer>
{
    private DaoEstacaoDeTrabalho dao;

    public C_BuscaEstacaoDeTrabalho (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoEstacaoDeTrabalho(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoEstacaoDeTrabalho) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (EstacaoDeTrabalho entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(), entidade.getNomeEstacaoDeTrabalho(),
                    entidade.getSerialHD()
                };
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        switch (campo)
        {
            case "nome":
                return dao.buscarEstacoesPorNome(busca);
            case "código":
                if (busca.matches("[0-9]+"))
                {
                    return dao.buscarEstacoesPorCodigo(Integer.valueOf(busca));
                }
                return new ArrayList<>();
            default:
                return new ArrayList<>();
        }
    }

}
