/*
 * PnlEstacaoDeTrabalho.java
 *
 * Created on 09/04/2012, 11:13:10
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.LblAviso;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtReadOnly;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import javax.swing.Box;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlEstacaoDeTrabalho extends PnlDaEntidadeComCrud<EstacaoDeTrabalho>
{
    public PnlEstacaoDeTrabalho ()
    {
        setTemTxtCodigo(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        add(new CampoDaEnt("Código", false, false).setComponent(txtCod.pintarDeAmarelo()), c);
        c.gridy = 1;
        c.gridwidth = 2;
        add(new CampoDaEnt("Nome da estação", false, true).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridy = 2;
        add(new PnlComp(false, true).setComponent(lblMinhaEstacao), c);
        c.gridy = 3;
        c.gridwidth = 1;
        c.weighty = 1;
        add(Box.createHorizontalStrut(100), c);
        c.weightx = 1;
        c.gridx = 1;
        add(Box.createHorizontalStrut(100), c);

    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (EstacaoDeTrabalho entidade, int contador)
    {
        txtCod.setText(entidade.getCodigo());
        txtNome.setText(entidade.getNomeEstacaoDeTrabalho());

        final boolean estAtual = entidade.equals(StaticInfo.getEstTrabalho());
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                lblMinhaEstacao.setVisible(estAtual);
            }

        });

        return true;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtNome.requestFocusInWindow();
    }

    @Override
    public void preencherDadosDaEntidade (EstacaoDeTrabalho entidadeBase)
    {
        entidadeBase.setNomeEstacaoDeTrabalho(txtNome.getText());
    }

    private TxtReadOnly txtCod = new TxtReadOnly();
    private MyJTextField txtNome = new MyJTextField();
    private LblAviso lblMinhaEstacao = new LblAviso("", Imagens.INFO_SMALL);
    {
        lblMinhaEstacao.setText("Esta é a estação de trabalho atual.");
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome),
                          validadores.get("nomeEstacaoDeTrabalho").set("codigo",
                               readerInt(txtCod)).set("campo", readerStr(txtNome)));
    }

}
