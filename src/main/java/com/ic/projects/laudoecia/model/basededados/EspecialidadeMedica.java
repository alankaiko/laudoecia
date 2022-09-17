/*
 * EspecialidadeMedica.java
 *
 * Created on 18/08/2010, 09:56:19
 */
package com.ic.projects.laudoecia.model.basededados;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Classe da entidade : Base de dados de especialidades medicas
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "especialidademedica")
@NamedNativeQuery(name = "buscarPorEspecialidade", query = "select * from especialidademedica where sem_acento(nome) like ?1", resultClass = EspecialidadeMedica.class)
public class EspecialidadeMedica implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome = "";

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
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
        final EspecialidadeMedica other = (EspecialidadeMedica) obj;
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
        hash = 71 * hash + this.codigo;
        return hash;
    }

    @Override
    public String toString ()
    {
        return nome;
    }

}