/*
 * CapituloCID10.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe da entidade : Capitulos do CID10
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "capitulocid10")
public class CapituloCID10 implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo", length = 6)
    private String codigo = "";

    @Column(name = "nome", nullable = false, length = 150)
    private String nome = "";

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
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
        final CapituloCID10 other = (CapituloCID10) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 53 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString ()
    {
        return "model.CapituloCID10[codigo=" + codigo + "]";
    }

}
