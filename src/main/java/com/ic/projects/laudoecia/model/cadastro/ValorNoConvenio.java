/*
 *  ValorNoConvenio.java
 *
 *  Created on 21/06/2011, 14:19:59
 */
package com.ic.projects.laudoecia.model.cadastro;

import com.lib.java.utils.Money;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author SimonidesZacarias
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_valor", discriminatorType = DiscriminatorType.STRING)
@Table(name = "valornoconvenio")
public abstract class ValorNoConvenio implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public abstract Money getValorNoConvenio ();

    @Override
    public String toString ()
    {
        return getValorNoConvenio().toString();
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
        final ValorNoConvenio other = (ValorNoConvenio) obj;
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
        hash = 79 * hash + this.codigo;
        return hash;
    }

}
