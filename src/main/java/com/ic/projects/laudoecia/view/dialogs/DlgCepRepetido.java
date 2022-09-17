/*
 * DlgCepRepetido.java
 *
 * Created on 29/02/2012, 10:11:07
 */
package com.ic.projects.laudoecia.view.dialogs;

import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.icontrol.crud.busca.ResultsGenerator;
import com.lib.swing.crud.busca.ScrollResultsDaBusca;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.utils.TableConfigurator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class DlgCepRepetido extends MyJDialog
{
    private List<Endereco> enderecos;
    private int resposta = -1;

    public DlgCepRepetido (Container cp, List<Endereco> enderecos)
    {
        super(cp, true, 600, 180);
        this.enderecos = enderecos;
        initComponents();
        preencherTabela();
    }

    private void preencherTabela ()
    {
        scrpTabela.updateResultList(new ResultsGenerator() {

            @Override
            public List<Object[]> generateResults ()
            {
                List<Object[]> result = new ArrayList<>();
                for (int i = 0; i < enderecos.size(); i++)
                {
                    result.add(new Object[]
                            {
                                enderecos.get(i).getCep(),
                                enderecos.get(i).getUf(),
                                enderecos.get(i).getCidade(),
                                enderecos.get(i).getBairro(),
                                enderecos.get(i).getLogradouro()
                            });
                }
                return result;
            }
        });
    }

    public Endereco escolherEndereco ()
    {
        if (resposta >= 0)
        {
            return enderecos.get(resposta);
        }
        return null;
    }

    private void initComponents ()
    {

        btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR)); // NOI18N
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed (java.awt.event.ActionEvent evt)
            {
                btnCancelarAction();
            }

        });

        scrpTabela = new ScrollResultsDaBusca(new TableConfigurator()
        {

            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?> [] { 
                    String.class, String.class, String.class, String.class, String.class};
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                {
                    "CEP", "UF", "Cidade", "Bairro", "Logradouro"
                };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                {
                    180, 70, 250, 250, 250
                };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean [] { false, false, false, false, false } ;
            }
            
            @Override
            public int[] sortedColumns ()
            {
                return new int[] { 0 };
            }

        });
        scrpTabela.setMinimumSize(new Dimension(570, 110));
        scrpTabela.getTabela().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    resposta = scrpTabela.getTabela().getSelectedRow();
                    fechar();
                }
            }

        });

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;

        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        add(Box.createVerticalStrut(5), c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.gridx = 1;
        add(lblSuperior, c);
        c.gridy = 1;
        c.gridx = 2;
        c.gridheight = 2;
        add(btnCancelar, c);
        c.gridheight = 1;
        c.gridy = 2;
        c.gridx = 1;
        add(lblInferior, c);
        c.gridy = 3;
        c.gridx = 0;
        c.gridwidth = 4;
        add(Box.createVerticalStrut(5), c);
        c.gridy = 4;
        c.gridx = 0;
        add(scrpTabela, c);

        c.gridy = 5;
        c.gridwidth = 1;
        c.weighty = 0;
        c.gridx = 0;
        add(Box.createHorizontalStrut(5), c);
        c.gridx = 1;
        add(Box.createHorizontalStrut(450), c);
        c.gridx = 2;
        add(Box.createHorizontalStrut(120), c);
        c.gridx = 3;
        add(Box.createHorizontalStrut(5), c);

    }

    private void btnCancelarAction ()
    {
        this.setVisible(false);
    }

    @Override
    public void fechar ()
    {
        btnCancelarAction();
    }

    private MyJButton btnCancelar = new MyJButton("Cancelar");
    private MyJLabel lblSuperior = new MyJLabel(" O CEP digitado corresponde a mais de um endereço.");
    private MyJLabel lblInferior = new MyJLabel(" Clique duas vezes no endereço desejado para confirmar.");
    private ScrollResultsDaBusca scrpTabela;

}
