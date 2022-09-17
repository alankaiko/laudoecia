/*
 * DlgExportarImgVideos.java
 *
 * Created on 30/05/2012, 16:10:25
 */
package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.laudoecia.LaudoeCiaMediator;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.notentities.SCSIDevice;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.utils.CDRecorder;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.BtnFileChooser;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgExportarImgVideos extends MyJDialog
{
    private LaudoeCiaMediator mediador;
    private boolean alterarDispGravEstTrab = false;

    public DlgExportarImgVideos (LaudoeCiaMediator mediador)
    {
        super(FormPrincipal.getInstance(), true, 490, 210);
        this.mediador = mediador;
        setTitle("Exportar Imagens e Vídeos do Atendimento");
        setIconImage(FormPrincipal.getInstance().getIconImage());
        initComponents();
        listarDevicesEstTrabalho();
        habilitarComponentes(false);
    }

    private void initComponents ()
    {
        MyJPanel pnlExportar = new MyJPanel(new GridLayout(1, 3));
        pnlExportar.add(rdbApenasImagens);
        pnlExportar.add(rdbApenasVideos);
        pnlExportar.add(rdbImagensVideos);

        MyJPanel pnlBotoes = new MyJPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBotoes.add(btnCD);
        pnlBotoes.add(btnPC);

        MyJPanel pnl = new MyJPanel();
        pnl.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        pnl.add(new PnlComp("Exportar: ", false, true).setComponent(pnlExportar), c);
        c.gridy = 1;
        pnl.add(new PnlComp(false, true).setComponent(pnlBotoes), c);
        c.gridwidth = 1;
        c.weightx = 1;
        c.gridy = 2;
        pnl.add(new PnlComp("Dispositivo de gravação CD/DVD", false, true).setComponent(cmbDevices), c);
        c.gridx = 1;
        c.weightx = 0;
        pnl.add(new PnlComp(true, true).setComponent(btnBuscarDev), c);
        pnl.add(Box.createHorizontalStrut(100), c);
        this.add(pnl);
    }

    private void listarDevicesEstTrabalho ()
    {
        EstacaoDeTrabalho estTrabalho = StaticInfo.getEstTrabalho();
        String disp = estTrabalho.getDispositivoGrav();
        if (disp == null || disp.isEmpty())
        {
            btnBuscarDevAction();
        }
        else
        {
            SCSIDevice dev = SCSIDevice.toSCSIDevice(disp);
            if (dev == null)
            {
                btnBuscarDevAction();
            }
            else
            {
                List<SCSIDevice> model = new ArrayList<>();
                model.add(dev);
                cmbDevices.setModel(model);
                cmbDevices.setSelectedIndex(0);
            }
        }
    }

    private void btnCDAction ()
    {
        final SCSIDevice dispSel = cmbDevices.getSelectedItem();
        if (validarDispGravEstTrab(dispSel))
        {
            int tipoExport = getTipoExportacao();
            if (mediador.iniciarGravacaoNoDisco(tipoExport, dispSel.deviceString()))
            {
                dispose(); //se iniciou a gravação fecha dlg
            }
        }
    }

    private void habilitarComponentes(boolean b)
    {
        btnCD.setEnabled(b);
        btnPC.setEnabled(b);
        cmbDevices.setEnabled(b);
        btnBuscarDev.setEnabled(b);
    }

    private boolean validarDispGravEstTrab (final SCSIDevice dispSel)
    {
        if (dispSel == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(this, "Selecione o dispositivo.\nSe não há dispositivos listados, clique em buscar para que o sistema\ndetecte os dispositivos do seu computador.");
            return false;
        }
        if (alterarDispGravEstTrab)
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run ()
                {
                    mediador.alterarDispositivoEstTrabalho(dispSel.toString());
                }
            });
        }
        return true;
    }

    private int getTipoExportacao ()
    {
        if (rdbApenasImagens.isSelected())
        {
            return LaudoeCiaMediator.EXP_APENAS_IMAGENS;
        }
        else if (rdbApenasVideos.isSelected())
        {
            return LaudoeCiaMediator.EXP_APENAS_VIDEOS;
        }
        else
        {
            return LaudoeCiaMediator.EXP_IMAGENS_VIDEOS;
        }
    }

    private void btnPCAction (File pasta)
    {
        int tipoExport = getTipoExportacao();
        mediador.iniciarGravacaoNaPasta(tipoExport, pasta.getAbsolutePath());
    }

    private void btnBuscarDevAction ()
    {
        alterarDispGravEstTrab = true;
        cmbDevices.setModel(CDRecorder.getDevices());
        for (int i = 0; i < cmbDevices.getItemCount(); i++)
        {
            ComboBoxModel<SCSIDevice> model = cmbDevices.getModel();
            if (model.getElementAt(i).getDescription().contains("Removable CD-ROM"))
            {
                cmbDevices.setSelectedIndex(i);
                break;
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Components do Form">

    private ButtonGroup btgAdicionar = new ButtonGroup();
    private MyJRadioButton rdbApenasImagens = new MyJRadioButton("Apenas Imagens");
    private MyJRadioButton rdbApenasVideos = new MyJRadioButton("Apenas Vídeos");
    private MyJRadioButton rdbImagensVideos = new MyJRadioButton("Imagens e Vídeos");
    private MyJButton btnCD = new MyJButton("Exportar para CD/DVD");
    private BtnFileChooser.FileReceiver fileReceiver = new BtnFileChooser.FileReceiver() {
        @Override
        public void fileChosen (File file)
        {
            btnPCAction(file);
        }
    };
    private BtnFileChooser btnPC = new BtnFileChooser(fileReceiver, BtnFileChooser.ESCOLHER_DIRETORIO);
    private MyJComboBox<SCSIDevice> cmbDevices = new MyJComboBox<>();
    private MyJButton btnBuscarDev = new MyJButton();

    {
        ItemListener selRdb = new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (!btnCD.isEnabled() && (rdbApenasImagens.isSelected() ||
                    rdbApenasVideos.isSelected() ||
                    rdbImagensVideos.isSelected()))
                {
                    habilitarComponentes(true);
                }
            }
        };
        btgAdicionar.add(rdbApenasImagens);
        btgAdicionar.add(rdbApenasVideos);
        btgAdicionar.add(rdbImagensVideos);
        rdbApenasImagens.addItemListener(selRdb);
        rdbApenasVideos.addItemListener(selRdb);
        rdbImagensVideos.addItemListener(selRdb);

        btnCD.setIcon(ImageResources.getIcon(ImagensLC.CD));
        btnPC.setIcon(ImageResources.getIcon(ImagensLC.COMPUTADOR));
        btnPC.setText("Exportar para outro local");

        btnCD.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnCDAction();
            }
        });

        btnBuscarDev.setIcon(SwingLibResources.getIcon(Imagens.BUSCA));
        btnBuscarDev.setText("Buscar");
        btnBuscarDev.setToolTipText("Buscar dispositivos de gravação.");
        btnBuscarDev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnBuscarDevAction ();
            }
        });
    }

    //</editor-fold>

    @Override
    public void fechar ()
    {
        dispose();
    }

}
