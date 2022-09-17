/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.cadastro.BackupAutomatico;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author marcelol-IC
 */
public class AuditorDeParametroDeSistemas extends Auditor<ParametrosDoSistema>
{
    @Override
    void preencherAlteracoes (final ParametrosDoSistema novo, ParametrosDoSistema antigo)
    {
        if (!Objects.equals(novo.getTopMargin(), antigo.getTopMargin()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Margem Superior");
            ar.setValorOriginal(String.valueOf(antigo.getTopMargin()));
            ar.setValorAposAlteracao(String.valueOf(novo.getTopMargin()));
        }
        if (!Objects.equals(novo.getBottomMargin(), antigo.getBottomMargin()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Margem Inferior");
            ar.setValorOriginal(String.valueOf(antigo.getBottomMargin()));
            ar.setValorAposAlteracao(String.valueOf(novo.getBottomMargin()));
        }
        if (!Objects.equals(novo.getLeftMargin(), antigo.getLeftMargin()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Margem Esquerda");
            ar.setValorOriginal(String.valueOf(antigo.getLeftMargin()));
            ar.setValorAposAlteracao(String.valueOf(novo.getLeftMargin()));
        }
        if (!Objects.equals(novo.getRightMargin(), antigo.getRightMargin()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Margem Direita");
            ar.setValorOriginal(String.valueOf(antigo.getRightMargin()));
            ar.setValorAposAlteracao(String.valueOf(novo.getRightMargin()));
        }
        if (!Objects.equals(novo.getPaperWidth(), antigo.getPaperWidth()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Largura do Papel");
            ar.setValorOriginal(String.valueOf(antigo.getPaperWidth()));
            ar.setValorAposAlteracao(String.valueOf(novo.getPaperWidth()));
        }
        if (!Objects.equals(novo.getPaperHeight(), antigo.getPaperHeight()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Altura do Papel");
            ar.setValorOriginal(String.valueOf(antigo.getPaperHeight()));
            ar.setValorAposAlteracao(String.valueOf(novo.getPaperHeight()));
        }
        if (!Objects.equals(novo.getLayoutImagem(), antigo.getLayoutImagem()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Layout Padrão Imagens");
            ar.setValorOriginal(antigo.getLayoutImagem().toString());
            ar.setValorAposAlteracao(novo.getLayoutImagem().toString());
        }
        if (!Objects.equals(novo.getLogomarcaWidth(), antigo.getLogomarcaWidth()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Largura Logomarca");
            ar.setValorOriginal(String.valueOf(antigo.getLogomarcaWidth()));
            ar.setValorAposAlteracao(String.valueOf(novo.getLogomarcaWidth()));
        }
        if (!Objects.equals(novo.getLogomarcaHeight(), antigo.getLogomarcaHeight()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Altura Logomarca");
            ar.setValorOriginal(String.valueOf(antigo.getLogomarcaHeight()));
            ar.setValorAposAlteracao(String.valueOf(novo.getLogomarcaHeight()));
        }
        if (!Objects.equals(novo.getLeftMarginLogomarca(), antigo.getLeftMarginLogomarca()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Margem Esquerda Logoamrca");
            ar.setValorOriginal(String.valueOf(antigo.getLeftMarginLogomarca()));
            ar.setValorAposAlteracao(String.valueOf(novo.getLeftMarginLogomarca()));
        }
        if (!Objects.equals(novo.isImprimeCabecalhoLaudo(), antigo.isImprimeCabecalhoLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Imprimir Cabeçalho");
            ar.setValorOriginal(antigo.isImprimeCabecalhoLaudo() ? "SIM" : "NÃO");
            ar.setValorAposAlteracao(novo.isImprimeCabecalhoLaudo() ? "SIM" : "NÃO");
        }
        if (!Objects.equals(novo.getTextoCabecalhoLaudo(), antigo.getTextoCabecalhoLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Texto Cabeçalho");
            String vlrOrig = antigo.getTextoCabecalhoLaudo();
            if (vlrOrig == null)
            {
                vlrOrig = "Usar Dados do Licenciado";
            }
            ar.setValorOriginal(vlrOrig);
            String vlrNovo = novo.getTextoCabecalhoLaudo();
            if (vlrNovo == null)
            {
                vlrNovo = "Usar Dados do Licenciado";
            }
            ar.setValorAposAlteracao(vlrNovo);
        }
        if (!Objects.equals(novo.isImprimeRodapeLaudo(), antigo.isImprimeRodapeLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Imprimir Rodapé");
            ar.setValorOriginal(antigo.isImprimeRodapeLaudo() ? "SIM" : "NÃO");
            ar.setValorAposAlteracao(novo.isImprimeRodapeLaudo() ? "SIM" : "NÃO");
        }
        if (!Objects.equals(novo.getFraseRodapeLaudo(), antigo.getFraseRodapeLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Frase do rodapé");
            ar.setValorOriginal(antigo.getFraseRodapeLaudo());
            ar.setValorAposAlteracao(novo.getFraseRodapeLaudo());
        }
        if (!Objects.equals(novo.getTextoRodapeLaudo(), antigo.getTextoRodapeLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Texto Rodapé");
            String vlrOrig = antigo.getTextoRodapeLaudo();
            if (vlrOrig == null)
            {
                vlrOrig = "Usar Dados do Licenciado";
            }
            ar.setValorOriginal(vlrOrig);
            String vlrNovo = novo.getTextoRodapeLaudo();
            if (vlrNovo == null)
            {
                vlrNovo = "Usar Dados do Licenciado";
            }
            ar.setValorAposAlteracao(vlrNovo);
        }
        if (!Objects.equals(novo.isImprimePaginacaoLaudo(), antigo.isImprimePaginacaoLaudo()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Impressao Laudos->Imprimir Paginação");
            ar.setValorOriginal(antigo.isImprimePaginacaoLaudo() ? "SIM" : "NÃO");
            ar.setValorAposAlteracao(novo.isImprimePaginacaoLaudo() ? "SIM" : "NÃO");
        }
        if (!Objects.equals(novo.isBackupAutomaticoEnabled(), antigo.isBackupAutomaticoEnabled()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Backup->Realiza Backup Automático");
            ar.setValorOriginal(antigo.isBackupAutomaticoEnabled() ? "SIM" : "NÃO");
            ar.setValorAposAlteracao(novo.isBackupAutomaticoEnabled() ? "SIM" : "NÃO");
        }

        compararListaBackups(novo.getBackups(), antigo.getBackups());

        if (!Objects.equals(novo.getTipoControleDeAcesso(), antigo.getTipoControleDeAcesso()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Outras Opções->Controle de Acesso");
            ar.setValorOriginal(antigo.getTipoControleDeAcesso().toString());
            ar.setValorAposAlteracao(novo.getTipoControleDeAcesso().toString());
        }
        if (!Objects.equals(novo.getDiretorioDeVideos(), antigo.getDiretorioDeVideos()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Outras Opções->Pasta de Vídeos");
            ar.setValorOriginal(antigo.getDiretorioDeVideos());
            ar.setValorAposAlteracao(novo.getDiretorioDeVideos());
        }
        if (!Objects.equals(novo.getBgColor(), antigo.getBgColor()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Outras Opções->Fundo de Tela");
            ar.setValorOriginal(antigo.getBgColor() == 0 ? "Imagem Padrão" : "Cor Sólida");
            ar.setValorAposAlteracao(novo.getBgColor() == 0 ? "Imagem Padrão" : "Cor Sólida");
        }
    }

    private void compararListaBackups (List<BackupAutomatico> novo, List<BackupAutomatico> antigo)
    {
        if (!novo.isEmpty() && !antigo.isEmpty())
        {
            if (!Objects.equals(novo.get(0).getDiretorioDoArquivo(), antigo.get(0).getDiretorioDoArquivo()))
            {
                AltDeRegistro ar = criarAltDeReg();
                ar.setCampo("Backup->Local para Salvar");
                ar.setValorOriginal(antigo.get(0).getDiretorioDoArquivo());
                ar.setValorAposAlteracao(novo.get(0).getDiretorioDoArquivo());
            }
        }

        //laço para testar se excluiu ou alterou algum backup
        for (int i = 0; i < antigo.size(); i++)
        {
            BackupAutomatico bAntigo = antigo.get(i);
            if (!novo.contains(bAntigo)) //se excluiu
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.APAGAR);
                ar.setCampo("Backup->Backup Automático");
                ar.setValorOriginal(bAntigo.toString());
                ar.setValorAposAlteracao("");
            }
        }
        //testa se inseriu algum backup
        for (int i = 0; i < novo.size(); i++)
        {
            BackupAutomatico bNovo = novo.get(i);
            if (!antigo.contains(bNovo))
            {
                AltDeRegistro ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.ADICIONAR);
                ar.setCampo("Backup->Backup Automático");
                ar.setValorOriginal("");
                ar.setValorAposAlteracao(bNovo.toString());
            }
        }
    }

}
