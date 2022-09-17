/*
 * TxtEnumeracao.java
 *
 * Created on 28/05/2012, 09:40:29
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudoListener;
import com.ic.projects.laudoecia.model.laudo.Enumeracao;
import com.ic.projects.laudoecia.model.laudo.EventoDoCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.lib.icontrol.autocompletar.AbsC_AutoCompletar;
import com.lib.iview.autocompletar.AcTableConfigurator;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.java.utils.StringUtils;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJTable;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.RobotImpl;
import com.lib.swing.utils.SwingUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;
import javax.swing.table.TableCellRenderer;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.EdgedBalloonStyle;
import net.java.balloontip.utils.FadingUtils;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class TxtEnumeracao extends TxtComAutoCompletar implements CampoDoLaudoListener,
                                                                  FocusListener,
                                                                  AutoCompletarListener,
                                                                  ViewCampoDoLaudo
{

    private Enumeracao enumeracao;
    private MeuControlador buscador = new MeuControlador();
    private boolean listValorHabilitado = true;
    private boolean listAutCompHabilitado = true;
    private boolean vincularVisible;
    private int focusLostStatus = ViewCampoDoLaudo.NONE;
    private int dismissDelay;
    private int initialDelay;

    @SuppressWarnings("LeakingThisInConstructor")
    TxtEnumeracao (Enumeracao enumeracao, boolean vincularVisible)
    {
        this.enumeracao = enumeracao;
        this.vincularVisible = vincularVisible;
        enumeracao.setView(this);
        enumeracao.adicionarListener(this);
        addFocusListener(this);
        addAutoCompletarListener(this);
        addKeyListener(new UpAndDownArrowListener());
        setControlador(buscador);
        setSelecionarPrimeiroAposBusca(false);
        setMaxVisibleRows(30);
        vincularHabilitado(enumeracao.isHabilitado());
        vincularValor(enumeracao.getValor());
        addFocusListener(new FocusLostStatusCleaner(this));
        setFocusTraversalKeysEnabled(false);
        setStrictMatching(true);
        setStrCnfEnabled(false);
        setKeyEventDelay(1);
    }

    @Override
    protected void keyPressed (KeyEvent evt)
    {
    }

    @Override
    protected void keyReleased (KeyEvent evt)
    {
        if (!isValidado() || evt.isConsumed())
        {
            return;
        }
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_9:
            case KeyEvent.VK_NUMPAD0:
            case KeyEvent.VK_NUMPAD1:
            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_NUMPAD5:
            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_NUMPAD7:
            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_NUMPAD9:
                if (setarOpcaoOk(getText(), false))
                {
                    RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
                    evt.consume();
                }
                break;
            case KeyEvent.VK_ENTER:
                RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
                evt.consume();
                break;
            case KeyEvent.VK_TAB:
                boolean trocarFoco;
                if (existeLinhaSelecionada())
                {
                    trocarFoco = true;
                }
                else
                {
                    String text = getText();
                    if (text == null || text.isEmpty())
                    {
                        if (evt.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK)
                        {
                            trocarFoco = true;
                        }
                        else if (enumeracao.isObrigatorio())
                        {
                            PnlLaudoeCia.getInstance().mostrarMsgErro(
                                    enumeracao.getMsgErroValidCampoObrig());
                            trocarFoco = false;
                        }
                        else
                        {
                            trocarFoco = true;
                        }
                    }
                    else
                    {
                        trocarFoco = setarOpcaoOk(text, true);
                        if (!trocarFoco)
                        {
                            // não pode ser mensagem de erro porque senão um evento
                            // focus lost seria gerado e a msg apareceria 2 vezes
                            MyJLabel lbl = new MyJLabel("Valor inconsistente!");
                            lbl.setForeground(Color.red);
                            BalloonTip b = new BalloonTip(this, lbl, getBalloonStyle(), false);
                            b.setVisible(true);
                            FadingUtils.fadeOutBalloon(b, new ActionListener()
                            {
                                @Override
                                public void actionPerformed (ActionEvent e)
                                {
                                }

                            }, 2000, 30);
                        }
                    }
                }
                if (trocarFoco)
                {
                    KeyboardFocusManager manager = KeyboardFocusManager.
                            getCurrentKeyboardFocusManager();
                    if (evt.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK)
                    {
                        setFocusLostStatus(ViewCampoDoLaudo.SHIFT_TAB);
                        manager.focusPreviousComponent();
                    }
                    else
                    {
                        setFocusLostStatus(ViewCampoDoLaudo.TAB);
                        manager.focusNextComponent();
                    }
                    evt.consume();
                }
                break;
            default:
        }
    }

    @Override
    public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
    {
        switch (evento.getTipo())
        {
            case EventoDoCampoDoLaudo.HABILITADO_MUDOU:
                vincularHabilitado((boolean) evento.getValorAtual());
                break;
            case EventoDoCampoDoLaudo.VALOR_MUDOU:
                vincularValor((String) evento.getValorAtual());
                break;
            default:
        }
    }

    @Override
    public void focusGained (FocusEvent e)
    {
        selectAll();
        autoCompletar();
        dismissDelay = ToolTipManager.sharedInstance().getDismissDelay();
        initialDelay = ToolTipManager.sharedInstance().getInitialDelay();
        ToolTipManager.sharedInstance().setDismissDelay(60000);
        ToolTipManager.sharedInstance().setInitialDelay(150);
    }

    @Override
    public void focusLost (FocusEvent e)
    {
        ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
        ToolTipManager.sharedInstance().setInitialDelay(initialDelay);
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                if (isInError())
                {
                    SwingUtils.mostrarMensagemDeErroConhecido(null, "Valor inconsistente!");
                    requestFocusInWindow();
                }
            }

        });
    }

    @Override
    protected void mouseClicked ()
    {
        RobotImpl.pressionarTecla(KeyEvent.VK_TAB);
    }

    @Override
    public void linhaSelecionadaMudou (Object[] oldLinhaSelecionada, Object[] newLinhaSelecionada)
    {
        if (listAutCompHabilitado)
        {
            try
            {
                listValorHabilitado = false;
                enumeracao.setValor(buscador.getSelectedModel());
                listValorHabilitado = true;
            }
            catch (ErrosDeValidacao ex)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this, ex.getMessage());
            }
        }
    }

    @Override
    public void setText (String texto)
    {
        super.setText(formatarOpcao(texto));
    }

    private void vincularHabilitado (boolean habilitado)
    {
        if (vincularVisible)
        {
            PnlComp pc = SwingUtils.getParent(TxtEnumeracao.this, PnlComp.class);
            if (pc == null)
            {
                setVisible(habilitado);
            }
            else
            {
                setVisible(true);
                pc.setVisible(habilitado);
            }
        }
        else
        {
            setEnabled(habilitado);
        }
    }

    private void vincularValor (String valor)
    {
        if (listValorHabilitado)
        {
            listAutCompHabilitado = false;
            buscador.setSelectedModel(valor);
            listAutCompHabilitado = true;
        }
    }

    private String formatarOpcao (String opcao)
    {
        if (opcao == null || opcao.isEmpty())
        {
            return "";
        }
        else if (opcao.length() == 1)
        {
            return opcao.toUpperCase();
        }
        else
        {
            return opcao.substring(0, 1).toUpperCase() + opcao.substring(1);
        }
    }

    private boolean setarOpcaoOk (String text, boolean doneEditing)
    {
        if (text == null || text.isEmpty())
        {
            return false;
        }
        else
        {
            String[] opcoes = enumeracao.getOpcoes();
            if (text.matches("[0-9]+"))
            {
                Integer numDigitado = Integer.valueOf(text);
                boolean comecarDoZero = enumeracao.comecarDoZero();
                // valida se o valor do txt nao deixa duvidas quanto ao item a
                // ser selecionado. Ex.: tem 11 itens e o texto eh 1
                if (!doneEditing && numDigitado <= (opcoes.length - 1) / 10 && numDigitado > 0)
                {
                    return false;
                }
                else if (comecarDoZero)
                {
                    if (numDigitado >= 0 && numDigitado < opcoes.length)
                    {
                        listValorHabilitado = false;
                        buscador.setSelectedModel(opcoes[numDigitado]);
                        listValorHabilitado = true;
                        return true;
                    }
                }
                else
                {
                    if (numDigitado > 0 && numDigitado < opcoes.length + 1)
                    {
                        listValorHabilitado = false;
                        buscador.setSelectedModel(opcoes[numDigitado - 1]);
                        listValorHabilitado = true;
                        return true;
                    }
                }
            }
            else
            {
                String textoSemAcentos = StringUtils.removerAcentos(text);
                for (int i = 0; i < opcoes.length; i++)
                {
                    String opcao = opcoes[i];
                    if (textoSemAcentos.equalsIgnoreCase(StringUtils.
                            removerAcentos(opcao)))
                    {
                        listValorHabilitado = false;
                        buscador.setSelectedModel(opcao);
                        listValorHabilitado = true;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public String getValor ()
    {
        return buscador.getSelectedModel();
    }

    @Override
    public CampoDoLaudo getCampoDoLaudo ()
    {
        return enumeracao;
    }

    @Override
    public int getFocusLostStatus ()
    {
        return focusLostStatus;
    }

    @Override
    public void setFocusLostStatus (int status)
    {
        focusLostStatus = status;
    }

    @Override
    protected MyJTable criarTabela ()
    {
        return new MyTable();
    }

    private EdgedBalloonStyle getBalloonStyle ()
    {
        return new EdgedBalloonStyle(new Color(255, 253, 245), new Color(64, 64, 64));
    }

    private class MyTable extends MyJTable
    {

        @Override
        public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int vColIndex)
        {
            Component cp = super.prepareRenderer(renderer, rowIndex, vColIndex);
            if (vColIndex == 1)
            {
                try
                {
                    String valor = enumeracao.previewGerarHtmlImpl(enumeracao.
                                     getOpcoes()[rowIndex], true);
                    if (valor == null || valor.trim().isEmpty())
                    {
                        valor = null;
                    }
                    else
                    {
                        valor = "<html>" + valor + "</html>";
                    }
                    ((JLabel) cp).setToolTipText(valor);
                }
                catch (ErrosDeValidacao ex)
                {
                    ((JLabel) cp).setToolTipText("<html><b>Erro: </b>"
                             + ex.getMessage() + "</html>");
                }
            }
            return cp;
        }

    }

    private class MeuControlador extends AbsC_AutoCompletar<String>
    {

        @Override
        protected String getModel (Object[] linha)
        {
            String[] opcoes = enumeracao.getOpcoes();
            for (int i = 0; i < opcoes.length; i++)
            {
                String opcao = opcoes[i];
                if (opcao.equalsIgnoreCase((String)linha[1]))
                {
                    return opcao;
                }
            }
            throw new AssertionError();
        }

        @Override
        protected Object[] getLinha (String model)
        {
            String[] opcoes = enumeracao.getOpcoes();
            for (int i = 0; i < opcoes.length; i++)
            {
                if (model.equalsIgnoreCase(opcoes[i]))
                {
                    if (enumeracao.comecarDoZero())
                    {
                        return new Object[] { i, model };
                    }
                    else
                    {
                        return new Object[] { i + 1, model };
                    }
                }
            }
            throw new AssertionError();
        }

        @Override
        public AcTableConfigurator getPropriedadesDaTabela ()
        {
            return new AcTableConfigurator() {

                @Override
                public int indexToUseAsTextFieldText ()
                {
                    return 1;
                }

                @Override
                public String[] columnsTitles ()
                {
                    return null;
                }

                @Override
                public Class<?>[] columnsClasses ()
                {
                    return new Class<?> [] { Integer.class, String.class };
                }

                @Override
                public int[] columnsWidths ()
                {
                    return new int [] { 25, 0 };
                }

                @Override
                public boolean[] shouldResizeColumns ()
                {
                    return new boolean [] { false, true };
                }

                @Override
                public int[] sortedColumns ()
                {
                    return new int [] { 0 };
                }

            };
        }

        @Override
        public List<Object[]> buscarCandidatos (String textoDaBusca)
        {
            String[] opcoes = enumeracao.getOpcoes();
            List<Object[]> resposta = new ArrayList<>();
            int correcaoIndex = enumeracao.comecarDoZero() ? 0 : 1;
            for (int index = 0; index < opcoes.length; index++)
            {
                String opcao = opcoes[index];
                resposta.add(new Object[] { index + correcaoIndex, formatarOpcao(opcao) } );
            }
            return resposta;
        }

    }

}
