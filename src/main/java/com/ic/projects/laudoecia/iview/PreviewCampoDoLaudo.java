/*
 * PreviewCampoDoLaudo.java
 *
 * Created on 11/07/2012, 11:17:13
 */

package com.ic.projects.laudoecia.iview;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface PreviewCampoDoLaudo
{

    void atualizarDadosDoPreview (int indexCdl);
    void atualizarAlturaDoPreview (int pixels);
    void limparPreview ();

}
