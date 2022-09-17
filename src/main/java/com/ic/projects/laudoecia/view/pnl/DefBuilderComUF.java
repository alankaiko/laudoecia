/*
 * DefBuilderComUF.java
 *
 * Created on 23/02/2012, 10:30:09
 */

package com.ic.projects.laudoecia.view.pnl;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.utils.TableConfigurator;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DefBuilderComUF extends DefBuilder
{
    public DefBuilderComUF (TableConfigurator tc)
    {
        super(tc);
    }

    public DefBuilderComUF withUF ()
    {
        MyJComboBox<UF> cmbUF = new MyJComboBox<>(StaticInfo.getUfs());
        cmbUF.setSelectedItem(StaticInfo.getDefaultUF());
        cmbUF.setFocusable(false);
        // deve ser adicionado por ultimo para que nao sejam disparados eventos
        cmbUF.addItemListener(defaultItemListener);
        pnlParamsBusca.add(cmbUF, cmbReader, new LblNegrito("UF"), null);
        return this;
    }

    @Override
    public DefBuilderComUF setCmbCampos (int width, String... campos)
    {
        return (DefBuilderComUF) super.setCmbCampos(width, campos);
    }

    @Override
    public DefBuilderComUF setCmbCampos (int width, int selIndex, String... campos)
    {
        return (DefBuilderComUF) super.setCmbCampos(width, selIndex, campos);
    }

    @Override
    public DefBuilderComUF setCmbNumResultados ()
    {
        return (DefBuilderComUF) super.setCmbNumResultados();
    }

    @Override
    public DefBuilderComUF setCmbNumResultados (int selIndex)
    {
        return (DefBuilderComUF) super.setCmbNumResultados(selIndex);
    }

    @Override
    public DefBuilderComUF setTxtBusca (int width)
    {
        return (DefBuilderComUF) super.setTxtBusca(width);
    }

}
