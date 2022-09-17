/*
 * PnlAuditoria.java
 *
 * Created on 21/03/2012, 09:29:44
 */
package com.ic.projects.laudoecia.view.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.ic.projects.laudoecia.view.dialogs.DlgVisualizarHTML;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.model.cnv.ConversorDateTimeStampString;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.entidade.CampoDaEnt;
import com.lib.swing.crud.entidade.PnlDaEntidade;
import com.lib.swing.plus.cps.MyJComboBox;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.renderers.MyMultilineCellRenderer;
import com.lib.swing.plus.utils.CmbEnum;
import com.lib.swing.utils.TableConfigurator;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class PnlAuditoria extends PnlDaEntidade<AcaoDoUsuario>
{

    public PnlAuditoria ()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 2;
        add(new CampoDaEnt("Usuário Responsável", false, false).setComponent(txtUsuario), c);
        c.gridx = 2;
        c.gridwidth = 1;
        add(new CampoDaEnt("Estação de trabalho", true, false).setComponent(txtEstacao), c);
        c.gridx = 3;
        add(new CampoDaEnt("Tipo da Ação", true, false).setComponent(cmbTipo), c);
        c.gridx = 4;
        add(new CampoDaEnt("Rotina", true, false).setComponent(cmbTabela), c);

        c.gridy = 1;
        c.gridx = 0;
        add(new CampoDaEnt("Cód. Registro", false, true).setComponent(txtCodigoDoRegistro), c);
        c.gridx = 1;
        c.gridwidth = 3;
        add(new CampoDaEnt("Descrição do Registro", true, true).setComponent(txtRegistro), c);
        c.gridx = 4;
        c.gridwidth = 1;
        add(new CampoDaEnt("Data da Ação", true, true).setComponent(txtDataAcao), c);

        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 5;
        c.weighty = 1;
        add(new CampoDaEnt("Alterações do Registro", false, true).setComponent(scrpTblAlteracoes), c);

        c.gridy = 3;
        c.gridwidth = 1;
        c.weighty = 0;
        c.gridx = 0;
        add(Box.createHorizontalStrut(80), c);
        c.gridx = 1;
        c.weightx = 1;
        add(Box.createHorizontalStrut(0), c);
        c.gridx = 2;
        c.weightx = 0;
        add(Box.createHorizontalStrut(200), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(110), c);
        c.gridx = 4;
        add(Box.createHorizontalStrut(190), c);

    }

    @Override
    protected boolean mostrarDadosDaEntidadeOk (AcaoDoUsuario entidade, int contador)
    {
        txtUsuario.setText(entidade.getUsuario().getNome());
        EstacaoDeTrabalho estacao = entidade.getEstacao();
        if (estacao == null)
        {
            txtEstacao.setText("");
        }
        else
        {
            txtEstacao.setText(estacao.toString());
        }
        cmbTipo.setSelectedItem(entidade.getTipo());
        cmbTabela.setSelectedItem(entidade.getTabela());
        txtDataAcao.setText(entidade.getDataDaAcao());
        txtRegistro.setText(entidade.getRegistro());
        txtCodigoDoRegistro.setText(entidade.getCodigoDoRegistro());
        alimentarTabelaDeAcoes(entidade.getAlteracoes());
        return true;
    }

    private MyJTextField txtUsuario = new MyJTextField();
    private MyJTextField txtEstacao = new MyJTextField();
    private CmbEnum<TIPO_ACAO_DO_USUARIO> cmbTipo = new CmbEnum<>(TIPO_ACAO_DO_USUARIO.ADICIONAR, null);
    private MyJComboBox<String> cmbTabela = new MyJComboBox<>(StaticInfo.getEntidadesAuditaveis());
    private MyJTextField txtDataAcao = new MyJTextField();
    private MyJTextField txtRegistro = new MyJTextField();
    private MyJTextField txtCodigoDoRegistro = new MyJTextField();
    private ScrollResultsDaBusca scrpTblAlteracoes = new ScrollResultsDaBusca(new TableConfigurator()
    {

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean[]
                    {
                        true, true, true, false
                    };
        }

        @Override
        public String[] columnsTitles ()
        {
            return new String[]
                    {
                        "Campo", "Valor Antigo", "Valor Novo", "Ação"
                    };
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?>[]
                    {
                        String.class, Object.class, Object.class, String.class
                    };
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int[]
                    {
                        0, 0, 0, 100
                    };
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int[] { 0 };
        }

    });

    {
        txtDataAcao.setConversorDeData(new ConversorDateTimeStampString(true));
        scrpTblAlteracoes.getTabela().setDefaultRenderer(String.class, new MyMultilineCellRenderer());
        scrpTblAlteracoes.getTabela().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    int row = scrpTblAlteracoes.getTabela().rowAtPoint(e.getPoint());
                    int col = scrpTblAlteracoes.getTabela().columnAtPoint(e.getPoint());
                    Object o = scrpTblAlteracoes.getTabela().getValueAt(row, col);
                    if (o instanceof HtmlCellRenderer)
                    {
                        DlgVisualizarHTML dlg = new DlgVisualizarHTML(
                                PnlAuditoria.this, ((HtmlCellRenderer) o).getHtml());
                        dlg.setVisible(true);
                    }
                }
            }

        });
    }

    private void alimentarTabelaDeAcoes (final List<AltDeRegistro> alteracoes)
    {
        scrpTblAlteracoes.updateResultList(new ResultsGenerator()
        {
            @Override
            public List<Object[]> generateResults ()
            {
                List<Object[]> result = new ArrayList<>();
                for (int i = 0; i < alteracoes.size(); i++)
                {
                    AltDeRegistro a = alteracoes.get(i);
                    Object[] item = new Object[4];
                    item[0] = a.getCampo();
                    if (a.getValorOriginal().contains("<html") ||
                        a.getValorOriginal().contains("<font") ||
                        a.getValorOriginal().contains("<div") ||
                        a.getValorOriginal().contains("<table"))
                    {
                        item[1] = new HtmlCellRenderer(a.getValorOriginal());
                    }
                    else
                    {
                        item[1] = a.getValorOriginal();
                    }
                    if (a.getValorAposAlteracao().contains("<html") ||
                        a.getValorAposAlteracao().contains("<font") ||
                        a.getValorAposAlteracao().contains("<div") ||
                        a.getValorAposAlteracao().contains("<table"))
                    {
                        item[2] = new HtmlCellRenderer(a.getValorAposAlteracao());
                    }
                    else
                    {
                        item[2] = a.getValorAposAlteracao();
                    }
                    item[3] = a.getTipo();
                    result.add(item);
                }
                return result;
            }

        });
    }

    private class HtmlCellRenderer
    {
        private String html;

        private HtmlCellRenderer (String html)
        {
            this.html = html;
        }

        public String getHtml ()
        {
            return html;
        }

        @Override
        public String toString ()
        {
            return "Duplo clique para visualizar.";
        }
    }

}
