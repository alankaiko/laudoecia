package com.ic.projects.laudoecia.view.cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.ic.projects.laudoecia.dao.auditable.DaoEmailParametro;
import com.ic.projects.laudoecia.model.auditable.EmailParametros;
import com.ic.projects.laudoecia.model.enums.EnumEmail;
import com.lib.icontrol.crud.cadastro.SimpleC_Cadastro;
import com.lib.swing.crud.cadastro.CrudConfigurator;
import com.lib.swing.crud.cadastro.SimpleIFrameCadastro;
import com.lib.swing.crud.cadastro.SimplePnlCadastro;
import com.lib.swing.crud.cadastro.TBarCRUD;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;

public class IFrameEmailParametros extends SimpleIFrameCadastro {
	private static final long serialVersionUID = 1L;
	
	private JTextField temail, tsmtp, tport;
	private JPasswordField tsenha;
	private MyJButton alterar, salvar, cancelar;
	private EmailParametros email;
	private JCheckBox checkboxssl;
	private JTextPane paineltexto;
	private JLabel lemail, lsenha, lsmtp, lport, lssl, lobservacoes;
	private JLabel ltipo;
	private JComboBox<EnumEmail> combotipo;
	private JScrollPane ScrolObservacao;
	
	public IFrameEmailParametros() {
		super("Parâmetros de E-mail", 600, 435);
		//setBounds(100, 100, 600, 435);
		getContentPane().setLayout(null);
		
		//codigo pra colocar tela no meio vem aqui
		this.CriaTela();
		this.CarregarDados();
		this.PreencherCampos();
		this.DesabilitarCampos();
		this.VerificarSelecao();
		
		setPnlCadastro(new SimplePnlCadastro(new CrudConfigurator() {

            @Override
            public boolean permiteAdicionar () {
                return true;
            }

            @Override
            public boolean permiteAlterar () {
                return true;
            }

            @Override
            public boolean permiteApagar () {
                return true;
            }

            @Override
            public int selBtn () {
                return TBarCRUD.BTN_ADICIONAR;
            }

        }, true, true, SimpleC_Cadastro.VIEW_BUSCA));
	}
	
