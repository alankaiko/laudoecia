/*
 * SplashScreenLC.java
 *
 * Created on 17/01/2012, 09:01:19
 */
package com.ic.projects.laudoecia.view.build;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Danilo Brito
 */
public class SplashScreenLC
{
    private static SplashScreen mySplash;
    private static java.awt.geom.Rectangle2D.Double splashVersionTextArea;
    private static java.awt.geom.Rectangle2D.Double splashTextArea;
    private static java.awt.geom.Rectangle2D.Double splashProgressArea;
    private static Graphics2D splashGraphics;

    private static Font font;

    /**
     * Prepare the global variables for the other splash functions
     */
    public static void splashInit ()
    {
        mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null)
        {   // if there are any problems displaying the splash this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;

            // stake out some area for our status information
            splashVersionTextArea = new Rectangle2D.Double(30., height * 0.52, width * .46, 30.);
            splashTextArea = new Rectangle2D.Double(18., height * 0.82, width * .46, 30.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height * .85, width * .4, 12);

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 12);
            splashGraphics.setFont(font);

            //initialize the status info
            splashVersionText();
            splashText("Carregando...");
            splashProgress(0);
        }
    }

    public static void splashUpdate (String texto, int progress)
    {
        splashText(texto);
        splashProgress(progress);
    }

    /**
     * Display text in status area of Splash. Note: no validation it will fit.
     *
     * @param str - text to be displayed
     */
    private static void splashText (String str)
    {
        if (mySplash != null && mySplash.isVisible())
        {
            // erase the last status text
            splashGraphics.setPaint(Color.WHITE);
            splashGraphics.fill(splashTextArea);

            // draw the text
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int) (splashTextArea.getX() + 10), (int) (splashTextArea.getY() + 20));

            // make sure it's displayed
            mySplash.update();
        }
    }

    private static void splashVersionText ()
    {
        if (mySplash != null && mySplash.isVisible())
        {
            // draw the text
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString("Versão " + LaudoeCia.VERSAO_DO_SISTEMA, (int) (splashVersionTextArea.getX() + 5), (int) (splashVersionTextArea.getY() + 15));
            splashGraphics.drawString(LaudoeCia.COPYRIGHT_DO_SISTEMA, (int) (splashVersionTextArea.getX() + 5), (int) (splashVersionTextArea.getY() + 30));
            splashGraphics.drawString(LaudoeCia.PAGINA_OFICIAL_DO_SISTEMA, (int) (splashVersionTextArea.getX() + 5), (int) (splashVersionTextArea.getY() + 45));
            // make sure it's displayed
            mySplash.update();
        }
    }

    /**
     * Display a (very) basic progress bar
     *
     * @param pct how much of the progress bar to display 0-100
     */
    private static void splashProgress (int pct)
    {
        if (mySplash != null && mySplash.isVisible())
        {

            // Note: 3 colors are used here to demonstrate steps
            // erase the old one
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashProgressArea);

            // draw an outline
            splashGraphics.setPaint(Color.DARK_GRAY);
            splashGraphics.draw(splashProgressArea);

            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct * wid / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.decode("#0096d8"));
            splashGraphics.fillRect(x + 2, y + 1, doneWidth, hgt - 1);

            // make sure it's displayed
            mySplash.update();
        }
    }

    public static void splashClose ()
    {
        if (mySplash != null)
        {
            mySplash.close();
        }
    }

}
