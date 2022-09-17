/*
 * JFrameRelatorios.java
 *
 * Created on 16/05/2012, 17:57:05
 */

package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.swing.plus.cps.MyJFrame;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class JFrameRelatorios extends MyJFrame
{

    public JFrameRelatorios (String title)
    {
        super(title);
        setIconImage(FormPrincipal.getInstance().getIconImage());
    }

}
