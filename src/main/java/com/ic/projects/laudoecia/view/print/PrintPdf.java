/*
 * PrintPdf.java
 *
 * Created on 21/08/2013, 16:46:18
 */

package com.ic.projects.laudoecia.view.print;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
class PrintPdf
{

    private PrinterJob pjob = null;

    PrintPdf(InputStream inputStream, String jobName, PageFormat pf) throws IOException, PrinterException
    {
        byte[] pdfContent = new byte[inputStream.available()];
        inputStream.read(pdfContent, 0, inputStream.available());
        initialize(pdfContent, jobName, pf);
    }

    /**
     * Initializes the job
     *
     * @param pdfContent
     * @param jobName
     * @throws IOException
     * @throws PrinterException
     */
    private void initialize (byte[] pdfContent, String jobName, PageFormat pf) throws IOException, PrinterException
    {
        ByteBuffer bb = ByteBuffer.wrap(pdfContent);
        PDFFile pdfFile = new PDFFile(bb);
        PDFPrintPage pages = new PDFPrintPage(pdfFile);

        pjob = PrinterJob.getPrinterJob();
        pjob.setJobName(jobName);
        Book book = new Book();
        book.append(pages, pf, pdfFile.getNumPages());
        pjob.setPageable(book);

    }

    void print (String defaultPrinter, int copies) throws PrinterException
    {
        if (!(defaultPrinter == null || defaultPrinter.isEmpty()))
        {
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
            for (PrintService printService : ps)
            {
                if (printService.getName().equalsIgnoreCase(defaultPrinter))
                {
                    pjob.setPrintService(printService);
                    break;
                }
            }
        }
        pjob.setCopies(copies);
        if (pjob.printDialog())
        {
            pjob.print();
        }
    }

    /**
     * Class that actually converts the PDF file into Printable format
     */
    private class PDFPrintPage implements Printable
    {

	private PDFFile file;

	private PDFPrintPage(PDFFile file)
        {
		this.file = file;
	}

        @Override
	public int print(Graphics g, PageFormat format, int index) throws PrinterException
        {
		int pagenum = index + 1;
		if ((pagenum >= 1) && (pagenum <= file.getNumPages())) {
			Graphics2D g2 = (Graphics2D) g;
			PDFPage page = file.getPage(pagenum);

			// fit the PDFPage into the printing area
			Rectangle imageArea = new Rectangle((int) format.getImageableX(), (int) format.getImageableY(),
					(int) format.getImageableWidth(), (int) format.getImageableHeight());
			g2.translate(0, 0);
			PDFRenderer pgs = new PDFRenderer(page, g2, imageArea, null, null);
			try {
				page.waitForFinish();
				pgs.run();
			} catch (InterruptedException ie) {
				// nothing to do
			}
			return PAGE_EXISTS;
		} else {
			return NO_SUCH_PAGE;
		}
	}

}

}
