/*
 * EnderecoPorCep.java
 *
 * Created on 19/01/2012, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.java.utils.Comparador;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : Base de dados de CEP
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "enderecoporcep")
public class EnderecoPorCep implements Serializable, Comparable<EnderecoPorCep>
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = true, length = 2)
    private int codigo;

    @Embedded
    private Endereco endereco = new Endereco();

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public Endereco getEndereco ()
    {
        return endereco;
    }

    public void setEndereco (Endereco endereco)
    {
        this.endereco = endereco;
    }

    @Override
    public int compareTo (EnderecoPorCep other)
    {
        if (other == null)
        {
            return +1;
        }
        else if (this.endereco.getCidade() == null)
        {
            return other.endereco.getCidade() == null ? 0 : -1;
        }
        else
        {
            return Comparador.compararRemovendoAcentos(this.endereco.getCidade(), other.endereco.getCidade());
        }
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
        final EnderecoPorCep other = (EnderecoPorCep) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 67 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return endereco.toString();
    }
    
}
