/*
 * LaudoeCiaMediator.java
 *
 * Created on 27/06/2012, 10:52:36
 */

package com.ic.projects.laudoecia.control.laudoecia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.swing.*;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.ctrlacesso.AdapterPermissaoDeUsuario;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.dao.auditable.DaoEstacaoDeTrabalho;
import com.ic.projects.laudoecia.dao.auditable.DaoImagenImpressa;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.dao.auditable.DaoProcMedico;
import com.ic.projects.laudoecia.dao.cadastro.DaoAcaoDoUsuario;
import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.iview.TelaPrincipal;
import com.ic.projects.laudoecia.iview.TelaSolicitanteNull;
import com.ic.projects.laudoecia.iview.ViewLaudoeCia;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.cadastro.ImagemImpressa;
import com.ic.projects.laudoecia.model.cadastro.ImagemJPEG;
import com.ic.projects.laudoecia.model.cadastro.PaginaDeImagens;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;
import com.ic.projects.laudoecia.model.enums.TIPO_LICENCA;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.model.laudo.Planilha;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.model.notentities.PerfilDeAcesso;
import com.ic.projects.laudoecia.view.audio.AudioResources;
import com.ic.projects.laudoecia.view.audio.AudiosLC;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.ic.projects.laudoecia.view.laudoecia.ServiceJPEG;
import com.ic.projects.laudoecia.view.laudoecia.layouts.PnlLayoutImagens;
import com.ic.projects.laudoecia.view.utils.DiretorioDoSistemaUtil;
import com.lib.icontrol.crud.utils.C_ImpImagens;

