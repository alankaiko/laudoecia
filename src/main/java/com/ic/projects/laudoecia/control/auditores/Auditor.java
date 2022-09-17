/*
 * Auditor.java
 *
 * Created on 02/03/2012, 11:20:48
 */

package com.ic.projects.laudoecia.control.auditores;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.model.cadastro.AltDeRegistro;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.ic.projects.laudoecia.model.notentities.Endereco;
import com.lib.java.utils.StringUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @param <T>
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class Auditor<T extends Serializable>
{

    private TIPO_ACAO_DO_USUARIO tipo;
    private String tabela = "";
    private String codigoDoRegistro = "";
    private AcaoDoUsuario acaoAtual;
    private List<AltDeRegistro> alteracoes = new ArrayList<>();

    public void setCodigoDoRegistro (String codigoDoRegistro)
    {
        this.codigoDoRegistro = codigoDoRegistro;
    }

    public void setTabela (String tabela)
    {
        this.tabela = tabela;
    }

    public void setTipo (TIPO_ACAO_DO_USUARIO tipo)
    {
        this.tipo = tipo;
    }

    public AcaoDoUsuario criarAcaoDoUsuario (T entity, T originalEntity)
    {
        AcaoDoUsuario acao = new AcaoDoUsuario();
        acao.setRegistro(entity.toString());
        acao.setTabela(tabela);
        acao.setTipo(tipo);
        acao.setCodigoDoRegistro(codigoDoRegistro);
        acao.setEstacao(StaticInfo.getEstTrabalho());
        if (tipo == TIPO_ACAO_DO_USUARIO.ALTERAR)
        {
            acaoAtual = acao;
            preencherAlteracoes(entity, originalEntity);
            acao.setAlteracoes(alteracoes);
            alteracoes.clear();
        }
        acao.setDataDaAcao(new Date());
        acao.setUsuario(ControladorDeAcesso.getInstance().getResponsavelPelaAcao());
        return acao;
    }

    protected AltDeRegistro criarAltDeReg ()
    {
        return criarAltDeReg(TIPO_ACAO_DO_USUARIO.ALTERAR);
    }

    protected AltDeRegistro criarAltDeReg (TIPO_ACAO_DO_USUARIO tipo)
    {
        AltDeRegistro ar = new AltDeRegistro();
        ar.setTipo(tipo);
        ar.setAcaoDoUsuario(acaoAtual);
        alteracoes.add(ar);
        return ar;
    }

    protected void compararEnderecos (Endereco novo, Endereco antigo)
    {
        if (Objects.equals(novo, antigo))
        {
            return;
        }
        Endereco novoNn = novo == null ? new Endereco() : novo;
        Endereco antigoNn = antigo == null ? new Endereco() : antigo;
        if (!Objects.equals(novoNn.getUf(), antigoNn.getUf()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("UF");
            ar.setValorOriginal(antigoNn.getUf() == null ? "" : antigoNn.getUf().toString());
            ar.setValorAposAlteracao(novoNn.getUf() == null ? "" : novoNn.getUf().toString());
        }
        if (!Objects.equals(novoNn.getCidade(), antigoNn.getCidade()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Cidade");
            ar.setValorOriginal(antigoNn.getCidade());
            ar.setValorAposAlteracao(novoNn.getCidade());
        }
        if (!Objects.equals(novoNn.getBairro(), antigoNn.getBairro()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Bairro");
            ar.setValorOriginal(antigoNn.getBairro());
            ar.setValorAposAlteracao(novoNn.getBairro());
        }
        if (!Objects.equals(novoNn.getTipoDeLogradouro(), antigoNn.getTipoDeLogradouro()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Tipo de Logradouro");
            ar.setValorOriginal(antigoNn.getTipoDeLogradouro());
            ar.setValorAposAlteracao(novoNn.getTipoDeLogradouro());
        }
        if (!Objects.equals(novoNn.getLogradouro(), antigoNn.getLogradouro()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Logradouro");
            ar.setValorOriginal(antigoNn.getLogradouro());
            ar.setValorAposAlteracao(novoNn.getLogradouro());
        }
        if (!Objects.equals(novoNn.getComplemento(), antigoNn.getComplemento()))
        {
            AltDeRegistro ar = criarAltDeReg();
            ar.setCampo("Complemento");
            ar.setValorOriginal(antigoNn.getComplemento());
            ar.setValorAposAlteracao(novoNn.getComplemento());
        }
    }

    protected void compararPerfisDeAcesso (Object perfilNovo, Object perfilAntigo)
    {
        if (perfilNovo == null || perfilAntigo == null)
        {
        }
        else if (!perfilNovo.getClass().equals(perfilAntigo.getClass()))
        {
            throw new AssertionError();
        }
        else
        {
            Class<?> classeDoPerfil = perfilNovo.getClass();
            for (Method method : classeDoPerfil.getDeclaredMethods())
            {
                String methodName = method.getName();
                if (methodName.startsWith("is"))
                {
                    try
                    {
                        boolean permissaoNova = (boolean) method.invoke(perfilNovo);
                        boolean permissaoAntiga = (boolean) method.invoke(perfilAntigo);
                        if (permissaoAntiga == permissaoNova)
                        {

                        }
                        else
                        {
                            AltDeRegistro ar = criarAltDeReg();
                            String camelCaseName = StringUtils.splitCamelCase(methodName);
                            ar.setCampo(camelCaseName
                                    .substring(camelCaseName.indexOf(' ') + 1));
                            ar.setValorOriginal(permissaoAntiga ? "Sim" : "Não");
                            ar.setValorAposAlteracao(permissaoNova ? "Sim" : "Não");
                        }
                    }
                    catch (IllegalAccessException | IllegalArgumentException |
                            InvocationTargetException ex)
                    {
                    }
                }
            }
        }
    }

    abstract void preencherAlteracoes (T novo, T antigo);

}
