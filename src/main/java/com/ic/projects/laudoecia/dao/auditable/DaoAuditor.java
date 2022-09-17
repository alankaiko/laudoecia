/*
 * DaoAuditor.java
 *
 * Created on 02/03/2012, 10:38:12
 */

package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.Auditor;
import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.dao.utils.PUs;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import com.ic.projects.laudoecia.model.enums.TIPO_ACAO_DO_USUARIO;
import com.lib.dao.general.DaoListener;
import com.lib.dao.general.GenericDaoWithIntegerId;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
abstract class DaoAuditor<T extends Serializable> extends GenericDaoWithIntegerId<T>
                                                implements DaoListener<T>
{

    private Auditor<T> auditor;

    DaoAuditor (Class<T> classeDaEntidade, Auditor<T> auditor)
    {
        super(PUs.CADASTRO_PU, classeDaEntidade);
        addDaoListener(this);
        this.auditor = auditor;
        if (auditor == null)
        {
            throw new IllegalArgumentException("Auditor não pode ser null");
        }
    }

    @Override
    public void aboutToPersist (T entity, EntityManager em)
    {
        auditor.setTipo(TIPO_ACAO_DO_USUARIO.ADICIONAR);
        auditor.setTabela(StaticInfo.getNomeDaEntidadeAuditavel(nomeDaEntidade));
        auditor.setCodigoDoRegistro(getCodigoDoRegistro(entity, em));
        em.persist(auditor.criarAcaoDoUsuario(entity, null));
    }

    @Override
    public void aboutToRemove (T entity, EntityManager em)
    {
        auditor.setTipo(TIPO_ACAO_DO_USUARIO.APAGAR);
        auditor.setCodigoDoRegistro(getCodigoDoRegistro(entity, em));
        auditor.setTabela(StaticInfo.getNomeDaEntidadeAuditavel(nomeDaEntidade));
        em.persist(auditor.criarAcaoDoUsuario(entity, null));
    }

    @Override
    public void aboutToUpdate (T entity, T originalEntity, EntityManager em)
    {
        if (!auditar())
        {
            return;
        }
        auditor.setTipo(TIPO_ACAO_DO_USUARIO.ALTERAR);
        auditor.setTabela(StaticInfo.getNomeDaEntidadeAuditavel(nomeDaEntidade));
        auditor.setCodigoDoRegistro(getCodigoDoRegistro(entity, em));
        AcaoDoUsuario acaoDoUsuario = auditor.criarAcaoDoUsuario(entity, originalEntity);
        if (!acaoDoUsuario.getAlteracoes().isEmpty())
        {
            em.persist(acaoDoUsuario);
        }
    }

    protected boolean auditar ()
    {
        return true;
    }

    protected String getCodigoDoRegistro (T entity, EntityManager em)
    {
        return getID(entity, em).toString();
    }

}
