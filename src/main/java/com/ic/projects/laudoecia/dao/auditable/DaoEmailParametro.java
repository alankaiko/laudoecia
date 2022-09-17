package com.ic.projects.laudoecia.dao.auditable;

import java.util.ArrayList;
import java.util.List;

import com.ic.projects.laudoecia.control.auditores.AuditorDeEmailParametro;
import com.ic.projects.laudoecia.model.auditable.EmailParametros;
import com.lib.dao.general.EntityListener;
import com.lib.icontrol.crud.cadastro.CustomException;

public class DaoEmailParametro extends DaoAuditor<EmailParametros> implements EntityListener<EmailParametros> {
	private static List<EntityListener<EmailParametros>> entityListeners = new ArrayList<>();

	public DaoEmailParametro() {
		super(EmailParametros.class, new AuditorDeEmailParametro());
		addEntityListener(this);
	}

	public static void addStaticEntityListener(EntityListener<EmailParametros> el) {
		entityListeners.add(el);
	}

	public static void removeStaticEntityListener(EntityListener<EmailParametros> el) {
		entityListeners.remove(el);
	}

	@Override
	public void persisted(EmailParametros entity) throws CustomException {
		for (EntityListener<EmailParametros> entityListener : entityListeners) {
			entityListener.persisted(entity);
		}
	}

	@Override
	public void removed(EmailParametros entity) {
		for (EntityListener<EmailParametros> entityListener : entityListeners) {
			entityListener.removed(entity);
		}
	}

	@Override
	public void updated(EmailParametros entity) {
		for (EntityListener<EmailParametros> entityListener : entityListeners) {
			entityListener.updated(entity);
		}
	}

}
