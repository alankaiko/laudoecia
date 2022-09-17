/*
 * Linha.java
 *
 * Created on 07/05/2012, 09:06:35
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class Linha extends LinhaAbstrata
{

    private String textoDaLinha;
    private boolean htmlDaProleEhObrigatorio = true;
    public static final String TEXTO_CAMPOS_FILHOS = "@texto dos campos filhos@";
    /**
     * Mapa que representa quais campos são obrigatórios. Se um campo é
     * obrigatório mas seu html é vazio, o html da linha inteira sera vazio
     */
    private final Map<CampoDoLaudo, Boolean> camposObrigatorios = new HashMap<>();
    private String descrPrimParag = null;

    public Linha () throws ErroNaCriacaoDoModelo
    {
        this(TEXTO_CAMPOS_FILHOS);
    }

    public Linha (String textoDaLinha) throws ErroNaCriacaoDoModelo
    {
        if (textoDaLinha == null)
        {
            throw new ErroNaCriacaoDoModelo("Texto da linha nao deve ser null!");
        }
        this.textoDaLinha = textoDaLinha;
    }

    @Override
    void adicionarCampoFilho (CampoDoLaudo campo)
    {
        super.adicionarCampoFilho(campo);
        camposObrigatorios.put(campo, false);
    }

    public void setObrigatorioCampoFilho (CampoDoLaudo campo, boolean obrigatorio)
    {
        if (camposObrigatorios.containsKey(campo))
        {
            camposObrigatorios.put(campo, obrigatorio);
        }
    }

    public void setHtmlDaProleEhObrigatorio (boolean htmlDaProleEhObrigatorio)
    {
        this.htmlDaProleEhObrigatorio = htmlDaProleEhObrigatorio;
    }

    public void setDescrPrimParag (String descrPrimParag)
    {
        this.descrPrimParag = descrPrimParag;
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        String valor = getValor();
        if (!(valor == null || valor.isEmpty()))
        {
            return valor;
        }
        StringBuilder htmlProle = new StringBuilder(16);
        List<CampoDoLaudo> campos = getProle();
        for (int i = 0; i < campos.size(); i++)
        {
            CampoDoLaudo campo = campos.get(i);
            String htmlDoCampo = campo.gerarHtml(validar);
            if (camposObrigatorios.get(campo) && (htmlDoCampo == null || htmlDoCampo.isEmpty()))
            {
                return "";
            }
            htmlProle.append(htmlDoCampo);
        }
        if (htmlProle.toString().replaceAll("\\<.*?\\>", "").trim().isEmpty()
                && htmlDaProleEhObrigatorio)
        {
            return "";
        }
        else
        {
            String textoASerImp = textoDaLinha.replaceAll(
                   TEXTO_CAMPOS_FILHOS, htmlProle.toString()).trim();
            if (textoASerImp.startsWith("</div>") || textoASerImp.startsWith("<div ") || (textoASerImp.startsWith("<p ") && textoASerImp.endsWith("</p>")) || textoASerImp.startsWith("<table"))
            {
                return inserirDescrPrimParag(textoASerImp);
            }
            else if (textoASerImp.endsWith("</p>"))
            {
                return inserirDescrPrimParag("<p style=\"margin-top: 0\">" + textoASerImp);
            }
            else if (textoASerImp.startsWith("<p "))
            {
                return inserirDescrPrimParag(textoASerImp + "</p>");
            }
            else
            {
                return inserirDescrPrimParag("<p style=\"margin-top: 0\">" + textoASerImp + "</p>");
            }
        }
    }

    private String inserirDescrPrimParag (String html)
    {
        if (descrPrimParag == null)
        {
            return html;
        }
        else
        {
            return html.replaceFirst(">", ">" + descrPrimParag);
        }
    }

}
