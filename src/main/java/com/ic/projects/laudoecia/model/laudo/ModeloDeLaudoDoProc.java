/*
 * ModeloDeLaudoDoProc.java
 *
 * Created on 18/06/2012, 09:31:57
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "modelodelaudodoproc")
public class ModeloDeLaudoDoProc implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @JoinColumn(name = "procmedico_codigo", referencedColumnName = "codigo", nullable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcMedico procMedico;

    @JoinColumn(name = "modelolaudo_codigo", referencedColumnName = "codigo", nullable = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModeloDeLaudo modeloDeLaudo;

    @Column(name = "descricao", nullable = false)
    private String descricao = "";

    @Column(name = "customstring", nullable = false, length=100000)
    private String customString = "";

    @Column(name = "prioridade", nullable = false)
    private int prioridade = 0;

    public ModeloDeLaudoDoProc ()
    {
    }

    public ModeloDeLaudoDoProc (ModeloDeLaudo modeloDeLaudo)
    {
        this.modeloDeLaudo = modeloDeLaudo;
    }

    public int getPrioridade ()
    {
        return prioridade;
    }

    public void setPrioridade (int prioridade)
    {
        this.prioridade = prioridade;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getCustomString ()
    {
        return customString == null ? "" : customString;
    }

    public void setCustomString (String customString)
    {
        this.customString = customString == null ? "" : customString;
    }

    public String getDescricao ()
    {
        return descricao;
    }

    public void setDescricao (String descricao)
    {
        this.descricao = descricao;
    }

    public ModeloDeLaudo getModeloDeLaudo ()
    {
        return modeloDeLaudo;
    }

    public void setModeloDeLaudo (ModeloDeLaudo modeloDeLaudo)
    {
        this.modeloDeLaudo = modeloDeLaudo;
    }

    public ProcMedico getProcMedico ()
    {
        return procMedico;
    }

    public void setProcMedico (ProcMedico procMedico)
    {
        this.procMedico = procMedico;
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
        final ModeloDeLaudoDoProc other = (ModeloDeLaudoDoProc) obj;
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
        hash = 83 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return descricao;
    }

}
