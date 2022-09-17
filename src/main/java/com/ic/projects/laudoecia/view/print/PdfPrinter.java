package com.ic.projects.laudoecia.view.print;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * With this class, you can print a {@link Pageable} to a pdf
 *
 * @author Morgan Conrad
 *
 * Based upon earlier work by
 * @author G.J. Schouten
 * @see http://www.zenbi.co.uk/2011/09/04/printable-to-pdf/
 *
 * Using the wonderful iText library. This version is built for version 2.1.7
 * but it will work, with changes to the import statements, with iText 5.2.1
 * @author Bruno Lowagie
 * @see http://itextpdf.com/
 */
public class PdfPrinter
{

    private static final DefaultFontMapper fm = new DefaultFontMapper();

    static
    {
        fm.insertDirectory("c:/windows/fonts/");
    }

    public int printToPdf (Pageable pageable, String fileName) throws IOException, Exception, PrinterException
    {
        if (pageable.getNumberOfPages() <= 0)
        {
            return 0;
        }
        PageFormat pageFormat = pageable.getPageFormat(0);
        float width = (float) pageFormat.getWidth();
        float height = (float) pageFormat.getHeight();
        Rectangle pageRect = new Rectangle(0.0f, 0.0f, width, height);
        Document document = new Document(pageRect);
        PdfWriter writer = null;
        OutputStream os = null;
        try
        {
            os = new FileOutputStream(fileName);
            writer = PdfWriter.getInstance(document, os);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            int pageIdx = 0, pageStatus = 0;
            do
            {
                if (pageIdx > 0)
                {
                    document.newPage();
                }
                Graphics2D g2d = null;
                float convertToJpeg = StaticInfo.convertToJpeg();
                if (convertToJpeg > 0)
                {
                    g2d = cb.createGraphics(width, height, fm, true, convertToJpeg);
                }
                else
                {
                    g2d = cb.createGraphics(width, height, fm);
                }
                Printable printable = pageable.getPrintable(pageIdx);
                try
                {
                    pageStatus = printable.print(g2d, pageFormat, pageIdx);
                }
                finally
                {
                    g2d.dispose();
                }
                pageIdx++;
            }
            while ((pageStatus == Printable.PAGE_EXISTS) && (pageIdx < pageable.getNumberOfPages()));
            return pageIdx;
        }
        catch (DocumentException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            document.close();
            if (writer != null)
            {
                writer.close();
            }
            if (os != null)
            {
                os.flush();
                os.close();
            }
        }
    }

}