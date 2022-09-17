/*
 * ValidadorDeTabelaRequired.java
 *
 * Created on 13/04/2012, 15:58:25
 */
package com.ic.projects.laudoecia.view.validacao;

import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.plus.cps.MyJCheckBox;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class ValidadorDeTabelaRequired implements IValidaCampo
{
    private ScrollResultsDaBusca scrpTabela;
    private MyJCheckBox ckb;

    public ValidadorDeTabelaRequired (ScrollResultsDaBusca scrpTabela)
    {
        this.scrpTabela = scrpTabela;
    }

    public ValidadorDeTabelaRequired (ScrollResultsDaBusca scrpTabela, MyJCheckBox ckb)
    {
        this.scrpTabela = scrpTabela;
        this.ckb = ckb;
    }

    @Override
    public boolean validationOk (int tipo)
    {
        boolean valid;
        if (ckb == null)
        {
            valid = !scrpTabela.getResults().isEmpty();
        }
        else
        {
            valid = !ckb.isSelected() || !scrpTabela.getResults().isEmpty();
        }
        return valid;
    }

    @Override
    public String getErrorMessage ()
    {
        return "Você deve adicionar pelo menos um registro!";
    }

}
