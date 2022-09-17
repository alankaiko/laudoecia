/*
 * C_TxtPreview.java
 *
 * Created on 11/07/2012, 11:07:22
 */

package com.ic.projects.laudoecia.control.laudoecia;

import com.ic.projects.laudoecia.iview.PreviewCampoDoLaudo;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarString;
import com.lib.iview.autocompletar.AcTableConfigurator;
import com.lib.swing.plus.renderers.AlignedTblRnd;
import java.util.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_TxtPreview extends C_AutoCompletarString
{

    private static final String DESC_PREVIEW_IMP_LAUDO = "Laudo completo";
    private static final String DESC_IMPRESSAO_DIAG = "Impressão diagnóstica";
    private static final int IMP_DIAG_HEIGHT = 400;
    private static final int LAUDO_COMP_HEIGHT = 500;

    private List<String> topicos = new ArrayList<>();
    private Map<String, Integer[]> viewParams = new HashMap<>();
    private Map<String, String> cards = new HashMap<>();

    private PreviewCampoDoLaudo preview;
    private LaudoeCiaMediator mediador;

    public C_TxtPreview (PreviewCampoDoLaudo preview, LaudoeCiaMediator mediador)
    {
        this.preview = preview;
        this.mediador = mediador;
    }

    public void topicoFoiAdicionado (String cardId)
    {
        if (cardId.matches("[0-9]+"))
        {
            topicos.add(DESC_IMPRESSAO_DIAG);
            viewParams.put(DESC_IMPRESSAO_DIAG,
                           new Integer[] { IMP_DIAG_HEIGHT, Integer.valueOf(cardId) } );

            topicos.add(DESC_PREVIEW_IMP_LAUDO);
            viewParams.put(DESC_PREVIEW_IMP_LAUDO, new Integer[] { LAUDO_COMP_HEIGHT, -1 });
            cards.put(cardId, DESC_PREVIEW_IMP_LAUDO);
        }
        else
        {
            String params[] = cardId.split(";;");
            if (params.length == 2)
            {
                cards.put(cardId, null);
            }
            else
            {
                String descPreview = params[4];
                if (topicos.contains(descPreview))
                {
                }
                else
                {
                    topicos.add(descPreview);
                    viewParams.put(descPreview, new Integer[]
                            {
                                Integer.valueOf(params[2]),
                                Integer.valueOf(params[3])
                            });
                }
                cards.put(cardId, descPreview);
            }
        }
    }

    public void topicoFoiSelecionado (String cardId)
    {
        if (cardId == null)
        {
            topicos.clear();
            preview.limparPreview();
        }
        else
        {
            String modelToSelect = cards.get(cardId);
            if (modelToSelect == null)
            {
            }
            else
            {
                boolean topicoFoiEncontrado = false;
                for (int i = topicos.size() - 1; i >= 0; i--)
                {
                    String topico = topicos.get(i);
                    if (!topicoFoiEncontrado && Objects.equals(modelToSelect, topico))
                    {
                        topicoFoiEncontrado = true;
                    }
                    if (topicoFoiEncontrado)
                    {
                        Integer[] dadosPreview = viewParams.get(topico);
                        int index = dadosPreview[1];
                        if (index == -1 || mediador.isCdlHabilitado(index))
                        {
                            modelToSelect = topico;
                            break;
                        }
                    }
                }
            }
            setSelectedModel(modelToSelect);
            Integer[] dadosPreview = viewParams.get(modelToSelect);
            if (dadosPreview == null)
            {
                preview.limparPreview();
            }
            else
            {
                preview.atualizarAlturaDoPreview(dadosPreview[0]);
            }
        }
    }

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        List<String> topicosHab = new ArrayList<>();
        for (int i = 0; i < topicos.size(); i++)
        {
            String topico = topicos.get(i);
            int index = viewParams.get(topico)[1];
            if (index == -1 || mediador.isCdlHabilitado(index))
            {
                topicosHab.add(topico);
            }
        }

        List<String> resultBusca = AutoCompletarUtils.
                buscarNaListaDesordenada(topicosHab, textoDaBusca, true);
        if (resultBusca.isEmpty())
        {
            return AutoCompletarUtils.converterLista(topicosHab);
        }
        else
        {
            return AutoCompletarUtils.converterLista(resultBusca);
        }
    }

    @Override
    public void linhaSelecionadaMudou (Object[] antigo, Object[] novo)
    {
        super.linhaSelecionadaMudou(antigo, novo);
        if (novo == null)
        {
        }
        else
        {
            preview.atualizarDadosDoPreview(viewParams.get(getSelectedModel())[1]);
        }
    }

    @Override
    public boolean defListener ()
    {
        return false;
    }

    public void selecionarImpLaudo ()
    {
        if (topicos.contains(DESC_PREVIEW_IMP_LAUDO))
        {
            setSelectedModel(DESC_PREVIEW_IMP_LAUDO);
        }
    }

    @Override
    public AcTableConfigurator getPropriedadesDaTabela ()
    {
        return new AcTableConfigurator() {

            @Override
            public Map<Integer, TableCellRenderer> getOverridingRenderers ()
            {
                Map<Integer, TableCellRenderer> map = super.getOverridingRenderers();
                map.put(0, new AlignedTblRnd(AlignedTblRnd.CENTER));
                return map;
            }

            @Override
            public int indexToUseAsTextFieldText ()
            {
                return 0;
            }

            @Override
            public String[] columnsTitles ()
            {
                return null;
            }

            @Override
            public Class<?>[] columnsClasses ()
            {
                return null;
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[] { 0 };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { true };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int [] {  } ;
            }

        };
    }

    public void setarValorPadrao ()
    {
        setarValor(null);
    }

    public void setarValor (String valor)
    {
        int indexCdl = viewParams.get(getSelectedModel())[1];
        mediador.setarValor(indexCdl, valor);
        preview.atualizarDadosDoPreview(indexCdl);
    }

    public boolean isImpLaudoSelected ()
    {
        return DESC_PREVIEW_IMP_LAUDO.equals(getSelectedModel());
    }

    public boolean planilhaFoiEditada ()
    {
        int indexPlanilha = viewParams.get(DESC_PREVIEW_IMP_LAUDO)[1];
        return mediador.getValor(indexPlanilha) != null;
    }

}
