/*
 * SubcategoriaCID10.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import com.ic.projects.laudoecia.model.enums.CID_CAUSA_OBITO;
import com.ic.projects.laudoecia.model.enums.CID_CLASSIFICACAO;
import com.lib.model.abstracao.RESTRICAO_SEXO;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : Subcategorias do CID10
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "subcategoriacid10")
public class SubcategoriaCID10 implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo", length = 6)
    private String codigo = "";

    @JoinColumn(name = "categoriacid10_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CategoriaCID10 categoriaCID10;

    @Column(name = "nome", nullable = false, length = 500)
    private String nome = "";

    @Column(name = "nome50", length = 50)
    private String nome50 = "";

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", nullable = false)
    private CID_CLASSIFICACAO classificacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "restrsexo", nullable = false)
    private RESTRICAO_SEXO restrSexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "causaobito", nullable = false)
    private CID_CAUSA_OBITO causaObito;

    @Column(name = "referencia", nullable = true)
    private String referencia = "";

    @Column(name = "excluidos", nullable = true)
    private String excluidos = "";

    public CategoriaCID10 getCategoriaCID10 ()
    {
        return categoriaCID10;
    }

    public void setCategoriaCID10 (CategoriaCID10 categoriaCID10)
    {
        this.categoriaCID10 = categoriaCID10;
    }

    public CID_CAUSA_OBITO getCausaObito ()
    {
        return causaObito;
    }

    public void setCausaObito (CID_CAUSA_OBITO causaObito)
    {
        this.causaObito = causaObito;
    }

    public CID_CLASSIFICACAO getClassificacao ()
    {
        return classificacao;
    }

    public void setClassificacao (CID_CLASSIFICACAO classificacao)
    {
        this.classificacao = classificacao;
    }

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public String getExcluidos ()
    {
        return excluidos;
    }

    public void setExcluidos (String excluidos)
    {
        this.excluidos = excluidos;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getNome50 ()
    {
        return nome50;
    }

    public void setNome50 (String nome50)
    {
        this.nome50 = nome50;
    }

    public String getReferencia ()
    {
        return referencia;
    }

    public void setReferencia (String referencia)
    {
        this.referencia = referencia;
    }

    public RESTRICAO_SEXO getRestrSexo ()
    {
        return restrSexo;
    }

    public void setRestrSexo (RESTRICAO_SEXO restrSexo)
    {
        this.restrSexo = restrSexo;
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
        final SubcategoriaCID10 other = (SubcategoriaCID10) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 97 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString ()
    {
        return "model.SubcategoriaCID10[id=" + codigo + "]";
    }

}
