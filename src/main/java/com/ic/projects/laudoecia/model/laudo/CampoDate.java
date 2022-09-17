/*
 * CampoDate.java
 *
 * Created on 17/05/2012, 10:14:24
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeConversao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.java.utils.StringUtils;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoDate extends CampoSimples
{
    
    public CampoDate (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
    }
    
    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
        if (StringUtils.parseableToDate(valor))
        {
        }
        else
        {
            throw new ErroDeConversao(this, "Valor não pode ser convertido para data!");
        }
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }
    
}
