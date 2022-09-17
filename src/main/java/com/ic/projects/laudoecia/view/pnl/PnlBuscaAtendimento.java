/*
 * PnlBuscaAtendimento.java
 *
 * Created on 23/04/2012, 08:23:15
 */
package com.ic.projects.laudoecia.view.pnl;

import com.ic.projects.laudoecia.control.cadastro.C_BuscaAtendimento;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.enums.STATUS_LAUDO;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.cadastro.IFrameAtendimentos;
import com.ic.projects.laudoecia.view.cadastro.IFrameAuditoria;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.java.utils.DateUtils;
import com.lib.swing.crud.busca.DefBuilder;
import com.lib.swing.crud.busca.PnlBusca;
import com.lib.swing.crud.entidade.ComponentReader;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlBuscaAtendimento extends DefBuilder
{

    private final IFrameAtendimentos iframe;

    //<editor-fold defaultstate="collapsed" desc="Components">

    private MyJComboBox<String> cmbStatusLaudo;
    private MyJComboBox<String> cmbDatas;
    private TxtData txtDataIni;
    private TxtData txtDataFin;
    private ComponentReader txtDataReader = new ComponentReader()
    {
        @Override
        public Object getParamFromComp (Component component)
        {
            TxtData txt = (TxtData) component;
            return txt.getDate();
        }

    };
    private KeyAdapter txtKeyListener = new KeyAdapter()
    {
        @Override
        public void keyReleased (KeyEvent e)
        {
            pnlBusca.parametroDeBuscaChanged();
        }

    };

    //</editor-fold>

    public PnlBuscaAtendimento (TableConfigurator tc, IFrameAtendimentos iframe)
    {
        super(tc);
        this.iframe = iframe;
    }

    @Override
    protected PnlBusca criarPnlBusca ()
    {
        return new PnlBusca(pnlParamsBusca, scroll) {

            @Override
            public void cardSelected (String cardId)
            {
                switch (cardId)
                {
                    case SimpleC_Cadastro.VIEW_BUSCA:
                        scroll.getTabela().sortColumn(new int[] { 0 } );
                        break;
                    case SimpleC_Cadastro.VIEW_ENTIDADE:
                        scroll.getTabela().sortColumn(new int[] { 0 } );
                        break;
                    default:
                }
            }
        };
    }

    @Override
    public PnlBuscaAtendimento setCmbCampos (int width, String... campos)
    {
        return (PnlBuscaAtendimento) super.setCmbCampos(width, campos);
    }

    @Override
    public PnlBuscaAtendimento setCmbCampos (int width, int selIndex, String... campos)
    {
        return (PnlBuscaAtendimento) super.setCmbCampos(width, selIndex, campos);
    }

    @Override
    public PnlBuscaAtendimento setCmbNumResultados ()
    {
        return (PnlBuscaAtendimento) super.setCmbNumResultados();
    }

    @Override
    public PnlBuscaAtendimento setCmbNumResultados (int selIndex)
    {
        return (PnlBuscaAtendimento) super.setCmbNumResultados(selIndex);
    }

    @Override
    public PnlBuscaAtendimento setTxtBusca (int width)
    {
        PnlBuscaAtendimento p = (PnlBuscaAtendimento) super.setTxtBusca(width);
        getTxtBusca().setLargura(2.0d);
        getTxtBusca().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_F5)
                {
                    getPnlBusca().parametroDeBuscaChanged();
                }
            }
        });
        return p;
    }

    public PnlBuscaAtendimento setCmbData (int width)
    {
        String[] items = new String[]
        {
            "personalizado (todos)", "hoje", "última semana", "últimos 15 dias", "último mês"
        };
        cmbDatas = new MyJComboBox<>(items);
        cmbDatas.setPreferredSize(new Dimension(width, cmbDatas.getPreferredSize().height));
        cmbDatas.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    switch (cmbDatas.getSelectedItem())
                    {
                        case "hoje":
                            txtDataIni.setText(new Date());
                            txtDataFin.setText(new Date());
                            break;
                        case "última semana":
                            txtDataIni.setText(DateUtils.subtrairDiasNaData(new Date(), 7));
                            txtDataFin.setText(new Date());
                            break;
                        case "últimos 15 dias":
                            txtDataIni.setText(DateUtils.subtrairDiasNaData(new Date(), 15));
                            txtDataFin.setText(new Date());
                            break;
                        case "último mês":
                            txtDataIni.setText(DateUtils.subtrairDiasNaData(new Date(), 30));
                            txtDataFin.setText(new Date());
                            break;
                        default:
                            txtDataIni.setText("");
                            txtDataFin.setText("");
                            txtDataIni.requestFocusInWindow();
                    }
                    pnlParamsBusca.parametroDeBuscaChanged();
                }
            }

        });
        pnlParamsBusca.add(cmbDatas, new LblNegrito("no período"), null);
        cmbDatas.setFocusable(false);
        cmbDatas.pintarDeAmarelo();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run ()
            {
                cmbDatas.setSelectedItem("hoje");
            }

        });
        return this;
    }

    public PnlBuscaAtendimento setTxtDataIni (int width)
    {
        txtDataIni = new TxtData();
        txtDataIni.setPreferredSize(new Dimension(width, txtDataIni.getPreferredSize().height));
        txtDataIni.addKeyListener(txtKeyListener);
        pnlParamsBusca.add(txtDataIni, txtDataReader, new LblNegrito(" data inicial"), null);
        return this;
    }

    public PnlBuscaAtendimento setTxtDataFin (int width)
    {
        txtDataFin = new TxtData();
        txtDataFin.setPreferredSize(new Dimension(width, txtDataIni.getPreferredSize().height));
        txtDataFin.addKeyListener(txtKeyListener);
        pnlParamsBusca.add(txtDataFin, txtDataReader, new LblNegrito(" data final"), null);
        return this;
    }

    public PnlBuscaAtendimento setCmbStatusLaudo (int width)
    {
        cmbStatusLaudo = new MyJComboBox<>(STATUS_LAUDO.getStatusComOpcaoAdicional("indiferente"));
        cmbStatusLaudo.setSelectedIndex(0);
        cmbStatusLaudo.addItemListener(defaultItemListener);
        cmbStatusLaudo.setFocusable(false);
        cmbStatusLaudo.setPreferredSize(new Dimension(width, cmbStatusLaudo.getPreferredSize().height));
        pnlParamsBusca.add(cmbStatusLaudo, new ComponentReader() {

        @Override
        public Object getParamFromComp (Component component)
        {
            JComboBox cmb = (JComboBox) component;
            return cmb.getSelectedItem().toString().toUpperCase();
        }
    }, new LblNegrito(" laudo"), null);
        return this;
    }

    public PnlBuscaAtendimento addDefaultPanel ()
    {
        pnlParamsBusca.addDefaultPanel();
        return this;
    }

    @Override
    public void putProperty (String key, Object property)
    {
        if (C_BuscaAtendimento.LICENCA_EXPIROU.equals(key))
        {
            if (Boolean.TRUE.equals(property))
            {
                SwingUtils.mostrarMensagemDeErroConhecido(iframe,
                "Para continuar usando o programa, é preciso obter uma licença!");
                iframe.doDefaultCloseAction();
                return;
            }
        }
        super.putProperty(key, property);
    }

}
