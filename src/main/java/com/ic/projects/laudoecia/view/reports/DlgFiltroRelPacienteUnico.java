package com.ic.projects.laudoecia.view.reports;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePacientes;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.lib.swing.autocompletar.TxtComAutoCompletar;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.imagens.SwingLibResources;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJDialog;
import com.lib.swing.plus.cps.MyJPanel;
import com.lib.swing.plus.utils.LblNegrito;
import com.lib.swing.plus.utils.PnlComp;
import com.lib.swing.utils.SwingUtils;

import net.sf.jasperreports.swing.JRViewer;

public class DlgFiltroRelPacienteUnico extends MyJDialog {
	private BuscadorDePacientes buscPaciente = new BuscadorDePacientes();

	public DlgFiltroRelPacienteUnico(Component cp) {
		super(cp, false, 440, 260);
		setTitle("Relatório de Paciente Específico");
		initComponents();
	}

	private void initComponents() {

		pnlPrincipal.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;

		c.gridy = 0;
		pnlPrincipal.add(lblExplicacao1, c);
		c.gridy = 1;
		pnlPrincipal.add(lblExplicacao2, c);
		c.gridy = 2;
		pnlPrincipal.add(Box.createVerticalStrut(20), c);
		c.gridy = 3;
		pnlPrincipal.add(new PnlComp("Paciente", false, true).setComponent(txtPaciente), c);
		c.gridy = 4;
		pnlButtons.setLayout(new FlowLayout(FlowLayout.TRAILING));
		pnlButtons.add(btnGerarPdf);
		pnlButtons.add(btnGerarRel);
		pnlButtons.add(btnCancelar);
		pnlPrincipal.add(new PnlComp("", false, false).setComponent(pnlButtons), c);
	}

	private void btnGerarPdfAction() {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Paciente paciente = buscPaciente.getSelectedModel();
		List<Paciente> lista = new ArrayList<Paciente>();
		lista.add(paciente);

		if (!RelCadastrosCreator.exportToPDF(TelaPrincipal.REL_PACIENTE_ANALITICO,  lista)) {
			SwingUtils.mostrarMsgDeInformacao(this, "Não há dados a serem mostrados!");
		}
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	private void btnGerarRelAction() {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Paciente paciente = buscPaciente.getSelectedModel();
		List<Paciente> lista = new ArrayList<Paciente>();
		lista.add(paciente);
		
		JRViewer jrv = RelCadastrosCreator.getRelatorio(TelaPrincipal.REL_PACIENTE_ANALITICO, lista);
		if (jrv != null) {
			JFrameRelatorios frame = new JFrameRelatorios(this.getTitle());
			frame.add(jrv);
			frame.setVisible(true);
		} else {
			SwingUtils.mostrarMsgDeInformacao(this, "Não há dados a serem mostrados!");
		}
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	private void btnCancelarAction() {
		fechar();
	}

	@Override
	public void fechar() {
		this.setVisible(false);
	}

	// <editor-fold defaultstate="collapsed" desc="Components Filtro">
	private MyJPanel pnlPrincipal = new MyJPanel();
	private LblNegrito lblExplicacao1 = new LblNegrito();
	private LblNegrito lblExplicacao2 = new LblNegrito();
	private TxtComAutoCompletar txtPaciente = new TxtComAutoCompletar();
	private MyJPanel pnlButtons = new MyJPanel();
	private MyJButton btnGerarPdf = new MyJButton();
	private MyJButton btnGerarRel = new MyJButton();
	private MyJButton btnCancelar = new MyJButton();
	// </editor-fold>

	// Configuração dos Components
	{
		pnlPrincipal.setBorder(new EmptyBorder(17, 10, 10, 10));
		add(pnlPrincipal);

		lblExplicacao1.setText(" Para gerar o relatório, selecione o Paciente desejado");

		btnGerarPdf.setText("Gerar PDF");
		btnGerarPdf.setIcon(SwingLibResources.getIcon(Imagens.PDF_FILE));
		btnGerarPdf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnGerarPdfAction();
			}

		});
		btnGerarRel.setText("Gerar Relatório");
		btnGerarRel.setIcon(SwingLibResources.getIcon(Imagens.OK));
		btnGerarRel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnGerarRelAction();
			}

		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setIcon(SwingLibResources.getIcon(Imagens.CANCELAR));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelarAction();
			}

		});
		txtPaciente.setControlador(buscPaciente);

	}

}
