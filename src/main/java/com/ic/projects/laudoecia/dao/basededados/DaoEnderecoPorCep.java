/*
 * DaoEnderecoPorCep.java
 *
 * Created on 10/02/2012, 08:15:31
 */
package com.ic.projects.laudoecia.dao.basededados;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.dao.general.*;
import com.lib.java.utils.StringUtils;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DaoEnderecoPorCep extends GenericDaoWithIntegerId<EnderecoPorCep>
{
    public DaoEnderecoPorCep ()
    {
        super(PUs.BASE_DE_DADOS_PU, EnderecoPorCep.class);
    }

    public List<String> listarCidades (UF uf)
    {
        QueryBuilder qb = new QueryBuilder(new Select(true, "endereco.cidade"),
                                           new Where("endereco.uf"));
        qb.setParametro("uf", uf);
        return getResultList(qb, String.class);
    }

    public List<String> listarBairros (UF uf, String cidade)
    {
        QueryBuilder qb = new QueryBuilder(new Select(true, "endereco.bairro"),
                new Where("endereco.uf"), new And("endereco.cidade"),
                new Length("endereco.bairro"));
        qb.setParametro("uf", uf);
        qb.setParametro("cidade", cidade);
        qb.setParametro(Length.LENGTH, 0);
        return getResultList(qb, String.class);
    }

    public List<Endereco> procurarEnderecoBuscandoPorCep (String cep)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("endereco"),
                new Where("endereco.cep"));
        qb.setParametro("cep", cep);
        return getResultList(qb, Endereco.class);
    }

    public List<Object[]> buscarPorCep (String cep, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "endereco.cep", "endereco.tipoDeLogradouro",
                           "endereco.logradouro", "endereco.bairro", "endereco.cidade"),
                new Where(true, "endereco.cep", LIKE),
                new OrderBy("endereco.cep"));
        qb.setParametro("cep", configurarParamBusca(cep, false).
                replace(".", "").replace("-", ""));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<Object[]> buscarPorEndereco (Endereco endereco, int maxResults)
    {
        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "endereco.cep", "endereco.tipoDeLogradouro",
                           "endereco.logradouro", "endereco.bairro", "endereco.cidade"),
                new Where("endereco.uf"),
                new And(true, "endereco.cidade"),
                new And(true, "endereco.bairro", LIKE),
                new And(true, "endereco.tipoDeLogradouro", LIKE),
                new And(true, "endereco.logradouro", LIKE),
                new OrderBy("endereco.cep"));
        qb.setParametro("uf", endereco.getUf());
        qb.setParametro("cidade", StringUtils.removerAcentos(endereco.getCidade()));
        qb.setParametro("bairro", configurarParamBusca(StringUtils.removerAcentos(endereco.getBairro())));
        qb.setParametro("tipoDeLogradouro", configurarParamBusca(StringUtils.removerAcentos(endereco.getTipoDeLogradouro())));
        qb.setParametro("logradouro", configurarParamBusca(StringUtils.removerAcentos(endereco.getLogradouro())));
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public Integer buscarCodigo (String cep, String bairro, String logradouro)
    {
        QueryBuilder qb = new QueryBuilder(new Select("codigo"),
                                           new Where("endereco.cep"),
                                           new And("endereco.bairro"),
                                           new And("endereco.logradouro"));
        qb.setParametro("cep", cep);
        qb.setParametro("bairro", bairro);
        qb.setParametro("logradouro", logradouro);
        return getSingleResult(qb, Integer.class);
    }

}
