/*
 * BuscadorDeStatusBackup.java
 *
 * Created on 18/04/2012, 10:06:58
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import com.lib.java.utils.Comparador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeStatusBackup extends C_AutoCompletarLista<STATUS_BACKUP>
{
    private List<String> lista = getLista();

    @Override
    protected STATUS_BACKUP getModel (Object[] linha)
    {
        String status = (String) linha[0];
        if (status.equals(STATUS_BACKUP.AGENDADO.getMensagem()))
        {
            return STATUS_BACKUP.AGENDADO;
        }
        if (status.equals(STATUS_BACKUP.DISCO_CHEIO.getMensagem()))
        {
            return STATUS_BACKUP.DISCO_CHEIO;
        }
        if (status.equals(STATUS_BACKUP.EM_ANDAMENTO.getMensagem()))
        {
            return STATUS_BACKUP.EM_ANDAMENTO;
        }
        if (status.equals(STATUS_BACKUP.ERRO_DESCONHECIDO.getMensagem()))
        {
            return STATUS_BACKUP.ERRO_DESCONHECIDO;
        }
        if (status.equals(STATUS_BACKUP.IO_EXCEPTION.getMensagem()))
        {
            return STATUS_BACKUP.IO_EXCEPTION;
        }
        if (status.equals(STATUS_BACKUP.REALIZADO_COM_SUCESSO.getMensagem()))
        {
            return STATUS_BACKUP.REALIZADO_COM_SUCESSO;
        }
        return null;
    }

    @Override
    protected Object[] getLinha (STATUS_BACKUP model)
    {
        return new Object[]
                {
                    model.getMensagem()
                };
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        return AutoCompletarUtils.converterLista(
                Comparador.ordenarLista(AutoCompletarUtils.
                buscarNaListaDesordenada(lista, textoDaBusca), false));
    }

    private List<String> getLista ()
    {
        List<String> result = new ArrayList<>();
        STATUS_BACKUP[] s = STATUS_BACKUP.values();
        for (int i = 0; i < s.length; i++)
        {
            if (!s[i].equals(STATUS_BACKUP.CANCELADO))
            {
                result.add(s[i].toString());
            }
        }
        return result;
    }

}
