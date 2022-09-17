/*
 * PnlUsuario.java
 *
 * Created on 12/03/2012, 09:10:57
 */

package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeGrupoDeUsuarios;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeUsuario;
import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.GrupoDeUsuarios;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.model.cnv.ConversorDateTimeStampString;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.PswFieldValidator;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.plus.cps.MyJCheckBox;
import com.lib.swing.plus.cps.MyJPasswordField;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.docfilters.Login;
import com.lib.swing.plus.docfilters.NomeDePessoa;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.TxtReadOnly;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JComponent;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlUsuario extends PnlDaEntidadeComCrud<Usuario>
{

    private BuscadorDeGrupoDeUsuarios buscador = new BuscadorDeGrupoDeUsuarios();
    private C_EntidadeUsuario controlador;

    public PnlUsuario ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        c.gridx = 1;
        c.gridwidth = 4;
        add(new CampoDaEnt("Nome", true, false).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridx = 5;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt(true, false).setComponent(chkAtivo), c);
        c.gridx = 6;
        c.gridheight = 4;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createVerticalStrut(1), c);
        c.weightx = 0;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 1;
        add(new CampoDaEnt("Login", false, true).setComponent(txtLogin.pintarDeAmarelo()), c);
        c.gridx = 3;
        c.gridwidth = 2;
        add(new CampoDaEnt("Grupo de usuários").setComponent(txtGrupoDeUsuarios.pintarDeAmarelo()), c);
        c.gridx = 5;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        add(new CampoDaEnt().setComponent(btnBusca
                , false, true, false, false), c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        add(new CampoDaEnt("Senha", false, true).setComponent(txtSenha), c);
        c.gridx = 2;
        add(new CampoDaEnt("Confirme a senha").setComponent(txtConfirmarSenha), c);
        c.gridx = 4;
        c.gridwidth = 1;
        add(new CampoDaEnt("Data de cadastro").setComponent(txtDataDeCadastro), c);
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 1;
        c.weighty = 1;
        add(Box.createHorizontalStrut(65), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(85), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(30), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(120), c);
        c.gridx = 4;
        add(Box.createHorizontalStrut(225), c);
        c.gridx = 5;
        add(Box.createHorizontalStrut(20), c);
    }

    @Override
    protected <ID> void controladorWasSet (C_EntidadeComCrud<Usuario, ID> controlador)
    {
        this.controlador = (C_EntidadeUsuario) controlador;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        txtNome.requestFocusInWindow();
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtSenha.requestFocusInWindow();
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (Usuario entidade, int contador)
    {
        buscador.setSelectedModel(entidade.getGrupo());
        chkAtivo.setSelected(entidade.isAtivo());
        txtCodigo.setText(entidade.getCodigo());
        txtConfirmarSenha.setText(entidade.getSenha());
        txtDataDeCadastro.setText(entidade.getDataDeCadastro());
        txtLogin.setText(entidade.getLogin());
        txtNome.setText(entidade.getNome());
        txtSenha.setText(entidade.getSenha());
        return true;
    }

    @Override
    public void preencherDadosDaEntidade (Usuario entidadeBase)
    {
        entidadeBase.setAtivo(chkAtivo.isSelected());
        entidadeBase.setCodigo(txtCodigo.getInt());
        entidadeBase.setGrupo(buscador.getSelectedModel());
        entidadeBase.setLogin(txtLogin.getText());
        entidadeBase.setNome(txtNome.getText());
        entidadeBase.setSenha(txtSenha.getSenha());
        controlador.dadosForamPreenchidos();
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome));
        formValidator.add(txtLogin, new RequiredFieldValidator(txtLogin),
                                    validadores.get("login").set("codigo",
                           readerInt(txtCodigo)).set("campo", readerStr(txtLogin)));
        formValidator.add(txtGrupoDeUsuarios, new RequiredFieldValidator(buscador));
        formValidator.add(new JComponent[] {txtSenha, txtConfirmarSenha},
                          new PswFieldValidator(txtSenha, txtConfirmarSenha));
    }

    @Override
    public void usarResultadoDaBusca (Object o)
    {
        if (o instanceof GrupoDeUsuarios)
        {
            buscador.setSelectedModel((GrupoDeUsuarios)o);
            txtGrupoDeUsuarios.requestFocusInWindow();
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    txtSenha.requestFocusInWindow();
                }

            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Campos do cadastro">

    private MyJTextField txtNome = new MyJTextField();
    private MyJCheckBox chkAtivo = new MyJCheckBox("Ativo");
    private MyJTextField txtLogin = new MyJTextField();
    private TxtComAutoCompletar txtGrupoDeUsuarios = new TxtComAutoCompletar();
    private BtnFKey btnBusca = new BtnFKey();
    private MyJPasswordField txtSenha = new MyJPasswordField();
    private MyJPasswordField txtConfirmarSenha = new MyJPasswordField();
    private TxtReadOnly txtDataDeCadastro = new TxtReadOnly();

    {
        txtDataDeCadastro.setConversorDeData(new ConversorDateTimeStampString(true));
        txtNome.setDocumentFilter(new NomeDePessoa(new LimitedLengthDocFilter()));
        txtLogin.setDocumentFilter(new Login(new LimitedLengthDocFilter()));
        txtGrupoDeUsuarios.setStrictMatching(true);
        txtGrupoDeUsuarios.setMensagemDeErro("Grupo não encontrado");
        txtGrupoDeUsuarios.setControlador(buscador);
        btnBusca.addActionListener(new ActionAddTela(
                TelaPrincipal.CADASTRO_GRUPOS_DE_USUARIOS,
                new TelaSolPadrao(TelaPrincipal.CADASTRO_USUARIOS, txtGrupoDeUsuarios),
                new AdapterPermissaoDeUsuario() {

            @Override
            public boolean podeAcessar (PerfilDeAcesso p)
            {
                return p.isAcessaGrupoDeUsuarios();
            }

        } ));
    }

    // </editor-fold>

}
