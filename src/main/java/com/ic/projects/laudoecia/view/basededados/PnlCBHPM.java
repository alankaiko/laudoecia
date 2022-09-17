/*
 * PnlCBHPM.java
 *
 * Created on 09/03/2012, 16:47:20
 */
package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.model.basededados.CBHPM;
import com.ic.projects.laudoecia.view.maskedfields.TxtCodigoCBHPM;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.plus.cps.MyJTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlCBHPM extends PnlDaEntidade<CBHPM>
{

    public PnlCBHPM ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        c.gridy = 0; //linha 1
        c.gridx = 0;
        c.gridwidth = 7;
        add(new CampoDaEnt("Procedimento", false, false).setComponent(txtProcedimento), c);

        c.gridy = 1; //linha 2
        c.gridx = 0;
        add(new CampoDaEnt("Subgrupo", false, true).setComponent(txtSubgrupo), c);
        c.gridy = 2; //linha 3
        c.gridx = 0;
        add(new CampoDaEnt("Grupo", false, true).setComponent(txtGrupo), c);

        c.gridy = 3; //linha 4
        c.gridwidth = 1;
        c.gridx = 0;
        add(new CampoDaEnt("Código Anatômico", false, true).setComponent(txtCodigo), c);
        c.gridx = 1;
        add(new CampoDaEnt("Nº Aux.", true, true).setComponent(txtNumAux), c);
        c.gridx = 2;
        add(new CampoDaEnt("Porte Anestésico", true, true).setComponent(txtPorteAnest), c);
        c.gridx = 3;
        add(new CampoDaEnt("Filmes", true, true).setComponent(txtFilmes), c);
        c.gridx = 4;
        add(new CampoDaEnt("Incidência", true, true).setComponent(txtIncidencia), c);
        c.gridx = 5;
        add(new CampoDaEnt("Porte", true, true).setComponent(txtPorte), c);
        c.gridx = 6;
        add(new CampoDaEnt("Custo Op.", true, true).setComponent(txtCusto), c);

        c.gridy = 4; //linha 5 ajuste tamanhos
        c.weighty = 1;
        c.gridx = 0;
        add(Box.createHorizontalStrut(120), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(60), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(120), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(70), c);
        c.gridx = 4;
        add(Box.createHorizontalStrut(90), c);
        c.gridx = 5;
        add(Box.createHorizontalStrut(110), c);
        c.gridx = 6;
        add(Box.createHorizontalStrut(110), c);

    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (CBHPM entidade, int contador)
    {
        txtProcedimento.setText(entidade.getProcedimento());
        if (entidade.getSubgrupo() != null)
        {
            txtSubgrupo.setText(entidade.getSubgrupo().getSubgrupo());
            txtGrupo.setText(entidade.getSubgrupo().getGrupo() == null ? ""
                             : entidade.getSubgrupo().getGrupo().getGrupo());
        }
        else
        {
            txtGrupo.setText("");
            txtSubgrupo.setText("");
        }
        txtCodigo.setText(entidade.getCodigo());
        txtNumAux.setText(String.valueOf(entidade.getNauxiliares()));
        txtPorteAnest.setText(entidade.getPorteAnest());
        txtFilmes.setText(String.valueOf(entidade.getFilmes()));
        txtIncidencia.setText(String.valueOf(entidade.getIncidencia()));
        txtPorte.setText(entidade.getPorte());
        txtCusto.setText(String.valueOf(entidade.getCustoOp()));
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes do PnlEntidade">

    private MyJTextField txtProcedimento = new MyJTextField();
    private MyJTextField txtGrupo = new MyJTextField();
    private MyJTextField txtSubgrupo = new MyJTextField();
    private TxtCodigoCBHPM txtCodigo = new TxtCodigoCBHPM();
    private MyJTextField txtNumAux = new MyJTextField();
    private MyJTextField txtPorteAnest = new MyJTextField();
    private MyJTextField txtFilmes = new MyJTextField();
    private MyJTextField txtIncidencia = new MyJTextField();
    private MyJTextField txtPorte = new MyJTextField();
    private MyJTextField txtCusto = new MyJTextField();

    {
        txtProcedimento.pintarDeAmarelo();
        txtCodigo.pintarDeAmarelo();
    }

    //</editor-fold>

}
