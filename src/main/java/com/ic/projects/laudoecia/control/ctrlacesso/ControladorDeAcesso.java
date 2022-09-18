/**
 * ControladorDeAcesso.java
 *
 * Created on 16/12/2011, 17:39:52
 */
package com.ic.projects.laudoecia.control.ctrlacesso;

import java.util.ArrayList;
import java.util.List;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.auditable.DaoUsuario;
import com.ic.projects.laudoecia.model.auditable.Usuario;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
public abstract class ControladorDeAcesso {
	private static ControladorDeAcesso singleton;
	private static Usuario usuarioLogado;
	private static Usuario usuarioNull;
	private static boolean acessobackup = false;
	private final static List<UsuarioLogadoListener> usuarioLogadoListeners = new ArrayList<>();

	final int VALIDAR_ACESSAR = 0;
	final int VALIDAR_ADICIONAR = 1;
	final int VALIDAR_ALTERAR = 2;
	final int VALIDAR_APAGAR = 3;

	protected Usuario ultimoUsuarioValidado;

	ControladorDeAcesso() {
	}

	public synchronized static ControladorDeAcesso getInstance() {
		if (singleton == null) {
			switch (StaticInfo.getParametrosDoSistema().getTipoControleDeAcesso()) {
			//case SEM_CONTROLE:
			//	singleton = new SemControle();
			//	break;
			case CONFORME_USUARIO_LOGADO:
				singleton = new ConformeUsuarioLogado();
				break;
			case SEMPRE_EXIGE_SENHA:
				singleton = new SempreExigeSenha();
				break;
			//default:
			//	singleton = new SemControle();
			}
			singleton = new SempreExigeSenha();
			usuarioNull = new DaoUsuario().procurarPorId(Usuario.CODIGO_NULL);
			if (usuarioNull == null) {
				// should never reach this line
				usuarioNull = new Usuario();
			}
			setUsuarioLogado(usuarioNull);
		}
		return singleton;
	}

	public static void addUsuarioLogadoListener(UsuarioLogadoListener ull) {
		usuarioLogadoListeners.add(ull);
	}

	public static void removeUsuarioLogadoListener(UsuarioLogadoListener ull) {
		usuarioLogadoListeners.remove(ull);
	}

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuario novoUsuario) {
		if (novoUsuario == null) {
			setUsuarioLogado(usuarioNull);
		} else {
			for (UsuarioLogadoListener usuarioListener : usuarioLogadoListeners) {
				usuarioListener.usuarioSelecionadoVaiMudar(usuarioLogado, novoUsuario);
			}
			usuarioLogado = novoUsuario;
		}
	}

	public static boolean existeUsuarioLogado() {
		return usuarioLogado != usuarioNull;
	}

	public void setUltimoUsuarioValidado(Usuario u) {
		if (u == null) {
			throw new IllegalArgumentException();
		}
		ultimoUsuarioValidado = u;
	}

	boolean validar(int tipo, PermissaoDeUsuario p, boolean utilizarUsuarioLogado) {
		if(ControladorDeAcesso.acessobackup)
			return true;
		
		if (utilizarUsuarioLogado) {
			return validar(tipo, p, usuarioLogado);
		} else {
			Usuario resp;
			int tentativas = 0;
			while (tentativas++ < 3 && (resp = LaudoeCia.getTelaPrincipal().solicitarUsuario()) != null) {
				if (validar(tipo, p, resp)) {
					return true;
				} else {
					LaudoeCia.getTelaPrincipal().mostrarMensagemDeErro("O usuário não possui a permissão necessária!",
							LaudoeCia.getTelaPrincipal());
				}
			}
			return false;
		}
	}

	private boolean validar(int tipo, PermissaoDeUsuario p, Usuario u) {
		boolean validarOk;
		switch (tipo) {
		case VALIDAR_ACESSAR:
			validarOk = p.podeAcessar(u.getGrupo().getPerfilDeAcesso());
			break;
		case VALIDAR_ADICIONAR:
			validarOk = p.podeAdicionar(u.getGrupo().getPerfilDeAcesso());
			break;
		case VALIDAR_ALTERAR:
			validarOk = p.podeAlterar(u.getGrupo().getPerfilDeAcesso());
			break;
		case VALIDAR_APAGAR:
			validarOk = p.podeApagar(u.getGrupo().getPerfilDeAcesso());
			break;
		default:
			return false;
		}
		if (validarOk) {
			ultimoUsuarioValidado = u;
		}
		return validarOk;
	}

	public abstract Usuario getResponsavelPelaAcao();

	public abstract boolean criarMenusDeControleDeSessão();

	public abstract boolean exigirLoginAoIniciarOSistema();

	public abstract boolean mostrarCadastrosDoControleDeAcesso();

	public abstract boolean podeAcessar(PermissaoDeUsuario p);

	public abstract boolean podeAdicionar(PermissaoDeUsuario p);

	public abstract boolean podeAlterar(PermissaoDeUsuario p);

	public abstract boolean podeApagar(PermissaoDeUsuario p);
	
	public static ControladorDeAcesso getSingleton() {
		return singleton;
	}
	
	public static void setSingleton(ControladorDeAcesso singleton) {
		ControladorDeAcesso.singleton = singleton;
	}

	public static boolean isAcessobackup() {
		return acessobackup;
	}
	
	public static void setAcessobackup(boolean acessobackup) {
		ControladorDeAcesso.acessobackup = acessobackup;
	}
}
