/*
 * Atendimento.java
 *
 * Created on 19/01/2012, 12:06:43
 */
package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @JoinColumn(name = "paciente_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente paciente;

    @JoinColumn(name = "convenio_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Convenio convenio;

    @JoinColumn(name = "profsolicitante_codigo", referencedColumnName = "codigo", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private ProfSolicitante solicitante;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "atendimento", orphanRemoval = true)
    private List<ProcDoAtd> procedimentos = new ArrayList<>();

    @Column(name = "dataatendimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAtendimento;

    @Column(name = "observacoes", nullable = true, length = 500)
    private String observacoes = "";

    @Column(name = "gravarexame", nullable = false)
    private boolean gravarExame = false;

    // <editor-fold defaultstate="collapsed" desc="Versioned">

    @Version
    private long version = 0;

    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    public Date getDataAtendimento ()
    {
        return dataAtendimento;
    }

    public void setDataAtendimento (Date dataAtendimento)
    {
        this.dataAtendimento = dataAtendimento;
    }

    public boolean isGravarExame ()
    {
        return gravarExame;
    }

    public void setGravarExame (boolean gravarExame)
    {
        this.gravarExame = gravarExame;
    }

    public List<ProcDoAtd> getProcedimentos ()
    {
        Collections.sort(procedimentos);
        return Collections.unmodifiableList(procedimentos);
    }

    public void setProcedimentos (List<ProcDoAtd> procedimentos)
    {
        this.procedimentos.clear();
        if (procedimentos == null)
        {
        }
        else
        {
            this.procedimentos.addAll(procedimentos);
        }
    }

    public void addProcDoAtd (ProcDoAtd p)
    {
        procedimentos.add(p);
    }

    public void removeProcDoAtd (ProcDoAtd p)
    {
        procedimentos.remove(p);
    }

    public String getObservacoes ()
    {
        return observacoes;
    }

    public void setObservacoes (String observacoes)
    {
        this.observacoes = observacoes;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public Convenio getConvenio ()
    {
        return convenio;
    }

    public Paciente getPaciente ()
    {
        return paciente;
    }

    public ProfSolicitante getSolicitante ()
    {
        return solicitante;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setConvenio (Convenio convenio)
    {
        this.convenio = convenio;
    }

    public void setPaciente (Paciente paciente)
    {
        this.paciente = paciente;
    }

    public void setSolicitante (ProfSolicitante solicitante)
    {
        this.solicitante = solicitante;
    }

    @Override
    public String toString ()
    {
        if (paciente == null)
        {
            return "";
        }
        return paciente.toString();
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
        final Atendimento other = (Atendimento) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 31 * hash + this.codigo;
        return hash;
    }

}
