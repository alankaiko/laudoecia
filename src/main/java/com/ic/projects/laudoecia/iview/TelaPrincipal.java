/*
 * TelaPrincipal.java
 *
 * Created on 15/12/2011, 20:12:23
 */
package com.ic.projects.laudoecia.iview;

import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.Usuario;
import com.ic.projects.laudoecia.model.cadastro.AcaoDoUsuario;
import java.util.List;

/**
 *
 * @author Amsterdam Luís <amsterdamluis@gmail.com>
 */
public interface TelaPrincipal extends Tela
{

    // <editor-fold defaultstate="collapsed" desc="Telas">

    /**
     * Estrutura criada para facilitar inclusão de novos menus
     * de forma organizada.
     * @author Danilo Brito
     */

    public static final int TELA_NULL = 0;

    // Menu Ajuda vai de 1 até 9
    public static final int AJUDA_SOBRE = 1;

    // Menu Cadastros começam com 1
    public static final int CADASTRO_USUARIOS = 10;
    public static final int CADASTRO_GRUPOS_DE_USUARIOS = 11;
    public static final int CADASTRO_CONVENIOS = 12;
    public static final int CADASTRO_PACIENTES = 13;
    public static final int CADASTRO_PROF_SOLICITANTE = 14;
    public static final int CADASTRO_PROC_MEDICO = 15;
    public static final int CADASTRO_GRUPOS_PROCEDIMENTOS = 16;
    public static final int CADASTRO_AUDITORIA_BD = 17;
    public static final int CADASTRO_PROF_EXECUTANTE = 18;
    public static final int CADASTRO_TEXTOS_PADROES = 19;
    public static final int CADASTRO_ABREVIATURAS = 190;
    public static final int CADASTRO_RECORTES = 191;

    // Menu Operações de Imagens começam com 2
    public static final int ATENDIMENTO = 20;
    public static final int LAUDO_E_CAPTURA = 21;

    // Menu Relatórios começam com 3
    public static final int RELATORIOS_TODOS = 30;
    public static final int REL_ATD_COMPLETO = 31;
    public static final int REL_ATD_POR_CONVENIO = 32;
    public static final int REL_ATD_POR_PROC_MED = 33;
    public static final int REL_ATD_POR_PROF_EXE = 34;
    public static final int REL_ATD_POR_PROF_SOL = 35;
    public static final int REL_ATD_RESUMOS = 36;
    public static final int GRAF_ATDENDIMENTOS = 37;
    public static final int REL_PROC_MEDICO = 38;
    public static final int REL_PROF_EXEC = 39;
    public static final int REL_CONVENIOS = 310;
    public static final int REL_PACIENTES = 311;
    public static final int REL_PACIENTE_ANALITICO = 312;

    // Menu Base de Dados começam com 4
    public static final int BASE_DE_DADOS_CBHPM = 40;
    public static final int BASE_DE_DADOS_CEP = 41;
    public static final int BASE_DE_DADOS_CID10 = 42;
    public static final int BASE_DE_DADOS_CNES = 43;
    public static final int BASE_DE_DADOS_CRM = 44;
    public static final int BASE_DE_DADOS_ESPECIALIDADE_MEDICA = 45;

    // Menu Ferramentas começam com 5
    public static final int BACKUP_INSTANTANEO = 50;
    public static final int ESTACOES_DE_TRABALHO = 51;
    public static final int PARAMETROS_DA_CAPTURA = 52;
    public static final int PARAMETROS_DO_SISTEMA = 53;
    public static final int DADOS_DO_LICENCIADO = 54;
    public static final int PRIMEIRO_ACESSO = 55;
    public static final int SUPORTE_REMOTO = 56;
    public static final int PARAMETROS_EMAIL = 57;
    public static final int CONSENTIMENTO = 58;
    public static final int POLITICAS_PRIVACIDADE = 59;

    // custom
    public static final int DLG_CID10 = 60;
    public static final int DLG_EXECUTANTES = 61;
    public static final int DLG_PROC_MEDICO = 62;
    public static final int DLG_CEP = 63;
    public static final int DLG_GRUPO_PROC = 64;
    public static final int DLG_ABREVIATURAS = 65;
    public static final int DLG_TEXTO_PESSOAL = 66;
    public static final int DLG_RECORTES = 67;


    // </editor-fold>

    void start (boolean exigirLoginDoUsuario);

    void setCursorToDefaultCursor ();
    void setCursorToWaitCursor ();

    void iniciarTarefa (String descricao);
    void terminarTarefa (String mensagem);

    Usuario solicitarUsuario ();
    void exigirLoginDoUsuario ();
    void suspenderSessao ();

    void mostrarMensagemDeErro (String mensagem, Tela t);

    void mostrarTela (int tela, TelaSolicitante telaSolicitante);

    void mostrarRelAuditoria (List<AcaoDoUsuario> lista);
    void mostrarComprovanteAtd (Atendimento atd);

}
