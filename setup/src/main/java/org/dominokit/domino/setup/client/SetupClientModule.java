package org.dominokit.domino.setup.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Setup")
public class SetupClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(SetupClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Setup frontend module ...");
		//new ModuleConfigurator().configureModule(new SetupModuleConfiguration());
	}
}
