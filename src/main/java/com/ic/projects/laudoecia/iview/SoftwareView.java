/*
 * SoftwareView.java
 *
 * Created on 27/04/2012, 16:41:47
 */

package com.ic.projects.laudoecia.iview;

import com.ic.projects.laudoecia.iview.captura.C_Captura;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface SoftwareView
{

    void runThread (Runnable thread, Runnable notify);

    C_Captura getC_Captura ();

    void paramsSistemaMudou ();

}
