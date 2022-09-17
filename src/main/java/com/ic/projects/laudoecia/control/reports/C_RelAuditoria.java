/*
 * C_RelAuditoria.java
 *
 * Created on 23/03/2012, 09:13:28
 */
package com.ic.projects.laudoecia.control.reports;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_RelAuditoria
{
    private Map<String, Object> parametros;
    private List<AcaoDoUsuario> lista;
    private String subReportDir;
    private String iconDir;

    public C_RelAuditoria (String subReportDir, String iconDir)
    {
        this.subReportDir = subReportDir;
        this.iconDir = iconDir;
    }

    public void configurarRelatorio (List<AcaoDoUsuario> lista)
    {
        this.lista = lista;
        setParametrosDefault();
    }

    private void setParametrosDefault ()
    {
        Licenciado dadosLicenciado = StaticInfo.getLicenciado();
        parametros = new HashMap<>();
        parametros.put("NOME_EMPRESA", dadosLicenciado.getLicenciadoPara());
        parametros.put("LICENCIADO", dadosLicenciado.getRazaoSocial());

        //parametro com caminho da pasta onde estao os sub relatorios e imagens
        parametros.put("SUBREPORT_DIR", subReportDir);
        parametros.put("ICON_URL", iconDir);
    }

    public List<AcaoDoUsuario> getLista ()
    {
        try {
            return Collections.unmodifiableList(lista);
        }
        catch (Exception e){
            return null;
        }
    }

    public Map<String, Object> getParametros ()
    {
        return parametros;
    }

}
