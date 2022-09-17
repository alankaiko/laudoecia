/*
 * Endereco.java
 *
 * Created on 19/01/2012, 10:20:12
 */
package com.ic.projects.laudoecia.model.notentities;

import com.ic.projects.laudoecia.model.basededados.UF;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Embeddable
public class Endereco implements Serializable
{
    @Column(name = "cep", nullable = true, length = 8)
    private String cep = "";

    @JoinColumn(name = "uf", referencedColumnName = "sigla", nullable = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UF uf;

    @Column(name = "cidade", nullable = true)
    private String cidade = "";

    @Column(name = "bairro", nullable = true)
    private String bairro = "";

    @Column(name = "tipodelogradouro", nullable = true)
    private String tipoDeLogradouro = "";

    @Column(name = "logradouro", nullable = true)
    private String logradouro = "";

    @Column(name = "complemento", nullable = true)
    private String complemento = "";

    public String getBairro ()
    {
        return bairro;
    }

    public String getCep ()
    {
        return cep;
    }

    public String getCidade ()
    {
        return cidade;
    }

    public String getComplemento ()
    {
        return complemento;
    }

    public String getLogradouro ()
    {
        return logradouro;
    }

    public String getTipoDeLogradouro ()
    {
        return tipoDeLogradouro;
    }

    public UF getUf ()
    {
        return uf;
    }

    public void setBairro (String bairro)
    {
        this.bairro = bairro == null ? "" : bairro;
    }

    public void setCep (String cep)
    {
        this.cep = cep == null ? "" : cep;
    }

    public void setCidade (String cidade)
    {
        this.cidade = cidade == null ? "" : cidade;
    }

    public void setComplemento (String complemento)
    {
        this.complemento = complemento == null ? "" : complemento;
    }

    public void setLogradouro (String logradouro)
    {
        this.logradouro = logradouro == null ? "" : logradouro;
    }

    public void setUf (UF uf)
    {
        this.uf = uf;
    }

    public void setTipoDeLogradouro (String tipoDeLogradouro)
    {
        this.tipoDeLogradouro = tipoDeLogradouro == null ? "" : tipoDeLogradouro;
    }

    @Override
    public String toString ()
    {
        String endereco = "";
        if (tipoDeLogradouro != null && !tipoDeLogradouro.isEmpty())
        {
            endereco += tipoDeLogradouro;
        }
        if (logradouro != null && !logradouro.isEmpty())
        {
            endereco += " " + logradouro + ", ";
        }
        if (complemento != null && !complemento.isEmpty())
        {
            endereco += complemento + ", ";
        }
        if (bairro != null && !bairro.isEmpty())
        {
            endereco += bairro + ", ";
        }
        if (cidade != null && !cidade.isEmpty())
        {
            endereco += cidade + "-";
        }
        if (uf != null)
        {
            endereco += uf.getSigla() == null ? "" : uf.getSigla();
        }
        if (cep != null && !cep.isEmpty())
        {
            endereco += ", CEP: " + new StringBuilder(cep).insert(2, ".").insert(6, "-").toString();
        }
        return endereco;
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.cep, other.cep))
        {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf))
        {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade))
        {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro))
        {
            return false;
        }
        if (!Objects.equals(this.tipoDeLogradouro, other.tipoDeLogradouro))
        {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro))
        {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.cep);
        hash = 71 * hash + Objects.hashCode(this.uf);
        hash = 71 * hash + Objects.hashCode(this.cidade);
        hash = 71 * hash + Objects.hashCode(this.bairro);
        hash = 71 * hash + Objects.hashCode(this.tipoDeLogradouro);
        hash = 71 * hash + Objects.hashCode(this.logradouro);
        hash = 71 * hash + Objects.hashCode(this.complemento);
        return hash;
    }
    
}
