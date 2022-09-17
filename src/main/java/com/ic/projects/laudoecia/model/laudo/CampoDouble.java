/*
 * CampoDouble.java
 *
 * Created on 07/05/2012, 09:08:21
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeConversao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.java.utils.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoDouble extends CampoNumero
{

    private int numCasasDecimais;

    public CampoDouble (String valorConstante, int numCasasDecimais) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante);
        this.numCasasDecimais = numCasasDecimais;
        setZeroDeveSerImpresso(false);
        if (numCasasDecimais < 0)
        {
            throw new ErroNaCriacaoDoModelo("Numero de casas decimais < 0");
        }
    }

    public int getNumCasasDecimais ()
    {
        return numCasasDecimais;
    }

    @Override
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
        if (StringUtils.parseableToDouble(valor, true))
        {
        }
        else
        {
            throw new ErroDeConversao(this, "O valor não pôde ser convertido em número!");
        }
    }

    @Override
    String tratarValorNaoVazioParaImpressao (String valor)
    {
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(numCasasDecimais);
        format.setMinimumFractionDigits(numCasasDecimais);
        format.setDecimalFormatSymbols(new DecimalFormatSymbols(
                new Locale("pt", "BR")));
        String valorEmDbl = valor.replaceAll(",", ".");
        return format.format(Double.valueOf(valorEmDbl));
    }

    @Override
    String zero ()
    {
        return tratarValorNaoVazioParaImpressao("0");
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

}
