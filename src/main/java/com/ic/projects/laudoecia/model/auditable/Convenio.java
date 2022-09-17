/*
 * Convenio.java
 *
 * Created on 19/01/2012, 09:32:24
 */
package com.ic.projects.laudoecia.model.auditable;

import com.ic.projects.laudoecia.model.cadastro.TabelaDeProcedimentos;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.java.utils.Comparador;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "convenio")
public class Convenio implements Serializable, Comparable<Convenio>
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome = "";

    @Column(name = "nomedocontato", nullable = true)
    private String nomeDoContato = "";

    @Column(name = "telefone", nullable = true)
    private String telefone = "";

    @Column(name = "fax", nullable = true)
    private String fax = "";

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    @Embedded
    private Endereco endereco = new Endereco();

    @Column(name = "email", nullable = true)
    private String email = "";

    @Column(name = "observacoes", length = 500, nullable = true)
    private String observacoes = "";

    @Column(name = "numcopiasdolaudo", nullable = false)
    private int numcopiasdolaudo = 1;

    @JoinColumn(name = "tabeladeprocedimentos_codigo", unique = true, nullable = true, referencedColumnName = "codigo")
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private TabelaDeProcedimentos tabelaDeProcedimentos = new TabelaDeProcedimentos();

    // <editor-fold defaultstate="collapsed" desc="Versioned">

    @Version
    private long version = 0;

    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    public Convenio (int codigo)
    {
        this.codigo = codigo;
    }

    public Convenio ()
    {
    }

    public boolean isAtivo ()
    {
        return ativo;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public String getEmail ()
    {
        return email;
    }

    public Endereco getEndereco ()
    {
        return endereco;
    }

    public String getFax ()
    {
        return fax;
    }

    public String getNome ()
    {
        return nome;
    }

    public String getNomeDoContato ()
    {
        return nomeDoContato;
    }

    public String getObservacoes ()
    {
        return observacoes;
    }

    public String getTelefone ()
    {
        return telefone;
    }

    public TabelaDeProcedimentos getTabelaDeProcedimentos ()
    {
        return tabelaDeProcedimentos;
    }

    public void setAtivo (boolean ativo)
    {
        this.ativo = ativo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public void setEndereco (Endereco endereco)
    {
        this.endereco = endereco;
    }

    public void setFax (String fax)
    {
        this.fax = fax;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public void setNomeDoContato (String nomeDoContato)
    {
        this.nomeDoContato = nomeDoContato;
    }

    public void setObservacoes (String observacoes)
    {
        this.observacoes = observacoes;
    }

    public void setTabelaDeProcedimentos (TabelaDeProcedimentos tabelaDeProcedimentos)
    {
        this.tabelaDeProcedimentos = tabelaDeProcedimentos;
        if (tabelaDeProcedimentos != null)
        {
            tabelaDeProcedimentos.setConvenio(this);
        }
    }

    public void setTelefone (String telefone)
    {
        this.telefone = telefone;
    }

    public int getNumcopiasdolaudo ()
    {
        return numcopiasdolaudo;
    }

    public void setNumcopiasdolaudo (int numcopiasdolaudo)
    {
        this.numcopiasdolaudo = numcopiasdolaudo;
    }

    @Override
    public String toString ()
    {
        return nome;
    }

    @Override
    public int compareTo (Convenio other)
    {
        if (other == null)
        {
            return +1;
        }
        else if (this.nome == null)
        {
            return other.getNome() == null ? 0 : -1;
        }
        else
        {
            return Comparador.compararRemovendoAcentos(this.nome, other.getNome());
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
        final Convenio other = (Convenio) obj;
        if (this.codigo != other.getCodigo())
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 13 * hash + this.codigo;
        return hash;
    }

}
