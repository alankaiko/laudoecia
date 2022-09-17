/*
 * TxtCodigoCBHPM.java
 *
 * Created on 28/02/2012, 08:36:52
 */
package com.ic.projects.laudoecia.view.maskedfields;

import com.lib.swing.maskedfields.MaskedTxtLCTelefone;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class TxtCodigoCBHPM extends MaskedTxtLCTelefone
{
    public TxtCodigoCBHPM ()
    {
        super(new MascaraDeCodigoCBHPM());
    }

}
