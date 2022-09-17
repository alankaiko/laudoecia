/*
 * DlgVisualizarHTML.java
 *
 * Created on 23/07/2012, 08:37:21
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.utils.HTMLEditor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgVisualizarHTML extends MyJDialog
{
    
    public DlgVisualizarHTML (Component cp, final String html)
    {
        super(cp, true, 500, 400);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(scrlPane, BorderLayout.CENTER);
        setResizable(true);
        htmlEditor.setHtml(html);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened (WindowEvent e)
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run ()
                    {
                        scrlPane.getVerticalScrollBar().setValue(0);
                    }
                    
                });
            }
        });
    }

    private HTMLEditor htmlEditor = new HTMLEditor();
    private JScrollPane scrlPane = new JScrollPane(htmlEditor);

    {
        htmlEditor.setEditable(false);
    }

    @Override
    public void fechar ()
    {
        dispose();
    }

}
