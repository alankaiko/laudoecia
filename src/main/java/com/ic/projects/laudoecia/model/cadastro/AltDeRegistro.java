/*
 * AltDeRegistro.java
 *
 * Created on 01/03/2012, 10:08:34
 */

package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name="altderegistro")
public class AltDeRegistro implements Serializable
{
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @JoinColumn(name = "acaodousuario_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AcaoDoUsuario acaoDoUsuario;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TIPO_ACAO_DO_USUARIO tipo;
    
    @Column(name = "campo", nullable = false)
    private String campo = "";
    
    @Column(name = "valorOriginal", nullable = true, length = 100000)
    private String valorOriginal = "";
    
    @Column(name = "valoraposalteracao", nullable = true, length = 100000)
    private String valorAposAlteracao = "";

    public AcaoDoUsuario getAcaoDoUsuario ()
    {
        return acaoDoUsuario;
    }

    public void setAcaoDoUsuario (AcaoDoUsuario acaoDoUsuario)
    {
        this.acaoDoUsuario = acaoDoUsuario;
    }

    public String getCampo ()
    {
        return campo;
    }

    public void setCampo (String campo)
    {
        this.campo = campo;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getValorAposAlteracao ()
    {
        return valorAposAlteracao;
    }

    public void setValorAposAlteracao (String valorAposAlteracao)
    {
        this.valorAposAlteracao = valorAposAlteracao;
    }

    public String getValorOriginal ()
    {
        return valorOriginal;
    }

    public void setValorOriginal (String valorOriginal)
    {
        this.valorOriginal = valorOriginal;
    }

    public TIPO_ACAO_DO_USUARIO getTipo ()
    {
        return tipo;
    }

    public void setTipo (TIPO_ACAO_DO_USUARIO tipo)
    {
        this.tipo = tipo;
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
        final AltDeRegistro other = (AltDeRegistro) obj;
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
