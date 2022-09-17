/*
 * PnlProfSolicitante.java
 *
 * Created on 12/03/2012, 17:27:09
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfSolECrm;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.FieldReader;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.docfilters.NomeDePessoa;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import javax.swing.Box;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlProfSolicitante extends PnlDaEntidadeComCrud<ProfSolicitante>
{
    private BuscadorDeProfSolECrm buscProfSol = new BuscadorDeProfSolECrm();
    private boolean autoCompletar = false;
    private int codigo;

    public PnlProfSolicitante ()
    {
        setTemTxtCodigo(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridy = 0; //linha1
        c.gridx = 0;
        add(new CampoDaEnt("UF conselho", false, false).setComponent(cmbUfConselho.pintarDeAmarelo()), c);
        c.gridx = 1;
        add(new CampoDaEnt("Conselho", true, false).setComponent(cmbConselho.pintarDeAmarelo()), c);
        c.gridx = 2;
        add(new CampoDaEnt("Número no conselho", true, false).setComponent(txtNumNoConselho.pintarDeAmarelo()), c);
        c.gridy = 1; //linha 2
        c.gridwidth = 4;
        c.gridx = 0;
        add(new CampoDaEnt("Nome do profissional", false, true).setComponent(txtNome.pintarDeAmarelo()), c);

        c.gridwidth = 1;
        c.gridy = 2; //linha 3 (tamanhos)
        c.weighty = 1;
        c.gridx = 0;
        add(Box.createHorizontalStrut(80), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(100), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(130), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(230), c);
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (ProfSolicitante entidade, int contador)
    {
        autoCompletar = false;
        codigo = entidade.getCodigo();
        txtNome.setText(entidade.getNome());
        cmbConselho.setSelectedItem(entidade.getConselho());
        cmbUfConselho.setSelectedItem(entidade.getUfConselho());
        txtNumNoConselho.setText(entidade.getNumNoConselho());
        return true;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        autoCompletar = true;
        cmbUfConselho.requestFocusInWindow();
        if (dadosIniciais != null && dadosIniciais instanceof String)
        {
            txtNumNoConselho.setText((String) dadosIniciais);
        }
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        txtNome.requestFocusInWindow();
    }

    @Override
    public void preencherDadosDaEntidade (ProfSolicitante entidadeBase)
    {
        entidadeBase.setConselho(cmbConselho.getSelectedItem());
        entidadeBase.setNome(txtNome.getText());
        entidadeBase.setNumNoConselho(txtNumNoConselho.getText());
        entidadeBase.setUfConselho(cmbUfConselho.getSelectedItem());
    }

    //<editor-fold defaultstate="collapsed" desc="Components PnlEntidade">

    private MyJTextField txtNome = new MyJTextField();
    private MyJComboBox<TISS_Conselho> cmbConselho = new MyJComboBox<>(StaticInfo.getTiss_Conselhos());
    private MyJComboBox<UF> cmbUfConselho = new MyJComboBox<>(StaticInfo.getUfs());
    private TxtComAutoCompletar txtNumNoConselho = new TxtComAutoCompletar();
    private MyJLabel lblImagemMedicina = new MyJLabel();

    {
        buscProfSol.setBuscarSoEmCrm(true);
        txtNome.setDocumentFilter(new NomeDePessoa(new LimitedLengthDocFilter()));
        lblImagemMedicina.setIcon(ImageResources.getIcon(ImagensLC.MEDICINA));
        txtNumNoConselho.addAutoCompletarListener(new AutoCompletarListener()
        {
            @Override
            public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
            {
                ProfSolicitante ps = buscProfSol.getSelectedModel();
                if (ps != null)
                {
                    txtNome.setText(ps.getNome());
                }
            }

        });
        txtNumNoConselho.setLargura(2.5d);
        cmbUfConselho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    buscProfSol.setUf(cmbUfConselho.getSelectedItem());
                }
            }
        });
        cmbConselho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    if (cmbConselho.getSelectedItem().equals(new TISS_Conselho("CRM")) && autoCompletar)
                    {
                        buscProfSol.setConselho(cmbConselho.getSelectedItem());
                        txtNumNoConselho.setControlador(buscProfSol);
                    }
                    else
                    {
                        txtNumNoConselho.setControlador(null);
                    }
                }
            }
        });
    }

    //</editor-fold>

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(cmbUfConselho, new RequiredFieldValidator(cmbUfConselho));
        formValidator.add(cmbConselho, new RequiredFieldValidator(cmbConselho));
        formValidator.add(txtNumNoConselho, new RequiredFieldValidator(txtNumNoConselho),
                          validadores.get("numNoConselho").
                            set("codigo", new FieldReader() {
                                @Override
                                public Object readField ()
                                {
                                    return codigo;
                                }
                            }).
                            set("uf", readerComboBox(cmbUfConselho)).
                            set("conselho", readerComboBox(cmbConselho)).
                            set("numNoConselho", readerStr(txtNumNoConselho)));
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome));
    }

}
