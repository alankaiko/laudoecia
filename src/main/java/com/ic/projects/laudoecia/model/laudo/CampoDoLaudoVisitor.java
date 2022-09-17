/*
 * CampoDoLaudoVisitor.java
 *
 * Created on 20/06/2012, 16:41:03
 */

package com.ic.projects.laudoecia.model.laudo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface CampoDoLaudoVisitor
{

    void visit (CampoDate campoData);
    void visit (CampoDouble campoDouble);
    void visit (CampoRpn campoRpn);
    void visit (CampoRpnData campoRpnData);
    void visit (CampoInteiro campoInteiro);
    void visit (CampoTexto campoTexto);
    void visit (CampoLogicoTexto campoLogicoTexto);
    void visit (CampoLogico campoLogico);
    void visit (Enumeracao enumeracao);
    void visit (Label label);
    void visit (CampoAlfaNumerico campoAlfaNumerico);

}
