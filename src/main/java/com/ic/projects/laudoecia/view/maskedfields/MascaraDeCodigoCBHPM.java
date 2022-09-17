/*
 * MascaraDeCodigoCBHPM.java
 *
 * Created on 28/02/2012, 08:38:07
 */
package com.ic.projects.laudoecia.view.maskedfields;

import com.lib.swing.maskedfields.IMaskable;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class MascaraDeCodigoCBHPM implements IMaskable
{
    @Override
    public String getErrorMessage ()
    {
        return "Codigo CBHPM inválido";
    }

    @Override
    public String getMask ()
    {
        return "#.##.##.##-#";
    }

    @Override
    public String getNext (String text, int caretPosition)
    {
        // se o cursor esta no fim da string
        if (caretPosition == text.length())
        {
            // se o usuario digitou o primeiro ou os tres ou os cinco
            // primeiros digitos, completa o ponto
            if (text.matches("[0-9]{1}") || text.matches("[0-9]{1}\\.[0-9]{2}")
                    || text.matches("[0-9]{1}\\.[0-9]{2}\\.[0-9]{2}"))
            {
                return ".";
            }
            // se o usuario digitou os sete primeiros digitos, completa o traço
            else if (text.matches("[0-9]{1}\\.[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}"))
            {
                return "-";
            }
        }
        else
        {
            // se o usuario digitou o primeiro ou os tres ou os cinco primeiros digitos,
            // completa o ponto se ele ainda nao existir
            if (text.substring(0, caretPosition).matches("[0-9]{1}")
                || text.substring(0, caretPosition).matches("[0-9]{1}\\.[0-9]{2}")
                || text.substring(0, caretPosition).matches("[0-9]{1}\\.[0-9]{2}\\.[0-9]{2}"))
            {
                if (!text.substring(caretPosition, caretPosition + 1).equals("."))
                {
                    return ".";
                }
            }
            // se o usuario digitou os sete primeiros digitos, completa o traço
            // se ele ja nao existir
            else if (text.substring(0, caretPosition).
                    matches("[0-9]{1}\\.[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}"))
            {
                if (!text.substring(caretPosition, caretPosition + 1).equals("/"))
                {
                    return "-";
                }
            }            
        }
        return "";
    }

    @Override
    public String getRegex ()
    {
        return "[0-9]{1}\\.[0-9]{2}\\.[0-9]{2}.[0-9]{2}-[0-9]{1}";
    }

}
