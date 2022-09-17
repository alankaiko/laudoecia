package com.ic.projects.laudoecia.view.utils;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.0 21/10/2015 08:55
 */
public class FormatarTelefone {
    private static FormatarTelefone instance;
    
    public static FormatarTelefone getInstance(){
        if(instance == null){
            instance = new FormatarTelefone();
        }
        return instance;
    }
    /**
     * Metodo para fazer maskara 
     * @param pattern Maskara
     * @param value Valor para maskarar
     * @return 
     */
    public String format(String pattern, Object value){
        MaskFormatter mask;
        String retorno = null;
        try {            
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            retorno = mask.valueToString(value);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo."+e.getMessage());
        }
        return retorno;
    }
}
