/*
 * DaoLaudoeCia.java
 *
 * Created on 15/07/2013, 09:36:53
 */

package com.ic.projects.laudoecia.dao.utils;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.model.auditable.ParametrosDoSistema;
import com.lib.dao.general.GenericDaoWithIntegerId;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class DaoLaudoeCia extends GenericDaoWithIntegerId<ParametrosDoSistema>
{

    public DaoLaudoeCia ()
    {
        super(PUs.CADASTRO_PU, ParametrosDoSistema.class);
    }

    public void criarColunaTamanhoSepRodape ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE parametrosdosistema ADD COLUMN "
                    + "tamanhoseprodape integer NOT NULL DEFAULT 1")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarTabelaParamDoLaudo1_0_0 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("UPDATE parametrodolaudo SET valor = "
                    + "'normoinserido' WHERE valor = 'normo inserido'")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarTabelaParamDoLaudo1_0_1 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("UPDATE parametrodolaudo SET valor = "
                    + "'justa-uterino' WHERE valor = 'justa uterino'")
                    .executeUpdate();
            em.createNativeQuery("UPDATE parametrodolaudo SET valor = "
                    + "'para-uterino' WHERE valor = 'para uterino'")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void limparCadastroDeLicencas ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createQuery("delete from Licenca o").executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void atualizarVersao ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("UPDATE parametrosdosistema SET versaodosw = "
                    + "'" + LaudoeCia.VERSAO_DO_SISTEMA_ENUM.name() + "'")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarTabelas1_6 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE convenio ADD COLUMN "
                    + "numcopiasdolaudo integer NOT NULL DEFAULT 1")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE profexecutante ADD COLUMN "
                    + "assinatura bytea")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE profexecutante ADD COLUMN "
                    + "asswidth double precision NOT NULL DEFAULT 0")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE profexecutante ADD COLUMN "
                    + "assheight double precision NOT NULL DEFAULT 0")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE parametrosdosistema ADD COLUMN "
                    + "imprimirsolcon boolean NOT NULL DEFAULT true")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE parametrosdosistema ADD COLUMN "
                    + "defprinterlaudo character varying(255)")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE parametrosdosistema ADD COLUMN "
                    + "defprinterimagens character varying(255)")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarTabelas1_7 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE procdoatd ADD COLUMN estacao_codigo integer")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE procdoatd ADD CONSTRAINT fk_atendimento_estacao_codigo FOREIGN KEY (estacao_codigo) REFERENCES estacaodetrabalho (codigo) ON UPDATE NO ACTION ON DELETE NO ACTION")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarDadosLaudos1_8 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("update parametrodolaudo "
                    + "set index = index + 3 where index > 50 "
                    + "and laudo_codigo in ("
                    + "select laudo.codigo from laudo as laudo "
                    + "inner join modelodelaudodoproc as mdlproc on mdlproc.codigo = laudo.modelodelaudo_codigo "
                    + "inner join modelodelaudo as mdl on mdl.codigo = mdlproc.modelolaudo_codigo "
                    + "where mdl.codigo = 19)")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarTabelas1_8 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE parametrosdosistema ADD COLUMN imprimiratd boolean NOT NULL DEFAULT true;")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE profexecutante ADD COLUMN espacoass integer NOT NULL DEFAULT 10;")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE procmedico ADD COLUMN margemtop integer NOT NULL DEFAULT 10;")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE procmedico ADD COLUMN margembottom integer NOT NULL DEFAULT 10;")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarBd191 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("DROP TABLE licenca CASCADE").executeUpdate();
            em.createNativeQuery("ALTER TABLE licenciado RENAME nomefantasia TO licenciadopara").executeUpdate();
            em.createNativeQuery("ALTER TABLE licenciado ADD COLUMN qtdeacessos integer NOT NULL DEFAULT 2").executeUpdate();
            em.createNativeQuery("ALTER TABLE licenciado ADD COLUMN tipodelicenca character varying(255) NOT NULL DEFAULT 'LAUDO_E_IMAGEM'").executeUpdate();
            em.createNativeQuery("ALTER TABLE licenciado ADD COLUMN serial character varying(255) NOT NULL DEFAULT ''").executeUpdate();
            em.createNativeQuery("ALTER TABLE parametrosdosistema DROP COLUMN codigoderest1").executeUpdate();
            em.createNativeQuery("ALTER TABLE parametrosdosistema DROP COLUMN codigoderest2").executeUpdate();
            em.createNativeQuery("ALTER TABLE parametrosdosistema DROP COLUMN codigodeinst").executeUpdate();
            em.createNativeQuery("ALTER TABLE estacaodetrabalho ADD COLUMN logado boolean NOT NULL DEFAULT false").executeUpdate();
            int maxCodigoMaisUm = (int) em.createNativeQuery(
                    "SELECT MAX(codigo) + 1 FROM imagem")
                    .getSingleResult();
            String maxCodigoStr = String.valueOf(maxCodigoMaisUm);
            em.createNativeQuery("CREATE SEQUENCE imagem_codigo_seq "
                    + "START WITH " + maxCodigoStr).executeUpdate();
            em.createNativeQuery("ALTER TABLE imagem ALTER COLUMN codigo "
                    + "SET DEFAULT nextval('imagem_codigo_seq');")
                    .executeUpdate();
            em.createNativeQuery("ALTER TABLE imagem ADD COLUMN indice integer")
                    .executeUpdate();
            em.createNativeQuery("update imagem set indice = codigo")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarBd192 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE procmedico ADD COLUMN imagem1 bytea").executeUpdate();
            em.createNativeQuery("ALTER TABLE procmedico ADD COLUMN imagem2 bytea").executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarDadosLaudos1_9_2 ()
    {
        EntityManager em = null;
        try
        {
            // o campo em questão do laudo tradicional de videocolposcopia estava em cm, mas a precisão mudou para mm
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("update parametrodolaudo set valor = cast((cast(valor as integer) * 10) as text) "
                    + "where index = 26 and laudo_codigo IN "
                    + "(select distinct p.laudo_codigo from parametrodolaudo p "
                    + "inner join laudo l on p.laudo_codigo = l.codigo "
                    + "inner join modelodelaudodoproc mp on l.modelodelaudo_codigo = mp.codigo "
                    + "inner join modelodelaudo m on mp.modelolaudo_codigo = m.codigo "
                    + "where m.codigo = 12)")
                    .executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarBd193 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE licenciado ALTER COLUMN telefone1 TYPE character varying(15)").executeUpdate();
            em.createNativeQuery("ALTER TABLE licenciado ALTER COLUMN telefone2 TYPE character varying(15)").executeUpdate();
            em.createNativeQuery("ALTER TABLE grupodeusuarios ADD COLUMN suporte_remoto boolean").executeUpdate();
            em.createNativeQuery("ALTER TABLE procmedico ADD COLUMN laudo_modelo boolean NOT NULL DEFAULT false").executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarBd1943 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER TABLE parametrosdosistema ADD COLUMN naopossuiterminais boolean").executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarBd195 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("INSERT INTO modelodelaudo(contexto, nome, visao) VALUES ('a', 'OBSTÉTRICO ACIMA DE 14 SEMANAS COM REFERENCIA', 'a')").executeUpdate();
            em.createNativeQuery("UPDATE modelodelaudodoproc SET prioridade = prioridade + 1 WHERE procmedico_codigo = 6 OR procmedico_codigo = 71").executeUpdate();
            em.createNativeQuery("INSERT INTO modelodelaudodoproc(customstring, descricao, prioridade, modelolaudo_codigo, procmedico_codigo) VALUES ('', 'PRÉ-FORMATADO COM REF', 0, 31, 6)").executeUpdate();
            em.createNativeQuery("INSERT INTO modelodelaudodoproc(customstring, descricao, prioridade, modelolaudo_codigo, procmedico_codigo) VALUES ('', 'PRÉ-FORMATADO COM REF', 0, 31, 71)").executeUpdate();
            em.createNativeQuery("UPDATE procmedico SET margemtop = 0, margembottom = 0 WHERE codigo = 6 OR codigo = 71").executeUpdate();
            em.createNativeQuery("alter table parametrosdosistema drop column naopossuiterminais").executeUpdate();
            em.createNativeQuery("alter table grupodeusuarios drop column suporte_remoto").executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void alterarBd196 ()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createNativeQuery("ALTER SEQUENCE modelodelaudo_codigo_seq RESTART WITH 32").executeUpdate();
            em.createNativeQuery("INSERT INTO modelodelaudo(contexto, nome, visao) VALUES ('a', 'ABDOME INFERIOR FEMININO / ENDOVAGINAL PÉLVICA COM REF', 'a')").executeUpdate();
            em.createNativeQuery("UPDATE modelodelaudodoproc SET modelolaudo_codigo = 32 WHERE modelolaudo_codigo = 14").executeUpdate();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void atualizarIndiceImg()
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            int maxCodigoMaisUm = (int) em.createNativeQuery(
                    "SELECT MAX(codigo) + 1 FROM imagem")
                    .getSingleResult();
            String maxCodigoStr = String.valueOf(maxCodigoMaisUm);
            em.createNativeQuery("SELECT setval('public.imagem_codigo_seq', "
                    + maxCodigoStr + ", true);")
                    .getResultList();
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }
}
