/*
 * PnlBuscaAuditoria.java
 *
 * Created on 20/03/2012, 10:13:32
 */
package com.ic.projects.laudoecia.view.pnl;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDeUsuarios;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.lib.java.utils.DateUtils;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.crud.busca.AbstractPnlBuscaBuilder;
import com.lib.swing.crud.entidade.ComponentReader;
import com.lib.swing.maskedfields.TxtData;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlBuscaAuditoria extends AbstractPnlBuscaBuilder
{
    
    //<editor-fold defaultstate="collapsed" desc="Componentes do Builder">
    
    private TxtComAutoCompletar txtUsuario;
    private MyJComboBox<String> cmbTipoAcao;
    private MyJComboBox<String> cmbTabela;
    private MyJComboBox<String> cmbDatas;
    private TxtData txtDataIni;
    private TxtData txtDataFin;
    private MyJTextField txtRegistro;
    private MyJTextField txtCodigo;
    private MyJComboBox<Integer> cmbNumResultados;
    private BuscadorDeUsuarios buscadorUsuarios = new BuscadorDeUsuarios();
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

    public PnlBuscaAuditoria (TableConfigurator tc)
    {
        super(tc);
        addTxtUsuario(150);
        addCmbTipoAcao();
        addCmbTabela(200);
        pnlParamsBusca.addDefaultPanel();
        addCmbData(170);
        addTxtDataIni(145);
        addTxtDataFin(145);
        pnlParamsBusca.addDefaultPanel();
        addTxtRegistro(190);
        addTxtCodigo(70);
        addCmbNumResultados(5);
    }

    private void addCmbNumResultados (int selIndex)
    {
        cmbNumResultados = criarCmbNumResultados(selIndex);
        pnlParamsBusca.add(cmbNumResultados, cmbReader, new LblNegrito(" ver apenas"),
                           new LblNegrito("resultados"));
    }

    private void addTxtUsuario (int width)
    {
        txtUsuario = criarTxtBusca(width);
        txtUsuario.setControlador(buscadorUsuarios);
        pnlParamsBusca.add(txtUsuario, new ComponentReader()
        {
            @Override
            public Object getParamFromComp (Component component)
            {
                return buscadorUsuarios.getSelectedModel();
            }

        }, new LblNegrito("Procurar por usuário"), null);
        pnlParamsBusca.setFocusedComponent(txtUsuario);
    }

    private void addCmbTipoAcao ()
    {
        cmbTipoAcao = new MyJComboBox<>(TIPO_ACAO_DO_USUARIO.getAcoesComOpcaoAdicional("TODAS"));
        cmbTipoAcao.addItemListener(defaultItemListener);
        pnlParamsBusca.add(cmbTipoAcao, cmbReader, new LblNegrito(" tipo de ação"), null);
    }

    private void addCmbTabela (int width)
    {
        cmbTabela = new MyJComboBox<>(StaticInfo.getEntidadesAuditaveis("TODAS"));
        cmbTabela.setSelectedIndex(0);
        cmbTabela.addItemListener(defaultItemListener);
        cmbTabela.setPreferredSize(new Dimension(width, cmbTabela.getPreferredSize().height));
        pnlParamsBusca.add(cmbTabela, cmbReader, new LblNegrito(" na rotina"), null);
    }

    private void addCmbData (int width)
    {
        String[] items = new String[]
        {
            "personalizado", "hoje", "última semana", "últimos 15 dias", "último mês"
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
    }

    private void addTxtDataIni (int width)
    {
        txtDataIni = new TxtData();
        txtDataIni.setPreferredSize(new Dimension(width, txtDataIni.getPreferredSize().height));
        txtDataIni.addKeyListener(txtKeyListener);
        pnlParamsBusca.add(txtDataIni, txtDataReader, new LblNegrito(" que está entre a data"), null);
    }

    private void addTxtDataFin (int width)
    {
        txtDataFin = new TxtData();
        txtDataFin.setPreferredSize(new Dimension(width, txtDataIni.getPreferredSize().height));
        txtDataFin.addKeyListener(txtKeyListener);
        pnlParamsBusca.add(txtDataFin, txtDataReader, new LblNegrito(" e a data"), null);
    }

    private void addTxtRegistro (int width)
    {
        txtRegistro = new MyJTextField();
        txtRegistro.setPreferredSize(new Dimension(width, txtRegistro.getPreferredSize().height));
        txtRegistro.addKeyListener(txtKeyListener);
        pnlParamsBusca.add(txtRegistro, txtCompReader, new LblNegrito("descrição do registro"), null);
    }

    private void addTxtCodigo (int width)
    {
        txtCodigo = new MyJTextField();
        txtCodigo.setPreferredSize(new Dimension(width, txtCodigo.getPreferredSize().height));
        txtCodigo.addKeyListener(txtKeyListener);
        pnlParamsBusca.add(txtCodigo, txtCompReader, new LblNegrito("ou código do registro"), null);
    }

}
