/*
 * PnlBackup.java
 *
 * Created on 09/04/2012, 16:40:24
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.model.cadastro.Backup;
import com.ic.projects.laudoecia.model.enums.STATUS_BACKUP;
import com.ic.projects.laudoecia.model.enums.TIPO_BACKUP;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.java.utils.DateUtils;
import com.lib.model.cnv.ConversorDateTimeStampString;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidadeComCrud;
import com.lib.swing.crud.entidade.validation.RequiredFieldValidator;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.*;
import com.lib.swing.utils.Constantes;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Map;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlBackup extends PnlDaEntidadeComCrud<Backup>
{
    private ConversorDateTimeStampString convDateStr = new ConversorDateTimeStampString(true);

    public PnlBackup ()
    {
        setTemTxtCodigo(false);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        add(new CampoDaEnt("Data marcada", false, false).setComponent(spnDataMarcada), c);
        c.gridx = 1;
        add(new CampoDaEnt("Tipo de backup", true, false).setComponent(cmbTipo
                , false, true, true, true), c);
        c.gridx = 2;
        c.gridwidth = 2;
        add(new CampoDaEnt(true, false).setComponent(lblEstacao), c);

        c.gridy = 1;
        c.gridwidth = 3;
        c.gridx = 0;
        add(new CampoDaEnt("Local p/ salvar backup", false, true).setComponent(txtDirArquivo), c);
        c.gridwidth = 1;
        c.gridx = 3;
        add(new CampoDaEnt(true, true).setComponent(btnDirChooser
                , false, false, true, true), c);

        //<editor-fold defaultstate="collapsed" desc="Add Itens PnlInfo">

        pnlInfo.setLayout(new GridBagLayout());
        c.gridy = 0;
        c.gridx = 0;
        pnlInfo.add(new CampoDaEnt("Status", false, false).setComponent(lblStatus, false, false, false, true), c);
        c.gridx = 1;
        pnlInfo.add(new CampoDaEnt("Data de início", true, false).setComponent(lblDataInicio, false, false, false, true), c);
        c.gridx = 2;
        pnlInfo.add(new CampoDaEnt("Data de término", true, false).setComponent(lblDataTermino, false, false, false, true), c);

        c.gridy = 1;
        c.gridx = 0;
        c.weightx = 1;
        pnlInfo.add(Box.createHorizontalStrut(0), c);
        c.weightx = 0;
        c.gridx = 1;
        pnlInfo.add(Box.createHorizontalStrut(175), c);
        c.gridx = 2;
        pnlInfo.add(Box.createHorizontalStrut(175), c);

        //</editor-fold>

        c.gridy = 2;
        c.gridwidth = 4;
        c.gridx = 0;
        c.weighty = 0.30;
        add(new PnlComp("Informações do backup", false, true).setComponent(pnlInfo), c);

        c.gridy = 3;
        c.weighty = 0.7;
        add(new LblNegrito("Atenção: para backup automático acesse o menu "
                + "Ferramentas->Parâmetros do sistema."), c);

        c.gridy = 4;
        c.gridwidth = 1;
        c.gridx = 0;
        c.weighty = 0.00;
        add(Box.createHorizontalStrut(175), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(175), c);
        c.gridx = 2;
        c.weightx = 1;
        add(Box.createHorizontalStrut(0), c);
        c.weightx = 0;
        c.gridx = 3;
        add(Box.createHorizontalStrut(50), c);

    }

    @Override
    protected void configurarValidacao (Map<String, C_Validacao> validadores)
    {
        formValidator.add(spnDataMarcada, new RequiredFieldValidator(spnDataMarcada));
        formValidator.add(cmbTipo, new RequiredFieldValidator(cmbTipo));
        formValidator.add(txtDirArquivo, new RequiredFieldValidator(txtDirArquivo));
    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (Backup entidade, int contador)
    {
        if (entidade.getDataMarcada() == null)
        {
            spnDataMarcada.setValue(new Date());
        }
        else
        {
            spnDataMarcada.setValue(entidade.getDataMarcada());
        }
        cmbTipo.setSelectedItem(entidade.getTipo());
        txtDirArquivo.setText(entidade.getDiretorioDoArquivo());
        STATUS_BACKUP status = entidade.getStatus();
        lblEstacao.setText(entidade.getEstacao() == null ? "" :
                           "Estação solicitante: " + entidade.getEstacao().toString());
        if (status == null)
        {
            lblStatus.setText(" ");
        }
        else
        {
            lblStatus.setText(" " + entidade.getStatus().getMensagem());
            if (status.isStatusDeErro())
            {
                lblStatus.setForeground(corVermelho);
            }
            else
            {
                lblStatus.setForeground(corVerde);
            }
        }
        if (entidade.getDataDeInicio() == null)
        {
            lblDataInicio.setText(" -");
        }
        else
        {
            lblDataInicio.setText(" " + convDateStr.convertForward(entidade.getDataDeInicio()));
        }
        if (entidade.getDataDeTermino() == null)
        {
            lblDataTermino.setText(" -");
        }
        else
        {
            lblDataTermino.setText(" " + convDateStr.convertForward(entidade.getDataDeTermino()));
        }
        return true;
    }

    @Override
    public void prepararParaAdicionar (Object dadosIniciais)
    {
        spnDataMarcada.getTextField().requestFocusInWindow();
    }

    @Override
    public void prepararParaAlterar (boolean pnlEntidadeWasSelected)
    {
        spnDataMarcada.getTextField().requestFocusInWindow();
    }

    @Override
    public void preencherDadosDaEntidade (Backup entidadeBase)
    {
        entidadeBase.setDataMarcada(spnDataMarcada.getValue());
        Date dataMarcada = entidadeBase.getDataMarcada();
        Date newDate = new Date();
        if (dataMarcada.before(newDate) || newDate.equals(dataMarcada) ||
            DateUtils.diferencaDeMinutos(newDate, dataMarcada) < 3)
        {
            // caso o relogio do servidor esteja atrasado
            // essa abordagem esta ok pois o que vale no backup eh a data inicio
            // e nao a data marcada, portanto o horario do arquivo eh confiavel
            entidadeBase.setDataMarcada(DateUtils.subtrairMinutosNaData(newDate, 15));
        }
        entidadeBase.setTipo(cmbTipo.getSelectedItem());
        entidadeBase.setDiretorioDoArquivo(txtDirArquivo.getText());
    }

    //<editor-fold defaultstate="collapsed" desc="Components do Formulario">

    private SpinnerData spnDataMarcada = new SpinnerData(Constantes.TIMESTAMP);
    private CmbEnum<TIPO_BACKUP> cmbTipo = new CmbEnum<>(TIPO_BACKUP.DADOS, TIPO_BACKUP.DADOS);
    private MyJTextField txtDirArquivo = new MyJTextField();
    private BtnFileChooser btnDirChooser = new BtnFileChooser(txtDirArquivo, BtnFileChooser.ESCOLHER_DIRETORIO);
    private MyJPanel pnlInfo = new MyJPanel();
    private MyJLabel lblStatus = new MyJLabel();
    private MyJLabel lblDataInicio = new MyJLabel();
    private MyJLabel lblDataTermino = new MyJLabel();
    private MyJLabel lblEstacao = new MyJLabel();
    private Color corVerde = new Color(0, 102, 0);
    private Color corAzul = Color.blue;
    private Color corVermelho = Color.red;

    {
        pnlInfo.setBorder(new CompoundBorder(new LineBorder(Color.LIGHT_GRAY),
                new EmptyBorder(5, 5, 5, 5)));
        lblDataInicio.setForeground(corAzul);
        lblDataTermino.setForeground(corAzul);
        cmbTipo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.getKeyChar() == '\n')
                {
                    btnDirChooser.requestFocusInWindow();
                }
            }

        });
        lblEstacao.setHorizontalAlignment(SwingConstants.TRAILING);
        lblEstacao.setForeground(corVerde);
    }

    //</editor-fold>

}
