/*
 * C_EntidadeParametrosDoSistema.java
 *
 * Created on 02/04/2012, 11:13:36
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.iview.crud.ViewEntidadeComCrud;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_EntidadeParametrosDoSistema extends DefC_EntidadeComCrud<ParametrosDoSistema, Integer>
{

    public C_EntidadeParametrosDoSistema (ViewEntidadeComCrud<ParametrosDoSistema> view)
    {
        super(new DaoParametrosDoSistema(), view);
    }

    @Override
    public ParametrosDoSistema criarEntidadeParaAdicionar ()
    {
        return null;
    }

    @Override
    protected void adicionarValidadores ()
    {
    }
    
    @Override
    public void alterar (ParametrosDoSistema entidadeBase) throws OptimisticLockException, EntityNotFoundException, Exception
    {
        super.alterar(entidadeBase);
        StaticInfo.escreverPropriedade(StaticInfo.BACKUP, 
                                       StaticInfo.PARAMS_BACKUP_AUT_MUDOU, "true");
    }

}
