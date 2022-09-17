/*
 * ProcMedico.java
 *
 * Created on 18/10/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.auditable;

import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.lib.model.abstracao.RESTRICAO_SEXO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Classe da entidade : ProcMedico
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "procmedico")
public class ProcMedico implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProcedimento grupo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "procMedico", orphanRemoval = true)
    private List<ProcDaTabela> procDaTabela = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "procMedico", orphanRemoval = true)
    private List<ModeloDeLaudoDoProc> modelos = new ArrayList<>();

    @Column(name = "nome", nullable = false, unique = true)
    private String nome = "";

    @Column(name = "diasparaentregadolaudo", nullable = false)
    private int diasParaEntregaDoLaudo;

    @Column(name = "margemtop", nullable = false)
    private int margemTop = 10;

    @Column(name = "margembottom", nullable = false)
    private int margemBottom = 10;

    @Column(name = "restricaosexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private RESTRICAO_SEXO restricaoSexo = RESTRICAO_SEXO.NENHUMA_RESTRICAO;

    @Column(name = "imagem1", nullable = true)
    private byte[] imagem1;

    @JoinColumn(name = "imagem2", nullable = true)
    private byte[] imagem2;

    @Column(name = "laudo_modelo")
    private boolean laudoModelo;

    // <editor-fold defaultstate="collapsed" desc="Versioned">

    @Version
    private long version = 0;

    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    public int getMargemTop ()
    {
        return margemTop;
    }

    public void setMargemTop (int margemTop)
    {
        this.margemTop = margemTop;
    }

    public int getMargemBottom ()
    {
        return margemBottom;
    }

    public void setMargemBottom (int margemBottom)
    {
        this.margemBottom = margemBottom;
    }

    public ProcMedico ()
    {
    }

    public ProcMedico (int codigo)
    {
        this.codigo = codigo;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">

    public List<ProcDaTabela> getProcDaTabela ()
    {
        return Collections.unmodifiableList(procDaTabela);
    }

    public void setProcDaTabela (List<ProcDaTabela> procDaTabela)
    {
        this.procDaTabela.clear();
        if (procDaTabela == null)
        {
        }
        else
        {
            this.procDaTabela.addAll(procDaTabela);
        }
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public GrupoProcedimento getGrupo ()
    {
        return grupo;
    }

    public String getNome ()
    {
        return nome;
    }

    public RESTRICAO_SEXO getRestricaoSexo ()
    {
        return restricaoSexo;
    }

    public List<ModeloDeLaudoDoProc> getModelos ()
    {
        return Collections.unmodifiableList(modelos);
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setGrupo (GrupoProcedimento grupo)
    {
        this.grupo = grupo;
    }

    public void setModelos (List<ModeloDeLaudoDoProc> modelos)
    {
        this.modelos.clear();
        if (modelos == null)
        {
        }
        else
        {
            for (int i = 0; i < modelos.size(); i++)
            {
                this.modelos.add(modelos.get(i));
            }
        }
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public void setRestricaoSexo (RESTRICAO_SEXO restricaoSexo)
    {
        this.restricaoSexo = restricaoSexo;
    }

    public int getDiasParaEntregaDoLaudo ()
    {
        return diasParaEntregaDoLaudo;
    }

    public void setDiasParaEntregaDoLaudo (int diasParaEntregaDoLaudo)
    {
        this.diasParaEntregaDoLaudo = diasParaEntregaDoLaudo;
    }

    public void addModelo (ModeloDeLaudoDoProc modelo)
    {
        if (modelo == null)
        {
            throw new IllegalArgumentException("Modelo não pode ser null!");
        }
        this.modelos.add(modelo);
        modelo.setProcMedico(this);
    }

    // </editor-fold>

    public void addProcDaTabela (ProcDaTabela p)
    {
        procDaTabela.add(p);
    }

    public ProcDaTabela getProcDaTabela (Convenio convenio)
    {
        if (convenio == null)
        {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < procDaTabela.size(); i++)
        {
            ProcDaTabela pdt = procDaTabela.get(i);
            if (Objects.equals(
                    pdt.getTabelaDeProcedimentos(), convenio.getTabelaDeProcedimentos()))
            {
                return pdt;
            }
        }
        return null;
    }

    public byte[] getImagem1 ()
    {
        return imagem1;
    }

    public void setImagem1 (byte[] imagem1)
    {
        this.imagem1 = imagem1;
    }

    public byte[] getImagem2 ()
    {
        return imagem2;
    }

    public void setImagem2 (byte[] imagem2)
    {
        this.imagem2 = imagem2;
    }

    public boolean getLaudoModelo ()
    {
        return laudoModelo;
    }

    public void setLaudoModelo (boolean laudoModelo)
    {
        this.laudoModelo = laudoModelo;
    }

    @Override
    public String toString ()
    {
        return nome;
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
        final ProcMedico other = (ProcMedico) obj;
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
        hash = 47 * hash + this.codigo;
        return hash;
    }

}
