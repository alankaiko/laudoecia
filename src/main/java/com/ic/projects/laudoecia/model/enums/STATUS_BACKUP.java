/*
 * STATUS_BACKUP.java
 *
 * Created on 11/04/2012, 08:50:45
 */
package com.ic.projects.laudoecia.model.enums;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum STATUS_BACKUP
{
    AGENDADO("Agendado", false),
    CANCELADO("Cancelado", true),
    DISCO_CHEIO("Espaço em disco foi insuficiente", true),
    EM_ANDAMENTO("Em andamento", false),
    ERRO_DESCONHECIDO("Erro desconhecido", true),
    ERRO_AO_MOVER_BACKUP_LOCAL("Erro ao mover o backup para a maquina local", true),
    IO_EXCEPTION("Erro de entrada e saída de dados", true),
    CONCURRENCY_EXCEPTION("Já havia um backup sendo realizado", true),
    REALIZADO_COM_SUCESSO("Realizado com sucesso", false);

    private final String mensagem;
    // significa que uma nova tentativa de realizar o backup nao sera feita
    private final boolean statusDeErro;

    private STATUS_BACKUP (String mensagem, boolean statusDeErro)
    {
        this.mensagem = mensagem;
        this.statusDeErro = statusDeErro;
    }

    public String getMensagem ()
    {
        return mensagem;
    }

    public boolean isStatusDeErro ()
    {
        return statusDeErro;
    }

    @Override
    public String toString ()
    {
        return mensagem;
    }

}
