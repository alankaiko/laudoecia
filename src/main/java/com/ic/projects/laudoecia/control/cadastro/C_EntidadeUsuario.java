/*
 * C_EntidadeUsuario.java
 *
 * Created on 12/03/2012, 10:11:48
 */

package com.ic.projects.laudoecia.control.cadastro;

import com.ic.projects.laudoecia.control.ctrlacesso.ControladorDeAcesso;
import com.ic.projects.laudoecia.dao.auditable.DaoUsuario;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.lib.icontrol.crud.entidade.DefC_EntidadeComCrud;
import com.lib.icontrol.crud.entidade.ValidadorAuxiliarDeUnicidade;
import com.lib.icontrol.crud.entidade.ValidadorDeUnicidade;
import com.lib.iview.crud.ViewEntidadeComCrud;
import java.util.Date;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class C_EntidadeUsuario extends DefC_EntidadeComCrud<Usuario, Integer>
{
    private DaoUsuario dao;
    private C_CadastroUsuario c_Cadastro;

    public C_EntidadeUsuario (ViewEntidadeComCrud<Usuario> view)
    {
        super(new DaoUsuario(), view);
        dao = (DaoUsuario) getDao();
    }

    @Override
    public Usuario criarEntidadeParaAdicionar ()
    {
        Usuario usuario = new Usuario(dao.sugerirNovoID());
        usuario.setDataDeCadastro(new Date());
        return usuario;
    }

    @Override
    protected void adicionarValidadores ()
    {
        validadores.put("login", new ValidadorDeUnicidade(
                "O login escolhido já foi cadastrado para outro usuário!",
                new ValidadorAuxiliarDeUnicidade() {

                    @Override
                    public boolean validar (int codigo, String valor)
                    {
                        return dao.validarUnicidadeDeLogin(codigo, valor);
                    }

                }));
    }

    void setC_Cadastro (C_CadastroUsuario c_Cadastro)
    {
        this.c_Cadastro = c_Cadastro;
    }

    public void dadosForamPreenchidos ()
    {
        c_Cadastro.dadosForamPreenchidos();
    }

    @Override
    public void alterar (Usuario entidadeBase) throws OptimisticLockException, EntityNotFoundException, Exception
    {
        super.alterar(entidadeBase);
        if (ControladorDeAcesso.getUsuarioLogado().equals(entidadeBase))
        {
            ControladorDeAcesso.setUsuarioLogado(entidadeBase);
        }
    }

}
