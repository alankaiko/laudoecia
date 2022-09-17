/**
 * Usuario.java
 *
 * Created on 12/12/2011, 07:18:08
 */
package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
@Entity
public class Usuario implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    public final static int CODIGO_SUPORTE = 100;
    public final static int CODIGO_NULL = 99;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", nullable = false)
    private String nome = "";

    @Column(name = "login", nullable = false, unique = true)
    private String login = "";

    @Column(name = "senha", nullable = true)
    private String senha = "";

    @Column(name = "datadecadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDeCadastro;

    @JoinColumn(name = "grupodeusuarios_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GrupoDeUsuarios grupo;
    
    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;
    
    // <editor-fold defaultstate="collapsed" desc="Versioned">
    
    @Version
    private long version = 0;
    
    public long getVersion()
    {
        return version;
    }

    // </editor-fold>
    
    public Usuario (int codigo)
    {
        this.codigo = codigo;
    }

    public Usuario ()
    {
    }

    public Date getDataDeCadastro ()
    {
        return dataDeCadastro;
    }

    public void setDataDeCadastro (Date dataDeCadastro)
    {
        this.dataDeCadastro = dataDeCadastro;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getLogin ()
    {
        return login;
    }

    public void setLogin (String login)
    {
        this.login = login;
    }

    public boolean isAtivo ()
    {
        return ativo;
    }

    public void setAtivo (boolean ativo)
    {
        this.ativo = ativo;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getSenha ()
    {
        return senha == null ? "" : senha;
    }

    public void setSenha (String senha)
    {
        this.senha = senha;
    }

    public GrupoDeUsuarios getGrupo ()
    {
        return grupo;
    }

    public void setGrupo (GrupoDeUsuarios grupo)
    {
        this.grupo = grupo;
    }

    @Override
    public int hashCode ()
    {
        int hash = 0;
        hash += codigo;
        return hash;
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
        final Usuario other = (Usuario) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return nome;
    }

}
