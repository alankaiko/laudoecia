/*
 * PropriedadeDaCaptura.java
 *
 * Created on 02/08/2012, 17:07:48
 */

package com.ic.projects.laudoecia.model.cadastro;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "propriedadedacaptura")
public class PropriedadeDaCaptura implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Column(name = "valor", nullable = false)
    private String valor;
    
    @JoinColumn(name = "parametrosdacaptura_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ParametrosDaCaptura parametrosDaCaptura;

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getDescricao ()
    {
        return descricao;
    }

    public void setDescricao (String descricao)
    {
        this.descricao = descricao;
    }

    public ParametrosDaCaptura getParametrosDaCaptura ()
    {
        return parametrosDaCaptura;
    }

    public void setParametrosDaCaptura (ParametrosDaCaptura parametrosDaCaptura)
    {
        this.parametrosDaCaptura = parametrosDaCaptura;
    }

    public String getValor ()
    {
        return valor;
    }

    public void setValor (String valor)
    {
        this.valor = valor;
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
        final PropriedadeDaCaptura other = (PropriedadeDaCaptura) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 5;
        hash = 89 * hash + this.codigo;
        return hash;
    }
    
}
