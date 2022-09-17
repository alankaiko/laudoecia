/*
 * TOPICOS_HELP.java
 *
 * Created on 18/09/2012, 08:09:40
 */
package com.ic.projects.laudoecia.model.enums;

/**
 *
 * @author Tekna <informatica@instrumental.net.br>
 */
public enum TOPICOS_HELP
{
    INTRODUCAO,
    INSTAL_CONFIG_SISTEMA,
    INSTAL_SISTEMA,
    LC_EM_REDE,
    CONTROLE_DE_ACESSO,
    PASTA_DE_VIDEOS,
    FUNDO_DE_TELA,
    DADOS_LICENCIADO,
    CONF_IMPRESSAO_LAUDO,
    FAZER_BACKUP,
    CONF_DISP_CAPTURA,
    CONHECENDO_LC,
    CONHECENDO_TELA_INICIAL,
    CONHECENDO_MENUS_PRINCIPAIS,
    CONHECENDO_BARRA_CRUD,
    CONHECENDO_TECLAS_ATALHO,
    MENU_CADASTROS,
    CAD_GRUPO_USUARIOS,
    CAD_USUARIOS,
    CAD_CONVENIOS,
    CAD_GRUPO_PROCMED,
    CAD_PROCMED,
    CAD_PACIENTES,
    CAD_PROF_EXE,
    CAD_PROF_SOL,
    CAD_TEXTOS_PESSOAIS,
    OP_ATENDIMENTO,
    CAD_ATENDIMENTO,
    TELA_LAUDO_CAPTURA,
    MODULO_CAPTURA,
    CAPTURAR_IMAGEM,
    EDITAR_IMAGEM,
    GRAVANDO_VIDEO,
    REPRODUZIR_VIDEO,
    EXPORTAR_IMAGENS_VIDEOS,
    MODULO_LAUDOS,
    MODELO_DE_LAUDO,
    TOPICOS_DO_LAUDO,
    PREENCHENDO_LAUDO,
    INSERIR_TEXTOS_PESSOAIS,
    VISUALIZA_EDITA_LAUDO,
    ESCOLHER_IMAGENS_IMPRESSAO,
    IMPRIMIR_E_PDF_LAUDO,
    RELATORIOS_DO_SISTEMA,
    RELATORIOS_DE_ATENDIMENTO,
    AUDITORIA,
    OUTRAS_OPCOES_DO_SISTEMA,
    BASES_DE_DADOS,
    ALTERNAR_USUARIO,
    SUSPENDER_SESSAO,
    ESTACOES_DE_TRABALHO,
    DUVIDAS_PROBLEMAS_FREQUENTES,
    LISTA_ABREVIACOES,
    RESTAURAR_BACKUP;

    @Override
    public String toString ()
    {
        return "sd" + ordinal();
    }

}
