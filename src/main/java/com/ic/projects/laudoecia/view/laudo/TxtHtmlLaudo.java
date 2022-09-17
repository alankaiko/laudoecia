/*
 * TxtHtmlLaudo.java
 *
 * Created on 26/06/2012, 10:03:48
 */
package com.ic.projects.laudoecia.view.laudo;

import br.com.oslunaticos.InstallSpellcheck;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.DlgAddAbreviatura;
import com.ic.projects.laudoecia.view.laudoecia.DlgAddTextoPadrao;
import com.lib.java.utils.StringUtils;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.utils.TxtHTML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class TxtHtmlLaudo extends TxtHTML
{

    // <editor-fold defaultstate="collapsed" desc="Add texto pessoal">

    private MyJButton btnAddAbreviatura;
    private MyJButton btnAddTextos;
    private ProcMedico proc;

    // </editor-fold>

    public TxtHtmlLaudo ()
    {
        setPreferredSize(getToolBar().getPreferredSize());
    }

    public TxtHtmlLaudo (int sizeInicial)
    {
        super(sizeInicial);
        setPreferredSize(getToolBar().getPreferredSize());
    }

    public TxtHtmlLaudo withSpellChecker ()
    {
        InstallSpellcheck.install(
                getEditor(),
                StaticInfo.mainDictPath(),
                StaticInfo.userDictPath());
        return this;
    }

    public TxtHtmlLaudo withAddTextosPadrao (ProcMedico proc)
    {

        this.proc = proc;

        btnAddAbreviatura = new MyJButton("Inserir abreviatura (F2)");
        btnAddAbreviatura.setIcon(ImageResources.getIcon(ImagensLC.ADD_TEXTO));
        btnAddAbreviatura.setToolTipText("Inserir abreviatura na posição do cursor. (F2)");
        btnAddAbreviatura.setFocusable(false);
        btnAddAbreviatura.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddAbreviaturaAction();
            }
        });

        btnAddTextos = new MyJButton("Inserir texto pessoal (F3)");
        btnAddTextos.setIcon(ImageResources.getIcon(ImagensLC.ADD_TEXTO));
        btnAddTextos.setToolTipText("Inserir texto pessoal na posição do cursor. (F3)");
        btnAddTextos.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddTextoPessoalAction();
            }
        });
        btnAddTextos.setFocusable(false);

        InputMap inputMap = getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        KeyStroke f3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, true);
        KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, true);
        inputMap.put(f3, "addTextoPessoal");
        inputMap.put(f2, "addAbreviatura");

        ActionMap actionMap = getActionMap();
        actionMap.put("addTextoPessoal", new AbstractAction() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddTextoPessoalAction();
            }
        });
        actionMap.put("addAbreviatura", new AbstractAction() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddAbreviaturaAction();
            }
        });

        addExtraButton(btnAddAbreviatura);
        addExtraButton(btnAddTextos);

        return this;
    }

    private void btnAddTextoPessoalAction ()
    {
        final DlgAddTextoPadrao d = new DlgAddTextoPadrao(proc);
        d.setVisible(true);
        if (!d.isCancelado())
        {
            getEditor().replaceSelection("");
            insertHTML(d.getTexto(), getEditor().getCaretPosition());
        }
    }

    private void btnAddAbreviaturaAction ()
    {
        DlgAddAbreviatura d = new DlgAddAbreviatura();
        final int sr = getEditor().getSelectionStart();
        final int se = getEditor().getSelectionEnd();
        if (se > sr)
        {
           getEditor().cut();
        }
        d.setVisible(true);
        if (!d.isCancelado())
        {
//            if (se > sr)
//            {
//                RobotImpl.pressionarTecla(KeyEvent.VK_DELETE);
//            }
//            java.awt.EventQueue.invokeLater(new Runnable()
//            {
//
//                @Override
//                public void run ()
//                {
                    getEditor().paste();
//                }
//            });
        }
    }

    @Override
    public void setHtml (String html)
    {
        if (html == null || html.trim().isEmpty())
        {
            super.setHtml("<html><head></head><body><p style=\"margin-top: 0\"></p></body></html>");
        }
        else if (html.contains("<html><head>"))
        {
            throw new IllegalArgumentException("Html inesperado!");
        }
        else
        {
            super.setHtml("<html><head></head><body>" + html + "</body></html>");
        }
    }

    @Override
    public String getHTML ()
    {
        return StringUtils.getBodyContents(super.getHTML());
    }

}
