/*
 * PnlRecorte.java
 *
 * Created on 12/03/2012, 09:10:57
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.model.cadastro.Recorte;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.utils.TxtInteiro;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import javax.swing.Box;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlRecorte extends PnlDaEntidadeComCrud<Recorte>
{

    public PnlRecorte ()
    {
        setTemTxtCodigo(false);
        txtCodigo.setEditable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo(), true, false, false, true), c);
        add(Box.createHorizontalStrut(120), c);
        c.gridy = 1;
        c.gridwidth = 3;
        add(new CampoDaEnt("Descrição", false, true).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridwidth = 1;
        c.gridx = 2;
        add(Box.createHorizontalStrut(100), c);
        c.gridy = 2;
        c.gridx = 0;
        add(new CampoDaEnt("Posição X", false, true).setComponent(txtX), c);
        c.gridx = 1;
        add(new CampoDaEnt("Posição Y", true, true).setComponent(txtY), c);
        add(Box.createHorizontalStrut(120), c);
        c.gridx = 0;
        c.gridy = 3;
        add(new CampoDaEnt("Largura", false, true).setComponent(txtLargura.pintarDeAmarelo()), c);
        c.gridx = 1;
        add(new CampoDaEnt("Altura", true, true).setComponent(txtAltura.pintarDeAmarelo()), c);
        c.gridy = 4;
        c.gridx = 3;
        c.weightx = 1;
        c.weighty = 1;
        add(Box.createHorizontalStrut(0), c);
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        txtNome.requestFocusInWindow();
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtNome.requestFocusInWindow();
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (Recorte entidade, int contador)
    {
        txtNome.setText(entidade.getDescricao());
        txtX.setText(entidade.getPosicaoX());
        txtY.setText(entidade.getPosicaoY());
        txtLargura.setText(entidade.getLargura());
        txtAltura.setText(entidade.getAltura());
        return true;
    }

    @Override
    public void preencherDadosDaEntidade (Recorte entidadeBase)
    {
        entidadeBase.setAltura(txtAltura.getInt());
        entidadeBase.setDescricao(txtNome.getText());
        entidadeBase.setLargura(txtLargura.getInt());
        entidadeBase.setPosicaoX(txtX.getInt());
        entidadeBase.setPosicaoY(txtY.getInt());
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome),
                          validadores.get("descrição").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtNome)));
        formValidator.add(txtLargura, new IValidaCampo()
        {

            @Override
            public boolean validationOk (int tipo)
            {
                return txtLargura.getInt() > 0;
            }

            @Override
            public String getErrorMessage ()
            {
                return "Campo obrigatório!";
            }
        });
        formValidator.add(txtAltura, new IValidaCampo()
        {

            @Override
            public boolean validationOk (int tipo)
            {
                return txtAltura.getInt() > 0;
            }

            @Override
            public String getErrorMessage ()
            {
                return "Campo obrigatório!";
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Campos do cadastro">

    private final MyJTextField txtNome = new MyJTextField();
    private final TxtInteiro txtX = new TxtInteiro(3);
    private final TxtInteiro txtY = new TxtInteiro(3);
    private final TxtInteiro txtLargura = new TxtInteiro(4);
    private final TxtInteiro txtAltura = new TxtInteiro(4);

    {
        txtNome.setDocumentFilter(new LimitedLengthDocFilter());
    }

    // </editor-fold>

}
