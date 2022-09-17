package com.ic.projects.laudoecia.model.cadastro;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.0 14/10/2015 16:01
 */
public enum TipoMedico {
    DR("DR."), DRA("DRA."), NENHUM("N");
        
    private int sigla;
       
     TipoMedico(String sigla){
        sigla = sigla;
        
    }

    public int getSigla() {
        return sigla;
    }

    public void setSigla(int sigla) {
        this.sigla = sigla;
    }
    
    
}
