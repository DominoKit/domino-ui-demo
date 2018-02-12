package com.progressoft.brix.domino.themes.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Themes")
public class ThemesClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThemesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Themes frontend module ...");
		new ModuleConfigurator().configureModule(new ThemesModuleConfiguration());
	}
}
