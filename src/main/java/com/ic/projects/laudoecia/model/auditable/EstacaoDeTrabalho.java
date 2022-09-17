/*
 * EstacaoDeTrabalho.java
 *
 * Created on 19/01/2012, 12:06:43
 */
package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author marcelol-IC
 */
@Entity
@Table(name = "estacaodetrabalho")
public class EstacaoDeTrabalho implements Serializable
{
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "nomeestacaodetrabalho", nullable = false, unique = false)
    private String nomeEstacaoDeTrabalho;

    @Column(name = "serialhd", nullable = false, unique = true)
    private String serialHD;

    @Column(name = "dispositivograv", nullable = true)
    private String dispositivoGrav;

    @Column(name = "logado", nullable = false)
    private boolean logado;

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getNomeEstacaoDeTrabalho ()
    {
        return nomeEstacaoDeTrabalho;
    }

    public void setNomeEstacaoDeTrabalho (String nomeEstacaoDeTrabalho)
    {
        this.nomeEstacaoDeTrabalho = nomeEstacaoDeTrabalho;
        if (this.nomeEstacaoDeTrabalho != null)
        {
            this.nomeEstacaoDeTrabalho = this.nomeEstacaoDeTrabalho.toUpperCase();
        }
    }

    public String getDispositivoGrav ()
    {
        return dispositivoGrav;
    }

    public void setDispositivoGrav (String dispositivoGrav)
    {
        this.dispositivoGrav = dispositivoGrav;
    }

    public String getSerialHD ()
    {
        return serialHD;
    }

    public void setSerialHD (String serialHD)
    {
        this.serialHD = serialHD;
    }

    public boolean getLogado ()
    {
        return logado;
    }

    public void setLogado (boolean logado)
    {
        this.logado = logado;
    }

    @Override
    public String toString ()
    {
        return nomeEstacaoDeTrabalho == null ? "" : nomeEstacaoDeTrabalho;
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
        final EstacaoDeTrabalho other = (EstacaoDeTrabalho) obj;
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
