/*
 * TextoPadrao.java
 *
 * Created on 18/06/2012, 10:32:44
 */

package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "textopadrao")
public class TextoPadrao implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "abreviatura", nullable = false, unique = true)
    private String abreviatura = "";

    @Column(name = "texto", nullable = false, length = 100000)
    private String texto = "";

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "textopadrao_procmedico",
               joinColumns = @JoinColumn(name = "textopadrao_codigo"),
               inverseJoinColumns = @JoinColumn(name = "procmedico_codigo"))
    private List<ProcMedico> procedimentos = new ArrayList<>();

    public String getAbreviatura ()
    {
        return abreviatura;
    }

    public void setAbreviatura (String abreviatura)
    {
        this.abreviatura = abreviatura;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public List<ProcMedico> getProcedimentos ()
    {
        return Collections.unmodifiableList(procedimentos);
    }

    public void setProcedimentos (List<ProcMedico> procedimentos)
    {
        this.procedimentos.clear();
        if (procedimentos == null)
        {
        }
        else
        {
            this.procedimentos.addAll(procedimentos);
        }
    }

    public String getTexto ()
    {
        return texto;
    }

    public void setTexto (String texto)
    {
        this.texto = texto;
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
        final TextoPadrao other = (TextoPadrao) obj;
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
        hash = 73 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return abreviatura;
    }

}
