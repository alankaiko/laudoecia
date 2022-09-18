/**
 * FormPrincipal.java
 *
 * Created on 09/12/2011, 10:52:24
 */
package com.ic.projects.laudoecia.view.build;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.List;

import javax.swing.JInternalFrame;

import com.ic.projects.laudoecia.control.build.C_TelaPrincipal;
import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.iview.Tela;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaSolicitante;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.view.dialogs.DlgCadastro;
import com.ic.projects.laudoecia.view.dialogs.DlgLogin;
import com.ic.projects.laudoecia.view.dialogs.DlgValidarUsuario;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.reports.JFrameRelatorios;
import com.ic.projects.laudoecia.view.reports.RelAtendCreator;
import com.ic.projects.laudoecia.view.reports.RelAuditoriaCreator;
import com.lib.swing.crud.cadastro.IFrameCadastro;
import com.lib.swing.mdi.JFrameMdi;
import com.lib.swing.plus.cps.MyJDesktopPane;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.utils.SwingUtils;

import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
public class FormPrincipal extends JFrameMdi implements TelaPrincipal {
	private static C_TelaPrincipal controlador;
	private boolean mudandoCartao = false;

	@SuppressWarnings("unused")
	private SessaoLoginUsuario sessao;
	private DlgLogin dlgLogin = null;
	// <editor-fold defaultstate="collapsed" desc="Singleton">

	private FormPrincipal() {
		super(LaudoeCia.NOME_DO_SISTEMA, FormBuilder.getInstance());
		atualizarBackground();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				FormPrincipal.this.windowClosed();
			}
		});
		
		this.sessao = new SessaoLoginUsuario(this);
	}

	public static FormPrincipal getInstance() {
		if (singleton == null) {
			singleton = new FormPrincipal();
			controlador = new C_TelaPrincipal((TelaPrincipal) singleton);
		}
		return (FormPrincipal) singleton;
	}

	private void windowClosed() {
		if (PnlLaudoeCia.foiInstanciado() && !mudandoCartao) {
			PnlLaudoeCia.getInstance().disconnect();
		} else {
		}
		try {
			StaticInfo.desconectarEstacao();
		} catch (Exception ex) {
		}
	}

	// </editor-fold>

	@Override
	public boolean sairOk() {
		if (PnlLaudoeCia.foiInstanciado()) {
			if (PnlLaudoeCia.getInstance().estaGravandoCd()) {
				mostrarMensagemDeErro(
						"Existe um cd\\dvd sendo gravado.\n" + "Aguarde alguns minutos para sair do programa.", this);
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	protected void sairDoPrograma() {
		if (CARD_MDI.equals(getPnlCartao().getSelectedCard())) {
			super.sairDoPrograma();
		} else {
			PnlLaudoeCia.getInstance().voltar();
		}
	}

	@Override
	public void exigirLoginDoUsuario() {
		DlgLogin dlgLogin = new DlgLogin(this, true);
		dlgLogin.setVisible(true);
	}

	@Override
	public void suspenderSessao() {
		controlador.suspenderSessao();
	}

	@Override
	public void start(final boolean exigirLoginDoUsuario) {
		setIconImage(ImageResources.getImage(ImagensLC.ICONE_LC));
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (exigirLoginDoUsuario) {
					exigirLoginDoUsuario();
				}
			}

		});
		setMinimumSize(new Dimension(640, 480));
		pack();
		setVisible(true);
	}

	@Override
	public void setCursorToWaitCursor() {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
	}

	@Override
	public void setCursorToDefaultCursor() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public Usuario solicitarUsuario() {
		DlgValidarUsuario dlgConfirmUsuario = new DlgValidarUsuario(this, true);
		dlgConfirmUsuario.setVisible(true);
		return dlgConfirmUsuario.getUsuario();
	}

	@Override
	public void mostrarMensagemDeErro(String mensagem, Tela t) {
		if (t instanceof Component) {
			SwingUtils.mostrarMensagemDeErroConhecido((Component) t, mensagem);
		} else {
			throw new IllegalArgumentException("A tela informada não é um componente");
		}
	}

	@Override
	public void iniciarTarefa(String descricao) {
		FormBuilder.getInstance().iniciarTarefa(descricao);
	}

	@Override
	public void terminarTarefa(String mensagem) {
		FormBuilder.getInstance().terminarTarefa(mensagem);
	}

	// <editor-fold defaultstate="collapsed" desc="Mostrar telas">

	private boolean isFullScreenNow = false;

	@Override
	public void mostrarRelAuditoria(List<AcaoDoUsuario> lista) {
		setCursorToWaitCursor();
		JRViewer jrv = RelAuditoriaCreator.getRelatorio(lista);
		if (jrv != null) {
			JFrameRelatorios frame = new JFrameRelatorios("Relatorio de Auditoria - Ações dos usuários");
			frame.add(jrv);
			frame.setVisible(true);
		} else {
			SwingUtils.mostrarAviso(null, "Não há dados a serem mostrados");
		}
		setCursorToDefaultCursor();
	}

	@Override
	public void mostrarComprovanteAtd(Atendimento atd) {
		setCursorToWaitCursor();
		JRViewer jrv = RelAtendCreator.getComprovante(atd);
		if (jrv != null) {
			JFrameRelatorios frame = new JFrameRelatorios(
					"Comprovante do atendimento: " + atd.getCodigo() + " - " + atd.toString());
			frame.add(jrv);
			frame.setVisible(true);
		}
		setCursorToDefaultCursor();
	}

	@Override
	public void mostrarTela(int tela, TelaSolicitante telaSol) {
		boolean fullScreen = false;
		Class<? extends JInternalFrame> iframeClass = ViewFactory.getInstance().getIFrameClass(tela);
		if (iframeClass == null) {
			MyJDialog myJDialog = ViewFactory.getInstance().getMyJDialog(tela, this);
			if (myJDialog == null) {
				PnlFormPrincipal pnl = ViewFactory.getInstance().getJPanel(tela);
				if (pnl == null) {
					getPnlCartao().setSelectedCard(CARD_MDI);
					setJMenuBar(FormBuilder.getInstance().getJMenuBar());
				} else {
					fullScreen = mostrarPnlFromPrincipal(pnl);
				}
			} else {
				if (telaSol != null && myJDialog instanceof DlgCadastro) {
					((DlgCadastro) myJDialog).iniciarBusca(telaSol.getReceptorDeBusca(), telaSol.getParametroDeBusca());
				}
				myJDialog.setVisible(true);
				fullScreen = isFullScreenNow;
			}
		} else {
			mostrarIFrame(iframeClass, telaSol);
		}
		configurarFullScreen(fullScreen);
	}

	private void mostrarIFrame(Class<? extends JInternalFrame> iframeClass, TelaSolicitante telaSol) {
		JInternalFrame iframe = getIFrame(iframeClass);
		if (iframe == null) {
			try {
				iframe = iframeClass.newInstance();
				adicionarInternalFrame(iframe);
			} catch (InstantiationException | IllegalAccessException e) {
			}
		} else {
			selecionarIFrame(iframe);
		}
		if (!(telaSol == null || TELA_NULL == telaSol.getCodigo()) && iframe instanceof IFrameCadastro) {
			IFrameCadastro iframeFornecedor = (IFrameCadastro) iframe;
			// redesign this call... may throw ClassCastException
			IFrameCadastro iframeSolicitante = (IFrameCadastro) getIFrame(
					ViewFactory.getInstance().getIFrameClass(telaSol.getCodigo()));
			try {
				iframeSolicitante.setIcon(true);
			} catch (PropertyVetoException ex) {
			}

			iframeFornecedor.iniciarBusca(iframeSolicitante, telaSol.getParametroDeBusca());
		}
	}

	private boolean mostrarPnlFromPrincipal(PnlFormPrincipal pnl) {
		String cardId = pnl.getClass().getName();
		getPnlCartao().addCard(pnl.getContainer(), cardId);
		getPnlCartao().setSelectedCard(cardId);
		pnl.selected();
		setJMenuBar(pnl.getMenu());
		return pnl.fullScreen();
	}

	private void configurarFullScreen(boolean fullScreen) {
		mudandoCartao = true;
		if (fullScreen) {
			if (!isFullScreenNow) {
				dispose();
				setUndecorated(true);
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				setBounds(0, 0, screenSize.width, screenSize.height);
				isFullScreenNow = true;
				setVisible(true);
			}
		} else {
			if (isFullScreenNow) {
				dispose();
				setUndecorated(false);
				setExtendedState(JFrameMdi.MAXIMIZED_BOTH);
				isFullScreenNow = false;
				setVisible(true);
			}
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				mudandoCartao = false;
			}

		});
		// <editor-fold defaultstate="collapsed" desc="Outra possibilidade, não aceita
		// jdialog">

