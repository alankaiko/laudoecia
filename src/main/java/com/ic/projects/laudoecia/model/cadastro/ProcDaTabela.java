/*
 * ProcDaTabela.java
 *
 * Created on 19/01/2012, 08:58:26
 */
package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.lib.java.utils.Money;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumentalcientifico.net.br>
 */
@Entity
@Table(name = "procdatabela")
public class ProcDaTabela implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "valorpaciente", nullable = false)
    private double valorPaciente = 0d;

    @JoinColumn(name = "tabeladeprocedimentos_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TabelaDeProcedimentos tabelaDeProcedimentos;

    @JoinColumn(name = "procmedico_codigo", referencedColumnName = "codigo", nullable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcMedico procMedico;

    @JoinColumn(name = "valornoconvenio_codigo", referencedColumnName = "codigo", nullable=false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ValorNoConvenio valorNoConvenio;

    public ValorNoConvenio getValorNoConvenio ()
    {
        return valorNoConvenio;
    }

    public void setValorNoConvenio (ValorNoConvenio valorNoConvenio)
    {
        this.valorNoConvenio = valorNoConvenio;
    }

    public ProcMedico getProcMedico ()
    {
        return procMedico;
    }

    public void setProcMedico (ProcMedico procMedico)
    {
        this.procMedico = procMedico;
    }

    public TabelaDeProcedimentos getTabelaDeProcedimentos ()
    {
        return tabelaDeProcedimentos;
    }

    public void setTabelaDeProcedimentos (TabelaDeProcedimentos tabelaDeProcedimentos)
    {
        this.tabelaDeProcedimentos = tabelaDeProcedimentos;
    }

    public Money getValorPaciente ()
    {
        return new Money(valorPaciente);
    }

    public void setValorPaciente (double valorPaciente)
    {
        this.valorPaciente = new Money(valorPaciente).doubleValue();
    }
            
    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public Money getValorPagoPeloConvenio ()
    {
        return valorNoConvenio == null ? new Money() : valorNoConvenio.getValorNoConvenio();
    }

    @Override
    public String toString ()
    {
        return procMedico == null ? "" : procMedico.toString();
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
        final ProcDaTabela other = (ProcDaTabela) obj;
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
        hash = 97 * hash + this.codigo;
        return hash;
    }

}
