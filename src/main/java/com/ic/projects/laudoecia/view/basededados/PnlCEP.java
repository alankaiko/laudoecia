/*
 * PnlCEP.java
 *
 * Created on 13/03/2012, 10:51:44
 */
package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.basededados.EnderecoPorCep;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.maskedfields.TxtCep;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlCEP extends PnlDaEntidade<EnderecoPorCep>
{

    public PnlCEP ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0; 
        c.gridx = 0;
        c.gridwidth = 2;
        add(new CampoDaEnt("CEP", false, false).setComponent(txtCep), c);

        c.gridy = 1; 
        c.gridx = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt("UF", false, true).setComponent(cmbUf), c);
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        add(new CampoDaEnt("Cidade", true, true).setComponent(txtCidade), c);

        c.gridy = 2; 
        c.gridx = 0;
        c.gridwidth = 4;
        add(new CampoDaEnt("Bairro", false, true).setComponent(txtBairro), c);

        c.gridy = 3; 
        c.gridx = 0;
        c.gridwidth = 3;
        add(new CampoDaEnt("Tipo Log.", false, true).setComponent(txtTipoLog), c);
        c.gridx = 3;
        c.gridwidth = 1;
        add(new CampoDaEnt("Endereço (Logradouro)", true, true).setComponent(txtLogradouro), c);
        
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridy = 4;
        add(new CampoDaEnt("Complemento", false, true).setComponent(txtComplemento), c);
        
        c.gridy = 5; 
        c.weighty = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        add(Box.createHorizontalStrut(70), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(50), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(40), c);
        c.gridx = 3;
        c.weightx = 1;
        add(Box.createHorizontalStrut(10), c);

    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (EnderecoPorCep entidade, int contador)
    {
        if (entidade.getEndereco() != null)
        {
            txtCep.setText(entidade.getEndereco().getCep());
            cmbUf.setSelectedItem(entidade.getEndereco().getUf());
            txtCidade.setText(entidade.getEndereco().getCidade());
            txtBairro.setText(entidade.getEndereco().getBairro());
            txtTipoLog.setText(entidade.getEndereco().getTipoDeLogradouro());
            txtLogradouro.setText(entidade.getEndereco().getLogradouro());
            txtComplemento.setText(entidade.getEndereco().getComplemento());
        }
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes do PnlEntidade">
    
    private TxtCep txtCep = new TxtCep();
    private MyJComboBox<UF> cmbUf = new MyJComboBox<>(StaticInfo.getUfs());
    private MyJTextField txtCidade = new MyJTextField();
    private MyJTextField txtBairro = new MyJTextField();
    private MyJTextField txtTipoLog = new MyJTextField();
    private MyJTextField txtLogradouro = new MyJTextField();
    private MyJTextField txtComplemento = new MyJTextField();

    //</editor-fold>

}
