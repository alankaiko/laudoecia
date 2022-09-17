package com.ic.projects.laudoecia.view.paint;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import com.ic.projects.laudoecia.dao.auditable.DaoParametrosDoSistema;
import com.ic.projects.laudoecia.dao.cadastro.DaoAbreviatura;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.cadastro.Abreviatura;
import com.ic.projects.laudoecia.model.enums.PARAMETRO_BUSCA_SIGLA;
import com.mxrck.autocompleter.TextAutoCompleter;

//Jonathan Alves - classe inteira
public class UtilsCompletaTexto implements KeyListener, FocusListener, MouseListener{
	private DesenhistaDeTexto desenho;
	private TextAutoCompleter completer;
	private List<Abreviatura> lista;
	private PARAMETRO_BUSCA_SIGLA parametrosigla;
	
	public UtilsCompletaTexto(DesenhistaDeTexto desenho) {
		this.desenho = desenho;
		RegistraConfiguracoes();
	}
	
	//metodos locais
	private void RegistraConfiguracoes(){
		this.AdicionaListener();
		this.completer = new TextAutoCompleter(this.desenho.getTxtArea());
		this.BuscaNoBanco();
		this.VerificaParametro();
		this.AdicionaAutocompletar();
	}
	
	//adicionando eventos no campo texto
	private void AdicionaListener(){
		this.desenho.getTxtArea().addKeyListener(this);
		this.desenho.getTxtArea().addFocusListener(this);
		this.desenho.getTxtArea().addMouseListener(this);
	}
	
	private void VerificaParametro() {
		DaoParametrosDoSistema dao = new DaoParametrosDoSistema();
		int codigo = dao.getMaxID();
		ParametrosDoSistema sis = dao.procurarPorId(codigo);
		
		if(sis.getParametrobuscasigla() == null)
			sis.setParametrobuscasigla(PARAMETRO_BUSCA_SIGLA.BUSCA_SIGLA_SIGLA);
		
		this.parametrosigla = sis.getParametrobuscasigla();
		
		dao = null;
		sis = null;
	}
	
	
	//Logicamente nao é ideal chamar um dao aqui, mas, aqui estamos nós =D
	private void BuscaNoBanco(){
		DaoAbreviatura dao = new DaoAbreviatura();
		this.lista = dao.listar();
	}
	
	//Logicamente nao é ideal chamar um dao aqui, mas, aqui estamos nós =D
	private void AdicionaAutocompletar(){
		this.completer.setMode(0);
		
		if(this.parametrosigla.equals(PARAMETRO_BUSCA_SIGLA.BUSCA_SIGLA_SIGLA)) {
			for(Abreviatura ab : this.lista)
				this.completer.addItem(ab.getAbreviatura());
		}
		
		if(this.parametrosigla.equals(PARAMETRO_BUSCA_SIGLA.BUSCA_TEXTO_TEXTO)) {
			for(Abreviatura ab : this.lista)
				this.completer.addItem(ab.getTexto());
		}
		
		if(this.parametrosigla.equals(PARAMETRO_BUSCA_SIGLA.BUSCA_SIGLA_TEXTO)) {
			for(Abreviatura ab : this.lista)
				this.completer.addItem(ab.getAbreviatura());
		}
		
		if(this.parametrosigla.equals(PARAMETRO_BUSCA_SIGLA.BUSCA_MEIO_TEXTO_TEXTO)) {
			this.completer.setMode(1);
			
			for(Abreviatura ab : this.lista)
				this.completer.addItem(ab.getTexto());
		}
		
		if(this.parametrosigla.equals(PARAMETRO_BUSCA_SIGLA.BUSCA_SIGLA_MOSTRA_TEXTO)) {
			for(Abreviatura ab : this.lista){
				this.completer.addItem(ab.getTexto());
			}
		}
		
		if(this.parametrosigla.equals(PARAMETRO_BUSCA_SIGLA.BUSCA_SIGLA_MOSTRA_SIGLA_E_TEXTO)) {
			for(Abreviatura ab : this.lista)
				this.completer.addItem(ab.getTexto()+ " - " + ab.getAbreviatura());
		}
	}
	

	//------------------------------------------------------------------------------------
	@Override
	public void keyPressed(KeyEvent evento) {
		if(evento.getKeyCode() == KeyEvent.VK_ENTER) {
			if(this.desenho.getTxtArea().getText().equals(this.completer.getItemSelected())) {
				this.desenho.doneEditing();
				evento.consume();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent evento) {
		switch (evento.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				this.desenho.doneEditing();
				evento.consume();
				break;
			default:
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent evento) {
		this.desenho.doneEditing();
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if(this.desenho.getTxtArea().getText().equals(this.completer.getItemSelected())) 
			this.desenho.doneEditing();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void focusGained(FocusEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	
	public List<Abreviatura> getLista() {
		return lista;
	}
	
	public PARAMETRO_BUSCA_SIGLA getParametrosigla() {
		return parametrosigla;
	}
	
	public TextAutoCompleter getCompleter() {
		return completer;
	}
	
	public void setCompleter(TextAutoCompleter completer) {
		this.completer = completer;
	}
	
}
