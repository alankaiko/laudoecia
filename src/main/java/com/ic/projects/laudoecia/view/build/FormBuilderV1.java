/**
 * FormBuilderV1.java
 * <p>
 * Created on 15/12/2011, 18:18:07
 */
package com.ic.projects.laudoecia.view.build;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaSolicitanteNull;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import com.ic.projects.laudoecia.view.laudoecia.PnlLaudoeCia;
import com.ic.projects.laudoecia.view.utils.DiretorioDoSistemaUtil;
import com.ic.projects.laudoecia.view.utils.HelpDoSistema;
import com.ic.projects.laudoecia.view.utils.TermosEContrato;
import com.lib.model.cnv.ConversorByteArrayImage;
import com.lib.swing.imagens.Imagens;
import com.lib.swing.plus.cps.MyJButton;
import com.lib.swing.plus.cps.MyJLabel;
import com.lib.swing.plus.utils.BtnTextoEmBaixo;
import com.lib.swing.plus.utils.MacBtnsController;
import com.lib.swing.utils.SwingUtils;

/**
 * @author Amsterdam Luís <amsterdamluis@gmail.com.br>
 */
class FormBuilderV1 extends FormBuilder {
	private boolean mostrarCadastrosDoControleDeAcesso;
	private boolean criarMenusDeControleDeSessão;

	private JMenuBar menuBar;

	FormBuilderV1() {
		this.mostrarCadastrosDoControleDeAcesso = ControladorDeAcesso.getInstance().mostrarCadastrosDoControleDeAcesso();
		this.criarMenusDeControleDeSessão = ControladorDeAcesso.getInstance().criarMenusDeControleDeSessão();
	}

	private void criarJMenu() {
		criarBarraDeMenus();

		criarMenu(" Cadastros ", 'C');
		criarItemDeMenu("Convênios",
				new ActionAddTela(TelaPrincipal.CADASTRO_CONVENIOS, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaConvenio();
					}
				}));// , "ctrl alt C");
		criarItemDeMenu("Exames e procedimentos médicos",
				new ActionAddTela(TelaPrincipal.CADASTRO_PROC_MEDICO, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaProcMedico();
					}
				}));// , "ctrl alt E");
		criarItemDeMenu("Grupos de exames e procedimentos",
				new ActionAddTela(TelaPrincipal.CADASTRO_GRUPOS_PROCEDIMENTOS, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaGrupoProcedimento();
					}
				}));// , "ctrl alt G");
		criarItemDeMenu("Pacientes",
				new ActionAddTela(TelaPrincipal.CADASTRO_PACIENTES, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaPaciente();
					}
				}), "ctrl alt P");
		criarItemDeMenu("Profissionais executantes",
				new ActionAddTela(TelaPrincipal.CADASTRO_PROF_EXECUTANTE, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaProfExecutante();
					}
				}));// , "ctrl alt X");
		criarItemDeMenu("Profissionais solicitantes",
				new ActionAddTela(TelaPrincipal.CADASTRO_PROF_SOLICITANTE, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaProfSolicitante();
					}
				}));// , "ctrl alt S");
		criarItemDeMenu("Textos pessoais",
				new ActionAddTela(TelaPrincipal.CADASTRO_TEXTOS_PADROES, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaTextoPadrao();
					}
				}));// , "ctrl alt T");
		criarItemDeMenu("Abreviaturas",
				new ActionAddTela(TelaPrincipal.CADASTRO_ABREVIATURAS, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return true;
					}
				}));
