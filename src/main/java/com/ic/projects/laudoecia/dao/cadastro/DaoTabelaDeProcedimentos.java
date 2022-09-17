/*
 * DaoTabelaDeProcedimentos.java
 *
 * Created on 15/03/2012, 16:55:19
 */
package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.cadastro.TabelaDeProcedimentos;
import com.lib.dao.general.GenericDaoWithIntegerId;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DaoTabelaDeProcedimentos extends GenericDaoWithIntegerId<TabelaDeProcedimentos>
{
    public DaoTabelaDeProcedimentos ()
    {
        super(PUs.CADASTRO_PU, TabelaDeProcedimentos.class);
    }

}
