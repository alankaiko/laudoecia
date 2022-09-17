/*
 * PnlProcMedico.java
 *
 * Created on 13/03/2012, 09:54:49
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeGrupoProcedimento;
import com.ic.projects.laudoecia.control.cadastro.C_EntidadeProcMedico;
import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.auditable.GrupoProcedimento;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.ProcDaTabela;
import com.ic.projects.laudoecia.model.cadastro.ValorFixo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.ic.projects.laudoecia.view.dialogs.DlgCadastro;
import com.ic.projects.laudoecia.view.dialogs.DlgModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.view.dialogs.DlgProcDaTabela;
import com.ic.projects.laudoecia.view.pnl.JanelaComTitulo;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.icontrol.crud.entidade.C_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.java.utils.Money;
import com.lib.model.abstracao.RESTRICAO_SEXO;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.PnlDoTabbedPane;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.docfilters.LimitedLengthDocFilter;
import com.lib.swing.plus.utils.*;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlProcMedico extends PnlDaEntidadeComCrud<ProcMedico>
{

    private BuscadorDeGrupoProcedimento buscadorGrupo = new BuscadorDeGrupoProcedimento();
    private boolean procsIsEmpty;
    private boolean modelsIsEmpty;
    private boolean editarValorNoConv = false;
    private Object[] convSel = null;
    private C_EntidadeProcMedico controlador;
    private JanelaComTitulo janela;

    public PnlProcMedico ()
    {
        PnlDoTabbedPane pnlTab1 = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Código", false, false).setComponent(txtCodigo.pintarDeAmarelo()), c);
        c.gridy = 0;
        c.gridx = 1;
        pnlTab1.add(new CampoDaEnt("Abrir modelo de laudo", false, false).setComponent(checkBox), c);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 5;
        pnlTab1.add(new CampoDaEnt("Nome (será impresso no laudo)", false, true).setComponent(txtNome.pintarDeAmarelo()), c);
        c.gridwidth = 2;
        c.gridy = 2;
        c.gridx = 0;
        pnlTab1.add(new CampoDaEnt("Grupo", false, true).setComponent(txtGrupoProc.pintarDeAmarelo()), c);
        c.gridwidth = 1;
        c.gridx = 2;
        pnlTab1.add(new CampoDaEnt("", true, true).setComponent(btnBuscaGrupo
                , false, true, false, false), c);
        c.gridx = 3;
        pnlTab1.add(new CampoDaEnt("Restrição de sexo", true, true).setComponent(cmbRestSexo.pintarDeAmarelo()), c);
        c.gridx = 4;
        pnlTab1.add(new CampoDaEnt("Dias p/ entrega do laudo", true, true).setComponent(spnDiasEntrega), c);

        MyJPanel pnl = new MyJPanel(new GridLayout(1, 2));
        pnl.add(new CampoDaEnt("Margem antes do título", false, true).setComponent(txtMt));
        pnl.add(new CampoDaEnt("Margem após o título", true, true).setComponent(txtMb));
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        pnlTab1.add(pnl, c);

        c.gridy = 4;
        c.gridx = 0;
        c.weighty = 1;
        c.gridwidth = 1;
        pnlTab1.add(Box.createHorizontalStrut(100), c);
        c.weightx = 1;
        c.gridx = 1;
        pnlTab1.add(Box.createHorizontalStrut(0), c);

        PnlDoTabbedPane pnlTab2 = new PnlDoTabbedPane(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        c.weighty = 1;
        c.weightx = 1;
        pnlTab2.add(new CampoDaEnt(false, false, false).setComponent(tabelaConvenios), c);
        c.gridx = 1;
        c.weightx = 0;
        pnlTab2.add(new CampoDaEnt(false, true, false).setComponent(pnlBtnsConvenios), c);

        PnlDoTabbedPane pnlTab3 = new PnlDoTabbedPane(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1;
        c.weighty = 1;
        pnlTab3.add(new CampoDaEnt(false, false, false).setComponent(tabelaModeloLaudo), c);
        c.gridx = 1;
        c.weightx = 0;
        pnlTab3.add(new CampoDaEnt(false, true, false).setComponent(pnlBtnsModeloLaudo), c);

        PnlDoTabbedPane pnlTab4 = new PnlDoTabbedPane(new BorderLayout());
        pnlTab4.add(pnlImg1, BorderLayout.CENTER);

        PnlDoTabbedPane pnlTab5 = new PnlDoTabbedPane(new BorderLayout());
        pnlTab5.add(pnlImg2, BorderLayout.CENTER);

        tabPane.addTab("Dados principais", pnlTab1);
        tabPane.addTab("Tabela de preços", pnlTab2);
        tabPane.addTab("Imagem 1", pnlTab4);
        tabPane.addTab("Imagem 2", pnlTab5);
        tabPane.addTab("Modelos de laudos", pnlTab3);
        setLayout(new CardLayout());
        add(tabPane);
    }

    @Override
    public boolean mostrarDadosDaEntidadeOk (ProcMedico entidade, int contador)
    {
        switch (contador)
        {
            case 0:
                txtCodigo.setText(entidade.getCodigo());
                txtNome.setText(entidade.getNome());
                buscadorGrupo.setSelectedModel(entidade.getGrupo());
                cmbRestSexo.setSelectedItem(entidade.getRestricaoSexo());
                spnDiasEntrega.setValue(entidade.getDiasParaEntregaDoLaudo());
                txtMb.setText(entidade.getMargemBottom());
                txtMt.setText(entidade.getMargemTop());
                alterarTitulo(entidade.getNome());
                pnlImg1.setImagem(entidade.getImagem1());
                pnlImg2.setImagem(entidade.getImagem2());
                checkBox.setSelected(entidade.getLaudoModelo());
                return false;
            case 1:
                procsIsEmpty = false;
                modelsIsEmpty = false;
                if (entidade.getProcDaTabela().isEmpty())
                {
                    tabelaConvenios.limparTabela();
                    procsIsEmpty = true;
                }
                if (entidade.getModelos().isEmpty())
                {
                    tabelaModeloLaudo.limparTabela();
                    modelsIsEmpty = true;
                }
                if (procsIsEmpty && modelsIsEmpty)
                {
                    return true;
                }
                return false;
            case 2:
                if (procsIsEmpty)
                {
                    return false;
                }
                final List<Object[]> linhasDaTabela = new ArrayList<>();
                List<ProcDaTabela> procedimentos = entidade.getProcDaTabela();
                for (int i = 0; i < procedimentos.size(); i++)
                {
                    ProcDaTabela p = procedimentos.get(i);
                    linhasDaTabela.add(new Object[]
                            {
                                p.getCodigo(),
                                p.getTabelaDeProcedimentos().getConvenio(),
                                new Money(p.getValorPaciente()),
                                new Money(p.getValorNoConvenio().getValorNoConvenio()),
                                p.getValorNoConvenio()
                            });
                }
                if (editarValorNoConv)
                {
                    int index = 0;
                    for (int i = 0; i < tabelaConvenios.getResults().size(); i++)
                    {
                        Object[] o = tabelaConvenios.getResults().get(i);
                        if (Arrays.equals(o, convSel))
                        {
                            index = tabelaConvenios.getTabela().convertRowIndexToView(i);
                            break;
                        }
                    }
                    tabelaConvenios.updateResultList(new ResultsGenerator()
                    {
                        @Override
                        public List<Object[]> generateResults ()
                        {
                            return linhasDaTabela;
                        }

                    }, index);
                    mostrarDlgProcDaTbl();
                    editarValorNoConv = false;
                }
                else
                {
                    tabelaConvenios.updateResultList(new ResultsGenerator()
                    {
                        @Override
                        public List<Object[]> generateResults ()
                        {
                            return linhasDaTabela;
                        }

                    });
                }
                return modelsIsEmpty ? true : false;
            case 3:
                final List<Object[]> linhasDaTabela2 = new ArrayList<>();
                List<ModeloDeLaudoDoProc> modelos = entidade.getModelos();
                for (int i = 0; i < modelos.size(); i++)
                {
                    ModeloDeLaudoDoProc m = modelos.get(i);
                    linhasDaTabela2.add(new Object[]
                            {
                                m,
                                m.getDescricao(),
                                m.getModeloDeLaudo()
                            });
                }
                Collections.sort(linhasDaTabela2, new Comparator<Object[]>()
                {
                    @Override
                    public int compare (Object[] o1, Object[] o2)
                    {
                        return Integer.compare(((ModeloDeLaudoDoProc) o1[0])
                                .getPrioridade(), ((ModeloDeLaudoDoProc) o2[0])
                                .getPrioridade());
                    }

                });
                tabelaModeloLaudo.updateResultList(new ResultsGenerator()
                {
                    @Override
                    public List<Object[]> generateResults ()
                    {
                        return linhasDaTabela2;
                    }

                });
                return true;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        tabPane.setSelectedIndex(0);
        txtNome.requestFocusInWindow();
        if (dadosIniciais != null && dadosIniciais instanceof String)
        {
            txtNome.setText((String) dadosIniciais);
        }
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        if (!pnlEntidadeWasSelected)
        {
            tabPane.setSelectedIndex(1);
        }
        switch (tabPane.getSelectedIndex())
        {
            case 0:
                spnDiasEntrega.requestFocusInWindow();
                break;
            case 1:
                btnEditConvenio.requestFocusInWindow();
                break;
            case 2:
                btnAddModeloLaudo.requestFocusInWindow();
                break;
            default:
        }
    }

    @Override
    public void preencherDadosDaEntidade (ProcMedico ent)
    {
        ent.setMargemTop(txtMt.getInt());
        ent.setMargemBottom(txtMb.getInt());
        ent.setCodigo(txtCodigo.getInt());
        ent.setNome(txtNome.getText());
        ent.setGrupo(buscadorGrupo.getSelectedModel());
        ent.setRestricaoSexo(cmbRestSexo.getSelectedItem());
        ent.setDiasParaEntregaDoLaudo(spnDiasEntrega.getValue());
        ent.setImagem1(pnlImg1.getImagem());
        ent.setImagem2(pnlImg2.getImagem());
        ent.setLaudoModelo(checkBox.isSelected());
        List<ProcDaTabela> procedimentos = new ArrayList<>();
        List<Object[]> linhasDaTabela = tabelaConvenios.getResults();
        for (int i = 0; i < linhasDaTabela.size(); i++)
        {
            Object[] dados = linhasDaTabela.get(i);
            ProcDaTabela proc = new ProcDaTabela();
            proc.setCodigo((int) dados[0]);
            proc.setProcMedico(ent);
            proc.setTabelaDeProcedimentos(((Convenio) dados[1]).getTabelaDeProcedimentos());
            proc.setValorPaciente(((Money) dados[2]).doubleValue());
            proc.setValorNoConvenio( (ValorFixo) dados[4]);
            procedimentos.add(proc);
        }
        ent.setProcDaTabela(procedimentos);

        List<ModeloDeLaudoDoProc> modelos = new ArrayList<>();
        List<Object[]> linhasDaTabela2 = tabelaModeloLaudo.getResults();
        for (int i = 0; i < linhasDaTabela2.size(); i++)
        {
            Object[] dados = linhasDaTabela2.get(i);
            ModeloDeLaudoDoProc modelo = (ModeloDeLaudoDoProc) dados[0];
            modelo.setProcMedico(ent);
            modelo.setPrioridade(i);
            modelos.add(modelo);
        }
        ent.setModelos(modelos);
    }

    @Override
    protected <ID> void controladorWasSet (C_EntidadeComCrud<ProcMedico, ID> controlador)
    {
        final C_EntidadeProcMedico c_Proc = (C_EntidadeProcMedico) controlador;
        this.controlador = c_Proc;
    }

    private void btnAddConvenioAction ()
    {
        DlgProcDaTabela d = new DlgProcDaTabela(this);
        d.setVisible(true);
        if (!d.isCancelado())
        {
            Convenio conv = d.getConvenio();
            if (validaUnicidadeConvenios(conv))
            {
                Object[] dados = new Object[5];
                dados[0] = 0;
                dados[1] = conv;
                dados[2] = d.getValorPaciente();
                dados[3] = d.getValorConvenio();
                dados[4] = new ValorFixo(d.getValorConvenio().doubleValue());
                tabelaConvenios.adicionarESelecionarResultado(dados);
            }
        }
    }

    private void btnDeleteConvenioAction ()
    {
        tabelaConvenios.removerResultadoSelecionado();
    }

    private void editarConvenioAction ()
    {
        Object[] dados = tabelaConvenios.getSelectedResult();
        if (dados == null)
        {
            SwingUtils.mostrarAviso(this, "Selecione um convênio para alterá-lo.");
        }
        else
        {
            if (txtNome.isEditable())
            {
                mostrarDlgProcDaTbl();
            }
            else
            {
                editarValorNoConv = true;
                convSel = dados;
                controlador.alterar();
            }
        }
    }

    private void mostrarDlgProcDaTbl ()
    {
        Object[] dados = tabelaConvenios.getSelectedResult();
        DlgProcDaTabela d = new DlgProcDaTabela(this);
        d.setConvenio((Convenio) dados[1]);
        d.setTxtConvenioEnabled(false);
        d.setValorPaciente(((Money) dados[2]).doubleValue());
        d.setValorConvenio(((Money) dados[3]).doubleValue());
        d.setVisible(true);
        if (!d.isCancelado())
        {
            dados[2] = d.getValorPaciente();
            dados[3] = d.getValorConvenio();
            ((ValorFixo) dados[4]).setValor(d.getValorConvenio().doubleValue());
            tabelaConvenios.atualizarResultadoSelecionado(dados);
        }
    }

    private void btnAddModeloLaudoAction ()
    {
        DlgModeloDeLaudoDoProc d = new DlgModeloDeLaudoDoProc(this, null
                , controlador);
        d.setVisible(true);
        if (!d.isCancelado())
        {
            Object[] dados = new Object[3];
            ModeloDeLaudoDoProc modelo = d.getModeloDeLaudo();
            dados[0] = modelo;
            dados[1] = modelo.getDescricao();
            dados[2] = modelo.getModeloDeLaudo();
            final List<Object[]> results = new ArrayList<>(tabelaModeloLaudo.getResults());
            results.add(0, dados);
            tabelaModeloLaudo.updateResultList(new ResultsGenerator()
            {

                @Override
                public List<Object[]> generateResults ()
                {
                    return results;
                }
            });
        }
    }

    private void btnDeleteModeloLaudoAction ()
    {
        tabelaModeloLaudo.removerResultadoSelecionado();
    }

    private void btnUpModeloLaudoAction ()
    {
        final int selRow = tabelaModeloLaudo.getTabela().getSelectedRow();
        if (selRow == -1)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "Escolha um modelo"
                    + " de laudo da tabela.");
        }
        else if (tabelaModeloLaudo.getResults().size() == 1 || selRow == 0)
        {
        }
        else
        {
            tabelaModeloLaudo.updateResultList(new ResultsGenerator() {

                @Override
                public List<Object[]> generateResults ()
                {
                    List<Object[]> novos = new ArrayList<>();
                    novos.addAll(tabelaModeloLaudo.getResults());
                    Object[] linhaSel = novos.get(selRow);
                    Object[] linhaDeCima = novos.set(selRow - 1, linhaSel);
                    novos.set(selRow, linhaDeCima);
                    return novos;
                }
            }, selRow - 1);
        }
    }

    private void btnDownModeloLaudoAction ()
    {
        final int selRow = tabelaModeloLaudo.getTabela().getSelectedRow();
        if (selRow == -1)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "Escolha um modelo"
                    + " de laudo da tabela.");
        }
        else if (tabelaModeloLaudo.getResults().size() == 1 ||
                 selRow == tabelaModeloLaudo.getResults().size() - 1)
        {
        }
        else
        {
            tabelaModeloLaudo.updateResultList(new ResultsGenerator() {

                @Override
                public List<Object[]> generateResults ()
                {
                    List<Object[]> novos = new ArrayList<>();
                    novos.addAll(tabelaModeloLaudo.getResults());
                    Object[] linhaSel = novos.get(selRow);
                    Object[] linhaDeBaixo = novos.set(selRow + 1, linhaSel);
                    novos.set(selRow, linhaDeBaixo);
                    return novos;
                }
            }, selRow + 1);
        }
    }

    private void editarModeloLaudoAction ()
    {
        Object[] dados = tabelaModeloLaudo.getSelectedResult();
        ModeloDeLaudoDoProc modelo = (ModeloDeLaudoDoProc) dados [0];
        DlgModeloDeLaudoDoProc d = new DlgModeloDeLaudoDoProc(this, modelo
                , controlador);
        d.setVisible(true);
        if (!d.isCancelado())
        {
            dados[0] = modelo;
            dados[1] = modelo.getDescricao();
            dados[2] = modelo.getModeloDeLaudo();
            tabelaModeloLaudo.atualizarResultadoSelecionado(dados);
        }
    }

    @Override
    public void usarResultadoDaBusca (Object o)
    {
        if (o instanceof GrupoProcedimento)
        {
            txtGrupoProc.requestFocusInWindow();
            buscadorGrupo.setSelectedModel((GrupoProcedimento) o);
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    cmbRestSexo.requestFocusInWindow();
                }

            });
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Campos do cadastro">

    private MyJTabbedPane tabPane = new MyJTabbedPane();
    private MyJTextField txtNome = new MyJTextField();
    private TxtComAutoCompletar txtGrupoProc = new TxtComAutoCompletar(buscadorGrupo);
    private BtnFKey btnBuscaGrupo = new BtnFKey();
    private CmbEnum<RESTRICAO_SEXO> cmbRestSexo = new CmbEnum<>(RESTRICAO_SEXO.NENHUMA_RESTRICAO, RESTRICAO_SEXO.NENHUMA_RESTRICAO);
    private SpinnerInt spnDiasEntrega = new SpinnerInt(0, 1000, 1);
    private final TxtInteiro txtMt = new TxtInteiro(3);
    private final TxtInteiro txtMb = new TxtInteiro(3);
    private ScrollResultsDaBusca tabelaConvenios = new ScrollResultsDaBusca(new TableConfigurator()
    {

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean[]
                    {
                        false, true, false, false, false
                    };
        }

        @Override
        public String[] columnsTitles ()
        {
            return new String[]
                    {
                        "Código", "Convênio", "Valor Paciente", "Valor Convênio", "Valor fixo"
                    };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?>[]
                    {
                        Integer.class, Object.class, Object.class, Object.class, Object.class
                    };
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int[]
                    {
                        0, 0, 150, 150, 0
                    };
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int[] { 1 };
        }

    });
    private MyJPanel pnlBtnsConvenios = new MyJPanel()
    {
        @Override
        public void setEnabled (boolean enabled)
        {
            super.setEnabled(enabled);
            btnAddConvenio.setEnabled(enabled);
            btnDeleteConvenio.setEnabled(enabled);
            btnAddConvenio.setToolTipText(enabled ? "Adicionar valores de um convênio." : null);
            btnDeleteConvenio.setToolTipText(enabled ? "Remover item selecionado." : null);
            tabelaConvenios.getTabela().setToolTipText(enabled ? "Duplo clique para alterar valores do registro" : null);
        }
    };
    private MyJButton btnAddConvenio = new MyJButton();
    private MyJButton btnEditConvenio = new MyJButton();
    private MyJButton btnDeleteConvenio = new MyJButton();
    private ScrollResultsDaBusca tabelaModeloLaudo = new ScrollResultsDaBusca(new TableConfigurator()
    {
        @Override
        public String[] columnsTitles ()
        {
            return new String[]
                    {
                        "Modelo", "Descrição", "Modelo de tela"
                    };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?>[]
                    {
                        Object.class, String.class, Object.class
                    };
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int[]
                    {
                        0, 0, 0
                    };
        }

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean[]
                    {
                        false, true, true
                    };
        }

        @Override
        public int[] sortedColumns ()
        {
            return null;
        }

    });
    private MyJPanel pnlBtnsModeloLaudo = new MyJPanel()
    {
        @Override
        public void setEnabled (boolean enabled)
        {
            super.setEnabled(enabled);
            btnAddModeloLaudo.setEnabled(enabled);
            btnEditarModeloLaudo.setEnabled(enabled);
            btnDeleteModeloLaudo.setEnabled(enabled);
            btnUpModeloLaudo.setEnabled(enabled);
            btnDownModeloLaudo.setEnabled(enabled);
            btnAddModeloLaudo.setToolTipText(enabled ? "Adicionar modelo de laudo." : null);
            btnDeleteModeloLaudo.setToolTipText(enabled ? "Remover item selecionado." : null);
            btnEditarModeloLaudo.setToolTipText(enabled ? "Editar item selecionado." : null);
            btnUpModeloLaudo.setToolTipText(enabled ? "Mover modelo selecionado para cima." : null);
            btnDownModeloLaudo.setToolTipText(enabled ? "Mover modelo selecionado para baixo." : null);
            tabelaModeloLaudo.getTabela().setToolTipText(enabled ? "Duplo clique para alterar" : null);
        }

    };
    private MyJButton btnAddModeloLaudo = new MyJButton();
    private MyJButton btnDeleteModeloLaudo = new MyJButton();
    private MyJButton btnEditarModeloLaudo = new MyJButton();
    private MyJButton btnUpModeloLaudo = new MyJButton();
    private MyJButton btnDownModeloLaudo = new MyJButton();
    private PnlImagemComBotoes pnlImg1 = new PnlImagemComBotoes();
    private PnlImagemComBotoes pnlImg2 = new PnlImagemComBotoes();
    private MyJCheckBox checkBox = new MyJCheckBox();

    {
        txtNome.setDocumentFilter(new LimitedLengthDocFilter());
        txtGrupoProc.setStrictMatching(true);
        txtGrupoProc.setMensagemDeErro("Grupo não encontrado");
        btnBuscaGrupo.addActionListener(new ActionListener() {

            private ActionAddTela actionAddTela;

            @Override
            public void actionPerformed (ActionEvent e)
            {
                if (actionAddTela == null)
                {
                    criarAction();
                }
                actionAddTela.actionPerformed(e);
            }

            private void criarAction ()
            {
                JInternalFrame iframe = SwingUtils.getParent(PnlProcMedico.this,
                                           JInternalFrame.class);
                if (iframe == null)
                {
                    DlgCadastro dlg = SwingUtils.getParent(PnlProcMedico.this,
                                           DlgCadastro.class);
                    if (dlg != null)
                    {
                        actionAddTela = new ActionAddTela(
                            TelaPrincipal.DLG_GRUPO_PROC,
                            new TelaSolPadrao(
                            TelaPrincipal.TELA_NULL, txtGrupoProc, dlg),
                            new AdapterPermissaoDeUsuario() {
                                @Override
                                public boolean podeAcessar (PerfilDeAcesso p)
                                {
                                    return p.isAcessaGrupoProcedimento();
                                }

                            });
                    }
                }
                else
                {
                    actionAddTela = new ActionAddTela(
                            TelaPrincipal.CADASTRO_GRUPOS_PROCEDIMENTOS,
                            new TelaSolPadrao(
                            TelaPrincipal.CADASTRO_PROC_MEDICO, txtGrupoProc),
                            new AdapterPermissaoDeUsuario() {
                                @Override
                                public boolean podeAcessar (PerfilDeAcesso p)
                                {
                                    return p.isAcessaGrupoProcedimento();
                                }

                            });
                }
            }

        });
        //tab1
        btnAddConvenio.setIcon(SwingLibResources.getIcon(Imagens.ADICIONAR));
        btnAddConvenio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddConvenioAction();
            }

        });
        btnEditConvenio.setIcon(SwingLibResources.getIcon(Imagens.ALTERAR));
        btnEditConvenio.setToolTipText("Alterar valores do convênio selecionado.");
        btnEditConvenio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                editarConvenioAction();
            }
        });
        btnDeleteConvenio.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnDeleteConvenio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnDeleteConvenioAction();
            }

        });
        btnEditarModeloLaudo.setIcon(SwingLibResources.getIcon(Imagens.ALTERAR));
        btnEditarModeloLaudo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                editarModeloLaudoAction();
            }

        });
        tabelaConvenios.getTabela().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    editarConvenioAction();
                }
            }
        });
        tabelaConvenios.removeColumn(0);
        pnlBtnsConvenios.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        pnlBtnsConvenios.add(btnEditConvenio, c);
        c.gridy = 1;
        c.weighty = 1;
        pnlBtnsConvenios.add(Box.createHorizontalStrut(70), c);
        //tab2
        btnAddModeloLaudo.setIcon(SwingLibResources.getIcon(Imagens.ADICIONAR));
        btnAddModeloLaudo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddModeloLaudoAction();
            }

        });
        btnDeleteModeloLaudo.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnDeleteModeloLaudo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnDeleteModeloLaudoAction();
            }

        });
        btnUpModeloLaudo.setIcon(SwingLibResources.getIcon(Imagens.UP));
        btnUpModeloLaudo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnUpModeloLaudoAction();
            }

        });
        btnDownModeloLaudo.setIcon(SwingLibResources.getIcon(Imagens.DOWN));
        btnDownModeloLaudo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnDownModeloLaudoAction();
            }

        });
        tabelaModeloLaudo.getTabela().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                if (tabelaConvenios.getTabela().isHabilitado() && e.getClickCount() == 2)
                {
                    editarModeloLaudoAction();
                }
            }
        });
        tabelaModeloLaudo.getTabela().setRowSorter(null);
        tabelaModeloLaudo.removeColumn(0);
        pnlBtnsModeloLaudo.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridx = 0;
        c2.gridy = 0;
        pnlBtnsModeloLaudo.add(btnAddModeloLaudo, c2);
        c2.gridy = 1;
        pnlBtnsModeloLaudo.add(btnEditarModeloLaudo, c2);
        c2.gridy = 2;
        pnlBtnsModeloLaudo.add(btnDeleteModeloLaudo, c2);
        c2.gridy = 3;
        pnlBtnsModeloLaudo.add(btnUpModeloLaudo, c2);
        c2.gridy = 4;
        pnlBtnsModeloLaudo.add(btnDownModeloLaudo, c2);
        c2.gridy = 5;
        c2.weighty = 1;
        pnlBtnsModeloLaudo.add(Box.createHorizontalStrut(70), c2);

    }

    //</editor-fold>

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(txtNome, new RequiredFieldValidator(txtNome),
                          validadores.get("nome").set("codigo",
                               readerInt(txtCodigo)).set("campo", readerStr(txtNome)));
        formValidator.add(txtGrupoProc, new RequiredFieldValidator(buscadorGrupo));
        formValidator.add(cmbRestSexo, new RequiredFieldValidator(cmbRestSexo));
    }

    private boolean validaUnicidadeConvenios (Convenio c)
    {
        List<Object[]> linhasDaTabela = tabelaConvenios.getResults();
        for (int i = 0; i < linhasDaTabela.size(); i++)
        {
            if (c.equals((Convenio) linhasDaTabela.get(i)[1]))
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this,
                "Este convênio já foi adicionado a tabela de preços!");
                return false;
            }
        }
        return true;
    }

    private void alterarTitulo (String titulo)
    {
        if (janela == null)
        {
            janela = JanelaComTitulo.obterJanela(this);
        }
        if (janela == null)
        {
        }
        else if (titulo == null || titulo.trim().isEmpty())
        {
            janela.setTitulo("Exames e procedimentos médicos");
        }
        else
        {
            janela.setTitulo("Exames e procedimentos médicos: " + titulo);
        }
    }

    @Override
    public void cardSelected (final String cardId)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                if (SimpleC_Cadastro.VIEW_ENTIDADE.equals(cardId))
                {
                    alterarTitulo(txtNome.getText());
                }
                else
                {
                    alterarTitulo(null);
                }
            }

        });
    }

}
