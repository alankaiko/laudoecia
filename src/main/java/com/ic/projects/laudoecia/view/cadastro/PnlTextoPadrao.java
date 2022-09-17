/*
 * PnlTextoPadrao.java
 *
 * Created on 20/06/2012, 16:39:38
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeProcMedico;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.TextoPadrao;
import com.ic.projects.laudoecia.view.laudo.TxtHtmlLaudo;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.IValidaCampo;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJTabbedPane;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.utils.LblAviso;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.Box;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlTextoPadrao extends PnlDaEntidadeComCrud<TextoPadrao>
{
    private BuscadorDeProcMedico buscProcMed = new BuscadorDeProcMedico();

    public PnlTextoPadrao ()
    {
        PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        c.gridx = 1;
        c.weightx = 1;
        pnlTab1.add(new CampoDaEnt("Abreviatura", true, false).setComponent(txtAbreviatura.pintarDeAmarelo()), c);
        c.weightx = 0;
        c.gridwidth = 2;
        c.gridy = 1;
        c.gridx = 0;
        c.weighty = 1;
        pnlTab1.add(new CampoDaEnt("Texto pessoal", false, true).setComponent(txtTexto), c);
        c.gridwidth = 1;
        c.gridy = 2;
        c.weighty = 0;
        pnlTab1.add(Box.createHorizontalStrut(100), c);

        PnlDoTabbedPane pnlTab2 = new PnlDoTabbedPane(new GridBagLayout());
        c.gridy = 0;
        c.gridwidth = 3;
        pnlTab2.add(lblAviso, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.weightx = 1;
        pnlTab2.add(new CampoDaEnt("Procedimento Médico", false, true).setComponent(
                txtProcMed, true, false, true, true), c);
        c.gridx = 1;
        c.weightx = 0;
        pnlTab2.add(new CampoDaEnt(" ", true, false).setComponent(btnAddProcMed
                , false, false, true, false), c);
        c.gridx = 2;
        pnlTab2.add(new CampoDaEnt(" ", true, false).setComponent(btnDeleteProcMed), c);
        c.gridwidth = 3;
        c.gridy = 2;
        c.gridx = 0;
        c.weighty = 1;
        pnlTab2.add(new CampoDaEnt(false, false, true).setComponent(tabelaProcMed), c);

        tabPane.addTab("Dados principais", pnlTab1);
        tabPane.addTab("Procedimentos relacionados", pnlTab2);
        setLayout(new CardLayout());
        add(tabPane);
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private MyJTabbedPane tabPane = new MyJTabbedPane();
    private MyJTextField txtAbreviatura = new MyJTextField();
    private TxtHtmlLaudo txtTexto = new TxtHtmlLaudo().withSpellChecker();
    private LblAviso lblAviso = new LblAviso("", Imagens.INFO_SMALL);
    private TxtComAutoCompletar txtProcMed = new TxtComAutoCompletar(buscProcMed);
    private ScrollResultsDaBusca tabelaProcMed = new ScrollResultsDaBusca(new TableConfigurator()
    {

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean[]
                    {
                        true
                    };
        }

        @Override
        public String[] columnsTitles ()
        {
            return new String[]
                    {
                        "Procedimentos médicos"
                    };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?>[]
                    {
                        Object.class
                    };
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int[]
                    {
                        0
                    };
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int[] { 0 };
        }

    });
    private MyJButton btnAddProcMed = new MyJButton();
    private MyJButton btnDeleteProcMed = new MyJButton();

    {

        txtAbreviatura.setDocumentFilter(new LimitedLengthDocFilter());
        String aviso = "<html><b>Atenção!</b> Caso não relacione procedimentos, o texto poderá ser utilizado para todos os procedimentos.</html>";
        lblAviso.setText(aviso);
        btnAddProcMed.setIcon(SwingLibResources.getIcon(Imagens.ADICIONAR));
        btnAddProcMed.setToolTipText("Adicionar procedimento à lista");
        btnAddProcMed.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddProcMedAction();
            }

        });
        btnDeleteProcMed.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnDeleteProcMed.setToolTipText("Remover procedimento selecionado");
        btnDeleteProcMed.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnDeleteProcMedAction();
            }

        });
    }

    //</editor-fold>

    private void btnAddProcMedAction ()
    {
        ProcMedico proc = buscProcMed.getSelectedModel();
        if (proc != null && validaUnicidadeProcMedico(proc))
        {
            tabelaProcMed.adicionarESelecionarResultado(new Object[] { proc });
        }
        buscProcMed.setSelectedModel(null);
        txtProcMed.requestFocusInWindow();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                formValidator.revalidate(txtProcMed);
            }

        });
    }

    private void btnDeleteProcMedAction ()
    {
        tabelaProcMed.removerResultadoSelecionado();
    }

    private boolean validaUnicidadeProcMedico (ProcMedico proc)
    {
        List<Object[]> linhasDaTabela = tabelaProcMed.getResults();
        for (int i = 0; i < linhasDaTabela.size(); i++)
        {
            if (proc.equals((ProcMedico) linhasDaTabela.get(i)[0]))
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this,
                "Este procedimento já foi adicionado!");
                return false;
            }
        }
        return true;
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtAbreviatura, new RequiredFieldValidator(txtAbreviatura),
                          validadores.get("abreviatura").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtAbreviatura)));
        formValidator.add(txtProcMed, new MeuValidador());
    }

    @Override
    protected void prepararParaAdicionar (Object dadosIniciais)
    {
        tabPane.setSelectedIndex(0);
        txtAbreviatura.requestFocusInWindow();
    }

    @Override
    protected void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        if (!pnlEntidadeWasSelected)
        {
            tabPane.setSelectedIndex(0);
        }
        switch (tabPane.getSelectedIndex())
        {
            case 0:
                txtAbreviatura.requestFocusInWindow();
                break;
            case 1:
                txtProcMed.requestFocusInWindow();
                break;
            default:
        }
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (TextoPadrao entidade, int contador)
    {
        switch (contador)
        {
            case 0:
                txtCodigo.setText(entidade.getCodigo());
                txtAbreviatura.setText(entidade.getAbreviatura());
                txtTexto.setHtml(entidade.getTexto());
                return false;
            case 1:
                if (entidade.getProcedimentos().isEmpty())
                {
                    tabelaProcMed.limparTabela();
                    return true;
                }
                return false;
            case 2:
                final List<Object[]> linhasDaTabela = new ArrayList<>();
                List<ProcMedico> procedimentos = entidade.getProcedimentos();
                for (int i = 0; i < procedimentos.size(); i++)
                {
                    ProcMedico p = procedimentos.get(i);
                    linhasDaTabela.add(new Object[] { p });
                }
                tabelaProcMed.updateResultList(new ResultsGenerator()
                {
                    @Override
                    public List<Object[]> generateResults ()
                    {
                        return linhasDaTabela;
                    }
                });
                return true;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void preencherDadosDaEntidade (TextoPadrao textoPadrao)
    {
        textoPadrao.setCodigo(txtCodigo.getInt());
        textoPadrao.setAbreviatura(txtAbreviatura.getText());
        textoPadrao.setTexto(txtTexto.getHTML());

        List<ProcMedico> procedimentos = new ArrayList<>();
        List<Object[]> linhasDaTabela = tabelaProcMed.getResults();
        for (int i = 0; i < linhasDaTabela.size(); i++)
        {
            procedimentos.add((ProcMedico) linhasDaTabela.get(i)[0]);
        }
        textoPadrao.setProcedimentos(procedimentos);
    }

    private class MeuValidador implements IValidaCampo
    {

        private String msgErro;

        @Override
        public boolean validationOk (int tipo)
        {
            if (buscProcMed.getSelectedModel() == null)
            {
                if (txtProcMed.getText() == null || txtProcMed.getText().isEmpty())
                {
                    return true;
                }
                else
                {
                    msgErro = "Escolha um procedimento e clique no "
                    + "botão verde a sua direita!";
                    return false;
                }
            }
            else
            {
                msgErro = "Clique no botão verde a sua direita para "
                + "adicionar o procedimento!";
                return false;
            }
        }

        @Override
        public String getErrorMessage ()
        {
            return msgErro;
        }

    }

}
