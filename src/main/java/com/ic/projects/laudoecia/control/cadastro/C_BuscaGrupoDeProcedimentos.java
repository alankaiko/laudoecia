/*
 * C_BuscaGrupoDeProcedimentos.java
 *
 * Created on 14/03/2012, 17:39:45
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoGrupoProcedimento;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaGrupoDeProcedimentos extends AbsDefC_BuscaComCrud<GrupoProcedimento, Integer>
{
    private DaoGrupoProcedimento dao;

    public C_BuscaGrupoDeProcedimentos (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoGrupoProcedimento(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoGrupoProcedimento) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (GrupoProcedimento entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(), entidade.getNome()
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
                return dao.buscarCodigoseNomesQuandoNomeComecaCom(busca);
            case "código":
                if (busca.matches("[0-9]+"))
                {
                    return dao.buscarCodigoseNomesPorCodigo(Integer.valueOf(busca));
                }
                return new ArrayList<>();
            default:
                return new ArrayList<>();
        }
    }

}
