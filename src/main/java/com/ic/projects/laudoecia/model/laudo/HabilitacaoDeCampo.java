/*
 * HabilitacaoDeCampo.java
 *
 * Created on 16/05/2012, 16:06:55
 */

package com.ic.projects.laudoecia.model.laudo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class HabilitacaoDeCampo implements CampoDoLaudoListener
{
    
    private boolean habilitado = true;
    private CampoDoLaudo donoDaHabilitacao;
    private Map<CampoDoLaudo, DesabilitadorDeCampo> mapa = new HashMap<>();

    HabilitacaoDeCampo (CampoDoLaudo dono)
    {
        this.donoDaHabilitacao = dono;
    }
    
    void adicionarDependencia (CampoDoLaudo campo, DesabilitadorDeCampo desCampo)
    {
        campo.adicionarListener(this);
        mapa.put(campo, desCampo);
        if (desCampo.desabilitarCampo())
        {
            donoDaHabilitacao.setHabilitado(false);
        }
    }

    boolean isHabilitado ()
    {
        return habilitado;
    }
    
    void setHabilitado (boolean habilitado)
    {
        this.habilitado = habilitado;
    }
    
    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
        CampoDoLaudo origem = evento.getOrigem();
        DesabilitadorDeCampo desCampoOriginal = mapa.get(origem);
        desCampoOriginal.campoDoLaudoMudou(evento);
        if (desCampoOriginal.desabilitarCampo())
        {
            donoDaHabilitacao.setHabilitado(false);
        }
        else
        {
            for (Iterator<DesabilitadorDeCampo> it = mapa.values().iterator(); it.hasNext();)
            {
                DesabilitadorDeCampo outroDesCampo = it.next();
                if (outroDesCampo == desCampoOriginal)
                {
                    continue;
                }
                else
                {
                    if (outroDesCampo.desabilitarCampo())
                    {
                        donoDaHabilitacao.setHabilitado(false);
                        return;
                    }
                }
            }
            donoDaHabilitacao.setHabilitado(true);
        }
    }
    
}
