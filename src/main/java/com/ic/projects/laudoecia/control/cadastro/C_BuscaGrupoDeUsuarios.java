/*
 * C_BuscaGrupoDeUsuarios.java
 *
 * Created on 12/03/2012, 09:24:16
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoGrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaGrupoDeUsuarios extends AbsDefC_BuscaComCrud <GrupoDeUsuarios, Integer>
{

    private DaoGrupoDeUsuarios dao;

    public C_BuscaGrupoDeUsuarios (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoGrupoDeUsuarios(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoGrupoDeUsuarios) getDao();
    }

    @Override
    public List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
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

    @Override
    public Object[] criarLinhaSelecionada (GrupoDeUsuarios entidade)
    {
        return new Object[] { entidade.getCodigo(), entidade.getNome() };
    }

}
