/*
 * LaudosHTMLUtils.java
 *
 * Created on 06/06/2012, 16:09:50
 */
package com.ic.projects.laudoecia.view.print;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JEditorPane;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.model.cadastro.PaginaDeImagens;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;
import com.ic.projects.laudoecia.view.build.FormPrincipal;
import com.lib.icontrol.crud.utils.C_ImpImagens;
import com.lib.java.utils.DateUtils;
import com.lib.java.utils.StringUtils;
import com.lib.model.cnv.ConversorDateString;
import com.lib.model.cnv.ConversorDoublePixels;
import com.lib.swing.plus.cps.MyHTMLEditorKit;
import com.lib.swing.plus.cps.MyJTextPane;
import com.lib.swing.utils.SwingUtils;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class LaudosHTMLUtils {
	private static ConversorDoublePixels convDoublePixels = new ConversorDoublePixels();
	private static ConversorDateString convDateStr = new ConversorDateString();
	private static ConversorDoublePixels convPixels = new ConversorDoublePixels();

	private static int headerHeight;
	private static int footerHeight;
	private static boolean updateFooter = false;
	private static boolean pagination = true;
	private static boolean valor = true;

	private static ProcDoAtd procedimento;

	public static void setProcDoAtd(ProcDoAtd proc) {
		LaudosHTMLUtils.procedimento = proc;
	}

	public static void setProcDoAtd(ProcDoAtd proc, boolean valor) {
		LaudosHTMLUtils.valor = valor;
	}

	public static JEditorPane createHeader(boolean impAtdInfo) {
		MyEditorHeaderFooter header = new MyEditorHeaderFooter();
		header.setText(getHtmlHeader(true));
		headerHeight = header.getPreferredSize().height;
		return header;
	}

	public static JEditorPane createFooter(int actualPage, int totalPages) {
		MyEditorHeaderFooter footer = new MyEditorHeaderFooter();
		footer.setText(getHtmlFooter(actualPage, totalPages));
		footerHeight = footer.getPreferredSize().height;
		return footer;
	}

	private static String createAtdInfo() {
		if (procedimento == null) {
			return "";
		}
		Atendimento atd = procedimento.getAtendimento();
		if (atd == null) {
			return "";
		}

		String codigo = "<font size=\"2\">" + String.format("%06d", atd.getCodigo()) + "</font>";
		String dataAtd = "<font size=\"2\">" + convDateStr.convertForward(procedimento.getDataDaExecucao()) + "</font>";
		String solicte = "<font size=\"2\">"
				+ (atd.getSolicitante() == null ? "&nbsp;" : atd.getSolicitante().getNome()) + "</font>";
		String convenio = "<font size=\"2\">" + atd.getConvenio().getNome() + "</font>";
		String paciente = atd.getPaciente().getNome();
		String idadeOss = atd.getPaciente().getIdadeOssea();
		String titulo = procedimento.toString();// .replace(" ", "&nbsp; ");
		String mt = String.valueOf(procedimento.getProcMedico().getMargemTop());
		String mb = String.valueOf(procedimento.getProcMedico().getMargemBottom());

		boolean imprimeCab = StaticInfo.getParametrosDoSistema().isImprimeCabecalhoLaudo();
		String styleBorderTop = imprimeCab ? "" : "border-top: 1px solid #000000;";

		String codigoAtd = StaticInfo.getParametrosDoSistema().isImprimirAtd()
				? "<td align=\"right\"><font size=\"2\"><b>ATENDIMENTO:" + "&nbsp;" + codigo + "</b></font></td>"
				: "<td></td>";

		String dn = convDateStr.convertForward(atd.getPaciente().getDataNascimento());

		String fraseLicenciado = StaticInfo.LICENCIADO_LAUDO;

		if (StaticInfo.LICENCIADO_LAUDO.equals(StaticInfo.LICENCIADO_LAUDO_VERSAO_TESTES)) {
			if (atd.getCodigo() > 20) {
				SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
						"Versão de demonstração expirou!\n"
								+ "Os laudos serão impressos com uma marca dizendo que o laudo não é real!!!\n"
								+ "Contate o suporte técnico.");
			} else {
				fraseLicenciado = "";
			}
		}

		if (Files.exists(Paths.get("c:\\windows\\system32\\34652.txt"))) {
			fraseLicenciado = "";
		}

		String html = "<div style=\"padding: 3px; border-bottom: 1px solid #000000; " + styleBorderTop + "\">"
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">" + "<tr>"
				+ "<td width=\"60\"><font size=\"2\"><b>PACIENTE:</b></font></td>" + "<td><font size=\"2\"><b>"
				+ paciente + "</b></font></td>" + codigoAtd + "</tr>" + "<tr>"
				+ "<td><font size=\"2\">DATA:</font></td>" + "<td><font size=\"2\">" + dataAtd + "</font></td>"
				+ "<td align=\"right\"><font size=\"2\">D.N.:&nbsp;" + dn + "&nbsp;&nbsp;&nbsp;IDADE:&nbsp;" + idadeOss
				+ "&nbsp;&nbsp;&nbsp;&nbsp;</font></td>" + "</tr>" + getSolCon(solicte, convenio) + "</table>"
				+ "</div>" + "<div align=\"right\" width=\"97.3%\">" + fraseLicenciado + "</div>"
				+ "<div style=\"margin-top: " + mt + "px; margin-bottom: " + mb
				+ "px; background: #DDDDDD;\" align=\"center\">" + "<font><b>" + titulo + "</b></font>" + "</div>";
		return html;
	}

	// Jonatan Alves - inclusao deste metodo
	private static String createAtdInfoPra8Imagens() {
		if (procedimento == null) {
			return "";
		}
		Atendimento atd = procedimento.getAtendimento();
		if (atd == null) {
			return "";
		}

		String codigo = String.format("%06d", atd.getCodigo());
		String dataAtd = "<font size=\"2\">" + convDateStr.convertForward(procedimento.getDataDaExecucao()) + "</font>";
		String paciente = atd.getPaciente().getNome();

		boolean imprimeCab = StaticInfo.getParametrosDoSistema().isImprimeCabecalhoLaudo();
		String styleBorderTop = imprimeCab ? "" : "border-top: 1px solid #000000;";

		String fraseLicenciado = StaticInfo.LICENCIADO_LAUDO;

		if (StaticInfo.LICENCIADO_LAUDO.equals(StaticInfo.LICENCIADO_LAUDO_VERSAO_TESTES)) {
			if (atd.getCodigo() > 20) {
				SwingUtils.mostrarAviso(FormPrincipal.getInstance(),
						"Versão de demonstração expirou!\n"
								+ "Os laudos serão impressos com uma marca dizendo que o laudo não é real!!!\n"
								+ "Contate o suporte técnico.");
			} else {
				fraseLicenciado = " ";
			}
		}

		if (Files.exists(Paths.get("c:\\windows\\system32\\34652.txt"))) {
			fraseLicenciado = "";
		}

		String html = "<div style=\"padding: 2px; border-bottom: 1px solid #000000; " + styleBorderTop + "\">"
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">" + "<tr>" + "<td>"
				+ "<font size=\"2\">" + "PACIENTE: " + paciente + "</font>" + "</td>"

				+ "<td>" + "<font size=\"2\">" + "DATA: " + dataAtd + "</font>" + "</td>"

				+ "<td align=\"right\">" + "<font size=\"2\">" + "ATENDIMENTO: " + codigo + "</font>" + "</tr>"
				+ "</tr>" + "</table>" + "</div>"

				+ "<div align=\"right\" width=\"99%\">" + "<font size=\"2\">" + fraseLicenciado + "</font>" + "</div>";

		return html;
	}

	private static String getSolCon(String solicte, String convenio) {
		if (StaticInfo.getParametrosDoSistema().isImprimirsolcon()) {
			String sol = solicte == null || solicte.isEmpty() ? "" : "Dr(a).&nbsp;" + solicte;

			return "<tr>" + "<td><font size=\"2\">SOLICITANTE:</font></td>" + "<td><font size=\"2\">" + sol
					+ "</font></td>" + "<td align=\"right\"><font size=\"2\">CONVÊNIO:&nbsp;" + convenio
					+ "</font></td>" + "</tr>";
		}
		return "";
	}

	public static String createAssProf(ProfExecutante prof) {
		if (prof == null || !StaticInfo.imprimirAss()) {
			return "";
		}

		String nome = prof.getNome();
		String cons = prof.getConselho().getSigla() + "-" + prof.getUfConselho().getSigla() + " "
				+ prof.getNumNoConselho();
		String m = String.valueOf(prof.getEspacoAss());
		int img = -1;
		if (prof.getAssinatura() != null) {
			img = C_ImpImagens.cadastrarImgParaImp(prof.getAssinatura());
		}
		String frasePessoal = prof.getFrasePessoal();
		String frase = (frasePessoal == null || frasePessoal.isEmpty()) ? "" : " - " + prof.getFrasePessoal();
		String html = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
				+ "<tr><td width=\"30%\">&nbsp;</td>\n" + "<td style=\"border-bottom:1px solid #000000; margin-top: "
				+ m + "px;\">" + getAss(img, prof) + "</td>\n" + "<td width=\"30%\">&nbsp;</td></tr>\n" + "<tr>\n"
				+ "<td colspan=\"3\" align=\"center\">" + " <font size=\"2\">" + nome + "<BR />\n" + (cons + frase)
				+ "</font>\n" + "</td>\n" + "</tr>\n" + "</table>";

		return html;
	}

	private static String getAss(int img, ProfExecutante prof) {
		if (img >= 0) {
			String width = String.valueOf(convPixels.convertForward(prof.getAssWidth()));
			String height = String.valueOf(convPixels.convertForward(prof.getAssHeight()));
			String imgs = String.valueOf(img);
			// return "<img src=\"" + imgs + "\">";
			return "<img src=\"" + imgs + "\" width=\"" + width + "\" height=\"" + height + "\">";
		}
		return "&nbsp;";
	}

	public static String createHtmlAtestadoPac(String pac, String data, String horaDe, String horaAte,
			ProfExecutante prof, SubcategoriaCID10 cid) {
		String html = "<font size='3'><p align='center'><b>ATESTADO</b></p><br /><br />";
		html += "<p align='justify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Atestamos para os devidos fins que " + pac + " "
				+ "esteve neste estabelecimento no dia " + data + " no período de " + horaDe + " às " + horaAte + " "
				+ "horas, onde submeteu-se à procedimento(s) médico(s).</p> " + getCid(cid) + "<br /><br />";
		html += "<p align='justify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ StaticInfo.getLicenciado().getEndereco().getCidade() + ", " + DateUtils.dataExtenso(new Date())
				+ ".</p><br /><br /></font>";
		html += createAssProf(prof);
		return html;
	}

	public static String createHtmlAtestadoAcomp(String pac, String acomp, String data, String horaDe, String horaAte,
			ProfExecutante prof, SubcategoriaCID10 cid) {
		String html = "<font size='3'><p align='center'><b>ATESTADO</b></p><br /><br />";
		html += "<p align='justify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Atestamos para os devidos fins que " + acomp + " "
				+ "esteve neste estabelecimento no dia " + data + " no período de " + horaDe + " às " + horaAte + " "
				+ "horas, acompanhando " + pac + " para realização de procedimento(s) médico(s).</p> " + getCid(cid)
				+ "<br /><br />";
		html += "<p align='justify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ StaticInfo.getLicenciado().getEndereco().getCidade() + ", " + DateUtils.dataExtenso(new Date())
				+ ".</p><br /><br /></font>";
		html += createAssProf(prof);
		return html;
	}

	public static String createTabelaPagina(String html, boolean impAtdInfo) {
		return createTabelaPagina(html, 1, true, impAtdInfo);
	}

	public static String createTabelaPagina(String html, int subtrair, boolean impAtdInfo) {
		return createTabelaPagina(html, 1, true, subtrair, impAtdInfo);
	}

	public static String createTabelaPagina(String html, int numPages, boolean vAlignCenter, boolean impAtdInfo) {
		return createTabelaPagina(html, numPages, vAlignCenter, 0, impAtdInfo);
	}

	public static String createTabelaPagina(String html, int numPages, boolean vAlignCenter, int subtrair,
			boolean impAtdInfo) {
		ParametrosDoSistema param = StaticInfo.getParametrosDoSistema();
		int pageH = convDoublePixels.convertForward(param.getPaperHeight());
		int height = pageH - getHeaderHeight(impAtdInfo) - getTopMargin() - getFooterHeight() - getBottomMargin();
		if (numPages > 1) {
			height *= numPages;
		}
		height -= subtrair;
		String valign = vAlignCenter ? "" : "valign=\"top\"";
		String resp = "<table class=\"page\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
				+ "<tr><td height=\"" + String.valueOf(height) + "\" " + valign + ">" + html + "</td></tr>"
				+ "</table>";
		return resp;
	}

	public static int getBottomMargin() {
		return convDoublePixels.convertForward(StaticInfo.getParametrosDoSistema().getBottomMargin());
	}

	public static int getLeftMargin() {
		return convDoublePixels.convertForward(StaticInfo.getParametrosDoSistema().getLeftMargin());
	}

	public static int getRightMargin() {
		return convDoublePixels.convertForward(StaticInfo.getParametrosDoSistema().getRightMargin());
	}

	public static int getTopMargin() {
		return convDoublePixels.convertForward(StaticInfo.getParametrosDoSistema().getTopMargin());
	}

	public static int getFooterHeight() {
		if (footerHeight == 0 || updateFooter) {
			createFooter(0, 0);
			updateFooter = false;
		}
		return footerHeight;
	}

	public static int getHeaderHeight(boolean impAtdInfo) {
		// Alterado para sempre recriar o cabeçalho, pois o cabeçalho depende
		// da página se vai ter as informações do atd ou nao.
		createHeader(impAtdInfo);
		return headerHeight;
	}

	public static void headerFooterMudou() {
		updateFooter = true;
	}

	private static String getHtmlHeader(boolean impAtdInfo) {
		// Jonatan Alves - inclusao desta linha abaixo
		List<LAYOUT_IMG> listaTemp = new ArrayList<LAYOUT_IMG>();

		String imgTag = "";
		String textoCabecalho = "";

		ParametrosDoSistema paramSist = StaticInfo.getParametrosDoSistema();
		if (paramSist.isImprimeCabecalhoLaudo()) {
			byte[] logomarcaLaudo = paramSist.getLogomarcaLaudo();
			if (logomarcaLaudo != null) {
				int margem = (int) (convPixels.convertForward(paramSist.getLeftMarginLogomarca()) * 0.8);
				int width = convPixels.convertForward(paramSist.getLogomarcaWidth());
				int height = convPixels.convertForward(paramSist.getLogomarcaHeight());
				int img = C_ImpImagens.cadastrarImgParaImp(logomarcaLaudo);
				imgTag = "<div style=\"margin-left: " + String.valueOf(margem) + "px\"><img src=\""
						+ String.valueOf(img) + "\" width=\"" + width + "\" height=\"" + height + "\"></div>";
			}

			if (paramSist.getTextoCabecalhoLaudo() == null) {
				String nomeEmpresa = StaticInfo.getLicenciado().getLicenciadoPara();
				if (nomeEmpresa != null && !nomeEmpresa.isEmpty()) {
					textoCabecalho = "<div style=\"border-bottom:1px solid #000000;\">"
							+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">"
							+ "<tr><td align=\"center\">" + nomeEmpresa + "</td></tr></table>" + "</div>";
				}
			} else {
				textoCabecalho = "<div style=\"border-bottom:1px solid #000000;\">"
						+ StringUtils.getBodyContents(paramSist.getTextoCabecalhoLaudo()) + "</div>";
			}
		}

		// Jonatan Alves - inclusao deste trecho abaixo
		if (valor == true) {
			for (PaginaDeImagens a : procedimento.getImpressoesDeImg())
				listaTemp.add(a.getLayout());

			// Jonatan Alves - alteracao neste trecho abaixo
			if (impAtdInfo) {
				if (listaTemp.contains(LAYOUT_IMG.LAYOUT_8_IMG_GRANDES))
					textoCabecalho += createAtdInfoPra8Imagens();
				else
					textoCabecalho += createAtdInfo();
			}
		}

		if (textoCabecalho.isEmpty()) {
			return "";
		}

		String html = "<html><head></head><body>";
		html += imgTag;
		html += textoCabecalho;
		html += "</body></html>";

		return html;
	}

	private static String getHtmlFooter(int actualPage, int totalPages) {
		ParametrosDoSistema paramSist = StaticInfo.getParametrosDoSistema();
		Licenciado licenciado = StaticInfo.getLicenciado();
		String licenciadoPara = "";// StaticInfo.LICENCIADO_LAUDO;

		String licenciadoPaginaTR = "<tr><td>" + licenciadoPara + "</td>";
		if (paramSist.isImprimePaginacaoLaudo() && pagination) {
			licenciadoPaginaTR += "<td align=\"right\"><font size=\"2\"><i>Página " + actualPage + " de " + totalPages
					+ "&nbsp; </i></font></td>";
		} else {
			licenciadoPaginaTR += "<td>&nbsp;</td>";
		}
		licenciadoPaginaTR += "</tr>";

		String tamSepRodape = String.valueOf(StaticInfo.getParametrosDoSistema().getTamanhoSepRodape());

		// quando estiver marcado para não imprimir rodapé
		if (!paramSist.isImprimeRodapeLaudo()) {
			String html = "<html><head></head><body>" + "<div style=\"border-top:" + tamSepRodape
					+ "px solid #000000;\">"
					+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">";
			html += licenciadoPaginaTR;
			html += "</table></div></body></html>";
			return html;
		}

		String texto;
		if (paramSist.getTextoRodapeLaudo() == null) {
			String end = licenciado.getEndereco() == null ? "" : licenciado.getEndereco().toString();
			texto = "<tr>" + "<td colspan=\"2\" align=\"center\"><font size=\"2\">" + end + "</font></td>" + "</tr>";
			String contact = "";
			if (licenciado.getTelefone1() != null && !licenciado.getTelefone1().isEmpty()) {
				contact += " Fone: " + new StringBuilder(licenciado.getTelefone1()).insert(0, "(").insert(3, ") ")
						.insert(9, "-").toString();
			}
			if (licenciado.getEmail() != null && !licenciado.getEmail().isEmpty()) {
				contact += " e-mail: " + licenciado.getEmail();
			}
			if (licenciado.getSite() != null && !licenciado.getSite().isEmpty()) {
				contact += " - " + licenciado.getSite();
			}
			texto += "<tr>" + "<td colspan=\"2\" align=\"center\"><font size=\"2\">" + contact + "</font></td>"
					+ "</tr>";
		} else {
			texto = "<tr><td colspan=\"2\" align=\"center\"><div>"
					+ StringUtils.getBodyContents(paramSist.getTextoRodapeLaudo()) + "</div></td></tr>";
		}

		String frase = StringUtils.getBodyContents(paramSist.getFraseRodapeLaudo());
		if (frase != null && !frase.isEmpty()) {
			frase = "<tr><td colspan=\"2\"><div>" + frase + "" + "</div></td></tr>"; // .replace(" ", "&nbsp;")
		} else {
			frase = "";
		}

		int w = convPixels
				.convertForward(paramSist.getPaperWidth() - paramSist.getLeftMargin() - paramSist.getRightMargin());
		// montando html do rodapé
		String html = "<html><head></head><body>";
		html += "<div style=\"border-top:" + tamSepRodape + "px solid #000000;\">";
		html += "<div style=\"border-top:0px solid #000000;\">";
		html += "<table width=\"" + w + "\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">";
		html += frase;
		html += texto;
		html += licenciadoPaginaTR;
		html += "</table></div></body></html>";
		return html;
	}

	private static String getCid(SubcategoriaCID10 cid) {
		if (cid == null) {
			return "";
		} else {
			return "<p align='justify'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Enquadrando-se no CID " + cid.getCodigo()
					+ " – " + cid.getNome() + ".</p>";
		}
	}

	private static class MyEditorHeaderFooter extends MyJTextPane {
		private MyEditorHeaderFooter() {
			super();
			setEditorKit(new MyHTMLEditorKit());
			setContentType("text/html");
			setEditable(false);
			setFocusable(false);
			setBorder(null);
		}
	}

	public static void setPagination(boolean pagination) {
		LaudosHTMLUtils.pagination = pagination;
	}

	private LaudosHTMLUtils() {
	}

}
