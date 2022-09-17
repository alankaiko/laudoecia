package com.ic.projects.laudoecia.model.basededados;

import com.lib.java.utils.Comparador;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Developer01
 */
@Entity
@Table(name = "cnes")
public class CNES implements Serializable, Comparable<CNES> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codigo", length=7)
    private String codigo;
    
    @Column(name="razaosocial", nullable=false, length=100)
    private String razaoSocial;

    @Column(name="nomefantasia", nullable=false, length=100)
    private String nomeFantasia;

    @Column(name="cnpj", nullable=true, length=14)
    private String cnpj;

    @Column(name="cpf", nullable=true, length=11)
    private String cpf;

    @Column(name="codmunicipio", nullable=false, length=7)
    private String codMunicipio;

    @Column(name="municipio", nullable=false, length=40)
    private String municipio;

    @JoinColumn(name = "uf", referencedColumnName = "sigla", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UF uf;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CNES other = (CNES) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public int compareTo(CNES other) {
        if (other == null) {
            return +1;
        }
        else if (this.nomeFantasia == null) {
            return other.nomeFantasia == null ? 0 : -1;
        }
        else {
            return Comparador.compararRemovendoAcentos(this.nomeFantasia, other.nomeFantasia);
        }
    }

}