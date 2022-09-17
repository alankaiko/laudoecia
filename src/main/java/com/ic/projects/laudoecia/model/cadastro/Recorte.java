/*
 * Recorte.java
 *
 * Created on 24/01/2015, 22:56:51
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
 * @author Tekna <informatica@teknamed.com.br>
 */
@Entity
@Table(name = "recorte")
public class Recorte implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "posicaox")
    private int posicaoX;

    @Column(name = "posicaoy")
    private int posicaoY;

    @Column(name = "largura")
    private int largura;

    @Column(name = "altura")
    private int altura;

    @Column(name = "descricao", nullable = false, unique = true)
    private String descricao = "";

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public int getPosicaoX ()
    {
        return posicaoX;
    }

    public void setPosicaoX (int posicaoX)
    {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY ()
    {
        return posicaoY;
    }

    public void setPosicaoY (int posicaoY)
    {
        this.posicaoY = posicaoY;
    }

    public int getLargura ()
    {
        return largura;
    }

    public void setLargura (int largura)
    {
        this.largura = largura;
    }

    public int getAltura ()
    {
        return altura;
    }

    public void setAltura (int altura)
    {
        this.altura = altura;
    }

    public String getDescricao ()
    {
        return descricao;
    }

    public void setDescricao (String descricao)
    {
        this.descricao = descricao == null ? null : descricao.toUpperCase();
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 41 * hash + this.codigo;
        return hash;
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
        final Recorte other = (Recorte) obj;
        return this.codigo == other.getCodigo();
    }

    @Override
    public String toString ()
    {
        return descricao;
    }

}
