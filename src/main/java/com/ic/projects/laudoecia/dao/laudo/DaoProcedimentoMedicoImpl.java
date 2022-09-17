/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ic.projects.laudoecia.dao.laudo;

import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.lib.dao.general.GenericDao;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Sql;
import java.io.Serializable;


public class DaoProcedimentoMedicoImpl<T extends Serializable> extends GenericDao<T, Integer>{
    
    public DaoProcedimentoMedicoImpl(String persistenceUnit, Class<T> classeDaEntidade) {
        super(persistenceUnit, classeDaEntidade);
    }
    
    public ProcMedico buscaModeloLaudo(String nome){
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT laudomodelo FROM ProcMedico where nome = '" + nome +"'") ;
            ProcMedico procMedico = (ProcMedico) getSingleResult(new QueryBuilder(new Sql(sb.toString())));
            return procMedico;
        } catch (Exception e) { 
            return null;
        }                
    }
}
