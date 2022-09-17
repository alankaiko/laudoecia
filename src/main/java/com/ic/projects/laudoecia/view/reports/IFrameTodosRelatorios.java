/*
 * IFrameTodosRelatorios.java
 *
 * Created on 02/04/2012, 14:06:34
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.build.ActionAddTela;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.*;
import com.lib.swing.plus.utils.PnlComEspaco;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public final class IFrameTodosRelatorios extends MyJInternalFrame
{
    private boolean mostrarCadastrosDoControleDeAcesso;

    public IFrameTodosRelatorios ()
    {
        super("Relatórios do sistema");
        setSize(650, 370);
        this.mostrarCadastrosDoControleDeAcesso = ControladorDeAcesso.getInstance().mostrarCadastrosDoControleDeAcesso();
        initializeComponents();
    }

    public void initializeComponents ()
    {
        //Relatórios de Atendimentos
        JPanel pnlTabAtd = new JPanel(new GridBagLayout());
        pnlTabAtd.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black), new EmptyBorder(10, 10, 10, 10)));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridy = 0;
        c.gridx = 0;
        pnlTabAtd.add(addItemRelatorio("Relatório completo", new ActionAddTela(TelaPrincipal.REL_ATD_COMPLETO,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaRelAtendCompleto();
                    }
                })), c);
        c.gridy = 1;
        pnlTabAtd.add(addItemRelatorio("Relatório resumido", new ActionAddTela(TelaPrincipal.REL_ATD_RESUMOS,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaRelAtendResumos();
                    }
                })), c);
        c.gridy = 2;
        pnlTabAtd.add(addItemRelatorio("Relatório por convênio", new ActionAddTela(TelaPrincipal.REL_ATD_POR_CONVENIO,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaRelAtendPorConvenio();
                    }
                })), c);
        c.gridy = 3;
        pnlTabAtd.add(addItemRelatorio("Relatório por procedimento médico", new ActionAddTela(TelaPrincipal.REL_ATD_POR_PROC_MED,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaRelAtendPorProcMedico();
                    }
                })), c);
        c.gridy = 4;
        pnlTabAtd.add(addItemRelatorio("Relatório por profissional executante / diagnóstico", new ActionAddTela(TelaPrincipal.REL_ATD_POR_PROF_EXE,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaRelAtendPorProfExe();
                    }
                })), c);
        c.gridy = 5;
        pnlTabAtd.add(addItemRelatorio("Relatório por profissional solicitante", new ActionAddTela(TelaPrincipal.REL_ATD_POR_PROF_SOL,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaRelAtendPorProfSol();
                    }
                })), c);
        c.gridy = 0;
        c.gridx = 1;
        pnlTabAtd.add(addItemRelatorio("Gráficos de atendimentos", new ActionAddTela(TelaPrincipal.GRAF_ATDENDIMENTOS,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return p.isAcessaGrafAtendimentos();
                    }
                })), c);
        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 2;
        c.weighty = 1;
        pnlTabAtd.add(Box.createHorizontalStrut(100), c);
        c.gridwidth = 1;
        c.weighty = 0;
        tabPane.addTab("Atendimentos", pnlTabAtd);

        //Relatórios de Cadastros
        JPanel pnlTabCad = new JPanel(new GridBagLayout());
        pnlTabCad.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black), new EmptyBorder(10, 10, 10, 10)));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridy = 0;
        c.gridx = 0;
        pnlTabCad.add(addItemRelatorio("Relatório de convênios", new ActionAddTela(TelaPrincipal.REL_CONVENIOS,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return true;
                    }
                })), c);
        c.gridy = 1;
        pnlTabCad.add(addItemRelatorio("Relatório de pacientes", new ActionAddTela(TelaPrincipal.REL_PACIENTES,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return true;
                    }
                })), c);
        c.gridy = 2;
        pnlTabCad.add(addItemRelatorio("Relatório de procedimentos médicos", new ActionAddTela(TelaPrincipal.REL_PROC_MEDICO,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return true;
                    }
                })), c);
        c.gridy = 3;
        pnlTabCad.add(addItemRelatorio("Relatório de profissionais executantes", new ActionAddTela(TelaPrincipal.REL_PROF_EXEC,
                new AdapterPermissaoDeUsuario(){
                    @Override
                    public boolean podeAcessar (PerfilDeAcesso p)
                    {
                        return true;
                    }
                })), c);
        c.gridy = 4;
        c.weighty = 1;
        pnlTabCad.add(Box.createHorizontalStrut(100), c);
        c.weighty = 0;
        tabPane.addTab("Cadastros", pnlTabCad);

        //Outros Relatorios
        if (mostrarCadastrosDoControleDeAcesso)
        {
            JPanel pnlTab2 = new JPanel(new GridBagLayout());
            pnlTab2.setBorder(new EmptyBorder(10, 10, 10, 10));
            pnlTab2.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black), new EmptyBorder(10, 10, 10, 10)));
            c.gridy = 0;
            c.gridx = 0;
            pnlTab2.add(addItemRelatorio("Auditoria do banco de dados", new ActionAddTela(
                    TelaPrincipal.CADASTRO_AUDITORIA_BD,
                    new AdapterPermissaoDeUsuario()
                    {
                        @Override
                        public boolean podeAcessar (PerfilDeAcesso p)
                        {
                            return p.isAcessaAuditoria();
                        }

                    })), c);
            c.gridy = 1;
            c.gridx = 0;
            c.gridwidth = 2;
            c.weighty = 1;
            pnlTab2.add(Box.createHorizontalStrut(100), c);
            c.gridwidth = 1;
            c.weighty = 0;
            tabPane.addTab("Outros", pnlTab2);
        }

        //montando painel principal
        MyJPanel pnlPrincipal = new MyJPanel();
        pnlPrincipal.setBackground(Color.white);
        pnlPrincipal.setLayout(new CardLayout(8, 8));
        pnlPrincipal.add(tabPane);

        //montando pnlBotoes
        MyJPanel pnlBotoes = new MyJPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        pnlBotoes.setBackground(Color.white);
        pnlBotoes.add(btnOk);
        pnlBotoes.add(btnCancel);

        //montando tela
        setLayout(new BorderLayout());
        add(lblImageRel, BorderLayout.NORTH);
        add(pnlPrincipal, BorderLayout.CENTER);
        add(pnlBotoes, BorderLayout.SOUTH);
    }

    private Component addItemRelatorio (String rotulo, final ActionListener act1)
    {
        ItemRelatorio item = new ItemRelatorio(rotulo, act1);
        buttonGroup.add(item);
        return new PnlComEspaco(item, 2, 2);
    }

    private void btnOkAction ()
    {
        Enumeration<AbstractButton> e = buttonGroup.getElements();
        while (e.hasMoreElements())
        {
            ItemRelatorio item = (ItemRelatorio) e.nextElement();
            if (item.isSelected())
            {
                item.getItemAction().actionPerformed(null);
                this.dispose();
                break;
            }
        }
    }

    private void btnCancelAction ()
    {
        dispose();
    }

    //<editor-fold defaultstate="collapsed" desc="Components">

    private MyJLabel lblImageRel = new MyJLabel();
    private MyJTabbedPane tabPane = new MyJTabbedPane();
    private ButtonGroup buttonGroup = new ButtonGroup();
    private MyJButton btnOk = new MyJButton("Abrir relatório");
    private MyJButton btnCancel = new MyJButton("Cancelar");

    {
        lblImageRel.setIcon(ImageResources.getIcon(ImagensLC.TOPO_RELATORIOS));
        btnOk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnOkAction();
            }

        });
        btnOk.setIcon(SwingLibResources.getIcon(Imagens.OK));
        btnOk.setPreferredSize(new Dimension(btnOk.getPreferredSize().width, 40));
        btnCancel.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
        btnCancel.setPreferredSize(new Dimension(btnCancel.getPreferredSize().width, 40));
        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                btnCancelAction();
            }

        });
    }

    //</editor-fold>

    private class ItemRelatorio extends MyJRadioButton
    {
        private ActionListener itemAction;

        private ItemRelatorio (String text, ActionListener act1)
        {
            super(text);
            this.itemAction = act1;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased (MouseEvent e)
                {
                    if (e.getClickCount() == 2)
                    {
                        btnOkAction();
                    }
                }
            });
        }

        private ActionListener getItemAction ()
        {
            return itemAction;
        }

    }

}
