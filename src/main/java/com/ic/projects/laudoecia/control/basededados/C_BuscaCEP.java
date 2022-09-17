/*
 * C_BuscaCEP.java
 *
 * Created on 24/02/2012, 10:32:21
 */
package com.ic.projects.laudoecia.control.basededados;

import com.ic.projects.laudoecia.dao.basededados.DaoEnderecoPorCep;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.icontrol.crud.busca.AbsDefC_Busca;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaCEP extends AbsDefC_Busca<EnderecoPorCep, Integer>
{

    private DaoEnderecoPorCep dao;
    private boolean listarResultados = false;

    public C_BuscaCEP (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoEnderecoPorCep(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoEnderecoPorCep) getDao();
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        if (listarResultados)
        {
            String tipoBusca = (String) paramsBusca[0];
            int maxResults = (int) paramsBusca[1];
            switch (tipoBusca)
            {
                case "endereço":
                    Endereco endereco = (Endereco) paramsBusca[2];
                    return dao.buscarPorEndereco(endereco, maxResults);
                case "cep":
                    return dao.buscarPorCep((String) paramsBusca[3], maxResults);
                default:
                    return new ArrayList<>();
            }
        }
        else
        {
            return new ArrayList<>();
        }
    }

    @Override
    protected void parametrosBuscaMudaram (Object[] newParamsBusca, Object[] oldParamsBusca)
    {
        listarResultados = true;
    }

    @Override
    public Object[] criarLinhaSelecionada (EnderecoPorCep entidade)
    {
        Endereco e = entidade.getEndereco();
        if (e == null)
        {
            e = new Endereco();
        }
        return new Object[] { entidade.getCodigo(), e.getCep(),
                        e.getTipoDeLogradouro(), e.getLogradouro(),
                        e.getBairro(), e.getCidade()} ;
    }

}
