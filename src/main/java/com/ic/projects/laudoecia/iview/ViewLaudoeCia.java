/*
 * ViewLaudoeCia.java
 *
 * Created on 27/06/2012, 10:52:52
 */
package com.ic.projects.laudoecia.iview;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcMedico;
import com.ic.projects.laudoecia.model.cadastro.PaginaDeImagens;
import com.ic.projects.laudoecia.model.cadastro.VideoGravado;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.ic.projects.laudoecia.model.laudo.ModeloDeLaudoDoProc;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public interface ViewLaudoeCia
{
    String CAPTURA = "CAPTURA";
    String LAUDO = "LAUDO";
    String ESCOLHER_IMAGENS = "ESCOLHER_IMAGENS";
    String IMAGENS_FULL_SCREEN = "IMAGENS_FULL_SCREEN";

    // PNL CARTAO
    void setState (String state);

    // MODEL INTERACTION
    void setAtendimento (Atendimento atdASerMostrado);
    void setProcedimentos (List<ProcDoAtd> procedimentos);

    void setProcSel (ProcDoAtd get);
    void limparLaudos ();
    void setLaudo (Laudo laudo);
    void configurarLaudo (ProcMedico proc, ModeloDeLaudoDoProc mdlSel);
    void visualizarLaudo ();
    void irParaExec ();

    // DIALOGS

    void mostrarDadosDoAtendimento (Atendimento atd);
    void mostrarMsgErro (String msgErro);
    void mostrarMsgSucesso (String msgSucesso);
    void mostrarAviso (String aviso);
    boolean obterConfirmacaoDoUsuario (String msg);

    // IMAGENS

    void addImagem (byte[] img);
    void atualizarSelecao ();
    void carregarImagens (List<byte[]> imagens);
    void editarImagemAtual ();
    void removerImgSelecionada ();
    void imgSelMudou ();
    void escolherImagensAutomaticamente (List<byte[]> listaImagem);
    void capturarImagem ();

    // IMPRESSAO
    void imprimirApenasImagens (ProcDoAtd procDoAtd);
    void imprimirApenasLaudo (String htmlDoLaudo, ProcDoAtd procDoAtd);
    void imprimirLaudoEImg (String htmlDoLaudo, ProcDoAtd procDoAtd);
    void previewApenasImagens (ProcDoAtd procDoAtd);
    void previewApenasLaudo (String htmlDoLaudo, ProcDoAtd procDoAtd);
    void previewLaudoEImg (String htmlDoLaudo, ProcDoAtd procDoAtd);

    // GERAR PDF
    void gerarPDFApenasImagens (ProcDoAtd procDoAtd);
    void gerarPDFApenasLaudo (String htmlDoLaudo, ProcDoAtd procDoAtd);
    void gerarPDFLaudoEImg (String htmlDoLaudo, ProcDoAtd procDoAtd);

    // GRAVAÇÃO/EXPORTAÇÃO
    void exportarArquivosDoProc ();
    boolean iniciarGravacaoNoDisco (int tipoExportacao, String dispositivo);
    void abortarGravacaoNoDisco ();

    boolean iniciarGravacaoDeVideo (File arquivo);
    void btnGravarVideoDoClick (boolean tratarSelected);
    void setarListaVideos (List<VideoGravado> videos);
    Date liberarEspacoEmDisco ();
    void pararCaptura ();

    void mostrarErroDeValidacaoDoLaudo (ErrosDeValidacao ex);
    void mostrarDlgAguarde (String texto);
    void ocultarDlgAguarde ();

    void carregarImpressoes (List<PaginaDeImagens> paginas);
    void atualizarImgImpressa (int indexPag, int indiceDaImg, byte[] novaImg);

    void abrirPopupModelo ();
}
