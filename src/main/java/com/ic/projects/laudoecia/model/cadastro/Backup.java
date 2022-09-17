/*
 * Backup.java
 *
 * Created on 02/04/2012, 10:49:11
 */
package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author marcelol-IC
 */
@Entity
@Table(name = "backup")
public class Backup implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "datamarcada", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataMarcada;

    @Column(name = "datadeinicio", nullable = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDeInicio;

    @Column(name = "datadetermino", nullable = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataDeTermino;

    @Column(name = "diretorioDoArquivo", nullable = false)
    private String diretorioDoArquivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private STATUS_BACKUP status;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TIPO_BACKUP tipo;

    @JoinColumn(name = "estacao_codigo", referencedColumnName = "codigo", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private EstacaoDeTrabalho estacao;

    public EstacaoDeTrabalho getEstacao ()
    {
        return estacao;
    }

    public void setEstacao (EstacaoDeTrabalho estacao)
    {
        this.estacao = estacao;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public Date getDataDeInicio ()
    {
        return dataDeInicio;
    }

    public void setDataDeInicio (Date dataDeInicio)
    {
        this.dataDeInicio = dataDeInicio;
    }

    public Date getDataDeTermino ()
    {
        return dataDeTermino;
    }

    public void setDataDeTermino (Date dataDeTermino)
    {
        this.dataDeTermino = dataDeTermino;
    }

    public Date getDataMarcada ()
    {
        return dataMarcada;
    }

    public void setDataMarcada (Date dataMarcada)
    {
        this.dataMarcada = dataMarcada;
    }

    public String getDiretorioDoArquivo ()
    {
        return diretorioDoArquivo;
    }

    public void setDiretorioDoArquivo (String diretorioDoArquivo)
    {
        this.diretorioDoArquivo = diretorioDoArquivo;
        if (!(diretorioDoArquivo == null || diretorioDoArquivo.isEmpty()))
        {
            if (diretorioDoArquivo.endsWith("/") || diretorioDoArquivo.endsWith("\\"))
            {
            }
            else
            {
                this.diretorioDoArquivo += "\\";
            }
        }
    }

    public STATUS_BACKUP getStatus ()
    {
        return status;
    }

    public void setStatus (STATUS_BACKUP status)
    {
        this.status = status;
    }

    public TIPO_BACKUP getTipo ()
    {
        return tipo;
    }

    public void setTipo (TIPO_BACKUP tipo)
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
        final Backup other = (Backup) obj;
        if (this.codigo != other.codigo)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 3;
        hash = 11 * hash + this.codigo;
        return hash;
    }

    public String fileName ()
    {
        if (dataDeInicio == null)
        {
            return "";
        }
        SimpleDateFormat sdfBackupName = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        StringBuilder sb = new StringBuilder("");
        sb.append(sdfBackupName.format(dataDeInicio));
        return sb.append(".backup").toString();
    }

    public String pastaDeImagens ()
    {
        if (diretorioDoArquivo == null)
        {
            return "imagens\\";
        }
        else
        {
            return diretorioDoArquivo + "imagens\\";
        }
    }

    public boolean isBackupAutomatico ()
    {
        return getEstacao() == null;
    }

}
