/*
 * JanelaComTitulo.java
 *
 * Created on 05/03/2013, 15:18:56
 */

package com.ic.projects.laudoecia.view.pnl;

import com.lib.swing.utils.SwingUtils;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public abstract class JanelaComTitulo
{

    public abstract void setTitulo (String titulo);
    public abstract String getTitulo ();

    public static JanelaComTitulo obterJanela (Component cp)
    {
        final JInternalFrame iframe = SwingUtils.getParent(
                cp, JInternalFrame.class);
        if (iframe == null)
        {
            final JDialog dlg = SwingUtils.getParent(
                cp, JDialog.class);
            if (dlg == null)
            {
                return null;
            }
            else
            {
                return new JanelaComTitulo() {

                    @Override
                    public void setTitulo (String titulo)
                    {
                        dlg.setTitle(titulo);
                    }

                    @Override
                    public String getTitulo ()
                    {
                        return dlg.getTitle();
                    }
                };
            }
        }
        else
        {
            return new JanelaComTitulo() {

                @Override
                public void setTitulo (String titulo)
                {
                    iframe.setTitle(titulo);
                }

                @Override
                public String getTitulo ()
                {
                    return iframe.getTitle();
                }
            };
        }
    }

}
