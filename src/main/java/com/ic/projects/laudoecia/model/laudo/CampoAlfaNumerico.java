/*
 * CampoAlfaNumerico.java
 *
 * Created on 30/05/2014, 11:16:40
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class CampoAlfaNumerico extends CampoSimples
{

    public CampoAlfaNumerico (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

}
