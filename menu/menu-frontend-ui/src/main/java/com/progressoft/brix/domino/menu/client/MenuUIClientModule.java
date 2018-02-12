package com.progressoft.brix.domino.menu.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="MenuUI")
public class MenuUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Menu frontend UI module ...");
		new ModuleConfigurator().configureModule(new MenuUIModuleConfiguration());
	}
}
