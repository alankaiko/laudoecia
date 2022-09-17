/*
 * View.java
 *
 * Created on 17/09/2012, 17:32:17
 */

package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.laudo.DaoModeloDeLaudo;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.model.laudo.Planilha;
import com.ic.projects.laudoecia.view.laudo.ViewLaudoBuilder;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.autocompletar.C_AutoCompletarString;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.CardAdapter;
import com.lib.swing.plus.utils.PnlCartao;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
// <editor-fold defaultstate="collapsed" desc="Supress warnings">

@SuppressWarnings({"UseOfSystemOutOrSystemErr", "StaticNonFinalUsedInInitialization", "UtilityClassWithoutPrivateConstructor"})

// </editor-fold>
class View
{

    // <editor-fold defaultstate="collapsed" desc="Utils">

    private static DaoModeloDeLaudo dao = new DaoModeloDeLaudo();
    static StringBuilder sb = new StringBuilder("");
    static DaoModeloDeLaudo daoModeloDeLaudo = new DaoModeloDeLaudo();

    static
    {
        LaudoeCia.configurarGenericDao();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                try
                {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                }
                catch (Exception ex)
                {
                }
            }

        });
    }

    static JFrame getFrame ()
    {
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return fr;
    }

    static void showView (int mdl) throws Exception
    {
        ProcDoAtd pda = new ProcDoAtd();
        pda.setDataDaExecucao(new Date());
        final Laudo laudo = new Laudo(new ModeloDeLaudoDoProc(dao.procurarPorId(mdl)));
        pda.setLaudo(laudo);
        final PnlCartao pnlCartao = new PnlCartao();
        pnlCartao.setBorder(new BlackAndWhiteEtchedBorder());

        JMenuBar mnBar = new JMenuBar();
        mnBar.setBorder(new BlackAndWhiteEtchedBorder());
        final C_TxtTopico c_TxtTopico = new C_TxtTopico(laudo.getPlanilha());
        mnBar.add(new TxtTopico(pnlCartao, c_TxtTopico));
        mnBar.add(new MyJButton(" << ")
        {

            {
                addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed (ActionEvent e)
                    {
                        c_TxtTopico.anterior();
                    }

                });
            }

        });
        mnBar.add(new MyJButton(" >> ")
        {

            {
                addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed (ActionEvent e)
                    {
                        c_TxtTopico.proximo();
                    }

                });
            }

        });
        MyJButton btn = new MyJButton(" Ver html");
        btn.addActionListener(new ActionListener()
        {
            @Override
            @SuppressWarnings("CallToThreadDumpStack")
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    verLaudo(laudo.getPlanilha());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    String delay = "";
                }
            }

        });
        mnBar.add(btn);

        JFrame frame = getFrame();
        frame.setJMenuBar(mnBar);
        frame.setContentPane(pnlCartao);

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            @SuppressWarnings("CallToThreadDumpStack")
            public void run ()
            {
                try
                {
                    new ViewLaudoBuilder(laudo.getPlanilha(), pnlCartao, sb.toString()).execute();
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            }

        });
        frame.setVisible(true);

    }

    static void verLaudo (Planilha laudo) throws Exception
    {
        final JTextPane editor = new JTextPane();
        editor.setContentType("text/html");
        editor.setText(laudo.gerarHtml(false));
        JFrame fr = getFrame();
        fr.add(new JScrollPane(editor), BorderLayout.CENTER);
        JButton jButton = new JButton("Print");
        jButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    editor.print(null,
                                 null, false, null, null, true);
                }
                catch (PrinterException ex)
                {
                }
            }

        });
        fr.add(jButton, BorderLayout.SOUTH);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
    }

    static class TxtTopico extends TxtComAutoCompletar
    {
        TxtTopico (final PnlCartao pnlCartao, final C_TxtTopico buscador)
        {
            super(buscador);
            pnlCartao.addCardListener(new CardAdapter()
            {
                @Override
                public void cardAdded (String cardId)
                {
                    buscador.cadastrarTopico(cardId);
                }

            });
            addAutoCompletarListener(new AutoCompletarListener()
            {
                @Override
                public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
                {
                    pnlCartao.setSelectedCard(buscador.getSelCard());
                }

            });
        }

    }

    static class C_TxtTopico extends C_AutoCompletarString
    {
        Planilha planilha;

        static final String DESC_TOPICO_CID = "Médico Executante";

        Map<String, Integer> topicos = new LinkedHashMap<>();

        Map<String, String> cards = new LinkedHashMap<>();

        C_TxtTopico (Planilha planilha)
        {
            this.planilha = planilha;
        }

        void cadastrarTopico (String cardId)
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
                Integer index = entry.getValue();
                if (planilha.getCampo(index).isHabilitado())
                {
                    topicosHabilitados.add(topico);
                }
            }
            List<String> resultadoDaBusca = AutoCompletarUtils.buscarNaListaDesordenada(topicosHabilitados, textoDaBusca);
            return AutoCompletarUtils.converterLista(resultadoDaBusca);
        }

        void proximo ()
        {
            Iterator<Map.Entry<String, Integer>> it = topicos.entrySet().iterator();
            String resposta = null;
            String topicoSel = getSelectedModel();
            boolean topSelEncontrado = false;
            if (topicoSel == null)
            {
                topSelEncontrado = true;
            }
            while (it.hasNext())
            {
                String topicoAtual = it.next().getKey();
                if (topSelEncontrado)
                {
                    if (planilha.getCampo(topicos.get(topicoAtual)).isHabilitado())
                    {
                        resposta = topicoAtual;
                        break;
                    }
                }
                else
                {
                    topSelEncontrado = topicoAtual.equals(topicoSel);
                }
            }
            setSelectedModel(resposta);
        }

        void anterior ()
        {
            Iterator<Map.Entry<String, Integer>> it = topicos.entrySet().iterator();
            String resposta = null;
            String topicoSel = getSelectedModel();
            ArrayDeque<String> stackDosTopicos = new ArrayDeque<>();
            boolean topAtualEncontrado = false;
            if (topicoSel == null)
            {
            }
            else
            {
                while (it.hasNext() && !topAtualEncontrado)
                {
                    String topicoAtual = it.next().getKey();
                    stackDosTopicos.push(topicoAtual);
                    if (topicoAtual.equals(topicoSel))
                    {
                        topAtualEncontrado = true;
                        resposta = topicoAtual;
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
        }

        String getSelCard ()
        {
            String topicoSel = getSelectedModel();
            if (topicoSel == null)
            {
                return null;
            }
            else
            {
                return cards.get(topicoSel);
            }
        }

    }

    @SuppressWarnings("CallToThreadDumpStack")
    static void alterarVisaoDeLaudo (int id) throws Exception
    {
        try
        {
            ModeloDeLaudo mdl = daoModeloDeLaudo.procurarPorId(id);
            mdl.setVisao(sb.toString());
            daoModeloDeLaudo.alterar(mdl);
            System.out.println("Alterada a visão: " + id);
            sb.delete(0, sb.length());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // </editor-fold>

}
