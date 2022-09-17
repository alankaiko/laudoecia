/*
 * Topico.java
 *
 * Created on 07/05/2012, 09:06:07
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class Topico extends Composite
{

    private String descricaoFormatada;
    private String descricao;
    private String htmlTopico;
    private boolean topicoPadrao;
    public static final String ID_DESCRICAO_TOPICO = "@descricao do topico@";

    public Topico (String descricao) throws ErroNaCriacaoDoModelo
    {
        this(descricao, null);
    }

    public Topico (String descricao, String htmlTopico) throws ErroNaCriacaoDoModelo
    {
        topicoPadrao = (htmlTopico == null);
        if (topicoPadrao)
        {
        }
        else
        {
            if (!htmlTopico.contains(HTML_CAMPOS_FILHOS))
            {
                throw new ErroNaCriacaoDoModelo("Faltou identificador do "
                        + "html das linhas do topico!");
            }
            else
            {
            }
            this.htmlTopico = htmlTopico;
        }
        configurarDescricao(descricao);
    }

    public final void configurarDescricao (String descricao)
    {
        this.descricao = descricao;
        if (descricao == null || descricao.trim().isEmpty())
        {
            this.descricaoFormatada = "";
        }
        else
        {
            this.descricaoFormatada = "<p style=\"margin-top: 0\">– <b>" +
                             descricao + ":</b></p>";
        }
    }

    public String getDescricao ()
    {
        return descricao;
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        String valorTopico = getValor();
        if (!(valorTopico == null || valorTopico.isEmpty()))
        {
            return valorTopico;
        }
        StringBuilder textoDaSecao = new StringBuilder(16);
        List<CampoDoLaudo> campos = getProle();
        for (int i = 0; i < campos.size(); i++)
        {
            String valorCampo = campos.get(i).gerarHtml(validar);
            if (valorCampo == null)
            {
            }
            else
            {
                textoDaSecao.append(valorCampo);
            }
        }
        if (textoDaSecao.toString().replaceAll("\\<.*?\\>", "").trim().isEmpty())
        {
            return "";
        }
        else if (topicoPadrao)
        {
            textoDaSecao.insert(0, descricaoFormatada);
            return textoDaSecao.toString();
        }
        else
        {
            return htmlTopico.replaceAll(HTML_CAMPOS_FILHOS, textoDaSecao.toString()).
                              replaceAll(ID_DESCRICAO_TOPICO, descricaoFormatada).
                              replace("<table", "<table class=\"topico\"");
        }
    }

}
