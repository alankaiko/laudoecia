/*
 * PnlCrm.java
 *
 * Created on 09/03/2012, 17:01:51
 */

package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.basededados.Crm;
import com.ic.projects.laudoecia.model.basededados.EspecialidadeMedica;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.plus.cps.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.Box;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlCrm extends PnlDaEntidade<Crm>
{

    public PnlCrm ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(new CampoDaEnt("CRM", false, false).setComponent(txtCrm.pintarDeAmarelo()), c);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(new CampoDaEnt("UF", true, false).setComponent(cmbUf), c);
        c.gridx = 3;
        c.gridheight = 3;
        c.fill = GridBagConstraints.NONE;
        add(lblImagemMedicina, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        add(new CampoDaEnt("Nome", false, false).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1d;
        c.ipady = 53;
        scrpEspecialidades.setViewportView(lstEspecialidades);
        add(new CampoDaEnt("Especialidades", false, false).setComponent(scrpEspecialidades), c);
        c.gridwidth = 1;
        c.gridy = 3;
        c.gridx = 0;
        c.weighty = 0;
        c.ipady = 0;
        add(Box.createHorizontalStrut(100), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(70), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(350), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(130), c);
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (Crm entidade, int contador)
    {
        switch (contador)
        {
            case 0:
                txtCrm.setText(entidade.getCrm());
                cmbUf.setSelectedItem(entidade.getUf());
                txtNome.setText(entidade.getNome());
                return false;
            case 1:
                lstEspecialidades.limparLista();
                List<EspecialidadeMedica> lEsp = entidade.getEspecialidades();
                return lEsp == null;
            case 2:
                List<EspecialidadeMedica> lEsp2 = entidade.getEspecialidades();
                String[] listData = new String[lEsp2.size()];
                for (int i = 0; i < lEsp2.size(); i++)
                {
                    listData[i] = lEsp2.get(i).getNome();
                }
                lstEspecialidades.setListData(listData);
                return true;
            default:
                throw new AssertionError();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Components PnlEntidade">

    private MyJTextField txtCrm = new MyJTextField();
    private MyJComboBox<UF> cmbUf = new MyJComboBox<>(StaticInfo.getUfs());
    private MyJTextField txtNome = new MyJTextField();
    private MyJList<String> lstEspecialidades = new MyJList<>();
    private MyJScrollPane scrpEspecialidades = new MyJScrollPane();
    private MyJLabel lblImagemMedicina = new MyJLabel();

    // </editor-fold>

    {
        lblImagemMedicina.setIcon(ImageResources.getIcon(ImagensLC.MEDICINA));
    }

}
