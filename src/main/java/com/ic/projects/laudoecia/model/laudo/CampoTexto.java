/*
 * CampoTexto.java
 *
 * Created on 07/05/2012, 09:07:17
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroAoGerarHtml;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.java.utils.StringUtils;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoTexto extends CampoDoLaudo
{

    private String textoPadrao = "";
    private CampoDoLaudo cdl;
    private static final String inicioDeParag = "<p ";

    public CampoTexto ()
    {
    }

    public CampoTexto (String textoPadrao)
    {
        this.textoPadrao = textoPadrao == null ? "" : textoPadrao;
    }

    public CampoTexto (CampoDoLaudo cdl)
    {
        this.cdl = cdl;
    }

    public boolean possuiTextoPadrao ()
    {
        return cdl == null ? !textoPadrao.isEmpty() : true;
    }

    public String getTextoPadrao () throws ErrosDeValidacao
    {
        if (cdl == null)
        {
            if (textoPadrao.isEmpty())
            {
                throw new AssertionError();
            }
            return textoPadrao;
        }
        return cdl.gerarHtmlImpl(true);
    }

    public void setarValorPadrao () throws ErrosDeValidacao
    {
        if (isHabilitado() && possuiTextoPadrao() && impressaoEstaVazia())
        {
            setValor(getTextoPadrao());
        }
        else
        {
        }
    }

    public boolean impressaoEstaVazia ()
    {
        return StringUtils.textBetweenTags(getValor()).trim().isEmpty();
    }

    public boolean tamanhoDoTextoOk ()
    {
        String valor = getValor();
        if (valor == null || valor.isEmpty())
        {
            return true;
        }
        return StringUtils.textBetweenTags(valor).trim().length() > 4;
    }

    @Override
    String tratarValorQueSeraSetado (String valor)
    {
        if (valor == null)
        {
            return null;
        }
        String resposta = valor.trim();
        while (resposta.contains(inicioDeParag))
        {
            int indexDoUltParag = resposta.lastIndexOf(inicioDeParag);
            String parag = resposta.substring(indexDoUltParag);
            if (StringUtils.textBetweenTags(parag).trim().isEmpty())
            {
                if (indexDoUltParag > 0)
                {
                    resposta = resposta.substring(0, indexDoUltParag).trim();
                }
                else
                {
                    return "";
                }
            }
            else
            {
                break;
            }
        }
        return resposta;
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        String valor = getValor();
        if (valor == null || StringUtils.textBetweenTags(valor).trim().isEmpty())
        {
            return "";
        }
        else if (validar && !tamanhoDoTextoOk())
        {
            throw new ErroAoGerarHtml(this, "Texto inválido!");
        }
        else
        {
            return valor;
        }
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
