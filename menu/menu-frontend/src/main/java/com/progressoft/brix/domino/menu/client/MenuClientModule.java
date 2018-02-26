package com.progressoft.brix.domino.menu.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Menu")
public class MenuClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Menu frontend module ...");
		new ModuleConfigurator().configureModule(new MenuModuleConfiguration());
	}
}
