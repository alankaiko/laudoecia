/*
 * ValidadorDeDiretorio.java
 *
 * Created on 13/04/2012, 09:32:24
 */
package com.ic.projects.laudoecia.view.validacao;

import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.plus.cps.MyJCheckBox;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class ValidadorDeDiretorio extends RequiredFieldValidator
{
    private MyJCheckBox ckb;

    public ValidadorDeDiretorio (MyJCheckBox ckb, JTextComponent txtCp)
    {
        super(txtCp);
        this.ckb = ckb;
    }

    @Override
    public boolean validationOk (int tipo)
    {
        return !ckb.isSelected() || super.validationOk(tipo);
    }

}
