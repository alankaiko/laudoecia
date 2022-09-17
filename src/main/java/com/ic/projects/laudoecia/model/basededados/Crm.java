/*
 * Crm.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

/**
 * Classe da entidade : Base de dados de medicos
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "crm")
public class Crm implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "crm", nullable = false, length = 10)
    private String crm = "";

    @Column(name = "nome", nullable = false, length = 70)
    private String nome = "";

    @JoinColumn(name = "uf", referencedColumnName = "sigla", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UF uf;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "crm_especialidade", joinColumns = @JoinColumn(name = "idcrm", referencedColumnName = "codigo"), inverseJoinColumns = @JoinColumn(name = "idesp", referencedColumnName = "codigo"))
    private List<EspecialidadeMedica> especialidades;

    public String getCrm ()
    {
        return crm;
    }

    public void setCrm (String crm)
    {
        this.crm = crm;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public List<EspecialidadeMedica> getEspecialidades ()
    {
        return Collections.unmodifiableList(especialidades);
    }

    public void setEspecialidades (List<EspecialidadeMedica> especialidades)
    {
        this.especialidades.clear();
        if (especialidades == null)
        {
        }
        else
        {
            this.especialidades.addAll(especialidades);
        }
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public UF getUf ()
    {
        return uf;
    }

    public void setUf (UF uf)
    {
        this.uf = uf;
    }

    @Override
    public int hashCode ()
    {
        int hash = 0;
        hash += codigo;
        return hash;
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
        final Crm other = (Crm) obj;
        if (this.codigo != other.getCodigo())
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "ClassesDeEntidade.Crm[id=" + codigo + "]";
    }

}
