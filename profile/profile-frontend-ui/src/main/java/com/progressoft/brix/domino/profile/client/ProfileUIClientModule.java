package com.progressoft.brix.domino.profile.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="ProfileUI")
public class ProfileUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Profile frontend UI module ...");
		new ModuleConfigurator().configureModule(new ProfileUIModuleConfiguration());
	}
}
