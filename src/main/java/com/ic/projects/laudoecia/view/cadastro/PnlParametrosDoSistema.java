/*
 * PnlParametrosDoSistema.java
 *
 * Created on 02/04/2012, 10:52:55
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorImpressoras;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.cadastro.BackupAutomatico;
import com.ic.projects.laudoecia.model.enums.CONTROLE_DE_ACESSO;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.ic.projects.laudoecia.model.enums.TIPO_PAPEL;
import com.ic.projects.laudoecia.view.dialogs.DlgBackupAutomatico;
import com.ic.projects.laudoecia.view.laudo.TxtHtmlLaudo;
import com.ic.projects.laudoecia.view.validacao.ValidadorDeDiretorio;
import com.ic.projects.laudoecia.view.validacao.ValidadorDeTabelaRequired;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.model.abstracao.DIA_DA_SEMANA;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.model.cnv.ConversorDoublePixels;
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
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.plus.utils.*;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class PnlParametrosDoSistema extends PnlDaEntidadeComCrud<ParametrosDoSistema>
{
    private MyJTabbedPane tabPane = new MyJTabbedPane();
    private ConversorDoublePixels convDoublePixels = new ConversorDoublePixels();
    private ConversorByteArrayImage convImagem = new ConversorByteArrayImage();

    public PnlParametrosDoSistema ()
    {
        setTemTxtCodigo(false);
        configTabLaudos();
        configTabBackup();
        configTabOutrasOpcoes();

        setLayout(new CardLayout());
        add(tabPane);
    }

    //<editor-fold defaultstate="collapsed" desc="Tab Backup">
    private void configTabBackup ()
    {
        PnlDoTabbedPane pnl = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridy = 0;
        c.gridx = 0;
        pnl.add(new CampoDaEnt(false, false, true).setComponent(ckbBackupEnabled), c);

        //<editor-fold defaultstate="collapsed" desc="monta pnlBkp">
        pnlBkp.setLayout(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 3;
        pnlBkp.add(new CampoDaEnt("Local para salvar backup", false, true).setComponent(txtDirArquivo), c);
        c.gridx = 3;
        c.gridwidth = 1;
        pnlBkp.add(new CampoDaEnt().setComponent(btnAbrirLocal), c);
        c.gridy = 1;
        c.gridx = 0;
        pnlBkp.add(new CampoDaEnt(false, false, true).setComponent(lblTabela), c);
        c.gridx = 1;
        pnlBkp.add(new CampoDaEnt(false, true, true).setComponent(btnAddBackup), c);
        c.gridx = 2;
        c.gridwidth = 2;
        pnlBkp.add(new CampoDaEnt(false, true, true).setComponent(btnDeleteBackup), c);
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 4;
        c.weighty = 1;
        pnlBkp.add(new CampoDaEnt(false, false, true).setComponent(scrpTabelaBackup), c);

        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 1;
        c.weighty = 0;
        pnlBkp.add(Box.createHorizontalStrut(200), c);
        c.gridx = 1;
        pnlBkp.add(Box.createHorizontalStrut(150), c);
        c.gridx = 2;
        pnlBkp.add(Box.createHorizontalStrut(75), c);
        c.gridx = 3;
        pnlBkp.add(Box.createHorizontalStrut(75), c);
        //</editor-fold>

        c.gridy = 1;
        c.gridx = 0;
        c.weighty = 1;
        pnl.add(new CampoDaEnt(false, false, true).setComponent(pnlBkp), c);

        tabPane.addTab("Backup automático", pnl);
    }

    private void mostrarDadosBackup (ParametrosDoSistema entidade)
    {
        ckbBackupEnabled.setSelected(entidade.isBackupAutomaticoEnabled());

        if (entidade.getBackups().isEmpty())
        {
            scrpTabelaBackup.limparTabela();
            return;
        }

        final List<Object[]> linhasDaTabela = new ArrayList<>();
        List<BackupAutomatico> backups = entidade.getBackups();
        for (int i = 0; i < backups.size(); i++)
        {
            BackupAutomatico ba = backups.get(i);
            linhasDaTabela.add(new Object[]
                    {
                        ba.getCodigo(),
                        ba.getDiaDaSemana().getPorNumero(),
                        ba.getDiaDaSemana(),
                        ba.getHorario(),
                        ba.getTipo()
                    });
        }
        scrpTabelaBackup.updateResultList(new ResultsGenerator()
        {
            @Override
            public List<Object[]> generateResults ()
            {
                return linhasDaTabela;
            }

        });

        txtDirArquivo.setText(backups.get(0).getDiretorioDoArquivo());
    }

    private void preencherDadosBackup (ParametrosDoSistema entidadeBase)
    {
        entidadeBase.setBackupAutomaticoEnabled(ckbBackupEnabled.isSelected());

        List<BackupAutomatico> backups = new ArrayList<>();
        List<Object[]> linhasDaTabela = scrpTabelaBackup.getResults();
        String diretorioArquivo = txtDirArquivo.getText();
        for (int i = 0; i < linhasDaTabela.size(); i++)
        {
            Object[] dados = linhasDaTabela.get(i);
            BackupAutomatico ba = new BackupAutomatico();
            ba.setCodigo((int) dados[0]);
            ba.setParametrosDoSistema(entidadeBase);
            ba.setDiaDaSemana((DIA_DA_SEMANA) dados[2]);
            ba.setDiretorioDoArquivo(diretorioArquivo);
            ba.setHorario((Date) dados[3]);
            ba.setTipo((TIPO_BACKUP) dados[4]);
            backups.add(ba);
        }

        entidadeBase.setBackups(backups);
    }

    private void ckbBackupEnabledAction ()
    {
        setEnabledComponentesBackup(ckbBackupEnabled.isSelected());
    }

    private void btnAddBackupAction ()
    {
        DlgBackupAutomatico d = new DlgBackupAutomatico(this);
        d.setVisible(true);
        if (!d.isCancelado())
        {
            List<Object[]> novasLinhas = d.getLinhas();
            for (int i = 0; i < novasLinhas.size(); i++)
            {
                scrpTabelaBackup.adicionarESelecionarResultado(novasLinhas.get(i));
                scrpTabelaBackup.getTabela().requestFocusInWindow();
            }
        }
    }

    private void btnDeleteBackupAction ()
    {
        scrpTabelaBackup.removerResultadoSelecionado();
    }

    private void setEnabledComponentesBackup (boolean enabled)
    {
        txtDirArquivo.setEnabled(enabled);
        btnAbrirLocal.setEnabled(enabled);
        btnAddBackup.setEnabled(enabled);
        btnDeleteBackup.setEnabled(enabled);
        scrpTabelaBackup.getTabela().setEnabled(enabled);
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">
    private MyJCheckBox ckbBackupEnabled = new MyJCheckBox("Realizar backup automático?");
    private MyJPanel pnlBkp = new MyJPanel()
    {
        @Override
        public void setEnabled (boolean enabled)
        {
            super.setEnabled(enabled);
            if (enabled && ckbBackupEnabled.isSelected())
            {
                setEnabledComponentesBackup(true);
            }
            else
            {
                setEnabledComponentesBackup(false);
            }
        }

    };
    private MyJTextField txtDirArquivo = new MyJTextField();
    private BtnFileChooser btnAbrirLocal = new BtnFileChooser(txtDirArquivo, BtnFileChooser.ESCOLHER_DIRETORIO);
    private LblNegrito lblTabela = new LblNegrito(" Backups automáticos configurados");
    private MyJButton btnAddBackup = new MyJButton("Adicionar configuração");
    private MyJButton btnDeleteBackup = new MyJButton("Remover selecionada");
    private ScrollResultsDaBusca scrpTabelaBackup = new ScrollResultsDaBusca(new TableConfigurator()
    {
        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean[]
                    {
                        false, false, true, false, false
                    };
        }

        @Override
        public String[] columnsTitles ()
        {
            return new String[]
                    {
                        "Código", "", "Dia da semana", "Horário", "Tipo de backup"
                    };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?>[]
                    {
                        Integer.class, Integer.class, Object.class, Date.class, Object.class
                    };
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int[]
                    {
                        0, 0, 0, 120, 160
                    };
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int[]
                    {
                        3, 1
                    };
        }

    });


    {
        pnlBkp.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(5, 5, 5, 5)));
        ckbBackupEnabled.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                ckbBackupEnabledAction();
            }

        });
        btnAddBackup.setIcon(SwingLibResources.getIcon(Imagens.ADICIONAR));
        btnAddBackup.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnAddBackupAction();
            }

        });
        btnDeleteBackup.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnDeleteBackup.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnDeleteBackupAction();
            }

        });
        scrpTabelaBackup.setCellRenderer(3, new MyDateRenderer(
                Constantes.TIME_ONLY_AMPM_OFF, SwingConstants.LEFT));
        scrpTabelaBackup.removeColumn(0);
        btnAbrirLocal.setText("Abrir");
    }

    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tab Impressao Laudos">

    private boolean loadImgNow = true;

    private void configTabLaudos ()
    {
        pnlNullLogomarca.add(pnlLogoLaudo);
        pnlNullLogomarca.setBorder(new MatteBorder(1, 0, 0, 0, Color.GRAY));

        MyJPanel pnlConfLogomarca = new MyJPanel(new GridBagLayout());
        pnlConfLogomarca.setBorder(new LineBorder(Color.GRAY));
        GridBagConstraints cI = new GridBagConstraints();
        cI.fill = GridBagConstraints.BOTH;
        pnlConfLogomarca.add(new PnlComp(false, false, true).setComponent(btnAddImagem), cI);
        cI.gridx = 1;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(btnDelImagem), cI);
        cI.gridx = 2;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(new MyJLabel("Largura (cm)")), cI);
        cI.gridx = 3;
        cI.weightx = 0.3;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(spnImgWidth), cI);
        cI.gridx = 4;
        cI.weightx = 0;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(new MyJLabel("Altura (cm)")), cI);
        cI.gridx = 5;
        cI.weightx = 0.3;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(spnImgHeight), cI);
        cI.gridx = 6;
        cI.weightx = 0;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(new MyJLabel("Margem esquerda (cm)")), cI);
        cI.gridx = 7;
        cI.weightx = 0.3;
        pnlConfLogomarca.add(new PnlComp(false, true, true).setComponent(spnLeftMarginImg), cI);
        cI.weightx = 0;
        cI.weighty = 1;
        cI.gridwidth = 8;
        cI.gridy = 1;
        cI.gridx = 0;
        pnlConfLogomarca.add(new PnlComp(false, false, true).setComponent(pnlNullLogomarca), cI);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        //pnlHeader
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.gridwidth = 2;
        pnlHeader.add(new PnlComp("Logomarca / Imagem do topo", false, false).setComponent(pnlConfLogomarca), c);
        c.gridwidth = 1;
        c.gridx = 2;
        pnlHeader.add(Box.createVerticalStrut(312), c);
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.3;
        pnlHeader.add(new PnlComp(false, false).setComponent(lblTextoHeader), c);
        c.gridx = 1;
        c.weightx = 0.7;
        pnlHeader.add(new PnlComp(true, false).setComponent(ckbUsarLicenciadoHeader), c);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        pnlHeader.add(new PnlComp(false, false, true).setComponent(txtTextoHeader), c);
        c.gridwidth = 1;
        txtTextoHeader.setPreferredSize(new Dimension(540, 130));

        //pnlFooter
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        pnlFooter.add(new PnlComp("Frase do rodapé", false, false).setComponent(txtFraseRodapeLaudo), c);
        txtFraseRodapeLaudo.setPreferredSize(new Dimension(540, 130));
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.3;
        pnlFooter.add(new PnlComp(false, false).setComponent(lblTextoFooter), c);
        c.gridx = 1;
        c.weightx = 0.7;
        pnlFooter.add(new PnlComp(true, false).setComponent(ckbUsarLicenciadoFooter), c);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        pnlFooter.add(new PnlComp(false, false, true).setComponent(txtTextoFooter), c);
        c.gridwidth = 1;
        txtTextoFooter.setPreferredSize(new Dimension(540, 130));

        //pnlPrincipal
        MyJPanel pnl = new MyJPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.25;
        pnl.add(new CampoDaEnt("Margem superior (cm)", false, false).setComponent(spnTopMargin), c);
        c.gridx = 1;
        c.gridwidth = 2;
        pnl.add(new CampoDaEnt("Margem inferior (cm)", true, false).setComponent(spnBottomMargin), c);
        c.gridwidth = 1;
        c.gridx = 3;
        pnl.add(new CampoDaEnt("Margem esquerda (cm)", true, false).setComponent(spnLeftMargin), c);
        c.gridx = 4;
        pnl.add(new CampoDaEnt("Margem direita (cm)", true, false).setComponent(spnRightMargin), c);
        c.weightx = 0;
        c.gridy = 1;
        c.gridx = 0;
        pnl.add(new CampoDaEnt("Papel de impressão", false, true).setComponent(cmbTipoPapel), c);
        c.gridx = 1;
        pnl.add(new CampoDaEnt("Largura (cm)", true, true).setComponent(spnPaperWidth), c);
        c.gridx = 2;
        pnl.add(new CampoDaEnt("Altura (cm)", true, true).setComponent(spnPaperHeight), c);
        c.gridx = 3;
        c.gridwidth = 2;
        pnl.add(new CampoDaEnt("Layout padrão de impressão de imagens", true, true).setComponent(cmbLayout), c);
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 5;
        pnl.add(new CampoDaEnt(false, false).setComponent(ckbPrintHeader), c);
        c.gridy = 3;
        pnl.add(new CampoDaEnt(false, false, true).setComponent(pnlHeader), c);
        c.gridy = 4;
        c.gridwidth = 2;
        pnl.add(new CampoDaEnt(false, false).setComponent(ckbPrintFooter), c);
        c.gridx = 3;
        pnl.add(new CampoDaEnt().setComponent(ckbImpSepRodape), c);
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 5;
        pnl.add(new CampoDaEnt(false, false, true).setComponent(pnlFooter), c);

        c.gridy = 6;
        pnl.add(new CampoDaEnt("Impressora padrão para laudos", false, true).setComponent(txtImpLaudo), c);

        c.gridy = 7;
        pnl.add(new CampoDaEnt("Impressora padrão para imagens", false, true).setComponent(txtImpImagens), c);

        c.gridy = 8;
        pnl.add(new CampoDaEnt("", false, true).setComponent(ckbImpSolConv), c);

        c.gridy = 9;
        pnl.add(new CampoDaEnt("", false, true).setComponent(ckbImpAtd), c);

//        c.gridy = 10;
//        pnl.add(new CampoDaEnt("",false,true).setComponent(ckbNaoPossuiTerminais),c);

        JScrollPane scrl = new JScrollPane(pnl);
        scrl.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED),
                                          new EmptyBorder(5, 5, 5, 5)));
        scrl.getVerticalScrollBar().setBlockIncrement(25);
        scrl.getVerticalScrollBar().setUnitIncrement(25);
        tabPane.addTab("Impressão de laudos", scrl);

    }

    private void cmbTipoPapelAction ()
    {
        TIPO_PAPEL papel = cmbTipoPapel.getSelectedItem();
        if (papel != null)
        {
            spnPaperWidth.setValue(papel.getWidth());
            spnPaperHeight.setValue(papel.getHeight());
            boolean custom = papel.equals(TIPO_PAPEL.CUSTOM);
            boolean enable = custom && cmbTipoPapel.isEnabled();
            spnPaperWidth.setEnabled(enable);
            spnPaperHeight.setEnabled(enable);
            if (custom)
            {
                spnPaperWidth.requestFocusInWindow();
            }
        }
    }

    private void mostrarDadosPapel (ParametrosDoSistema entidade)
    {
        double paperWidth = entidade.getPaperWidth();
        double paperHeight = entidade.getPaperHeight();
        if (TIPO_PAPEL.A4.getWidth() == paperWidth && TIPO_PAPEL.A4.getHeight() == paperHeight)
        {
            cmbTipoPapel.setSelectedItem(TIPO_PAPEL.A4);
            spnPaperWidth.setEnabled(false);
            spnPaperHeight.setEnabled(false);
        }
        else if (TIPO_PAPEL.CARTA.getWidth() == paperWidth && TIPO_PAPEL.CARTA.getHeight() == paperHeight)
        {
            cmbTipoPapel.setSelectedItem(TIPO_PAPEL.CARTA);
            spnPaperWidth.setEnabled(false);
            spnPaperHeight.setEnabled(false);
        }
        else if (TIPO_PAPEL.OFICIO.getWidth() == paperWidth && TIPO_PAPEL.OFICIO.getHeight() == paperHeight)
        {
            cmbTipoPapel.setSelectedItem(TIPO_PAPEL.OFICIO);
            spnPaperWidth.setEnabled(false);
            spnPaperHeight.setEnabled(false);
        }
        else
        {
            cmbTipoPapel.setSelectedItem(TIPO_PAPEL.CUSTOM);
            spnPaperWidth.setValue(paperWidth);
            spnPaperHeight.setValue(paperHeight);
        }
    }

    private void mostrarDadosLaudos (ParametrosDoSistema entidade)
    {
        ckbImpAtd.setSelected(entidade.isImprimirAtd());
        spnTopMargin.setValue(entidade.getTopMargin());
        spnBottomMargin.setValue(entidade.getBottomMargin());
        spnLeftMargin.setValue(entidade.getLeftMargin());
        spnRightMargin.setValue(entidade.getRightMargin());

        mostrarDadosPapel(entidade);
        cmbLayout.setSelectedItem(entidade.getLayoutImagem());

        ckbPrintHeader.setSelected(entidade.isImprimeCabecalhoLaudo());
        loadImgNow = false;
        spnImgWidth.setValue(entidade.getLogomarcaWidth());
        loadImgNow = true;
        spnImgHeight.setValue(entidade.getLogomarcaHeight());
        spnLeftMarginImg.setValue(entidade.getLeftMarginLogomarca());
        byte[] logoLaudo = entidade.getLogomarcaLaudo();
        pnlLogoLaudo.setImagem(logoLaudo == null ? null : logoLaudo);
        doActionTemImagem(logoLaudo != null, false);
        String textoH = entidade.getTextoCabecalhoLaudo();
        if (textoH == null)
        {
            ckbUsarLicenciadoHeader.setSelected(true);
        }
        else
        {
            txtTextoHeader.setHtml(textoH);
        }

        ckbPrintFooter.setSelected(entidade.isImprimeRodapeLaudo());
        txtFraseRodapeLaudo.setHtml(entidade.getFraseRodapeLaudo());
        String textoF = entidade.getTextoRodapeLaudo();
        if (textoF == null)
        {
            ckbUsarLicenciadoFooter.setSelected(true);
        }
        else
        {
            txtTextoFooter.setHtml(textoF);
        }

        ckbImpSepRodape.setSelected(entidade.getTamanhoSepRodape() > 0);
        txtImpLaudo.setText(entidade.getDefprinterlaudo());
        txtImpImagens.setText(entidade.getDefprinterimagens());
        ckbImpSolConv.setSelected(entidade.isImprimirsolcon());
    }

    private void preencherDadosLaudos (ParametrosDoSistema entidadeBase)
    {

        entidadeBase.setImprimirAtd(ckbImpAtd.isSelected());

        entidadeBase.setTopMargin(spnTopMargin.getValue());
        entidadeBase.setBottomMargin(spnBottomMargin.getValue());
        entidadeBase.setLeftMargin(spnLeftMargin.getValue());
        entidadeBase.setRightMargin(spnRightMargin.getValue());

        entidadeBase.setPaperWidth(spnPaperWidth.getValue());
        entidadeBase.setPaperHeight(spnPaperHeight.getValue());

        entidadeBase.setImprimeCabecalhoLaudo(ckbPrintHeader.isSelected());
        entidadeBase.setLogomarcaWidth(spnImgWidth.getValue());
        entidadeBase.setLogomarcaHeight(spnImgHeight.getValue());
        entidadeBase.setLeftMarginLogomarca(spnLeftMarginImg.getValue());
        entidadeBase.setLogomarcaLaudo(pnlLogoLaudo.getImagem() == null ? null : pnlLogoLaudo.getImagem());
        entidadeBase.setTextoCabecalhoLaudo(ckbUsarLicenciadoHeader.isSelected() ? null : txtTextoHeader.getHTML());

        entidadeBase.setImprimeRodapeLaudo(ckbPrintFooter.isSelected());
        entidadeBase.setFraseRodapeLaudo(txtFraseRodapeLaudo.getHTML());
        entidadeBase.setTextoRodapeLaudo(ckbUsarLicenciadoFooter.isSelected() ? null : txtTextoFooter.getHTML());

        entidadeBase.setLayoutImagem(cmbLayout.getSelectedItem());
        entidadeBase.setTamanhoSepRodape(ckbImpSepRodape.isSelected() ? 1 : 0);

        entidadeBase.setDefprinterimagens(txtImpImagens.getText());
        entidadeBase.setDefprinterlaudo(txtImpLaudo.getText());
        entidadeBase.setImprimirsolcon(ckbImpSolConv.isSelected());
    }

    private void ckbPrintHeaderAction ()
    {
        if (ckbPrintHeader.isEnabled())
        {
            setEnabledComponentesHeader(ckbPrintHeader.isSelected());
        }
    }

    private void ckbPrintFooterAction ()
    {
        if (ckbPrintFooter.isEnabled())
        {
            setEnabledComponentesFooter(ckbPrintFooter.isSelected());
        }
    }

    private void ckbUsarLicenciadoHeaderAction ()
    {
        boolean selected = ckbUsarLicenciadoHeader.isSelected();
        txtTextoHeader.setEditable(!selected);
        if (selected)
        {
            txtTextoHeader.setHtml(null);
        }
        else
        {
            txtTextoHeader.getEditor().requestFocusInWindow();
        }
    }

    private void ckbUsarLicenciadoFooterAction ()
    {
        boolean selected = ckbUsarLicenciadoFooter.isSelected();
        txtTextoFooter.setEditable(!selected);
        if (selected)
        {
            txtTextoFooter.setHtml(null);
        }
        else
        {
            txtTextoFooter.getEditor().requestFocusInWindow();
        }
    }

    private void setEnabledComponentesHeader (boolean enabled)
    {
        btnAddImagem.setEnabled(enabled);
        btnDelImagem.setEnabled(enabled);
        doActionTemImagem(enabled, false);
        pnlLogoLaudo.setEnabled(enabled);
        ckbUsarLicenciadoHeader.setEnabled(enabled);
        txtTextoHeader.setEnabled(enabled);
    }

    private void setEnabledComponentesFooter (boolean enabled)
    {
        txtFraseRodapeLaudo.setEnabled(enabled);
        ckbUsarLicenciadoFooter.setEnabled(enabled);
        txtTextoFooter.setEnabled(enabled);
    }

    private void tamanhoDaImagemMudou ()
    {
        if (loadImgNow)
        {
            int width = convDoublePixels.convertForward(spnImgWidth.getValue());
            int height = convDoublePixels.convertForward(spnImgHeight.getValue());
            int x = (pnlNullLogomarca.getWidth() - width) / 2;
            int y = (pnlNullLogomarca.getHeight() - height) / 2;
            pnlLogoLaudo.setBounds(x, y, width, height);
            pnlLogoLaudo.setSize(width, height);
            if (pnlLogoLaudo.getImagem() != null)
            {
                pnlLogoLaudo.desenharImagem();
            }
        }

    }

    private void btnAddAction (File file)
    {
        if (file == null)
        {
        }
        else
        {
            doActionTemImagem(true, false);
            byte[] img = convImagem.convertReverse(file);
            BufferedImage bimg = convImagem.convertForward(img);
            if (bimg == null)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(PnlParametrosDoSistema.this, "Não foi possível carregar a imagem. A imagem pode estar danificada.");
            }
            else
            {
                double width = convDoublePixels.convertReverse(bimg.getWidth());
                double height = convDoublePixels.convertReverse(bimg.getHeight());
                if (width > MAX_WIDTH_LOGO)
                {
                    double fator = MAX_WIDTH_LOGO / width;
                    width = MAX_WIDTH_LOGO;
                    height *= fator;
                }
                if (height > MAX_HEIGHT_LOGO)
                {
                    double fator = MAX_HEIGHT_LOGO / height;
                    height = MAX_HEIGHT_LOGO;
                    width *= fator;
                }
                spnImgWidth.setValue(width);
                spnImgHeight.setValue(height);
            }
            pnlLogoLaudo.setImagem(img);
            spnLeftMarginImg.setValue(0d);
        }
    }

    private void btnDelImagemAction()
    {
        pnlLogoLaudo.setImagem(null);
        doActionTemImagem(false, true);
    }

    private void doActionTemImagem(boolean tem, boolean setZero)
    {
        if (setZero)
        {
            spnImgWidth.setValue(0d);
            spnImgHeight.setValue(0d);
            spnLeftMarginImg.setValue(0d);
        }
        boolean b = btnAddImagem.isEnabled();
        spnImgWidth.setEnabled(b && tem);
        spnImgHeight.setEnabled(b && tem);
        spnLeftMarginImg.setEnabled(b && tem);

    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private final double MAX_WIDTH_LOGO = 20d;
    private final double MAX_HEIGHT_LOGO = 9d;

    private SpinnerDouble spnPaperWidth = new SpinnerDouble(0d, 100d, 0.5);
    private SpinnerDouble spnPaperHeight = new SpinnerDouble(0d, 100d, 0.5);
    private SpinnerDouble spnTopMargin = new SpinnerDouble(0.49d, 15d, 0.1);
    private SpinnerDouble spnBottomMargin = new SpinnerDouble(0.49d, 5d, 0.1);
    private SpinnerDouble spnLeftMargin = new SpinnerDouble(0.49d, 5d, 0.1);
    private SpinnerDouble spnRightMargin = new SpinnerDouble(0.49d, 5d, 0.1);
    private MyJCheckBox ckbPrintHeader = new MyJCheckBox("Imprimir cabeçalho");
    private MyJPanel pnlHeader = new MyJPanel(new GridBagLayout())
    {
        @Override
        public void setEnabled (boolean enabled)
        {
            super.setEnabled(enabled);
            if (enabled && ckbPrintHeader.isSelected())
            {
                setEnabledComponentesHeader(true);
            }
            else
            {
                setEnabledComponentesHeader(false);
            }
        }

    };
    private LblNegrito lblTextoHeader = new LblNegrito(" Texto do cabeçalho");
    private MyJCheckBox ckbUsarLicenciadoHeader = new MyJCheckBox("Usar dados do licenciado");
    private TxtHtmlLaudo txtTextoHeader = new TxtHtmlLaudo();
    private MyJPanel pnlNullLogomarca = new MyJPanel(null);
    private PnlImagem pnlLogoLaudo = new PnlImagem();
    private SpinnerDouble spnLeftMarginImg = new SpinnerDouble(0d, 20d, 0.5);
    private SpinnerDouble spnImgWidth = new SpinnerDouble(0.5, MAX_WIDTH_LOGO, 0.5);
    private SpinnerDouble spnImgHeight = new SpinnerDouble(0.5, MAX_HEIGHT_LOGO, 0.5);
    private BtnFileChooser btnAddImagem = new BtnFileChooser(
            new BtnFileChooser.FileReceiver()
            {
                @Override
                public void fileChosen (File file)
                {
                    btnAddAction(file);
                }

            }, BtnFileChooser.ESCOLHER_ARQUIVO);
    private MyJButton btnDelImagem = new MyJButton();
    private MyJCheckBox ckbPrintFooter = new MyJCheckBox("Imprimir rodapé");
    private MyJPanel pnlFooter = new MyJPanel(new GridBagLayout())
    {
        @Override
        public void setEnabled (boolean enabled)
        {
            super.setEnabled(enabled);
            if (enabled && ckbPrintFooter.isSelected())
            {
                setEnabledComponentesFooter(true);
            }
            else
            {
                setEnabledComponentesFooter(false);
            }
        }

    };
    private TxtHtmlLaudo txtFraseRodapeLaudo = new TxtHtmlLaudo();
    private LblNegrito lblTextoFooter = new LblNegrito(" Texto do rodapé");
    private MyJCheckBox ckbUsarLicenciadoFooter = new MyJCheckBox("Usar dados do licenciado");
    private TxtHtmlLaudo txtTextoFooter = new TxtHtmlLaudo(10);
    private MyJCheckBox ckbImpSepRodape = new MyJCheckBox("Imprimir separador no rodapé");
    private CmbEnum<LAYOUT_IMG> cmbLayout = new CmbEnum<>(LAYOUT_IMG.LAYOUT_1_IMG, LAYOUT_IMG.LAYOUT_1_IMG);
    private CmbEnum<TIPO_PAPEL> cmbTipoPapel = new CmbEnum<>(TIPO_PAPEL.A4, TIPO_PAPEL.A4);
    private TxtComAutoCompletar txtImpLaudo = new TxtComAutoCompletar(new BuscadorImpressoras());
    private TxtComAutoCompletar txtImpImagens = new TxtComAutoCompletar(new BuscadorImpressoras());
    private MyJCheckBox ckbImpSolConv = new MyJCheckBox("Imprimir solicitante e convênio");
    private MyJCheckBox ckbImpAtd = new MyJCheckBox("Imprimir número do atendimento");

    {
        txtImpImagens.setDocumentFilter(new LimitedLengthDocFilter());
        txtImpLaudo.setDocumentFilter(new LimitedLengthDocFilter());
        txtImpImagens.setStrCnfEnabled(false);
        txtImpLaudo.setStrCnfEnabled(false);

        pnlHeader.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(5, 5, 5, 5)));
        pnlFooter.setBorder(new CompoundBorder(new LineBorder(Color.gray), new EmptyBorder(5, 5, 5, 5)));
        ckbPrintHeader.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                ckbPrintHeaderAction();
            }

        });
        ckbPrintFooter.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                ckbPrintFooterAction();
            }

        });
        ckbUsarLicenciadoHeader.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                ckbUsarLicenciadoHeaderAction();
            }

        });
        ckbUsarLicenciadoFooter.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                ckbUsarLicenciadoFooterAction();
            }

        });
        pnlLogoLaudo.setTypeConversion(ConversorByteArrayImage.PNG_CONVERSION);
        pnlLogoLaudo.setBorder(null);
        cmbTipoPapel.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                cmbTipoPapelAction();
            }

        });
        spnImgWidth.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged (ChangeEvent e)
            {
                tamanhoDaImagemMudou();
            }

        });
        spnImgHeight.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged (ChangeEvent e)
            {
                tamanhoDaImagemMudou();
            }

        });
        btnAddImagem.setToolTipText("Procurar imagem para adicionar.");
        btnAddImagem.setFileFilter(new FileNameExtensionFilter(
                "Imagens", "jpg", "png", "bmp", "gif"));
        btnDelImagem.setToolTipText("Remover logomarca.");
        btnDelImagem.setIcon(SwingLibResources.getIcon(Imagens.APAGAR));
        btnDelImagem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnDelImagemAction();
            }

        });
    }

    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tab Outras Opções">
    private void configTabOutrasOpcoes ()
    {
        PnlDoTabbedPane pnl = new PnlDoTabbedPane(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        pnl.add(new CampoDaEnt("Pasta de gravação de vídeos", false, false).setComponent(txtDirVideos), c);
        c.gridx = 1;
        c.weightx = 0;
        pnl.add(new CampoDaEnt(true, false).setComponent(btnAbrirLocalVideos), c);
        c.gridx = 2;
        pnl.add(new CampoDaEnt("Fundo de tela", true, false).setComponent(rdbImagemPadrao), c);
        c.gridx = 3;
        pnl.add(new CampoDaEnt(true, false).setComponent(rdbCorSolida), c);
        c.gridx = 4;
        pnl.add(new CampoDaEnt(true, false).setComponent(colorChooser), c);
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 5;
        pnl.add(new CampoDaEnt("Tipo de controle de acesso", false, true).setComponent(cmbCtrlAcesso), c);
        c.gridy = 2;
        pnl.add(new CampoDaEnt(false, false, true).setComponent(lblAvisoCtrlAcesso), c);
        c.gridy = 3;
        c.gridwidth = 1;
        c.weighty = 1;
        pnl.add(Box.createVerticalStrut(5), c);

        tabPane.addTab("Outras opções", pnl);
    }

    private void mostrarDadosOutrasOpcoes (ParametrosDoSistema entidade)
    {
        txtDirVideos.setText(entidade.getDiretorioDeVideos());
        if (entidade.getBgColor() == 0)
        {
            rdbImagemPadrao.setSelected(true);
        }
        else
        {
            rdbCorSolida.setSelected(true);
            colorChooser.setCor(new Color(entidade.getBgColor()));
        }
        CONTROLE_DE_ACESSO ctrlAcesso = entidade.getTipoControleDeAcesso();
        cmbCtrlAcesso.setSelectedItem(ctrlAcesso);
        lblAvisoCtrlAcesso.setText(ctrlAcesso.getDescricao());
    }

    private void preencherDadosOutrasOpcoes (ParametrosDoSistema entidadeBase)
    {
        entidadeBase.setDiretorioDeVideos(txtDirVideos.getText());
        entidadeBase.setTipoControleDeAcesso(cmbCtrlAcesso.getSelectedItem());
        if (rdbImagemPadrao.isSelected() || colorChooser.getCor() == null)
        {
            entidadeBase.setBgColor(0);
        }
        else
        {
            entidadeBase.setBgColor(colorChooser.getCor().getRGB());
        }
    }

    private CmbEnum<CONTROLE_DE_ACESSO> cmbCtrlAcesso = new CmbEnum<>(
            CONTROLE_DE_ACESSO.SEM_CONTROLE, CONTROLE_DE_ACESSO.SEM_CONTROLE);
    private LblAviso lblAvisoCtrlAcesso = new LblAviso("", Imagens.INFO_SMALL);
    private MyJTextField txtDirVideos = new MyJTextField();
    private BtnFileChooser btnAbrirLocalVideos = new BtnFileChooser(txtDirVideos, BtnFileChooser.ESCOLHER_DIRETORIO);
    private ButtonGroup btgFundoTela = new ButtonGroup();
    private MyJRadioButton rdbImagemPadrao = new MyJRadioButton("Imagem padrão");
    private MyJRadioButton rdbCorSolida = new MyJRadioButton("Cor sólida");
    private ColorChooser colorChooser = new ColorChooser(this, this.getBackground());


    {
        cmbCtrlAcesso.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                CONTROLE_DE_ACESSO ca = cmbCtrlAcesso.getSelectedItem();
                if (ca != null)
                {
                    lblAvisoCtrlAcesso.setText(ca.getDescricao());
                }
            }

        });
        btnAbrirLocalVideos.setText("Abrir");
        btgFundoTela.add(rdbImagemPadrao);
        btgFundoTela.add(rdbCorSolida);
        rdbImagemPadrao.setToolTipText("<html>Ao marcar esta opção o sistema coloca uma imagem no fundo de tela. <BR>Para alterar a imagem: vá na pasta 'recursos', dentro da pasta de instalação do sistema, <BR>substitua a imagem 'IMAGEM_DE_FUNDO.jpg' e reinicie o sistema.</html>");
        rdbImagemPadrao.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                colorChooser.setEnabled(false);
            }

        });
        rdbCorSolida.setToolTipText("Ao marcar esta opção o sistema ficará com o fundo de tela com uma cor sólida, escolhida pelo botão ao lado.");
        rdbCorSolida.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                colorChooser.setEnabled(rdbCorSolida.isEnabled());
            }

        });
    }

    //</editor-fold>

    @Override
    protected boolean mostrarDadosDaEntidadeOk (ParametrosDoSistema entidade, int contador)
    {
        switch (contador)
        {
            case 0:
                mostrarDadosLaudos(entidade);
                return false;
            case 1:
                mostrarDadosBackup(entidade);
                return false;
            case 2:
                mostrarDadosOutrasOpcoes(entidade);
                return true;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        spnTopMargin.requestFocusInWindow();
        if (rdbImagemPadrao.isSelected())
        {
            colorChooser.setEnabled(false);
        }
        else
        {
            colorChooser.setEnabled(true);
        }
    }

    @Override
    public void preencherDadosDaEntidade (ParametrosDoSistema entidadeBase)
    {
        preencherDadosLaudos(entidadeBase);
        preencherDadosBackup(entidadeBase);
        preencherDadosOutrasOpcoes(entidadeBase);
    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(spnTopMargin, new RequiredFieldValidator(spnTopMargin));
        formValidator.add(spnBottomMargin, new RequiredFieldValidator(spnBottomMargin));
        formValidator.add(spnLeftMargin, new RequiredFieldValidator(spnLeftMargin));
        formValidator.add(spnRightMargin, new RequiredFieldValidator(spnRightMargin));
        formValidator.add(txtDirArquivo, new ValidadorDeDiretorio(ckbBackupEnabled, txtDirArquivo));
        formValidator.add(scrpTabelaBackup, new ValidadorDeTabelaRequired(scrpTabelaBackup, ckbBackupEnabled));
        formValidator.add(txtDirVideos, new RequiredFieldValidator(txtDirVideos));
    }

    @Override
    public boolean validarSalvar (int tipo)
    {
        if (super.validarSalvar(tipo))
        {
            if (ckbPrintHeader.isSelected())
            {
                double wPapel = spnPaperWidth.getValue();
                double mLeft = spnLeftMargin.getValue();
                double mRight = spnRightMargin.getValue();
                double mLeftImg = spnLeftMarginImg.getValue();
                double wImg = spnImgWidth.getValue();
                double soma = mLeft + mRight + mLeftImg + wImg;
                if (soma >= wPapel)
                {
                    String msg = "Atenção!\nA soma das margens com o "
                    + "tamanho da imagem ultrapassam o tamanho do papel!"
                    + "\n\nTente diminuir o tamanho da imagem ou o tamanho "
                            + "das margens para caber no papel selecionado.";
                    SwingUtils.mostrarMensagemDeErroConhecido(this, msg);
                    return false;
                }
                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

}
