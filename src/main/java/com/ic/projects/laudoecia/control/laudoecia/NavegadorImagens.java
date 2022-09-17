/*
 * NavegadorImagens.java
 *
 * Created on 24/04/2012, 10:32:21
 */
package com.ic.projects.laudoecia.control.laudoecia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
class NavegadorImagens
{
    
    private List<byte[]> lista = new ArrayList<>();
    private int indexAtual;

    // <editor-fold defaultstate="collapsed" desc="Navegacao">
    
    boolean irParaImgAnterior ()
    {
        if (indexAtual > 0)
        {
            --indexAtual;
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean irParaProximaImg ()
    {
        if (indexAtual < lista.size() - 1)
        {
            indexAtual++;
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean irParaUltimaImg ()
    {
        if (lista.isEmpty() || indexAtual == lista.size() - 1)
        {
            return false;
        }
        else
        {
            indexAtual = lista.size() - 1;
            return true;
        }
    }

    boolean irParaPrimeiraImg ()
    {
        if (lista.isEmpty() || indexAtual == 0)
        {
            return false;
        }
        else
        {
            indexAtual = 0;
            return true;
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Manutencao da lista">
    
    boolean setIndexAtual (int index)
    {
        if (index < 0 || index >= lista.size() || indexAtual == index)
        {
            return false;
        }
        else
        {
            indexAtual = index;
            return true;
        }
    }
    
    void setLista (List<byte[]> lista)
    {
        this.lista.clear();
        if (lista == null)
        {
        }
        else
        {
            for (int i = 0; i < lista.size(); i++)
            {
                // preservando a ordem dos elementos
                this.lista.add(lista.get(i));
            }
        }
        indexAtual = getNumeroDeImagens() == 0 ? -1 : 0;
    }

    void atualizarImgSel (byte[] img)
    {
        lista.set(indexAtual, img);
    }

    void addImagem (byte[] img)
    {
        lista.add(img);
        indexAtual = lista.size() - 1;
    }
    
    void removerImgSelecionada ()
    {
        lista.remove(indexAtual);
        if (lista.isEmpty())
        {
            indexAtual = -1;
        }
        else if (indexAtual < lista.size())
        {
        }
        else
        {
            indexAtual--;
        }
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Informacoes da lista">
    
    byte[] getImagemAtual ()
    {
        if (indexAtual > -1)
        {
            return lista.get(indexAtual);
        }
        else
        {
            return null;
        }
    }

    int getIndexAtual ()
    {
        return indexAtual;
    }
    
    int getNumeroDeImagens ()
    {
        return lista.size();
    }
    
    List<byte[]> getImagens ()
    {
        return Collections.unmodifiableList(lista);
    }
    
    // </editor-fold>

}
