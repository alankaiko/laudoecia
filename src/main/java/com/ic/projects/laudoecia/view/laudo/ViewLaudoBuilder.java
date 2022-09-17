/*
 * ViewLaudoBuilder.java
 *
 * Created on 20/06/2012, 08:36:21
 */

package com.ic.projects.laudoecia.view.laudo;

import com.ic.projects.laudoecia.model.laudo.Planilha;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.PnlComEspaco;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ViewLaudoBuilder extends SwingWorker<Void, String>
{

    private final Planilha planilha;
    private final PnlCartao pnlCartao;
    private final String contexto;
    private final Map<String, MyJPanel> paineisDosTopicos = new HashMap<>();

    public ViewLaudoBuilder (Planilha planilha, PnlCartao pnlCartao, String contexto)
    {
        this.planilha = planilha;
        this.pnlCartao = pnlCartao;
        this.contexto = contexto;
    }
      
    @Override
    protected void process (List<String> chunks)
    {
        for (Iterator<String> it = chunks.iterator(); it.hasNext();)
        {
            String pnlId = it.next();
            pnlCartao.addCard(paineisDosTopicos.get(pnlId), pnlId);
        }
    }

    @Override
    protected Void doInBackground () throws Exception
    {
        String[] strCriacaoDosPaineis = contexto.replaceAll("\n", "").split("##");
        for (int i = 0; i < strCriacaoDosPaineis.length; i++)
        {
            String strPnl = strCriacaoDosPaineis[i];
            publish(criarPnl(strPnl));
        }
        return null;
    }

    @Override
    protected void done ()
    {
        try
        {
            get();
        }
        catch (ExecutionException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            // Process e here
        }
    }

    private String criarPnl (String strPnl) throws Exception
    {
        String[] comandosDoPnl = strPnl.split("\\Q$$\\E");
        MyJPanel pnlTopico = addNoMapa(comandosDoPnl[0]);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        Map<Integer, Container> subContainers = new HashMap<>();
        for (int i = 1; i < comandosDoPnl.length; i++)
        {
            // comandosDoComp.length = 4
            String[] comandosDoComp = comandosDoPnl[i].split("\\Q||\\E", -1);
            ComponentFactory cd = new ComponentFactory(comandosDoComp[0], planilha, subContainers);
            Component cp = cd.criarComponente(
                    comandosDoComp[1].split(";;", -1),
                    comandosDoComp[2].split(";;", -1));
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
        return comandosDoPnl[0];
    }

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

    private MyJPanel addNoMapa (String cmd) throws Exception
    {
        MyJPanel pnl = new MyJPanel(new GridBagLayout());
        paineisDosTopicos.put(cmd, new PnlComEspaco(pnl, 5, 5));
        return pnl;
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
                default:
                    throw new Exception("Constraint unexpected: " + constKey);
            }
        }
    }

}
