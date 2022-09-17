/*
 * DlgModeloDeLaudoDoProc.java
 *
 * Created on 20/06/2012, 14:11:46
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProcMedico;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.view.laudo.TxtHtmlLaudo;
import com.lib.icontrol.autocompletar.AutoCompletarUtils;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.java.utils.StringUtils;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.BlackAndWhiteEtchedBorder;
import com.lib.swing.plus.utils.PnlCartao;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgModeloDeLaudoDoProc extends MyJDialog
{

    private boolean cancelado;
    private final ModeloDeLaudoDoProc mdl;
    private final C_EntidadeProcMedico controlador;

    public DlgModeloDeLaudoDoProc (Component cp, ModeloDeLaudoDoProc mdl
            , C_EntidadeProcMedico controlador)
    {
        super(cp, true, 800, 650);
        setTitle("Modelo de laudo do procedimento");
        if (mdl == null)
        {
            this.mdl = new ModeloDeLaudoDoProc(
                    new ModeloDeLaudo(ModeloDeLaudo.DIVERSOS));
        }
        else
        {
            this.mdl = mdl;
        }
        this.controlador = controlador;
        initComponents();
        mostrarDados();
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    public ModeloDeLaudoDoProc getModeloDeLaudo ()
    {
        return mdl;
    }

    @Override
    public void fechar ()
    {
        cancelado = true;
        dispose();
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private final String cartaoDescrito = "DESCRITO";
    private final String cartaoPlanilha = "PLANILHA";
    private final String cartaoTextoLivre = "LIVRE";

    private MyJTextField txtDescricao = new MyJTextField();
    private JRadioButton rbDescrito = new JRadioButton("Modelo com 3 tópicos");
    private JRadioButton rbPlanilha = new JRadioButton("Usar modelo existente");
    private JRadioButton rbTextoLivre = new JRadioButton("Texto livre");
    private MyJButton btnConfirmar = new MyJButton("Confirmar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");
    private final ScrollResultsDaBusca scrollModelos = new ScrollResultsDaBusca(
            new TableConfigurator() {

        @Override
        public String[] columnsTitles ()
        {
            return new String[] { "Modelo de tela" };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?> [] { ModeloDeLaudoDoProc.class } ;
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int [] { 0 } ;
        }

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean [] { true } ;
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int [] { 0 } ;
        }

    });
    private final PnlMdlDiversos pnlMdlDescrito = new PnlMdlDiversos();
    private final PnlMdlTextLivre pnlMdlTextoLivre = new PnlMdlTextLivre();
    private final PnlCartao pnlCartao = new PnlCartao();

    {

        txtDescricao.pintarDeAmarelo();

        ButtonGroup group = new ButtonGroup();
        group.add(rbDescrito);
        group.add(rbPlanilha);
        group.add(rbTextoLivre);

        ItemListener itemListRadioButton = new ItemListener() {

            @Override
            public void itemStateChanged (ItemEvent e)
            {
                paradigmaDeMdlMudou();
            }
        };
        rbDescrito.addItemListener(itemListRadioButton);
        rbPlanilha.addItemListener(itemListRadioButton);
        rbTextoLivre.addItemListener(itemListRadioButton);

        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction();
            }

        });
        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));

        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                fechar();
            }

        });

        MyJScrollPane scrpPnlDescrito = new MyJScrollPane(pnlMdlDescrito);
        scrpPnlDescrito.setBorder(new BlackAndWhiteEtchedBorder());
        MyJScrollPane scrpPnlTextoLivre = new MyJScrollPane(pnlMdlTextoLivre);
        scrpPnlTextoLivre.setBorder(new BlackAndWhiteEtchedBorder());
        pnlCartao.addCard(scrpPnlDescrito, cartaoDescrito);
        pnlCartao.addCard(scrollModelos, cartaoPlanilha);
        pnlCartao.addCard(scrpPnlTextoLivre, cartaoTextoLivre);

    }

    //</editor-fold>

    private void btnConfirmarAction ()
    {
        if (validarCampos())
        {
            cancelado = false;
            carregarDados();
            dispose();
        }
    }

    private void initComponents ()
    {

        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        pnl.add(new PnlComp("Descrição do modelo", false, false).setComponent(txtDescricao), c);

        c.gridy = 1;
        MyJPanel pnlRadioBtn = new MyJPanel(new GridLayout(1, 3));
        pnlRadioBtn.add(rbDescrito);
        pnlRadioBtn.add(rbTextoLivre);
        pnlRadioBtn.add(rbPlanilha);
        pnl.add(new PnlComp(false, true).setComponent(pnlRadioBtn), c);

        c.gridy = 2;
        c.weighty = 1;
        c.weightx = 1;
        pnl.add(new PnlComp(false, true).setComponent(pnlCartao), c);

        c.gridy = 3;
        c.weighty = 0;
        MyJPanel pnlBtn = new MyJPanel(new FlowLayout());
        pnlBtn.add(btnConfirmar);
        pnlBtn.add(btnCancelar);
        pnl.add(new PnlComp(false, false, false).setComponent(pnlBtn), c);

        setContentPane(new PnlComEspaco(pnl));

    }

    private boolean validarCampos ()
    {
        if (txtDescricao.getText().trim().isEmpty())
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "O campo descrição"
                                                            + " do modelo é obrigatório");
            txtDescricao.requestFocusInWindow();
            return false;
        }
        if (rbDescrito.isSelected())
        {
            if (StringUtils.textBetweenTags(pnlMdlDescrito.
                    getTxtDescLaudo().getHTML()).trim().isEmpty())
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this,
                                       "O campo descrição do laudo é obrigatório");
                return false;
            }
        }
        else if (rbPlanilha.isSelected())
        {
            if (scrollModelos.getSelectedResult() == null)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this,
                             "Escolha um modelo de tela!");
                return false;
            }
        }
        else if (rbTextoLivre.isSelected())
        {
        }
        else
        {
            return false;
        }
        return true;
    }

    private void mostrarDados ()
    {
        txtDescricao.setText(mdl.getDescricao());
        boolean mdlEhDiversos = mdl.getModeloDeLaudo().equals(
                new ModeloDeLaudo(ModeloDeLaudo.DIVERSOS));
        boolean mdlEhLivre = mdl.getModeloDeLaudo().equals(
                new ModeloDeLaudo(ModeloDeLaudo.TEXTO_LIVRE));
        boolean mdlEhPlanilha = !(mdlEhDiversos || mdlEhLivre);
        rbDescrito.setSelected(false);
        rbTextoLivre.setSelected(true);
        rbPlanilha.setSelected(false);
        ResultsGenerator rg = new ResultsGenerator()
        {
            @Override
            public List<Object[]> generateResults ()
            {
                List<ModeloDeLaudo> modelos = controlador.getModelosPlanilhados();
                return AutoCompletarUtils.converterLista(modelos);
            }

        };
        if (mdlEhDiversos)
        {
            mostrarDadosMdl3Topicos();
            scrollModelos.updateResultList(rg, -1);
        }
        else if (mdlEhLivre)
        {
            mostrarDadosTextoLivre();
            scrollModelos.updateResultList(rg, -1);
        }
        else if (mdlEhPlanilha)
        {
            scrollModelos.updateResultList(rg, -1, new Runnable() {

                @Override
                public void run ()
                {
                    scrollModelos.selecionarResultado(scrollModelos.getTabela().
                            convertRowIndexToView(((MyTableModel)
                            scrollModelos.getTabela().getModel()).
                            addResultado(new Object[] {mdl.getModeloDeLaudo()})));
                }
            });
        }
        else
        {
            // assertion error
        }
    }

    private void carregarDados ()
    {
        mdl.setDescricao(txtDescricao.getText());
        if (rbDescrito.isSelected())
        {
            mdl.setModeloDeLaudo(new ModeloDeLaudo(ModeloDeLaudo.DIVERSOS));
            mdl.getModeloDeLaudo().setNome("DIVERSOS");
            StringBuilder sb = new StringBuilder("");
            sb.append("2;;setValor;;");
            sb.append(pnlMdlDescrito.getTxtDescLaudo().getHTML());
            sb.append("$$\n");
            if (!StringUtils.textBetweenTags(pnlMdlDescrito.getTxtObsLaudo()
                    .getHTML()).trim().isEmpty())
            {
                sb.append("5;;setValor;;");
                sb.append(pnlMdlDescrito.getTxtObsLaudo().getHTML());
                sb.append("$$\n");
            }
            if (!StringUtils.textBetweenTags(pnlMdlDescrito.getTxtImpDiagLaudo()
                    .getHTML()).trim().isEmpty())
            {
                sb.append("8;;setValor;;");
                sb.append(pnlMdlDescrito.getTxtImpDiagLaudo().getHTML());
                sb.append("$$\n");
            }
            sb.append("0;;configurarDescricao;;");
            sb.append(pnlMdlDescrito.txtDesc.getText()).append("$$\n");
            sb.append("3;;configurarDescricao;;");
            sb.append(pnlMdlDescrito.txtObs.getText()).append("$$\n");
            mdl.setCustomString(sb.toString());
        }
        else if (rbTextoLivre.isSelected())
        {
            mdl.setModeloDeLaudo(new ModeloDeLaudo(ModeloDeLaudo.TEXTO_LIVRE));
            mdl.getModeloDeLaudo().setNome("TEXTO LIVRE");
            StringBuilder sb = new StringBuilder("");
            sb.append("2;;setValor;;");
            sb.append(pnlMdlTextoLivre.getTxtTextoLivre().getHTML());
            sb.append("$$\n");
            mdl.setCustomString(sb.toString());
        }
        else if (rbPlanilha.isSelected())
        {
            mdl.setModeloDeLaudo((ModeloDeLaudo)scrollModelos.getSelectedResult()[0]);
            mdl.setCustomString("");
        }
        else
        {
            // assertion error
        }
    }

    private void paradigmaDeMdlMudou ()
    {
        if (rbDescrito.isSelected())
        {
            pnlCartao.setSelectedCard(cartaoDescrito, false);
        }
        else if (rbPlanilha.isSelected())
        {
            pnlCartao.setSelectedCard(cartaoPlanilha, false);
        }
        else if (rbTextoLivre.isSelected())
        {
            pnlCartao.setSelectedCard(cartaoTextoLivre, false);
        }
    }

    private void mostrarDadosMdl3Topicos ()
    {
        pnlMdlDescrito.txtDesc.setText("Informe o título:");
        pnlMdlDescrito.txtObs.setText("Informe o título:");
        String customString = mdl.getCustomString();
        if (customString == null || customString.isEmpty())
        {
        }
        else
        {
            String[] split = customString.split("\\Q$$\n\\E");
            for (String comando : split)
            {
                switch (comando.charAt(0))
                {
                    case '2':
                        pnlMdlDescrito.getTxtDescLaudo().setHtml(comando.substring(13));
                        break;
                    case '5':
                        pnlMdlDescrito.getTxtObsLaudo().setHtml(comando.substring(13));
                        break;
                    case '8':
                        pnlMdlDescrito.getTxtImpDiagLaudo().setHtml(comando.substring(13));
                        break;
                    case '0':
                        pnlMdlDescrito.txtDesc.setText(comando.substring(24));
                        break;
                    case '3':
                        pnlMdlDescrito.txtObs.setText(comando.substring(24));
                        break;
                    default:
                }
            }
        }
    }

    private void mostrarDadosTextoLivre ()
    {
        String customString = mdl.getCustomString();
        if (customString == null || !customString.contains("$$"))
        {
            pnlMdlTextoLivre.getTxtTextoLivre().setHtml("");
        }
        else
        {
            String[] split = customString.split("\\Q$$\n\\E");
            for (String comando : split)
            {
                TxtHtmlLaudo txt;
                switch (comando.charAt(0))
                {
                    case '2':
                        txt = pnlMdlTextoLivre.getTxtTextoLivre();
                        break;
                    default:
                        continue;
                }
                txt.setHtml(comando.substring(13));
            }
        }
    }

    private class PnlMdlDiversos extends MyJPanel
    {

        private final TxtHtmlLaudo txtDescLaudo = new TxtHtmlLaudo().withSpellChecker();
        private final TxtHtmlLaudo txtObsLaudo = new TxtHtmlLaudo().withSpellChecker();
        private final TxtHtmlLaudo txtImpDiagLaudo = new TxtHtmlLaudo().withSpellChecker();
        private final MyJTextField txtDesc = new MyJTextField();
        private final MyJTextField txtObs = new MyJTextField();

        private PnlMdlDiversos ()
        {
            super(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;

            c.gridx = 0;
            c.gridy = 0;
            c.weightx = 1;
            add(txtDesc, c);
            c.gridy = 1;
            c.weighty = 0.33;
            add(txtDescLaudo, c);

            c.gridy = 2;
            c.weighty = 0;
            c.insets.top = 5;
            add(txtObs, c);
            c.gridy = 3;
            c.insets.top = 0;
            c.weighty = 0.33;
            add(txtObsLaudo, c);

            c.gridy = 4;
            add(new PnlComp("Impressão diagnóstica", false, true).setComponent(txtImpDiagLaudo), c);
            setPreferredHeight(500);

        }

        private TxtHtmlLaudo getTxtDescLaudo ()
        {
            return txtDescLaudo;
        }

        private TxtHtmlLaudo getTxtImpDiagLaudo ()
        {
            return txtImpDiagLaudo;
        }

        private TxtHtmlLaudo getTxtObsLaudo ()
        {
            return txtObsLaudo;
        }

    }

    private class PnlMdlTextLivre extends MyJPanel
    {
        private final TxtHtmlLaudo txtTextoLivre = new TxtHtmlLaudo().withSpellChecker();

        private PnlMdlTextLivre ()
        {
            super(new BorderLayout());
            add(new PnlComp("Texto livre", false, false).setComponent(txtTextoLivre), BorderLayout.CENTER);
            setPreferredHeight(500);
        }

        private TxtHtmlLaudo getTxtTextoLivre ()
        {
            return txtTextoLivre;
        }

    }

}
