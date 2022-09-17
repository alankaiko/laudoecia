/*
 * SwViewLaudo.java
 *
 * Created on 06/07/2012, 15:07:16
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorCID10;
import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProfExecutante;
import com.ic.projects.laudoecia.control.laudoecia.C_TxtTopico;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.model.laudo.*;
import com.ic.projects.laudoecia.model.laudo.Composite;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJScrollPane;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.EnterEnviaTab;
import com.lib.swing.utils.RobotImpl;
import com.lib.swing.utils.SwingUtils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class SwViewLaudo extends SwingWorker<Void, String>
{

    // <editor-fold defaultstate="collapsed" desc="Flags">

    private int indexAtual = 0;
    private int initialSelCard = 0;
    private boolean initialCardSel = false;
    private boolean showViewEnabled = false;
    private boolean showViewIsScheduled = false;
    private boolean viewTerminouDeSerCriado = false;
    private boolean naoAddPnlNoMetodoProcess = false;

    private static String PNL_CID_EX = "PNL_CID_EX";

    // </editor-fold>

    private static final BuscadorCID10 buscadorCid = new BuscadorCID10();
    private static final BuscadorDeProfExecutante buscadorExec = new BuscadorDeProfExecutante();

    private C_TxtTopico buscadorTopico;
    private final Map<String, MyJScrollPane> paineis = new LinkedHashMap<>();

    private final Laudo laudo;
    private final TxtTopico txtTopico;
    private final PnlCartao pnlTopicos;
    private final LaudoeCiaMediator mediador;
    private TxtExec txtExec;
    private boolean selecionarTxtExec = false;

    public SwViewLaudo (Laudo laudo, TxtTopico txtTopico, PnlCartao pnlTopicos,
                                                          LaudoeCiaMediator mediador)
    {
        this.laudo = laudo;
        this.txtTopico = txtTopico;
        this.pnlTopicos = pnlTopicos;
        this.mediador = mediador;
    }

    @Override
    protected void process (java.util.List<String> chunks)
    {
        for (int i = 0; i < chunks.size(); i++)
        {
            String cardId = chunks.get(i);
            if (isCancelled() || naoAddPnlNoMetodoProcess)
            {
                break;
            }
            else
            {
                pnlTopicos.addCard(paineis.get(cardId), cardId);
                if (initialCardSel)
                {
                }
                else
                {
                    setSelCardIfNeeded(cardId.split(";;"));
                }
            }
        }
    }

    @Override
    @SuppressWarnings("AssignmentToForLoopParameter")
    protected Void doInBackground () throws Exception
    {
        buscadorTopico = new C_TxtTopico(laudo.getPlanilha());
        if (!isCancelled()) {
            txtTopico.setControlador(buscadorTopico);
        }
        String contexto = laudo.getModeloDeLaudo().getModeloDeLaudo().getVisao();
        String[] strCriacaoDosPaineis = contexto.replaceAll("\n", "").split("##");
        CriadorDePainel cp;
        if (laudo.getModeloDeLaudo().getModeloDeLaudo().getCodigo() == ModeloDeLaudo.DIVERSOS)
        {
            cp = new CriadorDePainelDiversos();
        }
        else
        {
            cp = new CriadorDePainelGeral();
        }
        for (int i = 0; i < strCriacaoDosPaineis.length; i++)
        {
            String strPnl = strCriacaoDosPaineis[i];
            try
            {
                publish(cp.criarPainel(strPnl));
            }
            // pode acontecer devido a um erro de concorrencia no nimbus
            // nesse caso apenas tento criar o painel novamente
            catch (ClassCastException e)
            {
                i--;
            }
        }

        viewTerminouDeSerCriado = true;
        return null;
    }

    @Override
    protected void done ()
    {
        if (showViewIsScheduled)
        {
            showViewNow();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Public">

    public void showView ()
    {
        showViewEnabled = true;
        if (viewTerminouDeSerCriado)
        {
            showViewNow();
        }
        else
        {
            showViewIsScheduled = true;
        }
    }

    public void cancelarShowView ()
    {
        showViewIsScheduled = false;
        showViewEnabled = false;
    }

    public void cancelar (boolean mayInterruptIfRunning)
    {
        if (mayInterruptIfRunning)
        {
            cancel(true);
        }
        else
        {
            naoAddPnlNoMetodoProcess = true;
            cancel(false);
        }
    }

    public Laudo getLaudo ()
    {
        return laudo;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Private stuff - parser">

    private String tratarCmdContraintSubContainer (String str)
    {
        if (str.contains(";;"))
        {
            return str.substring(str.indexOf(";;") + 2);
        }
        else
        {
            return "";
        }
    }

    private int getActionCp (String cmdTotal) throws Exception
    {
        String[] split = cmdTotal.split(";;", -1);
        String cmdDeDecisao = split[0];
        if (cmdDeDecisao.matches("\\Q->\\E[0-9]+"))
        {
            // criar subcontainer
            String apenasNumero = cmdDeDecisao.replaceAll("\\Q->\\E", "");
            return Integer.valueOf(apenasNumero);
        }
        else if (cmdDeDecisao.matches("[0-9]+"))
        {
            // add no subcontainer
            return Integer.valueOf(cmdDeDecisao) * -1;
        }
        else
        {
            // add no pnlTopico
            return 0;
        }
    }

    private void configConstraint (GridBagConstraints c, String cmd) throws Exception
    {
        if (cmd.isEmpty())
        {
            return;
        }
        String[] constKeyAndValue = cmd.split(";;");
        for (int i = 0; i < constKeyAndValue.length; i++)
        {
            String[] constKeyAndValueSplit = constKeyAndValue[i].split("=");
            String constKey = constKeyAndValueSplit[0];
            String constValue = constKeyAndValueSplit[1];
            switch (constKey)
            {
                case "gridx":
                    c.gridx = Integer.valueOf(constValue);
                    break;
                case "gridy":
                    c.gridy = Integer.valueOf(constValue);
                    break;
                case "weightx":
                    c.weightx = Double.valueOf(constValue);
                    break;
                case "weighty":
                    c.weighty = Double.valueOf(constValue);
                    break;
                case "gridwidth":
                    c.gridwidth = Integer.valueOf(constValue);
                    break;
                case "gridheight":
                    c.gridheight = Integer.valueOf(constValue);
                    break;
                case "bottom_insets":
                    c.insets.bottom = Integer.valueOf(constValue);
                    break;
                case "top_insets":
                    c.insets.top = Integer.valueOf(constValue);
                    break;
                case "left_insets":
                    c.insets.left = Integer.valueOf(constValue);
                    break;
                case "right_insets":
                    c.insets.right = Integer.valueOf(constValue);
                    break;
                case "anchor":
                    c.anchor = Integer.valueOf(constValue);
                    break;
                case "fill":
                    c.fill = Integer.valueOf(constValue);
                    break;
                default:
                    throw new Exception("Constraint unexpected: " + constKey);
            }
        }
    }

    private boolean componentePodeReceberFoco (Component cp)
    {
        if (cp instanceof TxtHtmlLaudo)
        {
            return true;
        }
        if (cp instanceof JTextComponent && cp.isFocusable())// && cp.isEnabled())
        {
            return true;
        }
        if (cp instanceof PnlComp)
        {
            Component comp = ((PnlComp) cp).getComp();
            return componentePodeReceberFoco(comp);
        }
        return false;
    }

    // </editor-fold>

    private void showViewNow ()
    {
        if (showViewEnabled)
        {
            txtTopico.setControlador(buscadorTopico);
            Iterator<Map.Entry<String, MyJScrollPane>> it = paineis.entrySet().iterator();
            indexAtual = 0;
            initialSelCard = 0;
            while (it.hasNext() && showViewEnabled)
            {
                Map.Entry<String, MyJScrollPane> entry = it.next();
                String cardId = entry.getKey();
                pnlTopicos.addCard(entry.getValue(), cardId);
                setSelCardIfNeeded(cardId.split(";;"));
            }
        }
        else
        {
        }
    }

    private void setSelCardIfNeeded (String[] dadosDoTopico)
    {
        if (indexAtual == 0 && dadosDoTopico.length == 3)
        {
            initialSelCard = Integer.valueOf(dadosDoTopico[2]);
        }
        if (indexAtual == initialSelCard)
        {
            buscadorTopico.setSelectedModel(dadosDoTopico[1]);
            initialCardSel = true;
            mediador.mostrandoPrimeiraTelaDoMdl();
        }
        indexAtual++;
    }

    private JPanel criarPnlCidExe ()
    {

        final TxtCid txtCid = new TxtCid();
        txtExec = new TxtExec(txtCid);

        MyJPanel pnl = new MyJPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;

//        pnl.add(new PnlComp("CID resultado do exame", false, false).setComponent(txtCid), c);
        pnl.add(Box.createHorizontalBox(), c);
        c.gridx = 1;
        BtnFKey btnBuscaCid = new BtnFKey();
        btnBuscaCid.setFocusable(false);
        btnBuscaCid.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_CID10,
                new TelaSolPadrao(TelaPrincipal.LAUDO_E_CAPTURA, txtCid,
                                  new ReceptorDeBusca() {
            @Override
            public boolean isHabilitadoParaReceber ()
            {
                return true;
            }

            @Override
            public void receberBusca (Object o)
            {
                if (o != null && o instanceof SubcategoriaCID10)
                {
                    txtExec.requestFocusInWindow();
                    buscadorCid.setSelectedModel((SubcategoriaCID10)o);
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {
                        @Override
                        public void run ()
                        {
                            txtCid.requestFocusInWindow();
                        }

                    });
                }
            }

        })));
//        pnl.add(new PnlComp("", true, false).setComponent(btnBuscaCid), c);
        pnl.add(Box.createHorizontalBox(), c);

        c.gridy = 0;
        c.gridx = 0;
        pnl.add(new PnlComp("Médico executante", false, true).
                setComponent(txtExec), c);

        c.gridx = 1;
        BtnFKey btnBuscaExec = new BtnFKey();
        btnBuscaExec.setFocusable(false);
        btnBuscaExec.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_EXECUTANTES,
                new TelaSolPadrao(TelaPrincipal.LAUDO_E_CAPTURA, txtExec,
                                  new ReceptorDeBusca(){
            @Override
            public boolean isHabilitadoParaReceber ()
            {
                return true;
            }

            @Override
            public void receberBusca (Object o)
            {
                if (o != null && o instanceof ProfExecutante)
                {
                    txtCid.requestFocusInWindow();
                    buscadorExec.setSelectedModel((ProfExecutante)o);
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {
                        @Override
                        public void run ()
                        {
                            txtExec.requestFocusInWindow();
                        }

                    });
                }
            }

        })));
        pnl.add(new PnlComp("", true, true).setComponent(btnBuscaExec), c);

        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1d;
        pnl.add(Box.createHorizontalStrut(400), c);

        c.gridx = 2;
        c.weightx = 1d;
        pnl.add(Box.createHorizontalStrut(0), c);

        buscadorCid.setSelectedModel(laudo.getCidResultadoDoExame());
        buscadorExec.setSelectedModel(laudo.getProcDoAtd().getProfExecutante());

        return new PnlComEspacoDoCartao(pnl) {

            @Override
            Component focusComp ()
            {
//                if (selecionarTxtExec)
//                {
//                    selecionarTxtExec = false;
                    return txtExec;
//                }
//                else
//                {
//                    return txtCid;
//                }
            }

        };

    }

    public void irParaExec ()
    {
        if (buscadorTopico == null)
        {
        }
        else
        {
            selecionarTxtExec = true;
            buscadorTopico.irParaExec ();
        }
    }

    private ViewCampoDoLaudo getView (CampoDoLaudo cdl)
    {
        if (cdl instanceof Composite)
        {
            Composite c = (Composite) cdl;
            for (CampoDoLaudo campoFilho : c.getProle())
            {
                ViewCampoDoLaudo view = getView(campoFilho);
                if (view != null)
                {
                    return view;
                }
            }
        }
        return cdl.getView();
    }

    @SuppressWarnings("NestedAssignment")
    public void irParaTopico (CampoDoLaudo cdl)
    {
        final ViewCampoDoLaudo view;
        if (buscadorTopico == null || ((view = getView(cdl)) == null))
        {
        }
        else
        {
            PnlDoTopico pnlTopico = SwingUtils.getParent((Component)view, PnlDoTopico.class);
            if (pnlTopico == null)
            {
            }
            else
            {
                for (Map.Entry<String, MyJScrollPane> entry : paineis.entrySet())
                {
                    String cardId = entry.getKey();
                    MyJScrollPane scrp = entry.getValue();
                    if (scrp == SwingUtils.getParent(pnlTopico, MyJScrollPane.class))
                    {
                        buscadorTopico.setSelectedCard(cardId);
                        java.awt.EventQueue.invokeLater(new Runnable()
                        {
                            @Override
                            public void run ()
                            {
                                view.requestFocusInWindow();
                            }

                        });
                        break;
                    }
                }
            }
        }
    }

    private abstract class PnlComEspacoDoCartao extends PnlComEspaco
    {

        private PnlComEspacoDoCartao (Component jc)
        {
            super(jc);
        }

        @Override
        public boolean requestFocusInWindow ()
        {
            return focusComp().requestFocusInWindow();
        }

        abstract Component focusComp ();

    }

    private class TxtCid extends TxtComAutoCompletar
    {

        private TxtCid ()
        {
            super(buscadorCid);
            setLargura(2.24d);
            addAutoCompletarListener(new AutoCompletarListener()
            {
                @Override
                public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
                {
                    laudo.setCidResultadoDoExame(buscadorCid.getSelectedModel());
                }

            });
            addKeyListener(new EnterEnviaTab(false));
            setStrictMatching(true);
            setMensagemDeErro("CID não encontrado!");
            setMaxVisibleRows(10);
        }

        @Override
        protected void mouseClicked ()
        {
            RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
        }

        @Override
        protected void keyPressed (KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_UP:
                    if (getPopup().isShowing())
                    {
                        super.keyPressed(evt);
                    }
                    break;
                default:
                    super.keyPressed(evt);
            }
        }

        @Override
        protected void keyReleased (KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_DOWN:
                    if (getPopup().isShowing())
                    {
                        super.keyReleased(evt);
                    }
                    else
                    {
                        RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (getPopup().isShowing())
                    {
                        super.keyReleased(evt);
                    }
                    else
                    {
                        txtTopico.getControlador().anterior();
                    }
                    break;
                default:
                    super.keyReleased(evt);
            }
        }

    }

    private class TxtExec extends TxtComAutoCompletar
    {

        private final TxtCid txtCid;

        private TxtExec (TxtCid txtCid)
        {
            super(buscadorExec);
            this.txtCid = txtCid;
            addAutoCompletarListener(new AutoCompletarListener()
            {
                @Override
                public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
                {
                    laudo.getProcDoAtd().setProfExecutante(
                            buscadorExec.getSelectedModel());
                }

            });
            setStrictMatching(true);
            setMensagemDeErro("Médico executante não encontrado!");
        }

        @Override
        protected void mouseClicked ()
        {
//            imprimirLaudo();
        }

        private void imprimirLaudo ()
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    if (buscadorExec.getSelectedModel() == null)
                    {
                    }
                    else
                    {
                        mediador.imprimirApenasLaudo();
                    }
                }

            });
        }

        @Override
        protected void keyPressed (KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    if (getPopup().isShowing())
                    {
                        super.keyPressed(evt);
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    imprimirLaudo();
                    break;
                default:
                    super.keyPressed(evt);
            }
        }

        @Override
        protected void keyReleased (KeyEvent evt)
        {
            switch (evt.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    if (getPopup().isShowing())
                    {
                        super.keyReleased(evt);
                    }
                    else
                    {
                        txtCid.requestFocusInWindow();
                    }
                    break;
                default:
                    super.keyReleased(evt);
            }
        }

    }

    private class MeuScrpPane extends MyJScrollPane
    {

        private Component view;

        private MeuScrpPane (Component view)
        {
            super(view);
            this.view = view;
        }

        @Override
        public boolean requestFocusInWindow ()
        {
            return view.requestFocusInWindow();
        }

    }

    private abstract class CriadorDePainel
    {
        private String criarPainel (String strPnl) throws Exception
        {
            if (strPnl.matches("[0-9]+"))
            {
                paineis.put(strPnl, new MeuScrpPane(criarPnlCidExe()));
                return strPnl;
            }
            String[] comandosDoPnl = strPnl.split("\\Q$$\\E");
            comandosDoPnl[0] = getComand0(comandosDoPnl[0]);
            final PnlDoTopico pnlTopico = new PnlDoTopico(buscadorTopico, SwViewLaudo.this);
            boolean focusCpEhNull = true;
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 0;
            Map<Integer, Container> subContainers = new HashMap<>();
            for (int i = 1; i < comandosDoPnl.length; i++)
            {
                // comandosDoComp.length = 4
                String[] comandosDoComp = comandosDoPnl[i].split("\\Q||\\E", -1);
                ComponentFactory cd = new ComponentFactory(comandosDoComp[0],
                                                           laudo.getPlanilha(), subContainers);
                Component cp = cd.criarComponente(
                        comandosDoComp[1].split(";;", -1),
                        comandosDoComp[2].split(";;", -1));
                if (focusCpEhNull && componentePodeReceberFoco(cp))
                {

                        pnlTopico.setFocusCp(cp);
                        focusCpEhNull = false;

                }
                int actionCp = getActionCp(comandosDoComp[3]);
                if (actionCp == 0)
                {
                    configConstraint(c, comandosDoComp[3]);
                    pnlTopico.add(cp, c);
                }
                else if (actionCp > 0)
                {
                    subContainers.put(actionCp, (Container) cp);
                }
                else
                {
                    configConstraint(c, tratarCmdContraintSubContainer(comandosDoComp[3]));
                    subContainers.get(actionCp * -1).add(cp, c);
                }
            }
            paineis.put(comandosDoPnl[0], new MeuScrpPane(
                    new PnlComEspacoDoCartao(pnlTopico)
                    {

                        @Override
                        Component focusComp ()
                        {
                            return pnlTopico;
                        }

                    }));

            return comandosDoPnl[0];
        }

        abstract String getComand0 (String cmd0) throws Exception;

    }

    private class CriadorDePainelDiversos extends CriadorDePainel
    {

        String getComand0 (String cmd0) throws Exception
        {
            String resposta = cmd0;
            Matcher matcher = Pattern.compile("[0-9]+\\Q;;{desc}\\E").matcher(cmd0);
            while (matcher.find())
            {
                String group = matcher.group();
                int codigo = Integer.valueOf(group.substring(0, group.indexOf(';')));
                String replace = codigo + ";;" + ((Topico) laudo.getPlanilha().
                                                  getCampo(codigo)).getDescricao();
                resposta = resposta.replace(group, replace);
            }
            return resposta;
        }

    }

    private class CriadorDePainelGeral extends CriadorDePainel
    {

        String getComand0 (String cmd0) throws Exception
        {
            return cmd0;
        }

    }

}
