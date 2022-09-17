/*
 * C_Endereco.java
 *
 * Created on 15/02/2012, 11:54:59
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.basededados.DaoEnderecoPorCep;
import com.ic.projects.laudoecia.iview.ViewEndereco;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_Endereco
{
    private ViewEndereco view;
    private DaoEnderecoPorCep dao;

    public C_Endereco (ViewEndereco view)
    {
        this.view = view;
    }

    public void cepSelecionadoMudou (String cep)
    {
        List<Endereco> listEndereco = getDao().procurarEnderecoBuscandoPorCep(cep);
        if (listEndereco != null && !listEndereco.isEmpty())
        {
            Endereco endereco;
            if (listEndereco.size() > 1)
            {
                endereco = view.escolherEnderecoRepetido(listEndereco);
                if (endereco == null)
                {
                    endereco = new Endereco();
                    endereco.setCep(cep);
                }
            }
            else
            {
                endereco = listEndereco.get(0);
            }
            view.alimentarCamposPorCep(endereco);
        }
    }

    private DaoEnderecoPorCep getDao ()    
    {
        if (dao == null)
        {
            dao = new DaoEnderecoPorCep();
        }
        return dao;
    }

}
