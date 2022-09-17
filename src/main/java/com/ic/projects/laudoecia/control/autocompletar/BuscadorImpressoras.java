/*
 * BuscadorImpressoras.java
 *
 * Created on 18/05/2014, 14:05:22
 */

package com.ic.projects.laudoecia.control.autocompletar;

import com.lib.icontrol.autocompletar.C_AutoCompletarString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class BuscadorImpressoras extends C_AutoCompletarString
{

    private final List<Object[]> impressoras = new ArrayList<>();

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (impressoras.isEmpty())
        {
            carregarImpressoras();
        }
        return Collections.unmodifiableList(impressoras);
    }

    private void carregarImpressoras ()
    {
        for (PrintService ps : PrintServiceLookup.lookupPrintServices(null, null))
        {
            Object[] item = new String[1];
            item[0] = ps.getName();
            impressoras.add(item);
        }
    }

}
