/*
 * CampoRpn.java
 *
 * Created on 08/05/2012, 16:35:18
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErroNaCriacaoDoModelo;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDoCampoDoLaudo;
import com.lib.java.rpn.ExpressaoRpn;
import com.lib.java.rpn.InterpretadorRpn;
import com.lib.java.rpn.MapaIncompletoException;
import com.lib.java.rpn.Numero;
import com.lib.java.utils.StringUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class CampoRpn extends CampoDouble implements CampoDoLaudoListener
{

    private Map<CampoNumero, Integer> mapaDeCampos = new HashMap<>();
    private Map<String, ExpressaoRpn> variaveisDaExpRpn = new HashMap<>();
    private InterpretadorRpn interpretador;
    private Enumeracao campoDaFormula;

    private CampoRpn (String valorConstante, int numCasasDecimais) throws ErroNaCriacaoDoModelo
    {
        super(valorConstante, numCasasDecimais);
    }

    /**
     * Constroi um novo campo de formula. A Formula deve estar no padrao:
     * C1 C2 10,50 5 pi e @nome do parametro do laudo@ + * - / ^
     * C1 e C2 representam campos do laudo cujo valor vai entrar na formula
     * (os numeros C1 e C2 representam o primeiro e o segundo campos adicionados)
     * e o valor entre os marcadores @ devem constar nos parametros dos laudos.
     * @param formulaPseudoRpn a formula no formato explicado
     * @param valorConstante conforme superclasse
     */
    public CampoRpn (String formulaPseudoRpn, String valorConstante,
                                    int numCasasDecimais) throws ErroNaCriacaoDoModelo
    {
        this(valorConstante, numCasasDecimais);
        if (formulaPseudoRpn == null || formulaPseudoRpn.isEmpty())
        {
            throw new ErroNaCriacaoDoModelo("A formula nao pode ser vazia!");
        }
        atualizarInterpretador(formulaPseudoRpn);
        atualizarValor();
    }

    /**
     * Constroi um novo campo de formula. A Formula deve estar no padrao:
     * C1 C2 10,50 5 pi e @nome do parametro do laudo@ + * - / ^
     * O caracter de nova linha eh aceito, sendo substituido por espacos
     * C1 e C2 representam campos do laudo cujo valor vai entrar na formula
     * (os numeros C1 e C2 representam o primeiro e o segundo campos adicionados)
     * e o valor entre os marcadores @ devem constar nos parametros dos laudos.
     * @param campoEscolhaDaFormula
     * @param formulaPseudoRpn a formula no formato explicado
     * @param valorConstante conforme superclasse
     */
    public CampoRpn (Enumeracao campoEscolhaDaFormula, String valorConstante,
                                    int numCasasDecimais) throws ErrosDoCampoDoLaudo
    {
        this(valorConstante, numCasasDecimais);
        if (campoEscolhaDaFormula == null)
        {
            throw new ErroNaCriacaoDoModelo("Enumeracao nao pode ser null!");
        }
        campoEscolhaDaFormula.adicionarListener(this);
        this.campoDaFormula = campoEscolhaDaFormula;
        atualizarInterpretador(campoEscolhaDaFormula.valorDaChaveSelecionada());
        atualizarValor();
    }

    /**
     * Cadastra um campo que eh parte na formula. O metodo getValor desse campo
     * deve retornar um numero, senao uma excecao eh lancada. O variavel da
     * formula que se refere ao campo eh inferida pela ordem em que o campo
     * foi adicionado, sendo C1 para o primeiro, C2 para o segundo, etc...
     * @param campo o campo a ser cadastrado.
     */
    public void cadastrarParametroFormula (CampoNumero campo) throws ErrosDoCampoDoLaudo
    {
        cadastrarParametroFormula(campo, mapaDeCampos.size() + 1);
    }

    public void cadastrarParametroFormula (CampoNumero campo, int id) throws ErrosDoCampoDoLaudo
    {
        if (campo == null)
        {
            throw new ErroNaCriacaoDoModelo("O campo não deve ser null!");
        }
        if (mapaDeCampos.containsKey(campo))
        {
            throw new ErroNaCriacaoDoModelo("O mesmo campo não pode ser adicionado duas vezes!");
        }
        mapaDeCampos.put(campo, id);
        campo.adicionarListener(this);
        atualizarVariavelDeCampo(campo);
        atualizarValor();
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
        if (evento.getOrigem() == campoDaFormula)
        {
            atualizarInterpretador(campoDaFormula.valorDaChaveSelecionada());
        }
        else
        {
            atualizarVariavelDeCampo((CampoNumero)evento.getOrigem());
        }
        atualizarValor();
    }

    private void atualizarInterpretador (String formulaPseudoRpn)
    {
        if (formulaPseudoRpn == null || formulaPseudoRpn.isEmpty())
        {
            interpretador = new InterpretadorRpn("0");
        }
        else
        {
            Pattern pattern = Pattern.compile("@[^@]+@");
            Matcher matcher = pattern.matcher(formulaPseudoRpn);
            String formulaRpn = formulaPseudoRpn;
            final String marcadorParam = "P";
            int matchCount = 0;
            while (matcher.find())
            {
                String match = matcher.group();
                String nomeDoParam = marcadorParam + ++matchCount;
                // constroi formula rpn pela formulaPseudoRpn
                formulaRpn = formulaRpn.replace(match, nomeDoParam);
                try
                {
                    String paramLaudo = StaticInfo.getParametroDoLaudo(
                        match.replaceAll("@", ""));
                    // mapeia parametro do laudo
                    variaveisDaExpRpn.put(nomeDoParam, new Numero(
                            Double.valueOf(paramLaudo)));
                }
                catch (IOException ex)
                {
                    // a formula lançara um mapa incompleto exception
                }
            }
            interpretador = new InterpretadorRpn(formulaRpn);
        }
    }

    private void atualizarVariavelDeCampo (CampoNumero origem)
    {
        String valor = origem.getValor();
        Numero numero = null;
        if (valor == null || valor.isEmpty())
        {
        }
        else
        {
            numero = new Numero(origem.getDouble());
        }
        String idNaFormula = String.valueOf(mapaDeCampos.get(origem));
        variaveisDaExpRpn.put("C" + idNaFormula, numero);
    }

    @Override
    boolean campoFormula ()
    {
        return true;
    }

    @Override
    final void atualizarValor ()
    {
        String novoValor;
        try
        {
            double valorCalculado = interpretador.interpret(variaveisDaExpRpn);
            if (Double.isInfinite(valorCalculado) || Double.isNaN(valorCalculado))
            {
                novoValor = null;
            }
            else
            {
                novoValor = String.valueOf(valorCalculado);
            }
        }
        catch (MapaIncompletoException ex)
        {
            novoValor = null;
        }
        try
        {
            setValor(novoValor);
        }
        catch (ErrosDeValidacao ex)
        {
            // o valor que estou tentando setar sera sempre aceito
        }
    }

    @Override
    public void accept (CampoDoLaudoVisitor visitor)
    {
        visitor.visit(this);
    }

}
