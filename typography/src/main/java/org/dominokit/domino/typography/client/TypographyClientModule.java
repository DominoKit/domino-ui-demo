package org.dominokit.domino.typography.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Typography")
public class TypographyClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypographyClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Typography frontend module ...");
		//new ModuleConfigurator().configureModule(new TypographyModuleConfiguration());
	}
}
