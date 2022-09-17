/*
 * C_TxtTopico.java
 *
 * Created on 06/07/2012, 10:35:58
 */
package com.ic.projects.laudoecia.control.laudoecia;

import com.ic.projects.laudoecia.iview.ViewTopico;
import com.ic.projects.laudoecia.model.laudo.Planilha;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarString;
import java.util.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_TxtTopico extends C_AutoCompletarString
{

    private static final String DESC_TOPICO_CID = "Médico executante";

    private Planilha planilha;
    private String lastSelModel = null;
    private Map<String, Integer> topicos = new LinkedHashMap<>();
    private Map<String, String> cards = new LinkedHashMap<>();

    public C_TxtTopico (Planilha planilha)
    {
        this.planilha = planilha;
    }

    public void topicoFoiAdicionado (String cardId)
    {
        if (cardId.matches("[0-9]+"))
        {
            topicos.put(DESC_TOPICO_CID, -1);
            cards.put(DESC_TOPICO_CID, cardId);
        }
        else
        {
            String dados[] = cardId.split(";;");
            String descricaoTopico = dados[1];
            int indexDoTopicoNaPlanilha = Integer.valueOf(dados[0]);
            topicos.put(descricaoTopico, indexDoTopicoNaPlanilha);
            cards.put(descricaoTopico, cardId);
        }
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        List<String> topicosHabilitados = new ArrayList<>();
        for (Iterator<Map.Entry<String, Integer>> it = topicos.entrySet().iterator(); it.hasNext();)
        {
            Map.Entry<String, Integer> entry = it.next();
            String topico = entry.getKey();
            if (it.hasNext())
            {
                Integer index = entry.getValue();
                if (planilha.getCampo(index).isHabilitado())
                {
                    topicosHabilitados.add(topico);
                }
            }
            else
            {
                topicosHabilitados.add(topico);
            }
        }
        List<String> resultadoDaBusca = AutoCompletarUtils.
                buscarNaListaDesordenada(topicosHabilitados, textoDaBusca, true);
        return AutoCompletarUtils.converterLista(resultadoDaBusca);
    }

    public void proximo ()
    {
        String topicoSel = getSelectedModel();
        if (topicoSel == null)
        {
            setSelModelFromSelCard();
            return;
        }
        Iterator<Map.Entry<String, Integer>> it = topicos.entrySet().iterator();
        String resposta = null;
        boolean topSelEncontrado = false;
        while (it.hasNext())
        {
            String topicoAtual = it.next().getKey();
            if (topSelEncontrado)
            {
                boolean selAtual = !it.hasNext() ||
                    planilha.getCampo(topicos.get(topicoAtual)).isHabilitado();
                if (selAtual)
                {
                    resposta = topicoAtual;
                    break;
                }
            }
            else
            {
                topSelEncontrado = topicoAtual.equals(topicoSel);
                resposta = topicoAtual;
            }
        }
        setSelectedModel(resposta);
    }

    public void anterior ()
    {
        String topicoSel = getSelectedModel();
        if (topicoSel == null)
        {
            setSelModelFromSelCard();
            return;
        }
        Iterator<Map.Entry<String, Integer>> it = topicos.entrySet().iterator();
        String resposta = null;
        ArrayDeque<String> stackDosTopicos = new ArrayDeque<>();
        while (it.hasNext())
        {
            String topicoAtual = it.next().getKey();
            stackDosTopicos.push(topicoAtual);
            if (topicoAtual.equals(topicoSel))
            {
                resposta = topicoAtual;
                break;
            }
        }
        stackDosTopicos.pop();
        while (!stackDosTopicos.isEmpty())
        {
            String topico = stackDosTopicos.pop();
            if (planilha.getCampo(topicos.get(topico)).isHabilitado())
            {
                resposta = topico;
                break;
            }
        }
        setSelectedModel(resposta);
    }

    public void ultimo ()
    {
        irParaExec();
    }

    public void primeiro ()
    {
        String primeiroTopicoHabilitado = null;
        Iterator<Map.Entry<String, Integer>> it = topicos.entrySet().iterator();
        while (it.hasNext())
        {
            String topico = it.next().getKey();
            if (planilha.getCampo(topicos.get(topico)).isHabilitado())
            {
                primeiroTopicoHabilitado = topico;
                break;
            }
        }
        if (primeiroTopicoHabilitado != null)
        {
            setSelectedModel(primeiroTopicoHabilitado);
        }
    }

    private void setSelModelFromSelCard ()
    {
        setSelectedModel(lastSelModel);
    }

    public void modelSelMudou (Object[] ultimaLinhaSel)
    {
        String topicoSel = getSelectedModel();
        if (topicoSel == null)
        {
        }
        else
        {
            if (getView() == null)
            {
            }
            else
            {
                ((ViewTopico) getView()).setTopicoSel(cards.get(topicoSel));
            }
        }
        lastSelModel = ultimaLinhaSel == null ? null : getModel(ultimaLinhaSel);
    }

    public void irParaExec ()
    {
        if (topicos.containsKey(DESC_TOPICO_CID))
        {
            setSelectedModel(DESC_TOPICO_CID);
        }
    }

    public void setSelectedCard (String cardDesejado)
    {
        for (Map.Entry<String, String> entry : cards.entrySet())
        {
            String descricaoTopico = entry.getKey();
            String cardId = entry.getValue();
            if (cardId.equals(cardDesejado))
            {
                setSelectedModel(descricaoTopico);
            }
        }
    }

}
