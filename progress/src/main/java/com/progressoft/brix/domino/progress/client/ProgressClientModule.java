package com.progressoft.brix.domino.progress.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Progress")
public class ProgressClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Progress frontend module ...");
		new ModuleConfigurator().configureModule(new ProgressModuleConfiguration());
	}
}
