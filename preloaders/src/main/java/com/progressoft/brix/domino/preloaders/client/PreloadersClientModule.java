package com.progressoft.brix.domino.preloaders.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Preloaders")
public class PreloadersClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(PreloadersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Preloaders frontend module ...");
		new ModuleConfigurator().configureModule(new PreloadersModuleConfiguration());
	}
}
