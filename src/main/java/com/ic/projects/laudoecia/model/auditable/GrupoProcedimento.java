/*
 * GrupoProcedimento.java
 *
 * Created on 18/01/2012, 16:56:57
 */
package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : GrupoProcedimento
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "grupoprocedimento")
public class GrupoProcedimento implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome = "";
    
    // <editor-fold defaultstate="collapsed" desc="Versioned">
    
    @Version
    private long version = 0;
    
    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    public GrupoProcedimento ()
    {
    }

    public GrupoProcedimento (int codigo)
    {
        this.codigo = codigo;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
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
        final GrupoProcedimento other = (GrupoProcedimento) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        return hash;
    }

}
