/*
 *  ModeloDeLaudo.java
 *
 *  Created on 21/06/2011, 11:41:48
 */
package com.ic.projects.laudoecia.model.laudo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author SimonidesZacarias
 */
@Entity
@Table(name = "modelodelaudo")
public class ModeloDeLaudo implements Serializable
{

    // <editor-fold defaultstate="collapsed" desc="Códigos">

    public static final int DIVERSOS = 5;
    public static final int TEXTO_LIVRE = 27;

    // </editor-fold>

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome = "";

    @Column(name = "contexto", nullable = false, length = 999999)
    private String contexto;

    @Column(name = "visao", nullable = false, length = 100000)
    private String visao;

    public ModeloDeLaudo (int codigo)
    {
        this.codigo = codigo;
    }

    public ModeloDeLaudo ()
    {
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getContexto ()
    {
        return contexto;
    }

    public void setContexto (String contexto)
    {
        this.contexto = contexto;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getVisao ()
    {
        return visao;
    }

    public void setVisao (String visao)
    {
        this.visao = visao;
    }

    @Override
    public String toString ()
    {
        return nome;
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
        final ModeloDeLaudo other = (ModeloDeLaudo) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 5;
        hash = 73 * hash + this.codigo;
        return hash;
    }

}
