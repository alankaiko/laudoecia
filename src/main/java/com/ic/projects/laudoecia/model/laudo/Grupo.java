/*
 * Grupo.java
 *
 * Created on 19/10/2012, 09:52:32
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.List;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class Grupo extends Composite
{

    private String descricao;

    public Grupo (String descricao) throws ErroNaCriacaoDoModelo
    {
        if (descricao == null || descricao.isEmpty())
        {
            throw new ErroNaCriacaoDoModelo("Descrição não pode ser null!");
        }
        this.descricao = "<b>" + descricao + ":</b>";
    }

    @Override
    String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao
    {
        String valorGrupo = getValor();
        if (!(valorGrupo == null || valorGrupo.isEmpty()))
        {
            return valorGrupo;
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
        else
        {
            textoDaSecao.insert(0, descricao);
            return textoDaSecao.toString();
        }
    }

}
