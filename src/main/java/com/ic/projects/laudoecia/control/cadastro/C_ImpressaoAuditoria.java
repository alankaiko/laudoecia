/*
 * C_ImpressaoAuditoria.java
 *
 * Created on 23/03/2012, 16:08:18
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.cadastro.DaoAcaoDoUsuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.lib.icontrol.crud.cadastro.C_Impressao;
import com.lib.iview.crud.ViewResultadosDaBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_ImpressaoAuditoria implements C_Impressao
{
    private DaoAcaoDoUsuario dao;
    private ViewResultadosDaBusca view;

    public C_ImpressaoAuditoria (ViewResultadosDaBusca view)
    {
        this.view = view;
    }

    @Override
    public void imprimir ()
    {
        List<Object[]> resultados = view.getResults();
        if (resultados != null && !resultados.isEmpty())
        {
            List<AcaoDoUsuario> dados = getDao().buscarPorCodigo(getListIds(resultados));
            LaudoeCia.getTelaPrincipal().mostrarRelAuditoria(dados);
        }
    }

    private List<Integer> getListIds (List<Object[]> resultados)
    {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < resultados.size(); i++)
        {
            ids.add((int) resultados.get(i)[0]);
        }
        return ids;
    }

    private DaoAcaoDoUsuario getDao()
    {
        if (dao == null)
        {
            dao = new DaoAcaoDoUsuario();
        }
        return dao;
    }

}
