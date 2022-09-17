/*
 * C_EntidadeAtendimento.java
 *
 * Created on 23/04/2012, 09:41:18
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.autocompletar.BuscadorDePacientes;
import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.dao.cadastro.DaoAcaoDoUsuario;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.EstacaoDeTrabalho;
import com.ic.projects.laudoecia.model.auditable.Paciente;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.lib.icontrol.crud.entidade.C_Validacao;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.FieldReader;
import com.lib.iview.crud.ViewEntidadeComCrud;
import java.util.Date;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeAtendimento extends DefC_EntidadeComCrud<Atendimento, Integer>
{

    private final DaoAtendimento dao;
    private DaoAcaoDoUsuario daoAcaoDoUsuario;
    private DaoProcDoAtd daoProc;
    private C_CadastroAtendimento c_Cadastro;

    public C_EntidadeAtendimento (ViewEntidadeComCrud<Atendimento> view)
    {
        super(new DaoAtendimento(), view);
        dao = (DaoAtendimento) getDao();
    }

    @Override
    public boolean validarCodigo ()
    {
        return false;
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("paciente", new ValidadorPaciente());
    }

    @Override
    public Atendimento criarEntidadeParaAdicionar ()
    {
        Atendimento atd = new Atendimento();
        atd.setDataAtendimento(new Date());
        return atd;
    }

    private DaoAcaoDoUsuario getDaoAcaoDoUsuario ()
    {
        if (daoAcaoDoUsuario == null)
        {
            daoAcaoDoUsuario = new DaoAcaoDoUsuario();
        }
        return daoAcaoDoUsuario;
    }

    private DaoProcDoAtd getDaoProcDoAtd ()
    {
        if (daoProc == null)
        {
            daoProc = new DaoProcDoAtd();
        }
        return daoProc;
    }

    public Usuario getUsuarioRespPelaAcao (int codigoAtd)
    {
        Usuario resp = getDaoAcaoDoUsuario().buscarUsuarioRespPeloAtd(codigoAtd);
        if (resp == null || dao.procurarPorId(codigoAtd) == null)
        {
            return null;
        }
        return resp;
    }

    public boolean jaExisteAtdHoje (Paciente p)
    {
        return dao.jaExisteAtdHoje(p);
    }

    void setC_Cadastro (C_CadastroAtendimento c_Cadastro)
    {
        this.c_Cadastro = c_Cadastro;
    }

    public boolean salvar ()
    {
        return c_Cadastro.salvar();
    }

    public boolean alterar ()
    {
        return c_Cadastro.alterar();
    }

    public boolean pacienteExiste (String nome, Date nasc)
    {
        return dao.getDaoPac().getCodigo(nome, nasc) != 0;
    }

    public EstacaoDeTrabalho procIsLocked (int codigo)
    {
        return getDaoProcDoAtd().getEstacao(codigo);
    }

    private class ValidadorPaciente implements C_Validacao
    {

        private FieldReader pacienteReader;

        @Override
        public C_Validacao set (String chave, FieldReader reader)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean validationOk (int tipo)
        {
            Object fieldValue = pacienteReader.readField();
            Atendimento atdAtual = c_Cadastro.getEntidadeAtual();
            if (fieldValue == null || atdAtual == null)
            {
                return true;
            }
            else if (!(fieldValue instanceof BuscadorDePacientes))
            {
                return true;
            }
            else
            {
                Paciente pacDoAtd = atdAtual.getPaciente();
                if (pacDoAtd == null || pacDoAtd.getCodigo() == 0)
                {
                    return true;
                }
                else
                {
                    Paciente pacBancoDeDados = getPacienteBancoDeDados(pacDoAtd.getCodigo());
                    if (pacDoAtd.equals(pacBancoDeDados))
                    {
                        if (pacDoAtd.getVersion() >= pacBancoDeDados.getVersion())
                        {
                            return true;
                        }
                        else
                        {
                            BuscadorDePacientes buscDePac = (BuscadorDePacientes) fieldValue;
                            buscDePac.setSelectedModel(null);
                            buscDePac.setSelectedModel(pacBancoDeDados);
                            atdAtual.setPaciente(pacBancoDeDados);
                            return false;
                        }
                    }
                }
                return true;
            }
        }

        private Paciente getPacienteBancoDeDados (int codigo)
        {
            return dao.getDaoPac().procurarPorId(codigo);
        }

        @Override
        public C_Validacao set (FieldReader reader)
        {
            if (reader == null)
            {
                throw new IllegalArgumentException();
            }
            this.pacienteReader = reader;
            return this;
        }

        @Override
        public String getErrorMessage ()
        {
            return "O paciente foi alterado em outro processo. Confira os novos"
                    + " dados antes de continuar.";
        }

    }

}
