/*
 * BuscadorDeUsuarios.java
 *
 * Created on 01/02/2012, 07:50:26
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoUsuario;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class BuscadorDeUsuarios extends C_AutoCompletarLista<Usuario>
{
    private DaoUsuario dao;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (textoDaBusca != null && textoDaBusca.matches("[0-9]{1,5}") &&
            !textoDaBusca.equals(String.valueOf(Usuario.CODIGO_SUPORTE))
            && !textoDaBusca.equals(String.valueOf(Usuario.CODIGO_NULL)))
        {
            Usuario u = getDao().procurarPorId(Integer.valueOf(textoDaBusca));
            List<Object[]> result = new ArrayList<>();
            if (u != null && u.isAtivo())
            {
                result.add (new Object[] { u.getLogin() });
            }
            return result;
        }
        else
        {
            return AutoCompletarUtils.converterLista(
                    getDao().buscarPorLogin(textoDaBusca));
        }
    }

    @Override
    protected Usuario getModel (Object[] linha)
    {
        return getDao().buscarDonoDoLogin( (String) linha[0]);
    }

    @Override
    protected Object[] getLinha (Usuario model)
    {
        return new Object[] { model.getLogin() };
    }

    public Usuario getSelectedModel (String busca)
    {
        Usuario resposta = super.getSelectedModel();
        if (resposta == null && busca != null)
        {
            if (busca.matches("[0-9]+"))
            {
                resposta = getDao().procurarPorId(Integer.valueOf(busca));
            }
            else
            {
                resposta = getDao().buscarDonoDoLogin(busca);
            }
        }
        if (resposta == null || !resposta.isAtivo())
        {
            return null;
        }
        else
        {
            return resposta;
        }
    }

    private DaoUsuario getDao()
    {
        if (dao == null)
        {
            dao = new DaoUsuario();
        }
        return dao;
    }

}
