/*
 * GrupoCBHPM.java
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
 * Classe da entidade : Grupos CBHPM
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "grupoCBHPM")
public class GrupoCBHPM implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "grupo", nullable = false, length = 70)
    private String grupo;

    public GrupoCBHPM ()
    {
    }

    public GrupoCBHPM (String codigo)
    {
        this.codigo = codigo;
    }

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public String getGrupo ()
    {
        return grupo;
    }

    public void setGrupo (String grupo)
    {
        this.grupo = grupo;
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
        final GrupoCBHPM other = (GrupoCBHPM) obj;
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
        hash = 37 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString ()
    {
        return "ClassesDeEntidade.GrupoCBHPM[id=" + codigo + "]";
    }

}
