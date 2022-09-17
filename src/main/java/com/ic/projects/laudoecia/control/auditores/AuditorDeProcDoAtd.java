/*
 * AuditorDeProcDoAtd.java
 *
 * Created on 23/07/2012, 09:06:10
 */
package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.ic.projects.laudoecia.model.laudo.Laudo;
import com.ic.projects.laudoecia.model.laudo.Planilha;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class AuditorDeProcDoAtd extends Auditor<ProcDoAtd>
{
    @Override
    void preencherAlteracoes (ProcDoAtd novo, ProcDoAtd antigo)
    {
        if (!Objects.equals(novo.getCidMotivoDoExame(), antigo.getCidMotivoDoExame()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("CID Resultado do Exame");
            ar.setValorOriginal(antigo.getCidMotivoDoExame() == null ? "" : antigo.getCidMotivoDoExame().toString());
            ar.setValorAposAlteracao(novo.getCidMotivoDoExame() == null ? "" : novo.getCidMotivoDoExame().toString());
        }
        String[] laudos = new String[] { "", "" };
        if (laudoMudou(antigo.getLaudo(), novo.getLaudo(), laudos))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Laudo");
            ar.setValorOriginal(laudos[0]);
            ar.setValorAposAlteracao(laudos[1]);
        }
        if (!Objects.equals(novo.getProfExecutante(), antigo.getProfExecutante()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Prof. Executante");
            ar.setValorOriginal(antigo.getProfExecutante() == null ? "" : antigo.getProfExecutante().toString());
            ar.setValorAposAlteracao(novo.getProfExecutante() == null ? "" : novo.getProfExecutante().toString());
        }
        compararLista(novo.getImagens(), antigo.getImagens(), "Imagens", "Imagem", "Imagens");
        compararLista(novo.getVideosGravados(), antigo.getVideosGravados(), "Vídeos", "Vídeo", "Vídeos");
    }

    private void compararLista(List<?> novo, List<?> antigo, String campo, String singular, String plural)
    {
        int novoCount = novo.size();
        int antigoCount = antigo.size();
        AltDeRegistro ar;

        if (novoCount == antigoCount) //nao teve alteração
        {
            return;
        }
        else if (antigoCount > novoCount) // excluiu
        {
            ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.APAGAR);
        }
        else // adicionou
        {
            ar = criarAltDeReg(TIPO_ACAO_DO_USUARIO.ADICIONAR);
        }
        ar.setCampo(campo);
        ar.setValorOriginal(antigoCount == 0 ? "Nenhum " + singular :
                            antigoCount + " " + (antigoCount == 1 ? singular : plural));
        ar.setValorAposAlteracao(novoCount == 0 ? "Nenhum " + singular :
                            novoCount + " " + (novoCount == 1 ? singular : plural));
    }

    private boolean laudoMudou (Laudo laudoAntigo, Laudo laudoNovo, String[] laudos)
    {
        if (laudoAntigo == null && laudoNovo == null)
        {
            return false;
        }
        else if (laudoAntigo == null)
        {
            laudos[1] = getHtmlLaudo(laudoNovo);
            return true;
        }
        else if (laudoNovo == null)
        {
            laudos[0] = getHtmlLaudo(laudoAntigo);
            return true;
        }
        else
        {
            try
            {
                return planilhaMudou(laudoAntigo.getPlanilha(),
                                         laudoNovo.getPlanilha(), laudos);
            }
            catch (Exception ex)
            {
                return false;
            }
        }
    }

    private boolean planilhaMudou( Planilha planAntiga, Planilha planNova, String[] laudos)
    {
        if (Planilha.comparar(planAntiga, planNova))
        {
            return false;
        }
        else
        {
            laudos[0] = getHtmlLaudo(planAntiga.getLaudo());
            laudos[1] = getHtmlLaudo(planNova.getLaudo());
            return true;
        }
    }

    private String getHtmlLaudo (Laudo laudo)
    {
        try
        {
            return laudo.getPlanilha().gerarHtml(false);
        }
        catch (Exception ex)
        {
            return "";
        }
    }

}
