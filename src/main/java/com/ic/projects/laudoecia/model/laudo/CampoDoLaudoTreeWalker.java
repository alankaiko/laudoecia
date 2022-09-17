/*
 * Interface.java
 *
 * Created on 12/04/2013, 09:49:34
 */

package com.ic.projects.laudoecia.model.laudo;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
interface CampoDoLaudoTreeWalker
{
    final int CONTINUAR = 0;
    final int PULAR_PROLE = 1;
    final int PARAR = 2;

    int visit (CampoDoLaudo cdl);

}
