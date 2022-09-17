/*
 * ValorFixo.java
 *
 * Created on 19/01/2012, 11:18:58
 */
package com.ic.projects.laudoecia.model.cadastro;

import com.lib.java.utils.Money;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Marcelo <marcelo@instrumentalcientifico.net.br>
 */
@Entity
@DiscriminatorValue(value = "valorfixo")
public class ValorFixo extends ValorNoConvenio implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column(name = "valor", nullable = false)
    private double valor;

    public ValorFixo ()
    {
    }

    public ValorFixo (double valor)
    {
        this.valor = new Money(valor).doubleValue();
    }

    public Money getValor ()
    {
        return new Money(valor);
    }

    public void setValor (double valor)
    {
        this.valor = new Money(valor).doubleValue();
    }

    @Override
    public Money getValorNoConvenio ()
    {
        return new Money(valor);
    }

}
