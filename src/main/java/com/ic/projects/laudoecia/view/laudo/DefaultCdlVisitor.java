/*
 * DefaultCdlVisitor.java
 *
 * Created on 21/06/2012, 14:39:04
 */
package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.model.laudo.*;
import com.lib.swing.plus.cps.MyJTextField;
import java.awt.Component;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class DefaultCdlVisitor extends ViewCdlVisitor
{

    private Component componentCriado;
    private boolean vincularVisible;
    private boolean focusable;
    private boolean highlight;

    DefaultCdlVisitor (boolean vincularVisible, boolean focusable, boolean highlight)
    {
        this.vincularVisible = vincularVisible;
        this.focusable = focusable;
        this.highlight = highlight;
    }

    @Override
    public Component getComponentCriado ()
    {
        Component resposta = componentCriado;
        componentCriado = null;
        return resposta;
    }

    @Override
    public void visit (CampoDate campoData)
    {
        TxtData txtData = new TxtData(campoData, vincularVisible);
        txtData.setFocusable(focusable);
        componentCriado = txtData;
        componentCriado.addFocusListener(DefaultFocusList.getInstance());
    }

    @Override
    public void visit (CampoDouble campoDouble)
    {
        TxtDouble txtDouble = new TxtDouble(campoDouble, vincularVisible);
        txtDouble.setFocusable(focusable);
        componentCriado = txtDouble;
        componentCriado.addFocusListener(DefaultFocusList.getInstance());
    }

    @Override
    public void visit (CampoRpn campoRpn)
    {
        componentCriado = new TxtSomenteLeitura(campoRpn, vincularVisible);
    }

    @Override
    public void visit (CampoRpnData campoRpnData)
    {
        MyJTextField txt = new TxtSomenteLeitura(campoRpnData, vincularVisible);
        if (highlight)
        {
            txt = txt.pintarDeAmarelo();
        }
        componentCriado = txt;
    }

    @Override
    public void visit (CampoInteiro campoInteiro)
    {
        TxtInteiro txtInteiro = new TxtInteiro(campoInteiro, vincularVisible);
        txtInteiro.setFocusable(focusable);
        componentCriado = txtInteiro;
        componentCriado.addFocusListener(DefaultFocusList.getInstance());
    }

    @Override
    public void visit (CampoTexto campoTexto)
    {
        TxtCampoTexto txtCampoTxt = new TxtCampoTexto(campoTexto, vincularVisible);
        txtCampoTxt.getEditor().addFocusListener(DefaultFocusList.getInstance());
        componentCriado = txtCampoTxt;
    }

    @Override
    public void visit (Enumeracao enumeracao)
    {
        TxtEnumeracao txt = new TxtEnumeracao(enumeracao, vincularVisible);
        txt.setFocusable(focusable);
        if (highlight)
        {
            txt.pintarDeAmarelo();
        }
        componentCriado = txt;
        componentCriado.addFocusListener(DefaultFocusList.getInstance());
    }

    @Override
    public void visit (Label label)
    {
        componentCriado = new TxtSomenteLeitura(label, vincularVisible);
    }

    @Override
    public void visit (CampoLogicoTexto campoLogicoTexto)
    {
        MyJTextField txt = new TxtSomenteLeitura(campoLogicoTexto, vincularVisible);
        if (highlight)
        {
            txt = txt.pintarDeAmarelo();
        }
        componentCriado = txt;
    }

    @Override
    public void visit (CampoLogico campo)
    {
        MyJTextField txt = new TxtSomenteLeitura(campo, vincularVisible);
        if (highlight)
        {
            txt = txt.pintarDeAmarelo();
        }
        componentCriado = txt;
    }

    @Override
    public void visit (CampoAlfaNumerico campoAlfaNumerico)
    {
        TxtCampoAlfaNumerico txt = new TxtCampoAlfaNumerico(campoAlfaNumerico, vincularVisible);
        txt.setFocusable(focusable);
        componentCriado = txt;
        if (highlight)
        {
            txt.pintarDeAmarelo();
        }
        componentCriado.addFocusListener(DefaultFocusList.getInstance());
    }

}
