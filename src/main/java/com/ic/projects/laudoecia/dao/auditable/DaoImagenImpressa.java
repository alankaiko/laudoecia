package com.ic.projects.laudoecia.dao.auditable;

import com.ic.projects.laudoecia.control.auditores.Auditor;
import com.ic.projects.laudoecia.control.auditores.AuditorDeImagensImpressa;
import com.ic.projects.laudoecia.model.cadastro.ImagemImpressa;

public class DaoImagenImpressa  extends DaoAuditor<ImagemImpressa>{

	DaoImagenImpressa(Class<ImagemImpressa> classeDaEntidade,Auditor<ImagemImpressa> auditor) {
		super(classeDaEntidade, auditor);
	}
	
	public DaoImagenImpressa() {
		super(ImagemImpressa.class, new AuditorDeImagensImpressa());
	}
}
