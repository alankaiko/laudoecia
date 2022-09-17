/*
 * PnlCID10.java
 *
 * Created on 12/03/2012, 08:29:55
 */

package com.ic.projects.laudoecia.view.basededados;

import com.ic.projects.laudoecia.model.basededados.CapituloCID10;
import com.ic.projects.laudoecia.model.basededados.CategoriaCID10;
import com.ic.projects.laudoecia.model.basededados.GrupoCID10;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.model.enums.CID_CAUSA_OBITO;
import com.lib.model.abstracao.RESTRICAO_SEXO;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.plus.cps.MyJTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlCID10 extends PnlDaEntidade<SubcategoriaCID10>
{
    
    public PnlCID10 ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 5;
        c.weightx = 1.0;
        add(new CampoDaEnt("Nome da doença / Subcategoria", false, false).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridy = 1;
        c.weightx = 0;
        add(new CampoDaEnt("Categoria", false, true).setComponent(txtCategoria), c);
        c.gridy = 2;
        c.gridwidth = 5;
        add(new CampoDaEnt("Grupo", false, true).setComponent(txtGrupo), c);
        c.gridy = 3;
        add(new CampoDaEnt("Assunto / Capítulo", false, true).setComponent(txtCapitulo), c);
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 4;
        add(new CampoDaEnt("Referência", false, true).setComponent(txtReferencia), c);
        c.gridx = 1;
        c.gridwidth = 2;
        add(new CampoDaEnt("Causa óbito").setComponent(txtCausaObito), c);
        c.gridx = 3;
        c.gridwidth = 1;
        add(new CampoDaEnt("Restrição de sexo").setComponent(txtRestrSexo), c);
        c.gridx = 4;
        JTextField txt = txtCodigo.pintarDeAmarelo();
        txt.setHorizontalAlignment(JTextField.CENTER);
        add(new CampoDaEnt("Código (CID)", SwingConstants.CENTER, true, true).setComponent(txt), c);
        c.gridy = 5;
        c.gridx = 0;
        c.weighty = 1d;
        add(Box.createHorizontalStrut(180), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(100), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(60), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(170), c);
        c.gridx = 4;
        add(Box.createHorizontalStrut(60), c);
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (SubcategoriaCID10 entidade, int contador)
    {
        GrupoCID10 grupo = null;
        CapituloCID10 capitulo = null;
        CategoriaCID10 categoria = entidade.getCategoriaCID10();
        CID_CAUSA_OBITO causaObito = entidade.getCausaObito();
        RESTRICAO_SEXO restricao_Sexo = entidade.getRestrSexo();

        if (categoria != null)
        {
            grupo = categoria.getGrupoCID10();
            if (grupo != null)
            {
                capitulo = grupo.getCapituloCID10();
            }
        }

        txtCapitulo.setText(capitulo == null ? "" : capitulo.getNome());
        txtCategoria.setText(categoria == null ? "" : categoria.getNome());
        txtCausaObito.setText(causaObito == null ? "" : causaObito.toString());
        txtCodigo.setText(entidade.getCodigo());
        txtGrupo.setText(grupo == null ? "" : grupo.getNome());
        txtNome.setText(entidade.getNome());
        txtReferencia.setText(entidade.getReferencia());
        txtRestrSexo.setText(restricao_Sexo == null ? "" : restricao_Sexo.toString());
        return true;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Components PnlEntidade">
    
    private MyJTextField txtNome = new MyJTextField();
    private MyJTextField txtCategoria = new MyJTextField();
    private MyJTextField txtGrupo = new MyJTextField();
    private MyJTextField txtCapitulo = new MyJTextField();
    private MyJTextField txtReferencia = new MyJTextField();
    private MyJTextField txtCausaObito = new MyJTextField();
    private MyJTextField txtRestrSexo = new MyJTextField();
    private MyJTextField txtCodigo = new MyJTextField();
    
    // </editor-fold>

}
