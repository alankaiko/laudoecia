/*
 * C_EntidadeConvenio.java
 *
 * Created on 15/03/2012, 09:35:05
 */
package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.dao.auditable.DaoConvenio;
import com.ic.projects.laudoecia.model.auditable.Convenio;
import com.ic.projects.laudoecia.model.cadastro.TabelaDeProcedimentos;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;

/**
 *
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class C_EntidadeConvenio extends DefC_EntidadeComCrud<Convenio, Integer>
{
    private DaoConvenio dao;

    public C_EntidadeConvenio (ViewEntidadeComCrud<Convenio> view)
    {
        super(new DaoConvenio(), view);
        dao = (DaoConvenio) getDao();
    }

    @Override
    public Convenio criarEntidadeParaAdicionar ()
    {
        Convenio c = new Convenio();
        c.setCodigo(dao.sugerirNovoID());
        c.setAtivo(true);
        c.setTabelaDeProcedimentos(new TabelaDeProcedimentos(c.getCodigo()));
        return c;
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("nome", new ValidadorDeUnicidade(
                "O nome escolhido já foi cadastrado para outro convênio!",
                new ValidadorAuxiliarDeUnicidade() {

                    @Override
                    public boolean validar (int codigo, String nome)
                    {
                        return dao.validarUnicidadeDeNome(codigo, nome);
                    }

                }));
    }

}
