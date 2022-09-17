/*
 * C_BuscaPaciente.java
 *
 * Created on 13/03/2012, 08:51:56
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoPaciente;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.java.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaPaciente extends AbsDefC_BuscaComCrud<Paciente, Integer>
{
    private DaoPaciente dao;

    public C_BuscaPaciente (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoPaciente(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoPaciente) getDao();
    }

    @Override
    public List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "nome":
                return dao.buscarPorNome(busca, maxResults);
            case "prontuário":
                if (busca.matches("[0-9]+"))
                {
                    return dao.buscarPorCodigo(Integer.valueOf(busca), maxResults);
                }
                else
                {
                    return new ArrayList<>();
                }
            case "data nascimento":
                Date dataNasc = StringUtils.getRecentDateFromString(busca);
                if (dataNasc == null)
                {
                    return new ArrayList<>();
                }
                else
                {
                    return dao.buscarPorDataNascimento(dataNasc, maxResults);
                }
            case "data cadastro":
                Date dataCad = StringUtils.getRecentDateFromString(busca);
                if (dataCad == null)
                {
                    return new ArrayList<>();
                }
                else
                {
                    return dao.buscarPorDiaDeCadastro(dataCad, maxResults);
                }
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (Paciente entidade)
    {
        return new Object[]
                {
                    entidade.getCodigo(),
                    entidade.getNome(),
                    entidade.getDataNascimento(),
                    entidade.getDataDeCadastro()
                };
    }

}
