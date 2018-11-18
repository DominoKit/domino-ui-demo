package org.dominokit.domino.colors.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Colors")
public class ColorsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ColorsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Colors frontend module ...");
		//new ModuleConfigurator().configureModule(new ColorsModuleConfiguration());
	}
}
