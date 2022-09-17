package com.ic.projects.laudoecia.view.print;

import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.dialogs.DlgSaveAsPDF;
import com.lib.swing.plus.cps.MyHTMLEditorKit;
import com.lib.swing.utils.SwingUtils;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.print.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.print.PrintService;
import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.text.View;
import javax.swing.text.html.StyleSheet;

public class EditorPanePrinter extends JPanel implements Pageable, Printable
{
    private JEditorPane sourcePane;
    private Paper paper;
    private Insets margins;
    private ArrayList<PagePanel> pages;
    private int pageWidth;
    private int pageHeight;
    private View rootView;
    private static int PAGE_SHIFT = 20;
    private PageFormat pageFormat;
    private Dimension headerSize;
    private Dimension footerSize;
    private StyleSheet originalStyleSheet;
    private static DlgSaveAsPDF savePdfFile;
    private boolean controlaAtdInfo;

    public EditorPanePrinter (JEditorPane pane, Paper paper, boolean controlaAtdInfo)
    {
        initData(pane, paper, controlaAtdInfo);
    }

    private void initData (JEditorPane pane, Paper paper, boolean controlaAtdInfo)
    {
        JEditorPane tmpPane = new JEditorPane();

        MyHTMLEditorKit kit = null;
        if (pane.getEditorKit() instanceof MyHTMLEditorKit)
        {
            kit = ((MyHTMLEditorKit) pane.getEditorKit());
            originalStyleSheet = kit.getStyleSheet();
            originalStyleSheet.addRule("div.topico, td { font-size: 93%; } ");
            originalStyleSheet.addRule("table.page table.topico td { font-size: 93%; } ");
            originalStyleSheet.addRule("div.topico, table.topico { margin-bottom: 5px; } ");
            originalStyleSheet.addRule("table.page td { font-size: 100%; } ");
        }

        this.controlaAtdInfo = controlaAtdInfo;

        tmpPane.setEditorKit(kit == null ? pane.getEditorKit() : kit);
        tmpPane.setContentType(pane.getContentType());
        tmpPane.setText(pane.getText());
        tmpPane.setBorder(null);

        this.sourcePane = tmpPane;

        this.paper = paper;
        this.margins = new Insets(
                LaudosHTMLUtils.getTopMargin(),
                LaudosHTMLUtils.getLeftMargin(),
                LaudosHTMLUtils.getBottomMargin(),
                LaudosHTMLUtils.getRightMargin());
        this.pageWidth = (int) paper.getWidth();
        this.pageHeight = (int) paper.getHeight();
        pageFormat = new PageFormat();
        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight());
        pageFormat.setPaper(paper);

