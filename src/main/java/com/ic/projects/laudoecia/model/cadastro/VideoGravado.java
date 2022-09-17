/*
 * VideoGravado.java
 *
 * Created on 18/01/2012, 16:56:41
 */
package com.ic.projects.laudoecia.model.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import java.io.File;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
@Entity
@Table(name = "videogravado")
public class VideoGravado implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "caminho", nullable = false)
    private String caminho = "";

    @Column(name = "duracao", nullable = true)
    private String duracao = "";

    @JoinColumn(name = "procedimento_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcDoAtd procedimento;

    @JoinColumn(name = "estacaodetrabalho_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstacaoDeTrabalho estacaoDeTrabalho;

    public EstacaoDeTrabalho getEstacaoDeTrabalho ()
    {
        return estacaoDeTrabalho;
    }

    public void setEstacaoDeTrabalho (EstacaoDeTrabalho estacaoDeTrabalho)
    {
        this.estacaoDeTrabalho = estacaoDeTrabalho;
    }

    public ProcDoAtd getProcedimento ()
    {
        return procedimento;
    }

    public void setProcedimento (ProcDoAtd procedimento)
    {
        this.procedimento = procedimento;
    }

    public String getCaminho ()
    {
        return caminho;
    }

    public void setCaminho (String caminho)
    {
        this.caminho = caminho;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getDuracao ()
    {
        return duracao;
    }

    public void setDuracao (String duracao)
    {
        this.duracao = duracao;
    }

    @Override
    public String toString ()
    {
        return caminho;
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
        final VideoGravado other = (VideoGravado) obj;
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
        hash = 31 * hash + this.codigo;
        return hash;
    }

    @PostRemove
    public void removerArquivoDoDisco ()
    {
        // estava sendo chamado de forma inadequada...
//        if (Objects.equals(StaticInfo.getEstTrabalho(), getEstacaoDeTrabalho()))
//        {
//            File arqVideo = new File(caminho);
//            if (arqVideo.exists())
//            {
//                try
//                {
//                    arqVideo.delete();
//                }
//                catch (Exception e)
//                {
//                }
//            }
//        }
    }

}
