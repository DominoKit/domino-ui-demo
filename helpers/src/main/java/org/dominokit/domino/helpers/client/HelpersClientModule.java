package org.dominokit.domino.helpers.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Helpers")
public class HelpersClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelpersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Helpers frontend module ...");
		//new ModuleConfigurator().configureModule(new HelpersModuleConfiguration());
	}
}
