/*
 * BM_PopupMenu.java
 *
 * Created on 10/04/2012, 17:24:38
 */
package com.ic.projects.laudoecia.view.backup;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.dialogs.DlgLogin;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BM_PopupMenu extends PopupMenu {

	private static BM_PopupMenu singleton;
	private static final long serialVersionUID = 1L;

	private BM_PopupMenu() {
		MenuItem sair = new MenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		add(sair);
		MenuItem restore = new MenuItem("Restaurar dados do sistema");
		restore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CriarLogin();
				DlgBackup.setState(false);
				DlgRestore.setState(true);
			}
		});
		add(restore);
		MenuItem fazerBkp = new MenuItem("Fazer backup do sistema");
		fazerBkp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CriarLogin();
				DlgRestore.setState(false);
				DlgBackup.setState(true);
			}
		});
		add(fazerBkp);
	}

	public static BM_PopupMenu getInstance() {
		if (singleton == null) {
			singleton = new BM_PopupMenu();
		}
		return singleton;
	}

	private void CriarLogin() {
		ControladorDeAcesso.setAcessobackup(true);
		final FormPrincipal fp = FormPrincipal.getInstance();
		fp.setDlgLogin(new DlgLogin(null, true));
		fp.getDlgLogin().setVisible(true);
	}

}
