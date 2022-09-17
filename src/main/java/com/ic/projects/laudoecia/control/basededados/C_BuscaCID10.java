/*
 * C_BuscaCID10.java
 *
 * Created on 12/03/2012, 08:22:02
 */

package com.ic.projects.laudoecia.control.basededados;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeCapituloCID10;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeCategoriaCID10;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeGrupoCID10;
import com.ic.projects.laudoecia.dao.basededados.DaoCID10;
import com.ic.projects.laudoecia.model.basededados.CapituloCID10;
import com.ic.projects.laudoecia.model.basededados.CategoriaCID10;
import com.ic.projects.laudoecia.model.basededados.GrupoCID10;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.lib.icontrol.crud.busca.AbsDefC_Busca;
import com.lib.icontrol.crud.busca.C_ParamsBusca;
import com.lib.icontrol.crud.busca.C_ResultadosDaBusca;
import com.lib.iview.crud.ViewParamsBusca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_BuscaCID10 extends AbsDefC_Busca<SubcategoriaCID10, String>
{

    private DaoCID10 dao;
    private BuscadorDeCategoriaCID10 buscadorCat = new BuscadorDeCategoriaCID10();
    private BuscadorDeGrupoCID10 buscadorGrupo = new BuscadorDeGrupoCID10();
    private BuscadorDeCapituloCID10 buscadorCap = new BuscadorDeCapituloCID10();

    public C_BuscaCID10 (C_ParamsBusca c_ParamsBusca, C_ResultadosDaBusca c_ResultadosDaBusca)
    {
        super(new DaoCID10(), c_ParamsBusca, c_ResultadosDaBusca);
        dao = (DaoCID10) getDao();
    }

    @Override
    protected List<Object[]> nullSafeListarResultados (Object[] paramsBusca)
    {
        String busca = (String) paramsBusca[0];
        String campo = (String) paramsBusca[1];
        int maxResults = (int) paramsBusca[2];
        switch (campo)
        {
            case "nome":
                if (busca == null || busca.isEmpty())
                {
                    return new ArrayList<>();
                }
                return dao.buscarPorNome(busca, maxResults);
            case "código":
                if (busca == null || busca.isEmpty())
                {
                    return new ArrayList<>();
                }
                return dao.buscarPorCodigo(busca, maxResults);
            case "categoria":
                CategoriaCID10 catCID10 = buscadorCat.getSelectedModel();
                if (catCID10 != null)
                {
                    return dao.buscarPorCategoria(catCID10, maxResults);
                }
                return new ArrayList<>();
            case "grupo":
                GrupoCID10 grupoCID10 = buscadorGrupo.getSelectedModel();
                if (grupoCID10 != null)
                {
                    return dao.buscarPorGrupo(grupoCID10, maxResults);
                }
                return new ArrayList<>();
            case "assunto / capitulo":
                CapituloCID10 capituloCID10 = buscadorCap.getSelectedModel();
                if (capituloCID10 != null)
                {
                    return dao.buscarPorCapitulo(capituloCID10, maxResults);
                }
                return new ArrayList<>();
            default:
                return new ArrayList<>();
        }
    }

    @Override
    protected void parametrosBuscaMudaram (Object[] newParamsBusca, Object[] oldParamsBusca)
    {
        String newCampo = (String) newParamsBusca[1];
        String oldCampo = (String) oldParamsBusca[1];
        if (!newCampo.equals(oldCampo))
        {
            switch (newCampo)
            {
                case "categoria":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorCat);
                    break;
                case "grupo":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorGrupo);
                    break;
                case "assunto / capitulo":
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, buscadorCap);
                    break;
                default:
                    putProperty(ViewParamsBusca.KEY_BUSCADOR, null);
            }
        }
    }

    @Override
    public Object[] criarLinhaSelecionada (SubcategoriaCID10 entidade)
    {
        return new Object[] { entidade.getCodigo(), entidade.getNome() } ;
    }

}
