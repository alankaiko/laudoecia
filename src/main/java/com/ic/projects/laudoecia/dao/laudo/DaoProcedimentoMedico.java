/*
 * DaoProcedimento Médico
 * Create 18/11/2015
 */
package com.ic.projects.laudoecia.dao.laudo;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.lib.dao.general.GenericDao;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Sql;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
public class DaoProcedimentoMedico extends DaoProcedimentoMedicoImpl<ProcMedico> {
  
    private ProcMedico procMedico = new ProcMedico();
    private static DaoProcedimentoMedico instance;    

    public static DaoProcedimentoMedico getInstance() {
        if (instance == null) {
            instance = new DaoProcedimentoMedico();
        }
        return instance;
    }

    public DaoProcedimentoMedico() {
        super(PUs.CADASTRO_PU, ProcMedico.class);
    }

    public  ProcMedico buscaProcMedico(String nomeProcedimento) {
        try {
            procMedico = buscaModeloLaudo(nomeProcedimento);
            return procMedico;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
    public static void main(String[]args){
        DaoProcedimentoMedico d = new DaoProcedimentoMedico();
        System.out.println(d.buscaProcMedico("COLPOSCOPIA COM BIÓPSIA DE COLO UTERINO"));
    }
}