        doPagesLayout();
    }

    private void doPagesLayout ()
    {
        setLayout(null);
        removeAll();
        this.rootView = sourcePane.getUI().getRootView(sourcePane);

        sourcePane.setSize(pageWidth - margins.left - margins.right, Integer.MAX_VALUE);
        Dimension d = sourcePane.getPreferredSize();
        sourcePane.setSize(pageWidth - margins.left - margins.right, d.height);

        calculatePageInfo();
        int count = pages.size();
        this.setPreferredSize(new Dimension(pageWidth * 2 + 50, PAGE_SHIFT + count * (pageHeight + PAGE_SHIFT)));
    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        AffineTransform old = ((Graphics2D) g).getTransform();
        ((Graphics2D) g).setTransform(old);
    }

    private void calculatePageInfo ()
    {
        //criando paineis iniciais header e footer para saber as alturas
        JEditorPane pHead = LaudosHTMLUtils.createHeader(controlaAtdInfo);
        JEditorPane pFoot = LaudosHTMLUtils.createFooter(0,0);
        headerSize = pHead.getPreferredSize();
        footerSize = pFoot.getPreferredSize();
        headerSize.width = Math.min(headerSize.width, pageWidth);
        footerSize.width = Math.min(footerSize.width, pageWidth);
        headerSize.height = Math.min(headerSize.height, pageHeight / 2);
        footerSize.height = Math.min(footerSize.height, pageHeight / 2);

        Dimension dimHeadFirst = new Dimension(headerSize.width, headerSize.height);
        Dimension dimHeadOther = null;

        //descobrindo total de paginas
        int totalPage = 1;
        int startY = 0;
        int endPageY = getEndPageY(startY);
        if (startY + pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom < sourcePane.getHeight())
        {
            startY = endPageY;
            endPageY = getEndPageY(startY);
            totalPage++;

            pHead = LaudosHTMLUtils.createHeader(false);
            headerSize = pHead.getPreferredSize();
            headerSize.width = Math.min(headerSize.width, pageWidth);
            headerSize.height = Math.min(headerSize.height, pageHeight / 2);

            dimHeadOther = new Dimension(headerSize.width, headerSize.height);

            while (startY + pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom < sourcePane.getHeight())
            {
                startY = endPageY;
                endPageY = getEndPageY(startY);
                totalPage++;
            }
        }

        headerSize.width = dimHeadFirst.width;
        headerSize.height = dimHeadFirst.height;

        //criando páginas
        pages = new ArrayList<>();
        startY = 0;
        endPageY = getEndPageY(startY);
        int count = 1;
        while (startY + pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom < sourcePane.getHeight())
        {
            Shape pageShape = getPageShape(startY, pageWidth - margins.left - margins.right, pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom, sourcePane);
            pages.add(new PagePanel(startY, pageShape, LaudosHTMLUtils.createHeader(controlaAtdInfo && count == 1), LaudosHTMLUtils.createFooter(count,totalPage)));
            startY = endPageY;
            endPageY = getEndPageY(startY);
            count++;
            if (dimHeadOther != null)
            {
                headerSize.width = dimHeadOther.width;
                headerSize.height = dimHeadOther.height;
            }
        }
        Shape pageShape = getPageShape(startY, pageWidth - margins.left - margins.right, pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom, sourcePane);
        pages.add(new PagePanel(startY, pageShape, LaudosHTMLUtils.createHeader(controlaAtdInfo && totalPage == 1), LaudosHTMLUtils.createFooter(totalPage,totalPage)));

        // desenhando páginas
        count = 0;
        for (PagePanel pi : pages)
        {
            add(pi);
            pi.setLocation(PAGE_SHIFT, PAGE_SHIFT + count * (pageHeight + PAGE_SHIFT));
            count++;
        }
    }

    private int getEndPageY (int startY)
    {
        int desiredY = startY + pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom;
        int realY = desiredY;
        for (int x = 1; x < pageWidth; x++)
        {
            View v = getLeafViewAtPoint(new Point(x, realY), rootView);
            if (v != null)
            {
                Rectangle alloc = getAllocation(v, sourcePane).getBounds();
                if (alloc.height > pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom)
                {
                    continue;
                }
                if (alloc.y + alloc.height > desiredY)
                {
                    realY = Math.min(realY, alloc.y);
                }
            }
        }

        return realY;
    }

    private View getLeafViewAtPoint (Point p, View root)
    {
        return getLeafViewAtPoint(p, root, sourcePane);
    }

    private View getLeafViewAtPoint (Point p, View root, JEditorPane sourcePane)
    {
        int pos = sourcePane.viewToModel(p);
        View v = sourcePane.getUI().getRootView(sourcePane);
        while (v.getViewCount() > 0)
        {
            int i = v.getViewIndex(pos, Position.Bias.Forward);
            v = v.getView(i);
        }
        Shape alloc = getAllocation(root, sourcePane);
        if (alloc.contains(p))
        {
            return v;
        }

        return null;
    }

    private Shape getPageShape (int pageStartY, int pageWidth, int pageHeight, JEditorPane sourcePane)
    {
        Area result = new Area(new Rectangle(0, 0, pageWidth, pageHeight));
        View myRootView = sourcePane.getUI().getRootView(sourcePane);
        Rectangle last = new Rectangle();
        for (int x = 1; x < pageWidth; x++)
        {
            View v = getLeafViewAtPoint(new Point(x, pageStartY), myRootView, sourcePane);
            if (v != null)
            {
                Rectangle alloc = getAllocation(v, sourcePane).getBounds();
                if (alloc.y < pageStartY && alloc.y + alloc.height > pageStartY)
                {
                    if (!alloc.equals(last))
                    {
                        Rectangle r = new Rectangle(alloc);
                        r.y -= pageStartY;
                        result.subtract(new Area(r));
                    }
                }
                last = alloc;
            }
        }

        last = new Rectangle();
        for (int x = 1; x < pageWidth; x++)
        {
            View v = getLeafViewAtPoint(new Point(x, pageStartY + pageHeight), myRootView, sourcePane);
            if (v != null)
            {
                Rectangle alloc = getAllocation(v, sourcePane).getBounds();
                if (alloc.y < pageStartY + pageHeight && alloc.y + alloc.height > pageStartY + pageHeight)
                {
                    if (!alloc.equals(last))
                    {
                        Rectangle r = new Rectangle(alloc);
                        r.y -= pageStartY;
                        result.subtract(new Area(r));
                    }
                }
                last = alloc;
            }
        }

        return result;
    }

    private Shape getAllocation (View v, JEditorPane edit)
    {
        Insets ins = edit.getInsets();
        View vParent = v.getParent();
        int x = ins.left;
        int y = ins.top;
        while (vParent != null)
        {
            int i = vParent.getViewIndex(v.getStartOffset(), Position.Bias.Forward);
            Shape alloc = vParent.getChildAllocation(i, new Rectangle(0, 0, Short.MAX_VALUE, Short.MAX_VALUE));
            x += alloc.getBounds().x;
            y += alloc.getBounds().y;

            vParent = vParent.getParent();
        }
        return new Rectangle(x, y, (int) v.getPreferredSpan(View.X_AXIS), (int) v.getPreferredSpan(View.Y_AXIS));
    }

    //<editor-fold defaultstate="collapsed" desc="Pageable and printable methods">

    @Override
    public int getNumberOfPages ()
    {
        return pages.size();
    }

    @Override
    public PageFormat getPageFormat (int pageIndex) throws IndexOutOfBoundsException
    {
        return pageFormat;
    }

    @Override
    public Printable getPrintable (int pageIndex) throws IndexOutOfBoundsException
    {
        return this;
    }

    @Override
    public int print (Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException
    {
        if (pageIndex < pages.size())
        {
            pageFormat.getPaper().setImageableArea(0, 0, paper.getWidth(), paper.getHeight());

            pages.get(pageIndex).setPrinting(true);
            pages.get(pageIndex).paint(g);
            pages.get(pageIndex).setPrinting(false);

            return PAGE_EXISTS;
        }

        return NO_SUCH_PAGE;
    }

    //</editor-fold>

    private class PagePanel extends JPanel
    {
        private int pageStartY;
        private Shape pageShape;
        private boolean printing = false;
        private JPanel innerPage = new JPanel() {
            @Override
            public void paintComponent (Graphics g)
            {
                super.paintComponent(g);

                AffineTransform old = ((Graphics2D) g).getTransform();

                Shape oldClip = g.getClip();

                Area newClip = new Area(oldClip);
                if (printing)
                {
                    newClip = new Area(pageShape);
                }
                else
                {
                    newClip.intersect(new Area(pageShape));
                }
                g.setClip(newClip);

                g.translate(0, -pageStartY);

                sourcePane.paint(g);
                for (Component c : sourcePane.getComponents())
                {
                    AffineTransform tmp = ((Graphics2D) g).getTransform();
                    g.translate(c.getX(), c.getY());
                    ((Container) c).getComponent(0).paint(g);
                    ((Graphics2D) g).setTransform(tmp);
                }

                ((Graphics2D) g).setTransform(old);
                g.setClip(oldClip);
            }

        };
        private JPanel pnlConteudo = new JPanel();

        private PagePanel (int pageStartY, Shape pageShape, JEditorPane header, JEditorPane footer)
        {
            this.pageStartY = pageStartY;
            this.pageShape = pageShape;

            pnlConteudo.setLayout(null);
            pnlConteudo.add(innerPage);
            pnlConteudo.setBackground(Color.WHITE);
            innerPage.setBackground(Color.WHITE);

            int innerWidth = pageWidth - margins.left - margins.right;
            int innerHeight = pageHeight - headerSize.height - footerSize.height - margins.top - margins.bottom;
            innerPage.setBounds(0, 0, innerWidth, innerHeight);
            pnlConteudo.setPreferredSize(new Dimension(innerWidth, innerHeight));

            setSize(pageWidth, pageHeight);
            setBackground(Color.WHITE);
            setLayout(new GridBagLayout());

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.gridheight = 5;
            add(Box.createHorizontalStrut(margins.left), c);
            c.gridx = 2;
            add(Box.createHorizontalStrut(margins.right), c);
            c.gridheight = 1;
            c.gridx = 1;
            add(Box.createVerticalStrut(margins.top), c);
            c.gridy = 1;
            add(header, c);
            c.gridy = 2;
            add(pnlConteudo, c);
            c.gridy = 3;
            add(footer, c);
            c.gridy = 4;
            add(Box.createVerticalStrut(margins.bottom), c);
        }

        private boolean isPrinting ()
        {
            return printing;
        }

        private void setPrinting (boolean printing)
        {
            this.printing = printing;
        }

    }

    public void print (String defaultFileName)
    {
        print((PrintService) null, defaultFileName);
    }

    public void print (PrintService printService, String defaultFileName)
    {
        try
        {
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            JFrame tmp = new JFrame();
            tmp.getContentPane().add(new JScrollPane(this));
            tmp.pack();
            tmp.setVisible(false);
            printerJob.setPageable(this);
            printerJob.setPrintable(this);
            printerJob.setJobName(defaultFileName);
            if (printService != null)
            {
                printerJob.setPrintService(printService);
            }
            if (printerJob.printDialog())
            {
                printerJob.print();
            }
            tmp.dispose();
        }
        catch (PrinterException printerException)
        {
        }
        voltaOriginalStyleSheet();
    }

    public void savePDF (String defaultFileName)
    {
        try
        {
            if (savePdfFile == null)
            {
                savePdfFile = new DlgSaveAsPDF(defaultFileName);
            }
            else
            {
                savePdfFile.setInicialFileName(defaultFileName);
            }
            String nomeArquivo = savePdfFile.getUserOutputFilePath();
            if (nomeArquivo != null)
            {
                FormPrincipal.getInstance().setCursorToWaitCursor();

                JFrame tmp = new JFrame();
                tmp.getContentPane().add(new JScrollPane(this));
                tmp.pack();
                tmp.setVisible(false);

                new PdfPrinter().printToPdf(this, nomeArquivo);

                int resp = SwingUtils.obterConfirmacaoDoUsuario(
                        "Arquivo gravado com sucesso!\n"
                        + "Deseja abrir o arquivo gerado?", FormPrincipal.getInstance());
                if (resp == JOptionPane.YES_OPTION)
                {
                    File pdf = new File(nomeArquivo);
                    try
                    {
                        Desktop.getDesktop().open(pdf);
                    }
                    catch (IOException ex)
                    {
                        SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
                          "Não existe no seu computador um programa para abrir "
                                + "o arquivo.");
                    }
                    catch (Exception ex)
                    {
                        SwingUtils.mostrarAviso(FormPrincipal.getInstance(), "Houve uma falha ao tentar"
                                      + " abrir o arquivo:\n" + ex.getMessage());
                    }
                }
                tmp.dispose();
            }
        }
        catch (HeadlessException | IOException | PrinterException ex)
        {
            SwingUtils.mostrarAviso(FormPrincipal.getInstance(), "Houve uma falha ao gerar o arquivo.\n"
                    + "Verifique se ele não está aberto.");
        }
        catch (Exception ex)
        {
            SwingUtils.mostrarAviso(FormPrincipal.getInstance(), "Houve uma falha ao gerar o arquivo.\n");
        }
        finally
        {
            FormPrincipal.getInstance().setCursorToDefaultCursor();
        }
        voltaOriginalStyleSheet();
    }

    public void printFromPdf (String jobName, String defaultPrinter, int copies)
    {
        try
        {
            FormPrincipal.getInstance().setCursorToWaitCursor();

            JFrame tmp = new JFrame();
            tmp.getContentPane().add(new JScrollPane(this));
            tmp.pack();
            tmp.setVisible(false);

            File tempPdf = File.createTempFile("laudo", ".pdf");
            tempPdf.deleteOnExit();
            new PdfPrinter().printToPdf(this, tempPdf.getAbsolutePath());
            tmp.dispose();

            new PrintPdf(new FileInputStream(tempPdf),
                    jobName, pageFormat).print(defaultPrinter, copies);

        }
        catch (HeadlessException | IOException | PrinterException ex)
        {
            SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
                                    "Houve uma falha ao gerar o arquivo.\n"
                    + "Verifique se ele não está aberto.");
        }
        catch (Exception ex)
        {
            SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
                                    "Houve uma falha ao gerar o arquivo.\n");
        }
        finally
        {
            FormPrincipal.getInstance().setCursorToDefaultCursor();
            voltaOriginalStyleSheet();
        }
    }

    public void print (String jobName, String defaultPrinter, int copies)
    {
        try
        {
            FormPrincipal.getInstance().setCursorToWaitCursor();

            JFrame tmp = new JFrame();
            tmp.getContentPane().add(new JScrollPane(this));
            tmp.pack();
            tmp.setVisible(false);

            File tempPdf = File.createTempFile("laudo", ".pdf");
            tempPdf.deleteOnExit();
            new PdfPrinter().printToPdf(this, tempPdf.getAbsolutePath());
            tmp.dispose();

            new PrintPdf(new FileInputStream(tempPdf),
                    jobName, pageFormat).print(defaultPrinter, copies);

        }
        catch (HeadlessException | IOException | PrinterException ex)
        {
            SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
                                    "Impressora não localizada, verifique.");
        }
        catch (Exception ex)
        {
            SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
                                    "Houve uma falha ao imprimir.\n");
        }
        finally
        {
            FormPrincipal.getInstance().setCursorToDefaultCursor();
            voltaOriginalStyleSheet();
        }
    }

    public void voltaOriginalStyleSheet ()
    {
        if (sourcePane.getEditorKit() instanceof MyHTMLEditorKit)
        {
            originalStyleSheet.addRule("div.topico, td { font-family: Arial, Helvetica, sans-serif; font-size: 12pt; } div.topico, table.topico { margin-bottom: 5px; }");
        }
    }

}
