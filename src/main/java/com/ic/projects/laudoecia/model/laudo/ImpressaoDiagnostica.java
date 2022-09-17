/*
 * ImpressaoDiagnostica.java
 *
 * Created on 09/05/2012, 15:43:31
 */

package com.ic.projects.laudoecia.model.laudo;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ImpressaoDiagnostica extends CampoTexto
{

    public ImpressaoDiagnostica ()
    {
        this("");
    }

    public ImpressaoDiagnostica (String textoPadrao)
    {
        super(textoPadrao);
    }

    public ImpressaoDiagnostica (CampoDoLaudo cdl)
    {
        super(cdl);
    }
    
    {
        setObrigatorio(true);
        setMsgErroValidCampoObrig("Preencha a impressão diagnóstica!");
    }
    
}
