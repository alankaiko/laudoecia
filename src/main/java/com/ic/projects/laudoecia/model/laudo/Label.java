/*
 * Label.java
 *
 * Created on 17/05/2012, 15:22:19
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.text.SimpleDateFormat;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class Label extends CampoSimples
{

    public static final int DATA_DO_EXAME = 0;
    private static final int VALOR_FIXO = 1;
    private final int tipo;
    private String valorFixo;

    public Label (String valorFixo) throws ErroNaCriacaoDoModelo
    {
        this(VALOR_FIXO, true);
        this.valorFixo = valorFixo;
    }

    public Label (int tipo, String valorConstante) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        switch (tipo)
        {
            case DATA_DO_EXAME:
            case VALOR_FIXO:
                break;
            default:
                throw new ErroNaCriacaoDoModelo("Tipo de label inesperado!");
        }
        this.tipo = tipo;
        setSetarValorNullQuandoDesabilitado(false);
    }

    public Label (int tipo, boolean imprimir) throws ErroNaCriacaoDoModelo
    {
        this(tipo, imprimir ? identificador : NAO_IMPRIMIVEL);
    }

    private void setarValorConformeTipo () throws ErrosDeValidacao
    {
        switch (tipo)
        {
            case DATA_DO_EXAME:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                setValor(sdf.format(getLaudo().getProcDoAtd().getDataDaExecucao()));
                break;
            case VALOR_FIXO:
                setValor(valorFixo);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
    }

    @Override
    void parentSet ()
    {
        try
        {
            setarValorConformeTipo();
        }
        catch (ErrosDeValidacao ex)
        {
        }
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    boolean campoFormula ()
    {
        return true;
    }

}
