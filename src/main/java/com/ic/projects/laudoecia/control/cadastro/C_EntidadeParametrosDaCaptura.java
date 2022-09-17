/*
 * C_EntidadeParametrosDaCaptura.java
 *
 * Created on 25/07/2012, 14:59:24
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.cadastro.DaoParametrosDaCaptura;
import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeParametrosDaCaptura extends DefC_EntidadeComCrud<ParametrosDaCaptura, Integer>
{
    public C_EntidadeParametrosDaCaptura (ViewEntidadeComCrud<ParametrosDaCaptura> view)
    {
        super(new DaoParametrosDaCaptura(), view);
    }

    @Override
    public ParametrosDaCaptura criarEntidadeParaAdicionar ()
    {
        return null;
    }

    @Override
    protected void adicionarValidadores ()
    {
    }

}
