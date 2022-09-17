/*
 * PnlGrupoDeUsuarios.java
 *
 * Created on 12/03/2012, 09:17:38
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.build.ViewFactory;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.perfildeacesso.TabbedPanePerfilDeAcesso;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.docfilters.NomeDePessoa;
import com.lib.swing.plus.utils.PnlComEspaco;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.Box;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlGrupoDeUsuarios extends PnlDaEntidadeComCrud<GrupoDeUsuarios>
{

    public PnlGrupoDeUsuarios ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        c.gridx = 1;
        c.weightx = 1.0;
        add(new CampoDaEnt("Nome", true, false).setComponent(txtNome.pintarDeAmarelo()), c);
        c.weightx = 0;
        c.gridx = 2;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt(true, false).setComponent(btnAcessoTotal), c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weighty = 1;
        add(new PnlComEspaco(tabbedPane, 5, 0, 2, 2), c);
        c.ipadx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.weighty = 0;
        c.fill = GridBagConstraints.CENTER;
        add(Box.createHorizontalStrut(75), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(300), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(75), c);
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (GrupoDeUsuarios entidade, int contador)
    {
        txtCodigo.setText(entidade.getCodigo());
        txtNome.setText(entidade.getNome());
        tabbedPane.setPerfilDeAcesso(entidade.getPerfilDeAcesso());
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
    public void preencherDadosDaEntidade (GrupoDeUsuarios grupo)
    {
        grupo.setCodigo(txtCodigo.getInt());
        grupo.setNome(txtNome.getText());
        grupo.setPerfilDeAcesso(tabbedPane.getPerfilDeAcesso());
    }

    // <editor-fold defaultstate="collapsed" desc="Campos do cadastro">

    private MyJTextField txtNome = new MyJTextField();
    // Não coloquei o btn nenhum acesso porque ao criar um novo grupo
    // por padrão ele já possui todas as permissões desmarcadas
    private MyJButton btnAcessoTotal = new MyJButton("Acesso total");
    private TabbedPanePerfilDeAcesso<PerfilDeAcesso> tabbedPane;

    {
        txtNome.setDocumentFilter(new NomeDePessoa(new LimitedLengthDocFilter()));
        tabbedPane = ViewFactory.getInstance().criarTabsPerfilDeAcesso();
        btnAcessoTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                tabbedPane.acessoTotal();
            }

        });
    }

    // </editor-fold>

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome),
                          validadores.get("nome").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtNome)));
    }

}
