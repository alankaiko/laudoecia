/*
 * CampoLogicoTexto.java
 *
 * Created on 05/06/2012, 09:56:33
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.java.utils.StringUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoLogicoTexto extends CampoSimples implements CampoDoLaudoListener
{

    private CampoDoLaudo[] campos;
    private Map<String, String> mapa = new LinkedHashMap<>();

    public CampoLogicoTexto (String valorConstante, CampoDoLaudo... campos) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        if (campos == null || campos.length == 0)
        {
            throw new ErroNaCriacaoDoModelo("Deve ser informado pelo menos um campo!");
        }
        this.campos = campos;
        for (int i = 0; i < campos.length; i++)
        {
            campos[i].adicionarListener(this);
        }
    }

    public CampoLogicoTexto (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
    }

    public void setCampos (CampoDoLaudo... campos) throws ErroNaCriacaoDoModelo
    {
        if (campos == null || campos.length == 0)
        {
            throw new ErroNaCriacaoDoModelo("Deve ser informado pelo menos um campo!");
        }
        this.campos = campos;
        for (int i = 0; i < campos.length; i++)
        {
            campos[i].adicionarListener(this);
        }
    }

    public void cadastrarLogica (String valorDoCampo, String valorASerSetado)
    {
        mapa.put(valorDoCampo, valorASerSetado);
    }

    public void cadastrarLogica (String valorASerSetado)
    {
        mapa.put("", valorASerSetado);
        mapa.put(null, valorASerSetado);
    }

    @Override
    boolean campoFormula ()
    {
        return true;
    }

    @Override
    void atualizarValor ()
    {
        for (Iterator<String> it = mapa.keySet().iterator(); it.hasNext();)
        {
            String valorDaFormula = it.next();
            for (int i = 0; i < campos.length; i++)
            {
                if (campos[i].isHabilitado() &&
                    valorConfere(valorDaFormula, campos[i].getValor()))
                {
                    try
                    {
                        setValor(mapa.get(valorDaFormula));
                        return;
                    }
                    catch (ErrosDeValidacao ex)
                    {
                        try
                        {
                            setValor(null);
                            return;
                        }
                        catch (ErrosDeValidacao ex1)
                        {
                        }
                    }
                }
            }
        }
        try
        {
            setValor(null);
        }
        catch (ErrosDeValidacao ex)
        {
        }
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
    }

    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
        switch (evento.getTipo())
        {
            case EventoDoCampoDoLaudo.VALOR_MUDOU:
                atualizarValor();
                break;
            default:
        }
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

    private boolean valorConfere (String valorDaFormula, String valorDoCampo)
    {
        if (valorDaFormula != null && valorDaFormula.contains("->"))
        {
            double inicioDoIntervalo = Double.valueOf(
                    valorDaFormula.substring(0, valorDaFormula.indexOf('-'))
                    .replaceAll(",", "."));
            double fimDoIntervalo = Double.valueOf(
                    valorDaFormula.substring(valorDaFormula.indexOf('>') + 1)
                    .replaceAll(",", "."));
            if (StringUtils.parseableToDouble(valorDoCampo, true))
            {
                double valor = Double.valueOf(valorDoCampo.replace(',', '.'));
                return valor >= inicioDoIntervalo && valor < fimDoIntervalo;
            }
            return false;
        }
        else
        {
            return Objects.equals(valorDaFormula, valorDoCampo);
        }
    }

}
