/*
 * PnlCNES.java
 *
 * Created on 12/03/2012, 08:39:07
 */

package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.basededados.CNES;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.maskedfields.TxtCNPJ;
import com.lib.swing.maskedfields.TxtCPF;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlCNES extends PnlDaEntidade<CNES>
{

    public PnlCNES ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        add(new CampoDaEnt("Nome fantasia", false, false).setComponent(txtNomeFantasia.pintarDeAmarelo()), c);

        c.gridy = 1;
        add(new CampoDaEnt("Razão social", false, true).setComponent(txtRazaoSocial.pintarDeAmarelo()), c);

        c.gridy = 2;
        c.gridwidth = 2;
        add(new CampoDaEnt("CNES", false, true).setComponent(txtCNES.pintarDeAmarelo()), c);
        c.gridx = 2;
        c.gridwidth = 1;
        add(new CampoDaEnt("CPF", true, true).setComponent(txtCPF), c);
        c.gridx = 3;
        add(new CampoDaEnt("CNPJ", true, true).setComponent(txtCNPJ), c);

        c.gridy = 3;
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt("UF", false, true).setComponent(cmbUf), c);
        c.gridx = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new CampoDaEnt("Cidade", true, true).setComponent(txtCidade), c);

        c.gridy = 4;
        c.weighty = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(Box.createHorizontalStrut(70), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(80), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(150), c);
        c.gridx = 3;
        c.weightx = 1;
        add(Box.createHorizontalStrut(1), c);
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (CNES entidade, int contador)
    {
        cmbUf.setSelectedItem(entidade.getUf());
        txtCidade.setText(entidade.getMunicipio());
        txtCNES.setText(entidade.getCodigo());
        txtNomeFantasia.setText(entidade.getNomeFantasia());
        txtCPF.setText(entidade.getCpf());
        txtRazaoSocial.setText(entidade.getRazaoSocial());
        txtCNPJ.setText(entidade.getCnpj());
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes PnlEntidade">

    private MyJComboBox<UF> cmbUf = new MyJComboBox<>(StaticInfo.getUfs());
    private MyJTextField txtCidade = new MyJTextField();
    private MyJTextField txtCNES = new MyJTextField();
    private MyJTextField txtNomeFantasia = new MyJTextField();
    private TxtCPF txtCPF = new TxtCPF();
    private MyJTextField txtRazaoSocial = new MyJTextField();
    private TxtCNPJ txtCNPJ = new TxtCNPJ();

    //</editor-fold>

}
