/*
 * AcaoDoUsuario.java
 *
 * Created on 01/03/2012, 10:01:01
 */

package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name="acaodousuario")
public class AcaoDoUsuario implements Serializable
{
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @JoinColumn(name = "usuario_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    
    @JoinColumn(name = "estacao_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstacaoDeTrabalho estacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TIPO_ACAO_DO_USUARIO tipo;
    
    @Column(name = "tabela", nullable = false)
    private String tabela = "";
    
    @Column(name = "registro", nullable = false)
    private String registro = "";
    
    @Column(name = "codigodoregistro", nullable = false)
    private String codigoDoRegistro = "";
    
    @Column(name = "dataDaAcao", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDaAcao;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "acaoDoUsuario", orphanRemoval = true)
    private List<AltDeRegistro> alteracoes = new ArrayList<>();

    public EstacaoDeTrabalho getEstacao ()
    {
        return estacao;
    }

    public void setEstacao (EstacaoDeTrabalho estacao)
    {
        this.estacao = estacao;
    }
    
    public List<AltDeRegistro> getAlteracoes ()
    {
        return Collections.unmodifiableList(alteracoes);
    }

    public void setAlteracoes (List<AltDeRegistro> alteracoes)
    {
        this.alteracoes.clear();
        if (alteracoes == null)
        {
        }
        else
        {
            this.alteracoes.addAll(alteracoes);
        }
    }
    
    public void addAlteracao (AltDeRegistro alteracao)    
    {
        alteracoes.add(alteracao);
    }
    
    public void removeAlteracao (AltDeRegistro alteracao)    
    {
        alteracoes.remove(alteracao);
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getRegistro ()
    {
        return registro;
    }

    public void setRegistro (String registro)
    {
        this.registro = registro;
    }

    public String getTabela ()
    {
        return tabela;
    }

    public void setTabela (String tabela)
    {
        this.tabela = tabela;
    }

    public TIPO_ACAO_DO_USUARIO getTipo ()
    {
        return tipo;
    }

    public void setTipo (TIPO_ACAO_DO_USUARIO tipo)
    {
        this.tipo = tipo;
    }

    public Usuario getUsuario ()
    {
        return usuario;
    }

    public void setUsuario (Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Date getDataDaAcao ()
    {
        return dataDaAcao;
    }

    public void setDataDaAcao (Date dataDaAcao)
    {
        this.dataDaAcao = dataDaAcao;
    }

    public String getCodigoDoRegistro ()
    {
        return codigoDoRegistro;
    }

    public void setCodigoDoRegistro (String codigoDoRegistro)
    {
        this.codigoDoRegistro = codigoDoRegistro;
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
        final AcaoDoUsuario other = (AcaoDoUsuario) obj;
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
        hash = 19 * hash + this.codigo;
        return hash;
    }
    
}
