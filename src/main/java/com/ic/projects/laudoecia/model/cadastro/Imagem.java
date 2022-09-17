/*
 * Imagem.java
 *
 * Created on 18/01/2012, 16:56:57
 */
package com.ic.projects.laudoecia.model.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "imagem")
public class Imagem implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "imagem", nullable = false)
    private byte[] imagem;

    @Column(nullable = false, name = "indice")
    private int indice;

    public Imagem ()
    {
    }

    public Imagem (int codigo)
    {
        this.codigo = codigo;
    }

    public Imagem(byte[] img)
    {
        imagem = img;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public byte[] getImagem ()
    {
        if (imagem == null)
        {
            return null;
        }
//        return Arrays.copyOf(imagem, imagem.length);
        return imagem;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setImagem (byte[] imagem)
    {
        if (imagem == null)
        {
            this.imagem = null;
        }
        else
        {
            this.imagem = imagem;
        }
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public int getIndice ()
    {
        return indice;
    }

    public void setIndice (int indice)
    {
        this.indice = indice;
    }

    @Override
    public String toString ()
    {
        return "ImagemCapturada{" + "codigo=" + codigo + '}';
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Imagem other = (Imagem) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 13 * hash + this.codigo;
        return hash;
    }

}