	private void CriaTela() {
		lemail = new JLabel("E-mail/Host");
		lemail.setFont(new Font("Arial", Font.BOLD, 13));
		lemail.setBounds(10, 27, 110, 14);
		lemail.setToolTipText("Informe o email padrão que irá enviar emails para os Clientes");
		getContentPane().add(lemail);
		
		temail = new JTextField();
		temail.setBackground(Color.WHITE);
		temail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		temail.setColumns(10);
		temail.setToolTipText("Informe o email padrão que irá enviar emails para os Clientes");
		temail.setBounds(10, 52, 331, 25);
		getContentPane().add(temail);
		
		lsenha = new JLabel("Senha");
		lsenha.setFont(new Font("Arial", Font.BOLD, 13));
		lsenha.setBounds(351, 27, 100, 14);
		lsenha.setToolTipText("Informe a senha do e-email informado");
		getContentPane().add(lsenha);
		
		tsenha = new JPasswordField();
		tsenha.setBackground(Color.WHITE);
		tsenha.setColumns(10);
		tsenha.setToolTipText("Informe a senha do e-email informado");
		tsenha.setBounds(351, 52, 100, 25);
		getContentPane().add(tsenha);
		
		lsmtp = new JLabel("Nome do servidor de envio de e-mail SMTP");
		lsmtp.setFont(new Font("Arial", Font.BOLD, 13));
		lsmtp.setBounds(10, 88, 331, 14);
		lsmtp.setToolTipText("Informe os dados de servidor SMTP responsável pelo envio de e-email.");
		getContentPane().add(lsmtp);
		
		tsmtp = new JTextField();
		tsmtp.setBackground(Color.WHITE);
		tsmtp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tsmtp.setColumns(10);
		tsmtp.setToolTipText("Informe os dados de servidor SMTP responsável pelo envio de e-email.");
		tsmtp.setBounds(10, 113, 331, 25);
		getContentPane().add(tsmtp);
		
		lport = new JLabel("Porta");
		lport.setFont(new Font("Arial", Font.BOLD, 13));
		lport.setBounds(351, 88, 100, 14);
		lport.setToolTipText("Porta utilizada pelo servidor SMTP. Ex: porta 25, porta 465");
		getContentPane().add(lport);
		
		tport = new JTextField();
		tport.setBackground(Color.WHITE);
		tport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tport.setColumns(10);
		tport.setToolTipText("Porta utilizada pelo servidor SMTP. Ex: porta 25, porta 465");
		tport.setBounds(351, 113, 100, 25);
		getContentPane().add(tport);
		tport.setToolTipText("Porta utilizada pelo servidor SMTP. Ex: porta 25, porta 465");
		
		lssl = new JLabel("SSL/TSL");
		lssl.setFont(new Font("Arial", Font.BOLD, 13));
		lssl.setBounds(461, 88, 100, 14);
		getContentPane().add(lssl);
		
		this.checkboxssl = new JCheckBox("Ativo");
		this.checkboxssl.setBounds(457, 115, 97, 23);
		this.checkboxssl.setToolTipText("Autenticacão via TSL/SSL");
		getContentPane().add(this.checkboxssl);
				
		alterar = new MyJButton("Alterar");
		alterar.setBounds(10, 369, 100, 25);
		alterar.setIcon(SwingLibResources.getIcon(Imagens.ALTERAR));
		alterar.setToolTipText("Adicionar novo registro");
		alterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HabilitarCampos();
			}
		});
		getContentPane().add(alterar);
		
		salvar = new MyJButton("Salvar");
		salvar.setBounds(120, 369, 100, 25);
		salvar.setIcon(SwingLibResources.getIcon(Imagens.SALVAR));
		salvar.setToolTipText("Salvar registro atual");
		salvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SalvarAtualizar();
				Cancelar();
			}
		});
		getContentPane().add(salvar);
		
		cancelar = new MyJButton("Cancelar");
		cancelar.setBounds(230, 369, 100, 25);
		cancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
		cancelar.setToolTipText("Cancelar operação atual");
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cancelar();
			}
		});
		getContentPane().add(cancelar);
		
		ScrolObservacao = new JScrollPane();
		ScrolObservacao.setBounds(10, 172, 564, 193);
		getContentPane().add(ScrolObservacao);
		
		lobservacoes = new JLabel("Observações Importantes");
		lobservacoes.setToolTipText("Informe o email padrão que irá enviar emails para os Clientes");
		lobservacoes.setFont(new Font("Arial", Font.BOLD, 13));
		lobservacoes.setBounds(10, 149, 210, 14);
		getContentPane().add(lobservacoes);
		
		paineltexto = new JTextPane();
		ScrolObservacao.setViewportView(paineltexto);
		
		ltipo = new JLabel("Tipo");
		ltipo.setToolTipText("Informe a senha do e-email informado");
		ltipo.setFont(new Font("Arial", Font.BOLD, 13));
		ltipo.setBounds(461, 28, 113, 14);
		getContentPane().add(ltipo);
		
		combotipo = new JComboBox<EnumEmail>(EnumEmail.values());
		combotipo.setBounds(461, 52, 113, 25);
		combotipo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        VerificarSelecao();
		    }
		});
		getContentPane().add(combotipo);
	}
	
	private void CarregarDados() {
		DaoEmailParametro dao = new DaoEmailParametro();
		this.email = dao.procurarPorId(1);

		if(this.email == null) 
			this.email = new EmailParametros();
	}
	
	private void PreencherCampos() {
		this.temail.setText(this.email.getLogin());
		this.combotipo.setSelectedItem(this.email.getTipo());
		this.tsenha.setText(this.email.getSenha());
		this.tsmtp.setText(this.email.getSmtp());
		this.tport.setText(this.email.getPort());
		this.checkboxssl.setSelected(this.email.isSsl());
	}
	
	private void SalvarAtualizar() {
		this.email.setLogin(this.temail.getText());
		this.email.setTipo((EnumEmail) this.combotipo.getSelectedItem());
		this.email.setSenha(this.tsenha.getText());
		this.email.setSmtp(this.tsmtp.getText());
		this.email.setSsl(this.checkboxssl.isSelected());
		this.email.setPort(this.tport.getText());
		this.email.setPortsocket(this.tport.getText());
		
		try {
			DaoEmailParametro dao = new DaoEmailParametro();
			dao.alterar(this.email);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void Cancelar() {
		this.dispose();
	}
	
	private void HabilitarCampos() {
		this.temail.setEnabled(true);
		this.combotipo.setEnabled(true);
		
		this.tsenha.setEnabled(true);
		this.tsmtp.setEnabled(true);
		this.tport.setEnabled(true);
		this.salvar.setEnabled(true);
	}
	
	private void DesabilitarCampos() {
		this.temail.setEnabled(false);
		this.combotipo.setEnabled(false);
		this.paineltexto.setEditable(false);
		this.tsenha.setEnabled(false);
		this.tsmtp.setEnabled(false);
		this.tport.setEnabled(false);
		this.salvar.setEnabled(false);
	}
	
	private void VerificarSelecao() {
		if(this.combotipo.getSelectedItem() == EnumEmail.GMAIL)
			this.paineltexto.setText(this.RetornaGmail());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.HOTMAIL)
			this.paineltexto.setText(this.RetornaHotmail());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.BOL)
			this.paineltexto.setText(this.RetornaBol());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.KINGHOST)
			this.paineltexto.setText(this.RetornaKinghost());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.YAHOO)
			this.paineltexto.setText(this.RetornaYahoo());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.UOL)
			this.paineltexto.setText(this.RetornaUol());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.ZOHO)
			this.paineltexto.setText(this.RetornaZoho());
		
		if(this.combotipo.getSelectedItem() == EnumEmail.OUTROS)
			this.paineltexto.setText(this.RetornaOutros());
		
	}
	
	private String RetornaGmail() {
		return "Verificar as seguintes Opções:\r\n" + 
				"\r\n" + 
				"- DESATIVAR Verificação em Duas Etapas\r\n" + 
				"- DESATIVAR Usar seu Smartphone para fazer login\r\n" + 
				"link: https://myaccount.google.com/security\r\n" + 
				"\r\n" + 
				"- ATIVAR Acesso a app menos seguro\r\n" + 
				"link: https://www.google.com/settings/security/lesssecureapps\r\n" + 
				"\r\n" + 
				"- Verificar as configurações padrão para envio de Email através do GMAIL\r\n" + 
				"SMTP: smtp.gmail.com\r\n" + 
				"PORTA: 465(recomendada) ou 587\r\n" + 
				"SSL: TRUE\r\n" + 
				"SOCKET: javax.net.ssl.SSLSocketFactory\r\n" + 
				"PORTSOCKET: 465 OU 587";
	}
	
	private String RetornaHotmail() {
		return "";
	}
	
	private String RetornaBol() {
		return "";
	}
	
	private String RetornaKinghost() {
		return "";
	}
	
	private String RetornaYahoo() {
		return "";
	}
	
	private String RetornaUol() {
		return "";
	}
	
	private String RetornaZoho() {
		return "";
	}
	
	private String RetornaOutros() {
		return "";
	}
	
}













