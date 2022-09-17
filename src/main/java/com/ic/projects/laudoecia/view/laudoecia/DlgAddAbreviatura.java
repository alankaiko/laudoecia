/*
 * DlgAddAbreviatura.java
 *
 * Created on 30/04/2014, 11:37:51
 */

package com.ic.projects.laudoecia.view.laudoecia;

import com.ic.projects.laudoecia.dao.cadastro.DaoAbreviatura;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.build.TelaSolPadrao;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.java.utils.SystemUtils;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.crud.busca.TxtBuscaKeyListener;
import com.lib.swing.crud.cadastro.ReceptorDeBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.cps.MyJTextField;
import com.lib.swing.plus.utils.BtnFKey;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.plus.utils.TxtChangedListener;
import com.lib.swing.utils.SwingUtils;
import com.lib.swing.utils.TableConfigurator;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DlgAddAbreviatura extends MyJDialog
{
    private static final DaoAbreviatura dao = new DaoAbreviatura();
    private boolean cancelado = true;

    public DlgAddAbreviatura ()
    {
        super(FormPrincipal.getInstance(), true, 600, 250);
        setTitle("Inserir abreviatura...");
        setIconImage(FormPrincipal.getInstance().getIconImage());
        setLocationRelativeTo(null);
        initializeComponents();
        buscaMudou();
    }

    private void initializeComponents ()
    {
        MyJPanel pnl = new MyJPanel();
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        pnl.add(new PnlComp("Busque pela abreviatura", false, false).setComponent(txtBusca), c);
        c.weightx = 0;
        c.gridx = 1;
        pnl.add(new PnlComp("", true, false).setComponent(btnConfirmar), c);
        c.gridx = 2;
        pnl.add(new PnlComp("", true, false).setComponent(btnCadastrar), c);
        c.gridwidth = 3;
        c.weighty = 1;
        c.gridy = 1;
        c.gridx = 0;
        pnl.add(new PnlComp(false, true).setComponent(scroll), c);
        add(new PnlComEspaco(pnl));
    }

    //<editor-fold defaultstate="collapsed" desc="Componentes">

    private final MyJTextField txtBusca = new MyJTextField();
    private final MyJButton btnConfirmar = new MyJButton("OK");
    private final BtnFKey btnCadastrar = new BtnFKey();
    private final ScrollResultsDaBusca scroll = new ScrollResultsDaBusca(new TableConfigurator()
    {

        @Override
        public String[] columnsTitles ()
        {
            return new String [] { "Abreviatura", "Texto extendido" } ;
        }

        @Override
        public Class<?>[] columnsClasses ()
        {
            return new Class<?> [] {String.class, String.class};
        }

        @Override
        public int[] columnsWidths ()
        {
            return new int [] { 100, 500 } ;
        }

        @Override
        public boolean[] shouldResizeColumns ()
        {
            return new boolean [] { true, true};
        }

        @Override
        public int[] sortedColumns ()
        {
            return new int [] { 0 };
        }
    });

    {

        txtBusca.addDocumentListener(new TxtChangedListener()
        {

            @Override
            public void textChanged (DocumentEvent de)
            {
                buscaMudou();
            }
        });
        txtBusca.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    btnConfirmarAction();
                }
            }
        });
        txtBusca.addKeyListener(new TxtBuscaKeyListener(scroll));

        btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnConfirmarAction();
            }

        });

        btnCadastrar.addActionListener(new ActionAddTela(
                TelaPrincipal.DLG_ABREVIATURAS, new TelaSolPadrao(
                TelaPrincipal.TELA_NULL, new MyJTextField(),
                new ReceptorDeBusca()
                {
                    @Override
                    public boolean isHabilitadoParaReceber ()
                    {
                        return true;
                    }

                    @Override
                    public void receberBusca (Object o)
                    {
                        if (o != null && o instanceof Abreviatura)
                        {
                            confirmar(((Abreviatura) o).getTexto());
                        }
                    }

                })));

        scroll.getTabela().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked (MouseEvent e)
            {
                if (e.getClickCount() == 2 && scroll.getTabela().getSelectedRow() >= 0)
                {
                    btnConfirmarAction();
                }
            }
        });

    }

    //</editor-fold>

    private void buscaMudou ()
    {
        scroll.updateResultList(new ResultsGenerator()
        {
            @Override
            public List<Object[]> generateResults ()
            {
                return dao.buscarPorAbrev(txtBusca.getText());
            }
        });
    }

    private void btnConfirmarAction ()
    {
        if (validarCampos())
        {
            confirmar(scroll.getSelectedResult()[1].toString());
        }
    }

    private void confirmar (String textoExtenso)
    {
        cancelado = false;
        SystemUtils.setClipboardContents(textoExtenso);
        dispose();
    }

    private boolean validarCampos ()
    {
        if (scroll.getSelectedResult() == null)
        {
            SwingUtils.mostrarMensagemDeErroConhecido(
                    this, "Você deve selecionar uma abreviatura na tabela.");
            return false;
        }
        return true;
    }

    public boolean isCancelado ()
    {
        return cancelado;
    }

    @Override
    public void fechar ()
    {
        dispose();
    }

}
