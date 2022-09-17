/*
 * DlgInfoAtd.java
 *
 * Created on 30/05/2012, 09:43:18
 */
package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgInfoAtd extends MyJDialog
{

    private static DlgInfoAtd singleton;
    private static MeuSw meuSw;

    private DlgInfoAtd ()
    {
        super(PnlLaudoeCia.getInstance(), true, 600, 435);
        setIconImage(FormPrincipal.getInstance().getIconImage());
        initComponents();
    }

    public static DlgInfoAtd getInstance ()
    {
        if (singleton == null)
        {
            singleton = new DlgInfoAtd();
            singleton.setTitle("Informações do atendimento");
        }
        if (!(meuSw == null || meuSw.isDone()))
        {
            meuSw.cancel(true);
        }
        meuSw = new MeuSw(false);
        meuSw.execute();
        return singleton;
    }

    private void initComponents ()
    {

        // <editor-fold defaultstate="collapsed" desc="PnlPaciente">

        {
            GridBagConstraints c = new GridBagConstraints();
            c.weightx = 0.6;
            c.fill = GridBagConstraints.BOTH;
            PnlComp pnlNome = new PnlComp("Nome", false, false).setComponent(lblNome);
            pnlNome.setBackground(Color.white);
            pnlPaciente.add(pnlNome, c);
            c.gridy = 1;
            PnlComp pnlIdade = new PnlComp("Idade Óssea", false, true).setComponent(lblIdadeOssea);
            pnlIdade.setBackground(Color.white);
            pnlPaciente.add(pnlIdade, c);
            c.gridx = 1;
            c.gridy = 0;
            c.weightx = 0.4;
            PnlComp pnlSexo = new PnlComp("Sexo", true, false).setComponent(lblSexo);
            pnlSexo.setBackground(Color.white);
            pnlPaciente.add(pnlSexo, c);
            c.gridy = 1;
            PnlComp pnlConv = new PnlComp("Convênio", true, true).setComponent(lblConvenio);
            pnlConv.setBackground(Color.white);
            pnlPaciente.add(pnlConv, c);
        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PnlPrincipal">

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.insets.left = 5;
        pnlPrincipal.add(lblCodAtd, c);
        c.gridx = 2;
        c.gridwidth = 1;
        c.insets.left = 0;
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.NONE;
        pnlPrincipal.add(lblIcon, c);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.gridy = 1;
        c.gridx = 0;
        pnlPrincipal.add(new PnlComp("Informações do Paciente", false, true)
                .setComponent(pnlPaciente), c);
        c.gridy = 2;
        pnlProcAtd.add(lblProcAtd, BorderLayout.CENTER);
        MyJScrollPane scrpProcs = new MyJScrollPane(pnlProcAtd);
        scrpProcs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrpProcs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrpProcs.setPreferredSize(new Dimension(0, 85));
        scrpProcs.setMinimumSize(new Dimension(0, 85));
        scrpProcs.setMaximumSize(new Dimension(10000, 85));
        scrpProcs.setBorder(etchedBorder);
        pnlPrincipal.add(new PnlComp("Procedimentos", false, true).setComponent(scrpProcs), c);
        c.gridy = 3;
        scrpObs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrpObs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrpObs.setPreferredSize(new Dimension(0, 58));
        scrpObs.setMinimumSize(new Dimension(0, 58));
        scrpObs.setMaximumSize(new Dimension(10000, 58));
        pnlPrincipal.add(new PnlComp("Observações", false, true).setComponent(scrpObs), c);
        c.gridy = 4;
        c.gridwidth = 1;
        pnlPrincipal.add(new PnlComp(false, true, true).setComponent(lblGravaVideo), c);
        c.gridx = 1;
        c.weightx = 1;
        pnlPrincipal.add(Box.createHorizontalStrut(0), c);
        c.gridx = 2;
        c.weightx = 0;
        c.insets.top = 5;
        pnlPrincipal.add(btnOk, c);
        c.weighty = 1;
        c.insets.top = 0;
        c.gridy = 5;
        pnlPrincipal.add(Box.createHorizontalStrut(0), c);

        // </editor-fold>

        setLayout(new BorderLayout());
        add(pnlPrincipal, BorderLayout.CENTER);

    }

    //<editor-fold defaultstate="collapsed" desc="Components">

    private MyJPanel pnlPrincipal = new MyJPanel(new GridBagLayout());
    private LblNegrito lblCodAtd = new LblNegrito();
    private LblNegrito lblIcon = new LblNegrito();
    private MyJPanel pnlPaciente = new MyJPanel(new GridBagLayout());
    private MyJPanel pnlProcAtd = new MyJPanel(new BorderLayout());
    private MyJLabel lblNome = new MyJLabel();
    private MyJLabel lblIdadeOssea = new MyJLabel();
    private MyJLabel lblSexo = new MyJLabel();
    private MyJLabel lblConvenio = new MyJLabel();
    private MyJLabel lblProcAtd = new MyJLabel();
    private MyJTextArea txtObs = new MyJTextArea();
    private MyJScrollPane scrpObs = new MyJScrollPane(txtObs);
    private MyJLabel lblGravaVideo = new MyJLabel();
    private static MyJButton btnOk = new MyJButton();
    private EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
    private EtchedBorder etchedBorder = new EtchedBorder();

    {

        lblNome.setBackground(Color.white);
        lblIdadeOssea.setBackground(Color.white);
        lblSexo.setBackground(Color.white);
        lblConvenio.setBackground(Color.white);

        lblGravaVideo.setForeground(Color.red);

        pnlPrincipal.setBorder(new EmptyBorder(0, 5, 0, 5));
        pnlPaciente.setBorder(new CompoundBorder(etchedBorder, emptyBorder));
        pnlPaciente.setBackground(Color.white);
        pnlProcAtd.setBorder(emptyBorder);
        pnlProcAtd.setBackground(Color.white);

        scrpObs.setBorder(etchedBorder);
        txtObs.setFocusable(false);

        lblProcAtd.setVerticalAlignment(SwingConstants.TOP);
        lblProcAtd.setBackground(Color.white);
        lblIcon.setIcon(SwingLibResources.getIcon(Imagens.INFO));

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                fechar();
            }

        });

        txtObs.setEditable(false);

    }

    //</editor-fold>

    public void setAtendimento (Atendimento atd)
    {
        if (atd == null)
        {
        }
        else
        {
            lblCodAtd.setText("<html><font size='5'>Atendimento " +
                             atd.getCodigo() + "</font></html>");
            lblNome.setText(" " + atd.getPaciente().getNome());
            lblIdadeOssea.setText(" " + atd.getPaciente().getIdadeOssea());
            lblSexo.setText(" " + atd.getPaciente().getSexo().getDescricao());
            lblConvenio.setText(" " + atd.getConvenio().getNome());
            lblProcAtd.setText(criarStrProcedimentos(atd));
            txtObs.setText(atd.getObservacoes());
            if (atd.isGravarExame())
            {
                lblGravaVideo.setText("GRAVAR PROCEDIMENTO(S) EM VÍDEO");
            }
            else
            {
                lblGravaVideo.setText("");
            }
        }
    }

    private String criarStrProcedimentos (Atendimento atd)
    {
        String resposta = "<html>";
        List<ProcDoAtd> procedimentos = atd.getProcedimentos();
        for (int i = 0; i < procedimentos.size(); i++)
        {
            resposta += "&bull; " + procedimentos.get(i).toString() + "<BR>";
        }
        resposta += "</html>";
        return resposta;
    }

    @Override
    public void fechar ()
    {
        if (btnOk.isEnabled())
        {
            dispose();
        }
    }

    private static class MeuSw extends SwingWorker<Void, String>
    {

        private boolean allowDelay;

        private MeuSw (boolean allowDelay)
        {
            if (this.allowDelay = allowDelay)
            {
                btnOk.setEnabled(false);
                btnOk.setText("Aguarde 3...");
                btnOk.setIcon(null);
            }
            else
            {
            }
        }

        @Override
        protected void process (List<String> chunks)
        {
            btnOk.setText(chunks.get(0));
        }

        @Override
        @SuppressWarnings("SleepWhileInLoop")
        protected Void doInBackground () throws Exception
        {
            if (allowDelay)
            {
                Thread.sleep(1000);
                for (int i = 2; i > 0; i--)
                {
                    publish("Aguarde " + i + "...");
                    Thread.sleep(1000);
                }
            }
            return null;
        }

        @Override
        protected void done ()
        {
            btnOk.setText("OK");
            btnOk.setIcon(SwingLibResources.getIcon(Imagens.OK));
            btnOk.setEnabled(true);
            btnOk.requestFocusInWindow();
        }

    }

}
