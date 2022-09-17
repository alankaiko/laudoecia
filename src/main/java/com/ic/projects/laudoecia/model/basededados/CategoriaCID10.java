/*
 * CategoriaCID10.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : Categorias do CID10
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "categoriacid10")
public class CategoriaCID10 implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private String codigo = "";

    @JoinColumn(name = "grupocid10_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GrupoCID10 grupoCID10;

    @Column(name = "nome", nullable = false)
    private String nome = "";

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public GrupoCID10 getGrupoCID10 ()
    {
        return grupoCID10;
    }

    public void setGrupoCID10 (GrupoCID10 grupoCID10)
    {
        this.grupoCID10 = grupoCID10;
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
        final CategoriaCID10 other = (CategoriaCID10) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 97 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString ()
    {
        return "model.CategoriaCID10[codigo=" + codigo + "]";
    }

}
