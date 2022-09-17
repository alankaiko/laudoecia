package com.ic.projects.laudoecia.view.utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import com.ic.projects.laudoecia.dao.auditable.DaoEmailParametro;
import com.ic.projects.laudoecia.model.auditable.EmailParametros;

public class EnvioEmail {
	private EmailParametros parametros;
	private Properties props;
	
	public EnvioEmail() {
		try {
			this.CarregarParametros();
			this.CarregarPropriedades();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void CarregarParametros() {
		DaoEmailParametro dao = new DaoEmailParametro();
		this.parametros = dao.procurarPorId(1);
	}
	
	private void CarregarPropriedades() {
		this.props = new Properties();
		this.props.put("mail.smtp.host", this.parametros.getSmtp());
		this.props.put("mail.smtp.socketFactory.port", this.parametros.getPortsocket());
		this.props.put("mail.smtp.socketFactory.class", this.parametros.getSocket());
		this.props.put("mail.smtp.auth", this.parametros.isSsl());
		this.props.put("mail.smtp.port", this.parametros.getPort());
		
		//this.props.put("mail.smtp.socketFactory.fallback", "true");
        //this.props.put("mail.smtp.starttls.enable", "true");
	}
	
	public void EnviandoEmail(String para, String assunto, String caminhopdf){
		try {
			this.Enviando(para, assunto, caminhopdf);
			JOptionPane.showMessageDialog(null, "E-mail enviado!!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!! Verifique as configurações no menu Ferramentas => Parâmetros Email");
			e.printStackTrace();
		}
	}
	
	private void Enviando(String para, String assunto, String caminhopdf) throws Exception {
		File arq = new File(caminhopdf);
		
		if(!arq.exists()) {
			JOptionPane.showMessageDialog(null, "Laudo está vazio!! Clique em Laudo para verificar");
			return;
		}
		
		String de = this.parametros.getLogin();
		      
        Autenticacao auth = new Autenticacao(this.parametros.getLogin(), this.parametros.getSenha());
        Session instancia = Session.getInstance(props, auth);
        MimeMessage mimetipo = new MimeMessage(instancia);
       
        mimetipo.setFrom(new InternetAddress(de));
        Address[] to = new InternetAddress[] {new InternetAddress(para)};
        mimetipo.setRecipients(Message.RecipientType.TO, to);
        mimetipo.setSubject(assunto);
        mimetipo.setSentDate(new java.util.Date());

        Multipart corpo = new MimeMultipart();
        InternetHeaders headers = new InternetHeaders();
        headers.addHeader("Content-Type", "application/pdf");
        
        MimeBodyPart mbp2 = new MimeBodyPart();      
        FileDataSource fds = new FileDataSource(caminhopdf);
		mbp2.setDataHandler(new DataHandler(fds));
		mbp2.setFileName(fds.getName());

        corpo.addBodyPart(mbp2);
        mimetipo.setContent(corpo);
        Transport.send(mimetipo);
    }
	
}
