package org.dominokit.domino.layouts.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Layouts")
public class LayoutsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(LayoutsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Layouts frontend module ...");
		//new ModuleConfigurator().configureModule(new LayoutsModuleConfiguration());
	}
}
