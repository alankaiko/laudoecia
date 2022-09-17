/*
 * DaoParametroDoLaudo.java
 *
 * Created on 04/10/2014, 17:14:43
 */

package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProfExecutante;
import com.ic.projects.laudoecia.model.laudo.ParametroDoLaudo;
import com.lib.dao.general.And;
import com.lib.dao.general.Between;
import com.lib.dao.general.GenericDaoWithIntegerId;
import com.lib.dao.general.QueryBuilder;
import com.lib.dao.general.Select;
import com.lib.dao.general.Where;
import com.lib.java.utils.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jfree.data.DataUtilities;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DaoParametroDoLaudo extends GenericDaoWithIntegerId<ParametroDoLaudo>
{

    public DaoParametroDoLaudo ()
    {
        super(PUs.CADASTRO_PU, ParametroDoLaudo.class);
    }

    public List<Object[]> buscarPorFrag (String busca, Date dataIni, Date dataFin, int maxResults)
    {
        boolean between = dataIni != null && dataFin != null &&
                          (dataFin.after(dataIni) || dataFin.equals(dataIni));
        Between b = between ? new Between("laudo.procDoAtd.atendimento.dataAtendimento", AND) : null;
        QueryBuilder qb = new QueryBuilder(
                new Select(true, "laudo.procDoAtd.atendimento.codigo",
                        "laudo.procDoAtd.atendimento.paciente",
                        "laudo.procDoAtd.atendimento.convenio",
                        "laudo.procDoAtd.atendimento.dataAtendimento"),
                new Where("valor", LIKE), b);
        qb.setParametro("valor", "%" + escape(busca) + "%");
        if (between)
        {
            qb.setParametro(Between.LOWER_BOUND, setarHorario0horas(dataIni));
            qb.setParametro(Between.UPPER_BOUND, setarHorarioMeiaNoite(dataFin));
        }
        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    private String escape (String busca)
    {
        StringBuilder sb = new StringBuilder("");
        char[] charArray = busca.toCharArray();
        for (int i = 0; i < charArray.length; i++)
        {
            char c = charArray[i];
            if (c > 127)
            {
                sb.append("&#").append(Integer.valueOf(c)).append(";");
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public List<ProcDoAtd> buscarParaRel (String laudo, ProfExecutante profExe, Date dataIni, Date dataFin)
    {
        boolean dataOk = dataIni != null && dataFin != null &&
                          (dataFin.after(dataIni) || dataFin.equals(dataIni));
        if (!dataOk)
        {
            return new ArrayList<>();
        }
        And exec = profExe == null ? null : new And("laudo.procDoAtd.profExecutante", "exec");
        QueryBuilder qb = new QueryBuilder(
                new Select(true, "laudo.procDoAtd"),
                new Where("valor", LIKE), exec,
                new Between("laudo.procDoAtd.atendimento.dataAtendimento", AND));
        if (exec != null)
        {
            qb.setParametro("exec", profExe);
        }
        qb.setParametro("valor", "%" + escape(laudo) + "%");
        qb.setParametro(Between.LOWER_BOUND, setarHorario0horas(dataIni));
        qb.setParametro(Between.UPPER_BOUND, setarHorarioMeiaNoite(dataFin));
        return getResultList(qb, ProcDoAtd.class);
    }

    private Date setarHorario0horas (Date data)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    private Date setarHorarioMeiaNoite (Date data)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

}
