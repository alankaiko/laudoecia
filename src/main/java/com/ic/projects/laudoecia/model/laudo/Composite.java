/*
 * Composite.java
 *
 * Created on 09/05/2012, 14:31:26
 */

package com.ic.projects.laudoecia.model.laudo;

import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDeValidacao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public abstract class Composite extends CampoDoLaudo
{

    private List<CampoDoLaudo> prole = new ArrayList<>();
    public static final String HTML_CAMPOS_FILHOS = "@html dos campos filhos@";

    public Composite ()
    {
        adicionarListener(new CampoDoLaudoListener() {

            @Override
            public void campoDoLaudoMudou (EventoDoCampoDoLaudo evento)
            {
                switch (evento.getTipo())
                {
                    case EventoDoCampoDoLaudo.VALOR_MUDOU:
                        valorMudou((String)evento.getValorAtual());
                        break;
                    default:
                }
            }
        });
    }

    private void valorMudou (String novoValor)
    {
        final boolean novoValorEhNull = novoValor == null;
        visitarProle(new CampoDoLaudoTreeWalker()
        {
            @Override
            public int visit (CampoDoLaudo cdl)
            {
                if (!(cdl instanceof Composite))
                {
                    cdl.dispararEvento(EventoDoCampoDoLaudo.HABILITADO_MUDOU,
                       descobrirHabAntigo(cdl), cdl.isHabilitado());
                }
                return CampoDoLaudoTreeWalker.CONTINUAR;
            }

            private boolean descobrirHabAntigo (CampoDoLaudo cdl)
            {
                if (novoValorEhNull)
                {
                    // antes o composite possuia valor, entao o campo filho
                    // estava desabilitado
                    return false;
                }
                else if (cdl.getHabilitacao().isHabilitado())
                {
                    CampoDoLaudo parent = cdl.getParent();
                    while (parent != null)
                    {
                        if (parent == Composite.this)
                        {
                        }
                        else if (parent.getValor() != null)
                        {
                            return false;
                        }
                        parent = parent.getParent();
                    }
                    return true;
                }
                else
                {
                    // o campo do laudo estava desabilitado por alguma regra
                    return false;
                }
            }

        }, this);
    }

    void adicionarCampoFilho (CampoDoLaudo campo)
    {
        prole.add(campo);
        campo.setParent(this);
    }

    public List<CampoDoLaudo> getProle ()
    {
        return Collections.unmodifiableList(prole);
    }

    @Override
    @SuppressWarnings("NoopMethodInAbstractClass")
    void validarValorNaoVazio (String valor) throws ErrosDeValidacao
    {
    }

    void visitarProle (CampoDoLaudoTreeWalker visitor, Composite node)
    {
        List<CampoDoLaudo> proleAtual = node.getProle();
        for (int i = 0; i < proleAtual.size(); i++)
        {
            CampoDoLaudo campoDoLaudo = proleAtual.get(i);
            int resultado = visitor.visit(campoDoLaudo);
            if (resultado == CampoDoLaudoTreeWalker.PARAR)
            {
                break;
            }
            else if (resultado == CampoDoLaudoTreeWalker.PULAR_PROLE)
            {
            }
            else if (campoDoLaudo instanceof Composite)
            {
                visitarProle(visitor, (Composite) campoDoLaudo);
            }
            else
            {
            }
        }
    }

}