/**
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class LaudoeCiaMediator {
	// <editor-fold defaultstate="collapsed" desc="Mensagens de erro/Tipo de
	// exportacao">

	private static final String NENHUM_ATD_SELECIONADO = "Selecione um atendimento!";
	private static final String NENHUMA_IMG_CAPT = "Nenhuma imagem capturada!";
	private static final String NENHUM_VIDEO_FOI_GRAVADO = "Nenhum vídeo foi gravado!";
	private static final String NENHUMA_IMG_SEL = "Selecione uma imagem!";
	private static final String PROC_SEM_MDL = "O procedimento não possui modelo de laudo!";
	private static final String VALIDACAO_MED_EX = "Selecione o médico executante!";
	private static final String NENH_IMG_IMP = "Há páginas que não foram escolhidas imagens!";
	private static final String TIPO_NAO_LAUDOS = "O sistema não está licenciado para o módulo de laudos!";
	private static final String TIPO_NAO_IMAGENS = "O sistema não está licenciado para o módulo de " + " imagens!";

	public static final int EXP_APENAS_IMAGENS = 0;
	public static final int EXP_APENAS_VIDEOS = 1;
	public static final int EXP_IMAGENS_VIDEOS = 2;

	// </editor-fold>

	private AdapterPermissaoDeUsuario pdu = new AdapterPermissaoDeUsuario() {

		@Override
		public boolean podeAcessar(PerfilDeAcesso p) {
			return p.isAcessaLaudo();
		}

		@Override
		public boolean podeAlterar(PerfilDeAcesso p) {
			return p.isAlteraLaudo();
		}

	};

	private Atendimento atdSelecionado;
	private ProcDoAtd procSelecionado;
	private ProcDoAtd procTemp;
	private Laudo laudoAtual = null;
	private Map<ProcDoAtd, CacheMdls> laudosDoAtd = new HashMap<>();
	private Map<Laudo, DadosOriginaisDoLaudo> dadosOriginais = new IdentityHashMap<>();

	private ViewLaudoeCia view;
	private NavegadorImagens navegador = new NavegadorImagens();
	private C_EspacoEmDisco c_EspacoEmDisco;
	private C_ListaDeVideos c_Videos;

	private List<ImagemJPEG> lista = new ArrayList<ImagemJPEG>();
	
	private String viewState;
	private String telaQueChamouImgFS;
	private String telaQueChamouEscImg;

	private boolean isGravandoDisco = false;

	private boolean permitirSelecionarPopupModelo = true;

	private boolean naoTratarEvtAtdMudou = false;
	private boolean naoTratarEvtProcMudou = false;
	private boolean naoTratarEvtMdlMudou = false;
	private boolean naoTratarEvtImpImgMudou = false;
	private boolean estaEscolhendoImgAutom = false;
	private boolean captura = false;
	private boolean mostrarInfoAtd = true;
	private int indexProcSel = 0;
	private int indexImgSelParaEscolhendoAutom = 0;

	private File arqSendoGravado = null;

	private Map<ProcDoAtd, Boolean> mapaAltImgOuVideo = new HashMap<>();

	private DaoAtendimento daoAtd;
	private DaoProcDoAtd daoProc;
	private DaoEstacaoDeTrabalho daoEstTrab;
	private DaoAcaoDoUsuario daoAuditoria;
	private DaoImagem daoImagem;
	private DaoProcMedico daoProcMedico;

	public LaudoeCiaMediator(ViewLaudoeCia view) {
		this.view = view;
		c_EspacoEmDisco = new C_EspacoEmDisco(view);
		c_Videos = new C_ListaDeVideos(view, this);
	}

	// <editor-fold defaultstate="collapsed" desc="Navegador">

	public void irParaImgAnterior() {
		if (navegador.irParaImgAnterior()) {
			view.atualizarSelecao();
		} else {

		}
	}

	public void irParaProximaImg() {
		if (navegador.irParaProximaImg()) {
			view.atualizarSelecao();
		} else {

		}
	}

	public void irParaUltimaImg() {
		if (navegador.irParaUltimaImg()) {
			view.atualizarSelecao();
		} else {

		}
	}

	public void irParaPrimeiraImg() {
		if (navegador.irParaPrimeiraImg()) {
			view.atualizarSelecao();
		} else {

		}
	}

	public void irParaImg(int index) {
		if (navegador.setIndexAtual(index)) {
			view.atualizarSelecao();
		} else {

		}
	}

	public int getIndexAtual() {
		return navegador.getIndexAtual();
	}

	public int getNumeroDeImagens() {
		return navegador.getNumeroDeImagens();
	}

	public String getIndexes() {
		int total = getNumeroDeImagens();
		int indexAtual = 0;
		if (total != 0) {
			indexAtual = getIndexAtual() + 1;
		}
		return indexAtual + " de " + total;
	}

	public byte[] getImagemAtual() {
		return navegador.getImagemAtual();
	}

	private ImagemJPEG getImagemSel() {
		int indexAtual;
		if (estaEscolhendoImgAutom) {
			indexAtual = indexImgSelParaEscolhendoAutom;
			indexImgSelParaEscolhendoAutom++;
		} else {
			indexAtual = getIndexAtual();
		}
		if (getNumeroDeImagens() > 0 && indexAtual >= 0) {
			return this.lista.get(indexAtual);
			//return procSelecionado.getImagens().get(indexAtual);
		}
		return null;
	}

	// </editor-fold>

	public ProcDoAtd getProcSelecionado() {
		return procSelecionado;
	}

	public Atendimento getAtdSelecionado() {
		return atdSelecionado;
	}

	public void atendimentoMudou(Atendimento novoAtdSelecionado) {
		if (naoTratarEvtAtdMudou) {
		} else if (Objects.equals(atdSelecionado, novoAtdSelecionado)) {
		} else if (!salvarAlteracoes()) {
			naoTratarEvtAtdMudou = true;
			view.setAtendimento(atdSelecionado);
			naoTratarEvtAtdMudou = false;
		} else if (!(novoAtdSelecionado == null || ControladorDeAcesso.getInstance().podeAcessar(pdu))) {
			view.setAtendimento(null);
		} else if (arqSendoGravado != null) {
			view.mostrarAviso("Termine a gravação do vídeo!");
			naoTratarEvtAtdMudou = true;
			view.setAtendimento(atdSelecionado);
			naoTratarEvtAtdMudou = false;
		} else {
			atdSelecionado = novoAtdSelecionado;
			resetarCtrlDeAltDeImg();
			configMapaDeLaudos();
			view.limparLaudos();
			if (atdSelecionado == null) {
				view.setProcedimentos(new ArrayList<ProcDoAtd>());
				procMudou(null);
			} else {
				view.setProcedimentos(atdSelecionado.getProcedimentos());
				view.setProcSel(atdSelecionado.getProcedimentos().get(atdSelecionado.getProcedimentos().indexOf(this.procTemp)));
				if (mostrarInfoAtd) {
					// deve vir por ultimo pois mostrar dados acontece de
					// forma modal travando a gui
					// view.mostrarDadosDoAtendimento(atdSelecionado);
				}
			}
		}
	}

	public void procMudou(ProcDoAtd novoProcSel) {
		EstacaoDeTrabalho est;
		if (naoTratarEvtProcMudou) {
		} else if (Objects.equals(procSelecionado, novoProcSel)) {
		} else if (arqSendoGravado != null) {
			view.mostrarAviso("Termine a gravação do vídeo!");
			naoTratarEvtProcMudou = true;
			view.setProcSel(procSelecionado);
			naoTratarEvtProcMudou = false;
		} else if (!(novoProcSel == null || (est = getDaoProc().getEstacao(novoProcSel.getCodigo())) == null)) {
			view.mostrarAviso("O procedimento não pode ser selecionado " 
				+ "porque ele está aberto na estação "
				+ est.getNomeEstacaoDeTrabalho() + "!");
			naoTratarEvtProcMudou = true;
			view.setProcSel(procSelecionado);
			naoTratarEvtProcMudou = false;
		} else if (!salvarAlteracoes()) {
			naoTratarEvtProcMudou = true;
			view.setProcSel(procSelecionado);
			naoTratarEvtProcMudou = false;
		} else {
			if (procSelecionado != null) {
				try {
					getDaoProc().limparPessimisticLock(procSelecionado.getCodigo());
				} catch (Exception e) {
				}
			}

			procSelecionado = novoProcSel;
			ProcMedico procMedico;

			List<byte[]> imgBytesList = new ArrayList<>();
			List<PaginaDeImagens> impImgList;
			if (novoProcSel == null) {
				procMedico = null;
				imgBytesList = new ArrayList<>();
				impImgList = new ArrayList<>();
				c_Videos.setarListaDeVideos(new ArrayList<VideoGravado>());
				permitirSelecionarPopupModelo = true;
			} else {
				try {
					getDaoProc().lock(procSelecionado.getCodigo(), StaticInfo.getEstTrabalho().getCodigo());
				} catch (Exception e) {
				}
				procMedico = novoProcSel.getProcMedico();
				//imgBytesList = converterListaDeImgs(novoProcSel.getImagens());
				this.AtualizarLista();

				for(ImagemJPEG jpeg : this.lista)
					imgBytesList.add(jpeg.getImagem());		
				
				
				impImgList = procSelecionado.getImpressoesDeImg();
				if (impImgList.isEmpty()) {
					PaginaDeImagens paginaDeImagens = new PaginaDeImagens(StaticInfo.getParametrosDoSistema().getLayoutImagem());
					paginaDeImagens.setProcDoAtd(procSelecionado);
					procSelecionado.addImpImagem(paginaDeImagens);
					impImgList = procSelecionado.getImpressoesDeImg();
				}
				c_Videos.setarListaDeVideos(procSelecionado.getVideosGravados());
			}

			ModeloDeLaudoDoProc mdl = criarMdl(novoProcSel);
			naoTratarEvtMdlMudou = true;
			view.configurarLaudo(procMedico, mdl);
			naoTratarEvtMdlMudou = false;
			modeloDeLaudoMudou(mdl);
			navegador.setLista(imgBytesList);
			view.carregarImagens(imgBytesList);
			naoTratarEvtImpImgMudou = true;
			view.carregarImpressoes(impImgList);
			naoTratarEvtImpImgMudou = false;
		}
	}

	public void imagemFoiEditada(byte[] img) {
		ServiceJPEG captur = new ServiceJPEG(this.atdSelecionado, this.procSelecionado);
		this.lista = captur.ListaImagensCapturadas(this.procSelecionado.getProcMedico().getCodigo(), this.procSelecionado.getAtendimento().getCodigo());
		captur.EditarImageNaPasta(this.lista.get(getIndexAtual()).getNomeDaImagem(), img);
		
		//Imagem imagem = new Imagem(img);
		naoTratarEvtImpImgMudou = true;
		//imagemImpressaMudou(getImagemSel(), imagem);
		naoTratarEvtImpImgMudou = false;
		//procSelecionado.setImagem(getIndexAtual(), imagem);
		navegador.atualizarImgSel(img);		
		view.imgSelMudou();
		mapaAltImgOuVideo.put(procSelecionado, true);
	}

	public void imagemFoiCriada(byte[] img, boolean playAudio) {
		ServiceJPEG captur = new ServiceJPEG(this.atdSelecionado, this.procSelecionado);
		
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else {
			//final Imagem imagem = new Imagem(img);
			//imagem.setIndice(getNumeroDeImagens());
			//procSelecionado.addImagem(imagem);
			captur.CriaImagemNaPasta(img);
			
			mapaAltImgOuVideo.put(procSelecionado, true);
			navegador.addImagem(img);
			view.addImagem(img);
			view.atualizarSelecao();
			AtualizarLista();
			if (playAudio) {
				new SwingWorker<Void, Void>() {
					@Override
					protected Void doInBackground() throws Exception {
						AudioResources.executaArquivoDeAudio(AudiosLC.CAPTURAR_IMAGEM);
						return null;
					}
				}.execute();
			}
			new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					//ImgBackupManager.backupImage(procSelecionado.getCodigo(), imagem);
					return null;
				}
			}.execute();
		}
	}

	public void removerImgSelecionada() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (navegador.getIndexAtual() < 0) {
			view.mostrarMsgErro(NENHUMA_IMG_SEL);
		} else if (!view.obterConfirmacaoDoUsuario("Essa ação não " + "pode ser desfeita.\nContinuar mesmo assim?")) {
		} else {
			naoTratarEvtImpImgMudou = true;
			//final Imagem imgSel = getImagemSel();
			//imagemImpressaMudou(imgSel, null);
			naoTratarEvtImpImgMudou = false;
			//procSelecionado.removeImagem(getIndexAtual());
			mapaAltImgOuVideo.put(procSelecionado, true);
			view.removerImgSelecionada();
			navegador.removerImgSelecionada();
			view.atualizarSelecao();

			System.out.println(getIndexAtual());
			this.AtualizarLista();

			ServiceJPEG referencia = new ServiceJPEG(this.atdSelecionado, this.procSelecionado);
			referencia.ExcluirImagem(getIndexAtual() > 0 ? this.lista.get(getIndexAtual()) : this.lista.get(0));
		}
	}

	public void iniciarEdicaoDeImg() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (navegador.getIndexAtual() < 0) {
			view.mostrarMsgErro(NENHUMA_IMG_SEL);
		} else {
			view.editarImagemAtual();
		}
	}

	public boolean validarMoverImg() {
		if (atdSelecionado == null || procSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		}
		// else if (navegador.getNumeroDeImagens() == 0)
		// {
		// view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		// }
		else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			return true;
		}
		return false;
	}

	public boolean moverImagens(Collection<ImagemJPEG> imagens, ProcDoAtd procDestino) {
		if (imagens.isEmpty()) {
			view.mostrarMsgErro("Escolha pelo menos uma imagem para ser movida!");
		} else if (procDestino == null) {
			view.mostrarMsgErro("Escolha um procedimento!");
		} else if (Objects.equals(procDestino, procSelecionado)) {
			view.mostrarMsgErro("As imagens já pertencem ao procedimento selecionado!");
		} else {
			ProcDoAtd novoProcDestino = procDestino;
			for (ProcDoAtd procDoAtdLoop : atdSelecionado.getProcedimentos()) {
				if (Objects.equals(procDoAtdLoop, novoProcDestino)) {
					novoProcDestino = procDoAtdLoop;
					break;
				}
			}
			// codigo necessário porque senao a coleção, configurada como lazy,
			// pode não ser lida corretamente no codigo addImagem
			novoProcDestino.getImagens().size();
			for (ImagemJPEG imagem : imagens) {
				ServiceJPEG referencia = new ServiceJPEG(this.atdSelecionado, novoProcDestino);
				referencia.CriaImagemNaPasta(imagem.getImagem());
				
				referencia = new ServiceJPEG(this.atdSelecionado, this.procSelecionado);
				referencia.ExcluirImagem(imagem);

			}
			if (Objects.equals(procDestino.getAtendimento(), atdSelecionado)) {
				mapaAltImgOuVideo.put(novoProcDestino, true);
			} else {
				try {
					getDaoProc().alterar(novoProcDestino);
				} catch (Exception ex) {
					view.mostrarMsgErro("Atenção! A conexão com o servidor foi perdida!\n"
							+ "Normalize a situação antes de continuar o exame!");
				}
			}
			mapaAltImgOuVideo.put(procSelecionado, true);
			List<byte[]> imgBytesList = converterListaDeImgs(procSelecionado.getImagens());
			navegador.setLista(imgBytesList);
			view.carregarImagens(imgBytesList);
			List<PaginaDeImagens> impImgList = procSelecionado.getImpressoesDeImg();
			naoTratarEvtImpImgMudou = true;
			view.carregarImpressoes(impImgList);
			naoTratarEvtImpImgMudou = false;
			view.mostrarMsgSucesso("Imagens movidas com sucesso!");
			this.Remanejar(procDestino);
			return true;
		}
		return false;
	}
	
	public void Remanejar(ProcDoAtd procdestino) {
		ProcDoAtd procedimento = getProcSelecionado();
		this.procMudou(procdestino);
		this.procMudou(procedimento);
	}

	public boolean importarImagens(List<ImagemJPEG> imagens) {
		if (imagens.isEmpty()) {
			view.mostrarMsgErro("Escolha pelo menos uma imagem para ser importada!");
		} else {
			for (ImagemJPEG imagen : imagens) {
				imagemFoiCriada(imagen.getImagem(), false);
			}
			return true;
		}
		return false;
	}

	public void iniciarExportacaoDeArquivos() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else {
			view.exportarArquivosDoProc();
		}
	}

	public boolean salvar() {
		if (atdSelecionado == null) {
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarAviso(PROC_SEM_MDL);
		} else if (!laudoMudou(laudoAtual)) {
			// view.mostrarAviso(LAUDO_NAO_MUDOU);
		} else {
			if (salvarOk(procSelecionado, true, true)) {
				// view.mostrarMsgSucesso("Salvo com sucesso!");
				return true;
			}
		}
		return false;
	}

	public void cancelar() {
		if (atdSelecionado == null || procSelecionado == null) {
		} else if (laudoAtual == null) {
			view.mostrarAviso(PROC_SEM_MDL);
		} else if (!laudoMudou(laudoAtual)) {
			// view.mostrarAviso(LAUDO_NAO_MUDOU);
		} else if (view.obterConfirmacaoDoUsuario("Deseja cancelar a edição do laudo?")) {
			CacheMdls cacheLaudos = laudosDoAtd.get(procSelecionado);
			Laudo pointerParaLaudoOriginal = cacheLaudos.getLaudoOriginal();
			Laudo laudoOriginal = new Laudo(pointerParaLaudoOriginal);
			DadosOriginaisDoLaudo dadosOr = dadosOriginais.get(pointerParaLaudoOriginal);
			laudoOriginal.setCidResultadoDoExame(dadosOr.getCid());
			procSelecionado.setProfExecutante(dadosOr.getExec());
			cacheLaudos.put(laudoOriginal.getModeloDeLaudo(), laudoOriginal);
			view.setLaudo(laudoOriginal);
			naoTratarEvtMdlMudou = true;
			view.configurarLaudo(procSelecionado.getProcMedico(), laudoOriginal.getModeloDeLaudo());
			naoTratarEvtMdlMudou = false;
			laudoAtual = laudoOriginal;
		} else {
		}
	}

	public boolean capturarImagem() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else {
			switch (viewState) {
			case ViewLaudoeCia.CAPTURA:
			case ViewLaudoeCia.LAUDO:
				if (navegador.getNumeroDeImagens() >= 30 && StaticInfo.limitarFotos()) {
					view.mostrarMsgErro("São permitidos no máximo 30 imagens.");
				} else {
					view.capturarImagem();
					if (atdSelecionado.isGravarExame() && procSelecionado.getVideosGravados().isEmpty()) {
						view.btnGravarVideoDoClick(true);
					}
				}
				return true;
			default:
			}
		}
		return false;
	}

	public boolean videoEstaSendoCompactado(String caminho) {
		return c_Videos.videoEstaSendoCompactado(caminho);
	}

	public boolean estaCompactandoVideo() {
		return c_Videos.videoEstaSendoCompactado();
	}

	public boolean estaGravandoCd() {
		return isGravandoDisco;
	}

	public void receita() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else {
			int receituario = StaticInfo.receituario();
			if (receituario > 0) {
				for (ProcDoAtd procDoAtd : atdSelecionado.getProcedimentos()) {
					if (procDoAtd.getProcMedico().getCodigo() == receituario) {
						view.setProcSel(procDoAtd);
						return;
					}
				}
				ProcMedico procMedico = getDaoProcMedico().procurarPorId(receituario);
				if (procMedico == null) {
					view.mostrarAviso("Procedimento não encontrado!");
				} else {
					try {
						ProcDoAtd proc = new ProcDoAtd();
						proc.setCodigo(0);
						proc.setProcDaTabela(procMedico.getProcDaTabela(atdSelecionado.getConvenio()));
						proc.setProfExecutante(proc.getProfExecutante());
						proc.setDataDaExecucao(proc.getDataDaExecucao());
						proc.setAtendimento(atdSelecionado);
						int codigo = atdSelecionado.getCodigo();
						getDaoProc().adicionar(proc);
						view.setAtendimento(null);
						Atendimento atd = getDaoAtendimento().procurarPorId(codigo);
						indexProcSel = atd.getProcedimentos().indexOf(proc);
						mostrarInfoAtd = false;
						view.setAtendimento(atd);
						mostrarInfoAtd = true;
						indexProcSel = 0;
					} catch (Exception e) {

					}
				}
			} else {
				view.mostrarAviso("Contate o suporte técnico para configurar essa função!");
			}
		}
	}

	public void mostrandoPrimeiraTelaDoMdl() {
		if (procSelecionado != null && permitirSelecionarPopupModelo && !procSelecionado.getImagens().isEmpty()) {
			ProcMedico procMedico = procSelecionado.getProcMedico();
			if (procMedico != null) {
				if (procMedico.getLaudoModelo()) {
					java.awt.EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							// getView().abrirPopupModelo();
							permitirSelecionarPopupModelo = false;
						}
					});
				}
			}
		}
	}

	// <editor-fold defaultstate="collapsed" desc="State changes">

	public String getViewState() {
		return viewState;
	}

	public void voltar() {
		switch (viewState) {
		case ViewLaudoeCia.CAPTURA:
		case ViewLaudoeCia.LAUDO:
			view.setAtendimento(null);
			if (atdSelecionado != null) {
				return;
			}
			view.pararCaptura();
			LaudoeCia.getTelaPrincipal().mostrarTela(TelaPrincipal.TELA_NULL, new TelaSolicitanteNull());
			break;
		case ViewLaudoeCia.ESCOLHER_IMAGENS:
			setState(telaQueChamouEscImg);
			break;
		case ViewLaudoeCia.IMAGENS_FULL_SCREEN:
			setState(telaQueChamouImgFS);
			break;
		default:
		}
	}

	public void mostrarImagensEmFullScreen() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else {
			telaQueChamouImgFS = viewState;
			setState(ViewLaudoeCia.IMAGENS_FULL_SCREEN);
		}
	}

	public void escolherImgParaImp() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		}
		// else if (getNumeroDeImagens() == 0)
		// {
		// view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		// }
		else if (viewState.equals(ViewLaudoeCia.ESCOLHER_IMAGENS)) {
		} else {
			telaQueChamouEscImg = viewState;
			setState(ViewLaudoeCia.ESCOLHER_IMAGENS);
		}
	}

	public void mostrarLaudo() {
		setState(ViewLaudoeCia.LAUDO);
	}

	public void mostrarCaptura() {
		setState(ViewLaudoeCia.CAPTURA);
	}

	public void abrirModuloDeCaptura(Atendimento atdASerMostrado, ProcDoAtd procSel) {
		captura = true;
		abrirLaudoeCia(atdASerMostrado, procSel, ViewLaudoeCia.CAPTURA);
	}

	public void abrirModuloDeLaudo(Atendimento atdASerMostrado, ProcDoAtd procSel) {
		captura = false;
		abrirLaudoeCia(atdASerMostrado, procSel, ViewLaudoeCia.LAUDO);
	}

	private void abrirLaudoeCia(Atendimento atd, ProcDoAtd proc, String state) {
		setState(state);
		if (atd == null || proc == null) {
			view.setAtendimento(atd);
		} else {
			this.procTemp = proc;
			mostrarInfoAtd = false;
			view.setAtendimento(atd);
			mostrarInfoAtd = true;
		}
	}

	public void mostrarDlgAguarde(String texto) {
		view.mostrarDlgAguarde(texto);
	}

	public void ocultarDlgAguarde() {
		view.ocultarDlgAguarde();
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Private stuff">

	private boolean existeImgParaImpressao() {
		List<PaginaDeImagens> paginas = procSelecionado.getImpressoesDeImg();
		for (PaginaDeImagens pagina : paginas) {
			if (pagina.getImagens().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private void setState(String state) {
		viewState = state;
		view.setState(state);
		view.atualizarSelecao();
	}

	private DaoProcDoAtd getDaoProc() {
		if (daoProc == null) {
			daoProc = new DaoProcDoAtd();
		}
		return daoProc;
	}

	private DaoProcMedico getDaoProcMedico() {
		if (daoProcMedico == null) {
			daoProcMedico = new DaoProcMedico();
		}
		return daoProcMedico;
	}

	private DaoImagem getDaoImagem() {
		if (daoImagem == null) {
			daoImagem = new DaoImagem();
		}
		return daoImagem;
	}

	private DaoEstacaoDeTrabalho getDaoEstTrab() {
		if (daoEstTrab == null) {
			daoEstTrab = new DaoEstacaoDeTrabalho();
		}
		return daoEstTrab;
	}

	private DaoAcaoDoUsuario getDaoAuditoria() {
		if (daoAuditoria == null) {
			daoAuditoria = new DaoAcaoDoUsuario();
		}
		return daoAuditoria;
	}

	private DaoAtendimento getDaoAtendimento() {
		if (daoAtd == null) {
			daoAtd = new DaoAtendimento();
		}
		return daoAtd;
	}

	private void resetarCtrlDeAltDeImg() {
		mapaAltImgOuVideo.clear();
		if (atdSelecionado == null) {
		} else {
			for (ProcDoAtd procDoAtd : atdSelecionado.getProcedimentos()) {
				mapaAltImgOuVideo.put(procDoAtd, false);
			}
		}
	}

	private ModeloDeLaudoDoProc criarMdl(ProcDoAtd procDoAtd) {
		if (procDoAtd == null) {
			return null;
		} else {
			CacheMdls laudos = laudosDoAtd.get(procDoAtd);
			Iterator<Entry<ModeloDeLaudoDoProc, Laudo>> it = laudos.entrySet().iterator();
			ModeloDeLaudoDoProc mdl = null;
			while (it.hasNext()) {
				Entry<ModeloDeLaudoDoProc, Laudo> entry = it.next();
				mdl = entry.getKey();
			}
			if (mdl == null) {
				mdl = getPreferredMdl(procDoAtd);
				if (mdl == null) {
				} else {
					Laudo laudo = new Laudo(mdl);
					laudo.setProcDoAtd(procDoAtd);
					laudos.put(mdl, laudo);
				}
			}
			return mdl;
		}
	}

	private ModeloDeLaudoDoProc getPreferredMdl(ProcDoAtd proc) {
		ModeloDeLaudoDoProc resposta = null;
		List<ModeloDeLaudoDoProc> modelos = proc.getProcMedico().getModelos();
		for (int i = 0; i < modelos.size(); i++) {
			ModeloDeLaudoDoProc mdlLoop = modelos.get(i);
			if (resposta == null || mdlLoop.getPrioridade() < resposta.getPrioridade()) {
				resposta = mdlLoop;
			}
		}
		return resposta;
	}

	private List<byte[]> converterListaDeImgs(List<Imagem> imagens) {
		List<byte[]> bytes = new ArrayList<>(imagens.size());
		for (int i = 0; i < imagens.size(); i++) {
			bytes.add(imagens.get(i).getImagem());
		}
		return Collections.unmodifiableList(bytes);
	}

	private File img2File(ImagemJPEG img, String path, int index) throws IOException {
		String[] nomeDaImagem = img.getNomeDaImagem().split("\\.");
		File file = new File(path + "\\" + nomeDaImagem[0] + ".jpeg");
		if (file.exists()) {
			if (view.obterConfirmacaoDoUsuario("O arquivo " + file.getAbsolutePath() + " já existe! Deseja substituí-lo?")) {
				file.delete();
			} else {
				return null;
			}
		}
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(img.getImagem());
		}
		return file.exists() ? file : null;
	}

	private void configMapaDeLaudos() {
		laudosDoAtd.clear();
		if (atdSelecionado == null) {
		} else {
			List<ProcDoAtd> procs = atdSelecionado.getProcedimentos();
			for (int i = 0; i < procs.size(); i++) {
				ProcDoAtd procDoAtd = procs.get(i);
				Laudo laudoSalvoNoBd = procDoAtd.getLaudo();
				CacheMdls laudosDoProc = new CacheMdls(laudoSalvoNoBd);
				if (laudoSalvoNoBd == null) {
				} else {
					laudosDoProc.put(laudoSalvoNoBd.getModeloDeLaudo(), laudoSalvoNoBd);
				}
				laudosDoAtd.put(procDoAtd, laudosDoProc);
			}
		}
	}

	private boolean salvarAlteracoes() {
		if (atdSelecionado == null) {
			return true;
		} else {
			try {
				for (ProcDoAtd procDoAtd : atdSelecionado.getProcedimentos()) {
					boolean salvar;
					boolean salvarLaudo = false;
					if (procDoAtd.getProcMedico().getModelos().isEmpty()) {
						salvar = mapaAltImgOuVideo.get(procDoAtd);
					} else if (laudoMudou(getLaudoDoProc(procDoAtd))) {
						salvar = true;
						salvarLaudo = true;
					} else {
						salvar = mapaAltImgOuVideo.get(procDoAtd);
					}
					if (salvar && !salvarOk(procDoAtd, salvarLaudo, true)) {
						return false;
					}
				}
			} catch (Exception e) {
				view.mostrarMsgErro(e.getMessage());
				return false;
			}
		}
		return true;
	}

	private boolean confirmarAlterarLaudoJaImpresso(ProcDoAtd p) {
		for (PaginaDeImagens paginaDeImagens : p.getImpressoesDeImg()) {
			if (paginaDeImagens.getCodigo() != 0 && !paginaDeImagens.getImagens().isEmpty()) {
				return !view.obterConfirmacaoDoUsuario("O laudo do procedimento " + p.getProcMedico().toString()
						+ " foi alterado, mas " + "ele parece já ter sido impresso.\nDeseja cancelar?");
			}
		}
		return true;
	}

	private boolean laudoMudou(Laudo laudo) {
		if (laudo == null || laudo.getProcDoAtd() == null) {
			return false;
		}
		CacheMdls cacheLaudos = laudosDoAtd.get(laudo.getProcDoAtd());
		if (cacheLaudos.getLaudoOriginal() == null) {
		} else if (!Objects.equals(cacheLaudos.getLaudoOriginal().getModeloDeLaudo(), laudo.getModeloDeLaudo())) {
		} else {
			DadosOriginaisDoLaudo dadosOr = dadosOriginais.get(laudo);
			if (dadosOr == null) {
				return false;
			} else if (!Objects.equals(dadosOr.getExec(), laudo.getProcDoAtd().getProfExecutante())) {
			} else if (!Objects.equals(dadosOr.getCid(), laudo.getCidResultadoDoExame())) {
			} else {
				try {
					if (!laudo.getPlanilha().comparar(dadosOr.getValoresOriginais())) {
					} else {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean salvarOk(final ProcDoAtd proc, boolean salvarLaudo, boolean naoChecarAltNoLaudo) {
		// if (!permissaoDeUsuarioOk(proc))
		// {
		// if (view.obterConfirmacaoDoUsuario("Deseja cancelar as alterações?"))
		// {
		// CacheMdls cacheLaudos = laudosDoAtd.get(procSelecionado);
		// Laudo pointerParaLaudoOriginal = cacheLaudos.getLaudoOriginal();
		// Laudo laudoOriginal = new Laudo(pointerParaLaudoOriginal);
		// DadosOriginaisDoLaudo dadosOr = dadosOriginais.get(pointerParaLaudoOriginal);
		// laudoOriginal.setCidResultadoDoExame(dadosOr.getCid());
		// procSelecionado.setProfExecutante(dadosOr.getExec());
		// cacheLaudos.put(laudoOriginal.getModeloDeLaudo(), laudoOriginal);
		// view.setLaudo(laudoOriginal);
		// naoTratarEvtMdlMudou = true;
		// view.configurarLaudo(procSelecionado.getProcMedico()
		// , laudoOriginal.getModeloDeLaudo());
		// naoTratarEvtMdlMudou = false;
		// laudoAtual = laudoOriginal;
		// return true;
		// }
		// else
		// {
		// return false;
		// }
		// }
		try {
			if (salvarLaudo) {
				Laudo laudoDoProc = getLaudoDoProc(proc);
				if (naoChecarAltNoLaudo || laudoMudou(laudoDoProc)) {
					laudoDoProc.salvarAlteracoes();
				}
				proc.setLaudo(laudoDoProc);
				dadosOriginais.put(laudoDoProc, new DadosOriginaisDoLaudo(laudoDoProc.getPlanilha(),
						laudoDoProc.getCidResultadoDoExame(), proc.getProfExecutante()));
				laudosDoAtd.put(proc, new CacheMdls(laudoDoProc));
			}

			getDaoProc().alterar(proc);
			mapaAltImgOuVideo.put(proc, false);
			new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					ImgBackupManager.clear(proc.getCodigo());
					return null;
				}
			}.execute();
			return true;
		} catch (Exception e) {
			view.mostrarMsgErro("Erro ao salvar o procedimento!");
			try {
				File file = new File(StaticInfo.getPastaDeInstalacaoDoSistema() + "\\"
						+ StaticInfo.getEstTrabalho().getNomeEstacaoDeTrabalho() + ".txt");
				BufferedWriter b = new BufferedWriter(new FileWriter(file));
				b.write(e.toString());
				b.close();
			} catch (Exception ex) {
			}
			return false;
		}
	}

	private Laudo getLaudoDoProc(ProcDoAtd proc) {
		if (proc == procSelecionado) {
			return laudoAtual;
		} else {
			CacheMdls cache = laudosDoAtd.get(proc);
			Iterator<Entry<ModeloDeLaudoDoProc, Laudo>> it = cache.entrySet().iterator();
			Laudo resp = null;
			while (it.hasNext()) {
				resp = it.next().getValue();
			}
			return resp;
		}
	}

	private boolean salvarAntesDeImprimir() {
		if (laudoMudou(laudoAtual)) {
			return salvarOk(procSelecionado, true, true);
		}
		return true;
	}

	private boolean videoExiste(int index) {
		List<VideoGravado> videos = procSelecionado.getVideosGravados();
		for (int i = 0; i < videos.size(); i++) {
			VideoGravado video = videos.get(i);
			if (video.getCaminho().contains(getVideoFileName(index))) {
				return true;
			}
		}
		File arqInicial = new File(getVideoFileAbsolutePath(index, recFileExt()));
		File arqCompactado = new File(getVideoFileAbsolutePath(index, compFileExt()));
		return arqInicial.exists() || arqCompactado.exists();
	}

	private String getVideoFileAbsolutePath(int index, String ext) {
		String pv = StaticInfo.getPastaDeVideos();
		return pv + "\\" + getVideoFileName(index) + "." + ext;
	}

	private String getVideoFileName(int index) {
		return atdSelecionado.getCodigo() + "-" + index;
	}

	private String recFileExt() {
		return LaudoeCia.getSoftwareView().getC_Captura().getRecordedVideoFileExtension();
	}

	private String compFileExt() {
		return LaudoeCia.getSoftwareView().getC_Captura().getCompressedVideoFileExtension();
	}

	private boolean validarExecParaCriacaoDoLaudo() {
		if (procSelecionado.getProfExecutante() == null) {
			view.irParaExec();
			view.mostrarMsgErro(VALIDACAO_MED_EX);
			return false;
		}
		return true;
	}

	private void imagemImpressaMudou(Imagem imgAntiga, Imagem novaImg) {
		List<PaginaDeImagens> paginas = procSelecionado.getImpressoesDeImg();
		byte[] bytesNovaImg = novaImg == null ? null : novaImg.getImagem();
		for (int indexPag = 0; indexPag < paginas.size(); indexPag++) {
			PaginaDeImagens pagina = paginas.get(indexPag);
			List<ImagemImpressa> imagens = pagina.getImagens();
			for (int j = 0; j < imagens.size(); j++) {
				ImagemImpressa imgImp = imagens.get(j);
				Imagem imgLoop = imgImp.getImagem();
				if (procSelecionado.imagensSaoIguais(imgAntiga, imgLoop)) {
					view.atualizarImgImpressa(indexPag, imgImp.getIndice(), bytesNovaImg);
					imgImp.setImagem(novaImg);
				}
			}
		}
		for (int indexPagina = 0; indexPagina < paginas.size(); indexPagina++) {
			PaginaDeImagens pagina = paginas.get(indexPagina);
			List<ImagemImpressa> imagens = pagina.getImagens();
			boolean listaDeImagensMudou;
			do {
				listaDeImagensMudou = false;
				for (int i = 0; i < imagens.size(); i++) {
					if (imagens.get(i).getImagem() == null) {
						pagina.removeImagem(i);
						listaDeImagensMudou = true;
						break;
					}
				}
			} while (listaDeImagensMudou);
		}
	}

	private boolean permissaoDeUsuarioOk(ProcDoAtd p) {
		ControladorDeAcesso c_Acesso = ControladorDeAcesso.getInstance();
		if (c_Acesso.podeAlterar(pdu)) {
			return true;
			// Usuario medicoRespPeloLaudo = getDaoAuditoria().buscarRespPeloLaudo(p);
			// if (medicoRespPeloLaudo == null ||
			// medicoRespPeloLaudo.equals(new Usuario(Usuario.CODIGO_NULL)))
			// {
			// return true;
			// }
			// else
			// {
			// Usuario usuarioRespPelaAcao = c_Acesso.getResponsavelPelaAcao();
			// int tentativas = 0;
			// while (!(usuarioRespPelaAcao == null ||
			// medicoRespPeloLaudo.equals(usuarioRespPelaAcao)))
			// {
			// view.mostrarMsgErro("Apenas o usuário " + medicoRespPeloLaudo.
			// getNome() + " pode fazer alterações nesse laudo!");
			// if (tentativas > 2)
			// {
			// break;
			// }
			// else
			// {
			// usuarioRespPelaAcao = FormPrincipal.getInstance().solicitarUsuario();
			// tentativas++;
			// }
			// }
			// return medicoRespPeloLaudo.equals(usuarioRespPelaAcao);
			// }
		} else {
			return false;
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Metodos de Vídeos">

	public boolean iniciarGravacaoDeVideo() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
			return false;
		} else if (!(ViewLaudoeCia.CAPTURA.equals(viewState) || ViewLaudoeCia.LAUDO.equals(viewState))) {
			return false;
		} else {
			int index = 0;
			while (videoExiste(index)) {
				index++;
			}
			File arqASerGravado = new File(getVideoFileAbsolutePath(index, recFileExt()));
			c_EspacoEmDisco.verificarEspacoEmDisco();
			if (view.iniciarGravacaoDeVideo(arqASerGravado)) {
				arqSendoGravado = arqASerGravado;
				return true;
			} else {
				return false;
			}
		}
	}

	public void videoFoiGravado(String duracao) {
		if (arqSendoGravado == null) {
		} else {
			VideoGravado videoGravado = new VideoGravado();
			videoGravado.setCaminho(c_Videos.arqCompactado(arqSendoGravado.getAbsolutePath()));
			videoGravado.setEstacaoDeTrabalho(StaticInfo.getEstTrabalho());
			videoGravado.setProcedimento(procSelecionado);
			videoGravado.setDuracao(duracao);
			procSelecionado.addVideoGravado(videoGravado);
			mapaAltImgOuVideo.put(procSelecionado, true);
			arqSendoGravado = null;
			c_Videos.setarListaDeVideos(procSelecionado.getVideosGravados());
		}
	}

	public boolean deletarVideoGravado(VideoGravado video) {
		if (videoEstaSendoCompactado(video.getCaminho())) {
			view.mostrarAviso("O vídeo está sendo compactado." + "\nTente novamente em alguns minutos.");
			return false;
		}
		File arquivo = new File(video.getCaminho());
		boolean resultado;
		if (!view.obterConfirmacaoDoUsuario("Deseja excluir o vídeo?\nEssa ação não pode ser desfeita!")) {
			resultado = false;
		} else if (arquivo.exists()) {
			if (arquivo.delete()) {
				resultado = true;
			} else {
				view.mostrarMsgErro(
						"Nao foi possível excluir o arquivo " + "de vídeo. \nTalvez ele esteja sendo usado!");
				resultado = false;
			}
		} else {
			if (video.getEstacaoDeTrabalho().equals(StaticInfo.getEstTrabalho())) {
				resultado = true;
			} else {
				view.mostrarAviso(
						"Esse vídeo encontra-se na máquina " + video.getEstacaoDeTrabalho().getNomeEstacaoDeTrabalho());
				resultado = false;
			}
		}
		if (resultado == true) {
			procSelecionado.removeVideoGravado(video);
			mapaAltImgOuVideo.put(procSelecionado, true);
		}
		return resultado;
	}

	public boolean moverVideoGravado(VideoGravado video, ProcDoAtd procDestino) {
		if (video == null) {
			view.mostrarAviso("Selecione um vídeo!");
			return false;
		} else if (procDestino == null || procSelecionado == null) {
			view.mostrarAviso("Selecione um procedimento!");
			return false;
		} else if (procSelecionado.equals(procDestino)) {
			view.mostrarAviso("O vídeo já pertence ao procedimento selecionado!");
			return false;
		} else {
			if (atdSelecionado.getProcedimentos().contains(procDestino)) {
				mapaAltImgOuVideo.put(procDestino, true);
				for (ProcDoAtd procDoAtd : atdSelecionado.getProcedimentos()) {
					if (procDoAtd.equals(procDestino)) {
						procDoAtd.addVideoGravado(video);
						break;
					}
				}
			} else {
				procDestino.addVideoGravado(video);
				try {
					getDaoProc().alterar(procDestino);
				} catch (Exception ex) {
					view.mostrarMsgErro("Erro de banco de dados ao mover o procedimento!");
					return false;
				}
			}
			procSelecionado.removeVideoGravado(video);
			mapaAltImgOuVideo.put(procSelecionado, true);
			return true;
		}
	}

	public boolean validarMoverVideo() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado.getVideosGravados().isEmpty()) {
			view.mostrarMsgErro(NENHUM_VIDEO_FOI_GRAVADO);
		} else {
			return true;
		}
		return false;
	}

	public boolean reproduzirArquivoDeVideo(VideoGravado video, File arquivo) {
		if (arquivo.exists()) {
			if (videoEstaSendoCompactado(video.getCaminho())) {
				view.mostrarAviso("O vídeo está sendo compactado." + "\nTente novamente em alguns minutos.");
				return false;
			} else {
				setState(ViewLaudoeCia.CAPTURA);
				return true;
			}
		} else if (!video.getEstacaoDeTrabalho().equals(StaticInfo.getEstTrabalho())) {
			view.mostrarAviso(
					"Esse vídeo encontra-se na máquina " + video.getEstacaoDeTrabalho().getNomeEstacaoDeTrabalho());
			return false;
		} else {
			view.mostrarAviso("O arquivo não existe no disco!");
			return false;
		}
	}

	List<VideoGravado> getVideos() {
		if (procSelecionado == null) {
			return new ArrayList<>();
		} else {
			return procSelecionado.getVideosGravados();
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Metodos de Impressão">

	private void limparAtdAposImpressao() {
		if (view.obterConfirmacaoDoUsuario("Deseja acessar o cadastro de atendimentos?")) {
			voltar();
			voltar();
			FormPrincipal.getInstance().mostrarTela(TelaPrincipal.ATENDIMENTO, new TelaSolicitanteNull());
		}
	}

	public void escolherImagensAutomaticamente(boolean showResposta) {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else {
			estaEscolhendoImgAutom = true;
			view.escolherImagensAutomaticamente(navegador.getImagens());
			estaEscolhendoImgAutom = false;
			indexImgSelParaEscolhendoAutom = 0;
		}
	}

	public void imprimirApenasImagens() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			if (salvarAlteracoes()) {
				view.imprimirApenasImagens(procSelecionado);
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
				limparAtdAposImpressao();
			}
		}
	}

	public void imprimirApenasLaudo() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					view.imprimirApenasLaudo(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
			}
		}
	}

	public void imprimirLaudoEImagens() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					view.imprimirLaudoEImg(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
			}
		}
	}

	public void previewApenasImagens() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			view.previewApenasImagens(procSelecionado);
			C_ImpImagens.limpar();
			PnlLayoutImagens.labelImagem = 0;
		}
	}

	public void previewApenasLaudo() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					view.previewApenasLaudo(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
			}

		}
	}

	public void previewLaudoEImagens() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					view.previewLaudoEImg(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
			}
		}
	}

	public void layoutDaPagMudou(int indexDaPag, LAYOUT_IMG novoLayout) {
		if (!(naoTratarEvtImpImgMudou || procSelecionado == null)) {
			List<PaginaDeImagens> paginas = procSelecionado.getImpressoesDeImg();
			if (indexDaPag >= 0 && indexDaPag < paginas.size()) {
				PaginaDeImagens pagina = paginas.get(indexDaPag);
				pagina.setLayout(novoLayout);
				pagina.setImagens(null);
				mapaAltImgOuVideo.put(procSelecionado, true);
			}
		}
	}

	public void pagFoiRemovida(int indexDaPag) {
		if (!(naoTratarEvtImpImgMudou || procSelecionado == null)) {
			List<PaginaDeImagens> paginas = procSelecionado.getImpressoesDeImg();
			if (indexDaPag >= 0 && indexDaPag < paginas.size()) {
				procSelecionado.removeImpImg(indexDaPag);
				mapaAltImgOuVideo.put(procSelecionado, true);
			}
		}
	}
	
	public void pagFoiAtualizada(int indexDaPag, LAYOUT_IMG layoutDaPagina) {
		if (!(naoTratarEvtImpImgMudou || procSelecionado == null)) {
			PaginaDeImagens impImg = new PaginaDeImagens();
			impImg.setProcDoAtd(procSelecionado);
			impImg.setLayout(layoutDaPagina);
			procSelecionado.setImpImg(indexDaPag, impImg);
			mapaAltImgOuVideo.put(procSelecionado, true);
		}
	}
	

	public void pagFoiAdicionada(LAYOUT_IMG layoutDaPagina) {
		if (!(naoTratarEvtImpImgMudou || procSelecionado == null)) {
			PaginaDeImagens impImg = new PaginaDeImagens();
			impImg.setProcDoAtd(procSelecionado);
			impImg.setLayout(layoutDaPagina);
			procSelecionado.addImpImagem(impImg);
			mapaAltImgOuVideo.put(procSelecionado, true);
		}
	}

	public boolean colocarImgSelNoQuadro(int indexDaPag, int indexImagem) {
		if (!(naoTratarEvtImpImgMudou || procSelecionado == null)) {
			List<PaginaDeImagens> paginas = procSelecionado.getImpressoesDeImg();
			if (indexDaPag >= 0 && indexDaPag < paginas.size()) {
				PaginaDeImagens pagina = paginas.get(indexDaPag);
				List<ImagemImpressa> imagens = pagina.getImagens();
				//Imagem imgSel = getImagemSel();
				ImagemJPEG imgSel = getImagemSel();
				
				if (imgSel != null && indexImagem >= 0) {
					ImagemImpressa imagemImpSel = null;
					for (int i = 0; i < imagens.size(); i++) {
						ImagemImpressa imagemImp = imagens.get(i);
						Imagem imagem = imagemImp.getImagem();
						
						if (imagemImp.getIndice() == indexImagem) {
							imagemImpSel = imagemImp;
						}
						// if (Arrays.equals(imgSel.getImagem(), imagem.getImagem()))
						// {
						// view.mostrarMsgErro("A imagem já foi adicionada "
						// + "a essa página!!");
						// return false;
						// }
					}
					if (imagemImpSel == null) {						
						ImagemImpressa imgImp = new ImagemImpressa();
						//imgImp.setImagem(imgSel);
						imgImp.setCaminhoimagemjpeg(MontarCaminho()+imgSel.getNomeDaImagem());
						
						imgImp.setIndice(indexImagem);
						
						imgImp.setPagina(pagina);
						pagina.addImagem(imgImp);
					} else {
						//imagemImpSel.setImagem(imgSel);
						imagemImpSel.setCaminhoimagemjpeg(MontarCaminho()+imgSel.getNomeDaImagem());
						AtualizandoFotoEspecifica(imagemImpSel);

					}
					
					mapaAltImgOuVideo.put(procSelecionado, true);
				}
			}
		}
		return true;
	}
	
	private void AtualizandoFotoEspecifica(ImagemImpressa imagemImpSel){
		DaoImagenImpressa dao = new DaoImagenImpressa();
		try {
			dao.alterar(imagemImpSel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String MontarCaminho(){
		String caminho = null;
		try {
			caminho = DiretorioDoSistemaUtil.PegaDiretorioDeImagens()+this.procSelecionado.getAtendimento().getCodigo()+"\\";
		} catch (IOException e) {}
		
		return caminho;
	}

	public void removerImgDoQuadro(int indexDaPag, int indexImagem) {
		if (!(naoTratarEvtImpImgMudou || procSelecionado == null)) {
			mapaAltImgOuVideo.put(procSelecionado, true);
			List<PaginaDeImagens> paginas = procSelecionado.getImpressoesDeImg();
			if (indexDaPag >= 0 && indexDaPag < paginas.size()) {
				PaginaDeImagens pagina = paginas.get(indexDaPag);
				if (indexImagem >= 0) {
					List<ImagemImpressa> imagens = pagina.getImagens();
					for (int i = 0; i < imagens.size(); i++) {
						ImagemImpressa imagemImpressa = imagens.get(i);
						if (imagemImpressa.getIndice() == indexImagem) {
							pagina.removeImagem(i);
							break;
						}
					}
				}
			}
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Metodos de Gerar PDF">

	public void gerarPDFApenasImagens() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			view.gerarPDFApenasImagens(procSelecionado);
			C_ImpImagens.limpar();
			PnlLayoutImagens.labelImagem = 0;
		}
	}

	public void gerarPDFApenasLaudo() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					view.gerarPDFApenasLaudo(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
				
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
			}
		}
	}

	public void gerarPDFLaudoEImagens() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					view.gerarPDFLaudoEImg(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
			}
			C_ImpImagens.limpar();
			PnlLayoutImagens.labelImagem = 0;
		}
	}
	
	public File gerarPDFApenasImagensEmail() {
		File arquivo = null;
		
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			arquivo = view.GerarEnvioPdfEmailImagens(procSelecionado);
			C_ImpImagens.limpar();
			PnlLayoutImagens.labelImagem = 0;
		}
		
		return arquivo;
	}

	public File gerarPDFApenasLaudoEmail() {
		File arquivo = null;
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					arquivo = view.GerarEnvioPdfEmailLaudo(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
				
				C_ImpImagens.limpar();
				PnlLayoutImagens.labelImagem = 0;
			}
		}
		return arquivo;
	}
	
	public File GerarLaudoEImagemsPDFEmail() {
		File arquivo = null;
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else if (!existeImgParaImpressao()) {
			view.mostrarMsgErro(NENH_IMG_IMP);
		} else if (TIPO_LICENCA.APENAS_IMAGEM.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_LAUDOS);
		} else if (TIPO_LICENCA.APENAS_LAUDO.equals(StaticInfo.getLicenciado().getTipodelicenca())) {
			view.mostrarMsgErro(TIPO_NAO_IMAGENS);
		} else {
			if (validarExecParaCriacaoDoLaudo() && salvarAntesDeImprimir()) {
				try {
					arquivo = view.GerarEnvioPdfEmailLaudoEImg(laudoAtual.getPlanilha().gerarHtml(true), procSelecionado);
				} catch (ErrosDeValidacao ex) {
					setState(ViewLaudoeCia.LAUDO);
					view.mostrarErroDeValidacaoDoLaudo(ex);
				} catch (Exception ex) {
					view.mostrarMsgErro("Ocorreu um erro inesperado no sistema!");
				}
			}
			C_ImpImagens.limpar();
			PnlLayoutImagens.labelImagem = 0;
		}
		return arquivo;
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Metodos de Laudos">

	public void modeloDeLaudoMudou(ModeloDeLaudoDoProc novoMdlSel) {
		if (naoTratarEvtMdlMudou) {
		} else if (novoMdlSel == null) {
			laudoAtual = null;
			view.setLaudo(null);
		} else {
			CacheMdls laudosDoProcSel = laudosDoAtd.get(procSelecionado);
			if (laudosDoProcSel.containsKey(novoMdlSel)) {
				laudoAtual = laudosDoProcSel.get(novoMdlSel);
			} else {
				final Laudo laudo = new Laudo(novoMdlSel);
				laudo.setProcDoAtd(procSelecionado);
				laudosDoProcSel.put(novoMdlSel, laudo);
				laudoAtual = laudo;
			}
			view.setLaudo(laudoAtual);
		}
	}

	public void visualizarLaudo() {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado == null) {
			// assertion error
		} else if (laudoAtual == null) {
			view.mostrarMsgErro(PROC_SEM_MDL);
		} else {
			view.visualizarLaudo();
		}
	}

	void setarValor(int index, String valor) {
		try {
			if (index == -1) {
				laudoAtual.getPlanilha().setValor(valor);
			} else {
				laudoAtual.getPlanilha().getCampo(index).setValor(valor);
			}
		} catch (Exception ex) {
		}
	}

	boolean isCdlHabilitado(int index) {
		try {
			return laudoAtual.getPlanilha().getCampo(index).isHabilitado();
		} catch (Exception e) {
			return false;
		}
	}

	String getValor(int index) {
		try {
			if (index == -1) {
				return laudoAtual.getPlanilha().getValor();
			}
			return laudoAtual.getPlanilha().getCampo(index).getValor();
		} catch (Exception e) {
			return null;
		}
	}

	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Metodos de Gravação/Exportação">

	public boolean iniciarGravacaoNoDisco(int tipoExportacao, String deviceString) {
		if (isGravandoDisco) {
			view.mostrarMsgErro("Já existe um cd\\dvd sendo gravado!");
			return false;
		}
		isGravandoDisco = view.iniciarGravacaoNoDisco(tipoExportacao, deviceString);
		return isGravandoDisco;
	}

	public void gravacaoNoDiscoFinalizou() {
		isGravandoDisco = false;
	}

	public void iniciarGravacaoNaPasta(int tipoExportacao, String pasta) {
		if (tipoExportacao == EXP_APENAS_VIDEOS || tipoExportacao == EXP_IMAGENS_VIDEOS) {
			List<File> videos = getFilesVideosGravados(true);
			if (videos != null) {
				try {
					for (int i = 0; i < videos.size(); i++) {
						File v = videos.get(i);
						File dest = new File(pasta + "\\" + v.getName());
						if (!dest.exists() || view.obterConfirmacaoDoUsuario(
								"O arquivo " + dest.getAbsolutePath() + " já existe! Deseja substituí-lo?")) {
							Files.copy(v.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
						}
					}
				} catch (IOException ex) {
					view.mostrarMsgErro("Erro ao exportar vídeos!");
					return;
				}
			} else {
				return;
			}
		}
		if (tipoExportacao == EXP_APENAS_IMAGENS || tipoExportacao == EXP_IMAGENS_VIDEOS) {
			List<File> images = exportarImagensProcedimento(pasta);
			if (images == null) {
				return;
			}
		}
		view.mostrarMsgSucesso("Arquivos exportados com sucesso!");
	}

	public List<File> exportarImagensProcedimento(String path) {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (navegador.getNumeroDeImagens() == 0) {
			view.mostrarMsgErro(NENHUMA_IMG_CAPT);
		} else {
			List<File> files = new ArrayList<>();
			//List<Imagem> imagens = procSelecionado.getImagens();
			AtualizarLista();
			
			try {
				for (int i = 0; i < this.lista.size(); i++) {
					File f = this.img2File(this.lista.get(i), path, i);
					if (f != null) {
						files.add(f);
					}
				}
			} catch (IOException ex) {
				view.mostrarMsgErro("Erro ao exportar imagens!");
				return null;
			}
			return files;
		}
		return null;
	}

	public List<File> getFilesVideosGravados(boolean validarCompactacao) {
		if (atdSelecionado == null) {
			view.mostrarMsgErro(NENHUM_ATD_SELECIONADO);
		} else if (procSelecionado.getVideosGravados().isEmpty()) {
			view.mostrarMsgErro(NENHUM_VIDEO_FOI_GRAVADO);
		} else {
			List<File> files = new ArrayList<>();
			List<VideoGravado> videos = procSelecionado.getVideosGravados();
			for (int i = 0; i < videos.size(); i++) {
				VideoGravado video = videos.get(i);
				File arquivo = new File(video.getCaminho());
				if (arquivo.exists()) {
					if (validarCompactacao && videoEstaSendoCompactado(video.getCaminho())) {
						view.mostrarAviso("O vídeo está sendo compactado." + "\nTente novamente em alguns minutos.");
						return null;
					} else {
						files.add(arquivo);
					}
				} else {
					if (video.getEstacaoDeTrabalho().equals(StaticInfo.getEstTrabalho())) {
						view.mostrarMsgErro("O vídeo " + video.getCaminho() + "" + " não existe mais no disco!");
					} else {
						view.mostrarMsgErro("O vídeo " + video.getCaminho() + "" + " está na estação "
								+ video.getEstacaoDeTrabalho().toString());
					}
					return null;
				}
			}
			return files;
		}
		return null;
	}

	public void alterarDispositivoEstTrabalho(String dispositivo) {
		EstacaoDeTrabalho e = StaticInfo.getEstTrabalho();
		e.setDispositivoGrav(dispositivo);
		try {
			getDaoEstTrab().alterar(e);
		} catch (Exception ex) {
		}
	}

	// </editor-fold>

	private class CacheMdls extends LinkedHashMap<ModeloDeLaudoDoProc, Laudo> {

		private Laudo laudoOriginal;

		private CacheMdls(Laudo laudoOriginal) {
			super(16, 1.1f, true);
			this.laudoOriginal = laudoOriginal;
		}

		@Override
		protected boolean removeEldestEntry(Entry<ModeloDeLaudoDoProc, Laudo> eldest) {
			return false;
		}

		@Override
		public Laudo put(ModeloDeLaudoDoProc key, final Laudo laudo) {
			laudo.addListener(new Runnable() {
				@Override
				public void run() {
					try {
						dadosOriginais.put(laudo, new DadosOriginaisDoLaudo(laudo.getPlanilha(),
								laudo.getCidResultadoDoExame(), laudo.getProcDoAtd().getProfExecutante()));
					} catch (Exception ex) {
						dadosOriginais.put(laudo, new DadosOriginaisDoLaudo(null, laudo.getCidResultadoDoExame(),
								laudo.getProcDoAtd().getProfExecutante()));
					}
				}

			});
			return super.put(key, laudo);
		}

		private Laudo getLaudoOriginal() {
			return laudoOriginal;
		}

	}

	private class DadosOriginaisDoLaudo {

		private Map<Integer, String> valoresOriginais = new HashMap<>();
		private SubcategoriaCID10 cid;
		private ProfExecutante exec;

		private DadosOriginaisDoLaudo(Planilha planilha, SubcategoriaCID10 cid, ProfExecutante exec) {
			Map<Integer, CampoDoLaudo> mapa = planilha.getMapaDeCampos();
			for (Entry<Integer, CampoDoLaudo> entry : mapa.entrySet()) {
				Integer index = entry.getKey();
				CampoDoLaudo cdl = entry.getValue();
				valoresOriginais.put(index, cdl.getValor());
			}
			valoresOriginais.put(Planilha.INDEX_PLANILHA, planilha.getValor());
			this.cid = cid;
			this.exec = exec;
		}

		private ProfExecutante getExec() {
			return exec;
		}

		private SubcategoriaCID10 getCid() {
			return cid;
		}

		@SuppressWarnings("ReturnOfCollectionOrArrayField")
		private Map<Integer, String> getValoresOriginais() {
			return valoresOriginais;
		}

	}

	private class SwImagens extends SwingWorker<Void, Void> {

		private final Imagem img;
		private final ProcDoAtd proc;

		private SwImagens(Imagem img, ProcDoAtd proc) {
			this.img = img;
			this.proc = proc;
		}

		@Override
		protected Void doInBackground() throws Exception {
			getDaoImagem().cadastrarImagem(img, proc);
			return null;
		}
	}

	public void AtualizarLista(){
		if(this.procSelecionado != null && this.procSelecionado.getProcMedico() != null && this.procSelecionado.getAtendimento() != null) {
			ServiceJPEG captur = new ServiceJPEG(this.atdSelecionado, this.procSelecionado);
			this.lista = captur.ListaImagensCapturadas(this.procSelecionado.getProcMedico().getCodigo(), this.procSelecionado.getAtendimento().getCodigo());
			view.atualizarSelecao();
		}else {
			JOptionPane.showMessageDialog(null, "Procedimento ou Atendimento está nulo");
		}
	}

	public ViewLaudoeCia getView() {
		return view;
	}

	public boolean isCaptura() {
		return captura;
	}

	public void setCaptura(boolean captura) {
		this.captura = captura;
	}
	
}
