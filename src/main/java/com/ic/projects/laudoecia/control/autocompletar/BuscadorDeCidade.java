/*
 * BuscadorDeCidade.java
 *
 * Created on 15/02/2012, 15:32:01
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
public class BuscadorDeCidade extends C_AutoCompletarString
{
    private UF uf;

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (uf == null)
        {
            return new ArrayList<>();
        }
        return AutoCompletarUtils.buscarNaListaOrdenada(getLista(), textoDaBusca);
    }

    private List<String> getLista ()
    {
        return StaticInfo.getCidades(uf);
    }

    public void setFiltroUF (UF uf)
    {
        if (Objects.equals(this.uf, uf))
        {
        }
        else
        {
            this.uf = uf;
            getView().setHabilitado(uf != null);
            setSelectedModel("");
        }
    }

    @Override
    public void setView (RecursoAutoCompletar view)
    {
        super.setView(view);
        view.setHabilitado(uf != null);
    }

}
