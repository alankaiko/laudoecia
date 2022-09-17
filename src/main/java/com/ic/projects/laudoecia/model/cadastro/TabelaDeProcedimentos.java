/*
 * TabelaProcedimento.java
 *
 * Created on 09/11/2010, 09:18:12
 */
package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.auditable.Convenio;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "tabeladeprocedimentos")
public class TabelaDeProcedimentos implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @JoinColumn(name = "convenio_codigo", unique = true, nullable = true, referencedColumnName = "codigo")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Convenio convenio;

    public TabelaDeProcedimentos ()
    {
    }

    public TabelaDeProcedimentos (int codigo)
    {
        this.codigo = codigo;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public Convenio getConvenio ()
    {
        return convenio;
    }

    public void setConvenio (Convenio convenio)
    {
        this.convenio = convenio;
    }

    @Override
    public String toString ()
    {
        return convenio == null ? "" : convenio.toString();
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
        final TabelaDeProcedimentos other = (TabelaDeProcedimentos) obj;
        if (this.codigo != other.getCodigo())
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 5;
        hash = 37 * hash + this.codigo;
        return hash;
    }

}
