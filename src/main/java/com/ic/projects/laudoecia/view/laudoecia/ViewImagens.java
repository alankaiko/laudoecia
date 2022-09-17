/*
 * ViewImagens.java
 *
 * Created on 02/07/2012, 10:09:30
 */

package com.ic.projects.laudoecia.view.laudoecia;

import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
interface ViewImagens
{

    void addImg (byte[] imagem);
    void atualizarSelecao ();
    void carregarImagens (List<byte[]> imagens);
    void removerImgSel ();
    void imgSelMudou ();

}
