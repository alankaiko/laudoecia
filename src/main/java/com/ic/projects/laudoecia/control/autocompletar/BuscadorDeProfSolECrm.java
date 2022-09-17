/*
 * BuscadorDeProfSolECrm.java
 *
 * Created on 18/07/2012, 15:03:44
 */
package com.ic.projects.laudoecia.control.autocompletar;

import com.ic.projects.laudoecia.dao.auditable.DaoProfSolicitante;
import com.ic.projects.laudoecia.dao.basededados.DaoCRM;
import com.ic.projects.laudoecia.model.auditable.ProfSolicitante;
import com.ic.projects.laudoecia.model.basededados.Crm;
import com.ic.projects.laudoecia.model.basededados.UF;
import com.ic.projects.laudoecia.model.tiss.TISS_Conselho;
import com.lib.icontrol.autocompletar.C_AutoCompletarLista;
import com.lib.iview.autocompletar.AcTableConfigurator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class BuscadorDeProfSolECrm extends C_AutoCompletarLista<ProfSolicitante>
{
    private UF uf;
    private TISS_Conselho conselho;
    private DaoProfSolicitante daoProf;
    private DaoCRM daoCrm;
    private boolean buscarSoEmCrm = false;
    private final TISS_Conselho CRM = new TISS_Conselho("CRM");

    @Override
    public List<Object[]> buscarCandidatos (String textoDaBusca)
    {
        if (uf == null || conselho == null || textoDaBusca.isEmpty())
        {
            return new ArrayList<>();
        }

        List<Object[]> listProf;
        if (buscarSoEmCrm)
        {
            listProf = new ArrayList<>();
        }
        else
        {
            listProf = getDaoProf().buscarPorNumConselho(textoDaBusca, conselho, uf);
        }

        List<Object[]> listCrm = null;
        if (listProf.isEmpty() && conselho.equals(CRM))
        {
            listCrm = getDaoCrm().buscarPorNumConselho(textoDaBusca, uf);
        }
        if (listCrm != null && !listCrm.isEmpty())
        {
            for (int i = 0; i < listCrm.size(); i++)
            {
                Object[] get = listCrm.get(i);
                Object[] obj = new Object[] {CRM, get[0], get[1], get[2]};
                if (naoEstaNaLista(listProf, obj))
                {
                    listProf.add(obj);
                }
            }
        }
        return listProf;
    }

    @Override
    public ProfSolicitante getModel (Object[] linha)
    {
        ProfSolicitante profSol;
        if (buscarSoEmCrm)
        {
            profSol = new ProfSolicitante();
            profSol.setConselho((TISS_Conselho) linha[0]);
            profSol.setUfConselho((UF) linha[1]);
            profSol.setNumNoConselho((String) linha[2]);
            profSol.setNome((String) linha[3]);
        }
        else
        {
            profSol = getDaoProf().procurarPorTissUfNum(
                    (TISS_Conselho) linha[0], (UF) linha[1], (String) linha[2]);
            if (profSol == null)
            {
                profSol = new ProfSolicitante();
                profSol.setConselho((TISS_Conselho) linha[0]);
                profSol.setUfConselho((UF) linha[1]);
                profSol.setNumNoConselho((String) linha[2]);
                profSol.setNome((String) linha[3]);
            }
        }
        return profSol;
    }

    @Override
    protected Object[] getLinha (ProfSolicitante model)
    {
        return new Object[] {model.getConselho(), model.getUfConselho(), model.getNumNoConselho(), model.getNome()};
    }

    @Override
    public AcTableConfigurator getPropriedadesDaTabela ()
    {
        return new AcTableConfigurator()
        {
            @Override
            public Class<?>[] columnsClasses ()
            {
                return new Class<?>[]
                        {
                            Object.class, Object.class, String.class, String.class
                        };
            }

            @Override
            public int[] sortedColumns ()
            {
                return new int [] { 2 };
            }

            @Override
            public boolean[] shouldResizeColumns ()
            {
                return new boolean[]
                        {
                            false, false, false, true
                        };
            }

            @Override
            public String[] columnsTitles ()
            {
                return new String[]
                        {
                            "Conselho", "UF", "Num. Cons.", "Nome"
                        };
            }

            @Override
            public int[] columnsWidths ()
            {
                return new int[]
                        {
                            75, 40, 90, 0
                        };
            }

            @Override
            public int indexToUseAsTextFieldText ()
            {
                return 2;
            }

        };
    }

    private DaoProfSolicitante getDaoProf()
    {
        if (daoProf == null)
        {
            daoProf = new DaoProfSolicitante();
        }
        return daoProf;
    }

    private DaoCRM getDaoCrm()
    {
        if (daoCrm == null)
        {
            daoCrm = new DaoCRM();
        }
        return daoCrm;
    }

    public List<Object[]> buscarNumENome (TISS_Conselho conselho, UF uf, String busca)
    {
        if (uf == null || conselho == null || busca.isEmpty())
        {
            return new ArrayList<>();
        }
        List<Object[]> listProf = new ArrayList<>();
        if (busca.matches("[0-9]+"))
        {
            ProfSolicitante sol = getDaoProf().procurarPorTissUfNum(
                    conselho, uf, busca);
            if (sol != null)
            {
                listProf.add(new String[] { sol.getNumNoConselho(), sol.getNome() });
            }
            if (CRM.equals(conselho) && listProf.isEmpty())
            {
                Crm crm = getDaoCrm().procurarPorCrmEUF(busca, uf);
                if (crm != null)
                {
                    listProf.add(new String[] {crm.getCrm(), crm.getNome()});
                }
            }
        }
        else
        {
            if (CRM.equals(conselho))
            {
                listProf.addAll(getDaoCrm().buscarPorNome(busca, uf));
            }
            List<Object[]> sols = getDaoProf().buscarPorNome(busca, uf, conselho);
            outer: for (Object[] dadosSol : sols)
            {
                Object crmPelaSol = dadosSol[0];
                inner: for (Object[] dadosCrm : listProf)
                {
                    if (Objects.equals(crmPelaSol, dadosCrm[0]))
                    {
                        continue outer;
                    }
                }
                listProf.add(dadosSol);
            }
        }
        return listProf;
    }

    public void setUf (UF uf)
    {
        this.uf = uf;
        controlarHabilitado();
    }

    public void setConselho (TISS_Conselho conselho)
    {
        this.conselho = conselho;
        controlarHabilitado();
    }

    public void setBuscarSoEmCrm (boolean buscarSoEmCrm)
    {
        this.buscarSoEmCrm = buscarSoEmCrm;
    }

    private boolean naoEstaNaLista (List<Object[]> list, Object[] obj)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Object[] get = list.get(i);
            if (get[0].equals(obj[0]) && get[1].equals(obj[1]) && get[2].equals(obj[2]))
            {
                return false;
            }
        }
        return true;
    }

    private void controlarHabilitado ()
    {
        if (buscarSoEmCrm)
        {
            getView().setHabilitado(uf != null && CRM.equals(conselho));
        }
        else
        {
            getView().setHabilitado(uf != null);
        }
    }

}
