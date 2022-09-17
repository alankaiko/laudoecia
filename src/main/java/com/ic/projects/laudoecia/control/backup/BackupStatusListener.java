/*
 * BackupStatusListener.java
 *
 * Created on 13/09/2012, 11:18:34
 */

package com.ic.projects.laudoecia.control.backup;

import com.ic.projects.laudoecia.model.cadastro.Backup;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public interface BackupStatusListener
{

    void backupIniciou (Backup backup);
    void backupTerminou (Backup backup);

}
