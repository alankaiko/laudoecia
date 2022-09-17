/*
 * ParametrosDaCaptura.java
 *
 * Created on 20/06/2012, 09:30:07
 */

package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "parametrosdacaptura")
public class ParametrosDaCaptura implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @JoinColumn(name = "estacao_codigo", referencedColumnName = "codigo", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private EstacaoDeTrabalho estacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parametrosDaCaptura", orphanRemoval = true)
    private List<PropriedadeDaCaptura> propriedades = new ArrayList<>();

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public EstacaoDeTrabalho getEstacao ()
    {
        return estacao;
    }

    public void setEstacao (EstacaoDeTrabalho estacao)
    {
        this.estacao = estacao;
    }

    public List<PropriedadeDaCaptura> getPropriedades ()
    {
        return Collections.unmodifiableList(propriedades);
    }

    public void setPropriedades (List<PropriedadeDaCaptura> propriedades)
    {
        this.propriedades.clear();
        if (propriedades == null)
        {
        }
        else
        {
            this.propriedades.addAll(propriedades);
        }
    }

    public void addPropriedade (PropriedadeDaCaptura prop)
    {
        propriedades.add(prop);
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
        final ParametrosDaCaptura other = (ParametrosDaCaptura) obj;
        if (this.codigo != other.getCodigo())
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 13 * hash + this.codigo;
        return hash;
    }

}
