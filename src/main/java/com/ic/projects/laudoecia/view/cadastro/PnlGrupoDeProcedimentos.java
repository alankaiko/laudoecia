/*
 * PnlGrupoDeProcedimentos.java
 *
 * Created on 14/03/2012, 17:51:42
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import javax.swing.Box;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlGrupoDeProcedimentos extends PnlDaEntidadeComCrud<GrupoProcedimento>
{
    public PnlGrupoDeProcedimentos ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.PAGE_START;

        c.gridy = 0;
        c.gridx = 0;
        add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        c.gridy = 1;
        c.gridwidth = 2;
        add(new CampoDaEnt("Nome", false, true).setComponent(txtNome.pintarDeAmarelo()), c);

        c.gridwidth = 1;
        c.weighty = 1.0;
        c.gridy = 2;
        add(Box.createHorizontalStrut(100), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(550), c);
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (GrupoProcedimento entity, int contador)
    {
        txtCodigo.setText(entity.getCodigo());
        txtNome.setText(entity.getNome());
        return true;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        txtNome.requestFocusInWindow();
        if (dadosIniciais != null)
        {
            txtNome.setText(dadosIniciais.toString());
        }
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtNome.requestFocusInWindow();
    }

    @Override
    public void preencherDadosDaEntidade (GrupoProcedimento grupo)
    {
        grupo.setCodigo(txtCodigo.getInt());
        grupo.setNome(txtNome.getText());
    }

    private MyJTextField txtNome = new MyJTextField();

    {
        txtNome.setDocumentFilter(new LimitedLengthDocFilter());
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome),
                          validadores.get("nome").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtNome)));
    }

}
