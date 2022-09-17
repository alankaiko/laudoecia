/*
 * C_BuscaEspecialidadeMedica.java
 *
 * Created on 12/03/2012, 08:53:40
 */

package com.ic.projects.laudoecia.control.basededados;

import com.ic.projects.laudoecia.dao.basededados.DaoEspecialidadeMedica;
import com.ic.projects.laudoecia.model.basededados.EspecialidadeMedica;
import com.lib.icontrol.crud.busca.AbsDefC_Busca;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaEspecialidadeMedica extends AbsDefC_Busca<EspecialidadeMedica, Integer>
{

    private DaoEspecialidadeMedica dao;

    public C_BuscaEspecialidadeMedica (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoEspecialidadeMedica(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoEspecialidadeMedica) getDao();
    }

    @Override
    public List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        switch (campo)
        {
            case "nome":
                return dao.buscarPorNome(busca);
            case "código":
                if (busca.matches("[0-9]+"))
                {
                    return dao.buscarPorCodigo(Integer.valueOf(busca));
                }
                else
                {
                    return new ArrayList<>();
                }
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (EspecialidadeMedica entidade)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
