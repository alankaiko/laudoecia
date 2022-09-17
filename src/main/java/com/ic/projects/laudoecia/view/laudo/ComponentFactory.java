/*
 * ComponentFactory.java
 *
 * Created on 21/06/2012, 14:36:27
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.Planilha;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.lib.java.utils.StringUtils;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class ComponentFactory
{

    // <editor-fold defaultstate="collapsed" desc="Flags">

    static final int DEFAULT_VISITOR = 0;
    static final int HIDING_COMPONENT_VISITOR = 1;
    static final int DEFAULT_UNEDITABLE_COMPONENT_VISITOR = 2;
    static final int DEFAULT_HIGHLIGHTED_COMPONENT_VISITOR = 3;

    // </editor-fold>

    private CompCreator compCreator;
    private Planilha planilha;
    private Map<Integer, Container> subContainers;

    ComponentFactory (String desc, Planilha planilha, Map<Integer, Container> subContainers) throws Exception
    {
        this.planilha = planilha;
        this.subContainers = subContainers;
        switch (desc)
        {
            case "cdl":
                compCreator = new CompDoCdlCreator();
                break;
            case "pc":
                compCreator = new PnlCompCreator();
                break;
            case "hs":
                compCreator = new HorizontalBoxCreator();
                break;
            case "vs":
                compCreator = new VerticalBoxCreator();
                break;
            case "lbln":
                compCreator = new LabelCreator(true);
                break;
            case "lbl":
                compCreator = new LabelCreator(false);
                break;
            case "subpnl":
                compCreator = new SubPanelCreator();
                break;
            case "subcont":
                compCreator = new SubContainersCreator();
                break;
            case "txt":
                compCreator = new TextFieldCreator();
                break;
            case "btn":
                compCreator = new ButtonCreator();
                break;
            default:
                throw new Exception("Tipo de componente desconhecido: " + desc);
        }
    }

    Component criarComponente (String[] paramsCriacao, String[] metodos) throws Exception
    {
        return compCreator.createComp(paramsCriacao, metodos);
    }

    private interface CompCreator
    {

        Component createComp (String[] paramsCriacao, String[] metodos) throws Exception;

    }

    private class TextFieldCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            MyJTextField txt;
            switch (paramsCriacao.length)
            {
                case 0:
                    txt = new MyJTextField();
                    break;
                case 1:
                    txt = new MyJTextField(paramsCriacao[0]);
                    break;
                default:
                    throw new Exception("ParamsCriacao do txt desconhecido.");
            }
            txt.setEnabled(false);
            txt.setFocusable(false);
            return txt;
        }

    }

    private class CompDoCdlCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            if (paramsCriacao.length >= 1 && metodos.length >= 1)
            {
                Component cp;
                if (metodos[0] == null || metodos[0].isEmpty())
                {
                    cp = criarComponent(getVisitor(DEFAULT_VISITOR),
                                             Integer.valueOf(paramsCriacao[0]));
                }
                else
                {
                    cp = criarComponent(getVisitor(Integer.valueOf(
                            metodos[0])), Integer.valueOf(paramsCriacao[0]));
                }
                return cp;
            }
            else
            {
                throw new IllegalArgumentException("Parâmetros de criação do "
                        + "cdl inesperados!");
            }
        }

        private Component criarComponent (ViewCdlVisitor visitor, int index) throws Exception
        {
            CampoDoLaudo cdl = planilha.getCampo(index);
            if (cdl == null)
            {
                throw new Exception("Campo do laudo não encontrado: " + String.valueOf(index));
            }
            cdl.accept(visitor);
            Component cp = visitor.getComponentCriado();
            if (cp == null)
            {
                throw new Exception("Não foi possível criar o componente do campo do laudo!");
            }
            return cp;
        }

        private ViewCdlVisitor getVisitor (int visitorId) throws Exception
        {
            switch (visitorId)
            {
                case DEFAULT_VISITOR:
                    return new DefaultCdlVisitor(false, true, false);
                case HIDING_COMPONENT_VISITOR:
                    return new DefaultCdlVisitor(true, true, false);
                case DEFAULT_UNEDITABLE_COMPONENT_VISITOR:
                    return new DefaultCdlVisitor(false, false, false);
                case DEFAULT_HIGHLIGHTED_COMPONENT_VISITOR:
                    return new DefaultCdlVisitor(false, false, true);
                default:
                    throw new Exception("Tipo de visitor desconhecido!");
            }
        }

    }

    private class ButtonCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            final BtnLaudo btn;
            switch (paramsCriacao.length)
            {
                case 0:
                    btn = new BtnLaudo();
                    break;
                case 1:
                    btn = new BtnLaudo(paramsCriacao[0]);
                    break;
                default:
                    throw new Exception("ParamsCriacao do jbutton desconhecido.");
            }
            for (int i = 0; i < metodos.length; i++)
            {
                String metodo = metodos[i];
                if (metodo == null || metodo.isEmpty())
                {
                }
                else
                {
                    String[] descEParam = metodo.split("=");
outer:              switch (descEParam[0])
                    {
                        case "action":
inner:                      switch (descEParam[1])
                            {
                                case "tn":
                                    btn.addActionListener(new
                                            ActionTotalmenteNormal(btn));
                                    btn.setFocusable(false);
                                    btn.setBackground(Color.YELLOW);
                                    break outer;
                                default:
                                    throw new Exception("Action desconhecido para o jbutton");
                            }
                        default:
                            throw new Exception("Metodo desconhecido para o jbutton");
                    }
                }
            }
            return btn;
        }

    }

    private class LabelCreator implements CompCreator
    {

        private boolean negrito;

        private LabelCreator (boolean negrito)
        {
            this.negrito = negrito;
        }

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            MyJLabel lbl;
            switch (paramsCriacao.length)
            {
                case 0:
                    lbl = negrito ? new LblNegrito() : new MyJLabel();
                    break;
                case 1:
                    lbl = negrito ? new LblNegrito(paramsCriacao[0])
                                  : new MyJLabel(paramsCriacao[0]);
                    break;
                default:
                    throw new Exception("ParamsCriacao do lbl desconhecido.");
            }
            invocarMetodos(lbl, metodos);
            return lbl;
        }

        private void invocarMetodos (JLabel lbl, String[] metodos) throws Exception
        {
            for (int i = 0; i < metodos.length; i++)
            {
                String metodo = metodos[i];
                if (metodo == null || metodo.isEmpty())
                {
                }
                else
                {
                    String[] descEParams = metodo.split("=");
                    switch (descEParams[0])
                    {
                        case "cor":
                            String[] rgb = descEParams[1].split(",");
                            int[] rgbInt = new int[3];
                            rgbInt[0] = Integer.valueOf(rgb[0]);
                            rgbInt[1] = Integer.valueOf(rgb[1]);
                            rgbInt[2] = Integer.valueOf(rgb[2]);
                            lbl.setForeground(new Color(rgbInt[0], rgbInt[1], rgbInt[2]));
                            break;
                        case "fonte":
                            String tam = descEParams[1];
                            if (StringUtils.parseableToDouble(tam, true))
                            {
                                lbl.setFont(lbl.getFont().deriveFont(Float.valueOf(tam)));
                            }
                            break;
                        default:
                            throw new Exception("Metodo desconhecido para o label");
                    }
                }
            }
        }

    }

    private class PnlCompCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacaoDoPnlComp, String[] metodos) throws Exception
        {
            final PnlComp pnlComp = criarPnlComp(paramsCriacaoDoPnlComp);
            String[] cmdDoCompDoPnlComp = metodos[0].split("@", -1);
            ComponentFactory cf = new ComponentFactory(cmdDoCompDoPnlComp[0], planilha, subContainers);
            Component cp = cf.criarComponente(
                    cmdDoCompDoPnlComp[1].split(";;", -1),
                    cmdDoCompDoPnlComp[2].split(";;", -1));
            if (!cp.isVisible())
            {
                pnlComp.setVisible(false);
            }
            return pnlComp.setComponent(cp);
        }

        private PnlComp criarPnlComp (String[] paramsCriacao) throws Exception
        {
            switch (paramsCriacao.length)
            {
                case 0:
                    return new PnlComp();
                case 1:
                    return new PnlComp(paramsCriacao[0]);
                case 2:
                    if (isBoolean(paramsCriacao[0]) && isBoolean(paramsCriacao[1]))
                    {
                        return new PnlComp(getBoolean(paramsCriacao[0]),
                                getBoolean(paramsCriacao[1]));
                    }
                    else
                    {
                        return new PnlComp(paramsCriacao[0], Integer.valueOf(paramsCriacao[1]));
                    }
                case 3:
                    if (isBoolean(paramsCriacao[0]) &&
                            isBoolean(paramsCriacao[1]) && isBoolean(paramsCriacao[2]))
                    {
                        return new PnlComp(getBoolean(paramsCriacao[0]),
                                getBoolean(paramsCriacao[1]), getBoolean(paramsCriacao[2]));
                    }
                    else
                    {
                        return new PnlComp(paramsCriacao[0],
                                getBoolean(paramsCriacao[1]), getBoolean(paramsCriacao[2]));
                    }
                case 4:
                    return new PnlComp(paramsCriacao[0],
                            Integer.valueOf(paramsCriacao[1]),
                            getBoolean(paramsCriacao[2]), getBoolean(paramsCriacao[3]));
                case 5:
                    return new PnlComp(paramsCriacao[0], getBoolean(paramsCriacao[1]),
                            Integer.valueOf(paramsCriacao[2]),
                            getBoolean(paramsCriacao[3]), getBoolean(paramsCriacao[4]));
                default:
                    throw new AssertionError();
            }
        }

    }

    private class SubPanelCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            return new SubPanel();
        }

    }

    private class SubContainersCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            return subContainers.get(Integer.valueOf(paramsCriacao[0]));
        }

    }

    private class HorizontalBoxCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            return Box.createHorizontalStrut(Integer.valueOf(paramsCriacao[0]));
        }

    }

    private class VerticalBoxCreator implements CompCreator
    {

        @Override
        public Component createComp (String[] paramsCriacao, String[] metodos) throws Exception
        {
            return Box.createVerticalStrut(Integer.valueOf(paramsCriacao[0]));
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Private stuff">

    private boolean getBoolean (String str) throws Exception
    {
        if (isBoolean(str))
        {
            return "t".equals(str);
        }
        throw new Exception("String não pôde ser convertida em boolean");
    }

    private boolean isBoolean (String str)
    {
        return "f".equals(str) || "t".equals(str);
    }

    private class SubPanel extends MyJPanel
    {

        private SubPanel ()
        {
            super(new GridBagLayout());
            setBorder(new CompoundBorder(
                    new EtchedBorder(), new EmptyBorder(3, 3, 3, 3)));
        }

        @Override
        public boolean requestFocusInWindow ()
        {
            super.requestFocusInWindow();
            synchronized (getTreeLock())
            {
                for (int i = 0; i < getComponents().length; i++)
                {
                    Component component = getComponents()[i];
                    if (component.requestFocusInWindow())
                    {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    private class ActionTotalmenteNormal implements ActionListener
    {

        private Component cp;

        private ActionTotalmenteNormal (Component cp)
        {
            this.cp = cp;
        }

        @Override
        public void actionPerformed (ActionEvent e)
        {
            try
            {
                planilha.totalmenteNormal();
                PnlDoTopico pdt = SwingUtils.getParent(cp, PnlDoTopico.class);
                if (pdt == null)
                {
                }
                else
                {
                    pdt.irParaExec();
                }
            }
            catch (ErrosDeValidacao ex)
            {
                PnlLaudoeCia.getInstance().mostrarMsgErro(ex.getMessage());
                PnlDoTopico pdt = SwingUtils.getParent(
                        (Component)ex.getSource().getView(), PnlDoTopico.class);
                if (pdt == null)
                {
                }
                else
                {
                    pdt.irPara(ex.getSource());
                }
            }
        }

    }

    private class BtnLaudo extends MyJButton implements ViewCampoDoLaudo
    {

        private int focusLostStatus = ViewCampoDoLaudo.NONE;

        private BtnLaudo ()
        {
        }

        private BtnLaudo (String text)
        {
            super(text);
        }

        {
            addKeyListener(new UpAndDownArrowListener());
            addKeyListener(new TabKeyListener(this));
            setFocusTraversalKeysEnabled(false);
            addFocusListener(DefaultFocusList.getInstance());
        }

        @Override
        public String getValor ()
        {
            return null;
        }

        @Override
        public CampoDoLaudo getCampoDoLaudo ()
        {
            return null;
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

    }

    // </editor-fold>

}
