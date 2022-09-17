/*
 * CodigoCBHPMTblRnd.java
 *
 * Created on 19/04/2011, 10:25:50
 */
package com.ic.projects.laudoecia.view.renderers;

import java.awt.Component;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CodigoCBHPMTblRnd extends DefaultTableCellRenderer
{
    private MaskFormatter formatter = new MaskFormatter();

    public CodigoCBHPMTblRnd ()
    {
        try
        {
            formatter.setMask("#.##.##.##-#");
            formatter.setPlaceholderCharacter('0');
            formatter.setValueContainsLiteralCharacters(false);
        }
        catch (ParseException ex)
        {
        }
    }

    @Override
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel resposta = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof String)
        {
            try
            {
                resposta.setText(formatter.valueToString(value.toString()));
            }
            catch (ParseException ex)
            {
            }
        }
        return resposta;
    }

}
