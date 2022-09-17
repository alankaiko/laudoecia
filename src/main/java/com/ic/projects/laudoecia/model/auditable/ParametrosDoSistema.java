/*
 * ParametrosDoSistema.java
 *
 * Created on 02/04/2012, 10:49:11
 */

package com.ic.projects.laudoecia.model.auditable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.ic.projects.laudoecia.model.cadastro.BackupAutomatico;
import com.ic.projects.laudoecia.model.enums.CONTROLE_DE_ACESSO;
import com.ic.projects.laudoecia.model.enums.LAYOUT_IMG;
import com.ic.projects.laudoecia.model.enums.PARAMETRO_BUSCA_SIGLA;
import com.ic.projects.laudoecia.model.enums.VERSAO_DO_SW;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "parametrosdosistema")
public class ParametrosDoSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo")
	private int codigo;

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parametrosDoSistema")
	private List<BackupAutomatico> backups = new ArrayList<>();

	@Column(name = "backupautomaticoenabled", nullable = false)
	private boolean backupAutomaticoEnabled = true;

	@Column(name = "topmargin", nullable = false)
	private double topMargin = 1.0;

	@Column(name = "bottommargin", nullable = false)
	private double bottomMargin = 1.0;

	@Column(name = "leftmargin", nullable = false)
	private double leftMargin = 1.5;

	@Column(name = "rightmargin", nullable = false)
	private double rightMargin = 1.0;

	@Column(name = "paperwidth", nullable = false)
	private double paperWidth = 21.0;

	@Column(name = "paperheight", nullable = false)
	private double paperHeight = 29.7;

	@Column(name = "imprimecabecalholaudo", nullable = false)
	private boolean imprimeCabecalhoLaudo = true;

	@Column(name = "tamanhoseprodape", nullable = false)
	private int tamanhoSepRodape = 1;

	@Column(name = "logomarcalaudo", nullable = true)
	private byte[] logomarcaLaudo;

	@Column(name = "logomarcawidth", nullable = false)
	private double logomarcaWidth = 1.0;

	@Column(name = "logomarcaheight", nullable = false)
	private double logomarcaHeight = 1.0;

	@Column(name = "leftmarginlogomarca", nullable = false)
	private double leftMarginLogomarca = 0.0;

	@Column(name = "textocabecalholaudo", nullable = true, length = 10000)
	private String textoCabecalhoLaudo = "";

	@Column(name = "imprimerodapelaudo", nullable = false)
	private boolean imprimeRodapeLaudo = true;

	@Column(name = "fraserodapelaudo", nullable = true, length = 10000)
	private String fraseRodapeLaudo = "";

	@Column(name = "textorodapelaudo", nullable = true, length = 10000)
	private String textoRodapeLaudo = "";

	@Column(name = "imprimepaginacaolaudo", nullable = false)
	private boolean imprimePaginacaoLaudo = true;

	@Column(name = "bgcolor", nullable = true)
	private int bgColor = 0;

	@Enumerated(EnumType.STRING)
	@Column(name = "layoutimagem", nullable = false)
	private LAYOUT_IMG layoutImagem = LAYOUT_IMG.LAYOUT_4_IMG_MEDIAS;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipodecontroledeacesso", nullable = false)
	private CONTROLE_DE_ACESSO tipoControleDeAcesso = CONTROLE_DE_ACESSO.SEMPRE_EXIGE_SENHA;

	@Column(name = "diretoriodevideos", nullable = false)
	private String diretorioDeVideos = "C:\\videos";

	@Enumerated(EnumType.STRING)
	@Column(name = "versaodosw", nullable = false)
	private VERSAO_DO_SW versaoDoSw = VERSAO_DO_SW.V1;

	@Column(name = "defprinterlaudo", nullable = true)
	private String defprinterlaudo = "";

	@Column(name = "defprinterimagens", nullable = true)
	private String defprinterimagens = "";

	@Column(name = "imprimirsolcon", nullable = false)
	private boolean imprimirsolcon = true;

	@Column(name = "imprimiratd", nullable = false)
	private boolean imprimirAtd = true;

	@Enumerated(EnumType.STRING)
	@Column(name = "parametrobuscasigla")
	private PARAMETRO_BUSCA_SIGLA parametrobuscasigla = PARAMETRO_BUSCA_SIGLA.BUSCA_TEXTO_TEXTO;

	// <editor-fold defaultstate="collapsed" desc="Versioned">

	@Version
	private long version = 0;

	public long getVersion() {
		return version;
	}

	// </editor-fold>

	public boolean isImprimirAtd() {
		return imprimirAtd;
	}

	public void setImprimirAtd(boolean imprimirAtd) {
		this.imprimirAtd = imprimirAtd;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<BackupAutomatico> getBackups() {
		return Collections.unmodifiableList(backups);
	}

	public void setBackups(List<BackupAutomatico> backups) {
		this.backups.clear();
		if (backups == null) {
		} else {
			this.backups.addAll(backups);
		}
	}

	public String getFraseRodapeLaudo() {
		return fraseRodapeLaudo;
	}

	public void setFraseRodapeLaudo(String fraseRodapeLaudo) {
		this.fraseRodapeLaudo = fraseRodapeLaudo;
	}

	public byte[] getLogomarcaLaudo() {
		if (logomarcaLaudo == null) {
			return null;
		} else {
			return Arrays.copyOf(logomarcaLaudo, logomarcaLaudo.length);
		}
	}

	public void setLogomarcaLaudo(byte[] logomarcaLaudo) {
		if (logomarcaLaudo == null) {
			this.logomarcaLaudo = null;
		} else {
			this.logomarcaLaudo = Arrays.copyOf(logomarcaLaudo, logomarcaLaudo.length);
		}
	}

	public double getLogomarcaHeight() {
		return logomarcaHeight;
	}

	public void setLogomarcaHeight(double logomarcaHeight) {
		this.logomarcaHeight = logomarcaHeight;
	}

	public double getLogomarcaWidth() {
		return logomarcaWidth;
	}

	public void setLogomarcaWidth(double logomarcaWidth) {
		this.logomarcaWidth = logomarcaWidth;
	}

	public double getLeftMarginLogomarca() {
		return leftMarginLogomarca;
	}

	public void setLeftMarginLogomarca(double leftMarginLogomarca) {
		this.leftMarginLogomarca = leftMarginLogomarca;
	}

	public double getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(double bottomMargin) {
		this.bottomMargin = bottomMargin < 0.5 ? 0.5 : bottomMargin;
	}

	public double getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(double leftMargin) {
		this.leftMargin = leftMargin < 0.5 ? 0.5 : leftMargin;
	}

	public double getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(double rightMargin) {
		this.rightMargin = rightMargin < 0.5 ? 0.5 : rightMargin;
	}

	public double getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(double topMargin) {
		this.topMargin = topMargin < 0.5 ? 0.5 : topMargin;
	}

	public double getPaperHeight() {
		return paperHeight;
	}

	public void setPaperHeight(double paperHeight) {
		this.paperHeight = paperHeight;
	}

	public double getPaperWidth() {
		return paperWidth;
	}

	public void setPaperWidth(double paperWidth) {
		this.paperWidth = paperWidth;
	}

	public boolean isBackupAutomaticoEnabled() {
		return backupAutomaticoEnabled;
	}

	public void setBackupAutomaticoEnabled(boolean backupAutomaticoEnabled) {
		this.backupAutomaticoEnabled = backupAutomaticoEnabled;
	}

	public boolean isImprimeCabecalhoLaudo() {
		return imprimeCabecalhoLaudo;
	}

	public void setImprimeCabecalhoLaudo(boolean imprimeCabecalhoLaudo) {
		this.imprimeCabecalhoLaudo = imprimeCabecalhoLaudo;
	}

	public boolean isImprimePaginacaoLaudo() {
		return imprimePaginacaoLaudo;
	}

	public void setImprimePaginacaoLaudo(boolean imprimePaginacaoLaudo) {
		this.imprimePaginacaoLaudo = imprimePaginacaoLaudo;
	}

	public boolean isImprimeRodapeLaudo() {
		return imprimeRodapeLaudo;
	}

	public void setImprimeRodapeLaudo(boolean imprimeRodapeLaudo) {
		this.imprimeRodapeLaudo = imprimeRodapeLaudo;
	}

	public String getTextoCabecalhoLaudo() {
		return textoCabecalhoLaudo;
	}

	public void setTextoCabecalhoLaudo(String textoCabecalhoLaudo) {
		this.textoCabecalhoLaudo = textoCabecalhoLaudo;
	}

	public String getTextoRodapeLaudo() {
		return textoRodapeLaudo;
	}

	public void setTextoRodapeLaudo(String textoRodapeLaudo) {
		this.textoRodapeLaudo = textoRodapeLaudo;
	}

	public int getBgColor() {
		return bgColor;
	}

	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}

	public LAYOUT_IMG getLayoutImagem() {
		return layoutImagem;
	}

	public void setLayoutImagem(LAYOUT_IMG layoutImagem) {
		this.layoutImagem = layoutImagem;
	}

	public String getDiretorioDeVideos() {
		return diretorioDeVideos;
	}

	public void setDiretorioDeVideos(String diretorioDeVideos) {
		this.diretorioDeVideos = diretorioDeVideos;
	}

	public CONTROLE_DE_ACESSO getTipoControleDeAcesso() {
		return tipoControleDeAcesso;
	}

	public void setTipoControleDeAcesso(CONTROLE_DE_ACESSO tipoControleDeAcesso) {
		this.tipoControleDeAcesso = tipoControleDeAcesso;
	}

	public VERSAO_DO_SW getVersaoDoSw() {
		return versaoDoSw;
	}

	public void setVersaoDoSw(VERSAO_DO_SW versaoDoSw) {
		this.versaoDoSw = versaoDoSw;
	}

	public int getTamanhoSepRodape() {
		return tamanhoSepRodape;
	}

	public void setTamanhoSepRodape(int tamanhoSepRodape) {
		this.tamanhoSepRodape = tamanhoSepRodape;
	}

	public String getDefprinterlaudo() {
		return defprinterlaudo;
	}

	public void setDefprinterlaudo(String defprinterlaudo) {
		this.defprinterlaudo = defprinterlaudo;
	}

	public String getDefprinterimagens() {
		return defprinterimagens;
	}

	public void setDefprinterimagens(String defprinterimagens) {
		this.defprinterimagens = defprinterimagens;
	}

	public boolean isImprimirsolcon() {
		return imprimirsolcon;
	}

	public void setImprimirsolcon(boolean imprimirsolcon) {
		this.imprimirsolcon = imprimirsolcon;
	}
	
	public PARAMETRO_BUSCA_SIGLA getParametrobuscasigla() {
		return parametrobuscasigla;
	}
	
	public void setParametrobuscasigla(PARAMETRO_BUSCA_SIGLA parametrobuscasigla) {
		this.parametrobuscasigla = parametrobuscasigla;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ParametrosDoSistema other = (ParametrosDoSistema) obj;
		if (this.codigo != other.getCodigo()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29 * hash + this.codigo;
		return hash;
	}

	@Override
	public String toString() {
		return "PARAMETROS DO SISTEMA";
	}

}
