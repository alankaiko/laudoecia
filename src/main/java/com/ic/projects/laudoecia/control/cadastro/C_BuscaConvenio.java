/*
 * C_BuscaConvenio.java
 *
 * Created on 15/03/2012, 09:20:33
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoConvenio;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaConvenio extends AbsDefC_BuscaComCrud<Convenio, Integer>
{
    private DaoConvenio dao;

    public C_BuscaConvenio (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoConvenio(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoConvenio) getDao();
    }

    @Override
    public Object[] criarLinhaSelecionada (Convenio entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(), entidade.getNome(),
                    entidade.getTelefone(), entidade.isAtivo()
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
                return dao.buscarConveniosPorNome(busca);
            case "código":
                if (busca.matches("[0-9]+"))
                {
                    return dao.buscarConveniosPorCodigo(Integer.valueOf(busca));
                }
                return new ArrayList<>();
            default:
                return new ArrayList<>();
        }
    }

}
