/*
 * PnlLicenciado.java
 *
 * Created on 04/04/2012, 11:21:46
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.ic.projects.laudoecia.model.basededados.CNES;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.model.enums.TIPO_LICENCA;
import com.ic.projects.laudoecia.view.pnl.PnlEndereco;
import com.ic.projects.laudoecia.view.utils.FormatarTelefone;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.crud.entidade.validation.TxtEmailValidator;
import com.lib.swing.maskedfields.TxtCNPJ;
import com.lib.swing.maskedfields.TxtCPF;
import com.lib.swing.maskedfields.TxtTelefone;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.utils.CmbEnum;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtInteiro;
import com.lib.swing.plus.utils.TxtReadOnly;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlLicenciado extends PnlDaEntidadeComCrud<Licenciado>
{
    public PnlLicenciado ()
    {
        setTemTxtCodigo(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        add(new CampoDaEnt("CPF ou", false, false).setComponent(txtCpf.pintarDeAmarelo()), c);
        add(Box.createHorizontalStrut(110), c);
        c.gridx = 1;
        add(new CampoDaEnt("CNPJ", true, false).setComponent(txtCnpj.pintarDeAmarelo()), c);
        add(Box.createHorizontalStrut(140), c);
        c.gridx = 2;
        add(new CampoDaEnt("N˚ de licenças", true, false).setComponent(txtNumLic.pintarDeAmarelo()), c);
        add(Box.createHorizontalStrut(100), c);
        c.gridx = 3;
        add(new CampoDaEnt("Tipo de licença", true, false).setComponent(cmbTipo.pintarDeAmarelo()), c);
        c.gridx = 4;
        c.weightx = 1;
        add(new CampoDaEnt("Serial", true, false).setComponent(txtSerial.pintarDeAmarelo()), c);
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 2;
        c.gridwidth = 5;
        add(new CampoDaEnt("Nome de registro do programa (Será impresso no rodapé e não pode ser alterado)", false,
                true).setComponent(txtLicenciadoPara.pintarDeAmarelo()), c);
        c.gridy = 1;
        c.gridwidth = 4;
        add(new CampoDaEnt("Razão social (ou pessoa física)", false, true).setComponent(txtRazaoSocial), c);
        c.gridx = 4;
        c.gridwidth = 1;
        TxtReadOnly txtVersao = new TxtReadOnly();
        txtVersao.setText(LaudoeCia.VERSAO_DO_SISTEMA);
        add(new PnlComp("Versão instalada", true, true).setComponent(txtVersao), c);
        c.gridwidth = 5;
        c.gridy = 3;
        c.gridx = 0;
        add(pnlEndereco, c);
        pnlEndereco.getCmbUf().pintarDeAmarelo();
        pnlEndereco.getTxtCidade().pintarDeAmarelo();
        c.gridy = 4;
        c.gridwidth = 1;
        add(new CampoDaEnt("Telefone 1", false, true).setComponent(txtTelefone1), c);
        c.gridwidth = 4;
        c.gridx = 1;
        add(new CampoDaEnt("Website", true, true).setComponent(txtSite), c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 5;
        add(new CampoDaEnt("Telefone 2", false, true).setComponent(txtTelefone2), c);
        c.gridx = 1;
        c.gridwidth = 4;
        add(new CampoDaEnt("E-mail", true, true).setComponent(txtEmail), c);

    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (Licenciado entity, int contador)
    {
        txtCnpj.setText(entity.getCnpj());
        txtCpf.setText(entity.getCpf());
        txtLicenciadoPara.setText(entity.getLicenciadoPara());
        txtRazaoSocial.setText(entity.getRazaoSocial());
        pnlEndereco.setEndereco(entity.getEndereco());
        if (entity.getTelefone1().length() == 10)
        {
            txtTelefone1.setText(FormatarTelefone.getInstance().format("(##)####-#####", entity.getTelefone1()));
        }
        else if (entity.getTelefone2().length() == 10)
        {
            txtTelefone2.setText(FormatarTelefone.getInstance().format("(##)####-#####", entity.getTelefone2()));
        }
        else
        {
            txtTelefone1.setText(entity.getTelefone1());
            txtTelefone2.setText(entity.getTelefone2());
        }
        txtEmail.setText(entity.getEmail());
        txtSite.setText(entity.getSite());
        txtNumLic.setText(entity.getQtdeAcessos());
        cmbTipo.setSelectedItem(entity.getTipodelicenca());
        txtSerial.setText(entity.getSerial());
        return true;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtCpf.requestFocusInWindow();
    }

    @Override
    public void preencherDadosDaEntidade (Licenciado ent)
    {
        ent.setCnpj(txtCnpj.getText());
        ent.setCpf(txtCpf.getText());
        ent.setLicenciadoPara(txtLicenciadoPara.getText());
        ent.setRazaoSocial(txtRazaoSocial.getText());
        ent.setEndereco(pnlEndereco.getEndereco());

        if (txtTelefone1.getText().length() < 11)
        {
            ent.setTelefone1("");
        }
        else
        {
            ent.setTelefone1(txtTelefone1.getText());
        }

        if (txtTelefone2.getText().length() < 11)
        {
            ent.setTelefone2("");
        }
        else
        {
            ent.setTelefone2(txtTelefone2.getText());
        }
        ent.setEmail(txtEmail.getText());
        ent.setSite(txtSite.getText());
        ent.setTipodelicenca(cmbTipo.getSelectedItem());
        ent.setQtdeAcessos(txtNumLic.getInt());
        ent.setSerial(txtSerial.getText());
    }

    @Override
    public void usarResultadoDaBusca (Object o)
    {
        if (o instanceof EnderecoPorCep)
        {
            pnlEndereco.alimentarCamposPorCep(((EnderecoPorCep) o).getEndereco());
        }
        if (o instanceof CNES)
        {
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private final TxtCNPJ               txtCnpj           = new TxtCNPJ();
    private final TxtCPF                txtCpf            = new TxtCPF();
    private final TxtInteiro            txtNumLic         = new TxtInteiro(2);
    private final CmbEnum<TIPO_LICENCA> cmbTipo           = new CmbEnum<>(TIPO_LICENCA.APENAS_LAUDO, TIPO_LICENCA
            .APENAS_LAUDO);
    private final MyJTextField          txtSerial         = new MyJTextField();
    private final MyJTextField          txtLicenciadoPara = new MyJTextField();
    private final MyJTextField          txtRazaoSocial    = new MyJTextField();
    private final PnlEndereco           pnlEndereco       = new PnlEndereco(TelaPrincipal.DADOS_DO_LICENCIADO);
    private final TxtTelefone           txtTelefone1      = new TxtTelefone(StaticInfo.getDefaultDDD());
    private final TxtTelefone           txtTelefone2      = new TxtTelefone(StaticInfo.getDefaultDDD());
    private final MyJTextField          txtEmail          = new MyJTextField();
    private final MyJTextField          txtSite           = new MyJTextField();

    {
        txtLicenciadoPara.setDocumentFilter(new LimitedLengthDocFilter());
        txtRazaoSocial.setDocumentFilter(new LimitedLengthDocFilter());
        txtEmail.setStrCnfEnabled(false);
        txtSite.setStrCnfEnabled(false);
    }

    //</editor-fold>

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(pnlEndereco.getCmbUf(), new RequiredFieldValidator(pnlEndereco.getCmbUf()));
        formValidator.add(pnlEndereco.getTxtCidade(), new RequiredFieldValidator(pnlEndereco.getTxtCidade()));
        formValidator.add(txtEmail, new TxtEmailValidator(txtEmail));
        formValidator.add(txtLicenciadoPara, new IValidaCampo()
        {

            @Override
            public boolean validationOk (int tipo)
            {
                String serial = txtSerial.getText();
                if (serial.trim().isEmpty())
                {
                    return true;
                }
                if (StaticInfo.seriaisProibidos.contains(serial))
                {
                    return false;
                }
                try
                {
                    Licenciado lic = new Licenciado();
                    lic.setLicenciadoPara(txtLicenciadoPara.getText());
                    lic.setQtdeAcessos(txtNumLic.getInt());
                    lic.setTipodelicenca(cmbTipo.getSelectedItem());
                    return serial.equals(StaticInfo.
                            encriptografar(StaticInfo.getStringParaCypher(lic)));
                }
                catch (Exception ex)
                {
                    return false;
                }
            }

            @Override
            public String getErrorMessage ()
            {
                return "<html><br>Dados inválido! Verifique:</br>"
                        + "<br>O número de licenças e o tipo de licença</br>"
                        + "<br>O nome de registro (verificar acentos)</br>"
                        + "<br>O serial</br>"
                        + "</html>";
            }
        });
    }

}
