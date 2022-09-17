/*
 * GrupoCID10.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : Grupos do CID10
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "grupocid10")
public class GrupoCID10 implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo", length = 6)
    private String codigo = "";

    @Column(name = "nome", nullable = false)
    private String nome = "";

    @JoinColumn(name = "capitulocid10_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CapituloCID10 capituloCID10;

    public CapituloCID10 getCapituloCID10 ()
    {
        return capituloCID10;
    }

    public void setCapituloCID10 (CapituloCID10 capituloCID10)
    {
        this.capituloCID10 = capituloCID10;
    }

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
    public int hashCode ()
    {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
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
        final GrupoCID10 other = (GrupoCID10) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "model.GrupoCID10[id=" + codigo + "]";
    }

}
