/*
 * DesabilitadorPorHabilitacao.java
 *
 * Created on 16/05/2012, 17:10:26
 */

package com.ic.projects.laudoecia.model.laudo;

/**
 * Classe que desabilita um campo conforme a habilitacao de outro
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DesabilitadorPorHabilitacao extends DesabilitadorDeCampo
{
    
    private CampoDoLaudo campoDeterminante;

    DesabilitadorPorHabilitacao (CampoDoLaudo campoDeterminante)
    {
        this.campoDeterminante = campoDeterminante;
    }

    @Override
    boolean desabilitarCampo ()
    {
        return !campoDeterminante.isHabilitado();
    }

    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
    }

}
