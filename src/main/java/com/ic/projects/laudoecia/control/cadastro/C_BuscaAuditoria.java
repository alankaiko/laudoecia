/*
 * C_BuscaAuditoria.java
 *
 * Created on 21/03/2012, 08:47:01
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.cadastro.DaoAcaoDoUsuario;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.lib.icontrol.crud.busca.AbsDefC_Busca;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_BuscaAuditoria extends AbsDefC_Busca<AcaoDoUsuario, Integer>
{
    private DaoAcaoDoUsuario dao;

    public C_BuscaAuditoria (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoAcaoDoUsuario(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoAcaoDoUsuario) getDao();
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        //Não tratado campos nulos pois o dao aceita null como parametro
        Usuario user = (Usuario) paramsBusca[0];
        String tipoAcao = (String) paramsBusca[1];
        if (tipoAcao.equals("TODAS"))
        {
            tipoAcao = null;
        }
        String tabela = (String) paramsBusca[2];
        if (tabela.equals("TODAS"))
        {
            tabela = null;
        }
        if (user == null && tipoAcao == null && tabela == null)
        {
            return new ArrayList<>();
        }
        Date dataIni = (Date) paramsBusca[3];
        Date dataFin = (Date) paramsBusca[4];
        String registro = (String) paramsBusca[5];
        String codigo = (String) paramsBusca[6];
        int maxResults = (int) paramsBusca[7];
        return dao.buscarPorTodosCampos(user, tipoAcao, tabela, dataIni, dataFin, registro, codigo, maxResults);
    }

    @Override
    public Object[] criarLinhaSelecionada (AcaoDoUsuario entidade)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
