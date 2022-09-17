/*
 * PnlAbreviatura.java
 *
 * Created on 20/06/2012, 16:39:38
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
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
public class PnlAbreviatura extends PnlDaEntidadeComCrud<Abreviatura>
{

    public PnlAbreviatura ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        add(Box.createHorizontalStrut(80), c);
        c.gridy = 1;
        c.gridwidth = 2;
        add(new CampoDaEnt("Abreviatura", false, true).setComponent(txtAbreviatura.pintarDeAmarelo()), c);
        c.gridy = 2;
        add(new CampoDaEnt("Texto por extenso", false, true).setComponent(txtExtenso.pintarDeAmarelo()), c);
        c.gridy = 3;
        c.gridx = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        add(Box.createHorizontalStrut(0), c);
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private final MyJTextField txtAbreviatura = new MyJTextField();
    private final MyJTextField txtExtenso = new MyJTextField();

    {
        txtAbreviatura.setDocumentFilter(new LimitedLengthDocFilter());
        txtExtenso.setDocumentFilter(new LimitedLengthDocFilter());
        txtExtenso.setStrCnfEnabled(false);
    }

    //</editor-fold>

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtAbreviatura, new RequiredFieldValidator(txtAbreviatura),
                          validadores.get("abreviatura").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtAbreviatura)));
        formValidator.add(txtExtenso, new RequiredFieldValidator(txtExtenso));
    }

    @Override
    protected void prepararParaAdicionar (Object dadosIniciais)
    {
        txtAbreviatura.requestFocusInWindow();
    }

    @Override
    protected void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtAbreviatura.requestFocusInWindow();
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (Abreviatura entidade, int contador)
    {
        txtCodigo.setText(entidade.getCodigo());
        txtAbreviatura.setText(entidade.getAbreviatura());
        txtExtenso.setText(entidade.getTexto());
        return true;
    }

    @Override
    public void preencherDadosDaEntidade (Abreviatura abrev)
    {
        abrev.setCodigo(txtCodigo.getInt());
        abrev.setAbreviatura(txtAbreviatura.getText());
        abrev.setTexto(txtExtenso.getText());
    }

}
