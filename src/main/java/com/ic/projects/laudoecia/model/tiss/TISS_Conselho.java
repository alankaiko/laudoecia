/*
 * TISS_Conselho.java
 *
 * Created on 19/01/2012, 12:06:43
 */
package com.ic.projects.laudoecia.model.tiss;

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
@Table(name = "tiss_conselho")
public class TISS_Conselho implements Serializable
{
    private static final long serialVersionUID = 1L;

    public TISS_Conselho ()
    {
    }

    public TISS_Conselho (String sigla)
    {
        this.sigla = sigla;
    }

    @Id
    @Column(name = "sigla")
    private String sigla;

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
        final TISS_Conselho other = (TISS_Conselho) obj;
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
        hash = 29 * hash + Objects.hashCode(this.sigla);
        return hash;
    }

}
