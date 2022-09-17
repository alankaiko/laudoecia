/*
 * DlgRestore.java
 *
 * Created on 07/05/2012, 08:19:25
 */
package com.ic.projects.laudoecia.view.backup;

import com.ic.projects.laudoecia.control.backup.RestoreManager;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.renderers.MyDateRenderer;
import com.lib.swing.plus.utils.BtnFileChooser;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.utils.Constantes;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
class DlgRestore extends MyJDialog
{

    private Map<Date, File> filesMap = new HashMap<>();
    private static DlgRestore instance;

    private DlgRestore ()
    {
        super(null, true, 420, 330);
        setTitle("Restaurar dados do sistema");
        initComponents();
    }

    private static DlgRestore getInstance ()
    {
        if (instance == null)
        {
            instance = new DlgRestore();
        }
        return instance;
    }

    static void setState (boolean on)
    {
        if (instance == null && !on)
        {
        }
        else
        {
            if (on)
            {
                getInstance().atualizarTxtDir();
            }
            getInstance().setVisible(on);
        }
    }

    private void atualizarTxtDir ()
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                ParametrosDoSistema pds = StaticInfo.getParametrosDoSistema(true);
                if (!(pds == null || pds.getBackups().isEmpty()))
                {
                    txtPastaDeBackups.setText(pds.getBackups().get(0)
                            .getDiretorioDoArquivo());
                }
                txtPastaDeBackups.requestFocusInWindow();
            }

        });
    }

    private void initComponents ()
    {

        MyJPanel pnl = new MyJPanel();
        pnl.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        pnl.add(new PnlComp("Tipo de restauração", true, true).setComponent(rdbApenasDados), c);
        c.gridwidth = 1;
        c.gridx = 1;
        pnl.add(new PnlComp("", true, true).setComponent(rdbDadosEImagens), c);
        c.gridwidth = 2;
        c.gridy = 1;
        c.gridx = 0;
        pnl.add(new PnlComp("Selecione a pasta de backup",true, true).setComponent(txtPastaDeBackups), c);
        c.gridwidth = 1;
        c.gridx = 2;
        c.weightx = 0.2;
        pnl.add(new PnlComp(true, true).setComponent(btnDirChooser), c);
        c.weighty = 1;
        c.gridwidth = 3;
        c.gridy = 3;
        c.gridx = 0;
        pnl.add(new PnlComp("Selecione um backup para ser restaurado", true, true).setComponent(scroller), c);
        c.weighty = 0;
        MyJPanel pnlBotoes = new MyJPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBotoes.add(btnConfirmar);
        pnlBotoes.add(btnCancelar);
        c.gridwidth = 3;
        c.gridy = 4;
        pnl.add(new PnlComp(true, true).setComponent(pnlBotoes), c);
        add(pnl);
    }

    private void btnConfirmarAction ()
    {
        if (scroller.getSelectedResult() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "Escolha um backup"
                    + " na lista!");
        }
        else if (SwingUtils.obterConfirmacaoDoUsuario(
                 "Todos os dados atuais serão perdidos!\n"
                 + "Tem certeza que deseja restaurar o banco de dados?", this)
                 != JOptionPane.YES_OPTION)
        {
        }
        else
        {
            try
            {
                RestoreManager rm = createManager();
                SwingUtils.mostrarAviso(this, "<html>Durante a restauração uma "
                   + "janela com fundo escura será aberta.<br>Não feche essa janela!");
                final DlgStatusRestore dlg = new DlgStatusRestore();
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run ()
                    {
                        dlg.setVisible(true);
                    }

                });
                new MeuSw(rm, dlg).execute();
            }
            catch (IllegalArgumentException e)
            {
                SwingUtils.mostrarMensagemDeErroConhecido(this, e.getMessage());
            }
        }
    }

    private RestoreManager createManager ()
    {
        TIPO_BACKUP tipo;
        if (rdbApenasDados.isSelected())
        {
            tipo = TIPO_BACKUP.DADOS;
        }
        else
        {
            tipo = TIPO_BACKUP.DADOS_E_IMAGENS;
        }
        Date selectedDate = (Date) scroller.getSelectedResult()[0];
        return new RestoreManager(tipo, filesMap.get(selectedDate));
    }

    private void atualizarDadosTabela ()
    {
        File pastaBackups = new File(txtPastaDeBackups.getText());
        configTabela(RestoreManager.buscarArquivosDeBackup(pastaBackups));
    }

    private void configTabela (Map<Date, File> arquivosBkp)
    {
        scroller.updateResultList(new MeuRg(arquivosBkp));
    }

    //<editor-fold defaultstate="collapsed" desc="Components do Form">

    private ButtonGroup buttonGroup = new ButtonGroup();
    private MyJRadioButton rdbApenasDados = new MyJRadioButton("Apenas dados");
    private MyJRadioButton rdbDadosEImagens = new MyJRadioButton("Dados e imagens");
    private MyJButton btnConfirmar = new MyJButton("Iniciar");
    private MyJButton btnCancelar = new MyJButton("Cancelar");
    private MyJTextField txtPastaDeBackups = new MyJTextField();
    private BtnFileChooser btnDirChooser = new BtnFileChooser(txtPastaDeBackups, BtnFileChooser.ESCOLHER_DIRETORIO);
    private ScrollResultsDaBusca scroller = new ScrollResultsDaBusca(new MeuTc());

    {

        buttonGroup.add(rdbApenasDados);
        buttonGroup.add(rdbDadosEImagens);
        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));

        rdbApenasDados.setSelected(true);

        txtPastaDeBackups.addDocumentListener(new TxtChangedListener()
        {

            @Override
            public void textChanged (DocumentEvent de)
            {
                atualizarDadosTabela();
            }
        });

        btnCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                dispose();
            }

        });

        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction();
            }

        });

        scroller.setCellRenderer(0, new MyDateRenderer(
                Constantes.TIMESTAMP_AMPM_OFF, SwingConstants.LEFT));

    }

    //</editor-fold>

    @Override
    public void fechar ()
    {
        setVisible(false);
    }

    private class DlgStatusRestore extends MyJDialog
    {

        private JProgressBar progressBar;
        private JLabel lblAguarde = new JLabel("Operação demorada em andamento. \nAguarde...");
        private JButton btnOk = new JButton("Ok");
        private MyJPanel pnl = new MyJPanel(new BorderLayout(10, 10));
        private boolean restoreOk;

        private DlgStatusRestore ()
        {
            super(DlgRestore.this, true, 350, 100);
            progressBar = new JProgressBar();
            progressBar.setIndeterminate(true);
            progressBar.setForeground(Color.BLUE);
            btnOk.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                    if (!restoreOk)
                    {
                        SwingUtils.mostrarMsgDeInformacao(DlgStatusRestore.this,
                               "Clique no botão iniciar para tentar novamente!");
                    }
                    fechar();
                }

            });
            lblAguarde.setHorizontalAlignment(SwingConstants.CENTER);
            pnl.add(new MyJScrollPane(lblAguarde), BorderLayout.CENTER);
            pnl.add(progressBar, BorderLayout.SOUTH);
            add(pnl, BorderLayout.CENTER);
            setUndecorated(true);
        }

        private void restoreTerminou (Exception ex)
        {
            pnl.remove(progressBar);
            pnl.add(btnOk, BorderLayout.SOUTH);
            restoreOk = ex == null;
            if (restoreOk)
            {
                lblAguarde.setText("Restauração realizada com sucesso");
            }
            else
            {
                String msg = ex.getMessage();
                if (msg.contains(":"))
                {
                    msg = msg.substring(msg.indexOf(':') + 2);
                    lblAguarde.setText("<html>" + msg + "</html>");
                }
                else
                {
                    msg = "<html>" + msg + "</html>";
                    lblAguarde.setText(msg);
                }
            }
            pnl.revalidate();
        }

        @Override
        public void fechar ()
        {
            if (btnOk.isVisible())
            {
                dispose();
                if (restoreOk)
                {
                    DlgRestore.this.fechar();
                }
            }
            else
            {
                SwingUtils.mostrarAviso(this, "Aguarde o fim do processo!");
            }
        }

    }

    private class MeuSw extends SwingWorker<Object, Object>
    {

        private RestoreManager restoreManager;
        private DlgStatusRestore dlgStatusRestore;

        private MeuSw (RestoreManager rm, DlgStatusRestore dlg)
        {
            this.restoreManager = rm;
            this.dlgStatusRestore = dlg;
        }

        @Override
        protected Object doInBackground () throws Exception
        {
            restoreManager.executar();
            return null;
        }

        @Override
        protected void done ()
        {
            try
            {
                get();
                dlgStatusRestore.restoreTerminou(null);
            }
            catch (InterruptedException | ExecutionException ex)
            {
                ex.printStackTrace();
                dlgStatusRestore.restoreTerminou(ex);
            }
        }

    }

    private class MeuRg implements ResultsGenerator
    {

        private Map<Date, File> arquivosBkp;

        private MeuRg (Map<Date, File> arquivosBkp)
        {
            this.arquivosBkp = arquivosBkp;
        }

        @Override
        public java.util.List<Object[]> generateResults ()
        {
            java.util.List<Object[]> resposta = new ArrayList<>();
            for (Iterator<Date> it = arquivosBkp.keySet().iterator(); it.hasNext();)
            {
                resposta.add(new Object[] { it.next() } );
            }
            filesMap.clear();
            filesMap.putAll(arquivosBkp);
            return resposta;
        }

    }

    private class MeuTc implements TableConfigurator
    {

        @Override
        public String[] columnsTitles ()
        {
            return new String [] { "Data" };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?> [] {Date.class};
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int [] {0} ;
        }

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean [] { true } ;
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int [] { 0, 0 } ;
        }

    }

}
