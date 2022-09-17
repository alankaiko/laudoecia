/*
 * SubgrupoCBHPM.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : Subgrupos da base CBHPM
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "subgrupocbhpm")
public class SubgrupoCBHPM implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private String codigo;

    @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GrupoCBHPM grupo;

    @Column(name = "subgrupo", nullable = false, length = 200)
    private String subgrupo;

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public GrupoCBHPM getGrupo ()
    {
        return grupo;
    }

    public void setGrupo (GrupoCBHPM grupo)
    {
        this.grupo = grupo;
    }

    public String getSubgrupo ()
    {
        return subgrupo;
    }

    public void setSubgrupo (String subgrupo)
    {
        this.subgrupo = subgrupo;
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
        final SubgrupoCBHPM other = (SubgrupoCBHPM) obj;
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
        hash = 71 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString ()
    {
        return "ClassesDeEntidade.SubgrupoCBHPM[id=" + codigo + "]";
    }

}
