/*
 * CBHPM.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import com.lib.java.utils.Comparador;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : CBHPM
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "cbhpm")
public class CBHPM implements Serializable, Comparable<CBHPM>
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo", nullable = false)
    private String codigo;

    @JoinColumn(name = "subgrupo_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SubgrupoCBHPM subgrupo;

    @Column(name = "procedimento", nullable = false, length = 400)
    private String procedimento;

    @Column(name = "porte", nullable = false, length = 10)
    private String porte;

    @Column(name = "valorporte", nullable = false)
    private double valorPorte;

    @Column(name = "custoop", nullable = true)
    private double custoOp;

    @Column(name = "valorcustoop", nullable = true)
    private double valorCustoOp;

    @Column(name = "nauxiliares", nullable = false)
    private int nauxiliares;

    @Column(name = "porteanest", nullable = true)
    private String porteAnest;

    @Column(name = "valortotal", nullable = false)
    private double valorTotal;

    @Column(name = "filmes", nullable = false)
    private double filmes;

    @Column(name = "incidencia", nullable = false)
    private int incidencia;

    @Column(name = "unidrdfarmaco", nullable = true)
    private String unidRdFarmaco;

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public double getCustoOp ()
    {
        return custoOp;
    }

    public void setCustoOp (double custoOp)
    {
        this.custoOp = custoOp;
    }

    public double getFilmes ()
    {
        return filmes;
    }

    public void setFilmes (double filmes)
    {
        this.filmes = filmes;
    }

    public int getIncidencia ()
    {
        return incidencia;
    }

    public void setIncidencia (int incidencia)
    {
        this.incidencia = incidencia;
    }

    public int getNauxiliares ()
    {
        return nauxiliares;
    }

    public void setNauxiliares (int nauxiliares)
    {
        this.nauxiliares = nauxiliares;
    }

    public String getPorte ()
    {
        return porte;
    }

    public void setPorte (String porte)
    {
        this.porte = porte;
    }

    public String getPorteAnest ()
    {
        return porteAnest;
    }

    public void setPorteAnest (String porteAnest)
    {
        this.porteAnest = porteAnest;
    }

    public String getProcedimento ()
    {
        return procedimento;
    }

    public void setProcedimento (String procedimento)
    {
        this.procedimento = procedimento;
    }

    public SubgrupoCBHPM getSubgrupo ()
    {
        return subgrupo;
    }

    public void setSubgrupo (SubgrupoCBHPM subgrupo)
    {
        this.subgrupo = subgrupo;
    }

    public String getUnidRdFarmaco ()
    {
        return unidRdFarmaco;
    }

    public void setUnidRdFarmaco (String unidRdFarmaco)
    {
        this.unidRdFarmaco = unidRdFarmaco;
    }

    public double getValorCustoOp ()
    {
        return valorCustoOp;
    }

    public void setValorCustoOp (double valorCustoOp)
    {
        this.valorCustoOp = valorCustoOp;
    }

    public double getValorPorte ()
    {
        return valorPorte;
    }

    public void setValorPorte (double valorPorte)
    {
        this.valorPorte = valorPorte;
    }

    public double getValorTotal ()
    {
        return valorTotal;
    }

    public void setValorTotal (double valorTotal)
    {
        this.valorTotal = valorTotal;
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
        final CBHPM other = (CBHPM) obj;
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
        hash = 71 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString ()
    {
        return "ClassesDeEntidade.CBHPM[codigo=" + codigo + "]";
    }

    @Override
    public int compareTo (CBHPM other)
    {
        if (other == null)
        {
            return +1;
        }
        else if (this.procedimento == null)
        {
            return other.procedimento == null ? 0 : -1;
        }
        else
        {
            return Comparador.compararRemovendoAcentos(this.procedimento, other.procedimento);
        }
    }

}
