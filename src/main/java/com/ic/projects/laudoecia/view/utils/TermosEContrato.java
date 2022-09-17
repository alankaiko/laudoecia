/*
 * TermosEContrato.java
 *
 * Created on 18/01/2016, 10:10:48
 */

package com.ic.projects.laudoecia.view.utils;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.lib.swing.utils.SwingUtils;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author Renato Borges Cardos
 * @version 1.00 18/01/2016
 */
public class TermosEContrato
{
    private static TermosEContrato instance;

    public static TermosEContrato getInstance(){
        if(instance == null){
            instance = new TermosEContrato();
        }
        return instance;
    }

    private static final Desktop desk = java.awt.Desktop.getDesktop();

    /**
     * Metodo que abre o contrato no navegador
     */
    public void abrirContrato(){
        try{
            File indexFile = new File(StaticInfo.getPastaHelp() + "contrato/index.html");
            desk.browse(indexFile.toURI());
        }
        catch (Exception e){
            SwingUtils.mostrarMensagemDeErroConhecido(null, "Erro ao abrir contrato."+e.getMessage());
        }
    }

}
