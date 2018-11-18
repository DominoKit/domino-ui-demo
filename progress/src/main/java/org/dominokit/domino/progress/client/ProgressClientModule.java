package org.dominokit.domino.progress.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Progress")
public class ProgressClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Progress frontend module ...");
		//new ModuleConfigurator().configureModule(new ProgressModuleConfiguration());
	}
}
