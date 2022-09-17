/*
 * ValidadorFiltroIntervaloDeDatas.java
 *
 * Created on 02/03/2012, 11:11:10
 */
package com.ic.projects.laudoecia.view.validacao;

import com.lib.swing.utils.SwingUtils;
import java.util.Date;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class ValidadorFiltroIntervaloDeDatas
{
    public static boolean validarDatas (Date dataIni, Date dataFin)
    {
        if (dataIni == null || dataFin == null)
        {
            SwingUtils.mostrarAviso(null, "Datas não podem ser vazias.");
            return false;
        }
        if (dataIni.after(dataFin))
        {
            SwingUtils.mostrarAviso(null, "A data inicial não pode ser "
                                                        + "maior que a data final.");
            return false;
        }
        return true;
    }

}
