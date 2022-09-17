/*
 * PrintLaudo.java
 *
 * Created on 13/06/2012, 11:05:47
 */
package com.ic.projects.laudoecia.view.print;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.model.cnv.ConversorDoublePixels;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyHTMLEditorKit;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.LblNegrito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Paper;
import java.text.SimpleDateFormat;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PrintLaudo
{
    private ProcDoAtd procDoAtd;
    private MyJDialog dlgPreview;
    private ConversorDoublePixels convPixels = new ConversorDoublePixels();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public PrintLaudo ()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rect = new Rectangle(screenSize);
        dlgPreview = new MyJDialog(FormPrincipal.getInstance(), true, rect)
        {
            @Override
            public void fechar ()
            {
                dispose();
            }
        };
        dlgPreview.setUndecorated(true);
    }

    public void setProcDoAtd (ProcDoAtd procDoAtd)
    {
        this.procDoAtd = procDoAtd;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public void print (String html, String defaultPrinter, int copies)
    {
        if (procDoAtd == null)
        {
            return;
        }
        createPanePrinter(html).print(procDoAtd.getAtendimento().
                                  getCodigo() + " - " + procDoAtd.toString(),
                                             defaultPrinter, copies);
    }

    public void printAtestado (String html)
    {
        EditorPanePrinter pnl = createPanePrinter(html);
        pnl.print("Atestado Médico");
    }

    public void gerarPDF (String html)
    {
        if (procDoAtd == null)
        {
            return;
        }
        EditorPanePrinter pnl = createPanePrinter(html);

        pnl.savePDF(sdf.format(procDoAtd.getAtendimento().getDataAtendimento()) + "-" +
                procDoAtd.getAtendimento().getPaciente().getNome());
    }

    public void gerarPDFAtestado (String html)
    {
        EditorPanePrinter pnl = createPanePrinter(html);
        pnl.savePDF("Atestado Médico");
    }

    public void preview (String html, ActionListener imprimirAction)
    {
        if (procDoAtd == null)
        {
            return;
        }

        MyJPanel menu = createMenuBarPreview(imprimirAction);
        EditorPanePrinter pnlPreview = createPanePrinter(html);
        final JScrollPane scrl = new JScrollPane(pnlPreview);
        scrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrl.getVerticalScrollBar().setBlockIncrement(50);
        scrl.getVerticalScrollBar().setUnitIncrement(50);
        scrl.setBorder(new BlackAndWhiteEtchedBorder());
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                scrl.getVerticalScrollBar().setValue(0);
                scrl.getHorizontalScrollBar().setValue(0);
            }

        });

        dlgPreview.getContentPane().removeAll();
        dlgPreview.add(menu, BorderLayout.NORTH);
        dlgPreview.add(scrl, BorderLayout.CENTER);
        dlgPreview.setVisible(true);
        pnlPreview.voltaOriginalStyleSheet();
    }

    private EditorPanePrinter createPanePrinter (String html)
    {
        JEditorPane tmpPane = new JEditorPane();
        tmpPane.setEditorKit(new MyHTMLEditorKit());
        tmpPane.setContentType("text/html");
        tmpPane.setText(html);

        Paper paper = new Paper();
        ParametrosDoSistema param = StaticInfo.getParametrosDoSistema();
        int w = convPixels.convertForward(param.getPaperWidth());
        int h = convPixels.convertForward(param.getPaperHeight());
        paper.setSize(w, h);
        return new EditorPanePrinter(tmpPane, paper, procDoAtd != null);
    }

    private MyJPanel createMenuBarPreview (ActionListener action)
    {
        MyJButton btnVoltar = new MyJButton("Voltar");
        btnVoltar.setToolTipText("Voltar");
        btnVoltar.setIcon(SwingLibResources.getIcon(Imagens.VOLTAR));
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                dlgPreview.fechar();
            }
        });

        MyJButton btnImp = new MyJButton("Imprimir");
        btnImp.setIcon(SwingLibResources.getIcon(Imagens.IMPRESSORA));
        btnImp.setToolTipText("Iniciar impressão");
        btnImp.addActionListener(action);

        MyJPanel menu = new MyJPanel(new FlowLayout(FlowLayout.LEFT));
        menu.setBorder(new BlackAndWhiteEtchedBorder());
        menu.add(btnVoltar);
        menu.add(btnImp);
        menu.add(new LblNegrito("       Pré-Visualizar impressão"));
        return menu;
    }

    public int getNumPages (String html)
    {
        if (procDoAtd == null)
        {
            return 0;
        }
        EditorPanePrinter pnl = createPanePrinter(html);
        return pnl.getNumberOfPages();
    }

}
