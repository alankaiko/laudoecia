package com.ic.projects.laudoecia.view.dialogs;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.utils.EnvioZap;
import com.ic.projects.laudoecia.view.utils.VersaoChromeInicia;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.EnterEnviaTab;

public class DlgWhats extends MyJDialog {
	private static DlgWhats instance;
	private Atendimento atendimento;
	private String caminho;

	public static DlgWhats getInstance(Atendimento atendimento, String caminho) {
		return instance = new DlgWhats(FormPrincipal.getInstance(), atendimento, caminho);
	}

	private DlgWhats(Component cp, Atendimento atendimento, String caminho) {
		super(cp, true, 400, 200);
		this.atendimento = atendimento;
		this.caminho = caminho;
		initializeComponents();
		this.txtNomeCliente.setText(this.atendimento.getPaciente().getNome());
		this.txtNomeCliente.setEditable(false);
		this.txtWhats.setText(this.atendimento.getPaciente().getTelefone2());
		
		JOptionPane.showMessageDialog(this , "Aguarde alguns segundos, até que a Tela de Telefone esteja Disponível");
		this.VerificarCrome();
		this.setVisible(true);
	}
	
	public void VerificandoChrome(){
		  new Thread() {

		    @Override
		    public void run() {
		    	VersaoChromeInicia verifica = new VersaoChromeInicia();
		    	verifica.VerificarChrome();
		    }
		  }.start();
		  
		  Thread.interrupted();
	}
	
	private void VerificarCrome() {
		VersaoChromeInicia verifica = new VersaoChromeInicia();
    	verifica.VerificarChrome();
	}

	private void initializeComponents() {
		MyJPanel pnl = new MyJPanel();
		pnl.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 5;
		pnl.add(new PnlComp("Nome Cliente", false, true).setComponent(this.txtNomeCliente), c);
	
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 5;
		pnl.add(new PnlComp("Confirmar Whatsapp", true, true).setComponent(this.txtWhats), c);

		MyJPanel pnlBotoes = new MyJPanel(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.BOTH;

		c2.weighty = 0.25d;
		c2.gridwidth = 4;
		pnlBotoes.add(Box.createVerticalStrut(0), c2);
		c2.weightx = 0.25d;
		c2.gridy = 1;
		c2.weighty = 0.5d;
		c2.gridwidth = 1;
		pnlBotoes.add(Box.createHorizontalStrut(0), c2);
		c2.gridx = 1;
		pnlBotoes.add(btnConfirmar, c2);
		c2.gridx = 2;
		c2.insets.left = 5;
		pnlBotoes.add(btnCancelar, c2);
		c2.insets.left = 0;
		c2.gridx = 3;
		pnlBotoes.add(Box.createHorizontalStrut(0), c2);
		c2.gridx = 0;
		c2.gridy = 2;
		c2.weightx = 0;
		c2.gridwidth = 4;
		c2.weighty = 0.25d;
		pnlBotoes.add(Box.createVerticalStrut(0), c2);

		c.gridy = 3;
		c.weighty = 1;
		c.gridwidth = 4;
		c.gridx = 0;
		pnl.add(pnlBotoes, c);

		c.weighty = 0;
		c.gridy = 4;
		c.gridx = 0;
		c.gridwidth = 1;
		c.weightx = 0.333333333333333f;
		pnl.add(Box.createHorizontalStrut(0), c);
		c.gridx = 1;
		pnl.add(Box.createHorizontalStrut(0), c);
		c.gridx = 2;
		pnl.add(Box.createHorizontalStrut(0), c);

		add(new PnlComEspaco(pnl));
	}

	private JTextField txtWhats = new JTextField();
	private MyJButton btnConfirmar = new MyJButton("Confirmar");
	private MyJButton btnCancelar = new MyJButton("Cancelar");
	private JTextField txtNomeCliente = new JTextField();

	{
		KeyListener kl = new EnterEnviaTab(false);

		txtWhats.addKeyListener(kl);

		btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnConfirmarAction();
			}
		});

		btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fechar();
			}
		});

	}

	private void btnConfirmarAction() {
		try {
			EnvioZap envio = new EnvioZap();
			envio.EnviandoPara(this.txtWhats.getText(), this.caminho);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispose();
	}
	
	@Override
	public void fechar() {
		dispose();
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	
}
