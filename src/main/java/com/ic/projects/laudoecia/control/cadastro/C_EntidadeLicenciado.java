/*
 * C_EntidadeLicenciado.java
 *
 * Created on 04/04/2012, 11:32:04
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoLicenciado;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeLicenciado extends DefC_EntidadeComCrud<Licenciado, Integer>
{
    public C_EntidadeLicenciado (ViewEntidadeComCrud<Licenciado> view)
    {
        super(new DaoLicenciado(), view);
    }

    @Override
    public Licenciado criarEntidadeParaAdicionar ()
    {
        return null;
    }

    @Override
    protected void adicionarValidadores ()
    {
    }

}
