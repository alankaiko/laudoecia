/*
 * CampoDoLaudo.java
 *
 * Created on 07/05/2012, 09:05:33
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.iview.ViewCampoDoLaudo;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroDeCampoObrigatorio;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.lib.java.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * Abstracao de todos os possiveis campos de um laudo. Um campo do laudo
 * eh persistivel atraves da propriedade valor, e eh capaz de gerar uma String
 * html representando seu estado. Um objeto do tipo campo do laudo pode ser
 * totalmente definido atraves da sua propriedade valor (value object).
 * Todas as outras propriedades sao tansientes.
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
@SuppressWarnings("NoopMethodInAbstractClass")
public abstract class CampoDoLaudo
{

    // <editor-fold defaultstate="collapsed" desc="Flags">

    public static final int AO_MENOS_1_CAMPO_POSSUI_VALOR = 0;

    public static final int POR_HTML = 0;
    public static final int POR_VALOR = 1;

    public static final String DIGITAR = "Digitar";

    // </editor-fold>

    /**
     * Valor persistivel do campo
     * Todo campo deve sempre aceitar um valor null como valor valido
     */
    private String valor = null;
    /**
     * Sabendo que um campo do laudo pode depender de varios outros campos,
     * essa propriedade informa se faz sentido o valor do campo, dada a situacao
     * dos campos dependentes
     */
    private HabilitacaoDeCampo habilitacao = new HabilitacaoDeCampo(this);
    private boolean imprimivel = true;
    /**
     * Flag que representa se o campo eh obrigatorio, para fins de validacao
     * Um campo do laudo que eh solicitado a gerar seu html lanca uma excecao
     * de validacao se seu html for null ou vazio, e essa flag for true
     */
    private boolean obrigatorio = !(this instanceof Composite || campoFormula());
    /**
     *
     */
    private boolean setarValorNullQuandoDesabilitado = true;
    /**
     *
     */
    private int tipoValidObrig = POR_VALOR;
    /**
     * Lista de objetos interessados nos eventos disparados pelo campo
     */
    private Set<CampoDoLaudoListener> listeners = new HashSet<>();
    /**
     * Mensagem contida na excecao lancada em um erro de validacao devido
     * ao campo ser obrigatorio
     */
    private String msgErroValidCampoObrig = "Campo obrigatório";
    /**
     *
     */
    private boolean persistivel = !campoFormula();
    /**
     *
     */
    private CampoDoLaudo parent;
    /**
     *
     */
    private ViewCampoDoLaudo view;

    // <editor-fold defaultstate="collapsed" desc="Regras de negócio">

    /**
     * Vincula a propriedade obrigatorio desse campo a alguma propriedade
     * dos campos passados como parametros. O tipo de vinculacao eh definido
     * pela flag tipo.
     * @param tipo flag contendo o tipo de vinculacao desejada
     * @param campos os campos dos quais depende a propriedade obrigatorio
     * @throws ErroNaCriacaoDoModelo
     */
    public void vincularObrigatorio (int tipo, final CampoDoLaudo... campos) throws ErroNaCriacaoDoModelo
    {
        switch (tipo)
        {
            case AO_MENOS_1_CAMPO_POSSUI_VALOR:
                ConfiguradorDeObrigatoriedade0 c =
                    new ConfiguradorDeObrigatoriedade0(campos);
                break;
            default:
                throw new ErroNaCriacaoDoModelo("Tipo de vinculação do "
                        + "campo obrigatório inválido");
        }
    }

    public void vincularObrigatorio (CampoDoLaudo campo, final String[] valores) throws ErroNaCriacaoDoModelo
    {
        campo.adicionarListener(new CampoDoLaudoListener() {

            @Override
            public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
            {
                if (evento.getTipo() == EventoDoCampoDoLaudo.VALOR_MUDOU)
                {
                    for (int i = 0; i < valores.length; i++)
                    {
                        String valor = valores[i];
                        if (Objects.equals(valor, (String)evento.getValorAtual()))
                        {
                            obrigatorio = true;
                            return;
                        }
                    }
                    obrigatorio = false;
                }
            }
        });
    }

    /**
     * Vincula a propriedade habilitado ao valor do campo enumeracao passado
     * como parametro. Quando o valor do campo passado como parametro for igual
     * a Enumeracao.NAO_IMPRIMIR, a propriedade habilitado eh setado para false
     * @param enumeracao
     * @throws ErroNaCriacaoDoModelo
     */
    public void vincularHabAhEnumeracao (Enumeracao enumeracao) throws ErroNaCriacaoDoModelo
    {
        vincularHabAoValorDoCampo(enumeracao, Enumeracao.NAO_IMPRIMIR);
    }

    /**
     * Vincula a propriedade habilitado ao valor do campo passado
     * como parametro. Quando o valor do campo passado como parametro for igual
     * a algum dos valores passados, a propriedade habilitado eh
     * setada para false
     * @param campo o campo do qual a propriedade habilitado depende
     * @param valoresASeremComparados todos os valores que setam habilitado para false
     * @throws ErroNaCriacaoDoModelo
     */
    public void vincularHabAoValorDoCampo (CampoDoLaudo campo, String... valoresASeremComparados) throws ErroNaCriacaoDoModelo
    {
        vincularHabAoValorDoCampo(campo, true, valoresASeremComparados);
    }

    /**
     * Vincula a propriedade habilitado ao valor do campo passado
     * como parametro.
     * Quando a flag quandoForIgual eh true: habilitado eh setado para false
     * quando o valor do parametro campo for igual a um dos valores passados.
     * Quando a flag quandoForIgual eh false: habilitado eh setado para false
     * quando o valor do parametro campo for diferente de todos os valores passados.
     * @param campo o campo do qual a propriedade habilitado depende
     * @param desQuandoForIgual
     * @param valoresASeremComparados todos os valores que setam habilitado para valorHab
     * @throws ErroNaCriacaoDoModelo
     */
    public void vincularHabAoValorDoCampo (CampoDoLaudo campo, boolean desQuandoForIgual,
                                     String... valoresASeremComparados) throws ErroNaCriacaoDoModelo
    {
        if (campo == null)
        {
            throw new ErroNaCriacaoDoModelo("O campo a ser vinculado eh null!");
        }
        habilitacao.adicionarDependencia(campo, new DesabilitadorPorValor(
                valoresASeremComparados, campo.getValor(), desQuandoForIgual));
    }

    /**
     * Vincula a habilitacao a habilitacao do campo passado como parametro
     * @param campo
     * @throws ErroNaCriacaoDoModelo
     */
    public void vincularHabilitacao (CampoDoLaudo campo) throws ErroNaCriacaoDoModelo
    {
        if (campo == null)
        {
            throw new ErroNaCriacaoDoModelo("O campo a ser vinculado eh null!");
        }
        habilitacao.adicionarDependencia(campo, new DesabilitadorPorHabilitacao(campo));
    }

    public void setTipoValidObrig (int tipoValObrig) throws ErroNaCriacaoDoModelo
    {
        switch (tipoValObrig)
        {
            case POR_HTML:
            case POR_VALOR:
                this.tipoValidObrig = tipoValObrig;
                break;
            default:
                throw new ErroNaCriacaoDoModelo("Tipo de validação de obrigatório inesperado!");
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Classes internas de regras de negócios">

    private class ConfiguradorDeObrigatoriedade0 implements CampoDoLaudoListener
    {

        private CampoDoLaudo[] campos;

        @SuppressWarnings("LeakingThisInConstructor")
        private ConfiguradorDeObrigatoriedade0 (CampoDoLaudo[] campos)
        {
            for (int i = 0; i < campos.length; i++)
            {
                campos[i].adicionarListener(this);
            }
            this.campos = campos;
        }

        @Override
        public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
        {
            switch (evento.getTipo())
            {
                case EventoDoCampoDoLaudo.VALOR_MUDOU:
                    break;
                default:
                    return;
            }
            boolean peloMenosUmEstaPreenchido = false;
            for (int j = 0; j < campos.length; j++)
            {
                String valorCampo = campos[j].getValor();
                if (!(valorCampo == null || valorCampo.isEmpty()))
                {
                    peloMenosUmEstaPreenchido = true;
                }
            }
            setObrigatorio(peloMenosUmEstaPreenchido);
        }

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos de acesso de propriedades">

    public void setHabilitado (boolean habilitado)
    {
        boolean valorAntigo = this.habilitacao.isHabilitado();
        this.habilitacao.setHabilitado(habilitado);
        if (dispararEvento(EventoDoCampoDoLaudo.HABILITADO_MUDOU,
                       valorAntigo, habilitado))
        {
            if (habilitado)
            {
                if (campoFormula() && valor == null)
                {
                    atualizarValor();
                }
            }
            else if (!setarValorNullQuandoDesabilitado)
            {
            }
            else
            {
                try
                {
                    setValor(null);
                }
                catch (ErrosDeValidacao ex)
                {
                }
            }
        }
    }

    @SuppressWarnings("NestedAssignment")
    public void setObrigatorio (boolean obrigatorio)
    {
        dispararEvento(EventoDoCampoDoLaudo.OBRIGATORIO_MUDOU,
                       this.obrigatorio, this.obrigatorio = obrigatorio);
    }

    public boolean isHabilitado ()
    {
        if (this instanceof Composite)
        {
            return habilitacao.isHabilitado();
        }
        else
        {
            CampoDoLaudo p = getParent();
            while (p != null)
            {
                if (p.getValor() != null)
                {
                    return false;
                }
                p = p.getParent();
            }
            return habilitacao.isHabilitado();
        }
    }

    public boolean isObrigatorio ()
    {
        return obrigatorio;
    }

    public String getValor ()
    {
        return valor;
    }

    public void setImprimivel (boolean imprimivel)
    {
        this.imprimivel = imprimivel;
    }

    /**
     * Seta o valor desse campo.
     * As implementacoes eh que validam se o valor eh aceito.
     * @param valor o valor informado pelas classes clientes
     * @throws ErrosDeValidacao
     * implementacao
     */
    @SuppressWarnings("NestedAssignment")
    public void setValor (String valor) throws ErrosDeValidacao
    {
        if (!(valor == null || valor.isEmpty()))
        {
            validarValorNaoVazio(valor);
        }
        dispararEvento(EventoDoCampoDoLaudo.VALOR_MUDOU,
                       this.valor, this.valor = tratarValorQueSeraSetado(valor));
    }

    public void setMsgErroValidCampoObrig (String msgErroValidCampoObrig)
    {
        this.msgErroValidCampoObrig = msgErroValidCampoObrig;
    }

    public void setView (ViewCampoDoLaudo view)
    {
        this.view = view;
        CampoDoLaudo cdl = getParent();
        if (cdl != null)
        {
            cdl.setView(view);
        }
    }

    public ViewCampoDoLaudo getView ()
    {
        return view;
    }

    HabilitacaoDeCampo getHabilitacao ()
    {
        return habilitacao;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos usados apenas pelo campo do laudo">

    void setParent (CampoDoLaudo parent)
    {
        this.parent = parent;
        parentSet();
    }

    boolean isPersistivel ()
    {
        return persistivel;
    }

    CampoDoLaudo getParent ()
    {
        return parent;
    }

    boolean isSetarValorNullQuandoDesabilitado ()
    {
        return setarValorNullQuandoDesabilitado;
    }

    void setSetarValorNullQuandoDesabilitado (boolean setarValorNullQuandoDesabilitado)
    {
        this.setarValorNullQuandoDesabilitado = setarValorNullQuandoDesabilitado;
    }

    /**
     * Metodo chamado antes de setar o valor. As classes filhas podem
     * sobrescrever esse metodo para alterar (formatar por exemplo) a
     * propriedade valor que foi informada pelas classes clientes
     * @param valor o valor informado pelas classes clientes
     * @return
     */
    String tratarValorQueSeraSetado (String valor)
    {
        return valor;
    }

    /**
     * Metodo implementado pelas classes filhas para a geracao do html conforme
     * suas regras
     *
     * @return o html conforme as regras da implementacao
     * @throws ErrosDeValidacao lancado se houver um erro de validacao durante a
     * geracao do html
     */
    abstract String gerarHtmlImpl (boolean validar) throws ErrosDeValidacao;
    /**
     * Validacao do parametro valor que esta sendo setado no campo do laudo
     * @param valor
     * @throws ErrosDeValor
     */
    abstract void validarValorNaoVazio (String valor) throws ErrosDeValidacao;

    boolean campoFormula ()
    {
        return false;
    }

    void atualizarValor ()
    {

    }

    void parentSet ()
    {

    }

    Laudo getLaudo ()
    {
        if (parent == null)
        {
            throw new AssertionError("Parent do cdl null!");
        }
        return parent.getLaudo();
    }

    public ProcDoAtd getProc ()
    {
        return getLaudo().getProcDoAtd();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Utilities">

    /**
     * Dispara um evento, e retorna true se o evento foi disparado com sucesso.
     * @param tipo
     * @param valorAnterior
     * @param valorAtual
     * @return
     */
    boolean dispararEvento (int tipo, Object valorAnterior, Object valorAtual)
    {
        if (valorAnterior instanceof String && valorAtual instanceof String)
        {
            if (!valorMudou((String) valorAnterior, (String) valorAtual))
            {
                return false;
            }
        }
        else
        {
            if (Objects.equals(valorAnterior, valorAtual))
            {
                return false;
            }
        }
        EventoDoCampoDoLaudo evt = new EventoDoCampoDoLaudo(
                        tipo, this, valorAnterior, valorAtual);
        for (Iterator<CampoDoLaudoListener> it = listeners.iterator(); it.hasNext();)
        {
            it.next().campoDoLaudoMudou(evt);
        }
        return true;
    }

    boolean valorMudou (String valorAntigo, String valorNovo)
    {
        // trato null e vazio da mesma forma
        if (valorAntigo == null && (valorNovo != null && valorNovo.trim().isEmpty()))
        {
            return false;
        }
        if (valorNovo == null && (valorAntigo != null && valorAntigo.trim().isEmpty()))
        {
            return false;
        }
        return !Objects.equals(valorAntigo, valorNovo);
    }

    // </editor-fold>

    public String gerarHtml (boolean validar) throws ErrosDeValidacao
    {
        if (isHabilitado() && imprimivel)
        {
            switch (tipoValidObrig)
            {
                case POR_HTML:
                    String html = gerarHtmlImpl(validar);
                    if (obrigatorio && validar &&// habilitacao.isHabilitado() &&
                          (StringUtils.textBetweenTags(html).trim().isEmpty()))
                    {
                        throw new ErroDeCampoObrigatorio(this,
                                getMsgErroValidCampoObrig());
                    }
                    return html;
                case POR_VALOR:
                    String valorAtual = getValor();
                    if (obrigatorio && validar &&// habilitacao.isHabilitado() &&
                          (StringUtils.textBetweenTags(valorAtual).trim().isEmpty()))
                    {
                        throw new ErroDeCampoObrigatorio(this,
                                getMsgErroValidCampoObrig());
                    }
                    return gerarHtmlImpl(validar);
                default:
                    // linha não será executada, proteção está no método
                    // setTipoValidObrig
                    return null;
            }
        }
        else
        {
            return "";
        }
    }

    public void adicionarListener (CampoDoLaudoListener listener)
    {
        listeners.add(listener);
    }

    public void removerListener (CampoDoLaudoListener listener)
    {
        listeners.remove(listener);
    }

    public void accept (CampoDoLaudoVisitor visitor)
    {
    }

    public String getMsgErroValidCampoObrig ()
    {
        return msgErroValidCampoObrig;
    }

    // <editor-fold defaultstate="collapsed" desc="Debugging aid">

    private int index ()
    {
        Planilha p = getPlanilha();
        if (p == null)
        {
            return -1;
        }
        for (Entry<Integer, CampoDoLaudo> entry : p.getMapaDeCampos().entrySet())
        {
            if (entry.getValue() == this)
            {
                return entry.getKey();
            }
        }
        return -1;
    }

    private Planilha getPlanilha ()
    {
        CampoDoLaudo p = getParent();
        while (p != null)
        {
            if (p instanceof Planilha)
            {
                return (Planilha) p;
            }
            p = p.getParent();
        }
        return null;
    }

    // </editor-fold>

}
