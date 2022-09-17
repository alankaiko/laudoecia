/*
 * DaoAcaoDoUsuario.java
 *
 * Created on 02/03/2012, 11:59:04
 */
package com.ic.projects.laudoecia.dao.cadastro;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.lib.dao.general.*;
import com.lib.java.utils.DateUtils;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class DaoAcaoDoUsuario extends GenericDao<AcaoDoUsuario, Integer>
{
    public DaoAcaoDoUsuario ()
    {
        super(PUs.CADASTRO_PU, AcaoDoUsuario.class);
    }

    public List<Object[]> buscarPorTodosCampos (
            Usuario user, String tipo, String tabela,
            Date dataDaAcaoIni, Date dataDaAcaoFin,
            String registro, String codigoDoRegistro, int maxResults)
    {
        And wUsuario = user == null ? null : new And("usuario");
        And wTipo = tipo == null ? null : new And("tipo");
        And wTabela = tabela == null ? null : new And("tabela");
        Between wDatas = dataDaAcaoIni == null || dataDaAcaoFin == null ? null : new Between("dataDaAcao", AND);

        QueryBuilder qb = new QueryBuilder(
                new Select("codigo", "tipo", "tabela", "registro", "dataDaAcao"),
                new Where("registro", LIKE),
                wUsuario, wTipo, wTabela, wDatas,
                new And("codigoDoRegistro", LIKE));

        qb.setParametro("registro", configurarParamBusca(registro));
        if (wUsuario != null)
        {
            qb.setParametro("usuario", user);
        }
        if (wTipo != null)
        {
            qb.setParametro("tipo", TIPO_ACAO_DO_USUARIO.valueOf(tipo));
        }
        if (wTabela != null)
        {
            qb.setParametro("tabela", tabela);
        }
        if (wDatas != null)
        {
            qb.setParametro(Between.LOWER_BOUND, dataDaAcaoIni);
            qb.setParametro(Between.UPPER_BOUND, DateUtils.adicionarDiasNaData(dataDaAcaoFin, 1));
        }
        qb.setParametro("codigoDoRegistro", configurarParamBusca(codigoDoRegistro));

        qb.setMaxResults(maxResults);
        return getResultList(qb, Object[].class);
    }

    public List<AcaoDoUsuario> buscarPorCodigo (List<Integer> codigos)
    {
        QueryBuilder qb = new QueryBuilder(new Select(), new In("codigo"), new OrderBy("dataDaAcao"));
        qb.setParametro(In.VALORES, codigos);
        return getResultList(qb);
    }

    public Usuario buscarUsuarioRespPeloAtd (int codigoAtd)
    {
        QueryBuilder qb = new QueryBuilder(new Select("usuario"),
                new Where("tipo"), new And("tabela"), new And("codigoDoRegistro"),
                new OrderBy(true, "dataDaAcao"));
        qb.setParametro("tipo", TIPO_ACAO_DO_USUARIO.ADICIONAR);
        qb.setParametro("tabela", StaticInfo.getNomeDaEntidadeAuditavel(Atendimento.class.getSimpleName()));
        qb.setParametro("codigoDoRegistro", String.valueOf(codigoAtd));

        /**
         * Não utilizado o sigleResult pois pode acontecer de existir mais de um registro
         * com os mesmos filtros. (no caso de se ter excluido um registro e criado outro
         * com o mesmo código
         */
        qb.setMaxResults(1);
        List<Usuario> result = getResultList(qb, Usuario.class);
        if (result == null || result.isEmpty() || result.get(0).getCodigo() == Usuario.CODIGO_NULL)
        {
            return null;
        }
        return result.get(0);
    }

    public int codMaxDoAtdExcluido (EntityManager em)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append("SELECT MAX(codigodoregistro::integer) FROM acaodousuario");
        sb.append(" WHERE tipo = '").append(TIPO_ACAO_DO_USUARIO.APAGAR);
        sb.append("' AND tabela = '").append(StaticInfo.
                getNomeDaEntidadeAuditavel(Atendimento.class.getSimpleName()));
        sb.append("'");
        String sql = sb.toString();
        try
        {
            Integer resposta = (Integer) em.createNativeQuery(
                    sql).getSingleResult();
            return resposta == null ? 0 : resposta.intValue();
        }
        catch (NoResultException nre)
        {
            return 0;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public int codMaxDoAtdExcluido ()
    {
        StringBuilder sb = new StringBuilder("");
        sb.append("SELECT MAX(codigodoregistro::integer) FROM acaodousuario");
        sb.append(" WHERE tipo = '").append(TIPO_ACAO_DO_USUARIO.APAGAR);
        sb.append("' AND tabela = '").append(StaticInfo.
                getNomeDaEntidadeAuditavel(Atendimento.class.getSimpleName()));
        sb.append("'");
        String sql = sb.toString();
        EntityManager em = getEntityManager();
        try
        {
            Integer resposta = (Integer) em.createNativeQuery(
                    sql).getSingleResult();
            return resposta == null ? 0 : resposta.intValue();
        }
        catch (NoResultException nre)
        {
            return 0;
        }
        catch (Exception e)
        {
            return 0;
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public Usuario buscarRespPeloLaudo (ProcDoAtd p)
    {
        QueryBuilder qb = new QueryBuilder(new Select("usuario"),
                new Where("tipo"), new And("tabela"), new And("registro"),
                new And("codigoDoRegistro"), new OrderBy(true, "dataDaAcao"));
        qb.setParametro("tipo", TIPO_ACAO_DO_USUARIO.ALTERAR);
        qb.setParametro("tabela", StaticInfo.getNomeDaEntidadeAuditavel(
                ProcDoAtd.class.getSimpleName()));
        qb.setParametro("registro", p.toString());
        qb.setParametro("codigoDoRegistro", String.valueOf(p.
                getAtendimento().getCodigo()));
        List<Usuario> resultList = getResultList(qb, Usuario.class);
        qb.setMaxResults(1);
        if (resultList.isEmpty())
        {
            return null;
        }
        else
        {
            return resultList.get(0);
        }
    }

}
