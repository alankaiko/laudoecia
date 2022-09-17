/*
 * RelAuditoriaCreator.java
 *
 * Created on 23/03/2012, 08:58:04
 */
package com.ic.projects.laudoecia.view.reports;

import com.ic.projects.laudoecia.control.reports.C_RelAuditoria;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.view.imagens.ImageResources;
import com.ic.projects.laudoecia.view.imagens.ImagensLC;
import java.util.List;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class RelAuditoriaCreator
{
    private static C_RelAuditoria controlador = new C_RelAuditoria(
            RelatorioResources.class.getResource("files/").toString(),
            ImageResources.class.getResource(ImagensLC.ICONE_LC).toString()
            );

    public static JRViewer getRelatorio (List<AcaoDoUsuario> list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        controlador.configurarRelatorio(list);
        return RelatorioResources.criarRelatorio(RelatoriosLC.REL_AUDITORIA,
                    controlador.getParametros(),controlador.getLista());
    }

}
