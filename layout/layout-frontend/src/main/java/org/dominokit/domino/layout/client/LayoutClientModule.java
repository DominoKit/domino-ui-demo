package org.dominokit.domino.layout.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Layout")
public class LayoutClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(LayoutClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Layout frontend module ...");
		//new ModuleConfigurator().configureModule(new LayoutModuleConfiguration());
	}
}
