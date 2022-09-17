/*
 * CampoRpnData.java
 *
 * Created on 21/05/2012, 08:36:06
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeConversao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDoCampoDoLaudo;
import com.lib.java.rpn.ExpressaoRpn;
import com.lib.java.rpn.InterpretadorRpn;
import com.lib.java.rpn.MapaIncompletoException;
import com.lib.java.rpn.Numero;
import com.lib.java.utils.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoRpnData extends CampoSimples implements CampoDoLaudoListener
{

    private Map<CampoDoLaudo, Integer> mapaDeCampos = new HashMap<>();
    private Map<String, ExpressaoRpn> variaveisDaExpRpn = new HashMap<>();
    private InterpretadorRpn interpretador;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public final static String UM_DIA_EM_MS = "86400000";//24 * 60 * 60 * 1000
    private boolean aceitarValorMenorQueZero = false;

    public CampoRpnData (String valorConstante, String formulaRpn) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        if (formulaRpn == null || formulaRpn.isEmpty())
        {
            throw new ErroNaCriacaoDoModelo("A formula nao pode ser vazia!");
        }
        interpretador = new InterpretadorRpn(formulaRpn);
        sdf.setTimeZone(TimeZone.getTimeZone("gmt"));
    }

    public void cadastrarParamFormula (CampoDoLaudo campo) throws ErrosDoCampoDoLaudo
    {
        if (campo == null)
        {
            throw new ErroNaCriacaoDoModelo("O campo não deve ser null!");
        }
        if (mapaDeCampos.containsKey(campo))
        {
            throw new ErroNaCriacaoDoModelo("O mesmo campo não pode ser adicionado duas vezes!");
        }
        mapaDeCampos.put(campo, mapaDeCampos.size() + 1);
        campo.adicionarListener(this);
        atualizarVariavelEValor(campo);
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
        if (!(StringUtils.parseableToDate(valor) || StringUtils.parseableToInt(valor)))
        {
            throw new ErroDeConversao(this, "Resultado da formula de data inesperado!");
        }
    }

    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
        switch (evento.getTipo())
        {
            case EventoDoCampoDoLaudo.VALOR_MUDOU:
                break;
            default:
                return;
        }
        atualizarVariavelEValor(evento.getOrigem());
    }

    @Override
    boolean campoFormula ()
    {
        return true;
    }

    @Override
    final void atualizarValor ()
    {
        String novoValor;
        try
        {
            long valorFormula = (long) interpretador.interpret(variaveisDaExpRpn);
            String valorStr = String.valueOf(valorFormula);
            if (valorFormula < 0 && !aceitarValorMenorQueZero)
            {
                novoValor = null;
            }
            else if (valorStr.matches("[\\Q+-\\E]?[0-9]{8,}"))
            {
                Date resultadoComoData = new Date(Long.valueOf(valorStr));
                novoValor = sdf.format(resultadoComoData);
            }
            else
            {
                novoValor = valorStr;
            }
        }
        catch (MapaIncompletoException mie)
        {
            novoValor = null;
        }
        try
        {
            setValor(novoValor);
        }
        catch (ErrosDeValidacao ex)
        {
            // o valor que estou tentando setar sera sempre aceito
        }
    }

    private void atualizarVariavelEValor (CampoDoLaudo campo)
    {
        if (campo instanceof CampoInteiro)
        {
            atualizarVariavelDeCampo((CampoInteiro)campo);
        }
        else
        {
            atualizarVariavelDeCampo(campo);
        }
        atualizarValor();
    }

    private void atualizarVariavelDeCampo (CampoInteiro campo)
    {
        String valor = campo.getValor();
        Numero numero = null;
        if (valor == null || valor.isEmpty())
        {
        }
        else
        {
            numero = new Numero(campo.getInt());
        }
        atualizarVariavel(numero, campo);
    }

    private void atualizarVariavelDeCampo (CampoDoLaudo campo)
    {
        String valor = campo.getValor();
        Numero numero = null;
        if (valor == null || valor.isEmpty())
        {
        }
        else if (StringUtils.parseableToDate(valor))
        {
            try
            {
                numero = new Numero(sdf.parse(valor).getTime());
            }
            catch (ParseException ex)
            {
            }
        }
        else
        {
        }
        atualizarVariavel(numero, campo);
    }

    private void atualizarVariavel (Numero numero, CampoDoLaudo campo)
    {
        String idNaFormula = String.valueOf(mapaDeCampos.get(campo));
        if (numero == null)
        {
            variaveisDaExpRpn.remove("C" + idNaFormula);
        }
        else
        {
            variaveisDaExpRpn.put("C" + idNaFormula, numero);
        }
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

}
