/*
 * BackupAutomatico.java
 *
 * Created on 11/04/2012, 09:02:34
 */

package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.lib.model.abstracao.DIA_DA_SEMANA;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name="backupautomatico")
public class BackupAutomatico implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @JoinColumn(name = "parametrosdosistema_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ParametrosDoSistema parametrosDoSistema;

    @Enumerated(EnumType.STRING)
    @Column(name = "diadasemana", nullable = false)
    private DIA_DA_SEMANA diaDaSemana;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TIPO_BACKUP tipo;

    @Column(name = "horario", nullable = true)
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horario;

    @Column(name = "diretoriodoarquivo", nullable = false)
    private String diretorioDoArquivo;

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public DIA_DA_SEMANA getDiaDaSemana ()
    {
        return diaDaSemana;
    }

    public void setDiaDaSemana (DIA_DA_SEMANA diaDaSemana)
    {
        this.diaDaSemana = diaDaSemana;
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

    public Date getHorario ()
    {
        return horario;
    }

    public void setHorario (Date horario)
    {
        this.horario = horario;
    }

    public ParametrosDoSistema getParametrosDoSistema ()
    {
        return parametrosDoSistema;
    }

    public void setParametrosDoSistema (ParametrosDoSistema parametrosDoSistema)
    {
        this.parametrosDoSistema = parametrosDoSistema;
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
        final BackupAutomatico other = (BackupAutomatico) obj;
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
        hash = 59 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return diaDaSemana.toString();
    }

}
