/*
 * ProfSolicitante.java
 *
 * Created on 24/02/2011, 14:25:00
 */
package com.ic.projects.laudoecia.model.auditable;

import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "profsolicitante")
public class ProfSolicitante implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", nullable = false)
    private String nome = "";

    @JoinColumn(name = "ufconselho", referencedColumnName = "sigla", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UF ufConselho;

    @Column(name = "numnoconselho", nullable = false)
    private String numNoConselho = "";

    @JoinColumn(name = "conselho_codigo", referencedColumnName = "sigla",nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TISS_Conselho conselho;

    public ProfSolicitante ()
    {
    }

    public ProfSolicitante (int codigo)
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

    public TISS_Conselho getConselho ()
    {
        return conselho;
    }

    public void setConselho (TISS_Conselho conselho)
    {
        this.conselho = conselho;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getNumNoConselho ()
    {
        return numNoConselho;
    }

    public void setNumNoConselho (String numNoConselho)
    {
        this.numNoConselho = numNoConselho;
    }

    public UF getUfConselho ()
    {
        return ufConselho;
    }

    public void setUfConselho (UF ufConselho)
    {
        this.ufConselho = ufConselho;
    }

    @Override
    public String toString ()
    {
        if (ufConselho == null || conselho == null)
        {
            return "";
        }
        return conselho.toString() + "-" + ufConselho.getSigla() + ":" +
               numNoConselho + ", " + nome;
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
        final ProfSolicitante other = (ProfSolicitante) obj;
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
        hash = 79 * hash + this.codigo;
        return hash;
    }

}
