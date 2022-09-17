/*
 * C_EntidadeProfExecutante.java
 *
 * Created on 15/03/2012, 11:23:14
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.validacao.ValidadorDeUnicidadeProfExe;
import com.ic.projects.laudoecia.dao.auditable.DaoProfExecutante;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeProfExecutante extends DefC_EntidadeComCrud<ProfExecutante, Integer>
{
    private DaoProfExecutante dao;

    public C_EntidadeProfExecutante (ViewEntidadeComCrud<ProfExecutante> view)
    {
        super(new DaoProfExecutante(), view);
        dao = (DaoProfExecutante) getDao();
    }

    @Override
    public ProfExecutante criarEntidadeParaAdicionar ()
    {
        ProfExecutante resp = new ProfExecutante(dao.sugerirNovoID());
        resp.setUfConselho(StaticInfo.getDefaultUF());
        resp.setConselho(new TISS_Conselho("CRM"));
        return resp;
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("numNoConselho", new ValidadorDeUnicidadeProfExe((DaoProfExecutante) getDao()));
    }

}
