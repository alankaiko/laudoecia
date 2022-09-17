/*
 * UF.java
 *
 * Created on 20/01/2012, 15:29:16
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "uf")
public class UF implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sigla", length = 2)
    private String sigla;

    public UF (String sigla)
    {
        this.sigla = sigla;
    }

    public UF ()
    {
    }
    
    public String getSigla ()
    {
        return sigla;
    }

    public void setSigla (String sigla)
    {
        this.sigla = sigla;
    }
   
    @Override
    public String toString ()
    {
        return sigla;
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
        final UF other = (UF) obj;
        if (!Objects.equals(this.sigla, other.sigla))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.sigla);
        return hash;
    }

}
