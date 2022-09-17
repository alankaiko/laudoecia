/*
 * Abreviatura.java
 *
 * Created on 18/06/2012, 10:32:44
 */

package com.ic.projects.laudoecia.model.cadastro;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "abreviatura")
public class Abreviatura implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "abreviatura", nullable = false, unique = true)
    private String abreviatura = "";

    @Column(name = "texto", nullable = false, length = 100000)
    private String texto = "";

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
        final Abreviatura other = (Abreviatura) obj;
        return this.codigo == other.getCodigo();
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
