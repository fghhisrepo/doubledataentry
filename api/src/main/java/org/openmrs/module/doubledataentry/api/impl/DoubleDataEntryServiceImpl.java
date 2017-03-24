/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.doubledataentry.api.impl;

import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.doubledataentry.Configuration;
import org.openmrs.module.doubledataentry.Participant;
import org.openmrs.module.doubledataentry.api.DoubleDataEntryService;
import org.openmrs.module.doubledataentry.api.dao.DoubleDataEntryDao;
import org.openmrs.module.htmlformentry.HtmlForm;

import java.util.ArrayList;
import java.util.List;

public class DoubleDataEntryServiceImpl extends BaseOpenmrsService implements DoubleDataEntryService {
	
	DoubleDataEntryDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(DoubleDataEntryDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public List<HtmlForm> searchHtmlFormsByName(final String search) {
		return dao.searchHtmlForms(search);
	}
	
	@Override
	public List<Configuration> getAllConfigurations() {
		return new ArrayList<Configuration>();
	}
	
	@Override
	public List<Participant> getAllParticipants() {
		return new ArrayList<Participant>();
	}
	
	@Override
	public List<HtmlForm> getAllHtmlFormsHavingConfigurations() {
		return dao.getHtmlFormsUsedInConfigurations();
	}
}
