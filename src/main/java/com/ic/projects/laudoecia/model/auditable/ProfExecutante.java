/*
 * ProfExecutante.java
 *
 * Created on 19/01/2012, 10:21:21
 */
package com.ic.projects.laudoecia.model.auditable;

import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "profexecutante")
public class ProfExecutante implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", nullable = false)
    private String nome = "";

    @JoinColumn(name = "ufconselho", referencedColumnName = "sigla", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UF ufConselho;

    @JoinColumn(name = "conselho_codigo", referencedColumnName = "sigla", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TISS_Conselho conselho;

    @Column(name = "numnoconselho", nullable = false)
    private String numNoConselho = "";

    @Column(name = "telefone1", nullable = true)
    private String telefone1 = "";

    @Column(name = "telefone2", nullable = true)
    private String telefone2 = "";

    @Column(name = "frasepessoal", nullable = true)
    private String frasePessoal = "";

    @Column(name = "email", nullable = true)
    private String email = "";

    @Embedded
    private Endereco endereco = new Endereco();

    @Column(name="assinatura", nullable = true)
    private byte[] assinatura;

    @Column(name = "asswidth", nullable = false)
    private double assWidth = 0;

    @Column(name = "assheight", nullable = false)
    private double assHeight = 0;

    @Column(name = "espacoass", nullable = false)
    private int espacoAss = 10;

    // <editor-fold defaultstate="collapsed" desc="Versioned">

    @Version
    private long version = 0;

    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    public int getEspacoAss ()
    {
        return espacoAss;
    }

    public void setEspacoAss (int espacoAss)
    {
        this.espacoAss = espacoAss;
    }

    public ProfExecutante ()
    {
    }

    public ProfExecutante (int codigo)
    {
        this.codigo = codigo;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public Endereco getEndereco ()
    {
        return endereco;
    }

    public void setEndereco (Endereco endereco)
    {
        this.endereco = endereco;
    }

    public String getFrasePessoal ()
    {
        return frasePessoal == null ? "" : frasePessoal;
    }

    public void setFrasePessoal (String frasePessoal)
    {
        this.frasePessoal = frasePessoal;
    }

    public String getTelefone1 ()
    {
        return telefone1;
    }

    public void setTelefone1 (String telefone1)
    {
        this.telefone1 = telefone1;
    }

    public String getTelefone2 ()
    {
        return telefone2;
    }

    public void setTelefone2 (String telefone2)
    {
        this.telefone2 = telefone2;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public TISS_Conselho getConselho ()
    {
        return conselho;
    }

    public void setConselho (TISS_Conselho conselho)
    {
        this.conselho = conselho;
    }

    public String getNome ()
    {
        return nome;
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

    public byte[] getAssinatura ()
    {
        return assinatura;
    }

    public void setAssinatura (byte[] assinatura)
    {
        this.assinatura = assinatura;
    }

    public double getAssWidth ()
    {
        return assWidth;
    }

    public void setAssWidth (double assWidth)
    {
        this.assWidth = assWidth;
    }

    public double getAssHeight ()
    {
        return assHeight;
    }

    public void setAssHeight (double assHeight)
    {
        this.assHeight = assHeight;
    }

    @Override
    public String toString ()
    {
        return  nome;
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
        final ProfExecutante other = (ProfExecutante) obj;
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
        hash = 97 * hash + this.codigo;
        return hash;
    }

}
