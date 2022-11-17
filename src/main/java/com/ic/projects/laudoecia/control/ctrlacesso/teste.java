/**
  * C_Login.java
  *
  * Created on 16/12/2011, 18:42:21
  */
package com.ic.projects.laudoecia.control.ctrlacesso;


import com.lib.icontrol.autocompletar.C_AutoCompletar;
import com.lib.iview.autocompletar.AutoCompletarListener;
import com.lib.iview.autocompletar.RecursoAutoCompletar;

public class teste implements RecursoAutoCompletar {

	@Override
	public void addAutoCompletarListener (AutoCompletarListener listener)
	{
	}

	@Override
	public void removeAutoCompletarListener (AutoCompletarListener listener)
	{
	}

	@Override
	public void setLinhaSelecionada ()
	{
	}

	@Override
	public boolean isValidado ()
	{
		return false;
	}

	@Override
	public void setControlador (C_AutoCompletar<?> buscador)
	{
	}

	@Override
	public void setHabilitado (boolean habilitado)
	{
		this.setHabilitado(true);
	}

	@Override
	public void setMensagemDeErro (String mensagemDeErro)
	{
	}

	@Override
	public void setSelecionarPrimeiroAposBusca (boolean selecionarPrimeiroAposBusca)
	{
	}

	@Override
	public void setStrictMatching (boolean strictMatching)
	{
		this.setStrictMatching(true);
	}

	@Override
	public boolean existeLinhaSelecionada ()
	{
		return false;
	}

	@Override
	public void autoCompletar ()
	{
	}
}
