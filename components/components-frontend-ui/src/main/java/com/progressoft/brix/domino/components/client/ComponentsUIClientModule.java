package com.progressoft.brix.domino.components.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="ComponentsUI")
public class ComponentsUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Components frontend UI module ...");
		new ModuleConfigurator().configureModule(new ComponentsUIModuleConfiguration());
	}
}
