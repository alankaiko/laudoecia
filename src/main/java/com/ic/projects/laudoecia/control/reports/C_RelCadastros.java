/*
 * C_RelAuditoria.java
 *
 * Created on 23/03/2012, 09:13:28
 */
package com.ic.projects.laudoecia.control.reports;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.auditable.Licenciado;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_RelCadastros
{
    private Map<String, Object> parametros;
    private List<AcaoDoUsuario> lista;
    private String subReportDir;
    private String iconDir;

    public C_RelCadastros (String subReportDir, String iconDir)
    {
        this.subReportDir = subReportDir;
        this.iconDir = iconDir;
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

    public Map<String, Object> getParametros ()
    {
        return parametros;
    }

}
