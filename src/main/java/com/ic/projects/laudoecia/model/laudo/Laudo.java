/*
 * Laudo.java
 *
 * Created on 18/01/2012, 17:46:31
 */
package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.basededados.SubcategoriaCID10;
import com.ic.projects.laudoecia.model.enums.STATUS_LAUDO;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@Entity
@Table(name = "laudo")
public class Laudo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @JoinColumn(name = "procdoatd_codigo", referencedColumnName = "codigo", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private ProcDoAtd procDoAtd;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private STATUS_LAUDO status = STATUS_LAUDO.PENDENTE;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "laudo", orphanRemoval = true)
    private List<ParametroDoLaudo> paramsLaudo = new ArrayList<>();

    @JoinColumn(name = "modelodelaudo_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private ModeloDeLaudoDoProc modeloDeLaudo;

    @JoinColumn(name = "cid_resultado_ex_codigo", referencedColumnName = "codigo", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private SubcategoriaCID10 cidResultadoDoExame;

    @Transient
    private Planilha planilha;

    @Transient
    private List<Runnable> listenersPlanilha = new ArrayList<>();

    // <editor-fold defaultstate="collapsed" desc="Usual entity stuff">

    public int getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public ModeloDeLaudoDoProc getModeloDeLaudo ()
    {
        return modeloDeLaudo;
    }

    public void setModeloDeLaudo (ModeloDeLaudoDoProc modeloDeLaudo)
    {
        this.modeloDeLaudo = modeloDeLaudo;
    }

    public List<ParametroDoLaudo> getParamsLaudo ()
    {
        return Collections.unmodifiableList(paramsLaudo);
    }

    public void setParamsLaudo (List<ParametroDoLaudo> paramsLaudo)
    {
        this.paramsLaudo.clear();
        if (paramsLaudo == null)
        {
        }
        else
        {
            this.paramsLaudo.addAll(paramsLaudo);
        }
    }

    public ProcDoAtd getProcDoAtd ()
    {
        return procDoAtd;
    }

    public void setProcDoAtd (ProcDoAtd procDoAtd)
    {
        this.procDoAtd = procDoAtd;
    }

    public STATUS_LAUDO getStatus ()
    {
        return status;
    }

    public SubcategoriaCID10 getCidResultadoDoExame ()
    {
        return cidResultadoDoExame;
    }

    public void setCidResultadoDoExame (SubcategoriaCID10 cidResultadoDoExame)
    {
        this.cidResultadoDoExame = cidResultadoDoExame;
    }

    @Override
    public String toString ()
    {
        return "{" + "codigo=" + codigo + '}';
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Laudo other = (Laudo) obj;
        if (this.codigo != other.getCodigo())
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        int hash = 5;
        hash = 83 * hash + this.codigo;
        return hash;
    }

    // </editor-fold>

    public Laudo ()
    {
    }

    public Laudo (ModeloDeLaudoDoProc modeloDeLaudo)
    {
        this.modeloDeLaudo = modeloDeLaudo;
    }

    public Laudo (Laudo prototipo)
    {
        cidResultadoDoExame = prototipo.getCidResultadoDoExame();
        codigo = prototipo.getCodigo();
        modeloDeLaudo = prototipo.getModeloDeLaudo();
        procDoAtd = prototipo.getProcDoAtd();
        if (prototipo.getParamsLaudo() == null)
        {
        }
        else
        {
            paramsLaudo.addAll(prototipo.getParamsLaudo());
        }
    }

    /**
     * never returns null
     * @return
     * @throws Exception
     */
    public Planilha getPlanilha () throws Exception
    {
        return getPlanilha(false);
    }

    public synchronized Planilha getPlanilha (boolean criarPlanilha) throws Exception
    {
        if (planilha == null || criarPlanilha)
        {
            planilha = new CriadorDePlanilha(this).criarPlanilha();
            for (Runnable runnable : listenersPlanilha)
            {
                runnable.run();
            }
            listenersPlanilha.clear();
        }
        return planilha;
    }

    public void salvarAlteracoes () throws Exception
    {
        Planilha p = getPlanilha();
        try
        {
            p.gerarHtml(true);
            status = STATUS_LAUDO.PRONTO;
        }
        catch (ErrosDeValidacao ex)
        {
            status = STATUS_LAUDO.PENDENTE;
        }
        Map<Integer, String> paramsAtuais = p.criarParamsLaudo();
        List<ParametroDoLaudo> novosParamsLaudo = new ArrayList<>();
        List<Integer> indexesAtuais = indexesAtuais();
        for (Map.Entry<Integer, String> entry : paramsAtuais.entrySet())
        {
            Integer index = entry.getKey();
            String valor = entry.getValue();
            ParametroDoLaudo pdl;
            if (indexesAtuais.contains(index))
            {
                pdl = paramsLaudo.get(indexesAtuais.indexOf(index));
            }
            else
            {
                pdl = new ParametroDoLaudo();
                pdl.setIndex(index);
                pdl.setLaudo(this);
            }
            pdl.setValor(valor);
            novosParamsLaudo.add(pdl);
        }
        paramsLaudo = novosParamsLaudo;
    }

    private List<Integer> indexesAtuais ()
    {
        List<Integer> resposta = new ArrayList<>();
        for (int i = 0; i < paramsLaudo.size(); i++)
        {
            resposta.add(paramsLaudo.get(i).getIndex());
        }
        return resposta;
    }

    public void addListener (Runnable runn)
    {
        listenersPlanilha.add(runn);
    }

    public void removeListener (Runnable runn)
    {
        listenersPlanilha.remove(runn);
    }

}