//        criarItemDeMenu("Recortes de imagem", new ActionAddTela(TelaPrincipal.CADASTRO_RECORTES,
//                new AdapterPermissaoDeUsuario(){
//                    @Override
//                    public boolean podeAcessar (PerfilDeAcesso p)
//                    {
//                        return true;
//                    }
//                }));
		if (mostrarCadastrosDoControleDeAcesso) {
			criarSeparador();
			criarItemDeMenu("Grupos de usuários",
					new ActionAddTela(TelaPrincipal.CADASTRO_GRUPOS_DE_USUARIOS, new AdapterPermissaoDeUsuario() {
						@Override
						public boolean podeAcessar(PerfilDeAcesso p) {
							return p.isAcessaGrupoDeUsuarios();
						}

					}));// , "ctrl alt Z");
			criarItemDeMenu("Usuários",
					new ActionAddTela(TelaPrincipal.CADASTRO_USUARIOS, new AdapterPermissaoDeUsuario() {
						@Override
						public boolean podeAcessar(PerfilDeAcesso p) {
							return p.isAcessaUsuario();
						}

					}));// , "ctrl alt U");
		}

		criarMenu(" Operações ", 'O');
		criarItemDeMenu("Atendimento", new ActionAddTela(TelaPrincipal.ATENDIMENTO, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return p.isAcessaAtendimento();
			}

		}), "ctrl alt A");
		criarItemDeMenu("Captura", actionCaptura, "ctrl alt C");
		criarItemDeMenu("Laudos", actionLaudo, "ctrl alt L");

		criarMenu(" Relatórios ", 'R');
		criarSubMenu("Atendimentos");
		criarItemDeMenu("Completo", new ActionAddTela(TelaPrincipal.REL_ATD_COMPLETO, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return p.isAcessaRelAtendCompleto();
			}
		}));
		criarItemDeMenu("Por convênio",
				new ActionAddTela(TelaPrincipal.REL_ATD_POR_CONVENIO, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaRelAtendPorConvenio();
					}
				}));
		criarItemDeMenu("Por procedimento médico",
				new ActionAddTela(TelaPrincipal.REL_ATD_POR_PROC_MED, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaRelAtendPorProcMedico();
					}
				}));
		criarItemDeMenu("Por profissional executante",
				new ActionAddTela(TelaPrincipal.REL_ATD_POR_PROF_EXE, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaRelAtendPorProfExe();
					}
				}));
		criarItemDeMenu("Por profissional solicitante",
				new ActionAddTela(TelaPrincipal.REL_ATD_POR_PROF_SOL, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaRelAtendPorProfSol();
					}
				}));
		criarItemDeMenu("Resumido", new ActionAddTela(TelaPrincipal.REL_ATD_RESUMOS, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return p.isAcessaRelAtendResumos();
			}
		}));
		criarSeparador();
		criarItemDeMenu("Gráfico de atendimentos",
				new ActionAddTela(TelaPrincipal.GRAF_ATDENDIMENTOS, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaGrafAtendimentos();
					}
				}));
		sairDoSubMenu();
		criarSubMenu("Cadastros");
		criarItemDeMenu("Convênios", new ActionAddTela(TelaPrincipal.REL_CONVENIOS, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return true;
			}
		}));
		criarItemDeMenu("Pacientes", new ActionAddTela(TelaPrincipal.REL_PACIENTES, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return true;
			}
		}));
		criarItemDeMenu("Procedimentos médicos",
				new ActionAddTela(TelaPrincipal.REL_PROC_MEDICO, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return true;
					}
				}));
		criarItemDeMenu("Profissionais executantes",
				new ActionAddTela(TelaPrincipal.REL_PROF_EXEC, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return true;
					}
				}));
		sairDoSubMenu();
		if (mostrarCadastrosDoControleDeAcesso) {
			criarSeparador();
			criarItemDeMenu("Auditoria do banco de dados",
					new ActionAddTela(TelaPrincipal.CADASTRO_AUDITORIA_BD, new AdapterPermissaoDeUsuario() {
						@Override
						public boolean podeAcessar(PerfilDeAcesso p) {
							return p.isAcessaAuditoria();
						}
					}));
		};
		criarSubMenu("Relatórios LGPD");
		criarItemDeMenu("Relátorio Paciente Único", new ActionAddTela(TelaPrincipal.REL_PACIENTE_ANALITICO, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return true;
			}
		}));
		sairDoSubMenu();
		criarSeparador();
		criarItemDeMenu("Todos os relatórios", new ActionAddTela(TelaPrincipal.RELATORIOS_TODOS), "ctrl alt R");

		criarMenu(" Base de dados ", 'B');
		criarItemDeMenu("CBHPM", new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_CBHPM));
		criarItemDeMenu("CEP", new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_CEP));
		criarItemDeMenu("CID10", new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_CID10));
		criarItemDeMenu("CNES", new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_CNES));
		criarItemDeMenu("CRM", new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_CRM));
		criarItemDeMenu("Especialidades médicas", new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_ESPECIALIDADE_MEDICA));

		criarMenu(" Ferramentas ", 'F');
		if (criarMenusDeControleDeSessão) {
			criarItemDeMenu("Alternar usuário", new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LaudoeCia.getTelaPrincipal().exigirLoginDoUsuario();
				}
			});
			criarItemDeMenu("Suspender sessão", new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LaudoeCia.getTelaPrincipal().suspenderSessao();
				}
			}, "F12");
			criarSeparador();
		}
		criarItemDeMenu("Backup", new ActionAddTela(TelaPrincipal.BACKUP_INSTANTANEO, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return p.isAcessaBackup();
			}
		}));
		criarItemDeMenu("Estações de trabalho",
				new ActionAddTela(TelaPrincipal.ESTACOES_DE_TRABALHO, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaEstacaoDeTrabalho();
					}
				}));
		criarItemDeMenu("Parâmetros do sistema",
				new ActionAddTela(TelaPrincipal.PARAMETROS_DO_SISTEMA, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaParametrosDoSistema();
					}
				}));
