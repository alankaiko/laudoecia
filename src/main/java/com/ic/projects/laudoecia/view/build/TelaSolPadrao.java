/*
 * TelaSolPadrao.java
 *
 * Created on 25/09/2012, 08:40:44
 */

package com.ic.projects.laudoecia.view.build;

import com.ic.projects.laudoecia.iview.TelaSolicitante;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import javax.swing.JTextField;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class TelaSolPadrao implements TelaSolicitante
{

    private int codigo;
    private TxtComAutoCompletar txtAutocomp;
    private JTextField txt;
    private ReceptorDeBusca receptor;

    public TelaSolPadrao (int codigo, JTextField txt)
    {
        this(codigo, txt, null);
    }

    public TelaSolPadrao (TxtComAutoCompletar txt, int codigo)
    {
        // esse construtor trata o txt como txtfield
        this.codigo = codigo;
        if (txt == null)
        {
            throw new IllegalArgumentException("Txt não pode ser null!");
        }
        else
        {
            this.txt = txt;
        }
    }

    public TelaSolPadrao (int codigo, JTextField txt, ReceptorDeBusca receptor)
    {
        this.codigo = codigo;
        if (txt == null)
        {
            throw new IllegalArgumentException("Txt não pode ser null!");
        }
        if (txt instanceof TxtComAutoCompletar)
        {
            txtAutocomp = (TxtComAutoCompletar) txt;
        }
        else
        {
            this.txt = txt;
        }
        this.receptor = receptor;
    }

    public JTextField getTxt ()
    {
        return txt == null ? txtAutocomp : txt;
    }

    @Override
    public Object getParametroDeBusca ()
    {
        JTextField txtCadastrado = txt;
        if (txt == null)
        {
            if (txtAutocomp.existeLinhaSelecionada())
            {
                return txtAutocomp.getControlador().getSelectedModel();
            }
            txtCadastrado = txtAutocomp;
        }
        if (txtCadastrado.isEditable())
        {
            return txtCadastrado.getText() == null ? "" : txtCadastrado.getText();
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getCodigo ()
    {
        return codigo;
    }

    @Override
    public ReceptorDeBusca getReceptorDeBusca ()
    {
        return receptor;
    }

}
