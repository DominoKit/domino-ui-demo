package org.dominokit.domino.menu.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Menu")
public class MenuClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Menu frontend module ...");
		//new ModuleConfigurator().configureModule(new MenuModuleConfiguration());
	}
}