//        criarItemDeMenu("Suporte remoto", new ActionListener()
//        {
//            @Override
//            public void actionPerformed (ActionEvent e)
//            {
//
//                try
//                {
//                    String path = "C:\\Suporte_remoto";
//                    File file = new File(path);
//                    if(file != null){
//                        Runtime.getRuntime().exec( path + "\\Suporte_remoto");
//                    }else{
//                        SwingUtils.mostrarAviso(null, path);
//                    }
//                }
//                catch (IOException ex)
//                {
//                    SwingUtils.mostrarMensagemDeErroConhecido(null, ex.getMessage());
//                    Logger.getLogger(FormBuilderV1.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        criarSeparador();
		criarItemDeMenu("Dados do licenciado",
				new ActionAddTela(TelaPrincipal.DADOS_DO_LICENCIADO, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaLicenciado();
					}
				}));

		criarItemDeMenu("Parametros de E-mail",
				new ActionAddTela(TelaPrincipal.PARAMETROS_EMAIL, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaParametrosEmail();
					}
				}));
		
		//Com um pouco de pressa
		criarItemDeMenu("Abrir pasta de imagens selecionadas", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DiretorioDoSistemaUtil.VerificaPastaDeImgBkp();
					Runtime.getRuntime().exec("explorer " + DiretorioDoSistemaUtil.PegaDiretorioImgBackup());
				} catch (IOException erro) {
					System.out.println("Erro na Classe FormBuilder1 do pacote VIEW.BUILD - método criarItemdeMenu (Abrir pasta de imagens selecionadas)");
					erro.printStackTrace();
				}
				
			}
		});
		criarSeparador();
		criarItemDeMenu("Termos de Consentimento",
			new ActionAddTela(TelaPrincipal.CONSENTIMENTO, new AdapterPermissaoDeUsuario() {
				@Override
				public boolean podeAcessar(PerfilDeAcesso p) {
					return p.isAcessaConsentimento();
			}
		}));
		
		criarItemDeMenu("Políticas de Privacidade",
			new ActionAddTela(TelaPrincipal.POLITICAS_PRIVACIDADE, new AdapterPermissaoDeUsuario() {
				@Override
				public boolean podeAcessar(PerfilDeAcesso p) {
					return p.isAcessaPoliticaPrivacidade();
				}
			}
		));
		
		alinharProximosADireita();

		criarMenu(" Ajuda ");
		criarItemDeMenu("Ajuda na internet", null).setEnabled(false);
		criarItemDeMenu("Manual do programa", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDoSistema.abreManual(null);
			}
		}, "F1");
		criarItemDeMenu("Termos e contrato", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TermosEContrato.getInstance().abrirContrato();
			}
		}).setEnabled(true);
		
		criarSeparador();
		criarItemDeMenu("Sobre o sistema", new ActionAddTela(TelaPrincipal.AJUDA_SOBRE));

		menuBar = menuBarCriado();
	}

	@Override
	public JMenuBar getJMenuBar() {
		if (menuBar == null) {
			criarJMenu();
		}
		return menuBar;
	}

	@Override
	public JPanel getToolBar() {
		return null;
	}

	@Override
	public Component[] getDesktopPaneComponents() {
		MyJButton[] macButons = criarBtnsDskPrincipal();
		MacBtnsController.control(macButons, 0.7f);
		Component[] componentes = new Component[macButons.length + 1];
		System.arraycopy(macButons, 0, componentes, 0, macButons.length);
		componentes[macButons.length] = criarLogomarcaDoSistema();
		return componentes;
	}

	private MyJButton[] criarBtnsDskPrincipal() {
		BtnTextoEmBaixo btnAtendimento = new BtnTextoEmBaixo("Iniciar Atendimento");
		btnAtendimento.setToolTipText("Atendimento (Ctrl+Alt+A)");
		btnAtendimento.setBounds(10, 10, 145, 60);
		btnAtendimento.setForeground(Color.red);
		btnAtendimento.setIcon(ImageResources.getIcon(ImagensLC.ATENDIMENTO_ICON));
		btnAtendimento.addActionListener(new ActionAddTela(TelaPrincipal.ATENDIMENTO, new AdapterPermissaoDeUsuario() {
			@Override
			public boolean podeAcessar(PerfilDeAcesso p) {
				return p.isAcessaAtendimento();
			}

		}));

		BtnTextoEmBaixo btnLaudos = new BtnTextoEmBaixo("Laudos");
		btnLaudos.setToolTipText("Laudos (Ctrl+Alt+L)");
		btnLaudos.setBounds(15, 75, 135, 60);
		btnLaudos.setIcon(ImageResources.getIcon(ImagensLC.LAUDO_ICON));
		btnLaudos.addActionListener(actionLaudo);

		BtnTextoEmBaixo btnPacientes = new BtnTextoEmBaixo("Histórico");
		btnPacientes.setToolTipText("Histórico (Ctrl+Alt+P)");
		btnPacientes.setBounds(15, 140, 135, 60);
		btnPacientes.setIcon(ImageResources.getIcon(ImagensLC.PACIENTE_ICON));
		btnPacientes
				.addActionListener(new ActionAddTela(TelaPrincipal.CADASTRO_PACIENTES, new AdapterPermissaoDeUsuario() {
					@Override
					public boolean podeAcessar(PerfilDeAcesso p) {
						return p.isAcessaPaciente();
					}
				}));

		BtnTextoEmBaixo btnCaptura = new BtnTextoEmBaixo("Captura");
		btnCaptura.setToolTipText("Captura (Ctrl+Alt+C)");
		btnCaptura.setBounds(15, 205, 135, 60);
		btnCaptura.setIcon(ImageResources.getIcon(ImagensLC.CAPTURA_ICON));
		btnCaptura.addActionListener(actionCaptura);

		BtnTextoEmBaixo btnRelatorios = new BtnTextoEmBaixo("Relatórios");
		btnRelatorios.setToolTipText("Todos os Relatórios (Ctrl+Alt+R)");
		btnRelatorios.setBounds(15, 270, 135, 60);
		btnRelatorios.setIcon(ImageResources.getIcon(ImagensLC.RELATORIO_ICON));
		btnRelatorios.addActionListener(new ActionAddTela(TelaPrincipal.RELATORIOS_TODOS));

		BtnTextoEmBaixo btnImportar = new BtnTextoEmBaixo("Importar imagens");
		btnImportar.setToolTipText("Importação inteligente de imagens");
		btnImportar.setBounds(15, 335 - 65, 135, 60);
		btnImportar.setIcon(ImageResources.getIcon(Imagens.DOWNLOAD));
		btnImportar.addActionListener(new ActionImportar());

		BtnTextoEmBaixo btnCID10 = new BtnTextoEmBaixo();
		btnCID10.setToolTipText("CID10");
		btnCID10.setBounds(15, 400 - 65, 135, 60);
		btnCID10.setIcon(ImageResources.getIcon(ImagensLC.CID10));
		btnCID10.addActionListener(new ActionAddTela(TelaPrincipal.BASE_DE_DADOS_CID10));

		BtnTextoEmBaixo btnTeam = new BtnTextoEmBaixo("Suporte remoto");
		btnTeam.setToolTipText("Suporte remoto");
		btnTeam.setBounds(15, 465 - 65, 135, 60);
		btnTeam.setIcon(ImageResources.getIcon(ImagensLC.SUPORTE_REMOTO));
		btnTeam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FormPrincipal.getInstance().setCursorToWaitCursor();
					Path path = Paths.get(StaticInfo.getPastaDeInstalacaoDoSistema()).getParent().resolve("utils")
							.resolve("TeamViewerQS_pt.exe");
					Desktop.getDesktop().open(path.toFile());
					FormPrincipal.getInstance().setCursorToDefaultCursor();
				} catch (IOException e1) {
					e1.printStackTrace();
					SwingUtils.mostrarMensagemDeErroConhecido(null, "Erro ao abrir o programa de suporte!");
				}
			}
		});

		return new MyJButton[] { btnAtendimento, btnLaudos, btnPacientes, btnCaptura, btnImportar, btnCID10, btnTeam };
	}

	private MyJLabel criarLogomarcaDoSistema() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Icon icon = ImageResources.getIcon(ImagensLC.LOGO_LC);
		int x = (screenSize.width - icon.getIconWidth()) / 2;
		int y = (screenSize.height - icon.getIconHeight()) / 2;
		MyJLabel lblLogo = new MyJLabel();
		lblLogo.setBounds(x, y - 30, icon.getIconWidth(), icon.getIconHeight());
		lblLogo.setIcon(icon);
		return lblLogo;
	}

	private ActionListener actionLaudo = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			FormPrincipal.getInstance().setCursorToWaitCursor();
			FormPrincipal.getInstance().mostrarTela(TelaPrincipal.LAUDO_E_CAPTURA, new TelaSolicitanteNull());
			PnlLaudoeCia.getInstance().abrirModuloDeLaudo(null, null);
			FormPrincipal.getInstance().setCursorToDefaultCursor();
		}
	};
	private ActionListener actionCaptura = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			FormPrincipal.getInstance().setCursorToWaitCursor();
			FormPrincipal.getInstance().mostrarTela(TelaPrincipal.LAUDO_E_CAPTURA, new TelaSolicitanteNull());
			PnlLaudoeCia.getInstance().abrirModuloDeCaptura(null, null);
			FormPrincipal.getInstance().setCursorToDefaultCursor();
		}
	};

	private class ActionImportar implements ActionListener {
		private DaoAtendimento daoAtd;

		private DaoAtendimento getDaoAtd() {
			if (daoAtd == null) {
				daoAtd = new DaoAtendimento();
			}
			return daoAtd;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			FormPrincipal.getInstance().setCursorToWaitCursor();
			String penDrivePathStr = StaticInfo.getPenDrive();
			if (penDrivePathStr == null || penDrivePathStr.trim().isEmpty()) {
				int i = SwingUtils.obterConfirmacaoDoUsuario(
						"Cada grupo de imagens " + "deve estar em uma pasta "
								+ "cujo nome é o número do atendimento e que está dentro da "
								+ "pasta escolhida para importação.\n"
								+ "As imagens são excluídas após serem importadas.\n" + "Deseja continuar?",
						FormPrincipal.getInstance());
				if (i == JOptionPane.OK_OPTION) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						Path penDrivePath = fileChooser.getSelectedFile().toPath();
						try {
							StaticInfo.setPenDrive(penDrivePath.toString());
						} catch (IOException e1) {
						}
						importar(penDrivePath);
					}
				}
			} else {
				try {
					Path pasta = Paths.get(penDrivePathStr);
					if (Files.exists(pasta)) {
						importar(pasta);
					} else {
						StaticInfo.setPenDrive("");
						actionPerformed(e);
					}
				} catch (Exception e1) {
					try {
						StaticInfo.setPenDrive("");
						actionPerformed(e);
					} catch (IOException e2) {
					}
				}
			}
			FormPrincipal.getInstance().setCursorToDefaultCursor();
		}

		private void importar(Path pasta) {
			try {
				int imageCount = 0;
				int procCount = 0;
				ConversorByteArrayImage c = new ConversorByteArrayImage();
				MyFileVisitor visitor = new MyFileVisitor();
				Files.walkFileTree(pasta, visitor);
				for (Map.Entry<Integer, List<Path>> entry : visitor.imagesMap.entrySet()) {
					Atendimento atendimento = getDaoAtd().procurarPorId(entry.getKey());
					ProcDoAtd proc = atendimento.getProcedimentos().get(0);
					procCount++;
					for (Path path : entry.getValue()) {
						byte[] bytes = c.convertReverse(path.toFile());
						Imagem img = new Imagem(bytes);
						img.setIndice(proc.getImagens().size());
						proc.addImagem(img);
						Files.delete(path);
						imageCount++;
					}
					getDaoAtd().alterar(atendimento);
				}
				SwingUtils.mostrarMsgDeSucesso(FormPrincipal.getInstance(),
						imageCount + " imagens importadas de " + procCount + " procedimentos!");
			} catch (Exception e) {
				SwingUtils.mostrarMensagemDeErroConhecido(FormPrincipal.getInstance(), "Erro ao importar imagens!");
				e.printStackTrace();
			}
		}

		private class MyFileVisitor implements FileVisitor<Path> {
			private Map<Integer, java.util.List<Path>> imagesMap = new HashMap<>();

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				String parentName = file.getParent().getFileName().toString();
				if (isImage(file) && parentName.matches("[0-9]+")) {
					Integer key = Integer.valueOf(parentName);
					if (imagesMap.containsKey(key)) {
						imagesMap.get(key).add(file);
					} else {
						List<Path> files = new ArrayList<>();
						files.add(file);
						imagesMap.put(key, files);
					}
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			private boolean isImage(Path file) {
				String fileName = file.getFileName().toString();
				return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".JPG")
						|| fileName.endsWith(".JPEG") || fileName.endsWith(".png") || fileName.endsWith(".PNG")
						|| fileName.endsWith(".bmp") || fileName.endsWith(".BMP");
			}
		}
	}
}