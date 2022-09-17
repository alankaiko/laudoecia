/*
 * Licenciado.java
 *
 * Created on 04/04/2012, 11:01:58
 */
package com.ic.projects.laudoecia.model.auditable;

import com.ic.projects.laudoecia.model.enums.TIPO_LICENCA;
import com.ic.projects.laudoecia.model.enums.VERSAO_DO_SW;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
@Entity()
@Table(name = "licenciado")
public class Licenciado implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "cnpj", length = 14, nullable = true)
    private String cnpj = "";

    @Column(name = "cnes", length = 7, nullable = true)
    private String cnes = "";

    @Column(name = "cpf", nullable = true, length = 11)
    private String cpf = "";

    @Column(name = "licenciadopara", nullable = true)
    private String licenciadoPara = "";

    @Column(name = "razaoSocial", nullable = true)
    private String razaoSocial = "";

    @Embedded
    private Endereco endereco;

    @Column(name = "telefone1", length = 15, nullable = true)
    private String telefone1 = "";

    @Column(name = "telefone2", length = 15, nullable = true)
    private String telefone2 = "";

    @Column(name = "email", length = 50, nullable = true)
    private String email = "";

    @Column(name = "site", length = 50, nullable = true)
    private String site = "";

    @Column(name = "serial", nullable = false, unique=true)
    private String serial = "";

    @Column(name = "qtdeacessos", nullable = false)
    private int qtdeAcessos = 2;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipodelicenca", nullable = false)
    private TIPO_LICENCA tipodelicenca = TIPO_LICENCA.LAUDO_E_IMAGEM;

    // <editor-fold defaultstate="collapsed" desc="Versioned">

    @Version
    private long version = 0;

    public long getVersion()
    {
        return version;
    }

    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public TIPO_LICENCA getTipodelicenca ()
    {
        return tipodelicenca;
    }

    public void setTipodelicenca (TIPO_LICENCA tipodelicenca)
    {
        this.tipodelicenca = tipodelicenca;
    }

    public String getSerial ()
    {
        return serial;
    }

    public void setSerial (String serial)
    {
        this.serial = serial;
    }

    public int getQtdeAcessos ()
    {
        return qtdeAcessos;
    }

    public void setQtdeAcessos (int qtdeAcessos)
    {
        this.qtdeAcessos = qtdeAcessos;
    }

    public String getCnes ()
    {
        return cnes == null ? "" : cnes;
    }

    public String getCnpj ()
    {
        return cnpj == null ? "" : cnpj;
    }

    public int getCodigo ()
    {
        return codigo;
    }

    public String getCpf ()
    {
        return cpf == null ? "" : cpf;
    }

    public String getEmail ()
    {
        return email == null ? "" : email;
    }

    public Endereco getEndereco ()
    {
        return endereco;
    }

    public String getLicenciadoPara ()
    {
        return licenciadoPara == null ? "" : licenciadoPara;
    }

    public String getRazaoSocial ()
    {
        return razaoSocial == null ? "" : razaoSocial;
    }

    public String getSite ()
    {
        return site == null ? "" : site;
    }

    public String getTelefone1 ()
    {
        return telefone1 == null ? "" : telefone1;
    }

    public String getTelefone2 ()
    {
        return telefone2 == null ? "" : telefone2;
    }

    public void setCnes (String cnes)
    {
        this.cnes = cnes;
    }

    public void setCnpj (String cnpj)
    {
        this.cnpj = cnpj;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public void setCpf (String cpf)
    {
        this.cpf = cpf;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public void setEndereco (Endereco endereco)
    {
        this.endereco = endereco;
    }

    public void setLicenciadoPara (String licenciadoPara)
    {
        this.licenciadoPara = licenciadoPara;
    }

    public void setRazaoSocial (String razaoSocial)
    {
        this.razaoSocial = razaoSocial;
    }

    public void setSite (String site)
    {
        this.site = site;
    }

    public void setTelefone1 (String telefone1)
    {
        this.telefone1 = telefone1;
    }

    public void setTelefone2 (String telefone2)
    {
        this.telefone2 = telefone2;
    }

    public void setVersion (long version)
    {
        this.version = version;
    }

    //</editor-fold>

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
        final Licenciado other = (Licenciado) obj;
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
        hash = 71 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return getRazaoSocial();
    }

}
