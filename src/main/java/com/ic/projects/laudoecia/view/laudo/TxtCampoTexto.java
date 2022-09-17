/*
 * TxtCampoTexto.java
 *
 * Created on 21/06/2012, 17:09:04
 */
package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoTexto;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.utils.RobotImpl;
import com.lib.swing.utils.SwingUtils;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class TxtCampoTexto extends TxtHtmlLaudo implements ViewCampoDoLaudo
{

    private final CampoTexto campoTexto;
    private int focusLostStatus = ViewCampoDoLaudo.NONE;
    private int lastKey;

    // <editor-fold defaultstate="collapsed" desc="Add texto sugestivo">
    private MyJButton btnAddTextoSugestivo;

    // </editor-fold>
    TxtCampoTexto (CampoTexto campoTexto, boolean vincularVisible)
    {
        this.campoTexto = campoTexto;
        withSpellChecker();
        withAddTextosPadrao(campoTexto.getProc().getProcMedico());
        if (campoTexto.possuiTextoPadrao())
        {
            withTextoSugestivo();
        }
        getEditor().getDocument().addDocumentListener(
                new DefaultListener(this, vincularVisible));

        configurarFocusManager();
    }

    private TxtHtmlLaudo withTextoSugestivo ()
    {
        btnAddTextoSugestivo = new MyJButton("Inserir texto sugestivo/normal (F4)");
        btnAddTextoSugestivo.setIcon(ImageResources.getIcon(ImagensLC.ADD_TEXTO));
        btnAddTextoSugestivo.setToolTipText("Inserir texto sugestivo/normal (F4)");
        btnAddTextoSugestivo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddTextoSugestivoAction();
            }

        });

        InputMap inputMap = getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        KeyStroke f4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, true);
        inputMap.put(f4, "addTextoSugestivo");

        ActionMap actionMap = getActionMap();
        actionMap.put("addTextoSugestivo", new AbstractAction()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddTextoSugestivoAction();
            }

        });

        addExtraButton(btnAddTextoSugestivo);

        return this;
    }

    private void btnAddTextoSugestivoAction ()
    {
        try
        {
            setHtml(campoTexto.getTextoPadrao());
        }
        catch (ErrosDeValidacao ex)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "Erro de validação!"
                                                            + " Verifique se os campos necessários foram preenchidos.");
        }
    }

    private void configurarFocusManager ()
    {

        setFocusTraversalKeysEnabled(false);

        getEditor().addFocusListener(new FocusLostStatusCleaner(this));
        getEditor().addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusLost (FocusEvent e)
            {
                if (docEstaVazio())
                {
                    setHtml("");
                }
                else
                {

                }
            }

        });

        getEditor().addKeyListener(new MeuKeyList());

        InputMap inputMap = getEditor().getInputMap();
        ActionMap actionMap = getEditor().getActionMap();

        // para nao tratar o tab
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "tab");
        actionMap.put("tab", new AbstractAction()
        {

            @Override
            public void actionPerformed (ActionEvent e)
            {
            }

        });

    }

    @Override
    public void setText (String valorDoCdl)
    {
        setHtml(valorDoCdl);
    }

    @Override
    public void setEnabled (boolean enabled)
    {
        getEditor().setEnabled(enabled);
    }

    @Override
    public String getValor ()
    {
        return getHTML();
    }

    @Override
    public CampoDoLaudo getCampoDoLaudo ()
    {
        return campoTexto;
    }

    @Override
    public int getFocusLostStatus ()
    {
        return focusLostStatus;
    }

    @Override
    public void setFocusLostStatus (int status)
    {
        focusLostStatus = status;
    }

    private class MeuKeyList extends KeyAdapter
    {

        @Override
        public void keyReleased (KeyEvent evt)
        {
            if (evt.isConsumed())
            {
                return;
            }
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_TAB:
                    if (evt.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK)
                    {
                    }
                    else if (!validarTamanhoDoTexto())
                    {
                        break;
                    }
                    else if (docEstaVazio() && campoTexto.isObrigatorio())
                    {
                        PnlLaudoeCia.getInstance().mostrarMsgErro(
                                campoTexto.getMsgErroValidCampoObrig());
                        break;
                    }
                    KeyboardFocusManager manager
                                         = KeyboardFocusManager.getCurrentKeyboardFocusManager();
                    if (evt.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK)
                    {
                        setFocusLostStatus(ViewCampoDoLaudo.SHIFT_TAB);
                        manager.focusPreviousComponent();
                    }
                    else
                    {
                        setFocusLostStatus(ViewCampoDoLaudo.TAB);
                        manager.focusNextComponent();
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_ENTER:
//                    if (docEstaVazio())
//                    {
//                        if (campoTexto.isObrigatorio())
//                        {
//                            PnlLaudoeCia.getInstance().mostrarMsgErro(""
//                                                                      + campoTexto.getMsgErroValidCampoObrig());
//                        }
//                        else if (lastKey == KeyEvent.VK_ENTER
//                                 && getEditor().getCaretPosition() == getEditor().getDocument().getLength())
//                        {
//                            changeFocus(false, evt);
//                        }
//                    }
//                    else if (lastKey == KeyEvent.VK_ENTER
//                             && getEditor().getCaretPosition() == getEditor().getDocument().getLength())
//                    {
//                        changeFocus(false, evt);
//                    }
                    break;
                case KeyEvent.VK_UP:
                    if (docEstaVazio())
                    {
                        changeFocus(true, evt);
                    }
                    break;
                default:
            }
            lastKey = evt.getKeyCode();
        }

        private void changeFocus (boolean useShift, KeyEvent evt)
        {
            if (useShift)
            {
                setFocusLostStatus(ViewCampoDoLaudo.SHIFT_TAB);
                RobotImpl.pressionarTecla(KeyEvent.VK_TAB, KeyEvent.VK_SHIFT);
            }
            else
            {
                setFocusLostStatus(ViewCampoDoLaudo.TAB);
                RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
            }
            evt.consume();
        }

    }

    private boolean validarTamanhoDoTexto ()
    {
        if (campoTexto.tamanhoDoTextoOk())
        {
            return true;
        }
        String msgAdicional = "";
        if (campoTexto.possuiTextoPadrao())
        {
            msgAdicional += "\nTecle F4 para o texto sugestivo.";
        }
        PnlLaudoeCia.getInstance().mostrarMsgErro("Texto inválido!" + msgAdicional);
        return false;
    }

    private boolean docEstaVazio ()
    {
        return campoTexto.impressaoEstaVazia();
    }

}
