/*
 * ParametroDoLaudo.java
 *
 * Created on 18/01/2012, 14:16:08
 */
package com.ic.projects.laudoecia.model.laudo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumentalcientifico.net.br>
 */
@Entity
@Table(name = "parametrodolaudo")
public class ParametroDoLaudo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "index", nullable = false)
    private int index;

    @Column(name = "valor", nullable = false, length = 100000)
    private String valor;

    @JoinColumn(name = "laudo_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Laudo laudo;

    public Laudo getLaudo ()
    {
        return laudo;
    }

    public void setLaudo (Laudo laudo)
    {
        this.laudo = laudo;
    }

    public int getIndex ()
    {
        return index;
    }
    
    public String getValor ()
    {
        return valor;
    }

    public void setValor (String valor)
    {
        this.valor = valor;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setIndex (int index)
    {
        this.index = index;
    }
    
    @Override
    public String toString ()
    {
        return "ParametroDoLaudo{" + "codigo=" + codigo + '}';
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
        final ParametroDoLaudo other = (ParametroDoLaudo) obj;
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
        hash = 61 * hash + this.codigo;
        return hash;
    }

}
