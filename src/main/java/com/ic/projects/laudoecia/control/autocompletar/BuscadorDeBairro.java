/*
 * BuscadorDeBairro.java
 *
 * Created on 15/02/2012, 17:40:57
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarString;
import com.lib.iview.autocompletar.RecursoAutoCompletar;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeBairro extends C_AutoCompletarString
{
    private UF uf;
    private String cidade;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (uf == null || cidade == null)
        {
            return new ArrayList<>();
        }
        else
        {
            return AutoCompletarUtils.buscarNaListaOrdenada(getLista(), textoDaBusca);
        }
    }

    private List<String> getLista ()
    {
        return StaticInfo.getBairros(uf, cidade);
    }

    public void setFiltroUF (UF uf)
    {
        if (Objects.equals(this.uf, uf))
        {
        }
        else
        {
            this.uf = uf;
            configurarView();
        }
    }

    public void setFiltroCidade (String cidade)
    {
        if (Objects.equals(this.cidade, cidade))
        {
        }
        else
        {
            this.cidade = cidade;
            configurarView();
        }
    }

    @Override
    public void setView (RecursoAutoCompletar view)
    {
        super.setView(view);
        view.setHabilitado(!(uf == null || cidade == null || cidade.isEmpty()));
    }

    private void configurarView ()
    {
        setSelectedModel("");
        getView().setHabilitado(!(uf == null || cidade == null || cidade.isEmpty()));
    }

}
