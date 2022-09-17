/*
 * CampoLogico.java
 *
 * Created on 21/05/2012, 09:43:00
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroAoSetarPropriedade;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoLogico extends CampoSimples implements CampoDoLaudoListener
{

    private Map<Integer, String> enumValores = new LinkedHashMap<>();
    private List<Logica> logicas = new ArrayList<>();
    private CampoNumero dependencia;
    public static final int INTERVALO = 0;

    public CampoLogico (CampoNumero dependencia, String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        if (dependencia == null)
        {
            throw new ErroNaCriacaoDoModelo("A dependencia nao pode ser null!");
        }
        this.dependencia = dependencia;
        dependencia.adicionarListener(this);
    }

    public CampoLogico (String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
    }

    public void setDependencia (CampoNumero dependencia) throws ErroNaCriacaoDoModelo
    {
        if (dependencia == null)
        {
            throw new ErroNaCriacaoDoModelo("A dependencia nao pode ser null!");
        }
        if (this.dependencia != null)
        {
            this.dependencia.removerListener(this);
        }
        this.dependencia = dependencia;
        dependencia.adicionarListener(this);
    }

    public void cadastrarLogica (String valor, int tipo, double... parametros) throws ErroNaCriacaoDoModelo
    {
        switch (tipo)
        {
            case INTERVALO:
                logicas.add(new Intervalo(parametros));
                enumValores.put(enumValores.size(), valor);
                break;
            default:
                throw new ErroNaCriacaoDoModelo("Logica inesperada!");
        }
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
        if (enumValores.containsValue(valor))
        {
        }
        else
        {
            throw new ErroAoSetarPropriedade("Valor nao existe no mapa!",
                    ErroAoSetarPropriedade.VALOR, this);
        }
    }

    @Override
    boolean campoFormula ()
    {
        return true;
    }

    @Override
    void atualizarValor ()
    {
        try
        {
            String valor = dependencia.getValor();
            if (valor == null || valor.isEmpty())
            {
                setValor(null);
            }
            else
            {
                double valorDbl = dependencia.getDouble();
                for (int i = 0; i < logicas.size(); i++)
                {
                    if (logicas.get(i).avaliar(valorDbl))
                    {
                        setValor(enumValores.get(i));
                        return;
                    }
                }
                setValor(null);
            }
        }
        catch (ErrosDeValidacao ex)
        {
            // o valor que estou tentando setar sera sempre aceito
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
        atualizarValor();
    }

    private interface Logica
    {

        boolean avaliar (double valor);

    }

    private class Intervalo implements Logica
    {

        private double[] parametros;

        private Intervalo (double[] parametros)
        {
            this.parametros = parametros;
        }

        @Override
        public boolean avaliar (double valor)
        {
            return valor >= parametros[0] && valor < parametros[1];
        }

    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

}
