/*
 * PnlParametrosDaCaptura.java
 *
 * Created on 25/07/2012, 14:44:43
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.model.cadastro.ParametrosDaCaptura;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlParametrosDaCaptura extends PnlDaEntidadeComCrud<ParametrosDaCaptura>
{

    public PnlParametrosDaCaptura ()
    {
        setTemTxtCodigo(false);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
    }

    @Override
    protected void prepararParaAdicionar (Object dadosIniciais)
    {
    }

    @Override
    protected void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (ParametrosDaCaptura entity, int contador)
    {
        return true;
    }

    @Override
    public void preencherDadosDaEntidade (ParametrosDaCaptura entidadeBase)
    {
    }

}
