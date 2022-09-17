/*
 * TxtSomenteLeitura.java
 *
 * Created on 22/06/2012, 10:23:09
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDouble;
import com.lib.swing.plus.cps.MyJTextField;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class TxtSomenteLeitura extends MyJTextField implements ViewCampoDoLaudo
{

    private CampoDoLaudo cdl;
    private CampoDouble cdbl;
    private boolean cdlEhCampoDouble;
    private DecimalFormat format;

    public TxtSomenteLeitura (CampoDoLaudo cdl, boolean vincularVisible)
    {
        cdlEhCampoDouble = cdl instanceof CampoDouble;
        if (cdlEhCampoDouble)
        {
            this.cdbl = (CampoDouble) cdl;
            format = new DecimalFormat();
            format.setMaximumFractionDigits(cdbl.getNumCasasDecimais());
            format.setMinimumFractionDigits(cdbl.getNumCasasDecimais());
            format.setDecimalFormatSymbols(new DecimalFormatSymbols(
                    new Locale("pt", "BR")));
        }
        else
        {
            this.cdl = cdl;
        }
        setFocusable(false);
        addDocumentListener(new DefaultListener(this, vincularVisible));
    }

    @Override
    public void setText (String text)
    {
        if (cdlEhCampoDouble && !(text == null || text.isEmpty()))
        {
            String valorEmDbl = text.replaceAll(",", ".");
            super.setText(format.format(Double.valueOf(valorEmDbl)));
        }
        else
        {
            super.setText(text);
        }
    }

    @Override
    public String getValor ()
    {
        return null;
    }

    @Override
    public CampoDoLaudo getCampoDoLaudo ()
    {
        return cdl == null ? cdbl : cdl;
    }

    @Override
    public final void setEditable (boolean enabled)
    {
        super.setEditable(false);
    }

    @Override
    public final void setFocusable (boolean enabled)
    {
        super.setFocusable(false);
    }

    @Override
    public int getFocusLostStatus ()
    {
        return ViewCampoDoLaudo.NONE;
    }

    @Override
    public void setFocusLostStatus (int status)
    {
    }

}
