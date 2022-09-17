/*
 * C_BuscaUsuario.java
 *
 * Created on 12/03/2012, 10:02:55
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeGrupoDeUsuarios;
import com.ic.projects.laudoecia.dao.auditable.DaoUsuario;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.lib.icontrol.crud.busca.AbsDefC_BuscaComCrud;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.iview.crud.ViewParamsBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaUsuario extends AbsDefC_BuscaComCrud <Usuario, Integer>
{

    private DaoUsuario dao;
    private BuscadorDeGrupoDeUsuarios buscador = new BuscadorDeGrupoDeUsuarios();

    public C_BuscaUsuario (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoUsuario(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoUsuario) getDao();
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        switch (campo)
        {
            case "nome ou login":
                return dao.buscarPorNomeOuLogin(busca);
            case "grupo":
                GrupoDeUsuarios grupo = buscador.getSelectedModel();
                if (grupo != null)
                {
                    return dao.buscarPorGrupo(grupo);
                }
                return new ArrayList<>();
            default:
                return new ArrayList<>();
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (Usuario entidade)
    {
        return new Object[] { entidade.getCodigo(), entidade.getNome(),
                            entidade.getDataDeCadastro(), entidade.isAtivo() };
    }

    @Override
    protected void parametrosBuscaMudaram (Object[] newParamsBusca, Object[] oldParamsBusca)
    {
        String newCampo = (String) newParamsBusca[1];
        String oldCampo = (String) oldParamsBusca[1];
        if (!newCampo.equals(oldCampo))
        {
            switch (newCampo)
            {
                case "grupo":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscador);
                    break;
                default:
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, null);
            }
        }
    }

}
