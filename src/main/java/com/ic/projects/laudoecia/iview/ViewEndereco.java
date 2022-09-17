/*
 * ViewEndereco.java
 *
 * Created on 15/02/2012, 11:36:55
 */
package com.ic.projects.laudoecia.iview;

import com.ic.projects.laudoecia.model.notentities.Endereco;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public interface ViewEndereco
{
    void alimentarCamposPorCep (Endereco entidade);

    Endereco escolherEnderecoRepetido (List<Endereco> listEndereco);

}
