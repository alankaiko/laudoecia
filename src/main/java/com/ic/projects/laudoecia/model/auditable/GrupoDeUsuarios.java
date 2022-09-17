/**
 * GrupoDeUsuarios.java
 *
 * Created on 19/01/2011, 11:07:05
 */
package com.ic.projects.laudoecia.model.auditable;

import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
public class GrupoDeUsuarios implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public final static int CODIGO_SUPORTE = 100;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome = "";

    @Embedded
    private PerfilDeAcesso perfilDeAcesso = new PerfilDeAcesso();
    
    // <editor-fold defaultstate="collapsed" desc="Versioned">
    
    @Version
    private long version = 0;
    
    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    public GrupoDeUsuarios ()
    {
    }

    public GrupoDeUsuarios (int codigo)
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

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public PerfilDeAcesso getPerfilDeAcesso ()
    {
        return perfilDeAcesso;
    }

    public void setPerfilDeAcesso (PerfilDeAcesso perfilDeAcesso)
    {
        this.perfilDeAcesso = perfilDeAcesso;
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
        final GrupoDeUsuarios other = (GrupoDeUsuarios) obj;
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
        hash = 29 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return nome;
    }
    
}