//        GraphicsDevice device = getGraphicsConfiguration().getDevice();
//        if (device.isFullScreenSupported())
//        {
//            if (fullScreen)
//            {
//                if (device.getFullScreenWindow() != this)
//                {
//                    dispose();
//                    setUndecorated(true);
//                    device.setFullScreenWindow(FormPrincipal.this);
//                }
//            }
//            else
//            {
//                if (device.getFullScreenWindow() == this)
//                {
//                    dispose();
//                    setUndecorated(false);
//                    device.setFullScreenWindow(null);
//                    setExtendedState(JFrameMdi.MAXIMIZED_BOTH);
//                }
//            }
//            setVisible(true);
//        }

		// </editor-fold>
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Package private">

	void atualizarBackground() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				int bgColor = StaticInfo.getParametrosDoSistema().getBgColor();
				if (bgColor == 0) {
					try {
						setBackgroundImage(StaticInfo.getBackgroundImage(), MyJDesktopPane.REDIMENSIONAR);
					} catch (IOException ex) {
						setBackgroundColor(Color.lightGray);
					}
				} else {
					setBackgroundColor(new Color(bgColor));
				}
			}

		});
	}

	// </editor-fold>

	public DlgLogin getDlgLogin() {
		return dlgLogin;
	}
	
	public void setDlgLogin(DlgLogin dlgLogin) {
		this.dlgLogin = dlgLogin;
	}
}
