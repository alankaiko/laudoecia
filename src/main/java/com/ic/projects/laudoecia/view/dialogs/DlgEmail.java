package com.ic.projects.laudoecia.view.dialogs;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.utils.EnvioEmail;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.PnlComEspaco;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.EnterEnviaTab;

public class DlgEmail extends MyJDialog {
	private static DlgEmail instance;
	private Atendimento atendimento;
	private ProcDoAtd procSelecionado;

	public static DlgEmail getInstance(Atendimento atendimento, ProcDoAtd procSelecionado) {
		return instance = new DlgEmail(FormPrincipal.getInstance(), atendimento, procSelecionado);
	}

	private DlgEmail(Component cp, Atendimento atendimento, ProcDoAtd procSelecionado) {
		super(cp, true, 400, 240);
		this.atendimento = atendimento;
		this.procSelecionado = procSelecionado;
		initializeComponents();
		this.txtEmail.setText(this.atendimento.getPaciente().getEmail());
		this.txtAssunto.setText("Laudo: " + this.atendimento.getPaciente().getNome());
		this.gruporadio.add(this.botaoImagem);
		this.gruporadio.add(this.botaoLaudo);
		this.gruporadio.add(this.botaoLaudoeImagem);
		this.setVisible(true);
		
		
	}


	private void initializeComponents() {
		MyJPanel pnl = new MyJPanel();
		pnl.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 1;
		pnl.add(new PnlComp("Laudo e Imagem", false, true).setComponent(this.botaoLaudoeImagem), c);
		
		c.gridy = 0;
		c.gridx = 1;
		c.gridwidth = 1;
		pnl.add(new PnlComp("Apenas Imagens", false, true).setComponent(this.botaoImagem), c);
		
		c.gridy = 0;
		c.gridx = 2;
		c.gridwidth = 1;
		pnl.add(new PnlComp("Apenas Laudos", false, true).setComponent(this.botaoLaudo), c);

		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 5;
		pnl.add(new PnlComp("Confirmar E-mail do cliente", false, true).setComponent(this.txtEmail), c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 5;
		pnl.add(new PnlComp("Assunto", true, true).setComponent(this.txtAssunto), c);

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

	private JTextField txtEmail = new JTextField();
	private JTextField txtAssunto = new JTextField();
	private MyJButton btnConfirmar = new MyJButton("Confirmar");
	private MyJButton btnCancelar = new MyJButton("Cancelar");
	private JRadioButton botaoLaudo = new JRadioButton();
	private JRadioButton botaoImagem = new JRadioButton();
	private JRadioButton botaoLaudoeImagem = new JRadioButton();
	private ButtonGroup gruporadio = new ButtonGroup();

	{
		KeyListener kl = new EnterEnviaTab(false);

		txtEmail.addKeyListener(kl);
		txtAssunto.addKeyListener(kl);

		btnConfirmar.setIcon(SwingLibResources.getIcon(Imagens.OK));
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(botaoImagem.isSelected() || botaoLaudo.isSelected() || botaoLaudoeImagem.isSelected())
					if (ConfereTextfieldEmail())
						btnConfirmarAction();
					else
						JOptionPane.showMessageDialog(null, "E-mail Incorreto ou não informado!");
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
	
	private boolean ConfereTextfieldEmail() {
		if ((this.txtEmail.getText() == "") || !(this.txtEmail.getText().equals(null)) && !(this.txtEmail.getText().contains("@")))
			return false;
		else
			return true;
	}

	private void btnConfirmarAction() {
		try {
			File arquivo = null;
			
			if(this.botaoLaudoeImagem.isSelected())
				arquivo = this.EnviarLaudosEImagens();
			
			if(this.botaoImagem.isSelected())
				arquivo = this.EnviarImagens();
			
			if(this.botaoLaudo.isSelected())
				arquivo = this.EnviarLaudos();
			
			if(arquivo != null){
				EnvioEmail env = new EnvioEmail();
				env.EnviandoEmail(this.txtEmail.getText(), this.txtAssunto.getText(), arquivo.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispose();
	}
	
	private File EnviarLaudos() throws ErrosDeValidacao, Exception{
		LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
		PnlLaudoeCia.getInstance().abrirModuloDeLaudo(this.atendimento, this.procSelecionado);
		this.procSelecionado.getLaudo().getPlanilha().gerarHtml(true);
		return PnlLaudoeCia.getInstance().GerarEnvioPdfEmailLaudo(this.procSelecionado.getLaudo().getPlanilha().gerarHtml(true), this.procSelecionado);
	}
	
	private File EnviarImagens() throws ErrosDeValidacao, Exception{
		LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
		PnlLaudoeCia.getInstance().abrirModuloDeLaudo(this.atendimento, this.procSelecionado);
		this.procSelecionado.getLaudo().getPlanilha().gerarHtml(true);
		return PnlLaudoeCia.getInstance().GerarEnvioPdfEmailImagens(this.procSelecionado);
	}
	
	private File EnviarLaudosEImagens() throws ErrosDeValidacao, Exception{
		LaudoeCia.getTelaPrincipal().setCursorToWaitCursor();
		PnlLaudoeCia.getInstance().abrirModuloDeLaudo(this.atendimento, this.procSelecionado);
		this.procSelecionado.getLaudo().getPlanilha().gerarHtml(true);
		return PnlLaudoeCia.getInstance().GerarEnvioPdfEmailLaudoEImg(this.procSelecionado.getLaudo().getPlanilha().gerarHtml(true), this.procSelecionado);
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

	public ProcDoAtd getProcSelecionado() {
		return procSelecionado;
	}

	public void setProcSelecionado(ProcDoAtd procSelecionado) {
		this.procSelecionado = procSelecionado;
	}

	
}
