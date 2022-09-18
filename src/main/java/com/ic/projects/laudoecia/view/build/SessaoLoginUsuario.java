package com.ic.projects.laudoecia.view.build;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.ic.projects.laudoecia.view.dialogs.DlgLogin;

public class SessaoLoginUsuario implements ActionListener, AWTEventListener {
	private final int tempo = 15 * (60 * 1000);//1000 milissegundos X 60 pra dar 1 minuto X 15 pra dar 15minutos
	private final Timer cronometro = new Timer(tempo, this);
	private FormPrincipal formulario;
	
	public SessaoLoginUsuario(FormPrincipal formulario) {
		this.IniciarConfiguracoes();
		this.formulario = formulario;
	}
	
	private void IniciarConfiguracoes() {
		this.cronometro.setRepeats(false);
		this.cronometro.restart();
		Toolkit.getDefaultToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.cronometro.restart();
		this.ExibeTelaLogin();
	}

	@Override
	public void eventDispatched(AWTEvent event) {
		this.cronometro.restart();
	}
	
	private void ExibeTelaLogin() {
		if (this.formulario.getDlgLogin() == null || !this.formulario.getDlgLogin().isVisible()) {
			this.formulario.setDlgLogin(new DlgLogin(this.formulario, true));
			//this.formulario.getDlgLogin().setAlwaysOnTop(true);
			this.formulario.getDlgLogin().setVisible(true);
		}
	}
	
}